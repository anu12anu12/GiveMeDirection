package com.hopstop.gps;

import java.util.List;

public abstract interface GpsLocationManager
{
  public abstract void cancelRequestGPS(HopStopLocationListener paramHopStopLocationListener, boolean paramBoolean);

  public abstract List<String> getAllProviders();

  public abstract boolean isProviderAvailable(String paramString);

  public abstract void requestGPSFix(HopStopLocationListener paramHopStopLocationListener, GPSSettings paramGPSSettings);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.GpsLocationManager
 * JD-Core Version:    0.6.2
 */