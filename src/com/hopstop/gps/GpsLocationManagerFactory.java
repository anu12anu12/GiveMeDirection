package com.hopstop.gps;

import android.content.Context;

public class GpsLocationManagerFactory
{
  public static GpsLocationManager getAndroidGPS(Context paramContext)
  {
    return new AndroidGPS(paramContext);
  }

  public static HopStopLocationListener getHopStopLocationListener(String paramString, GPSSettings paramGPSSettings, GpsObserver paramGpsObserver)
  {
    return new HopStopLocationListener(paramString, paramGPSSettings, paramGpsObserver);
  }

  public static GpsLocationManager getInstance(Context paramContext)
  {
    return null;
  }

  public static GpsLocationManager getSkyHookGPS(Context paramContext)
  {
    return new SkyHookGPS(paramContext);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.GpsLocationManagerFactory
 * JD-Core Version:    0.6.2
 */