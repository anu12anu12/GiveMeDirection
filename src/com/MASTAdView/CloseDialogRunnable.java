package com.MASTAdView;

import android.app.Dialog;

public class CloseDialogRunnable
  implements Runnable
{
  private Dialog dialog;

  public CloseDialogRunnable(Dialog paramDialog)
  {
    this.dialog = paramDialog;
  }

  public void run()
  {
    if (this.dialog == null)
      return;
    this.dialog.dismiss();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.CloseDialogRunnable
 * JD-Core Version:    0.6.2
 */