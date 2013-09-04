package com.hopstop.gps;

import android.location.Location;

public class HopStopLocationListener
{
  public GpsObserver _gpsObserver;
  private String _provider;
  private GPSSettings _setting;

  public HopStopLocationListener(String paramString, GPSSettings paramGPSSettings, GpsObserver paramGpsObserver)
  {
    this._provider = paramString;
    this._setting = paramGPSSettings;
    this._gpsObserver = paramGpsObserver;
  }

  public int getMinTime()
  {
    return this._setting.minTime;
  }

  public String getProvider()
  {
    return this._provider;
  }

  public void onLocationChanged(Location paramLocation)
  {
    if ((paramLocation.getLatitude() == 0.0D) && (paramLocation.getLongitude() == 0.0D))
      return;
    if (paramLocation.hasAccuracy())
    {
      float f1 = paramLocation.getAccuracy();
      float f2 = this._setting.acc;
      if (f1 > f2)
        return;
    }
    this._gpsObserver.onLocationChanged(paramLocation);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.HopStopLocationListener
 * JD-Core Version:    0.6.2
 */