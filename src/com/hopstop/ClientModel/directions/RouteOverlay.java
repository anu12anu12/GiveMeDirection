package com.hopstop.ClientModel.directions;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class RouteOverlay extends Overlay
  implements HopStopOverlay
{
  private final int defaultAlpha;
  private final int defaultColor;
  private final int defaultWidth;
  private GeoPoint gp1;
  private GeoPoint gp2;
  private int mode = 0;

  public RouteOverlay(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, int paramInt)
  {
    int i = Color.parseColor("#0951bf");
    this.defaultColor = i;
    this.defaultAlpha = 178;
    this.defaultWidth = 8;
    this.gp1 = paramGeoPoint1;
    this.gp2 = paramGeoPoint2;
    this.mode = paramInt;
  }

  public RouteOverlay(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, int paramInt1, int paramInt2)
  {
    int i = Color.parseColor("#0951bf");
    this.defaultColor = i;
    this.defaultAlpha = 178;
    this.defaultWidth = 8;
    this.gp1 = paramGeoPoint1;
    this.gp2 = paramGeoPoint2;
    this.mode = paramInt1;
  }

  public boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong)
  {
    Projection localProjection = paramMapView.getProjection();
    if (!paramBoolean)
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Point localPoint1 = new Point();
      GeoPoint localGeoPoint1 = this.gp1;
      Point localPoint2 = localProjection.toPixels(localGeoPoint1, localPoint1);
      int i = this.defaultColor;
      localPaint.setColor(i);
      Point localPoint3 = new Point();
      GeoPoint localGeoPoint2 = this.gp2;
      Point localPoint4 = localProjection.toPixels(localGeoPoint2, localPoint3);
      localPaint.setStrokeWidth(8.0F);
      localPaint.setAlpha(178);
      float f1 = localPoint1.x;
      float f2 = localPoint1.y;
      float f3 = localPoint3.x;
      float f4 = localPoint3.y;
      paramCanvas.drawLine(f1, f2, f3, f4, localPaint);
    }
    return super.draw(paramCanvas, paramMapView, paramBoolean, paramLong);
  }

  public int getMode()
  {
    return this.mode;
  }

  public boolean recycle()
  {
    if (this.gp1 != null)
      this.gp1 = null;
    if (this.gp2 != null)
      this.gp2 = null;
    return true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.RouteOverlay
 * JD-Core Version:    0.6.2
 */