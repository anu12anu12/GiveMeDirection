package com.hopstop.ClientModel.NearbyStations;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="HopStopResponse")
public class HopStopNearbyStationsResponse
  implements Serializable
{

  @Element(name="ResponseStatus")
  private ResponseStatus _responseStatus;

  @ElementList(name="Stations")
  private ArrayList<Station> _stations;

  @Element(name="X")
  private float _x;

  @Element(name="Y")
  private float _y;

  public ResponseStatus getResponseStatus()
  {
    return this._responseStatus;
  }

  public int getStationCount()
  {
    return this._stations.size();
  }

  public ArrayList<Station> getStations()
  {
    return this._stations;
  }

  public float getX()
  {
    return this._x;
  }

  public float getY()
  {
    return this._y;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.NearbyStations.HopStopNearbyStationsResponse
 * JD-Core Version:    0.6.2
 */