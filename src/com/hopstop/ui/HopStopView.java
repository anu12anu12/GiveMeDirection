package com.hopstop.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class HopStopView extends View
{
  public HopStopView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public HopStopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public HopStopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public HopStopView copy()
  {
    Context localContext = getContext();
    return new HopStopView(localContext);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.HopStopView
 * JD-Core Version:    0.6.2
 */