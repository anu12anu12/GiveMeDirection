package com.ls.widgets.map.utils;

import android.graphics.Matrix;
import android.graphics.Rect;

public class TransformUtils
{
  private static final Matrix a = new Matrix();

  public static Rect scaleRect(Rect paramRect, float paramFloat, int paramInt1, int paramInt2)
  {
    a.reset();
    Matrix localMatrix = a;
    float f1 = paramInt1;
    float f2 = paramInt2;
    localMatrix.setScale(paramFloat, paramFloat, f1, f2);
    float[] arrayOfFloat = new float[4];
    float f3 = paramRect.left;
    arrayOfFloat[0] = f3;
    float f4 = paramRect.top;
    arrayOfFloat[1] = f4;
    float f5 = paramRect.right;
    arrayOfFloat[2] = f5;
    float f6 = paramRect.bottom;
    arrayOfFloat[3] = f6;
    a.mapPoints(arrayOfFloat);
    int i = (int)arrayOfFloat[0];
    int j = (int)arrayOfFloat[1];
    int k = (int)arrayOfFloat[2];
    int m = (int)arrayOfFloat[3];
    return new Rect(i, j, k, m);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.utils.TransformUtils
 * JD-Core Version:    0.6.2
 */