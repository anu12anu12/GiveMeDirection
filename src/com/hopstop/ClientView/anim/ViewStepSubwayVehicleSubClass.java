package com.hopstop.ClientView.anim;

import java.io.Serializable;

public class ViewStepSubwayVehicleSubClass
  implements Serializable
{
  private static final long serialVersionUID = -3451172334892479474L;
  private String _name;
  private String _status;
  private String _statusDescription;
  private String _timeOfDownload;
  private String _type;
  private String _url;
  private String _verbTime;

  public ViewStepSubwayVehicleSubClass(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this._name = paramString1;
    this._status = paramString2;
    this._type = paramString3;
    this._statusDescription = paramString4;
    this._url = paramString5;
    this._verbTime = paramString6;
    this._timeOfDownload = paramString7;
  }

  public String geType()
  {
    return this._type;
  }

  public String getName()
  {
    return this._name;
  }

  public String getStatusDescription()
  {
    return this._statusDescription;
  }

  public String getTimeOfDownload()
  {
    return this._timeOfDownload;
  }

  public String getURL()
  {
    return this._url;
  }

  public String getVerbTime()
  {
    return this._verbTime;
  }

  public String get_status()
  {
    return this._status;
  }

  public void seType(String paramString)
  {
    this._type = paramString;
  }

  public void setStatusDescription(String paramString)
  {
    this._statusDescription = paramString;
  }

  public void setTimeOfDownload(String paramString)
  {
    this._timeOfDownload = paramString;
  }

  public void setURL(String paramString)
  {
    this._url = paramString;
  }

  public void setVerbTime(String paramString)
  {
    this._verbTime = paramString;
  }

  public void set_status(String paramString)
  {
    this._status = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.anim.ViewStepSubwayVehicleSubClass
 * JD-Core Version:    0.6.2
 */