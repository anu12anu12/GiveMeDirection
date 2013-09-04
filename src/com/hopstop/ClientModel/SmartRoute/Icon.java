package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class Icon
  implements Serializable
{

  @Element(name="URL")
  private String _URL;

  @Element(name="Height")
  private byte _height;

  @Element(name="Width")
  private byte _width;

  public byte getHeight()
  {
    return this._height;
  }

  public String getURL()
  {
    return this._URL.replace("/i2/", "/i/");
  }

  public byte getWidth()
  {
    return this._width;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.Icon
 * JD-Core Version:    0.6.2
 */