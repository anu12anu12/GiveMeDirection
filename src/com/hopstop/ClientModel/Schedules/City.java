package com.hopstop.ClientModel.Schedules;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@DatabaseTable(tableName="schedules_cities")
@Root(strict=false)
public class City
  implements Serializable
{
  public static final String ID_COLUMN_NAME = "id";

  @DatabaseField
  @Element(name="CenterLat", required=false)
  private float centerLat;

  @DatabaseField
  @Element(name="CenterLon", required=false)
  private float centerLon;

  @DatabaseField
  @Element(name="Country", required=false)
  private String country;

  @DatabaseField(id=true, index=true, unique=true)
  @Element(name="Id")
  private String id;

  @DatabaseField
  @Element(name="Name")
  private String name;

  @Element(name="NumericId", required=false)
  private int numericId;

  @DatabaseField
  @Element(name="State", required=false)
  private String state;

  @DatabaseField
  @Element(name="TimeZone", required=false)
  private String timeZone;

  public float getCenterLat()
  {
    return this.centerLat;
  }

  public float getCenterLon()
  {
    return this.centerLon;
  }

  public String getCountry()
  {
    return this.country;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public int getNumericId()
  {
    return this.numericId;
  }

  public String getState()
  {
    return this.state;
  }

  public String getTimeZone()
  {
    return this.timeZone;
  }

  public void setCenterLat(float paramFloat)
  {
    this.centerLat = paramFloat;
  }

  public void setCenterLon(float paramFloat)
  {
    this.centerLon = paramFloat;
  }

  public void setCountry(String paramString)
  {
    this.country = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setNumericId(int paramInt)
  {
    this.numericId = paramInt;
  }

  public void setState(String paramString)
  {
    this.state = paramString;
  }

  public void setTimeZone(String paramString)
  {
    this.timeZone = paramString;
  }

  public String toString()
  {
    return this.name;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.City
 * JD-Core Version:    0.6.2
 */