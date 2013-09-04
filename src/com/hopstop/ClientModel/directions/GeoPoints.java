package com.hopstop.ClientModel.directions;

import com.google.android.maps.GeoPoint;

public class GeoPoints
{
  private GeoPoint _end;
  private int _routeColor;
  private GeoPoint _start;

  public GeoPoint getEnd()
  {
    return this._end;
  }

  public int getRouteColor()
  {
    return this._routeColor;
  }

  public GeoPoint getStart()
  {
    return this._start;
  }

  public void setEnd(GeoPoint paramGeoPoint)
  {
    this._end = paramGeoPoint;
  }

  public void setRouteColor(int paramInt)
  {
    this._routeColor = paramInt;
  }

  public void setStart(GeoPoint paramGeoPoint)
  {
    this._start = paramGeoPoint;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.GeoPoints
 * JD-Core Version:    0.6.2
 */