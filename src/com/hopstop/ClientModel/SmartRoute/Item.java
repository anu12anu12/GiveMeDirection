package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;

public class Item
  implements Serializable
{
  private String _URL;
  private boolean _has_height;
  private boolean _has_number;
  private boolean _has_width;
  private short _height;
  private String _id;
  private byte _number;
  private String _title;
  private short _width;

  public void deleteHeight()
  {
    this._has_height = false;
  }

  public void deleteNumber()
  {
    this._has_number = false;
  }

  public void deleteWidth()
  {
    this._has_width = false;
  }

  public short getHeight()
  {
    return this._height;
  }

  public String getId()
  {
    return this._id;
  }

  public byte getNumber()
  {
    return this._number;
  }

  public String getTitle()
  {
    return this._title;
  }

  public String getURL()
  {
    return this._URL;
  }

  public short getWidth()
  {
    return this._width;
  }

  public boolean hasHeight()
  {
    return this._has_height;
  }

  public boolean hasNumber()
  {
    return this._has_number;
  }

  public boolean hasWidth()
  {
    return this._has_width;
  }

  public void setHeight(short paramShort)
  {
    this._height = paramShort;
    this._has_height = true;
  }

  public void setId(String paramString)
  {
    this._id = paramString;
  }

  public void setNumber(byte paramByte)
  {
    this._number = paramByte;
    this._has_number = true;
  }

  public void setTitle(String paramString)
  {
    this._title = paramString;
  }

  public void setURL(String paramString)
  {
    this._URL = paramString;
  }

  public void setWidth(short paramShort)
  {
    this._width = paramShort;
    this._has_width = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.Item
 * JD-Core Version:    0.6.2
 */