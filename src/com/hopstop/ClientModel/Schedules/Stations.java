package com.hopstop.ClientModel.Schedules;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Stations
  implements Serializable
{

  @ElementList(name="Stations", required=false)
  private ArrayList<Station> stationList;

  public Stations()
  {
    ArrayList localArrayList = new ArrayList();
    this.stationList = localArrayList;
  }

  public Stations(ArrayList<Station> paramArrayList)
  {
    this.stationList = paramArrayList;
  }

  public void addStation(int paramInt, Station paramStation)
    throws IndexOutOfBoundsException
  {
    this.stationList.add(paramInt, paramStation);
  }

  public void addStation(Station paramStation)
    throws IndexOutOfBoundsException
  {
    boolean bool = this.stationList.add(paramStation);
  }

  public Stations clone()
  {
    Stations localStations = new Stations();
    ArrayList localArrayList1 = new ArrayList();
    localStations.stationList = localArrayList1;
    ArrayList localArrayList2 = (ArrayList)this.stationList.clone();
    localStations.stationList = localArrayList2;
    return localStations;
  }

  public int getSize()
  {
    if (this.stationList == null);
    for (int i = 0; ; i = this.stationList.size())
      return i;
  }

  public Station getStation(int paramInt)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this.stationList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("getStation: Index value '").append(paramInt).append("' not in range [0..");
      int j = this.stationList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    return (Station)this.stationList.get(paramInt);
  }

  public Station[] getStation()
  {
    Station[] arrayOfStation = new Station[0];
    return (Station[])this.stationList.toArray(arrayOfStation);
  }

  public int getStationCount()
  {
    return this.stationList.size();
  }

  public ArrayList<Station> getStations()
  {
    return this.stationList;
  }

  public void removeAllStation()
  {
    this.stationList.clear();
  }

  public boolean removeStation(Station paramStation)
  {
    return this.stationList.remove(paramStation);
  }

  public Station removeStationAt(int paramInt)
  {
    return (Station)this.stationList.remove(paramInt);
  }

  public void setStation(int paramInt, Station paramStation)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this.stationList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("setStation: Index value '").append(paramInt).append("' not in range [0..");
      int j = this.stationList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    Object localObject = this.stationList.set(paramInt, paramStation);
  }

  public void setStation(Station[] paramArrayOfStation)
  {
    this.stationList.clear();
    int i = 0;
    while (true)
    {
      int j = paramArrayOfStation.length;
      if (i >= j)
        return;
      ArrayList localArrayList = this.stationList;
      Station localStation = paramArrayOfStation[i];
      boolean bool = localArrayList.add(localStation);
      i += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Stations
 * JD-Core Version:    0.6.2
 */