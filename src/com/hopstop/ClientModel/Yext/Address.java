package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Address
  implements Serializable
{

  @Element(name="address", required=false)
  private String _address;

  @Element(name="address2", required=false)
  private String _address2;

  @Element(name="city", required=false)
  private String _city;

  @Element(name="displayAddress", required=false)
  private String _displayAddress;

  @Element(name="postalCode", required=false)
  private String _postalCode;

  @Element(name="state", required=false)
  private String _state;

  @Element(name="visible", required=false)
  private String _visible;

  public String getAddress()
  {
    return this._address;
  }

  public String getAddress2()
  {
    return this._address2;
  }

  public String getCity()
  {
    return this._city;
  }

  public String getDisplayAddress()
  {
    return this._displayAddress;
  }

  public String getPostalCode()
  {
    return this._postalCode;
  }

  public String getState()
  {
    return this._state;
  }

  public String getVisible()
  {
    return this._visible;
  }

  public void setAddress(String paramString)
  {
    this._address = paramString;
  }

  public void setAddress2(String paramString)
  {
    this._address2 = paramString;
  }

  public void setCity(String paramString)
  {
    this._city = paramString;
  }

  public void setDisplayAddress(String paramString)
  {
    this._displayAddress = paramString;
  }

  public void setPostalCode(String paramString)
  {
    this._postalCode = paramString;
  }

  public void setState(String paramString)
  {
    this._state = paramString;
  }

  public void setVisible(String paramString)
  {
    this._visible = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.Address
 * JD-Core Version:    0.6.2
 */