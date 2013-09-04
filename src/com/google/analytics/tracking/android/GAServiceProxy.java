package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class GAServiceProxy
  implements ServiceProxy, AnalyticsGmsCoreClient.OnConnectedListener, AnalyticsGmsCoreClient.OnConnectionFailedListener
{
  private static final long FAILED_CONNECT_WAIT_TIME = 3000L;
  private static final int MAX_TRIES = 2;
  private static final long RECONNECT_WAIT_TIME = 5000L;
  private static final long SERVICE_CONNECTION_TIMEOUT = 300000L;
  private volatile AnalyticsClient client;
  private Clock clock;
  private volatile int connectTries;
  private final Context ctx;
  private volatile Timer disconnectCheckTimer;
  private volatile Timer failedConnectTimer;
  private long idleTimeout;
  private volatile long lastRequestTime;
  private boolean pendingClearHits;
  private boolean pendingDispatch;
  private final Queue<HitParams> queue;
  private volatile Timer reConnectTimer;
  private volatile ConnectState state;
  private AnalyticsStore store;
  private AnalyticsStore testStore;
  private final AnalyticsThread thread;

  GAServiceProxy(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    this(paramContext, paramAnalyticsThread, null);
  }

  GAServiceProxy(Context paramContext, AnalyticsThread paramAnalyticsThread, AnalyticsStore paramAnalyticsStore)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.queue = localConcurrentLinkedQueue;
    this.idleTimeout = 300000L;
    this.testStore = paramAnalyticsStore;
    this.ctx = paramContext;
    this.thread = paramAnalyticsThread;
    Clock local1 = new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.clock = local1;
    this.connectTries = 0;
    ConnectState localConnectState = ConnectState.DISCONNECTED;
    this.state = localConnectState;
  }

  private Timer cancelTimer(Timer paramTimer)
  {
    if (paramTimer != null)
      paramTimer.cancel();
    return null;
  }

  private void clearAllTimers()
  {
    Timer localTimer1 = this.reConnectTimer;
    Timer localTimer2 = cancelTimer(localTimer1);
    this.reConnectTimer = localTimer2;
    Timer localTimer3 = this.failedConnectTimer;
    Timer localTimer4 = cancelTimer(localTimer3);
    this.failedConnectTimer = localTimer4;
    Timer localTimer5 = this.disconnectCheckTimer;
    Timer localTimer6 = cancelTimer(localTimer5);
    this.disconnectCheckTimer = localTimer6;
  }

  /** @deprecated */
  private void connectToService()
  {
    while (true)
    {
      try
      {
        if (this.client != null)
        {
          ConnectState localConnectState1 = this.state;
          ConnectState localConnectState2 = ConnectState.CONNECTED_LOCAL;
          if (localConnectState1 != localConnectState2)
            try
            {
              int i = this.connectTries + 1;
              this.connectTries = i;
              Timer localTimer1 = this.failedConnectTimer;
              Timer localTimer2 = cancelTimer(localTimer1);
              ConnectState localConnectState3 = ConnectState.CONNECTING;
              this.state = localConnectState3;
              Timer localTimer3 = new Timer("Failed Connect");
              this.failedConnectTimer = localTimer3;
              Timer localTimer4 = this.failedConnectTimer;
              FailedConnectTask localFailedConnectTask = new FailedConnectTask(null);
              localTimer4.schedule(localFailedConnectTask, 3000L);
              int j = Log.iDebug("connecting to Analytics service");
              this.client.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              int k = Log.w("security exception on connectToService");
              useStore();
              continue;
            }
        }
      }
      finally
      {
      }
      int m = Log.w("client not initialized.");
      useStore();
    }
  }

  /** @deprecated */
  private void disconnectFromService()
  {
    try
    {
      if (this.client != null)
      {
        ConnectState localConnectState1 = this.state;
        ConnectState localConnectState2 = ConnectState.CONNECTED_SERVICE;
        if (localConnectState1 == localConnectState2)
        {
          ConnectState localConnectState3 = ConnectState.PENDING_DISCONNECT;
          this.state = localConnectState3;
          this.client.disconnect();
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void dispatchToStore()
  {
    this.store.dispatch();
    this.pendingDispatch = false;
  }

  private void fireReconnectAttempt()
  {
    Timer localTimer1 = this.reConnectTimer;
    Timer localTimer2 = cancelTimer(localTimer1);
    this.reConnectTimer = localTimer2;
    Timer localTimer3 = new Timer("Service Reconnect");
    this.reConnectTimer = localTimer3;
    Timer localTimer4 = this.reConnectTimer;
    ReconnectTask localReconnectTask = new ReconnectTask(null);
    localTimer4.schedule(localReconnectTask, 5000L);
  }

  /** @deprecated */
  private void sendQueue()
  {
    while (true)
    {
      try
      {
        Thread localThread1 = Thread.currentThread();
        Thread localThread2 = this.thread.getThread();
        if (!localThread1.equals(localThread2))
        {
          LinkedBlockingQueue localLinkedBlockingQueue = this.thread.getQueue();
          Runnable local2 = new Runnable()
          {
            public void run()
            {
              GAServiceProxy.this.sendQueue();
            }
          };
          boolean bool = localLinkedBlockingQueue.add(local2);
          return;
        }
        if (this.pendingClearHits)
          clearHits();
        int[] arrayOfInt = 3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState;
        int i = this.state.ordinal();
        switch (arrayOfInt[i])
        {
        default:
          break;
        case 1:
          if (!this.queue.isEmpty())
          {
            HitParams localHitParams1 = (HitParams)this.queue.poll();
            int j = Log.iDebug("Sending hit to store");
            AnalyticsStore localAnalyticsStore = this.store;
            Map localMap1 = localHitParams1.getWireFormatParams();
            long l1 = localHitParams1.getHitTimeInMilliseconds();
            String str1 = localHitParams1.getPath();
            List localList1 = localHitParams1.getCommands();
            localAnalyticsStore.putHit(localMap1, l1, str1, localList1);
            continue;
          }
          break;
        case 2:
        case 3:
        }
      }
      finally
      {
      }
      if (this.pendingDispatch)
      {
        dispatchToStore();
        continue;
        while (!this.queue.isEmpty())
        {
          HitParams localHitParams2 = (HitParams)this.queue.peek();
          int k = Log.iDebug("Sending hit to service");
          AnalyticsClient localAnalyticsClient = this.client;
          Map localMap2 = localHitParams2.getWireFormatParams();
          long l2 = localHitParams2.getHitTimeInMilliseconds();
          String str2 = localHitParams2.getPath();
          List localList2 = localHitParams2.getCommands();
          localAnalyticsClient.sendHit(localMap2, l2, str2, localList2);
          Object localObject2 = this.queue.poll();
        }
        long l3 = this.clock.currentTimeMillis();
        this.lastRequestTime = l3;
        continue;
        int m = Log.iDebug("Need to reconnect");
        if (!this.queue.isEmpty())
          connectToService();
      }
    }
  }

  /** @deprecated */
  private void useStore()
  {
    while (true)
    {
      try
      {
        ConnectState localConnectState1 = this.state;
        ConnectState localConnectState2 = ConnectState.CONNECTED_LOCAL;
        if (localConnectState1 == localConnectState2)
          return;
        clearAllTimers();
        int i = Log.iDebug("falling back to local store");
        if (this.testStore != null)
        {
          AnalyticsStore localAnalyticsStore1 = this.testStore;
          this.store = localAnalyticsStore1;
          ConnectState localConnectState3 = ConnectState.CONNECTED_LOCAL;
          this.state = localConnectState3;
          sendQueue();
          continue;
        }
      }
      finally
      {
      }
      GAServiceManager localGAServiceManager = GAServiceManager.getInstance();
      Context localContext = this.ctx;
      AnalyticsThread localAnalyticsThread = this.thread;
      localGAServiceManager.initialize(localContext, localAnalyticsThread);
      AnalyticsStore localAnalyticsStore2 = localGAServiceManager.getStore();
      this.store = localAnalyticsStore2;
    }
  }

  public void clearHits()
  {
    int i = Log.iDebug("clearHits called");
    this.queue.clear();
    int[] arrayOfInt = 3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState;
    int j = this.state.ordinal();
    switch (arrayOfInt[j])
    {
    default:
      this.pendingClearHits = true;
      return;
    case 1:
      this.store.clearHits();
      this.pendingClearHits = false;
      return;
    case 2:
    }
    this.client.clearHits();
    this.pendingClearHits = false;
  }

  public void createService()
  {
    if (this.client != null)
      return;
    Context localContext = this.ctx;
    AnalyticsGmsCoreClient localAnalyticsGmsCoreClient = new AnalyticsGmsCoreClient(localContext, this, this);
    this.client = localAnalyticsGmsCoreClient;
    connectToService();
  }

  void createService(AnalyticsClient paramAnalyticsClient)
  {
    if (this.client != null)
      return;
    this.client = paramAnalyticsClient;
    connectToService();
  }

  public void dispatch()
  {
    int[] arrayOfInt = 3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState;
    int i = this.state.ordinal();
    switch (arrayOfInt[i])
    {
    default:
      this.pendingDispatch = true;
    case 2:
      return;
    case 1:
    }
    dispatchToStore();
  }

  /** @deprecated */
  public void onConnected()
  {
    try
    {
      Timer localTimer1 = this.failedConnectTimer;
      Timer localTimer2 = cancelTimer(localTimer1);
      this.failedConnectTimer = localTimer2;
      this.connectTries = 0;
      int i = Log.iDebug("Connected to service");
      ConnectState localConnectState = ConnectState.CONNECTED_SERVICE;
      this.state = localConnectState;
      sendQueue();
      Timer localTimer3 = this.disconnectCheckTimer;
      Timer localTimer4 = cancelTimer(localTimer3);
      this.disconnectCheckTimer = localTimer4;
      Timer localTimer5 = new Timer("disconnect check");
      this.disconnectCheckTimer = localTimer5;
      Timer localTimer6 = this.disconnectCheckTimer;
      DisconnectCheckTask localDisconnectCheckTask = new DisconnectCheckTask(null);
      long l = this.idleTimeout;
      localTimer6.schedule(localDisconnectCheckTask, l);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public void onConnectionFailed(int paramInt, Intent paramIntent)
  {
    try
    {
      int i = Log.w("Connection to service failed " + paramInt);
      ConnectState localConnectState = ConnectState.PENDING_CONNECTION;
      this.state = localConnectState;
      if (this.connectTries < 2)
        fireReconnectAttempt();
      while (true)
      {
        return;
        useStore();
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public void onDisconnected()
  {
    while (true)
    {
      try
      {
        ConnectState localConnectState1 = this.state;
        ConnectState localConnectState2 = ConnectState.PENDING_DISCONNECT;
        if (localConnectState1 == localConnectState2)
        {
          int i = Log.iDebug("Disconnected from service");
          clearAllTimers();
          ConnectState localConnectState3 = ConnectState.DISCONNECTED;
          this.state = localConnectState3;
          return;
        }
        int j = Log.iDebug("Unexpected disconnect.");
        ConnectState localConnectState4 = ConnectState.PENDING_CONNECTION;
        this.state = localConnectState4;
        if (this.connectTries < 2)
        {
          fireReconnectAttempt();
          continue;
        }
      }
      finally
      {
      }
      useStore();
    }
  }

  public void putHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    int i = Log.iDebug("putHit called");
    Queue localQueue = this.queue;
    Map<String, String> localMap = paramMap;
    long l = paramLong;
    String str = paramString;
    List<Command> localList = paramList;
    HitParams localHitParams = new HitParams(localMap, l, str, localList);
    boolean bool = localQueue.add(localHitParams);
    sendQueue();
  }

  void setClock(Clock paramClock)
  {
    this.clock = paramClock;
  }

  public void setIdleTimeout(long paramLong)
  {
    this.idleTimeout = paramLong;
  }

  private static class HitParams
  {
    private final List<Command> commands;
    private final long hitTimeInMilliseconds;
    private final String path;
    private final Map<String, String> wireFormatParams;

    public HitParams(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
    {
      this.wireFormatParams = paramMap;
      this.hitTimeInMilliseconds = paramLong;
      this.path = paramString;
      this.commands = paramList;
    }

    public List<Command> getCommands()
    {
      return this.commands;
    }

    public long getHitTimeInMilliseconds()
    {
      return this.hitTimeInMilliseconds;
    }

    public String getPath()
    {
      return this.path;
    }

    public Map<String, String> getWireFormatParams()
    {
      return this.wireFormatParams;
    }
  }

  private class DisconnectCheckTask extends TimerTask
  {
    private DisconnectCheckTask()
    {
    }

    public void run()
    {
      GAServiceProxy.ConnectState localConnectState1 = GAServiceProxy.this.state;
      GAServiceProxy.ConnectState localConnectState2 = GAServiceProxy.ConnectState.CONNECTED_SERVICE;
      if ((localConnectState1 == localConnectState2) && (GAServiceProxy.this.queue.isEmpty()))
      {
        long l1 = GAServiceProxy.this.lastRequestTime;
        long l2 = GAServiceProxy.this.idleTimeout;
        long l3 = l1 + l2;
        long l4 = GAServiceProxy.this.clock.currentTimeMillis();
        if (l3 < l4)
        {
          int i = Log.iDebug("Disconnecting due to inactivity");
          GAServiceProxy.this.disconnectFromService();
          return;
        }
      }
      Timer localTimer = GAServiceProxy.this.disconnectCheckTimer;
      GAServiceProxy localGAServiceProxy = GAServiceProxy.this;
      DisconnectCheckTask localDisconnectCheckTask = new DisconnectCheckTask(localGAServiceProxy);
      long l5 = GAServiceProxy.this.idleTimeout;
      localTimer.schedule(localDisconnectCheckTask, l5);
    }
  }

  private class ReconnectTask extends TimerTask
  {
    private ReconnectTask()
    {
    }

    public void run()
    {
      GAServiceProxy.this.connectToService();
    }
  }

  private class FailedConnectTask extends TimerTask
  {
    private FailedConnectTask()
    {
    }

    public void run()
    {
      GAServiceProxy.ConnectState localConnectState1 = GAServiceProxy.this.state;
      GAServiceProxy.ConnectState localConnectState2 = GAServiceProxy.ConnectState.CONNECTING;
      if (localConnectState1 != localConnectState2)
        return;
      GAServiceProxy.this.useStore();
    }
  }

  private static enum ConnectState
  {
    static
    {
      CONNECTED_SERVICE = new ConnectState("CONNECTED_SERVICE", 1);
      CONNECTED_LOCAL = new ConnectState("CONNECTED_LOCAL", 2);
      BLOCKED = new ConnectState("BLOCKED", 3);
      PENDING_CONNECTION = new ConnectState("PENDING_CONNECTION", 4);
      PENDING_DISCONNECT = new ConnectState("PENDING_DISCONNECT", 5);
      DISCONNECTED = new ConnectState("DISCONNECTED", 6);
      ConnectState[] arrayOfConnectState = new ConnectState[7];
      ConnectState localConnectState1 = CONNECTING;
      arrayOfConnectState[0] = localConnectState1;
      ConnectState localConnectState2 = CONNECTED_SERVICE;
      arrayOfConnectState[1] = localConnectState2;
      ConnectState localConnectState3 = CONNECTED_LOCAL;
      arrayOfConnectState[2] = localConnectState3;
      ConnectState localConnectState4 = BLOCKED;
      arrayOfConnectState[3] = localConnectState4;
      ConnectState localConnectState5 = PENDING_CONNECTION;
      arrayOfConnectState[4] = localConnectState5;
      ConnectState localConnectState6 = PENDING_DISCONNECT;
      arrayOfConnectState[5] = localConnectState6;
      ConnectState localConnectState7 = DISCONNECTED;
      arrayOfConnectState[6] = localConnectState7;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAServiceProxy
 * JD-Core Version:    0.6.2
 */