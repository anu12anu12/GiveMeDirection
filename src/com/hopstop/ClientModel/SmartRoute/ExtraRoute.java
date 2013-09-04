package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(name="ExtraRoute")
public class ExtraRoute
  implements Serializable
{

  @Element(name="CO2Savings", required=false)
  private float _CO2Savings;

  @Element(name="ArriveTime", required=false)
  private int _arriveTime;

  @Element(name="ArriveTimeVerb", required=false)
  private String _arriveTimeVerb;
  private String _arriveTimeVerbDisplay;

  @Element(name="BikingTime", required=false)
  private int _bikingTime;

  @Element(name="BikingTimeVerb", required=false)
  private String _bikingTimeVerb;

  @Element(name="Calories", required=false)
  private int _calories;

  @Element(name="DepartTime", required=false)
  private int _departTime;

  @Element(name="DepartTimeVerb", required=false)
  private String _departTimeVerb;

  @Element(name="Id", required=false)
  private String _id;

  @Element(name="TotalFarePriceVerb", required=false)
  private String _totalFarePriceVerb;

  @Element(name="TotalTime", required=false)
  private int _totalTime;

  @Element(name="TotalTimeVerb", required=false)
  private String _totalTimeVerb;
  private String _totalTimeVerbDisplay;

  @ElementList(name="Vehicles", required=false)
  private ArrayList<Vehicle> _vehicles;

  @Element(name="WalkingTime", required=false)
  private int _walkingTime;

  @Element(name="WalkingTimeVerb", required=false)
  private String _walkingTimeVerb;

  @Element(name="WheelChair", required=false)
  private byte _wheelChair;

  @Commit
  public void build()
  {
    setArriveTimeVerbDisplay();
    setTotalTimeVerbDisplay();
  }

  public int getArriveTime()
  {
    return this._arriveTime;
  }

  public String getArriveTimeVerb()
  {
    return this._arriveTimeVerb;
  }

  public String getArriveTimeVerbDisplay()
  {
    return this._arriveTimeVerbDisplay;
  }

  public int getBikingTime()
  {
    return this._bikingTime;
  }

  public String getBikingTimeVerb()
  {
    return this._bikingTimeVerb;
  }

  public float getCO2Savings()
  {
    return this._CO2Savings;
  }

  public int getCalories()
  {
    return this._calories;
  }

  public int getDepartTime()
  {
    return this._departTime;
  }

  public String getDepartTimeVerb()
  {
    return this._departTimeVerb;
  }

  public String getId()
  {
    return this._id;
  }

  public String getTotalFarePriceVerb()
  {
    return this._totalFarePriceVerb;
  }

  public int getTotalTime()
  {
    return this._totalTime;
  }

  public String getTotalTimeVerb()
  {
    return this._totalTimeVerb;
  }

  public String getTotalTimeVerbDisplay()
  {
    return this._totalTimeVerbDisplay;
  }

  public ArrayList<Vehicle> getVehicles()
  {
    return this._vehicles;
  }

  public int getWalkingTime()
  {
    return this._walkingTime;
  }

  public String getWalkingTimeVerb()
  {
    return this._walkingTimeVerb;
  }

  public byte getWheelChair()
  {
    return this._wheelChair;
  }

  public void setArriveTimeVerbDisplay()
  {
    String str1 = this._arriveTimeVerb;
    this._arriveTimeVerbDisplay = str1;
    if (this._arriveTimeVerb == null)
      return;
    if (this._arriveTimeVerb == "")
      return;
    int i = this._arriveTimeVerb.indexOf("(");
    if (i == -1)
      return;
    String str2 = this._arriveTimeVerb.substring(0, i);
    this._arriveTimeVerbDisplay = str2;
  }

  public void setId(String paramString)
  {
    this._id = paramString;
  }

  public void setTotalTimeVerbDisplay()
  {
    this._totalTimeVerbDisplay = "";
    if (this._totalTimeVerb == null)
      return;
    if (this._totalTimeVerb == "")
      return;
    String str = this._totalTimeVerb.replace("hours", "h").replace("hour", "h").replace("mins", "m").replace("min", "m");
    this._totalTimeVerbDisplay = str;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.ExtraRoute
 * JD-Core Version:    0.6.2
 */