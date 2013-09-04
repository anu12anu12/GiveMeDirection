package com.skyhookwireless.wps;

import java.util.Comparator;

final class _sdklb
  implements Comparator<Location>
{
  public int compare(Location paramLocation1, Location paramLocation2)
  {
    long l1 = Location._sdkc(paramLocation1);
    long l2 = Location._sdkc(paramLocation2);
    int i;
    if (l1 < l2)
      i = -1;
    while (true)
    {
      return i;
      long l3 = Location._sdkc(paramLocation1);
      long l4 = Location._sdkc(paramLocation2);
      if (l3 > l4)
        i = 1;
      else
        i = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdklb
 * JD-Core Version:    0.6.2
 */