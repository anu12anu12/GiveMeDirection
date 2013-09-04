package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Validate;

@Root(strict=false)
public class Vehicle
  implements Serializable, Cloneable
{

  @Element(name="Fare", required=false)
  private Fare _fare;

  @Element(name="Icon", required=false)
  private Icon _icon;

  @Element(name="Id")
  private String _id;

  @ElementList(name="TransitMaps", required=false)
  private ArrayList<Map> _maps;

  @Element(name="Name", required=false)
  private String _name;

  public Fare getFare()
  {
    return this._fare;
  }

  public Icon getIcon()
  {
    return this._icon;
  }

  public String getId()
  {
    return this._id;
  }

  public ArrayList<Map> getMaps()
  {
    return this._maps;
  }

  public String getName()
  {
    return this._name;
  }

  public void setFare(Fare paramFare)
  {
    this._fare = paramFare;
  }

  public void setIcon(Icon paramIcon)
  {
    this._icon = paramIcon;
  }

  public void setId(String paramString)
  {
    this._id = paramString;
  }

  public void setName(String paramString)
  {
    this._name = paramString;
  }

  public void setTransitMaps(ArrayList<Map> paramArrayList)
  {
    this._maps = paramArrayList;
  }

  @Validate
  public void validate()
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.Vehicle
 * JD-Core Version:    0.6.2
 */