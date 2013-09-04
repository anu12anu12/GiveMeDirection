package com.skyhookwireless;

import java.util.ArrayList;

final class _sdked extends _sdkdd
{
  private static final String z;

  static
  {
    Object localObject1 = "Q`V\020cH|\\\025c^q[\fhZg".toCharArray();
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
        i2 = 60;
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
      i2 = 31;
      continue;
      i2 = 53;
      continue;
      i2 = 26;
      continue;
      i2 = 92;
    }
  }

  _sdked()
    throws _sdkn
  {
  }

  protected _sdkdd _sdka(_sdkt param_sdkt)
    throws _sdkn
  {
    return this;
  }

  public void _sdka(long paramLong)
  {
  }

  public void _sdka(ArrayList<_sdkjc> paramArrayList)
  {
  }

  public boolean _sdka()
  {
    return false;
  }

  public boolean _sdkb()
  {
    return false;
  }

  public String _sdkc()
  {
    return null;
  }

  public boolean _sdkd()
  {
    return false;
  }

  public boolean _sdke()
  {
    return false;
  }

  public void _sdkf()
  {
  }

  public void _sdkg()
  {
  }

  public String _sdkh()
  {
    return z;
  }

  public boolean _sdki()
  {
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdked
 * JD-Core Version:    0.6.2
 */