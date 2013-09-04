package com.hopstop.gps;

import android.location.Location;

public abstract interface GpsObserver
{
  public static final int GPS_LINTENER_CANCEL = 3;
  public static final int GPS_LISTENER_TIMEOUT = 0;
  public static final int GPS_NO_PROVIDER_AVAILABLE = 2;
  public static final int GPS_SUCCESS_GOT_GPS = 1;

  public abstract void onLocationChanged(Location paramLocation);

  public abstract void onLocationError(int paramInt);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.GpsObserver
 * JD-Core Version:    0.6.2
 */