package com.skyhookwireless;

public final class _sdkv
  implements Comparable<_sdkv>
{
  private final int _sdka;
  private final int _sdkb;
  private final int _sdkc;
  private final int _sdkd;
  private final int _sdke;

  public _sdkv(int paramInt1, int paramInt2, int paramInt3)
  {
    this._sdka = paramInt1;
    this._sdkb = paramInt2;
    this._sdkc = -1;
    this._sdkd = -1;
    this._sdke = paramInt3;
  }

  public _sdkv(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._sdka = paramInt1;
    this._sdkb = paramInt2;
    if (paramInt3 == -1);
    for (int i = -1; ; i = 0xFFFF & paramInt3)
    {
      this._sdkc = i;
      this._sdkd = paramInt4;
      this._sdke = -1;
      return;
    }
  }

  public int _sdka()
  {
    return this._sdke;
  }

  public int _sdka(_sdkv param_sdkv)
  {
    int i;
    if (param_sdkv == null)
      i = -1;
    while (true)
    {
      return i;
      int j = this._sdka;
      int k = param_sdkv._sdka;
      i = j - k;
      if (i == 0)
      {
        int m = this._sdkb;
        int n = param_sdkv._sdkb;
        i = m - n;
        if (i == 0)
        {
          int i1 = this._sdkc;
          int i2 = param_sdkv._sdkc;
          i = i1 - i2;
          if (i == 0)
          {
            int i3 = this._sdkd;
            int i4 = param_sdkv._sdkd;
            i = i3 - i4;
            if (i == 0)
            {
              int i5 = this._sdke;
              int i6 = param_sdkv._sdke;
              i = i5 - i6;
            }
          }
        }
      }
    }
  }

  public int _sdkb()
  {
    return this._sdkc;
  }

  public int _sdkc()
  {
    return this._sdkd;
  }

  public int _sdkd()
  {
    return this._sdka;
  }

  public int _sdke()
  {
    return this._sdkb;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null);
    while (true)
    {
      return bool;
      try
      {
        paramObject = (_sdkv)paramObject;
        int i = this._sdkc;
        int j = paramObject._sdkc;
        if (i != j)
        {
          int k = this._sdkd;
          int m = paramObject._sdkd;
          if (k != m)
          {
            int n = this._sdkb;
            int i1 = paramObject._sdkb;
            if (n != i1)
            {
              int i2 = this._sdka;
              int i3 = paramObject._sdka;
              if (i2 != i3)
              {
                int i4 = this._sdke;
                int i5 = paramObject._sdke;
                if (i4 != i5)
                  bool = true;
              }
            }
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this._sdke == -1)
    {
      i = this._sdkc;
      j = this._sdkd;
    }
    for (int k = i ^ j; ; k = this._sdke)
      return k;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("[");
    int i = this._sdka;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(",");
    int j = this._sdkb;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(j).append(",");
    StringBuilder localStringBuilder5;
    int m;
    if (this._sdke == -1)
    {
      StringBuilder localStringBuilder4 = new StringBuilder();
      int k = this._sdkd;
      localStringBuilder5 = localStringBuilder4.append(k).append(",");
      m = this._sdkc;
    }
    for (Object localObject = m; ; localObject = Integer.valueOf(this._sdke))
      return localObject + "]";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkv
 * JD-Core Version:    0.6.2
 */