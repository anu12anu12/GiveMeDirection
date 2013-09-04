package com.ls.widgets.map.location;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import com.ls.widgets.map.MapWidget;
import com.ls.widgets.map.config.GPSConfig;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.model.MapObject;
import com.ls.widgets.map.utils.MapCalibrationData;
import com.ls.widgets.map.utils.PivotFactory;
import com.ls.widgets.map.utils.PivotFactory.PivotPosition;

public class PositionMarker extends MapObject
{
  private float a;
  private float b;
  private boolean c;
  private float d;
  private float e;
  private double f;
  private double g;
  private ShapeDrawable h;
  private Paint i;
  private Drawable j;
  private Drawable k;
  private MapWidget l;
  private Point m;
  private Point n;

  public PositionMarker(MapWidget paramMapWidget, Object paramObject, Drawable paramDrawable1, Drawable paramDrawable2)
  {
  }

  private float a()
  {
    if (this.e == 0.0F)
    {
      MapWidget localMapWidget = this.l;
      float f1 = a(localMapWidget);
      this.e = f1;
    }
    float f2 = this.a;
    float f3 = this.e;
    float f4 = f2 * f3;
    float f5 = this.scale;
    return f4 * f5 * 2.0F;
  }

  private float a(MapWidget paramMapWidget)
  {
    float f1 = 0.0F;
    if (paramMapWidget == null);
    while (true)
    {
      return f1;
      GPSConfig localGPSConfig = paramMapWidget.getGpsConfig();
      if ((localGPSConfig != null) && (localGPSConfig.isMapCalibrated()))
      {
        MapCalibrationData localMapCalibrationData = localGPSConfig.getCalibration();
        float f2 = paramMapWidget.getConfig().getImageWidth();
        float f3 = localMapCalibrationData.getWidthInMeters();
        f1 = f2 / f3;
      }
    }
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.a > 50.0F)
    {
      this.h.draw(paramCanvas);
      float f1 = (float)this.f;
      float f2 = (float)this.g;
      float f3 = this.d - 1.0F;
      Paint localPaint = this.i;
      paramCanvas.drawCircle(f1, f2, f3, localPaint);
    }
    if (!this.c)
    {
      super.draw(paramCanvas);
      return;
    }
    int i1 = paramCanvas.save(1);
    float f4 = this.b;
    float f5 = (float)this.f;
    float f6 = (float)this.g;
    paramCanvas.rotate(f4, f5, f6);
    super.draw(paramCanvas);
    paramCanvas.restore();
  }

  public Rect getBounds()
  {
    Rect localRect1 = super.getBounds();
    double d1 = this.d * 2.0D;
    double d2 = localRect1.width();
    Rect localRect2;
    if (d1 >= d2)
      localRect2 = this.h.getBounds();
    while (true)
    {
      return localRect2;
      if (this.c)
      {
        localRect2 = new Rect(localRect1);
        int i1 = localRect2.width();
        int i2 = localRect1.height();
        if (i1 > i2)
        {
          int i3 = localRect2.top + i1;
          localRect2.bottom = i3;
        }
        else if (i1 > i2)
        {
          int i4 = localRect2.left + i2;
          localRect2.right = i4;
        }
      }
      else
      {
        localRect2 = localRect1;
      }
    }
  }

  protected void recalculateBounds()
  {
    super.recalculateBounds();
    float f1 = a() / 2.0F;
    if (this.h == null)
      return;
    Rect localRect = super.getBounds();
    float f2 = a();
    float f3 = f2 / 2.0F;
    this.d = f3;
    this.h.getShape().resize(f2, f2);
    double d1 = this.posScaled.x;
    double d2 = localRect.width() / 2.0D;
    double d3 = d1 + d2;
    double d4 = this.pivotPoint.x;
    double d5 = d3 - d4;
    this.f = d5;
    double d6 = this.posScaled.y;
    double d7 = localRect.height() / 2.0D;
    double d8 = d6 + d7;
    double d9 = this.pivotPoint.y;
    double d10 = d8 - d9;
    this.g = d10;
    ShapeDrawable localShapeDrawable = this.h;
    double d11 = this.f;
    double d12 = f1;
    int i1 = (int)(d11 - d12);
    double d13 = this.g;
    double d14 = f1;
    int i2 = (int)(d13 - d14);
    double d15 = this.f;
    double d16 = f1;
    int i3 = (int)(d15 + d16);
    double d17 = this.g;
    double d18 = f1;
    int i4 = (int)(d17 + d18);
    localShapeDrawable.setBounds(i1, i2, i3, i4);
  }

  public void setAccuracy(float paramFloat)
  {
    invalidateSelf();
    this.a = paramFloat;
    recalculateBounds();
    invalidateSelf();
  }

  public void setArrowPointer(Drawable paramDrawable, Point paramPoint)
  {
    this.j = paramDrawable;
    this.n = paramPoint;
  }

  public void setBearing(float paramFloat)
  {
    invalidateSelf();
    this.b = paramFloat;
    invalidateSelf();
  }

  public void setBearingEnabled(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (paramBoolean)
    {
      Drawable localDrawable1 = this.j;
      setDrawable(localDrawable1);
      if (this.n == null)
      {
        Drawable localDrawable2 = this.j;
        PivotFactory.PivotPosition localPivotPosition1 = PivotFactory.PivotPosition.PIVOT_CENTER;
        Point localPoint1 = PivotFactory.createPivotPoint(localDrawable2, localPivotPosition1);
        setPivotPoint(localPoint1);
      }
    }
    while (true)
    {
      recalculateBounds();
      return;
      Point localPoint2 = this.n;
      setPivotPoint(localPoint2);
      continue;
      Drawable localDrawable3 = this.k;
      setDrawable(localDrawable3);
      if (this.m == null)
      {
        Drawable localDrawable4 = this.k;
        PivotFactory.PivotPosition localPivotPosition2 = PivotFactory.PivotPosition.PIVOT_CENTER;
        Point localPoint3 = PivotFactory.createPivotPoint(localDrawable4, localPivotPosition2);
        setPivotPoint(localPoint3);
      }
      else
      {
        Point localPoint4 = this.m;
        setPivotPoint(localPoint4);
      }
    }
  }

  public void setColor(int paramInt1, int paramInt2)
  {
    this.h.getPaint().setColor(paramInt1);
    this.i.setColor(paramInt2);
  }

  public void setDotPointer(Drawable paramDrawable, Point paramPoint)
  {
    this.k = paramDrawable;
    this.m = paramPoint;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.location.PositionMarker
 * JD-Core Version:    0.6.2
 */