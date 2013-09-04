package com.ls.widgets.map.model;

import android.graphics.Rect;

public class MapTouchable
{
  private Object a;
  private Rect b;
  private MapObject c;

  public MapTouchable(Object paramObject, MapObject paramMapObject, Rect paramRect)
  {
    this.a = paramObject;
    this.b = paramRect;
    this.c = paramMapObject;
  }

  public MapObject getDrawable()
  {
    return this.c;
  }

  public Object getId()
  {
    return this.a;
  }

  public boolean isTouched(int paramInt1, int paramInt2)
  {
    return this.b.contains(paramInt1, paramInt2);
  }

  public boolean isTouched(Rect paramRect)
  {
    return Rect.intersects(this.b, paramRect);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.model.MapTouchable
 * JD-Core Version:    0.6.2
 */