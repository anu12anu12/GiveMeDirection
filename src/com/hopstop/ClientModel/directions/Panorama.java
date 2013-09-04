package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Panorama
  implements Serializable, Cloneable
{

  @Element(name="Angle", required=false)
  private String _angle;

  @Element(name="URL", required=false)
  private String _url;

  public String getAngle()
  {
    return this._angle;
  }

  public String getURL()
  {
    return this._url;
  }

  public void setAngle(String paramString)
  {
    this._angle = paramString;
  }

  public void setURL(String paramString)
  {
    this._url = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.Panorama
 * JD-Core Version:    0.6.2
 */