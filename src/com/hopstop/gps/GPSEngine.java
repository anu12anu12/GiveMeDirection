package com.hopstop.gps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class GPSEngine
{
  private ArrayList<GpsTypeListener> _gpsList;
  private ArrayList<HopStopLocationListener> _listeners;
  private ArrayList<GpsLocationManager> _locManagers;
  private ArrayList<GPSFixRequest> _requests;
  private int fixNumber;
  private boolean isThreadRunning;

  public GPSEngine(Context paramContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    this._gpsList = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this._requests = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    this._locManagers = localArrayList3;
    ArrayList localArrayList4 = new ArrayList();
    this._listeners = localArrayList4;
    this.isThreadRunning = false;
    this.fixNumber = 0;
    ArrayList localArrayList5 = this._locManagers;
    GpsLocationManager localGpsLocationManager1 = GpsLocationManagerFactory.getAndroidGPS(paramContext);
    boolean bool1 = localArrayList5.add(localGpsLocationManager1);
    ArrayList localArrayList6 = this._locManagers;
    GpsLocationManager localGpsLocationManager2 = GpsLocationManagerFactory.getSkyHookGPS(paramContext);
    boolean bool2 = localArrayList6.add(localGpsLocationManager2);
  }

  private void endRequest(GpsLocationManager paramGpsLocationManager, HopStopLocationListener paramHopStopLocationListener)
  {
    new CancelThread(paramGpsLocationManager, paramHopStopLocationListener).start();
  }

  private HopStopLocationListener getNimListener(GpsObserver paramGpsObserver)
  {
    int i = 0;
    while (true)
    {
      int j = this._listeners.size();
      HopStopLocationListener localHopStopLocationListener;
      if (i >= j)
        localHopStopLocationListener = null;
      do
      {
        return localHopStopLocationListener;
        localHopStopLocationListener = (HopStopLocationListener)this._listeners.get(i);
      }
      while (localHopStopLocationListener._gpsObserver == paramGpsObserver);
      i += 1;
    }
  }

  private boolean isProviderAvaliable(String paramString)
  {
    int i = 0;
    while (true)
    {
      int j = this._locManagers.size();
      if (i >= j);
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        List localList = ((GpsLocationManager)this._locManagers.get(i)).getAllProviders();
        if ((localList == null) || (!localList.contains(paramString)))
          break;
      }
      i += 1;
    }
  }

  private boolean isRecievingFix(int paramInt)
  {
    return false;
  }

  private void onGetLocation(HopStopGpsObserver paramHopStopGpsObserver, Location paramLocation)
  {
    int i = this._gpsList.size() + -1;
    while (true)
    {
      if (i < 0)
        return;
      if (this._gpsList.size() > 0)
      {
        GpsTypeListener localGpsTypeListener = (GpsTypeListener)this._gpsList.get(i);
        if (localGpsTypeListener != null)
        {
          localGpsTypeListener.get_observer().observer.onLocationChanged(paramLocation);
          HopStopGpsObserver localHopStopGpsObserver = localGpsTypeListener.get_observer();
          cancelRequestAllGPS(localHopStopGpsObserver);
          localGpsTypeListener.get_observer().Stop();
          boolean bool = this._gpsList.remove(localGpsTypeListener);
        }
      }
      i += -1;
    }
  }

  private void onGetLocationError(HopStopGpsObserver paramHopStopGpsObserver, int paramInt)
  {
    try
    {
      int i = this._gpsList.size() + -1;
      while (true)
      {
        if (i < 0)
          return;
        if ((this._gpsList.size() > 0) && (((GpsTypeListener)this._gpsList.get(i)).get_observer() == paramHopStopGpsObserver))
        {
          GpsTypeListener localGpsTypeListener = (GpsTypeListener)this._gpsList.get(i);
          localGpsTypeListener.get_observer().observer.onLocationError(paramInt);
          HopStopGpsObserver localHopStopGpsObserver = localGpsTypeListener.get_observer();
          cancelRequestGPS(localHopStopGpsObserver);
          localGpsTypeListener.get_observer().Stop();
          boolean bool = this._gpsList.remove(localGpsTypeListener);
        }
        i += -1;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
    }
  }

  private void requestGPS(int paramInt)
  {
    GPSSettings localGPSSettings = new GPSSettings(60000, 550);
    localGPSSettings.acc = 550;
    GPSFixRequest localGPSFixRequest = (GPSFixRequest)this._requests.get(0);
    boolean bool1 = localGPSFixRequest.isSingleShot();
    localGPSSettings.singleShot = bool1;
    ArrayList localArrayList = localGPSSettings.gpsProviders;
    List localList = localGPSFixRequest.getProviderNames();
    boolean bool2 = localArrayList.addAll(localList);
    String str = localGPSFixRequest.getMode();
    localGPSSettings.mode = str;
    GpsObserver local2 = new GpsObserver()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        ApplicationEngine.getModel().updateCurrentLocation(paramAnonymousLocation, -1, -1, null);
        Iterator localIterator = GPSEngine.this._requests.iterator();
        while (true)
        {
          if (!localIterator.hasNext())
          {
            GPSEngine.this._requests.clear();
            return;
          }
          ((GPSFixRequest)localIterator.next()).setRequested(false);
        }
      }

      public void onLocationError(int paramAnonymousInt)
      {
        if (GPSEngine.this._requests == null)
          return;
        if (GPSEngine.this._requests.size() <= 1)
          return;
        ArrayList localArrayList = GPSEngine.this._requests;
        int i = GPSEngine.this._requests.size() + -1;
        Object localObject = localArrayList.remove(i);
      }
    };
    if (localGPSSettings.singleShot)
    {
      int i = localGPSFixRequest.getId();
      getCurrentGPSFix(localGPSSettings, local2, i);
      return;
    }
    int j = localGPSFixRequest.getId();
    startGpsListenForGPSFixes(localGPSSettings, local2, j);
  }

  private void startGpsTrucking(GPSSettings paramGPSSettings, GpsObserver paramGpsObserver)
  {
    int i = 0;
    int j = this._locManagers.size();
    if (i >= j)
      return;
    int k = 0;
    while (true)
    {
      int m = paramGPSSettings.gpsProviders.size();
      if (k >= m)
      {
        i += 1;
        break;
      }
      GpsLocationManager localGpsLocationManager = (GpsLocationManager)this._locManagers.get(i);
      String str = (String)paramGPSSettings.gpsProviders.get(k);
      if (localGpsLocationManager.isProviderAvailable(str))
      {
        HopStopLocationListener localHopStopLocationListener = GpsLocationManagerFactory.getHopStopLocationListener((String)paramGPSSettings.gpsProviders.get(k), paramGPSSettings, paramGpsObserver);
        boolean bool = this._listeners.add(localHopStopLocationListener);
        ((GpsLocationManager)this._locManagers.get(i)).requestGPSFix(localHopStopLocationListener, paramGPSSettings);
      }
      k += 1;
    }
  }

  public void addGPSRequests(GPSFixRequest paramGPSFixRequest)
  {
    boolean bool = this._requests.add(paramGPSFixRequest);
  }

  /** @deprecated */
  // ERROR //
  public void cancelRequestAllGPS(HopStopGpsObserver paramHopStopGpsObserver)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/hopstop/gps/GPSEngine:_listeners	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: new 38	java/util/ArrayList
    //   10: dup
    //   11: aload_2
    //   12: invokespecial 228	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   15: invokevirtual 232	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 237 1 0
    //   25: istore 4
    //   27: iload 4
    //   29: ifne +6 -> 35
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_3
    //   36: invokeinterface 241 1 0
    //   41: checkcast 106	com/hopstop/gps/HopStopLocationListener
    //   44: astore 5
    //   46: invokestatic 245	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   49: astore 6
    //   51: ldc2_w 246
    //   54: invokestatic 251	java/lang/Thread:sleep	(J)V
    //   57: aload 5
    //   59: getfield 110	com/hopstop/gps/HopStopLocationListener:_gpsObserver	Lcom/hopstop/gps/GpsObserver;
    //   62: checkcast 16	com/hopstop/gps/GPSEngine$HopStopGpsObserver
    //   65: astore 7
    //   67: aload_0
    //   68: aload 7
    //   70: iconst_3
    //   71: invokespecial 76	com/hopstop/gps/GPSEngine:onGetLocationError	(Lcom/hopstop/gps/GPSEngine$HopStopGpsObserver;I)V
    //   74: goto -55 -> 19
    //   77: astore 8
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 8
    //   83: athrow
    //   84: astore 9
    //   86: goto -29 -> 57
    //
    // Exception table:
    //   from	to	target	type
    //   2	27	77	finally
    //   35	46	77	finally
    //   46	57	77	finally
    //   57	74	77	finally
    //   46	57	84	java/lang/InterruptedException
  }

  /** @deprecated */
  public void cancelRequestGPS(GpsObserver paramGpsObserver)
  {
    try
    {
      HopStopLocationListener localHopStopLocationListener1 = getNimListener(paramGpsObserver);
      HopStopLocationListener localHopStopLocationListener2 = localHopStopLocationListener1;
      if (localHopStopLocationListener2 == null)
        return;
      int i = 0;
      while (true)
      {
        int j = this._locManagers.size();
        if (i >= j)
        {
          boolean bool = this._listeners.remove(localHopStopLocationListener2);
          localHopStopLocationListener2 = getNimListener(paramGpsObserver);
          break;
        }
        GpsLocationManager localGpsLocationManager = (GpsLocationManager)this._locManagers.get(i);
        endRequest(localGpsLocationManager, localHopStopLocationListener2);
        i += 1;
      }
    }
    finally
    {
    }
  }

  public Address getAddressForLocation(Context paramContext, Location paramLocation)
    throws IOException
  {
    Address localAddress = null;
    if (paramLocation == null);
    while (true)
    {
      return localAddress;
      double d1 = paramLocation.getLatitude();
      double d2 = paramLocation.getLongitude();
      Locale localLocale = Locale.getDefault();
      List localList = new Geocoder(paramContext, localLocale).getFromLocation(d1, d2, 1);
      if (localList.size() == 1)
        localAddress = (Address)localList.get(0);
    }
  }

  public void getCurrentGPSFix(GPSSettings paramGPSSettings, GpsObserver paramGpsObserver, int paramInt)
  {
  }

  public int getGPSFixRequest()
  {
    if (this._requests.size() > 0);
    for (int i = 0; ; i = -1)
      return i;
  }

  public GPSFixRequest initGPSFixes()
  {
    int i = 0;
    GPSFixRequest localGPSFixRequest = null;
    if (isProviderAvaliable("gps"))
    {
      int j = 0 + 1;
      localGPSFixRequest = new GPSFixRequest("Google GPS", "", false, 0);
      localGPSFixRequest.addProviderName("gps");
      i = j;
    }
    if (isProviderAvaliable("network"))
    {
      if (localGPSFixRequest == null)
      {
        int k = i + 1;
        localGPSFixRequest = new GPSFixRequest("Google Network", "", false, i);
        i = k;
      }
      localGPSFixRequest.addProviderName("network");
    }
    String str1 = XSPLocationManager.HYBRID_POSITION;
    if (isProviderAvaliable(str1))
    {
      if (localGPSFixRequest == null)
      {
        int m = i + 1;
        localGPSFixRequest = new GPSFixRequest("SkyHook GPS", "", false, i);
        int n = m;
      }
      String str2 = XSPLocationManager.HYBRID_POSITION;
      localGPSFixRequest.addProviderName(str2);
    }
    return localGPSFixRequest;
  }

  public void requestGPSFix(final int paramInt)
  {
    if (paramInt < 0)
      return;
    GPSFixRequest localGPSFixRequest = (GPSFixRequest)this._requests.get(paramInt);
    if (localGPSFixRequest.isRequested())
      return;
    if (this.isThreadRunning)
    {
      requestGPS(paramInt);
      if (!localGPSFixRequest.isRequested())
        break label67;
    }
    label67: for (boolean bool = false; ; bool = true)
    {
      localGPSFixRequest.setRequested(bool);
      return;
      new Thread()
      {
        public void run()
        {
          GPSEngine localGPSEngine = GPSEngine.this;
          int i = paramInt;
          localGPSEngine.requestGPS(i);
        }
      }
      .start();
      break;
    }
  }

  public void startGpsListenForGPSFixes(GPSSettings paramGPSSettings, GpsObserver paramGpsObserver, int paramInt)
  {
    if (isRecievingFix(paramInt))
      return;
    int i = paramGPSSettings.timeout;
    HopStopGpsObserver localHopStopGpsObserver = new HopStopGpsObserver(paramGpsObserver, i);
    GpsTypeListener localGpsTypeListener = new GpsTypeListener(localHopStopGpsObserver, paramInt);
    boolean bool = this._gpsList.add(localGpsTypeListener);
    startGpsTrucking(paramGPSSettings, localHopStopGpsObserver);
  }

  private class CancelThread extends Thread
  {
    GpsLocationManager _gpsMgr;
    HopStopLocationListener listener;

    CancelThread(GpsLocationManager paramHopStopLocationListener, HopStopLocationListener arg3)
    {
      this._gpsMgr = paramHopStopLocationListener;
      Object localObject;
      this.listener = localObject;
    }

    public void run()
    {
      try
      {
        GpsLocationManager localGpsLocationManager = this._gpsMgr;
        HopStopLocationListener localHopStopLocationListener = this.listener;
        localGpsLocationManager.cancelRequestGPS(localHopStopLocationListener, true);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  private class GpsTypeListener
  {
    private GPSEngine.HopStopGpsObserver _observer;
    private int _type;

    public GpsTypeListener(GPSEngine.HopStopGpsObserver paramInt, int arg3)
    {
      int i;
      this._type = i;
      this._observer = paramInt;
    }

    public GPSEngine.HopStopGpsObserver get_observer()
    {
      return this._observer;
    }

    public int get_type()
    {
      return this._type;
    }

    public void set_observer(GPSEngine.HopStopGpsObserver paramHopStopGpsObserver)
    {
      this._observer = paramHopStopGpsObserver;
    }

    public void set_type(int paramInt)
    {
      this._type = paramInt;
    }
  }

  private class HopStopGpsObserver
    implements GpsObserver
  {
    public int _timeout;
    public GpsObserver observer;
    private Timer timer;

    public HopStopGpsObserver(GpsObserver paramInt, int arg3)
    {
      this.observer = paramInt;
      int i;
      this._timeout = i;
      startTimer();
    }

    private void startTimer()
    {
      if (this.timer != null)
      {
        this.timer.cancel();
        this.timer = null;
      }
      Timer localTimer1 = new Timer();
      this.timer = localTimer1;
      Timer localTimer2 = this.timer;
      TimerTask local1 = new TimerTask()
      {
        public void run()
        {
          GPSEngine.HopStopGpsObserver.this.onLocationError(0);
        }
      };
      long l = this._timeout;
      localTimer2.schedule(local1, l);
    }

    public void Stop()
    {
      if (this.timer == null)
        return;
      this.timer.cancel();
      this.timer = null;
    }

    public void onLocationChanged(Location paramLocation)
    {
      GPSEngine.this.onGetLocation(this, paramLocation);
    }

    public void onLocationError(int paramInt)
    {
      GPSEngine.this.onGetLocationError(this, paramInt);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.GPSEngine
 * JD-Core Version:    0.6.2
 */