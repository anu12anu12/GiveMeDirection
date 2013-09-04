package com.MASTAdView.ormma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.MASTAdView.MASTAdLog;
import com.MASTAdView.MASTAdViewCore;
import com.MASTAdView.ormma.util.OrmmaConfigurationBroadcastReceiver;
import org.json.JSONException;
import org.json.JSONObject;

public class OrmmaDisplayController extends OrmmaController
{
  private static final String LOG_TAG = "OrmmaDisplayController";
  private OrmmaController.Dimensions defaultPosition;
  private OrmmaConfigurationBroadcastReceiver mConfigurationBroadCastReceiver;
  private IntentFilter mConfigurationFilter;
  private int mOrientationListenerCount = 0;
  private WindowManager mWindowManager;

  public OrmmaDisplayController(MASTAdViewCore paramMASTAdViewCore, Context paramContext)
  {
    super(paramMASTAdViewCore, paramContext);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    this.mWindowManager = localWindowManager;
  }

  public void close()
  {
    this.mOrmmaView.close();
  }

  public String dimensions()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("{ \"top\" :");
    int i = this.mOrmmaView.getTop();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(",").append("\"left\" :");
    int j = this.mOrmmaView.getLeft();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(j).append(",").append("\"bottom\" :");
    int k = this.mOrmmaView.getBottom();
    StringBuilder localStringBuilder4 = localStringBuilder3.append(k).append(",").append("\"right\" :");
    int m = this.mOrmmaView.getRight();
    return m + "}";
  }

  public void expand(String paramString1, String paramString2)
  {
    try
    {
      OrmmaController.Dimensions localDimensions = new OrmmaController.Dimensions();
      OrmmaController.Properties localProperties = (OrmmaController.Properties)getFromJSON(new JSONObject(paramString2), OrmmaController.Properties.class);
      int i = localProperties.width;
      localDimensions.width = i;
      int j = localProperties.height;
      localDimensions.height = j;
      localDimensions.x = 0;
      localDimensions.y = 0;
      this.mOrmmaView.expand(localDimensions, paramString1, localProperties);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"expand\",\"Wrong number\")");
      return;
    }
    catch (JSONException localJSONException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"expand\",\"Wrong JSON format\")");
      return;
    }
    catch (Exception localException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"expand\",\"Internal error\")");
    }
  }

  public String getDefaultPosition()
  {
    StringBuilder localStringBuilder4;
    int m;
    if (this.defaultPosition != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder("{ \"x\": ");
      int i = this.defaultPosition.x;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(", \"y\": ");
      int j = this.defaultPosition.y;
      StringBuilder localStringBuilder3 = localStringBuilder2.append(j).append(", ").append("\"width\": ");
      int k = this.defaultPosition.width;
      localStringBuilder4 = localStringBuilder3.append(k).append(", \"height\": ");
      m = this.defaultPosition.height;
    }
    for (String str = m + "}"; ; str = "")
      return str;
  }

  public String getMaxSize()
  {
    Rect localRect = new Rect();
    Window localWindow = ((Activity)this.mOrmmaView.getContext()).getWindow();
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = localWindow.findViewById(16908290).getTop();
    int k = localRect.bottom - j;
    int m = localRect.right;
    int n = localRect.left;
    int i1 = m - n;
    return "{ \"width\": " + i1 + ", " + "\"height\": " + k + "}";
  }

  public int getOrientation()
  {
    int i = this.mWindowManager.getDefaultDisplay().getOrientation();
    int j = -1;
    switch (i)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return j;
      j = 0;
      continue;
      j = 90;
      continue;
      j = 180;
      continue;
      j = 270;
    }
  }

  public String getPlacementType()
  {
    if (this.mOrmmaView.isInterstitial());
    for (String str = "interstitial"; ; str = "inline")
      return str;
  }

  public String getScreenSize()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.mWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    StringBuilder localStringBuilder1 = new StringBuilder("{ \"width\": ");
    int i = localDisplayMetrics.widthPixels;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(", ").append("\"height\": ");
    int j = localDisplayMetrics.heightPixels;
    return j + "}";
  }

  public String getSize()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("{ \"width\": ");
    int i = this.mOrmmaView.getWidth();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(", ").append("\"height\": ");
    int j = this.mOrmmaView.getHeight();
    return j + "}";
  }

  public void getState()
  {
    String str = this.mOrmmaView.getState();
  }

  public boolean getViewable()
  {
    if (this.mOrmmaView.getVisibility() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void hide()
  {
    this.mOrmmaView.hide();
  }

  public boolean isVisible()
  {
    if (this.mOrmmaView.getVisibility() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void onOrientationChanged(int paramInt)
  {
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str = "Ormma.gotOrientationChange(" + paramInt + ")";
    localMASTAdViewCore.injectJavaScript(str);
  }

  public void open(String paramString)
  {
    try
    {
      MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
      String str = "url=" + paramString;
      localMASTAdViewCore.ormmaEvent("open", str);
      Uri localUri = Uri.parse(paramString.toString());
      Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
      this.mContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"open\",\"Cannot open this URL\")");
    }
  }

  public void openMap(String paramString, boolean paramBoolean)
  {
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    StringBuilder localStringBuilder = new StringBuilder("url=").append(paramString).append(";fullscreen=");
    String str1 = String.valueOf(paramBoolean);
    String str2 = str1;
    localMASTAdViewCore.ormmaEvent("openmap", str2);
    String str3 = "openMap: url: " + paramString;
    int i = Log.d("OrmmaDisplayController", str3);
    this.mOrmmaView.openMap(paramString, paramBoolean);
  }

  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3)
  {
    String str1 = "playAudio: url: " + paramString1 + " autoPlay: " + paramBoolean1 + " controls: " + paramBoolean2 + " loop: " + paramBoolean3 + " position: " + paramBoolean4 + " startStyle: " + paramString2 + " stopStyle: " + paramString3;
    int i = Log.d("OrmmaDisplayController", str1);
    if (!URLUtil.isValidUrl(paramString1))
      return;
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str2 = paramString1;
    boolean bool1 = true;
    boolean bool2 = false;
    localMASTAdViewCore.playAudio(str2, true, bool1, false, bool2, "fullscreen", "exit");
  }

  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int[] paramArrayOfInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("playVideo: url: ").append(paramString1).append(" audioMuted: ").append(paramBoolean1).append(" autoPlay: ").append(paramBoolean2).append(" controls: ").append(paramBoolean3).append(" loop: ");
    boolean bool = paramBoolean4;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(bool).append(" x: ");
    int i = paramArrayOfInt[0];
    StringBuilder localStringBuilder3 = localStringBuilder2.append(i).append(" y: ");
    int j = paramArrayOfInt[1];
    StringBuilder localStringBuilder4 = localStringBuilder3.append(j).append(" width: ");
    int k = paramArrayOfInt[2];
    StringBuilder localStringBuilder5 = localStringBuilder4.append(k).append(" height: ");
    int m = paramArrayOfInt[3];
    StringBuilder localStringBuilder6 = localStringBuilder5.append(m).append(" startStyle: ");
    String str1 = paramString2;
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str1).append(" stopStyle: ");
    String str2 = paramString3;
    String str3 = str2;
    int n = Log.d("OrmmaDisplayController", str3);
    if (paramArrayOfInt[0] != -1)
    {
      OrmmaController.Dimensions localDimensions = new OrmmaController.Dimensions();
      int i1 = paramArrayOfInt[0];
      localDimensions.x = i1;
      int i2 = paramArrayOfInt[1];
      localDimensions.y = i2;
      int i3 = paramArrayOfInt[2];
      localDimensions.width = i3;
      int i4 = paramArrayOfInt[3];
      localDimensions.height = i4;
    }
    if (!URLUtil.isValidUrl(paramString1))
    {
      String str4 = "invalid url: " + paramString1;
      int i5 = Log.d("OrmmaDisplayController", str4);
      return;
    }
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str5 = paramString1;
    localMASTAdViewCore.playVideo(str5, false, true, true, false, null, "fullscreen", "exit");
  }

  public void resize(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = paramInt2;
    try
    {
      String str = getMaxSize();
      OrmmaController.Dimensions localDimensions = (OrmmaController.Dimensions)getFromJSON(new JSONObject(str), OrmmaController.Dimensions.class);
      int k = localDimensions.width;
      int m = localDimensions.height;
      if (paramInt1 > k)
        paramInt1 = k;
      if (paramInt2 > m)
        paramInt2 = m;
      label62: this.mOrmmaView.resize(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      break label62;
    }
  }

  public void setDefaultPosition()
  {
    if (this.defaultPosition != null)
      return;
    OrmmaController.Dimensions localDimensions1 = new OrmmaController.Dimensions();
    this.defaultPosition = localDimensions1;
    OrmmaController.Dimensions localDimensions2 = this.defaultPosition;
    int i = this.mOrmmaView.getLeft();
    localDimensions2.x = i;
    OrmmaController.Dimensions localDimensions3 = this.defaultPosition;
    int j = this.mOrmmaView.getTop();
    localDimensions3.y = j;
    OrmmaController.Dimensions localDimensions4 = this.defaultPosition;
    int k = this.mOrmmaView.getWidth();
    localDimensions4.width = k;
    OrmmaController.Dimensions localDimensions5 = this.defaultPosition;
    int m = this.mOrmmaView.getHeight();
    localDimensions5.height = m;
  }

  public void show()
  {
    this.mOrmmaView.showAdView();
  }

  public void startOrientationListener()
  {
    if ((this.mOrientationListenerCount == 0) || (this.mConfigurationBroadCastReceiver == null) || (this.mConfigurationFilter == null))
    {
      OrmmaConfigurationBroadcastReceiver localOrmmaConfigurationBroadcastReceiver1 = new OrmmaConfigurationBroadcastReceiver(this);
      this.mConfigurationBroadCastReceiver = localOrmmaConfigurationBroadcastReceiver1;
      IntentFilter localIntentFilter1 = new IntentFilter();
      this.mConfigurationFilter = localIntentFilter1;
      this.mConfigurationFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
    }
    int i = this.mOrientationListenerCount + 1;
    this.mOrientationListenerCount = i;
    try
    {
      Context localContext = this.mContext;
      OrmmaConfigurationBroadcastReceiver localOrmmaConfigurationBroadcastReceiver2 = this.mConfigurationBroadCastReceiver;
      IntentFilter localIntentFilter2 = this.mConfigurationFilter;
      Intent localIntent = localContext.registerReceiver(localOrmmaConfigurationBroadcastReceiver2, localIntentFilter2);
      return;
    }
    catch (Exception localException)
    {
      MASTAdLog localMASTAdLog = this.mOrmmaView.getLog();
      String str = localException.getMessage();
      localMASTAdLog.log(1, 1, "startOrientationListener", str);
    }
  }

  public void stopAllOrientationListeners()
  {
    try
    {
      Context localContext = this.mContext;
      OrmmaConfigurationBroadcastReceiver localOrmmaConfigurationBroadcastReceiver = this.mConfigurationBroadCastReceiver;
      localContext.unregisterReceiver(localOrmmaConfigurationBroadcastReceiver);
      label15: this.mConfigurationBroadCastReceiver = null;
      this.mConfigurationFilter = null;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }

  public void stopOrientationListener()
  {
    if (this.mOrientationListenerCount <= 0)
      return;
    int i = this.mOrientationListenerCount + -1;
    this.mOrientationListenerCount = i;
    if (this.mOrientationListenerCount != 0)
      return;
    stopAllOrientationListeners();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.OrmmaDisplayController
 * JD-Core Version:    0.6.2
 */