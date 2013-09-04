package com.hopstop.ClientModel.Schedules;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@DatabaseTable(tableName="schedules_stations")
@Root(name="Station", strict=false)
public class Station
  implements Serializable
{
  public static final String ID_COLUMN_NAME = "id";

  @DatabaseField
  @Element(name="Default", required=false)
  private int default_station;

  @DatabaseField(id=true, index=true, unique=true)
  @Element(name="Id", required=false)
  private String id;

  @DatabaseField
  @Element(name="Name", required=false)
  private String name;

  @DatabaseField
  @Element(name="Radius", required=false)
  private int radius;

  @DatabaseField
  @Element(name="X", required=false)
  private float x;

  @DatabaseField
  @Element(name="Y", required=false)
  private float y;

  public int getDefault()
  {
    return this.default_station;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public float getRadius()
  {
    return this.radius;
  }

  public float getX()
  {
    return this.x;
  }

  public float getY()
  {
    return this.y;
  }

  public void setDefault(int paramInt)
  {
    this.default_station = paramInt;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setRadius(int paramInt)
  {
    this.radius = paramInt;
  }

  public void setX(float paramFloat)
  {
    this.x = paramFloat;
  }

  public void setY(float paramFloat)
  {
    this.y = paramFloat;
  }

  public String toString()
  {
    return this.name;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Station
 * JD-Core Version:    0.6.2
 */