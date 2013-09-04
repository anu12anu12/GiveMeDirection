package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdktd;

class _sdkj extends _sdki
{
  private static final String z;
  private final _sdkhb _sdkb;
  private final WPSAuthentication _sdkc;
  private final WPSStreetAddressLookup _sdkd;
  private final IPLocationCallback _sdke;

  static
  {
    Object localObject1 = "M^\026*\021ez3*\034V{4+\023fb?e\024eg6 \026$y31\032$k\"&\027tz3*\034".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    Object localObject3;
    int n;
    label31: int i1;
    int i2;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      int m = i;
      localObject3 = localObject1;
      n = m;
      i1 = localObject3[j];
      switch (k % 5)
      {
      default:
        i2 = 114;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i3 = (char)(i2 ^ i1);
      localObject3[j] = i3;
      j = k + 1;
      if (n == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = n;
        break label31;
      }
      i = n;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i2 = 4;
      continue;
      i2 = 14;
      continue;
      i2 = 90;
      continue;
      i2 = 69;
    }
  }

  private _sdkj(WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, IPLocationCallback paramIPLocationCallback)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkj.class);
    this._sdkb = local_sdkhb;
    this._sdkc = paramWPSAuthentication;
    this._sdkd = paramWPSStreetAddressLookup;
    this._sdke = paramIPLocationCallback;
  }

  _sdkj(WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, IPLocationCallback paramIPLocationCallback, _sdkh param_sdkh)
  {
    this(paramWPSAuthentication, paramWPSStreetAddressLookup, paramIPLocationCallback);
  }

  public void run()
  {
    try
    {
      _sdkxb local_sdkxb = this._sdka;
      WPSAuthentication localWPSAuthentication = this._sdkc;
      WPSStreetAddressLookup localWPSStreetAddressLookup = this._sdkd;
      _sdktd local_sdktd = local_sdkxb._sdka(localWPSAuthentication, localWPSStreetAddressLookup);
      Object localObject = local_sdktd.first;
      WPSReturnCode localWPSReturnCode1 = WPSReturnCode.WPS_OK;
      if (localObject == localWPSReturnCode1)
      {
        IPLocationCallback localIPLocationCallback1 = this._sdke;
        IPLocation localIPLocation = (IPLocation)local_sdktd.second;
        localIPLocationCallback1.handleIPLocation(localIPLocation);
        if (Location._sdki == 0);
      }
      else
      {
        IPLocationCallback localIPLocationCallback2 = this._sdke;
        WPSReturnCode localWPSReturnCode2 = (WPSReturnCode)local_sdktd.first;
        WPSContinuation localWPSContinuation = localIPLocationCallback2.handleError(localWPSReturnCode2);
      }
      _sdkf._sdka(this._sdke);
      return;
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb = this._sdkb;
      String str = z;
      local_sdkhb._sdke(str, localThrowable);
      IPLocationCallback localIPLocationCallback3 = this._sdke;
      WPSReturnCode localWPSReturnCode3 = WPSReturnCode.WPS_ERROR;
      _sdkf._sdkb(localIPLocationCallback3, localWPSReturnCode3);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkj
 * JD-Core Version:    0.6.2
 */