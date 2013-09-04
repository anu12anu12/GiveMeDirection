package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.Address;
import com.hopstop.ClientModel.DirectionResponse;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepMap;
import com.hopstop.ClientModel.directions.ViewStepReverseNewSearch;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.DrawableManager;
import com.hopstop.network.NetworkSettings;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetDirectionRequestHandler extends DefaultHandler
{
  private int EXACT_ADDRESSES = 4;
  private int EXTRA_ADDRESSES = 3;
  private int MAP_MODE = 1;
  private int NORMAL_MODE = 0;
  private int ROUTE_INFO_MODE = 2;
  private DirectionResponse _dResponse;
  private int _mode = -1;
  private int address1Exact;
  private int address1OneLoc;
  private int address2Exact;
  private int address2OneLoc;
  private int addressType;
  private String arrivalTimeVerb;
  private StringBuffer buff = null;
  private boolean buffering = false;
  private String calories;
  private String co2;
  private String depatureTimeVerb;
  private Address end_addr;
  private ArrayList<Address> first;
  private String language;
  private int resultCode;
  private String resultString;
  private ArrayList<Address> second;
  private double segmentsLen;
  private Address start_addr;
  private boolean taxi_mode;
  private String urlString;
  private int viewWidth;
  private ViewStepMap vsm;
  private ArrayList<ViewStep> vsmList;
  private ViewStepAddress vst2;

  public GetDirectionRequestHandler()
  {
    int i = NetworkSettings.UNKNOWN_ERROR;
    this.resultCode = i;
    this.taxi_mode = false;
    this.vsmList = null;
    this.vsm = null;
    this.resultString = "Failed";
    this.segmentsLen = 0.0D;
    this.vst2 = null;
    this.addressType = 0;
    ArrayList localArrayList1 = new ArrayList();
    this.first = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.second = localArrayList2;
    this.address1Exact = 1;
    this.address2Exact = 1;
    this.address1OneLoc = 1;
    this.address2OneLoc = 1;
    ApplicationEngine.getDrawableManager().clearHashMap();
  }

  public GetDirectionRequestHandler(int paramInt, String paramString)
  {
    int i = NetworkSettings.UNKNOWN_ERROR;
    this.resultCode = i;
    this.taxi_mode = false;
    this.vsmList = null;
    this.vsm = null;
    this.resultString = "Failed";
    this.segmentsLen = 0.0D;
    this.vst2 = null;
    this.addressType = 0;
    ArrayList localArrayList1 = new ArrayList();
    this.first = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.second = localArrayList2;
    this.address1Exact = 1;
    this.address2Exact = 1;
    this.address1OneLoc = 1;
    this.address2OneLoc = 1;
    this.viewWidth = paramInt;
    this.urlString = paramString;
    DirectionResponse localDirectionResponse = new DirectionResponse(paramString);
    this._dResponse = localDirectionResponse;
    ApplicationEngine.getDrawableManager().clearHashMap();
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
      this.address1OneLoc = j;
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
    this.address2OneLoc = m;
  }

  private void parseEndExtraAddress(String paramString)
  {
    if (paramString.equals("item"))
    {
      if (this.addressType == 1)
      {
        ArrayList localArrayList1 = this.first;
        Address localAddress1 = this.start_addr;
        localArrayList1.add(0, localAddress1);
        return;
      }
      if (this.addressType != 2)
        return;
      ArrayList localArrayList2 = this.second;
      Address localAddress2 = this.end_addr;
      localArrayList2.add(0, localAddress2);
      return;
    }
    if (paramString.equals("Title"))
    {
      this.buffering = false;
      if (this.addressType == 1)
      {
        Address localAddress3 = this.start_addr;
        String str1 = this.buff.toString();
        localAddress3.setAddress(str1);
        return;
      }
      if (this.addressType != 2)
        return;
      Address localAddress4 = this.end_addr;
      String str2 = this.buff.toString();
      localAddress4.setAddress(str2);
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
        Address localAddress5 = new Address();
        this.start_addr = localAddress5;
      }
      if (this.end_addr == null)
      {
        Address localAddress6 = new Address();
        this.end_addr = localAddress6;
      }
      this.buffering = false;
      if (this.addressType == 1)
      {
        Address localAddress7 = this.start_addr;
        double d1 = Double.parseDouble(this.buff.toString());
        localAddress7.setX(d1);
        return;
      }
      if (this.addressType != 2)
        return;
      Address localAddress8 = this.end_addr;
      double d2 = Double.parseDouble(this.buff.toString());
      localAddress8.setX(d2);
      return;
    }
    if (paramString.equals("Y"))
    {
      this.buffering = false;
      if (this.addressType == 1)
      {
        Address localAddress9 = this.start_addr;
        double d3 = Double.parseDouble(this.buff.toString());
        localAddress9.setY(d3);
        return;
      }
      if (this.addressType != 2)
        return;
      Address localAddress10 = this.end_addr;
      double d4 = Double.parseDouble(this.buff.toString());
      localAddress10.setY(d4);
      return;
    }
    if (!paramString.equals("Id"))
      return;
    this.buffering = false;
    if (this.addressType == 1)
    {
      Address localAddress11 = this.start_addr;
      String str3 = this.buff.toString();
      localAddress11.setThumbnailId(str3);
      return;
    }
    if (this.addressType != 2)
      return;
    Address localAddress12 = this.end_addr;
    String str4 = this.buff.toString();
    localAddress12.setThumbnailId(str4);
  }

  private void parseEndMap(String paramString)
  {
    if (paramString.equals("item"))
      return;
    if (paramString.equals("Title"))
    {
      this.buffering = false;
      ViewStepMap localViewStepMap1 = this.vsm;
      String str1 = this.buff.toString();
      localViewStepMap1.setInfo(str1);
      return;
    }
    if (paramString.equals("URL"))
    {
      this.buffering = false;
      ViewStepMap localViewStepMap2 = this.vsm;
      String str2 = this.buff.toString();
      localViewStepMap2.setURL(str2, true);
      ArrayList localArrayList = this.vsmList;
      ViewStepMap localViewStepMap3 = this.vsm;
      boolean bool = localArrayList.add(localViewStepMap3);
      return;
    }
    if (!paramString.equals("Id"))
      return;
    this.buffering = false;
    ViewStepMap localViewStepMap4 = this.vsm;
    String str3 = this.buff.toString();
    localViewStepMap4.setId(str3);
  }

  private void parseEndRouteInfo(String paramString)
  {
    if (paramString.equals("RouteDimitare"))
      return;
    if (paramString.equals("ArriveTimeVerb"))
    {
      this.buffering = false;
      String str1 = this.buff.toString();
      this.arrivalTimeVerb = str1;
      return;
    }
    if (paramString.equals("DepartTimeVerb"))
    {
      this.buffering = false;
      String str2 = this.buff.toString();
      this.depatureTimeVerb = str2;
      return;
    }
    if (paramString.equals("Zip2"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse1 = this._dResponse;
      String str3 = this.buff.toString();
      localDirectionResponse1.setZip2(str3);
      ViewStepAddress localViewStepAddress1 = this.vst2;
      String str4 = this.buff.toString();
      localViewStepAddress1.setZip2(str4);
      return;
    }
    if (paramString.equals("Zip1"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse2 = this._dResponse;
      String str5 = this.buff.toString();
      localDirectionResponse2.setZip1(str5);
      return;
    }
    if (paramString.equals("EnableDisabledLinks"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse3 = this._dResponse;
      int i = Integer.parseInt(this.buff.toString());
      localDirectionResponse3.setEnableDisabledLinks(i);
      if (Integer.parseInt(this.buff.toString()) != 1)
        return;
      this.taxi_mode = true;
      return;
    }
    if (paramString.equals("Route"))
    {
      this.buffering = false;
      return;
    }
    if (paramString.equals("TotalTimeVerb"))
    {
      this.buffering = false;
      DecimalFormat localDecimalFormat = new DecimalFormat("#.##");
      Object[] arrayOfObject = new Object[2];
      double d1 = this.segmentsLen;
      String str6 = localDecimalFormat.format(d1);
      arrayOfObject[0] = str6;
      String str7 = this.buff.toString();
      arrayOfObject[1] = str7;
      String str8 = String.format("TOTAL TRAVEL %1$s miles, %2$s", arrayOfObject);
      ViewStepTotal localViewStepTotal1 = new ViewStepTotal();
      localViewStepTotal1.setTotalTimeVerb(str8);
      String str9 = this.calories;
      localViewStepTotal1.setCalories(str9);
      String str10 = this.co2;
      localViewStepTotal1.setCo2(str10);
      String str11 = this.depatureTimeVerb;
      localViewStepTotal1.setDeparture(str11);
      String str12 = this.arrivalTimeVerb;
      localViewStepTotal1.setArrival(str12);
      double d2 = this.segmentsLen;
      String str13 = localDecimalFormat.format(d2);
      localViewStepTotal1.setDistance(str13);
      String str14 = this.buff.toString();
      localViewStepTotal1.setDuration(str14);
      this._dResponse.addViewStep(0, localViewStepTotal1);
      return;
    }
    if (paramString.equals("WheelChairOut"))
    {
      this.buffering = false;
      ViewStepTotal localViewStepTotal2 = (ViewStepTotal)this._dResponse.getViewSteps().get(0);
      int j = Integer.parseInt(this.buff.toString());
      localViewStepTotal2.setWheelChairOut(j);
      return;
    }
    if (paramString.equals("SegmentsLen"))
    {
      this.buffering = false;
      double d3 = Double.parseDouble(this.buff.toString());
      this.segmentsLen = d3;
      return;
    }
    String str15;
    if (paramString.equals("Address2"))
    {
      this.buffering = false;
      str15 = this.buff.toString();
      if ((str15 == null) || (str15.equals(" ")) || (str15.equals("")))
        str15 = "Current Location (Approximate)";
      this.vst2.setStart(false);
      this.vst2.setAddress(str15);
      DirectionResponse localDirectionResponse4 = this._dResponse;
      String str16 = this.buff.toString();
      localDirectionResponse4.setAddress2(str16);
      return;
    }
    if (paramString.equals("Address1"))
    {
      this.buffering = false;
      str15 = this.buff.toString();
      if ((str15 != null) && (!str15.equals(" ")) && (str15.equals("")));
      ViewStepAddress localViewStepAddress2 = new ViewStepAddress();
      localViewStepAddress2.setAddress(str15);
      this._dResponse.addViewStep(localViewStepAddress2);
      DirectionResponse localDirectionResponse5 = this._dResponse;
      String str17 = this.buff.toString();
      localDirectionResponse5.setAddress1(str17);
      return;
    }
    if (paramString.equals("Calories"))
    {
      this.buffering = false;
      String str18 = this.buff.toString();
      this.calories = str18;
      return;
    }
    if (paramString.equals("CO2Savings"))
    {
      this.buffering = false;
      String str19 = this.buff.toString();
      this.co2 = str19;
      return;
    }
    if (paramString.equals("County1"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse6 = this._dResponse;
      String str20 = this.buff.toString();
      localDirectionResponse6.setCounty1(str20);
      return;
    }
    if (paramString.equals("County2"))
    {
      this.buffering = false;
      ViewStepAddress localViewStepAddress3 = this.vst2;
      String str21 = this.buff.toString();
      localViewStepAddress3.setCounty2(str21);
      return;
    }
    if (paramString.equals("City1"))
    {
      this.buffering = false;
      ViewStepAddress localViewStepAddress4 = this.vst2;
      String str22 = this.buff.toString();
      localViewStepAddress4.setCity1(str22);
      DirectionResponse localDirectionResponse7 = this._dResponse;
      String str23 = this.buff.toString();
      localDirectionResponse7.setCity1(str23);
      return;
    }
    if (paramString.equals("City2"))
    {
      this.buffering = false;
      ViewStepAddress localViewStepAddress5 = this.vst2;
      String str24 = this.buff.toString();
      localViewStepAddress5.setCity2(str24);
      DirectionResponse localDirectionResponse8 = this._dResponse;
      String str25 = this.buff.toString();
      localDirectionResponse8.setCity2(str25);
      return;
    }
    if (paramString.equals("X1"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse9 = this._dResponse;
      double d4 = Double.parseDouble(this.buff.toString());
      localDirectionResponse9.setX1(d4);
      return;
    }
    if (paramString.equals("X2"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse10 = this._dResponse;
      double d5 = Double.parseDouble(this.buff.toString());
      localDirectionResponse10.setX2(d5);
      return;
    }
    if (paramString.equals("Y1"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse11 = this._dResponse;
      double d6 = Double.parseDouble(this.buff.toString());
      localDirectionResponse11.setY1(d6);
      return;
    }
    if (paramString.equals("Y2"))
    {
      this.buffering = false;
      DirectionResponse localDirectionResponse12 = this._dResponse;
      double d7 = Double.parseDouble(this.buff.toString());
      localDirectionResponse12.setY2(d7);
      return;
    }
    if (!paramString.equals("Id"))
      return;
    this.buffering = false;
    DirectionResponse localDirectionResponse13 = this._dResponse;
    String str26 = this.buff.toString();
    localDirectionResponse13.setRouteId(str26);
  }

  private void parseStartExtraAddresses(String paramString)
  {
    if (paramString.equals("item"))
    {
      Address localAddress1 = new Address();
      this.start_addr = localAddress1;
      Address localAddress2 = new Address();
      this.end_addr = localAddress2;
      return;
    }
    if (paramString.equals("Title"))
    {
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
    if (paramString.equals("Y"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    if (!paramString.equals("Id"))
      return;
    StringBuffer localStringBuffer5 = new StringBuffer("");
    this.buff = localStringBuffer5;
    this.buffering = true;
  }

  private void parseStartMap(String paramString)
  {
    if (paramString.equals("item"))
    {
      ViewStepMap localViewStepMap = new ViewStepMap();
      this.vsm = localViewStepMap;
      return;
    }
    if (paramString.equals("Title"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      return;
    }
    if (paramString.equals("URL"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (!paramString.equals("Id"))
      return;
    StringBuffer localStringBuffer3 = new StringBuffer("");
    this.buff = localStringBuffer3;
    this.buffering = true;
  }

  private void parseStartRouteInfo(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    this.buff = localStringBuffer;
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
      int i = this.resultCode;
      int j = NetworkSettings.SUCCESS_GET_ROUTE;
      if (i != j)
        return;
      DirectionResponse localDirectionResponse1 = this._dResponse;
      ViewStepAddress localViewStepAddress1 = this.vst2;
      localDirectionResponse1.addViewStep(localViewStepAddress1);
      ViewStepTotal localViewStepTotal = (ViewStepTotal)this._dResponse.getViewSteps().get(0);
      String str2 = this._dResponse.getRouteId();
      localViewStepTotal.setRouteId(str2);
      ViewStepAddress localViewStepAddress2 = (ViewStepAddress)this._dResponse.getViewSteps().get(1);
      String str3 = this._dResponse.getZip1();
      localViewStepAddress2.setZip1(str3);
      ViewStepAddress localViewStepAddress3 = (ViewStepAddress)this._dResponse.getViewSteps().get(1);
      String str4 = this._dResponse.getCounty1();
      localViewStepAddress3.setCounty1(str4);
      ViewStepAddress localViewStepAddress4 = (ViewStepAddress)this._dResponse.getViewSteps().get(1);
      String str5 = this._dResponse.getCity1();
      localViewStepAddress4.setCity1(str5);
      ViewStepReverseNewSearch localViewStepReverseNewSearch1 = new ViewStepReverseNewSearch();
      String str6 = ((ViewStepAddress)this._dResponse.getViewSteps().get(1)).getFullAddress1();
      localViewStepReverseNewSearch1.setFullAddress1(str6);
      String str7 = this.vst2.getFullAddress2();
      localViewStepReverseNewSearch1.setFullAddress2(str7);
      this._dResponse.addViewStep(localViewStepReverseNewSearch1);
      DirectionResponse localDirectionResponse2 = this._dResponse;
      ArrayList localArrayList = this.vsmList;
      localDirectionResponse2.addAllViewStep(localArrayList);
      ViewStepReverseNewSearch localViewStepReverseNewSearch2 = new ViewStepReverseNewSearch();
      String str8 = ((ViewStepAddress)this._dResponse.getViewSteps().get(1)).getFullAddress1();
      localViewStepReverseNewSearch2.setFullAddress1(str8);
      String str9 = this.vst2.getFullAddress2();
      localViewStepReverseNewSearch2.setFullAddress2(str9);
      this._dResponse.addViewStep(localViewStepReverseNewSearch2);
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      this.buffering = false;
      int k = Integer.parseInt(this.buff.toString());
      this.resultCode = k;
      return;
    }
    if (paramString2.equals("FaultCode"))
    {
      this.buffering = false;
      int m = Integer.parseInt(this.buff.toString());
      this.resultCode = m;
      return;
    }
    int n = this._mode;
    int i1 = this.ROUTE_INFO_MODE;
    if (n != i1)
    {
      parseEndRouteInfo(paramString2);
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      this.buffering = false;
      String str10 = this.buff.toString();
      this.resultString = str10;
      return;
    }
    if (paramString2.equals("FaultString"))
    {
      this.buffering = false;
      String str11 = this.buff.toString();
      this.resultString = str11;
      return;
    }
    int i2 = this._mode;
    int i3 = this.MAP_MODE;
    if (i2 != i3)
    {
      parseEndMap(paramString2);
      return;
    }
    int i4 = this._mode;
    int i5 = this.EXTRA_ADDRESSES;
    if (i4 != i5)
    {
      parseEndExtraAddress(paramString2);
      return;
    }
    int i6 = this._mode;
    int i7 = this.EXACT_ADDRESSES;
    if (i6 != i7)
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

  public void setDirectionResponse(DirectionResponse paramDirectionResponse)
  {
    this._dResponse = paramDirectionResponse;
  }

  public void setTaxiMode(boolean paramBoolean)
  {
    this.taxi_mode = paramBoolean;
  }

  public void startDocument()
    throws SAXException
  {
    ArrayList localArrayList = new ArrayList();
    this.vsmList = localArrayList;
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
      ViewStepAddress localViewStepAddress = new ViewStepAddress();
      this.vst2 = localViewStepAddress;
      return;
    }
    if (paramString2.equals("Thumbnails"))
    {
      int j = this.EXTRA_ADDRESSES;
      this._mode = j;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("FaultCode"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("FaultString"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    int k = this._mode;
    int m = this.ROUTE_INFO_MODE;
    if (k != m)
    {
      parseStartRouteInfo(paramString2);
      return;
    }
    if ((paramString2.equals("RouteInfo")) && (this.resultCode == 200))
    {
      int n = this.ROUTE_INFO_MODE;
      this._mode = n;
      return;
    }
    if ((paramString2.equals("RouteInfo")) && (this.resultCode == 201))
    {
      int i1 = this.EXACT_ADDRESSES;
      this._mode = i1;
      return;
    }
    int i2 = this._mode;
    int i3 = this.MAP_MODE;
    if (i2 != i3)
    {
      parseStartMap(paramString2);
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Maps"))
    {
      int i4 = this.MAP_MODE;
      this._mode = i4;
      return;
    }
    int i5 = this._mode;
    int i6 = this.EXTRA_ADDRESSES;
    if (i5 != i6)
    {
      parseStartExtraAddresses(paramString2);
      return;
    }
    int i7 = this._mode;
    int i8 = this.EXACT_ADDRESSES;
    if (i7 != i8)
      return;
    StringBuffer localStringBuffer6 = new StringBuffer("");
    this.buff = localStringBuffer6;
    this.buffering = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetDirectionRequestHandler
 * JD-Core Version:    0.6.2
 */