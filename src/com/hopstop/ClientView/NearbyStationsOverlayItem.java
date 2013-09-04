package com.hopstop.ClientView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.hopstop.ClientModel.NearbyStations.Station;

public class NearbyStationsOverlayItem extends OverlayItem
{
  protected Station station;

  public NearbyStationsOverlayItem(GeoPoint paramGeoPoint, String paramString1, String paramString2, Station paramStation)
  {
    super(paramGeoPoint, paramString1, paramString2);
    this.station = paramStation;
  }

  public Station getStation()
  {
    return this.station;
  }

  public void setStation(Station paramStation)
  {
    this.station = paramStation;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.NearbyStationsOverlayItem
 * JD-Core Version:    0.6.2
 */