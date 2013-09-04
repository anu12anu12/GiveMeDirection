package com.ls.widgets.map.utils;

import android.graphics.Point;
import android.graphics.PointF;

public class MathUtils
{
  public static double distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    double d1 = Math.pow(paramFloat1 - paramFloat3, 2.0D);
    double d2 = Math.pow(paramFloat2 - paramFloat4, 2.0D);
    return Math.sqrt(d1 + d2);
  }

  public static double distance(Point paramPoint1, Point paramPoint2)
  {
    int i = paramPoint1.x;
    int j = paramPoint2.x;
    double d1 = Math.pow(i - j, 2.0D);
    int k = paramPoint1.y;
    int m = paramPoint2.y;
    double d2 = Math.pow(k - m, 2.0D);
    return Math.sqrt(d1 + d2);
  }

  public static Point middle(Point paramPoint1, Point paramPoint2)
  {
    int i = paramPoint1.x;
    int j = paramPoint2.x;
    int k = (i + j) / 2;
    int m = paramPoint1.y;
    int n = paramPoint2.y;
    int i1 = (m + n) / 2;
    return new Point(k, i1);
  }

  public static PointF middle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = (paramFloat1 + paramFloat3) / 2.0F;
    float f2 = (paramFloat2 + paramFloat4) / 2.0F;
    return new PointF(f1, f2);
  }

  public static PointF middle(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF2.x;
    float f3 = (f1 + f2) / 2.0F;
    float f4 = paramPointF1.y;
    float f5 = paramPointF2.y;
    float f6 = (f4 + f5) / 2.0F;
    return new PointF(f3, f6);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.utils.MathUtils
 * JD-Core Version:    0.6.2
 */