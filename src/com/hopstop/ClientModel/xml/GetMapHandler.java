package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.Address;
import com.hopstop.ClientModel.MapResponse;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetMapHandler extends DefaultHandler
{
  private int CAN_PARSE_SINGLE_ADDRESS = 3;
  private int EXTRA_ADDRESS = 2;
  private int NORMAL_MODE = 0;
  private int SINGLE_ADDRESS = 1;
  private MapResponse _mResponse;
  private int _mode = -1;
  private Address addr;
  private ArrayList<Address> addresses;
  private StringBuffer buff = null;
  private boolean buffering = false;
  private String responseStatus = null;
  private int resultCode = -1;
  private String resultString = "Failed";

  public GetMapHandler()
  {
    ArrayList localArrayList = new ArrayList();
    this.addresses = localArrayList;
  }

  private void parseEndExtraAddress(String paramString)
  {
    boolean bool = paramString.equals("item");
    if (paramString.equals("Title"))
    {
      this.buffering = false;
      Address localAddress1 = this.addr;
      String str = this.buff.toString();
      localAddress1.setAddress(str);
    }
    if (paramString.equals("X"))
    {
      this.buffering = false;
      Address localAddress2 = this.addr;
      double d1 = Double.parseDouble(this.buff.toString());
      localAddress2.setX(d1);
    }
    if (!paramString.equals("Y"))
      return;
    this.buffering = false;
    Address localAddress3 = this.addr;
    double d2 = Double.parseDouble(this.buff.toString());
    localAddress3.setY(d2);
    ArrayList localArrayList = this.addresses;
    Address localAddress4 = this.addr;
    localArrayList.add(0, localAddress4);
  }

  private void parseEndMap(String paramString)
  {
    if (paramString.equals("Address"))
    {
      this.buffering = false;
      MapResponse localMapResponse1 = this._mResponse;
      String str1 = this.buff.toString();
      localMapResponse1.setAddress(str1);
    }
    if (paramString.equals("City"))
    {
      this.buffering = false;
      MapResponse localMapResponse2 = this._mResponse;
      String str2 = this.buff.toString();
      localMapResponse2.setCity(str2);
    }
    if (paramString.equals("Height"))
    {
      this.buffering = false;
      MapResponse localMapResponse3 = this._mResponse;
      int i = Integer.parseInt(this.buff.toString());
      localMapResponse3.setHeight(i);
    }
    while (true)
    {
      if (paramString.equals("X"))
      {
        this.buffering = false;
        MapResponse localMapResponse4 = this._mResponse;
        double d1 = Double.parseDouble(this.buff.toString());
        localMapResponse4.setX(d1);
      }
      if (!paramString.equals("Y"))
        return;
      this.buffering = false;
      MapResponse localMapResponse5 = this._mResponse;
      double d2 = Double.parseDouble(this.buff.toString());
      localMapResponse5.setY(d2);
      return;
      if (paramString.equals("Id"))
      {
        this.buffering = false;
        MapResponse localMapResponse6 = this._mResponse;
        String str3 = this.buff.toString();
        localMapResponse6.setId(str3);
      }
      else if (paramString.equals("Number"))
      {
        this.buffering = false;
        MapResponse localMapResponse7 = this._mResponse;
        int j = Integer.parseInt(this.buff.toString());
        localMapResponse7.setNumber(j);
      }
      else if (paramString.equals("Title"))
      {
        this.buffering = false;
        MapResponse localMapResponse8 = this._mResponse;
        String str4 = this.buff.toString();
        localMapResponse8.setTitle(str4);
      }
      else if (paramString.equals("URL"))
      {
        this.buffering = false;
        MapResponse localMapResponse9 = this._mResponse;
        String str5 = this.buff.toString();
        localMapResponse9.setUrl(str5);
      }
      else if (paramString.equals("Width"))
      {
        this.buffering = false;
        MapResponse localMapResponse10 = this._mResponse;
        int k = Integer.parseInt(this.buff.toString());
        localMapResponse10.setWidth(k);
      }
      else if (paramString.equals("Zip"))
      {
        this.buffering = false;
        MapResponse localMapResponse11 = this._mResponse;
        String str6 = this.buff.toString();
        localMapResponse11.setZip(str6);
      }
    }
  }

  private void parseStartExtraAddress(String paramString)
  {
    boolean bool = paramString.equals("item");
    if (paramString.equals("Title"))
    {
      Address localAddress = new Address();
      this.addr = localAddress;
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
    }
    if (paramString.equals("X"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
    }
    if (!paramString.equals("Y"))
      return;
    StringBuffer localStringBuffer3 = new StringBuffer("");
    this.buff = localStringBuffer3;
    this.buffering = true;
  }

  private void parseStartMap(String paramString)
  {
    if (paramString.equals("Address"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
    }
    if (paramString.equals("City"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
    }
    if (paramString.equals("Height"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
    }
    while (true)
    {
      if (paramString.equals("X"))
      {
        StringBuffer localStringBuffer4 = new StringBuffer("");
        this.buff = localStringBuffer4;
        this.buffering = true;
      }
      if (!paramString.equals("Y"))
        return;
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
      if (paramString.equals("Id"))
      {
        StringBuffer localStringBuffer6 = new StringBuffer("");
        this.buff = localStringBuffer6;
        this.buffering = true;
      }
      else if (paramString.equals("Number"))
      {
        StringBuffer localStringBuffer7 = new StringBuffer("");
        this.buff = localStringBuffer7;
        this.buffering = true;
      }
      else if (paramString.equals("Title"))
      {
        StringBuffer localStringBuffer8 = new StringBuffer("");
        this.buff = localStringBuffer8;
        this.buffering = true;
      }
      else if (paramString.equals("URL"))
      {
        StringBuffer localStringBuffer9 = new StringBuffer("");
        this.buff = localStringBuffer9;
        this.buffering = true;
      }
      else if (paramString.equals("Width"))
      {
        StringBuffer localStringBuffer10 = new StringBuffer("");
        this.buff = localStringBuffer10;
        this.buffering = true;
      }
      else if (paramString.equals("Zip"))
      {
        StringBuffer localStringBuffer11 = new StringBuffer("");
        this.buff = localStringBuffer11;
        this.buffering = true;
      }
    }
  }

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
    if (paramString2.equals("Disclaimer"))
    {
      this.buffering = false;
      return;
    }
    if (paramString2.equals("ResponseStatus"))
    {
      this.buffering = false;
      String str2 = this.buff.toString();
      this.responseStatus = str2;
      return;
    }
    if (paramString2.equals("FaultCode"))
    {
      this.buffering = false;
      int i = Integer.parseInt(this.buff.toString());
      this.resultCode = i;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      this.buffering = false;
      int j = Integer.parseInt(this.buff.toString());
      this.resultCode = j;
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      this.buffering = false;
      String str3 = this.buff.toString();
      this.resultString = str3;
      return;
    }
    if (paramString2.equals("FaultString"))
    {
      this.buffering = false;
      String str4 = this.buff.toString();
      this.resultString = str4;
      return;
    }
    if (paramString2.equals("MapInfo"))
    {
      int k = this._mode;
      int m = this.SINGLE_ADDRESS;
      if (k != m)
        return;
    }
    if (paramString2.equals("Thumbnails"))
      return;
    int n = this._mode;
    int i1 = this.CAN_PARSE_SINGLE_ADDRESS;
    if (n != i1)
    {
      parseEndMap(paramString2);
      return;
    }
    int i2 = this._mode;
    int i3 = this.EXTRA_ADDRESS;
    if (i2 != i3)
      return;
    parseEndExtraAddress(paramString2);
  }

  public ArrayList<Address> getExtraAddresses()
  {
    return this.addresses;
  }

  public MapResponse getMapResponse()
  {
    return this._mResponse;
  }

  public int getResultCode()
  {
    return this.resultCode;
  }

  public String getResultString()
  {
    return this.resultString;
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
      int i = this.NORMAL_MODE;
      this._mode = i;
      return;
    }
    if (paramString2.equals("Disclaimer"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      int j = this.SINGLE_ADDRESS;
      this._mode = j;
      return;
    }
    if (paramString2.equals("ResponseStatus"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("FaultCode"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      StringBuffer localStringBuffer6 = new StringBuffer("");
      this.buff = localStringBuffer6;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("FaultString"))
    {
      StringBuffer localStringBuffer7 = new StringBuffer("");
      this.buff = localStringBuffer7;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("MapInfo"))
    {
      int k = this._mode;
      int m = this.SINGLE_ADDRESS;
      if (k != m)
      {
        MapResponse localMapResponse = new MapResponse();
        this._mResponse = localMapResponse;
        int n = this.CAN_PARSE_SINGLE_ADDRESS;
        this._mode = n;
        return;
      }
    }
    if (paramString2.equals("Thumbnails"))
    {
      int i1 = this.EXTRA_ADDRESS;
      this._mode = i1;
      return;
    }
    int i2 = this._mode;
    int i3 = this.CAN_PARSE_SINGLE_ADDRESS;
    if (i2 != i3)
    {
      parseStartMap(paramString2);
      return;
    }
    int i4 = this._mode;
    int i5 = this.EXTRA_ADDRESS;
    if (i4 != i5)
      return;
    parseStartExtraAddress(paramString2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetMapHandler
 * JD-Core Version:    0.6.2
 */