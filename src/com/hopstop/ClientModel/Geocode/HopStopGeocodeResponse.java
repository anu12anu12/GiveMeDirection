package com.hopstop.ClientModel.Geocode;

import java.io.Serializable;
import java.util.Vector;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="HopStopResponse", strict=false)
public class HopStopGeocodeResponse
  implements Serializable
{

  @ElementList(name="Points", required=false)
  private Vector<Item> _points;

  @Element(name="ResponseStatus")
  private ResponseStatus _responseStatus;

  public int getItemCount()
  {
    return this._points.size();
  }

  public Vector<Item> getPoints()
  {
    return this._points;
  }

  public ResponseStatus getResponseStatus()
  {
    return this._responseStatus;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Geocode.HopStopGeocodeResponse
 * JD-Core Version:    0.6.2
 */