package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.core.Commit;
import org.simpleframework.xml.core.Complete;

public class RouteInfo
  implements Serializable, Cloneable
{

  @Element(name="Address1FoundExact", required=false)
  private int _address1FoundExact;

  @Element(name="Address1OneLocation", required=false)
  private int _address1OneLocation;

  @Element(name="Address2FoundExact", required=false)
  private int _address2FoundExact;

  @Element(name="Address2OneLocation", required=false)
  private int _address2OneLocation;

  @Element(name="RouteIcons", required=false)
  private String _routeIcons;

  @Element(name="RouteLines", required=false)
  private String _routeLines;

  @Element(name="ABDistance", required=false)
  private double abDistance;

  @Element(name="Address1", required=false)
  private String address1;

  @Element(name="Address2", required=false)
  private String address2;

  @Element(name="ArriveBy", required=false)
  private int arriveBy;

  @Element(name="ArriveTime", required=false)
  private int arriveTime;

  @Element(name="ArriveTimeVerb", required=false)
  private String arriveTimeVerb;

  @Element(name="Calories", required=false)
  private String calories;

  @Element(name="City", required=false)
  private String city;

  @Element(name="City1", required=false)
  private String city1;

  @Element(name="City1Name", required=false)
  private String city1Name;

  @Element(name="City2", required=false)
  private String city2;

  @Element(name="City2Name", required=false)
  private String city2Name;

  @Element(name="CityName", required=false)
  private String cityName;

  @Element(name="CO2Savings", required=false)
  private String co2Savings;

  @Element(name="County1", required=false)
  private String county1;

  @Element(name="County1Name", required=false)
  private String county1Name;

  @Element(name="County2", required=false)
  private String county2;

  @Element(name="County2Name", required=false)
  private String county2Name;

  @Element(name="Day", required=false)
  private int day;

  @Element(name="DepartTime", required=false)
  private int departTime;

  @Element(name="DepartTimeVerb", required=false)
  private String departTimeVerb;

  @Element(name="EnableDisabledLinks", required=false)
  private int enableDisabledLinks;

  @Element(name="Id", required=false)
  private String id;

  @Element(name="Mode", required=false)
  private String mode;

  @Element(name="SegmentsLen", required=false)
  private double segmentsLen;

  @ElementList(name="Route", required=false)
  private ArrayList<ViewStepDirections> steps;

  @Element(name="Time", required=false)
  private int time;

  @Element(name="TotalFarePriceVerb", required=false)
  private String totalFarePriceVerb;

  @Element(name="TotalTime", required=false)
  private int totalTime;

  @Element(name="TotalTimeVerb", required=false)
  private String totalTimeVerb;
  private ViewStepAddress vst1;
  private ViewStepAddress vst2;

  @Element(name="WalkingTime", required=false)
  private int walkingTime;

  @Element(name="WheelChair", required=false)
  private int wheelChair;

  @Element(name="WheelChairOut", required=false)
  private int wheelChairOut;

  @Element(name="X1", required=false)
  private double x1;

  @Element(name="X2", required=false)
  private double x2;

  @Element(name="Y1", required=false)
  private double y1;

  @Element(name="Y2", required=false)
  private double y2;

  @Element(name="Zip1", required=false)
  private String zip1;

  @Element(name="Zip2", required=false)
  private String zip2;

  @Commit
  public void build()
  {
    if ((this.address1 == null) || (this.address1.equals(" ")) || (this.address1.equals("")))
      this.address1 = "Current Location (Approximate)";
    ViewStepAddress localViewStepAddress1 = new ViewStepAddress();
    this.vst1 = localViewStepAddress1;
    ViewStepAddress localViewStepAddress2 = this.vst1;
    String str1 = this.address1;
    localViewStepAddress2.setAddress(str1);
    ViewStepAddress localViewStepAddress3 = this.vst1;
    String str2 = this.zip1;
    localViewStepAddress3.setZip1(str2);
    ViewStepAddress localViewStepAddress4 = this.vst1;
    String str3 = this.county1;
    localViewStepAddress4.setCounty1(str3);
    ViewStepAddress localViewStepAddress5 = this.vst1;
    String str4 = this.city1;
    localViewStepAddress5.setCity1(str4);
    ViewStepAddress localViewStepAddress6 = this.vst1;
    double d1 = this.x1;
    localViewStepAddress6.setX(d1);
    ViewStepAddress localViewStepAddress7 = this.vst1;
    double d2 = this.y1;
    localViewStepAddress7.setY(d2);
    if ((this.address2 == null) || (this.address2.equals(" ")) || (this.address2.equals("")))
      this.address2 = "Current Location (Approximate)";
    ViewStepAddress localViewStepAddress8 = new ViewStepAddress();
    this.vst2 = localViewStepAddress8;
    this.vst2.setStart(false);
    ViewStepAddress localViewStepAddress9 = this.vst2;
    String str5 = this.address2;
    localViewStepAddress9.setAddress(str5);
    ViewStepAddress localViewStepAddress10 = this.vst2;
    String str6 = this.zip2;
    localViewStepAddress10.setZip2(str6);
    ViewStepAddress localViewStepAddress11 = this.vst2;
    String str7 = this.county2;
    localViewStepAddress11.setCounty2(str7);
    ViewStepAddress localViewStepAddress12 = this.vst2;
    String str8 = this.city2;
    localViewStepAddress12.setCity2(str8);
    ViewStepAddress localViewStepAddress13 = this.vst2;
    double d3 = this.x2;
    localViewStepAddress13.setX(d3);
    ViewStepAddress localViewStepAddress14 = this.vst2;
    double d4 = this.y2;
    localViewStepAddress14.setY(d4);
  }

  public double getABDistance()
  {
    return this.abDistance;
  }

  public String getAddress1()
  {
    return this.address1;
  }

  public int getAddress1FoundExact()
  {
    return this._address1FoundExact;
  }

  public int getAddress1OneLocation()
  {
    return this._address1OneLocation;
  }

  public String getAddress2()
  {
    return this.address2;
  }

  public int getAddress2FoundExact()
  {
    return this._address2FoundExact;
  }

  public int getAddress2OneLocation()
  {
    return this._address2OneLocation;
  }

  public int getArriveBy()
  {
    return this.arriveBy;
  }

  public int getArriveTime()
  {
    return this.arriveTime;
  }

  public String getArriveTimeVerb()
  {
    return this.arriveTimeVerb;
  }

  public String getCO2Savings()
  {
    return this.co2Savings;
  }

  public String getCalories()
  {
    return this.calories;
  }

  public String getCity()
  {
    return this.city;
  }

  public String getCity1()
  {
    return this.city1;
  }

  public String getCity1Name()
  {
    return this.city1Name;
  }

  public String getCity2()
  {
    return this.city2;
  }

  public String getCity2Name()
  {
    return this.city2Name;
  }

  public String getCityName()
  {
    return this.cityName;
  }

  public String getCounty1()
  {
    return this.county1;
  }

  public String getCounty1Name()
  {
    return this.county1Name;
  }

  public String getCounty2()
  {
    return this.county2;
  }

  public String getCounty2Name()
  {
    return this.county2Name;
  }

  public int getDay()
  {
    return this.day;
  }

  public int getDepartTime()
  {
    return this.departTime;
  }

  public String getDepartTimeVerb()
  {
    return this.departTimeVerb;
  }

  public int getEnableDisabledLinks()
  {
    return this.enableDisabledLinks;
  }

  public String getId()
  {
    return this.id;
  }

  public String getMode()
  {
    return this.mode;
  }

  public String getRouteIcons()
  {
    return this._routeIcons;
  }

  public String getRouteLines()
  {
    return this._routeLines;
  }

  public double getSegmentsLen()
  {
    return this.segmentsLen;
  }

  public ArrayList<ViewStepDirections> getSteps()
  {
    return this.steps;
  }

  public int getTime()
  {
    return this.time;
  }

  public String getTotalFarePriceVerb()
  {
    return this.totalFarePriceVerb;
  }

  public int getTotalTime()
  {
    return this.totalTime;
  }

  public String getTotalTimeVerb()
  {
    return this.totalTimeVerb;
  }

  public ViewStepAddress getViewStepAddress1()
  {
    return this.vst1;
  }

  public ViewStepAddress getViewStepAddress2()
  {
    return this.vst2;
  }

  public int getWalkingTime()
  {
    return this.walkingTime;
  }

  public int getWheelChair()
  {
    return this.wheelChair;
  }

  public int getWheelChairOut()
  {
    return this.wheelChairOut;
  }

  public double getX1()
  {
    return this.x1;
  }

  public double getX2()
  {
    return this.x2;
  }

  public double getY1()
  {
    return this.y1;
  }

  public double getY2()
  {
    return this.y2;
  }

  public String getZip1()
  {
    return this.zip1;
  }

  public String getZip2()
  {
    return this.zip2;
  }

  @Complete
  public void setABDistance(int paramInt)
  {
    double d = paramInt;
    this.abDistance = d;
  }

  public void setAddress1(String paramString)
  {
    this.address1 = paramString;
  }

  public void setAddress2(String paramString)
  {
    this.address2 = paramString;
  }

  public void setArriveBy(int paramInt)
  {
    this.arriveBy = paramInt;
  }

  public void setArriveTime(int paramInt)
  {
    this.arriveTime = paramInt;
  }

  public void setArriveTimeVerb(String paramString)
  {
    this.arriveTimeVerb = paramString;
  }

  public void setCO2Savings(String paramString)
  {
    this.co2Savings = paramString;
  }

  public void setCalories(String paramString)
  {
    this.calories = paramString;
  }

  public void setCity(String paramString)
  {
    this.city = paramString;
  }

  public void setCity1(String paramString)
  {
    this.city1 = paramString;
  }

  public void setCity1Name(String paramString)
  {
    this.city1Name = paramString;
  }

  public void setCity2(String paramString)
  {
    this.city2 = paramString;
  }

  public void setCity2Name(String paramString)
  {
    this.city2Name = paramString;
  }

  public void setCityName(String paramString)
  {
    this.cityName = paramString;
  }

  public void setCounty1(String paramString)
  {
    this.county1 = paramString;
  }

  public void setCounty1Name(String paramString)
  {
    this.county1Name = paramString;
  }

  public void setCounty2(String paramString)
  {
    this.county2 = paramString;
  }

  public void setCounty2Name(String paramString)
  {
    this.county2Name = paramString;
  }

  public void setDay(int paramInt)
  {
    this.day = paramInt;
  }

  public void setDepartTime(int paramInt)
  {
    this.departTime = paramInt;
  }

  public void setDepartTimeVerb(String paramString)
  {
    this.departTimeVerb = paramString;
  }

  public void setEnableDisabledLinks(int paramInt)
  {
    this.enableDisabledLinks = paramInt;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setSegmentsLen(double paramDouble)
  {
    this.segmentsLen = paramDouble;
  }

  public void setSteps(ArrayList<ViewStepDirections> paramArrayList)
  {
    this.steps = paramArrayList;
  }

  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }

  public void setTotalFarePriceVerb(String paramString)
  {
    this.totalFarePriceVerb = paramString;
  }

  public void setTotalTime(int paramInt)
  {
    this.totalTime = paramInt;
  }

  public void setTotalTimeVerb(String paramString)
  {
    this.totalTimeVerb = paramString;
  }

  public void setWalkingTime(int paramInt)
  {
    this.walkingTime = paramInt;
  }

  public void setWheelChair(int paramInt)
  {
    this.wheelChair = paramInt;
  }

  public void setWheelChairOut(int paramInt)
  {
    this.wheelChairOut = paramInt;
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
 * Qualified Name:     com.hopstop.ClientModel.directions.RouteInfo
 * JD-Core Version:    0.6.2
 */