package com.ls.widgets.map.model;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Looper;
import com.ls.widgets.map.MapWidget;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.interfaces.Layer;
import java.util.ArrayList;
import java.util.Iterator;

public class MapLayer
  implements Drawable.Callback, Layer
{
  private long a;
  private boolean b;
  private ArrayList<MapObject> c;
  private ArrayList<MapObject> d;
  protected MapWidget parent;

  public MapLayer(long paramLong, MapWidget paramMapWidget)
  {
    ArrayList localArrayList1 = new ArrayList();
    this.c = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.d = localArrayList2;
    this.b = true;
    this.a = paramLong;
    this.parent = paramMapWidget;
  }

  OfflineMapConfig a()
  {
    return this.parent.getConfig();
  }

  void a(MapObject paramMapObject)
  {
    Rect localRect = paramMapObject.getBounds();
    MapWidget localMapWidget = this.parent;
    int i = localRect.left;
    int j = localRect.top;
    int k = localRect.right;
    int m = localRect.bottom;
    localMapWidget.postInvalidate(i, j, k, m);
  }

  public void addMapObject(MapObject paramMapObject)
  {
    if (paramMapObject == null)
      throw new IllegalArgumentException();
    if (Looper.myLooper() == null)
      throw new RuntimeException("addMapObject should be called from UI thread.");
    paramMapObject.a(this);
    float f = this.parent.getScale();
    paramMapObject.a(f);
    boolean bool1 = this.c.add(paramMapObject);
    if (paramMapObject.isTouchable())
      boolean bool2 = this.d.add(paramMapObject);
    MapWidget localMapWidget = this.parent;
    Rect localRect = paramMapObject.getBounds();
    localMapWidget.invalidate(localRect);
  }

  public void clearAll()
  {
    if (Looper.myLooper() == null)
      throw new RuntimeException("clearAll should be called from UI thread.");
    this.c.clear();
    this.d.clear();
    this.c = null;
    this.d = null;
    ArrayList localArrayList1 = new ArrayList();
    this.c = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.d = localArrayList2;
  }

  public void draw(Canvas paramCanvas, Rect paramRect)
  {
    if (!this.b)
      return;
    int i = this.c.size();
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      MapObject localMapObject = (MapObject)this.c.get(j);
      if (Rect.intersects(localMapObject.getBounds(), paramRect))
        localMapObject.draw(paramCanvas);
      j += 1;
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null);
    while (true)
    {
      return bool;
      if ((paramObject instanceof MapLayer))
      {
        long l1 = ((MapLayer)paramObject).a;
        long l2 = this.a;
        if (l1 == l2)
          bool = true;
      }
    }
  }

  public long getId()
  {
    return this.a;
  }

  public MapObject getMapObject(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException();
    Iterator localIterator = this.c.iterator();
    MapObject localMapObject;
    do
    {
      if (!localIterator.hasNext())
        break;
      localMapObject = (MapObject)localIterator.next();
    }
    while (!localMapObject.getId().equals(paramObject));
    while (true)
    {
      return localMapObject;
      localMapObject = null;
    }
  }

  public MapObject getMapObjectByIndex(int paramInt)
  {
    return (MapObject)this.c.get(paramInt);
  }

  public int getMapObjectCount()
  {
    if (this.c != null);
    for (int i = this.c.size(); ; i = 0)
      return i;
  }

  public ArrayList<Object> getTouched(Rect paramRect)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      MapObject localMapObject = (MapObject)localIterator.next();
      if (localMapObject.isTouched(paramRect))
      {
        Object localObject = localMapObject.getId();
        boolean bool = localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }

  public int hashCode()
  {
    long l1 = this.a;
    long l2 = this.a >>> 32;
    return (int)(l1 ^ l2);
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    Rect localRect = paramDrawable.getBounds();
    MapWidget localMapWidget = this.parent;
    int i = localRect.left;
    int j = localRect.top;
    int k = localRect.right;
    int m = localRect.bottom;
    localMapWidget.postInvalidate(i, j, k, m);
  }

  public boolean isVisible()
  {
    return this.b;
  }

  public void removeMapObject(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException();
    if (Looper.myLooper() == null)
      throw new RuntimeException("removeMapObject should be called from UI thread.");
    Object localObject1 = null;
    Iterator localIterator = this.c.iterator();
    Object localObject2;
    do
    {
      if (!localIterator.hasNext())
        break;
      localObject2 = (MapObject)localIterator.next();
    }
    while (!((MapObject)localObject2).getId().equals(paramObject));
    while (true)
    {
      if (localObject2 == null)
        return;
      boolean bool1 = this.c.remove(localObject2);
      boolean bool2 = this.d.remove(localObject2);
      Rect localRect = ((MapObject)localObject2).getDrawable().getBounds();
      MapWidget localMapWidget = this.parent;
      int i = localRect.left;
      int j = localRect.top;
      int k = localRect.right;
      int m = localRect.bottom;
      localMapWidget.postInvalidate(i, j, k, m);
      return;
      localObject2 = localObject1;
    }
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.parent.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
  }

  public void setScale(float paramFloat)
  {
    int i = this.c.size();
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      ((MapObject)this.c.get(j)).a(paramFloat);
      j += 1;
    }
  }

  public void setVisible(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.parent.unscheduleDrawable(paramDrawable, paramRunnable);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.model.MapLayer
 * JD-Core Version:    0.6.2
 */