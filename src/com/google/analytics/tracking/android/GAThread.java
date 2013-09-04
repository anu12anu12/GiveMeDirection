package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class GAThread extends Thread
  implements AnalyticsThread
{
  static final String API_VERSION = "1";
  private static final String CLIENT_VERSION = "ma1b3";
  private static final int MAX_SAMPLE_RATE = 100;
  private static final int SAMPLE_RATE_MODULO = 10000;
  private static final int SAMPLE_RATE_MULTIPLIER = 100;
  private static GAThread instance;
  private volatile boolean appOptOut;
  private volatile String clientId;
  private volatile boolean closed;
  private volatile List<Command> commands;
  private final Context ctx;
  private volatile boolean disabled;
  private volatile String installCampaign;
  private volatile MetaModel metaModel;
  private final ServiceProxy proxy;
  private final LinkedBlockingQueue<Runnable> queue;

  private GAThread(Context paramContext)
  {
    super("GAThread");
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    this.queue = localLinkedBlockingQueue;
    this.disabled = false;
    this.closed = false;
    this.ctx = paramContext;
    GAServiceProxy localGAServiceProxy = new GAServiceProxy(paramContext, this);
    this.proxy = localGAServiceProxy;
    init();
  }

  GAThread(Context paramContext, ServiceProxy paramServiceProxy)
  {
    super("GAThread");
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    this.queue = localLinkedBlockingQueue;
    this.disabled = false;
    this.closed = false;
    this.ctx = paramContext;
    this.proxy = paramServiceProxy;
    init();
  }

  private void fillAppParameters(Map<String, String> paramMap)
  {
    PackageManager localPackageManager = this.ctx.getPackageManager();
    String str1 = this.ctx.getPackageName();
    String str2 = localPackageManager.getInstallerPackageName(str1);
    String str3 = str1;
    String str4 = null;
    try
    {
      String str5 = this.ctx.getPackageName();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str5, 0);
      if (localPackageInfo != null)
      {
        ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
        str3 = localPackageManager.getApplicationLabel(localApplicationInfo).toString();
        str4 = localPackageInfo.versionName;
      }
      putIfAbsent(paramMap, "appName", str3);
      putIfAbsent(paramMap, "appVersion", str4);
      putIfAbsent(paramMap, "appId", str1);
      putIfAbsent(paramMap, "appInstallerId", str2);
      Object localObject = paramMap.put("apiVersion", "1");
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        int i = Log.e("Error retrieving package info: appName set to " + str3);
    }
  }

  private void fillCampaignParameters(Map<String, String> paramMap)
  {
    String str = Utils.filterCampaign((String)paramMap.get("campaign"));
    if (TextUtils.isEmpty(str))
      return;
    Map localMap = Utils.parseURLParameters(str);
    Object localObject1 = localMap.get("utm_content");
    Object localObject2 = paramMap.put("campaignContent", localObject1);
    Object localObject3 = localMap.get("utm_medium");
    Object localObject4 = paramMap.put("campaignMedium", localObject3);
    Object localObject5 = localMap.get("utm_campaign");
    Object localObject6 = paramMap.put("campaignName", localObject5);
    Object localObject7 = localMap.get("utm_source");
    Object localObject8 = paramMap.put("campaignSource", localObject7);
    Object localObject9 = localMap.get("utm_term");
    Object localObject10 = paramMap.put("campaignKeyword", localObject9);
    Object localObject11 = localMap.get("utm_id");
    Object localObject12 = paramMap.put("campaignId", localObject11);
    Object localObject13 = localMap.get("gclid");
    Object localObject14 = paramMap.put("gclid", localObject13);
    Object localObject15 = localMap.get("dclid");
    Object localObject16 = paramMap.put("dclid", localObject15);
    Object localObject17 = localMap.get("gmob_t");
    Object localObject18 = paramMap.put("gmob_t", localObject17);
  }

  private void fillExceptionParameters(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("rawException");
    if (str1 == null)
      return;
    Object localObject1 = paramMap.remove("rawException");
    byte[] arrayOfByte = Utils.hexDecode(str1);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    try
    {
      ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
      Object localObject2 = localObjectInputStream.readObject();
      localObjectInputStream.close();
      if (!(localObject2 instanceof Throwable))
        return;
      Throwable localThrowable = (Throwable)localObject2;
      ArrayList localArrayList = new ArrayList();
      Context localContext = this.ctx;
      StandardExceptionParser localStandardExceptionParser = new StandardExceptionParser(localContext, localArrayList);
      String str2 = (String)paramMap.get("exceptionThreadName");
      String str3 = localStandardExceptionParser.getDescription(str2, localThrowable);
      Object localObject3 = paramMap.put("exDescription", str3);
      return;
    }
    catch (IOException localIOException)
    {
      int i = Log.w("IOException reading exception");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      int j = Log.w("ClassNotFoundException reading exception");
    }
  }

  static String getAndClearCampaign(Context paramContext)
  {
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaInstallData");
      byte[] arrayOfByte = new byte[8192];
      int i = localFileInputStream.read(arrayOfByte, 0, 8192);
      if (localFileInputStream.available() > 0)
      {
        int j = Log.e("Too much campaign data, ignoring it.");
        localFileInputStream.close();
        boolean bool1 = paramContext.deleteFile("gaInstallData");
        str = null;
      }
      while (true)
      {
        return str;
        localFileInputStream.close();
        boolean bool2 = paramContext.deleteFile("gaInstallData");
        if (i <= 0)
        {
          int k = Log.w("Campaign file is empty.");
          str = null;
        }
        else
        {
          str = new String(arrayOfByte, 0, i);
          int m = Log.i("Campaign found: " + str);
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
      {
        int n = Log.i("No campaign data found.");
        str = null;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        int i1 = Log.e("Error reading campaign data.");
        boolean bool3 = paramContext.deleteFile("gaInstallData");
        String str = null;
      }
    }
  }

  private String getHostUrl(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("internalHitUrl");
    if (str == null)
      if (!Utils.safeParseBoolean((String)paramMap.get("useSecure")))
        break label41;
    label41: for (str = "https://ssl.google-analytics.com/collect"; ; str = "http://www.google-analytics.com/collect")
      return str;
  }

  static GAThread getInstance(Context paramContext)
  {
    if (instance == null)
      instance = new GAThread(paramContext);
    return instance;
  }

  private void init()
  {
    this.proxy.createService();
    ArrayList localArrayList = new ArrayList();
    this.commands = localArrayList;
    List localList1 = this.commands;
    Command localCommand1 = new Command("appendVersion", "_v", "ma1b3");
    boolean bool1 = localList1.add(localCommand1);
    List localList2 = this.commands;
    Command localCommand2 = new Command("appendQueueTime", "qt", null);
    boolean bool2 = localList2.add(localCommand2);
    List localList3 = this.commands;
    Command localCommand3 = new Command("appendCacheBuster", "z", null);
    boolean bool3 = localList3.add(localCommand3);
    MetaModel localMetaModel = new MetaModel();
    this.metaModel = localMetaModel;
    MetaModelInitializer.set(this.metaModel);
    start();
  }

  private boolean isSampledOut(Map<String, String> paramMap)
  {
    double d1;
    boolean bool;
    if (paramMap.get("sampleRate") != null)
    {
      d1 = Utils.safeParseDouble((String)paramMap.get("sampleRate"));
      if (d1 <= 0.0D)
        bool = true;
    }
    while (true)
    {
      return bool;
      if (d1 < 100.0D)
      {
        String str = (String)paramMap.get("clientId");
        if (str != null)
        {
          double d2 = Math.abs(str.hashCode()) % 10000;
          double d3 = 100.0D * d1;
          if (d2 >= d3)
            bool = true;
        }
      }
      else
      {
        bool = false;
      }
    }
  }

  private boolean loadAppOptOut()
  {
    return this.ctx.getFileStreamPath("gaOptOut").exists();
  }

  private String printStackTrace(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    return new String(arrayOfByte);
  }

  private void putIfAbsent(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramMap.containsKey(paramString1))
      return;
    Object localObject = paramMap.put(paramString1, paramString2);
  }

  private void queueToThread(Runnable paramRunnable)
  {
    boolean bool = this.queue.add(paramRunnable);
  }

  private boolean storeClientId(String paramString)
  {
    boolean bool = false;
    try
    {
      FileOutputStream localFileOutputStream = this.ctx.openFileOutput("gaClientId", 0);
      byte[] arrayOfByte = paramString.getBytes();
      localFileOutputStream.write(arrayOfByte);
      localFileOutputStream.close();
      bool = true;
      return bool;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
        int i = Log.e("Error creating clientId file.");
    }
    catch (IOException localIOException)
    {
      while (true)
        int j = Log.e("Error writing to clientId file.");
    }
  }

  void close()
  {
    this.closed = true;
    interrupt();
  }

  public void dispatch()
  {
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        GAThread.this.proxy.dispatch();
      }
    };
    queueToThread(local2);
  }

  String generateClientId()
  {
    String str = Long.toHexString((new SecureRandom().nextLong() & 0xFFFFFFFF) % 9223372036854775807L + 1L);
    if (!storeClientId(str));
    return str;
  }

  public LinkedBlockingQueue<Runnable> getQueue()
  {
    return this.queue;
  }

  public Thread getThread()
  {
    return this;
  }

  // ERROR //
  String initializeClientId()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 70	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   6: ldc_w 481
    //   9: invokevirtual 330	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   12: astore_2
    //   13: sipush 128
    //   16: newarray byte
    //   18: astore_3
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: sipush 128
    //   25: invokevirtual 336	java/io/FileInputStream:read	([BII)I
    //   28: istore 4
    //   30: aload_2
    //   31: invokevirtual 340	java/io/FileInputStream:available	()I
    //   34: ifle +27 -> 61
    //   37: ldc_w 536
    //   40: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   43: istore 5
    //   45: aload_2
    //   46: invokevirtual 343	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: getfield 70	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   53: ldc_w 326
    //   56: invokevirtual 347	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   59: istore 6
    //   61: iload 4
    //   63: ifgt +38 -> 101
    //   66: ldc_w 538
    //   69: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   72: istore 7
    //   74: aload_2
    //   75: invokevirtual 343	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: getfield 70	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   82: ldc_w 326
    //   85: invokevirtual 347	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   88: istore 8
    //   90: aload_1
    //   91: ifnonnull +8 -> 99
    //   94: aload_0
    //   95: invokevirtual 540	com/google/analytics/tracking/android/GAThread:generateClientId	()Ljava/lang/String;
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: new 218	java/lang/String
    //   104: dup
    //   105: aload_3
    //   106: iconst_0
    //   107: iload 4
    //   109: invokespecial 352	java/lang/String:<init>	([BII)V
    //   112: astore 9
    //   114: aload_2
    //   115: invokevirtual 343	java/io/FileInputStream:close	()V
    //   118: aload 9
    //   120: astore_1
    //   121: goto -31 -> 90
    //   124: astore 10
    //   126: ldc_w 542
    //   129: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   132: istore 11
    //   134: aload_0
    //   135: getfield 70	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   138: ldc_w 326
    //   141: invokevirtual 347	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   144: istore 12
    //   146: goto -56 -> 90
    //   149: astore 13
    //   151: ldc_w 544
    //   154: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   157: istore 14
    //   159: aload_0
    //   160: getfield 70	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   163: ldc_w 326
    //   166: invokevirtual 347	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   169: istore 15
    //   171: goto -81 -> 90
    //   174: astore 16
    //   176: aload 9
    //   178: astore_1
    //   179: goto -28 -> 151
    //   182: astore 17
    //   184: aload 9
    //   186: astore_1
    //   187: goto -61 -> 126
    //   190: astore 18
    //   192: goto -102 -> 90
    //   195: astore 19
    //   197: aload 9
    //   199: astore_1
    //   200: goto -110 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   2	90	124	java/io/IOException
    //   101	114	124	java/io/IOException
    //   2	90	149	java/lang/NumberFormatException
    //   101	114	149	java/lang/NumberFormatException
    //   114	118	174	java/lang/NumberFormatException
    //   114	118	182	java/io/IOException
    //   2	90	190	java/io/FileNotFoundException
    //   101	114	190	java/io/FileNotFoundException
    //   114	118	195	java/io/FileNotFoundException
  }

  boolean isDisabled()
  {
    return this.disabled;
  }

  public void requestAppOptOut(final Analytics.AppOptOutCallback paramAppOptOutCallback)
  {
    Runnable local4 = new Runnable()
    {
      public void run()
      {
        Analytics.AppOptOutCallback localAppOptOutCallback = paramAppOptOutCallback;
        boolean bool = GAThread.this.appOptOut;
        localAppOptOutCallback.reportAppOptOut(bool);
      }
    };
    queueToThread(local4);
  }

  public void requestClientId(final AnalyticsThread.ClientIdCallback paramClientIdCallback)
  {
    Runnable local5 = new Runnable()
    {
      public void run()
      {
        AnalyticsThread.ClientIdCallback localClientIdCallback = paramClientIdCallback;
        String str = GAThread.this.clientId;
        localClientIdCallback.reportClientId(str);
      }
    };
    queueToThread(local5);
  }

  public void run()
  {
    try
    {
      Thread.sleep(2000L);
    }
    catch (InterruptedException localInterruptedException2)
    {
      try
      {
        while (true)
        {
          boolean bool = loadAppOptOut();
          this.appOptOut = bool;
          String str1 = initializeClientId();
          this.clientId = str1;
          String str2 = getAndClearCampaign(this.ctx);
          this.installCampaign = str2;
          while (true)
          {
            if (this.closed)
              return;
            try
            {
              Runnable localRunnable = (Runnable)this.queue.take();
              if (!this.disabled)
                localRunnable.run();
            }
            catch (InterruptedException localInterruptedException1)
            {
              int i = Log.i(localInterruptedException1.toString());
            }
            catch (Throwable localThrowable1)
            {
              StringBuilder localStringBuilder1 = new StringBuilder().append("Error on GAThread: ");
              String str3 = printStackTrace(localThrowable1);
              int j = Log.e(str3);
              int k = Log.e("Google Analytics is shutting down.");
              this.disabled = true;
            }
          }
          localInterruptedException2 = localInterruptedException2;
          int m = Log.w("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("Error initializing the GAThread: ");
          String str4 = printStackTrace(localThrowable2);
          int n = Log.e(str4);
          int i1 = Log.e("Google Analytics will not start up.");
          this.disabled = true;
        }
      }
    }
  }

  public void sendHit(Map<String, String> paramMap)
  {
    final HashMap localHashMap = new HashMap(paramMap);
    final long l = System.currentTimeMillis();
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (GAThread.this.appOptOut)
          return;
        GAThread localGAThread1 = GAThread.this;
        Map localMap1 = localHashMap;
        if (localGAThread1.isSampledOut(localMap1))
          return;
        Map localMap2 = localHashMap;
        String str1 = GAThread.this.clientId;
        Object localObject1 = localMap2.put("clientId", str1);
        if (!TextUtils.isEmpty(GAThread.this.installCampaign))
        {
          Map localMap3 = localHashMap;
          String str2 = GAThread.this.installCampaign;
          Object localObject2 = localMap3.put("campaign", str2);
          String str3 = GAThread.access$302(GAThread.this, null);
        }
        GAThread localGAThread2 = GAThread.this;
        Map localMap4 = localHashMap;
        localGAThread2.fillAppParameters(localMap4);
        GAThread localGAThread3 = GAThread.this;
        Map localMap5 = localHashMap;
        localGAThread3.fillCampaignParameters(localMap5);
        GAThread localGAThread4 = GAThread.this;
        Map localMap6 = localHashMap;
        localGAThread4.fillExceptionParameters(localMap6);
        MetaModel localMetaModel = GAThread.this.metaModel;
        Map localMap7 = localHashMap;
        Map localMap8 = HitBuilder.generateHitParams(localMetaModel, localMap7);
        ServiceProxy localServiceProxy = GAThread.this.proxy;
        long l = l;
        GAThread localGAThread5 = GAThread.this;
        Map localMap9 = localHashMap;
        String str4 = localGAThread5.getHostUrl(localMap9);
        List localList = GAThread.this.commands;
        localServiceProxy.putHit(localMap8, l, str4, localList);
      }
    };
    queueToThread(local1);
  }

  public void setAppOptOut(final boolean paramBoolean)
  {
    Runnable local3 = new Runnable()
    {
      public void run()
      {
        boolean bool1 = GAThread.this.appOptOut;
        boolean bool2 = paramBoolean;
        if (bool1 != bool2)
          return;
        File localFile;
        if (paramBoolean)
          localFile = GAThread.this.ctx.getFileStreamPath("gaOptOut");
        while (true)
        {
          try
          {
            boolean bool3 = localFile.createNewFile();
            GAThread.this.proxy.clearHits();
            GAThread localGAThread = GAThread.this;
            boolean bool4 = paramBoolean;
            boolean bool5 = GAThread.access$002(localGAThread, bool4);
            return;
          }
          catch (IOException localIOException)
          {
            int i = Log.w("Error creating optOut file.");
            continue;
          }
          boolean bool6 = GAThread.this.ctx.deleteFile("gaOptOut");
        }
      }
    };
    queueToThread(local3);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAThread
 * JD-Core Version:    0.6.2
 */