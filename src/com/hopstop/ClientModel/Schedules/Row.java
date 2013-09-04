package com.hopstop.ClientModel.Schedules;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Row
  implements Serializable
{

  @Element(name="ArriveTimeVerb")
  private String arriveTimeVerb;

  @Element(name="DepartTimeVerb")
  private String departTimeVerb;

  @Element(name="Id")
  private int id;

  @Element(name="NextAvailable", required=false)
  private int nextAvailable;

  @ElementList(name="Routes", required=false)
  private ArrayList<Route> routes;

  @Element(name="TotalTime", required=false)
  private int totalTime;

  @Element(name="TotalTimeVerb", required=false)
  private String totalTimeVerb;

  @ElementList(name="Transfers", required=false)
  private ArrayList<Transfer> transfers;

  @ElementList(name="TransitMaps", required=false)
  private ArrayList<Map> transitMaps;

  @Element(name="Vehicle", required=false)
  private Vehicle vehicle;

  public String getArriveTimeVerb()
  {
    return this.arriveTimeVerb;
  }

  public String getDepartTimeVerb()
  {
    return this.departTimeVerb;
  }

  public int getId()
  {
    return this.id;
  }

  public int getNextAvailable()
  {
    return this.nextAvailable;
  }

  public ArrayList<Route> getRoutes()
  {
    return this.routes;
  }

  public int getTotalTime()
  {
    return this.totalTime;
  }

  public String getTotalTimeVerb()
  {
    return this.totalTimeVerb;
  }

  public ArrayList<Transfer> getTransfers()
  {
    return this.transfers;
  }

  public ArrayList<Map> getTransitMaps()
  {
    return this.transitMaps;
  }

  public Vehicle getVehicle()
  {
    return this.vehicle;
  }

  public void setArriveTimeVerb(String paramString)
  {
    this.arriveTimeVerb = paramString;
  }

  public void setDepartTimeVerb(String paramString)
  {
    this.departTimeVerb = paramString;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }

  public void setNextAvailable(int paramInt)
  {
    this.nextAvailable = paramInt;
  }

  public void setRoutes(ArrayList<Route> paramArrayList)
  {
    this.routes = paramArrayList;
  }

  public void setTotalTime(int paramInt)
  {
    this.totalTime = paramInt;
  }

  public void setTotalTimeVerb(String paramString)
  {
    this.totalTimeVerb = paramString;
  }

  public void setTransfers(ArrayList<Transfer> paramArrayList)
  {
    this.transfers = paramArrayList;
  }

  public void setTransitMaps(ArrayList<Map> paramArrayList)
  {
    this.transitMaps = paramArrayList;
  }

  public void setVehicle(Vehicle paramVehicle)
  {
    this.vehicle = paramVehicle;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Row
 * JD-Core Version:    0.6.2
 */