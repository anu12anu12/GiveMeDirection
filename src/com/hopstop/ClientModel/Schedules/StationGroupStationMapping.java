package com.hopstop.ClientModel.Schedules;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="schedules_stationgroup_station_mapping")
public class StationGroupStationMapping
{
  public static final String STATIONGROUP_COLUMN_NAME = "stationGroupId";

  @DatabaseField(generatedId=true)
  private int id;

  @DatabaseField(index=true, uniqueCombo=true)
  private String stationGroupId;

  @DatabaseField(uniqueCombo=true)
  private String stationId;

  public StationGroupStationMapping()
  {
  }

  public StationGroupStationMapping(String paramString1, String paramString2)
  {
    this.stationGroupId = paramString1;
    this.stationId = paramString2;
  }

  public String getStationGroupId()
  {
    return this.stationGroupId;
  }

  public String getStationId()
  {
    return this.stationId;
  }

  public void setStationGroupId(String paramString)
  {
    this.stationGroupId = paramString;
  }

  public void setStationId(String paramString)
  {
    this.stationId = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.StationGroupStationMapping
 * JD-Core Version:    0.6.2
 */