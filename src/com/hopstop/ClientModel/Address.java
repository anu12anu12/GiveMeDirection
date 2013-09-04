package com.hopstop.ClientModel;

import java.io.Serializable;
import java.net.URLEncoder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(strict=false)
public class Address
  implements Serializable, Cloneable
{

  @Element(name="AddressId", required=false)
  private int _addressId;

  @Element(name="Title", required=false)
  private String address;
  private String city;

  @Element(name="Id", required=false)
  private String thumbnailId;
  private String urlCity;

  @Element(name="County", required=false)
  private String urlCounty;

  @Element(name="X", required=false)
  private double x;

  @Element(name="Y", required=false)
  private double y;

  @Element(name="Zip", required=false)
  private String zip;

  public Address()
  {
  }

  public Address(double paramDouble1, double paramDouble2)
  {
    this.address = "Current Location";
    this.x = paramDouble1;
    this.y = paramDouble2;
  }

  public Address(String paramString1, String paramString2, String paramString3)
  {
    this.address = paramString1;
    this.urlCounty = paramString2;
    this.urlCity = paramString3;
  }

  @Commit
  public void build()
  {
  }

  public String getAddress()
  {
    if (this == null);
    for (String str = null; ; str = this.address)
      return str;
  }

  public int getAddressId()
  {
    return this._addressId;
  }

  public String getCity()
  {
    return this.city;
  }

  public String getFullAddress()
  {
    String str4;
    if (this.address != null)
    {
      String str1 = String.valueOf(this.address);
      StringBuilder localStringBuilder1 = new StringBuilder(str1).append(", ");
      String str2 = this.urlCounty;
      if (str2 == null)
      {
        String str3 = String.valueOf(this.urlCounty);
        str4 = str3 + ", ";
      }
    }
    while (true)
    {
      return str4;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str5 = this.urlCity;
      str4 = str5;
      continue;
      str4 = null;
    }
  }

  public String getFullAddressURLEncoded()
  {
    StringBuilder localStringBuilder3;
    String str3;
    if ((this.address != null) && (this.urlCity != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder("address=");
      String str1 = URLEncoder.encode(this.address);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("&").append("county=");
      String str2 = getUrlCounty();
      localStringBuilder3 = localStringBuilder2.append(str2).append("&").append("city=");
      str3 = this.urlCity;
    }
    for (String str4 = str3; ; str4 = null)
      return str4;
  }

  public String getThumbnailId()
  {
    return this.thumbnailId;
  }

  public String getUrlCity()
  {
    return this.urlCity;
  }

  public String getUrlCounty()
  {
    if (this.urlCounty == null);
    for (String str = ""; ; str = this.urlCounty)
      return str;
  }

  public double getX()
  {
    return this.x;
  }

  public double getY()
  {
    return this.y;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public void setCity(String paramString)
  {
    this.city = paramString;
  }

  public void setThumbnailId(String paramString)
  {
    this.thumbnailId = paramString;
  }

  public void setUrlCity(String paramString)
  {
    this.urlCity = paramString;
  }

  public void setUrlCounty(String paramString)
  {
    this.urlCounty = paramString;
  }

  public void setX(double paramDouble)
  {
    this.x = paramDouble;
  }

  public void setY(double paramDouble)
  {
    this.y = paramDouble;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Address
 * JD-Core Version:    0.6.2
 */