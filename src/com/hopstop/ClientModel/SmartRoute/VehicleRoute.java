package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;

public class VehicleRoute
  implements Serializable
{
  private boolean _has_stopId;
  private String _partId;
  private String _stationId;
  private int _stopId;

  public void deleteStopId()
  {
    this._has_stopId = false;
  }

  public String getPartId()
  {
    return this._partId;
  }

  public String getStationId()
  {
    return this._stationId;
  }

  public int getStopId()
  {
    return this._stopId;
  }

  public boolean hasStopId()
  {
    return this._has_stopId;
  }

  public void setPartId(String paramString)
  {
    this._partId = paramString;
  }

  public void setStationId(String paramString)
  {
    this._stationId = paramString;
  }

  public void setStopId(int paramInt)
  {
    this._stopId = paramInt;
    this._has_stopId = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.VehicleRoute
 * JD-Core Version:    0.6.2
 */