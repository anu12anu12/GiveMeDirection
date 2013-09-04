package com.hopstop.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;

public class HopStopViewGroup extends ViewGroup
{
  private ImageView _image;

  public HopStopViewGroup(Context paramContext)
  {
    super(paramContext);
  }

  public HopStopViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ImageView localImageView = new ImageView(paramContext);
    this._image = localImageView;
    this._image.setImageResource(2130837611);
  }

  private void drawPict(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    int i = paramCanvas.save();
    float f1 = paramInt1;
    float f2 = paramInt2;
    paramCanvas.translate(f1, f2);
    boolean bool = paramCanvas.clipRect(0, 0, paramInt3, paramInt4);
    paramCanvas.scale(0.5F, 0.5F);
    float f3 = paramInt3;
    float f4 = paramInt4;
    paramCanvas.scale(paramFloat1, paramFloat2, f3, f4);
    Drawable localDrawable = getBackground();
    Rect localRect = new Rect(0, 0, 200, 50);
    localDrawable.setBounds(localRect);
    paramCanvas.restore();
  }

  public void addView(View paramView)
  {
    if (getChildCount() > 1)
      throw new IllegalStateException("PictureLayout can host only one direct child");
    super.addView(paramView);
  }

  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 1)
      throw new IllegalStateException("PictureLayout can host only one direct child");
    super.addView(paramView, paramInt);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 1)
      throw new IllegalStateException("PictureLayout can host only one direct child");
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 1)
      throw new IllegalStateException("PictureLayout can host only one direct child");
    super.addView(paramView, paramLayoutParams);
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -1);
  }

  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    int i = getLeft();
    paramArrayOfInt[0] = i;
    int j = getTop();
    paramArrayOfInt[1] = j;
    int k = getWidth();
    int m = getHeight();
    paramRect.set(0, 0, k, m);
    return getParent();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = super.getChildCount();
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        int k = getPaddingLeft();
        int m = getPaddingTop();
        int n = localView.getMeasuredWidth() + k;
        int i1 = localView.getMeasuredHeight() + m;
        localView.layout(k, m, n, i1);
      }
      j += 1;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    while (true)
    {
      if (j >= i)
      {
        int k = getPaddingLeft();
        int m = getPaddingRight();
        int n = k + m;
        int i1 = 0 + n;
        int i2 = getPaddingTop();
        int i3 = getPaddingBottom();
        int i4 = i2 + i3;
        int i5 = 0 + i4;
        Drawable localDrawable = getBackground();
        if (localDrawable != null)
        {
          int i6 = localDrawable.getMinimumHeight();
          i5 = Math.max(i5, i6);
          int i7 = localDrawable.getMinimumWidth();
          i1 = Math.max(i1, i7);
        }
        int i8 = resolveSize(i1, paramInt1);
        int i9 = resolveSize(i5, paramInt2);
        setMeasuredDimension(i8, i9);
        return;
      }
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
        measureChild(localView, paramInt1, paramInt2);
      j += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.HopStopViewGroup
 * JD-Core Version:    0.6.2
 */