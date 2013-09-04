package com.crashlytics.android;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Crashlytics
{
  private static Crashlytics b = null;
  private static final String c = null;
  private static ContextWrapper n;
  private static String o;
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static File t;
  private static boolean u = false;
  private static PinningInfoProvider v = null;
  String a = null;
  private B d;
  private CrashlyticsListener e;
  private j f;
  private final long g;
  private final ConcurrentHashMap<String, String> h;
  private boolean i = true;
  private IdManager j = null;
  private String k = null;
  private String l = null;
  private String m = null;

  private Crashlytics()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    this.h = localConcurrentHashMap;
    long l1 = System.currentTimeMillis();
    this.g = l1;
  }

  private static String a(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (paramString.length() > 1024)
        paramString = paramString.substring(0, 1024);
    }
    return paramString;
  }

  private Void a(Context paramContext, float paramFloat)
  {
    int i1 = 0;
    try
    {
      this.f.c();
      this.f.e();
      if (this.d.b())
      {
        i1 = 1;
        if (this.d.l())
          t.a().a(paramContext, paramFloat);
      }
      else if (i1 == 0)
      {
        D.c("Crash report collection disabled.");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          this.f.d();
          return null;
          D.c("Crash reporting disabled");
        }
        localException1 = localException1;
        int i2 = i1;
        Exception localException2 = localException1;
        D.a("Error sending crash report", localException2);
        i1 = i2;
      }
      catch (Exception localException3)
      {
        while (true)
          D.a("Error writing session report", localException3);
      }
    }
  }

  /** @deprecated */
  // ERROR //
  private void a(String paramString, Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   8: ifnull +11 -> 19
    //   11: ldc 148
    //   13: invokestatic 129	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_2
    //   20: invokevirtual 154	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   23: astore 5
    //   25: new 156	android/content/ContextWrapper
    //   28: dup
    //   29: aload 5
    //   31: invokespecial 159	android/content/ContextWrapper:<init>	(Landroid/content/Context;)V
    //   34: astore 6
    //   36: new 161	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 163
    //   42: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: invokestatic 168	com/crashlytics/android/Crashlytics:getCrashlyticsVersion	()Ljava/lang/String;
    //   50: astore 8
    //   52: aload 7
    //   54: aload 8
    //   56: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 9
    //   64: ldc 177
    //   66: aload 9
    //   68: invokestatic 182	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: istore 10
    //   73: aload_1
    //   74: putstatic 184	com/crashlytics/android/Crashlytics:s	Ljava/lang/String;
    //   77: aload 6
    //   79: putstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   82: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   85: invokevirtual 187	android/content/ContextWrapper:getPackageName	()Ljava/lang/String;
    //   88: putstatic 189	com/crashlytics/android/Crashlytics:o	Ljava/lang/String;
    //   91: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   94: invokevirtual 193	android/content/ContextWrapper:getPackageManager	()Landroid/content/pm/PackageManager;
    //   97: astore 11
    //   99: getstatic 189	com/crashlytics/android/Crashlytics:o	Ljava/lang/String;
    //   102: astore 12
    //   104: aload 11
    //   106: aload 12
    //   108: iconst_0
    //   109: invokevirtual 199	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   112: astore 13
    //   114: aload 13
    //   116: getfield 205	android/content/pm/PackageInfo:versionCode	I
    //   119: invokestatic 210	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   122: putstatic 212	com/crashlytics/android/Crashlytics:q	Ljava/lang/String;
    //   125: aload 13
    //   127: getfield 215	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   130: putstatic 217	com/crashlytics/android/Crashlytics:r	Ljava/lang/String;
    //   133: aload_2
    //   134: invokevirtual 218	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   137: astore 14
    //   139: aload_2
    //   140: invokevirtual 222	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   143: astore 15
    //   145: aload 14
    //   147: aload 15
    //   149: invokevirtual 226	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   152: invokevirtual 227	java/lang/Object:toString	()Ljava/lang/String;
    //   155: putstatic 229	com/crashlytics/android/Crashlytics:p	Ljava/lang/String;
    //   158: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   161: invokevirtual 233	android/content/Context:getFilesDir	()Ljava/io/File;
    //   164: astore 16
    //   166: new 235	java/io/File
    //   169: dup
    //   170: aload 16
    //   172: ldc 237
    //   174: invokespecial 240	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   177: astore 17
    //   179: aload 17
    //   181: putstatic 242	com/crashlytics/android/Crashlytics:t	Ljava/io/File;
    //   184: aload 17
    //   186: invokevirtual 245	java/io/File:exists	()Z
    //   189: ifne +11 -> 200
    //   192: getstatic 242	com/crashlytics/android/Crashlytics:t	Ljava/io/File;
    //   195: invokevirtual 248	java/io/File:mkdirs	()Z
    //   198: istore 18
    //   200: new 250	com/crashlytics/android/IdManager
    //   203: dup
    //   204: invokespecial 251	com/crashlytics/android/IdManager:<init>	()V
    //   207: astore 19
    //   209: aload_0
    //   210: aload 19
    //   212: putfield 57	com/crashlytics/android/Crashlytics:j	Lcom/crashlytics/android/IdManager;
    //   215: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   218: invokevirtual 255	android/content/ContextWrapper:getResources	()Landroid/content/res/Resources;
    //   221: astore 20
    //   223: getstatic 189	com/crashlytics/android/Crashlytics:o	Ljava/lang/String;
    //   226: astore 21
    //   228: aload 20
    //   230: ldc_w 257
    //   233: ldc_w 259
    //   236: aload 21
    //   238: invokevirtual 265	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   241: astore 22
    //   243: aload 22
    //   245: ifnonnull +31 -> 276
    //   248: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   251: invokevirtual 255	android/content/ContextWrapper:getResources	()Landroid/content/res/Resources;
    //   254: astore 23
    //   256: getstatic 189	com/crashlytics/android/Crashlytics:o	Ljava/lang/String;
    //   259: astore 24
    //   261: aload 23
    //   263: ldc_w 267
    //   266: ldc_w 259
    //   269: aload 24
    //   271: invokevirtual 265	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   274: istore 22
    //   276: aload 22
    //   278: ifnull +380 -> 658
    //   281: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   284: invokevirtual 255	android/content/ContextWrapper:getResources	()Landroid/content/res/Resources;
    //   287: aload 22
    //   289: invokevirtual 270	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   292: astore 22
    //   294: new 161	java/lang/StringBuilder
    //   297: dup
    //   298: ldc_w 272
    //   301: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: aload 22
    //   306: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 129	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   315: aload_0
    //   316: iconst_0
    //   317: putfield 55	com/crashlytics/android/Crashlytics:i	Z
    //   320: aload_0
    //   321: getfield 55	com/crashlytics/android/Crashlytics:i	Z
    //   324: ifeq +131 -> 455
    //   327: aload 22
    //   329: ifnull +11 -> 340
    //   332: aload 22
    //   334: invokevirtual 92	java/lang/String:length	()I
    //   337: ifne +118 -> 455
    //   340: ldc_w 274
    //   343: invokestatic 277	com/crashlytics/android/Crashlytics:log	(Ljava/lang/String;)V
    //   346: invokestatic 280	com/crashlytics/android/D:a	()Landroid/content/SharedPreferences;
    //   349: aconst_null
    //   350: iconst_0
    //   351: invokeinterface 286 3 0
    //   356: ifne -340 -> 16
    //   359: ldc_w 288
    //   362: invokestatic 294	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   365: astore 25
    //   367: new 296	android/content/Intent
    //   370: dup
    //   371: ldc_w 298
    //   374: aload 25
    //   376: invokespecial 301	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   379: astore 26
    //   381: aload 26
    //   383: ldc_w 302
    //   386: invokevirtual 306	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   389: astore 27
    //   391: getstatic 146	com/crashlytics/android/Crashlytics:n	Landroid/content/ContextWrapper;
    //   394: invokevirtual 307	android/content/ContextWrapper:getApplicationContext	()Landroid/content/Context;
    //   397: aload 26
    //   399: invokevirtual 311	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   402: invokestatic 280	com/crashlytics/android/D:a	()Landroid/content/SharedPreferences;
    //   405: invokeinterface 315 1 0
    //   410: astore 28
    //   412: aload 28
    //   414: aconst_null
    //   415: iconst_1
    //   416: invokeinterface 321 3 0
    //   421: astore 29
    //   423: aload 28
    //   425: invokeinterface 324 1 0
    //   430: istore 30
    //   432: goto -416 -> 16
    //   435: astore 31
    //   437: aload_0
    //   438: monitorexit
    //   439: aload 31
    //   441: athrow
    //   442: astore 22
    //   444: ldc_w 326
    //   447: aload 22
    //   449: invokestatic 138	com/crashlytics/android/D:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   452: goto -252 -> 200
    //   455: getstatic 184	com/crashlytics/android/Crashlytics:s	Ljava/lang/String;
    //   458: astore 32
    //   460: getstatic 189	com/crashlytics/android/Crashlytics:o	Ljava/lang/String;
    //   463: astore 33
    //   465: getstatic 212	com/crashlytics/android/Crashlytics:q	Ljava/lang/String;
    //   468: astore 34
    //   470: getstatic 217	com/crashlytics/android/Crashlytics:r	Ljava/lang/String;
    //   473: astore 35
    //   475: new 109	com/crashlytics/android/B
    //   478: dup
    //   479: aload 32
    //   481: aload 33
    //   483: aload 34
    //   485: aload 35
    //   487: invokespecial 329	com/crashlytics/android/B:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   490: astore 36
    //   492: aload_0
    //   493: aload 36
    //   495: putfield 107	com/crashlytics/android/Crashlytics:d	Lcom/crashlytics/android/B;
    //   498: ldc_w 331
    //   501: invokestatic 129	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   504: invokestatic 337	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   507: astore 37
    //   509: aload_0
    //   510: getfield 339	com/crashlytics/android/Crashlytics:e	Lcom/crashlytics/android/CrashlyticsListener;
    //   513: astore 38
    //   515: new 101	com/crashlytics/android/j
    //   518: dup
    //   519: aload 37
    //   521: aload 38
    //   523: invokespecial 342	com/crashlytics/android/j:<init>	(Ljava/lang/Thread$UncaughtExceptionHandler;Lcom/crashlytics/android/CrashlyticsListener;)V
    //   526: astore 39
    //   528: aload_0
    //   529: aload 39
    //   531: putfield 81	com/crashlytics/android/Crashlytics:f	Lcom/crashlytics/android/j;
    //   534: aload_0
    //   535: getfield 81	com/crashlytics/android/Crashlytics:f	Lcom/crashlytics/android/j;
    //   538: invokestatic 346	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   541: ldc_w 348
    //   544: invokestatic 129	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   547: getstatic 242	com/crashlytics/android/Crashlytics:t	Ljava/io/File;
    //   550: astore 40
    //   552: new 235	java/io/File
    //   555: dup
    //   556: aload 40
    //   558: ldc_w 350
    //   561: invokespecial 240	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   564: astore 22
    //   566: new 352	com/crashlytics/android/i
    //   569: dup
    //   570: aload_0
    //   571: aload_2
    //   572: fload_3
    //   573: aload 22
    //   575: invokespecial 355	com/crashlytics/android/i:<init>	(Lcom/crashlytics/android/Crashlytics;Landroid/content/Context;FLjava/io/File;)V
    //   578: astore 4
    //   580: aload 22
    //   582: invokevirtual 245	java/io/File:exists	()Z
    //   585: ifeq +21 -> 606
    //   588: aload_0
    //   589: aload_2
    //   590: fload_3
    //   591: invokespecial 143	com/crashlytics/android/Crashlytics:a	(Landroid/content/Context;F)Ljava/lang/Void;
    //   594: astore 41
    //   596: aload 22
    //   598: invokevirtual 358	java/io/File:delete	()Z
    //   601: istore 42
    //   603: goto -587 -> 16
    //   606: new 360	java/io/FileOutputStream
    //   609: dup
    //   610: aload 22
    //   612: invokespecial 363	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   615: invokevirtual 366	java/io/FileOutputStream:close	()V
    //   618: aconst_null
    //   619: astore 22
    //   621: aload 22
    //   623: anewarray 368	java/lang/Void
    //   626: astore 43
    //   628: aload 43
    //   630: iconst_0
    //   631: aconst_null
    //   632: aastore
    //   633: aload 4
    //   635: aload 43
    //   637: invokevirtual 374	android/os/AsyncTask:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   640: astore 44
    //   642: goto -626 -> 16
    //   645: astore 45
    //   647: ldc_w 376
    //   650: aload 45
    //   652: invokestatic 138	com/crashlytics/android/D:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   655: goto -37 -> 618
    //   658: aconst_null
    //   659: astore 22
    //   661: goto -346 -> 315
    //
    // Exception table:
    //   from	to	target	type
    //   5	16	435	finally
    //   19	82	435	finally
    //   82	200	435	finally
    //   200	432	435	finally
    //   444	603	435	finally
    //   606	618	435	finally
    //   621	655	435	finally
    //   82	200	442	java/lang/Exception
    //   606	618	645	java/lang/Exception
  }

  static ContextWrapper f()
  {
    return n;
  }

  static String g()
  {
    return o;
  }

  public static String getCrashlyticsVersion()
  {
    return "0.9.11.11";
  }

  /** @deprecated */
  public static Crashlytics getInstance()
  {
    try
    {
      if (b == null)
        b = new Crashlytics();
      Crashlytics localCrashlytics = b;
      return localCrashlytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static PinningInfoProvider getPinningInfoProvider()
  {
    return v;
  }

  static String h()
  {
    return r;
  }

  static String i()
  {
    return q;
  }

  static String j()
  {
    return s;
  }

  static File k()
  {
    return t;
  }

  static String l()
  {
    return p;
  }

  public static void log(int paramInt, String paramString1, String paramString2)
  {
    log(paramString2);
    String str1 = paramString1;
    String str2 = paramString2;
    int i1 = Log.println(paramInt, str1, str2);
  }

  public static void log(String paramString)
  {
    if ((b == null) || (b.f == null))
    {
      D.a("Crashlytics must be initialized by calling Crashlytics.start(Context) prior to logging messages.", null);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = b.g;
    long l3 = l1 - l2;
    h localh = new h(l3, paramString);
    new Thread(localh).start();
  }

  static String m()
  {
    String str = D.a(n, "com.crashlytics.ApiEndpoint");
    if ((str != null) && (str.length() > 0));
    while (true)
    {
      return str;
      str = "https://settings.crashlytics.com";
    }
  }

  public static void setApplicationInstallationIdentifier(String paramString)
  {
    Crashlytics localCrashlytics = getInstance();
    String str = a(paramString);
    localCrashlytics.a = str;
  }

  public static void setBool(String paramString, boolean paramBoolean)
  {
    String str = Boolean.toString(paramBoolean);
    setString(paramString, str);
  }

  public static void setDouble(String paramString, double paramDouble)
  {
    String str = Double.toString(paramDouble);
    setString(paramString, str);
  }

  public static void setFloat(String paramString, float paramFloat)
  {
    String str = Float.toString(paramFloat);
    setString(paramString, str);
  }

  public static void setInt(String paramString, int paramInt)
  {
    String str = Integer.toString(paramInt);
    setString(paramString, str);
  }

  public static void setLong(String paramString, long paramLong)
  {
    String str = Long.toString(paramLong);
    setString(paramString, str);
  }

  public static void setPinningInfoProvider(PinningInfoProvider paramPinningInfoProvider)
  {
    if (v == paramPinningInfoProvider)
      return;
    v = paramPinningInfoProvider;
    D.g();
  }

  public static void setString(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      if ((n != null) && (D.c(n)))
        throw new IllegalArgumentException("Custom attribute key cannot be null.");
      D.a("Attempting to set custom attribute with null key, ignoring.", null);
      return;
    }
    paramString1 = a(paramString1);
    if ((getInstance().h.size() < 64) || (getInstance().h.containsKey(paramString1)))
    {
      if (paramString2 == null);
      for (paramString2 = ""; ; paramString2 = a(paramString2))
      {
        Object localObject = b.h.put(paramString1, paramString2);
        return;
      }
    }
    D.c("Exceeded maximum number of custom attributes (64)");
  }

  public static void setUserEmail(String paramString)
  {
    Crashlytics localCrashlytics = getInstance();
    String str = a(paramString);
    localCrashlytics.l = str;
  }

  public static void setUserIdentifier(String paramString)
  {
    Crashlytics localCrashlytics = getInstance();
    String str = a(paramString);
    localCrashlytics.k = str;
  }

  public static void setUserName(String paramString)
  {
    Crashlytics localCrashlytics = getInstance();
    String str = a(paramString);
    localCrashlytics.m = str;
  }

  public static void start(Context paramContext)
  {
    start(paramContext, 1.0F);
  }

  public static void start(Context paramContext, float paramFloat)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context cannot be null.");
    String str3;
    try
    {
      PackageManager localPackageManager = paramContext.getApplicationContext().getPackageManager();
      String str1 = paramContext.getApplicationContext().getPackageName();
      Bundle localBundle = localPackageManager.getApplicationInfo(str1, 128).metaData;
      if (localBundle != null)
      {
        String str2 = localBundle.getString("com.crashlytics.ApiKey");
        str3 = str2;
        if ((str3 != null) && (str3.length() != 0))
          break label195;
        Resources localResources = paramContext.getResources();
        String str4 = o;
        int i1 = localResources.getIdentifier("com.crashlytics.ApiKey", "string", str4);
        if (i1 != 0)
          String str5 = paramContext.getResources().getString(i1);
        if ((str3 != null) && (str3.length() != 0))
          break label195;
        str3 = "Crashlytics could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"com.crashlytics.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
        if ((!u) && (!D.c(paramContext)))
          break label188;
        throw new IllegalArgumentException(str3);
      }
    }
    catch (Exception localException1)
    {
      while (true)
      {
        D.c("Caught non-fatal exception while retrieving apiKey: " + localException1);
        str3 = null;
      }
      label188: D.a(str3, null);
      return;
    }
    try
    {
      label195: getInstance().a(str3, paramContext, paramFloat);
      return;
    }
    catch (Exception localException2)
    {
      D.a("Crashlytics was not started due to an exception during initialization", localException2);
    }
  }

  final String a()
  {
    if (this.j.a());
    for (String str = this.k; ; str = null)
      return str;
  }

  final String b()
  {
    if (this.j.a());
    for (String str = this.l; ; str = null)
      return str;
  }

  final String c()
  {
    if (this.j.a());
    for (String str = this.m; ; str = null)
      return str;
  }

  public final void crash()
  {
    new CrashTest().indexOutOfBounds();
  }

  final Map<String, String> d()
  {
    return Collections.unmodifiableMap(this.h);
  }

  final IdManager e()
  {
    return this.j;
  }

  public final boolean getDebugMode()
  {
    return u;
  }

  final B n()
  {
    return this.d;
  }

  final j o()
  {
    return this.f;
  }

  public final void setDebugMode(boolean paramBoolean)
  {
    u = paramBoolean;
  }

  public final void setListener(CrashlyticsListener paramCrashlyticsListener)
  {
    this.e = paramCrashlyticsListener;
  }

  public final boolean verifyPinning(URL paramURL)
  {
    boolean bool = false;
    if (v == null);
    while (true)
    {
      return bool;
      try
      {
        HttpURLConnection localHttpURLConnection = D.a(paramURL);
        localHttpURLConnection.connect();
        int i1 = localHttpURLConnection.getResponseCode();
        int i2 = i1;
        if ((i2 >= 200) && (i2 < 300))
          bool = true;
      }
      catch (Exception localException)
      {
        D.a("Could not verify SSL pinning", localException);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.Crashlytics
 * JD-Core Version:    0.6.2
 */