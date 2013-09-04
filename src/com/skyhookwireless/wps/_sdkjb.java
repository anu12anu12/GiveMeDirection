package com.skyhookwireless.wps;

import java.util.Comparator;

final class _sdkjb
  implements Comparator<Location>
{
  public int compare(Location paramLocation1, Location paramLocation2)
  {
    double d1 = Location._sdka(paramLocation1);
    double d2 = Location._sdka(paramLocation2);
    int i;
    if (d1 < d2)
      i = -1;
    while (true)
    {
      return i;
      double d3 = Location._sdka(paramLocation1);
      double d4 = Location._sdka(paramLocation2);
      if (d3 > d4)
        i = 1;
      else
        i = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkjb
 * JD-Core Version:    0.6.2
 */