package com.hopstop.ClientModel.Schedules;

import com.hopstop.ClientModel.ResponseStatus;
import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="HopStopResponse", strict=false)
public class SchedulesSearchResponse
  implements Serializable
{

  @Element(name="ArriveBy", required=false)
  private int arriveBy;

  @Element(name="Disclaimer", required=false)
  private String disclaimer;

  @Element(name="Icon", required=false)
  private Icon icon;

  @Element(name="Id", required=false)
  private String id;

  @Element(name="MaxPages", required=false)
  private int maxPages;

  @Element(name="MaxTransfers", required=false)
  private int maxTransfers;

  @Element(name="Page", required=false)
  private int page;

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus responseStatus;

  @ElementList(name="Rows", required=false)
  private ArrayList<Row> rows;

  @Element(name="RowsPerPage", required=false)
  private int rowsPerPage;

  @Element(name="StartTime", required=false)
  private int startTime;

  @Element(name="StartTimeVerb", required=false)
  private String startTimeVerb;

  @Element(name="Station1Id", required=false)
  private String station1Id;

  @Element(name="Station1Name", required=false)
  private String station1Name;

  @Element(name="Station1X", required=false)
  private float station1X;

  @Element(name="Station1Y", required=false)
  private float station1Y;

  @Element(name="Station2Id", required=false)
  private String station2Id;

  @Element(name="Station2Name", required=false)
  private String station2Name;

  @Element(name="Station2X", required=false)
  private float station2X;

  @Element(name="Station2Y", required=false)
  private float station2Y;

  @Element(name="StationGroupId", required=false)
  private String stationGroupId;

  @Element(name="StationGroupName", required=false)
  private String stationGroupName;

  public int getArriveBy()
  {
    return this.arriveBy;
  }

  public String getDisclaimer()
  {
    return this.disclaimer;
  }

  public Icon getIcon()
  {
    return this.icon;
  }

  public String getId()
  {
    return this.id;
  }

  public int getMaxPages()
  {
    return this.maxPages;
  }

  public int getMaxTransfers()
  {
    return this.maxTransfers;
  }

  public int getPage()
  {
    return this.page;
  }

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public ArrayList<Row> getRows()
  {
    return this.rows;
  }

  public int getRowsPerPage()
  {
    return this.rowsPerPage;
  }

  public int getStartTime()
  {
    return this.startTime;
  }

  public String getStartTimeVerb()
  {
    return this.startTimeVerb;
  }

  public String getStation1Id()
  {
    return this.station1Id;
  }

  public String getStation1Name()
  {
    return this.station1Name;
  }

  public float getStation1X()
  {
    return this.station1X;
  }

  public float getStation1Y()
  {
    return this.station1Y;
  }

  public String getStation2Id()
  {
    return this.station2Id;
  }

  public String getStation2Name()
  {
    return this.station2Name;
  }

  public float getStation2X()
  {
    return this.station2X;
  }

  public float getStation2Y()
  {
    return this.station2Y;
  }

  public String getStationGroupId()
  {
    return this.stationGroupId;
  }

  public String getStationGroupName()
  {
    return this.stationGroupName;
  }

  public void setArriveBy(int paramInt)
  {
    this.arriveBy = paramInt;
  }

  public void setDisclaimer(String paramString)
  {
    this.disclaimer = paramString;
  }

  public void setIcon(Icon paramIcon)
  {
    this.icon = paramIcon;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setMaxPages(int paramInt)
  {
    this.maxPages = paramInt;
  }

  public void setMaxTransfers(int paramInt)
  {
    this.maxTransfers = paramInt;
  }

  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }

  public void setRows(ArrayList<Row> paramArrayList)
  {
    this.rows = paramArrayList;
  }

  public void setRowsPerPage(int paramInt)
  {
    this.rowsPerPage = paramInt;
  }

  public void setStartTimeVerb(String paramString)
  {
    this.startTimeVerb = paramString;
  }

  public void setStation1Id(String paramString)
  {
    this.station1Id = paramString;
  }

  public void setStation1Name(String paramString)
  {
    this.station1Name = paramString;
  }

  public void setStation1X(float paramFloat)
  {
    this.station1X = paramFloat;
  }

  public void setStation1Y(float paramFloat)
  {
    this.station1Y = paramFloat;
  }

  public void setStation2Id(String paramString)
  {
    this.station2Id = paramString;
  }

  public void setStation2Name(String paramString)
  {
    this.station2Name = paramString;
  }

  public void setStation2X(float paramFloat)
  {
    this.station2X = paramFloat;
  }

  public void setStation2Y(float paramFloat)
  {
    this.station2Y = paramFloat;
  }

  public void setStationGroupId(String paramString)
  {
    this.stationGroupId = paramString;
  }

  public void setStationGroupName(String paramString)
  {
    this.stationGroupName = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.SchedulesSearchResponse
 * JD-Core Version:    0.6.2
 */