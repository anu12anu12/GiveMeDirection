package com.hopstop.ClientModel;

import java.io.Serializable;

public class HopStopTaxi
  implements Serializable
{
  private static final long serialVersionUID = 9219309118986220869L;
  private String description;
  private float distance;
  private int drivingTime;
  private int drivingTimeInMins;
  private String id;
  private String name;
  private String notes;
  private String phone;
  private float price;

  public String getDescription()
  {
    return this.description;
  }

  public float getDistance()
  {
    return this.distance;
  }

  public int getDrivingTime()
  {
    return this.drivingTime;
  }

  public int getDrivingTimeInMins()
  {
    return this.drivingTimeInMins;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public String getNotes()
  {
    return this.notes;
  }

  public String getPhone()
  {
    return this.phone;
  }

  public float getPrice()
  {
    return this.price;
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setDistance(float paramFloat)
  {
    this.distance = paramFloat;
  }

  public void setDrivingTime(int paramInt)
  {
    this.drivingTime = paramInt;
    int i = paramInt / 60;
    this.drivingTimeInMins = i;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setNotes(String paramString)
  {
    this.notes = paramString;
  }

  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }

  public void setPrice(float paramFloat)
  {
    this.price = paramFloat;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.HopStopTaxi
 * JD-Core Version:    0.6.2
 */