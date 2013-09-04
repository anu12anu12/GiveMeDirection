package com.MASTAdView;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.VideoView;
import com.MASTAdView.ormma.OrmmaAssetController;
import com.MASTAdView.ormma.OrmmaController.Dimensions;
import com.MASTAdView.ormma.OrmmaController.PlayerProperties;
import com.MASTAdView.ormma.OrmmaController.Properties;
import com.MASTAdView.ormma.OrmmaDisplayController;
import com.MASTAdView.ormma.OrmmaLocationController;
import com.MASTAdView.ormma.OrmmaNetworkController;
import com.MASTAdView.ormma.OrmmaSensorController;
import com.MASTAdView.ormma.OrmmaUtilityController;
import com.MASTAdView.ormma.listeners.LocListener;
import com.MASTAdView.ormma.util.OrmmaPlayer;
import com.MASTAdView.ormma.util.OrmmaUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public abstract class MASTAdViewCore extends WebView
{
  private static final String ACTION_KEY = "action";
  protected static final int BACKGROUND_ID = 101;
  private static final String DIMENSIONS = "expand_dimensions";
  private static final String ERROR_ACTION = "action";
  private static final String ERROR_MESSAGE = "message";
  private static final String EXPAND_DIMENSIONS = "expand_initial_dimensions";
  private static final String EXPAND_PROPERTIES = "expand_properties";
  private static final String EXPAND_URL = "expand_url";
  private static final int MESSAGE_ANIMATE = 1005;
  private static final int MESSAGE_CLOSE = 1001;
  private static final int MESSAGE_EXPAND = 1004;
  private static final int MESSAGE_HIDE = 1002;
  private static final int MESSAGE_OPEN = 1006;
  private static final int MESSAGE_PLAY_AUDIO = 1008;
  private static final int MESSAGE_PLAY_VIDEO = 1007;
  private static final int MESSAGE_RAISE_ERROR = 1009;
  private static final int MESSAGE_RESIZE = 1000;
  private static final int MESSAGE_SHOW = 1003;
  private static final int ORMMA_ID = 102;
  protected static final int PLACEHOLDER_ID = 100;
  private static final String PLAYER_PROPERTIES = "player_properties";
  public static final int PREMIUM_STATUS_BOTH = 2;
  public static final int PREMIUM_STATUS_NON_PREMIUM = 0;
  public static final int PREMIUM_STATUS_PREMIUM = 1;
  private static final String RESIZE_HEIGHT = "resize_height";
  private static final String RESIZE_WIDTH = "resize_width";
  static int RequestCounter = 0;
  public static final int VISIBLE_MODE_CASE1 = 1;
  public static final int VISIBLE_MODE_CASE2 = 2;
  public static final int VISIBLE_MODE_CASE3 = 3;
  public static final String defaultBodyStyle = "<style>body{margin: 0px; padding: 0px; display:-webkit-box;-webkit-box-orient:horizontal;-webkit-box-pack:center;-webkit-box-align:center;}</style>";
  public static final String defaultViewportDefinition = "<meta name=\"viewport\" content=\"target-densitydpi=device-dpi\"/>";
  private static ViewGroup mExpandedFrame;
  private static String mScriptPath = null;
  private static ViewGroup mediaPlayerFrame;
  private static OrmmaPlayer player;
  private boolean IsManualUpdate;
  protected Context _context;
  private MASTOnAdClickListener adClickListener;
  private MASTOnAdDownload adDownload;
  protected MASTAdLog adLog;
  private Long adReloadPeriod;
  protected AdserverRequest adserverRequest;
  int bgColor;
  private Button buttonClose;
  private Integer defaultImageResource;
  protected Dialog dialog;
  private HashSet<String> excampaigns;
  private MASTAdViewCore expandParent;
  protected Handler handler;
  private String injectionHeaderCode;
  private boolean internalBrowser;
  protected boolean isAutoCollapse;
  private boolean isExpanded;
  protected boolean isInterstitial;
  private boolean isShowMediaPlayerFrame;
  protected boolean isShowPreviousAdOnError;
  private String lastRequest;
  private String lastResponse;
  private int lastX;
  private int lastY;
  private LocListener listener;
  private LocationManager locationManager;
  private Float locationMinMoveMeters;
  private Integer locationMinWaitMillis;
  private OrmmaAssetController mAssetController;
  private String mContent;
  private String mDataToInject;
  private OrmmaDisplayController mDisplayController;
  private OrmmaLocationController mLocationController;
  private OrmmaNetworkController mNetworkController;
  private Drawable mOldExpandBackground;
  private int mOldExpandBackgroundColor;
  private int mOldHeight;
  private int mOldWidth;
  private MASTAdViewCore mParentAd;
  private OrmmaSensorController mSensorController;
  private OrmmaUtilityController mUtilityController;
  private ViewState mViewState;
  private WebChromeClient mWebChromeClient;
  private DisplayMetrics metrics;
  private MASTOnActivityHandler onActivityHandler;
  private MASTOnThirdPartyRequest onThirdPartyRequest;
  private OpenUrlThread openUrlThread;
  private boolean ormaEnabled;
  private MASTOnOrmmaListener ormmaListener;
  private ViewGroup parentView;
  protected ReloadTask reloadTask;
  private Timer reloadTimer;
  private WebView view;
  private Integer visibleMode;

  protected MASTAdViewCore(Context paramContext)
  {
    super(paramContext);
    ViewState localViewState = ViewState.DEFAULT;
    this.mViewState = localViewState;
    this.mParentAd = null;
    this.mDataToInject = null;
    HashSet localHashSet = new HashSet();
    this.excampaigns = localHashSet;
    this.isInterstitial = false;
    this.isShowPreviousAdOnError = true;
    this.isAutoCollapse = true;
    this.isShowMediaPlayerFrame = false;
    Integer localInteger = Integer.valueOf(300000);
    this.locationMinWaitMillis = localInteger;
    Float localFloat = Float.valueOf(1000.0F);
    this.locationMinMoveMeters = localFloat;
    MASTAdLog localMASTAdLog = new MASTAdLog(this);
    this.adLog = localMASTAdLog;
    this.IsManualUpdate = false;
    this.internalBrowser = false;
    this.isExpanded = false;
    this.parentView = null;
    this.injectionHeaderCode = null;
    WebChromeClient local1 = new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }
    };
    this.mWebChromeClient = local1;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        Bundle localBundle = paramAnonymousMessage.getData();
        switch (paramAnonymousMessage.what)
        {
        case 1005:
        case 1006:
        default:
        case 1000:
        case 1001:
        case 1002:
        case 1003:
        case 1004:
        case 1008:
        case 1007:
        case 1009:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          MASTAdViewCore.ViewState localViewState1 = MASTAdViewCore.this.mViewState;
          MASTAdViewCore.ViewState localViewState2 = MASTAdViewCore.ViewState.DEFAULT;
          if (localViewState1 == localViewState2)
          {
            MASTAdViewCore.this.stopTimer(false);
            int i = MASTAdViewCore.this.lastX;
            int j = MASTAdViewCore.this.lastY;
            MASTAdViewCore localMASTAdViewCore1 = MASTAdViewCore.this;
            MASTAdViewCore.ViewState localViewState3 = MASTAdViewCore.ViewState.RESIZED;
            localMASTAdViewCore1.mViewState = localViewState3;
            ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParams();
            MASTAdViewCore localMASTAdViewCore2 = MASTAdViewCore.this;
            int k = localLayoutParams1.height;
            localMASTAdViewCore2.mOldHeight = k;
            MASTAdViewCore localMASTAdViewCore3 = MASTAdViewCore.this;
            int m = localLayoutParams1.width;
            localMASTAdViewCore3.mOldWidth = m;
            MASTAdViewCore localMASTAdViewCore4 = MASTAdViewCore.this;
            StringBuilder localStringBuilder1 = new StringBuilder("mOldWidth=");
            String str1 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(";OldHeight=");
            String str2 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(";width=");
            String str3 = String.valueOf(localLayoutParams1.width);
            StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(";height=");
            String str4 = String.valueOf(localLayoutParams1.height);
            String str5 = str4;
            localMASTAdViewCore4.ormmaEvent("resize", str5);
            int n = localLayoutParams1.height;
            int i1 = localBundle.getInt("resize_height", n);
            localLayoutParams1.height = i1;
            int i2 = localLayoutParams1.width;
            int i3 = localBundle.getInt("resize_width", i2);
            localLayoutParams1.width = i3;
            MASTAdViewCore.this.requestLayout();
            MASTAdViewCore.this.lastX = i;
            MASTAdViewCore.this.lastY = j;
          }
          else
          {
            MASTAdViewCore.this.ormmaEvent("error", "Error: resize: Cannot resize an ad that is not in the default state.");
            continue;
            boolean bool1 = MASTAdViewCore.this.closeView(false);
            continue;
            MASTAdViewCore.ViewState localViewState4 = MASTAdViewCore.this.mViewState;
            MASTAdViewCore.ViewState localViewState5 = MASTAdViewCore.ViewState.DEFAULT;
            if (localViewState4 == localViewState5)
            {
              MASTAdViewCore.this.ormmaEvent("hide", "");
              MASTAdViewCore.this.setVisibility(4);
            }
            else
            {
              MASTAdViewCore.this.ormmaEvent("error", "Error: hide: Cannot hide an ad that is not in the default state.");
              continue;
              MASTAdViewCore.this.ormmaEvent("show", "");
              MASTAdViewCore.this.setVisibility(0);
              continue;
              MASTAdViewCore.ViewState localViewState6 = MASTAdViewCore.this.mViewState;
              MASTAdViewCore.ViewState localViewState7 = MASTAdViewCore.ViewState.DEFAULT;
              if (localViewState6 == localViewState7)
              {
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.hideVirtualKeyboard();
                ViewGroup.LayoutParams localLayoutParams2 = MASTAdViewCore.this.getLayoutParams();
                MASTAdViewCore localMASTAdViewCore5 = MASTAdViewCore.this;
                int i4 = localLayoutParams2.height;
                localMASTAdViewCore5.mOldHeight = i4;
                MASTAdViewCore localMASTAdViewCore6 = MASTAdViewCore.this;
                int i5 = localLayoutParams2.width;
                localMASTAdViewCore6.mOldWidth = i5;
                MASTAdViewCore localMASTAdViewCore7 = MASTAdViewCore.this;
                Drawable localDrawable = MASTAdViewCore.this.getBackground();
                localMASTAdViewCore7.mOldExpandBackground = localDrawable;
                MASTAdViewCore localMASTAdViewCore8 = MASTAdViewCore.this;
                int i6 = MASTAdViewCore.this.getBackgroundColor();
                localMASTAdViewCore8.mOldExpandBackgroundColor = i6;
                if (MASTAdViewCore.this.mOldHeight == -1)
                {
                  MASTAdViewCore localMASTAdViewCore9 = MASTAdViewCore.this;
                  int i7 = MASTAdViewCore.this.getHeight();
                  localMASTAdViewCore9.mOldHeight = i7;
                }
                MASTAdViewCore.this.ormmaEvent("expand", "");
                MASTAdViewCore localMASTAdViewCore10 = MASTAdViewCore.this;
                MASTAdViewCore.ViewState localViewState8 = MASTAdViewCore.ViewState.EXPANDED;
                localMASTAdViewCore10.mViewState = localViewState8;
                MASTAdViewCore localMASTAdViewCore11 = MASTAdViewCore.this;
                OrmmaController.Dimensions localDimensions = (OrmmaController.Dimensions)localBundle.getParcelable("expand_initial_dimensions");
                String str6 = localBundle.getString("expand_url");
                OrmmaController.Properties localProperties = (OrmmaController.Properties)localBundle.getParcelable("expand_properties");
                localMASTAdViewCore11.expandInUIThread(localDimensions, str6, localProperties);
              }
              else
              {
                MASTAdViewCore.this.ormmaEvent("error", "Error: expand: Cannot expand an ad that is not in the default state.");
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playaudio", "");
                Handler localHandler1 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore12 = MASTAdViewCore.this;
                MASTAdViewCore.SetupOrmmaAudioPlayer localSetupOrmmaAudioPlayer = new MASTAdViewCore.SetupOrmmaAudioPlayer(localMASTAdViewCore12, localBundle);
                boolean bool2 = localHandler1.post(localSetupOrmmaAudioPlayer);
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playvideo", "fulscreen=false");
                Handler localHandler2 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore13 = MASTAdViewCore.this;
                WebView localWebView = MASTAdViewCore.this.view;
                MASTAdViewCore.SetupOrmmaPlayer localSetupOrmmaPlayer = new MASTAdViewCore.SetupOrmmaPlayer(localMASTAdViewCore13, localWebView, localBundle);
                boolean bool3 = localHandler2.post(localSetupOrmmaPlayer);
                continue;
                String str7 = localBundle.getString("message");
                String str8 = localBundle.getString("action");
                String str9 = "window.ormmaview.fireErrorEvent(\"" + str7 + "\", \"" + str8 + "\")";
                MASTAdViewCore localMASTAdViewCore14 = MASTAdViewCore.this;
                String str10 = "msg=" + str7 + ";action=" + str8;
                localMASTAdViewCore14.ormmaEvent("error", str10);
                MASTAdViewCore.this.injectJavaScript(str9);
              }
            }
          }
        }
      }
    };
    this.handler = local2;
    this.ormaEnabled = false;
    this.bgColor = -1;
    AutoDetectParameters(paramContext);
    initialize(paramContext, null);
  }

  protected MASTAdViewCore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ViewState localViewState = ViewState.DEFAULT;
    this.mViewState = localViewState;
    this.mParentAd = null;
    this.mDataToInject = null;
    HashSet localHashSet = new HashSet();
    this.excampaigns = localHashSet;
    this.isInterstitial = false;
    this.isShowPreviousAdOnError = true;
    this.isAutoCollapse = true;
    this.isShowMediaPlayerFrame = false;
    Integer localInteger = Integer.valueOf(300000);
    this.locationMinWaitMillis = localInteger;
    Float localFloat = Float.valueOf(1000.0F);
    this.locationMinMoveMeters = localFloat;
    MASTAdLog localMASTAdLog = new MASTAdLog(this);
    this.adLog = localMASTAdLog;
    this.IsManualUpdate = false;
    this.internalBrowser = false;
    this.isExpanded = false;
    this.parentView = null;
    this.injectionHeaderCode = null;
    WebChromeClient local1 = new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }
    };
    this.mWebChromeClient = local1;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        Bundle localBundle = paramAnonymousMessage.getData();
        switch (paramAnonymousMessage.what)
        {
        case 1005:
        case 1006:
        default:
        case 1000:
        case 1001:
        case 1002:
        case 1003:
        case 1004:
        case 1008:
        case 1007:
        case 1009:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          MASTAdViewCore.ViewState localViewState1 = MASTAdViewCore.this.mViewState;
          MASTAdViewCore.ViewState localViewState2 = MASTAdViewCore.ViewState.DEFAULT;
          if (localViewState1 == localViewState2)
          {
            MASTAdViewCore.this.stopTimer(false);
            int i = MASTAdViewCore.this.lastX;
            int j = MASTAdViewCore.this.lastY;
            MASTAdViewCore localMASTAdViewCore1 = MASTAdViewCore.this;
            MASTAdViewCore.ViewState localViewState3 = MASTAdViewCore.ViewState.RESIZED;
            localMASTAdViewCore1.mViewState = localViewState3;
            ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParams();
            MASTAdViewCore localMASTAdViewCore2 = MASTAdViewCore.this;
            int k = localLayoutParams1.height;
            localMASTAdViewCore2.mOldHeight = k;
            MASTAdViewCore localMASTAdViewCore3 = MASTAdViewCore.this;
            int m = localLayoutParams1.width;
            localMASTAdViewCore3.mOldWidth = m;
            MASTAdViewCore localMASTAdViewCore4 = MASTAdViewCore.this;
            StringBuilder localStringBuilder1 = new StringBuilder("mOldWidth=");
            String str1 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(";OldHeight=");
            String str2 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(";width=");
            String str3 = String.valueOf(localLayoutParams1.width);
            StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(";height=");
            String str4 = String.valueOf(localLayoutParams1.height);
            String str5 = str4;
            localMASTAdViewCore4.ormmaEvent("resize", str5);
            int n = localLayoutParams1.height;
            int i1 = localBundle.getInt("resize_height", n);
            localLayoutParams1.height = i1;
            int i2 = localLayoutParams1.width;
            int i3 = localBundle.getInt("resize_width", i2);
            localLayoutParams1.width = i3;
            MASTAdViewCore.this.requestLayout();
            MASTAdViewCore.this.lastX = i;
            MASTAdViewCore.this.lastY = j;
          }
          else
          {
            MASTAdViewCore.this.ormmaEvent("error", "Error: resize: Cannot resize an ad that is not in the default state.");
            continue;
            boolean bool1 = MASTAdViewCore.this.closeView(false);
            continue;
            MASTAdViewCore.ViewState localViewState4 = MASTAdViewCore.this.mViewState;
            MASTAdViewCore.ViewState localViewState5 = MASTAdViewCore.ViewState.DEFAULT;
            if (localViewState4 == localViewState5)
            {
              MASTAdViewCore.this.ormmaEvent("hide", "");
              MASTAdViewCore.this.setVisibility(4);
            }
            else
            {
              MASTAdViewCore.this.ormmaEvent("error", "Error: hide: Cannot hide an ad that is not in the default state.");
              continue;
              MASTAdViewCore.this.ormmaEvent("show", "");
              MASTAdViewCore.this.setVisibility(0);
              continue;
              MASTAdViewCore.ViewState localViewState6 = MASTAdViewCore.this.mViewState;
              MASTAdViewCore.ViewState localViewState7 = MASTAdViewCore.ViewState.DEFAULT;
              if (localViewState6 == localViewState7)
              {
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.hideVirtualKeyboard();
                ViewGroup.LayoutParams localLayoutParams2 = MASTAdViewCore.this.getLayoutParams();
                MASTAdViewCore localMASTAdViewCore5 = MASTAdViewCore.this;
                int i4 = localLayoutParams2.height;
                localMASTAdViewCore5.mOldHeight = i4;
                MASTAdViewCore localMASTAdViewCore6 = MASTAdViewCore.this;
                int i5 = localLayoutParams2.width;
                localMASTAdViewCore6.mOldWidth = i5;
                MASTAdViewCore localMASTAdViewCore7 = MASTAdViewCore.this;
                Drawable localDrawable = MASTAdViewCore.this.getBackground();
                localMASTAdViewCore7.mOldExpandBackground = localDrawable;
                MASTAdViewCore localMASTAdViewCore8 = MASTAdViewCore.this;
                int i6 = MASTAdViewCore.this.getBackgroundColor();
                localMASTAdViewCore8.mOldExpandBackgroundColor = i6;
                if (MASTAdViewCore.this.mOldHeight == -1)
                {
                  MASTAdViewCore localMASTAdViewCore9 = MASTAdViewCore.this;
                  int i7 = MASTAdViewCore.this.getHeight();
                  localMASTAdViewCore9.mOldHeight = i7;
                }
                MASTAdViewCore.this.ormmaEvent("expand", "");
                MASTAdViewCore localMASTAdViewCore10 = MASTAdViewCore.this;
                MASTAdViewCore.ViewState localViewState8 = MASTAdViewCore.ViewState.EXPANDED;
                localMASTAdViewCore10.mViewState = localViewState8;
                MASTAdViewCore localMASTAdViewCore11 = MASTAdViewCore.this;
                OrmmaController.Dimensions localDimensions = (OrmmaController.Dimensions)localBundle.getParcelable("expand_initial_dimensions");
                String str6 = localBundle.getString("expand_url");
                OrmmaController.Properties localProperties = (OrmmaController.Properties)localBundle.getParcelable("expand_properties");
                localMASTAdViewCore11.expandInUIThread(localDimensions, str6, localProperties);
              }
              else
              {
                MASTAdViewCore.this.ormmaEvent("error", "Error: expand: Cannot expand an ad that is not in the default state.");
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playaudio", "");
                Handler localHandler1 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore12 = MASTAdViewCore.this;
                MASTAdViewCore.SetupOrmmaAudioPlayer localSetupOrmmaAudioPlayer = new MASTAdViewCore.SetupOrmmaAudioPlayer(localMASTAdViewCore12, localBundle);
                boolean bool2 = localHandler1.post(localSetupOrmmaAudioPlayer);
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playvideo", "fulscreen=false");
                Handler localHandler2 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore13 = MASTAdViewCore.this;
                WebView localWebView = MASTAdViewCore.this.view;
                MASTAdViewCore.SetupOrmmaPlayer localSetupOrmmaPlayer = new MASTAdViewCore.SetupOrmmaPlayer(localMASTAdViewCore13, localWebView, localBundle);
                boolean bool3 = localHandler2.post(localSetupOrmmaPlayer);
                continue;
                String str7 = localBundle.getString("message");
                String str8 = localBundle.getString("action");
                String str9 = "window.ormmaview.fireErrorEvent(\"" + str7 + "\", \"" + str8 + "\")";
                MASTAdViewCore localMASTAdViewCore14 = MASTAdViewCore.this;
                String str10 = "msg=" + str7 + ";action=" + str8;
                localMASTAdViewCore14.ormmaEvent("error", str10);
                MASTAdViewCore.this.injectJavaScript(str9);
              }
            }
          }
        }
      }
    };
    this.handler = local2;
    this.ormaEnabled = false;
    this.bgColor = -1;
    AutoDetectParameters(paramContext);
    initialize(paramContext, paramAttributeSet);
  }

  protected MASTAdViewCore(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ViewState localViewState = ViewState.DEFAULT;
    this.mViewState = localViewState;
    this.mParentAd = null;
    this.mDataToInject = null;
    HashSet localHashSet = new HashSet();
    this.excampaigns = localHashSet;
    this.isInterstitial = false;
    this.isShowPreviousAdOnError = true;
    this.isAutoCollapse = true;
    this.isShowMediaPlayerFrame = false;
    Integer localInteger = Integer.valueOf(300000);
    this.locationMinWaitMillis = localInteger;
    Float localFloat = Float.valueOf(1000.0F);
    this.locationMinMoveMeters = localFloat;
    MASTAdLog localMASTAdLog = new MASTAdLog(this);
    this.adLog = localMASTAdLog;
    this.IsManualUpdate = false;
    this.internalBrowser = false;
    this.isExpanded = false;
    this.parentView = null;
    this.injectionHeaderCode = null;
    WebChromeClient local1 = new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }
    };
    this.mWebChromeClient = local1;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        Bundle localBundle = paramAnonymousMessage.getData();
        switch (paramAnonymousMessage.what)
        {
        case 1005:
        case 1006:
        default:
        case 1000:
        case 1001:
        case 1002:
        case 1003:
        case 1004:
        case 1008:
        case 1007:
        case 1009:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          MASTAdViewCore.ViewState localViewState1 = MASTAdViewCore.this.mViewState;
          MASTAdViewCore.ViewState localViewState2 = MASTAdViewCore.ViewState.DEFAULT;
          if (localViewState1 == localViewState2)
          {
            MASTAdViewCore.this.stopTimer(false);
            int i = MASTAdViewCore.this.lastX;
            int j = MASTAdViewCore.this.lastY;
            MASTAdViewCore localMASTAdViewCore1 = MASTAdViewCore.this;
            MASTAdViewCore.ViewState localViewState3 = MASTAdViewCore.ViewState.RESIZED;
            localMASTAdViewCore1.mViewState = localViewState3;
            ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParams();
            MASTAdViewCore localMASTAdViewCore2 = MASTAdViewCore.this;
            int k = localLayoutParams1.height;
            localMASTAdViewCore2.mOldHeight = k;
            MASTAdViewCore localMASTAdViewCore3 = MASTAdViewCore.this;
            int m = localLayoutParams1.width;
            localMASTAdViewCore3.mOldWidth = m;
            MASTAdViewCore localMASTAdViewCore4 = MASTAdViewCore.this;
            StringBuilder localStringBuilder1 = new StringBuilder("mOldWidth=");
            String str1 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(";OldHeight=");
            String str2 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(";width=");
            String str3 = String.valueOf(localLayoutParams1.width);
            StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(";height=");
            String str4 = String.valueOf(localLayoutParams1.height);
            String str5 = str4;
            localMASTAdViewCore4.ormmaEvent("resize", str5);
            int n = localLayoutParams1.height;
            int i1 = localBundle.getInt("resize_height", n);
            localLayoutParams1.height = i1;
            int i2 = localLayoutParams1.width;
            int i3 = localBundle.getInt("resize_width", i2);
            localLayoutParams1.width = i3;
            MASTAdViewCore.this.requestLayout();
            MASTAdViewCore.this.lastX = i;
            MASTAdViewCore.this.lastY = j;
          }
          else
          {
            MASTAdViewCore.this.ormmaEvent("error", "Error: resize: Cannot resize an ad that is not in the default state.");
            continue;
            boolean bool1 = MASTAdViewCore.this.closeView(false);
            continue;
            MASTAdViewCore.ViewState localViewState4 = MASTAdViewCore.this.mViewState;
            MASTAdViewCore.ViewState localViewState5 = MASTAdViewCore.ViewState.DEFAULT;
            if (localViewState4 == localViewState5)
            {
              MASTAdViewCore.this.ormmaEvent("hide", "");
              MASTAdViewCore.this.setVisibility(4);
            }
            else
            {
              MASTAdViewCore.this.ormmaEvent("error", "Error: hide: Cannot hide an ad that is not in the default state.");
              continue;
              MASTAdViewCore.this.ormmaEvent("show", "");
              MASTAdViewCore.this.setVisibility(0);
              continue;
              MASTAdViewCore.ViewState localViewState6 = MASTAdViewCore.this.mViewState;
              MASTAdViewCore.ViewState localViewState7 = MASTAdViewCore.ViewState.DEFAULT;
              if (localViewState6 == localViewState7)
              {
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.hideVirtualKeyboard();
                ViewGroup.LayoutParams localLayoutParams2 = MASTAdViewCore.this.getLayoutParams();
                MASTAdViewCore localMASTAdViewCore5 = MASTAdViewCore.this;
                int i4 = localLayoutParams2.height;
                localMASTAdViewCore5.mOldHeight = i4;
                MASTAdViewCore localMASTAdViewCore6 = MASTAdViewCore.this;
                int i5 = localLayoutParams2.width;
                localMASTAdViewCore6.mOldWidth = i5;
                MASTAdViewCore localMASTAdViewCore7 = MASTAdViewCore.this;
                Drawable localDrawable = MASTAdViewCore.this.getBackground();
                localMASTAdViewCore7.mOldExpandBackground = localDrawable;
                MASTAdViewCore localMASTAdViewCore8 = MASTAdViewCore.this;
                int i6 = MASTAdViewCore.this.getBackgroundColor();
                localMASTAdViewCore8.mOldExpandBackgroundColor = i6;
                if (MASTAdViewCore.this.mOldHeight == -1)
                {
                  MASTAdViewCore localMASTAdViewCore9 = MASTAdViewCore.this;
                  int i7 = MASTAdViewCore.this.getHeight();
                  localMASTAdViewCore9.mOldHeight = i7;
                }
                MASTAdViewCore.this.ormmaEvent("expand", "");
                MASTAdViewCore localMASTAdViewCore10 = MASTAdViewCore.this;
                MASTAdViewCore.ViewState localViewState8 = MASTAdViewCore.ViewState.EXPANDED;
                localMASTAdViewCore10.mViewState = localViewState8;
                MASTAdViewCore localMASTAdViewCore11 = MASTAdViewCore.this;
                OrmmaController.Dimensions localDimensions = (OrmmaController.Dimensions)localBundle.getParcelable("expand_initial_dimensions");
                String str6 = localBundle.getString("expand_url");
                OrmmaController.Properties localProperties = (OrmmaController.Properties)localBundle.getParcelable("expand_properties");
                localMASTAdViewCore11.expandInUIThread(localDimensions, str6, localProperties);
              }
              else
              {
                MASTAdViewCore.this.ormmaEvent("error", "Error: expand: Cannot expand an ad that is not in the default state.");
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playaudio", "");
                Handler localHandler1 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore12 = MASTAdViewCore.this;
                MASTAdViewCore.SetupOrmmaAudioPlayer localSetupOrmmaAudioPlayer = new MASTAdViewCore.SetupOrmmaAudioPlayer(localMASTAdViewCore12, localBundle);
                boolean bool2 = localHandler1.post(localSetupOrmmaAudioPlayer);
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playvideo", "fulscreen=false");
                Handler localHandler2 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore13 = MASTAdViewCore.this;
                WebView localWebView = MASTAdViewCore.this.view;
                MASTAdViewCore.SetupOrmmaPlayer localSetupOrmmaPlayer = new MASTAdViewCore.SetupOrmmaPlayer(localMASTAdViewCore13, localWebView, localBundle);
                boolean bool3 = localHandler2.post(localSetupOrmmaPlayer);
                continue;
                String str7 = localBundle.getString("message");
                String str8 = localBundle.getString("action");
                String str9 = "window.ormmaview.fireErrorEvent(\"" + str7 + "\", \"" + str8 + "\")";
                MASTAdViewCore localMASTAdViewCore14 = MASTAdViewCore.this;
                String str10 = "msg=" + str7 + ";action=" + str8;
                localMASTAdViewCore14.ormmaEvent("error", str10);
                MASTAdViewCore.this.injectJavaScript(str9);
              }
            }
          }
        }
      }
    };
    this.handler = local2;
    this.ormaEnabled = false;
    this.bgColor = -1;
    AutoDetectParameters(paramContext);
    initialize(paramContext, paramAttributeSet);
  }

  public MASTAdViewCore(Context paramContext, Integer paramInteger1, Integer paramInteger2)
  {
    super(paramContext);
    ViewState localViewState = ViewState.DEFAULT;
    this.mViewState = localViewState;
    this.mParentAd = null;
    this.mDataToInject = null;
    HashSet localHashSet = new HashSet();
    this.excampaigns = localHashSet;
    this.isInterstitial = false;
    this.isShowPreviousAdOnError = true;
    this.isAutoCollapse = true;
    this.isShowMediaPlayerFrame = false;
    Integer localInteger1 = Integer.valueOf(300000);
    this.locationMinWaitMillis = localInteger1;
    Float localFloat = Float.valueOf(1000.0F);
    this.locationMinMoveMeters = localFloat;
    MASTAdViewCore localMASTAdViewCore1 = this;
    MASTAdLog localMASTAdLog = new MASTAdLog(localMASTAdViewCore1);
    this.adLog = localMASTAdLog;
    this.IsManualUpdate = false;
    this.internalBrowser = false;
    this.isExpanded = false;
    this.parentView = null;
    this.injectionHeaderCode = null;
    MASTAdViewCore localMASTAdViewCore2 = this;
    WebChromeClient local1 = new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }
    };
    this.mWebChromeClient = local1;
    MASTAdViewCore localMASTAdViewCore3 = this;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        Bundle localBundle = paramAnonymousMessage.getData();
        switch (paramAnonymousMessage.what)
        {
        case 1005:
        case 1006:
        default:
        case 1000:
        case 1001:
        case 1002:
        case 1003:
        case 1004:
        case 1008:
        case 1007:
        case 1009:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          MASTAdViewCore.ViewState localViewState1 = MASTAdViewCore.this.mViewState;
          MASTAdViewCore.ViewState localViewState2 = MASTAdViewCore.ViewState.DEFAULT;
          if (localViewState1 == localViewState2)
          {
            MASTAdViewCore.this.stopTimer(false);
            int i = MASTAdViewCore.this.lastX;
            int j = MASTAdViewCore.this.lastY;
            MASTAdViewCore localMASTAdViewCore1 = MASTAdViewCore.this;
            MASTAdViewCore.ViewState localViewState3 = MASTAdViewCore.ViewState.RESIZED;
            localMASTAdViewCore1.mViewState = localViewState3;
            ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParams();
            MASTAdViewCore localMASTAdViewCore2 = MASTAdViewCore.this;
            int k = localLayoutParams1.height;
            localMASTAdViewCore2.mOldHeight = k;
            MASTAdViewCore localMASTAdViewCore3 = MASTAdViewCore.this;
            int m = localLayoutParams1.width;
            localMASTAdViewCore3.mOldWidth = m;
            MASTAdViewCore localMASTAdViewCore4 = MASTAdViewCore.this;
            StringBuilder localStringBuilder1 = new StringBuilder("mOldWidth=");
            String str1 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(";OldHeight=");
            String str2 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(";width=");
            String str3 = String.valueOf(localLayoutParams1.width);
            StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(";height=");
            String str4 = String.valueOf(localLayoutParams1.height);
            String str5 = str4;
            localMASTAdViewCore4.ormmaEvent("resize", str5);
            int n = localLayoutParams1.height;
            int i1 = localBundle.getInt("resize_height", n);
            localLayoutParams1.height = i1;
            int i2 = localLayoutParams1.width;
            int i3 = localBundle.getInt("resize_width", i2);
            localLayoutParams1.width = i3;
            MASTAdViewCore.this.requestLayout();
            MASTAdViewCore.this.lastX = i;
            MASTAdViewCore.this.lastY = j;
          }
          else
          {
            MASTAdViewCore.this.ormmaEvent("error", "Error: resize: Cannot resize an ad that is not in the default state.");
            continue;
            boolean bool1 = MASTAdViewCore.this.closeView(false);
            continue;
            MASTAdViewCore.ViewState localViewState4 = MASTAdViewCore.this.mViewState;
            MASTAdViewCore.ViewState localViewState5 = MASTAdViewCore.ViewState.DEFAULT;
            if (localViewState4 == localViewState5)
            {
              MASTAdViewCore.this.ormmaEvent("hide", "");
              MASTAdViewCore.this.setVisibility(4);
            }
            else
            {
              MASTAdViewCore.this.ormmaEvent("error", "Error: hide: Cannot hide an ad that is not in the default state.");
              continue;
              MASTAdViewCore.this.ormmaEvent("show", "");
              MASTAdViewCore.this.setVisibility(0);
              continue;
              MASTAdViewCore.ViewState localViewState6 = MASTAdViewCore.this.mViewState;
              MASTAdViewCore.ViewState localViewState7 = MASTAdViewCore.ViewState.DEFAULT;
              if (localViewState6 == localViewState7)
              {
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.hideVirtualKeyboard();
                ViewGroup.LayoutParams localLayoutParams2 = MASTAdViewCore.this.getLayoutParams();
                MASTAdViewCore localMASTAdViewCore5 = MASTAdViewCore.this;
                int i4 = localLayoutParams2.height;
                localMASTAdViewCore5.mOldHeight = i4;
                MASTAdViewCore localMASTAdViewCore6 = MASTAdViewCore.this;
                int i5 = localLayoutParams2.width;
                localMASTAdViewCore6.mOldWidth = i5;
                MASTAdViewCore localMASTAdViewCore7 = MASTAdViewCore.this;
                Drawable localDrawable = MASTAdViewCore.this.getBackground();
                localMASTAdViewCore7.mOldExpandBackground = localDrawable;
                MASTAdViewCore localMASTAdViewCore8 = MASTAdViewCore.this;
                int i6 = MASTAdViewCore.this.getBackgroundColor();
                localMASTAdViewCore8.mOldExpandBackgroundColor = i6;
                if (MASTAdViewCore.this.mOldHeight == -1)
                {
                  MASTAdViewCore localMASTAdViewCore9 = MASTAdViewCore.this;
                  int i7 = MASTAdViewCore.this.getHeight();
                  localMASTAdViewCore9.mOldHeight = i7;
                }
                MASTAdViewCore.this.ormmaEvent("expand", "");
                MASTAdViewCore localMASTAdViewCore10 = MASTAdViewCore.this;
                MASTAdViewCore.ViewState localViewState8 = MASTAdViewCore.ViewState.EXPANDED;
                localMASTAdViewCore10.mViewState = localViewState8;
                MASTAdViewCore localMASTAdViewCore11 = MASTAdViewCore.this;
                OrmmaController.Dimensions localDimensions = (OrmmaController.Dimensions)localBundle.getParcelable("expand_initial_dimensions");
                String str6 = localBundle.getString("expand_url");
                OrmmaController.Properties localProperties = (OrmmaController.Properties)localBundle.getParcelable("expand_properties");
                localMASTAdViewCore11.expandInUIThread(localDimensions, str6, localProperties);
              }
              else
              {
                MASTAdViewCore.this.ormmaEvent("error", "Error: expand: Cannot expand an ad that is not in the default state.");
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playaudio", "");
                Handler localHandler1 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore12 = MASTAdViewCore.this;
                MASTAdViewCore.SetupOrmmaAudioPlayer localSetupOrmmaAudioPlayer = new MASTAdViewCore.SetupOrmmaAudioPlayer(localMASTAdViewCore12, localBundle);
                boolean bool2 = localHandler1.post(localSetupOrmmaAudioPlayer);
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playvideo", "fulscreen=false");
                Handler localHandler2 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore13 = MASTAdViewCore.this;
                WebView localWebView = MASTAdViewCore.this.view;
                MASTAdViewCore.SetupOrmmaPlayer localSetupOrmmaPlayer = new MASTAdViewCore.SetupOrmmaPlayer(localMASTAdViewCore13, localWebView, localBundle);
                boolean bool3 = localHandler2.post(localSetupOrmmaPlayer);
                continue;
                String str7 = localBundle.getString("message");
                String str8 = localBundle.getString("action");
                String str9 = "window.ormmaview.fireErrorEvent(\"" + str7 + "\", \"" + str8 + "\")";
                MASTAdViewCore localMASTAdViewCore14 = MASTAdViewCore.this;
                String str10 = "msg=" + str7 + ";action=" + str8;
                localMASTAdViewCore14.ormmaEvent("error", str10);
                MASTAdViewCore.this.injectJavaScript(str9);
              }
            }
          }
        }
      }
    };
    this.handler = local2;
    this.ormaEnabled = false;
    this.bgColor = -1;
    AutoDetectParameters(paramContext);
    MASTAdViewCore localMASTAdViewCore4 = this;
    Context localContext = paramContext;
    Integer localInteger2 = paramInteger1;
    Integer localInteger3 = paramInteger2;
    localMASTAdViewCore4.loadContent(localContext, null, null, null, null, null, localInteger2, localInteger3, null, null, null, null, null, null, null, null, null, null, null, null);
  }

  protected MASTAdViewCore(Context paramContext, boolean paramBoolean, MASTAdViewCore paramMASTAdViewCore)
  {
    super(paramContext);
    ViewState localViewState1 = ViewState.DEFAULT;
    this.mViewState = localViewState1;
    this.mParentAd = null;
    this.mDataToInject = null;
    HashSet localHashSet = new HashSet();
    this.excampaigns = localHashSet;
    this.isInterstitial = false;
    this.isShowPreviousAdOnError = true;
    this.isAutoCollapse = true;
    this.isShowMediaPlayerFrame = false;
    Integer localInteger = Integer.valueOf(300000);
    this.locationMinWaitMillis = localInteger;
    Float localFloat = Float.valueOf(1000.0F);
    this.locationMinMoveMeters = localFloat;
    MASTAdLog localMASTAdLog = new MASTAdLog(this);
    this.adLog = localMASTAdLog;
    this.IsManualUpdate = false;
    this.internalBrowser = false;
    this.isExpanded = false;
    this.parentView = null;
    this.injectionHeaderCode = null;
    WebChromeClient local1 = new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }
    };
    this.mWebChromeClient = local1;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        Bundle localBundle = paramAnonymousMessage.getData();
        switch (paramAnonymousMessage.what)
        {
        case 1005:
        case 1006:
        default:
        case 1000:
        case 1001:
        case 1002:
        case 1003:
        case 1004:
        case 1008:
        case 1007:
        case 1009:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          MASTAdViewCore.ViewState localViewState1 = MASTAdViewCore.this.mViewState;
          MASTAdViewCore.ViewState localViewState2 = MASTAdViewCore.ViewState.DEFAULT;
          if (localViewState1 == localViewState2)
          {
            MASTAdViewCore.this.stopTimer(false);
            int i = MASTAdViewCore.this.lastX;
            int j = MASTAdViewCore.this.lastY;
            MASTAdViewCore localMASTAdViewCore1 = MASTAdViewCore.this;
            MASTAdViewCore.ViewState localViewState3 = MASTAdViewCore.ViewState.RESIZED;
            localMASTAdViewCore1.mViewState = localViewState3;
            ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParams();
            MASTAdViewCore localMASTAdViewCore2 = MASTAdViewCore.this;
            int k = localLayoutParams1.height;
            localMASTAdViewCore2.mOldHeight = k;
            MASTAdViewCore localMASTAdViewCore3 = MASTAdViewCore.this;
            int m = localLayoutParams1.width;
            localMASTAdViewCore3.mOldWidth = m;
            MASTAdViewCore localMASTAdViewCore4 = MASTAdViewCore.this;
            StringBuilder localStringBuilder1 = new StringBuilder("mOldWidth=");
            String str1 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(";OldHeight=");
            String str2 = String.valueOf(MASTAdViewCore.this.mOldWidth);
            StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(";width=");
            String str3 = String.valueOf(localLayoutParams1.width);
            StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(";height=");
            String str4 = String.valueOf(localLayoutParams1.height);
            String str5 = str4;
            localMASTAdViewCore4.ormmaEvent("resize", str5);
            int n = localLayoutParams1.height;
            int i1 = localBundle.getInt("resize_height", n);
            localLayoutParams1.height = i1;
            int i2 = localLayoutParams1.width;
            int i3 = localBundle.getInt("resize_width", i2);
            localLayoutParams1.width = i3;
            MASTAdViewCore.this.requestLayout();
            MASTAdViewCore.this.lastX = i;
            MASTAdViewCore.this.lastY = j;
          }
          else
          {
            MASTAdViewCore.this.ormmaEvent("error", "Error: resize: Cannot resize an ad that is not in the default state.");
            continue;
            boolean bool1 = MASTAdViewCore.this.closeView(false);
            continue;
            MASTAdViewCore.ViewState localViewState4 = MASTAdViewCore.this.mViewState;
            MASTAdViewCore.ViewState localViewState5 = MASTAdViewCore.ViewState.DEFAULT;
            if (localViewState4 == localViewState5)
            {
              MASTAdViewCore.this.ormmaEvent("hide", "");
              MASTAdViewCore.this.setVisibility(4);
            }
            else
            {
              MASTAdViewCore.this.ormmaEvent("error", "Error: hide: Cannot hide an ad that is not in the default state.");
              continue;
              MASTAdViewCore.this.ormmaEvent("show", "");
              MASTAdViewCore.this.setVisibility(0);
              continue;
              MASTAdViewCore.ViewState localViewState6 = MASTAdViewCore.this.mViewState;
              MASTAdViewCore.ViewState localViewState7 = MASTAdViewCore.ViewState.DEFAULT;
              if (localViewState6 == localViewState7)
              {
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.hideVirtualKeyboard();
                ViewGroup.LayoutParams localLayoutParams2 = MASTAdViewCore.this.getLayoutParams();
                MASTAdViewCore localMASTAdViewCore5 = MASTAdViewCore.this;
                int i4 = localLayoutParams2.height;
                localMASTAdViewCore5.mOldHeight = i4;
                MASTAdViewCore localMASTAdViewCore6 = MASTAdViewCore.this;
                int i5 = localLayoutParams2.width;
                localMASTAdViewCore6.mOldWidth = i5;
                MASTAdViewCore localMASTAdViewCore7 = MASTAdViewCore.this;
                Drawable localDrawable = MASTAdViewCore.this.getBackground();
                localMASTAdViewCore7.mOldExpandBackground = localDrawable;
                MASTAdViewCore localMASTAdViewCore8 = MASTAdViewCore.this;
                int i6 = MASTAdViewCore.this.getBackgroundColor();
                localMASTAdViewCore8.mOldExpandBackgroundColor = i6;
                if (MASTAdViewCore.this.mOldHeight == -1)
                {
                  MASTAdViewCore localMASTAdViewCore9 = MASTAdViewCore.this;
                  int i7 = MASTAdViewCore.this.getHeight();
                  localMASTAdViewCore9.mOldHeight = i7;
                }
                MASTAdViewCore.this.ormmaEvent("expand", "");
                MASTAdViewCore localMASTAdViewCore10 = MASTAdViewCore.this;
                MASTAdViewCore.ViewState localViewState8 = MASTAdViewCore.ViewState.EXPANDED;
                localMASTAdViewCore10.mViewState = localViewState8;
                MASTAdViewCore localMASTAdViewCore11 = MASTAdViewCore.this;
                OrmmaController.Dimensions localDimensions = (OrmmaController.Dimensions)localBundle.getParcelable("expand_initial_dimensions");
                String str6 = localBundle.getString("expand_url");
                OrmmaController.Properties localProperties = (OrmmaController.Properties)localBundle.getParcelable("expand_properties");
                localMASTAdViewCore11.expandInUIThread(localDimensions, str6, localProperties);
              }
              else
              {
                MASTAdViewCore.this.ormmaEvent("error", "Error: expand: Cannot expand an ad that is not in the default state.");
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playaudio", "");
                Handler localHandler1 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore12 = MASTAdViewCore.this;
                MASTAdViewCore.SetupOrmmaAudioPlayer localSetupOrmmaAudioPlayer = new MASTAdViewCore.SetupOrmmaAudioPlayer(localMASTAdViewCore12, localBundle);
                boolean bool2 = localHandler1.post(localSetupOrmmaAudioPlayer);
                continue;
                MASTAdViewCore.this.stopTimer(false);
                MASTAdViewCore.this.ormmaEvent("playvideo", "fulscreen=false");
                Handler localHandler2 = MASTAdViewCore.this.handler;
                MASTAdViewCore localMASTAdViewCore13 = MASTAdViewCore.this;
                WebView localWebView = MASTAdViewCore.this.view;
                MASTAdViewCore.SetupOrmmaPlayer localSetupOrmmaPlayer = new MASTAdViewCore.SetupOrmmaPlayer(localMASTAdViewCore13, localWebView, localBundle);
                boolean bool3 = localHandler2.post(localSetupOrmmaPlayer);
                continue;
                String str7 = localBundle.getString("message");
                String str8 = localBundle.getString("action");
                String str9 = "window.ormmaview.fireErrorEvent(\"" + str7 + "\", \"" + str8 + "\")";
                MASTAdViewCore localMASTAdViewCore14 = MASTAdViewCore.this;
                String str10 = "msg=" + str7 + ";action=" + str8;
                localMASTAdViewCore14.ormmaEvent("error", str10);
                MASTAdViewCore.this.injectJavaScript(str9);
              }
            }
          }
        }
      }
    };
    this.handler = local2;
    this.ormaEnabled = false;
    this.bgColor = -1;
    this.isExpanded = paramBoolean;
    this.expandParent = paramMASTAdViewCore;
    AutoDetectParameters(paramContext);
    initialize(paramContext, null);
    ViewState localViewState2 = ViewState.EXPANDED;
    this.mViewState = localViewState2;
  }

  private Integer GetColor(String paramString)
  {
    Integer localInteger;
    if (paramString == null)
      localInteger = null;
    while (true)
    {
      return localInteger;
      int i = paramString.length();
      if ((i > 0) && (paramString.charAt(0) == '#'));
      int j;
      int k;
      int m;
      StringBuilder localStringBuilder3;
      String str3;
      switch (i)
      {
      case 6:
      case 8:
      default:
        localInteger = Integer.valueOf(-1);
        break;
      case 4:
        j = 255;
        StringBuilder localStringBuilder1 = new StringBuilder("#");
        String str1 = paramString.substring(1, 2);
        k = Integer.decode(str1).intValue() * 17;
        StringBuilder localStringBuilder2 = new StringBuilder("#");
        String str2 = paramString.substring(2, 3);
        m = Integer.decode(str2).intValue() * 17;
        localStringBuilder3 = new StringBuilder("#");
        str3 = paramString.substring(3, 4);
      case 5:
        StringBuilder localStringBuilder7;
        String str7;
        for (int n = Integer.decode(str3).intValue() * 17; ; n = Integer.decode(str7).intValue() * 17)
        {
          localInteger = Integer.valueOf(Color.argb(j, k, m, n));
          break;
          StringBuilder localStringBuilder4 = new StringBuilder("#");
          String str4 = paramString.substring(1, 2);
          j = Integer.decode(str4).intValue() * 17;
          StringBuilder localStringBuilder5 = new StringBuilder("#");
          String str5 = paramString.substring(2, 3);
          k = Integer.decode(str5).intValue() * 17;
          StringBuilder localStringBuilder6 = new StringBuilder("#");
          String str6 = paramString.substring(3, 4);
          m = Integer.decode(str6).intValue() * 17;
          localStringBuilder7 = new StringBuilder("#");
          str7 = paramString.substring(4, 5);
        }
      case 7:
      case 9:
        localInteger = Integer.valueOf(Color.parseColor(paramString));
        continue;
        localInteger = Integer.valueOf(-1);
      }
    }
  }

  private void RestartExcampaings(String paramString, Context paramContext, WebView paramWebView)
  {
    this.adLog.log(2, 2, "RestartExcampaings", paramString);
    if (this.excampaigns.contains(paramString))
    {
      StartTimer(paramContext, paramWebView);
      return;
    }
    boolean bool = this.excampaigns.add(paramString);
    update(false);
  }

  private void StartLoadContent(Context paramContext, WebView paramWebView)
  {
    if (this.reloadTask != null)
    {
      boolean bool1 = this.reloadTask.cancel();
      this.reloadTask = null;
    }
    if (ContentManager.getInstance(this).getAutoDetectParameters().equals(""))
    {
      this.IsManualUpdate = true;
      StartTimer(paramContext, paramWebView);
      return;
    }
    setScrollBarStyle(0);
    this.adLog.log(3, 3, "StartLoadContent", "");
    if ((!paramWebView.isShown()) && (!this.IsManualUpdate));
    for (int i = 0; ; i = 1)
    {
      this.IsManualUpdate = false;
      if ((getSite().intValue() != 0) && (getZone().intValue() != 0))
        break;
      StartTimer(paramContext, paramWebView);
      this.adLog.log(3, 2, "StartLoadContent", "site=0 or zone=0");
      return;
    }
    if (this.visibleMode == null)
    {
      Integer localInteger1 = Integer.valueOf(2);
      this.visibleMode = localInteger1;
    }
    int j;
    switch (this.visibleMode.intValue())
    {
    default:
      j = 1;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if ((this.defaultImageResource != null) && (getBackground() == null));
      try
      {
        Handler localHandler = this.handler;
        Integer localInteger2 = this.defaultImageResource;
        WebView localWebView1 = paramWebView;
        SetBackgroundResourceAction localSetBackgroundResourceAction = new SetBackgroundResourceAction(localWebView1, localInteger2);
        boolean bool2 = localHandler.post(localSetBackgroundResourceAction);
        WebView localWebView2 = paramWebView;
        InterceptOnAdDownload localInterceptOnAdDownload = new InterceptOnAdDownload(paramContext, localWebView2);
        if (j == 0)
          return;
        try
        {
          ViewState localViewState1 = this.mViewState;
          ViewState localViewState2 = ViewState.EXPANDED;
          if (localViewState1 == localViewState2)
            return;
          if (this.adserverRequest == null)
            return;
          ViewState localViewState3 = this.mViewState;
          ViewState localViewState4 = ViewState.RESIZED;
          if (localViewState3 == localViewState4)
          {
            ViewState localViewState5 = ViewState.DEFAULT;
            this.mViewState = localViewState5;
          }
          MASTAdView localMASTAdView1 = (MASTAdView)this;
          localInterceptOnAdDownload.begin(localMASTAdView1);
          AdserverRequest localAdserverRequest1 = this.adserverRequest;
          String str1 = getExcampaignsString();
          AdserverRequest localAdserverRequest2 = localAdserverRequest1.setExcampaigns(str1);
          String str2 = this.adserverRequest.createURL();
          this.lastRequest = str2;
          RequestCounter += 1;
          MASTAdLog localMASTAdLog1 = this.adLog;
          StringBuilder localStringBuilder = new StringBuilder("requestGet[");
          String str3 = String.valueOf(RequestCounter);
          String str4 = str3 + "]";
          localMASTAdLog1.log(3, 3, str4, str2);
          ContentManager localContentManager = ContentManager.getInstance(this);
          String str5 = this.adserverRequest.createURL();
          localContentManager.startLoadContent(this, str5);
          return;
        }
        catch (Exception localException1)
        {
          MASTAdLog localMASTAdLog2 = this.adLog;
          String str6 = localException1.getMessage();
          localMASTAdLog2.log(1, 1, "StartLoadContent.requestGet", str6);
          MASTAdView localMASTAdView2 = (MASTAdView)this;
          String str7 = localException1.getMessage();
          localInterceptOnAdDownload.error(localMASTAdView2, str7);
          return;
        }
        j = 1;
        continue;
        j = i;
        int k = i;
        continue;
        j = 1;
        int m = i;
      }
      catch (Exception localException2)
      {
        while (true)
        {
          MASTAdLog localMASTAdLog3 = this.adLog;
          String str8 = localException2.getMessage();
          localMASTAdLog3.log(1, 1, "StartLoadContent", str8);
        }
      }
    }
  }

  private void StartTimer(Context paramContext, WebView paramWebView)
  {
    ReloadTask localReloadTask;
    try
    {
      if (this.reloadTimer == null)
        return;
      if (this.reloadTask != null)
      {
        boolean bool = this.reloadTask.cancel();
        this.reloadTask = null;
      }
      localReloadTask = new ReloadTask(paramContext, paramWebView);
      if (!this.IsManualUpdate)
        break label177;
      if (ContentManager.getInstance(this).getAutoDetectParameters().equals(""))
      {
        MASTAdLog localMASTAdLog1 = this.adLog;
        String str1 = String.valueOf(1);
        localMASTAdLog1.log(3, 3, "AutoDetectParameters, StartTimer", str1);
        this.reloadTimer.schedule(localReloadTask, 1000L);
        this.reloadTask = localReloadTask;
        return;
      }
    }
    catch (Exception localException)
    {
      MASTAdLog localMASTAdLog2 = this.adLog;
      String str2 = localException.getMessage();
      localMASTAdLog2.log(3, 1, "StartTimer", str2);
      return;
    }
    MASTAdLog localMASTAdLog3 = this.adLog;
    String str3 = String.valueOf(0);
    localMASTAdLog3.log(3, 3, "Manual Update, StartTimer", str3);
    this.reloadTimer.schedule(localReloadTask, 100L);
    this.reloadTask = localReloadTask;
    return;
    label177: if ((this.adReloadPeriod != null) && (this.adReloadPeriod.longValue() >= 0L))
      if (this.adReloadPeriod.longValue() > 0L)
      {
        MASTAdLog localMASTAdLog4 = this.adLog;
        String str4 = String.valueOf(this.adReloadPeriod.longValue() / 1000L);
        localMASTAdLog4.log(3, 3, "StartTimer", str4);
        Timer localTimer = this.reloadTimer;
        long l = this.adReloadPeriod.longValue();
        localTimer.schedule(localReloadTask, l);
      }
    while (true)
    {
      this.reloadTask = localReloadTask;
      return;
      this.adLog.log(3, 3, "StartTimer", "stopped");
      continue;
      this.reloadTimer.schedule(localReloadTask, 120000L);
      MASTAdLog localMASTAdLog5 = this.adLog;
      String str5 = String.valueOf(String.valueOf(120));
      String str6 = str5 + " default";
      localMASTAdLog5.log(3, 3, "StartTimer", str6);
    }
  }

  private void _openUrlInExternalBrowser(final Context paramContext, final String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = paramString;
    while (true)
    {
      if (((String)localObject2).equals(localObject1))
      {
        if (localObject2 == null)
          localObject2 = paramString;
        Uri localUri1 = Uri.parse((String)localObject2);
        if ((!this.internalBrowser) || ((!localUri1.getScheme().equals("http")) && (!localUri1.getScheme().equals("https"))))
          break;
        Handler localHandler = this.handler;
        Runnable local10 = new Runnable()
        {
          public void run()
          {
            try
            {
              Context localContext = paramContext;
              String str1 = paramString;
              new InternelBrowser(localContext, str1).show();
              return;
            }
            catch (Exception localException)
            {
              MASTAdLog localMASTAdLog = MASTAdViewCore.this.adLog;
              String str2 = localException.getMessage();
              localMASTAdLog.log(1, 1, "openUrlInInternalBrowser", str2);
            }
          }
        };
        boolean bool = localHandler.post(local10);
        return;
      }
      localObject1 = localObject2;
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL((String)localObject2).openConnection();
        localObject2 = localHttpURLConnection.getHeaderField("Location");
        if (localObject2 == null)
        {
          String str1 = localHttpURLConnection.getURL().toString();
          localObject2 = str1;
        }
      }
      catch (Exception localException1)
      {
        localObject2 = localObject1;
      }
    }
    try
    {
      Uri localUri2 = Uri.parse((String)localObject2);
      Intent localIntent = new Intent("android.intent.action.VIEW", localUri2);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException2)
    {
      MASTAdLog localMASTAdLog = this.adLog;
      StringBuilder localStringBuilder = new StringBuilder("url=").append((String)localObject2).append("; error=");
      String str2 = localException2.getMessage();
      String str3 = str2;
      localMASTAdLog.log(1, 1, "openUrlInExternalBrowser", str3);
    }
  }

  private void closeRunnable(final MASTAdViewCore paramMASTAdViewCore)
  {
    Handler localHandler = paramMASTAdViewCore.handler;
    Runnable local5 = new Runnable()
    {
      public void run()
      {
        boolean bool = MASTAdViewCore.this.closeView(false);
        MASTAdViewCore localMASTAdViewCore = MASTAdViewCore.this;
        MASTAdViewCore.ViewState localViewState = MASTAdViewCore.this.mViewState;
        localMASTAdViewCore.onStateChange(localViewState);
        paramMASTAdViewCore.injectJavaScript("ormma.close(); ormma.show();");
      }
    };
    boolean bool = localHandler.post(local5);
  }

  private boolean closeView(boolean paramBoolean)
  {
    boolean bool = true;
    this.buttonClose.setVisibility(4);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    int[] arrayOfInt = $SWITCH_TABLE$com$MASTAdView$MASTAdViewCore$ViewState();
    int i = this.mViewState.ordinal();
    switch (arrayOfInt[i])
    {
    default:
      bool = false;
    case 2:
      while (true)
      {
        return bool;
        ormmaEvent("close", "viewState=resized");
        int j = this.mOldHeight;
        localLayoutParams.height = j;
        int k = this.mOldWidth;
        localLayoutParams.width = k;
        requestLayout();
        ViewState localViewState1 = ViewState.DEFAULT;
        this.mViewState = localViewState1;
        Context localContext1 = getContext();
        WebView localWebView1 = this.view;
        StartTimer(localContext1, localWebView1);
      }
    case 3:
    }
    if (paramBoolean)
    {
      if (this.expandParent == null)
        break label344;
      this.expandParent.injectJavaScript("ormma.close();");
    }
    while (true)
    {
      if (this.parentView != null)
      {
        mExpandedFrame.removeAllViews();
        WebView localWebView2 = this.view;
        int m = this.mOldExpandBackgroundColor;
        localWebView2.setBackgroundColor(m);
        WebView localWebView3 = this.view;
        Drawable localDrawable = this.mOldExpandBackground;
        localWebView3.setBackgroundDrawable(localDrawable);
        ViewGroup localViewGroup1 = this.parentView;
        WebView localWebView4 = this.view;
        int n = this.mOldWidth;
        int i1 = this.mOldHeight;
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(n, i1);
        localViewGroup1.addView(localWebView4, localLayoutParams1);
        this.parentView = null;
      }
      if (mExpandedFrame != null)
      {
        ormmaEvent("close", "viewState=expanded");
        ViewGroup localViewGroup2 = mExpandedFrame;
        closeExpanded(localViewGroup2);
        ViewState localViewState2 = ViewState.DEFAULT;
        this.mViewState = localViewState2;
      }
      int i2 = this.mOldHeight;
      localLayoutParams.height = i2;
      int i3 = this.mOldWidth;
      localLayoutParams.width = i3;
      requestLayout();
      Context localContext2 = getContext();
      WebView localWebView5 = this.view;
      StartTimer(localContext2, localWebView5);
      break;
      label344: injectJavaScript("ormma.close();");
    }
  }

  private void expandInUIThread(OrmmaController.Dimensions paramDimensions, String paramString, OrmmaController.Properties paramProperties)
  {
    int i;
    int j;
    label28: RelativeLayout.LayoutParams localLayoutParams;
    WindowManager.LayoutParams localLayoutParams1;
    boolean bool1;
    if (paramDimensions.width == 0)
    {
      i = -1;
      paramDimensions.width = i;
      if (paramDimensions.height != 0)
        break label362;
      j = -1;
      paramDimensions.height = j;
      int k = paramDimensions.width;
      int m = this.metrics.widthPixels;
      if (k < m)
      {
        int n = this.metrics.widthPixels;
        paramDimensions.width = n;
      }
      if (mExpandedFrame != null)
      {
        ViewGroup localViewGroup1 = (ViewGroup)((Activity)getContext()).getWindow().getDecorView();
        ViewGroup localViewGroup2 = mExpandedFrame;
        localViewGroup1.removeView(localViewGroup2);
      }
      Context localContext1 = getContext();
      mExpandedFrame = new RelativeLayout(localContext1);
      int i1 = paramDimensions.width;
      int i2 = paramDimensions.height;
      localLayoutParams = new RelativeLayout.LayoutParams(i1, i2);
      int i3 = ((Activity)getContext()).getWindow().findViewById(16908290).getTop();
      int i4 = paramDimensions.x;
      localLayoutParams.leftMargin = i4;
      int i5 = paramDimensions.y + i3;
      localLayoutParams.topMargin = i5;
      localLayoutParams1 = new android/view/WindowManager$LayoutParams;
      localLayoutParams1.<init>(-1, -1);
      if ((paramString != null) && (!paramString.equals("undefined")))
        break label377;
      ViewGroup localViewGroup3 = (ViewGroup)getParent();
      this.parentView = localViewGroup3;
      ViewGroup localViewGroup4 = this.parentView;
      MASTAdViewCore localMASTAdViewCore1 = this;
      localViewGroup4.removeView(localMASTAdViewCore1);
      MASTAdViewCore localMASTAdViewCore2 = this;
      OrmmaController.Properties localProperties1 = paramProperties;
      MASTAdViewCore localMASTAdViewCore3 = this;
      localMASTAdViewCore2.setExpandBackgroundColor(localProperties1, localMASTAdViewCore3);
      ViewGroup localViewGroup5 = mExpandedFrame;
      MASTAdViewCore localMASTAdViewCore4 = this;
      localViewGroup5.addView(localMASTAdViewCore4, localLayoutParams);
      if (!paramProperties.useCustomClose)
        break label371;
      bool1 = false;
      label304: useCloseButton(bool1);
      boolean bool2 = requestFocus();
    }
    while (true)
    {
      ViewGroup localViewGroup6 = (ViewGroup)((Activity)getContext()).getWindow().getDecorView();
      ViewGroup localViewGroup7 = mExpandedFrame;
      WindowManager.LayoutParams localLayoutParams2 = localLayoutParams1;
      localViewGroup6.addView(localViewGroup7, localLayoutParams2);
      return;
      i = paramDimensions.width;
      break;
      label362: j = paramDimensions.height;
      break label28;
      label371: bool1 = true;
      break label304;
      label377: Context localContext2 = getContext();
      MASTAdViewCore localMASTAdViewCore5 = this;
      MASTAdView localMASTAdView = new MASTAdView(localContext2, true, localMASTAdViewCore5);
      MASTAdViewCore localMASTAdViewCore6 = this;
      OrmmaController.Properties localProperties2 = paramProperties;
      localMASTAdViewCore6.setExpandBackgroundColor(localProperties2, localMASTAdView);
      localMASTAdView.setAutoCollapse(false);
      localMASTAdView.setVisibility(0);
      mExpandedFrame.addView(localMASTAdView, localLayoutParams);
      try
      {
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        String str1 = paramString;
        HttpGet localHttpGet = new HttpGet(str1);
        String str2 = EntityUtils.toString(localDefaultHttpClient.execute(localHttpGet).getEntity(), "UTF-8");
        localMASTAdView.loadDataWithBaseURL(null, str2, "text/html", "UTF-8", null);
        Context localContext3 = this._context;
        Button localButton = new Button(localContext3);
        StateListDrawable localStateListDrawable = InternelBrowser.GetSelector(this._context, "b_close.png", "b_close.png", "b_close.png");
        localButton.setBackgroundDrawable(localStateListDrawable);
        ViewGroup.LayoutParams localLayoutParams3 = new ViewGroup.LayoutParams(30, 30);
        localButton.setLayoutParams(localLayoutParams3);
        MASTAdViewCore localMASTAdViewCore7 = this;
        View.OnClickListener local11 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Handler localHandler = MASTAdViewCore.this.handler;
            Runnable local1 = new Runnable()
            {
              public void run()
              {
                MASTAdViewCore.this.injectJavaScript("ormma.close();");
              }
            };
            boolean bool = localHandler.post(local1);
          }
        };
        localButton.setOnClickListener(local11);
        LinearLayout localLinearLayout1 = new android/widget/LinearLayout;
        Context localContext4 = this._context;
        localLinearLayout1.<init>(localContext4);
        LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout1.setLayoutParams(localLayoutParams4);
        localLinearLayout1.setGravity(5);
        localLinearLayout1.addView(localButton);
        ViewGroup localViewGroup8 = mExpandedFrame;
        LinearLayout localLinearLayout2 = localLinearLayout1;
        localViewGroup8.addView(localLinearLayout2, localLayoutParams);
        boolean bool3 = localMASTAdView.requestFocus();
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          MASTAdLog localMASTAdLog = this.adLog;
          String str3 = localException.getMessage();
          localMASTAdLog.log(1, 1, "expandInUIThread", str3);
        }
      }
    }
  }

  private static Boolean getBooleanParameter(String paramString)
  {
    if (paramString != null);
    for (Boolean localBoolean = Boolean.valueOf(Boolean.parseBoolean(paramString)); ; localBoolean = null)
      return localBoolean;
  }

  private String getExcampaignsString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this.excampaigns.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if (this.excampaigns.size() > 0)
        {
          int i = localStringBuilder1.length() + -1;
          StringBuilder localStringBuilder2 = localStringBuilder1.deleteCharAt(i);
        }
        return localStringBuilder1.toString();
      }
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder3 = localStringBuilder1.append(str);
      StringBuilder localStringBuilder4 = localStringBuilder1.append(",");
    }
  }

  private Float getFloatParameter(String paramString)
  {
    Object localObject = null;
    if (paramString != null);
    try
    {
      Float localFloat = Float.valueOf(Float.parseFloat(paramString));
      localObject = localFloat;
      label16: return localObject;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }

  private Integer getIntParameter(String paramString)
  {
    Object localObject = null;
    if (paramString != null);
    try
    {
      Integer localInteger = Integer.valueOf((int)Long.decode(paramString).longValue());
      localObject = localInteger;
      label20: return localObject;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }

  private ViewGroup.LayoutParams getLayoutParamsByDrawableSize(String paramString)
  {
    int i = -1;
    int j = -1;
    try
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)Utils.GetDrawable(getContext(), paramString);
      if (localBitmapDrawable != null)
      {
        i = localBitmapDrawable.getBitmap().getWidth();
        int k = localBitmapDrawable.getBitmap().getHeight();
        j = k;
      }
      label46: return new ViewGroup.LayoutParams(i, j);
    }
    catch (Exception localException)
    {
      break label46;
    }
  }

  private OrmmaPlayer getPlayer()
  {
    if (player != null)
      player.releasePlayer();
    Context localContext = getContext();
    player = new OrmmaPlayer(localContext);
    return player;
  }

  private void hideVirtualKeyboard()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    IBinder localIBinder = getApplicationWindowToken();
    boolean bool = localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
  }

  private void initialize(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      String str1 = paramAttributeSet.getAttributeValue(null, "logLevel");
      Integer localInteger1 = getIntParameter(str1);
      if (localInteger1 != null)
      {
        int i = localInteger1.intValue();
        setLogLevel(i);
      }
      String str2 = paramAttributeSet.getAttributeValue(null, "site");
      Integer localInteger2 = getIntParameter(str2);
      String str3 = paramAttributeSet.getAttributeValue(null, "zone");
      Integer localInteger3 = getIntParameter(str3);
      Boolean localBoolean1 = getBooleanParameter(paramAttributeSet.getAttributeValue(null, "test"));
      AttributeSet localAttributeSet = paramAttributeSet;
      int j = 2;
      Integer localInteger4 = Integer.valueOf(localAttributeSet.getAttributeIntValue(null, "premium", j));
      String str4 = paramAttributeSet.getAttributeValue(null, "keywords");
      String str5 = paramAttributeSet.getAttributeValue(null, "minSizeX");
      Integer localInteger5 = getIntParameter(str5);
      String str6 = paramAttributeSet.getAttributeValue(null, "minSizeY");
      Integer localInteger6 = getIntParameter(str6);
      String str7 = paramAttributeSet.getAttributeValue(null, "maxSizeX");
      Integer localInteger7 = getIntParameter(str7);
      String str8 = paramAttributeSet.getAttributeValue(null, "maxSizeY");
      Integer localInteger8 = getIntParameter(str8);
      String str9 = paramAttributeSet.getAttributeValue(null, "backgroundColor");
      Integer localInteger9 = GetColor(str9);
      String str10 = paramAttributeSet.getAttributeValue(null, "type");
      Integer localInteger10 = getIntParameter(str10);
      Boolean localBoolean2 = getBooleanParameter(paramAttributeSet.getAttributeValue(null, "locationDetection"));
      String str11 = paramAttributeSet.getAttributeValue(null, "locationMinWaitMillis");
      Integer localInteger11 = getIntParameter(str11);
      this.locationMinWaitMillis = localInteger11;
      String str12 = paramAttributeSet.getAttributeValue(null, "locationMinMoveMeters");
      Float localFloat = getFloatParameter(str12);
      this.locationMinMoveMeters = localFloat;
      Boolean localBoolean3 = getBooleanParameter(paramAttributeSet.getAttributeValue(null, "internalBrowser"));
      String str13 = paramAttributeSet.getAttributeValue(null, "textColor");
      Integer localInteger12 = GetColor(str13);
      String str14 = paramAttributeSet.getAttributeValue(null, "adserverURL");
      String str15 = paramAttributeSet.getAttributeValue(null, "defaultImage");
      Integer localInteger13 = null;
      if (str15 != null)
      {
        Resources localResources = paramContext.getResources();
        String str16 = paramContext.getPackageName();
        String str17 = str15;
        String str18 = str16;
        localInteger13 = Integer.valueOf(localResources.getIdentifier(str17, null, str18));
      }
      String str19 = paramAttributeSet.getAttributeValue(null, "updateTime");
      Integer localInteger14 = getIntParameter(str19);
      setUpdateTime(localInteger14);
      String str20 = paramAttributeSet.getAttributeValue(null, "latitude");
      String str21 = paramAttributeSet.getAttributeValue(null, "longitude");
      String str22 = paramAttributeSet.getAttributeValue(null, "country");
      String str23 = paramAttributeSet.getAttributeValue(null, "region");
      String str24 = paramAttributeSet.getAttributeValue(null, "city");
      String str25 = paramAttributeSet.getAttributeValue(null, "area");
      String str26 = paramAttributeSet.getAttributeValue(null, "dma");
      String str27 = paramAttributeSet.getAttributeValue(null, "zip");
      String str28 = paramAttributeSet.getAttributeValue(null, "carrier");
      String str29 = paramAttributeSet.getAttributeValue(null, "ua");
      String str30 = paramAttributeSet.getAttributeValue(null, "visibleMode");
      Integer localInteger15 = getIntParameter(str30);
      String str31 = paramAttributeSet.getAttributeValue(null, "customParameters");
      Hashtable localHashtable = null;
      String[] arrayOfString;
      int k;
      if (str31 != null)
      {
        localHashtable = new Hashtable();
        arrayOfString = str31.split(",");
        k = 0;
      }
      while (true)
      {
        int m = arrayOfString.length / 2;
        if (k >= m)
        {
          if (localInteger15 != null)
          {
            Integer localInteger16 = localInteger15;
            this.visibleMode = localInteger16;
          }
          if (this.adserverRequest == null)
          {
            MASTAdLog localMASTAdLog = this.adLog;
            Context localContext1 = paramContext;
            AdserverRequest localAdserverRequest = new AdserverRequest(localMASTAdLog, localContext1);
            this.adserverRequest = localAdserverRequest;
          }
          if (str14 != null)
          {
            MASTAdViewCore localMASTAdViewCore1 = this;
            String str32 = str14;
            localMASTAdViewCore1.setAdserverURL(str32);
          }
          if (str24 != null)
          {
            MASTAdViewCore localMASTAdViewCore2 = this;
            String str33 = str24;
            localMASTAdViewCore2.setCity(str33);
          }
          if (str25 != null)
          {
            MASTAdViewCore localMASTAdViewCore3 = this;
            String str34 = str25;
            localMASTAdViewCore3.setArea(str34);
          }
          if (str26 != null)
          {
            MASTAdViewCore localMASTAdViewCore4 = this;
            String str35 = str26;
            localMASTAdViewCore4.setDma(str35);
          }
          if (str27 != null)
          {
            MASTAdViewCore localMASTAdViewCore5 = this;
            String str36 = str27;
            localMASTAdViewCore5.setZip(str36);
          }
          if (localBoolean2 != null)
          {
            boolean bool1 = localBoolean2.booleanValue();
            setLocationDetection(bool1);
          }
          if (localBoolean3 != null)
          {
            boolean bool2 = localBoolean3.booleanValue();
            setInternalBrowser(bool2);
          }
          if (localInteger10 != null)
          {
            MASTAdViewCore localMASTAdViewCore6 = this;
            Integer localInteger17 = localInteger10;
            localMASTAdViewCore6.setType(localInteger17);
          }
          MASTAdViewCore localMASTAdViewCore7 = this;
          Context localContext2 = paramContext;
          localMASTAdViewCore7.loadContent(localContext2, localInteger5, localInteger6, localInteger7, localInteger8, localInteger13, localInteger2, localInteger3, str4, str20, str21, str29, localInteger4, localBoolean1, str22, str23, localInteger9, localInteger12, str28, localHashtable);
          return;
        }
        int n = k * 2;
        String str37 = arrayOfString[n];
        int i1 = k * 2 + 1;
        String str38 = arrayOfString[i1];
        Object localObject = localHashtable.put(str37, str38);
        k += 1;
      }
    }
    MASTAdViewCore localMASTAdViewCore8 = this;
    Context localContext3 = paramContext;
    localMASTAdViewCore8.loadContent(localContext3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
  }

  private boolean isInternetAvailable(Context paramContext)
  {
    boolean bool = false;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
      bool = true;
    return bool;
  }

  private void loadContent(Context paramContext, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger8, Boolean paramBoolean, String paramString5, String paramString6, Integer paramInteger9, Integer paramInteger10, String paramString7, Hashtable<String, String> paramHashtable)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("SDK version = 2.12; DeviceModel = ");
    String str1 = Build.MODEL;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("; DeviceOsVersion = ");
    String str2 = Build.VERSION.RELEASE;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append("; PackageName = ");
    String str3 = paramContext.getPackageName();
    Object localObject = str3;
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      String str4 = paramContext.getPackageName();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str4, 0);
      if (localPackageInfo != null)
      {
        String str5 = String.valueOf(localObject);
        StringBuilder localStringBuilder4 = new StringBuilder(str5).append("; versionName=");
        String str6 = localPackageInfo.versionName;
        String str7 = str6;
        localObject = str7;
      }
      label144: this.adLog.log(1, 3, "created", (String)localObject);
      if (this.isAutoCollapse)
        setVisibility(4);
      this.view = this;
      if (this.adserverRequest == null)
      {
        MASTAdLog localMASTAdLog = this.adLog;
        AdserverRequest localAdserverRequest1 = new AdserverRequest(localMASTAdLog, paramContext);
        this.adserverRequest = localAdserverRequest1;
      }
      AdserverRequest localAdserverRequest2 = this.adserverRequest;
      String str8 = paramString4;
      AdserverRequest localAdserverRequest3 = localAdserverRequest2.setUa(str8);
      AdserverRequest localAdserverRequest4 = this.adserverRequest;
      Integer localInteger1 = Integer.valueOf(1);
      AdserverRequest localAdserverRequest5 = localAdserverRequest4.setCount(localInteger1);
      AdserverRequest localAdserverRequest6 = this.adserverRequest;
      Integer localInteger2 = Integer.valueOf(0);
      AdserverRequest localAdserverRequest7 = localAdserverRequest6.setSizeRequired(localInteger2);
      Integer localInteger3 = paramInteger6;
      setSite(localInteger3);
      String str9 = paramString1;
      setKeywords(str9);
      Integer localInteger4 = paramInteger8;
      setPremium(localInteger4);
      Integer localInteger5 = paramInteger7;
      setZone(localInteger5);
      Boolean localBoolean = paramBoolean;
      setTest(localBoolean);
      String str10 = paramString5;
      setCountry(str10);
      String str11 = paramString6;
      setRegion(str11);
      String str12 = paramString2;
      setLatitude(str12);
      String str13 = paramString3;
      setLongitude(str13);
      if (paramInteger9 != null)
      {
        int i = paramInteger9.intValue();
        setBackgroundColor(i);
      }
      if (paramInteger10 != null)
      {
        int j = paramInteger10.intValue();
        setTextColor(j);
      }
      String str14 = paramString7;
      setCarrier(str14);
      setMinSizeX(paramInteger1);
      setMinSizeY(paramInteger2);
      setMaxSizeX(paramInteger3);
      Integer localInteger6 = paramInteger4;
      setMaxSizeY(localInteger6);
      Hashtable<String, String> localHashtable = paramHashtable;
      setCustomParameters(localHashtable);
      Integer localInteger7 = paramInteger5;
      this.defaultImageResource = localInteger7;
      WebSettings localWebSettings = getSettings();
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setSupportZoom(false);
      localWebSettings.setCacheMode(2);
      OrmmaAssetController localOrmmaAssetController1 = new OrmmaAssetController(this, paramContext);
      this.mAssetController = localOrmmaAssetController1;
      OrmmaDisplayController localOrmmaDisplayController1 = new OrmmaDisplayController(this, paramContext);
      this.mDisplayController = localOrmmaDisplayController1;
      OrmmaUtilityController localOrmmaUtilityController1 = new OrmmaUtilityController(this, paramContext);
      this.mUtilityController = localOrmmaUtilityController1;
      OrmmaLocationController localOrmmaLocationController1 = new OrmmaLocationController(this, paramContext);
      this.mLocationController = localOrmmaLocationController1;
      OrmmaNetworkController localOrmmaNetworkController1 = new OrmmaNetworkController(this, paramContext);
      this.mNetworkController = localOrmmaNetworkController1;
      OrmmaSensorController localOrmmaSensorController1 = new OrmmaSensorController(this, paramContext);
      this.mSensorController = localOrmmaSensorController1;
      OrmmaDisplayController localOrmmaDisplayController2 = this.mDisplayController;
      addJavascriptInterface(localOrmmaDisplayController2, "ORMMADisplayControllerBridge");
      OrmmaUtilityController localOrmmaUtilityController2 = this.mUtilityController;
      addJavascriptInterface(localOrmmaUtilityController2, "ORMMAUtilityControllerBridge");
      OrmmaLocationController localOrmmaLocationController2 = this.mLocationController;
      addJavascriptInterface(localOrmmaLocationController2, "ORMMALocationControllerBridge");
      OrmmaNetworkController localOrmmaNetworkController2 = this.mNetworkController;
      addJavascriptInterface(localOrmmaNetworkController2, "ORMMANetworkControllerBridge");
      OrmmaSensorController localOrmmaSensorController2 = this.mSensorController;
      addJavascriptInterface(localOrmmaSensorController2, "ORMMASensorControllerBridge");
      OrmmaAssetController localOrmmaAssetController2 = this.mAssetController;
      addJavascriptInterface(localOrmmaAssetController2, "ORMMAAssetsControllerBridge");
      setScriptPath();
      AdWebViewClient localAdWebViewClient = new AdWebViewClient(paramContext);
      setWebViewClient(localAdWebViewClient);
      WebChromeClient localWebChromeClient = this.mWebChromeClient;
      setWebChromeClient(localWebChromeClient);
      System.out.println("@@@ Pre-load javascript");
      String str15 = setupViewport(true, " ");
      super.loadDataWithBaseURL(null, str15, "text/html", "UTF-8", null);
      Context localContext = this._context;
      Button localButton1 = new Button(localContext);
      this.buttonClose = localButton1;
      if (isInterstitial())
      {
        Button localButton2 = this.buttonClose;
        ViewGroup.LayoutParams localLayoutParams1 = new ViewGroup.LayoutParams(30, 30);
        localButton2.setLayoutParams(localLayoutParams1);
        Button localButton3 = this.buttonClose;
        StateListDrawable localStateListDrawable1 = InternelBrowser.GetSelector(this._context, "b_close.png", "b_close.png", "b_close.png");
        localButton3.setBackgroundDrawable(localStateListDrawable1);
      }
      while (true)
      {
        this.buttonClose.setVisibility(4);
        Button localButton4 = this.buttonClose;
        View.OnClickListener local3 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Handler localHandler = MASTAdViewCore.this.handler;
            Runnable local1 = new Runnable()
            {
              public void run()
              {
                if ((MASTAdViewCore.this.isInterstitial()) && (!MASTAdViewCore.this.isExpanded))
                {
                  MASTAdViewCore.this.InterstitialClose();
                  return;
                }
                MASTAdViewCore.this.injectJavaScript("ormma.close();");
              }
            };
            boolean bool = localHandler.post(local1);
          }
        };
        localButton4.setOnClickListener(local3);
        LinearLayout localLinearLayout = new LinearLayout(paramContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setGravity(5);
        Button localButton5 = this.buttonClose;
        localLinearLayout.addView(localButton5);
        addView(localLinearLayout);
        return;
        Button localButton6 = this.buttonClose;
        ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(30, 30);
        localButton6.setLayoutParams(localLayoutParams2);
        Button localButton7 = this.buttonClose;
        StateListDrawable localStateListDrawable2 = InternelBrowser.GetSelector(this._context, "b_close_s.png", "b_close_s.png", "b_close_s.png");
        localButton7.setBackgroundDrawable(localStateListDrawable2);
      }
    }
    catch (Exception localException)
    {
      break label144;
    }
  }

  private void loadExpandedUrl(String paramString, MASTAdViewCore paramMASTAdViewCore, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.mParentAd = paramMASTAdViewCore;
    mExpandedFrame = paramViewGroup;
    ViewState localViewState = ViewState.EXPANDED;
    this.mViewState = localViewState;
    String str = this.mDataToInject;
    loadUrl(paramString, paramBoolean, str);
  }

  private void loadWebViewContent(final String paramString1, final String paramString2, final String paramString3)
  {
    Handler localHandler = this.handler;
    Runnable local9 = new Runnable()
    {
      public void run()
      {
        WebView localWebView = MASTAdViewCore.this.view;
        String str1 = paramString1;
        String str2 = paramString2;
        String str3 = paramString3;
        localWebView.loadDataWithBaseURL(str1, str2, "text/html", "UTF-8", str3);
      }
    };
    boolean bool = localHandler.post(local9);
  }

  private void onStateChange(ViewState paramViewState)
  {
    int[] arrayOfInt = $SWITCH_TABLE$com$MASTAdView$MASTAdViewCore$ViewState();
    int i = paramViewState.ordinal();
    String str1;
    switch (arrayOfInt[i])
    {
    default:
      str1 = "default";
    case 3:
    case 4:
    case 2:
    }
    while (true)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = str1;
      String str2 = String.format("Ormma.fireEvent(ORMMA_EVENT_STATE_CHANGE, \"%s\");", arrayOfObject);
      injectJavaScript(str2);
      return;
      str1 = "expanded";
      continue;
      str1 = "hidden";
      continue;
      str1 = "resized";
    }
  }

  private void openUrlInExternalBrowser(Context paramContext, String paramString)
  {
    if (paramString == null)
      return;
    if (this.openUrlThread != null)
    {
      Thread.State localState1 = this.openUrlThread.getState();
      Thread.State localState2 = Thread.State.TERMINATED;
      if (!localState1.equals(localState2));
    }
    else
    {
      Context localContext = getContext();
      OpenUrlThread localOpenUrlThread = new OpenUrlThread(localContext, this, paramString);
      this.openUrlThread = localOpenUrlThread;
      this.openUrlThread.start();
      return;
    }
    Thread.State localState3 = this.openUrlThread.getState();
    Thread.State localState4 = Thread.State.NEW;
    if (!localState3.equals(localState4))
      return;
    this.openUrlThread.start();
  }

  protected static String readFile(String paramString)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    try
    {
      File localFile = new File(paramString);
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      InputStreamReader localInputStreamReader = new InputStreamReader(localFileInputStream);
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      while (true)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null)
        {
          localBufferedReader.close();
          localFileInputStream.close();
          PrintStream localPrintStream1 = System.out;
          StringBuilder localStringBuilder = new StringBuilder("readFile: ");
          String str2 = localStringBuffer1.toString();
          String str3 = str2;
          localPrintStream1.println(str3);
          str4 = localStringBuffer1.toString();
          return str4;
        }
        StringBuffer localStringBuffer2 = localStringBuffer1.append(str1);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        PrintStream localPrintStream2 = System.out;
        String str5 = "Exception reading file: " + paramString;
        localPrintStream2.println(str5);
        String str4 = null;
      }
    }
  }

  private static void sendGetRequest(String paramString)
    throws IOException
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpGet localHttpGet = new HttpGet(paramString);
    HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpGet);
  }

  private void setExpandBackgroundColor(OrmmaController.Properties paramProperties, View paramView)
  {
    if (!paramProperties.useBackground)
      return;
    float f1 = paramProperties.backgroundOpacity;
    float f2 = 255.0F * f1;
    int i = new Float(f2).intValue();
    if (i < 0)
      i = 0;
    if (i > 255)
      i = 255;
    int j = Color.red(paramProperties.backgroundColor);
    int k = Color.green(paramProperties.backgroundColor);
    int m = Color.blue(paramProperties.backgroundColor);
    int n = Color.argb(i, j, k, m);
    paramView.setBackgroundColor(n);
  }

  /** @deprecated */
  private void setScriptPath()
  {
    try
    {
      if (mScriptPath == null)
        mScriptPath = this.mAssetController.copyTextFromJarIntoAssetDir("/OrmmaAdController.js", "/OrmmaAdController.js");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private String setupViewport(boolean paramBoolean, String paramString)
  {
    StringBuffer localStringBuffer1 = new StringBuffer("<html><head>");
    StringBuffer localStringBuffer2 = localStringBuffer1.append("<script src=\"file://");
    String str1 = mScriptPath;
    StringBuffer localStringBuffer3 = localStringBuffer1.append(str1);
    StringBuffer localStringBuffer4 = localStringBuffer1.append("\" type=\"text/javascript\"></script>");
    String str2 = getInjectionHeaderCode();
    StringBuffer localStringBuffer5 = localStringBuffer1.append(str2);
    StringBuffer localStringBuffer6 = localStringBuffer1.append("</head><body>");
    if ((!paramBoolean) && (paramString != null))
      StringBuffer localStringBuffer7 = localStringBuffer1.append(paramString);
    StringBuffer localStringBuffer8 = localStringBuffer1.append("</body></html>");
    return localStringBuffer1.toString();
  }

  private void stopTimer(boolean paramBoolean)
  {
    if (this.reloadTimer == null)
      return;
    try
    {
      this.reloadTimer.cancel();
      if (paramBoolean)
        this.reloadTimer = null;
      this.adLog.log(3, 3, "stopTimer", "timer stopped");
      return;
    }
    catch (Exception localException)
    {
      MASTAdLog localMASTAdLog = this.adLog;
      String str = localException.getMessage();
      localMASTAdLog.log(1, 1, "stopTimer", str);
    }
  }

  private void update(boolean paramBoolean)
  {
    if ((!isShown()) && (!paramBoolean))
      return;
    this.adLog.log(3, 3, "update", "");
    if (paramBoolean)
      this.IsManualUpdate = true;
    hideVirtualKeyboard();
    Context localContext = getContext();
    StartLoadContent(localContext, this);
  }

  protected void AutoDetectParameters(Context paramContext)
  {
    this._context = paramContext;
    if (this.adserverRequest == null)
    {
      MASTAdLog localMASTAdLog = this.adLog;
      AdserverRequest localAdserverRequest = new AdserverRequest(localMASTAdLog, paramContext);
      this.adserverRequest = localAdserverRequest;
    }
    WindowManager localWindowManager = (WindowManager)((Activity)paramContext).getSystemService("window");
    DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
    this.metrics = localDisplayMetrics1;
    Display localDisplay = localWindowManager.getDefaultDisplay();
    DisplayMetrics localDisplayMetrics2 = this.metrics;
    localDisplay.getMetrics(localDisplayMetrics2);
  }

  public String GetLastRequest()
  {
    return this.lastRequest;
  }

  public String GetLastResponse()
  {
    return this.lastResponse;
  }

  public boolean GetShowPreviousAdOnError()
  {
    return this.isShowPreviousAdOnError;
  }

  protected void InterstitialClose()
  {
  }

  public void SetShowPreviousAdOnError(boolean paramBoolean)
  {
    this.isShowPreviousAdOnError = paramBoolean;
  }

  public void close()
  {
    boolean bool = this.handler.sendEmptyMessage(1001);
  }

  protected void closeExpanded(View paramView)
  {
    ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).removeView(paramView);
    requestLayout();
  }

  public void expand(OrmmaController.Dimensions paramDimensions, String paramString, OrmmaController.Properties paramProperties)
  {
    Message localMessage = this.handler.obtainMessage(1004);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("expand_initial_dimensions", paramDimensions);
    localBundle.putString("expand_url", paramString);
    localBundle.putParcelable("expand_properties", paramProperties);
    localMessage.setData(localBundle);
    boolean bool = this.handler.sendMessage(localMessage);
  }

  public int getAd_Call_Timeout()
  {
    return this.adserverRequest.timeout;
  }

  public String getAdserverURL()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getAdserverURL(); ; str = null)
      return str;
  }

  public String getArea()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getArea(); ; str = null)
      return str;
  }

  public boolean getAutoCollapse()
  {
    return this.isAutoCollapse;
  }

  public int getBackgroundColor()
  {
    if (this.adserverRequest != null);
    for (int i = this.bgColor; ; i = -1)
      return i;
  }

  public String getCarrier()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getCarrier(); ; str = null)
      return str;
  }

  public String getCity()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getCity(); ; str = null)
      return str;
  }

  public String getCountry()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getCountry(); ; str = null)
      return str;
  }

  public Hashtable<String, String> getCustomParameters()
  {
    if (this.adserverRequest != null);
    for (Hashtable localHashtable = this.adserverRequest.getCustomParameters(); ; localHashtable = null)
      return localHashtable;
  }

  public Integer getDefaultImage()
  {
    if (this.defaultImageResource == null);
    for (int i = 0; ; i = this.defaultImageResource.intValue())
      return Integer.valueOf(i);
  }

  public String getDeviceId()
  {
    return ContentManager.getInstance(this).getDeviceId();
  }

  public String getDma()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getDma(); ; str = null)
      return str;
  }

  public String getInjectionHeaderCode()
  {
    if (this.injectionHeaderCode != null);
    for (String str = this.injectionHeaderCode; ; str = "<meta name=\"viewport\" content=\"target-densitydpi=device-dpi\"/><style>body{margin: 0px; padding: 0px; display:-webkit-box;-webkit-box-orient:horizontal;-webkit-box-pack:center;-webkit-box-align:center;}</style>")
      return str;
  }

  public boolean getInternalBrowser()
  {
    return this.internalBrowser;
  }

  public String getKeywords()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getKeywords(); ; str = null)
      return str;
  }

  public String getLatitude()
  {
    String str;
    if (this.adserverRequest != null)
    {
      str = this.adserverRequest.getLatitude();
      if (str == null);
    }
    while (true)
    {
      return str;
      str = null;
      continue;
      str = null;
    }
  }

  public int getLocationMinWait()
  {
    return this.locationMinWaitMillis.intValue();
  }

  public float getLocationMoveDistance()
  {
    return this.locationMinMoveMeters.floatValue();
  }

  public MASTAdLog getLog()
  {
    return this.adLog;
  }

  public String getLongitude()
  {
    String str;
    if (this.adserverRequest != null)
    {
      str = this.adserverRequest.getLongitude();
      if (str == null);
    }
    while (true)
    {
      return str;
      str = null;
      continue;
      str = null;
    }
  }

  public Integer getMaxSizeX()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getSizeX(); ; localInteger = Integer.valueOf(0))
      return localInteger;
  }

  public Integer getMaxSizeY()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getSizeY(); ; localInteger = Integer.valueOf(0))
      return localInteger;
  }

  @Deprecated
  public String getMetro()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getMetro(); ; str = null)
      return str;
  }

  public Integer getMinSizeX()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getMinSizeX(); ; localInteger = Integer.valueOf(0))
      return localInteger;
  }

  public Integer getMinSizeY()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getMinSizeY(); ; localInteger = Integer.valueOf(0))
      return localInteger;
  }

  public MASTOnActivityHandler getOnActivityHandler()
  {
    return this.onActivityHandler;
  }

  public MASTOnAdClickListener getOnAdClickListener()
  {
    return this.adClickListener;
  }

  public MASTOnAdDownload getOnAdDownload()
  {
    return this.adDownload;
  }

  public MASTOnOrmmaListener getOnOrmmaListener()
  {
    return this.ormmaListener;
  }

  public MASTOnThirdPartyRequest getOnThirdPartyRequest()
  {
    return this.onThirdPartyRequest;
  }

  public Integer getPremium()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getPremium(); ; localInteger = Integer.valueOf(2))
      return localInteger;
  }

  public String getRegion()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getRegion(); ; str = null)
      return str;
  }

  public Integer getSite()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getSite(); ; localInteger = Integer.valueOf(0))
      return localInteger;
  }

  public String getState()
  {
    return this.mViewState.toString().toLowerCase();
  }

  public Boolean getTest()
  {
    if (this.adserverRequest != null);
    for (Boolean localBoolean = this.adserverRequest.getTestModeEnabled(); ; localBoolean = null)
      return localBoolean;
  }

  public int getTextColor()
  {
    if (this.adserverRequest != null);
    for (int i = this.adserverRequest.getParamLINK().intValue(); ; i = -1)
      return i;
  }

  public Boolean getTrack()
  {
    boolean bool = true;
    Boolean localBoolean;
    if (this.adserverRequest != null)
      if (this.adserverRequest.getTrack() == null)
        localBoolean = null;
    while (true)
    {
      return localBoolean;
      if (this.adserverRequest.getTrack().intValue() == 1);
      while (true)
      {
        localBoolean = Boolean.valueOf(bool);
        break;
        bool = false;
      }
      localBoolean = null;
    }
  }

  public Integer getType()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getType(); ; localInteger = null)
      return localInteger;
  }

  public Integer getUpdateTime()
  {
    long l;
    if (this.adReloadPeriod != null)
      l = this.adReloadPeriod.longValue() / 1000L;
    for (Integer localInteger = Integer.valueOf(new Long(l).intValue()); ; localInteger = Integer.valueOf(new Long(120L).intValue()))
      return localInteger;
  }

  public boolean getUseSystemDeviceId()
  {
    return ContentManager.getInstance(this).getUseSystemDeviceId();
  }

  public String getZip()
  {
    if (this.adserverRequest != null);
    for (String str = this.adserverRequest.getZip(); ; str = null)
      return str;
  }

  public Integer getZone()
  {
    if (this.adserverRequest != null);
    for (Integer localInteger = this.adserverRequest.getZone(); ; localInteger = Integer.valueOf(0))
      return localInteger;
  }

  public void hide()
  {
    boolean bool = this.handler.sendEmptyMessage(1002);
    if (!isInterstitial())
      return;
    if (this.isExpanded)
      return;
    InterstitialClose();
  }

  public void injectJavaScript(String paramString)
  {
    try
    {
      String str = "javascript:" + paramString;
      super.loadUrl(str);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public boolean isInterstitial()
  {
    if ((!this.isExpanded) && (!this.isInterstitial));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public void loadUrl(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mDataToInject = paramString2;
    if (!paramBoolean)
    {
      if (paramString1 == null)
        return;
      try
      {
        if (paramString1.length() <= 0)
          return;
        super.loadUrl(paramString1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        MASTAdLog localMASTAdLog = this.adLog;
        String str1 = localException.getMessage();
        localMASTAdLog.log(1, 1, "loadUrl", str1);
        return;
      }
    }
    if (this.mContent == null)
      return;
    if (this.mContent.length() <= 0)
      return;
    String str2 = this.mContent;
    MASTAdViewCore localMASTAdViewCore = this;
    String str3 = null;
    localMASTAdViewCore.loadDataWithBaseURL(null, str2, "text/html", "UTF-8", str3);
  }

  protected void onAttachedToWindow()
  {
    if (this.reloadTimer == null)
    {
      Timer localTimer = new Timer();
      this.reloadTimer = localTimer;
      Context localContext = getContext();
      WebView localWebView = this.view;
      StartTimer(localContext, localWebView);
    }
    super.onAttachedToWindow();
    if (this.onActivityHandler != null)
    {
      MASTOnActivityHandler localMASTOnActivityHandler = this.onActivityHandler;
      MASTAdView localMASTAdView = (MASTAdView)this;
      localMASTOnActivityHandler.onAttachedToActivity(localMASTAdView);
    }
    if (getBackgroundColor() != 0)
      return;
    invalidate();
  }

  protected void onDetachedFromWindow()
  {
    if ((this.locationManager != null) && (this.listener != null))
    {
      LocationManager localLocationManager = this.locationManager;
      LocListener localLocListener = this.listener;
      localLocationManager.removeUpdates(localLocListener);
    }
    stopTimer(true);
    ContentManager.getInstance(this).stopLoadContent(this);
    if (this.mNetworkController != null)
      this.mNetworkController.stopAllNetworkListeners();
    if (this.mDisplayController != null)
      this.mDisplayController.stopAllOrientationListeners();
    super.onDetachedFromWindow();
    if (this.onActivityHandler == null)
      return;
    MASTOnActivityHandler localMASTOnActivityHandler = this.onActivityHandler;
    MASTAdView localMASTAdView = (MASTAdView)this;
    localMASTOnActivityHandler.onDetachedFromActivity(localMASTAdView);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ViewState localViewState1 = this.mViewState;
      ViewState localViewState2 = ViewState.EXPANDED;
      if (localViewState1 != localViewState2);
    }
    for (boolean bool = true; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return bool;
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ViewState localViewState1 = this.mViewState;
      ViewState localViewState2 = ViewState.EXPANDED;
      if (localViewState1 == localViewState2)
        if (this.expandParent != null)
        {
          MASTAdViewCore localMASTAdViewCore = this.expandParent;
          closeRunnable(localMASTAdViewCore);
        }
    }
    for (boolean bool = true; ; bool = super.onKeyUp(paramInt, paramKeyEvent))
    {
      return bool;
      closeRunnable(this);
      break;
    }
  }

  protected void onPageFinished()
  {
    if (this.mDataToInject != null)
    {
      String str = this.mDataToInject;
      injectJavaScript(str);
    }
    injectJavaScript("Ormma.ready();");
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
  {
    ViewState localViewState1 = this.mViewState;
    ViewState localViewState2 = ViewState.DEFAULT;
    if (localViewState1 != localViewState2)
      stopTimer(false);
    ViewState localViewState3 = this.mViewState;
    ViewState localViewState4 = ViewState.EXPANDED;
    if ((localViewState3 == localViewState4) && (mExpandedFrame != null))
    {
      if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
      {
        final MASTAdViewCore localMASTAdViewCore = this;
        Handler localHandler = this.handler;
        Runnable local4 = new Runnable()
        {
          public void run()
          {
            ViewGroup.LayoutParams localLayoutParams = MASTAdViewCore.this.getLayoutParams();
            localLayoutParams.width = -1;
            localLayoutParams.height = -1;
            localMASTAdViewCore.setLayoutParams(localLayoutParams);
            localMASTAdViewCore.requestLayout();
            int i = localMASTAdViewCore.getWidth();
            int j = localMASTAdViewCore.getHeight();
            int k = MASTAdViewCore.this.mOldWidth;
            int m = MASTAdViewCore.this.metrics.widthPixels;
            if (k != m)
            {
              int n = MASTAdViewCore.this.mOldWidth;
              int i1 = localMASTAdViewCore.getWidth();
              if (n != i1)
              {
                MASTAdViewCore localMASTAdViewCore1 = MASTAdViewCore.this;
                int i2 = localMASTAdViewCore.getWidth();
                localMASTAdViewCore1.mOldWidth = i2;
                Display localDisplay = ((WindowManager)((Activity)MASTAdViewCore.this._context).getSystemService("window")).getDefaultDisplay();
                DisplayMetrics localDisplayMetrics = MASTAdViewCore.this.metrics;
                localDisplay.getMetrics(localDisplayMetrics);
              }
            }
            MASTAdViewCore localMASTAdViewCore2 = MASTAdViewCore.this;
            int i3 = paramInt3;
            int i4 = paramInt4;
            localMASTAdViewCore2.onSizeChanged(i, j, i3, i4);
          }
        };
        boolean bool = localHandler.post(local4);
        return;
      }
      int i = this.mOldWidth;
      int j = this.metrics.widthPixels;
      if (i != j)
      {
        int k = this.mOldWidth;
        int m = getWidth();
        if (k != m)
        {
          int n = getWidth();
          this.mOldWidth = n;
          Display localDisplay = ((WindowManager)((Activity)this._context).getSystemService("window")).getDefaultDisplay();
          DisplayMetrics localDisplayMetrics = this.metrics;
          localDisplay.getMetrics(localDisplayMetrics);
        }
      }
    }
    Object[] arrayOfObject = new Object[2];
    Integer localInteger1 = Integer.valueOf(paramInt1);
    arrayOfObject[0] = localInteger1;
    Integer localInteger2 = Integer.valueOf(paramInt2);
    arrayOfObject[1] = localInteger2;
    String str = String.format("Ormma.fireEvent(ORMMA_EVENT_SIZE_CHANGE, {dimensions : {width : %d, height: %d}});", arrayOfObject);
    injectJavaScript(str);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.adserverRequest.sizeX = paramInt1;
    this.adserverRequest.sizeY = paramInt2;
  }

  public void openMap(String paramString, boolean paramBoolean)
  {
    String str1 = OrmmaUtils.convert(paramString.trim());
    String str2 = "geo:0,0?q=" + str1;
    try
    {
      Uri localUri = Uri.parse(str2);
      Intent localIntent1 = new Intent("android.intent.action.VIEW", localUri);
      Intent localIntent2 = localIntent1.setFlags(268435456);
      getContext().startActivity(localIntent1);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      this.adLog.log(2, 1, "openMap", "Error: no Google Api or error in parameters");
    }
  }

  public void ormmaEvent(String paramString1, String paramString2)
  {
    if (this.ormmaListener == null)
      return;
    if (!this.ormaEnabled)
    {
      MASTOnOrmmaListener localMASTOnOrmmaListener1 = this.ormmaListener;
      MASTAdView localMASTAdView1 = (MASTAdView)this;
      localMASTOnOrmmaListener1.event(localMASTAdView1, "ormmaenabled", "");
    }
    this.ormaEnabled = true;
    if (paramString2 != null)
      paramString2 = paramString2.replace(";", "&");
    MASTOnOrmmaListener localMASTOnOrmmaListener2 = this.ormmaListener;
    MASTAdView localMASTAdView2 = (MASTAdView)this;
    localMASTOnOrmmaListener2.event(localMASTAdView2, paramString1, paramString2);
  }

  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3)
  {
    OrmmaController.PlayerProperties localPlayerProperties = new OrmmaController.PlayerProperties();
    boolean bool1 = paramBoolean1;
    boolean bool2 = paramBoolean2;
    boolean bool3 = paramBoolean4;
    boolean bool4 = paramBoolean3;
    String str1 = paramString2;
    String str2 = paramString3;
    localPlayerProperties.setProperties(false, bool1, bool2, bool3, bool4, str1, str2);
    Bundle localBundle = new Bundle();
    String str3 = ACTION.PLAY_AUDIO.toString();
    localBundle.putString("action", str3);
    localBundle.putString("expand_url", paramString1);
    localBundle.putParcelable("player_properties", localPlayerProperties);
    Message localMessage = this.handler.obtainMessage(1008);
    localMessage.setData(localBundle);
    boolean bool5 = this.handler.sendMessage(localMessage);
  }

  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, OrmmaController.Dimensions paramDimensions, String paramString2, String paramString3)
  {
    Message localMessage = this.handler.obtainMessage(1007);
    OrmmaController.PlayerProperties localPlayerProperties = new OrmmaController.PlayerProperties();
    boolean bool1 = paramBoolean1;
    boolean bool2 = paramBoolean2;
    boolean bool3 = paramBoolean3;
    boolean bool4 = paramBoolean4;
    String str1 = paramString2;
    String str2 = paramString3;
    localPlayerProperties.setProperties(bool1, bool2, bool3, false, bool4, str1, str2);
    Bundle localBundle = new Bundle();
    localBundle.putString("expand_url", paramString1);
    String str3 = ACTION.PLAY_VIDEO.toString();
    localBundle.putString("action", str3);
    localBundle.putParcelable("player_properties", localPlayerProperties);
    if (paramDimensions != null)
    {
      OrmmaController.Dimensions localDimensions = paramDimensions;
      localBundle.putParcelable("expand_dimensions", localDimensions);
    }
    localMessage.setData(localBundle);
    boolean bool5 = this.handler.sendMessage(localMessage);
  }

  public void raiseError(String paramString1, String paramString2)
  {
    Message localMessage = this.handler.obtainMessage(1009);
    Bundle localBundle = new Bundle();
    localBundle.putString("message", paramString1);
    localBundle.putString("action", paramString2);
    localMessage.setData(localBundle);
    boolean bool = this.handler.sendMessage(localMessage);
  }

  public void resize(int paramInt1, int paramInt2)
  {
    Message localMessage = this.handler.obtainMessage(1000);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resize_width", paramInt1);
    localBundle.putInt("resize_height", paramInt2);
    localMessage.setData(localBundle);
    boolean bool = this.handler.sendMessage(localMessage);
  }

  public void setAdVisibility(final int paramInt)
  {
    Handler localHandler = this.handler;
    Runnable local7 = new Runnable()
    {
      public void run()
      {
        MASTAdViewCore localMASTAdViewCore = MASTAdViewCore.this;
        int i = paramInt;
        localMASTAdViewCore.setVisibility(i);
      }
    };
    boolean bool = localHandler.post(local7);
  }

  public void setAd_Call_Timeout(int paramInt)
  {
    if (paramInt < 1000)
      return;
    if (paramInt > 3000)
      return;
    this.adserverRequest.timeout = paramInt;
  }

  public void setAdserverURL(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    this.adserverRequest.setAdserverURL(paramString);
  }

  public void setArea(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setArea(paramString);
  }

  public void setAutoCollapse(boolean paramBoolean)
  {
    this.isAutoCollapse = paramBoolean;
  }

  public void setBackgroundColor(int paramInt)
  {
    if (this.adserverRequest == null)
      return;
    try
    {
      this.bgColor = paramInt;
      AdserverRequest localAdserverRequest1 = this.adserverRequest;
      Integer localInteger = Integer.valueOf(paramInt);
      AdserverRequest localAdserverRequest2 = localAdserverRequest1.setParamBG(localInteger);
      super.setBackgroundColor(paramInt);
      return;
    }
    catch (Exception localException)
    {
      MASTAdLog localMASTAdLog = this.adLog;
      String str = localException.getMessage();
      localMASTAdLog.log(1, 1, "AdServerViewCore.setBackgroundColor", str);
    }
  }

  public void setCarrier(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setCarrier(paramString);
  }

  public void setCity(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setCity(paramString);
  }

  public void setContent(String paramString)
  {
    this.mContent = paramString;
    if (!this.isExpanded)
      return;
    String str1 = this.mContent;
    MASTAdViewCore localMASTAdViewCore = this;
    String str2 = null;
    localMASTAdViewCore.loadDataWithBaseURL(null, str1, "text/html", "UTF-8", str2);
  }

  public void setCountry(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setCountry(paramString);
  }

  public void setCustomParameters(Hashtable<String, String> paramHashtable)
  {
    if (this.adserverRequest == null)
      return;
    this.adserverRequest.setCustomParameters(paramHashtable);
  }

  public void setDefaultImage(Integer paramInteger)
  {
    this.defaultImageResource = paramInteger;
  }

  public void setDeviceId(String paramString)
  {
    ContentManager.getInstance(this).setDeviceId(paramString);
  }

  public void setDma(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setDma(paramString);
  }

  public void setInjectionHeaderCode(String paramString)
  {
    this.injectionHeaderCode = paramString;
  }

  public void setInternalBrowser(boolean paramBoolean)
  {
    this.internalBrowser = paramBoolean;
  }

  public void setKeywords(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setKeywords(paramString);
  }

  public void setLatitude(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    if (paramString == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setLatitude(paramString);
  }

  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    int i = paramLayoutParams.width;
    this.lastX = i;
    int j = paramLayoutParams.height;
    this.lastY = j;
    super.setLayoutParams(paramLayoutParams);
  }

  public void setLocationDetection(boolean paramBoolean)
  {
    if (!paramBoolean)
      return;
    final AutoDetectParameters localAutoDetectParameters = AutoDetectParameters.getInstance();
    if (this.locationMinWaitMillis == null)
    {
      Integer localInteger = Integer.valueOf(0);
      this.locationMinWaitMillis = localInteger;
    }
    if (this.locationMinMoveMeters == null)
    {
      Float localFloat = Float.valueOf(0.0F);
      this.locationMinMoveMeters = localFloat;
    }
    if ((this.adserverRequest.getLatitude() != null) && (this.adserverRequest.getLongitude() != null))
      return;
    if ((localAutoDetectParameters.getLatitude() == null) || (localAutoDetectParameters.getLongitude() == null))
    {
      if (this._context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
      {
        LocationManager localLocationManager = (LocationManager)this._context.getSystemService("location");
        this.locationManager = localLocationManager;
        if (this.locationManager.isProviderEnabled("gps"))
        {
          Context localContext = getContext();
          int i = this.locationMinWaitMillis.intValue();
          float f = this.locationMinMoveMeters.floatValue();
          Looper localLooper = Looper.getMainLooper();
          MASTAdLog localMASTAdLog1 = this.adLog;
          MASTAdViewCore localMASTAdViewCore = this;
          LocListener local12 = new LocListener()
          {
            public void fail(String paramAnonymousString)
            {
            }

            public void success(Location paramAnonymousLocation)
            {
              try
              {
                double d1 = paramAnonymousLocation.getLatitude();
                double d2 = paramAnonymousLocation.getLongitude();
                AdserverRequest localAdserverRequest1 = MASTAdViewCore.this.adserverRequest;
                String str1 = Double.toString(d1);
                AdserverRequest localAdserverRequest2 = localAdserverRequest1.setLatitude(str1);
                AdserverRequest localAdserverRequest3 = MASTAdViewCore.this.adserverRequest;
                String str2 = Double.toString(d2);
                AdserverRequest localAdserverRequest4 = localAdserverRequest3.setLongitude(str2);
                AutoDetectParameters localAutoDetectParameters1 = localAutoDetectParameters;
                String str3 = Double.toString(d1);
                localAutoDetectParameters1.setLatitude(str3);
                AutoDetectParameters localAutoDetectParameters2 = localAutoDetectParameters;
                String str4 = Double.toString(d2);
                localAutoDetectParameters2.setLongitude(str4);
                MASTAdLog localMASTAdLog1 = MASTAdViewCore.this.adLog;
                StringBuilder localStringBuilder1 = new StringBuilder("(");
                String str5 = localAutoDetectParameters.getLatitude();
                StringBuilder localStringBuilder2 = localStringBuilder1.append(str5).append(";");
                String str6 = localAutoDetectParameters.getLongitude();
                String str7 = str6 + ")";
                localMASTAdLog1.log(3, 3, "GPSLocationChanged=", str7);
                return;
              }
              catch (Exception localException)
              {
                MASTAdLog localMASTAdLog2 = MASTAdViewCore.this.adLog;
                String str8 = localException.getMessage();
                localMASTAdLog2.log(2, 1, "GPSLocationChanged", str8);
              }
            }
          };
          this.listener = local12;
          this.listener.start();
          return;
        }
        this.adLog.log(2, 2, "AutoDetectParameters.Gps", "not avalable");
        return;
      }
      this.adLog.log(2, 2, "AutoDetectParameters.Gps", "no permission ACCESS_FINE_LOCATION");
      return;
    }
    AdserverRequest localAdserverRequest1 = this.adserverRequest;
    String str1 = localAutoDetectParameters.getLatitude();
    AdserverRequest localAdserverRequest2 = localAdserverRequest1.setLatitude(str1);
    AdserverRequest localAdserverRequest3 = this.adserverRequest;
    String str2 = localAutoDetectParameters.getLongitude();
    AdserverRequest localAdserverRequest4 = localAdserverRequest3.setLongitude(str2);
    MASTAdLog localMASTAdLog2 = this.adLog;
    StringBuilder localStringBuilder1 = new StringBuilder("(");
    String str3 = localAutoDetectParameters.getLatitude();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append(";");
    String str4 = localAutoDetectParameters.getLongitude();
    String str5 = str4 + ")";
    localMASTAdLog2.log(2, 2, "AutoDetectParameters.Gps=", str5);
  }

  public void setLocationMinWait(int paramInt)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    this.locationMinWaitMillis = localInteger;
  }

  public void setLocationMoveDistance(float paramFloat)
  {
    Float localFloat = Float.valueOf(paramFloat);
    this.locationMinMoveMeters = localFloat;
  }

  public void setLogLevel(int paramInt)
  {
    this.adLog.setLogLevel(paramInt);
  }

  public void setLongitude(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    if (paramString == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setLongitude(paramString);
  }

  public void setMaxSizeX(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setSizeX(paramInteger);
  }

  public void setMaxSizeY(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setSizeY(paramInteger);
  }

  @Deprecated
  public void setMetro(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setMetro(paramString);
  }

  public void setMinSizeX(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setMinSizeX(paramInteger);
  }

  public void setMinSizeY(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setMinSizeY(paramInteger);
  }

  public void setOnActivityHandler(MASTOnActivityHandler paramMASTOnActivityHandler)
  {
    this.onActivityHandler = paramMASTOnActivityHandler;
  }

  public void setOnAdClickListener(MASTOnAdClickListener paramMASTOnAdClickListener)
  {
    this.adClickListener = paramMASTOnAdClickListener;
  }

  public void setOnAdDownload(MASTOnAdDownload paramMASTOnAdDownload)
  {
    this.adDownload = paramMASTOnAdDownload;
  }

  public void setOnOrmmaListener(MASTOnOrmmaListener paramMASTOnOrmmaListener)
  {
    this.ormmaListener = paramMASTOnOrmmaListener;
  }

  public void setOnThirdPartyRequest(MASTOnThirdPartyRequest paramMASTOnThirdPartyRequest)
  {
    this.onThirdPartyRequest = paramMASTOnThirdPartyRequest;
  }

  public void setPremium(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setPremium(paramInteger);
  }

  public void setRegion(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setRegion(paramString);
  }

  protected void setResult(String paramString1, String paramString2)
  {
    String str1 = paramString1;
    this.lastResponse = str1;
    if (paramString2 != null)
    {
      MASTAdLog localMASTAdLog1 = this.adLog;
      StringBuilder localStringBuilder1 = new StringBuilder("requestGet result[");
      String str2 = String.valueOf(RequestCounter);
      String str3 = str2 + "][ERROR]";
      String str4 = paramString2;
      localMASTAdLog1.log(3, 1, str3, str4);
      if (this.adDownload != null)
      {
        MASTOnAdDownload localMASTOnAdDownload1 = this.adDownload;
        MASTAdView localMASTAdView1 = (MASTAdView)this;
        String str5 = paramString2;
        localMASTOnAdDownload1.error(localMASTAdView1, str5);
      }
      Context localContext1 = getContext();
      WebView localWebView1 = this.view;
      StartTimer(localContext1, localWebView1);
      if ((this.mContent != null) && (!this.mContent.equals("")) && (this.isShowPreviousAdOnError))
        return;
      if (this.defaultImageResource != null)
        try
        {
          Handler localHandler1 = this.handler;
          WebView localWebView2 = this.view;
          Integer localInteger1 = this.defaultImageResource;
          MASTAdViewCore localMASTAdViewCore1 = this;
          Integer localInteger2 = localInteger1;
          SetBackgroundResourceAction localSetBackgroundResourceAction = new SetBackgroundResourceAction(localWebView2, localInteger2);
          boolean bool1 = localHandler1.post(localSetBackgroundResourceAction);
          return;
        }
        catch (Exception localException1)
        {
          MASTAdLog localMASTAdLog2 = this.adLog;
          String str6 = localException1.getMessage();
          String str7 = "setResult";
          String str8 = str6;
          localMASTAdLog2.log(1, 1, str7, str8);
          return;
        }
      if (this.isAutoCollapse)
      {
        setAdVisibility(4);
        return;
      }
      String str9 = setupViewport(false, null);
      MASTAdViewCore localMASTAdViewCore2 = this;
      String str10 = str9;
      localMASTAdViewCore2.loadWebViewContent(null, str10, null);
      return;
    }
    Context localContext2 = getContext();
    MASTAdLog localMASTAdLog3 = this.adLog;
    StringBuilder localStringBuilder2 = new StringBuilder("requestGet result[");
    String str11 = String.valueOf(RequestCounter);
    String str12 = str11 + "]";
    String str13 = paramString1;
    localMASTAdLog3.log(3, 3, str12, str13);
    if (paramString1 != null)
    {
      try
      {
        if (paramString1.length() <= 0)
          break label1055;
        String str14 = paramString1.toLowerCase();
        if ((str14.contains("invalid params")) || (str14.contains("error: -1")))
        {
          InterstitialClose();
          Context localContext3 = getContext();
          WebView localWebView3 = this.view;
          StartTimer(localContext3, localWebView3);
          if (this.adDownload == null)
            return;
          MASTOnAdDownload localMASTOnAdDownload2 = this.adDownload;
          MASTAdView localMASTAdView2 = (MASTAdView)this;
          localMASTOnAdDownload2.error(localMASTAdView2, "invalid params");
          return;
        }
      }
      catch (Exception localException2)
      {
        MASTAdLog localMASTAdLog4 = this.adLog;
        String str15 = localException2.getMessage();
        String str16 = "StartLoadContent";
        String str17 = str15;
        localMASTAdLog4.log(1, 1, str16, str17);
        WebView localWebView4 = this.view;
        StartTimer(localContext2, localWebView4);
        return;
      }
      String str18 = Utils.scrapeIgnoreCase(paramString1, "<external_campaign", "</external_campaign>");
      if ((str18 != null) && (str18.length() > 0))
      {
        String str19 = Utils.scrapeIgnoreCase(str18, "<type>", "</type>");
        String str20 = Utils.scrapeIgnoreCase(str18, "<campaign_id>", "</campaign_id>");
        String str21 = Utils.scrapeIgnoreCase(str18, "<track_url>", "</track_url>");
        String str22 = Utils.scrapeIgnoreCase(str18, "<external_params>", "</external_params>");
        MASTOnThirdPartyRequest localMASTOnThirdPartyRequest1 = this.onThirdPartyRequest;
        if (localMASTOnThirdPartyRequest1 != null)
          try
          {
            HashMap localHashMap1 = new HashMap();
            HashMap localHashMap2 = localHashMap1;
            String str23 = str19;
            Object localObject1 = localHashMap2.put("type", str23);
            Object localObject2 = localHashMap1.put("campaignId", str20);
            HashMap localHashMap3 = localHashMap1;
            String str24 = str21;
            Object localObject3 = localHashMap3.put("trackUrl", str24);
            String[] arrayOfString1 = str22.split("</param>");
            int i = 0;
            int j = arrayOfString1.length;
            if (i >= j)
            {
              MASTOnThirdPartyRequest localMASTOnThirdPartyRequest2 = this.onThirdPartyRequest;
              MASTAdView localMASTAdView3 = (MASTAdView)this;
              HashMap localHashMap4 = localHashMap1;
              localMASTOnThirdPartyRequest2.event(localMASTAdView3, localHashMap4);
              WebView localWebView5 = this.view;
              StartTimer(localContext2, localWebView5);
              return;
            }
            String[] arrayOfString2 = arrayOfString1[i].split("\">");
            if (arrayOfString2.length > 1);
            for (String str25 = arrayOfString2[1]; ; str25 = "")
            {
              String str26 = arrayOfString2[0].split("\"")[1];
              HashMap localHashMap5 = localHashMap1;
              String str27 = str25;
              Object localObject4 = localHashMap5.put(str26, str27);
              i += 1;
              break;
            }
          }
          catch (Exception localException3)
          {
            while (true)
            {
              MASTAdLog localMASTAdLog5 = this.adLog;
              String str28 = localException3.getMessage();
              String str29 = "onThirdPartyRequest";
              String str30 = str28;
              localMASTAdLog5.log(1, 1, str29, str30);
            }
          }
        WebView localWebView6 = this.view;
        RestartExcampaings(str20, localContext2, localWebView6);
        return;
      }
      Handler localHandler2 = this.handler;
      WebView localWebView7 = this.view;
      MASTAdViewCore localMASTAdViewCore3 = this;
      RemoveAllChildViews localRemoveAllChildViews = new RemoveAllChildViews(localWebView7);
      boolean bool2 = localHandler2.post(localRemoveAllChildViews);
      String str31 = "";
      if ((str31 != null) && (str31.length() > 0))
      {
        String str32 = Utils.scrapeIgnoreCase(str31, "src=\"", "\"");
        String str33 = Utils.scrapeIgnoreCase(paramString1, "href=\"", "\"");
        Handler localHandler3 = this.handler;
        WebView localWebView8 = this.view;
        MASTAdViewCore localMASTAdViewCore4 = this;
        SetupVideoAction localSetupVideoAction = new SetupVideoAction(localContext2, localWebView8, str32, str33);
        boolean bool3 = localHandler3.post(localSetupVideoAction);
        stopTimer(false);
        return;
      }
      MASTAdViewCore localMASTAdViewCore5 = this;
      String str34 = paramString1;
      String str35 = localMASTAdViewCore5.setupViewport(false, str34);
      MASTAdLog localMASTAdLog6 = this.adLog;
      String str36 = "setResult: final data:";
      localMASTAdLog6.log(3, 3, str36, str35);
      this.mContent = str35;
      Handler localHandler4 = this.handler;
      MASTAdViewCore localMASTAdViewCore6 = this;
      Runnable local8 = new Runnable()
      {
        public void run()
        {
          WebView localWebView = MASTAdViewCore.this.view;
          String str1 = MASTAdViewCore.this.mContent;
          String str2 = null;
          localWebView.loadDataWithBaseURL(null, str1, "text/html", "UTF-8", str2);
          ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParams();
          int i = MASTAdViewCore.this.lastX;
          localLayoutParams1.width = i;
          ViewGroup.LayoutParams localLayoutParams2 = MASTAdViewCore.this.getLayoutParams();
          int j = MASTAdViewCore.this.lastY;
          localLayoutParams2.height = j;
          MASTAdViewCore.this.requestLayout();
        }
      };
      boolean bool4 = localHandler4.post(local8);
      WebView localWebView9 = this.view;
      StartTimer(localContext2, localWebView9);
      return;
    }
    label1055: InterstitialClose();
    if (this.adDownload != null)
    {
      MASTOnAdDownload localMASTOnAdDownload3 = this.adDownload;
      MASTAdView localMASTAdView4 = (MASTAdView)this;
      localMASTOnAdDownload3.error(localMASTAdView4, "empty server response (no ads)");
    }
    WebView localWebView10 = this.view;
    StartTimer(localContext2, localWebView10);
  }

  public void setSite(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setSite(paramInteger);
  }

  public void setTest(Boolean paramBoolean)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setTestModeEnabled(paramBoolean);
  }

  public void setTextColor(int paramInt)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest1 = this.adserverRequest;
    Integer localInteger = Integer.valueOf(paramInt);
    AdserverRequest localAdserverRequest2 = localAdserverRequest1.setParamLINK(localInteger);
  }

  public void setTrack(Boolean paramBoolean)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setTrack(paramBoolean);
  }

  public void setType(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setType(paramInteger);
  }

  public void setUpdateTime(Integer paramInteger)
  {
    if (paramInteger == null)
      return;
    MASTAdLog localMASTAdLog = this.adLog;
    String str = String.valueOf(paramInteger);
    localMASTAdLog.log(2, 3, "setUpdateTime", str);
    long l = paramInteger.intValue() * 1000;
    Long localLong = new Long(l);
    this.adReloadPeriod = localLong;
    update(false);
  }

  public void setUseSystemDeviceId(boolean paramBoolean)
  {
    ContentManager.getInstance(this).setUseSystemDeviceId(paramBoolean);
  }

  public void setZip(String paramString)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setZip(paramString);
  }

  public void setZone(Integer paramInteger)
  {
    if (this.adserverRequest == null)
      return;
    AdserverRequest localAdserverRequest = this.adserverRequest.setZone(paramInteger);
  }

  public void showAdView()
  {
    boolean bool = this.handler.sendEmptyMessage(1003);
  }

  public void update()
  {
    if (this.reloadTimer == null)
    {
      Timer localTimer = new Timer();
      this.reloadTimer = localTimer;
    }
    update(true);
  }

  public void useCloseButton(final boolean paramBoolean)
  {
    Handler localHandler = this.handler;
    Runnable local6 = new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          MASTAdViewCore.this.buttonClose.setVisibility(0);
          return;
        }
        MASTAdViewCore.this.buttonClose.setBackgroundColor(0);
        MASTAdViewCore.this.buttonClose.setVisibility(0);
      }
    };
    boolean bool = localHandler.post(local6);
  }

  private static enum ACTION
  {
    static
    {
      ACTION[] arrayOfACTION = new ACTION[2];
      ACTION localACTION1 = PLAY_AUDIO;
      arrayOfACTION[0] = localACTION1;
      ACTION localACTION2 = PLAY_VIDEO;
      arrayOfACTION[1] = localACTION2;
    }
  }

  private class AdWebViewClient extends WebViewClient
  {
    private Context context;

    public AdWebViewClient(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    protected void defaultOnAdClickHandler(MASTAdView paramMASTAdView, String paramString)
    {
      Context localContext = paramMASTAdView.getContext();
      int i = localContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
      if (i == 0)
      {
        if (MASTAdViewCore.this.isInternetAvailable(localContext))
        {
          MASTAdViewCore.this.openUrlInExternalBrowser(localContext, paramString);
          return;
        }
        Toast.makeText(localContext, "Internet is not available", 1).show();
        return;
      }
      if (i != -1)
        return;
      MASTAdViewCore.this.openUrlInExternalBrowser(localContext, paramString);
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      ((MASTAdViewCore)paramWebView).onPageFinished();
      if (MASTAdViewCore.this.isAutoCollapse)
        MASTAdViewCore.this.setAdVisibility(0);
      if (MASTAdViewCore.this.adDownload == null)
        return;
      MASTAdViewCore.MASTOnAdDownload localMASTOnAdDownload = MASTAdViewCore.this.adDownload;
      MASTAdView localMASTAdView = (MASTAdView)paramWebView;
      localMASTOnAdDownload.end(localMASTAdView);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (MASTAdViewCore.this.mDisplayController == null)
        return;
      MASTAdViewCore.this.mDisplayController.setDefaultPosition();
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (MASTAdViewCore.this.adDownload == null)
        return;
      MASTAdViewCore.MASTOnAdDownload localMASTOnAdDownload = MASTAdViewCore.this.adDownload;
      MASTAdView localMASTAdView = (MASTAdView)paramWebView;
      localMASTOnAdDownload.error(localMASTAdView, paramString1);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      try
      {
        MASTAdViewCore.this.adLog.log(2, 3, "OverrideUrlLoading", paramString);
        if (MASTAdViewCore.this.adClickListener != null)
        {
          MASTAdViewCore.MASTOnAdClickListener localMASTOnAdClickListener = MASTAdViewCore.this.adClickListener;
          MASTAdView localMASTAdView1 = (MASTAdView)paramWebView;
          if (!localMASTOnAdClickListener.click(localMASTAdView1, paramString))
          {
            MASTAdView localMASTAdView2 = (MASTAdView)paramWebView;
            defaultOnAdClickHandler(localMASTAdView2, paramString);
          }
        }
        while (true)
        {
          return true;
          MASTAdView localMASTAdView3 = (MASTAdView)paramWebView;
          defaultOnAdClickHandler(localMASTAdView3, paramString);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          MASTAdLog localMASTAdLog = MASTAdViewCore.this.adLog;
          String str = localException.getMessage();
          localMASTAdLog.log(1, 1, "shouldOverrideUrlLoading", str);
        }
      }
    }
  }

  private class InterceptOnAdDownload
    implements MASTAdViewCore.MASTOnAdDownload
  {
    String campaignId = null;
    int childCount;
    private Context context;
    private WebView view;

    public InterceptOnAdDownload(Context paramWebView, WebView arg3)
    {
      this.context = paramWebView;
      Object localObject;
      this.view = localObject;
      int i = localObject.getChildCount();
      this.childCount = i;
    }

    public void SetCampaingId(String paramString)
    {
      this.campaignId = paramString;
    }

    public void begin(MASTAdView paramMASTAdView)
    {
      if (MASTAdViewCore.this.adDownload == null)
        return;
      MASTAdViewCore.this.adDownload.begin(paramMASTAdView);
    }

    public void end(MASTAdView paramMASTAdView)
    {
      MASTAdViewCore.this.loadWebViewContent(null, "", null);
      MASTAdViewCore localMASTAdViewCore = MASTAdViewCore.this;
      Context localContext = this.context;
      WebView localWebView = this.view;
      localMASTAdViewCore.StartTimer(localContext, localWebView);
      if (MASTAdViewCore.this.adDownload == null)
        return;
      MASTAdViewCore.this.adDownload.end(paramMASTAdView);
    }

    public void error(MASTAdView paramMASTAdView, String paramString)
    {
      if (this.campaignId != null)
      {
        MASTAdViewCore localMASTAdViewCore1 = MASTAdViewCore.this;
        String str = this.campaignId;
        Context localContext1 = this.context;
        WebView localWebView1 = this.view;
        localMASTAdViewCore1.RestartExcampaings(str, localContext1, localWebView1);
      }
      while (true)
      {
        if (MASTAdViewCore.this.adDownload == null)
          return;
        MASTAdViewCore.this.adDownload.error(paramMASTAdView, paramString);
        return;
        MASTAdViewCore localMASTAdViewCore2 = MASTAdViewCore.this;
        Context localContext2 = this.context;
        WebView localWebView2 = this.view;
        localMASTAdViewCore2.StartTimer(localContext2, localWebView2);
      }
    }
  }

  public static abstract interface MASTOnActivityHandler
  {
    public abstract void onAttachedToActivity(MASTAdView paramMASTAdView);

    public abstract void onDetachedFromActivity(MASTAdView paramMASTAdView);
  }

  public static abstract interface MASTOnAdClickListener
  {
    public abstract boolean click(MASTAdView paramMASTAdView, String paramString);
  }

  public static abstract interface MASTOnAdDownload
  {
    public abstract void begin(MASTAdView paramMASTAdView);

    public abstract void end(MASTAdView paramMASTAdView);

    public abstract void error(MASTAdView paramMASTAdView, String paramString);
  }

  public static abstract interface MASTOnOrmmaListener
  {
    public abstract void event(MASTAdView paramMASTAdView, String paramString1, String paramString2);
  }

  public static abstract interface MASTOnThirdPartyRequest
  {
    public abstract void event(MASTAdView paramMASTAdView, HashMap<String, String> paramHashMap);
  }

  private class OpenUrlThread extends Thread
  {
    MASTAdViewCore ad;
    Context context;
    String url;

    public OpenUrlThread(Context paramMASTAdViewCore, MASTAdViewCore paramString, String arg4)
    {
      this.ad = paramString;
      this.context = paramMASTAdViewCore;
      Object localObject;
      this.url = localObject;
    }

    public void run()
    {
      MASTAdViewCore localMASTAdViewCore = this.ad;
      Context localContext = this.context;
      String str = this.url;
      localMASTAdViewCore._openUrlInExternalBrowser(localContext, str);
    }
  }

  private class ReloadTask extends TimerTask
  {
    private Context context;
    private WebView view;

    public ReloadTask(Context paramWebView, WebView arg3)
    {
      this.context = paramWebView;
      Object localObject;
      this.view = localObject;
    }

    public void run()
    {
      MASTAdViewCore localMASTAdViewCore = MASTAdViewCore.this;
      Context localContext = this.context;
      WebView localWebView = this.view;
      localMASTAdViewCore.StartLoadContent(localContext, localWebView);
    }
  }

  private class RemoveAllChildViews
    implements Runnable
  {
    private ViewGroup view;

    public RemoveAllChildViews(ViewGroup arg2)
    {
      Object localObject;
      this.view = localObject;
    }

    public void run()
    {
    }
  }

  private class SetBackgroundResourceAction
    implements Runnable
  {
    private Integer backgroundResource;
    private WebView view;

    public SetBackgroundResourceAction(WebView paramInteger, Integer arg3)
    {
      this.view = paramInteger;
      Object localObject;
      this.backgroundResource = localObject;
    }

    public void run()
    {
      try
      {
        if (this.backgroundResource == null)
          return;
        WebView localWebView = this.view;
        int i = this.backgroundResource.intValue();
        localWebView.setBackgroundResource(i);
        this.view.setBackgroundColor(0);
        return;
      }
      catch (Exception localException)
      {
        MASTAdLog localMASTAdLog = MASTAdViewCore.this.adLog;
        String str = localException.getMessage();
        localMASTAdLog.log(1, 1, "SetBackgroundResourceAction", str);
      }
    }
  }

  private class SetupOrmmaAudioPlayer
    implements Runnable
  {
    private Bundle data;

    public SetupOrmmaAudioPlayer(Bundle arg2)
    {
      Object localObject;
      this.data = localObject;
    }

    public void run()
    {
      try
      {
        if (MASTAdViewCore.this.isShowMediaPlayerFrame)
          return;
        if (MASTAdViewCore.mediaPlayerFrame != null)
        {
          ViewGroup localViewGroup1 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
          ViewGroup localViewGroup2 = MASTAdViewCore.mediaPlayerFrame;
          localViewGroup1.removeView(localViewGroup2);
        }
        OrmmaController.PlayerProperties localPlayerProperties = (OrmmaController.PlayerProperties)this.data.getParcelable("player_properties");
        String str = this.data.getString("expand_url");
        final OrmmaPlayer localOrmmaPlayer = MASTAdViewCore.this.getPlayer();
        localOrmmaPlayer.setPlayData(localPlayerProperties, str);
        int i = ((Activity)MASTAdViewCore.this.getContext()).getWindow().findViewById(16908290).getTop();
        Context localContext1 = MASTAdViewCore.this.getContext();
        MASTAdViewCore.mediaPlayerFrame = new RelativeLayout(localContext1);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        MASTAdViewCore.mediaPlayerFrame.setPadding(0, i, 0, 0);
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            MASTAdViewCore.this.isShowMediaPlayerFrame = false;
            if (MASTAdViewCore.mediaPlayerFrame == null)
              return;
            ViewGroup localViewGroup1 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
            ViewGroup localViewGroup2 = MASTAdViewCore.mediaPlayerFrame;
            localViewGroup1.removeView(localViewGroup2);
          }
        };
        localOrmmaPlayer.setOnCompletionRunnable(local1);
        localOrmmaPlayer.setOnErrorRunnable(local1);
        Context localContext2 = MASTAdViewCore.this.getContext();
        Button localButton = new Button(localContext2);
        StateListDrawable localStateListDrawable = Utils.GetSelector(MASTAdViewCore.this.getContext(), "b_close.png", "b_close.png", "b_close.png");
        localButton.setBackgroundDrawable(localStateListDrawable);
        ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParamsByDrawableSize("b_close.png");
        localButton.setLayoutParams(localLayoutParams1);
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Handler localHandler = MASTAdViewCore.this.handler;
            final OrmmaPlayer localOrmmaPlayer = localOrmmaPlayer;
            Runnable local1 = new Runnable()
            {
              public void run()
              {
                MASTAdViewCore.this.isShowMediaPlayerFrame = false;
                localOrmmaPlayer.releasePlayer();
                if (MASTAdViewCore.mediaPlayerFrame == null)
                  return;
                ViewGroup localViewGroup1 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
                ViewGroup localViewGroup2 = MASTAdViewCore.mediaPlayerFrame;
                localViewGroup1.removeView(localViewGroup2);
              }
            };
            boolean bool = localHandler.post(local1);
          }
        };
        localButton.setOnClickListener(local2);
        Context localContext3 = MASTAdViewCore.this.getContext();
        LinearLayout localLinearLayout1 = new LinearLayout(localContext3);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout1.setLayoutParams(localLayoutParams2);
        localLinearLayout1.setGravity(5);
        localLinearLayout1.addView(localButton);
        Context localContext4 = MASTAdViewCore.this.getContext();
        ImageView localImageView = new ImageView(localContext4);
        Drawable localDrawable = Utils.GetDrawable(MASTAdViewCore.this.getContext(), "note.png");
        localImageView.setImageDrawable(localDrawable);
        LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        localImageView.setLayoutParams(localLayoutParams3);
        Context localContext5 = MASTAdViewCore.this.getContext();
        LinearLayout localLinearLayout2 = new LinearLayout(localContext5);
        LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout2.setLayoutParams(localLayoutParams4);
        localLinearLayout2.setGravity(17);
        localLinearLayout2.addView(localImageView);
        LinearLayout.LayoutParams localLayoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        localOrmmaPlayer.setLayoutParams(localLayoutParams5);
        MASTAdViewCore.mediaPlayerFrame.addView(localOrmmaPlayer);
        MASTAdViewCore.mediaPlayerFrame.addView(localLinearLayout2);
        MASTAdViewCore.mediaPlayerFrame.addView(localLinearLayout1);
        ViewGroup localViewGroup3 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
        ViewGroup localViewGroup4 = MASTAdViewCore.mediaPlayerFrame;
        localViewGroup3.addView(localViewGroup4, localLayoutParams);
        ViewGroup localViewGroup5 = MASTAdViewCore.mediaPlayerFrame;
        View.OnTouchListener local3 = new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        };
        localViewGroup5.setOnTouchListener(local3);
        localOrmmaPlayer.playAudio();
        MASTAdViewCore.this.isShowMediaPlayerFrame = true;
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private class SetupOrmmaPlayer
    implements Runnable
  {
    private Bundle data;
    private WebView view;

    public SetupOrmmaPlayer(WebView paramBundle, Bundle arg3)
    {
      this.view = paramBundle;
      Object localObject;
      this.data = localObject;
    }

    public void run()
    {
      try
      {
        if (MASTAdViewCore.this.isShowMediaPlayerFrame)
          return;
        if (MASTAdViewCore.mediaPlayerFrame != null)
        {
          ViewGroup localViewGroup1 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
          ViewGroup localViewGroup2 = MASTAdViewCore.mediaPlayerFrame;
          localViewGroup1.removeView(localViewGroup2);
        }
        OrmmaController.PlayerProperties localPlayerProperties = (OrmmaController.PlayerProperties)this.data.getParcelable("player_properties");
        String str = this.data.getString("expand_url");
        final OrmmaPlayer localOrmmaPlayer = MASTAdViewCore.this.getPlayer();
        localOrmmaPlayer.setPlayData(localPlayerProperties, str);
        int i = ((Activity)MASTAdViewCore.this.getContext()).getWindow().findViewById(16908290).getTop();
        Context localContext1 = MASTAdViewCore.this.getContext();
        MASTAdViewCore.mediaPlayerFrame = new RelativeLayout(localContext1);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        MASTAdViewCore.mediaPlayerFrame.setPadding(0, i, 0, 0);
        MASTAdViewCore.mediaPlayerFrame.setBackgroundColor(-16777216);
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            MASTAdViewCore.this.isShowMediaPlayerFrame = false;
            if (MASTAdViewCore.mediaPlayerFrame == null)
              return;
            ViewGroup localViewGroup1 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
            ViewGroup localViewGroup2 = MASTAdViewCore.mediaPlayerFrame;
            localViewGroup1.removeView(localViewGroup2);
          }
        };
        localOrmmaPlayer.setOnCompletionRunnable(local1);
        localOrmmaPlayer.setOnErrorRunnable(local1);
        Context localContext2 = MASTAdViewCore.this.getContext();
        Button localButton = new Button(localContext2);
        StateListDrawable localStateListDrawable = Utils.GetSelector(MASTAdViewCore.this.getContext(), "b_close.png", "b_close.png", "b_close.png");
        localButton.setBackgroundDrawable(localStateListDrawable);
        ViewGroup.LayoutParams localLayoutParams1 = MASTAdViewCore.this.getLayoutParamsByDrawableSize("b_close.png");
        localButton.setLayoutParams(localLayoutParams1);
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Handler localHandler = MASTAdViewCore.this.handler;
            final OrmmaPlayer localOrmmaPlayer = localOrmmaPlayer;
            Runnable local1 = new Runnable()
            {
              public void run()
              {
                MASTAdViewCore.this.isShowMediaPlayerFrame = false;
                localOrmmaPlayer.releasePlayer();
                if (MASTAdViewCore.mediaPlayerFrame == null)
                  return;
                ViewGroup localViewGroup1 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
                ViewGroup localViewGroup2 = MASTAdViewCore.mediaPlayerFrame;
                localViewGroup1.removeView(localViewGroup2);
              }
            };
            boolean bool = localHandler.post(local1);
          }
        };
        localButton.setOnClickListener(local2);
        Context localContext3 = MASTAdViewCore.this.getContext();
        LinearLayout localLinearLayout1 = new LinearLayout(localContext3);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout1.setLayoutParams(localLayoutParams2);
        localLinearLayout1.setGravity(5);
        localLinearLayout1.addView(localButton);
        LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        localOrmmaPlayer.setLayoutParams(localLayoutParams3);
        Context localContext4 = MASTAdViewCore.this.getContext();
        LinearLayout localLinearLayout2 = new LinearLayout(localContext4);
        LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout2.setLayoutParams(localLayoutParams4);
        localLinearLayout2.setGravity(17);
        localLinearLayout2.addView(localOrmmaPlayer);
        MASTAdViewCore.mediaPlayerFrame.addView(localLinearLayout2);
        MASTAdViewCore.mediaPlayerFrame.addView(localLinearLayout1);
        ViewGroup localViewGroup3 = (ViewGroup)((Activity)MASTAdViewCore.this.getContext()).getWindow().getDecorView();
        ViewGroup localViewGroup4 = MASTAdViewCore.mediaPlayerFrame;
        localViewGroup3.addView(localViewGroup4, localLayoutParams);
        ViewGroup localViewGroup5 = MASTAdViewCore.mediaPlayerFrame;
        View.OnTouchListener local3 = new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        };
        localViewGroup5.setOnTouchListener(local3);
        localOrmmaPlayer.playVideo();
        MASTAdViewCore.this.isShowMediaPlayerFrame = true;
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private class SetupVideoAction
    implements Runnable
  {
    private String clickUrl;
    private Context context;
    private String url;
    private WebView view;

    public SetupVideoAction(Context paramWebView, WebView paramString1, String paramString2, String arg5)
    {
      this.context = paramWebView;
      this.view = paramString1;
      this.url = paramString2;
      Object localObject;
      this.clickUrl = localObject;
    }

    public void run()
    {
      try
      {
        if (this.url == null)
          return;
        if (this.url.length() <= 0)
          return;
        Context localContext1 = this.context;
        VideoView localVideoView = new VideoView(localContext1);
        ViewGroup.LayoutParams localLayoutParams = this.view.getLayoutParams();
        localVideoView.setLayoutParams(localLayoutParams);
        Context localContext2 = this.context;
        MediaController localMediaController = new MediaController(localContext2);
        localVideoView.setMediaController(localMediaController);
        Uri localUri = Uri.parse(this.url);
        localVideoView.setVideoURI(localUri);
        MediaPlayer.OnCompletionListener local1 = new MediaPlayer.OnCompletionListener()
        {
          public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            try
            {
              paramAnonymousMediaPlayer.seekTo(0);
              paramAnonymousMediaPlayer.start();
              return;
            }
            catch (Exception localException)
            {
              MASTAdLog localMASTAdLog = MASTAdViewCore.this.adLog;
              String str = localException.getMessage();
              localMASTAdLog.log(1, 1, "SetupVideoAction", str);
            }
          }
        };
        localVideoView.setOnCompletionListener(local1);
        MediaPlayer.OnErrorListener local2 = new MediaPlayer.OnErrorListener()
        {
          public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            MASTAdLog localMASTAdLog = MASTAdViewCore.this.adLog;
            StringBuilder localStringBuilder1 = new StringBuilder("what=");
            String str1 = String.valueOf(paramAnonymousInt1);
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(";extra=");
            String str2 = String.valueOf(paramAnonymousInt2);
            String str3 = str2;
            localMASTAdLog.log(1, 1, "Play video", str3);
            return true;
          }
        };
        localVideoView.setOnErrorListener(local2);
        if ((this.clickUrl != null) && (this.clickUrl.length() > 0))
        {
          View.OnClickListener local3 = new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              MASTAdViewCore localMASTAdViewCore = MASTAdViewCore.this;
              Context localContext = MASTAdViewCore.SetupVideoAction.this.context;
              String str = MASTAdViewCore.SetupVideoAction.this.clickUrl;
              localMASTAdViewCore.openUrlInExternalBrowser(localContext, str);
            }
          };
          localVideoView.setOnClickListener(local3);
          View.OnTouchListener local4 = new View.OnTouchListener()
          {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              if (paramAnonymousMotionEvent.getAction() == 0)
              {
                MASTAdViewCore localMASTAdViewCore = MASTAdViewCore.this;
                Context localContext = MASTAdViewCore.SetupVideoAction.this.context;
                String str = MASTAdViewCore.SetupVideoAction.this.clickUrl;
                localMASTAdViewCore.openUrlInExternalBrowser(localContext, str);
              }
              return false;
            }
          };
          localVideoView.setOnTouchListener(local4);
        }
        this.view.addView(localVideoView);
        localVideoView.start();
        this.view.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private static enum ViewState
  {
    static
    {
      EXPANDED = new ViewState("EXPANDED", 2);
      HIDDEN = new ViewState("HIDDEN", 3);
      ViewState[] arrayOfViewState = new ViewState[4];
      ViewState localViewState1 = DEFAULT;
      arrayOfViewState[0] = localViewState1;
      ViewState localViewState2 = RESIZED;
      arrayOfViewState[1] = localViewState2;
      ViewState localViewState3 = EXPANDED;
      arrayOfViewState[2] = localViewState3;
      ViewState localViewState4 = HIDDEN;
      arrayOfViewState[3] = localViewState4;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.MASTAdViewCore
 * JD-Core Version:    0.6.2
 */