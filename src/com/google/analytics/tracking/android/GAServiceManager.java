package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class GAServiceManager
  implements ServiceManager
{
  private static final int MSG_KEY = 1;
  private static final Object MSG_OBJECT = new Object();
  private static GAServiceManager instance;
  private Context ctx;
  private int dispatchPeriodInSeconds = 1800;
  private Handler handler;
  private AnalyticsStoreStateListener listener;
  private boolean pendingDispatch = true;
  private boolean powerSaveMode;
  private AnalyticsStore store;
  private volatile AnalyticsThread thread;

  private GAServiceManager()
  {
    AnalyticsStoreStateListener local1 = new AnalyticsStoreStateListener()
    {
      public void reportStoreIsEmpty(boolean paramAnonymousBoolean)
      {
        GAServiceManager.this.updatePowerSaveMode(paramAnonymousBoolean);
      }
    };
    this.listener = local1;
    this.powerSaveMode = false;
  }

  GAServiceManager(Context paramContext, AnalyticsThread paramAnalyticsThread, AnalyticsStore paramAnalyticsStore)
  {
    AnalyticsStoreStateListener local1 = new AnalyticsStoreStateListener()
    {
      public void reportStoreIsEmpty(boolean paramAnonymousBoolean)
      {
        GAServiceManager.this.updatePowerSaveMode(paramAnonymousBoolean);
      }
    };
    this.listener = local1;
    this.powerSaveMode = false;
    this.store = paramAnalyticsStore;
    this.thread = paramAnalyticsThread;
    initialize(paramContext, paramAnalyticsThread);
  }

  public static GAServiceManager getInstance()
  {
    if (instance == null)
      instance = new GAServiceManager();
    return instance;
  }

  private void initializeHandler()
  {
    Looper localLooper = this.ctx.getMainLooper();
    Handler.Callback local2 = new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        int i = paramAnonymousMessage.what;
        if (1 != i)
        {
          Object localObject1 = GAServiceManager.MSG_OBJECT;
          Object localObject2 = paramAnonymousMessage.obj;
          if (localObject1.equals(localObject2))
          {
            GAUsage.getInstance().setDisableUsage(true);
            GAServiceManager.this.dispatch();
            GAUsage.getInstance().setDisableUsage(false);
            if ((GAServiceManager.this.dispatchPeriodInSeconds > 0) && (!GAServiceManager.this.powerSaveMode))
            {
              Handler localHandler1 = GAServiceManager.this.handler;
              Handler localHandler2 = GAServiceManager.this.handler;
              Object localObject3 = GAServiceManager.MSG_OBJECT;
              Message localMessage = localHandler2.obtainMessage(1, localObject3);
              long l = GAServiceManager.this.dispatchPeriodInSeconds * 1000;
              boolean bool = localHandler1.sendMessageDelayed(localMessage, l);
            }
          }
        }
        return true;
      }
    };
    Handler localHandler1 = new Handler(localLooper, local2);
    this.handler = localHandler1;
    if (this.dispatchPeriodInSeconds <= 0)
      return;
    Handler localHandler2 = this.handler;
    Handler localHandler3 = this.handler;
    Object localObject = MSG_OBJECT;
    Message localMessage = localHandler3.obtainMessage(1, localObject);
    long l = this.dispatchPeriodInSeconds * 1000;
    boolean bool = localHandler2.sendMessageDelayed(localMessage, l);
  }

  /** @deprecated */
  public void dispatch()
  {
    try
    {
      if (this.thread == null)
      {
        int i = Log.w("dispatch call queued.  Need to call GAServiceManager.getInstance().initialize().");
        this.pendingDispatch = true;
      }
      while (true)
      {
        return;
        GAUsage localGAUsage = GAUsage.getInstance();
        GAUsage.Field localField = GAUsage.Field.DISPATCH;
        localGAUsage.setUsage(localField);
        this.thread.dispatch();
      }
    }
    finally
    {
    }
  }

  AnalyticsStoreStateListener getListener()
  {
    return this.listener;
  }

  /** @deprecated */
  AnalyticsStore getStore()
  {
    try
    {
      if (this.store != null)
        break label58;
      if (this.ctx == null)
        throw new IllegalStateException("Cant get a store unless we have a context");
    }
    finally
    {
    }
    AnalyticsStoreStateListener localAnalyticsStoreStateListener = this.listener;
    Context localContext = this.ctx;
    PersistentAnalyticsStore localPersistentAnalyticsStore = new PersistentAnalyticsStore(localAnalyticsStoreStateListener, localContext);
    this.store = localPersistentAnalyticsStore;
    label58: if (this.handler == null)
      initializeHandler();
    AnalyticsStore localAnalyticsStore = this.store;
    return localAnalyticsStore;
  }

  /** @deprecated */
  void initialize(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    try
    {
      Context localContext1 = this.ctx;
      if (localContext1 != null);
      while (true)
      {
        return;
        Context localContext2 = paramContext.getApplicationContext();
        this.ctx = localContext2;
        if (this.thread == null)
        {
          this.thread = paramAnalyticsThread;
          if (this.pendingDispatch)
            paramAnalyticsThread.dispatch();
        }
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public void setDispatchPeriod(int paramInt)
  {
    try
    {
      if (this.handler == null)
      {
        int i = Log.w("Need to call initialize() and be in fallback mode to start dispatch.");
        this.dispatchPeriodInSeconds = paramInt;
      }
      while (true)
      {
        return;
        GAUsage localGAUsage = GAUsage.getInstance();
        GAUsage.Field localField = GAUsage.Field.SET_DISPATCH_PERIOD;
        localGAUsage.setUsage(localField);
        if ((!this.powerSaveMode) && (this.dispatchPeriodInSeconds > 0))
        {
          Handler localHandler1 = this.handler;
          Object localObject1 = MSG_OBJECT;
          localHandler1.removeMessages(1, localObject1);
        }
        this.dispatchPeriodInSeconds = paramInt;
        if ((paramInt > 0) && (!this.powerSaveMode))
        {
          Handler localHandler2 = this.handler;
          Handler localHandler3 = this.handler;
          Object localObject2 = MSG_OBJECT;
          Message localMessage = localHandler3.obtainMessage(1, localObject2);
          long l = paramInt * 1000;
          boolean bool = localHandler2.sendMessageDelayed(localMessage, l);
        }
      }
    }
    finally
    {
    }
  }

  void setThrottlingEnabled(boolean paramBoolean)
  {
    this.store.setThrottlingEnabled(paramBoolean);
  }

  /** @deprecated */
  void updatePowerSaveMode(boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        boolean bool1 = this.powerSaveMode;
        if (bool1 != paramBoolean)
          return;
        if ((paramBoolean) && (this.dispatchPeriodInSeconds > 0))
        {
          Handler localHandler1 = this.handler;
          Object localObject1 = MSG_OBJECT;
          localHandler1.removeMessages(1, localObject1);
        }
        if ((!paramBoolean) && (this.dispatchPeriodInSeconds > 0))
        {
          Handler localHandler2 = this.handler;
          Handler localHandler3 = this.handler;
          Object localObject2 = MSG_OBJECT;
          Message localMessage = localHandler3.obtainMessage(1, localObject2);
          long l = this.dispatchPeriodInSeconds * 1000;
          boolean bool2 = localHandler2.sendMessageDelayed(localMessage, l);
        }
        StringBuilder localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean)
        {
          str = "initiated.";
          int i = Log.iDebug(str);
          this.powerSaveMode = paramBoolean;
          continue;
        }
      }
      finally
      {
      }
      String str = "terminated.";
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAServiceManager
 * JD-Core Version:    0.6.2
 */