package com.hopstop.network;

import android.location.Location;
import com.hopstop.ClientModel.Address;
import com.hopstop.ClientModel.DirectionRequest;
import com.hopstop.ClientModel.MapRequest;
import com.hopstop.ClientModel.MapUpdateRequest;

public class URLFactoryBuilder
{
  public static String GetCountImpressionURL(String paramString)
  {
    String str = NetworkSettings.count_impression_url;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    return String.format(str, arrayOfObject);
  }

  public static String GetGeocodeRequest(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.geocode, paramString2));
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    return str2 + paramString1;
  }

  public static String GetLonLanToCityURL(Location paramLocation, String paramString)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.getcity_from_lon_lan, paramString));
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
    String str3 = NetworkSettings.latitude;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str3);
    String str4 = NetworkSettings.equal;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str4);
    double d1 = paramLocation.getLatitude();
    StringBuilder localStringBuilder5 = localStringBuilder4.append(d1);
    String str5 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder6 = localStringBuilder5.append(str5);
    String str6 = NetworkSettings.longitude;
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str6);
    String str7 = NetworkSettings.equal;
    StringBuilder localStringBuilder8 = localStringBuilder7.append(str7);
    double d2 = paramLocation.getLongitude();
    return d2;
  }

  public static String GetMoreSmartRouteRequest(String paramString)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.getroute_method));
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    return str2 + paramString;
  }

  public static String GetNearbyBusinessURL(String paramString1, String paramString2, String paramString3)
  {
    return getYestURL(NetworkSettings.yext_key, paramString1, paramString2, paramString3);
  }

  public static String GetNearbyStationsRequest(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.get_nearby_stations, paramString2));
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    return str2 + paramString1;
  }

  public static String GetScheduleInfo(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.get_schedule_info, paramString2));
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    return str2 + paramString1;
  }

  public static String GetSchedulesCitiesURL(String paramString)
  {
    return getCommonURL(NetworkSettings.getschedules_cities, paramString);
  }

  public static String GetSchedulesGroupsURL(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.getschedules_stationgroups, paramString2));
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("city");
    String str3 = NetworkSettings.equal;
    return str3 + paramString1;
  }

  public static String GetSchedulesSearch(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.getschedules_schedule, paramString2));
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    return str2 + paramString1;
  }

  public static String GetSchedulesStationsInGroupURL(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.getschedules_stations_in_group, paramString2));
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("stationGroupId");
    String str3 = NetworkSettings.equal;
    return str3 + paramString1;
  }

  public static String GetServiceAdvisorURL(String paramString)
  {
    String str = NetworkSettings.service_advisor_url;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    return String.format(str, arrayOfObject);
  }

  public static String GetSmartRouteRequest(String paramString)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.getroute_method));
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    return str2 + paramString;
  }

  public static String GetYextEnhancedList(String paramString1, String paramString2)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    String str = paramString2.toLowerCase();
    arrayOfObject[1] = str;
    return String.format("https://pl.yext.com/lists?pid=jsR77MufY9&yextId=%s&template=mobile-%s", arrayOfObject);
  }

  public static String GetYextEnhancedListClick(String paramString1, String paramString2)
  {
    String str1 = NetworkSettings.count_yext_enhanced_list_click_url;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    String str2 = paramString2.toLowerCase();
    arrayOfObject[1] = str2;
    return String.format(str1, arrayOfObject);
  }

  public static String appendXY(String paramString, Address paramAddress, int paramInt)
  {
    StringBuilder localStringBuilder18;
    double d6;
    if (paramString != null)
      if (paramAddress != null)
      {
        if (paramInt == 0)
        {
          String str1 = String.valueOf(paramString);
          StringBuilder localStringBuilder1 = new StringBuilder(str1);
          String str2 = NetworkSettings.ampersand;
          StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("x");
          String str3 = NetworkSettings.equal;
          StringBuilder localStringBuilder3 = localStringBuilder2.append(str3);
          double d1 = paramAddress.getX();
          StringBuilder localStringBuilder4 = localStringBuilder3.append(d1);
          String str4 = NetworkSettings.ampersand;
          StringBuilder localStringBuilder5 = localStringBuilder4.append(str4).append("y");
          String str5 = NetworkSettings.equal;
          StringBuilder localStringBuilder6 = localStringBuilder5.append(str5);
          double d2 = paramAddress.getY();
          paramString = d2;
        }
        if (paramInt == 1)
        {
          String str6 = String.valueOf(paramString);
          StringBuilder localStringBuilder7 = new StringBuilder(str6);
          String str7 = NetworkSettings.ampersand;
          StringBuilder localStringBuilder8 = localStringBuilder7.append(str7).append("x1");
          String str8 = NetworkSettings.equal;
          StringBuilder localStringBuilder9 = localStringBuilder8.append(str8);
          double d3 = paramAddress.getX();
          StringBuilder localStringBuilder10 = localStringBuilder9.append(d3);
          String str9 = NetworkSettings.ampersand;
          StringBuilder localStringBuilder11 = localStringBuilder10.append(str9).append("y1");
          String str10 = NetworkSettings.equal;
          StringBuilder localStringBuilder12 = localStringBuilder11.append(str10);
          double d4 = paramAddress.getY();
          paramString = d4;
        }
        if (paramInt == 2)
        {
          String str11 = String.valueOf(paramString);
          StringBuilder localStringBuilder13 = new StringBuilder(str11);
          String str12 = NetworkSettings.ampersand;
          StringBuilder localStringBuilder14 = localStringBuilder13.append(str12).append("x2");
          String str13 = NetworkSettings.equal;
          StringBuilder localStringBuilder15 = localStringBuilder14.append(str13);
          double d5 = paramAddress.getX();
          StringBuilder localStringBuilder16 = localStringBuilder15.append(d5);
          String str14 = NetworkSettings.ampersand;
          StringBuilder localStringBuilder17 = localStringBuilder16.append(str14).append("y2");
          String str15 = NetworkSettings.equal;
          localStringBuilder18 = localStringBuilder17.append(str15);
          d6 = paramAddress.getY();
        }
      }
    for (paramString = d6; ; paramString = null)
      return paramString;
  }

  public static String getCitiesURL(String paramString)
  {
    return getCommonURL(NetworkSettings.getcities_method, paramString);
  }

  public static String getCommonURL(String paramString)
  {
    String str1 = String.valueOf(NetworkSettings.hopstop_url);
    StringBuilder localStringBuilder1 = new StringBuilder(str1).append(paramString);
    String str2 = NetworkSettings.question_mark;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
    String str3 = NetworkSettings.license;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str3);
    String str4 = NetworkSettings.equal;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str4);
    String str5 = NetworkSettings.keyNewAPI;
    String str6 = str5;
    return new String(str6);
  }

  public static String getCommonURL(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(NetworkSettings.hopstop_url);
    StringBuilder localStringBuilder1 = new StringBuilder(str1).append(paramString1);
    String str2 = NetworkSettings.question_mark;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
    String str3 = NetworkSettings.license;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str3);
    String str4 = NetworkSettings.equal;
    String str5 = str4 + paramString2;
    return new String(str5);
  }

  public static String getMapURL(MapRequest paramMapRequest, String paramString)
  {
    if (paramMapRequest == null);
    StringBuilder localStringBuilder;
    String str3;
    for (String str1 = null; ; str1 = str3)
    {
      return str1;
      String str2 = String.valueOf(getCommonURL(NetworkSettings.getmap_method, paramString));
      localStringBuilder = new StringBuilder(str2);
      str3 = paramMapRequest.completeMapReqURL();
    }
  }

  public static String getReRouteURL(String paramString1, String paramString2, String paramString3)
  {
    String str1 = String.valueOf(getCommonURL(NetworkSettings.getroute_method, paramString3));
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("routeId");
    String str3 = NetworkSettings.equal;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str3).append(paramString1);
    String str4 = NetworkSettings.ampersand;
    return str4 + paramString2;
  }

  public static String getRouteURL(DirectionRequest paramDirectionRequest, String paramString)
  {
    if (paramDirectionRequest == null);
    StringBuilder localStringBuilder;
    String str3;
    for (String str1 = null; ; str1 = str3)
    {
      return str1;
      String str2 = String.valueOf(getCommonURL(NetworkSettings.getroute_method, paramString));
      localStringBuilder = new StringBuilder(str2);
      str3 = paramDirectionRequest.completeGetRouteURL();
    }
  }

  public static String getTaxiRouteURL(DirectionRequest paramDirectionRequest, String paramString)
  {
    if (paramDirectionRequest == null);
    StringBuilder localStringBuilder;
    String str3;
    for (String str1 = null; ; str1 = str3)
    {
      return str1;
      String str2 = String.valueOf(getCommonURL(NetworkSettings.getroute_method, paramString));
      localStringBuilder = new StringBuilder(str2);
      str3 = paramDirectionRequest.completeGetTaxiRouteURL();
    }
  }

  public static String getTaxiURL(String paramString1, String paramString2)
  {
    if (paramString1 == null);
    StringBuilder localStringBuilder3;
    String str5;
    for (String str1 = null; ; str1 = str5 + "taxi_types=taxi,car_service")
    {
      return str1;
      String str2 = String.valueOf(getCommonURL(NetworkSettings.gettaxi_method, paramString2));
      StringBuilder localStringBuilder1 = new StringBuilder(str2);
      String str3 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append("routeId");
      String str4 = NetworkSettings.equal;
      localStringBuilder3 = localStringBuilder2.append(str4).append(paramString1);
      str5 = NetworkSettings.ampersand;
    }
  }

  private static String getYestURL(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = NetworkSettings.yext_url;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = paramString3;
    arrayOfObject[3] = paramString4;
    return String.format(str, arrayOfObject);
  }

  public static String updateMapURL(MapUpdateRequest paramMapUpdateRequest, String paramString)
  {
    if (paramMapUpdateRequest == null);
    StringBuilder localStringBuilder;
    String str3;
    for (String str1 = null; ; str1 = str3)
    {
      return str1;
      String str2 = String.valueOf(getCommonURL(NetworkSettings.updatemap_method, paramString));
      localStringBuilder = new StringBuilder(str2);
      str3 = paramMapUpdateRequest.completeMapReqURL();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.network.URLFactoryBuilder
 * JD-Core Version:    0.6.2
 */