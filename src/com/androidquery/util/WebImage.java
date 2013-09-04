package com.androidquery.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Picture;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;

public class WebImage extends WebViewClient
{
  private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
  private static final String PREF_FILE = "WebViewSettings";
  private static String template;
  private int color;
  private boolean control;
  private Object progress;
  private String url;
  private WebView wv;
  private boolean zoom;

  public WebImage(WebView paramWebView, String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.wv = paramWebView;
    this.url = paramString;
    this.progress = paramObject;
    this.zoom = paramBoolean1;
    this.control = paramBoolean2;
    this.color = paramInt;
  }

  private void delaySetup()
  {
    WebView localWebView1 = this.wv;
    WebView.PictureListener local1 = new WebView.PictureListener()
    {
      public void onNewPicture(WebView paramAnonymousWebView, Picture paramAnonymousPicture)
      {
        WebImage.this.wv.setPictureListener(null);
        WebImage.this.setup();
      }
    };
    localWebView1.setPictureListener(local1);
    this.wv.loadData("<html></html>", "text/html", "utf-8");
    WebView localWebView2 = this.wv;
    int i = this.color;
    localWebView2.setBackgroundColor(i);
  }

  private static void disableZoomControl(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT < 11)
      return;
    WebSettings localWebSettings = paramWebView.getSettings();
    Class[] arrayOfClass = new Class[1];
    Class localClass = Boolean.TYPE;
    arrayOfClass[0] = localClass;
    Object[] arrayOfObject = new Object[1];
    Boolean localBoolean = Boolean.valueOf(false);
    arrayOfObject[0] = localBoolean;
    boolean bool = false;
    Object localObject = AQUtility.invokeHandler(localWebSettings, "setDisplayZoomControls", false, bool, arrayOfClass, arrayOfObject);
  }

  private void done(WebView paramWebView)
  {
    if (this.progress != null)
    {
      paramWebView.setVisibility(0);
      Object localObject = this.progress;
      String str = this.url;
      Common.showProgress(localObject, str, false);
    }
    paramWebView.setWebViewClient(null);
  }

  private static void fixWebviewTip(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("WebViewSettings", 0);
    if (localSharedPreferences.getInt("double_tap_toast_count", 1) <= 0)
      return;
    boolean bool = localSharedPreferences.edit().putInt("double_tap_toast_count", 0).commit();
  }

  private static String getSource(Context paramContext)
  {
    if (template == null);
    try
    {
      byte[] arrayOfByte = AQUtility.toBytes(paramContext.getClassLoader().getResourceAsStream("com/androidquery/util/web_image.html"));
      template = new String(arrayOfByte);
      return template;
    }
    catch (Exception localException)
    {
      while (true)
        AQUtility.debug(localException);
    }
  }

  private void setup()
  {
    String str1 = getSource(this.wv.getContext());
    String str2 = this.url;
    String str3 = str1.replace("@src", str2);
    String str4 = Integer.toHexString(this.color);
    String str5 = str3.replace("@color", str4);
    this.wv.setWebViewClient(this);
    WebView localWebView1 = this.wv;
    String str6 = null;
    localWebView1.loadDataWithBaseURL(null, str5, "text/html", "utf-8", str6);
    WebView localWebView2 = this.wv;
    int i = this.color;
    localWebView2.setBackgroundColor(i);
  }

  public void load()
  {
    String str1 = this.url;
    Object localObject1 = this.wv.getTag(1090453505);
    if (str1.equals(localObject1))
      return;
    WebView localWebView1 = this.wv;
    String str2 = this.url;
    localWebView1.setTag(1090453505, str2);
    if (Build.VERSION.SDK_INT <= 10)
      this.wv.setDrawingCacheEnabled(true);
    fixWebviewTip(this.wv.getContext());
    WebSettings localWebSettings = this.wv.getSettings();
    boolean bool1 = this.zoom;
    localWebSettings.setSupportZoom(bool1);
    boolean bool2 = this.zoom;
    localWebSettings.setBuiltInZoomControls(bool2);
    if (!this.control)
      disableZoomControl(this.wv);
    localWebSettings.setJavaScriptEnabled(true);
    WebView localWebView2 = this.wv;
    int i = this.color;
    localWebView2.setBackgroundColor(i);
    if (this.progress != null)
    {
      Object localObject2 = this.progress;
      String str3 = this.url;
      Common.showProgress(localObject2, str3, true);
    }
    if (this.wv.getWidth() > 0)
    {
      setup();
      return;
    }
    delaySetup();
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    done(paramWebView);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    done(paramWebView);
  }

  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.WebImage
 * JD-Core Version:    0.6.2
 */