package com.MASTAdView.ormma.listeners;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.MASTAdView.MASTAdLog;

public class LocListener
  implements LocationListener
{
  MASTAdLog adLog;
  private Looper listenerLooper;
  private float mDistance;
  private long mInterval;
  private LocationManager mLocMan;
  private String mProvider;

  public LocListener(Context paramContext, int paramInt, float paramFloat, String paramString, Looper paramLooper, MASTAdLog paramMASTAdLog)
  {
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    this.mLocMan = localLocationManager;
    this.mProvider = paramString;
    long l = paramInt;
    this.mInterval = l;
    this.mDistance = paramFloat;
    this.listenerLooper = paramLooper;
    this.adLog = paramMASTAdLog;
  }

  public LocListener(Context paramContext, int paramInt, float paramFloat, String paramString, MASTAdLog paramMASTAdLog)
  {
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    this.mLocMan = localLocationManager;
    this.mProvider = paramString;
    long l = paramInt;
    this.mInterval = l;
    this.mDistance = paramFloat;
    this.listenerLooper = null;
    this.adLog = paramMASTAdLog;
  }

  public void fail(String paramString)
  {
  }

  public void onLocationChanged(Location paramLocation)
  {
    if ((this.mInterval <= 0L) && (this.mDistance <= 0.0F))
    {
      this.mLocMan.removeUpdates(this);
      if (this.adLog != null)
        this.adLog.log(3, 3, "GPSLocation", "Listener stopped after update.");
    }
    this.adLog.log(3, 3, "GPSLocation", "Location change called.");
    success(paramLocation);
  }

  public void onProviderDisabled(String paramString)
  {
    fail("Location provider is disabled");
  }

  public void onProviderEnabled(String paramString)
  {
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramInt != 0)
      return;
    fail("Location provider is out of service");
  }

  public void start()
  {
    this.adLog.log(3, 3, "GPSLocation", "Listener started.");
    if (this.listenerLooper != null)
    {
      LocationManager localLocationManager1 = this.mLocMan;
      String str1 = this.mProvider;
      long l1 = this.mInterval;
      float f1 = this.mDistance;
      Looper localLooper = this.listenerLooper;
      LocListener localLocListener1 = this;
      localLocationManager1.requestLocationUpdates(str1, l1, f1, localLocListener1, localLooper);
      return;
    }
    LocationManager localLocationManager2 = this.mLocMan;
    String str2 = this.mProvider;
    long l2 = this.mInterval;
    float f2 = this.mDistance;
    LocListener localLocListener2 = this;
    localLocationManager2.requestLocationUpdates(str2, l2, f2, localLocListener2);
  }

  public void stop()
  {
    this.mLocMan.removeUpdates(this);
  }

  public void success(Location paramLocation)
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.listeners.LocListener
 * JD-Core Version:    0.6.2
 */