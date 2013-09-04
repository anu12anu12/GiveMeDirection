package com.hopstop.ClientModel.xml;

import android.view.View;
import com.hopstop.ClientModel.HopStopMap;
import java.util.ArrayList;

public class MapsSet
{
  private boolean isUpdating;
  private ArrayList<View> mapView;
  private ArrayList<HopStopMap> maps;
  private ArrayList<MapInfoHolder> mapsView;

  public MapsSet()
  {
    ArrayList localArrayList1 = new ArrayList();
    this.maps = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.mapsView = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    this.mapView = localArrayList3;
  }

  public void add(View paramView)
  {
    boolean bool = this.mapView.add(paramView);
  }

  public void add(HopStopMap paramHopStopMap)
  {
    boolean bool = this.maps.add(paramHopStopMap);
  }

  public void add(MapInfoHolder paramMapInfoHolder)
  {
    boolean bool = this.mapsView.add(paramMapInfoHolder);
  }

  public ArrayList<HopStopMap> getHopStopMaps()
  {
    return this.maps;
  }

  public ArrayList<View> getMaps()
  {
    return this.mapView;
  }

  public ArrayList<MapInfoHolder> getViewMaps()
  {
    return this.mapsView;
  }

  public boolean isUpdating()
  {
    return this.isUpdating;
  }

  public void setUpdating(boolean paramBoolean)
  {
    this.isUpdating = paramBoolean;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.MapsSet
 * JD-Core Version:    0.6.2
 */