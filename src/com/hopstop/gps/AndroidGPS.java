package com.hopstop.gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.hopstop.core.ApplicationEngine;
import java.util.ArrayList;
import java.util.List;

public class AndroidGPS
  implements GpsLocationManager
{
  private Context _context;
  private float distance;
  private ArrayList<MyLocationListener> listenerArray;
  private LocationManager locManager;

  public AndroidGPS(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    this.listenerArray = localArrayList;
    this._context = paramContext;
    LocationManager localLocationManager = (LocationManager)this._context.getSystemService("location");
    this.locManager = localLocationManager;
  }

  public void cancelRequestGPS(HopStopLocationListener paramHopStopLocationListener, boolean paramBoolean)
  {
    int i = 0;
    while (true)
    {
      int j = this.listenerArray.size();
      if (i >= j)
        return;
      if (this.listenerArray.size() > i)
      {
        MyLocationListener localMyLocationListener = (MyLocationListener)this.listenerArray.get(i);
        if (localMyLocationListener._listener == paramHopStopLocationListener)
        {
          this.locManager.removeUpdates(localMyLocationListener);
          boolean bool = this.listenerArray.remove(localMyLocationListener);
          return;
        }
      }
      i += 1;
    }
  }

  public List<String> getAllProviders()
  {
    if (ApplicationEngine.APPLICATION_FOR_AMAZON_MARKET);
    for (Object localObject = new ArrayList(); ; localObject = this.locManager.getProviders(true))
      return localObject;
  }

  public boolean isProviderAvailable(String paramString)
  {
    boolean bool = true;
    if (this.locManager.getProviders(bool).contains(paramString));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public void requestGPSFix(HopStopLocationListener paramHopStopLocationListener, GPSSettings paramGPSSettings)
  {
    MyLocationListener localMyLocationListener = new MyLocationListener(paramHopStopLocationListener);
    LocationManager localLocationManager = this.locManager;
    String str = paramHopStopLocationListener.getProvider();
    long l = paramHopStopLocationListener.getMinTime();
    float f = this.distance;
    Looper localLooper = this._context.getMainLooper();
    localLocationManager.requestLocationUpdates(str, l, f, localMyLocationListener, localLooper);
    boolean bool = this.listenerArray.add(localMyLocationListener);
  }

  public class MyLocationListener
    implements LocationListener
  {
    private HopStopLocationListener _listener;

    public MyLocationListener(HopStopLocationListener arg2)
    {
      Object localObject;
      this._listener = localObject;
    }

    public void onLocationChanged(Location paramLocation)
    {
      this._listener.onLocationChanged(paramLocation);
    }

    public void onProviderDisabled(String paramString)
    {
    }

    public void onProviderEnabled(String paramString)
    {
    }

    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.AndroidGPS
 * JD-Core Version:    0.6.2
 */