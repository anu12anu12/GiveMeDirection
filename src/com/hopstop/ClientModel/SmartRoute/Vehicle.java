package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class Vehicle
  implements Serializable
{

  @Element(name="Fare", required=false)
  private Fare _fare;

  @Element(name="Icon", required=false)
  private Icon _icon;

  @Element(name="Id", required=false)
  private int _id;

  @Element(name="Name", required=false)
  private String _name;

  @Element(name="Title", required=false)
  private String _title;

  public Fare getFare()
  {
    return this._fare;
  }

  public Icon getIcon()
  {
    return this._icon;
  }

  public int getId()
  {
    return this._id;
  }

  public String getName()
  {
    return this._name;
  }

  public String getTitle()
  {
    return this._title;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.Vehicle
 * JD-Core Version:    0.6.2
 */