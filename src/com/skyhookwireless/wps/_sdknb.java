package com.skyhookwireless.wps;

import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdktd;
import com.skyhookwireless._sdkwb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class _sdknb
{
  static final boolean _sdkd;
  private final _sdkhb _sdka;
  private final _sdkmb _sdkb;
  private final _sdky _sdkc;

  static
  {
    if (!_sdknb.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkd = bool;
      return;
    }
  }

  _sdknb(WPSAuthentication paramWPSAuthentication, List<String> paramList, _sdkrc param_sdkrc)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdknb.class);
    this._sdka = local_sdkhb;
    _sdkmb local_sdkmb = _sdkmb.newInstance();
    this._sdkb = local_sdkmb;
    _sdky local_sdky = new _sdky(paramWPSAuthentication, paramList, param_sdkrc);
    this._sdkc = local_sdky;
  }

  _sdktd<WPSReturnCode, _sdkib> _sdka(_sdkzb param_sdkzb, boolean paramBoolean1, boolean paramBoolean2, long paramLong, List<_sdkwb> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    this._sdkc._sdka(param_sdkzb, localArrayList1);
    if (param_sdkzb.getGpsLocations().isEmpty());
    _sdkec local_sdkec1;
    long l1;
    _sdktd local_sdktd1;
    _sdkib local_sdkib2;
    ArrayList localArrayList3;
    Comparator localComparator;
    for (_sdkib local_sdkib1 = null; ; local_sdkib1 = (_sdkib)Collections.min(localArrayList3, localComparator))
    {
      local_sdkec1 = _sdkec._sdkd();
      l1 = System.currentTimeMillis();
      _sdkmb local_sdkmb = this._sdkb;
      ArrayList localArrayList2 = param_sdkzb.getAPs();
      boolean bool1 = paramBoolean1;
      boolean bool2 = paramBoolean2;
      long l2 = paramLong;
      List<_sdkwb> localList = paramList;
      local_sdktd1 = local_sdkmb.calculateLocation(localArrayList2, localArrayList1, local_sdkib1, bool1, bool2, l2, localList, local_sdkec1);
      if (local_sdktd1.second == null)
        break label231;
      local_sdkib2 = (_sdkib)local_sdktd1.second;
      if (local_sdkib2.hasTime())
        break label201;
      if ((_sdkd) || (((_sdkib)local_sdktd1.second).getAge() != null))
        break;
      throw new AssertionError();
      localArrayList3 = param_sdkzb.getGpsLocations();
      localComparator = _sdkbb.COMPARATOR;
    }
    _sdkec local_sdkec2 = local_sdkib2.getAge();
    long l3 = local_sdkec1._sdkb(local_sdkec2);
    long l4 = l1 - l3;
    local_sdkib2.setTime(l4);
    label201: if (local_sdkib2.hasSpeed())
    {
      double d = local_sdkib2.getSpeed() * 3600.0D / 1000.0D;
      local_sdkib2.setSpeed(d);
    }
    label231: Object localObject = local_sdktd1.first;
    WPSReturnCode localWPSReturnCode = WPSReturnCode.WPS_ERROR_NO_WIFI_IN_RANGE;
    if ((localObject == localWPSReturnCode) && (!param_sdkzb.getCells().isEmpty()));
    for (_sdktd local_sdktd2 = _sdktd._sdka(WPSReturnCode.WPS_ERROR_LOCATION_CANNOT_BE_DETERMINED, null); ; local_sdktd2 = local_sdktd1)
      return local_sdktd2;
  }

  void _sdka()
  {
    this._sdkc._sdka();
  }

  void _sdka(WPSAuthentication paramWPSAuthentication)
  {
    this._sdkc._sdka(paramWPSAuthentication);
  }

  void _sdka(_sdkib param_sdkib)
  {
    this._sdkb.saveRemoteLocation(param_sdkib);
  }

  void _sdka(_sdkrc param_sdkrc)
  {
    this._sdkc._sdka(param_sdkrc);
  }

  void _sdka(List<String> paramList)
  {
    this._sdkc._sdka(paramList);
  }

  void _sdkb()
  {
    this._sdkc._sdkb();
  }

  long _sdkc()
  {
    return this._sdkb.getWifiPeriod();
  }

  long _sdkd()
  {
    return this._sdkb.getGpsPeriod();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdknb
 * JD-Core Version:    0.6.2
 */