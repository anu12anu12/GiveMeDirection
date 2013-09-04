package com.hopstop.ClientModel.Schedules;

import com.hopstop.ClientModel.ResponseStatus;
import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="HopStopResponse", strict=false)
public class SchedulesDetailsStopResponce
  implements Serializable
{

  @Element(name="StartTimeVerb", required=false)
  private String _startTimeVerb;

  @Element(name="Station1Name", required=false)
  private String _station1Name;

  @Element(name="Station2Name", required=false)
  private String _station2Name;

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus responseStatus;

  @ElementList(name="Rows", required=false)
  private ArrayList<Row> rows;

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public ArrayList<Row> getRows()
  {
    return this.rows;
  }

  public String getStartTimeVerb()
  {
    return this._startTimeVerb;
  }

  public String getStation1Name()
  {
    return this._station1Name;
  }

  public String getStation2Name()
  {
    return this._station2Name;
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }

  public void setRows(ArrayList<Row> paramArrayList)
  {
    this.rows = paramArrayList;
  }

  public void setStartTimeVerb(String paramString)
  {
    this._startTimeVerb = paramString;
  }

  public void setStation1Name(String paramString)
  {
    this._station1Name = paramString;
  }

  public void setStation2Name(String paramString)
  {
    this._station2Name = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.SchedulesDetailsStopResponce
 * JD-Core Version:    0.6.2
 */