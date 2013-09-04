package com.ls.widgets.map.interfaces;

import com.ls.widgets.map.model.MapObject;

public abstract interface Layer
{
  public abstract void addMapObject(MapObject paramMapObject);

  public abstract void clearAll();

  public abstract MapObject getMapObject(Object paramObject);

  public abstract MapObject getMapObjectByIndex(int paramInt);

  public abstract int getMapObjectCount();

  public abstract boolean isVisible();

  public abstract void removeMapObject(Object paramObject);

  public abstract void setVisible(boolean paramBoolean);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.interfaces.Layer
 * JD-Core Version:    0.6.2
 */