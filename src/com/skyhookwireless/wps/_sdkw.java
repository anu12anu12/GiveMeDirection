package com.skyhookwireless.wps;

import java.util.List;

abstract interface _sdkw
{
  public abstract void abort();

  public abstract void getIPLocation(WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, IPLocationCallback paramIPLocationCallback);

  public abstract void getLocation(WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, WPSLocationCallback paramWPSLocationCallback);

  public abstract void getPeriodicLocation(WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, long paramLong, int paramInt, WPSPeriodicLocationCallback paramWPSPeriodicLocationCallback);

  public abstract void registerUser(WPSAuthentication paramWPSAuthentication1, WPSAuthentication paramWPSAuthentication2, RegistrationCallback paramRegistrationCallback);

  public abstract void setLocalFilePaths(List<String> paramList);

  public abstract void setTiling(String paramString, long paramLong1, long paramLong2, TilingListener paramTilingListener);

  public abstract void tuneLocation(WPSAuthentication paramWPSAuthentication, WPSLocation paramWPSLocation, TuneLocationCallback paramTuneLocationCallback);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkw
 * JD-Core Version:    0.6.2
 */