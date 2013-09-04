package com.MASTAdView;

import android.widget.Button;

public class VisibilityButtonRunnable
  implements Runnable
{
  private Button button;
  private int visibility;

  public VisibilityButtonRunnable(Button paramButton, int paramInt)
  {
    this.button = paramButton;
    this.visibility = paramInt;
  }

  public void run()
  {
    if (this.button == null)
      return;
    Button localButton = this.button;
    int i = this.visibility;
    localButton.setVisibility(i);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.VisibilityButtonRunnable
 * JD-Core Version:    0.6.2
 */