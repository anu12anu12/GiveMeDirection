package com.crashlytics.android;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class t
{
  private static final short[] a = tmp26_21;
  private static final Map<String, String> b = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
  private static t c;
  private static final FilenameFilter f = new u();
  private final Object d;
  private Thread e;

  static
  {
     tmp1_0 = null;
    tmp1_0[0] = 10;
     tmp6_1 = tmp1_0;
    tmp6_1[1] = 20;
     tmp11_6 = tmp6_1;
    tmp11_6[2] = 30;
     tmp16_11 = tmp11_6;
    tmp16_11[3] = 60;
     tmp21_16 = tmp16_11;
    tmp21_16[4] = 120;
     tmp26_21 = tmp21_16;
    tmp26_21[5] = 300;
  }

  private t()
  {
    Object localObject = new Object();
    this.d = localObject;
  }

  /** @deprecated */
  public static t a()
  {
    try
    {
      if (c == null)
        c = new t();
      t localt = c;
      return localt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean a(s params, URL paramURL)
  {
    Object localObject1 = null;
    boolean bool1 = null;
    if (paramURL == null)
      D.a("No submission URL, aborting upload.", null);
    while (true)
    {
      return bool1;
      try
      {
        while (true)
        {
          synchronized (this.d)
          {
            if ((D.d()) && (!Crashlytics.getInstance().n().k()))
            {
              D.c("Crash reporting disabled for emulator, not uploading report: " + params);
              boolean bool2 = params.a();
              bool1 = true;
              break;
            }
            boolean bool3 = params.a(paramURL);
            StringBuilder localStringBuilder = new StringBuilder("Report ");
            if (bool3)
            {
              str = "sent";
              D.c(str + " successfully");
              if (!bool3)
                break label183;
              boolean bool4 = params.a();
              Object localObject3 = localObject1;
            }
          }
          String str = "NOT SENT";
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          D.a("Error occurred sending report " + params, localException);
          continue;
          label183: Object localObject2 = null;
        }
      }
    }
  }

  // ERROR //
  private static URL d()
  {
    // Byte code:
    //   0: invokestatic 80	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   3: invokevirtual 84	com/crashlytics/android/Crashlytics:n	()Lcom/crashlytics/android/B;
    //   6: astore_0
    //   7: aload_0
    //   8: invokevirtual 219	com/crashlytics/android/B:j	()Ljava/lang/String;
    //   11: astore_1
    //   12: aload_1
    //   13: astore_2
    //   14: new 221	java/net/URL
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 222	java/net/URL:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: areturn
    //   25: astore_3
    //   26: aconst_null
    //   27: astore_2
    //   28: new 91	java/lang/StringBuilder
    //   31: dup
    //   32: ldc 224
    //   34: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: aload_3
    //   45: invokestatic 71	com/crashlytics/android/D:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: aconst_null
    //   49: astore_0
    //   50: goto -27 -> 23
    //   53: astore_3
    //   54: goto -26 -> 28
    //
    // Exception table:
    //   from	to	target	type
    //   7	12	25	java/lang/Exception
    //   14	23	53	java/lang/Exception
  }

  /** @deprecated */
  public final void a(Context paramContext, float paramFloat)
  {
    try
    {
      if (this.e == null)
      {
        A localA = new A(this, paramContext, paramFloat);
        Thread localThread = new Thread(localA);
        this.e = localThread;
        this.e.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean a(s params)
  {
    URL localURL = d();
    return a(params, localURL);
  }

  final List<s> b()
  {
    int i = 0;
    D.c("Checking for crash reports...");
    while (true)
    {
      LinkedList localLinkedList;
      synchronized (this.d)
      {
        File localFile1 = Crashlytics.k();
        FilenameFilter localFilenameFilter1 = f;
        File[] arrayOfFile = localFile1.listFiles(localFilenameFilter1);
        localObject2 = Crashlytics.getInstance().o().b();
        if (!((File)localObject2).exists())
          break label276;
        FilenameFilter localFilenameFilter2 = d.a;
        localObject2 = ((File)localObject2).listFiles(localFilenameFilter2);
        localLinkedList = new LinkedList();
        int j = arrayOfFile.length;
        k = 0;
        if (k < j)
        {
          File localFile2 = arrayOfFile[k];
          StringBuilder localStringBuilder1 = new StringBuilder("Found crash report ");
          String str1 = localFile2.getPath();
          D.c(str1);
          s locals1 = new s(localFile2);
          boolean bool1 = localLinkedList.add(locals1);
          k += 1;
        }
      }
      int k = localObject2.length;
      while (i < k)
      {
        File localFile3 = localObject2[i];
        StringBuilder localStringBuilder2 = new StringBuilder("Found invalid crash file ");
        String str2 = localFile3.getPath();
        D.c(str2);
        Map localMap = b;
        s locals2 = new s(localFile3, localMap);
        boolean bool2 = localLinkedList.add(locals2);
        i += 1;
      }
      if (localLinkedList.size() == 0)
        D.c("No reports found.");
      return localLinkedList;
      label276: Object localObject2 = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.t
 * JD-Core Version:    0.6.2
 */