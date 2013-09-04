package com.crashlytics.android;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class j
  implements Thread.UncaughtExceptionHandler
{
  private static final Map<String, String> a = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
  private static FilenameFilter c = new k();
  private final a b;
  private int d;
  private final Thread.UncaughtExceptionHandler e;
  private final File f;
  private boolean g;
  private RandomAccessFile h;
  private boolean i;
  private String j;
  private Date k;
  private String l;
  private boolean m;
  private BroadcastReceiver n;
  private BroadcastReceiver o;
  private Thread[] p;
  private List<StackTraceElement[]> q;
  private StackTraceElement[] r;
  private ActivityManager.RunningAppProcessInfo s;
  private a t;
  private a u;
  private int v;
  private boolean w;
  private ReentrantLock x;
  private final Lock y;

  public j(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, CrashlyticsListener paramCrashlyticsListener)
  {
    a locala1 = a.a("0");
    this.b = locala1;
    this.v = 0;
    this.w = false;
    ReentrantLock localReentrantLock1 = new ReentrantLock();
    this.x = localReentrantLock1;
    ReentrantLock localReentrantLock2 = new ReentrantLock();
    this.y = localReentrantLock2;
    this.e = paramUncaughtExceptionHandler;
    this.g = false;
    File localFile1 = Crashlytics.k();
    File localFile2 = new File(localFile1, "invalidClsFiles");
    this.f = localFile2;
    Object[] arrayOfObject = new Object[1];
    String str1 = Crashlytics.getCrashlyticsVersion();
    arrayOfObject[0] = str1;
    String str2 = String.format("Crashlytics Android SDK/%s", arrayOfObject);
    this.j = str2;
    Date localDate = new Date();
    this.k = localDate;
    String str3 = new b().toString();
    this.l = str3;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str4 = this.l;
    String str5 = str4 + "SessionEvent";
    B localB = Crashlytics.getInstance().n();
    int i1 = localB.m();
    this.d = i1;
    int i2 = localB.o();
    this.v = i2;
    boolean bool = localB.n();
    this.w = bool;
    File localFile3 = Crashlytics.k();
    File localFile4 = new File(localFile3, "crash_marker");
    try
    {
      if ((localFile4.exists()) && (localFile4.delete()) && (paramCrashlyticsListener != null))
        paramCrashlyticsListener.crashlyticsDidDetectCrashDuringPreviousExecution();
      File localFile5 = Crashlytics.k();
      FilenameFilter localFilenameFilter = d.a;
      File[] arrayOfFile = localFile5.listFiles(localFilenameFilter);
      if (arrayOfFile.length > 0)
      {
        n localn = new n(this, arrayOfFile);
        new Thread(localn).start();
      }
      a locala2 = a.a(Crashlytics.g());
      this.t = locala2;
      Resources localResources = Crashlytics.f().getResources();
      String str6 = Crashlytics.g();
      int i3 = localResources.getIdentifier("com.crashlytics.android.build_id", "string", str6);
      if (i3 != 0)
      {
        a locala3 = a.a(Crashlytics.f().getResources().getString(i3).replace("-", ""));
        this.u = locala3;
        StringBuilder localStringBuilder2 = new StringBuilder("Setting binary image id to ");
        String str7 = this.u.b();
        D.c(str7);
        l locall = new l(this);
        this.o = locall;
        IntentFilter localIntentFilter1 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        m localm = new m(this);
        this.n = localm;
        IntentFilter localIntentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        ContextWrapper localContextWrapper1 = Crashlytics.f();
        BroadcastReceiver localBroadcastReceiver1 = this.o;
        Intent localIntent1 = localContextWrapper1.registerReceiver(localBroadcastReceiver1, localIntentFilter1);
        ContextWrapper localContextWrapper2 = Crashlytics.f();
        BroadcastReceiver localBroadcastReceiver2 = this.n;
        Intent localIntent2 = localContextWrapper2.registerReceiver(localBroadcastReceiver2, localIntentFilter2);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        D.a("Could not start crash detector for previous session", localException);
        continue;
        D.c("String resource com.crashlytics.android.build_id not found");
      }
    }
  }

  private static int a(float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    int i1 = c.f(1) + 4 + 0;
    int i2 = c.f(2);
    int i3 = c.h(c.j(paramInt1));
    int i4 = i2 + i3;
    int i5 = i1 + i4;
    int i6 = c.f(3) + 1;
    int i7 = i5 + i6;
    int i8 = c.d(4, paramInt2);
    int i9 = i7 + i8;
    int i10 = c.b(5, paramLong1);
    int i11 = i9 + i10;
    int i12 = c.b(6, paramLong2);
    return i11 + i12;
  }

  private int a(int paramInt1, a parama1, a parama2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map<IdManager.DeviceIdentifierType, String> paramMap, int paramInt3, a parama3, a parama4)
  {
    int i1 = c.b(1, parama1) + 0;
    int i2 = c.e(3, paramInt1) + i1;
    if (parama2 == null);
    int i12;
    for (int i3 = 0; ; i3 = c.b(4, parama2))
    {
      int i4 = i3 + i2;
      int i5 = c.d(5, paramInt2);
      int i6 = i4 + i5;
      int i7 = c.b(6, paramLong1);
      int i8 = i6 + i7;
      int i9 = c.b(7, paramLong2);
      int i10 = i8 + i9;
      int i11 = c.f(10) + 1;
      i12 = i10 + i11;
      if (paramMap == null)
        break;
      Iterator localIterator = paramMap.entrySet().iterator();
      int i14;
      int i17;
      for (i13 = i12; localIterator.hasNext(); i13 = i14 + i17 + i13)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        IdManager.DeviceIdentifierType localDeviceIdentifierType = (IdManager.DeviceIdentifierType)localEntry.getKey();
        String str = (String)localEntry.getValue();
        i14 = a(localDeviceIdentifierType, str);
        int i15 = c.f(11);
        int i16 = c.h(i14);
        i17 = i15 + i16;
      }
    }
    int i13 = i12;
    int i18 = paramInt3;
    int i19 = c.d(12, i18);
    int i20 = i13 + i19;
    int i21;
    int i22;
    if (parama3 == null)
    {
      i21 = 0;
      i22 = i20 + i21;
      if (parama4 != null)
        break label287;
    }
    label287: a locala2;
    for (int i23 = 0; ; i23 = c.b(14, locala2))
    {
      return i23 + i22;
      a locala1 = parama3;
      i21 = c.b(13, locala1);
      break;
      locala2 = parama4;
    }
  }

  private static int a(IdManager.DeviceIdentifierType paramDeviceIdentifierType, String paramString)
  {
    int i1 = paramDeviceIdentifierType.protobufIndex;
    int i2 = c.e(1, i1);
    a locala = a.a(paramString);
    int i3 = c.b(2, locala);
    return i2 + i3;
  }

  private static int a(StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    int i1;
    int i3;
    int i6;
    if (paramStackTraceElement.isNativeMethod())
    {
      long l1 = Math.max(paramStackTraceElement.getLineNumber(), 0);
      i1 = c.b(1, l1) + 0;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = paramStackTraceElement.getClassName();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(".");
      String str2 = paramStackTraceElement.getMethodName();
      a locala1 = a.a(str2);
      int i2 = c.b(2, locala1);
      i3 = i1 + i2;
      if (paramStackTraceElement.getFileName() != null)
      {
        a locala2 = a.a(paramStackTraceElement.getFileName());
        int i4 = c.b(3, locala2);
        int i5 = i3 + i4;
      }
      if ((paramStackTraceElement.isNativeMethod()) || (paramStackTraceElement.getLineNumber() <= 0))
        break label200;
      long l2 = paramStackTraceElement.getLineNumber();
      i6 = c.b(4, l2);
    }
    label200: for (int i7 = i3 + i6; ; i7 = i3)
    {
      int i8 = 5;
      if (paramBoolean);
      for (int i9 = 2; ; i9 = 0)
      {
        return c.d(i8, i9) + i7;
        i1 = c.b(1, 0L) + 0;
        break;
      }
    }
  }

  private static int a(String paramString1, String paramString2)
  {
    a locala1 = a.a(paramString1);
    int i1 = c.b(1, locala1);
    if (paramString2 == null)
      paramString2 = "";
    a locala2 = a.a(paramString2);
    int i2 = c.b(2, locala2);
    return i1 + i2;
  }

  private int a(Thread paramThread, Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement1 = this.r;
    int i1 = a(paramThread, arrayOfStackTraceElement1, 4, true);
    int i2 = c.f(1);
    int i3 = c.h(i1);
    int i4 = i2 + i3;
    int i5 = i1 + i4 + 0;
    int i6 = this.p.length;
    int i7 = 0;
    int i8 = i5;
    while (i7 < i6)
    {
      Thread localThread = this.p[i7];
      StackTraceElement[] arrayOfStackTraceElement2 = (StackTraceElement[])this.q.get(i7);
      int i9 = a(localThread, arrayOfStackTraceElement2, 0, false);
      int i10 = c.f(1);
      int i11 = c.h(i9);
      int i12 = i10 + i11;
      int i13 = i9 + i12;
      i8 += i13;
      i7 += 1;
    }
    int i14 = a(paramThrowable, 1);
    int i15 = c.f(2);
    int i16 = c.h(i14);
    int i17 = i15 + i16;
    int i18 = i14 + i17 + i8;
    int i19 = l();
    int i20 = c.f(3);
    int i21 = c.h(i19);
    int i22 = i20 + i21;
    int i23 = i19 + i22;
    int i24 = i18 + i23;
    int i25 = k();
    int i26 = c.f(3);
    int i27 = c.h(i25);
    int i28 = i26 + i27;
    int i29 = i25 + i28;
    return i24 + i29;
  }

  private int a(Thread paramThread, Throwable paramThrowable, Map<String, String> paramMap)
  {
    int i1 = a(paramThread, paramThrowable);
    int i2 = c.f(1);
    int i3 = c.h(i1);
    int i4 = i2 + i3;
    int i5 = i1 + i4 + 0;
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      int i7;
      int i10;
      for (i6 = i5; localIterator.hasNext(); i6 = i7 + i10 + i6)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        String str2 = (String)localEntry.getValue();
        i7 = a(str1, str2);
        int i8 = c.f(2);
        int i9 = c.h(i7);
        i10 = i8 + i9;
      }
    }
    int i6 = i5;
    if (this.s != null)
    {
      int i11 = 3;
      if (this.s.importance != 100);
      int i12 = c.f(i11) + 1;
      i6 += i12;
    }
    int i13 = Crashlytics.f().getResources().getConfiguration().orientation;
    return c.d(4, i13) + i6;
  }

  private int a(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    a locala = a.a(paramThread.getName());
    int i1 = c.b(1, locala) + 0;
    int i2 = c.d(2, paramInt) + i1;
    int i3 = paramArrayOfStackTraceElement.length;
    int i4 = 0;
    while (i4 < i3)
    {
      int i5 = a(paramArrayOfStackTraceElement[i4], paramBoolean);
      int i6 = c.f(3);
      int i7 = c.h(i5);
      int i8 = i6 + i7;
      int i9 = i5 + i8;
      i2 += i9;
      i4 += 1;
    }
    return i2;
  }

  private int a(Throwable paramThrowable, int paramInt)
  {
    int i1 = 0;
    a locala1 = a.a(paramThrowable.getClass().getName());
    int i2 = c.b(1, locala1) + 0;
    String str = paramThrowable.getLocalizedMessage();
    if (str != null)
    {
      a locala2 = a.a(str);
      int i3 = c.b(3, locala2);
      i2 += i3;
    }
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int i4 = arrayOfStackTraceElement.length;
    int i5 = 0;
    while (i5 < i4)
    {
      int i6 = a(arrayOfStackTraceElement[i5], true);
      int i7 = c.f(4);
      int i8 = c.h(i6);
      int i9 = i7 + i8;
      int i10 = i6 + i9 + i2;
      i5 += 1;
      i2 = i10;
    }
    Throwable localThrowable = paramThrowable.getCause();
    if (localThrowable != null)
    {
      int i11 = this.d;
      if (paramInt >= i11)
        break label208;
      int i12 = paramInt + 1;
      int i13 = a(localThrowable, i12);
      int i14 = c.f(6);
      int i15 = c.h(i13);
      int i16 = i14 + i15;
      int i17 = i13 + i16;
      i2 += i17;
    }
    while (true)
    {
      return i2;
      label208: 
      while (localThrowable != null)
      {
        localThrowable = localThrowable.getCause();
        i1 += 1;
      }
      int i18 = c.d(7, i1);
      i2 += i18;
    }
  }

  private static a a(String paramString)
  {
    if (paramString == null);
    for (a locala = null; ; locala = a.a(paramString))
      return locala;
  }

  private void a(c paramc, int paramInt, StackTraceElement paramStackTraceElement, boolean paramBoolean)
    throws Exception
  {
    int i1 = 4;
    paramc.f(paramInt, 2);
    int i2 = a(paramStackTraceElement, paramBoolean);
    paramc.g(i2);
    int i3;
    if (paramStackTraceElement.isNativeMethod())
    {
      long l1 = Math.max(paramStackTraceElement.getLineNumber(), 0);
      paramc.a(1, l1);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = paramStackTraceElement.getClassName();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(".");
      String str2 = paramStackTraceElement.getMethodName();
      a locala1 = a.a(str2);
      paramc.a(2, locala1);
      if (paramStackTraceElement.getFileName() != null)
      {
        a locala2 = a.a(paramStackTraceElement.getFileName());
        paramc.a(3, locala2);
      }
      if ((!paramStackTraceElement.isNativeMethod()) && (paramStackTraceElement.getLineNumber() > 0))
      {
        long l2 = paramStackTraceElement.getLineNumber();
        paramc.a(4, l2);
      }
      i3 = 5;
      if (!paramBoolean)
        break label185;
    }
    while (true)
    {
      paramc.a(i3, i1);
      return;
      paramc.a(1, 0L);
      break;
      label185: i1 = 0;
    }
  }

  private static void a(c paramc, File paramFile)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    int i1 = 0;
    while (true)
    {
      int i2 = arrayOfByte.length;
      if (i1 >= i2)
        break;
      int i3 = arrayOfByte.length - i1;
      int i4 = localFileInputStream.read(arrayOfByte, i1, i3);
      if (i4 < 0)
        break;
      i1 += i4;
    }
    localFileInputStream.close();
    paramc.a(arrayOfByte);
    boolean bool = paramFile.delete();
  }

  private void a(c paramc, Thread paramThread, Throwable paramThrowable)
    throws Exception
  {
    paramc.f(1, 2);
    int i1 = a(paramThread, paramThrowable);
    paramc.g(i1);
    StackTraceElement[] arrayOfStackTraceElement1 = this.r;
    j localj1 = this;
    c localc1 = paramc;
    Thread localThread1 = paramThread;
    localj1.a(localc1, localThread1, arrayOfStackTraceElement1, 4, true);
    int i2 = this.p.length;
    int i3 = 0;
    while (i3 < i2)
    {
      Thread localThread2 = this.p[i3];
      StackTraceElement[] arrayOfStackTraceElement2 = (StackTraceElement[])this.q.get(i3);
      j localj2 = this;
      c localc2 = paramc;
      localj2.a(localc2, localThread2, arrayOfStackTraceElement2, 0, false);
      i3 += 1;
    }
    a(paramc, paramThrowable, 1, 2);
    paramc.f(3, 2);
    int i4 = l();
    paramc.g(i4);
    a locala1 = this.b;
    paramc.a(1, locala1);
    a locala2 = this.b;
    paramc.a(2, locala2);
    paramc.a(3, 0L);
    paramc.f(4, 2);
    int i5 = k();
    paramc.g(i5);
    paramc.a(1, 0L);
    paramc.a(2, 0L);
    a locala3 = this.t;
    paramc.a(3, locala3);
    if (this.u == null)
      return;
    a locala4 = this.u;
    paramc.a(4, locala4);
  }

  private void a(c paramc, Thread paramThread, Throwable paramThrowable, String paramString)
    throws Exception
  {
    long l1 = new Date().getTime() / 1000L;
    float f1 = D.a(Crashlytics.f());
    int i1 = D.a(this.m);
    boolean bool1 = D.b(Crashlytics.f());
    int i2 = Crashlytics.f().getResources().getConfiguration().orientation;
    long l2 = Debug.getNativeHeapAllocatedSize();
    String str1 = Environment.getDataDirectory().getPath();
    StatFs localStatFs = new StatFs(str1);
    long l3 = localStatFs.getBlockCount();
    long l4 = localStatFs.getBlockSize();
    long l5 = l3 * l4;
    long l6 = localStatFs.getAvailableBlocks();
    long l7 = localStatFs.getBlockSize();
    long l8 = l6 * l7;
    long l9 = l5 - l8;
    String str2 = Crashlytics.g();
    ContextWrapper localContextWrapper1 = Crashlytics.f();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = D.a(str2, localContextWrapper1);
    this.s = localRunningAppProcessInfo;
    Set localSet = Thread.getAllStackTraces().keySet();
    Thread[] arrayOfThread1 = new Thread[localSet.size()];
    Thread[] arrayOfThread2 = (Thread[])localSet.toArray(arrayOfThread1);
    this.p = arrayOfThread2;
    LinkedList localLinkedList = new LinkedList();
    this.q = localLinkedList;
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      StackTraceElement[] arrayOfStackTraceElement1 = ((Thread)localIterator.next()).getStackTrace();
      int i3 = arrayOfStackTraceElement1.length;
      StackTraceElement[] arrayOfStackTraceElement2 = (StackTraceElement[])Array.newInstance(StackTraceElement.class, i3);
      int i4 = arrayOfStackTraceElement1.length;
      int i5 = 0;
      int i6 = 0;
      int i7 = i4;
      System.arraycopy(arrayOfStackTraceElement1, i5, arrayOfStackTraceElement2, i6, i7);
      boolean bool2 = this.q.add(arrayOfStackTraceElement2);
    }
    int i8 = paramThrowable.getStackTrace().length;
    StackTraceElement[] arrayOfStackTraceElement3 = (StackTraceElement[])Array.newInstance(StackTraceElement.class, i8);
    this.r = arrayOfStackTraceElement3;
    StackTraceElement[] arrayOfStackTraceElement4 = paramThrowable.getStackTrace();
    StackTraceElement[] arrayOfStackTraceElement5 = this.r;
    int i9 = 0;
    System.arraycopy(arrayOfStackTraceElement4, 0, arrayOfStackTraceElement5, i9, i8);
    a locala1 = m();
    this.h = null;
    this.i = false;
    ContextWrapper localContextWrapper2 = Crashlytics.f();
    boolean bool3 = true;
    Object localObject;
    if (!D.a(localContextWrapper2, "com.crashlytics.CollectCustomKeys", bool3))
      localObject = new TreeMap();
    while (true)
    {
      c localc1 = paramc;
      int i10 = 2;
      localc1.f(10, i10);
      int i11 = c.b(1, l1) + 0;
      a locala2 = a.a(paramString);
      int i12 = c.b(2, locala2);
      int i13 = i11 + i12;
      j localj1 = this;
      Thread localThread1 = paramThread;
      Throwable localThrowable1 = paramThrowable;
      int i14 = localj1.a(localThread1, localThrowable1, (Map)localObject);
      int i15 = c.f(3);
      int i16 = c.h(i14);
      int i17 = i15 + i16;
      int i18 = i14 + i17;
      int i19 = i13 + i18;
      int i20 = a(f1, i1, bool1, i2, l2, l9);
      int i21 = c.f(5);
      int i22 = c.h(i20);
      int i23 = i21 + i22;
      int i24 = i20 + i23;
      int i25 = i19 + i24;
      if (locala1 != null)
      {
        int i26 = c.b(1, locala1);
        int i27 = c.f(6);
        int i28 = c.h(i26);
        int i29 = i27 + i28;
        int i30 = i26 + i29;
        i25 += i30;
      }
      paramc.g(i25);
      paramc.a(1, l1);
      a locala3 = a.a(paramString);
      paramc.a(2, locala3);
      paramc.f(3, 2);
      j localj2 = this;
      Thread localThread2 = paramThread;
      Throwable localThrowable2 = paramThrowable;
      int i31 = localj2.a(localThread2, localThrowable2, (Map)localObject);
      paramc.g(i31);
      a(paramc, paramThread, paramThrowable);
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        j localj3 = this;
        c localc2 = paramc;
        localj3.a(localc2, (Map)localObject);
      }
      int i32;
      if (this.s != null)
      {
        i32 = 3;
        if (this.s.importance == 100)
          break label916;
      }
      Map localMap;
      label916: for (boolean bool4 = true; ; bool4 = false)
      {
        paramc.a(i32, bool4);
        int i33 = Crashlytics.f().getResources().getConfiguration().orientation;
        paramc.a(4, i33);
        paramc.f(5, 2);
        int i34 = a(f1, i1, bool1, i2, l2, l9);
        paramc.g(i34);
        paramc.a(1, f1);
        paramc.c(2, i1);
        paramc.a(3, bool1);
        paramc.a(4, i2);
        paramc.a(5, l2);
        paramc.a(6, l9);
        if (locala1 == null)
          return;
        paramc.f(6, 2);
        int i35 = c.b(1, locala1);
        paramc.g(i35);
        paramc.a(1, locala1);
        return;
        localMap = Crashlytics.getInstance().d();
        if (localMap == null)
          break label922;
        int i36 = localMap.size();
        int i37 = 1;
        if (i36 <= i37)
          break label922;
        localObject = new TreeMap(localMap);
        break;
      }
      label922: localObject = localMap;
    }
  }

  private void a(c paramc, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
    throws Exception
  {
    paramc.f(1, 2);
    int i1 = a(paramThread, paramArrayOfStackTraceElement, paramInt, paramBoolean);
    paramc.g(i1);
    a locala = a.a(paramThread.getName());
    paramc.a(1, locala);
    paramc.a(2, paramInt);
    int i2 = paramArrayOfStackTraceElement.length;
    int i3 = 0;
    while (true)
    {
      if (i3 >= i2)
        return;
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i3];
      a(paramc, 3, localStackTraceElement, paramBoolean);
      i3 += 1;
    }
  }

  private void a(c paramc, Throwable paramThrowable, int paramInt1, int paramInt2)
    throws Exception
  {
    int i1 = 0;
    paramc.f(paramInt2, 2);
    int i2 = a(paramThrowable, 1);
    paramc.g(i2);
    a locala1 = a.a(paramThrowable.getClass().getName());
    paramc.a(1, locala1);
    String str = paramThrowable.getLocalizedMessage();
    if (str != null)
    {
      a locala2 = a.a(str);
      paramc.a(3, locala2);
    }
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int i3 = arrayOfStackTraceElement.length;
    int i4 = 0;
    while (i4 < i3)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i4];
      a(paramc, 4, localStackTraceElement, true);
      i4 += 1;
    }
    Throwable localThrowable = paramThrowable.getCause();
    if (localThrowable == null)
      return;
    int i5 = this.d;
    if (paramInt1 < i5)
    {
      int i6 = paramInt1 + 1;
      a(paramc, localThrowable, i6, 6);
      return;
    }
    while (localThrowable != null)
    {
      localThrowable = localThrowable.getCause();
      i1 += 1;
    }
    paramc.a(7, i1);
  }

  private void a(c paramc, Map<String, String> paramMap)
    throws Exception
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramc.f(2, 2);
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      int i1 = a(str1, str2);
      paramc.g(i1);
      a locala1 = a.a((String)localEntry.getKey());
      paramc.a(1, locala1);
      String str3 = (String)localEntry.getValue();
      if (str3 == null)
        str3 = "";
      a locala2 = a.a(str3);
      paramc.a(2, locala2);
    }
  }

  private void a(Thread paramThread, Throwable paramThrowable, String paramString)
    throws Exception
  {
    File localFile1 = Crashlytics.k();
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this.l;
    String str2 = str1 + "SessionUser";
    d locald = new d(localFile1, str2);
    Object localObject1 = c.a(locald);
    Object localObject2 = Crashlytics.getInstance().a();
    String str3 = Crashlytics.getInstance().c();
    String str4 = Crashlytics.getInstance().b();
    a locala1;
    a locala2;
    if ((localObject2 != null) || (str3 != null) || (str4 != null))
    {
      if (localObject2 == null)
        localObject2 = "";
      locala1 = a.a((String)localObject2);
      if (str3 != null)
        break label283;
      locala2 = null;
      if (str4 != null)
        break label293;
    }
    File[] arrayOfFile1;
    label283: label293: for (localObject2 = null; ; localObject2 = a.a(str4))
    {
      int i2 = c.b(1, locala1) + 0;
      if (locala2 != null)
      {
        int i3 = c.b(2, locala2);
        i2 += i3;
      }
      if (localObject2 != null)
      {
        int i4 = c.b(3, (a)localObject2);
        i2 += i4;
      }
      ((c)localObject1).f(6, 2);
      ((c)localObject1).g(i2);
      ((c)localObject1).a(1, locala1);
      if (locala2 != null)
        ((c)localObject1).a(2, locala2);
      if (localObject2 != null)
        ((c)localObject1).a(3, (a)localObject2);
      ((c)localObject1).a();
      locald.close();
      localFile2 = Crashlytics.k();
      p localp1 = new p(this, "BeginSession");
      arrayOfFile1 = localFile2.listFiles(localp1);
      if ((arrayOfFile1 != null) && (arrayOfFile1.length > 0))
        break label303;
      D.c("Can't find a session begin File");
      return;
      locala2 = a.a(str3);
      break;
    }
    label303: String str5 = arrayOfFile1[0].getName();
    int i5 = str5.indexOf("BeginSession");
    String str6 = str5.substring(0, i5);
    locald = new d(localFile2, str6);
    c localc = c.a(locald);
    File localFile3 = arrayOfFile1[0];
    a(localc, localFile3);
    long l1 = new Date().getTime() / 1000L;
    localc.a(4, l1);
    int i6 = 5;
    boolean bool1;
    int i1;
    int i7;
    if (paramThrowable != null)
    {
      bool1 = true;
      localc.a(i6, bool1);
      localObject1 = new String[4];
      localObject1[0] = "SessionUser";
      localObject1[1] = "SessionApp";
      localObject1[2] = "SessionOS";
      localObject1[3] = "SessionDevice";
      i1 = localObject1.length;
      i7 = 0;
    }
    while (true)
    {
      if (i7 >= i1)
        break label552;
      locala1 = localObject1[i7];
      p localp2 = new p(this, locala1);
      File[] arrayOfFile2 = localFile2.listFiles(localp2);
      if ((arrayOfFile2 == null) || (arrayOfFile2.length <= 0))
      {
        D.c("Can't find a " + locala1 + " File");
        return;
        bool1 = false;
        break;
      }
      File localFile4 = arrayOfFile2[0];
      a(localc, localFile4);
      i7 += 1;
    }
    label552: int i8 = this.v;
    File localFile5 = Crashlytics.k();
    p localp3 = new p(this, "SessionEvent");
    D.a(localFile5, localp3, i8);
    p localp4 = new p(this, "SessionEvent");
    File[] arrayOfFile3 = localFile2.listFiles(localp4);
    if ((arrayOfFile3 != null) && (arrayOfFile3.length > 0))
    {
      Comparator localComparator = D.a;
      Arrays.sort(arrayOfFile3, localComparator);
      int i9 = arrayOfFile3.length + -1;
      while (i9 >= 0)
      {
        StringBuilder localStringBuilder2 = new StringBuilder("Found Session Event:  ");
        String str7 = arrayOfFile3[i9].getPath();
        D.c(str7);
        File localFile6 = arrayOfFile3[i9];
        a(localc, localFile6);
        i9 += -1;
      }
    }
    if (paramThrowable != null)
      a(localc, paramThread, paramThrowable, paramString);
    localc.a(11, 1);
    localc.b(12, 3);
    localc.a();
    locald.close();
    if ((!this.w) && (paramThrowable == null))
    {
      boolean bool2 = locald.a().delete();
      return;
    }
    File localFile7 = new File(localFile2, "crash_marker");
    new FileOutputStream(localFile7).close();
    B localB = Crashlytics.getInstance().n();
    File localFile2 = locald.a();
    if (localFile2 == null)
      return;
    if (!localB.a())
      return;
    ContextWrapper localContextWrapper = Crashlytics.f();
    if (localB.a(localContextWrapper))
      return;
    if (paramThrowable == null)
      return;
    D.c("Attempting to send crash report at time of crash...");
    o localo = new o(this, localFile2);
    new Thread(localo).start();
  }

  private boolean g()
  {
    boolean bool1 = false;
    if (!D.a(Crashlytics.f(), "com.crashlytics.CollectCustomLogs", true));
    while (true)
    {
      return bool1;
      try
      {
        if (this.h != null)
          this.h.close();
        localObject = null;
      }
      catch (Exception localException1)
      {
        try
        {
          File localFile1 = Crashlytics.f().getFilesDir();
          File localFile2 = File.createTempFile("crashlytics-userlog-", ".temp", localFile1);
          RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile2, "rw");
          this.h = localRandomAccessFile1;
          this.i = false;
          boolean bool2 = localFile2.delete();
          bool1 = true;
          continue;
          localException1 = localException1;
          StringBuilder localStringBuilder = new StringBuilder("Could not close log file: ");
          RandomAccessFile localRandomAccessFile2 = this.h;
          D.a(localRandomAccessFile2, localException1);
        }
        catch (Exception localException2)
        {
          Object localObject;
          D.a("Could not create log file: " + localObject, localException2);
        }
      }
    }
  }

  private static int h()
  {
    a locala1 = a.a(Crashlytics.l());
    int i1 = c.b(1, locala1) + 0;
    int i2 = Process.myPid();
    int i3 = c.d(2, i2);
    int i4 = i1 + i3;
    a locala2 = a.a(Crashlytics.f().getPackageCodePath());
    int i5 = c.b(3, locala2) + i4;
    Object[] arrayOfObject = D.a(i2);
    int i7;
    int i8;
    if ((arrayOfObject != null) && (arrayOfObject.length > 1))
    {
      a locala3 = a.a((String)arrayOfObject[1]);
      int i6 = c.b(4, locala3);
      i7 = i5 + i6;
      i8 = ((Integer)arrayOfObject[0]).intValue();
    }
    for (int i9 = c.d(5, i8) + i7; ; i9 = i5)
      return i9;
  }

  private static int i()
  {
    a locala = a.a(Crashlytics.j());
    return c.b(1, locala) + 0;
  }

  private void j()
    throws Exception
  {
    d locald = new com/crashlytics/android/d;
    File localFile = Crashlytics.k();
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.l;
    String str2 = str1 + "SessionDevice";
    locald.<init>(localFile, str2);
    c localc1 = c.a(locald);
    String str3 = Environment.getDataDirectory().getPath();
    StatFs localStatFs = new StatFs(str3);
    String str4 = D.b().toUpperCase();
    int i1;
    if (str4.startsWith("ARMV7"))
      i1 = 6;
    a locala2;
    a locala3;
    int i3;
    while (true)
    {
      a locala1 = a(Build.MODEL);
      locala2 = a(Build.MANUFACTURER);
      locala3 = a(Build.PRODUCT);
      int i2 = Runtime.getRuntime().availableProcessors();
      long l1 = D.c();
      long l2 = localStatFs.getBlockCount();
      long l3 = localStatFs.getBlockSize();
      long l4 = l2 * l3;
      boolean bool = D.d();
      IdManager localIdManager = Crashlytics.getInstance().e();
      a locala4 = a.a(localIdManager.c());
      Map localMap = localIdManager.d();
      i3 = D.f();
      c localc2 = localc1;
      int i4 = 2;
      localc2.f(9, i4);
      int i5 = a(i1, locala4, locala1, i2, l1, l4, bool, localMap, i3, locala2, locala3);
      localc1.g(i5);
      localc1.a(1, locala4);
      localc1.b(3, i1);
      localc1.a(4, locala1);
      localc1.a(5, i2);
      localc1.a(6, l1);
      localc1.a(7, l4);
      localc1.a(10, bool);
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localc1.f(11, 2);
        IdManager.DeviceIdentifierType localDeviceIdentifierType = (IdManager.DeviceIdentifierType)localEntry.getKey();
        String str5 = (String)localEntry.getValue();
        int i6 = a(localDeviceIdentifierType, str5);
        localc1.g(i6);
        int i7 = ((IdManager.DeviceIdentifierType)localEntry.getKey()).protobufIndex;
        localc1.b(1, i7);
        a locala5 = a.a((String)localEntry.getValue());
        localc1.a(2, locala5);
      }
      if (str4.startsWith("ARMV6"))
      {
        i1 = 5;
      }
      else if (str4.startsWith("ARMV"))
      {
        i1 = 7;
      }
      else
      {
        D.c("Unexpected non-ARM architecture type: " + str4);
        i1 = 7;
      }
    }
    localc1.a(12, i3);
    if (locala2 != null)
      localc1.a(13, locala2);
    if (locala3 != null)
      localc1.a(14, locala3);
    localc1.a();
    locald.close();
  }

  private int k()
  {
    int i1 = c.b(1, 0L) + 0;
    int i2 = c.b(2, 0L);
    int i3 = i1 + i2;
    a locala1 = this.t;
    int i4 = c.b(3, locala1);
    int i5 = i3 + i4;
    if (this.u != null)
    {
      a locala2 = this.u;
      int i6 = c.b(4, locala2);
      i5 += i6;
    }
    return i5;
  }

  private int l()
  {
    a locala1 = this.b;
    int i1 = c.b(1, locala1) + 0;
    a locala2 = this.b;
    int i2 = c.b(2, locala2);
    int i3 = i1 + i2;
    int i4 = c.b(3, 0L);
    return i3 + i4;
  }

  private a m()
  {
    Object localObject = null;
    if (this.h == null);
    while (true)
    {
      return localObject;
      try
      {
        int i1 = (int)this.h.getFilePointer();
        if ((i1 != 0) || (this.i))
        {
          ByteBuffer localByteBuffer1 = ByteBuffer.allocate(i1);
          FileChannel localFileChannel = this.h.getChannel();
          int i2 = localFileChannel.read(localByteBuffer1, 0L);
          Buffer localBuffer1 = localByteBuffer1.position(0);
          if (this.i)
          {
            RandomAccessFile localRandomAccessFile = this.h;
            long l1 = i1;
            localRandomAccessFile.seek(l1);
            String str = this.h.readLine();
            int i3 = (int)this.h.getFilePointer();
            ByteBuffer localByteBuffer2 = ByteBuffer.allocate(64000 - i3);
            long l2 = this.h.getFilePointer();
            int i4 = localFileChannel.read(localByteBuffer2, l2);
            Buffer localBuffer2 = localByteBuffer2.position(0);
            a[] arrayOfa = new a[2];
            a locala1 = a.a(localByteBuffer2);
            arrayOfa[0] = locala1;
            a locala2 = a.a(localByteBuffer1);
            arrayOfa[1] = locala2;
            localObject = a.a(Arrays.asList(arrayOfa));
          }
          else
          {
            a locala3 = a.a(localByteBuffer1);
            localObject = locala3;
          }
        }
      }
      catch (Exception localException)
      {
        D.a("Could not convert log to ByteString", localException);
      }
    }
  }

  /** @deprecated */
  final void a(long paramLong, String paramString)
  {
    while (true)
    {
      try
      {
        if ((this.h == null) && (!g()))
        {
          D.c("Could not instantiate log for message: " + paramString);
          return;
        }
        if (paramString != null)
          break label273;
        str1 = "null";
        try
        {
          Object[] arrayOfObject = new Object[2];
          Long localLong = Long.valueOf(paramLong);
          arrayOfObject[0] = localLong;
          String str2 = str1.replaceAll("\n", " ");
          arrayOfObject[1] = str2;
          str1 = String.format("%d %s%n", arrayOfObject);
          long l1 = this.h.getFilePointer();
          long l2 = str1.length();
          if (l1 + l2 < 64000L)
            break label261;
          this.i = true;
          long l3 = this.h.getFilePointer();
          long l4 = str1.length();
          int i1 = (int)(l3 + l4 - 64000L);
          int i2 = str1.length() - i1;
          RandomAccessFile localRandomAccessFile1 = this.h;
          String str3 = str1.substring(0, i2);
          localRandomAccessFile1.writeBytes(str3);
          this.h.seek(0L);
          RandomAccessFile localRandomAccessFile2 = this.h;
          String str4 = str1.substring(i2);
          localRandomAccessFile2.writeBytes(str4);
        }
        catch (Exception localException)
        {
          D.a("Failed to log message: " + str1, localException);
        }
        continue;
      }
      finally
      {
      }
      label261: this.h.writeBytes(str1);
      continue;
      label273: String str1 = paramString;
    }
  }

  final boolean a()
  {
    return this.g;
  }

  final File b()
  {
    return this.f;
  }

  final void c()
  {
    this.x.lock();
    while (true)
    {
      try
      {
        File localFile = Crashlytics.k();
        p localp1 = new p(this, "SessionEvent");
        int i2 = localFile.list(localp1).length;
        if (i2 > 0)
        {
          localFile = null;
          localObject1 = null;
          int i3 = 0;
          try
          {
            a(localFile, (Throwable)localObject1, i3);
            return;
          }
          catch (Exception localException)
          {
            D.a("Unable to collect session events", localException);
            continue;
          }
        }
      }
      finally
      {
        this.x.unlock();
      }
      p localp2 = new p(this, "Session");
      Object localObject1 = localException.listFiles(localp2);
      int i4 = localObject1.length;
      int i1 = 0;
      while (i1 < i4)
      {
        boolean bool = localObject1[i1].delete();
        i1 += 1;
      }
    }
  }

  final void d()
    throws Exception
  {
    this.x.lock();
    try
    {
      File localFile1 = Crashlytics.k();
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = this.l;
      String str2 = str1 + "BeginSession";
      d locald1 = new d(localFile1, str2);
      c localc1 = c.a(locald1);
      a locala1 = a.a(this.j);
      localc1.a(1, locala1);
      a locala2 = a.a(this.l);
      localc1.a(2, locala2);
      long l1 = this.k.getTime() / 1000L;
      localc1.a(3, l1);
      localc1.a();
      locald1.close();
      File localFile2 = Crashlytics.k();
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str3 = this.l;
      String str4 = str3 + "SessionApp";
      d locald2 = new d(localFile2, str4);
      c localc2 = c.a(locald2);
      a locala3 = a.a(Crashlytics.g());
      a locala4 = a.a(Crashlytics.i());
      a locala5 = a.a(Crashlytics.h());
      a locala6 = a.a(Crashlytics.l());
      a locala7 = a.a(Crashlytics.f().getPackageCodePath());
      a locala8 = a.a(Crashlytics.getInstance().e().b());
      localc2.f(7, 2);
      int i1 = c.b(1, locala3) + 0;
      int i2 = c.b(2, locala4);
      int i3 = i1 + i2;
      int i4 = c.b(3, locala5);
      int i5 = i3 + i4;
      int i6 = h();
      int i7 = c.f(4);
      int i8 = c.h(i6);
      int i9 = i7 + i8;
      int i10 = i6 + i9;
      int i11 = i5 + i10;
      int i12 = i();
      int i13 = c.f(5);
      int i14 = c.h(i12);
      int i15 = i13 + i14;
      int i16 = i12 + i15;
      int i17 = i11 + i16;
      int i18 = c.b(6, locala8);
      int i19 = i17 + i18;
      localc2.g(i19);
      localc2.a(1, locala3);
      localc2.a(2, locala4);
      localc2.a(3, locala5);
      localc2.f(4, 2);
      int i20 = h();
      localc2.g(i20);
      localc2.a(1, locala6);
      int i21 = Process.myPid();
      localc2.a(2, i21);
      localc2.a(3, locala7);
      Object[] arrayOfObject = D.a(i21);
      if ((arrayOfObject != null) && (arrayOfObject.length > 1))
      {
        a locala9 = a.a((String)arrayOfObject[1]);
        localc2.a(4, locala9);
        int i22 = ((Integer)arrayOfObject[0]).intValue();
        localc2.a(5, i22);
      }
      localc2.f(5, 2);
      int i23 = i();
      localc2.g(i23);
      String str5 = Crashlytics.j();
      localc2.a(1, str5);
      localc2.a(6, locala8);
      localc2.a();
      locald2.close();
      File localFile3 = Crashlytics.k();
      StringBuilder localStringBuilder3 = new StringBuilder();
      String str6 = this.l;
      String str7 = str6 + "SessionOS";
      d locald3 = new d(localFile3, str7);
      c localc3 = c.a(locald3);
      a locala10 = a.a(Build.VERSION.RELEASE);
      a locala11 = a.a(Build.VERSION.CODENAME);
      boolean bool = D.e();
      localc3.f(8, 2);
      int i24 = c.e(1, 3) + 0;
      int i25 = c.b(2, locala10);
      int i26 = i24 + i25;
      int i27 = c.b(3, locala11);
      int i28 = i26 + i27;
      int i29 = c.f(4) + 1;
      int i30 = i28 + i29;
      localc3.g(i30);
      localc3.b(1, 3);
      localc3.a(2, locala10);
      localc3.a(3, locala11);
      localc3.a(4, bool);
      localc3.a();
      locald3.close();
      j();
      return;
    }
    finally
    {
      this.x.unlock();
    }
  }

  final void e()
  {
    this.x.lock();
    try
    {
      File localFile = Crashlytics.k();
      FilenameFilter localFilenameFilter = c;
      D.a(localFile, localFilenameFilter, 4);
      return;
    }
    finally
    {
      this.x.unlock();
    }
  }

  /** @deprecated */
  // ERROR //
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: iconst_1
    //   6: putfield 100	com/crashlytics/android/j:g	Z
    //   9: new 143	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 907
    //   16: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_2
    //   20: invokevirtual 713	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: ldc_w 909
    //   26: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: astore 4
    //   31: aload_1
    //   32: invokevirtual 417	java/lang/Thread:getName	()Ljava/lang/String;
    //   35: astore 5
    //   37: aload 4
    //   39: aload 5
    //   41: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 252	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   50: invokestatic 211	com/crashlytics/android/Crashlytics:f	()Landroid/content/ContextWrapper;
    //   53: astore 6
    //   55: aload_0
    //   56: getfield 259	com/crashlytics/android/j:o	Landroid/content/BroadcastReceiver;
    //   59: astore 7
    //   61: aload 6
    //   63: aload 7
    //   65: invokevirtual 913	android/content/ContextWrapper:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   68: invokestatic 211	com/crashlytics/android/Crashlytics:f	()Landroid/content/ContextWrapper;
    //   71: astore 8
    //   73: aload_0
    //   74: getfield 269	com/crashlytics/android/j:n	Landroid/content/BroadcastReceiver;
    //   77: astore 9
    //   79: aload 8
    //   81: aload 9
    //   83: invokevirtual 913	android/content/ContextWrapper:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   86: aload_0
    //   87: aload_1
    //   88: aload_2
    //   89: ldc_w 915
    //   92: invokespecial 872	com/crashlytics/android/j:a	(Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   95: aload_0
    //   96: invokevirtual 917	com/crashlytics/android/j:e	()V
    //   99: ldc_w 919
    //   102: invokestatic 252	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 98	com/crashlytics/android/j:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   109: aload_1
    //   110: aload_2
    //   111: invokeinterface 921 3 0
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 100	com/crashlytics/android/j:g	Z
    //   121: aload_0
    //   122: monitorexit
    //   123: return
    //   124: astore_3
    //   125: ldc_w 923
    //   128: aload_3
    //   129: invokestatic 280	com/crashlytics/android/D:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: ldc_w 919
    //   135: invokestatic 252	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield 98	com/crashlytics/android/j:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   142: aload_1
    //   143: aload_2
    //   144: invokeinterface 921 3 0
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 100	com/crashlytics/android/j:g	Z
    //   154: goto -33 -> 121
    //   157: astore 10
    //   159: aload_0
    //   160: monitorexit
    //   161: aload 10
    //   163: athrow
    //   164: astore_3
    //   165: ldc_w 919
    //   168: invokestatic 252	com/crashlytics/android/D:c	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: getfield 98	com/crashlytics/android/j:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   175: aload_1
    //   176: aload_2
    //   177: invokeinterface 921 3 0
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 100	com/crashlytics/android/j:g	Z
    //   187: aload_3
    //   188: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	99	124	java/lang/Exception
    //   4	9	157	finally
    //   99	121	157	finally
    //   132	154	157	finally
    //   165	189	157	finally
    //   9	99	164	finally
    //   125	132	164	finally
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.j
 * JD-Core Version:    0.6.2
 */