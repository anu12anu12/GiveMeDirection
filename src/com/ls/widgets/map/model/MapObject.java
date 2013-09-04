package com.ls.widgets.map.model;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.ls.widgets.map.config.GPSConfig;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.utils.MapCalibrationData;

public class MapObject
{
  private Object a;
  private Drawable b;
  private boolean c;
  private boolean d;
  protected MapLayer parent;
  protected Point pivotPoint;
  protected Point pos;
  protected Point posScaled;
  protected float scale;
  protected Rect touchRect;

  public MapObject(Object paramObject)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramObject;
    this.b = paramDrawable;
    Point localPoint1 = new Point(paramInt1, paramInt2);
    this.pos = localPoint1;
    Point localPoint2 = new Point();
    this.posScaled = localPoint2;
    Point localPoint3 = new Point(paramInt3, paramInt4);
    this.pivotPoint = localPoint3;
    this.d = paramBoolean1;
    this.c = paramBoolean2;
    this.scale = 1.0F;
    Rect localRect = new Rect();
    this.touchRect = localRect;
  }

  public MapObject(Object paramObject, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, Point paramPoint)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, Point paramPoint1, Point paramPoint2)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, Point paramPoint, boolean paramBoolean)
  {
  }

  public MapObject(Object paramObject, Drawable paramDrawable, Point paramPoint, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  void a(float paramFloat)
  {
    this.scale = paramFloat;
    recalculateBounds();
  }

  void a(MapLayer paramMapLayer)
  {
    this.parent = paramMapLayer;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.b == null)
      return;
    this.b.draw(paramCanvas);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null);
    while (true)
    {
      return bool;
      if ((paramObject instanceof MapObject))
      {
        Object localObject1 = ((MapObject)paramObject).a;
        Object localObject2 = this.a;
        bool = localObject1.equals(localObject2);
      }
    }
  }

  public Rect getBounds()
  {
    if (this.b != null);
    for (Rect localRect = this.b.getBounds(); ; localRect = null)
      return localRect;
  }

  public Drawable getDrawable()
  {
    return this.b;
  }

  public Object getId()
  {
    return this.a;
  }

  public Point getPosition()
  {
    return this.pos;
  }

  public int getX()
  {
    return this.pos.x;
  }

  public int getXScaled()
  {
    return this.posScaled.x;
  }

  public int getY()
  {
    return this.pos.y;
  }

  public int getYScaled()
  {
    return this.posScaled.y;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  protected void invalidateSelf()
  {
    this.parent.a(this);
  }

  public boolean isTouchable()
  {
    return this.d;
  }

  public boolean isTouched(Rect paramRect)
  {
    return Rect.intersects(this.touchRect, paramRect);
  }

  public void moveTo(int paramInt1, int paramInt2)
  {
    invalidateSelf();
    this.pos.x = paramInt1;
    this.pos.y = paramInt2;
    recalculateBounds();
    invalidateSelf();
  }

  public void moveTo(Location paramLocation)
  {
    GPSConfig localGPSConfig = this.parent.a().getGpsConfig();
    if (!localGPSConfig.isMapCalibrated())
    {
      int i = Log.w("MapObject", "Can't move object to location because map has not been calibrated.");
      throw new IllegalStateException("Map is not calibrated. Please, add calibration info into map's configuration file.");
    }
    invalidateSelf();
    if (!localGPSConfig.isMapCalibrated())
      return;
    MapCalibrationData localMapCalibrationData = localGPSConfig.getCalibration();
    Point localPoint1 = this.pos;
    Point localPoint2 = localMapCalibrationData.translate(paramLocation, localPoint1);
    recalculateBounds();
    invalidateSelf();
  }

  protected void recalculateBounds()
  {
    Point localPoint1 = this.posScaled;
    float f1 = this.pos.x;
    float f2 = this.scale;
    int i = (int)(f1 * f2);
    localPoint1.x = i;
    Point localPoint2 = this.posScaled;
    float f3 = this.pos.y;
    float f4 = this.scale;
    int j = (int)(f3 * f4);
    localPoint2.y = j;
    if (this.b == null)
      return;
    int k = this.b.getIntrinsicWidth();
    int m = this.b.getIntrinsicHeight();
    if (!this.c)
    {
      Drawable localDrawable1 = this.b;
      int n = this.posScaled.x;
      int i1 = this.pivotPoint.x;
      int i2 = n - i1;
      int i3 = this.posScaled.y;
      int i4 = this.pivotPoint.y;
      int i5 = i3 - i4;
      int i6 = this.posScaled.x;
      int i7 = k + i6;
      int i8 = this.pivotPoint.x;
      int i9 = i7 - i8;
      int i10 = this.posScaled.y;
      int i11 = m + i10;
      int i12 = this.pivotPoint.y;
      int i13 = i11 - i12;
      localDrawable1.setBounds(i2, i5, i9, i13);
    }
    while (true)
    {
      if (!this.d)
        return;
      Rect localRect1 = this.touchRect;
      Rect localRect2 = this.b.getBounds();
      localRect1.set(localRect2);
      return;
      Drawable localDrawable2 = this.b;
      int i14 = this.posScaled.x;
      float f5 = this.pivotPoint.x;
      float f6 = this.scale;
      int i15 = (int)(f5 * f6);
      int i16 = i14 - i15;
      int i17 = this.posScaled.y;
      float f7 = this.pivotPoint.y;
      float f8 = this.scale;
      int i18 = (int)(f7 * f8);
      int i19 = i17 - i18;
      int i20 = this.posScaled.x;
      float f9 = k;
      float f10 = this.scale;
      int i21 = (int)(f9 * f10) + i20;
      float f11 = this.pivotPoint.x;
      float f12 = this.scale;
      int i22 = (int)(f11 * f12);
      int i23 = i21 - i22;
      int i24 = this.posScaled.y;
      float f13 = m;
      float f14 = this.scale;
      int i25 = (int)(f13 * f14) + i24;
      float f15 = this.pivotPoint.y;
      float f16 = this.scale;
      int i26 = (int)(f15 * f16);
      int i27 = i25 - i26;
      localDrawable2.setBounds(i16, i19, i23, i27);
    }
  }

  public void setDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null)
      throw new IllegalArgumentException();
    if (Looper.myLooper() == null)
      throw new IllegalThreadStateException("setDrawable should be called from UI thread");
    this.b = paramDrawable;
    recalculateBounds();
  }

  public void setPivotPoint(int paramInt1, int paramInt2)
  {
    this.pivotPoint.x = paramInt1;
    this.pivotPoint.y = paramInt2;
  }

  public void setPivotPoint(Point paramPoint)
  {
    if (paramPoint == null)
      throw new IllegalArgumentException();
    this.pivotPoint = paramPoint;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.model.MapObject
 * JD-Core Version:    0.6.2
 */