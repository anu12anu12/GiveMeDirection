package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class WalkingPartInfo
  implements Serializable, Cloneable
{

  @Element(name="CurrentDay", required=false)
  private int _currentDay;

  @Element(name="CurrentTime", required=false)
  private int _currentTime;

  @Element(name="MapNumber", required=false)
  private int _mapNumber;

  @Element(name="WalkingTime", required=false)
  private int _walkingTime;

  @Element(name="X1", required=false)
  private double _x1;

  @Element(name="X2", required=false)
  private double _x2;

  @Element(name="Y1", required=false)
  private double _y1;

  @Element(name="Y2", required=false)
  private double _y2;

  public int getCurrentDay()
  {
    return this._currentDay;
  }

  public int getCurrentTime()
  {
    return this._currentTime;
  }

  public int getMapNumber()
  {
    return this._mapNumber;
  }

  public int getWalkingTime()
  {
    return this._walkingTime;
  }

  public double getX1()
  {
    return this._x1;
  }

  public double getX2()
  {
    return this._x2;
  }

  public double getY1()
  {
    return this._y1;
  }

  public double getY2()
  {
    return this._y2;
  }

  public void setCurrentDay(int paramInt)
  {
    this._currentDay = paramInt;
  }

  public void setCurrentTime(int paramInt)
  {
    this._currentTime = paramInt;
  }

  public void setMapNumber(int paramInt)
  {
    this._mapNumber = paramInt;
  }

  public void setWalkingTime(int paramInt)
  {
    this._walkingTime = paramInt;
  }

  public void setX1(int paramInt)
  {
    double d = paramInt;
    this._x1 = d;
  }

  public void setX2(int paramInt)
  {
    double d = paramInt;
    this._x2 = d;
  }

  public void setY1(int paramInt)
  {
    double d = paramInt;
    this._y1 = d;
  }

  public void setY2(int paramInt)
  {
    double d = paramInt;
    this._y2 = d;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.WalkingPartInfo
 * JD-Core Version:    0.6.2
 */