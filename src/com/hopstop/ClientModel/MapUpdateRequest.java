package com.hopstop.ClientModel;

import com.hopstop.network.NetworkSettings;

public class MapUpdateRequest extends MapReqBase
{
  public static final int MOVE = 0;
  public static final int ZOOM = 1;
  private String mapID;
  private String move;
  private int type;
  private String url_mapID = "mapId";
  private String url_move = "move";
  private String url_zoom = "zoom";
  private String zoom;

  public MapUpdateRequest(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.mapID = paramString1;
    this.move = paramString2;
    this.zoom = paramString3;
    this.type = paramInt;
  }

  public String completeMapReqURL()
  {
    String str1;
    switch (this.type)
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
      String str3 = this.url_mapID;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str3);
      String str4 = NetworkSettings.equal;
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str4);
      String str5 = this.mapID;
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str5);
      String str6 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str6);
      String str7 = this.url_move;
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str7);
      String str8 = NetworkSettings.equal;
      StringBuilder localStringBuilder7 = localStringBuilder6.append(str8);
      String str9 = this.move;
      str1 = str9;
      continue;
      String str10 = String.valueOf(NetworkSettings.ampersand);
      StringBuilder localStringBuilder8 = new StringBuilder(str10);
      String str11 = this.url_mapID;
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str11);
      String str12 = NetworkSettings.equal;
      StringBuilder localStringBuilder10 = localStringBuilder9.append(str12);
      String str13 = this.mapID;
      StringBuilder localStringBuilder11 = localStringBuilder10.append(str13);
      String str14 = NetworkSettings.ampersand;
      StringBuilder localStringBuilder12 = localStringBuilder11.append(str14);
      String str15 = this.url_zoom;
      StringBuilder localStringBuilder13 = localStringBuilder12.append(str15);
      String str16 = NetworkSettings.equal;
      StringBuilder localStringBuilder14 = localStringBuilder13.append(str16);
      String str17 = this.zoom;
      str1 = str17;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.MapUpdateRequest
 * JD-Core Version:    0.6.2
 */