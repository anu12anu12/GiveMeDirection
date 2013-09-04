package com.MASTAdView.ormma;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.MASTAdView.MASTAdLog;
import com.MASTAdView.MASTAdViewCore;
import com.MASTAdView.ormma.listeners.LocListener;
import java.util.Iterator;
import java.util.List;

public class OrmmaLocationController extends OrmmaController
{
  final float DISTANCE = 1000.0F;
  final int INTERVAL = 300000;
  private boolean hasPermission = false;
  private LocListener mGps;
  private int mLocListenerCount;
  private LocationManager mLocationManager;
  private LocListener mNetwork;

  public OrmmaLocationController(MASTAdViewCore paramMASTAdViewCore, Context paramContext)
  {
    super(paramMASTAdViewCore, paramContext);
    try
    {
      LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
      this.mLocationManager = localLocationManager;
      if (this.mLocationManager.getProvider("gps") != null)
      {
        OrmmaLocationController localOrmmaLocationController1 = this;
        Context localContext1 = paramContext;
        LocListener local1 = new LocListener()
        {
          public void fail(String paramAnonymousString)
          {
            OrmmaLocationController.this.onFail(paramAnonymousString);
          }

          public void success(Location paramAnonymousLocation)
          {
            OrmmaLocationController.this.onSuccess(paramAnonymousLocation);
          }
        };
        this.mGps = local1;
      }
      if (this.mLocationManager.getProvider("network") != null)
      {
        OrmmaLocationController localOrmmaLocationController2 = this;
        Context localContext2 = paramContext;
        LocListener local2 = new LocListener()
        {
          public void fail(String paramAnonymousString)
          {
            OrmmaLocationController.this.onFail(paramAnonymousString);
          }

          public void success(Location paramAnonymousLocation)
          {
            OrmmaLocationController.this.onSuccess(paramAnonymousLocation);
          }
        };
        this.mNetwork = local2;
      }
      this.hasPermission = true;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"location\",\"Security error\")");
    }
  }

  public String getLocation()
  {
    String str1;
    if (!this.hasPermission)
    {
      onFail("Security error");
      str1 = null;
    }
    while (true)
    {
      return str1;
      Iterator localIterator = this.mLocationManager.getProviders(true).iterator();
      Location localLocation = null;
      label33: if (!localIterator.hasNext());
      while (true)
      {
        if (localLocation == null)
          break label164;
        StringBuilder localStringBuilder1 = new StringBuilder("{ \"lat\": ");
        double d1 = localLocation.getLatitude();
        StringBuilder localStringBuilder2 = localStringBuilder1.append(d1).append(", ").append("\"lon\": ");
        double d2 = localLocation.getLongitude();
        StringBuilder localStringBuilder3 = localStringBuilder2.append(d2).append(", ").append("\"acc\": ");
        float f = localLocation.getAccuracy();
        str1 = f + "}";
        break;
        LocationManager localLocationManager = this.mLocationManager;
        String str2 = (String)localIterator.next();
        localLocation = localLocationManager.getLastKnownLocation(str2);
        if (localLocation == null)
          break label33;
      }
      label164: str1 = null;
    }
  }

  public void onFail(String paramString)
  {
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str = "Ormma.fireError(\"location\"," + paramString + ")";
    localMASTAdViewCore.injectJavaScript(str);
  }

  public void onSuccess(Location paramLocation)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("{ \"lat\": ");
    double d1 = paramLocation.getLatitude();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(d1).append(", ").append("\"lon\": ");
    double d2 = paramLocation.getLongitude();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(d2).append(", ").append("\"acc\": ");
    float f = paramLocation.getAccuracy();
    String str1 = f + "}";
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str2 = "Ormma.locationChanged(" + str1 + ")";
    localMASTAdViewCore.injectJavaScript(str2);
  }

  public void startLocationListener()
  {
    if (!this.hasPermission)
    {
      onFail("Security error");
      return;
    }
    if (this.mLocListenerCount == 0)
    {
      if (this.mNetwork != null)
        this.mNetwork.start();
      if (this.mGps != null)
        this.mGps.start();
    }
    int i = this.mLocListenerCount + 1;
    this.mLocListenerCount = i;
  }

  public void stopLocationListener()
  {
    if (this.mLocListenerCount <= 0)
      return;
    int i = this.mLocListenerCount + -1;
    this.mLocListenerCount = i;
    if (this.mLocListenerCount != 0)
      return;
    if (this.mNetwork != null)
      this.mNetwork.stop();
    if (this.mGps == null)
      return;
    this.mGps.stop();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.OrmmaLocationController
 * JD-Core Version:    0.6.2
 */