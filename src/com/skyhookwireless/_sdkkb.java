package com.skyhookwireless;

import android.util.Log;

final class _sdkkb extends _sdkhb
{
  private static final String z;

  static
  {
    Object localObject1 = "R\035OG\002Z\013J\006\036Z\005K\033\024]\027Q\032_I\002Q".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    Object localObject3;
    int n;
    label31: int i1;
    int i2;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      int m = i;
      localObject3 = localObject1;
      n = m;
      i1 = localObject3[j];
      switch (k % 5)
      {
      default:
        i2 = 113;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i3 = (char)(i2 ^ i1);
      localObject3[j] = i3;
      j = k + 1;
      if (n == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = n;
        break label31;
      }
      i = n;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i2 = 49;
      continue;
      i2 = 114;
      continue;
      i2 = 34;
      continue;
      i2 = 105;
    }
  }

  public _sdkkb(Class<?> paramClass)
  {
    super(paramClass);
  }

  protected _sdkhb _sdka(Class<?> paramClass)
  {
    return new _sdkkb(paramClass);
  }

  protected void _sdka(_sdkh param_sdkh, String paramString)
  {
    int i = _sdkh._sdkb;
    int[] arrayOfInt = _sdkob._sdka;
    int j = param_sdkh.ordinal();
    switch (arrayOfInt[j])
    {
    default:
      return;
    case 1:
      int k = Log.d(z, paramString);
      if (i == 0)
        return;
    case 2:
      int m = Log.e(z, paramString);
      if (i == 0)
        return;
    case 3:
      int n = Log.i(z, paramString);
      if (i == 0)
        return;
    case 4:
      int i1 = Log.v(z, paramString);
      if (i == 0)
        return;
      break;
    case 5:
    }
    int i2 = Log.w(z, paramString);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkkb
 * JD-Core Version:    0.6.2
 */