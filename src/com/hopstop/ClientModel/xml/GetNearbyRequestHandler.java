package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.FineNearbyBusinessResponse;
import com.hopstop.network.NetworkSettings;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetNearbyRequestHandler extends DefaultHandler
{
  private FineNearbyBusinessResponse _dResponse = null;
  private boolean _hasURL = false;
  private boolean _isAddressComplete = false;
  private boolean _isCompanyName = false;
  private boolean _isDisplayPhone = false;
  private boolean _isPhoneNumber = false;
  private String _phoneKey = null;
  private boolean _specialOffer = false;
  private YextBusiness _yext = null;
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
    if (paramString2.equals("listings"))
    {
      this.buffering = false;
      if (this._dResponse.getYextBussiness().size() == 0)
      {
        FineNearbyBusinessResponse localFineNearbyBusinessResponse1 = this._dResponse;
        int i = NetworkSettings.FAIL_GET_NEARBY_BUSINESS;
        localFineNearbyBusinessResponse1.setResult(i);
        return;
      }
      FineNearbyBusinessResponse localFineNearbyBusinessResponse2 = this._dResponse;
      int j = NetworkSettings.SUCCESS_GET_NEARBY_BUSINESS;
      localFineNearbyBusinessResponse2.setResult(j);
      return;
    }
    if (paramString2.equals("number"))
    {
      if (this._isPhoneNumber)
      {
        this.buffering = false;
        YextBusiness localYextBusiness1 = this._yext;
        String str1 = this._phoneKey;
        String str2 = this.buff.toString();
        localYextBusiness1.addPhoneNumber(str1, str2);
        this._isPhoneNumber = false;
        return;
      }
      this._isPhoneNumber = true;
      return;
    }
    if (paramString2.equals("type"))
    {
      if (!this._isDisplayPhone)
        return;
      this.buffering = false;
      String str3 = this.buff.toString();
      this._phoneKey = str3;
      this._isDisplayPhone = false;
      return;
    }
    if (paramString2.equals("displayLatitude"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness2 = this._yext;
      String str4 = this.buff.toString();
      localYextBusiness2.setDisplayLatitude(str4);
      return;
    }
    if (paramString2.equals("displayLongitude"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness3 = this._yext;
      String str5 = this.buff.toString();
      localYextBusiness3.setDisplayLongitude(str5);
      return;
    }
    if (paramString2.equals("displayPhone"))
      return;
    if (paramString2.equals("visible"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness4 = this._yext;
      String str6 = this.buff.toString();
      localYextBusiness4.setVisible(str6);
      return;
    }
    if (paramString2.equals("postalCode"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness5 = this._yext;
      String str7 = this.buff.toString();
      localYextBusiness5.setPostalCode(str7);
      return;
    }
    if (paramString2.equals("state"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness6 = this._yext;
      String str8 = this.buff.toString();
      localYextBusiness6.setState(str8);
      return;
    }
    if (paramString2.equals("city"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness7 = this._yext;
      String str9 = this.buff.toString();
      localYextBusiness7.setCity(str9);
      return;
    }
    if (paramString2.equals("address2"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness8 = this._yext;
      String str10 = this.buff.toString();
      localYextBusiness8.setAddress2(str10);
      return;
    }
    if (paramString2.equals("address"))
    {
      if (this._isAddressComplete)
        return;
      this.buffering = false;
      YextBusiness localYextBusiness9 = this._yext;
      String str11 = this.buff.toString();
      localYextBusiness9.setAddress(str11);
      this._isAddressComplete = true;
      return;
    }
    if (paramString2.equals("displayAddress"))
    {
      this.buffering = false;
      YextBusiness localYextBusiness10 = this._yext;
      String str12 = this.buff.toString();
      localYextBusiness10.setDisplayAddress(str12);
      return;
    }
    if (paramString2.equals("name"))
    {
      if (!this._isCompanyName)
        return;
      this.buffering = false;
      YextBusiness localYextBusiness11 = this._yext;
      String str13 = this.buff.toString();
      localYextBusiness11.setName(str13);
      this._isCompanyName = false;
      return;
    }
    if (paramString2.equals("status"))
    {
      this.buffering = false;
      String str14 = this.buff.toString();
      YextBusiness localYextBusiness12 = new YextBusiness(str14);
      this._yext = localYextBusiness12;
      this._isAddressComplete = false;
      this._isCompanyName = true;
      return;
    }
    if (paramString2.equals("listing"))
    {
      this.buffering = false;
      FineNearbyBusinessResponse localFineNearbyBusinessResponse3 = this._dResponse;
      YextBusiness localYextBusiness13 = this._yext;
      localFineNearbyBusinessResponse3.addYextBusiness(localYextBusiness13);
      return;
    }
    if (paramString2.equals("message"))
    {
      if (!this._specialOffer)
        return;
      this.buffering = false;
      YextBusiness localYextBusiness14 = this._yext;
      String str15 = this.buff.toString();
      localYextBusiness14.setSpecialOffer(str15);
      return;
    }
    if (paramString2.equals("specialOffer"))
    {
      this.buffering = false;
      return;
    }
    if (paramString2.equals("url"))
    {
      if (!this._hasURL)
        return;
      YextBusiness localYextBusiness15 = this._yext;
      String str16 = this.buff.toString();
      localYextBusiness15.setURL(str16);
      this._hasURL = false;
      return;
    }
    if (paramString2.equals("urls"))
    {
      this.buffering = false;
      this._specialOffer = false;
      this._hasURL = false;
      return;
    }
    if (!paramString2.equals("yextId"))
      return;
    this.buffering = false;
    YextBusiness localYextBusiness16 = this._yext;
    String str17 = this.buff.toString();
    localYextBusiness16.set_yextId(str17);
  }

  public FineNearbyBusinessResponse getResponse()
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
    if (paramString2.equals("listings"))
    {
      FineNearbyBusinessResponse localFineNearbyBusinessResponse = new FineNearbyBusinessResponse();
      this._dResponse = localFineNearbyBusinessResponse;
    }
    while (true)
    {
      StringBuffer localStringBuffer = new StringBuffer("");
      this.buff = localStringBuffer;
      this.buffering = true;
      return;
      if (paramString2.equals("countryCode"))
      {
        this._isPhoneNumber = true;
      }
      else if (paramString2.equals("displayPhone"))
      {
        this._isDisplayPhone = true;
      }
      else if ((!paramString2.equals("address")) && (paramString2.equals("specialOffer")))
      {
        this._specialOffer = true;
        this._hasURL = true;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetNearbyRequestHandler
 * JD-Core Version:    0.6.2
 */