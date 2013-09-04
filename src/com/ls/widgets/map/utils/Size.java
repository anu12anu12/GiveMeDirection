package com.ls.widgets.map.utils;

public class Size
{
  private int a;
  private int b;

  public Size(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public int getHeight()
  {
    return this.b;
  }

  public int getWidth()
  {
    return this.a;
  }

  public void setHeight(int paramInt)
  {
    this.b = paramInt;
  }

  public void setWidth(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.utils.Size
 * JD-Core Version:    0.6.2
 */