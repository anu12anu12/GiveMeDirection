package com.hopstop.gps;

import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.skyhookwireless.wps.IPLocation;
import com.skyhookwireless.wps.IPLocationCallback;
import com.skyhookwireless.wps.RegistrationCallback;
import com.skyhookwireless.wps.TilingListener;
import com.skyhookwireless.wps.WPS;
import com.skyhookwireless.wps.WPSAuthentication;
import com.skyhookwireless.wps.WPSContinuation;
import com.skyhookwireless.wps.WPSLocation;
import com.skyhookwireless.wps.WPSLocationCallback;
import com.skyhookwireless.wps.WPSPeriodicLocationCallback;
import com.skyhookwireless.wps.WPSReturnCode;
import com.skyhookwireless.wps.WPSStreetAddressLookup;
import com.skyhookwireless.wps.XPS;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class XSPLocationManager
{
  private static final String AUTHENTICATION_FILE = "/sdcard/HopStop.com/xps/authentication";
  private static final int DONE_MESSAGE = 3;
  private static final int ERROR_MESSAGE = 2;
  public static String HYBRID_POSITION = "hybrid_position";
  private static final int LOCATION_MESSAGE = 1;
  private static final int MAX_TILE_SESSION_SIZE = 460800;
  private static final int MAX_TILE_TOTAL_SIZE = 1048576;
  private static final String TILE_DIR = "/sdcard/HopStop.com/xps/tiles/";
  private static final String XPS_DIR = "/sdcard/HopStop.com/xps";
  private static XSPLocationManager xsp;
  private final MyLocationCallback _callback;
  private Handler _handler;
  private HopStopTilingListener _hopStopTilingListener;
  private HopStopLocationListener _listener;
  private SkyHook_Logger _logger;
  private List<String> _providers;
  private WPSAuthentication auth = null;
  WPSLocationCallback callback;
  private Context context;
  private boolean gotFix = false;
  private WPS wps;
  private XPS xps;

  private XSPLocationManager(Context paramContext)
  {
    SkyHook_Logger localSkyHook_Logger = new SkyHook_Logger();
    this._logger = localSkyHook_Logger;
    MyLocationCallback localMyLocationCallback = new MyLocationCallback(null);
    this._callback = localMyLocationCallback;
    ArrayList localArrayList = new ArrayList();
    this._providers = localArrayList;
    WPSLocationCallback local1 = new WPSLocationCallback()
    {
      private boolean _stop;

      public void done()
      {
        this._stop = false;
        Handler localHandler = XSPLocationManager.this._handler;
        Message localMessage = XSPLocationManager.this._handler.obtainMessage(3);
        boolean bool = localHandler.sendMessage(localMessage);
      }

      public WPSContinuation handleError(WPSReturnCode paramAnonymousWPSReturnCode)
      {
        Handler localHandler = XSPLocationManager.this._handler;
        Message localMessage = XSPLocationManager.this._handler.obtainMessage(2, paramAnonymousWPSReturnCode);
        boolean bool = localHandler.sendMessage(localMessage);
        if (this._stop)
          if (this._stop)
            break label53;
        label53: for (WPSContinuation localWPSContinuation = WPSContinuation.WPS_CONTINUE; ; localWPSContinuation = WPSContinuation.WPS_STOP)
        {
          return localWPSContinuation;
          break;
        }
      }

      public void handleWPSLocation(WPSLocation paramAnonymousWPSLocation)
      {
        Handler localHandler = XSPLocationManager.this._handler;
        Message localMessage = XSPLocationManager.this._handler.obtainMessage(1, paramAnonymousWPSLocation);
        boolean bool = localHandler.sendMessage(localMessage);
      }
    };
    this.callback = local1;
    List localList = this._providers;
    String str1 = HYBRID_POSITION;
    boolean bool = localList.add(str1);
    WPS localWPS = new WPS(paramContext);
    this.wps = localWPS;
    XPS localXPS1 = new XPS(paramContext);
    this.xps = localXPS1;
    this.context = paramContext;
    HopStopTilingListener localHopStopTilingListener1 = new HopStopTilingListener(null);
    this._hopStopTilingListener = localHopStopTilingListener1;
    File localFile = new File("/sdcard/HopStop.com/xps/tiles/");
    if ((localFile.exists()) || (localFile.mkdirs()))
    {
      XPS localXPS2 = this.xps;
      String str2 = localFile.getAbsolutePath();
      HopStopTilingListener localHopStopTilingListener2 = this._hopStopTilingListener;
      localXPS2.setTiling(str2, 460800L, 1048576L, localHopStopTilingListener2);
    }
    while (true)
    {
      Handler local2 = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (XSPLocationManager.this._listener == null)
            return;
          switch (paramAnonymousMessage.what)
          {
          default:
            return;
          case 1:
            WPSLocation localWPSLocation = (WPSLocation)paramAnonymousMessage.obj;
            HopStopLocationListener localHopStopLocationListener = XSPLocationManager.this._listener;
            Location localLocation = XSPLocationManager.this.convertWSPLocationToAndroidLocation(localWPSLocation);
            localHopStopLocationListener.onLocationChanged(localLocation);
            XSPLocationManager.this.gotFix = true;
            return;
          case 2:
            WPSReturnCode localWPSReturnCode1 = (WPSReturnCode)paramAnonymousMessage.obj;
            WPSReturnCode localWPSReturnCode2 = WPSReturnCode.WPS_ERROR;
            if (localWPSReturnCode1 != localWPSReturnCode2)
              return;
            XSPLocationManager.this._listener._gpsObserver.onLocationError(3);
            return;
          case 3:
          }
          if (!XSPLocationManager.this.gotFix)
            return;
          XSPLocationManager.this._listener._gpsObserver.onLocationError(3);
          XSPLocationManager.this.gotFix = false;
        }
      };
      this._handler = local2;
      return;
      this._logger.error("couldn't enable tiling because directory creation failed");
    }
  }

  private WPSAuthentication calculateLocationAuth()
  {
    String str1;
    WPSAuthentication localWPSAuthentication;
    try
    {
      str1 = ((TelephonyManager)this.context.getSystemService("phone")).getDeviceId();
      if ((str1 == null) || (str1.length() < 8))
      {
        str1 = ((WifiManager)this.context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if ((str1 == null) || (str1.length() < 8))
        {
          SkyHook_Logger localSkyHook_Logger = this._logger;
          String str2 = "can't calculate username, invalid IMEI: " + str1;
          localSkyHook_Logger.error(str2);
          localWPSAuthentication = null;
          return localWPSAuthentication;
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      while (true)
      {
        this._logger.debug("couldn't get device ID");
        localWPSAuthentication = null;
      }
    }
    while (true)
    {
      StringBuilder localStringBuilder1;
      byte[] arrayOfByte2;
      int i;
      try
      {
        localStringBuilder1 = new StringBuilder(25);
        String str3 = str1.substring(0, 8);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append('-');
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte1 = str1.getBytes("UTF-8");
        localMessageDigest.update(arrayOfByte1);
        arrayOfByte2 = localMessageDigest.digest();
        i = 0;
        int j = arrayOfByte2.length;
        if (i < j)
          break label233;
        String str4 = localStringBuilder1.toString();
        localWPSAuthentication = new WPSAuthentication(str4, "HopStop.com");
      }
      catch (Throwable localThrowable2)
      {
        this._logger.error("can't calculate username", localThrowable2);
        localWPSAuthentication = null;
      }
      break;
      label233: String str5 = Integer.toHexString(arrayOfByte2[i] & 0xFF);
      StringBuilder localStringBuilder3 = localStringBuilder1.append(str5);
      i += 1;
    }
  }

  private Location convertWSPLocationToAndroidLocation(WPSLocation paramWPSLocation)
  {
    Location localLocation = new Location("SkyHook Location");
    double d1 = paramWPSLocation.getLatitude();
    localLocation.setLatitude(d1);
    double d2 = paramWPSLocation.getLongitude();
    localLocation.setLongitude(d2);
    return localLocation;
  }

  private WPSAuthentication deserializeAuthentication()
  {
    String str = ApplicationEngine.getModel().getSkyHookUser();
    return new WPSAuthentication(str, "HopStop.com");
  }

  public static XSPLocationManager getXSPLocationManager(Context paramContext)
  {
    if (xsp == null)
      xsp = new XSPLocationManager(paramContext);
    return xsp;
  }

  private WPSAuthentication register()
  {
    Object localObject = calculateLocationAuth();
    WPSAuthentication localWPSAuthentication1 = deserializeAuthentication();
    if ((localObject == null) || (((WPSAuthentication)localObject).equals(localWPSAuthentication1)))
      if (this._logger.isDebugEnabled())
      {
        if ((localObject == null) && (localWPSAuthentication1 == null))
          this._logger.debug("can't perform registration");
      }
      else
        localObject = localWPSAuthentication1;
    while (true)
    {
      return localObject;
      if (localObject == null)
      {
        this._logger.debug("trusing previous registration");
        break;
      }
      this._logger.debug("already registered");
      break;
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      RegistrationCallback local3 = new RegistrationCallback()
      {
        public void done()
        {
          XSPLocationManager.this._logger.debug("registration done");
          localCountDownLatch.countDown();
        }

        public WPSContinuation handleError(WPSReturnCode paramAnonymousWPSReturnCode)
        {
          SkyHook_Logger localSkyHook_Logger = XSPLocationManager.this._logger;
          String str = "registration failed: " + paramAnonymousWPSReturnCode;
          localSkyHook_Logger.error(str);
          return WPSContinuation.WPS_STOP;
        }

        public void handleSuccess()
        {
          XSPLocationManager.this._logger.debug("registration successful");
          Model localModel = ApplicationEngine.getModel();
          String str = this.val$newAuth.getUsername();
          localModel.setSkyHookUser(str);
          XSPLocationManager localXSPLocationManager = XSPLocationManager.this;
          WPSAuthentication localWPSAuthentication = this.val$newAuth;
          localXSPLocationManager.serialize(localWPSAuthentication);
        }
      };
      this._logger.debug("performing registration");
      XPS localXPS = this.xps;
      WPSAuthentication localWPSAuthentication2 = new WPSAuthentication("v9488jrtcbnm", "HopStop.com");
      localXPS.registerUser(localWPSAuthentication2, (WPSAuthentication)localObject, local3);
    }
  }

  // ERROR //
  private void serialize(WPSAuthentication paramWPSAuthentication)
  {
    // Byte code:
    //   0: new 126	java/io/File
    //   3: dup
    //   4: ldc 21
    //   6: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: aconst_null
    //   11: astore_3
    //   12: aconst_null
    //   13: astore 4
    //   15: new 354	java/io/FileOutputStream
    //   18: dup
    //   19: aload_2
    //   20: iconst_0
    //   21: invokespecial 357	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   24: astore 5
    //   26: new 359	java/io/ObjectOutputStream
    //   29: dup
    //   30: aload 5
    //   32: invokespecial 362	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 6
    //   37: aload 6
    //   39: aload_1
    //   40: invokevirtual 366	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 85	com/hopstop/gps/XSPLocationManager:_logger	Lcom/hopstop/gps/SkyHook_Logger;
    //   47: ldc_w 368
    //   50: invokevirtual 233	com/hopstop/gps/SkyHook_Logger:debug	(Ljava/lang/String;)V
    //   53: aload 6
    //   55: astore 4
    //   57: aload 5
    //   59: astore_3
    //   60: aload 4
    //   62: ifnull +8 -> 70
    //   65: aload 4
    //   67: invokevirtual 371	java/io/ObjectOutputStream:close	()V
    //   70: aload_3
    //   71: ifnonnull +4 -> 75
    //   74: return
    //   75: aload_3
    //   76: invokevirtual 372	java/io/FileOutputStream:close	()V
    //   79: return
    //   80: astore 7
    //   82: aload_0
    //   83: getfield 85	com/hopstop/gps/XSPLocationManager:_logger	Lcom/hopstop/gps/SkyHook_Logger;
    //   86: ldc_w 374
    //   89: aload 7
    //   91: invokevirtual 277	com/hopstop/gps/SkyHook_Logger:error	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: goto -34 -> 60
    //   97: astore 8
    //   99: aload_0
    //   100: getfield 85	com/hopstop/gps/XSPLocationManager:_logger	Lcom/hopstop/gps/SkyHook_Logger;
    //   103: ldc_w 376
    //   106: aload 8
    //   108: invokevirtual 379	com/hopstop/gps/SkyHook_Logger:warn	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: return
    //   112: astore 7
    //   114: aload 5
    //   116: astore_3
    //   117: goto -35 -> 82
    //   120: astore 7
    //   122: aload 6
    //   124: astore 4
    //   126: aload 5
    //   128: astore_3
    //   129: goto -47 -> 82
    //
    // Exception table:
    //   from	to	target	type
    //   15	26	80	java/lang/Throwable
    //   65	79	97	java/lang/Throwable
    //   26	37	112	java/lang/Throwable
    //   37	53	120	java/lang/Throwable
  }

  public void done()
  {
    this.xps.abort();
    this.wps.abort();
  }

  public List<String> getProviders(boolean paramBoolean)
  {
    return this._providers;
  }

  public void registerLocalisationListener(HopStopLocationListener paramHopStopLocationListener, GPSSettings paramGPSSettings)
  {
    this._listener = paramHopStopLocationListener;
  }

  public void startWSP()
  {
    this._callback._stop = false;
    if (this.auth == null)
    {
      WPSAuthentication localWPSAuthentication1 = register();
      this.auth = localWPSAuthentication1;
    }
    WPS localWPS = this.wps;
    WPSAuthentication localWPSAuthentication2 = this.auth;
    WPSStreetAddressLookup localWPSStreetAddressLookup = WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP;
    WPSLocationCallback localWPSLocationCallback = this.callback;
    localWPS.getLocation(localWPSAuthentication2, localWPSStreetAddressLookup, localWPSLocationCallback);
  }

  public void startXSP()
  {
    this._callback._stop = false;
    if (this.auth == null)
    {
      WPSAuthentication localWPSAuthentication1 = new WPSAuthentication("transit09", "HopStop.com");
      this.auth = localWPSAuthentication1;
    }
    XPS localXPS = this.xps;
    WPSAuthentication localWPSAuthentication2 = this.auth;
    MyLocationCallback localMyLocationCallback = this._callback;
    localXPS.getXPSLocation(localWPSAuthentication2, 5, 30, localMyLocationCallback);
  }

  private class HopStopTilingListener
    implements TilingListener
  {
    private HopStopTilingListener()
    {
    }

    public WPSContinuation tilingCallback(int paramInt1, int paramInt2)
    {
      return WPSContinuation.WPS_CONTINUE;
    }
  }

  private class MyLocationCallback
    implements IPLocationCallback, WPSLocationCallback, WPSPeriodicLocationCallback
  {
    private boolean _stop;

    private MyLocationCallback()
    {
    }

    public void done()
    {
      this._stop = false;
    }

    public WPSContinuation handleError(WPSReturnCode paramWPSReturnCode)
    {
      if (!this._stop);
      for (WPSContinuation localWPSContinuation = WPSContinuation.WPS_CONTINUE; ; localWPSContinuation = WPSContinuation.WPS_STOP)
        return localWPSContinuation;
    }

    public void handleIPLocation(IPLocation paramIPLocation)
    {
    }

    public void handleWPSLocation(WPSLocation paramWPSLocation)
    {
    }

    public WPSContinuation handleWPSPeriodicLocation(WPSLocation paramWPSLocation)
    {
      Handler localHandler = XSPLocationManager.this._handler;
      Message localMessage = XSPLocationManager.this._handler.obtainMessage(1, paramWPSLocation);
      boolean bool = localHandler.sendMessage(localMessage);
      if (!this._stop);
      for (WPSContinuation localWPSContinuation = WPSContinuation.WPS_CONTINUE; ; localWPSContinuation = WPSContinuation.WPS_STOP)
        return localWPSContinuation;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.XSPLocationManager
 * JD-Core Version:    0.6.2
 */