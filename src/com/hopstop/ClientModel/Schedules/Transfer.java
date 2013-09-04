package com.hopstop.ClientModel.Schedules;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Transfer", strict=false)
public class Transfer
  implements Serializable
{

  @Element(name="DepartTimeVerb", required=false)
  private String departTimeVerb;

  @Element(name="Station", required=false)
  private Station station;

  public String getDepartTimeVerb()
  {
    return this.departTimeVerb;
  }

  public Station getStation()
  {
    return this.station;
  }

  public void setDepartTimeVerb(String paramString)
  {
    this.departTimeVerb = paramString;
  }

  public void setStation(Station paramStation)
  {
    this.station = paramStation;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Transfer
 * JD-Core Version:    0.6.2
 */