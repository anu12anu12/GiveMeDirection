package com.hopstop.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.hopstop.R.styleable;

public class RadioButtonCenter extends RadioButton
{
  Drawable buttonDrawable;

  public RadioButtonCenter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = R.styleable.CompoundButton;
    Drawable localDrawable = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0).getDrawable(1);
    this.buttonDrawable = localDrawable;
    setButtonDrawable(17170445);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.buttonDrawable == null)
      return;
    Drawable localDrawable1 = this.buttonDrawable;
    int[] arrayOfInt = getDrawableState();
    boolean bool = localDrawable1.setState(arrayOfInt);
    int i = getGravity() & 0x70;
    int j = this.buttonDrawable.getIntrinsicHeight();
    int k = 0;
    switch (i)
    {
    default:
    case 80:
    case 16:
    }
    while (true)
    {
      int m = this.buttonDrawable.getIntrinsicWidth();
      int n = (getWidth() - m) / 2;
      Drawable localDrawable2 = this.buttonDrawable;
      int i1 = n + m;
      int i2 = k + j;
      localDrawable2.setBounds(n, k, i1, i2);
      this.buttonDrawable.draw(paramCanvas);
      return;
      k = getHeight() - j;
      continue;
      k = (getHeight() - j) / 2;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.RadioButtonCenter
 * JD-Core Version:    0.6.2
 */