package com.skyhookwireless;

import java.util.ArrayList;

public abstract class _sdkqc extends _sdkpc
{
  public static final _sdkqc NULL_GSM_ADAPTER;
  private static _sdkqc _sdkc;
  private static final String z;

  static
  {
    Object localObject1 = "\n\bc\021\005I\032hBQ\031\033bB\036\035\020}S\002".toCharArray();
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
      NULL_GSM_ADAPTER = new _sdkrc();
      _sdkc = null;
      return;
      i2 = 105;
      continue;
      i2 = 105;
      continue;
      i2 = 13;
      continue;
      i2 = 54;
    }
  }

  public static void _sdka(_sdkqc param_sdkqc)
  {
    String str = z;
    throw new UnsupportedOperationException(str);
  }

  public static _sdkqc _sdkb(_sdkt param_sdkt)
    throws _sdkyd
  {
    if (_sdkc == null);
    for (Object localObject = new _sdksc(param_sdkt); ; localObject = _sdkc._sdka(param_sdkt))
      return localObject;
  }

  protected abstract _sdkqc _sdka(_sdkt param_sdkt)
    throws _sdkyd;

  public abstract void _sdka(ArrayList<_sdkab> paramArrayList);

  public abstract void _sdkb()
    throws _sdkyd;

  public abstract void _sdkc();

  public abstract String _sdkd();

  public abstract boolean _sdke();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkqc
 * JD-Core Version:    0.6.2
 */