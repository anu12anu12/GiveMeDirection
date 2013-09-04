package com.skyhookwireless;

import java.util.List;

public abstract class _sdkad extends _sdkpc
{
  public static final _sdkad NULL_ACCELEROMETER_ADAPTER;
  private static _sdkad _sdkc;
  public static boolean _sdkd;
  private static final String z;

  static
  {
    Object localObject1 = "6t8g\007uf34S%g94\034!l&%��".toCharArray();
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
        i2 = 115;
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
      NULL_ACCELEROMETER_ADAPTER = new _sdkbd();
      _sdkc = null;
      return;
      i2 = 85;
      continue;
      i2 = 21;
      continue;
      i2 = 86;
      continue;
      i2 = 64;
    }
  }

  public static void _sdka(_sdkad param_sdkad)
  {
    String str = z;
    throw new UnsupportedOperationException(str);
  }

  public static _sdkad _sdkb(_sdkt param_sdkt)
  {
    if (_sdkc == null);
    for (Object localObject = new _sdkcd(param_sdkt); ; localObject = _sdkc._sdka(param_sdkt))
      return localObject;
  }

  protected abstract _sdkad _sdka(_sdkt param_sdkt);

  public abstract String _sdka();

  public abstract void _sdkb()
    throws _sdkl;

  public abstract void _sdkc();

  public abstract List<_sdkwb> _sdkd();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkad
 * JD-Core Version:    0.6.2
 */