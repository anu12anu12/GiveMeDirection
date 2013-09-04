package com.hopstop.ClientModel.Schedules;

import com.hopstop.ClientModel.Schedules.stops.Stop;
import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Route
  implements Serializable
{

  @Element(name="EndStopIdx", required=false)
  private int endStopIdx;

  @Element(name="Id")
  private int id;

  @Element(name="StartStopIdx", required=false)
  private int startStopIdx;

  @ElementList(name="Stops", required=false)
  private ArrayList<Stop> stops;

  @Element(name="TotalTime", required=false)
  private String totalTime;

  @Element(name="Vehicle", required=false)
  private Vehicle vehicle;

  public int getEndStopIdx()
  {
    return this.endStopIdx;
  }

  public int getId()
  {
    return this.id;
  }

  public int getStartStopIdx()
  {
    return this.startStopIdx;
  }

  public ArrayList<Stop> getStops()
  {
    return this.stops;
  }

  public String getTotalTime()
  {
    return this.totalTime;
  }

  public Vehicle getVehicle()
  {
    return this.vehicle;
  }

  public void setStops(ArrayList<Stop> paramArrayList)
  {
    this.stops = paramArrayList;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Route
 * JD-Core Version:    0.6.2
 */