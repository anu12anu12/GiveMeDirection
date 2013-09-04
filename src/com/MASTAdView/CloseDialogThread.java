package com.MASTAdView;

import android.app.Dialog;
import android.os.Handler;

public class CloseDialogThread extends Thread
{
  private Integer autoCloseInterstitialTime;
  private Dialog dialog;
  private Handler handler;

  public CloseDialogThread(Handler paramHandler, Dialog paramDialog, Integer paramInteger)
  {
    this.handler = paramHandler;
    this.dialog = paramDialog;
    this.autoCloseInterstitialTime = paramInteger;
  }

  public void run()
  {
    if (this.handler == null)
      return;
    if (this.dialog == null)
      return;
    try
    {
      Thread.sleep(this.autoCloseInterstitialTime.intValue() * 1000);
      label31: Handler localHandler = this.handler;
      Dialog localDialog = this.dialog;
      CloseDialogRunnable localCloseDialogRunnable = new CloseDialogRunnable(localDialog);
      boolean bool = localHandler.post(localCloseDialogRunnable);
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.CloseDialogThread
 * JD-Core Version:    0.6.2
 */