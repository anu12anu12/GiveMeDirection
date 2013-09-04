package com.hopstop.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageView;

public class HopStopEditText extends EditText
{
  private ImageView _image;
  private Paint mPaint;
  private Path mPath;
  private Rect mRect;

  public HopStopEditText(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public HopStopEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public HopStopEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
 * Qualified Name:     com.hopstop.ui.HopStopEditText
 * JD-Core Version:    0.6.2
 */