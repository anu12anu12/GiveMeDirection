package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="specialOffer", strict=false)
public class SpecialOffer
  implements Serializable
{

  @Element(name="message", required=false)
  private String _message;

  @Element(name="url", required=false)
  private String _url;

  public String getMessage()
  {
    return this._message;
  }

  public String getUrl()
  {
    return this._url;
  }

  public void setMessage(String paramString)
  {
    this._message = paramString;
  }

  public void setUrl(String paramString)
  {
    this._url = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.SpecialOffer
 * JD-Core Version:    0.6.2
 */