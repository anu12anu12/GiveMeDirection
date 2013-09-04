package com.skyhookwireless.wps;

import com.skyhookwireless._sdkec;
import java.util.Comparator;

final class _sdkyb
  implements Comparator<_sdkib>
{
  public int compare(_sdkib param_sdkib1, _sdkib param_sdkib2)
  {
    int i = 1;
    if (param_sdkib1 == param_sdkib2)
      i = 0;
    while (true)
    {
      return i;
      if (param_sdkib1 == null)
      {
        i = -1;
      }
      else if (param_sdkib2 != null)
      {
        _sdkec local_sdkec1 = param_sdkib1.getAge();
        _sdkec local_sdkec2 = param_sdkib2.getAge();
        int j = local_sdkec1._sdkc(local_sdkec2);
        if (j != 0)
        {
          i = j;
        }
        else
        {
          double d1 = param_sdkib1.getLatitude();
          double d2 = param_sdkib2.getLatitude();
          j = Double.compare(d1, d2);
          if (j != 0)
          {
            i = j;
          }
          else
          {
            double d3 = param_sdkib1.getLongitude();
            double d4 = param_sdkib2.getLongitude();
            j = Double.compare(d3, d4);
            if (j != 0)
            {
              i = j;
            }
            else
            {
              int k = param_sdkib1.getSatellites();
              int m = param_sdkib2.getSatellites();
              j = k - m;
              if (j != 0)
              {
                i = j;
              }
              else
              {
                int n = param_sdkib1.getHPE();
                int i1 = param_sdkib2.getHPE();
                j = n - i1;
                if (j != 0)
                {
                  i = j;
                }
                else
                {
                  boolean bool1 = param_sdkib1.hasAltitude();
                  boolean bool2 = param_sdkib2.hasAltitude();
                  if ((bool1 ^ bool2))
                  {
                    if (!param_sdkib1.hasAltitude())
                      i = -1;
                  }
                  else
                  {
                    double d5 = param_sdkib1.getAltitude();
                    double d6 = param_sdkib2.getAltitude();
                    j = Double.compare(d5, d6);
                    if (j != 0)
                    {
                      i = j;
                    }
                    else
                    {
                      boolean bool3 = param_sdkib1.hasSpeed();
                      boolean bool4 = param_sdkib2.hasSpeed();
                      if ((bool3 ^ bool4))
                      {
                        if (!param_sdkib1.hasSpeed())
                          i = -1;
                      }
                      else
                      {
                        double d7 = param_sdkib1.getSpeed();
                        double d8 = param_sdkib2.getSpeed();
                        i = Double.compare(d7, d8);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkyb
 * JD-Core Version:    0.6.2
 */