package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="geoData", strict=false)
public class GeoData
  implements Serializable
{

  @Element(name="displayLatitude")
  private String _displayLatitude;

  @Element(name="displayLongitude")
  private String _displayLongitude;
  private boolean _has_displayLatitude;
  private boolean _has_displayLongitude;

  public String getDisplayLatitude()
  {
    return this._displayLatitude;
  }

  public String getDisplayLongitude()
  {
    return this._displayLongitude;
  }

  public boolean hasDisplayLatitude()
  {
    return this._has_displayLatitude;
  }

  public boolean hasDisplayLongitude()
  {
    return this._has_displayLongitude;
  }

  public void setDisplayLatitude(String paramString)
  {
    this._displayLatitude = paramString;
    this._has_displayLatitude = true;
  }

  public void setDisplayLongitude(String paramString)
  {
    this._displayLongitude = paramString;
    this._has_displayLongitude = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.GeoData
 * JD-Core Version:    0.6.2
 */