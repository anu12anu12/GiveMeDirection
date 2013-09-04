package com.hopstop.ClientModel.directions;

public class RouteIcons
{
  private int _lat;
  private int _lon;
  private String _name;
  private int _occurred = 0;
  private String _url = "http://www.hopstop.com/";

  public int getLat()
  {
    return this._lat;
  }

  public int getLon()
  {
    return this._lon;
  }

  public String getName()
  {
    return this._name;
  }

  public String getUrl()
  {
    return this._url;
  }

  public int isOccurred()
  {
    return this._occurred;
  }

  public void setLat(int paramInt)
  {
    this._lat = paramInt;
  }

  public void setLon(int paramInt)
  {
    this._lon = paramInt;
  }

  public void setName(String paramString)
  {
    this._name = paramString;
  }

  public void setOccurred(int paramInt)
  {
    this._occurred = paramInt;
  }

  public void setUrl(String paramString)
  {
    if (paramString == null)
      return;
    if ((paramString.equals("start")) || (paramString.equals("end")) || (paramString.startsWith("http")))
    {
      this._url = paramString;
      return;
    }
    if (paramString.equals("walk"))
    {
      String str1 = String.valueOf(this._url);
      String str2 = str1 + "i/" + paramString + ".gif";
      this._url = str2;
      return;
    }
    if (paramString.equals("ride"))
    {
      String str3 = String.valueOf(this._url);
      String str4 = str3 + "i/" + paramString + ".gif";
      this._url = str4;
      return;
    }
    String str5 = String.valueOf(this._url);
    String str6 = str5 + paramString + ".gif";
    this._url = str6;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.RouteIcons
 * JD-Core Version:    0.6.2
 */