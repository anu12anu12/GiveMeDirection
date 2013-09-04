package com.hopstop.ClientModel.directions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class WrappedImageViewLayout extends LinearLayout
  implements ViewStep
{
  private int line_height;

  static
  {
    if (!WrappedImageViewLayout.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public WrappedImageViewLayout(Context paramContext)
  {
    super(paramContext);
  }

  public WrappedImageViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void addBitmap(int paramInt, Bitmap paramBitmap)
  {
    int i = getChildCount();
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      if ((getChildAt(paramInt) instanceof WrappedImageView))
      {
        WrappedImageView localWrappedImageView = (WrappedImageView)getChildAt(j);
        if (localWrappedImageView.getIndex() != paramInt)
          localWrappedImageView.setImageBitmap(paramBitmap);
        localWrappedImageView.invalidate();
      }
      j += 1;
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public ViewStep cloneItself()
  {
    return null;
  }

  public void downloadError(int paramInt)
  {
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }

  protected LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(1, 1);
  }

  public Bitmap getBitmap()
  {
    return null;
  }

  public String getURL()
  {
    return null;
  }

  public boolean isDownloading()
  {
    return false;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt3 - paramInt1;
    int k = getPaddingLeft();
    int m = getPaddingTop();
    int n = 0;
    while (true)
    {
      if (n >= i)
        return;
      View localView = getChildAt(n);
      if (localView.getVisibility() != 8)
      {
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (k + i1 > j)
        {
          k = getPaddingLeft();
          int i3 = this.line_height;
          m += i3;
        }
        int i4 = k + i1;
        int i5 = m + i2;
        localView.layout(k, m, i4, i5);
        int i6 = localLayoutParams.horizontal_spacing + i1;
        int i7 = k + i6;
      }
      n += 1;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    assert (View.MeasureSpec.getMode(paramInt1) != 0);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = i - j;
    int m = getPaddingRight();
    int n = k - m;
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int i2 = getPaddingTop();
    int i3 = i1 - i2;
    int i4 = getPaddingBottom();
    int i5 = i3 - i4;
    int i6 = getChildCount();
    int i7 = 0;
    int i8 = getPaddingLeft();
    int i9 = getPaddingTop();
    int i10;
    int i11;
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648)
    {
      i10 = View.MeasureSpec.makeMeasureSpec(i5, -2147483648);
      i11 = 0;
      label125: if (i11 < i6)
        break label171;
      this.line_height = i7;
      if (View.MeasureSpec.getMode(paramInt2) != 0)
        break label303;
    }
    for (i5 = i9 + i7; ; i5 = i9 + i7)
      label171: label303: 
      do
      {
        setMeasuredDimension(n, i5);
        return;
        i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break;
        View localView = getChildAt(i11);
        if (localView.getVisibility() != 8)
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          int i12 = View.MeasureSpec.makeMeasureSpec(n, -2147483648);
          localView.measure(i12, i10);
          int i13 = localView.getMeasuredWidth();
          int i14 = localView.getMeasuredHeight();
          int i15 = localLayoutParams.vertical_spacing;
          int i16 = i14 + i15;
          i7 = Math.max(i7, i16);
          if (i8 + i13 > n)
          {
            i8 = getPaddingLeft();
            int i17 = i9 + i7;
          }
          int i18 = localLayoutParams.horizontal_spacing + i13;
          int i19 = i8 + i18;
        }
        i11 += 1;
        break label125;
      }
      while ((View.MeasureSpec.getMode(paramInt2) != -2147483648) || (i9 + i7 >= i5));
  }

  public void recycle(boolean paramBoolean)
  {
    int i = getChildCount();
    int j = 0;
    while (true)
    {
      if (j >= i)
      {
        removeAllViews();
        return;
      }
      ImageView localImageView = (ImageView)getChildAt(j);
      if (localImageView != null)
      {
        localImageView.setImageBitmap(null);
        removeView(localImageView);
      }
      j += 1;
    }
  }

  public void setBitmap(Bitmap paramBitmap)
  {
  }

  public void setDownloading(boolean paramBoolean)
  {
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
  }

  public static class LayoutParams extends LinearLayout.LayoutParams
  {
    public final int horizontal_spacing;
    public final int vertical_spacing;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(0);
      this.horizontal_spacing = paramInt1;
      this.vertical_spacing = paramInt2;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.WrappedImageViewLayout
 * JD-Core Version:    0.6.2
 */