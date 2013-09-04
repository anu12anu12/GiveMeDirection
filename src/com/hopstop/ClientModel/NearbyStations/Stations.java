package com.hopstop.ClientModel.NearbyStations;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

public class Stations
  implements Serializable
{
  private Vector<Station> _stationList;

  public Stations()
  {
    Vector localVector = new Vector();
    this._stationList = localVector;
  }

  public void addStation(int paramInt, Station paramStation)
    throws IndexOutOfBoundsException
  {
    this._stationList.add(paramInt, paramStation);
  }

  public void addStation(Station paramStation)
    throws IndexOutOfBoundsException
  {
    this._stationList.addElement(paramStation);
  }

  public Enumeration<? extends Station> enumerateStation()
  {
    return this._stationList.elements();
  }

  public Station getStation(int paramInt)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this._stationList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("getStation: Index value '").append(paramInt).append("' not in range [0..");
      int j = this._stationList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    return (Station)this._stationList.get(paramInt);
  }

  public Station[] getStation()
  {
    Station[] arrayOfStation = new Station[0];
    return (Station[])this._stationList.toArray(arrayOfStation);
  }

  public int getStationCount()
  {
    return this._stationList.size();
  }

  public void removeAllStation()
  {
    this._stationList.clear();
  }

  public boolean removeStation(Station paramStation)
  {
    return this._stationList.remove(paramStation);
  }

  public Station removeStationAt(int paramInt)
  {
    return (Station)this._stationList.remove(paramInt);
  }

  public void setStation(int paramInt, Station paramStation)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this._stationList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("setStation: Index value '").append(paramInt).append("' not in range [0..");
      int j = this._stationList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    Object localObject = this._stationList.set(paramInt, paramStation);
  }

  public void setStation(Station[] paramArrayOfStation)
  {
    this._stationList.clear();
    int i = 0;
    while (true)
    {
      int j = paramArrayOfStation.length;
      if (i >= j)
        return;
      Vector localVector = this._stationList;
      Station localStation = paramArrayOfStation[i];
      boolean bool = localVector.add(localStation);
      i += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.NearbyStations.Stations
 * JD-Core Version:    0.6.2
 */