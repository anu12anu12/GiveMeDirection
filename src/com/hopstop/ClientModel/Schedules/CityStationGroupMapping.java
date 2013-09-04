package com.hopstop.ClientModel.Schedules;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="schedules_city_stationgroup_mapping")
public class CityStationGroupMapping
{
  public static final String CITY_ID_COLUMN_NAME = "cityId";

  @DatabaseField(index=true, uniqueCombo=true)
  private String cityId;

  @DatabaseField(generatedId=true)
  private int id;

  @DatabaseField(uniqueCombo=true)
  private String stationGroupId;

  public CityStationGroupMapping()
  {
  }

  public CityStationGroupMapping(String paramString1, String paramString2)
  {
    this.cityId = paramString1;
    this.stationGroupId = paramString2;
  }

  public String getCityId()
  {
    return this.cityId;
  }

  public String getStationGroupId()
  {
    return this.stationGroupId;
  }

  public void setCityId(String paramString)
  {
    this.cityId = paramString;
  }

  public void setStationGroupId(String paramString)
  {
    this.stationGroupId = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.CityStationGroupMapping
 * JD-Core Version:    0.6.2
 */