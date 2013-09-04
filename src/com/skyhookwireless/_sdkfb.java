package com.skyhookwireless;

import android.content.Context;
import android.location.LocationManager;
import java.util.concurrent.Callable;

class _sdkfb
  implements Callable<LocationManager>
{
  private static final String z;
  final _sdkxc _sdka;

  static
  {
    Object localObject1 = "\036m\034<\031\033m\021".toCharArray();
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
        i2 = 109;
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
      i2 = 114;
      continue;
      i2 = 2;
      continue;
      i2 = 127;
      continue;
      i2 = 93;
    }
  }

  _sdkfb(_sdkxc param_sdkxc)
  {
  }

  public LocationManager _sdka()
  {
    Context localContext = _sdkxc._sdka(this._sdka);
    String str = z;
    return (LocationManager)localContext.getSystemService(str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkfb
 * JD-Core Version:    0.6.2
 */