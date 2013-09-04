package com.skyhookwireless.wps;

import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;

class _sdkvb
  implements _sdkbb
{
  private static final String[] z;
  private double _sdka;
  private final _sdkec _sdkb;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = "f\032G;5b\nQ+5m\032\0028gj\036V:g/\013J>{/\005G-z5_".toCharArray();
    int i = localObject2.length;
    int j;
    Object localObject3;
    int k;
    int i1;
    int i2;
    if (i <= 1)
    {
      j = 0;
      localObject3 = localObject2;
      k = j;
      int m = i;
      Object localObject4 = localObject2;
      int n = m;
      while (true)
      {
        i1 = localObject4[j];
        switch (k % 5)
        {
        default:
          i2 = 95;
          int i3 = (char)(i2 ^ i1);
          localObject4[j] = i3;
          j = k + 1;
          if (n != 0)
            break label129;
          localObject4 = localObject3;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: i = n;
      localObject2 = localObject3;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject2).intern();
      arrayOfString[0] = str1;
      Object localObject5 = "`a\033G9|a\032F".toCharArray();
      int i4 = localObject5.length;
      int i5;
      label180: int i8;
      if (i4 <= 1)
      {
        i5 = 0;
        localObject3 = localObject5;
        k = i5;
        int i6 = i4;
        Object localObject6 = localObject5;
        int i7 = i6;
        while (true)
        {
          i1 = localObject6[i5];
          switch (k % 5)
          {
          default:
            i8 = 95;
            label244: int i9 = (char)(i8 ^ i1);
            localObject6[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label285;
            localObject6 = localObject3;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i4 = i7;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i5)
          break label180;
        String str2 = new String((char[])localObject5).intern();
        arrayOfString[1] = str2;
        int i11 = 2;
        Object localObject7 = "5n\030Gb".toCharArray();
        int i12 = localObject7.length;
        label343: int i18;
        label408: int i14;
        if (i12 <= 1)
        {
          int i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i15 = i12;
          Object localObject9 = localObject7;
          int i16 = i15;
          while (true)
          {
            int i17 = localObject9[i13];
            switch (k % 5)
            {
            default:
              i18 = 95;
              int i19 = (char)(i18 ^ i17);
              localObject9[i13] = i19;
              i14 = k + 1;
              if (i16 != 0)
                break label449;
              localObject9 = localObject3;
              int i20 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i12 = i16;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i14)
            break label343;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i21 = 3;
          Object localObject10 = "f\032G;(".toCharArray();
          Object localObject11 = localObject10.length;
          label505: Object localObject13;
          Object localObject14;
          label524: int i22;
          if (localObject11 <= 1)
          {
            localObject8 = localObject10;
            localObject3 = localObject1;
            Object localObject12 = localObject11;
            localObject13 = localObject10;
            localObject14 = localObject12;
            i11 = localObject13[localObject1];
            switch (localObject3 % 5)
            {
            default:
              i22 = 95;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          while (true)
          {
            int i23 = (char)(i22 ^ i11);
            localObject13[localObject1] = i23;
            localObject1 = localObject3 + 1;
            if (localObject14 == 0)
            {
              localObject13 = localObject8;
              int i24 = localObject1;
              localObject1 = localObject14;
              break label524;
            }
            localObject11 = localObject14;
            localObject10 = localObject8;
            if (localObject11 > localObject1)
              break label505;
            String str4 = new String((char[])localObject10).intern();
            arrayOfString[i21] = str4;
            z = arrayOfString;
            return;
            i2 = 21;
            break;
            i2 = 15;
            break;
            i2 = 127;
            break;
            i2 = 34;
            break;
            i8 = 21;
            break label244;
            i8 = 15;
            break label244;
            i8 = 127;
            break label244;
            i8 = 34;
            break label244;
            i18 = 21;
            break label408;
            i18 = 15;
            break label408;
            i18 = 127;
            break label408;
            i18 = 34;
            break label408;
            i22 = 21;
            continue;
            i22 = 15;
            continue;
            i22 = 127;
            continue;
            i22 = 34;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  _sdkvb()
  {
    this(0.0D, null);
  }

  _sdkvb(double paramDouble, _sdkec param_sdkec)
  {
    if (paramDouble < 0.0D)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = z[0];
      String str2 = str1 + paramDouble;
      throw new IllegalArgumentException(str2);
    }
    this._sdka = paramDouble;
    this._sdkb = param_sdkec;
  }

  double _sdka()
  {
    return this._sdka;
  }

  void _sdka(_sdkvb param_sdkvb)
  {
    double d1 = this._sdka;
    double d2 = param_sdkvb._sdka;
    double d3 = d1 + d2;
    this._sdka = d3;
  }

  public _sdkec getAge()
  {
    return this._sdkb;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[3];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    double d = this._sdka;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(d);
    String str2 = z[2];
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str2);
    if (this._sdkb == null);
    for (Object localObject = z[1]; ; localObject = Long.valueOf(this._sdkb._sdka()))
      return localObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkvb
 * JD-Core Version:    0.6.2
 */