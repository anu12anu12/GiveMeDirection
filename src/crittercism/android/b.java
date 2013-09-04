package crittercism.android;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.crittercism.app.Crittercism;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  final String a;
  final int b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private c k;
  private Context l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private List s;
  private boolean t;
  private String u;
  private Object v;

  public b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str1 = d.b();
    this.c = str1;
    String str2 = d.a();
    this.d = str2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str3 = this.d;
    String str4 = str3 + "/feedback/app_loaded";
    this.e = str4;
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str5 = this.d;
    String str6 = str5 + "/feedback/get_feedback";
    this.f = str6;
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str7 = this.d;
    String str8 = str7 + "/android_v1/crash";
    this.g = str8;
    StringBuilder localStringBuilder4 = new StringBuilder();
    String str9 = this.d;
    String str10 = str9 + "/feedback/update_user_metadata";
    this.h = str10;
    StringBuilder localStringBuilder5 = new StringBuilder();
    String str11 = this.d;
    String str12 = str11 + "/feedback/log_crittererror";
    this.i = str12;
    StringBuilder localStringBuilder6 = new StringBuilder();
    String str13 = this.d;
    String str14 = str13 + "/android_v1/update_package_name";
    this.j = str14;
    this.k = null;
    this.l = null;
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = "";
    ArrayList localArrayList = new ArrayList();
    this.s = localArrayList;
    this.a = "critter_did";
    this.b = 100;
    this.t = false;
    this.u = "";
    Object localObject = new Object();
    this.v = localObject;
    this.l = paramContext;
    String str15 = this.c;
    Context localContext = this.l;
    c localc = new c(str15, localContext);
    this.k = localc;
    this.m = paramString1;
    this.n = null;
    this.o = paramString4;
    this.p = paramString5;
    this.q = paramString2;
    this.r = paramString3;
  }

  private static String b(Exception paramException)
  {
    String str1 = new String();
    int i1 = paramException.toString().indexOf(":");
    if (i1 >= 0)
      String str2 = paramException.toString().substring(0, i1);
    StringWriter localStringWriter;
    while (true)
    {
      localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramException.printStackTrace(localPrintWriter);
      for (Throwable localThrowable = paramException.getCause(); localThrowable != null; localThrowable = localThrowable.getCause())
      {
        String str3 = localThrowable.getClass().getName();
        localThrowable.printStackTrace(localPrintWriter);
      }
      String str4 = paramException.getClass().getName();
    }
    return localStringWriter.toString();
  }

  private static String b(String paramString)
  {
    String str1 = null;
    if ((paramString != null) && (!paramString.equals("")));
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      byte[] arrayOfByte1 = paramString.getBytes();
      byte[] arrayOfByte2 = localMessageDigest.digest(arrayOfByte1);
      String str2 = new BigInteger(1, arrayOfByte2).toString(16);
      paramString = new String(str2);
      if (paramString.equals(""))
        return str1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
      {
        paramString = null;
        continue;
        str1 = paramString;
      }
    }
  }

  private int c(String paramString)
  {
    int i1 = -1;
    try
    {
      PackageManager localPackageManager = this.l.getPackageManager();
      String str = this.l.getPackageName();
      int i2 = localPackageManager.checkPermission(paramString, str);
      i1 = i2;
      label32: return i1;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }

  private double g()
  {
    double d1 = 1.0D;
    try
    {
      Context localContext = this.l.getApplicationContext();
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
      Intent localIntent = localContext.registerReceiver(null, localIntentFilter);
      int i1 = localIntent.getIntExtra("level", -1);
      int i2 = localIntent.getIntExtra("scale", -1);
      double d2 = i2;
      if ((i1 >= 0) && (d2 > 0.0D))
        d1 = i1 / d2;
      label80: return d1;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }

  private static long h()
  {
    int i1 = -1;
    try
    {
      Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
      Debug.getMemoryInfo(localMemoryInfo);
      int i2 = localMemoryInfo.dalvikPss;
      int i3 = localMemoryInfo.nativePss;
      int i4 = i2 + i3;
      int i5 = localMemoryInfo.otherPss;
      i1 = (i5 + i4) * 1024;
      label46: return i1;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }

  private String i()
  {
    try
    {
      String str1 = ((TelephonyManager)this.l.getSystemService("phone")).getNetworkOperatorName();
      str2 = str1;
      return str2;
    }
    catch (Exception localException)
    {
      while (true)
        String str2 = Build.BRAND;
    }
  }

  private JSONObject j()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.l.getSystemService("connectivity")).getNetworkInfo(1);
      boolean bool1 = localNetworkInfo.isAvailable();
      JSONObject localJSONObject2 = localJSONObject1.put("available", bool1);
      boolean bool2 = localNetworkInfo.isConnected();
      JSONObject localJSONObject3 = localJSONObject1.put("connected", bool2);
      if (!localNetworkInfo.isConnected())
      {
        boolean bool3 = localNetworkInfo.isConnectedOrConnecting();
        JSONObject localJSONObject4 = localJSONObject1.put("connecting", bool3);
      }
      boolean bool4 = localNetworkInfo.isFailover();
      JSONObject localJSONObject5 = localJSONObject1.put("failover", bool4);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str1 = b.class.getCanonicalName();
        String str2 = localException.toString();
      }
    }
  }

  private JSONObject k()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.l.getSystemService("connectivity")).getNetworkInfo(0);
      boolean bool1 = localNetworkInfo.isAvailable();
      JSONObject localJSONObject2 = localJSONObject1.put("available", bool1);
      boolean bool2 = localNetworkInfo.isConnected();
      JSONObject localJSONObject3 = localJSONObject1.put("connected", bool2);
      if (!localNetworkInfo.isConnected())
      {
        boolean bool3 = localNetworkInfo.isConnectedOrConnecting();
        JSONObject localJSONObject4 = localJSONObject1.put("connecting", bool3);
      }
      boolean bool4 = localNetworkInfo.isFailover();
      JSONObject localJSONObject5 = localJSONObject1.put("failover", bool4);
      boolean bool5 = localNetworkInfo.isRoaming();
      JSONObject localJSONObject6 = localJSONObject1.put("roaming", bool5);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str1 = b.class.getCanonicalName();
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = localException.toString();
        String str3 = str2 + " in getMobileNetworkStatus";
      }
    }
  }

  private String l()
  {
    try
    {
      if (c("android.permission.GET_TASKS") == 0)
      {
        List localList = ((ActivityManager)this.l.getSystemService("activity")).getRunningTasks(1);
        StringBuilder localStringBuilder = new StringBuilder("CURRENT Activity ::");
        String str1 = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getClassName();
        String str2 = str1;
        String str3 = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.flattenToShortString().replace("/", "");
        str4 = str3;
        return str4;
      }
    }
    catch (Exception localException)
    {
      while (true)
        String str4 = "";
    }
  }

  // ERROR //
  private JSONArray m()
  {
    // Byte code:
    //   0: new 383	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 384	org/json/JSONArray:<init>	()V
    //   7: astore_1
    //   8: new 55	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 122	crittercism/android/b:v	Ljava/lang/Object;
    //   20: astore_3
    //   21: aload_3
    //   22: monitorenter
    //   23: invokestatic 390	java/util/concurrent/Executors:newCachedThreadPool	()Ljava/util/concurrent/ExecutorService;
    //   26: astore 4
    //   28: aload_0
    //   29: getfield 122	crittercism/android/b:v	Ljava/lang/Object;
    //   32: astore 5
    //   34: invokestatic 396	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   37: astore 6
    //   39: new 6	crittercism/android/b$a
    //   42: dup
    //   43: aload 5
    //   45: aload 6
    //   47: invokespecial 399	crittercism/android/b$a:<init>	(Ljava/lang/Object;Ljava/lang/Thread;)V
    //   50: astore 7
    //   52: aload 4
    //   54: aload 7
    //   56: invokeinterface 405 2 0
    //   61: astore 8
    //   63: aload 8
    //   65: astore 9
    //   67: invokestatic 407	crittercism/android/b$a:a	()Z
    //   70: ifne +303 -> 373
    //   73: getstatic 413	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   76: astore 10
    //   78: aload 9
    //   80: ldc2_w 414
    //   83: aload 10
    //   85: invokeinterface 420 4 0
    //   90: checkcast 55	java/lang/StringBuilder
    //   93: astore 11
    //   95: aconst_null
    //   96: astore_2
    //   97: aload 9
    //   99: aload_2
    //   100: invokeinterface 424 2 0
    //   105: istore 12
    //   107: aload 4
    //   109: invokeinterface 428 1 0
    //   114: astore 13
    //   116: aload_3
    //   117: monitorexit
    //   118: aload 11
    //   120: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokevirtual 432	java/lang/String:length	()I
    //   126: ifle +135 -> 261
    //   129: aload 11
    //   131: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: ldc_w 434
    //   137: invokevirtual 438	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   140: astore 14
    //   142: iconst_0
    //   143: istore 11
    //   145: aload 14
    //   147: arraylength
    //   148: istore 15
    //   150: iload 11
    //   152: iload 15
    //   154: if_icmpge +107 -> 261
    //   157: aload 14
    //   159: iload 11
    //   161: aaload
    //   162: astore 16
    //   164: aload_1
    //   165: aload 16
    //   167: invokevirtual 441	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   170: astore 17
    //   172: iload 11
    //   174: iconst_1
    //   175: iadd
    //   176: istore 11
    //   178: goto -33 -> 145
    //   181: astore 18
    //   183: invokestatic 443	crittercism/android/b$a:b	()V
    //   186: aload 7
    //   188: invokevirtual 445	crittercism/android/b$a:c	()V
    //   191: ldc2_w 446
    //   194: lstore 19
    //   196: lload 19
    //   198: invokestatic 451	java/lang/Thread:sleep	(J)V
    //   201: aconst_null
    //   202: astore 11
    //   204: aload 9
    //   206: aload 11
    //   208: invokeinterface 424 2 0
    //   213: istore 21
    //   215: aload 4
    //   217: invokeinterface 428 1 0
    //   222: astore 22
    //   224: aload_2
    //   225: astore 11
    //   227: goto -111 -> 116
    //   230: astore 23
    //   232: aload 9
    //   234: iconst_1
    //   235: invokeinterface 424 2 0
    //   240: istore 24
    //   242: aload 4
    //   244: invokeinterface 428 1 0
    //   249: astore 25
    //   251: aload 23
    //   253: athrow
    //   254: astore 26
    //   256: aload_3
    //   257: monitorexit
    //   258: aload 26
    //   260: athrow
    //   261: aload_1
    //   262: invokevirtual 452	org/json/JSONArray:length	()I
    //   265: istore 27
    //   267: iload 27
    //   269: bipush 100
    //   271: if_icmple +96 -> 367
    //   274: new 383	org/json/JSONArray
    //   277: dup
    //   278: invokespecial 384	org/json/JSONArray:<init>	()V
    //   281: astore 28
    //   283: iload 27
    //   285: bipush 156
    //   287: iadd
    //   288: astore_3
    //   289: aload_3
    //   290: iload 27
    //   292: if_icmpge +78 -> 370
    //   295: aload_1
    //   296: aload_3
    //   297: invokevirtual 455	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   300: astore 29
    //   302: aload 28
    //   304: aload 29
    //   306: invokevirtual 441	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   309: astore 30
    //   311: aload_3
    //   312: iconst_1
    //   313: iadd
    //   314: istore_3
    //   315: goto -26 -> 289
    //   318: astore 31
    //   320: new 55	java/lang/StringBuilder
    //   323: dup
    //   324: ldc_w 457
    //   327: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   330: astore 32
    //   332: aload 31
    //   334: invokevirtual 164	java/lang/Object:getClass	()Ljava/lang/Class;
    //   337: invokevirtual 169	java/lang/Class:getName	()Ljava/lang/String;
    //   340: astore 33
    //   342: aload 32
    //   344: aload 33
    //   346: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 34
    //   354: aload 31
    //   356: invokevirtual 459	org/json/JSONException:printStackTrace	()V
    //   359: goto -48 -> 311
    //   362: astore 35
    //   364: goto -163 -> 201
    //   367: aload_1
    //   368: astore 28
    //   370: aload 28
    //   372: areturn
    //   373: aload_2
    //   374: astore 11
    //   376: goto -281 -> 95
    //
    // Exception table:
    //   from	to	target	type
    //   67	95	181	java/lang/Exception
    //   67	95	230	finally
    //   183	191	230	finally
    //   196	201	230	finally
    //   23	63	254	finally
    //   97	118	254	finally
    //   204	254	254	finally
    //   295	311	318	org/json/JSONException
    //   196	201	362	java/lang/InterruptedException
  }

  private float n()
  {
    try
    {
      float f1 = this.l.getResources().getDisplayMetrics().ydpi;
      label14: return f1;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }

  // ERROR //
  private String o()
  {
    // Byte code:
    //   0: new 289	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 290	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: new 289	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 290	org/json/JSONObject:<init>	()V
    //   15: astore_2
    //   16: new 130	java/lang/String
    //   19: dup
    //   20: invokespecial 131	java/lang/String:<init>	()V
    //   23: astore_3
    //   24: aload_0
    //   25: invokevirtual 482	crittercism/android/b:c	()Ljava/util/List;
    //   28: astore 4
    //   30: aload 4
    //   32: iconst_0
    //   33: invokeinterface 356 2 0
    //   38: checkcast 484	org/apache/http/NameValuePair
    //   41: invokeinterface 487 1 0
    //   46: astore 5
    //   48: aload_2
    //   49: ldc_w 489
    //   52: aload 5
    //   54: invokevirtual 492	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: astore 6
    //   59: aload 4
    //   61: iconst_1
    //   62: invokeinterface 356 2 0
    //   67: checkcast 484	org/apache/http/NameValuePair
    //   70: invokeinterface 487 1 0
    //   75: astore 7
    //   77: aload_2
    //   78: ldc_w 494
    //   81: aload 7
    //   83: invokevirtual 492	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: astore 8
    //   88: aload 4
    //   90: iconst_2
    //   91: invokeinterface 356 2 0
    //   96: checkcast 484	org/apache/http/NameValuePair
    //   99: invokeinterface 487 1 0
    //   104: astore 9
    //   106: aload_2
    //   107: ldc_w 496
    //   110: aload 9
    //   112: invokevirtual 492	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: astore 10
    //   117: aload 4
    //   119: iconst_3
    //   120: invokeinterface 356 2 0
    //   125: checkcast 484	org/apache/http/NameValuePair
    //   128: invokeinterface 487 1 0
    //   133: astore 11
    //   135: aload_2
    //   136: ldc_w 498
    //   139: aload 11
    //   141: invokevirtual 492	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   144: astore 12
    //   146: aload 4
    //   148: iconst_4
    //   149: invokeinterface 356 2 0
    //   154: checkcast 484	org/apache/http/NameValuePair
    //   157: invokeinterface 487 1 0
    //   162: astore 13
    //   164: aload_2
    //   165: ldc_w 500
    //   168: aload 13
    //   170: invokevirtual 492	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: astore 14
    //   175: aload_0
    //   176: getfield 91	crittercism/android/b:l	Landroid/content/Context;
    //   179: invokevirtual 217	android/content/Context:getPackageName	()Ljava/lang/String;
    //   182: astore 15
    //   184: aload_2
    //   185: ldc_w 502
    //   188: aload 15
    //   190: invokevirtual 492	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: astore 16
    //   195: aload_0
    //   196: getfield 89	crittercism/android/b:k	Lcrittercism/android/c;
    //   199: astore 17
    //   201: aload_0
    //   202: getfield 87	crittercism/android/b:j	Ljava/lang/String;
    //   205: astore 18
    //   207: aload 17
    //   209: aload 18
    //   211: aload_2
    //   212: invokevirtual 505	crittercism/android/c:a	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   215: astore 19
    //   217: aload 19
    //   219: astore 20
    //   221: aload 20
    //   223: ifnull +143 -> 366
    //   226: aload 20
    //   228: ldc 93
    //   230: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifne +133 -> 366
    //   236: new 289	org/json/JSONObject
    //   239: dup
    //   240: aload 20
    //   242: invokespecial 506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   245: astore_3
    //   246: aload_3
    //   247: ldc_w 508
    //   250: invokevirtual 512	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   253: ifeq +116 -> 369
    //   256: aload_3
    //   257: ldc_w 508
    //   260: invokevirtual 515	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   263: iconst_1
    //   264: if_icmpne +102 -> 366
    //   267: new 55	java/lang/StringBuilder
    //   270: dup
    //   271: ldc_w 517
    //   274: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: astore 21
    //   279: aload_3
    //   280: ldc_w 489
    //   283: invokevirtual 519	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: astore 22
    //   288: aload 21
    //   290: aload 22
    //   292: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: astore 23
    //   300: new 55	java/lang/StringBuilder
    //   303: dup
    //   304: ldc_w 521
    //   307: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   310: astore 24
    //   312: aload_3
    //   313: ldc_w 502
    //   316: invokevirtual 519	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   319: astore 25
    //   321: aload 24
    //   323: aload 25
    //   325: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: astore 26
    //   333: new 55	java/lang/StringBuilder
    //   336: dup
    //   337: ldc_w 523
    //   340: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: astore 27
    //   345: aload_3
    //   346: ldc_w 525
    //   349: invokevirtual 529	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   352: astore 28
    //   354: aload 27
    //   356: aload 28
    //   358: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: astore 29
    //   366: aload 20
    //   368: areturn
    //   369: new 55	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   376: astore 30
    //   378: aload_0
    //   379: getfield 87	crittercism/android/b:j	Ljava/lang/String;
    //   382: astore 31
    //   384: aload 30
    //   386: aload 31
    //   388: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc_w 534
    //   394: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 20
    //   399: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: astore 32
    //   407: goto -41 -> 366
    //   410: astore 33
    //   412: goto -46 -> 366
    //   415: astore 34
    //   417: aload_3
    //   418: astore 20
    //   420: aload 34
    //   422: astore_3
    //   423: aload_3
    //   424: invokevirtual 459	org/json/JSONException:printStackTrace	()V
    //   427: goto -61 -> 366
    //   430: astore 35
    //   432: aload_3
    //   433: astore 20
    //   435: aload 35
    //   437: astore_3
    //   438: new 55	java/lang/StringBuilder
    //   441: dup
    //   442: ldc_w 536
    //   445: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   448: astore 36
    //   450: aload_3
    //   451: invokevirtual 164	java/lang/Object:getClass	()Ljava/lang/Class;
    //   454: invokevirtual 169	java/lang/Class:getName	()Ljava/lang/String;
    //   457: astore 37
    //   459: aload 36
    //   461: aload 37
    //   463: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: astore 38
    //   471: aload_3
    //   472: invokevirtual 537	java/lang/Exception:printStackTrace	()V
    //   475: goto -109 -> 366
    //   478: astore_3
    //   479: goto -41 -> 438
    //   482: astore_3
    //   483: goto -60 -> 423
    //   486: astore 39
    //   488: aload_3
    //   489: astore 20
    //   491: goto -125 -> 366
    //   494: astore 40
    //   496: goto -130 -> 366
    //   499: astore 41
    //   501: aload_3
    //   502: astore 20
    //   504: goto -138 -> 366
    //
    // Exception table:
    //   from	to	target	type
    //   226	407	410	crittercism/android/g
    //   24	217	415	org/json/JSONException
    //   24	217	430	java/lang/Exception
    //   226	407	478	java/lang/Exception
    //   226	407	482	org/json/JSONException
    //   24	217	486	java/io/IOException
    //   226	407	494	java/io/IOException
    //   24	217	499	crittercism/android/g
  }

  private boolean p()
  {
    int i1 = 30;
    try
    {
      while ((!this.t) && (i1 > 0))
      {
        i1 += -1;
        Thread.sleep(1000L);
      }
    }
    catch (Exception localException)
    {
    }
    return this.t;
  }

  public final String a()
  {
    return this.m;
  }

  // ERROR //
  public final JSONObject a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 130	java/lang/String
    //   3: dup
    //   4: invokespecial 131	java/lang/String:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: ldc_w 542
    //   12: invokevirtual 519	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_1
    //   17: ldc_w 544
    //   20: invokevirtual 529	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   23: astore 4
    //   25: new 130	java/lang/String
    //   28: dup
    //   29: invokespecial 131	java/lang/String:<init>	()V
    //   32: astore 5
    //   34: getstatic 547	crittercism/android/a$d:c	Ljava/lang/String;
    //   37: astore 6
    //   39: aload_3
    //   40: aload 6
    //   42: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +132 -> 177
    //   48: new 55	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 549
    //   55: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_3
    //   59: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore 7
    //   67: new 55	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 551
    //   74: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: astore 8
    //   79: aload 4
    //   81: invokevirtual 552	org/json/JSONObject:toString	()Ljava/lang/String;
    //   84: astore 9
    //   86: aload 8
    //   88: aload 9
    //   90: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore 10
    //   98: aload_0
    //   99: getfield 89	crittercism/android/b:k	Lcrittercism/android/c;
    //   102: aload_3
    //   103: ldc_w 554
    //   106: aload 4
    //   108: invokevirtual 557	crittercism/android/c:a	(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   111: astore 11
    //   113: aload 11
    //   115: astore 12
    //   117: new 55	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 559
    //   124: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload 12
    //   129: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore 13
    //   137: new 289	org/json/JSONObject
    //   140: dup
    //   141: invokespecial 290	org/json/JSONObject:<init>	()V
    //   144: astore 4
    //   146: aload 12
    //   148: ifnull +106 -> 254
    //   151: aload 12
    //   153: ldc 93
    //   155: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   158: ifne +96 -> 254
    //   161: new 289	org/json/JSONObject
    //   164: dup
    //   165: aload 12
    //   167: invokespecial 506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   170: astore_2
    //   171: aload_2
    //   172: astore 14
    //   174: aload 14
    //   176: areturn
    //   177: new 289	org/json/JSONObject
    //   180: dup
    //   181: invokespecial 290	org/json/JSONObject:<init>	()V
    //   184: astore 14
    //   186: goto -12 -> 174
    //   189: astore 15
    //   191: aload_2
    //   192: astore 12
    //   194: aload 15
    //   196: astore_2
    //   197: aload_2
    //   198: invokevirtual 459	org/json/JSONException:printStackTrace	()V
    //   201: goto -64 -> 137
    //   204: astore 16
    //   206: aload_2
    //   207: astore 12
    //   209: aload 16
    //   211: astore_2
    //   212: new 55	java/lang/StringBuilder
    //   215: dup
    //   216: ldc_w 561
    //   219: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: astore 17
    //   224: aload_2
    //   225: invokevirtual 164	java/lang/Object:getClass	()Ljava/lang/Class;
    //   228: invokevirtual 169	java/lang/Class:getName	()Ljava/lang/String;
    //   231: astore 18
    //   233: aload 17
    //   235: aload 18
    //   237: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: astore 19
    //   245: aload_2
    //   246: invokevirtual 537	java/lang/Exception:printStackTrace	()V
    //   249: goto -112 -> 137
    //   252: astore 20
    //   254: aload 4
    //   256: astore 14
    //   258: goto -84 -> 174
    //   261: astore_2
    //   262: goto -50 -> 212
    //   265: astore_2
    //   266: goto -69 -> 197
    //
    // Exception table:
    //   from	to	target	type
    //   8	113	189	org/json/JSONException
    //   177	186	189	org/json/JSONException
    //   8	113	204	java/lang/Exception
    //   177	186	204	java/lang/Exception
    //   161	171	252	java/lang/Exception
    //   117	137	261	java/lang/Exception
    //   117	137	265	org/json/JSONException
  }

  public final JSONObject a(boolean[] paramArrayOfBoolean)
  {
    String str1 = null;
    int i1 = 1;
    if (paramArrayOfBoolean.length > 0);
    for (int i2 = paramArrayOfBoolean[0]; ; i2 = 1)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        double d1 = g();
        JSONObject localJSONObject2 = localJSONObject1.put("battery_level", d1);
        long l1 = h();
        JSONObject localJSONObject3 = localJSONObject1.put("memory_usage", l1);
        String str2 = "low_memory";
        ActivityManager localActivityManager = (ActivityManager)this.l.getSystemService("activity");
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        localActivityManager.getMemoryInfo(localMemoryInfo);
        int i3;
        if (localMemoryInfo.lowMemory)
          i3 = null;
        while (true)
        {
          JSONObject localJSONObject4 = localJSONObject1.put(str2, i3);
          String str3 = a.b(this.l);
          JSONObject localJSONObject5 = localJSONObject1.put("locale", str3);
          double d2 = d();
          JSONObject localJSONObject6 = localJSONObject1.put("dpi", d2);
          double d3 = e();
          JSONObject localJSONObject7 = localJSONObject1.put("xdpi", d3);
          double d4 = n();
          JSONObject localJSONObject8 = localJSONObject1.put("ydpi", d4);
          JSONObject localJSONObject9 = localJSONObject1.put("name", "");
          JSONObject localJSONObject10 = localJSONObject1.put("system", "android");
          if (c("android.permission.ACCESS_NETWORK_STATE") == 0)
          {
            JSONObject localJSONObject11 = j();
            JSONObject localJSONObject12 = localJSONObject1.put("wifi", localJSONObject11);
            JSONObject localJSONObject13 = k();
            JSONObject localJSONObject14 = localJSONObject1.put("mobile_network", localJSONObject13);
          }
          String str4 = Build.MODEL;
          JSONObject localJSONObject15 = localJSONObject1.put("model", str4);
          String str5 = i();
          JSONObject localJSONObject16 = localJSONObject1.put("carrier", str5);
          String str6 = this.p;
          JSONObject localJSONObject17 = localJSONObject1.put("app_version", str6);
          String str7 = Build.VERSION.RELEASE;
          JSONObject localJSONObject18 = localJSONObject1.put("system_version", str7);
          String str8 = j.a().toString();
          JSONObject localJSONObject19 = localJSONObject1.put("disk_space_free", str8);
          String str9 = j.b().toString();
          JSONObject localJSONObject20 = localJSONObject1.put("disk_space_total", str9);
          String str10 = j.c().toString();
          JSONObject localJSONObject21 = localJSONObject1.put("sd_space_free", str10);
          String str11 = j.d().toString();
          JSONObject localJSONObject22 = localJSONObject1.put("sd_space_total", str11);
          str1 = "orientation";
          i3 = this.l.getResources().getConfiguration().orientation;
          if (i3 == 0)
          {
            int i4 = ((WindowManager)this.l.getSystemService("window")).getDefaultDisplay();
            int i5 = i4.getWidth();
            int i6 = i4.getHeight();
            if (i5 != i6)
            {
              i1 = 3;
              label482: JSONObject localJSONObject23 = localJSONObject1.put(str1, i1);
              String str12 = l();
              JSONObject localJSONObject24 = localJSONObject1.put("activity", str12);
              if ((c("android.permission.READ_LOGS") == 0) && (i2 != null))
              {
                localJSONArray = m();
                int i7 = localJSONArray.length();
                if (i7 <= 0);
              }
            }
            try
            {
              JSONObject localJSONObject25 = localJSONObject1.put("logcat", localJSONArray);
              return localJSONObject1;
              localJSONArray = null;
              continue;
              int i8 = localJSONArray.getWidth();
              int i9 = localJSONArray.getHeight();
              if (i8 <= i9)
                break label482;
              i1 = 2;
            }
            catch (Exception localException1)
            {
              while (true)
              {
                StringBuilder localStringBuilder1 = new StringBuilder("put logcat EXCEPTION: ");
                String str13 = localException1.getClass().getName();
                String str14 = str13;
              }
            }
          }
        }
      }
      catch (Exception localException2)
      {
        while (true)
        {
          JSONArray localJSONArray;
          StringBuilder localStringBuilder2 = new StringBuilder("Exception with getStateInfo(): ");
          String str15 = localException2.getClass().getName();
          String str16 = str15;
          localException2.printStackTrace();
          continue;
          i1 = localJSONArray;
        }
      }
    }
  }

  public final void a(Exception paramException)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = c();
    BasicNameValuePair localBasicNameValuePair1 = new BasicNameValuePair("platform", "android");
    boolean bool1 = localList.add(localBasicNameValuePair1);
    String str1 = paramException.getClass().getName();
    BasicNameValuePair localBasicNameValuePair2 = new BasicNameValuePair("exception_name", str1);
    boolean bool2 = localList.add(localBasicNameValuePair2);
    boolean[] arrayOfBoolean = new boolean[i1];
    String str2 = a(arrayOfBoolean).toString();
    BasicNameValuePair localBasicNameValuePair3 = new BasicNameValuePair("state", str2);
    boolean bool3 = localList.add(localBasicNameValuePair3);
    JSONArray localJSONArray1 = new JSONArray();
    String[] arrayOfString = b(paramException).split("\n");
    while (true)
    {
      int i2 = arrayOfString.length;
      if (i1 >= i2)
        break;
      String str3 = arrayOfString[i1];
      JSONArray localJSONArray2 = localJSONArray1.put(str3);
      i1 += 1;
    }
    String str4 = localJSONArray1.toString();
    BasicNameValuePair localBasicNameValuePair4 = new BasicNameValuePair("stacktrace", str4);
    boolean bool4 = localList.add(localBasicNameValuePair4);
    try
    {
      c localc = this.k;
      String str5 = this.i;
      String str6 = localc.a(str5, localList);
      if (str6 == null)
        return;
      if (str6 == "")
        return;
      JSONObject localJSONObject = new JSONObject(str6);
      int i3 = localJSONObject.getInt("need_lib_version");
      int i4 = localJSONObject.getInt("need_platform");
      int i5 = localJSONObject.getInt("success");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Exception in logCritterError: ");
      String str7 = localException.getClass().getName();
      String str8 = str7;
    }
  }

  public final void a(String paramString)
  {
    this.n = paramString;
  }

  public final boolean a(e parame)
  {
    boolean bool = false;
    try
    {
      c localc = this.k;
      String str1 = this.g;
      JSONObject localJSONObject1 = parame.b;
      String str2 = localc.a(str1, localJSONObject1);
      if ((str2 != null) && (str2 != ""))
      {
        JSONObject localJSONObject2 = new JSONObject(str2);
        bool = true;
      }
      return bool;
    }
    catch (g localg)
    {
      String str3 = b.class.getCanonicalName();
      g.a locala1 = localg.a();
      g.a locala2 = g.a.a;
      if (locala1 == locala2)
      {
        Iterator localIterator = this.s.iterator();
        while (localIterator.hasNext())
        {
          NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
          String str4 = b.class.getCanonicalName();
          StringBuilder localStringBuilder1 = new StringBuilder("Name: ");
          String str5 = localNameValuePair.getName();
          StringBuilder localStringBuilder2 = localStringBuilder1.append(str5).append("\t Value: ");
          String str6 = localNameValuePair.getValue();
          String str7 = str6;
        }
      }
      throw localg;
    }
    catch (SocketException localSocketException)
    {
      String str8 = a.a(10);
      g.a locala3 = g.a.a;
      throw new g(str8, locala3);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder3 = new StringBuilder("Weird. Some other exception...");
      String str9 = localException.getClass().getName();
      String str10 = str9;
      String str11 = a.a(13);
      g.a locala4 = g.a.d;
      throw new g(str11, locala4);
    }
  }

  public final String b()
  {
    Object localObject = Settings.Secure.getString(this.l.getContentResolver(), "android_id");
    if ((localObject != null) && (!((String)localObject).equals("")) && (!"9774d56d682e549c".equals(localObject)));
    while (true)
    {
      try
      {
        localObject = UUID.nameUUIDFromBytes(((String)localObject).getBytes("utf8"));
        if (localObject != null)
        {
          String str1 = ((UUID)localObject).toString();
          str2 = str1;
          if ((str2 != null) && (str2.equals("")))
            str2 = null;
          if (str2 == null)
          {
            PackageManager localPackageManager = this.l.getPackageManager();
            String str3 = Crittercism.a().d();
            if (localPackageManager.checkPermission("android.permission.READ_PHONE_STATE", str3) == 0)
              str2 = b(((TelephonyManager)this.l.getSystemService("phone")).getDeviceId());
          }
          if (str2 == null)
            str2 = UUID.randomUUID().toString();
          return str2;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        str2 = null;
        continue;
      }
      String str2 = null;
    }
  }

  /** @deprecated */
  // ERROR //
  public final boolean b(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ldc_w 822
    //   8: invokevirtual 512	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11: ifeq +122 -> 133
    //   14: aload_1
    //   15: ldc_w 822
    //   18: invokevirtual 519	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_3
    //   22: aload_0
    //   23: aload_3
    //   24: putfield 120	crittercism/android/b:u	Ljava/lang/String;
    //   27: aload_0
    //   28: invokespecial 824	crittercism/android/b:p	()Z
    //   31: ifeq +158 -> 189
    //   34: aload_0
    //   35: invokevirtual 482	crittercism/android/b:c	()Ljava/util/List;
    //   38: astore 4
    //   40: aload_1
    //   41: invokevirtual 552	org/json/JSONObject:toString	()Ljava/lang/String;
    //   44: astore 5
    //   46: new 703	org/apache/http/message/BasicNameValuePair
    //   49: dup
    //   50: ldc_w 826
    //   53: aload 5
    //   55: invokespecial 708	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: astore 6
    //   60: aload 4
    //   62: aload 6
    //   64: invokeinterface 711 2 0
    //   69: istore 7
    //   71: aload_0
    //   72: getfield 89	crittercism/android/b:k	Lcrittercism/android/c;
    //   75: astore 8
    //   77: aload_0
    //   78: getfield 79	crittercism/android/b:h	Ljava/lang/String;
    //   81: astore 9
    //   83: aload 8
    //   85: aload 9
    //   87: aload 4
    //   89: invokevirtual 725	crittercism/android/c:a	(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    //   92: astore 10
    //   94: aload 10
    //   96: ifnull +93 -> 189
    //   99: aload 10
    //   101: ldc 93
    //   103: if_acmpeq +86 -> 189
    //   106: new 289	org/json/JSONObject
    //   109: dup
    //   110: aload 10
    //   112: invokespecial 506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   115: ldc_w 508
    //   118: invokevirtual 515	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   121: istore 11
    //   123: iload 11
    //   125: iconst_1
    //   126: if_icmpne +63 -> 189
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_2
    //   132: ireturn
    //   133: aload_0
    //   134: getfield 120	crittercism/android/b:u	Ljava/lang/String;
    //   137: ldc 93
    //   139: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifne -115 -> 27
    //   145: aload_0
    //   146: getfield 120	crittercism/android/b:u	Ljava/lang/String;
    //   149: astore 12
    //   151: aload_1
    //   152: ldc_w 822
    //   155: aload 12
    //   157: invokevirtual 492	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   160: astore 13
    //   162: goto -135 -> 27
    //   165: astore_2
    //   166: aload_2
    //   167: athrow
    //   168: astore 14
    //   170: aload_0
    //   171: monitorexit
    //   172: aload 14
    //   174: athrow
    //   175: astore_2
    //   176: ldc 2
    //   178: invokevirtual 328	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   181: astore 15
    //   183: aload_2
    //   184: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   187: astore 16
    //   189: iconst_0
    //   190: istore_2
    //   191: goto -62 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   4	123	165	crittercism/android/g
    //   133	162	165	crittercism/android/g
    //   4	123	168	finally
    //   133	162	168	finally
    //   166	168	168	finally
    //   176	189	168	finally
    //   4	123	175	java/lang/Exception
    //   133	162	175	java/lang/Exception
  }

  public final List c()
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = this.m;
    BasicNameValuePair localBasicNameValuePair1 = new BasicNameValuePair("app_id", str1);
    boolean bool1 = localArrayList.add(localBasicNameValuePair1);
    if (this.n == null)
    {
      String str2 = b();
      this.n = str2;
    }
    String str3 = this.n;
    BasicNameValuePair localBasicNameValuePair2 = new BasicNameValuePair("did", str3);
    boolean bool2 = localArrayList.add(localBasicNameValuePair2);
    BasicNameValuePair localBasicNameValuePair3 = new BasicNameValuePair("device_name", "android");
    boolean bool3 = localArrayList.add(localBasicNameValuePair3);
    String str4 = this.o;
    BasicNameValuePair localBasicNameValuePair4 = new BasicNameValuePair("lib_version", str4);
    boolean bool4 = localArrayList.add(localBasicNameValuePair4);
    String str5 = this.q;
    BasicNameValuePair localBasicNameValuePair5 = new BasicNameValuePair("key", str5);
    boolean bool5 = localArrayList.add(localBasicNameValuePair5);
    return localArrayList;
  }

  public final float d()
  {
    try
    {
      float f1 = this.l.getResources().getDisplayMetrics().density;
      label14: return f1;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }

  public final float e()
  {
    try
    {
      float f1 = this.l.getResources().getDisplayMetrics().xdpi;
      label14: return f1;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }

  // ERROR //
  public final i f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 482	crittercism/android/b:c	()Ljava/util/List;
    //   6: astore_2
    //   7: iconst_1
    //   8: newarray boolean
    //   10: astore_3
    //   11: aload_3
    //   12: iconst_0
    //   13: iconst_0
    //   14: bastore
    //   15: aload_0
    //   16: aload_3
    //   17: invokevirtual 715	crittercism/android/b:a	([Z)Lorg/json/JSONObject;
    //   20: invokevirtual 552	org/json/JSONObject:toString	()Ljava/lang/String;
    //   23: astore 4
    //   25: new 703	org/apache/http/message/BasicNameValuePair
    //   28: dup
    //   29: ldc_w 717
    //   32: aload 4
    //   34: invokespecial 708	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload_2
    //   40: aload 5
    //   42: invokeinterface 711 2 0
    //   47: istore 6
    //   49: aload_0
    //   50: getfield 89	crittercism/android/b:k	Lcrittercism/android/c;
    //   53: astore 7
    //   55: aload_0
    //   56: getfield 67	crittercism/android/b:e	Ljava/lang/String;
    //   59: astore 8
    //   61: aload 7
    //   63: aload 8
    //   65: aload_2
    //   66: invokevirtual 725	crittercism/android/c:a	(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    //   69: astore 9
    //   71: aload 9
    //   73: ifnull +238 -> 311
    //   76: aload 9
    //   78: ldc 93
    //   80: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne +228 -> 311
    //   86: new 289	org/json/JSONObject
    //   89: dup
    //   90: aload 9
    //   92: invokespecial 506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   95: astore 10
    //   97: aload 10
    //   99: ldc_w 839
    //   102: invokevirtual 529	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   105: invokevirtual 552	org/json/JSONObject:toString	()Ljava/lang/String;
    //   108: astore 11
    //   110: aload 10
    //   112: ldc_w 508
    //   115: invokevirtual 515	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   118: iconst_1
    //   119: if_icmpne +192 -> 311
    //   122: aload 10
    //   124: ldc_w 841
    //   127: invokevirtual 512	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   130: ifeq +181 -> 311
    //   133: aload_0
    //   134: iconst_1
    //   135: putfield 118	crittercism/android/b:t	Z
    //   138: aload 10
    //   140: ldc_w 841
    //   143: invokevirtual 529	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   146: invokestatic 846	crittercism/android/f:a	(Lorg/json/JSONObject;)Lcrittercism/android/f;
    //   149: astore 12
    //   151: aload 12
    //   153: astore 9
    //   155: aload 10
    //   157: ldc_w 839
    //   160: invokevirtual 512	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   163: ifeq +101 -> 264
    //   166: aload 10
    //   168: ldc_w 839
    //   171: invokevirtual 529	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   174: astore_1
    //   175: aload_1
    //   176: ldc_w 848
    //   179: invokevirtual 512	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   182: ifeq +82 -> 264
    //   185: aload_1
    //   186: ldc_w 848
    //   189: invokevirtual 529	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   192: astore 13
    //   194: aload 13
    //   196: ldc_w 850
    //   199: invokevirtual 512	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   202: ifeq +62 -> 264
    //   205: new 55	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 852
    //   212: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: astore 14
    //   217: aload 13
    //   219: ldc_w 850
    //   222: invokevirtual 515	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   225: iconst_1
    //   226: if_icmpne +49 -> 275
    //   229: ldc_w 854
    //   232: astore 10
    //   234: aload 14
    //   236: aload 10
    //   238: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore 15
    //   246: aload 13
    //   248: ldc_w 850
    //   251: invokevirtual 515	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   254: iconst_1
    //   255: if_icmpne +9 -> 264
    //   258: aload_0
    //   259: invokespecial 856	crittercism/android/b:o	()Ljava/lang/String;
    //   262: astore 16
    //   264: new 858	crittercism/android/i
    //   267: dup
    //   268: aload_1
    //   269: aload 9
    //   271: invokespecial 861	crittercism/android/i:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   274: areturn
    //   275: ldc_w 863
    //   278: astore 10
    //   280: goto -46 -> 234
    //   283: athrow
    //   284: astore 10
    //   286: aconst_null
    //   287: astore 9
    //   289: ldc 2
    //   291: invokevirtual 328	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   294: astore 17
    //   296: aload 10
    //   298: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   301: astore 18
    //   303: goto -39 -> 264
    //   306: astore 10
    //   308: goto -19 -> 289
    //   311: aconst_null
    //   312: astore 9
    //   314: goto -50 -> 264
    //
    // Exception table:
    //   from	to	target	type
    //   2	151	283	crittercism/android/g
    //   155	264	283	crittercism/android/g
    //   275	280	283	crittercism/android/g
    //   2	151	284	java/lang/Exception
    //   155	264	306	java/lang/Exception
    //   275	280	306	java/lang/Exception
  }

  static class a
    implements Callable
  {
    private static boolean d = false;
    private static Object f;
    private StringBuilder a;
    private StringBuilder b;
    private String[] c;
    private Process e;
    private Thread g;
    private b.b h;
    private b.b i;

    public a(Object paramObject, Thread paramThread)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      this.a = localStringBuilder1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      this.b = localStringBuilder2;
      this.e = null;
      f = paramObject;
      this.g = paramThread;
      if (Build.VERSION.SDK_INT >= 8)
      {
        String[] arrayOfString1 = new String[5];
        this.c = arrayOfString1;
        this.c[0] = "logcat";
        this.c[1] = "-t";
        this.c[2] = "100";
        this.c[3] = "-v";
        this.c[4] = "time";
        return;
      }
      String[] arrayOfString2 = new String[4];
      this.c = arrayOfString2;
      this.c[0] = "logcat";
      this.c[1] = "-d";
      this.c[2] = "-v";
      this.c[3] = "time";
    }

    public static boolean a()
    {
      return d;
    }

    public static void b()
    {
      d = true;
    }

    // ERROR //
    private StringBuilder d()
    {
      // Byte code:
      //   0: aload_0
      //   1: aconst_null
      //   2: putfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   5: aload_0
      //   6: aconst_null
      //   7: putfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   10: getstatic 28	crittercism/android/b$a:d	Z
      //   13: ifne +186 -> 199
      //   16: invokestatic 81	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   19: astore_1
      //   20: aload_0
      //   21: getfield 55	crittercism/android/b$a:c	[Ljava/lang/String;
      //   24: astore_2
      //   25: aload_1
      //   26: aload_2
      //   27: invokevirtual 85	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
      //   30: astore_3
      //   31: aload_0
      //   32: aload_3
      //   33: putfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   36: aload_0
      //   37: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   40: invokevirtual 91	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   43: astore 4
      //   45: new 93	crittercism/android/b$b
      //   48: dup
      //   49: aload 4
      //   51: invokespecial 96	crittercism/android/b$b:<init>	(Ljava/io/InputStream;)V
      //   54: astore 5
      //   56: aload_0
      //   57: aload 5
      //   59: putfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   62: aload_0
      //   63: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   66: invokevirtual 99	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   69: astore 6
      //   71: new 93	crittercism/android/b$b
      //   74: dup
      //   75: aload 6
      //   77: invokespecial 96	crittercism/android/b$b:<init>	(Ljava/io/InputStream;)V
      //   80: astore 7
      //   82: aload_0
      //   83: aload 7
      //   85: putfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   88: aload_0
      //   89: getfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   92: invokevirtual 102	crittercism/android/b$b:start	()V
      //   95: aload_0
      //   96: getfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   99: invokevirtual 102	crittercism/android/b$b:start	()V
      //   102: aload_0
      //   103: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   106: invokevirtual 106	java/lang/Process:waitFor	()I
      //   109: istore 8
      //   111: aload_0
      //   112: getfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   115: ifnull +18 -> 133
      //   118: aload_0
      //   119: getfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   122: invokevirtual 108	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   125: astore 9
      //   127: aload_0
      //   128: aload 9
      //   130: putfield 37	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   133: aload_0
      //   134: getfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   137: ifnull +18 -> 155
      //   140: aload_0
      //   141: getfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   144: invokevirtual 108	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   147: astore 10
      //   149: aload_0
      //   150: aload 10
      //   152: putfield 39	crittercism/android/b$a:b	Ljava/lang/StringBuilder;
      //   155: aload_0
      //   156: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   159: ifnull +40 -> 199
      //   162: aload_0
      //   163: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   166: invokevirtual 91	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   169: invokevirtual 113	java/io/InputStream:close	()V
      //   172: aload_0
      //   173: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   176: invokevirtual 99	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   179: invokevirtual 113	java/io/InputStream:close	()V
      //   182: aload_0
      //   183: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   186: invokevirtual 117	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   189: invokevirtual 120	java/io/OutputStream:close	()V
      //   192: aload_0
      //   193: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   196: invokevirtual 123	java/lang/Process:destroy	()V
      //   199: aload_0
      //   200: getfield 37	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   203: areturn
      //   204: astore 11
      //   206: iconst_1
      //   207: istore 12
      //   209: iload 12
      //   211: putstatic 28	crittercism/android/b$a:d	Z
      //   214: aload_0
      //   215: getfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   218: ifnull +18 -> 236
      //   221: aload_0
      //   222: getfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   225: invokevirtual 108	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   228: astore 13
      //   230: aload_0
      //   231: aload 13
      //   233: putfield 37	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   236: aload_0
      //   237: getfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   240: ifnull +18 -> 258
      //   243: aload_0
      //   244: getfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   247: invokevirtual 108	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   250: astore 14
      //   252: aload_0
      //   253: aload 14
      //   255: putfield 39	crittercism/android/b$a:b	Ljava/lang/StringBuilder;
      //   258: aload_0
      //   259: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   262: ifnull -63 -> 199
      //   265: aload_0
      //   266: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   269: invokevirtual 91	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   272: invokevirtual 113	java/io/InputStream:close	()V
      //   275: aload_0
      //   276: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   279: invokevirtual 99	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   282: invokevirtual 113	java/io/InputStream:close	()V
      //   285: aload_0
      //   286: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   289: invokevirtual 117	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   292: invokevirtual 120	java/io/OutputStream:close	()V
      //   295: aload_0
      //   296: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   299: invokevirtual 123	java/lang/Process:destroy	()V
      //   302: goto -103 -> 199
      //   305: astore 15
      //   307: goto -108 -> 199
      //   310: astore 16
      //   312: aload_0
      //   313: getfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   316: ifnull +18 -> 334
      //   319: aload_0
      //   320: getfield 73	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   323: invokevirtual 108	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   326: astore 17
      //   328: aload_0
      //   329: aload 17
      //   331: putfield 37	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   334: aload_0
      //   335: getfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   338: ifnull +18 -> 356
      //   341: aload_0
      //   342: getfield 75	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   345: invokevirtual 108	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   348: astore 18
      //   350: aload_0
      //   351: aload 18
      //   353: putfield 39	crittercism/android/b$a:b	Ljava/lang/StringBuilder;
      //   356: aload_0
      //   357: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   360: ifnull +40 -> 400
      //   363: aload_0
      //   364: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   367: invokevirtual 91	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   370: invokevirtual 113	java/io/InputStream:close	()V
      //   373: aload_0
      //   374: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   377: invokevirtual 99	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   380: invokevirtual 113	java/io/InputStream:close	()V
      //   383: aload_0
      //   384: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   387: invokevirtual 117	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   390: invokevirtual 120	java/io/OutputStream:close	()V
      //   393: aload_0
      //   394: getfield 41	crittercism/android/b$a:e	Ljava/lang/Process;
      //   397: invokevirtual 123	java/lang/Process:destroy	()V
      //   400: aload 16
      //   402: athrow
      //   403: astore 19
      //   405: goto -5 -> 400
      //
      // Exception table:
      //   from	to	target	type
      //   16	111	204	java/lang/Exception
      //   162	199	305	java/lang/Exception
      //   265	302	305	java/lang/Exception
      //   16	111	310	finally
      //   209	214	310	finally
      //   363	400	403	java/lang/Exception
    }

    public final void c()
    {
      try
      {
        synchronized (f)
        {
          this.h.b();
          this.i.b();
          if (this.e != null)
          {
            this.e.getInputStream().close();
            this.e.getErrorStream().close();
            this.e.getOutputStream().close();
          }
          label57: if (this.e != null)
            this.e.destroy();
          return;
        }
      }
      catch (Exception localException)
      {
        break label57;
      }
    }
  }

  static class b extends Thread
  {
    private InputStream a;
    private StringBuilder b;
    private BufferedReader c;

    public b(InputStream paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      this.b = localStringBuilder;
      this.c = null;
      this.a = paramInputStream;
    }

    public final StringBuilder a()
    {
      return this.b;
    }

    public final void b()
    {
      if (this.c == null)
        return;
      try
      {
        this.c.close();
        return;
      }
      catch (Exception localException)
      {
        this.c = null;
      }
    }

    // ERROR //
    public final void run()
    {
      // Byte code:
      //   0: new 37	java/lang/String
      //   3: dup
      //   4: invokespecial 38	java/lang/String:<init>	()V
      //   7: astore_1
      //   8: aload_0
      //   9: getfield 26	crittercism/android/b$b:a	Ljava/io/InputStream;
      //   12: astore_2
      //   13: new 40	java/io/InputStreamReader
      //   16: dup
      //   17: aload_2
      //   18: invokespecial 42	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   21: astore_3
      //   22: new 31	java/io/BufferedReader
      //   25: dup
      //   26: aload_3
      //   27: invokespecial 45	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   30: astore 4
      //   32: aload_0
      //   33: aload 4
      //   35: putfield 24	crittercism/android/b$b:c	Ljava/io/BufferedReader;
      //   38: aload_0
      //   39: getfield 24	crittercism/android/b$b:c	Ljava/io/BufferedReader;
      //   42: invokevirtual 49	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   45: astore 5
      //   47: aload 5
      //   49: ifnull +38 -> 87
      //   52: aload_0
      //   53: getfield 22	crittercism/android/b$b:b	Ljava/lang/StringBuilder;
      //   56: aload 5
      //   58: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   61: astore 6
      //   63: aload_0
      //   64: getfield 22	crittercism/android/b$b:b	Ljava/lang/StringBuilder;
      //   67: ldc 55
      //   69: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: astore 7
      //   74: goto -36 -> 38
      //   77: astore 8
      //   79: aload_0
      //   80: getfield 24	crittercism/android/b$b:c	Ljava/io/BufferedReader;
      //   83: invokevirtual 34	java/io/BufferedReader:close	()V
      //   86: return
      //   87: aload_0
      //   88: getfield 24	crittercism/android/b$b:c	Ljava/io/BufferedReader;
      //   91: invokevirtual 34	java/io/BufferedReader:close	()V
      //   94: return
      //   95: astore 9
      //   97: new 19	java/lang/StringBuilder
      //   100: dup
      //   101: ldc 57
      //   103: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   106: astore 10
      //   108: aload 9
      //   110: invokevirtual 66	java/lang/Object:getClass	()Ljava/lang/Class;
      //   113: invokevirtual 71	java/lang/Class:getName	()Ljava/lang/String;
      //   116: astore 11
      //   118: aload 10
      //   120: aload 11
      //   122: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   125: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   128: astore 12
      //   130: return
      //   131: astore 13
      //   133: new 19	java/lang/StringBuilder
      //   136: dup
      //   137: ldc 57
      //   139: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   142: astore 14
      //   144: aload 13
      //   146: invokevirtual 66	java/lang/Object:getClass	()Ljava/lang/Class;
      //   149: invokevirtual 71	java/lang/Class:getName	()Ljava/lang/String;
      //   152: astore 15
      //   154: aload 14
      //   156: aload 15
      //   158: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   161: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   164: astore 16
      //   166: return
      //   167: astore 17
      //   169: aload_0
      //   170: getfield 24	crittercism/android/b$b:c	Ljava/io/BufferedReader;
      //   173: invokevirtual 34	java/io/BufferedReader:close	()V
      //   176: aload 17
      //   178: athrow
      //   179: astore 18
      //   181: new 19	java/lang/StringBuilder
      //   184: dup
      //   185: ldc 57
      //   187: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   190: astore 19
      //   192: aload 18
      //   194: invokevirtual 66	java/lang/Object:getClass	()Ljava/lang/Class;
      //   197: invokevirtual 71	java/lang/Class:getName	()Ljava/lang/String;
      //   200: astore 20
      //   202: aload 19
      //   204: aload 20
      //   206: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   209: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   212: astore 21
      //   214: goto -38 -> 176
      //
      // Exception table:
      //   from	to	target	type
      //   38	74	77	java/lang/Exception
      //   87	94	95	java/lang/Exception
      //   79	86	131	java/lang/Exception
      //   38	74	167	finally
      //   169	176	179	java/lang/Exception
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     crittercism.android.b
 * JD-Core Version:    0.6.2
 */