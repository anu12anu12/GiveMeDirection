package com.hopstop.ClientModel.Geocode;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="item")
public class Item
  implements Serializable
{

  @Element(name="Address", required=false)
  private String _address;

  @Element(name="City", required=false)
  private String _city;

  @Element(name="CityName", required=false)
  private String _cityName;

  @Element(name="Country", required=false)
  private String _country;

  @Element(name="County", required=false)
  private String _county;

  @Element(name="CountyName", required=false)
  private String _countyName;

  @Element(name="Title", required=false)
  private String _title;

  @Element(name="X", required=false)
  private String _x;

  @Element(name="Y", required=false)
  private String _y;

  @Element(name="Zip", required=false)
  private String _zip;

  public String getAddress()
  {
    return this._address;
  }

  public String getCity()
  {
    return this._city;
  }

  public String getCityName()
  {
    return this._cityName;
  }

  public String getCountry()
  {
    return this._country;
  }

  public String getCounty()
  {
    return this._county;
  }

  public String getCountyName()
  {
    return this._countyName;
  }

  public String getTitle()
  {
    return this._title;
  }

  public String getX()
  {
    return this._x;
  }

  public String getY()
  {
    return this._y;
  }

  public String getZip()
  {
    return this._zip;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Geocode.Item
 * JD-Core Version:    0.6.2
 */