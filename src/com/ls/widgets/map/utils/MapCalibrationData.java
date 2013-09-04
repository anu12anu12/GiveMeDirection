package com.ls.widgets.map.utils;

import android.graphics.Point;
import android.location.Location;
import android.util.Pair;

public class MapCalibrationData
{
  private Pair<Point, Location> a;
  private Pair<Point, Location> b;
  private float c;
  private float d;
  private float[] e;

  public MapCalibrationData(Pair<Point, Location> paramPair1, Pair<Point, Location> paramPair2)
  {
    this.a = paramPair1;
    this.b = paramPair2;
    float[] arrayOfFloat = new float[3];
    this.e = arrayOfFloat;
    a();
  }

  private void a()
  {
    double d1 = ((Location)this.a.second).getLatitude();
    double d2 = ((Location)this.a.second).getLongitude();
    double d3 = ((Location)this.a.second).getLatitude();
    double d4 = ((Location)this.b.second).getLongitude();
    float[] arrayOfFloat1 = this.e;
    Location.distanceBetween(d1, d2, d3, d4, arrayOfFloat1);
    int i = this.e[0];
    this.c = i;
    double d5 = ((Location)this.b.second).getLatitude();
    double d6 = ((Location)this.a.second).getLongitude();
    double d7 = ((Location)this.a.second).getLatitude();
    double d8 = ((Location)this.a.second).getLongitude();
    float[] arrayOfFloat2 = this.e;
    Location.distanceBetween(d5, d6, d7, d8, arrayOfFloat2);
    int j = this.e[0];
    this.d = j;
  }

  public float getHeightInMeters()
  {
    return this.d;
  }

  public float getWidthInMeters()
  {
    return this.c;
  }

  public double heightInDegrees()
  {
    double d1 = ((Location)this.a.second).getLatitude();
    double d2 = ((Location)this.b.second).getLatitude();
    return d1 - d2;
  }

  public int heightInPixels()
  {
    int i = ((Point)this.b.first).y;
    int j = ((Point)this.a.first).y;
    return i - j;
  }

  public Point translate(Location paramLocation, Point paramPoint)
  {
    double d1 = ((Location)this.a.second).getLatitude();
    double d2 = paramLocation.getLatitude();
    double d3 = d1 - d2;
    double d4 = heightInDegrees();
    double d5 = d3 / d4;
    double d6 = paramLocation.getLongitude();
    double d7 = ((Location)this.a.second).getLongitude();
    double d8 = d6 - d7;
    double d9 = widthInDegrees();
    double d10 = d8 / d9;
    if (paramPoint == null)
      paramPoint = new Point();
    double d11 = widthInPixels();
    double d12 = d10 * d11;
    double d13 = ((Point)this.a.first).x;
    int i = (int)(d12 + d13);
    paramPoint.x = i;
    double d14 = heightInPixels();
    double d15 = d5 * d14;
    double d16 = ((Point)this.a.first).y;
    int j = (int)(d15 + d16);
    paramPoint.y = j;
    return paramPoint;
  }

  public void translate(int paramInt1, int paramInt2, Location paramLocation)
  {
    float f1 = ((Point)this.a.first).y - paramInt2;
    float f2 = heightInPixels();
    double d1 = f1 / f2;
    int i = ((Point)this.a.first).x;
    float f3 = paramInt1 - i;
    float f4 = widthInPixels();
    double d2 = f3 / f4;
    double d3 = heightInDegrees();
    double d4 = d1 * d3;
    double d5 = ((Location)this.a.second).getLatitude();
    double d6 = d4 + d5;
    paramLocation.setLatitude(d6);
    float f5 = widthInDegrees() * d2;
    double d7 = ((Location)this.a.second).getLongitude();
    double d8 = f5 + d7;
    paramLocation.setLongitude(d8);
  }

  public void translate(Point paramPoint, Location paramLocation)
  {
    int i = paramPoint.x;
    int j = paramPoint.y;
    translate(i, j, paramLocation);
  }

  public double widthInDegrees()
  {
    double d1 = ((Location)this.b.second).getLongitude();
    double d2 = ((Location)this.a.second).getLongitude();
    return d1 - d2;
  }

  public int widthInPixels()
  {
    int i = ((Point)this.b.first).x;
    int j = ((Point)this.a.first).x;
    return i - j;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.utils.MapCalibrationData
 * JD-Core Version:    0.6.2
 */