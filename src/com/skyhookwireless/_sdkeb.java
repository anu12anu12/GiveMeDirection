package com.skyhookwireless;

import android.location.LocationManager;
import java.util.concurrent.Callable;

class _sdkeb
  implements Callable<Boolean>
{
  final _sdkdb _sdka;

  _sdkeb(_sdkdb param_sdkdb)
  {
  }

  public Boolean _sdka()
    throws Exception
  {
    LocationManager localLocationManager = _sdkdb._sdka(this._sdka);
    _sdkdb local_sdkdb = this._sdka;
    return Boolean.valueOf(localLocationManager.addGpsStatusListener(local_sdkdb));
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkeb
 * JD-Core Version:    0.6.2
 */