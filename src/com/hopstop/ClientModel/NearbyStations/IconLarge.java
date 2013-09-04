package com.hopstop.ClientModel.NearbyStations;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class IconLarge
  implements Serializable
{

  @Element(name="URL")
  private String _URL;
  private boolean _has_height;
  private boolean _has_width;

  @Element(name="Height")
  private byte _height;

  @Element(name="Width")
  private byte _width;

  public void deleteHeight()
  {
    this._has_height = false;
  }

  public void deleteWidth()
  {
    this._has_width = false;
  }

  public byte getHeight()
  {
    return this._height;
  }

  public String getURL()
  {
    return this._URL;
  }

  public byte getWidth()
  {
    return this._width;
  }

  public boolean hasHeight()
  {
    return this._has_height;
  }

  public boolean hasWidth()
  {
    return this._has_width;
  }

  public void setHeight(byte paramByte)
  {
    this._height = paramByte;
    this._has_height = true;
  }

  public void setURL(String paramString)
  {
    this._URL = paramString;
  }

  public void setWidth(byte paramByte)
  {
    this._width = paramByte;
    this._has_width = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.NearbyStations.IconLarge
 * JD-Core Version:    0.6.2
 */