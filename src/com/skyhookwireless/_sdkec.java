package com.skyhookwireless;

import java.io.Serializable;

public abstract class _sdkec
  implements Comparable<_sdkec>, Serializable
{
  private static _sdkec _sdkb;
  public static boolean _sdkc = false;
  private static final long serialVersionUID = 115056162806105970L;
  private static final String z;
  private long _sdka;

  static
  {
    Object localObject1 = "^`y&A\035rru\025MsxuZIxgdF".toCharArray();
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
        i2 = 53;
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
      _sdkb = null;
      return;
      i2 = 61;
      continue;
      i2 = 1;
      continue;
      i2 = 23;
      continue;
      i2 = 1;
    }
  }

  protected _sdkec()
  {
    long l = _sdkb();
    this._sdka = l;
  }

  public static final _sdkec _sdka(long paramLong)
  {
    _sdkec local_sdkec = _sdkd();
    long l = local_sdkec._sdka - paramLong;
    local_sdkec._sdka = l;
    return local_sdkec;
  }

  public static final _sdkec _sdkd()
  {
    if (_sdkb == null);
    for (Object localObject = new _sdkfc(); ; localObject = _sdkb._sdkc())
      return localObject;
  }

  /** @deprecated */
  public static void _sdkd(_sdkec param_sdkec)
  {
    try
    {
      String str = z;
      throw new UnsupportedOperationException(str);
    }
    finally
    {
    }
  }

  public long _sdka()
  {
    long l1 = _sdkb();
    long l2 = this._sdka;
    return l1 - l2;
  }

  public long _sdka(_sdkec param_sdkec)
  {
    return param_sdkec._sdkb(this);
  }

  protected abstract long _sdkb();

  public long _sdkb(_sdkec param_sdkec)
  {
    long l1 = this._sdka;
    long l2 = param_sdkec._sdka;
    return l1 - l2;
  }

  public int _sdkc(_sdkec param_sdkec)
  {
    long l1 = this._sdka;
    long l2 = param_sdkec._sdka;
    int i;
    if (l1 > l2)
      i = -1;
    while (true)
    {
      return i;
      long l3 = this._sdka;
      long l4 = param_sdkec._sdka;
      if (l3 < l4)
        i = 1;
      else
        i = 0;
    }
  }

  protected abstract _sdkec _sdkc();

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null);
    while (true)
    {
      return bool;
      try
      {
        long l1 = this._sdka;
        long l2 = ((_sdkec)paramObject)._sdka;
        if (l1 == l2)
          bool = true;
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  public int hashCode()
  {
    return (int)this._sdka;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkec
 * JD-Core Version:    0.6.2
 */