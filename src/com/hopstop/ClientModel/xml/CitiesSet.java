package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.HopStopCity;
import java.util.ArrayList;

public class CitiesSet
{
  private ArrayList<HopStopCity> cities;

  public CitiesSet()
  {
    ArrayList localArrayList = new ArrayList();
    this.cities = localArrayList;
  }

  public void add(HopStopCity paramHopStopCity)
  {
    boolean bool = this.cities.add(paramHopStopCity);
  }

  public ArrayList<HopStopCity> getHopStopCities()
  {
    return this.cities;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.CitiesSet
 * JD-Core Version:    0.6.2
 */