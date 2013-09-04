package com.skyhookwireless;

public final class _sdkab
  implements Comparable<_sdkab>, _sdkw, _sdkbb
{
  public static final int MIN_DBM = 143;
  public static int _sdkf;
  private static final String z;
  private final _sdkv _sdka;
  private final int _sdkb;
  private final int _sdkc;
  private final _sdkec _sdkd;

  static
  {
    int i = 1;
    Object localObject1 = "\034o\r-\022\bhXb\033]~\027x\023\031oB-".toCharArray();
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
          i3 = 125;
          label80: int i4 = (char)(i3 ^ i2);
          localObject3[k] = i4;
          k = m + 1;
          if (i1 != 0)
            break label117;
          localObject3 = localObject2;
          m = k;
          k = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label117: j = i1;
      localObject1 = localObject2;
    }
    while (j <= k)
    {
      z = new String((char[])localObject1).intern();
      if (!_sdkab.class.desiredAssertionStatus());
      while (true)
      {
        _sdke = i;
        return;
        i = 0;
      }
      i3 = 125;
      break label80;
      i3 = 28;
      break label80;
      i3 = 120;
      break label80;
      i3 = 13;
      break label80;
      k = 0;
    }
  }

  public _sdkab(_sdkv param_sdkv, int paramInt1, int paramInt2, _sdkec param_sdkec)
  {
    this._sdka = param_sdkv;
    this._sdkb = paramInt1;
    this._sdkc = paramInt2;
    this._sdkd = param_sdkec;
  }

  static boolean _sdka(int paramInt)
  {
    if ((paramInt < 0) || ((paramInt > 31) && (paramInt != 99)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  static int _sdkb(int paramInt)
  {
    if ((!_sdke) && (_sdka(paramInt)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = z;
      String str2 = str1 + paramInt;
      throw new AssertionError(str2);
    }
    if (_sdka(paramInt));
    for (int i = 65423; ; i = paramInt * 2 + -113)
      return i;
  }

  public int _sdka()
  {
    return this._sdkb;
  }

  public int _sdka(_sdkab param_sdkab)
  {
    int i;
    if (param_sdkab == null)
      i = 1;
    while (true)
    {
      return i;
      _sdkv local_sdkv1 = this._sdka;
      _sdkv local_sdkv2 = param_sdkab._sdka;
      i = local_sdkv1._sdka(local_sdkv2);
      if (i == 0)
      {
        _sdkec local_sdkec1 = this._sdkd;
        _sdkec local_sdkec2 = param_sdkab._sdkd;
        i = local_sdkec1._sdkc(local_sdkec2);
        if (i == 0)
        {
          int j = this._sdkc;
          int k = param_sdkab._sdkc;
          i = j - k;
          if (i == 0)
          {
            int m = this._sdkb;
            int n = param_sdkab._sdkb;
            i = m - n;
          }
        }
      }
    }
  }

  public _sdkv _sdka()
  {
    return this._sdka;
  }

  public int _sdkb()
  {
    return this._sdkc;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject == null);
    while (true)
    {
      return bool1;
      try
      {
        paramObject = (_sdkab)paramObject;
        _sdkv local_sdkv1 = this._sdka;
        _sdkv local_sdkv2 = paramObject._sdka;
        if (local_sdkv1.equals(local_sdkv2))
        {
          int i = this._sdkb;
          int j = paramObject._sdkb;
          if (i != j)
          {
            int k = this._sdkc;
            int m = paramObject._sdkc;
            if (k != m)
            {
              _sdkec local_sdkec1 = this._sdkd;
              _sdkec local_sdkec2 = paramObject._sdkd;
              boolean bool2 = local_sdkec1.equals(local_sdkec2);
              if (bool2)
                bool1 = true;
            }
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  public _sdkec getAge()
  {
    return this._sdkd;
  }

  public int hashCode()
  {
    int i = this._sdka.hashCode();
    int j = this._sdkc;
    return i ^ j;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("[");
    String str = this._sdka.toString();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str).append(",");
    int i = this._sdkc;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(i).append(",");
    long l = this._sdkd._sdka();
    return l + "]";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkab
 * JD-Core Version:    0.6.2
 */