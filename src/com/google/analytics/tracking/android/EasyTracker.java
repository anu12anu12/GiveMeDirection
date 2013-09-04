package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class EasyTracker
{
  static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
  private static EasyTracker instance;
  private int activitiesActive = 0;
  private final Map<String, String> activityNameMap;
  private boolean autoActivityTracking = false;
  private Clock clock;
  private Analytics ga;
  private boolean gaAnonymizeIp;
  private String gaAppName;
  private String gaAppVersion;
  private Context gaContext;
  private boolean gaDebug;
  private int gaDispatchPeriod = 1800;
  private boolean gaEnabled = false;
  private boolean gaReportUncaughtExceptions;
  private Double gaSampleRate;
  private long gaSessionTimeout;
  private String gaTrackingId;
  private Thread.UncaughtExceptionHandler handler;
  private boolean inForeground;
  private long lastOnStopTime;
  private ParameterLoader parameterFetcher;
  private ServiceManager serviceManager;
  private Timer timer;
  private TimerTask timerTask;
  private Tracker tracker;

  private EasyTracker()
  {
    HashMap localHashMap = new HashMap();
    this.activityNameMap = localHashMap;
    this.tracker = null;
    this.inForeground = false;
    Clock local1 = new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.clock = local1;
  }

  /** @deprecated */
  private void clearExistingTimer()
  {
    try
    {
      if (this.timer != null)
      {
        this.timer.cancel();
        this.timer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static void clearTracker()
  {
    instance = null;
  }

  private String getActivityName(Activity paramActivity)
  {
    String str1 = paramActivity.getClass().getCanonicalName();
    if (this.activityNameMap.containsKey(str1));
    String str2;
    for (Object localObject1 = (String)this.activityNameMap.get(str1); ; localObject1 = str2)
    {
      return localObject1;
      str2 = this.parameterFetcher.getString(str1);
      if (str2 == null)
        str2 = str1;
      Object localObject2 = this.activityNameMap.put(str1, str2);
    }
  }

  public static EasyTracker getInstance()
  {
    if (instance == null)
      instance = new EasyTracker();
    return instance;
  }

  public static Tracker getTracker()
  {
    if (getInstance().gaContext == null)
      throw new IllegalStateException("You must call EasyTracker.getInstance().setContext(context) or startActivity(activity) before calling getTracker()");
    return getInstance().tracker;
  }

  private void loadParameters()
  {
    boolean bool1 = true;
    String str1 = this.parameterFetcher.getString("ga_trackingId");
    this.gaTrackingId = str1;
    if (TextUtils.isEmpty(this.gaTrackingId))
    {
      String str2 = this.parameterFetcher.getString("ga_api_key");
      this.gaTrackingId = str2;
      if (TextUtils.isEmpty(this.gaTrackingId))
      {
        int i = Log.e("EasyTracker requested, but missing required ga_trackingId");
        NoopTracker localNoopTracker = new NoopTracker();
        this.tracker = localNoopTracker;
        return;
      }
    }
    this.gaEnabled = true;
    String str3 = this.parameterFetcher.getString("ga_appName");
    this.gaAppName = str3;
    String str4 = this.parameterFetcher.getString("ga_appVersion");
    this.gaAppVersion = str4;
    boolean bool2 = this.parameterFetcher.getBoolean("ga_debug");
    this.gaDebug = bool2;
    Double localDouble1 = this.parameterFetcher.getDoubleFromString("ga_sampleFrequency");
    this.gaSampleRate = localDouble1;
    if (this.gaSampleRate == null)
    {
      double d1 = this.parameterFetcher.getInt("ga_sampleRate", 100);
      Double localDouble2 = new Double(d1);
      this.gaSampleRate = localDouble2;
    }
    int j = this.parameterFetcher.getInt("ga_dispatchPeriod", 1800);
    this.gaDispatchPeriod = j;
    long l = this.parameterFetcher.getInt("ga_sessionTimeout", 30) * 1000;
    this.gaSessionTimeout = l;
    if ((this.parameterFetcher.getBoolean("ga_autoActivityTracking")) || (this.parameterFetcher.getBoolean("ga_auto_activity_tracking")));
    while (true)
    {
      this.autoActivityTracking = bool1;
      boolean bool3 = this.parameterFetcher.getBoolean("ga_anonymizeIp");
      this.gaAnonymizeIp = bool3;
      boolean bool4 = this.parameterFetcher.getBoolean("ga_reportUncaughtExceptions");
      this.gaReportUncaughtExceptions = bool4;
      Analytics localAnalytics1 = this.ga;
      String str5 = this.gaTrackingId;
      Tracker localTracker1 = localAnalytics1.getTracker(str5);
      this.tracker = localTracker1;
      if (!TextUtils.isEmpty(this.gaAppName))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("setting appName to ");
        String str6 = this.gaAppName;
        int k = Log.i(str6);
        Tracker localTracker2 = this.tracker;
        String str7 = this.gaAppName;
        localTracker2.setAppName(str7);
      }
      if (this.gaAppVersion != null)
      {
        Tracker localTracker3 = this.tracker;
        String str8 = this.gaAppVersion;
        localTracker3.setAppVersion(str8);
      }
      Tracker localTracker4 = this.tracker;
      boolean bool5 = this.gaAnonymizeIp;
      localTracker4.setAnonymizeIp(bool5);
      Tracker localTracker5 = this.tracker;
      double d2 = this.gaSampleRate.doubleValue();
      localTracker5.setSampleRate(d2);
      Analytics localAnalytics2 = this.ga;
      boolean bool6 = this.gaDebug;
      localAnalytics2.setDebug(bool6);
      ServiceManager localServiceManager1 = this.serviceManager;
      int m = this.gaDispatchPeriod;
      localServiceManager1.setDispatchPeriod(m);
      if (!this.gaReportUncaughtExceptions)
        return;
      Object localObject = this.handler;
      if (localObject == null)
      {
        Tracker localTracker6 = this.tracker;
        ServiceManager localServiceManager2 = this.serviceManager;
        Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        localObject = new ExceptionReporter(localTracker6, localServiceManager2, localUncaughtExceptionHandler);
      }
      Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)localObject);
      return;
      bool1 = false;
    }
  }

  public void activityStart(Activity paramActivity)
  {
    setContext(paramActivity);
    if (!this.gaEnabled)
      return;
    clearExistingTimer();
    if ((!this.inForeground) && (this.activitiesActive == 0) && (checkForNewSession()))
    {
      this.tracker.setStartSession(true);
      if (this.autoActivityTracking);
    }
    this.inForeground = true;
    int i = this.activitiesActive + 1;
    this.activitiesActive = i;
    if (!this.autoActivityTracking)
      return;
    Tracker localTracker = this.tracker;
    String str = getActivityName(paramActivity);
    localTracker.trackView(str);
  }

  public void activityStop(Activity paramActivity)
  {
    setContext(paramActivity);
    if (!this.gaEnabled)
      return;
    int i = this.activitiesActive + -1;
    this.activitiesActive = i;
    int j = this.activitiesActive;
    int k = Math.max(0, j);
    this.activitiesActive = k;
    long l = this.clock.currentTimeMillis();
    this.lastOnStopTime = l;
    if (this.activitiesActive != 0)
      return;
    clearExistingTimer();
    NotInForegroundTimerTask localNotInForegroundTimerTask = new NotInForegroundTimerTask(null);
    this.timerTask = localNotInForegroundTimerTask;
    Timer localTimer1 = new Timer("waitForActivityStart");
    this.timer = localTimer1;
    Timer localTimer2 = this.timer;
    TimerTask localTimerTask = this.timerTask;
    localTimer2.schedule(localTimerTask, 1000L);
  }

  boolean checkForNewSession()
  {
    if (this.gaSessionTimeout != 0L)
    {
      if (this.gaSessionTimeout <= 0L)
        break label62;
      long l1 = this.clock.currentTimeMillis();
      long l2 = this.lastOnStopTime;
      long l3 = this.gaSessionTimeout;
      long l4 = l2 + l3;
      if (l1 <= l4)
        break label62;
    }
    label62: for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void dispatch()
  {
    if (!this.gaEnabled)
      return;
    this.serviceManager.dispatch();
  }

  int getActivitiesActive()
  {
    return this.activitiesActive;
  }

  void setClock(Clock paramClock)
  {
    this.clock = paramClock;
  }

  public void setContext(Context paramContext)
  {
    if (paramContext == null)
    {
      int i = Log.e("Context cannot be null");
      return;
    }
    GAServiceManager localGAServiceManager = GAServiceManager.getInstance();
    Context localContext = paramContext.getApplicationContext();
    ParameterLoaderImpl localParameterLoaderImpl = new ParameterLoaderImpl(localContext);
    GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.getInstance(paramContext.getApplicationContext());
    setContext(paramContext, localParameterLoaderImpl, localGoogleAnalytics, localGAServiceManager);
  }

  void setContext(Context paramContext, ParameterLoader paramParameterLoader, Analytics paramAnalytics, ServiceManager paramServiceManager)
  {
    if (paramContext == null)
      int i = Log.e("Context cannot be null");
    if (this.gaContext != null)
      return;
    Context localContext = paramContext.getApplicationContext();
    this.gaContext = localContext;
    this.ga = paramAnalytics;
    this.serviceManager = paramServiceManager;
    this.parameterFetcher = paramParameterLoader;
    loadParameters();
  }

  void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.handler = paramUncaughtExceptionHandler;
  }

  private class NotInForegroundTimerTask extends TimerTask
  {
    private NotInForegroundTimerTask()
    {
    }

    public void run()
    {
      boolean bool = EasyTracker.access$102(EasyTracker.this, false);
    }
  }

  class NoopTracker
    implements Tracker
  {
    private boolean anonymizeIp;
    private String appId;
    private String appInstallerId;
    private ExceptionParser exceptionParser;
    private double sampleRate = 100.0D;
    private boolean useSecure;

    NoopTracker()
    {
    }

    public boolean anonymizeIpEnabled()
    {
      return this.anonymizeIp;
    }

    public void close()
    {
    }

    public Map<String, String> constructEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
    {
      return new HashMap();
    }

    public Map<String, String> constructException(String paramString, boolean paramBoolean)
    {
      return new HashMap();
    }

    public Map<String, String> constructRawException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    {
      return new HashMap();
    }

    public Map<String, String> constructSocial(String paramString1, String paramString2, String paramString3)
    {
      return new HashMap();
    }

    public Map<String, String> constructTiming(String paramString1, long paramLong, String paramString2, String paramString3)
    {
      return new HashMap();
    }

    public Map<String, String> constructTransaction(Transaction paramTransaction)
    {
      return new HashMap();
    }

    public String get(String paramString)
    {
      return "";
    }

    public String getAppId()
    {
      return this.appId;
    }

    public String getAppInstallerId()
    {
      return this.appInstallerId;
    }

    public ExceptionParser getExceptionParser()
    {
      return this.exceptionParser;
    }

    public double getSampleRate()
    {
      return this.sampleRate;
    }

    public String getTrackingId()
    {
      return "";
    }

    public boolean getUseSecure()
    {
      return this.useSecure;
    }

    public void send(String paramString, Map<String, String> paramMap)
    {
    }

    public void set(String paramString1, String paramString2)
    {
    }

    public void setAnonymizeIp(boolean paramBoolean)
    {
      this.anonymizeIp = paramBoolean;
    }

    public void setAppId(String paramString)
    {
      this.appId = paramString;
    }

    public void setAppInstallerId(String paramString)
    {
      this.appInstallerId = paramString;
    }

    public void setAppName(String paramString)
    {
    }

    public void setAppScreen(String paramString)
    {
    }

    public void setAppVersion(String paramString)
    {
    }

    public void setCampaign(String paramString)
    {
    }

    public void setCustomDimension(int paramInt, String paramString)
    {
    }

    public void setCustomDimensionsAndMetrics(Map<Integer, String> paramMap, Map<Integer, Long> paramMap1)
    {
    }

    public void setCustomMetric(int paramInt, Long paramLong)
    {
    }

    public void setExceptionParser(ExceptionParser paramExceptionParser)
    {
      this.exceptionParser = paramExceptionParser;
    }

    public void setReferrer(String paramString)
    {
    }

    public void setSampleRate(double paramDouble)
    {
      this.sampleRate = paramDouble;
    }

    public void setStartSession(boolean paramBoolean)
    {
    }

    public void setUseSecure(boolean paramBoolean)
    {
      this.useSecure = paramBoolean;
    }

    public void trackEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
    {
    }

    public void trackException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    {
    }

    public void trackException(String paramString, boolean paramBoolean)
    {
    }

    public void trackSocial(String paramString1, String paramString2, String paramString3)
    {
    }

    public void trackTiming(String paramString1, long paramLong, String paramString2, String paramString3)
    {
    }

    public void trackTransaction(Transaction paramTransaction)
    {
    }

    public void trackView()
    {
    }

    public void trackView(String paramString)
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.EasyTracker
 * JD-Core Version:    0.6.2
 */