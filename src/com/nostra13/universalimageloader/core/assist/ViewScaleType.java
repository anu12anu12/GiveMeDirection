package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public enum ViewScaleType
{
  static
  {
    CROP = new ViewScaleType("CROP", 1);
    ViewScaleType[] arrayOfViewScaleType = new ViewScaleType[2];
    ViewScaleType localViewScaleType1 = FIT_INSIDE;
    arrayOfViewScaleType[0] = localViewScaleType1;
    ViewScaleType localViewScaleType2 = CROP;
    arrayOfViewScaleType[1] = localViewScaleType2;
  }

  public static ViewScaleType fromImageView(ImageView paramImageView)
  {
    int[] arrayOfInt = 1.$SwitchMap$android$widget$ImageView$ScaleType;
    int i = paramImageView.getScaleType().ordinal();
    switch (arrayOfInt[i])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    for (ViewScaleType localViewScaleType = CROP; ; localViewScaleType = FIT_INSIDE)
      return localViewScaleType;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ViewScaleType
 * JD-Core Version:    0.6.2
 */