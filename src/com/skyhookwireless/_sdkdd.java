package com.skyhookwireless;

import java.util.ArrayList;

public abstract class _sdkdd extends _sdkpc
{
  public static _sdkdd NULL_WIFI_ADAPTER;
  private static _sdkdd _sdkc;
  static final boolean _sdkd;
  private static final String z;

  static
  {
    int i = 1;
    Object localObject1 = "LR6\002q\017@=Q%_A7Qj[J(@v".toCharArray();
    int j = localObject1.length;
    int k;
    int i3;
    if (j <= i)
    {
      k = 0;
      Object localObject2 = localObject1;
      int m = k;
      int n = j;
      Object localObject3 = localObject1;
      int i1 = n;
      while (true)
      {
        int i2 = localObject3[k];
        switch (m % 5)
        {
        default:
          i3 = 5;
          label79: int i4 = (char)(i3 ^ i2);
          localObject3[k] = i4;
          k = m + 1;
          if (i1 != 0)
            break label116;
          localObject3 = localObject2;
          m = k;
          k = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label116: j = i1;
      localObject1 = localObject2;
    }
    while (j <= k)
    {
      z = new String((char[])localObject1).intern();
      if (!_sdkdd.class.desiredAssertionStatus());
      while (true)
      {
        _sdkd = i;
        try
        {
          NULL_WIFI_ADAPTER = new _sdked();
          _sdkc = null;
          return;
          i = 0;
        }
        catch (_sdkn local_sdkn)
        {
          while (true)
          {
            if (!_sdkd)
              throw new AssertionError();
            NULL_WIFI_ADAPTER = null;
          }
        }
      }
      i3 = 47;
      break label79;
      i3 = 51;
      break label79;
      i3 = 88;
      break label79;
      i3 = 37;
      break label79;
      k = 0;
    }
  }

  _sdkdd()
    throws _sdkn
  {
  }

  public static void _sdka(_sdkdd param_sdkdd)
  {
    String str = z;
    throw new UnsupportedOperationException(str);
  }

  public static _sdkdd _sdkb(_sdkt param_sdkt)
    throws _sdkn
  {
    if (_sdkc == null);
    for (Object localObject = new _sdkfd(param_sdkt); ; localObject = _sdkc._sdka(param_sdkt))
      return localObject;
  }

  protected abstract _sdkdd _sdka(_sdkt param_sdkt)
    throws _sdkn;

  public abstract void _sdka(long paramLong);

  public abstract void _sdka(ArrayList<_sdkjc> paramArrayList);

  public abstract boolean _sdka();

  public abstract boolean _sdkb();

  public abstract String _sdkc();

  public abstract boolean _sdkd();

  public abstract boolean _sdke();

  public abstract void _sdkf();

  public abstract void _sdkg();

  public abstract String _sdkh();

  public abstract boolean _sdki();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkdd
 * JD-Core Version:    0.6.2
 */