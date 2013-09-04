package com.hopstop.ClientModel.Schedules;

import android.net.Uri;
import com.hopstop.network.NetworkSettings;

public class SchedulesDetailsStopRequest
{
  private static final String _pageIdKey = "page";
  private static final String _rowIdKey = "rowId";
  private static final String _scheduleSessionIdKey = "scheduleSessionId";
  private String _pageId;
  private String _rowId;
  private String _scheduleSessionId;

  public SchedulesDetailsStopRequest(String paramString1, String paramString2, String paramString3)
  {
    this._scheduleSessionId = paramString1;
    this._rowId = paramString2;
    this._pageId = paramString3;
  }

  public String getRequestUrl()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("scheduleSessionId");
    String str1 = NetworkSettings.equal;
    StringBuilder localStringBuilder3 = localStringBuilder1.append(str1);
    String str2 = this._scheduleSessionId;
    StringBuilder localStringBuilder4 = localStringBuilder1.append(str2);
    String str3 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder5 = localStringBuilder1.append(str3);
    StringBuilder localStringBuilder6 = localStringBuilder1.append("rowId");
    String str4 = NetworkSettings.equal;
    StringBuilder localStringBuilder7 = localStringBuilder1.append(str4);
    String str5 = Uri.encode(this._rowId);
    StringBuilder localStringBuilder8 = localStringBuilder1.append(str5);
    String str6 = NetworkSettings.ampersand;
    StringBuilder localStringBuilder9 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder10 = localStringBuilder1.append("page");
    String str7 = NetworkSettings.equal;
    StringBuilder localStringBuilder11 = localStringBuilder1.append(str7);
    String str8 = Uri.encode(this._pageId);
    StringBuilder localStringBuilder12 = localStringBuilder1.append(str8);
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.SchedulesDetailsStopRequest
 * JD-Core Version:    0.6.2
 */