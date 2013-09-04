package com.hopstop.ClientModel;

import com.hopstop.network.NetworkSettings;

public class MapRequest extends MapReqBase
{
  private int map_H = 0;
  private int map_W = 0;
  private Address map_addr;
  private String showNearby = "s";
  private int type_url = 0;
  private String url_mapH = "mapH";
  private String url_mapW = "mapW";
  private String url_showNearby = "showNearby";
  private String url_x = "x";
  private String url_y = "y";

  public MapRequest(double paramDouble1, double paramDouble2, String paramString, int paramInt1, int paramInt2)
  {
    Address localAddress = new Address(paramDouble1, paramDouble2);
    this.map_addr = localAddress;
    this.showNearby = paramString;
    this.map_W = paramInt1;
    this.map_H = paramInt2;
  }

  public MapRequest(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    Address localAddress = new Address(paramString1, paramString2, paramString3);
    this.map_addr = localAddress;
    this.showNearby = paramString4;
    this.map_W = paramInt1;
    this.map_H = paramInt2;
  }

  public String completeMapReqURL()
  {
    String str1;
    switch (this.type_url)
    {
    default:
      str1 = null;
    case 0:
    case 1:
    }
    while (true)
    {
      return str1;
      String str2 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder1 = new StringBuilder(str2);
      String str3 = this.map_addr.getFullAddressURLEncoded();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str3);
      String str4 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str4);
      String str5 = this.url_showNearby;
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str5);
      String str6 = NetworkSettings.equal;
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str6);
      String str7 = this.showNearby;
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str7);
      String str8 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder7 = localStringBuilder6.append(str8);
      String str9 = this.url_mapW;
      StringBuilder localStringBuilder8 = localStringBuilder7.append(str9);
      String str10 = NetworkSettings.equal;
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str10);
      int i = this.map_W;
      StringBuilder localStringBuilder10 = localStringBuilder9.append(i);
      String str11 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder11 = localStringBuilder10.append(str11);
      String str12 = this.url_mapH;
      StringBuilder localStringBuilder12 = localStringBuilder11.append(str12);
      String str13 = NetworkSettings.equal;
      StringBuilder localStringBuilder13 = localStringBuilder12.append(str13);
      int j = this.map_H;
      str1 = j;
      continue;
      String str14 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder14 = new StringBuilder(str14);
      String str15 = this.url_x;
      StringBuilder localStringBuilder15 = localStringBuilder14.append(str15);
      String str16 = NetworkSettings.equal;
      StringBuilder localStringBuilder16 = localStringBuilder15.append(str16);
      double d1 = this.map_addr.getX();
      StringBuilder localStringBuilder17 = localStringBuilder16.append(d1);
      String str17 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder18 = localStringBuilder17.append(str17);
      String str18 = this.url_y;
      StringBuilder localStringBuilder19 = localStringBuilder18.append(str18);
      String str19 = NetworkSettings.equal;
      StringBuilder localStringBuilder20 = localStringBuilder19.append(str19);
      double d2 = this.map_addr.getY();
      StringBuilder localStringBuilder21 = localStringBuilder20.append(d2);
      String str20 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str20);
      String str21 = this.url_showNearby;
      StringBuilder localStringBuilder23 = localStringBuilder22.append(str21);
      String str22 = NetworkSettings.equal;
      StringBuilder localStringBuilder24 = localStringBuilder23.append(str22);
      String str23 = this.showNearby;
      StringBuilder localStringBuilder25 = localStringBuilder24.append(str23);
      String str24 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder26 = localStringBuilder25.append(str24);
      String str25 = this.url_mapW;
      StringBuilder localStringBuilder27 = localStringBuilder26.append(str25);
      String str26 = NetworkSettings.equal;
      StringBuilder localStringBuilder28 = localStringBuilder27.append(str26);
      int k = this.map_W;
      StringBuilder localStringBuilder29 = localStringBuilder28.append(k);
      String str27 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder30 = localStringBuilder29.append(str27);
      String str28 = this.url_mapH;
      StringBuilder localStringBuilder31 = localStringBuilder30.append(str28);
      String str29 = NetworkSettings.equal;
      StringBuilder localStringBuilder32 = localStringBuilder31.append(str29);
      int m = this.map_H;
      str1 = m;
    }
  }

  public Address getAddress()
  {
    return this.map_addr;
  }

  public void setTypeUrl(int paramInt)
  {
    this.type_url = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.MapRequest
 * JD-Core Version:    0.6.2
 */