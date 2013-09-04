package com.hopstop.core;

import android.app.Application;
import android.content.SharedPreferences;
import com.hopstop.ClientModel.Model;
import com.hopstop.gps.GPSEngine;
import com.hopstop.gps.XSPLocationManager;

public class HopStopApplication extends Application
{
  private SharedPreferences _prefs;

  public void onCreate()
  {
    GPSEngine localGPSEngine = ApplicationEngine.getGPSEngine(this);
    Model localModel = ApplicationEngine.getModel();
    String str = this._prefs.getString("skyhook_user", "");
    localModel.setSkyHookUser(str);
    XSPLocationManager.getXSPLocationManager(this).startWSP();
    super.onCreate();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.core.HopStopApplication
 * JD-Core Version:    0.6.2
 */