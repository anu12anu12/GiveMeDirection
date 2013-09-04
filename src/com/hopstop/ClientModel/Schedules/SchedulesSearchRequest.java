package com.hopstop.ClientModel.Schedules;

import android.net.Uri;
import com.hopstop.network.NetworkSettings;

public class SchedulesSearchRequest
{
  private static final int aheadPeriod = 10800;
  private static final String aheadPeriodKey = "aheadPeriod";
  private static final String arriveByKey = "arriveBy";
  private static final String dayKey = "day";
  private static final String endStationKey = "endStationId";
  private static final int pastPeriod = 0;
  private static final String pastPeriodKey = "pastPeriod";
  private static final int rowsPerPage = 50;
  private static final String rowsPerPageKey = "rowsPerPage";
  private static final String startStationKey = "startStationId";
  private static final String stationGroupKey = "stationGroupId";
  private static final String timeKey = "time";
  private boolean arriveBy;
  private Day day;
  private String endStation;
  private String startStation;
  private String stationGroup;
  private int time;

  public SchedulesSearchRequest(String paramString1, String paramString2, String paramString3, Day paramDay, int paramInt, boolean paramBoolean)
  {
    this.stationGroup = paramString1;
    this.startStation = paramString2;
    this.endStation = paramString3;
    this.day = paramDay;
    this.time = paramInt;
    this.arriveBy = paramBoolean;
  }

  public Day getDay()
  {
    return this.day;
  }

  public String getEndStation()
  {
    return this.endStation;
  }

  public String getRequestUrl()
  {
    int i = 0;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("stationGroupId");
    String str1 = NetworkSettings.equal;
    StringBuilder localStringBuilder3 = localStringBuilder1.append(str1);
    String str2 = this.stationGroup;
    StringBuilder localStringBuilder4 = localStringBuilder1.append(str2);
    String str3 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder5 = localStringBuilder1.append(str3);
    StringBuilder localStringBuilder6 = localStringBuilder1.append("startStationId");
    String str4 = NetworkSettings.equal;
    StringBuilder localStringBuilder7 = localStringBuilder1.append(str4);
    String str5 = Uri.encode(this.startStation);
    StringBuilder localStringBuilder8 = localStringBuilder1.append(str5);
    String str6 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder9 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder10 = localStringBuilder1.append("endStationId");
    String str7 = NetworkSettings.equal;
    StringBuilder localStringBuilder11 = localStringBuilder1.append(str7);
    String str8 = Uri.encode(this.endStation);
    StringBuilder localStringBuilder12 = localStringBuilder1.append(str8);
    String str9 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder13 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder14 = localStringBuilder1.append("day");
    String str10 = NetworkSettings.equal;
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str10);
    int j = this.day.ordinal() + 1;
    StringBuilder localStringBuilder16 = localStringBuilder1.append(j);
    String str11 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str11);
    StringBuilder localStringBuilder18 = localStringBuilder1.append("time");
    String str12 = NetworkSettings.equal;
    StringBuilder localStringBuilder19 = localStringBuilder1.append(str12);
    int k = this.time;
    StringBuilder localStringBuilder20 = localStringBuilder1.append(k);
    String str13 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder21 = localStringBuilder1.append(str13);
    StringBuilder localStringBuilder22 = localStringBuilder1.append("pastPeriod");
    String str14 = NetworkSettings.equal;
    StringBuilder localStringBuilder23 = localStringBuilder1.append(str14);
    StringBuilder localStringBuilder24 = localStringBuilder1.append(i);
    String str15 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder25 = localStringBuilder1.append(str15);
    StringBuilder localStringBuilder26 = localStringBuilder1.append("aheadPeriod");
    String str16 = NetworkSettings.equal;
    StringBuilder localStringBuilder27 = localStringBuilder1.append(str16);
    StringBuilder localStringBuilder28 = localStringBuilder1.append(10800);
    String str17 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder29 = localStringBuilder1.append(str17);
    StringBuilder localStringBuilder30 = localStringBuilder1.append("rowsPerPage");
    String str18 = NetworkSettings.equal;
    StringBuilder localStringBuilder31 = localStringBuilder1.append(str18);
    StringBuilder localStringBuilder32 = localStringBuilder1.append(50);
    String str19 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder33 = localStringBuilder1.append(str19);
    StringBuilder localStringBuilder34 = localStringBuilder1.append("arriveBy");
    String str20 = NetworkSettings.equal;
    StringBuilder localStringBuilder35 = localStringBuilder1.append(str20);
    if (this.arriveBy)
      i = 1;
    StringBuilder localStringBuilder36 = localStringBuilder1.append(i);
    return localStringBuilder1.toString();
  }

  public String getStartStation()
  {
    return this.startStation;
  }

  public String getStationGroup()
  {
    return this.stationGroup;
  }

  public int getTime()
  {
    return this.time;
  }

  public void setDay(Day paramDay)
  {
    this.day = paramDay;
  }

  public void setEndStation(String paramString)
  {
    this.endStation = paramString;
  }

  public void setStartStation(String paramString)
  {
    this.startStation = paramString;
  }

  public void setStationGroup(String paramString)
  {
    this.stationGroup = paramString;
  }

  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.SchedulesSearchRequest
 * JD-Core Version:    0.6.2
 */