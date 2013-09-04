package com.skyhookwireless.wps;

import com.skyhookwireless._sdktd;
import java.util.concurrent.Callable;

class _sdkob
  implements Callable<_sdktd<WPSReturnCode, _sdkib>>
{
  final WPSAuthentication _sdka;
  final WPSStreetAddressLookup _sdkb;
  final _sdkzb _sdkc;
  final _sdkxb _sdkd;

  _sdkob(_sdkxb param_sdkxb, WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, _sdkzb param_sdkzb)
  {
  }

  public _sdktd<WPSReturnCode, _sdkib> call()
  {
    _sdkxb local_sdkxb = this._sdkd;
    WPSAuthentication localWPSAuthentication = this._sdka;
    WPSStreetAddressLookup localWPSStreetAddressLookup = this._sdkb;
    _sdkzb local_sdkzb = this._sdkc;
    return local_sdkxb._sdka(localWPSAuthentication, localWPSStreetAddressLookup, local_sdkzb);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkob
 * JD-Core Version:    0.6.2
 */