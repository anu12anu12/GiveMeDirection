package com.skyhookwireless;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class _sdkwd
{
  static
  {
    if (!_sdkwd.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdka = bool;
      return;
    }
  }

  public static double _sdka(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 + paramDouble2) / 2.0D;
  }

  public static double _sdka(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if ((!_sdka) && (paramDouble2 > paramDouble3))
      throw new AssertionError();
    double d = Math.min(paramDouble1, paramDouble3);
    return Math.max(paramDouble2, d);
  }

  public static double _sdka(Collection<? extends Number> paramCollection)
  {
    boolean bool = _sdkpc._sdkb;
    Iterator localIterator = paramCollection.iterator();
    double d1 = 0.0D;
    double d3;
    if (localIterator.hasNext())
    {
      double d2 = ((Number)localIterator.next()).doubleValue();
      d3 = d1 + d2;
      if (!bool);
    }
    while (true)
    {
      return d3;
      d1 = d3;
      break;
      d3 = d1;
    }
  }

  public static double _sdka(List<Double> paramList)
  {
    int i = paramList.size();
    if ((!_sdka) && (paramList.size() <= 0))
      throw new AssertionError();
    Collections.sort(paramList);
    int j = (i + -1) / 2;
    double d1 = ((Double)paramList.get(j)).doubleValue();
    if (i % 2 == 1);
    double d3;
    for (double d2 = d1; ; d2 = _sdka(d1, d3))
    {
      return d2;
      int k = i / 2;
      d3 = ((Double)paramList.get(k)).doubleValue();
    }
  }

  public static <T extends Number> Double _sdka(Collection<T> paramCollection1, Collection<T> paramCollection2)
  {
    boolean bool = _sdkpc._sdkb;
    Iterator localIterator1 = paramCollection2.iterator();
    Iterator localIterator2 = paramCollection1.iterator();
    double d1 = 0.0D;
    double d5;
    if (localIterator2.hasNext())
    {
      Number localNumber = (Number)localIterator2.next();
      if ((!_sdka) && (!localIterator1.hasNext()))
        throw new AssertionError();
      double d2 = localNumber.doubleValue();
      double d3 = ((Number)localIterator1.next()).doubleValue();
      double d4 = d2 * d3;
      d5 = d1 + d4;
      if (!bool);
    }
    while (true)
    {
      double d6 = _sdka(paramCollection2);
      if (d6 == 0.0D);
      for (Double localDouble = null; ; localDouble = Double.valueOf(d5 / d6))
        return localDouble;
      d1 = d5;
      break;
      d5 = d1;
    }
  }

  public static double _sdkb(Collection<? extends Number> paramCollection)
  {
    double d1 = _sdka(paramCollection);
    double d2 = paramCollection.size();
    return d1 / d2;
  }

  public static Double _sdkc(Collection<? extends Number> paramCollection)
  {
    boolean bool = _sdkpc._sdkb;
    Double localDouble;
    if (paramCollection.size() == 0)
    {
      localDouble = null;
      return localDouble;
    }
    Iterator localIterator = paramCollection.iterator();
    double d1 = 0.0D;
    double d2 = 0.0D;
    double d3 = d1;
    double d4 = 0.0D;
    double d5 = d2;
    label47: double d7;
    double d12;
    if (localIterator.hasNext())
    {
      double d6 = ((Number)localIterator.next()).doubleValue();
      d7 = 1L + d4;
      double d8 = d6 - d5;
      double d9 = d7;
      d4 = d8 / d9 + d5;
      double d10 = d6 - d5;
      double d11 = d6 - d4;
      d5 = d10 * d11;
      d12 = d3 + d5;
      if (!bool);
    }
    while (true)
    {
      double d13 = d7;
      localDouble = Double.valueOf(d12 / d13);
      break;
      double d14 = d4;
      double d15 = d7;
      d3 = d12;
      break label47;
      d7 = d4;
      d12 = d3;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkwd
 * JD-Core Version:    0.6.2
 */