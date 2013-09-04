package com.ls.widgets.map.providers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.ls.widgets.map.interfaces.MapLocationListener;

public final class GPSLocationProvider
  implements LocationListener
{
  private LocationManager a;
  private int b;
  private int c;
  private MapLocationListener d;
  private long e;
  private Location f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private a l;

  public GPSLocationProvider(Context paramContext)
  {
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    this.a = localLocationManager;
    this.i = false;
    this.k = false;
    a locala = new a(null);
    this.l = locala;
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    if (localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", str) == 0)
    {
      this.j = true;
      return;
    }
    this.j = false;
  }

  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = "UNKNOWN";
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return str;
      str = "OUT_OF_SERVICE";
      continue;
      str = "TEMPORARILY_UNAVAILABLE";
      continue;
      str = "AVAILABLE:";
    }
  }

  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation == null)
      return;
    if (!this.k)
    {
      long l1 = SystemClock.elapsedRealtime();
      this.e = l1;
      if (paramLocation.getProvider().equals("network"))
        if (!this.h)
          this.d.onMovePinTo(paramLocation);
      while (true)
      {
        this.f = paramLocation;
        return;
        if (paramLocation.getProvider().equals("gps"))
          this.d.onMovePinTo(paramLocation);
      }
    }
    this.d.onMovePinTo(paramLocation);
  }

  public void onProviderDisabled(String paramString)
  {
    String str = "Provider disabled: " + paramString;
    int m = Log.d("GPSLocationProvider", str);
  }

  public void onProviderEnabled(String paramString)
  {
    String str = "Provider enabled: " + paramString;
    int m = Log.d("GPSLocationProvider", str);
    if (!this.i)
      return;
    if (this.k)
      return;
    if (!paramString.equals("gps"))
      return;
    LocationManager localLocationManager = this.a;
    long l1 = this.b;
    float f1 = this.c;
    GPSLocationProvider localGPSLocationProvider = this;
    localLocationManager.requestLocationUpdates("gps", l1, f1, localGPSLocationProvider);
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Status of ").append(paramString).append(" changed for ");
    String str1 = a(paramInt);
    String str2 = str1;
    int m = Log.d("GPSLocationProvider", str2);
  }

  public void setMapLocationListener(MapLocationListener paramMapLocationListener)
  {
    this.d = paramMapLocationListener;
  }

  public void setMinRefreshDistance(int paramInt)
  {
    this.c = paramInt;
  }

  public void setMinRefreshTime(int paramInt)
  {
    this.b = paramInt;
  }

  public void start(boolean paramBoolean)
  {
    Location localLocation1 = null;
    if (!this.j)
    {
      int m = Log.w("GPSLocationProvider", "Can't start receiving the location updates. You have no ACCESS_FINE_LOCATION permission enabled.");
      return;
    }
    if (this.i)
    {
      int n = Log.w("GPSLocationProvider", "Can't start receiving the location updates. Already started.");
      return;
    }
    this.i = true;
    label299: label307: label330: 
    while (true)
    {
      Location localLocation2;
      try
      {
        this.k = paramBoolean;
        if (paramBoolean)
        {
          LocationManager localLocationManager1 = this.a;
          GPSLocationProvider localGPSLocationProvider1 = this;
          localLocationManager1.requestLocationUpdates("passive", 0L, 0.0F, localGPSLocationProvider1);
          int i1 = Log.d("GPSLocationProvider", "Registering for receiving updates from passive provider.");
          localLocation2 = this.a.getLastKnownLocation("network");
          localLocation1 = this.a.getLastKnownLocation("gps");
          if ((localLocation2 == null) || (localLocation1 == null))
            break label307;
          float f1 = localLocation2.getAccuracy();
          float f2 = localLocation1.getAccuracy();
          if (f1 >= f2)
            break label299;
          onLocationChanged(localLocation2);
          if (this.d == null)
            return;
          this.d.onChangePinVisibility(true);
          return;
        }
      }
      catch (SecurityException localSecurityException)
      {
        String str = "Can't get location provider due to " + localSecurityException;
        int i2 = Log.w("GPSLocationProvider", str);
        return;
      }
      LocationManager localLocationManager2 = this.a;
      a locala = this.l;
      boolean bool = localLocationManager2.addGpsStatusListener(locala);
      if (this.a.isProviderEnabled("network"))
      {
        LocationManager localLocationManager3 = this.a;
        long l1 = this.b;
        float f3 = this.c;
        GPSLocationProvider localGPSLocationProvider2 = this;
        localLocationManager3.requestLocationUpdates("network", l1, f3, localGPSLocationProvider2);
      }
      LocationManager localLocationManager4 = this.a;
      long l2 = this.b;
      float f4 = this.c;
      GPSLocationProvider localGPSLocationProvider3 = this;
      localLocationManager4.requestLocationUpdates("gps", l2, f4, localGPSLocationProvider3);
      continue;
      onLocationChanged(localLocation1);
      continue;
      if (localLocation2 != null);
      while (true)
      {
        if (localLocation2 == null)
          break label330;
        onLocationChanged(localLocation2);
        break;
        localLocation2 = localLocation1;
      }
    }
  }

  public void stop()
  {
    LocationManager localLocationManager = this.a;
    a locala = this.l;
    localLocationManager.removeGpsStatusListener(locala);
    if (this.d != null)
      this.d.onChangePinVisibility(false);
    this.i = false;
    this.a.removeUpdates(this);
  }

  private class a
    implements GpsStatus.Listener
  {
    private a()
    {
    }

    public void onGpsStatusChanged(int paramInt)
    {
      if (GPSLocationProvider.a(GPSLocationProvider.this))
        return;
      switch (paramInt)
      {
      default:
        return;
      case 3:
        boolean bool1 = GPSLocationProvider.a(GPSLocationProvider.this, true);
        boolean bool2 = GPSLocationProvider.b(GPSLocationProvider.this, true);
        return;
      case 4:
      }
      GPSLocationProvider localGPSLocationProvider;
      if (GPSLocationProvider.b(GPSLocationProvider.this) != null)
      {
        localGPSLocationProvider = GPSLocationProvider.this;
        long l1 = SystemClock.elapsedRealtime();
        long l2 = GPSLocationProvider.c(GPSLocationProvider.this);
        if (l1 - l2 >= 3000L)
          break label131;
      }
      label131: for (boolean bool3 = true; ; bool3 = false)
      {
        boolean bool4 = GPSLocationProvider.a(localGPSLocationProvider, bool3);
        if (!GPSLocationProvider.d(GPSLocationProvider.this))
          break;
        boolean bool5 = GPSLocationProvider.b(GPSLocationProvider.this, true);
        return;
      }
      boolean bool6 = GPSLocationProvider.b(GPSLocationProvider.this, false);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.providers.GPSLocationProvider
 * JD-Core Version:    0.6.2
 */