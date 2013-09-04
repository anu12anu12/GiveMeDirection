package com.hopstop.ClientModel.SmartRoute;

import com.hopstop.ClientModel.ResponseStatus;
import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="HopStopResponse")
public class HopStopSmartRouteResponse
  implements Serializable
{

  @ElementList(name="ExtraRoutes", required=false)
  private ArrayList<ExtraRoute> _extraRoutes;

  @Element(name="ExtraRoutesIdPrefix", required=false)
  private String _extraRoutesIdPrefix;

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus _responseStatus;

  public ArrayList<ExtraRoute> getExtraRoutes()
  {
    return this._extraRoutes;
  }

  public String getExtraRoutesIdPrefix()
  {
    return this._extraRoutesIdPrefix;
  }

  public ResponseStatus getResponseStatus()
  {
    return this._responseStatus;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.HopStopSmartRouteResponse
 * JD-Core Version:    0.6.2
 */