package com.hopstop.ClientModel.Geocode;

import java.net.URLEncoder;

public class GeocodeRequest
{
  String address;
  String city;
  String county;
  String zip;

  public GeocodeRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.address = paramString1;
    this.city = paramString2;
    this.county = paramString3;
    this.zip = paramString4;
  }

  public String getGeocodeRequestURL()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("city=");
    String str1 = this.city;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("&address=");
    String str2 = String.valueOf(this.address);
    StringBuilder localStringBuilder3 = new StringBuilder(str2);
    String str4;
    StringBuilder localStringBuilder5;
    StringBuilder localStringBuilder6;
    String str5;
    if (this.county != null)
    {
      StringBuilder localStringBuilder4 = new StringBuilder(",");
      String str3 = this.county;
      str4 = str3;
      localStringBuilder5 = localStringBuilder3.append(str4);
      if (this.zip == null)
        break label159;
      localStringBuilder6 = new StringBuilder(",");
      str5 = this.zip;
    }
    label159: for (String str6 = str5; ; str6 = "")
    {
      String str7 = URLEncoder.encode(str6);
      return str7;
      str4 = "";
      break;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Geocode.GeocodeRequest
 * JD-Core Version:    0.6.2
 */