package com.ls.widgets.map.events;

public class MapScrolledEvent
{
  boolean a;
  private int b;
  private int c;

  public MapScrolledEvent(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public int getDX()
  {
    return this.b;
  }

  public int getDY()
  {
    return this.c;
  }

  public boolean isByUser()
  {
    return this.a;
  }

  public void setData(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = paramBoolean;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.events.MapScrolledEvent
 * JD-Core Version:    0.6.2
 */