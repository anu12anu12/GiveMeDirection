package com.crittercism.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import crittercism.android.a;
import crittercism.android.c;
import crittercism.android.d;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CrittercismService extends Service
{
  Timer a = null;
  final String b = "CritterTimer";
  final String c = "CrittercismService";
  NotificationManager d;
  ArrayList e;
  private final ICritter.a f;
  private TimerTask g;

  public CrittercismService()
  {
    ArrayList localArrayList = new ArrayList();
    this.e = localArrayList;
    ICritter.a local1 = new ICritter.a()
    {
      public final String a(String paramAnonymousString)
      {
        return CrittercismService.this.a(paramAnonymousString);
      }

      public final void a(ApplicationInfo paramAnonymousApplicationInfo)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder("******** NEW CLIENT PACKAGE REGISTER: ");
          String str1 = paramAnonymousApplicationInfo.toString();
          String str2 = str1;
          if (CrittercismService.this.e.contains(paramAnonymousApplicationInfo))
            return;
          boolean bool = CrittercismService.this.e.add(paramAnonymousApplicationInfo);
          CrittercismService.a locala = CrittercismService.a.a();
          JSONArray localJSONArray = new JSONArray();
          locala.a(localJSONArray);
          return;
        }
        catch (Exception localException)
        {
        }
      }

      public final void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        CrittercismService.this.a(paramAnonymousString1, paramAnonymousString2);
      }

      public final void b(ApplicationInfo paramAnonymousApplicationInfo)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("******** REMOVING CLIENT PACKAGE REGISTER: ");
        String str1 = paramAnonymousApplicationInfo.toString();
        String str2 = str1;
        int i = 0;
        try
        {
          while (true)
          {
            int j = CrittercismService.this.e.size();
            if (i >= j)
              return;
            ApplicationInfo localApplicationInfo = (ApplicationInfo)CrittercismService.this.e.get(i);
            String str3 = localApplicationInfo.packageName;
            String str4 = paramAnonymousApplicationInfo.packageName;
            if (str3.equals(str4))
            {
              boolean bool = CrittercismService.this.e.remove(localApplicationInfo);
              return;
            }
            i += 1;
          }
        }
        catch (Exception localException)
        {
          int k = Log.e("CrittercismService", "Failed to unregister client.");
          StringBuilder localStringBuilder2 = new StringBuilder("Exception Name: ");
          String str5 = localException.getClass().getName();
          String str6 = str5;
          int m = Log.e("CrittercismService", str6);
          StringBuilder localStringBuilder3 = new StringBuilder("Exception Message: ");
          String str7 = localException.getMessage();
          String str8 = str7;
          int n = Log.e("CrittercismService", str8);
        }
      }

      public final void b(String paramAnonymousString)
      {
        if (paramAnonymousString == null)
          int i = Log.e("CrittercismService", "STRING IS NULL");
        try
        {
          while (true)
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousString);
            if (localJSONObject.has("did"))
            {
              CrittercismService localCrittercismService = CrittercismService.this;
              CrittercismService.a(localJSONObject);
            }
            StringBuilder localStringBuilder = new StringBuilder("Called d from thread ");
            String str1 = Long.toString(Thread.currentThread().getId());
            String str2 = str1;
            JSONArray localJSONArray = new JSONArray().put(localJSONObject);
            CrittercismService.a.a().a(localJSONArray);
            return;
            String str3 = "d string: " + paramAnonymousString;
          }
        }
        catch (JSONException localJSONException)
        {
          int j = Log.e("CrittercismService", "Failed to log error.");
        }
      }
    };
    this.f = local1;
    TimerTask local3 = new TimerTask()
    {
      public final void run()
      {
      }
    };
    this.g = local3;
  }

  public final String a(String paramString)
  {
    String str1 = null;
    try
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
      if (localSharedPreferences != null)
      {
        str1 = localSharedPreferences.getString(paramString, null);
        if (str1 != null)
          String str2 = "***** READ " + paramString + " = " + str1;
      }
      label51: return str1;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }

  public final void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = PreferenceManager.getDefaultSharedPreferences(this);
      if (localObject == null)
        return;
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject == null)
        return;
      SharedPreferences.Editor localEditor = ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      boolean bool = ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      String str = localException.toString();
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.f;
  }

  public void onCreate()
  {
    super.onCreate();
    int i = Log.i("CrittercismService", "Service creating");
    a.a(this);
    a.b();
    a.a(this);
    a.f();
    NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
    this.d = localNotificationManager;
    String str = a("com.crittercism.prefs.did");
    Timer localTimer = new Timer("CritterTimer");
    this.a = localTimer;
  }

  public void onDestroy()
  {
    int i = Log.i("CrittercismService", "Service destroying");
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        CrittercismService.a.c();
      }
    };
    new Thread(local2).start();
    this.d.cancel(1);
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
    super.onDestroy();
  }

  static class a
  {
    private static Context a;
    private static a b = new a();
    private static final String e = d.a();
    private static final String f = str + "/android_v1/crash";
    private static boolean h = false;
    private boolean c = false;
    private c d;
    private List g;
    private a i;

    static
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = e;
    }

    private a()
    {
      c localc = new c("1");
      this.d = localc;
      Vector localVector = new Vector();
      this.g = localVector;
      a locala = new a();
      this.i = locala;
    }

    public static a a()
    {
      return b;
    }

    public static void a(Context paramContext)
    {
      a = paramContext;
    }

    public static void b()
    {
      a locala = b;
      c localc = new c("1");
      locala.d = localc;
      locala.c = true;
      Vector localVector = new Vector();
      locala.g = localVector;
      h = false;
      locala.i.start();
    }

    public static void c()
    {
      h = true;
    }

    public static void f()
    {
      JSONArray localJSONArray1 = new JSONArray();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a);
      try
      {
        String str1 = new JSONArray().toString();
        String str2 = localSharedPreferences.getString("stacktracesJsonArray", str1);
        localJSONArray2 = new JSONArray(str2);
        StringBuilder localStringBuilder = new StringBuilder("Size of stacktraces is ");
        String str3 = Integer.toString(localJSONArray2.length());
        String str4 = str3;
        localJSONArray3 = new JSONArray();
        if (localJSONArray2.length() == 0)
          localObject1 = "";
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          BufferedReader localBufferedReader;
          while (true)
          {
            File localFile1 = Environment.getExternalStorageDirectory();
            File localFile2 = new File(localFile1, "critter.txt");
            FileInputStream localFileInputStream = new FileInputStream(localFile2);
            InputStreamReader localInputStreamReader = new InputStreamReader(localFileInputStream);
            localBufferedReader = new BufferedReader(localInputStreamReader);
            while (true)
            {
              localObject2 = localBufferedReader.readLine();
              if (localObject2 == null)
                break;
              String str5 = (String)localObject1 + (String)localObject2;
              localObject1 = str5;
            }
            localJSONException1 = localJSONException1;
            localJSONArray2 = new JSONArray();
          }
          localBufferedReader.close();
          localObject2 = localObject1;
        }
        catch (Exception localException)
        {
          try
          {
            while (true)
            {
              JSONArray localJSONArray2;
              Object localObject1;
              JSONArray localJSONArray4 = new JSONArray((String)localObject2);
              if (localJSONArray3.length() != 0)
                break;
              b.a(localJSONArray2);
              return;
              localException = localException;
              Object localObject2 = localObject1;
            }
          }
          catch (JSONException localJSONException2)
          {
            JSONArray localJSONArray3;
            while (true)
              localJSONArray3 = new JSONArray();
            b.a(localJSONArray3);
          }
        }
      }
    }

    private static void g()
    {
      JSONArray localJSONArray1 = new JSONArray();
      try
      {
        SharedPreferences.Editor localEditor1 = PreferenceManager.getDefaultSharedPreferences(a).edit();
        SharedPreferences.Editor localEditor2 = localEditor1.remove("stacktracesJsonArray");
        int j = 0;
        while (true)
        {
          int k = b.g.size();
          if (j >= k)
            break;
          JSONObject localJSONObject1 = new JSONObject();
          JSONObject localJSONObject2 = (JSONObject)b.g.get(j);
          JSONArray localJSONArray2 = localJSONArray1.put(localJSONObject2);
          j += 1;
        }
        StringBuilder localStringBuilder = new StringBuilder("CrittercismService.onDestroy(): Size of stacktraces is ");
        String str1 = Integer.toString(localJSONArray1.length());
        String str2 = str1;
        String str3 = localJSONArray1.toString();
        SharedPreferences.Editor localEditor3 = localEditor1.putString("stacktracesJsonArray", str3);
        if (localEditor1.commit())
          return;
        throw new Exception();
      }
      catch (Exception localException)
      {
        try
        {
          File localFile1 = Environment.getExternalStorageDirectory();
          if (!localFile1.canWrite())
            return;
          File localFile2 = new File(localFile1, "critter.txt");
          FileWriter localFileWriter = new FileWriter(localFile2);
          BufferedWriter localBufferedWriter = new BufferedWriter(localFileWriter);
          String str4 = localJSONArray1.toString();
          localBufferedWriter.write(str4);
          localBufferedWriter.close();
          return;
        }
        catch (IOException localIOException)
        {
          int m = Log.w("CrittercismService", "Failed to store offline crashes!!");
        }
      }
    }

    /** @deprecated */
    private static void h()
    {
      try
      {
        if (b.g.size() != 0)
        {
          StringBuilder localStringBuilder1 = new StringBuilder("PendingStacktraceList is size: ");
          String str1 = Integer.toString(b.g.size());
          String str2 = str1;
        }
        int j = 0;
        while (true)
        {
          int k = b.g.size();
          if (j < k)
          {
            JSONObject localJSONObject = (JSONObject)b.g.get(j);
            try
            {
              StringBuilder localStringBuilder2 = new StringBuilder("Stacktrace ");
              String str3 = Integer.toString(j);
              String str4 = str3;
              StringBuilder localStringBuilder3 = new StringBuilder("Thread Id: ");
              long l1 = localJSONObject.getLong("current_thread_id");
              String str5 = l1;
              while (true)
              {
                try
                {
                  Iterator localIterator = localJSONObject.keys();
                  if (!localIterator.hasNext())
                    break label265;
                  String str6 = (String)localIterator.next();
                  Object localObject1 = localJSONObject.get(str6);
                  if (!(localObject1 instanceof String))
                    continue;
                  StringBuilder localStringBuilder4 = new StringBuilder("Name: ").append(str6).append("\tValue: ");
                  String str7 = (String)localObject1;
                  String str8 = str7;
                  continue;
                }
                catch (Exception localException)
                {
                  int m = Log.e("CrittercismService", "Error printing stacktraces!!");
                  localException.printStackTrace();
                  j += 1;
                }
                break;
                label265: StringBuilder localStringBuilder5 = new StringBuilder("Name: current_thread_id\tValue: ");
                long l2 = localJSONObject.getLong("current_thread_id");
                String str9 = l2;
              }
            }
            catch (JSONException localJSONException)
            {
              while (true)
              {
                StringBuilder localStringBuilder6 = new StringBuilder("JSONException thrown at index ");
                String str10 = Integer.toString(j);
                String str11 = str10 + "!!";
              }
            }
          }
        }
      }
      finally
      {
      }
    }

    public final void a(JSONArray paramJSONArray)
    {
      if (h)
        return;
      int j = 0;
      while (true)
      {
        int k = paramJSONArray.length();
        if (j < k)
        {
          JSONObject localJSONObject1 = new JSONObject();
          try
          {
            l1 = paramJSONArray.getJSONObject(j);
            l2 = l1;
          }
          catch (JSONException localJSONException3)
          {
            try
            {
              long l2;
              long l1 = l2.getLong("current_thread_id");
              l3 = l1;
            }
            catch (JSONException localJSONException3)
            {
              try
              {
                long l3;
                List localList = b.g;
                JSONObject localJSONObject2 = paramJSONArray.getJSONObject(j);
                boolean bool = localList.add(localJSONObject2);
                StringBuilder localStringBuilder1 = new StringBuilder("Added stacktrace from thread ");
                String str1 = Long.toString(l3);
                String str2 = str1 + "!";
                while (true)
                {
                  j += 1;
                  break;
                  localJSONException2.printStackTrace();
                  continue;
                  localJSONException3.printStackTrace();
                }
              }
              catch (JSONException localJSONException1)
              {
                while (true)
                {
                  StringBuilder localStringBuilder2 = new StringBuilder("Skipping stacktrace in this thread at index ");
                  String str3 = Integer.toString(j);
                  String str4 = str3 + "...";
                  StringBuilder localStringBuilder3 = new StringBuilder("JSONException for stacktrace at index ");
                  String str5 = Integer.toString(j);
                  String str6 = str5;
                }
              }
            }
          }
        }
      }
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          CrittercismService.a.this.d();
        }
      };
      new Thread(local1).start();
    }

    /** @deprecated */
    final void d()
    {
      try
      {
        notifyAll();
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          StringBuilder localStringBuilder = new StringBuilder("Shit! ");
          String str1 = localException.getClass().getName();
          String str2 = str1;
          localException.printStackTrace();
        }
      }
      finally
      {
      }
    }

    /** @deprecated */
    // ERROR //
    final void e()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: getstatic 56	com/crittercism/service/CrittercismService$a:h	Z
      //   5: ifne +345 -> 350
      //   8: getstatic 33	com/crittercism/service/CrittercismService$a:b	Lcom/crittercism/service/CrittercismService$a;
      //   11: getfield 73	com/crittercism/service/CrittercismService$a:g	Ljava/util/List;
      //   14: invokeinterface 176 1 0
      //   19: lstore_1
      //   20: lload_1
      //   21: ifnonnull +25 -> 46
      //   24: aload_0
      //   25: invokevirtual 325	java/lang/Object:wait	()V
      //   28: goto -20 -> 8
      //   31: astore_3
      //   32: getstatic 33	com/crittercism/service/CrittercismService$a:b	Lcom/crittercism/service/CrittercismService$a;
      //   35: getfield 73	com/crittercism/service/CrittercismService$a:g	Ljava/util/List;
      //   38: invokeinterface 176 1 0
      //   43: ifeq -35 -> 8
      //   46: getstatic 33	com/crittercism/service/CrittercismService$a:b	Lcom/crittercism/service/CrittercismService$a;
      //   49: getfield 73	com/crittercism/service/CrittercismService$a:g	Ljava/util/List;
      //   52: invokeinterface 176 1 0
      //   57: ifle -55 -> 2
      //   60: getstatic 33	com/crittercism/service/CrittercismService$a:b	Lcom/crittercism/service/CrittercismService$a;
      //   63: getfield 73	com/crittercism/service/CrittercismService$a:g	Ljava/util/List;
      //   66: iconst_0
      //   67: invokeinterface 327 2 0
      //   72: checkcast 178	org/json/JSONObject
      //   75: astore 4
      //   77: aload 4
      //   79: ldc 231
      //   81: invokevirtual 235	org/json/JSONObject:getLong	(Ljava/lang/String;)J
      //   84: lstore_1
      //   85: lload_1
      //   86: lstore 5
      //   88: new 42	java/lang/StringBuilder
      //   91: dup
      //   92: ldc_w 329
      //   95: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   98: astore 7
      //   100: lload 5
      //   102: invokestatic 288	java/lang/Long:toString	(J)Ljava/lang/String;
      //   105: astore 8
      //   107: aload 7
      //   109: aload 8
      //   111: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: ldc_w 295
      //   117: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   120: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   123: astore 9
      //   125: getstatic 33	com/crittercism/service/CrittercismService$a:b	Lcom/crittercism/service/CrittercismService$a;
      //   128: getfield 68	com/crittercism/service/CrittercismService$a:d	Lcrittercism/android/c;
      //   131: astore 10
      //   133: getstatic 54	com/crittercism/service/CrittercismService$a:f	Ljava/lang/String;
      //   136: astore 11
      //   138: aload 10
      //   140: aload 11
      //   142: aload 4
      //   144: invokevirtual 332	crittercism/android/c:a	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
      //   147: astore 12
      //   149: aload 12
      //   151: ifnull +120 -> 271
      //   154: aload 12
      //   156: ldc 122
      //   158: if_acmpeq +113 -> 271
      //   161: new 42	java/lang/StringBuilder
      //   164: dup
      //   165: ldc_w 334
      //   168: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   171: aload 12
      //   173: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   176: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   179: astore 13
      //   181: new 42	java/lang/StringBuilder
      //   184: dup
      //   185: ldc_w 336
      //   188: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   191: astore 14
      //   193: lload 5
      //   195: invokestatic 288	java/lang/Long:toString	(J)Ljava/lang/String;
      //   198: astore 15
      //   200: aload 14
      //   202: aload 15
      //   204: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: ldc_w 338
      //   210: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   213: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   216: astore 16
      //   218: goto -172 -> 46
      //   221: astore 17
      //   223: ldc 215
      //   225: ldc_w 340
      //   228: invokestatic 264	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   231: istore 18
      //   233: getstatic 33	com/crittercism/service/CrittercismService$a:b	Lcom/crittercism/service/CrittercismService$a;
      //   236: getfield 73	com/crittercism/service/CrittercismService$a:g	Ljava/util/List;
      //   239: aload 4
      //   241: invokeinterface 281 2 0
      //   246: istore 19
      //   248: invokestatic 342	com/crittercism/service/CrittercismService$a:h	()V
      //   251: invokestatic 344	com/crittercism/service/CrittercismService$a:g	()V
      //   254: aconst_null
      //   255: astore 4
      //   257: aload_0
      //   258: aload 4
      //   260: invokevirtual 347	java/lang/Object:wait	(J)V
      //   263: goto -217 -> 46
      //   266: astore 20
      //   268: goto -222 -> 46
      //   271: ldc 215
      //   273: ldc_w 349
      //   276: invokestatic 264	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   279: istore 21
      //   281: goto -48 -> 233
      //   284: astore 22
      //   286: ldc 215
      //   288: ldc_w 351
      //   291: invokestatic 264	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   294: istore 23
      //   296: goto -63 -> 233
      //   299: astore 24
      //   301: aload_0
      //   302: monitorexit
      //   303: aload 24
      //   305: athrow
      //   306: astore 25
      //   308: ldc 215
      //   310: ldc_w 351
      //   313: invokestatic 264	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   316: istore 26
      //   318: goto -85 -> 233
      //   321: astore 27
      //   323: aload 27
      //   325: invokevirtual 313	java/lang/Object:getClass	()Ljava/lang/Class;
      //   328: invokevirtual 318	java/lang/Class:getName	()Ljava/lang/String;
      //   331: astore 28
      //   333: ldc 215
      //   335: aload 28
      //   337: invokestatic 264	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   340: istore 29
      //   342: aload 27
      //   344: invokevirtual 267	java/lang/Exception:printStackTrace	()V
      //   347: goto -301 -> 46
      //   350: invokestatic 344	com/crittercism/service/CrittercismService$a:g	()V
      //   353: aload_0
      //   354: monitorexit
      //   355: return
      //   356: astore 30
      //   358: goto -312 -> 46
      //
      // Exception table:
      //   from	to	target	type
      //   24	28	31	java/lang/InterruptedException
      //   88	218	221	crittercism/android/g
      //   271	281	221	crittercism/android/g
      //   257	263	266	java/lang/InterruptedException
      //   88	218	284	java/io/IOException
      //   271	281	284	java/io/IOException
      //   2	20	299	finally
      //   24	28	299	finally
      //   32	77	299	finally
      //   77	85	299	finally
      //   88	218	299	finally
      //   223	254	299	finally
      //   257	263	299	finally
      //   271	281	299	finally
      //   286	296	299	finally
      //   308	353	299	finally
      //   88	218	306	java/lang/Exception
      //   271	281	306	java/lang/Exception
      //   257	263	321	java/lang/Exception
      //   77	85	356	org/json/JSONException
    }

    class a extends Thread
    {
      public a()
      {
      }

      public final void run()
      {
        CrittercismService.a.a().e();
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crittercism.service.CrittercismService
 * JD-Core Version:    0.6.2
 */