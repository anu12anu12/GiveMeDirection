package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AnalyticsReceiver extends BroadcastReceiver
{
  static final String CAMPAIGN_KEY = "referrer";
  static final String INSTALL_ACTION = "com.android.vending.INSTALL_REFERRER";

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("referrer");
    String str2 = paramIntent.getAction();
    if (!"com.android.vending.INSTALL_REFERRER".equals(str2))
      return;
    if (str1 == null)
      return;
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput("gaInstallData", 0);
      byte[] arrayOfByte = str1.getBytes();
      localFileOutputStream.write(arrayOfByte);
      localFileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      int i = Log.e("Error storing install campaign.");
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.AnalyticsReceiver
 * JD-Core Version:    0.6.2
 */