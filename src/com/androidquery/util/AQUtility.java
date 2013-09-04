package com.androidquery.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.androidquery.AQuery;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class AQUtility
{
  private static final int IO_BUFFER_SIZE = 4096;
  private static File cacheDir;
  private static Context context;
  private static boolean debug = false;
  private static Thread.UncaughtExceptionHandler eh;
  private static Handler handler;
  private static File pcacheDir;
  private static ScheduledExecutorService storeExe;
  private static Map<String, Long> times = new HashMap();
  private static Object wait;

  public static void apply(SharedPreferences.Editor paramEditor)
  {
    if (AQuery.SDK_INT >= 9)
    {
      SharedPreferences.Editor localEditor = paramEditor;
      Object[] arrayOfObject = null;
      Object localObject = invokeHandler(localEditor, "apply", false, true, null, arrayOfObject);
      return;
    }
    boolean bool = paramEditor.commit();
  }

  public static void cleanCache(File paramFile, long paramLong1, long paramLong2)
  {
    try
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
        return;
      Common localCommon = new Common();
      Arrays.sort(arrayOfFile, localCommon);
      if (testCleanNeeded(arrayOfFile, paramLong1))
        cleanCache(arrayOfFile, paramLong2);
      File localFile = getTempDir();
      if (localFile == null)
        return;
      if (!localFile.exists())
        return;
      cleanCache(localFile.listFiles(), 0L);
      return;
    }
    catch (Exception localException)
    {
      report(localException);
    }
  }

  private static void cleanCache(File[] paramArrayOfFile, long paramLong)
  {
    int i = 0;
    while (true)
    {
      int j = paramArrayOfFile.length;
      if (i >= j)
      {
        Integer localInteger = Integer.valueOf(0);
        debug("deleted", localInteger);
        return;
      }
      File localFile = paramArrayOfFile[i];
      if (localFile.isFile())
      {
        long l = localFile.length();
        if (0L + l >= paramLong)
        {
          boolean bool = localFile.delete();
          int k = 0 + 1;
        }
      }
      i += 1;
    }
  }

  public static void cleanCacheAsync(Context paramContext)
  {
    cleanCacheAsync(paramContext, 3000000L, 2000000L);
  }

  public static void cleanCacheAsync(Context paramContext, long paramLong1, long paramLong2)
  {
    try
    {
      File localFile = getCacheDir(paramContext);
      Common localCommon1 = new Common();
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localFile;
      Long localLong1 = Long.valueOf(paramLong1);
      arrayOfObject[1] = localLong1;
      Long localLong2 = Long.valueOf(paramLong2);
      arrayOfObject[2] = localLong2;
      Common localCommon2 = localCommon1.method(2, arrayOfObject);
      ScheduledExecutorService localScheduledExecutorService = getFileStoreExecutor();
      TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
      ScheduledFuture localScheduledFuture = localScheduledExecutorService.schedule(localCommon2, 0L, localTimeUnit);
      return;
    }
    catch (Exception localException)
    {
      report(localException);
    }
  }

  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    copy(paramInputStream, paramOutputStream, 0, null);
  }

  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt, Progress paramProgress)
    throws IOException
  {
    Integer localInteger = Integer.valueOf(paramInt);
    debug("content header", localInteger);
    if (paramProgress != null)
    {
      paramProgress.reset();
      paramProgress.setBytes(paramInt);
    }
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
      {
        if (paramProgress == null)
          return;
        paramProgress.done();
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      if (paramProgress != null)
        paramProgress.increment(i);
    }
  }

  public static void debug(Object paramObject)
  {
    if (!debug)
      return;
    String str = paramObject;
    int i = Log.w("AQuery", str);
  }

  public static void debug(Object paramObject1, Object paramObject2)
  {
    if (!debug)
      return;
    String str = paramObject1 + ":" + paramObject2;
    int i = Log.w("AQuery", str);
  }

  public static void debug(Throwable paramThrowable)
  {
    if (!debug)
      return;
    String str = Log.getStackTraceString(paramThrowable);
    int i = Log.w("AQuery", str);
  }

  public static void debugNotify()
  {
    if (!debug)
      return;
    if (wait == null)
      return;
    synchronized (wait)
    {
      wait.notifyAll();
      return;
    }
  }

  public static void debugWait(long paramLong)
  {
    if (!debug)
      return;
    if (wait == null)
      wait = new Object();
    try
    {
      synchronized (wait)
      {
        wait.wait(paramLong);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        localInterruptedException.printStackTrace();
    }
  }

  public static int dip2pixel(Context paramContext, float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    return (int)TypedValue.applyDimension(1, paramFloat, localDisplayMetrics);
  }

  public static void ensureUIThread()
  {
    if (isUIThread())
      return;
    report(new IllegalStateException("Not UI Thread"));
  }

  public static File getCacheDir(Context paramContext)
  {
    if (cacheDir == null)
    {
      File localFile = paramContext.getCacheDir();
      cacheDir = new File(localFile, "aquery");
      boolean bool = cacheDir.mkdirs();
    }
    return cacheDir;
  }

  public static File getCacheDir(Context paramContext, int paramInt)
  {
    File localFile1;
    if (paramInt == 1)
      if (pcacheDir != null)
        localFile1 = pcacheDir;
    while (true)
    {
      return localFile1;
      File localFile2 = getCacheDir(paramContext);
      pcacheDir = new File(localFile2, "persistent");
      boolean bool = pcacheDir.mkdirs();
      localFile1 = pcacheDir;
      continue;
      localFile1 = getCacheDir(paramContext);
    }
  }

  public static File getCacheFile(File paramFile, String paramString)
  {
    File localFile;
    if (paramString == null)
      localFile = null;
    while (true)
    {
      return localFile;
      String str1 = File.separator;
      if (paramString.startsWith(str1))
      {
        localFile = new File(paramString);
      }
      else
      {
        String str2 = getCacheFileName(paramString);
        localFile = makeCacheFile(paramFile, str2);
      }
    }
  }

  private static String getCacheFileName(String paramString)
  {
    return getMD5Hex(paramString);
  }

  public static Context getContext()
  {
    if (context == null)
    {
      warn("warn", "getContext with null");
      debug(new IllegalStateException());
    }
    return context;
  }

  public static File getExistedCacheByUrl(File paramFile, String paramString)
  {
    File localFile = getCacheFile(paramFile, paramString);
    if ((localFile == null) || (!localFile.exists()))
      localFile = null;
    return localFile;
  }

  public static File getExistedCacheByUrlSetAccess(File paramFile, String paramString)
  {
    File localFile = getExistedCacheByUrl(paramFile, paramString);
    if (localFile != null)
      lastAccess(localFile);
    return localFile;
  }

  private static ScheduledExecutorService getFileStoreExecutor()
  {
    if (storeExe == null)
      storeExe = Executors.newSingleThreadScheduledExecutor();
    return storeExe;
  }

  public static Handler getHandler()
  {
    if (handler == null)
    {
      Looper localLooper = Looper.getMainLooper();
      handler = new Handler(localLooper);
    }
    return handler;
  }

  private static byte[] getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      byte[] arrayOfByte1 = localMessageDigest.digest();
      arrayOfByte2 = arrayOfByte1;
      return arrayOfByte2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
      {
        report(localNoSuchAlgorithmException);
        byte[] arrayOfByte2 = null;
      }
    }
  }

  private static String getMD5Hex(String paramString)
  {
    byte[] arrayOfByte = getMD5(paramString.getBytes());
    return new BigInteger(arrayOfByte).abs().toString(36);
  }

  public static File getTempDir()
  {
    File localFile1 = Environment.getExternalStorageDirectory();
    File localFile2 = new File(localFile1, "aquery/temp");
    boolean bool = localFile2.mkdirs();
    if (!localFile2.exists())
      localFile2 = null;
    return localFile2;
  }

  public static Object invokeHandler(Object paramObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, Object[] paramArrayOfObject)
  {
    Object localObject1 = paramObject;
    String str = paramString;
    boolean bool = paramBoolean1;
    Class<?>[] arrayOfClass1 = paramArrayOfClass1;
    Class<?>[] arrayOfClass2 = paramArrayOfClass2;
    Object[] arrayOfObject = paramArrayOfObject;
    Object localObject3;
    try
    {
      Object localObject2 = invokeMethod(localObject1, str, bool, arrayOfClass1, arrayOfClass2, arrayOfObject);
      localObject3 = localObject2;
      return localObject3;
    }
    catch (Exception localException)
    {
      if (!paramBoolean2)
        break label62;
    }
    report(localException);
    while (true)
    {
      localObject3 = null;
      break;
      label62: debug(localException);
    }
  }

  public static Object invokeHandler(Object paramObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject = paramObject;
    String str = paramString;
    boolean bool1 = paramBoolean1;
    boolean bool2 = paramBoolean2;
    Class<?>[] arrayOfClass = paramArrayOfClass;
    Object[] arrayOfObject = paramArrayOfObject;
    return invokeHandler(localObject, str, bool1, bool2, arrayOfClass, null, arrayOfObject);
  }

  private static Object invokeMethod(Object paramObject, String paramString, boolean paramBoolean, Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, Object[] paramArrayOfObject)
    throws Exception
  {
    Object localObject1 = null;
    if ((paramObject == null) || (paramString == null));
    while (true)
    {
      return localObject1;
      int i;
      if (paramArrayOfClass1 == null)
        i = 0;
      Object localObject2;
      try
      {
        paramArrayOfClass1 = new Class[i];
        localObject2 = paramObject.getClass().getMethod(paramString, paramArrayOfClass1).invoke(paramObject, paramArrayOfObject);
        localObject1 = localObject2;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
      }
      if (paramBoolean)
      {
        if (paramArrayOfClass2 == null);
        try
        {
          Class localClass = paramObject.getClass();
          Class[] arrayOfClass = new Class[0];
          Method localMethod = localClass.getMethod(paramString, arrayOfClass);
          Object[] arrayOfObject = new Object[0];
          localObject1 = localMethod.invoke(paramObject, arrayOfObject);
          continue;
          localObject2 = paramObject.getClass().getMethod(paramString, paramArrayOfClass2).invoke(paramObject, paramArrayOfObject);
          localObject1 = localObject2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
        }
      }
    }
  }

  public static boolean isUIThread()
  {
    long l1 = Looper.getMainLooper().getThread().getId();
    long l2 = Thread.currentThread().getId();
    if (l1 == l2);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private static void lastAccess(File paramFile)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramFile.setLastModified(l);
  }

  private static File makeCacheFile(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }

  public static void post(Object paramObject, String paramString)
  {
    Class[] arrayOfClass = new Class[0];
    Object[] arrayOfObject = new Object[0];
    post(paramObject, paramString, arrayOfClass, arrayOfObject);
  }

  public static void post(Object paramObject, final String paramString, final Class<?>[] paramArrayOfClass, final Object[] paramArrayOfObject)
  {
    post(new Runnable()
    {
      public void run()
      {
        Object localObject1 = AQUtility.this;
        String str = paramString;
        Class[] arrayOfClass = paramArrayOfClass;
        Object[] arrayOfObject = paramArrayOfObject;
        Object localObject2 = AQUtility.invokeHandler(localObject1, str, false, true, arrayOfClass, arrayOfObject);
      }
    });
  }

  public static void post(Runnable paramRunnable)
  {
    boolean bool = getHandler().post(paramRunnable);
  }

  public static void postAsync(Object paramObject, String paramString)
  {
    Class[] arrayOfClass = new Class[0];
    Object[] arrayOfObject = new Object[0];
    postAsync(paramObject, paramString, arrayOfClass, arrayOfObject);
  }

  public static void postAsync(Object paramObject, final String paramString, final Class<?>[] paramArrayOfClass, final Object[] paramArrayOfObject)
  {
    ScheduledExecutorService localScheduledExecutorService = getFileStoreExecutor();
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        Object localObject1 = AQUtility.this;
        String str = paramString;
        Class[] arrayOfClass = paramArrayOfClass;
        Object[] arrayOfObject = paramArrayOfObject;
        Object localObject2 = AQUtility.invokeHandler(localObject1, str, false, true, arrayOfClass, arrayOfObject);
      }
    };
    localScheduledExecutorService.execute(local2);
  }

  public static void postDelayed(Runnable paramRunnable, long paramLong)
  {
    boolean bool = getHandler().postDelayed(paramRunnable, paramLong);
  }

  public static void removePost(Runnable paramRunnable)
  {
    getHandler().removeCallbacks(paramRunnable);
  }

  public static void report(Throwable paramThrowable)
  {
    if (paramThrowable == null)
      return;
    try
    {
      String str = Log.getStackTraceString(paramThrowable);
      warn("reporting", str);
      if (eh == null)
        return;
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = eh;
      Thread localThread = Thread.currentThread();
      localUncaughtExceptionHandler.uncaughtException(localThread, paramThrowable);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private static void setAlpha(View paramView, float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      paramView.clearAnimation();
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }

  public static void setCacheDir(File paramFile)
  {
    cacheDir = paramFile;
    if (cacheDir == null)
      return;
    boolean bool = cacheDir.mkdirs();
  }

  public static void setContext(Application paramApplication)
  {
    context = paramApplication.getApplicationContext();
  }

  public static void setDebug(boolean paramBoolean)
  {
    debug = paramBoolean;
  }

  public static void setExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    eh = paramUncaughtExceptionHandler;
  }

  public static void store(File paramFile, byte[] paramArrayOfByte)
  {
    if (paramFile == null)
      return;
    try
    {
      write(paramFile, paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      report(localException);
    }
  }

  public static void storeAsync(File paramFile, byte[] paramArrayOfByte, long paramLong)
  {
    ScheduledExecutorService localScheduledExecutorService = getFileStoreExecutor();
    Common localCommon1 = new Common();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramFile;
    arrayOfObject[1] = paramArrayOfByte;
    Common localCommon2 = localCommon1.method(1, arrayOfObject);
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    ScheduledFuture localScheduledFuture = localScheduledExecutorService.schedule(localCommon2, paramLong, localTimeUnit);
  }

  private static boolean testCleanNeeded(File[] paramArrayOfFile, long paramLong)
  {
    int i = 0;
    long l1 = 0L;
    int j = paramArrayOfFile.length;
    int k = i;
    while (true)
    {
      if (k >= j);
      while (true)
      {
        return i;
        long l2 = paramArrayOfFile[k].length();
        l1 += l2;
        if (l1 <= paramLong)
          break;
        i = 1;
      }
      int m;
      k += 1;
    }
  }

  public static void time(String paramString)
  {
    Map localMap = times;
    Long localLong = Long.valueOf(System.currentTimeMillis());
    Object localObject = localMap.put(paramString, localLong);
  }

  public static long timeEnd(String paramString, long paramLong)
  {
    Long localLong1 = (Long)times.get(paramString);
    long l1;
    if (localLong1 == null)
      l1 = 0L;
    while (true)
    {
      return l1;
      long l2 = System.currentTimeMillis();
      long l3 = localLong1.longValue();
      l1 = l2 - l3;
      if ((paramLong == 0L) || (l1 > paramLong))
      {
        Long localLong2 = Long.valueOf(l1);
        debug(paramString, localLong2);
      }
    }
  }

  public static byte[] toBytes(InputStream paramInputStream)
  {
    Object localObject = null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      copy(paramInputStream, localByteArrayOutputStream);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject = arrayOfByte;
      close(paramInputStream);
      return localObject;
    }
    catch (IOException localIOException)
    {
      while (true)
        report(localIOException);
    }
  }

  public static void transparent(View paramView, boolean paramBoolean)
  {
    float f = 1.0F;
    if (paramBoolean)
      f = 0.5F;
    setAlpha(paramView, f);
  }

  public static void warn(Object paramObject1, Object paramObject2)
  {
    String str = paramObject1 + ":" + paramObject2;
    int i = Log.w("AQuery", str);
  }

  public static void write(File paramFile, byte[] paramArrayOfByte)
  {
    try
    {
      boolean bool1 = paramFile.exists();
      if (!bool1);
      try
      {
        boolean bool2 = paramFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        localFileOutputStream.write(paramArrayOfByte);
        localFileOutputStream.close();
        return;
      }
      catch (Exception localException1)
      {
        while (true)
        {
          debug("file create fail", paramFile);
          report(localException1);
        }
      }
    }
    catch (Exception localException2)
    {
      report(localException2);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.AQUtility
 * JD-Core Version:    0.6.2
 */