package com.hopstop.gps;

import android.content.Context;
import java.util.List;

public class SkyHookGPS
  implements GpsLocationManager
{
  private XSPLocationManager _xspLocManager;

  public SkyHookGPS(Context paramContext)
  {
    XSPLocationManager localXSPLocationManager = XSPLocationManager.getXSPLocationManager(paramContext);
    this._xspLocManager = localXSPLocationManager;
  }

  public void cancelRequestGPS(HopStopLocationListener paramHopStopLocationListener, boolean paramBoolean)
  {
    this._xspLocManager.done();
  }

  public List<String> getAllProviders()
  {
    return this._xspLocManager.getProviders(true);
  }

  public boolean isProviderAvailable(String paramString)
  {
    boolean bool = true;
    if (this._xspLocManager.getProviders(bool).contains(paramString));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public void requestGPSFix(HopStopLocationListener paramHopStopLocationListener, GPSSettings paramGPSSettings)
  {
    this._xspLocManager.registerLocalisationListener(paramHopStopLocationListener, paramGPSSettings);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.SkyHookGPS
 * JD-Core Version:    0.6.2
 */