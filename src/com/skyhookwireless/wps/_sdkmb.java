package com.skyhookwireless.wps;

import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkjc;
import com.skyhookwireless._sdktd;
import com.skyhookwireless._sdkwb;
import java.util.ArrayList;
import java.util.List;

abstract class _sdkmb
{
  public static _sdkmb newInstance()
  {
    return new XPSSwitchingAlgorithm();
  }

  public abstract _sdktd<WPSReturnCode, _sdkib> calculateLocation(ArrayList<_sdkjc> paramArrayList, ArrayList<_sdkhb> paramArrayList1, _sdkib param_sdkib, boolean paramBoolean1, boolean paramBoolean2, long paramLong, List<_sdkwb> paramList, _sdkec param_sdkec);

  public abstract long getGpsPeriod();

  public abstract long getWifiPeriod();

  public abstract void saveRemoteLocation(_sdkib param_sdkib);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkmb
 * JD-Core Version:    0.6.2
 */