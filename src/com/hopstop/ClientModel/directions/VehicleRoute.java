package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Validate;

@Root(strict=false)
public class VehicleRoute
  implements Serializable, Cloneable
{

  @ElementList(name="Classes", required=false)
  private ArrayList<Diversion> _diversions;

  @Element(name="PartId", required=false)
  private String _partId;

  @Element(name="StationId", required=false)
  private String _stationId;

  @Element(name="StopId", required=false)
  private String _stopId;

  public ArrayList<Diversion> getDiversion()
  {
    return this._diversions;
  }

  public String getStationId()
  {
    return this._stationId;
  }

  public String getStopId()
  {
    return this._stopId;
  }

  public void setDiversions(ArrayList<Diversion> paramArrayList)
  {
    this._diversions = paramArrayList;
  }

  public void setStationId(String paramString)
  {
    this._stationId = paramString;
  }

  public void setStopId(String paramString)
  {
    this._stopId = paramString;
  }

  @Validate
  public void validate()
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.VehicleRoute
 * JD-Core Version:    0.6.2
 */