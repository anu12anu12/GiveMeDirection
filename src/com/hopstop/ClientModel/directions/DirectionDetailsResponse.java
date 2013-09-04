package com.hopstop.ClientModel.directions;

import com.hopstop.ClientModel.Address;
import com.hopstop.ClientModel.DirectionResponse;
import com.hopstop.ClientModel.ResponseStatus;
import com.hopstop.ClientModel.SmartRoute.ExtraRoute;
import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Complete;
import org.simpleframework.xml.core.Persist;
import org.simpleframework.xml.core.Validate;

@Root(name="HopStopResponse", strict=false)
public class DirectionDetailsResponse
  implements Serializable
{
  private DirectionResponse _dResponse;

  @ElementList(name="ExtraRoutes", required=false)
  private ArrayList<ExtraRoute> _extraRoutes;

  @Element(name="ExtraRoutesIdPrefix", required=false)
  private String _extraRoutesIdPrefix;

  @Element(name="ExtraRoutesResumeData", required=false)
  private String _extraRoutesResumeData;

  @Element(name="Id", required=false)
  private String _id;

  @ElementList(name="Thumbnails", required=false)
  private ArrayList<Address> _multiAddresses;
  private ArrayList<Address> first;

  @ElementList(name="Maps", required=false)
  private ArrayList<ViewStepMap> maps;

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus responseStatus;

  @Element(name="RouteInfo", required=false)
  private RouteInfo routeInfo;
  private ArrayList<Address> second;

  public DirectionDetailsResponse()
  {
    ArrayList localArrayList1 = new ArrayList();
    this.first = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.second = localArrayList2;
    DirectionResponse localDirectionResponse = new DirectionResponse(null);
    this._dResponse = localDirectionResponse;
  }

  public DirectionResponse getDirectionResponse()
  {
    return this._dResponse;
  }

  public ArrayList<ExtraRoute> getExtraRoutes()
  {
    return this._extraRoutes;
  }

  public String getExtraRoutesIdPrefix()
  {
    return this._extraRoutesIdPrefix;
  }

  public String getExtraRoutesResumeData()
  {
    return this._extraRoutesResumeData;
  }

  public ArrayList<Address> getFirstExtraAddresses()
  {
    return this.first;
  }

  public ArrayList<Address> getMultiAddresses()
  {
    return this._multiAddresses;
  }

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public RouteInfo getRouteInfo()
  {
    return this.routeInfo;
  }

  public ArrayList<Address> getSecondExtraAddresses()
  {
    return this.second;
  }

  @Persist
  public void prepare()
  {
  }

  @Complete
  public void release()
  {
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }

  public void setRouteInfo(RouteInfo paramRouteInfo)
  {
    this.routeInfo = paramRouteInfo;
  }

  public void setSteps(ArrayList<Address> paramArrayList)
  {
    this._multiAddresses = paramArrayList;
  }

  @Validate
  public void validate()
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.DirectionDetailsResponse
 * JD-Core Version:    0.6.2
 */