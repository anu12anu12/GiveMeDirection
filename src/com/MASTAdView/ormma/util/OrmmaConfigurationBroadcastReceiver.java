package com.MASTAdView.ormma.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.MASTAdView.ormma.OrmmaDisplayController;

public class OrmmaConfigurationBroadcastReceiver extends BroadcastReceiver
{
  private int mLastOrientation;
  private OrmmaDisplayController mOrmmaDisplayController;

  public OrmmaConfigurationBroadcastReceiver(OrmmaDisplayController paramOrmmaDisplayController)
  {
    this.mOrmmaDisplayController = paramOrmmaDisplayController;
    int i = this.mOrmmaDisplayController.getOrientation();
    this.mLastOrientation = i;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!paramIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
      return;
    int i = this.mOrmmaDisplayController.getOrientation();
    int j = this.mLastOrientation;
    if (i != j)
      return;
    this.mLastOrientation = i;
    OrmmaDisplayController localOrmmaDisplayController = this.mOrmmaDisplayController;
    int k = this.mLastOrientation;
    localOrmmaDisplayController.onOrientationChanged(k);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.util.OrmmaConfigurationBroadcastReceiver
 * JD-Core Version:    0.6.2
 */