package com.skyhookwireless.wps;

import com.skyhookwireless._sdkod;
import com.skyhookwireless._sdkpd;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class _sdkyc<T> extends FutureTask<T>
  implements _sdkpd
{
  private static final String z;
  private final _sdkod _sdka;

  static
  {
    Object localObject1 = "K']pV\b4V6Q[/T9\002\\.Vwg^#]#qA(X".toCharArray();
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
        i2 = 34;
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
      i2 = 40;
      continue;
      i2 = 70;
      continue;
      i2 = 51;
      continue;
      i2 = 87;
    }
  }

  public _sdkyc(_sdkod param_sdkod, Callable<T> paramCallable)
  {
    super(paramCallable);
    this._sdka = param_sdkod;
  }

  protected void done()
  {
    this._sdka._sdka(this);
  }

  public void setEventSink(_sdkod param_sdkod)
  {
    String str = z;
    throw new UnsupportedOperationException(str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkyc
 * JD-Core Version:    0.6.2
 */