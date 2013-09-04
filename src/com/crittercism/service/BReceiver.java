package com.crittercism.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class BReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = CrittercismService.class.getName();
    Intent localIntent = new Intent(str);
    ComponentName localComponentName = paramContext.startService(localIntent);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crittercism.service.BReceiver
 * JD-Core Version:    0.6.2
 */