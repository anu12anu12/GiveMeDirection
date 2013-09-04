package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import com.google.android.gms.analytics.internal.IAnalyticsService.Stub;
import java.util.List;
import java.util.Map;

class AnalyticsGmsCoreClient
  implements AnalyticsClient
{
  private static final int BIND_ADJUST_WITH_ACTIVITY = 128;
  public static final int BIND_FAILED = 1;
  public static final String KEY_APP_PACKAGE_NAME = "app_package_name";
  public static final int REMOTE_EXECUTION_FAILED = 2;
  static final String SERVICE_ACTION = "com.google.android.gms.analytics.service.START";
  private static final String SERVICE_DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
  private ServiceConnection connection;
  private Context context;
  private OnConnectedListener onConnectedListener;
  private OnConnectionFailedListener onConnectionFailedListener;
  private IAnalyticsService service;

  public AnalyticsGmsCoreClient(Context paramContext, OnConnectedListener paramOnConnectedListener, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.context = paramContext;
    this.onConnectedListener = paramOnConnectedListener;
    this.onConnectionFailedListener = paramOnConnectionFailedListener;
  }

  private IAnalyticsService getService()
  {
    checkConnected();
    return this.service;
  }

  private void onConnectionSuccess()
  {
    this.onConnectedListener.onConnected();
  }

  private void onServiceBound()
  {
    onConnectionSuccess();
  }

  protected void checkConnected()
  {
    if (isConnected())
      return;
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }

  public void clearHits()
  {
    try
    {
      getService().clearHits();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      int i = Log.e("clear hits failed: " + localRemoteException);
    }
  }

  public void connect()
  {
    Intent localIntent1 = new Intent("com.google.android.gms.analytics.service.START");
    String str = this.context.getPackageName();
    Intent localIntent2 = localIntent1.putExtra("app_package_name", str);
    if (this.connection != null)
    {
      int i = Log.e("Calling connect() while still connected, missing disconnect().");
      return;
    }
    AnalyticsServiceConnection localAnalyticsServiceConnection = new AnalyticsServiceConnection();
    this.connection = localAnalyticsServiceConnection;
    Context localContext = this.context;
    ServiceConnection localServiceConnection = this.connection;
    boolean bool = localContext.bindService(localIntent1, localServiceConnection, 129);
    int j = Log.iDebug("connect: bindService returned " + bool + " for " + localIntent1);
    if (bool)
      return;
    this.connection = null;
    this.onConnectionFailedListener.onConnectionFailed(1, null);
  }

  public void disconnect()
  {
    this.service = null;
    if (this.connection == null)
      return;
    Context localContext = this.context;
    ServiceConnection localServiceConnection = this.connection;
    localContext.unbindService(localServiceConnection);
    this.connection = null;
    this.onConnectedListener.onDisconnected();
  }

  public boolean isConnected()
  {
    if (this.service != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void sendHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    try
    {
      IAnalyticsService localIAnalyticsService = getService();
      Map<String, String> localMap = paramMap;
      long l = paramLong;
      String str = paramString;
      List<Command> localList = paramList;
      localIAnalyticsService.sendHit(localMap, l, str, localList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      int i = Log.e("sendHit failed: " + localRemoteException);
    }
  }

  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(int paramInt, Intent paramIntent);
  }

  public static abstract interface OnConnectedListener
  {
    public abstract void onConnected();

    public abstract void onDisconnected();
  }

  final class AnalyticsServiceConnection
    implements ServiceConnection
  {
    AnalyticsServiceConnection()
    {
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      int i = Log.dDebug("service connected, binder: " + paramIBinder);
      try
      {
        String str = paramIBinder.getInterfaceDescriptor();
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(str))
        {
          int j = Log.dDebug("bound to service");
          AnalyticsGmsCoreClient localAnalyticsGmsCoreClient = AnalyticsGmsCoreClient.this;
          IAnalyticsService localIAnalyticsService1 = IAnalyticsService.Stub.asInterface(paramIBinder);
          IAnalyticsService localIAnalyticsService2 = AnalyticsGmsCoreClient.access$002(localAnalyticsGmsCoreClient, localIAnalyticsService1);
          AnalyticsGmsCoreClient.this.onServiceBound();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        AnalyticsGmsCoreClient.this.context.unbindService(this);
        ServiceConnection localServiceConnection = AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
        AnalyticsGmsCoreClient.this.onConnectionFailedListener.onConnectionFailed(2, null);
      }
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      int i = Log.dDebug("service disconnected: " + paramComponentName);
      ServiceConnection localServiceConnection = AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
      AnalyticsGmsCoreClient.this.onConnectedListener.onDisconnected();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.AnalyticsGmsCoreClient
 * JD-Core Version:    0.6.2
 */