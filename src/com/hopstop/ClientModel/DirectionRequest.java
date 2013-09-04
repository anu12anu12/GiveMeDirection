package com.hopstop.ClientModel;

import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkSettings;
import java.net.URLEncoder;

public class DirectionRequest
{
  public static final String arrive_by_prefix = "arriveBy=";
  public static final String simplified_directions_prefix = "simplifiedDirs=";
  public static final String url_address1 = "address1";
  public static final String url_address2 = "address2";
  public static final String url_city1 = "city1";
  public static final String url_city2 = "city2";
  public static final String wheel_char_off = "wheel_chair=0";
  public static final String wheel_char_on = "wheel_chair=1";
  private Address address1;
  private Address address2;
  private int day;
  public final String exclude_both_express_bus_and_private_vehicles = "excluded_classes=P,F,E";
  public final String exclude_only_express_bus = "excluded_classes=E";
  private final String exclude_only_private_vehicles = "excluded_classes=P,F";
  private String lang;
  private String language = "language";
  private String mapH = "mapH";
  private String mapW = "mapW";
  private String mode;
  private String regional_rail = "excluded_vehicles=H,R,U";
  private final String smart_route = "excludeMainRoute=1&multipleRoutes=1";
  private String thumbnailId1;
  private String thumbnailId2;
  private String time;
  private int transferPriority;
  private int type_url;
  private String url_county1 = "county1";
  private String url_county2 = "county2";
  private String url_day = "day";
  private String url_enableDisabledLinks = "enableDisabledLinks";
  public final String url_mode = "mode";
  private String url_thumbnail1 = "thumbnail1Id";
  private String url_thumbnail2 = "thumbnail2Id";
  private String url_time = "time";
  private String url_transferPriority = "transferPriority";
  private String width;
  private double x1;
  private String x1_url = "x1";
  private double x2;
  private String x2_url = "x2";
  private double y1;
  private String y1_url = "y1";
  private double y2;
  private String y2_url = "y2";

  public DirectionRequest(double paramDouble1, double paramDouble2, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7)
  {
    this.x1 = paramDouble1;
    this.y1 = paramDouble2;
    Address localAddress = new Address(paramString1, paramString2, paramString3);
    this.address2 = localAddress;
    this.day = paramInt1;
    this.time = paramString4;
    this.mode = paramString5;
    this.transferPriority = paramInt2;
    this.width = paramString6;
    this.lang = paramString7;
  }

  public DirectionRequest(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6)
  {
    this.thumbnailId1 = paramString1;
    this.thumbnailId2 = paramString2;
    this.day = paramInt1;
    this.time = paramString3;
    this.mode = paramString4;
    this.transferPriority = paramInt2;
    this.width = paramString5;
    this.lang = paramString6;
  }

  public DirectionRequest(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, int paramInt1, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7)
  {
    Address localAddress = new Address(paramString1, paramString2, paramString3);
    this.address1 = localAddress;
    this.x2 = paramDouble1;
    this.y2 = paramDouble2;
    this.day = paramInt1;
    this.time = paramString4;
    this.mode = paramString5;
    this.transferPriority = paramInt2;
    this.width = paramString6;
    this.lang = paramString7;
  }

