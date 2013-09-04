package com.hopstop.ClientModel.NearbyStations;

public class NearbyStationsRequest
{
  private int includeBus;
  private int includeSubway;
  private String latitude;
  private String longitude;
  private int maxStations;

  public NearbyStationsRequest(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.latitude = paramString1;
    this.longitude = paramString2;
    this.includeSubway = paramInt1;
    this.includeBus = paramInt2;
    this.maxStations = paramInt3;
  }

  public String getNearbyRequestURL()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("latitude=");
    String str1 = this.latitude;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("&longitude=");
    String str2 = this.longitude;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append("&entrances=1&exits=1&verbLocation=1").append("&includedInSubway=");
    int i = this.includeSubway;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(i).append("&includedInBus=");
    int j = this.includeBus;
    StringBuilder localStringBuilder5 = localStringBuilder4.append(j).append("&maxStations=");
    int k = this.maxStations;
    return k;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.NearbyStations.NearbyStationsRequest
 * JD-Core Version:    0.6.2
 */