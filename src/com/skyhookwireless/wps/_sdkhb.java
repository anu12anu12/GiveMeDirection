package com.skyhookwireless.wps;

import com.skyhookwireless._sdkgc;
import com.skyhookwireless._sdkic;

public final class _sdkhb extends Location
  implements Comparable<_sdkhb>, _sdkgc
{
  private final _sdkic _sdkj;
  private final int _sdkk;
  private final double _sdkl;

  public _sdkhb(_sdkic param_sdkic, double paramDouble1, double paramDouble2, int paramInt, double paramDouble3)
  {
    super(paramDouble1, paramDouble2);
    this._sdkj = param_sdkic;
    this._sdkk = paramInt;
    this._sdkl = paramDouble3;
  }

  public int _sdka()
  {
    return this._sdkk;
  }

  public int _sdka(_sdkhb param_sdkhb)
  {
    int i = -1;
    if (param_sdkhb == null);
    while (true)
    {
      return i;
      _sdkic local_sdkic1 = this._sdkj;
      _sdkic local_sdkic2 = param_sdkhb._sdkj;
      int j = local_sdkic1._sdka(local_sdkic2);
      if (j != 0)
      {
        i = j;
      }
      else
      {
        int k = this._sdkk;
        int m = param_sdkhb._sdkk;
        j = k - m;
        if (j != 0)
        {
          i = j;
        }
        else
        {
          double d1 = this._sdkl;
          double d2 = param_sdkhb._sdkl;
          if (d1 >= d2)
          {
            double d3 = this._sdkl;
            double d4 = param_sdkhb._sdkl;
            if (d3 > d4)
              i = 1;
            else
              i = 0;
          }
        }
      }
    }
  }

  public _sdkic _sdka()
  {
    return this._sdkj;
  }

  public double _sdkb()
  {
    return this._sdkl;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    try
    {
      paramObject = (_sdkhb)paramObject;
      if (paramObject != null)
      {
        _sdkic local_sdkic1 = this._sdkj;
        _sdkic local_sdkic2 = paramObject._sdkj;
        if (local_sdkic1.equals(local_sdkic2))
        {
          int i = this._sdkk;
          int j = paramObject._sdkk;
          if (i != j)
          {
            double d1 = this._sdkl;
            double d2 = paramObject._sdkl;
            if (d1 == d2)
              bool = true;
          }
        }
      }
      label72: return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      break label72;
    }
  }

  public int hashCode()
  {
    return (int)this._sdkj._sdka();
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("(");
    _sdkic local_sdkic = this._sdkj;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(local_sdkic).append(",");
    String str = super.toString();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str).append(",");
    int i = this._sdkk;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(i).append(",");
    double d = this._sdkl;
    return d + ")";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkhb
 * JD-Core Version:    0.6.2
 */