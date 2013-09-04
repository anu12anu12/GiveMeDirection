package com.hopstop.ClientModel;

public class LonLonToCityResponse
{
  private String _city = null;
  private String _cityId = null;
  private int _resultCode = -1;
  private String _resultString = null;

  public String getCity()
  {
    return this._city;
  }

  public String getCityId()
  {
    return this._cityId;
  }

  public int getResultCode()
  {
    return this._resultCode;
  }

  public String getResultString()
  {
    return this._resultString;
  }

  public void setCity(String paramString)
  {
    this._city = paramString;
  }

  public void setCityId(String paramString)
  {
    this._cityId = paramString;
  }

  public void setResultCode(int paramInt)
  {
    this._resultCode = paramInt;
  }

  public void setResultString(String paramString)
  {
    this._resultString = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.LonLonToCityResponse
 * JD-Core Version:    0.6.2
 */