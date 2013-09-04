package com.skyhookwireless.wps;

import com.skyhookwireless._sdkic;
import java.io.Closeable;
import java.io.IOException;

public abstract class _sdkeb
  implements Closeable
{
  private static _sdkeb _sdka;
  private static final String z;

  static
  {
    Object localObject1 = "\007~\b9oDl\003j;\024m\tjt\020f\026{h".toCharArray();
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
        i2 = 27;
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
      _sdka = null;
      return;
      i2 = 100;
      continue;
      i2 = 31;
      continue;
      i2 = 102;
      continue;
      i2 = 30;
    }
  }

  public static void _sdka(_sdkeb param_sdkeb)
  {
    String str = z;
    throw new UnsupportedOperationException(str);
  }

  public static _sdkeb _sdkb(String paramString1, String paramString2)
    throws IOException
  {
    if (_sdka == null);
    for (Object localObject = new _sdkfb(paramString1, paramString2); ; localObject = _sdka._sdka(paramString1, paramString2))
      return localObject;
  }

  protected abstract _sdkeb _sdka(String paramString1, String paramString2)
    throws IOException;

  public abstract _sdkhb _sdka(_sdkic param_sdkic)
    throws _sdkc;

  public abstract void close();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkeb
 * JD-Core Version:    0.6.2
 */