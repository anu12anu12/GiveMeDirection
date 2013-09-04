package com.hopstop.ClientModel.xml;

import android.view.LayoutInflater;
import com.hopstop.ClientModel.Address;
import com.hopstop.ClientModel.DirectionResponse;
import com.hopstop.ClientModel.HopStopMap;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetDirectionHandler extends DefaultHandler
{
  private int EXACT_ADDRESS = 4;
  private int EXTRA_ADDRESS = 3;
  private int MAP_MODE = 1;
  private int NORMAL_MODE = 0;
  private int ROUTE_INFO_MODE = 2;
  private DirectionResponse _dResponse;
  private HopStopMap _map;
  private MapsSet _mapsSet = null;
  private int _mode = -1;
  private int address1Exact;
  private int address1OneLoc;
  private int address2Exact;
  private int address2OneLoc;
  private int addressType;
  private StringBuffer buff = null;
  private boolean buffering = false;
  private Address end_addr;
  private ArrayList<Address> first;
  private LayoutInflater inflater;
  private MapInfoHolder mView;
  private String responseStatus = null;
  private int resultCode = -1;
  private String resultString = "Failed";
  private ArrayList<Address> second;
  private Address start_addr;
  private boolean taxi_mode;
  private String urlString;
  private int viewWidth;

  public GetDirectionHandler(LayoutInflater paramLayoutInflater, int paramInt, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    this.first = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.second = localArrayList2;
    this.addressType = 0;
    this.taxi_mode = false;
    this.address1Exact = 1;
    this.address2Exact = 1;
    this.address1OneLoc = 1;
    this.address2OneLoc = 1;
    this.viewWidth = paramInt;
    this.inflater = paramLayoutInflater;
    this.urlString = paramString;
  }

  private void parseEndExactAddress(String paramString)
  {
    if (paramString.equals("Address1FoundExact"))
    {
      this.buffering = false;
      int i = Integer.parseInt(this.buff.toString());
      this.address1Exact = i;
      return;
    }
    if (paramString.equals("Address1OneLocation"))
    {
      this.buffering = false;
      int j = Integer.parseInt(this.buff.toString());
      setAddress1OneLoc(j);
      return;
    }
    if (paramString.equals("Address2FoundExact"))
    {
      this.buffering = false;
      int k = Integer.parseInt(this.buff.toString());
      this.address2Exact = k;
      return;
    }
    if (!paramString.equals("Address2OneLocation"))
      return;
    this.buffering = false;
    int m = Integer.parseInt(this.buff.toString());
    setAddress2OneLoc(m);
  }

  private void parseEndExtraAddress(String paramString)
  {
    if (paramString.equals("Title"))
    {
      this.buffering = false;
      if (this.addressType == 1)
      {
        Address localAddress1 = this.start_addr;
        String str1 = this.buff.toString();
        localAddress1.setAddress(str1);
        return;
      }
      if (this.addressType != 2)
        return;
      Address localAddress2 = this.end_addr;
      String str2 = this.buff.toString();
      localAddress2.setAddress(str2);
      return;
    }
    if (paramString.equals("AddressId"))
    {
      this.buffering = false;
      int i = Integer.parseInt(this.buff.toString());
      this.addressType = i;
      return;
    }
    if (paramString.equals("X"))
    {
      if (this.start_addr == null)
      {
        Address localAddress3 = new Address();
        this.start_addr = localAddress3;
      }
      if (this.end_addr == null)
      {
        Address localAddress4 = new Address();
        this.end_addr = localAddress4;
      }
      this.buffering = false;
      if (this.addressType == 1)
      {
        Address localAddress5 = this.start_addr;
        double d1 = Double.parseDouble(this.buff.toString());
        localAddress5.setX(d1);
        return;
      }
      if (this.addressType != 2)
        return;
      Address localAddress6 = this.end_addr;
      double d2 = Double.parseDouble(this.buff.toString());
      localAddress6.setX(d2);
      return;
    }
    if (!paramString.equals("Y"))
      return;
    this.buffering = false;
    if (this.addressType == 1)
    {
      Address localAddress7 = this.start_addr;
      double d3 = Double.parseDouble(this.buff.toString());
      localAddress7.setY(d3);
      ArrayList localArrayList1 = this.first;
      Address localAddress8 = this.start_addr;
      localArrayList1.add(0, localAddress8);
      return;
    }
    if (this.addressType != 2)
      return;
    Address localAddress9 = this.end_addr;
    double d4 = Double.parseDouble(this.buff.toString());
    localAddress9.setY(d4);
    ArrayList localArrayList2 = this.second;
    Address localAddress10 = this.end_addr;
    localArrayList2.add(0, localAddress10);
  }

  private void parseEndMap(String paramString)
  {
    if (paramString.equals("item"))
    {
      MapsSet localMapsSet1 = this._mapsSet;
      HopStopMap localHopStopMap1 = this._map;
      localMapsSet1.add(localHopStopMap1);
      return;
    }
    if (paramString.equals("Height"))
    {
      this.buffering = false;
      HopStopMap localHopStopMap2 = this._map;
      int i = Integer.parseInt(this.buff.toString());
      localHopStopMap2.setHeight(i);
      return;
    }
    if (paramString.equals("Id"))
    {
      this.buffering = false;
      HopStopMap localHopStopMap3 = this._map;
      String str1 = this.buff.toString();
      localHopStopMap3.setId(str1);
      return;
    }
    if (paramString.equals("Number"))
    {
      this.buffering = false;
      HopStopMap localHopStopMap4 = this._map;
      int j = Integer.parseInt(this.buff.toString());
      localHopStopMap4.setNumber(j);
      return;
    }
    if (paramString.equals("Title"))
    {
      this.buffering = false;
      HopStopMap localHopStopMap5 = this._map;
      String str2 = this.buff.toString();
      localHopStopMap5.setTitle(str2);
      return;
    }
    if (paramString.equals("URL"))
    {
      this.buffering = false;
      MapInfoHolder localMapInfoHolder1 = this.mView;
      String str3 = this.buff.toString();
      localMapInfoHolder1.setUrl(str3);
      MapInfoHolder localMapInfoHolder2 = this.mView;
      String str4 = this._map.getTitle();
      localMapInfoHolder2.setInfo(str4);
      HopStopMap localHopStopMap6 = this._map;
      String str5 = this.buff.toString();
      localHopStopMap6.setUrl(str5);
      MapsSet localMapsSet2 = this._mapsSet;
      MapInfoHolder localMapInfoHolder3 = this.mView;
      localMapsSet2.add(localMapInfoHolder3);
      return;
    }
    if (!paramString.equals("Width"))
      return;
    this.buffering = false;
    HopStopMap localHopStopMap7 = this._map;
    int k = Integer.parseInt(this.buff.toString());
    localHopStopMap7.setWidth(k);
  }

  private void parseEndRouteInfo(String paramString)
  {
    if (paramString.equals("Address1"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse1 = this._dResponse;
      String str1 = this.buff.toString();
      localDirectionResponse1.setAddress1(str1);
    }
    while (true)
    {
      if (!paramString.equals("Id"))
        return;
      this.buffering = false;
      DirectionResponse localDirectionResponse2 = this._dResponse;
      String str2 = this.buff.toString();
      localDirectionResponse2.setRouteId(str2);
      return;
      if (paramString.equals("Address2"))
      {
        this.buffering = false;
        DirectionResponse localDirectionResponse3 = this._dResponse;
        String str3 = this.buff.toString();
        localDirectionResponse3.setAddress2(str3);
      }
    }
  }

  private void parseStartExactAddress(String paramString)
  {
    if (paramString.equals("Address1FoundExact"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Address1OneLocation"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Address2FoundExact"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (!paramString.equals("Address2OneLocation"))
      return;
    StringBuffer localStringBuffer4 = new StringBuffer("");
    this.buff = localStringBuffer4;
    this.buffering = true;
  }

  private void parseStartExtraAddress(String paramString)
  {
    if (paramString.equals("Title"))
    {
      Address localAddress1 = new Address();
      this.start_addr = localAddress1;
      Address localAddress2 = new Address();
      this.end_addr = localAddress2;
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      return;
    }
    if (paramString.equals("AddressId"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString.equals("X"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (!paramString.equals("Y"))
      return;
    StringBuffer localStringBuffer4 = new StringBuffer("");
    this.buff = localStringBuffer4;
    this.buffering = true;
  }

  private void parseStartMap(String paramString)
  {
    if (paramString.equals("item"))
    {
      HopStopMap localHopStopMap = new HopStopMap();
      this._map = localHopStopMap;
      MapInfoHolder localMapInfoHolder = new MapInfoHolder();
      this.mView = localMapInfoHolder;
      return;
    }
    if (paramString.equals("Height"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Id"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Number"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Title"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    if (paramString.equals("URL"))
    {
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
    }
    if (!paramString.equals("Width"))
      return;
    StringBuffer localStringBuffer6 = new StringBuffer("");
    this.buff = localStringBuffer6;
    this.buffering = true;
  }

  private void parseStartRouteInfo(String paramString)
  {
    if (paramString.equals("ABDistance"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Address1"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Address2"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (paramString.equals("City"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    if (paramString.equals("City1"))
    {
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
    }
    if (paramString.equals("City1Name"))
    {
      StringBuffer localStringBuffer6 = new StringBuffer("");
      this.buff = localStringBuffer6;
      this.buffering = true;
      return;
    }
    if (paramString.equals("City2"))
    {
      StringBuffer localStringBuffer7 = new StringBuffer("");
      this.buff = localStringBuffer7;
      this.buffering = true;
      return;
    }
    if (paramString.equals("City2Name"))
    {
      StringBuffer localStringBuffer8 = new StringBuffer("");
      this.buff = localStringBuffer8;
      this.buffering = true;
      return;
    }
    if (paramString.equals("CityName"))
    {
      StringBuffer localStringBuffer9 = new StringBuffer("");
      this.buff = localStringBuffer9;
      this.buffering = true;
      return;
    }
    if (paramString.equals("County1"))
    {
      StringBuffer localStringBuffer10 = new StringBuffer("");
      this.buff = localStringBuffer10;
      this.buffering = true;
      return;
    }
    if (paramString.equals("County1Name"))
    {
      StringBuffer localStringBuffer11 = new StringBuffer("");
      this.buff = localStringBuffer11;
      this.buffering = true;
      return;
    }
    if (paramString.equals("County2"))
    {
      StringBuffer localStringBuffer12 = new StringBuffer("");
      this.buff = localStringBuffer12;
      this.buffering = true;
      return;
    }
    if (paramString.equals("County2Name"))
    {
      StringBuffer localStringBuffer13 = new StringBuffer("");
      this.buff = localStringBuffer13;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Day"))
    {
      StringBuffer localStringBuffer14 = new StringBuffer("");
      this.buff = localStringBuffer14;
      this.buffering = true;
      return;
    }
    if (paramString.equals("EnableDisabledLinks"))
    {
      StringBuffer localStringBuffer15 = new StringBuffer("");
      this.buff = localStringBuffer15;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Id"))
    {
      StringBuffer localStringBuffer16 = new StringBuffer("");
      this.buff = localStringBuffer16;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Language"))
    {
      StringBuffer localStringBuffer17 = new StringBuffer("");
      this.buff = localStringBuffer17;
      this.buffering = true;
      return;
    }
    if (paramString.equals("MaxBuses"))
    {
      StringBuffer localStringBuffer18 = new StringBuffer("");
      this.buff = localStringBuffer18;
      this.buffering = true;
      return;
    }
    if (paramString.equals("MaxTrains"))
    {
      StringBuffer localStringBuffer19 = new StringBuffer("");
      this.buff = localStringBuffer19;
      this.buffering = true;
      return;
    }
    if (paramString.equals("MaxWalked"))
    {
      StringBuffer localStringBuffer20 = new StringBuffer("");
      this.buff = localStringBuffer20;
      this.buffering = true;
      return;
    }
    if (paramString.equals("MaxWalkingTripShown"))
    {
      StringBuffer localStringBuffer21 = new StringBuffer("");
      this.buff = localStringBuffer21;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Mode"))
    {
      StringBuffer localStringBuffer22 = new StringBuffer("");
      this.buff = localStringBuffer22;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Route"))
    {
      StringBuffer localStringBuffer23 = new StringBuffer("");
      this.buff = localStringBuffer23;
      this.buffering = true;
      return;
    }
    if (paramString.equals("SegmentsLen"))
    {
      StringBuffer localStringBuffer24 = new StringBuffer("");
      this.buff = localStringBuffer24;
      this.buffering = true;
      return;
    }
    if (paramString.equals("SimpleWalking"))
    {
      StringBuffer localStringBuffer25 = new StringBuffer("");
      this.buff = localStringBuffer25;
      this.buffering = true;
      return;
    }
    if (paramString.equals("SimplifiedDirs"))
    {
      StringBuffer localStringBuffer26 = new StringBuffer("");
      this.buff = localStringBuffer26;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Time"))
    {
      StringBuffer localStringBuffer27 = new StringBuffer("");
      this.buff = localStringBuffer27;
      this.buffering = true;
      return;
    }
    if (paramString.equals("TotalTime"))
    {
      StringBuffer localStringBuffer28 = new StringBuffer("");
      this.buff = localStringBuffer28;
      this.buffering = true;
      return;
    }
    if (paramString.equals("TotalTimeVerb"))
    {
      StringBuffer localStringBuffer29 = new StringBuffer("");
      this.buff = localStringBuffer29;
      this.buffering = true;
      return;
    }
    if (paramString.equals("TransferPriority"))
    {
      StringBuffer localStringBuffer30 = new StringBuffer("");
      this.buff = localStringBuffer30;
      this.buffering = true;
      return;
    }
    if (paramString.equals("X1"))
    {
      StringBuffer localStringBuffer31 = new StringBuffer("");
      this.buff = localStringBuffer31;
      this.buffering = true;
      return;
    }
    if (paramString.equals("X2"))
    {
      StringBuffer localStringBuffer32 = new StringBuffer("");
      this.buff = localStringBuffer32;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Y1"))
    {
      StringBuffer localStringBuffer33 = new StringBuffer("");
      this.buff = localStringBuffer33;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Y2"))
    {
      StringBuffer localStringBuffer34 = new StringBuffer("");
      this.buff = localStringBuffer34;
      this.buffering = true;
      return;
    }
    if (paramString.equals("Zip1"))
    {
      StringBuffer localStringBuffer35 = new StringBuffer("");
      this.buff = localStringBuffer35;
      this.buffering = true;
      return;
    }
    if (!paramString.equals("Zip2"))
      return;
    StringBuffer localStringBuffer36 = new StringBuffer("");
    this.buff = localStringBuffer36;
    this.buffering = true;
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
    if (paramString2.equals("FaultCode"))
    {
      this.buffering = false;
      int j = Integer.parseInt(this.buff.toString());
      this.resultCode = j;
      return;
    }
    if (paramString2.equals("FaultString"))
    {
      this.buffering = false;
      String str4 = this.buff.toString();
      this.resultString = str4;
      return;
    }
    if (paramString2.equals("Maps"))
      return;
    if (paramString2.equals("RouteInfo"))
      return;
    int k = this._mode;
    int m = this.MAP_MODE;
    if (k != m)
    {
      parseEndMap(paramString2);
      return;
    }
    int n = this._mode;
    int i1 = this.ROUTE_INFO_MODE;
    if (n != i1)
    {
      parseEndRouteInfo(paramString2);
      return;
    }
    int i2 = this._mode;
    int i3 = this.EXTRA_ADDRESS;
    if (i2 != i3)
    {
      parseEndExtraAddress(paramString2);
      return;
    }
    int i4 = this._mode;
    int i5 = this.EXACT_ADDRESS;
    if (i4 != i5)
      return;
    parseEndExactAddress(paramString2);
  }

  public int getAddress1Exact()
  {
    return this.address1Exact;
  }

  public int getAddress1OneLoc()
  {
    return this.address1OneLoc;
  }

  public int getAddress2Exact()
  {
    return this.address2Exact;
  }

  public int getAddress2OneLoc()
  {
    return this.address2OneLoc;
  }

  public DirectionResponse getDirectionResponse()
  {
    return this._dResponse;
  }

  public ArrayList<Address> getFirstExtraAddresses()
  {
    return this.first;
  }

  public MapsSet getMapsSet()
  {
    return this._mapsSet;
  }

  public int getResultCode()
  {
    return this.resultCode;
  }

  public String getResultString()
  {
    return this.resultString;
  }

  public ArrayList<Address> getSecondExtraAddresses()
  {
    return this.second;
  }

  public void setAddress1Exact(int paramInt)
  {
    this.address1Exact = paramInt;
  }

  public void setAddress1OneLoc(int paramInt)
  {
    this.address1OneLoc = paramInt;
  }

  public void setAddress2Exact(int paramInt)
  {
    this.address2Exact = paramInt;
  }

  public void setAddress2OneLoc(int paramInt)
  {
    this.address2OneLoc = paramInt;
  }

  public void setTaxiMode(boolean paramBoolean)
  {
    this.taxi_mode = paramBoolean;
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
      return;
    }
    if (paramString2.equals("ResponseStatus"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("FaultCode"))
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
    if (paramString2.equals("Maps"))
    {
      MapsSet localMapsSet = new MapsSet();
      this._mapsSet = localMapsSet;
      int j = this.MAP_MODE;
      this._mode = j;
      return;
    }
    if (paramString2.equals("Thumbnails"))
    {
      int k = this.EXTRA_ADDRESS;
      this._mode = k;
      return;
    }
    if ((paramString2.equals("RouteInfo")) && (this.resultCode == 200))
    {
      String str = this.urlString;
      DirectionResponse localDirectionResponse = new DirectionResponse(str);
      this._dResponse = localDirectionResponse;
      int m = this.ROUTE_INFO_MODE;
      this._mode = m;
      return;
    }
    if ((paramString2.equals("RouteInfo")) && (this.resultCode == 201))
    {
      int n = this.EXACT_ADDRESS;
      this._mode = n;
      return;
    }
    int i1 = this._mode;
    int i2 = this.MAP_MODE;
    if (i1 != i2)
    {
      parseStartMap(paramString2);
      return;
    }
    int i3 = this._mode;
    int i4 = this.ROUTE_INFO_MODE;
    if (i3 != i4)
    {
      parseStartRouteInfo(paramString2);
      return;
    }
    int i5 = this._mode;
    int i6 = this.EXTRA_ADDRESS;
    if (i5 != i6)
    {
      parseStartExtraAddress(paramString2);
      return;
    }
    int i7 = this._mode;
    int i8 = this.EXACT_ADDRESS;
    if (i7 != i8)
      return;
    parseStartExactAddress(paramString2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetDirectionHandler
 * JD-Core Version:    0.6.2
 */