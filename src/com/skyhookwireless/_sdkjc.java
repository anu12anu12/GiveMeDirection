package com.skyhookwireless;

public class _sdkjc
  implements Comparable<_sdkjc>, _sdkgc, _sdkbb
{
  private static final String z;
  private final _sdkic _sdka;
  private final int _sdkb;
  private final long _sdkc;
  private final _sdkec _sdkd;

  static
  {
    Object localObject1 = "+��L".toCharArray();
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
        i2 = 22;
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
      i2 = 70;
      continue;
      i2 = 115;
      continue;
      i2 = 17;
      continue;
      i2 = 33;
    }
  }

  public _sdkjc(_sdkic param_sdkic, int paramInt, long paramLong, _sdkec param_sdkec)
  {
    this._sdka = param_sdkic;
    this._sdkb = paramInt;
    this._sdkc = paramLong;
    this._sdkd = param_sdkec;
  }

  public int _sdka()
  {
    return this._sdkb;
  }

  public int _sdka(_sdkjc param_sdkjc)
  {
    int i;
    if (param_sdkjc == null)
      i = 1;
    while (true)
    {
      return i;
      _sdkic local_sdkic1 = this._sdka;
      _sdkic local_sdkic2 = param_sdkjc._sdka;
      i = local_sdkic1._sdka(local_sdkic2);
      if (i == 0)
      {
        _sdkec local_sdkec1 = this._sdkd;
        _sdkec local_sdkec2 = param_sdkjc._sdkd;
        i = local_sdkec1._sdkc(local_sdkec2);
        if (i == 0)
        {
          int j = this._sdkb;
          int k = param_sdkjc._sdkb;
          i = j - k;
        }
      }
    }
  }

  public _sdkic _sdka()
  {
    return this._sdka;
  }

  public long _sdkb()
  {
    return this._sdkc;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    try
    {
      _sdkjc local_sdkjc = (_sdkjc)paramObject;
      int i = _sdka(local_sdkjc);
      if (i == 0)
        bool = true;
      label21: return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      break label21;
    }
  }

  public _sdkec getAge()
  {
    return this._sdkd;
  }

  public int hashCode()
  {
    boolean bool = _sdkic._sdkc;
    int i = (this._sdka.hashCode() + 629) * 37;
    long l1 = this._sdkc;
    long l2 = this._sdkc >>> 32;
    int j = (int)(l1 ^ l2);
    int k = (i + j) * 37;
    int m = this._sdkb;
    int n = k + m;
    if (_sdkhb._sdkd)
      if (!bool)
        break label81;
    label81: for (bool = false; ; bool = true)
    {
      _sdkic._sdkc = bool;
      return n;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("[");
    _sdkic local_sdkic = this._sdka;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(local_sdkic).append(" ");
    int i = this._sdkb;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(i).append(" ");
    long l = this._sdkc;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(l);
    String str = z;
    return str;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkjc
 * JD-Core Version:    0.6.2
 */