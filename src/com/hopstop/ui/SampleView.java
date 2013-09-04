package com.hopstop.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SampleView extends View
{
  private GradientDrawable mDrawable;
  private Paint mPaint;
  private Path mPath;
  private Rect mRect;

  public SampleView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public SampleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SampleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    Path localPath = new Path();
    this.mPath = localPath;
    Paint localPaint = new Paint(1);
    this.mPaint = localPaint;
    Rect localRect = new Rect(0, 0, 120, 120);
    this.mRect = localRect;
    GradientDrawable.Orientation localOrientation = GradientDrawable.Orientation.TL_BR;
    int[] arrayOfInt = { -65536, -16711936, -16776961 };
    GradientDrawable localGradientDrawable1 = new GradientDrawable(localOrientation, arrayOfInt);
    this.mDrawable = localGradientDrawable1;
    this.mDrawable.setShape(0);
    GradientDrawable localGradientDrawable2 = this.mDrawable;
    float f = (float)(Math.sqrt(2.0D) * 60.0D);
    localGradientDrawable2.setGradientRadius(f);
  }

  static void setCornerRadii(GradientDrawable paramGradientDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[2] = paramFloat2;
    arrayOfFloat[3] = paramFloat2;
    arrayOfFloat[4] = paramFloat3;
    arrayOfFloat[5] = paramFloat3;
    arrayOfFloat[6] = paramFloat4;
    arrayOfFloat[7] = paramFloat4;
    paramGradientDrawable.setCornerRadii(arrayOfFloat);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    GradientDrawable localGradientDrawable = this.mDrawable;
    Rect localRect = this.mRect;
    localGradientDrawable.setBounds(localRect);
    int i = paramCanvas.save();
    paramCanvas.translate(10.0F, 10.0F);
    this.mDrawable.setGradientType(0);
    setCornerRadii(this.mDrawable, 16.0F, 16.0F, 0.0F, 0.0F);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
    int j = paramCanvas.save();
    float f1 = this.mRect.width() + 10 + 10;
    paramCanvas.translate(f1, 10.0F);
    this.mDrawable.setGradientType(1);
    setCornerRadii(this.mDrawable, 0.0F, 0.0F, 16.0F, 16.0F);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
    float f2 = this.mRect.height() + 10;
    paramCanvas.translate(0.0F, f2);
    int k = paramCanvas.save();
    paramCanvas.translate(10.0F, 10.0F);
    this.mDrawable.setGradientType(2);
    setCornerRadii(this.mDrawable, 0.0F, 16.0F, 16.0F, 0.0F);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
    int m = paramCanvas.save();
    float f3 = this.mRect.width() + 10 + 10;
    paramCanvas.translate(f3, 10.0F);
    this.mDrawable.setGradientType(0);
    setCornerRadii(this.mDrawable, 16.0F, 0.0F, 0.0F, 16.0F);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
    float f4 = this.mRect.height() + 10;
    paramCanvas.translate(0.0F, f4);
    int n = paramCanvas.save();
    paramCanvas.translate(10.0F, 10.0F);
    this.mDrawable.setGradientType(1);
    setCornerRadii(this.mDrawable, 16.0F, 0.0F, 16.0F, 0.0F);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
    int i1 = paramCanvas.save();
    float f5 = this.mRect.width() + 10 + 10;
    paramCanvas.translate(f5, 10.0F);
    this.mDrawable.setGradientType(2);
    setCornerRadii(this.mDrawable, 0.0F, 16.0F, 0.0F, 16.0F);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = getWidth();
    int j = getHeight();
    int k = getLeft();
    int m = getRight();
    float f = paramMotionEvent.getX();
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.SampleView
 * JD-Core Version:    0.6.2
 */