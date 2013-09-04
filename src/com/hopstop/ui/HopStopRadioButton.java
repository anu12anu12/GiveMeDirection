package com.hopstop.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;

public class HopStopRadioButton extends CompoundButton
  implements View.OnClickListener
{
  private Button delete_btn;

  public HopStopRadioButton(Context paramContext)
  {
    this(paramContext, null);
    init(paramContext);
  }

  public HopStopRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131427331);
    init(paramContext);
  }

  public HopStopRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }

  private void init(Context paramContext)
  {
  }

  public void onClick(View paramView)
  {
    if (isChecked())
      return;
    super.toggle();
  }

  public void setDeleteButton(Button paramButton)
  {
    this.delete_btn = paramButton;
  }

  public void toggle()
  {
    if (!isChecked())
      this.delete_btn.setVisibility(0);
    while (true)
    {
      super.toggle();
      return;
      this.delete_btn.setVisibility(4);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.HopStopRadioButton
 * JD-Core Version:    0.6.2
 */