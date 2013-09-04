package com.skyhookwireless;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class _sdkr
{
  private static Handler _sdka;
  private static final String z;

  static
  {
    Object localObject1 = "\031IT8&\005Ir8(\004FA5;".toCharArray();
    int i = localObject1.length;
    Object localObject2;
    int j;
    Object localObject3;
    int m;
    label28: int n;
    int i1;
    if (i <= 1)
    {
      localObject2 = localObject1;
      j = 0;
      int k = i;
      localObject3 = localObject1;
      m = k;
      n = localObject3[0];
      switch (j % 5)
      {
      default:
        i1 = 73;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i2 = (char)(i1 ^ n);
      localObject3[0] = i2;
      int i3 = j + 1;
      if (m == 0)
      {
        localObject3 = localObject2;
        j = i3;
        int i4 = m;
        break label28;
      }
      i = m;
      localObject1 = localObject2;
      if (i > 0)
        break;
      z = new String((char[])localObject1).intern();
      Looper localLooper1 = Looper.getMainLooper();
      if (localLooper1 == null)
      {
        String str = z;
        HandlerThread localHandlerThread = new HandlerThread(str, -1);
        localHandlerThread.start();
        Looper localLooper2 = localHandlerThread.getLooper();
        _sdka = new Handler(localLooper2);
        return;
      }
      _sdka = new Handler(localLooper1);
      return;
      i1 = 106;
      continue;
      i1 = 34;
      continue;
      i1 = 45;
      continue;
      i1 = 80;
    }
  }

  public static <T> Future<T> _sdka(Callable<T> paramCallable)
  {
    _sdkae local_sdkae = new _sdkae(paramCallable);
    if (!_sdka.post(local_sdkae))
      local_sdkae = null;
    return local_sdkae;
  }

  private static boolean _sdka()
  {
    long l1 = Thread.currentThread().getId();
    long l2 = _sdkb().getThread().getId();
    if (l1 == l2);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean _sdka(Runnable paramRunnable)
  {
    return _sdka.post(paramRunnable);
  }

  public static boolean _sdka(Runnable paramRunnable, long paramLong)
  {
    return _sdka.postDelayed(paramRunnable, paramLong);
  }

  public static Looper _sdkb()
  {
    return _sdka.getLooper();
  }

  static boolean _sdkc()
  {
    return _sdka();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkr
 * JD-Core Version:    0.6.2
 */