package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.LonLonToCityResponse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetLonLanToCityRequestHandler extends DefaultHandler
{
  private LonLonToCityResponse _dResponse = null;
  private StringBuffer buff = null;
  private boolean buffering = false;

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!this.buffering)
      return;
    StringBuffer localStringBuffer = this.buff.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void endDocument()
    throws SAXException
  {
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if (paramString2.equals("HopStopResponse"))
    {
      this.buffering = false;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      this.buffering = false;
      LonLonToCityResponse localLonLonToCityResponse1 = this._dResponse;
      int i = Integer.parseInt(this.buff.toString());
      localLonLonToCityResponse1.setResultCode(i);
      return;
    }
    if (paramString2.equals("City"))
    {
      this.buffering = false;
      LonLonToCityResponse localLonLonToCityResponse2 = this._dResponse;
      String str1 = this.buff.toString();
      localLonLonToCityResponse2.setCity(str1);
      return;
    }
    if (paramString2.equals("CityId"))
    {
      this.buffering = false;
      LonLonToCityResponse localLonLonToCityResponse3 = this._dResponse;
      String str2 = this.buff.toString();
      localLonLonToCityResponse3.setCityId(str2);
      return;
    }
    if (!paramString2.equals("CityId"))
      return;
    this.buffering = false;
    LonLonToCityResponse localLonLonToCityResponse4 = this._dResponse;
    String str3 = this.buff.toString();
    localLonLonToCityResponse4.setResultString(str3);
  }

  public LonLonToCityResponse getLonLonToCityResponse()
  {
    return this._dResponse;
  }

  public void startDocument()
    throws SAXException
  {
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if (paramString2.equals("HopStopResponse"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      LonLonToCityResponse localLonLonToCityResponse = new LonLonToCityResponse();
      this._dResponse = localLonLonToCityResponse;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("City"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (!paramString2.equals("CityId"))
      return;
    StringBuffer localStringBuffer4 = new StringBuffer("");
    this.buff = localStringBuffer4;
    this.buffering = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetLonLanToCityRequestHandler
 * JD-Core Version:    0.6.2
 */