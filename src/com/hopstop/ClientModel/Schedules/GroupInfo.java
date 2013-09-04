package com.hopstop.ClientModel.Schedules;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root
public class GroupInfo
  implements Serializable
{

  @Element(name="Category", required=false)
  @Path("GroupInfo")
  private String category;

  @Element(name="Icon", required=false)
  @Path("GroupInfo")
  private Icon icon;

  @Element(name="IconLarge", required=false)
  @Path("GroupInfo")
  private IconLarge iconLarge;

  @Element(name="Id", required=false)
  @Path("GroupInfo")
  private String id;

  @Element(name="Name", required=false)
  @Path("GroupInfo")
  private String name;

  @ElementList(name="Stations", required=false)
  @Path("GroupInfo")
  private ArrayList<Station> stations;

  @Element(name="VehicleTypes", required=false)
  @Path("GroupInfo")
  private String vehicleTypes;

  public String getCategory()
  {
    return this.category;
  }

  public Icon getIcon()
  {
    return this.icon;
  }

  public IconLarge getIconLarge()
  {
    return this.iconLarge;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public ArrayList<Station> getStations()
  {
    return this.stations;
  }

  public String getVehicleTypes()
  {
    return this.vehicleTypes;
  }

  public void setCategory(String paramString)
  {
    this.category = paramString;
  }

  public void setIcon(Icon paramIcon)
  {
    this.icon = paramIcon;
  }

  public void setIconLarge(IconLarge paramIconLarge)
  {
    this.iconLarge = paramIconLarge;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setStations(ArrayList<Station> paramArrayList)
  {
    this.stations = paramArrayList;
  }

  public void setVehicleTypes(String paramString)
  {
    this.vehicleTypes = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.GroupInfo
 * JD-Core Version:    0.6.2
 */