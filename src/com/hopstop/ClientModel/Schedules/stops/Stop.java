package com.hopstop.ClientModel.Schedules.stops;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Stop
  implements Serializable
{

  @Element(name="ArriveTimeVerb", required=false)
  private String _arriveTimeVerb;

  @Element(name="DepartTimeVerb", required=false)
  private String _departTimeVerb;

  @Element(name="Name")
  private String _name;

  @Element(name="StationId")
  private String _stationId;

  @Element(name="X")
  private String _x;

  @Element(name="Y")
  private String _y;

  public Stop()
  {
  }

  public Stop(Stop paramStop)
  {
    String str1 = paramStop.getName();
    this._name = str1;
    String str2 = paramStop.getDepartTimeVerb();
    this._departTimeVerb = str2;
    String str3 = paramStop.getArriveTimeVerb();
    this._arriveTimeVerb = str3;
    String str4 = paramStop.getStationId();
    this._stationId = str4;
    String str5 = paramStop.getX();
    this._x = str5;
    String str6 = paramStop.getY();
    this._y = str6;
  }

  public String getArriveTimeVerb()
  {
    return this._arriveTimeVerb;
  }

  public String getDepartTimeVerb()
  {
    return this._departTimeVerb;
  }

  public String getName()
  {
    return this._name;
  }

  public String getStationId()
  {
    return this._stationId;
  }

  public String getX()
  {
    return this._x;
  }

  public String getY()
  {
    return this._y;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.stops.Stop
 * JD-Core Version:    0.6.2
 */