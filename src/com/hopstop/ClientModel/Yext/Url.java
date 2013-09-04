package com.hopstop.ClientModel.Yext;

import java.io.Serializable;

public class Url
  implements Serializable
{
  private String _description;
  private String _displayUrl;
  private String _type;
  private String _url;

  public String getDescription()
  {
    return this._description;
  }

  public String getDisplayUrl()
  {
    return this._displayUrl;
  }

  public String getType()
  {
    return this._type;
  }

  public String getUrl()
  {
    return this._url;
  }

  public void setDescription(String paramString)
  {
    this._description = paramString;
  }

  public void setDisplayUrl(String paramString)
  {
    this._displayUrl = paramString;
  }

  public void setType(String paramString)
  {
    this._type = paramString;
  }

  public void setUrl(String paramString)
  {
    this._url = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.Url
 * JD-Core Version:    0.6.2
 */