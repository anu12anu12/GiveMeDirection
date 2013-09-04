package com.skyhookwireless.wps;

import com.skyhookwireless._sdkt;

abstract class _sdkg extends _sdkf
  implements _sdkx
{
  protected _sdkg(_sdkt param_sdkt)
  {
    super(param_sdkt);
  }

  protected boolean _sdka()
  {
    return true;
  }

  public void getXPSLocation(WPSAuthentication paramWPSAuthentication, int paramInt1, int paramInt2, WPSPeriodicLocationCallback paramWPSPeriodicLocationCallback)
  {
    WPSStreetAddressLookup localWPSStreetAddressLookup = WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP;
    long l = paramInt1 * 1000;
    _sdkg local_sdkg = this;
    WPSAuthentication localWPSAuthentication = paramWPSAuthentication;
    WPSPeriodicLocationCallback localWPSPeriodicLocationCallback = paramWPSPeriodicLocationCallback;
    local_sdkg.getPeriodicLocation(localWPSAuthentication, localWPSStreetAddressLookup, l, 0, localWPSPeriodicLocationCallback);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkg
 * JD-Core Version:    0.6.2
 */