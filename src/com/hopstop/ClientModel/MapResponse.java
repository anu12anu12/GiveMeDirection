package com.hopstop.ClientModel;

import android.graphics.drawable.Drawable;
import com.hopstop.network.NetworkEngine;
import java.io.Serializable;

public class MapResponse extends HopStopMap
  implements Serializable
{
  private static final long serialVersionUID = -1340840963244028867L;
  private String address;
  private String city;
  private String county;
  private int height;
  private String id;
  private String state;
  private double x;
  private double y;
  private String zip;

  public String getAddress()
  {
    return this.address;
  }

  public String getCity()
  {
    return this.city;
  }

  public String getCounty()
  {
    return this.county;
  }

  public int getHeight()
  {
    return this.height;
  }

  public String getId()
  {
    return this.id;
  }

  public String getKeyWords()
  {
    if (this == null);
    String str2;
    for (String str1 = ""; ; str1 = str2.toLowerCase())
    {
      return str1;
      str2 = "";
      if (this.zip != null)
      {
        String str3 = String.valueOf(str2);
        StringBuilder localStringBuilder1 = new StringBuilder(str3);
        String str4 = this.zip;
        str2 = str4 + ",";
      }
      if (this.x != 0.0D)
      {
        String str5 = String.valueOf(str2);
        StringBuilder localStringBuilder2 = new StringBuilder(str5);
        double d1 = this.x;
        str2 = d1 + ",";
      }
      if (this.y != 0.0D)
      {
        String str6 = String.valueOf(str2);
        StringBuilder localStringBuilder3 = new StringBuilder(str6);
        double d2 = this.y;
        str2 = d2 + ",";
      }
      if (this.city != null)
      {
        String str7 = String.valueOf(str2);
        StringBuilder localStringBuilder4 = new StringBuilder(str7);
        String str8 = this.city;
        str2 = str8 + ",";
      }
      if (this.address != null)
      {
        String str9 = String.valueOf(str2);
        StringBuilder localStringBuilder5 = new StringBuilder(str9);
        String str10 = this.address;
        str2 = str10 + ",";
      }
      if (str2 != null)
      {
        int i = str2.lastIndexOf(",");
        str2 = str2.substring(0, i);
      }
    }
  }

  public Drawable getMap()
  {
    return this.map;
  }

  public String getState()
  {
    return this.state;
  }

  public double getX()
  {
    return this.x;
  }

  public double getY()
  {
    return this.y;
  }

  public String getZip()
  {
    return this.zip;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public void setCity(String paramString)
  {
    this.city = paramString;
  }

  public void setCounty(String paramString)
  {
    this.county = paramString;
  }

  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setState(String paramString)
  {
    this.state = paramString;
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
    if (this.url == null)
      return;
    if (this.url.length() <= 0)
      return;
    Drawable localDrawable = NetworkEngine.fetchNewDrawable(this.url);
    this.map = localDrawable;
  }

  public void setX(double paramDouble)
  {
    this.x = paramDouble;
  }

  public void setY(double paramDouble)
  {
    this.y = paramDouble;
  }

  public void setZip(String paramString)
  {
    this.zip = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.MapResponse
 * JD-Core Version:    0.6.2
 */