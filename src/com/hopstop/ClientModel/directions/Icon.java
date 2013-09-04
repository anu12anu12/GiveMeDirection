package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Icon
  implements Serializable, Cloneable
{

  @Element(name="Height", required=false)
  private int _height;

  @Element(name="URL", required=false)
  private String _url;

  @Element(name="Width", required=false)
  private int _width;

  public int getHeight()
  {
    return this._height;
  }

  public String getURL()
  {
    return this._url;
  }

  public int getWidth()
  {
    return this._width;
  }

  public void setHeight(int paramInt)
  {
    this._height = paramInt;
  }

  public void setURL(String paramString)
  {
    this._url = paramString;
  }

  public void setWidth(int paramInt)
  {
    this._width = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.Icon
 * JD-Core Version:    0.6.2
 */