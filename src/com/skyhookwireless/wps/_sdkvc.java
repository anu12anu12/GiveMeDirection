package com.skyhookwireless.wps;

import com.skyhookwireless._sdknd;
import com.skyhookwireless._sdkpd;
import com.skyhookwireless._sdkwb;
import java.util.List;

abstract interface _sdkvc extends _sdkuc
{
  public abstract void abort();

  public abstract long getGpsPeriod();

  public abstract long getWifiPeriod();

  public abstract WPSContinuation handleEvents(List<_sdkpd> paramList, _sdknd param_sdknd);

  public abstract WPSContinuation handleScan(_sdkzb param_sdkzb, _sdknd param_sdknd, boolean paramBoolean1, boolean paramBoolean2, List<_sdkwb> paramList);

  public abstract void init();

  public abstract _sdkib lastLocation();

  public abstract boolean reportedFirstFix();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkvc
 * JD-Core Version:    0.6.2
 */