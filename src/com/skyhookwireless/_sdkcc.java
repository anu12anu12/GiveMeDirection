package com.skyhookwireless;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.concurrent.Callable;

class _sdkcc
  implements Callable<TelephonyManager>
{
  private static final String z;
  final Context _sdka;
  final _sdkbc _sdkb;

  static
  {
    Object localObject1 = "k0h\007\f".toCharArray();
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
        i2 = 105;
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
      i2 = 27;
      continue;
      i2 = 88;
      continue;
      i2 = 7;
      continue;
      i2 = 105;
    }
  }

  _sdkcc(_sdkbc param_sdkbc, Context paramContext)
  {
  }

  public TelephonyManager _sdka()
  {
    Context localContext = this._sdka;
    String str = z;
    return (TelephonyManager)localContext.getSystemService(str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkcc
 * JD-Core Version:    0.6.2
 */