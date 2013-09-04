package com.skyhookwireless;

import android.content.Context;
import android.net.wifi.WifiManager;
import java.util.concurrent.Callable;

final class _sdkmc
  implements Callable<WifiManager>
{
  private static final String z;
  final _sdkfd _sdka;

  static
  {
    Object localObject1 = "\016\007}x".toCharArray();
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
        i2 = 64;
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
      i2 = 121;
      continue;
      i2 = 110;
      continue;
      i2 = 27;
      continue;
      i2 = 17;
    }
  }

  private _sdkmc(_sdkfd param_sdkfd)
  {
  }

  _sdkmc(_sdkfd param_sdkfd, _sdkkc param_sdkkc)
  {
    this(param_sdkfd);
  }

  public WifiManager _sdka()
  {
    Context localContext = _sdkfd._sdkj(this._sdka);
    String str = z;
    return (WifiManager)localContext.getSystemService(str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkmc
 * JD-Core Version:    0.6.2
 */