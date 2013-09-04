package com.hopstop.ClientModel;

import com.hopstop.ClientModel.SmartRoute.ExtraRoute;
import com.hopstop.ClientModel.SmartRoute.SmartRoute;
import com.hopstop.ClientModel.directions.RouteInfo;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepDirections;
import com.hopstop.ClientModel.directions.ViewStepMap;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.network.NetworkSettings;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(name="HopStopResponse", strict=false)
public class DirectionResponse
  implements Serializable
{
  private static final long serialVersionUID = 8651284362648345310L;

  @ElementList(name="ExtraRoutes", required=false)
  private ArrayList<ExtraRoute> _extraRoutes;

  @Element(name="ExtraRoutesIdPrefix", required=false)
  private String _extraRoutesIdPrefix;

  @Element(name="ExtraRoutesResumeData", required=false)
  private String _extraRoutesResumeData;

  @Element(name="Id", required=false)
  private String _id;

  @ElementList(name="Maps", required=false)
  private ArrayList<ViewStepMap> _maps;

  @ElementList(name="Thumbnails", required=false)
  private ArrayList<Address> _multiAddresses;

  @Element(name="RouteInfo", required=false)
  private RouteInfo _routeInfo;
  private ViewStepTotal _viewStepTotal;
  private String address1;
  private String address2;
  private String city1;
  private String city2;
  private String county1;
  private int enableDisabledLinks;
  private ArrayList<Address> first;
  private String mode;

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus responseStatus;
  private String routeId;
  private ArrayList<Address> second;
  private SmartRoute smartRoute;
  private ArrayList<ViewStep> steps;
  private String urlString;
  private double x1;
  private double x2;
  private double y1;
  private double y2;
  private String zip1;
  private String zip2;

  public DirectionResponse()
  {
    ArrayList localArrayList1 = new ArrayList();
    this.steps = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.first = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    this.second = localArrayList3;
  }

  public DirectionResponse(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    this.steps = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.first = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    this.second = localArrayList3;
    this.urlString = paramString;
  }

  public void addAllViewStep(ArrayList<ViewStep> paramArrayList)
  {
    boolean bool = this.steps.addAll(paramArrayList);
  }

  public void addAllViewStepMap(ArrayList<ViewStepMap> paramArrayList)
  {
    boolean bool = this.steps.addAll(paramArrayList);
  }

  public void addViewStep(int paramInt, ViewStep paramViewStep)
  {
    this.steps.add(paramInt, paramViewStep);
  }

  public void addViewStep(ViewStep paramViewStep)
  {
    boolean bool = this.steps.add(paramViewStep);
  }

  public void addViewStepDirections(ArrayList<ViewStepDirections> paramArrayList)
  {
    boolean bool = this.steps.addAll(paramArrayList);
  }

  @Commit
  public void build()
  {
    int i = this.responseStatus.getResultCode();
    int j = NetworkSettings.SEVERAL_CHOICES_FOUND;
    if (i != j)
    {
      Iterator localIterator = this._multiAddresses.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        Address localAddress = (Address)localIterator.next();
        if (localAddress.getAddressId() == 1)
          boolean bool1 = this.first.add(localAddress);
        else if (localAddress.getAddressId() == 2)
          boolean bool2 = this.second.add(localAddress);
      }
    }
    if (!this.responseStatus.isSuccess())
      return;
    DecimalFormat localDecimalFormat = new DecimalFormat("#.##");
    RouteInfo localRouteInfo = getRouteInfo();
    Object[] arrayOfObject = new Object[2];
    double d1 = localRouteInfo.getSegmentsLen();
    String str1 = localDecimalFormat.format(d1);
    arrayOfObject[0] = str1;
    String str2 = localRouteInfo.getTotalTimeVerb();
    arrayOfObject[1] = str2;
    String str3 = String.format("TOTAL TRAVEL %1$s miles, %2$s", arrayOfObject);
    ViewStepTotal localViewStepTotal1 = new ViewStepTotal();
    this._viewStepTotal = localViewStepTotal1;
    this._viewStepTotal.setTotalTimeVerb(str3);
    ViewStepTotal localViewStepTotal2 = this._viewStepTotal;
    String str4 = localRouteInfo.getCalories();
    localViewStepTotal2.setCalories(str4);
    ViewStepTotal localViewStepTotal3 = this._viewStepTotal;
    String str5 = localRouteInfo.getCO2Savings();
    localViewStepTotal3.setCo2(str5);
    ViewStepTotal localViewStepTotal4 = this._viewStepTotal;
    String str6 = localRouteInfo.getDepartTimeVerb();
    localViewStepTotal4.setDeparture(str6);
    ViewStepTotal localViewStepTotal5 = this._viewStepTotal;
    String str7 = localRouteInfo.getArriveTimeVerb();
    localViewStepTotal5.setArrival(str7);
    ViewStepTotal localViewStepTotal6 = this._viewStepTotal;
    double d2 = localRouteInfo.getSegmentsLen();
    String str8 = localDecimalFormat.format(d2);
    localViewStepTotal6.setDistance(str8);
    ViewStepTotal localViewStepTotal7 = this._viewStepTotal;
    String str9 = localRouteInfo.getTotalTimeVerb();
    localViewStepTotal7.setDuration(str9);
    ViewStepTotal localViewStepTotal8 = this._viewStepTotal;
    if (localRouteInfo.getTotalFarePriceVerb() == null);
    for (String str10 = "$0.00"; ; str10 = localRouteInfo.getTotalFarePriceVerb())
    {
      localViewStepTotal8.setFare(str10);
      ViewStepTotal localViewStepTotal9 = this._viewStepTotal;
      int k = localRouteInfo.getWalkingTime() / 60;
      localViewStepTotal9.setWalkingTime(k);
      ViewStepTotal localViewStepTotal10 = this._viewStepTotal;
      int m = localRouteInfo.getWheelChairOut();
      localViewStepTotal10.setWheelChairOut(m);
      ViewStepTotal localViewStepTotal11 = this._viewStepTotal;
      String str11 = localRouteInfo.getId();
      localViewStepTotal11.setRouteId(str11);
      if ((localRouteInfo != null) && (localRouteInfo.getRouteIcons() != null))
      {
        ViewStepTotal localViewStepTotal12 = this._viewStepTotal;
        String str12 = localRouteInfo.getRouteIcons();
        localViewStepTotal12.setRouteIcons(str12);
      }
      if ((localRouteInfo != null) && (localRouteInfo.getRouteLines() != null))
      {
        ViewStepTotal localViewStepTotal13 = this._viewStepTotal;
        String str13 = localRouteInfo.getRouteLines();
        localViewStepTotal13.setRouteLines(str13);
      }
      int n = this.responseStatus.getResultCode();
      int i1 = NetworkSettings.SMART_ROUTE;
      if (n != i1)
      {
        ResponseStatus localResponseStatus = this.responseStatus;
        int i2 = NetworkSettings.SUCCESS_GET_ROUTE;
        localResponseStatus.setResultCode(i2);
      }
      ArrayList localArrayList = this._extraRoutes;
      String str14 = this._extraRoutesIdPrefix;
      String str15 = this._extraRoutesResumeData;
      SmartRoute localSmartRoute = new SmartRoute(localArrayList, str14, str15);
      this.smartRoute = localSmartRoute;
      String str16 = this._routeInfo.getMode();
      setMode(str16);
      return;
    }
  }

  public String getAddress1()
  {
    return this._routeInfo.getAddress1();
  }

  public String getAddress2()
  {
    return this._routeInfo.getAddress2();
  }

  public String getCity1()
  {
    return this._routeInfo.getCity1();
  }

  public String getCity2()
  {
    return this._routeInfo.getCity2();
  }

  public String getCounty1()
  {
    return this._routeInfo.getCounty1();
  }

  public int getEnableDisabledLinks()
  {
    return this._routeInfo.getEnableDisabledLinks();
  }

  public ArrayList<ExtraRoute> getExtraRoutes()
  {
    return this._extraRoutes;
  }

  public String getExtraRoutesIdPrefix()
  {
    return this._extraRoutesIdPrefix;
  }

  public ArrayList<Address> getFirstExtraAddresses()
  {
    return this.first;
  }

  public String getKeyWords()
  {
    String str1 = "";
    if (this._routeInfo.getZip1() != null)
    {
      String str2 = String.valueOf("");
      StringBuilder localStringBuilder1 = new StringBuilder(str2);
      String str3 = this._routeInfo.getZip1();
      str1 = str3 + ",";
    }
    if (this._routeInfo.getZip2() != null)
    {
      String str4 = String.valueOf(str1);
      StringBuilder localStringBuilder2 = new StringBuilder(str4);
      String str5 = this._routeInfo.getZip1();
      str1 = str5 + ",";
    }
    if (this._routeInfo.getX1() != 0.0D)
    {
      String str6 = String.valueOf(str1);
      StringBuilder localStringBuilder3 = new StringBuilder(str6);
      double d1 = this._routeInfo.getX1();
      str1 = d1 + ",";
    }
    if (this._routeInfo.getX2() != 0.0D)
    {
      String str7 = String.valueOf(str1);
      StringBuilder localStringBuilder4 = new StringBuilder(str7);
      double d2 = this._routeInfo.getX2();
      str1 = d2 + ",";
    }
    if (this._routeInfo.getY1() != 0.0D)
    {
      String str8 = String.valueOf(str1);
      StringBuilder localStringBuilder5 = new StringBuilder(str8);
      double d3 = this._routeInfo.getY1();
      str1 = d3 + ",";
    }
    if (this._routeInfo.getY2() != 0.0D)
    {
      String str9 = String.valueOf(str1);
      StringBuilder localStringBuilder6 = new StringBuilder(str9);
      double d4 = this._routeInfo.getY2();
      str1 = d4 + ",";
    }
    if (this._routeInfo.getCity1() != null)
    {
      String str10 = String.valueOf(str1);
      StringBuilder localStringBuilder7 = new StringBuilder(str10);
      String str11 = this._routeInfo.getCity1();
      str1 = str11 + ",";
    }
    if (this._routeInfo.getCity2() != null)
    {
      String str12 = String.valueOf(str1);
      StringBuilder localStringBuilder8 = new StringBuilder(str12);
      String str13 = this._routeInfo.getCity2();
      str1 = str13 + ",";
    }
    if (this._routeInfo.getAddress1() != null)
    {
      String str14 = String.valueOf(str1);
      StringBuilder localStringBuilder9 = new StringBuilder(str14);
      String str15 = this._routeInfo.getAddress1();
      str1 = str15 + ",";
    }
    if (this._routeInfo.getAddress2() != null)
    {
      String str16 = String.valueOf(str1);
      StringBuilder localStringBuilder10 = new StringBuilder(str16);
      String str17 = this._routeInfo.getAddress2();
      str1 = str17 + ",";
    }
    if (str1 != null)
    {
      int i = str1.lastIndexOf(",");
      str1 = str1.substring(0, i);
    }
    return str1.toLowerCase();
  }

  public ArrayList<ViewStepMap> getMaps()
  {
    return this._maps;
  }

  public String getMode()
  {
    return this.mode;
  }

  public ArrayList<Address> getMultiAddresses()
  {
    return this._multiAddresses;
  }

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public String getRouteId()
  {
    return this._routeInfo.getId();
  }

  public RouteInfo getRouteInfo()
  {
    return this._routeInfo;
  }

  public ArrayList<Address> getSecondExtraAddresses()
  {
    return this.second;
  }

  public SmartRoute getSmartRoute()
  {
    return this.smartRoute;
  }

  public String getUrlString()
  {
    return this.urlString;
  }

  public ViewStepTotal getViewStepTotal()
  {
    return this._viewStepTotal;
  }

  public ArrayList<ViewStep> getViewSteps()
  {
    return this.steps;
  }

  public double getX1()
  {
    return this._routeInfo.getX1();
  }

  public double getX2()
  {
    return this._routeInfo.getX2();
  }

  public double getY1()
  {
    return this._routeInfo.getY1();
  }

  public double getY2()
  {
    return this._routeInfo.getY2();
  }

  public String getZip1()
  {
    return this._routeInfo.getZip1();
  }

  public String getZip2()
  {
    return this._routeInfo.getZip2();
  }

  public boolean isSmartRoute()
  {
    if ((this.smartRoute != null) && (!this.smartRoute.empty()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setAddress1(String paramString)
  {
    if ((paramString == null) || (paramString.equals(" ")) || (paramString.equals("")))
    {
      this.address1 = "Current Location (Approximate)";
      return;
    }
    this.address1 = paramString;
  }

  public void setAddress2(String paramString)
  {
    if ((paramString == null) || (paramString.equals(" ")) || (paramString.equals("")))
    {
      this.address2 = "Current Location (Approximate)";
      return;
    }
    this.address2 = paramString;
  }

  public void setCity1(String paramString)
  {
    this.city1 = paramString;
  }

  public void setCity2(String paramString)
  {
    this.city2 = paramString;
  }

  public void setCounty1(String paramString)
  {
    this.county1 = paramString;
  }

  public void setEnableDisabledLinks(int paramInt)
  {
    this.enableDisabledLinks = paramInt;
  }

  public void setMaps(ArrayList<ViewStepMap> paramArrayList)
  {
    this._maps = paramArrayList;
  }

  public void setMode(String paramString)
  {
    this.mode = paramString;
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }

  public void setRouteId(String paramString)
  {
    this.routeId = paramString;
  }

  public void setRouteInfo(RouteInfo paramRouteInfo)
  {
    this._routeInfo = paramRouteInfo;
  }

  public void setSmartRoute(SmartRoute paramSmartRoute)
  {
    this.smartRoute = paramSmartRoute;
  }

  public void setSteps(ArrayList<Address> paramArrayList)
  {
    this._multiAddresses = paramArrayList;
  }

  public void setX1(double paramDouble)
  {
    this.x1 = paramDouble;
  }

  public void setX2(double paramDouble)
  {
    this.x2 = paramDouble;
  }

  public void setY1(double paramDouble)
  {
    this.y1 = paramDouble;
  }

  public void setY2(double paramDouble)
  {
    this.y2 = paramDouble;
  }

  public void setZip1(String paramString)
  {
    this.zip1 = paramString;
  }

  public void setZip2(String paramString)
  {
    this.zip2 = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.DirectionResponse
 * JD-Core Version:    0.6.2
 */