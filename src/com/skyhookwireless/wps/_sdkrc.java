package com.skyhookwireless.wps;

public final class _sdkrc
{
  public static final _sdkrc NULL_TILING_PARAMETERS = new _sdkrc("", 0L, 1L, null);
  private final String _sdka;
  private final long _sdkb;
  private final long _sdkc;
  private final TilingListener _sdkd;

  public _sdkrc(String paramString, long paramLong1, long paramLong2, TilingListener paramTilingListener)
  {
    this._sdka = paramString;
    this._sdkb = paramLong1;
    this._sdkc = paramLong2;
    this._sdkd = paramTilingListener;
  }

  public String _sdka()
  {
    return this._sdka;
  }

  public long _sdkb()
  {
    return this._sdkb;
  }

  public long _sdkc()
  {
    return this._sdkc;
  }

  public TilingListener _sdkd()
  {
    return this._sdkd;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this == paramObject)
      bool2 = true;
    while (true)
    {
      return bool2;
      if (paramObject != null)
        try
        {
          paramObject = (_sdkrc)paramObject;
          if ((this._sdka == null) || (paramObject._sdka == null))
          {
            String str1 = this._sdka;
            String str2 = paramObject._sdka;
            if (str1 == str2)
            {
              label55: long l1 = this._sdkb;
              long l2 = paramObject._sdkb;
              if (l1 == l2)
              {
                long l3 = this._sdkc;
                long l4 = paramObject._sdkc;
                if (l3 != l4);
              }
            }
          }
          else
          {
            while (true)
            {
              bool2 = bool1;
              break;
              String str3 = this._sdka;
              String str4 = paramObject._sdka;
              boolean bool3 = str3.equals(str4);
              if (bool3)
                break label55;
              break;
              bool1 = false;
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
    int i = (this._sdka.hashCode() + 629) * 37;
    long l1 = this._sdkb;
    long l2 = this._sdkb >>> 32;
    int j = (int)(l1 ^ l2);
    int k = (i + j) * 37;
    long l3 = this._sdkc;
    long l4 = this._sdkc >>> 32;
    int m = (int)(l3 ^ l4);
    return k + m;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkrc
 * JD-Core Version:    0.6.2
 */