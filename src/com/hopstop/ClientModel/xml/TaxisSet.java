package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.HopStopTaxi;
import java.util.ArrayList;

public class TaxisSet
{
  private ArrayList<HopStopTaxi> taxis;

  public TaxisSet()
  {
    ArrayList localArrayList = new ArrayList();
    this.taxis = localArrayList;
  }

  public void add(HopStopTaxi paramHopStopTaxi)
  {
    boolean bool = this.taxis.add(paramHopStopTaxi);
  }

  public int getHopStopTaxiCount()
  {
    if (this.taxis != null);
    for (int i = this.taxis.size(); ; i = 0)
      return i;
  }

  public ArrayList<HopStopTaxi> getHopStopTaxies()
  {
    return this.taxis;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.TaxisSet
 * JD-Core Version:    0.6.2
 */