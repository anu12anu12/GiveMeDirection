package com.hopstop.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.MASTAdView.MASTAdView;
import com.hopstop.gps.XSPLocationManager;
import java.util.Hashtable;

public class BaseActivity extends Activity
{
  private DelegatedActivity _delegate;
  protected XSPLocationManager xspl = null;

  public void LogD(String paramString)
  {
    this._delegate.LogD(paramString);
  }

  public void LogE(String paramString)
  {
    this._delegate.LogE(paramString);
  }

  public void displayAds()
  {
  }

  public void displayAds(String paramString)
  {
    this._delegate.displayAds(paramString);
  }

  public void displayAds(String paramString1, String paramString2)
  {
    this._delegate.displayAds(paramString1, paramString2);
  }

  public float getScreenDensity()
  {
    return this._delegate.getScreenDensity();
  }

  public int[] getScreenDimention()
  {
    return this._delegate.getScreenDimention();
  }

  public int getScreenLongSide()
  {
    return this._delegate.getScreenLongSide();
  }

  public int getScreenShortSide()
  {
    return this._delegate.getScreenShortSide();
  }

  public boolean getSharedPreferenceBoolean(String paramString, boolean paramBoolean)
  {
    return this._delegate.getSharedPreferenceBoolean(paramString, paramBoolean);
  }

  public int getSharedPreferenceInt(String paramString)
  {
    return this._delegate.getSharedPreferenceInt(paramString);
  }

  public String getSharedPreferenceString(String paramString)
  {
    return this._delegate.getSharedPreferenceString(paramString);
  }

  public int getStatusBarHeight()
  {
    return this._delegate.getStatusBarHeight();
  }

  protected void initCityButtons(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this._delegate.initCityButtons(paramContext, paramInt1, paramInt2, paramInt3);
  }

  protected void initiateAsyncImageLoader()
  {
    this._delegate.initiateAsyncImageLoader();
  }

  protected void loadImageAsync(String paramString, ImageView paramImageView)
  {
    this._delegate.loadImageAsync(paramString, paramImageView);
  }

  protected boolean needUpdateFromPreferences(String paramString, int paramInt)
  {
    return this._delegate.needUpdateFromPreferences(paramString, paramInt);
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
    this._delegate.onBackPressed();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = requestWindowFeature(1);
    DelegatedActivity localDelegatedActivity = new DelegatedActivity(this);
    this._delegate = localDelegatedActivity;
    this._delegate.onCreate(paramBundle);
  }

  protected void onDestroy()
  {
    this._delegate.onDestroy();
    super.onDestroy();
  }

  protected void onPause()
  {
    this._delegate.onPause();
    super.onPause();
  }

  public void onResume()
  {
    this._delegate.onResume();
    super.onResume();
  }

  protected void onStart()
  {
    this._delegate.onStart();
    super.onStart();
  }

  protected void onStop()
  {
    this._delegate.onStop();
    super.onStop();
  }

  public void resetTabBackground()
  {
    this._delegate.resetTabBackground();
  }

  protected void sendEmail(String paramString1, String paramString2, String paramString3)
  {
    this._delegate.sendEmail(paramString1, paramString2, paramString3);
  }

  protected void setNextUpdateFromPreferences(String paramString)
  {
    this._delegate.setNextUpdateFromPreferences(paramString);
  }

  public void setSharedPreferenceBoolean(String paramString, boolean paramBoolean)
  {
    this._delegate.setSharedPreferenceBoolean(paramString, paramBoolean);
  }

  public void setSharedPreferenceInt(String paramString, int paramInt)
  {
    this._delegate.setSharedPreferenceInt(paramString, paramInt);
  }

  public void setSharedPreferenceString(String paramString1, String paramString2)
  {
    this._delegate.setSharedPreferenceString(paramString1, paramString2);
  }

  public void startSkyHook()
  {
    this._delegate.startSkyHook();
  }

  public void stopSkyHook()
  {
    this._delegate.stopSkyHook();
  }

  public void tabDirectionsClick(View paramView)
  {
    this._delegate.tabDirectionsClick(paramView);
  }

  public void tabMoreClick(View paramView)
  {
    this._delegate.tabMoreClick(paramView);
  }

  public void tabNearbyStationsClick(View paramView)
  {
    this._delegate.tabNearbyStationsClick(paramView);
  }

  public void tabSchedulesClick(View paramView)
  {
    this._delegate.tabSchedulesClick(paramView);
  }

  public void tabTransitMapsClick(View paramView)
  {
    this._delegate.tabTransitMapsClick(paramView);
  }

  public void trackAction(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    this._delegate.trackAction(paramString1, paramString2, paramString3, paramLong);
  }

  public void trackEvent(String paramString)
  {
    this._delegate.trackEvent(paramString);
  }

  protected void update(int paramInt, Hashtable<String, String> paramHashtable, String paramString1, String paramString2)
  {
    this._delegate.update(paramInt, paramHashtable, paramString1, paramString2);
  }

  protected void update(int paramInt, Hashtable<String, String> paramHashtable, String paramString1, String paramString2, boolean paramBoolean)
  {
    DelegatedActivity localDelegatedActivity = this._delegate;
    int i = paramInt;
    Hashtable<String, String> localHashtable = paramHashtable;
    String str1 = paramString1;
    String str2 = paramString2;
    boolean bool = paramBoolean;
    localDelegatedActivity.update(i, localHashtable, str1, str2, bool);
  }

  protected void updateCityButtons(int paramInt1, int paramInt2, int paramInt3)
  {
    this._delegate.updateCityButtons(paramInt1, paramInt2, paramInt3);
  }

  static abstract interface AdServerViewRunnable extends Runnable
  {
    public abstract void setAdServerView(MASTAdView paramMASTAdView);

    public abstract void setVisibility(int paramInt);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.BaseActivity
 * JD-Core Version:    0.6.2
 */