  public DirectionRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10)
  {
    Address localAddress1 = new Address(paramString1, paramString2, paramString3);
    this.address1 = localAddress1;
    Address localAddress2 = new Address(paramString4, paramString5, paramString6);
    this.address2 = localAddress2;
    this.day = paramInt1;
    this.time = paramString7;
    this.mode = paramString8;
    this.transferPriority = paramInt2;
    this.width = paramString9;
    this.lang = paramString10;
  }

  public String completeGetRouteURL()
  {
    String str1 = String.valueOf(getCityCountyAddress());
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = getCommonString();
    return str2;
  }

  public String completeGetTaxiRouteURL()
  {
    String str1 = String.valueOf(getCityCountyAddress());
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
    String str3 = this.url_day;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str3);
    String str4 = NetworkSettings.equal;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str4);
    int i = this.day;
    StringBuilder localStringBuilder5 = localStringBuilder4.append(i);
    String str5 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder6 = localStringBuilder5.append(str5);
    String str6 = this.url_time;
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str6);
    String str7 = NetworkSettings.equal;
    StringBuilder localStringBuilder8 = localStringBuilder7.append(str7);
    String str8 = this.time;
    StringBuilder localStringBuilder9 = localStringBuilder8.append(str8);
    String str9 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder10 = localStringBuilder9.append(str9).append("mode");
    String str10 = NetworkSettings.equal;
    StringBuilder localStringBuilder11 = localStringBuilder10.append(str10).append("j");
    String str11 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder12 = localStringBuilder11.append(str11);
    String str12 = this.url_enableDisabledLinks;
    StringBuilder localStringBuilder13 = localStringBuilder12.append(str12);
    String str13 = NetworkSettings.equal;
    StringBuilder localStringBuilder14 = localStringBuilder13.append(str13).append("1");
    String str14 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder15 = localStringBuilder14.append(str14).append("arriveBy=");
    int j = ApplicationEngine.getModel().getIsArriveByInt();
    return j;
  }

  public String getCityCountyAddress()
  {
    String str1 = "";
    switch (this.type_url)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return str1;
      String str2 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder1 = new StringBuilder(str2).append("city1");
      String str3 = NetworkSettings.equal;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str3);
      String str4 = this.address1.getUrlCity().toLowerCase();
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str4);
      String str5 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str5).append("address1");
      String str6 = NetworkSettings.equal;
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str6);
      String str7 = this.address1.getAddress();
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str7);
      String str8 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder7 = localStringBuilder6.append(str8);
      String str9 = this.url_county1;
      StringBuilder localStringBuilder8 = localStringBuilder7.append(str9);
      String str10 = NetworkSettings.equal;
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str10);
      String str11 = URLEncoder.encode(this.address1.getUrlCounty());
      StringBuilder localStringBuilder10 = localStringBuilder9.append(str11);
      String str12 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder11 = localStringBuilder10.append(str12).append("city2");
      String str13 = NetworkSettings.equal;
      StringBuilder localStringBuilder12 = localStringBuilder11.append(str13);
      String str14 = this.address2.getUrlCity().toLowerCase();
      StringBuilder localStringBuilder13 = localStringBuilder12.append(str14);
      String str15 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder14 = localStringBuilder13.append(str15).append("address2");
      String str16 = NetworkSettings.equal;
      StringBuilder localStringBuilder15 = localStringBuilder14.append(str16);
      String str17 = this.address2.getAddress();
      StringBuilder localStringBuilder16 = localStringBuilder15.append(str17);
      String str18 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder17 = localStringBuilder16.append(str18);
      String str19 = this.url_county2;
      StringBuilder localStringBuilder18 = localStringBuilder17.append(str19);
      String str20 = NetworkSettings.equal;
      StringBuilder localStringBuilder19 = localStringBuilder18.append(str20);
      String str21 = URLEncoder.encode(this.address2.getUrlCounty());
      str1 = str21;
      continue;
      String str22 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder20 = new StringBuilder(str22);
      String str23 = this.x1_url;
      StringBuilder localStringBuilder21 = localStringBuilder20.append(str23);
      String str24 = NetworkSettings.equal;
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str24);
      double d1 = this.x1;
      StringBuilder localStringBuilder23 = localStringBuilder22.append(d1);
      String str25 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder24 = localStringBuilder23.append(str25);
      String str26 = this.y1_url;
      StringBuilder localStringBuilder25 = localStringBuilder24.append(str26);
      String str27 = NetworkSettings.equal;
      StringBuilder localStringBuilder26 = localStringBuilder25.append(str27);
      double d2 = this.y1;
      StringBuilder localStringBuilder27 = localStringBuilder26.append(d2);
      String str28 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder28 = localStringBuilder27.append(str28).append("city2");
      String str29 = NetworkSettings.equal;
      StringBuilder localStringBuilder29 = localStringBuilder28.append(str29);
      String str30 = this.address2.getUrlCity().toLowerCase();
      StringBuilder localStringBuilder30 = localStringBuilder29.append(str30);
      String str31 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder31 = localStringBuilder30.append(str31).append("address2");
      String str32 = NetworkSettings.equal;
      StringBuilder localStringBuilder32 = localStringBuilder31.append(str32);
      String str33 = this.address2.getAddress();
      StringBuilder localStringBuilder33 = localStringBuilder32.append(str33);
      String str34 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder34 = localStringBuilder33.append(str34);
      String str35 = this.url_county2;
      StringBuilder localStringBuilder35 = localStringBuilder34.append(str35);
      String str36 = NetworkSettings.equal;
      StringBuilder localStringBuilder36 = localStringBuilder35.append(str36);
      String str37 = URLEncoder.encode(this.address2.getUrlCounty());
      str1 = str37;
      continue;
      String str38 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder37 = new StringBuilder(str38).append("city1");
      String str39 = NetworkSettings.equal;
      StringBuilder localStringBuilder38 = localStringBuilder37.append(str39);
      String str40 = this.address1.getUrlCity().toLowerCase();
      StringBuilder localStringBuilder39 = localStringBuilder38.append(str40);
      String str41 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder40 = localStringBuilder39.append(str41).append("address1");
      String str42 = NetworkSettings.equal;
      StringBuilder localStringBuilder41 = localStringBuilder40.append(str42);
      String str43 = this.address1.getAddress();
      StringBuilder localStringBuilder42 = localStringBuilder41.append(str43);
      String str44 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder43 = localStringBuilder42.append(str44);
      String str45 = this.url_county1;
      StringBuilder localStringBuilder44 = localStringBuilder43.append(str45);
      String str46 = NetworkSettings.equal;
      StringBuilder localStringBuilder45 = localStringBuilder44.append(str46);
      String str47 = URLEncoder.encode(this.address1.getUrlCounty());
      StringBuilder localStringBuilder46 = localStringBuilder45.append(str47);
      String str48 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder47 = localStringBuilder46.append(str48);
      String str49 = this.x2_url;
      StringBuilder localStringBuilder48 = localStringBuilder47.append(str49);
      String str50 = NetworkSettings.equal;
      StringBuilder localStringBuilder49 = localStringBuilder48.append(str50);
      double d3 = this.x2;
      StringBuilder localStringBuilder50 = localStringBuilder49.append(d3);
      String str51 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder51 = localStringBuilder50.append(str51);
      String str52 = this.y2_url;
      StringBuilder localStringBuilder52 = localStringBuilder51.append(str52);
      String str53 = NetworkSettings.equal;
      StringBuilder localStringBuilder53 = localStringBuilder52.append(str53);
      double d4 = this.y2;
      str1 = d4;
      continue;
      String str54 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder54 = new StringBuilder(str54);
      String str55 = this.url_thumbnail1;
      StringBuilder localStringBuilder55 = localStringBuilder54.append(str55);
      String str56 = NetworkSettings.equal;
      StringBuilder localStringBuilder56 = localStringBuilder55.append(str56);
      String str57 = this.thumbnailId1;
      StringBuilder localStringBuilder57 = localStringBuilder56.append(str57);
      String str58 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder58 = localStringBuilder57.append(str58);
      String str59 = this.url_thumbnail2;
      StringBuilder localStringBuilder59 = localStringBuilder58.append(str59);
      String str60 = NetworkSettings.equal;
      StringBuilder localStringBuilder60 = localStringBuilder59.append(str60);
      String str61 = this.thumbnailId2;
      str1 = str61;
    }
  }

  public String getCommonString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = "";
    String str23;
    label434: StringBuilder localStringBuilder34;
    if ((!ApplicationEngine.getModel().isPrivate_vehicles()) && (!ApplicationEngine.getModel().getIsExpressBusIncluded()))
    {
      String str2 = String.valueOf(NetworkSettings.ampersand);
      str1 = str2 + "excluded_classes=P,F,E";
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      String str3 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder3 = localStringBuilder1.append(str3).append("simplifiedDirs=");
      int i = ApplicationEngine.getModel().getIsSimplifiedDirectionsInt();
      StringBuilder localStringBuilder4 = localStringBuilder3.append(i);
      if (ApplicationEngine.getModel().getIsSmartRouteEnabled())
      {
        String str4 = NetworkSettings.ampersand;
        StringBuilder localStringBuilder5 = localStringBuilder1.append(str4).append("excludeMainRoute=1&multipleRoutes=1");
      }
      String str5 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder6 = new StringBuilder(str5);
      String str6 = this.url_day;
      StringBuilder localStringBuilder7 = localStringBuilder6.append(str6);
      String str7 = NetworkSettings.equal;
      StringBuilder localStringBuilder8 = localStringBuilder7.append(str7);
      int j = this.day;
      StringBuilder localStringBuilder9 = localStringBuilder8.append(j);
      String str8 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder10 = localStringBuilder9.append(str8);
      String str9 = this.url_time;
      StringBuilder localStringBuilder11 = localStringBuilder10.append(str9);
      String str10 = NetworkSettings.equal;
      StringBuilder localStringBuilder12 = localStringBuilder11.append(str10);
      String str11 = this.time;
      StringBuilder localStringBuilder13 = localStringBuilder12.append(str11);
      String str12 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder14 = localStringBuilder13.append(str12).append("mode");
      String str13 = NetworkSettings.equal;
      StringBuilder localStringBuilder15 = localStringBuilder14.append(str13);
      String str14 = this.mode;
      StringBuilder localStringBuilder16 = localStringBuilder15.append(str14);
      String str15 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder17 = localStringBuilder16.append(str15);
      String str16 = this.language;
      StringBuilder localStringBuilder18 = localStringBuilder17.append(str16);
      String str17 = NetworkSettings.equal;
      StringBuilder localStringBuilder19 = localStringBuilder18.append(str17);
      String str18 = this.lang;
      StringBuilder localStringBuilder20 = localStringBuilder19.append(str18);
      String str19 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder21 = localStringBuilder20.append(str19);
      String str20 = this.url_transferPriority;
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str20);
      String str21 = NetworkSettings.equal;
      StringBuilder localStringBuilder23 = localStringBuilder22.append(str21);
      int k = this.transferPriority;
      StringBuilder localStringBuilder24 = localStringBuilder23.append(k);
      String str22 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder25 = localStringBuilder24.append(str22);
      if (!ApplicationEngine.getModel().isWheelChairOn())
        break label723;
      str23 = "wheel_chair=1";
      StringBuilder localStringBuilder26 = localStringBuilder25.append(str23);
      String str24 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder27 = localStringBuilder26.append(str24);
      String str25 = this.mapW;
      StringBuilder localStringBuilder28 = localStringBuilder27.append(str25);
      String str26 = NetworkSettings.equal;
      StringBuilder localStringBuilder29 = localStringBuilder28.append(str26);
      String str27 = this.width;
      StringBuilder localStringBuilder30 = localStringBuilder29.append(str27);
      String str28 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder31 = localStringBuilder30.append(str28);
      String str29 = this.mapH;
      StringBuilder localStringBuilder32 = localStringBuilder31.append(str29);
      String str30 = NetworkSettings.equal;
      StringBuilder localStringBuilder33 = localStringBuilder32.append(str30);
      String str31 = this.width;
      localStringBuilder34 = localStringBuilder33.append(str31);
      if (!ApplicationEngine.getModel().isRegional_rail())
        break label730;
    }
    label723: label730: StringBuilder localStringBuilder37;
    String str39;
    for (String str32 = ""; ; str32 = str39)
    {
      StringBuilder localStringBuilder35 = localStringBuilder34.append(str32);
      String str33 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder36 = localStringBuilder35.append(str33).append("arriveBy=");
      int m = ApplicationEngine.getModel().getIsArriveByInt();
      String str34 = m;
      String str35 = String.valueOf(localStringBuilder1.toString());
      return str35 + str34;
      if (!ApplicationEngine.getModel().isPrivate_vehicles())
      {
        String str36 = String.valueOf(NetworkSettings.ampersand);
        str1 = str36 + "excluded_classes=P,F";
        break;
      }
      if (ApplicationEngine.getModel().getIsExpressBusIncluded())
        break;
      String str37 = String.valueOf(NetworkSettings.ampersand);
      str1 = str37 + "excluded_classes=E";
      break;
      str23 = "wheel_chair=0";
      break label434;
      String str38 = String.valueOf(NetworkSettings.ampersand);
      localStringBuilder37 = new StringBuilder(str38);
      str39 = this.regional_rail;
    }
  }

  public String getWebLink()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("http://www.hopstop.com/search?trip_type=1&action=calc&stop_count=2");
    String str1 = completeGetRouteURL();
    StringBuilder localStringBuilder3 = localStringBuilder1.append(str1);
    if (ApplicationEngine.getModel().getIsSmartRouteEnabled())
    {
      String str2 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder4 = localStringBuilder1.append(str2).append("sm_rt=1");
    }
    return URLEncoder.encode(localStringBuilder1.toString());
  }

  public void setTypeUrl(int paramInt)
  {
    this.type_url = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.DirectionRequest
 * JD-Core Version:    0.6.2
 */