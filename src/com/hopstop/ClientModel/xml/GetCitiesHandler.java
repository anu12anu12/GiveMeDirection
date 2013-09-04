package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.HopStopCity;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetCitiesHandler extends DefaultHandler
{
  private CitiesSet _citiesSet = null;
  private StringBuffer buff = null;
  private boolean buffering = false;
  private HopStopCity city;
  private String responseStatus = null;
  private int resultCode = -1;
  private String resultString = "Failed";

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
      String str1 = this.buff.toString();
      return;
    }
    if (paramString2.equals("ResponseStatus"))
    {
      this.buffering = false;
      String str2 = this.buff.toString();
      this.responseStatus = str2;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      this.buffering = false;
      int i = Integer.parseInt(this.buff.toString());
      this.resultCode = i;
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      this.buffering = false;
      String str3 = this.buff.toString();
      this.resultString = str3;
      return;
    }
    if (paramString2.equals("Cities"))
      return;
    if (paramString2.equals("item"))
    {
      CitiesSet localCitiesSet = this._citiesSet;
      HopStopCity localHopStopCity1 = this.city;
      localCitiesSet.add(localHopStopCity1);
      return;
    }
    if (paramString2.equals("CellGateway"))
    {
      this.buffering = false;
      HopStopCity localHopStopCity2 = this.city;
      String str4 = this.buff.toString();
      localHopStopCity2.setCellGateway(str4);
      return;
    }
    if (paramString2.equals("DefaultCounty"))
    {
      this.buffering = false;
      String[] arrayOfString = this.buff.toString().split(",");
      this.city.setDefaultCounty(arrayOfString);
      return;
    }
    if (paramString2.equals("Id"))
    {
      this.buffering = false;
      HopStopCity localHopStopCity3 = this.city;
      String str5 = this.buff.toString();
      localHopStopCity3.setId(str5);
      return;
    }
    if (paramString2.equals("Name"))
    {
      this.buffering = false;
      HopStopCity localHopStopCity4 = this.city;
      String str6 = this.buff.toString();
      localHopStopCity4.setName(str6);
      return;
    }
    if (paramString2.equals("State"))
    {
      this.buffering = false;
      HopStopCity localHopStopCity5 = this.city;
      String str7 = this.buff.toString();
      localHopStopCity5.setState(str7);
      return;
    }
    if (!paramString2.equals("UsePlaces"))
      return;
    this.buffering = false;
    HopStopCity localHopStopCity6 = this.city;
    String str8 = this.buff.toString();
    localHopStopCity6.setUsePlaces(str8);
  }

  public CitiesSet getCitiesSet()
  {
    return this._citiesSet;
  }

  public boolean isSuccess()
  {
    if ((this.resultCode == 200) && (this.resultString.equals("Success.")));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void startDocument()
    throws SAXException
  {
    CitiesSet localCitiesSet = new CitiesSet();
    this._citiesSet = localCitiesSet;
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if (paramString2.equals("HopStopResponse"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResponseStatus"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Cities"))
      return;
    if (paramString2.equals("item"))
    {
      HopStopCity localHopStopCity = new HopStopCity();
      this.city = localHopStopCity;
      return;
    }
    if (paramString2.equals("CellGateway"))
    {
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("DefaultCounty"))
    {
      StringBuffer localStringBuffer6 = new StringBuffer("");
      this.buff = localStringBuffer6;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Id"))
    {
      StringBuffer localStringBuffer7 = new StringBuffer("");
      this.buff = localStringBuffer7;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Name"))
    {
      StringBuffer localStringBuffer8 = new StringBuffer("");
      this.buff = localStringBuffer8;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("State"))
    {
      StringBuffer localStringBuffer9 = new StringBuffer("");
      this.buff = localStringBuffer9;
      this.buffering = true;
      return;
    }
    if (!paramString2.equals("UsePlaces"))
      return;
    StringBuffer localStringBuffer10 = new StringBuffer("");
    this.buff = localStringBuffer10;
    this.buffering = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetCitiesHandler
 * JD-Core Version:    0.6.2
 */