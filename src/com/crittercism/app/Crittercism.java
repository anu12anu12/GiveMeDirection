package com.crittercism.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import com.crittercism.NotificationActivity;
import com.crittercism.service.ICritter;
import com.crittercism.service.ICritter.a;
import crittercism.android.a;
import crittercism.android.a.d;
import crittercism.android.b;
import crittercism.android.d;
import crittercism.android.e;
import crittercism.android.f;
import crittercism.android.g;
import crittercism.android.i;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Crittercism
{
  public static final String a = d.b();
  private static Crittercism e = new Crittercism();
  boolean b;
  ICritter c;
  final Handler d;
  private b f;
  private d g;
  private f h = null;
  private boolean i = false;
  private Context j = null;
  private float k = 1.0F;
  private e l;
  private Vector m;
  private Vector n;
  private Date o;
  private int p;
  private boolean q;
  private boolean r;
  private Exception s;
  private String t;
  private String u;
  private String v;
  private boolean w;
  private ServiceConnection x;

  private Crittercism()
  {
    Vector localVector1 = new Vector();
    this.m = localVector1;
    Vector localVector2 = new Vector();
    this.n = localVector2;
    this.o = null;
    this.p = 0;
    this.q = false;
    this.r = false;
    this.s = null;
    this.t = "";
    this.u = "";
    this.v = "Developer Reply";
    this.w = true;
    this.b = false;
    this.c = null;
    Handler local2 = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        Bundle localBundle = paramAnonymousMessage.getData();
        if (!localBundle.containsKey("notification"))
          return;
        try
        {
          Context localContext = Crittercism.g(Crittercism.this);
          Intent localIntent1 = new Intent(localContext, NotificationActivity.class);
          Intent localIntent2 = localIntent1.setFlags(272629760);
          String str = localBundle.getString("notification");
          Intent localIntent3 = localIntent1.putExtra("com.crittercism.notification", str);
          Crittercism.g(Crittercism.this).startActivity(localIntent1);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    };
    this.d = local2;
    ServiceConnection local3 = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        try
        {
          Crittercism localCrittercism1 = Crittercism.this;
          ICritter localICritter1 = ICritter.a.a(paramAnonymousIBinder);
          localCrittercism1.c = localICritter1;
          if (Crittercism.this.c == null)
            return;
          ICritter localICritter2 = Crittercism.this.c;
          Crittercism localCrittercism2 = Crittercism.this;
          Context localContext = Crittercism.g(Crittercism.this);
          ApplicationInfo localApplicationInfo = Crittercism.h(localCrittercism2);
          localICritter2.a(localApplicationInfo);
          String str1 = Crittercism.this.c.a("com.crittercism.prefs.did");
          if ((str1 == null) || (str1.equals("")))
          {
            d locald1 = Crittercism.d(Crittercism.this);
            str1 = d.a(Crittercism.g(Crittercism.this), "com.crittercism.prefs.did");
            if (str1 == null)
            {
              str1 = Crittercism.c(Crittercism.this).b();
              d locald2 = Crittercism.d(Crittercism.this);
              d.a(Crittercism.g(Crittercism.this), "com.crittercism.prefs.did", str1);
            }
            Crittercism.this.c.a("com.crittercism.prefs.did", str1);
            ICritter localICritter3 = Crittercism.this.c;
            String str2 = Crittercism.a;
            localICritter3.a("com.crittercism.service.library_version", str2);
          }
          while (true)
          {
            Crittercism.c(Crittercism.this).a(str1);
            Crittercism.this.b = true;
            return;
            d locald3 = Crittercism.d(Crittercism.this);
            d.a(Crittercism.g(Crittercism.this), "com.crittercism.prefs.did", str1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }

      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        Crittercism.this.c = null;
        int i = Log.i("Crittercism", "Service Disconnected.");
      }
    };
    this.x = local3;
  }

  private static long a(Date paramDate)
  {
    Locale localLocale = Locale.US;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", localLocale);
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT");
    localSimpleDateFormat.setTimeZone(localTimeZone);
    String str1 = localSimpleDateFormat.format(paramDate);
    try
    {
      long l1 = localSimpleDateFormat.parse(str1).getTime();
      StringBuilder localStringBuilder1 = new StringBuilder("longFormat = ");
      String str2 = Long.toString(l1);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("\tdate = ");
      String str3 = paramDate.toString();
      String str4 = str3;
      label94: return l1;
    }
    catch (Exception localException)
    {
      break label94;
    }
  }

  public static Crittercism a()
  {
    return e;
  }

  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean[] paramArrayOfBoolean)
  {
    Crittercism localCrittercism1;
    int i1;
    if (paramArrayOfBoolean.length > 0)
    {
      localCrittercism1 = e;
      i1 = paramArrayOfBoolean[0];
    }
    for (localCrittercism1.w = i1; ; e.w = true)
    {
      this.i = true;
      this.j = paramContext;
      String str1 = g();
      this.t = str1;
      String str2 = a;
      String str3 = this.t;
      Context localContext1 = paramContext;
      String str4 = paramString1;
      String str5 = paramString2;
      String str6 = paramString3;
      b localb = new b(localContext1, str4, str5, str6, str2, str3);
      this.f = localb;
      float f1 = this.f.d();
      this.k = f1;
      if (this.g == null)
      {
        d locald1 = new d();
        this.g = locald1;
      }
      a.a(paramContext);
      Crittercism localCrittercism2 = e;
      boolean bool1 = b(paramContext, paramString1);
      this.q = bool1;
      Crittercism localCrittercism3 = e;
      boolean bool2 = a(paramContext, paramString1);
      this.r = bool2;
      if (!this.q)
        break;
      return;
    }
    String str7 = b();
    this.v = str7;
    StringBuilder localStringBuilder1 = new StringBuilder("initialize: notification title is ");
    String str8 = this.v;
    String str9 = str8;
    d locald2 = this.g;
    String str10 = d.a(this.j, "breadcrumbsFileString");
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = localJSONArray1.put("session_start");
    String str11 = i();
    JSONArray localJSONArray3 = localJSONArray1.put(str11);
    JSONArray localJSONArray4 = new JSONArray();
    JSONArray localJSONArray5 = localJSONArray4.put(localJSONArray1);
    Object localObject1 = new JSONObject();
    Object localObject2 = new JSONArray();
    if (str10 != null);
    try
    {
      localObject1 = new JSONObject(str10);
      if (!((JSONObject)localObject1).has("current_session"));
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        JSONArray localJSONArray6 = ((JSONObject)localObject1).getJSONArray("current_session");
        localObject2 = localJSONArray6;
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          while (true)
          {
            JSONObject localJSONObject1 = ((JSONObject)localObject1).put("previous_session", localObject2);
            JSONObject localJSONObject2 = ((JSONObject)localObject1).put("current_session", localJSONArray4);
            StringBuilder localStringBuilder2 = new StringBuilder("Breadcrumbs: ");
            String str12 = ((JSONObject)localObject1).toString();
            String str13 = str12;
            d locald3 = this.g;
            Context localContext2 = this.j;
            String str14 = ((JSONObject)localObject1).toString();
            d.a(localContext2, "breadcrumbsFileString", str14);
            Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(localUncaughtExceptionHandler instanceof a))
              Thread.setDefaultUncaughtExceptionHandler(new a(localUncaughtExceptionHandler));
            if (e.w)
              break;
            Intent localIntent1 = new Intent("com.crittercism.service.CrittercismService");
            Context localContext3 = this.j;
            ApplicationInfo localApplicationInfo = f();
            Intent localIntent2 = localIntent1.putExtra("com.crittercism.service.app_info", localApplicationInfo);
            ComponentName localComponentName = this.j.startService(localIntent1);
            Context localContext4 = this.j;
            ServiceConnection localServiceConnection = this.x;
            boolean bool3 = localContext4.bindService(localIntent1, localServiceConnection, 1);
            int i2 = Log.i("Crittercism", "Crittercism Initialized.");
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                if (Crittercism.a() == null)
                {
                  int i = Log.w("Crittercism", "Failed to post app load.  Please contact us at support@crittercism.com");
                  return;
                }
                try
                {
                  if (!Crittercism.b(Crittercism.a()))
                  {
                    int j = 10;
                    while ((!Crittercism.this.b) && (j > 0))
                    {
                      Thread.sleep(1000L);
                      j += -1;
                    }
                  }
                  i locali = Crittercism.c(Crittercism.this).f();
                  if (locali != null)
                  {
                    if (locali.a != null)
                    {
                      d locald = Crittercism.d(Crittercism.this);
                      d.a((JSONObject)locali.a);
                    }
                    if (locali.b != null)
                    {
                      Crittercism localCrittercism = Crittercism.this;
                      f localf1 = (f)locali.b;
                      Crittercism.a(localCrittercism, localf1);
                    }
                  }
                  if (Crittercism.e(Crittercism.this) != null)
                  {
                    f localf2 = Crittercism.e(Crittercism.this);
                    String str1 = localf2.b;
                    localf2.b = "";
                    String str2 = "pop notification: " + str1;
                    StringBuilder localStringBuilder = new StringBuilder("username: ");
                    String str3 = Crittercism.e(Crittercism.this).c;
                    String str4 = str3;
                    if ((str1 != null) && (!str1.equals("")))
                    {
                      Message localMessage = Message.obtain(Crittercism.this.d);
                      Bundle localBundle = new Bundle();
                      localBundle.putString("notification", str1);
                      localMessage.setData(localBundle);
                      localMessage.sendToTarget();
                    }
                  }
                  Crittercism.f(Crittercism.this);
                  return;
                }
                catch (g localg)
                {
                  String str5 = b.class.getCanonicalName();
                  String str6 = localg.toString();
                  return;
                }
                catch (Exception localException)
                {
                  String str7 = b.class.getCanonicalName();
                  String str8 = localException.toString();
                }
              }
            };
            new Thread(local1).start();
            return;
            localJSONException1 = localJSONException1;
            localObject1 = new JSONObject();
            continue;
            localJSONException2 = localJSONException2;
            JSONObject localJSONObject3 = new JSONObject();
            JSONArray localJSONArray7 = new JSONArray();
            localObject1 = localJSONObject3;
            localObject2 = localJSONArray7;
          }
        }
        catch (JSONException localJSONException3)
        {
          while (true)
            localObject1 = new JSONObject();
          d locald4 = this.g;
          str15 = d.a(this.j, "com.crittercism.prefs.did");
          if (str15 != null)
            break label700;
        }
      }
    }
    String str15 = this.f.b();
    d locald5 = this.g;
    d.a(this.j, "com.crittercism.prefs.did", str15);
    while (true)
    {
      this.f.a(str15);
      break;
      label700: String str16 = "did is " + str15;
    }
  }

  // ERROR //
  private static boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 343	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: ldc_w 345
    //   7: iconst_0
    //   8: invokeinterface 351 3 0
    //   13: istore_2
    //   14: iload_2
    //   15: istore_3
    //   16: iload_3
    //   17: ifne +147 -> 164
    //   20: ldc 107
    //   22: astore 4
    //   24: invokestatic 357	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   27: astore 5
    //   29: new 173	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 359
    //   36: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 361
    //   46: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 6
    //   54: new 363	java/io/File
    //   57: dup
    //   58: aload 5
    //   60: aload 6
    //   62: invokespecial 366	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore 7
    //   67: new 368	java/io/FileInputStream
    //   70: dup
    //   71: aload 7
    //   73: invokespecial 371	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   76: astore 8
    //   78: new 373	java/io/InputStreamReader
    //   81: dup
    //   82: aload 8
    //   84: invokespecial 376	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: astore 9
    //   89: new 378	java/io/BufferedReader
    //   92: dup
    //   93: aload 9
    //   95: invokespecial 381	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   98: astore 10
    //   100: aload 10
    //   102: invokevirtual 384	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 11
    //   107: aload 11
    //   109: ifnull +35 -> 144
    //   112: new 173	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 385	java/lang/StringBuilder:<init>	()V
    //   119: aload 4
    //   121: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 11
    //   126: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 12
    //   134: goto -34 -> 100
    //   137: astore 13
    //   139: iconst_0
    //   140: istore_3
    //   141: goto -125 -> 16
    //   144: aload 10
    //   146: invokevirtual 388	java/io/BufferedReader:close	()V
    //   149: aload 4
    //   151: ldc_w 390
    //   154: invokevirtual 394	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   157: istore_2
    //   158: iload_2
    //   159: ifeq +5 -> 164
    //   162: iconst_1
    //   163: istore_3
    //   164: iload_3
    //   165: ireturn
    //   166: astore 14
    //   168: iconst_0
    //   169: istore_3
    //   170: goto -6 -> 164
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	137	java/lang/Exception
    //   24	158	166	java/lang/Exception
  }

  private boolean a(e parame)
  {
    this.l = parame;
    JSONObject localJSONObject;
    Thread localThread;
    try
    {
      localJSONObject = this.l.b;
      if (localJSONObject != null)
        if (e.w)
          throw new Exception();
    }
    catch (Exception localException)
    {
      if (this.l != null)
      {
        Runnable local8 = new Runnable()
        {
          private void a()
          {
            StringBuilder localStringBuilder1 = new StringBuilder("this.pendingStacktraces.size = ");
            String str1 = Integer.toString(Crittercism.k(Crittercism.this).size());
            String str2 = str1;
            while (true)
            {
              if (Crittercism.k(Crittercism.this).size() <= 0)
                return;
              e locale = (e)Crittercism.k(Crittercism.this).remove(0);
              StringBuilder localStringBuilder2 = new StringBuilder("Attempting to send stacktrace for Thread ");
              String str3 = Long.toString(locale.a);
              String str4 = str3;
              try
              {
                boolean bool1 = Crittercism.c(Crittercism.this).a(locale);
                StringBuilder localStringBuilder3 = new StringBuilder("Successfully sent stacktrace for Thread ");
                String str5 = Long.toString(locale.a);
                String str6 = str5;
              }
              catch (Exception localException)
              {
                boolean bool2 = Crittercism.k(Crittercism.this).add(locale);
                StringBuilder localStringBuilder4 = new StringBuilder("Size of pendingStacktraces: ");
                String str7 = Integer.toString(Crittercism.k(Crittercism.this).size());
                String str8 = str7;
              }
            }
          }

          public final void run()
          {
            StringBuilder localStringBuilder1 = new StringBuilder("Thread run for pendingStacktraces: entering run(). THREAD ID: ");
            String str1 = Long.toString(Crittercism.l(Crittercism.this).a);
            String str2 = str1;
            StringBuilder localStringBuilder2 = new StringBuilder("Attempting to send stacktrace for Thread ");
            String str3 = Long.toString(Crittercism.l(Crittercism.this).a);
            String str4 = str3;
            int i = 1;
            try
            {
              b localb = Crittercism.c(Crittercism.this);
              e locale1 = Crittercism.l(Crittercism.this);
              boolean bool1 = localb.a(locale1);
              if (i != 0)
              {
                StringBuilder localStringBuilder3 = new StringBuilder("Successfully sent stacktrace for Thread ");
                String str5 = Long.toString(Crittercism.l(Crittercism.this).a);
                String str6 = str5;
                a();
              }
              long l = Crittercism.l(Crittercism.this).a;
              Crittercism.m(Crittercism.this);
              return;
            }
            catch (Exception localException)
            {
              while (true)
              {
                i = 0;
                Vector localVector = Crittercism.k(Crittercism.this);
                e locale2 = Crittercism.l(Crittercism.this);
                boolean bool2 = localVector.add(locale2);
                StringBuilder localStringBuilder4 = new StringBuilder("Size of pendingStacktraces: ");
                String str7 = Integer.toString(Crittercism.k(Crittercism.this).size());
                String str8 = str7;
              }
            }
          }
        };
        localThread = new Thread(local8);
        localThread.start();
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("INVOKING sendLogThread.join() for Thread id ");
      String str1 = Long.toString(this.l.a);
      String str2 = str1;
      localThread.join();
      label109: for (boolean bool = false; ; bool = true)
      {
        return bool;
        if (this.c.a("com.crittercism.service.library_version") == null)
          break;
        ICritter localICritter = this.c;
        String str3 = localJSONObject.toString();
        localICritter.b(str3);
      }
      throw new Exception();
      throw new Exception();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label109;
    }
  }

  // ERROR //
  private static boolean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 343	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: ldc_w 426
    //   7: iconst_0
    //   8: invokeinterface 351 3 0
    //   13: istore_2
    //   14: iload_2
    //   15: istore_3
    //   16: iload_3
    //   17: ifne +147 -> 164
    //   20: ldc 107
    //   22: astore 4
    //   24: invokestatic 357	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   27: astore 5
    //   29: new 173	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 359
    //   36: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 428
    //   46: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 6
    //   54: new 363	java/io/File
    //   57: dup
    //   58: aload 5
    //   60: aload 6
    //   62: invokespecial 366	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore 7
    //   67: new 368	java/io/FileInputStream
    //   70: dup
    //   71: aload 7
    //   73: invokespecial 371	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   76: astore 8
    //   78: new 373	java/io/InputStreamReader
    //   81: dup
    //   82: aload 8
    //   84: invokespecial 376	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: astore 9
    //   89: new 378	java/io/BufferedReader
    //   92: dup
    //   93: aload 9
    //   95: invokespecial 381	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   98: astore 10
    //   100: aload 10
    //   102: invokevirtual 384	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 11
    //   107: aload 11
    //   109: ifnull +35 -> 144
    //   112: new 173	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 385	java/lang/StringBuilder:<init>	()V
    //   119: aload 4
    //   121: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 11
    //   126: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 12
    //   134: goto -34 -> 100
    //   137: astore 13
    //   139: iconst_0
    //   140: istore_3
    //   141: goto -125 -> 16
    //   144: aload 10
    //   146: invokevirtual 388	java/io/BufferedReader:close	()V
    //   149: aload 4
    //   151: ldc_w 390
    //   154: invokevirtual 394	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   157: istore_2
    //   158: iload_2
    //   159: ifeq +5 -> 164
    //   162: iconst_1
    //   163: istore_3
    //   164: iload_3
    //   165: ireturn
    //   166: astore 14
    //   168: iconst_0
    //   169: istore_3
    //   170: goto -6 -> 164
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	137	java/lang/Exception
    //   24	158	166	java/lang/Exception
  }

  // ERROR //
  private boolean b(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	com/crittercism/app/Crittercism:p	I
    //   4: bipush 50
    //   6: if_icmpge +443 -> 449
    //   9: new 243	org/json/JSONObject
    //   12: dup
    //   13: invokespecial 244	org/json/JSONObject:<init>	()V
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 211	com/crittercism/app/Crittercism:g	Lcrittercism/android/d;
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 85	com/crittercism/app/Crittercism:j	Landroid/content/Context;
    //   26: ldc 227
    //   28: invokestatic 230	crittercism/android/d:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +425 -> 460
    //   38: new 243	org/json/JSONObject
    //   41: dup
    //   42: aload 4
    //   44: invokespecial 245	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   47: astore 5
    //   49: aload 5
    //   51: astore 6
    //   53: aload_0
    //   54: getfield 95	com/crittercism/app/Crittercism:n	Ljava/util/Vector;
    //   57: invokevirtual 433	java/util/Vector:size	()I
    //   60: iconst_5
    //   61: if_icmpge +131 -> 192
    //   64: aload_0
    //   65: getfield 95	com/crittercism/app/Crittercism:n	Ljava/util/Vector;
    //   68: invokevirtual 433	java/util/Vector:size	()I
    //   71: istore 7
    //   73: aload_0
    //   74: getfield 99	com/crittercism/app/Crittercism:p	I
    //   77: istore 8
    //   79: iload 7
    //   81: iload 8
    //   83: iadd
    //   84: bipush 50
    //   86: if_icmpge +106 -> 192
    //   89: new 173	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 435
    //   96: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: astore 9
    //   101: aload_1
    //   102: invokevirtual 440	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   105: astore 10
    //   107: aload 9
    //   109: aload 10
    //   111: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 11
    //   119: aload_0
    //   120: getfield 95	com/crittercism/app/Crittercism:n	Ljava/util/Vector;
    //   123: astore 12
    //   125: invokestatic 444	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   128: astore 13
    //   130: aload_0
    //   131: getfield 206	com/crittercism/app/Crittercism:f	Lcrittercism/android/b;
    //   134: invokevirtual 447	crittercism/android/b:c	()Ljava/util/List;
    //   137: astore 14
    //   139: aload_0
    //   140: getfield 206	com/crittercism/app/Crittercism:f	Lcrittercism/android/b;
    //   143: astore 15
    //   145: iconst_0
    //   146: newarray boolean
    //   148: astore 16
    //   150: aload 15
    //   152: aload 16
    //   154: invokevirtual 450	crittercism/android/b:a	([Z)Lorg/json/JSONObject;
    //   157: astore 17
    //   159: invokestatic 454	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   162: invokevirtual 457	java/lang/Thread:getId	()J
    //   165: lstore 18
    //   167: aload_1
    //   168: aload 13
    //   170: aload 14
    //   172: aload 17
    //   174: lload 18
    //   176: aload 6
    //   178: invokestatic 460	crittercism/android/e:a	(Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/List;Lorg/json/JSONObject;JLorg/json/JSONObject;)Lcrittercism/android/e;
    //   181: astore 20
    //   183: aload 12
    //   185: aload 20
    //   187: invokevirtual 463	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   190: istore 21
    //   192: aload_0
    //   193: getfield 97	com/crittercism/app/Crittercism:o	Ljava/util/Date;
    //   196: ifnull +43 -> 239
    //   199: aload_0
    //   200: getfield 97	com/crittercism/app/Crittercism:o	Ljava/util/Date;
    //   203: ifnull +246 -> 449
    //   206: new 167	java/util/Date
    //   209: dup
    //   210: invokespecial 464	java/util/Date:<init>	()V
    //   213: invokestatic 466	com/crittercism/app/Crittercism:a	(Ljava/util/Date;)J
    //   216: lstore 22
    //   218: aload_0
    //   219: getfield 97	com/crittercism/app/Crittercism:o	Ljava/util/Date;
    //   222: invokestatic 466	com/crittercism/app/Crittercism:a	(Ljava/util/Date;)J
    //   225: lstore 24
    //   227: lload 22
    //   229: lload 24
    //   231: lsub
    //   232: ldc2_w 467
    //   235: lcmp
    //   236: ifle +213 -> 449
    //   239: new 14	com/crittercism/app/Crittercism$5
    //   242: dup
    //   243: aload_0
    //   244: invokespecial 469	com/crittercism/app/Crittercism$5:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   247: astore 26
    //   249: new 471	java/util/concurrent/FutureTask
    //   252: dup
    //   253: aload 26
    //   255: invokespecial 474	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   258: astore 27
    //   260: bipush 10
    //   262: invokestatic 480	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   265: istore 28
    //   267: iload 28
    //   269: istore 29
    //   271: iload 29
    //   273: aload 27
    //   275: invokeinterface 485 2 0
    //   280: iconst_0
    //   281: istore 30
    //   283: aload 27
    //   285: invokevirtual 489	java/util/concurrent/FutureTask:isDone	()Z
    //   288: ifne +47 -> 335
    //   291: getstatic 495	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   294: astore 31
    //   296: aload 27
    //   298: ldc2_w 496
    //   301: aload 31
    //   303: invokevirtual 501	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   306: checkcast 503	java/lang/Boolean
    //   309: invokevirtual 506	java/lang/Boolean:booleanValue	()Z
    //   312: istore 28
    //   314: iload 28
    //   316: istore 32
    //   318: goto -35 -> 283
    //   321: invokevirtual 509	java/lang/Exception:printStackTrace	()V
    //   324: aload_2
    //   325: astore 6
    //   327: goto -274 -> 53
    //   330: astore 33
    //   332: iconst_0
    //   333: istore 31
    //   335: new 173	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 511
    //   342: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: astore 4
    //   347: iload 30
    //   349: ifeq +23 -> 372
    //   352: ldc_w 513
    //   355: astore 27
    //   357: aload 4
    //   359: aload 27
    //   361: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: astore 35
    //   369: iload 30
    //   371: ireturn
    //   372: ldc_w 515
    //   375: astore 27
    //   377: goto -20 -> 357
    //   380: astore 36
    //   382: new 173	java/lang/StringBuilder
    //   385: dup
    //   386: ldc_w 517
    //   389: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   392: astore 37
    //   394: aload 36
    //   396: invokevirtual 521	java/lang/Object:getClass	()Ljava/lang/Class;
    //   399: invokevirtual 526	java/lang/Class:getName	()Ljava/lang/String;
    //   402: astore 38
    //   404: aload 37
    //   406: aload 38
    //   408: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: astore 39
    //   416: aload 36
    //   418: invokevirtual 509	java/lang/Exception:printStackTrace	()V
    //   421: aload_0
    //   422: aload 36
    //   424: putfield 105	com/crittercism/app/Crittercism:s	Ljava/lang/Exception;
    //   427: new 16	com/crittercism/app/Crittercism$6
    //   430: dup
    //   431: aload_0
    //   432: invokespecial 527	com/crittercism/app/Crittercism$6:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   435: astore 40
    //   437: new 268	java/lang/Thread
    //   440: dup
    //   441: aload 40
    //   443: invokespecial 316	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   446: invokevirtual 319	java/lang/Thread:start	()V
    //   449: iconst_0
    //   450: istore 30
    //   452: goto -83 -> 369
    //   455: astore 41
    //   457: goto -8 -> 449
    //   460: aload_2
    //   461: astore 5
    //   463: goto -414 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   17	49	321	java/lang/Exception
    //   271	314	330	java/lang/Exception
    //   192	267	380	java/lang/Exception
    //   335	377	380	java/lang/Exception
    //   421	449	455	java/lang/Exception
  }

  private ApplicationInfo f()
  {
    try
    {
      Class[] arrayOfClass = new Class[0];
      Method localMethod = Context.class.getMethod("getApplicationInfo", arrayOfClass);
      Context localContext = this.j;
      Object[] arrayOfObject = new Object[0];
      localObject = (ApplicationInfo)localMethod.invoke(localContext, arrayOfObject);
      return localObject;
    }
    catch (Exception localException1)
    {
      while (true)
        try
        {
          PackageManager localPackageManager = this.j.getPackageManager();
          String str = this.j.getPackageName();
          ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(str, 0);
          localObject = localApplicationInfo;
        }
        catch (Exception localException2)
        {
          Object localObject = null;
        }
    }
  }

  private String g()
  {
    try
    {
      PackageManager localPackageManager = this.j.getPackageManager();
      String str1 = this.j.getPackageName();
      String str2 = localPackageManager.getPackageInfo(str1, 0).versionName;
      label26: return str2;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }

  public static boolean getOptOutStatus()
  {
    boolean bool = false;
    if (e == null)
      int i1 = Log.w("Crittercism", "Call to getOptOutStatus() failed.  Please contact us at support@crittercism.com.");
    while (true)
    {
      return bool;
      try
      {
        Crittercism localCrittercism1 = e;
        Context localContext = e.j;
        Crittercism localCrittercism2 = e;
        if (localCrittercism2.f == null)
          int i2 = Log.w("Crittercism", "Failed to get app id.  Please contact us at support@crittercism.com.");
        String str;
        for (Object localObject = new String(); ; localObject = str)
        {
          bool = b(localContext, (String)localObject);
          break;
          str = localCrittercism2.f.a();
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  private boolean h()
  {
    Object localObject1 = null;
    JSONObject localJSONObject1 = new JSONObject();
    String str1 = a.d.c;
    JSONObject localJSONObject2 = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    Object localObject3 = this.n.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      e locale = (e)((Iterator)localObject3).next();
      JSONObject localJSONObject3 = new JSONObject();
      JSONObject localJSONObject4 = locale.b;
      try
      {
        String str2 = a;
        JSONObject localJSONObject5 = localJSONObject3.put("library_version", str2);
        JSONObject localJSONObject6 = localJSONObject4.getJSONObject("app_state");
        JSONObject localJSONObject7 = localJSONObject3.put("state", localJSONObject6);
        JSONArray localJSONArray2 = localJSONObject4.getJSONArray("unsymbolized_stacktrace");
        JSONObject localJSONObject8 = localJSONObject3.put("unsymbolized_stacktrace", localJSONArray2);
        JSONArray localJSONArray3 = localJSONObject4.getJSONArray("threads");
        JSONObject localJSONObject9 = localJSONObject3.put("threads", localJSONArray3);
        String str3 = localJSONObject4.getString("exception_name");
        JSONObject localJSONObject10 = localJSONObject3.put("exception_name", str3);
        String str4 = localJSONObject4.getString("exception_reason");
        JSONObject localJSONObject11 = localJSONObject3.put("exception_reason", str4);
        JSONObject localJSONObject12 = localJSONObject3.put("platform", "android");
        JSONObject localJSONObject13 = localJSONObject4.getJSONObject("breadcrumbs");
        JSONObject localJSONObject14 = localJSONObject3.put("breadcrumbs", localJSONObject13);
        JSONArray localJSONArray4 = localJSONArray1.put(localJSONObject3);
      }
      catch (Exception localException2)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("Exception constructing new handled exception or adding it to exceptions array!! ");
        String str5 = localException2.getClass().getName();
        String str6 = str5;
        localException2.printStackTrace();
      }
    }
    try
    {
      String str7 = this.f.a();
      JSONObject localJSONObject15 = localJSONObject2.put("app_id", str7);
      localObject3 = "user_id";
      String str8 = "";
      if (this.h != null)
        str8 = this.h.a;
      JSONObject localJSONObject16 = localJSONObject2.put((String)localObject3, str8);
      String str9 = this.f.b();
      JSONObject localJSONObject17 = localJSONObject2.put("hashed_device_id", str9);
      String str10 = a;
      JSONObject localJSONObject18 = localJSONObject2.put("library_version", str10);
      JSONObject localJSONObject19 = localJSONObject2.put("exceptions", localJSONArray1);
      JSONObject localJSONObject20 = localJSONObject1.put("requestUrl", str1);
      JSONObject localJSONObject21 = localJSONObject1.put("requestData", localJSONObject2);
      localJSONObject22 = this.f.a(localJSONObject1);
    }
    catch (Exception localException1)
    {
      try
      {
        JSONObject localJSONObject22;
        if (localJSONObject22.has("success"))
        {
          int i1 = localJSONObject22.getInt("success");
          if (i1 != 1);
        }
      }
      catch (Exception localException1)
      {
        while (true)
        {
          try
          {
            int i2 = this.p;
            int i3 = this.n.size();
            int i4 = i2 + i3;
            this.p = i4;
            this.n.clear();
            bool = true;
            Date localDate = new Date();
            this.o = localDate;
            return bool;
            localException3 = localException3;
            StringBuilder localStringBuilder2 = new StringBuilder("Exception constructing request data or request object in attemptToSendHandledExceptions!!!! ");
            String str11 = localException3.getClass().getName();
            String str12 = str11;
            localException3.printStackTrace();
            continue;
            localException1 = localException1;
            bool = false;
            StringBuilder localStringBuilder3 = new StringBuilder("Exception handing response object or clearing pending handled exceptions vector in attemptToSendHandledExceptions!!!! ");
            String str13 = localException1.getClass().getName();
            String str14 = str13;
            localException1.printStackTrace();
            continue;
          }
          catch (Exception localException4)
          {
            bool = true;
            Object localObject2 = localException4;
            continue;
          }
          boolean bool = false;
        }
      }
    }
  }

  private static String i()
  {
    String str = new String();
    Locale localLocale = Locale.US;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", localLocale);
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT");
    localSimpleDateFormat.setTimeZone(localTimeZone);
    Date localDate = new Date();
    return localSimpleDateFormat.format(localDate);
  }

  /** @deprecated */
  public static void init(Context paramContext, String paramString1, String paramString2, String paramString3, boolean[] paramArrayOfBoolean)
  {
    try
    {
      if (paramString1.equals("CRITTERCISM_APP_ID"))
        int i1 = Log.e("Crittercism", "ERROR: Crittercism will NOT work unless you enter a valid Crittercism App ID. Check your settings page to find the ID.");
      if (e != null)
      {
        boolean bool = e.i;
        if (bool != null);
      }
      try
      {
        Crittercism localCrittercism = e;
        Context localContext = paramContext;
        String str1 = paramString1;
        String str2 = paramString2;
        String str3 = paramString3;
        boolean[] arrayOfBoolean = paramArrayOfBoolean;
        localCrittercism.a(localContext, str1, str2, str3, arrayOfBoolean);
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          int i2 = Log.e("Crittercism", "Failed to initialize Crittercism - Please report this issue, thanks!");
        }
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public static void init(Context paramContext, String paramString, boolean[] paramArrayOfBoolean)
  {
    try
    {
      if (paramString.equals("CRITTERCISM_APP_ID"))
        int i1 = Log.e("Crittercism", "ERROR: Crittercism will NOT work unless you enter a valid Crittercism App ID. Check your settings page to find the ID.");
      if (e != null)
      {
        boolean bool = e.i;
        if (bool != null);
      }
      try
      {
        Crittercism localCrittercism = e;
        Context localContext = paramContext;
        String str = paramString;
        boolean[] arrayOfBoolean = paramArrayOfBoolean;
        localCrittercism.a(localContext, str, "", "", arrayOfBoolean);
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          int i2 = Log.e("Crittercism", "Failed to initialize Crittercism - Please report this issue, thanks!");
        }
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  // ERROR //
  public static void leaveBreadcrumb(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 71	com/crittercism/app/Crittercism:e	Lcom/crittercism/app/Crittercism;
    //   6: ifnonnull +17 -> 23
    //   9: ldc_w 305
    //   12: ldc_w 707
    //   15: invokestatic 614	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: istore_1
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: getstatic 71	com/crittercism/app/Crittercism:e	Lcom/crittercism/app/Crittercism;
    //   26: astore_2
    //   27: aload_2
    //   28: getfield 101	com/crittercism/app/Crittercism:q	Z
    //   31: ifne -12 -> 19
    //   34: aload_2
    //   35: getfield 211	com/crittercism/app/Crittercism:g	Lcrittercism/android/d;
    //   38: astore_3
    //   39: aload_2
    //   40: getfield 85	com/crittercism/app/Crittercism:j	Landroid/content/Context;
    //   43: ldc 227
    //   45: invokestatic 230	crittercism/android/d:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 4
    //   50: new 232	org/json/JSONArray
    //   53: dup
    //   54: invokespecial 233	org/json/JSONArray:<init>	()V
    //   57: astore 5
    //   59: aload 5
    //   61: aload_0
    //   62: invokevirtual 239	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   65: astore 6
    //   67: invokestatic 241	com/crittercism/app/Crittercism:i	()Ljava/lang/String;
    //   70: astore 7
    //   72: aload 5
    //   74: aload 7
    //   76: invokevirtual 239	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   79: astore 8
    //   81: new 243	org/json/JSONObject
    //   84: dup
    //   85: invokespecial 244	org/json/JSONObject:<init>	()V
    //   88: astore 9
    //   90: new 232	org/json/JSONArray
    //   93: dup
    //   94: invokespecial 233	org/json/JSONArray:<init>	()V
    //   97: astore 10
    //   99: aload 4
    //   101: ifnull +331 -> 432
    //   104: new 243	org/json/JSONObject
    //   107: dup
    //   108: aload 4
    //   110: invokespecial 245	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   113: astore 9
    //   115: aload 9
    //   117: ldc 247
    //   119: invokevirtual 251	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   122: astore 11
    //   124: aload 11
    //   126: ifnull +299 -> 425
    //   129: aload 9
    //   131: ldc 247
    //   133: invokevirtual 255	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   136: astore 11
    //   138: aload 11
    //   140: astore 10
    //   142: aload 9
    //   144: astore 12
    //   146: aload 10
    //   148: aload 5
    //   150: invokevirtual 239	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   153: astore 13
    //   155: aload 10
    //   157: invokevirtual 574	org/json/JSONArray:length	()I
    //   160: bipush 50
    //   162: if_icmple +256 -> 418
    //   165: new 232	org/json/JSONArray
    //   168: dup
    //   169: invokespecial 233	org/json/JSONArray:<init>	()V
    //   172: astore 9
    //   174: aconst_null
    //   175: astore 4
    //   177: aload 10
    //   179: aload 4
    //   181: invokevirtual 710	org/json/JSONArray:getJSONArray	(I)Lorg/json/JSONArray;
    //   184: astore 14
    //   186: aload 9
    //   188: aload 14
    //   190: invokevirtual 239	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   193: astore 15
    //   195: aconst_null
    //   196: astore 4
    //   198: aload 10
    //   200: invokevirtual 574	org/json/JSONArray:length	()I
    //   203: istore 16
    //   205: aload 4
    //   207: iload 16
    //   209: if_icmpge +97 -> 306
    //   212: aload 10
    //   214: aload 4
    //   216: invokevirtual 710	org/json/JSONArray:getJSONArray	(I)Lorg/json/JSONArray;
    //   219: astore 17
    //   221: aload 9
    //   223: aload 17
    //   225: invokevirtual 239	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   228: astore 18
    //   230: aload 4
    //   232: iconst_1
    //   233: iadd
    //   234: istore 4
    //   236: goto -38 -> 198
    //   239: astore 19
    //   241: new 243	org/json/JSONObject
    //   244: dup
    //   245: invokespecial 244	org/json/JSONObject:<init>	()V
    //   248: astore 9
    //   250: goto -135 -> 115
    //   253: astore 20
    //   255: ldc_w 305
    //   258: ldc_w 712
    //   261: invokestatic 614	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: istore 21
    //   266: goto -247 -> 19
    //   269: astore 22
    //   271: ldc 2
    //   273: monitorexit
    //   274: aload 22
    //   276: athrow
    //   277: astore 23
    //   279: new 232	org/json/JSONArray
    //   282: dup
    //   283: invokespecial 233	org/json/JSONArray:<init>	()V
    //   286: astore 10
    //   288: aload 9
    //   290: astore 12
    //   292: goto -146 -> 146
    //   295: astore 24
    //   297: new 232	org/json/JSONArray
    //   300: dup
    //   301: invokespecial 233	org/json/JSONArray:<init>	()V
    //   304: astore 9
    //   306: aload 12
    //   308: ldc 247
    //   310: aload 9
    //   312: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   315: astore 25
    //   317: new 173	java/lang/StringBuilder
    //   320: dup
    //   321: ldc_w 262
    //   324: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   327: astore 26
    //   329: aload 12
    //   331: invokevirtual 263	org/json/JSONObject:toString	()Ljava/lang/String;
    //   334: astore 27
    //   336: aload 26
    //   338: aload 27
    //   340: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: astore 28
    //   348: new 173	java/lang/StringBuilder
    //   351: dup
    //   352: ldc_w 714
    //   355: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   358: astore 29
    //   360: aload 9
    //   362: invokevirtual 574	org/json/JSONArray:length	()I
    //   365: invokestatic 590	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   368: astore 30
    //   370: aload 29
    //   372: aload 30
    //   374: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: astore 31
    //   382: aload_2
    //   383: getfield 211	com/crittercism/app/Crittercism:g	Lcrittercism/android/d;
    //   386: astore 32
    //   388: aload_2
    //   389: getfield 85	com/crittercism/app/Crittercism:j	Landroid/content/Context;
    //   392: astore 33
    //   394: aload 12
    //   396: invokevirtual 263	org/json/JSONObject:toString	()Ljava/lang/String;
    //   399: astore 34
    //   401: aload 33
    //   403: ldc 227
    //   405: aload 34
    //   407: invokestatic 266	crittercism/android/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   410: goto -391 -> 19
    //   413: astore 35
    //   415: goto -98 -> 317
    //   418: aload 10
    //   420: astore 9
    //   422: goto -116 -> 306
    //   425: aload 9
    //   427: astore 12
    //   429: goto -283 -> 146
    //   432: aload 9
    //   434: astore 12
    //   436: goto -290 -> 146
    //
    // Exception table:
    //   from	to	target	type
    //   104	115	239	org/json/JSONException
    //   23	99	253	java/lang/Exception
    //   104	115	253	java/lang/Exception
    //   115	124	253	java/lang/Exception
    //   129	138	253	java/lang/Exception
    //   146	174	253	java/lang/Exception
    //   177	230	253	java/lang/Exception
    //   241	250	253	java/lang/Exception
    //   279	306	253	java/lang/Exception
    //   306	317	253	java/lang/Exception
    //   317	410	253	java/lang/Exception
    //   3	19	269	finally
    //   23	99	269	finally
    //   104	115	269	finally
    //   115	124	269	finally
    //   129	138	269	finally
    //   146	174	269	finally
    //   177	230	269	finally
    //   241	250	269	finally
    //   255	266	269	finally
    //   279	306	269	finally
    //   306	317	269	finally
    //   317	410	269	finally
    //   129	138	277	org/json/JSONException
    //   177	230	295	org/json/JSONException
    //   306	317	413	org/json/JSONException
  }

  /** @deprecated */
  // ERROR //
  public static boolean logHandledException(Throwable paramThrowable)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 71	com/crittercism/app/Crittercism:e	Lcom/crittercism/app/Crittercism;
    //   8: ifnonnull +18 -> 26
    //   11: ldc_w 305
    //   14: ldc_w 717
    //   17: invokestatic 614	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   20: istore_2
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: invokestatic 719	com/crittercism/app/Crittercism:getOptOutStatus	()Z
    //   29: iconst_1
    //   30: if_icmpeq -9 -> 21
    //   33: getstatic 71	com/crittercism/app/Crittercism:e	Lcom/crittercism/app/Crittercism;
    //   36: aload_0
    //   37: invokespecial 721	com/crittercism/app/Crittercism:b	(Ljava/lang/Throwable;)Z
    //   40: istore_3
    //   41: iload_3
    //   42: istore_1
    //   43: goto -22 -> 21
    //   46: astore 4
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload 4
    //   53: athrow
    //   54: astore 5
    //   56: goto -35 -> 21
    //
    // Exception table:
    //   from	to	target	type
    //   5	21	46	finally
    //   26	41	46	finally
    //   26	41	54	java/lang/Exception
  }

  public static void setMetadata(final JSONObject paramJSONObject)
  {
    if (e == null)
    {
      int i1 = Log.w("Crittercism", "Call to setMetadata() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    try
    {
      if (e.i)
      {
        Crittercism localCrittercism = e;
        Runnable local4 = new Runnable()
        {
          public final void run()
          {
            try
            {
              b localb = Crittercism.c(Crittercism.this);
              JSONObject localJSONObject = paramJSONObject;
              boolean bool = localb.b(localJSONObject);
              return;
            }
            catch (Exception localException)
            {
            }
          }
        };
        new Thread(local4).start();
        return;
      }
    }
    catch (Exception localException)
    {
      return;
    }
    int i2 = Log.e("Crittercism", "Initialize the Crittercism library before using its methods.");
  }

  public static void setNotificationTitle(String paramString)
  {
    if (e == null)
    {
      int i1 = Log.w("Crittercism", "Call to setNotificationTitle() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor1 = PreferenceManager.getDefaultSharedPreferences(e.j).edit();
      SharedPreferences.Editor localEditor2 = localEditor1.remove("notificationTitle");
      SharedPreferences.Editor localEditor3 = localEditor1.putString("notificationTitle", paramString);
      if (!localEditor1.commit())
        throw new Exception();
    }
    catch (Exception localException)
    {
      return;
    }
    String str = "Saved notificationTitle as " + paramString;
    e.v = paramString;
  }

  public static void setOptOutStatus(boolean paramBoolean)
  {
    if (e == null)
    {
      int i1 = Log.w("Crittercism", "Call to setOptOutStatus() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor1 = PreferenceManager.getDefaultSharedPreferences(e.j).edit();
      SharedPreferences.Editor localEditor2 = localEditor1.remove("optOutStatus");
      SharedPreferences.Editor localEditor3 = localEditor1.putBoolean("optOutStatus", paramBoolean);
      if (!localEditor1.commit())
        throw new Exception();
    }
    catch (Exception localException)
    {
    }
    while (true)
    {
      try
      {
        File localFile1 = Environment.getExternalStorageDirectory();
        if (!localFile1.canWrite())
          return;
        StringBuilder localStringBuilder = new StringBuilder("critter_");
        String str1 = e.f.a();
        String str2 = str1 + "_optoutsetting.txt";
        File localFile2 = new File(localFile1, str2);
        FileWriter localFileWriter = new FileWriter(localFile2);
        localObject = new BufferedWriter(localFileWriter);
        if (!paramBoolean)
          break label254;
        str3 = "true";
        ((BufferedWriter)localObject).write(str3);
        ((BufferedWriter)localObject).close();
        return;
      }
      catch (IOException localIOException)
      {
        int i2 = Log.w("Crittercism", "Failed to store opt out status!!");
        return;
      }
      Object localObject = new StringBuilder("Saved optOutStatus as ");
      if (paramBoolean);
      for (String str4 = "true"; ; str4 = "false")
      {
        String str5 = str4 + " to SharedPreferences!!";
        e.q = paramBoolean;
        return;
      }
      label254: String str3 = "false";
    }
  }

  public static void setShouldUseAmazonMarket(boolean paramBoolean)
  {
    if (e == null)
    {
      int i1 = Log.w("Crittercism", "Call to setShouldUseAmazonMarket() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor1 = PreferenceManager.getDefaultSharedPreferences(e.j).edit();
      SharedPreferences.Editor localEditor2 = localEditor1.remove("shouldUseAmazonMarket");
      SharedPreferences.Editor localEditor3 = localEditor1.putBoolean("shouldUseAmazonMarket", paramBoolean);
      if (!localEditor1.commit())
        throw new Exception();
    }
    catch (Exception localException)
    {
    }
    while (true)
    {
      try
      {
        File localFile1 = Environment.getExternalStorageDirectory();
        if (!localFile1.canWrite())
          return;
        StringBuilder localStringBuilder = new StringBuilder("critter_");
        String str1 = e.f.a();
        String str2 = str1 + "_amazonmarketsetting.txt";
        File localFile2 = new File(localFile1, str2);
        FileWriter localFileWriter = new FileWriter(localFile2);
        localObject = new BufferedWriter(localFileWriter);
        if (!paramBoolean)
          break label254;
        str3 = "true";
        ((BufferedWriter)localObject).write(str3);
        ((BufferedWriter)localObject).close();
        return;
      }
      catch (IOException localIOException)
      {
        int i2 = Log.w("Crittercism", "Failed to store amazon market status!!");
        return;
      }
      Object localObject = new StringBuilder("Saved shouldUseAmazonMarket as ");
      if (paramBoolean);
      for (String str4 = "true"; ; str4 = "false")
      {
        String str5 = str4 + " to SharedPreferences!!";
        e.r = paramBoolean;
        return;
      }
      label254: String str3 = "false";
    }
  }

  public static void setUsername(String paramString)
  {
    if (e == null)
    {
      int i1 = Log.w("Crittercism", "Call to setUsername() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    try
    {
      if (e.i)
      {
        if (e.h == null)
        {
          Crittercism localCrittercism = e;
          f localf = new f();
          localCrittercism.h = localf;
        }
        e.h.c = paramString;
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = localJSONObject1.put("username", paramString);
        setMetadata(localJSONObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      return;
    }
    int i2 = Log.e("Crittercism", "Initialize the Crittercism library before using its methods.");
  }

  public final void a(Exception paramException)
  {
    this.f.a(paramException);
  }

  /** @deprecated */
  // ERROR //
  public final boolean a(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 173	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 822
    //   9: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: invokestatic 454	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 457	java/lang/Thread:getId	()J
    //   19: invokestatic 184	java/lang/Long:toString	(J)Ljava/lang/String;
    //   22: astore_3
    //   23: aload_2
    //   24: aload_3
    //   25: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_0
    //   34: getfield 211	com/crittercism/app/Crittercism:g	Lcrittercism/android/d;
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 85	com/crittercism/app/Crittercism:j	Landroid/content/Context;
    //   43: ldc 227
    //   45: invokestatic 230	crittercism/android/d:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 6
    //   50: new 243	org/json/JSONObject
    //   53: dup
    //   54: invokespecial 244	org/json/JSONObject:<init>	()V
    //   57: astore 7
    //   59: aload 6
    //   61: ifnull +73 -> 134
    //   64: new 243	org/json/JSONObject
    //   67: dup
    //   68: aload 6
    //   70: invokespecial 245	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   73: astore 8
    //   75: aload 8
    //   77: astore 7
    //   79: aload 7
    //   81: ldc 247
    //   83: invokevirtual 251	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   86: istore 9
    //   88: iload 9
    //   90: ifne +44 -> 134
    //   93: new 232	org/json/JSONArray
    //   96: dup
    //   97: invokespecial 233	org/json/JSONArray:<init>	()V
    //   100: astore 10
    //   102: aload 7
    //   104: ldc 247
    //   106: aload 10
    //   108: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: astore 11
    //   113: new 232	org/json/JSONArray
    //   116: dup
    //   117: invokespecial 233	org/json/JSONArray:<init>	()V
    //   120: astore 12
    //   122: aload 7
    //   124: ldc_w 257
    //   127: aload 12
    //   129: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   132: astore 13
    //   134: new 173	java/lang/StringBuilder
    //   137: dup
    //   138: ldc_w 824
    //   141: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: astore 14
    //   146: aload 7
    //   148: invokevirtual 263	org/json/JSONObject:toString	()Ljava/lang/String;
    //   151: astore 15
    //   153: aload 14
    //   155: aload 15
    //   157: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 16
    //   165: aload_0
    //   166: getfield 95	com/crittercism/app/Crittercism:n	Ljava/util/Vector;
    //   169: invokevirtual 433	java/util/Vector:size	()I
    //   172: ifle +34 -> 206
    //   175: new 18	com/crittercism/app/Crittercism$7
    //   178: dup
    //   179: aload_0
    //   180: invokespecial 825	com/crittercism/app/Crittercism$7:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   183: astore 17
    //   185: new 268	java/lang/Thread
    //   188: dup
    //   189: aload 17
    //   191: invokespecial 316	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   194: astore 8
    //   196: aload 8
    //   198: invokevirtual 319	java/lang/Thread:start	()V
    //   201: aload 8
    //   203: invokevirtual 415	java/lang/Thread:join	()V
    //   206: invokestatic 444	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   209: astore 18
    //   211: aload_0
    //   212: getfield 206	com/crittercism/app/Crittercism:f	Lcrittercism/android/b;
    //   215: invokevirtual 447	crittercism/android/b:c	()Ljava/util/List;
    //   218: astore 19
    //   220: aload_0
    //   221: getfield 206	com/crittercism/app/Crittercism:f	Lcrittercism/android/b;
    //   224: astore 20
    //   226: iconst_0
    //   227: newarray boolean
    //   229: astore 21
    //   231: aload 20
    //   233: aload 21
    //   235: invokevirtual 450	crittercism/android/b:a	([Z)Lorg/json/JSONObject;
    //   238: astore 22
    //   240: invokestatic 454	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   243: invokevirtual 457	java/lang/Thread:getId	()J
    //   246: lstore 23
    //   248: aload_1
    //   249: aload 18
    //   251: aload 19
    //   253: aload 22
    //   255: lload 23
    //   257: aload 7
    //   259: invokestatic 460	crittercism/android/e:a	(Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/List;Lorg/json/JSONObject;JLorg/json/JSONObject;)Lcrittercism/android/e;
    //   262: astore 25
    //   264: aload_0
    //   265: aload 25
    //   267: invokespecial 599	com/crittercism/app/Crittercism:a	(Lcrittercism/android/e;)Z
    //   270: istore 26
    //   272: aload_0
    //   273: monitorexit
    //   274: iconst_1
    //   275: ireturn
    //   276: astore 27
    //   278: new 243	org/json/JSONObject
    //   281: dup
    //   282: invokespecial 244	org/json/JSONObject:<init>	()V
    //   285: astore 7
    //   287: goto -153 -> 134
    //   290: astore 28
    //   292: aload_0
    //   293: monitorexit
    //   294: aload 28
    //   296: athrow
    //   297: astore 29
    //   299: goto -93 -> 206
    //   302: astore 30
    //   304: goto -225 -> 79
    //
    // Exception table:
    //   from	to	target	type
    //   93	134	276	org/json/JSONException
    //   2	59	290	finally
    //   64	75	290	finally
    //   79	88	290	finally
    //   93	134	290	finally
    //   134	201	290	finally
    //   201	206	290	finally
    //   206	272	290	finally
    //   278	287	290	finally
    //   201	206	297	java/lang/Exception
    //   64	75	302	java/lang/Exception
  }

  public final String b()
  {
    String str1 = new String();
    try
    {
      str2 = PreferenceManager.getDefaultSharedPreferences(this.j).getString("notificationTitle", null);
      if (str2 == null)
        str2 = a.a(28);
      String str3 = "getNotificationTitle: notification title is " + str2;
      return str2;
    }
    catch (Exception localException)
    {
      while (true)
        String str2 = a.a(28);
    }
  }

  final void c()
  {
    if (!this.b)
      return;
    if (this.c != null);
    try
    {
      ICritter localICritter = this.c;
      Context localContext1 = this.j;
      ApplicationInfo localApplicationInfo = f();
      localICritter.b(localApplicationInfo);
      try
      {
        label37: Context localContext2 = this.j;
        ServiceConnection localServiceConnection = this.x;
        localContext2.unbindService(localServiceConnection);
        this.b = false;
        return;
      }
      catch (Exception localException1)
      {
      }
    }
    catch (Exception localException2)
    {
      break label37;
    }
  }

  public final String d()
  {
    try
    {
      if ((this.u == null) || (this.u.equals("")))
      {
        String str1 = this.j.getPackageName();
        this.u = str1;
      }
      return this.u;
    }
    catch (Exception localException)
    {
      while (true)
      {
        int i1 = Log.w("Crittercism", "Call to getPackageName() failed.  Please contact us at support@crittercism.com.");
        String str2 = new String();
        this.u = str2;
      }
    }
  }

  public final int e()
  {
    try
    {
      float f1 = this.f.e();
      i1 = (int)(f1 * 10.0F / 160.0F);
      return i1;
    }
    catch (Exception localException)
    {
      while (true)
        int i1 = -1;
    }
  }

  class a
    implements Thread.UncaughtExceptionHandler
  {
    private Thread.UncaughtExceptionHandler b;

    public a(Thread.UncaughtExceptionHandler arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      try
      {
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
        paramThrowable.printStackTrace(localPrintWriter);
        if (!Crittercism.a(Crittercism.a()))
        {
          String str1 = localStringWriter.toString();
          int i = Log.e("Crittercism", str1);
        }
        label48: if ((paramThread != null) && (paramThread.getName() != null) && (paramThread.getName().equals("main")))
          Object localObject1 = null;
        try
        {
          if (Crittercism.a() == null)
            throw new Exception("Failed to log error to Crittercism.");
        }
        catch (Exception localException1)
        {
          Object localObject2;
          while (true)
          {
            int j = Log.w("Crittercism", "Failed to log error with Crittercism.  Please contact us at support@crittercism.com.");
            StringBuilder localStringBuilder = new StringBuilder("Did not log error to Crittercism.  EXCEPTION: ");
            String str2 = localException1.getClass().getName();
            String str3 = str2;
            if (this.b == null)
              return;
            if ((this.b instanceof a))
              return;
            this.b.uncaughtException(paramThread, paramThrowable);
            return;
            localObject2 = null;
          }
          if (!Crittercism.a(Crittercism.a()))
          {
            Crittercism localCrittercism = Crittercism.a();
            String str4 = Crittercism.b.a;
            boolean bool = localCrittercism.a(paramThrowable);
          }
          if ((localObject2 != null) && (!Crittercism.b(Crittercism.a())))
            Crittercism.this.c();
          if (this.b == null)
            return;
          if ((this.b instanceof a))
            return;
          this.b.uncaughtException(paramThread, paramThrowable);
          return;
        }
        finally
        {
          if ((this.b != null) && (!(this.b instanceof a)))
            this.b.uncaughtException(paramThread, paramThrowable);
        }
      }
      catch (Exception localException2)
      {
        break label48;
      }
    }
  }

  public static class b
  {
    public static String a = "uhe";
    public static String b = "uhe-bg";
    public static String c = "error";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crittercism.app.Crittercism
 * JD-Core Version:    0.6.2
 */