package com.ls.widgets.map.events;

public class ObjectTouchEvent
{
  private Object a;
  private long b;

  public ObjectTouchEvent(Object paramObject, long paramLong)
  {
    this.a = paramObject;
    this.b = paramLong;
  }

  public long getLayerId()
  {
    return this.b;
  }

  public Object getObjectId()
  {
    return this.a;
  }

  public void setLayerId(int paramInt)
  {
    long l = paramInt;
    this.b = l;
  }

  public void setObjectId(Object paramObject)
  {
    this.a = paramObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.events.ObjectTouchEvent
 * JD-Core Version:    0.6.2
 */