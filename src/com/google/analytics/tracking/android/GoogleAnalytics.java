package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleAnalytics
  implements Analytics, TrackerHandler
{
  private static GoogleAnalytics instance;
  private AdHitIdGenerator adHitIdGenerator;
  private volatile Boolean appOptOut;
  private volatile String clientId;
  private Context context;
  private boolean debug;
  private Tracker defaultTracker;
  private String lastTrackingId;
  private AnalyticsThread thread;
  private final Map<String, Tracker> trackers;

  private GoogleAnalytics()
  {
    HashMap localHashMap = new HashMap();
    this.trackers = localHashMap;
  }

  private GoogleAnalytics(Context paramContext)
  {
    this(paramContext, localGAThread);
  }

  private GoogleAnalytics(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    HashMap localHashMap = new HashMap();
    this.trackers = localHashMap;
    if (paramContext == null)
      throw new IllegalArgumentException("context cannot be null");
    Context localContext = paramContext.getApplicationContext();
    this.context = localContext;
    this.thread = paramAnalyticsThread;
    AdHitIdGenerator localAdHitIdGenerator = new AdHitIdGenerator();
    this.adHitIdGenerator = localAdHitIdGenerator;
    AnalyticsThread localAnalyticsThread1 = this.thread;
    Analytics.AppOptOutCallback local1 = new Analytics.AppOptOutCallback()
    {
      public void reportAppOptOut(boolean paramAnonymousBoolean)
      {
        GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.this;
        Boolean localBoolean1 = Boolean.valueOf(paramAnonymousBoolean);
        Boolean localBoolean2 = GoogleAnalytics.access$002(localGoogleAnalytics, localBoolean1);
      }
    };
    localAnalyticsThread1.requestAppOptOut(local1);
    AnalyticsThread localAnalyticsThread2 = this.thread;
    AnalyticsThread.ClientIdCallback local2 = new AnalyticsThread.ClientIdCallback()
    {
      public void reportClientId(String paramAnonymousString)
      {
        String str = GoogleAnalytics.access$102(GoogleAnalytics.this, paramAnonymousString);
      }
    };
    localAnalyticsThread2.requestClientId(local2);
  }

  /** @deprecated */
  static void clearInstance()
  {
    try
    {
      instance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  static GoogleAnalytics getInstance()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = instance;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (instance == null)
        instance = new GoogleAnalytics(paramContext);
      GoogleAnalytics localGoogleAnalytics = instance;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  static GoogleAnalytics getNewInstance(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    try
    {
      if (instance != null)
        instance.close();
      instance = new GoogleAnalytics(paramContext, paramAnalyticsThread);
      GoogleAnalytics localGoogleAnalytics = instance;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void close()
  {
  }

  /** @deprecated */
  public void closeTracker(Tracker paramTracker)
  {
    try
    {
      boolean bool = this.trackers.values().remove(paramTracker);
      Tracker localTracker = this.defaultTracker;
      if (paramTracker == localTracker)
        this.defaultTracker = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean debugEnabled()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_DEBUG;
    localGAUsage.setUsage(localField);
    return this.debug;
  }

  Boolean getAppOptOut()
  {
    return this.appOptOut;
  }

  String getClientIdForAds()
  {
    if (this.clientId == null);
    for (String str = null; ; str = this.clientId.toString())
      return str;
  }

  /** @deprecated */
  public Tracker getDefaultTracker()
  {
    try
    {
      GAUsage localGAUsage = GAUsage.getInstance();
      GAUsage.Field localField = GAUsage.Field.GET_DEFAULT_TRACKER;
      localGAUsage.setUsage(localField);
      Tracker localTracker = this.defaultTracker;
      return localTracker;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public Tracker getTracker(String paramString)
  {
    if (paramString == null)
      try
      {
        throw new IllegalArgumentException("trackingId cannot be null");
      }
      finally
      {
      }
    Object localObject2 = (Tracker)this.trackers.get(paramString);
    if (localObject2 == null)
    {
      localObject2 = new GoogleTracker(paramString, this);
      Object localObject3 = this.trackers.put(paramString, localObject2);
      if (this.defaultTracker == null)
        this.defaultTracker = ((Tracker)localObject2);
    }
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_TRACKER;
    localGAUsage.setUsage(localField);
    return localObject2;
  }

  String getTrackingIdForAds()
  {
    return this.lastTrackingId;
  }

  public void requestAppOptOut(Analytics.AppOptOutCallback paramAppOptOutCallback)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.REQUEST_APP_OPT_OUT;
    localGAUsage.setUsage(localField);
    if (this.appOptOut != null)
    {
      boolean bool = this.appOptOut.booleanValue();
      paramAppOptOutCallback.reportAppOptOut(bool);
      return;
    }
    this.thread.requestAppOptOut(paramAppOptOutCallback);
  }

  /** @deprecated */
  public void sendHit(Map<String, String> paramMap)
  {
    if (paramMap == null)
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally
      {
      }
    String str1 = Utils.getLanguage(Locale.getDefault());
    Object localObject2 = paramMap.put("language", str1);
    String str2 = Integer.toString(this.adHitIdGenerator.getAdHitId());
    Object localObject3 = paramMap.put("adSenseAdMobHitId", str2);
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = this.context.getResources().getDisplayMetrics().widthPixels;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append("x");
    int j = this.context.getResources().getDisplayMetrics().heightPixels;
    String str3 = j;
    Object localObject4 = paramMap.put("screenResolution", str3);
    String str4 = GAUsage.getInstance().getAndClearSequence();
    Object localObject5 = paramMap.put("usage", str4);
    String str5 = GAUsage.getInstance().getAndClearUsage();
    this.thread.sendHit(paramMap);
    String str6 = (String)paramMap.get("trackingId");
    this.lastTrackingId = str6;
  }

  public void setAppOptOut(boolean paramBoolean)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_APP_OPT_OUT;
    localGAUsage.setUsage(localField);
    Boolean localBoolean = Boolean.valueOf(paramBoolean);
    this.appOptOut = localBoolean;
    this.thread.setAppOptOut(paramBoolean);
  }

  public void setDebug(boolean paramBoolean)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_DEBUG;
    localGAUsage.setUsage(localField);
    this.debug = paramBoolean;
    Log.setDebug(paramBoolean);
  }

  /** @deprecated */
  public void setDefaultTracker(Tracker paramTracker)
  {
    try
    {
      GAUsage localGAUsage = GAUsage.getInstance();
      GAUsage.Field localField = GAUsage.Field.SET_DEFAULT_TRACKER;
      localGAUsage.setUsage(localField);
      this.defaultTracker = paramTracker;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GoogleAnalytics
 * JD-Core Version:    0.6.2
 */