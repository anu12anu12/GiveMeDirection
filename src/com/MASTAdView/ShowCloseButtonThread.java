package com.MASTAdView;

import android.app.Dialog;
import android.os.Handler;
import android.widget.Button;

public class ShowCloseButtonThread extends Thread
{
  private Button btnClose;
  Dialog dialog;
  private Handler handler;
  private Integer showCloseButtonTime;

  public ShowCloseButtonThread(Handler paramHandler, Dialog paramDialog, Button paramButton, Integer paramInteger)
  {
    this.handler = paramHandler;
    this.btnClose = paramButton;
    this.showCloseButtonTime = paramInteger;
    this.dialog = paramDialog;
  }

  public void run()
  {
    try
    {
      Thread.sleep(this.showCloseButtonTime.intValue() * 1000);
      label15: if ((this.handler != null) && (this.btnClose != null))
      {
        this.dialog.setCancelable(true);
        Handler localHandler = this.handler;
        Button localButton = this.btnClose;
        VisibilityButtonRunnable localVisibilityButtonRunnable = new VisibilityButtonRunnable(localButton, 0);
        boolean bool = localHandler.post(localVisibilityButtonRunnable);
        return;
      }
      this.dialog.setCancelable(true);
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ShowCloseButtonThread
 * JD-Core Version:    0.6.2
 */