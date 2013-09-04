package com.hopstop.ClientModel;

import com.hopstop.ClientModel.Schedules.Group;
import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(reference="http://www.hopstop.com/ws/")
@Root(name="HopStopResponse")
public class HopStopResponse
  implements Serializable
{

  @ElementList(name="Groups", required=false)
  private ArrayList<Group> _groupList;

  @Element(name="ResponseStatus")
  private ResponseStatus _responseStatus;

  public ArrayList<Group> getGroupList()
  {
    return this._groupList;
  }

  public ResponseStatus getResponseStatus()
  {
    return this._responseStatus;
  }

  public void setGroupList(ArrayList<Group> paramArrayList)
  {
    this._groupList = paramArrayList;
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this._responseStatus = paramResponseStatus;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.HopStopResponse
 * JD-Core Version:    0.6.2
 */