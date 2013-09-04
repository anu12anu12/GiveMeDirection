package com.ls.widgets.map.config;

public class MapGraphicsConfig
{
  public static final int DEFAULT_ACCURACY_AREA_BORDER_COLOR = -15243287;
  public static final int DEFAULT_ACCURACY_AREA_COLOR = 857171945;
  private int a = -1;
  private int b = -1;
  private int c = 857171945;
  private int d = -15243287;

  public int getAccuracyAreaBorderColor()
  {
    return this.d;
  }

  public int getAccuracyAreaColor()
  {
    return this.c;
  }

  public int getArrowPointerDrawableId()
  {
    return this.b;
  }

  public int getDotPointerDrawableId()
  {
    return this.a;
  }

  public void setAccuracyAreaBorderColor(int paramInt)
  {
    this.d = paramInt;
  }

  public void setAccuracyAreaColor(int paramInt)
  {
    this.c = paramInt;
  }

  public void setArrowPointerDrawableId(int paramInt)
  {
    this.b = paramInt;
  }

  public void setDotPointerDrawableId(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.config.MapGraphicsConfig
 * JD-Core Version:    0.6.2
 */