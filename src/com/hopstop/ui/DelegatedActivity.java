package com.hopstop.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.MASTAdView.MASTAdView;
import com.MASTAdView.MASTAdViewCore.MASTOnAdDownload;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Tracker;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.ClientView.CitiesSelectionActivity;
import com.hopstop.ClientView.DirectionsMainViewActivity;
import com.hopstop.ClientView.MoreActivity;
import com.hopstop.ClientView.NearbyStationsRequestActivity;
import com.hopstop.ClientView.SchedulesSearchActivity;
import com.hopstop.ClientView.TransitMapActivity;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.gps.GPSEngine;
import com.hopstop.gps.GPSFixRequest;
import com.hopstop.gps.XSPLocationManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class DelegatedActivity
{
  private static final String CRASHLYTICS_TAG = "HopStopAppDelegatedActivity";
  public final String DISTANCE_SETTING_KEY = "distance_settings";
  private final int MODE_PRIVATE = 0;
  private final String PREF_FILE_NAME = "HopStopPref";
  private Activity _activity;
  private SharedPreferences _prefs;
  public boolean backPressed = false;
  private int currentGpsRequest;
  Hashtable<String, String> customParameters;
  private final String express_buses = "express_buses";
  private boolean googleTracked = false;
  String lat;
  String lon;
  private String mediaLetsKeyWord = null;
  private Runnable returnRes;
  private final String simplified_directions = "simplified_directions";
  private final String smart_route_key = "smart_route";
  ArrayList<Integer> tabList;
  int zone;

  public DelegatedActivity(Activity paramActivity)
  {
    AdServerViewRunnable local1 = new AdServerViewRunnable()
    {
      private MASTAdView adServerView;
      private int visibility;

      public void run()
      {
        if (this.adServerView == null)
          return;
        MASTAdView localMASTAdView = this.adServerView;
        int i = this.visibility;
        localMASTAdView.setVisibility(i);
      }

      public void setAdServerView(MASTAdView paramAnonymousMASTAdView)
      {
        this.adServerView = paramAnonymousMASTAdView;
      }

      public void setVisibility(int paramAnonymousInt)
      {
        this.visibility = paramAnonymousInt;
      }
    };
    this.returnRes = local1;
    this._activity = paramActivity;
    EasyTracker.getInstance().setContext(paramActivity);
    SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
    this._prefs = localSharedPreferences;
    ArrayList localArrayList1 = new ArrayList();
    this.tabList = localArrayList1;
    ArrayList localArrayList2 = this.tabList;
    Integer localInteger1 = Integer.valueOf(2131493274);
    boolean bool1 = localArrayList2.add(localInteger1);
    ArrayList localArrayList3 = this.tabList;
    Integer localInteger2 = Integer.valueOf(2131493275);
    boolean bool2 = localArrayList3.add(localInteger2);
    ArrayList localArrayList4 = this.tabList;
    Integer localInteger3 = Integer.valueOf(2131493276);
    boolean bool3 = localArrayList4.add(localInteger3);
    ArrayList localArrayList5 = this.tabList;
    Integer localInteger4 = Integer.valueOf(2131493277);
    boolean bool4 = localArrayList5.add(localInteger4);
    ArrayList localArrayList6 = this.tabList;
    Integer localInteger5 = Integer.valueOf(2131493278);
    boolean bool5 = localArrayList6.add(localInteger5);
  }

  private void adViewUpdate(int paramInt, Hashtable<String, String> paramHashtable, String paramString1, String paramString2)
  {
    MASTAdView localMASTAdView = (MASTAdView)this._activity.findViewById(2131492865);
    if (localMASTAdView == null)
      return;
    Integer localInteger1 = Integer.valueOf(320);
    localMASTAdView.setMaxSizeX(localInteger1);
    Integer localInteger2 = Integer.valueOf(50);
    localMASTAdView.setMaxSizeY(localInteger2);
    Integer localInteger3 = Integer.valueOf(paramInt);
    localMASTAdView.setZone(localInteger3);
    localMASTAdView.setBackgroundColor(0);
    if (localMASTAdView == null)
      return;
    UserAdDownload localUserAdDownload = new UserAdDownload();
    localMASTAdView.setOnAdDownload(localUserAdDownload);
    localMASTAdView.update();
    if (paramString1 != null)
      localMASTAdView.setLatitude(paramString1);
    if (paramString2 != null)
      localMASTAdView.setLongitude(paramString2);
    localMASTAdView.setCustomParameters(paramHashtable);
    localMASTAdView.setVerticalScrollBarEnabled(false);
    localMASTAdView.setHorizontalScrollBarEnabled(false);
    View.OnTouchListener local2 = new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 2);
        for (boolean bool = true; ; bool = false)
          return bool;
      }
    };
    localMASTAdView.setOnTouchListener(local2);
    localMASTAdView.setInjectionHeaderCode("<meta name=\"viewport\" content=\"user-scalable=no; initial-scale=1.0;\" /><style>body{margin:0;padding:0;display:-webkit-box;-webkit-box-orient:horizontal;-webkit-box-pack:center;-webkit-box-align:center;} img { max-width:%1.0fpx;}</style>");
  }

  private double convertStringToDouble(String paramString)
  {
    try
    {
      double d1 = Double.parseDouble(paramString);
      d2 = d1;
      return d2;
    }
    catch (Exception localException)
    {
      while (true)
        double d2 = 0.0D;
    }
  }

  private String getDeviceInfo()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("\nDevice: ");
    String str1 = Build.MANUFACTURER;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" ");
    String str2 = Build.MODEL;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(" ");
    String str3 = Build.VERSION.RELEASE;
    return str3;
  }

  private void loadHomeScreen()
  {
    Location localLocation = new Location("Dimitare");
    String str1 = this._prefs.getString("last_location_latitude", "0");
    double d1 = convertStringToDouble(str1);
    localLocation.setLatitude(d1);
    String str2 = this._prefs.getString("last_location_longitude", "0");
    double d2 = convertStringToDouble(str2);
    localLocation.setLongitude(d2);
    HistoryManager localHistoryManager = ApplicationEngine.getHistoryManager(this._activity);
    ApplicationEngine.getModel().updateCurrentLocation(localLocation, -1, -1, null);
    Model localModel1 = ApplicationEngine.getModel();
    String str3 = this._prefs.getString("default_city_id", null);
    localModel1.setDefaultCityId(str3);
    Model localModel2 = ApplicationEngine.getModel();
    int i = this._prefs.getInt("default_county", -1);
    localModel2.setDefaultCountySelection(i);
    Model localModel3 = ApplicationEngine.getModel();
    int j = this._prefs.getInt("default_city_selected", 0);
    localModel3.setDefaultCitySelectionDone(j);
    Model localModel4 = ApplicationEngine.getModel();
    String str4 = this._prefs.getString("selected_language", null);
    localModel4.setLanguage(str4);
    Model localModel5 = ApplicationEngine.getModel();
    boolean bool1 = this._prefs.getBoolean("private_vehicle", true);
    localModel5.setPrivate_vehicles(bool1);
    Model localModel6 = ApplicationEngine.getModel();
    boolean bool2 = this._prefs.getBoolean("simplified_directions", false);
    localModel6.setIsSimplifiedDirections(bool2);
    Model localModel7 = ApplicationEngine.getModel();
    boolean bool3 = this._prefs.getBoolean("express_buses", true);
    localModel7.setIsExpressBusIncluded(bool3);
    Model localModel8 = ApplicationEngine.getModel();
    boolean bool4 = this._prefs.getBoolean("wheel_chair", false);
    localModel8.setWheelChairOn(bool4);
    Model localModel9 = ApplicationEngine.getModel();
    boolean bool5 = this._prefs.getBoolean("smart_route", true);
    localModel9.setIsSmartRouteEnabled(bool5);
    Model localModel10 = ApplicationEngine.getModel();
    boolean bool6 = this._prefs.getBoolean("distance_settings", true);
    localModel10.setIsMiles(bool6);
    if (ApplicationEngine.getGPSEngine(this._activity) != null)
    {
      GPSEngine localGPSEngine1 = ApplicationEngine.getGPSEngine(this._activity);
      GPSFixRequest localGPSFixRequest = ApplicationEngine.getGPSEngine(this._activity).initGPSFixes();
      localGPSEngine1.addGPSRequests(localGPSFixRequest);
      int k = ApplicationEngine.getGPSEngine(null).getGPSFixRequest();
      this.currentGpsRequest = k;
      GPSEngine localGPSEngine2 = ApplicationEngine.getGPSEngine(this._activity);
      int m = this.currentGpsRequest;
      localGPSEngine2.requestGPSFix(m);
    }
    Model localModel11 = ApplicationEngine.getModel();
    long l = this._prefs.getLong("NextUpdateCheckTime", 0L);
    localModel11.setDelayUpdateTime(l);
  }

  private void loadSplashScreen()
  {
    String[] arrayOfString = this._activity.getResources().getStringArray(2131099651);
    ApplicationEngine.getModel().setLanguages(arrayOfString);
  }

  private void savePreferences()
  {
    if (this._prefs == null)
      return;
    SharedPreferences.Editor localEditor1 = this._prefs.edit();
    Location localLocation = ApplicationEngine.getModel().lastKnownLocation();
    if (localLocation == null)
      return;
    String str1 = Double.toString(localLocation.getLatitude());
    String str2 = Double.toString(localLocation.getLongitude());
    String str3 = Double.toString(localLocation.getLatitude());
    SharedPreferences.Editor localEditor2 = localEditor1.putString("last_location_latitude", str3);
    String str4 = Double.toString(localLocation.getLongitude());
    SharedPreferences.Editor localEditor3 = localEditor1.putString("last_location_longitude", str4);
    String str5 = ApplicationEngine.getModel().getDefaultCityByWidgetId(2131492900);
    SharedPreferences.Editor localEditor4 = localEditor1.putString("default_city_id", str5);
    int i = ApplicationEngine.getModel().getDefaultCountySelection();
    SharedPreferences.Editor localEditor5 = localEditor1.putInt("default_county", i);
    int j = ApplicationEngine.getModel().getDefaultCitySelectionDone();
    SharedPreferences.Editor localEditor6 = localEditor1.putInt("default_city_selected", j);
    String str6 = ApplicationEngine.getModel().getLanguage();
    SharedPreferences.Editor localEditor7 = localEditor1.putString("selected_language", str6);
    boolean bool1 = ApplicationEngine.getModel().isPrivate_vehicles();
    SharedPreferences.Editor localEditor8 = localEditor1.putBoolean("private_vehicle", bool1);
    boolean bool2 = ApplicationEngine.getModel().isWheelChairOn();
    SharedPreferences.Editor localEditor9 = localEditor1.putBoolean("wheel_chair", bool2);
    boolean bool3 = ApplicationEngine.getModel().getIsExpressBusIncluded();
    SharedPreferences.Editor localEditor10 = localEditor1.putBoolean("express_buses", bool3);
    boolean bool4 = ApplicationEngine.getModel().getIsSimplifiedDirections();
    SharedPreferences.Editor localEditor11 = localEditor1.putBoolean("simplified_directions", bool4);
    boolean bool5 = ApplicationEngine.getModel().getIsSmartRouteEnabled();
    SharedPreferences.Editor localEditor12 = localEditor1.putBoolean("smart_route", bool5);
    String str7 = ApplicationEngine.getModel().getSkyHookUser();
    SharedPreferences.Editor localEditor13 = localEditor1.putString("skyhook_user", str7);
    long l = ApplicationEngine.getModel().getDelayUpdateTime();
    SharedPreferences.Editor localEditor14 = localEditor1.putLong("NextUpdateCheckTime", l);
    boolean bool6 = localEditor1.commit();
  }

  public void LogD(String paramString)
  {
  }

  public void LogE(String paramString)
  {
  }

  public void displayAds()
  {
  }

  public void displayAds(String paramString)
  {
    String str = ApplicationEngine.getModel().getDefaultCityId();
    this.mediaLetsKeyWord = str;
    displayAds();
  }

  public void displayAds(String paramString1, String paramString2)
  {
    this.mediaLetsKeyWord = paramString2;
    displayAds();
  }

  public float getScreenDensity()
  {
    return this._activity.getResources().getDisplayMetrics().density;
  }

  public int[] getScreenDimention()
  {
    int[] arrayOfInt = new int[2];
    int i = this._activity.getResources().getDisplayMetrics().widthPixels;
    arrayOfInt[0] = i;
    int j = this._activity.getResources().getDisplayMetrics().heightPixels;
    arrayOfInt[1] = j;
    return arrayOfInt;
  }

  public int getScreenLongSide()
  {
    int[] arrayOfInt = getScreenDimention();
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if (i > j);
    for (int k = arrayOfInt[0]; ; k = arrayOfInt[1])
      return k;
  }

  public int getScreenShortSide()
  {
    int[] arrayOfInt = getScreenDimention();
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if (i > j);
    for (int k = arrayOfInt[1]; ; k = arrayOfInt[0])
      return k;
  }

  public boolean getSharedPreferenceBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
    this._prefs = localSharedPreferences;
    if (this._prefs != null)
      paramBoolean = this._prefs.getBoolean(paramString, paramBoolean);
    return paramBoolean;
  }

  public int getSharedPreferenceInt(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", i);
    this._prefs = localSharedPreferences;
    if (this._prefs != null)
      i = this._prefs.getInt(paramString, 0);
    return i;
  }

  public String getSharedPreferenceString(String paramString)
  {
    String str = null;
    SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
    this._prefs = localSharedPreferences;
    if (this._prefs != null)
      str = this._prefs.getString(paramString, null);
    return str;
  }

  public int getStatusBarHeight()
  {
    Rect localRect = new Rect();
    this._activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return localRect.top;
  }

  protected void initCityButtons(final Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    Button localButton1 = (Button)this._activity.findViewById(paramInt2);
    Button localButton2 = (Button)this._activity.findViewById(paramInt3);
    if (localButton1 != null)
    {
      String str = ApplicationEngine.getModel().getDefaultCityName();
      localButton1.setText(str);
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Context localContext = paramContext;
          Intent localIntent = new Intent(localContext, CitiesSelectionActivity.class);
          DelegatedActivity.this._activity.startActivityForResult(localIntent, 11);
        }
      };
      localButton1.setOnClickListener(local3);
    }
    updateCityButtons(paramInt1, paramInt2, paramInt3);
    if (localButton2 == null)
      return;
    localButton2.setText("Manhattan");
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = paramContext;
        Intent localIntent = new Intent(localContext, CitiesSelectionActivity.class);
        DelegatedActivity.this._activity.startActivityForResult(localIntent, 11);
      }
    };
    localButton2.setOnClickListener(local4);
  }

  public void initiateAsyncImageLoader()
  {
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cacheInMemory().cacheOnDisc().showStubImage(2130837564).build();
    Context localContext = this._activity.getApplicationContext();
    ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(localContext).defaultDisplayImageOptions(localDisplayImageOptions).build();
    ImageLoader.getInstance().init(localImageLoaderConfiguration);
  }

  public void loadImageAsync(String paramString, ImageView paramImageView)
  {
    if (paramImageView == null)
      return;
    if (paramImageView == null)
      return;
    try
    {
      ImageLoader.getInstance().displayImage(paramString, paramImageView);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }

  protected boolean needUpdateFromPreferences(String paramString, int paramInt)
  {
    boolean bool = true;
    try
    {
      SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
      this._prefs = localSharedPreferences;
      long l1;
      if (this._prefs != null)
      {
        l1 = this._prefs.getLong(paramString, 0L);
        long l2 = System.currentTimeMillis();
        long l3 = l2;
        long l4 = paramInt + l1;
        if (l3 <= l4)
          break label76;
      }
      while (true)
      {
        return bool;
        l1 = 0L;
        break;
        label76: bool = false;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  protected void onAdDownloadBegin()
  {
  }

  protected void onAdDownloadEnd()
  {
  }

  protected void onAdDownloadError()
  {
  }

  public void onBackPressed()
  {
    this.backPressed = true;
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Class localClass = this._activity.getClass();
    Activity localActivity = this._activity;
    Intent localIntent = localTabManager.getIntentOnDestroy(localClass, localActivity);
    if (localIntent != null)
      this._activity.startActivity(localIntent);
    this._activity.finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    String str = this._activity.getClass().getSimpleName();
    if (str.contains("SplashScreen"))
      loadSplashScreen();
    while (true)
    {
      TabManager localTabManager = ApplicationEngine.getTabManager();
      Class localClass = this._activity.getClass();
      localTabManager.handleActivityOnCreate(localClass);
      return;
      if (str.contains("DirectionsMainViewActivity"))
        loadHomeScreen();
    }
  }

  protected void onDestroy()
  {
    if (this.backPressed)
    {
      this.backPressed = false;
      return;
    }
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Class localClass = this._activity.getClass();
    Activity localActivity = this._activity;
    Intent localIntent = localTabManager.getIntentOnDestroy(localClass, localActivity);
    if (localIntent == null)
      return;
    this._activity.startActivity(localIntent);
  }

  protected void onPause()
  {
    savePreferences();
  }

  public void onResume()
  {
    int i = this.zone;
    Hashtable localHashtable = this.customParameters;
    String str1 = this.lat;
    String str2 = this.lon;
    adViewUpdate(i, localHashtable, str1, str2);
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Class localClass = this._activity.getClass();
    localTabManager.setTab(localClass);
    resetTabBackground();
  }

  protected void onStart()
  {
    if (!this.googleTracked)
    {
      EasyTracker localEasyTracker = EasyTracker.getInstance();
      Activity localActivity = this._activity;
      localEasyTracker.activityStart(localActivity);
    }
    FlurryAgent.onStartSession(this._activity, "858BMPGJIX84414Z3WYI");
    FlurryAgent.onPageView();
    String str1 = String.valueOf(this._activity.getClass().getSimpleName());
    String str2 = str1 + " OnStart";
    Crashlytics.log(4, "HopStopAppDelegatedActivity", str2);
  }

  protected void onStop()
  {
    if (!this.googleTracked)
    {
      EasyTracker localEasyTracker = EasyTracker.getInstance();
      Activity localActivity = this._activity;
      localEasyTracker.activityStop(localActivity);
    }
    FlurryAgent.onEndSession(this._activity);
    String str1 = String.valueOf(this._activity.getClass().getSimpleName());
    String str2 = str1 + "OnStop";
    Crashlytics.log(4, "HopStopAppDelegatedActivity", str2);
  }

  public void resetTabBackground()
  {
    int i = ApplicationEngine.getTabManager().getCurrentTab();
    if (i == -1)
      return;
    int j = ((Integer)this.tabList.get(i)).intValue();
    View localView1 = this._activity.findViewById(j);
    if (localView1 != null)
      localView1.setBackgroundResource(2130837514);
    Iterator localIterator = this.tabList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      int k = ((Integer)localIterator.next()).intValue();
      if (k != j)
      {
        View localView2 = this._activity.findViewById(k);
        if (localView2 != null)
          localView2.setBackgroundResource(2130837513);
      }
    }
  }

  protected void sendEmail(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder("mailto:").append(paramString1).append("?subject=").append(paramString2).append("&body=").append(paramString3);
    String str = getDeviceInfo();
    Uri localUri = Uri.parse(str);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    try
    {
      this._activity.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Activity localActivity = this._activity;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localActivity);
      AlertDialog.Builder localBuilder2 = localBuilder1.setTitle("Cannot create an email");
      AlertDialog.Builder localBuilder3 = localBuilder1.setMessage("Please make sure you have email account set up.");
      localBuilder1.create().show();
    }
  }

  protected void setNextUpdateFromPreferences(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
      this._prefs = localSharedPreferences;
      long l = System.currentTimeMillis();
      if (this._prefs == null)
        return;
      SharedPreferences.Editor localEditor1 = this._prefs.edit();
      if (localEditor1 == null)
        return;
      SharedPreferences.Editor localEditor2 = localEditor1.putLong(paramString, l);
      boolean bool = localEditor1.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void setSharedPreferenceBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
    this._prefs = localSharedPreferences;
    if (this._prefs == null)
      return;
    SharedPreferences.Editor localEditor1 = this._prefs.edit();
    if (localEditor1 == null)
      return;
    SharedPreferences.Editor localEditor2 = localEditor1.putBoolean(paramString, paramBoolean);
    boolean bool = localEditor1.commit();
  }

  public void setSharedPreferenceInt(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
    this._prefs = localSharedPreferences;
    if (this._prefs == null)
      return;
    SharedPreferences.Editor localEditor1 = this._prefs.edit();
    if (localEditor1 == null)
      return;
    SharedPreferences.Editor localEditor2 = localEditor1.putInt(paramString, paramInt);
    boolean bool = localEditor1.commit();
  }

  public void setSharedPreferenceString(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this._activity.getSharedPreferences("HopStopPref", 0);
    this._prefs = localSharedPreferences;
    if (this._prefs == null)
      return;
    SharedPreferences.Editor localEditor1 = this._prefs.edit();
    if (localEditor1 == null)
      return;
    SharedPreferences.Editor localEditor2 = localEditor1.putString(paramString1, paramString2);
    boolean bool = localEditor1.commit();
  }

  public void startSkyHook()
  {
    XSPLocationManager.getXSPLocationManager(this._activity).startXSP();
  }

  public void stopSkyHook()
  {
    XSPLocationManager.getXSPLocationManager(this._activity).done();
  }

  public void tabDirectionsClick(View paramView)
  {
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Activity localActivity = this._activity;
    Intent localIntent = localTabManager.getIntentOnTabClick(DirectionsMainViewActivity.class, localActivity);
    resetTabBackground();
    this._activity.startActivity(localIntent);
  }

  public void tabMoreClick(View paramView)
  {
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Activity localActivity = this._activity;
    Intent localIntent = localTabManager.getIntentOnTabClick(MoreActivity.class, localActivity);
    resetTabBackground();
    this._activity.startActivity(localIntent);
  }

  public void tabNearbyStationsClick(View paramView)
  {
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Activity localActivity = this._activity;
    Intent localIntent = localTabManager.getIntentOnTabClick(NearbyStationsRequestActivity.class, localActivity);
    resetTabBackground();
    this._activity.startActivity(localIntent);
  }

  public void tabSchedulesClick(View paramView)
  {
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Activity localActivity = this._activity;
    Intent localIntent = localTabManager.getIntentOnTabClick(SchedulesSearchActivity.class, localActivity);
    resetTabBackground();
    this._activity.startActivity(localIntent);
  }

  public void tabTransitMapsClick(View paramView)
  {
    TabManager localTabManager = ApplicationEngine.getTabManager();
    Activity localActivity = this._activity;
    Intent localIntent = localTabManager.getIntentOnTabClick(TransitMapActivity.class, localActivity);
    resetTabBackground();
    this._activity.startActivity(localIntent);
  }

  public void trackAction(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    try
    {
      EasyTracker.getTracker().trackEvent(paramString1, paramString2, paramString3, paramLong);
      String str1 = String.valueOf(this._activity.getClass().getSimpleName());
      String str2 = str1 + " trackAction(" + "category:" + paramString1 + ", action:" + paramString2 + ",label:" + paramString3;
      Crashlytics.log(4, "HopStopAppDelegatedActivity", str2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void trackEvent(String paramString)
  {
    try
    {
      FlurryAgent.onEvent(paramString);
      String str1 = String.valueOf(this._activity.getClass().getSimpleName());
      String str2 = str1 + " Event:" + paramString;
      Crashlytics.log(4, "HopStopAppDelegatedActivity", str2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  protected void update(int paramInt, Hashtable<String, String> paramHashtable, String paramString1, String paramString2)
  {
    this.zone = paramInt;
    this.customParameters = paramHashtable;
    this.lat = paramString1;
    this.lon = paramString2;
  }

  protected void update(int paramInt, Hashtable<String, String> paramHashtable, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.zone = paramInt;
    this.customParameters = paramHashtable;
    this.lat = paramString1;
    this.lon = paramString2;
    if (!paramBoolean)
      return;
    adViewUpdate(paramInt, paramHashtable, paramString1, paramString2);
  }

  protected void updateCityButtons(int paramInt1, int paramInt2, int paramInt3)
  {
    Button localButton1 = (Button)this._activity.findViewById(paramInt2);
    Button localButton2 = (Button)this._activity.findViewById(paramInt3);
    LinearLayout localLinearLayout = (LinearLayout)this._activity.findViewById(paramInt1);
    if (localButton1 == null)
      return;
    if (localButton2 == null)
      return;
    if (localLinearLayout == null)
      return;
    if (localButton1.getText().equals("New York"))
    {
      localButton2.setVisibility(0);
      localLinearLayout.invalidate();
      return;
    }
    localButton2.setVisibility(8);
    localLinearLayout.invalidate();
  }

  static abstract interface AdServerViewRunnable extends Runnable
  {
    public abstract void setAdServerView(MASTAdView paramMASTAdView);

    public abstract void setVisibility(int paramInt);
  }

  class UserAdDownload
    implements MASTAdViewCore.MASTOnAdDownload
  {
    UserAdDownload()
    {
    }

    public void begin(MASTAdView paramMASTAdView)
    {
    }

    public void end(MASTAdView paramMASTAdView)
    {
      ((DelegatedActivity.AdServerViewRunnable)DelegatedActivity.this.returnRes).setVisibility(0);
      ((DelegatedActivity.AdServerViewRunnable)DelegatedActivity.this.returnRes).setAdServerView(paramMASTAdView);
      Activity localActivity = DelegatedActivity.this._activity;
      Runnable localRunnable = DelegatedActivity.this.returnRes;
      localActivity.runOnUiThread(localRunnable);
    }

    public void error(MASTAdView paramMASTAdView, String paramString)
    {
      ((DelegatedActivity.AdServerViewRunnable)DelegatedActivity.this.returnRes).setVisibility(8);
      ((DelegatedActivity.AdServerViewRunnable)DelegatedActivity.this.returnRes).setAdServerView(paramMASTAdView);
      Activity localActivity = DelegatedActivity.this._activity;
      Runnable localRunnable = DelegatedActivity.this.returnRes;
      localActivity.runOnUiThread(localRunnable);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.DelegatedActivity
 * JD-Core Version:    0.6.2
 */