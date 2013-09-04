package com.MASTAdView.ormma;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.MASTAdView.Base64;
import com.MASTAdView.MASTAdViewCore;
import com.MASTAdView.ormma.util.OrmmaNetworkBroadcastReceiver;
import java.util.Enumeration;
import java.util.Hashtable;

public class OrmmaNetworkController extends OrmmaController
{
  private OrmmaNetworkBroadcastReceiver mBroadCastReceiver;
  private ConnectivityManager mConnectivityManager;
  private IntentFilter mFilter;
  private int mNetworkListenerCount;
  private Hashtable<String, String> requests;

  public OrmmaNetworkController(MASTAdViewCore paramMASTAdViewCore, Context paramContext)
  {
    super(paramMASTAdViewCore, paramContext);
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    this.mConnectivityManager = localConnectivityManager;
    Hashtable localHashtable = new Hashtable();
    this.requests = localHashtable;
  }

  private boolean isOnline()
  {
    NetworkInfo localNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null);
    for (boolean bool = false; ; bool = localNetworkInfo.isConnected())
      return bool;
  }

  private void response(String paramString1, String paramString2)
  {
    try
    {
      String str1 = Base64.encodeString(OrmmaAssetController.getHttpContent(paramString1));
      if (!paramString2.equalsIgnoreCase("proxy"))
        return;
      MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
      String str2 = "Ormma.gotResponse(\"" + paramString1 + "\", \"" + str1 + "\")";
      localMASTAdViewCore.injectJavaScript(str2);
      return;
    }
    catch (Exception localException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"response\",\"Could not read uri content\")");
    }
  }

  public String getNetwork()
  {
    NetworkInfo localNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
    String str;
    if (localNetworkInfo == null)
      str = "offline";
    while (true)
    {
      return str;
      int[] arrayOfInt = $SWITCH_TABLE$android$net$NetworkInfo$State();
      int i = localNetworkInfo.getState().ordinal();
      int j;
      switch (arrayOfInt[i])
      {
      case 4:
      case 5:
      default:
        j = localNetworkInfo.getType();
        if (j == 0)
          str = "cell";
        break;
      case 6:
        str = "unknown";
        break;
      case 3:
        str = "offline";
        continue;
        if (j == 1)
          str = "wifi";
        else
          str = "unknown";
        break;
      }
    }
  }

  public void onConnectionChanged()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("{\"online\": ");
    boolean bool = isOnline();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(bool).append(", ").append("\"connection\": \"");
    String str1 = getNetwork();
    String str2 = str1 + "\"}";
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str3 = "Ormma.gotNetworkChange(" + str2 + ")";
    localMASTAdViewCore.injectJavaScript(str3);
    if (!isOnline())
      return;
    Enumeration localEnumeration = this.requests.keys();
    while (true)
    {
      if (!localEnumeration.hasMoreElements())
      {
        this.requests.clear();
        return;
      }
      String str4 = (String)localEnumeration.nextElement();
      String str5 = (String)this.requests.get(str4);
      response(str4, str5);
    }
  }

  public void request(String paramString1, String paramString2)
  {
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str = "uri=" + paramString1 + ";display=" + paramString2;
    localMASTAdViewCore.ormmaEvent("request", str);
    if (isOnline())
    {
      response(paramString1, paramString2);
      return;
    }
    Object localObject = this.requests.put(paramString1, paramString2);
  }

  public void startNetworkListener()
  {
    if (this.mNetworkListenerCount == 0)
    {
      OrmmaNetworkBroadcastReceiver localOrmmaNetworkBroadcastReceiver1 = new OrmmaNetworkBroadcastReceiver(this);
      this.mBroadCastReceiver = localOrmmaNetworkBroadcastReceiver1;
      IntentFilter localIntentFilter1 = new IntentFilter();
      this.mFilter = localIntentFilter1;
      this.mFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }
    int i = this.mNetworkListenerCount + 1;
    this.mNetworkListenerCount = i;
    try
    {
      Context localContext = this.mContext;
      OrmmaNetworkBroadcastReceiver localOrmmaNetworkBroadcastReceiver2 = this.mBroadCastReceiver;
      IntentFilter localIntentFilter2 = this.mFilter;
      Intent localIntent = localContext.registerReceiver(localOrmmaNetworkBroadcastReceiver2, localIntentFilter2);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void stopAllNetworkListeners()
  {
    try
    {
      Context localContext = this.mContext;
      OrmmaNetworkBroadcastReceiver localOrmmaNetworkBroadcastReceiver = this.mBroadCastReceiver;
      localContext.unregisterReceiver(localOrmmaNetworkBroadcastReceiver);
      label15: this.mBroadCastReceiver = null;
      this.mFilter = null;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }

  public void stopNetworkListener()
  {
    if (this.mNetworkListenerCount <= 0)
      return;
    int i = this.mNetworkListenerCount + -1;
    this.mNetworkListenerCount = i;
    if (this.mNetworkListenerCount != 0)
      return;
    stopAllNetworkListeners();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.OrmmaNetworkController
 * JD-Core Version:    0.6.2
 */