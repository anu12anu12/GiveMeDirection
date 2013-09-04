package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;

public class ViewStepAddress
  implements ViewStep
{
  private static final long serialVersionUID = 7120347892097810043L;
  private double _x;
  private double _y;
  private String address;
  private String city1;
  private String city2;
  private String county1;
  private String county2;
  private boolean isStart = true;
  private String zip1;
  private String zip2;

  public ViewStepAddress cloneItself()
  {
    ViewStepAddress localViewStepAddress = new ViewStepAddress();
    String str1 = this.address;
    localViewStepAddress.setAddress(str1);
    boolean bool = this.isStart;
    localViewStepAddress.isStart = bool;
    String str2 = this.city1;
    localViewStepAddress.setCity1(str2);
    String str3 = this.city2;
    localViewStepAddress.setCity2(str3);
    String str4 = this.zip1;
    localViewStepAddress.setZip1(str4);
    String str5 = this.zip2;
    localViewStepAddress.setZip2(str5);
    String str6 = this.county1;
    localViewStepAddress.setCounty1(str6);
    String str7 = this.county2;
    localViewStepAddress.setCounty2(str7);
    return localViewStepAddress;
  }

  public void downloadError(int paramInt)
  {
  }

  public String formartedAddress()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this.address;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    if (this.isStart)
      if (this.county1 != null)
      {
        StringBuilder localStringBuilder3 = new StringBuilder(", ");
        String str2 = this.county1;
        String str3 = str2;
        StringBuilder localStringBuilder4 = localStringBuilder1.append(str3);
      }
    while (true)
    {
      return localStringBuilder1.toString();
      if (this.zip1 != null)
      {
        StringBuilder localStringBuilder5 = new StringBuilder(", ");
        String str4 = this.zip1;
        String str5 = str4;
        StringBuilder localStringBuilder6 = localStringBuilder1.append(str5);
        continue;
        if (this.county2 != null)
        {
          StringBuilder localStringBuilder7 = new StringBuilder(", ");
          String str6 = this.county2;
          String str7 = str6;
          StringBuilder localStringBuilder8 = localStringBuilder1.append(str7);
        }
        else if (this.zip2 != null)
        {
          StringBuilder localStringBuilder9 = new StringBuilder(", ");
          String str8 = this.zip2;
          String str9 = str8;
          StringBuilder localStringBuilder10 = localStringBuilder1.append(str9);
        }
      }
    }
  }

  public String getAddress()
  {
    return this.address;
  }

  public Bitmap getBitmap()
  {
    return null;
  }

  public String getCity1()
  {
    return this.city1;
  }

  public String getCity2()
  {
    return this.city2;
  }

  public String getCounty1()
  {
    return this.county1;
  }

  public String getCounty2()
  {
    return this.county2;
  }

  public String getFullAddress1()
  {
    String str1 = String.valueOf(this.address);
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    if (this.zip1 == null);
    StringBuilder localStringBuilder2;
    String str3;
    for (String str2 = ""; ; str2 = str3)
    {
      return str2;
      localStringBuilder2 = new StringBuilder(", ");
      str3 = this.zip1;
    }
  }

  public String getFullAddress2()
  {
    String str1 = String.valueOf(this.address);
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    if (this.zip2 == null);
    StringBuilder localStringBuilder2;
    String str3;
    for (String str2 = ""; ; str2 = str3)
    {
      return str2;
      localStringBuilder2 = new StringBuilder(", ");
      str3 = this.zip2;
    }
  }

  public String getURL()
  {
    return null;
  }

  public double getX()
  {
    return this._x;
  }

  public double getY()
  {
    return this._y;
  }

  public String getZip1()
  {
    return this.zip1;
  }

  public String getZip2()
  {
    return this.zip2;
  }

  public boolean isDownloading()
  {
    return false;
  }

  public boolean isStart()
  {
    return this.isStart;
  }

  public void recycle(boolean paramBoolean)
  {
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public void setBitmap(Bitmap paramBitmap)
  {
  }

  public void setCity1(String paramString)
  {
    this.city1 = paramString;
  }

  public void setCity2(String paramString)
  {
    this.city2 = paramString;
  }

  public void setCounty1(String paramString)
  {
    this.county1 = paramString;
  }

  public void setCounty2(String paramString)
  {
    this.county2 = paramString;
  }

  public void setDownloading(boolean paramBoolean)
  {
  }

  public void setStart(boolean paramBoolean)
  {
    this.isStart = paramBoolean;
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
  }

  public void setX(double paramDouble)
  {
    this._x = paramDouble;
  }

  public void setY(double paramDouble)
  {
    this._y = paramDouble;
  }

  public void setZip1(String paramString)
  {
    this.zip1 = paramString;
  }

  public void setZip2(String paramString)
  {
    this.zip2 = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ViewStepAddress
 * JD-Core Version:    0.6.2
 */