package com.hopstop.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class SubwayRail extends RadioButton
  implements View.OnClickListener
{
  public SubwayRail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }

  private void init(Context paramContext)
  {
    setOnClickListener(this);
  }

  public void onClick(View paramView)
  {
  }

  public void setSelected(boolean paramBoolean)
  {
    setSelected(paramBoolean);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.SubwayRail
 * JD-Core Version:    0.6.2
 */