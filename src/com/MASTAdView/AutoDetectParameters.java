package com.MASTAdView;

public class AutoDetectParameters
{
  private static AutoDetectParameters instance;
  private String carrier;
  private Integer connectionSpeed;
  private String country;
  private String latitude;
  private String longitude;
  private String ua;
  private String version;

  private AutoDetectParameters()
  {
  }

  public AutoDetectParameters(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Integer paramInteger)
  {
    this.latitude = paramString1;
    this.longitude = paramString2;
    this.carrier = paramString3;
    this.country = paramString4;
    this.ua = paramString5;
    this.version = paramString6;
    this.connectionSpeed = paramInteger;
  }

  /** @deprecated */
  public static AutoDetectParameters getInstance()
  {
    try
    {
      if (instance == null)
        instance = new AutoDetectParameters();
      AutoDetectParameters localAutoDetectParameters = instance;
      return localAutoDetectParameters;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getCarrier()
  {
    return this.carrier;
  }

  public Integer getConnectionSpeed()
  {
    return this.connectionSpeed;
  }

  public String getCountry()
  {
    return this.country;
  }

  public String getLatitude()
  {
    return this.latitude;
  }

  public String getLongitude()
  {
    return this.longitude;
  }

  public String getUa()
  {
    return this.ua;
  }

  public String getVersion()
  {
    return this.version;
  }

  public void setCarrier(String paramString)
  {
    this.carrier = paramString;
  }

  public void setConnectionSpeed(Integer paramInteger)
  {
    this.connectionSpeed = paramInteger;
  }

  public void setCountry(String paramString)
  {
    this.country = paramString;
  }

  public void setLatitude(String paramString)
  {
    this.latitude = paramString;
  }

  public void setLongitude(String paramString)
  {
    this.longitude = paramString;
  }

  public void setUa(String paramString)
  {
    this.ua = paramString;
  }

  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.AutoDetectParameters
 * JD-Core Version:    0.6.2
 */