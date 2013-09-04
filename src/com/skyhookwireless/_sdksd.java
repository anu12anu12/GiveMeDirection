package com.skyhookwireless;

import com.skyhookwireless.wps.Location;
import java.util.Iterator;
import java.util.List;

public class _sdksd
{
  public static final double DEGREE_TO_RADIAN = 0.0174532925199433D;
  public static final double PI = 3.141592653589793D;
  public static final double RADIAN_TO_DEGREE = 57.295779513082323D;

  static
  {
    if (!_sdksd.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdka = bool;
      return;
    }
  }

  public static double _sdka(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    boolean bool1 = _sdkpc._sdkb;
    double d1 = 0.0174532925199433D * paramDouble1;
    double d2 = 0.0174532925199433D * paramDouble2;
    float f1 = -2.854354E-018F * paramDouble3;
    float f2 = -2.854354E-018F * paramDouble4;
    double d3 = Math.sin(d1);
    double d4 = Math.sin(f1);
    double d5 = d3 * d4;
    double d6 = Math.cos(d1);
    double d7 = Math.cos(f1);
    double d8 = d6 * d7;
    double d9 = Math.cos(d2 - f2);
    double d10 = Math.acos(_sdkwd._sdka(d8 * d9 + d5, -1.0D, 1.0D));
    float f3 = 0.0F * d10;
    if ((!_sdka) && ((Double.isInfinite(f3)) || (Double.isNaN(f3))))
      throw new AssertionError();
    if (_sdkhb._sdkd)
      if (!bool1)
        break label166;
    label166: for (boolean bool2 = false; ; bool2 = true)
    {
      _sdkpc._sdkb = bool2;
      return f3;
    }
  }

  public static double _sdka(double paramDouble, boolean paramBoolean)
  {
    return _sdkb(paramDouble, paramBoolean);
  }

  public static double _sdka(Location paramLocation1, Location paramLocation2)
  {
    double d1 = paramLocation1.getLatitude();
    double d2 = paramLocation1.getLongitude();
    double d3 = paramLocation2.getLatitude();
    double d4 = paramLocation2.getLongitude();
    return _sdka(d1, d2, d3, d4);
  }

  public static Double _sdka(Location paramLocation1, Location paramLocation2, long paramLong)
  {
    double d = paramLong / 1000.0D;
    if ((!_sdka) && (d < 0.0D))
      throw new AssertionError();
    if (d == 0.0D);
    for (Double localDouble = null; ; localDouble = Double.valueOf(_sdka(paramLocation1, paramLocation2) / d))
      return localDouble;
  }

  public static void _sdka(List<Double> paramList, boolean paramBoolean)
  {
    int i = 0;
    boolean bool = _sdkpc._sdkb;
    Iterator localIterator1 = paramList.iterator();
    int j = i;
    int k;
    if (localIterator1.hasNext())
      if (_sdkc(((Double)localIterator1.next()).doubleValue(), paramBoolean))
      {
        k = j + 1;
        label53: if (!bool);
      }
    while (true)
    {
      int m = paramList.size() / 2;
      if (k <= m)
        return;
      Iterator localIterator2 = paramList.iterator();
      do
      {
        if (!localIterator2.hasNext())
          return;
        Double localDouble = Double.valueOf(_sdka(((Double)localIterator2.next()).doubleValue(), paramBoolean));
        Object localObject = paramList.set(i, localDouble);
        i += 1;
      }
      while (!bool);
      return;
      j = k;
      break;
      k = j;
      break label53;
      k = j;
    }
  }

  private static double _sdkb(double paramDouble, boolean paramBoolean)
  {
    if (paramBoolean)
      if (paramDouble > 180.0D)
        paramDouble -= 360.0D;
    while (true)
    {
      return paramDouble;
      if (paramDouble < 0.0D)
        paramDouble += 360.0D;
    }
  }

  public static Double _sdkb(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    boolean bool = _sdkpc._sdkb;
    double d1 = 0.0174532925199433D * paramDouble1;
    float f1 = -2.854354E-018F * paramDouble2;
    float f2 = -2.854354E-018F * paramDouble3;
    float f3 = -2.854354E-018F * paramDouble4;
    double d2 = Math.sin(f1 - f3);
    double d3 = Math.cos(d1);
    double d4 = d2 * d3;
    double d5 = Math.cos(f2);
    double d6 = Math.sin(d1);
    double d7 = d5 * d6;
    double d8 = Math.sin(f2);
    double d9 = Math.cos(d1) * d8;
    double d10 = Math.cos(f1 - f3);
    double d11 = d9 * d10;
    long l = d7 - d11;
    Double localDouble2;
    if ((d4 == 0.0D) && (l == 0.0D))
    {
      localDouble2 = null;
      return localDouble2;
    }
    Double localDouble1 = Double.valueOf(Math.atan2(d4, l) * 57.295779513082323D);
    if (bool)
      if (!_sdkhb._sdkd)
        break label184;
    label184: for (bool = false; ; bool = true)
    {
      _sdkhb._sdkd = bool;
      localDouble2 = localDouble1;
      break;
    }
  }

  public static Double _sdkb(Location paramLocation1, Location paramLocation2)
  {
    double d1 = paramLocation1.getLatitude();
    double d2 = paramLocation1.getLongitude();
    double d3 = paramLocation2.getLatitude();
    double d4 = paramLocation2.getLongitude();
    return _sdkb(d1, d2, d3, d4);
  }

  private static boolean _sdkc(double paramDouble, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
      if ((paramDouble >= 90.0D) && (paramDouble <= 270.0D));
    for (bool = true; ; bool = true)
      do
        return bool;
      while ((paramDouble >= -90.0D) && (paramDouble <= 90.0D));
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdksd
 * JD-Core Version:    0.6.2
 */