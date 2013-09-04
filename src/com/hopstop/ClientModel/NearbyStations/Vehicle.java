package com.hopstop.ClientModel.NearbyStations;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class Vehicle
  implements Serializable
{

  @Element(name="Icon")
  private Icon _icon;

  @Element(name="IconLarge")
  private IconLarge _iconLarge;

  @Element(name="Id")
  private long _id;

  @Element(name="Name")
  private String _name;

  @Element(name="Type")
  private String _type;

  public Icon getIcon()
  {
    return this._icon;
  }

  public IconLarge getIconLarge()
  {
    return this._iconLarge;
  }

  public long getId()
  {
    return this._id;
  }

  public String getName()
  {
    return this._name;
  }

  public String getType()
  {
    return this._type;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.NearbyStations.Vehicle
 * JD-Core Version:    0.6.2
 */