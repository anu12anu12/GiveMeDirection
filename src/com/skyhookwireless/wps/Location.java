package com.skyhookwireless.wps;

import java.io.Serializable;
import java.util.Comparator;

public class Location
  implements Serializable
{
  static final Comparator<Location> _sdka;
  static final Comparator<Location> _sdkb;
  static final Comparator<Location> _sdkc;
  public static int _sdki = 0;
  private static final long serialVersionUID = 326945576249960552L;
  private static final String[] z;
  private double _sdkd;
  private boolean _sdke;
  private double _sdkf;
  private double _sdkg;
  private long _sdkh;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = "\007YWY+\034STOh\007\021ZEn��_\031^+\033PHO+\022\021HKg\032U\036^b\036T".toCharArray();
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
          i2 = 11;
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
      Object localObject5 = "\036B".toCharArray();
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
            i8 = 11;
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
        Object localObject7 = "\036\021_FS".toCharArray();
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
              i18 = 11;
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
          Object localObject10 = "_\021".toCharArray();
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
              i22 = 11;
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
            _sdka = new _sdkjb();
            _sdkb = new _sdkkb();
            _sdkc = new _sdklb();
            return;
            i2 = 115;
            break;
            i2 = 49;
            break;
            i2 = 62;
            break;
            i2 = 42;
            break;
            i8 = 115;
            break label244;
            i8 = 49;
            break label244;
            i8 = 62;
            break label244;
            i8 = 42;
            break label244;
            i18 = 115;
            break label408;
            i18 = 49;
            break label408;
            i18 = 62;
            break label408;
            i18 = 42;
            break label408;
            i22 = 115;
            continue;
            i22 = 49;
            continue;
            i22 = 62;
            continue;
            i22 = 42;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  @Deprecated
  protected Location()
  {
  }

  protected Location(double paramDouble1, double paramDouble2)
  {
    this._sdkf = paramDouble1;
    this._sdkg = paramDouble2;
    this._sdkh = 65535L;
  }

  protected Location(double paramDouble1, double paramDouble2, long paramLong)
  {
    this._sdkf = paramDouble1;
    this._sdkg = paramDouble2;
    this._sdkh = paramLong;
  }

  static double _sdka(Location paramLocation)
  {
    return paramLocation._sdkf;
  }

  static double _sdkb(Location paramLocation)
  {
    return paramLocation._sdkg;
  }

  static long _sdkc(Location paramLocation)
  {
    return paramLocation._sdkh;
  }

  public double getAltitude()
  {
    return this._sdkd;
  }

  public double getLatitude()
  {
    return this._sdkf;
  }

  public double getLongitude()
  {
    return this._sdkg;
  }

  public long getTime()
  {
    if (this._sdkh == 65535L)
    {
      String str = z[0];
      throw new UnsupportedOperationException(str);
    }
    return this._sdkh;
  }

  public boolean hasAltitude()
  {
    return this._sdke;
  }

  public void setAltitude(double paramDouble)
  {
    this._sdkd = paramDouble;
    this._sdke = true;
  }

  public void setLatitude(double paramDouble)
  {
    this._sdkf = paramDouble;
  }

  public void setLongitude(double paramDouble)
  {
    this._sdkg = paramDouble;
  }

  public void setTime(long paramLong)
  {
    this._sdkh = paramLong;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    double d1 = Math.round(getLatitude() * 10000000.0D) / 10000000.0D;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(d1);
    String str1 = z[3];
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str1);
    double d2 = Math.round(getLongitude() * 10000000.0D) / 10000000.0D;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(d2).append(" ");
    StringBuilder localStringBuilder6;
    String str2;
    if (hasAltitude())
    {
      StringBuilder localStringBuilder5 = new StringBuilder();
      double d3 = this._sdkd;
      localStringBuilder6 = localStringBuilder5.append(d3);
      str2 = z[2];
    }
    for (String str3 = str2; ; str3 = "")
    {
      StringBuilder localStringBuilder7 = localStringBuilder4.append(str3);
      long l = this._sdkh;
      StringBuilder localStringBuilder8 = localStringBuilder7.append(l);
      String str4 = z[1];
      return str4;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.Location
 * JD-Core Version:    0.6.2
 */