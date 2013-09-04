package com.ls.widgets.map.events;

import java.util.ArrayList;

public class MapTouchedEvent
{
  private int a;
  private int b;
  private int c;
  private int d;
  private ArrayList<ObjectTouchEvent> e;

  public int getMapX()
  {
    return this.c;
  }

  public int getMapY()
  {
    return this.d;
  }

  public int getScreenX()
  {
    return this.a;
  }

  public int getScreenY()
  {
    return this.b;
  }

  public ArrayList<ObjectTouchEvent> getTouchedObjectEvents()
  {
    return this.e;
  }

  public ArrayList<ObjectTouchEvent> getTouchedObjectIds()
  {
    return this.e;
  }

  public void setMapX(int paramInt)
  {
    this.c = paramInt;
  }

  public void setMapY(int paramInt)
  {
    this.d = paramInt;
  }

  public void setScreenX(int paramInt)
  {
    this.a = paramInt;
  }

  public void setScreenY(int paramInt)
  {
    this.b = paramInt;
  }

  public void setTouchedObjectEvents(ArrayList<ObjectTouchEvent> paramArrayList)
  {
    this.e = paramArrayList;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.events.MapTouchedEvent
 * JD-Core Version:    0.6.2
 */