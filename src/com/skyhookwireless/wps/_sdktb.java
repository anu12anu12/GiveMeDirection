package com.skyhookwireless.wps;

import com.skyhookwireless._sdkec;

class _sdktb
  implements WPSPeriodicLocationCallback
{
  private final WPSPeriodicLocationCallback _sdka;
  private _sdkec _sdkb;
  private _sdkec _sdkc;
  private WPSContinuation _sdkd;
  private int _sdke;
  private _sdkib _sdkf;

  _sdktb(WPSPeriodicLocationCallback paramWPSPeriodicLocationCallback, WPSContinuation paramWPSContinuation)
  {
    this._sdka = paramWPSPeriodicLocationCallback;
    this._sdkd = paramWPSContinuation;
    _sdkec local_sdkec = _sdkec._sdkd();
    this._sdkb = local_sdkec;
    this._sdkc = null;
    this._sdke = -1;
    this._sdkf = null;
  }

  long _sdka()
  {
    return this._sdkb._sdka();
  }

  Long _sdkb()
  {
    if (this._sdkc != null);
    for (Long localLong = Long.valueOf(this._sdkc._sdka()); ; localLong = null)
      return localLong;
  }

  WPSContinuation _sdkc()
  {
    return this._sdkd;
  }

  int _sdkd()
  {
    return this._sdke;
  }

  _sdkib _sdke()
  {
    return this._sdkf;
  }

  public void done()
  {
    this._sdka.done();
    _sdkec local_sdkec = _sdkec._sdkd();
    this._sdkb = local_sdkec;
  }

  public WPSContinuation handleError(WPSReturnCode paramWPSReturnCode)
  {
    WPSContinuation localWPSContinuation = this._sdka.handleError(paramWPSReturnCode);
    this._sdkd = localWPSContinuation;
    _sdkec local_sdkec = _sdkec._sdkd();
    this._sdkb = local_sdkec;
    this._sdkf = null;
    return this._sdkd;
  }

  public WPSContinuation handleWPSPeriodicLocation(WPSLocation paramWPSLocation)
  {
    WPSContinuation localWPSContinuation = this._sdka.handleWPSPeriodicLocation(paramWPSLocation);
    this._sdkd = localWPSContinuation;
    _sdkec local_sdkec = _sdkec._sdkd();
    this._sdkc = local_sdkec;
    this._sdkb = local_sdkec;
    _sdkib local_sdkib = (_sdkib)paramWPSLocation;
    this._sdkf = local_sdkib;
    return this._sdkd;
  }

  public WPSContinuation handleWPSPeriodicLocationTrack(WPSLocation paramWPSLocation, int paramInt)
  {
    this._sdke = paramInt;
    return handleWPSPeriodicLocation(paramWPSLocation);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdktb
 * JD-Core Version:    0.6.2
 */