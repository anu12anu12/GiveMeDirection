package com.androidquery.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public class RatioDrawable extends BitmapDrawable
{
  private boolean adjusted;
  private float anchor;
  private Matrix m;
  private float ratio;
  private WeakReference<ImageView> ref;
  private int w;

  public RatioDrawable(Resources paramResources, Bitmap paramBitmap, ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    super(paramResources, paramBitmap);
    WeakReference localWeakReference = new WeakReference(paramImageView);
    this.ref = localWeakReference;
    this.ratio = paramFloat1;
    this.anchor = paramFloat2;
    ImageView.ScaleType localScaleType = ImageView.ScaleType.MATRIX;
    paramImageView.setScaleType(localScaleType);
    Matrix localMatrix = new Matrix();
    paramImageView.setImageMatrix(localMatrix);
    adjust(paramImageView, paramBitmap, false);
  }

  private void adjust(ImageView paramImageView, Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = getWidth(paramImageView);
    if (i <= 0)
      return;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int n = targetHeight(j, k, i);
    int i1 = paramImageView.getPaddingTop();
    int i2 = n + i1;
    int i3 = paramImageView.getPaddingBottom();
    int i4 = i2 + i3;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    if (localLayoutParams == null)
      return;
    int i5 = localLayoutParams.height;
    if (i4 != i5)
    {
      localLayoutParams.height = i4;
      paramImageView.setLayoutParams(localLayoutParams);
    }
    if (!paramBoolean)
      return;
    this.adjusted = true;
  }

  private void draw(Canvas paramCanvas, ImageView paramImageView, Bitmap paramBitmap)
  {
    Matrix localMatrix = getMatrix(paramImageView, paramBitmap);
    if (localMatrix != null)
    {
      int i = paramImageView.getPaddingTop();
      int j = paramImageView.getPaddingBottom();
      int k = i + j;
      int n = paramImageView.getPaddingLeft();
      int i1 = paramImageView.getPaddingRight();
      int i2 = n + i1;
      if ((k > 0) || (i2 > 0))
      {
        int i3 = paramImageView.getWidth() - i2;
        int i4 = paramImageView.getHeight() - k;
        boolean bool = paramCanvas.clipRect(0, 0, i3, i4);
      }
      Paint localPaint = getPaint();
      paramCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
    }
    if (this.adjusted)
      return;
    adjust(paramImageView, paramBitmap, true);
  }

  private Matrix getMatrix(ImageView paramImageView, Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    if (this.m != null)
    {
      int j = this.w;
      if (i == j);
    }
    int k;
    int n;
    int i1;
    for (Matrix localMatrix1 = this.m; ; localMatrix1 = null)
    {
      return localMatrix1;
      k = paramBitmap.getHeight();
      n = getWidth(paramImageView);
      i1 = targetHeight(i, k, n);
      if ((i > 0) && (k > 0) && (n > 0) && (i1 > 0))
        break;
    }
    float f1;
    float f2;
    float f5;
    if (this.m != null)
    {
      int i2 = this.w;
      if (i == i2);
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
      Matrix localMatrix2 = new Matrix();
      this.m = localMatrix2;
      int i3 = i * i1;
      int i4 = n * k;
      if (i3 < i4)
        break label221;
      float f3 = i1;
      float f4 = k;
      f5 = f3 / f4;
      float f6 = n;
      float f7 = i * f5;
      f1 = (f6 - f7) * 0.5F;
    }
    while (true)
    {
      this.m.setScale(f5, f5);
      boolean bool = this.m.postTranslate(f1, f2);
      this.w = i;
      localMatrix1 = this.m;
      break;
      label221: float f8 = n;
      float f9 = i;
      f5 = f8 / f9;
      float f10 = getYOffset(i, k);
      float f11 = i1;
      float f12 = k * f5;
      f2 = (f11 - f12) * f10;
    }
  }

  private int getWidth(ImageView paramImageView)
  {
    int i = 0;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    if (localLayoutParams != null)
      i = localLayoutParams.width;
    if (i <= 0)
      i = paramImageView.getWidth();
    if (i > 0)
    {
      int j = paramImageView.getPaddingLeft();
      int k = i - j;
      int n = paramImageView.getPaddingRight();
      i = k - n;
    }
    return i;
  }

  private float getYOffset(int paramInt1, int paramInt2)
  {
    float f1;
    if (this.anchor != 3.4028235E+38F)
      f1 = this.anchor;
    float f8;
    for (float f2 = (1.0F - f1) / 2.0F; ; f2 = 0.25F + f8)
    {
      return f2;
      float f3 = paramInt2;
      float f4 = paramInt1;
      float f5 = f3 / f4;
      float f6 = Math.min(1.5F, f5);
      float f7 = Math.max(1.0F, f6);
      f8 = (1.5F - f7) / 2.0F;
    }
  }

  private int targetHeight(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = this.ratio;
    if (this.ratio == 3.4028235E+38F)
    {
      float f2 = paramInt2;
      float f3 = paramInt1;
      f1 = f2 / f3;
    }
    return (int)(paramInt3 * f1);
  }

  public void draw(Canvas paramCanvas)
  {
    ImageView localImageView = null;
    if (this.ref != null)
      localImageView = (ImageView)this.ref.get();
    if ((this.ratio == 0.0F) || (localImageView == null))
    {
      super.draw(paramCanvas);
      return;
    }
    Bitmap localBitmap = getBitmap();
    draw(paramCanvas, localImageView, localBitmap);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.RatioDrawable
 * JD-Core Version:    0.6.2
 */