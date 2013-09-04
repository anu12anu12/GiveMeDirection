package com.MASTAdView.ormma.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.MASTAdView.ormma.OrmmaNetworkController;

public class OrmmaNetworkBroadcastReceiver extends BroadcastReceiver
{
  private OrmmaNetworkController mOrmmaNetworkController;

  public OrmmaNetworkBroadcastReceiver(OrmmaNetworkController paramOrmmaNetworkController)
  {
    this.mOrmmaNetworkController = paramOrmmaNetworkController;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      return;
    this.mOrmmaNetworkController.onConnectionChanged();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.util.OrmmaNetworkBroadcastReceiver
 * JD-Core Version:    0.6.2
 */