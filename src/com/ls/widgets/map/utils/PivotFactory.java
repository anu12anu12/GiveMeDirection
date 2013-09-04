package com.ls.widgets.map.utils;

import android.graphics.Point;
import android.graphics.drawable.Drawable;

public class PivotFactory
{
  public static Point createPivotPoint(Drawable paramDrawable, PivotPosition paramPivotPosition)
  {
    if (paramDrawable == null)
      throw new IllegalArgumentException();
    int[] arrayOfInt = 1.a;
    int i = paramPivotPosition.ordinal();
    Point localPoint;
    switch (arrayOfInt[i])
    {
    default:
      localPoint = null;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localPoint;
      localPoint = new Point(0, 0);
      continue;
      int j = paramDrawable.getIntrinsicWidth() / 2;
      int k = paramDrawable.getIntrinsicHeight() / 2;
      localPoint = new Point(j, k);
      continue;
      int m = paramDrawable.getIntrinsicWidth() / 2;
      int n = paramDrawable.getIntrinsicHeight();
      localPoint = new Point(m, n);
    }
  }

  public static enum PivotPosition
  {
    static
    {
      PIVOT_CENTER = new PivotPosition("PIVOT_CENTER", 1);
      PIVOT_BOTTOM_CENTER = new PivotPosition("PIVOT_BOTTOM_CENTER", 2);
      PivotPosition[] arrayOfPivotPosition = new PivotPosition[3];
      PivotPosition localPivotPosition1 = PIVOT_TOP_LEFT;
      arrayOfPivotPosition[0] = localPivotPosition1;
      PivotPosition localPivotPosition2 = PIVOT_CENTER;
      arrayOfPivotPosition[1] = localPivotPosition2;
      PivotPosition localPivotPosition3 = PIVOT_BOTTOM_CENTER;
      arrayOfPivotPosition[2] = localPivotPosition3;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.utils.PivotFactory
 * JD-Core Version:    0.6.2
 */