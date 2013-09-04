package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;

public class ViewStepTaxi
  implements ViewStep
{
  private static final long serialVersionUID = -8376307284435312588L;
  private String description;
  private float distance;
  private int drivingTime;
  private String id;
  private String name;
  private String notes;
  private String phone;
  private float price;

  public ViewStepTaxi()
  {
  }

  public ViewStepTaxi(float paramFloat1, String paramString1, float paramFloat2, String paramString2, String paramString3)
  {
    this.distance = paramFloat1;
    this.name = paramString1;
    this.price = paramFloat2;
    this.phone = paramString2;
    this.notes = paramString3;
  }

  public ViewStepTaxi cloneItself()
  {
    ViewStepTaxi localViewStepTaxi = new ViewStepTaxi();
    String str1 = this.description;
    localViewStepTaxi.setDescription(str1);
    float f1 = this.distance;
    localViewStepTaxi.setDistance(f1);
    int i = this.drivingTime;
    localViewStepTaxi.setDrivingTime(i);
    String str2 = this.id;
    localViewStepTaxi.setId(str2);
    String str3 = this.name;
    localViewStepTaxi.setName(str3);
    String str4 = this.notes;
    localViewStepTaxi.setNotes(str4);
    String str5 = this.phone;
    localViewStepTaxi.setPhone(str5);
    float f2 = this.price;
    localViewStepTaxi.setPrice(f2);
    return localViewStepTaxi;
  }

  public void downloadError(int paramInt)
  {
  }

  public Bitmap getBitmap()
  {
    return null;
  }

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

  public String getURL()
  {
    return null;
  }

  public boolean isDownloading()
  {
    return false;
  }

  public void recycle(boolean paramBoolean)
  {
  }

  public void setBitmap(Bitmap paramBitmap)
  {
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setDistance(float paramFloat)
  {
    this.distance = paramFloat;
  }

  public void setDownloading(boolean paramBoolean)
  {
  }

  public void setDrivingTime(int paramInt)
  {
    this.drivingTime = paramInt;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    String str = paramString;
    this.name = str;
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

  public void setURL(String paramString, boolean paramBoolean)
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ViewStepTaxi
 * JD-Core Version:    0.6.2
 */