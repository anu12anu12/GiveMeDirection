package com.hopstop.ClientView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class MyGpsMapOverlay extends Overlay
{
  private GeoPoint _pointToDraw;
  private Resources _resources;

  public MyGpsMapOverlay(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    this._resources = localResources;
  }

  public boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong)
  {
    super.draw(paramCanvas, paramMapView, paramBoolean);
    Point localPoint1 = new Point();
    Projection localProjection = paramMapView.getProjection();
    GeoPoint localGeoPoint = this._pointToDraw;
    Point localPoint2 = localProjection.toPixels(localGeoPoint, localPoint1);
    Bitmap localBitmap = BitmapFactory.decodeResource(this._resources, 2130837528);
    float f1 = localPoint1.x;
    float f2 = localPoint1.y + -24;
    paramCanvas.drawBitmap(localBitmap, f1, f2, null);
    return true;
  }

  public GeoPoint getPointToDraw()
  {
    return this._pointToDraw;
  }

  public void setPointToDraw(GeoPoint paramGeoPoint)
  {
    this._pointToDraw = paramGeoPoint;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MyGpsMapOverlay
 * JD-Core Version:    0.6.2
 */