package com.hopstop.ClientModel.NearbyStations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class Station
  implements Serializable
{

  @Element(name="Entrance")
  private Entrance _entrance;

  @Element(name="Exit")
  private Exit _exit;

  @Element(name="Location")
  private String _location;

  @ElementList(name="Vehicles")
  private ArrayList<Vehicle> _vehicleList;

  @Element(name="WalkingDistance")
  private float _walkingDistance;

  @Element(name="WalkingTime")
  private int _walkingTime;

  @Element(name="X")
  private float _x;

  @Element(name="Y")
  private float _y;

  public Entrance getEntrance()
  {
    return this._entrance;
  }

  public Exit getExit()
  {
    return this._exit;
  }

  public String getLocation()
  {
    return this._location;
  }

  public int getVehicleCount()
  {
    return this._vehicleList.size();
  }

  public String getVehicleListString()
  {
    String str1 = "";
    Iterator localIterator = this._vehicleList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        int i = str1.length() + -2;
        return str1.substring(0, i);
      }
      Vehicle localVehicle = (Vehicle)localIterator.next();
      String str2 = String.valueOf(str1);
      StringBuilder localStringBuilder = new StringBuilder(str2);
      String str3 = localVehicle.getName();
      str1 = str3 + ", ";
    }
  }

  public ArrayList<Vehicle> getVehicles()
  {
    return this._vehicleList;
  }

  public float getWalkingDistance()
  {
    return this._walkingDistance;
  }

  public int getWalkingTime()
  {
    return this._walkingTime;
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
 * Qualified Name:     com.hopstop.ClientModel.NearbyStations.Station
 * JD-Core Version:    0.6.2
 */