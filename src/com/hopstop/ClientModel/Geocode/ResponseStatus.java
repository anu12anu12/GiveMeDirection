package com.hopstop.ClientModel.Geocode;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class ResponseStatus
  implements Serializable
{

  @Element(name="FaultString", required=false)
  private String _faultString;

  @Element(name="ResultCode")
  private String _resultCode;

  @Element(name="ResultString", required=false)
  private String _resultString;

  public String getFaultString()
  {
    return this._faultString;
  }

  public String getResultCode()
  {
    return this._resultCode;
  }

  public String getResultString()
  {
    return this._resultString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Geocode.ResponseStatus
 * JD-Core Version:    0.6.2
 */