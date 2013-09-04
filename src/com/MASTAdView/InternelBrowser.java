package com.MASTAdView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.io.IOException;

public class InternelBrowser extends Dialog
{
  int ID_BOTTOM = 3;
  int ID_MAIN = 1;
  int ID_WEB = 2;
  Context _context;
  Button buttonBack;
  Button buttonForward;
  Button buttonOpen;
  Button buttonRefresh;
  Button buttonStopRefresh;
  Dialog thisDialog = this;
  WebView webView;

  public InternelBrowser(Context paramContext, String paramString)
  {
    super(paramContext);
    this._context = paramContext;
    boolean bool = requestWindowFeature(1);
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    int i = this.ID_MAIN;
    localLinearLayout1.setId(i);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    localLinearLayout1.setLayoutParams(localLayoutParams);
    localLinearLayout1.setOrientation(1);
    WebView localWebView1 = new WebView(paramContext);
    this.webView = localWebView1;
    WebView localWebView2 = this.webView;
    int j = this.ID_WEB;
    localWebView2.setId(j);
    WebView localWebView3 = this.webView;
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localWebView3.setLayoutParams(localLayoutParams1);
    this.webView.loadUrl(paramString);
    this.webView.getSettings().setJavaScriptEnabled(true);
    this.webView.getSettings().setBuiltInZoomControls(true);
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout1.setOrientation(1);
    int k = this.ID_BOTTOM;
    localLinearLayout2.setId(k);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1, 0.0F);
    localLinearLayout2.setLayoutParams(localLayoutParams2);
    localLinearLayout2.setOrientation(0);
    Drawable localDrawable = GetDrawable(this._context, "ib_bg_down.png");
    localLinearLayout2.setBackgroundDrawable(localDrawable);
    Button localButton1 = AddButton(localLinearLayout2, "ib_arrow_left_regular.png", "ib_arrow_left_press.png", "ib_arrow_left_disabled.png");
    this.buttonBack = localButton1;
    Button localButton2 = AddButton(localLinearLayout2, "ib_arrow_right_regular.png", "ib_arrow_right_press.png", "ib_arrow_right_disabled.png");
    this.buttonForward = localButton2;
    Button localButton3 = AddButton(localLinearLayout2, "ib_apdate_regular.png", "ib_apdate_press.png", null, true);
    this.buttonRefresh = localButton3;
    Button localButton4 = AddButton(localLinearLayout2, "ib_window_regular.png", "ib_window_press.png", null);
    this.buttonOpen = localButton4;
    WebView localWebView4 = this.webView;
    localLinearLayout1.addView(localWebView4);
    localLinearLayout1.addView(localLinearLayout2);
    setContentView(localLinearLayout1);
    getWindow().setLayout(-1, -1);
    getWindow().setBackgroundDrawable(null);
    Button localButton5 = this.buttonBack;
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InternelBrowser.this.webView.goBack();
        InternelBrowser.this.UpdateButtons();
      }
    };
    localButton5.setOnClickListener(local1);
    Button localButton6 = this.buttonForward;
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InternelBrowser.this.webView.goForward();
        InternelBrowser.this.UpdateButtons();
      }
    };
    localButton6.setOnClickListener(local2);
    Button localButton7 = this.buttonRefresh;
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InternelBrowser.this.webView.reload();
      }
    };
    localButton7.setOnClickListener(local3);
    Button localButton8 = this.buttonOpen;
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          Uri localUri = Uri.parse(InternelBrowser.this.webView.getUrl());
          Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
          InternelBrowser.this._context.startActivity(localIntent);
          label36: InternelBrowser.this.thisDialog.dismiss();
          return;
        }
        catch (Exception localException)
        {
          break label36;
        }
      }
    };
    localButton8.setOnClickListener(local4);
    Button localButton9 = this.buttonStopRefresh;
    View.OnClickListener local5 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InternelBrowser.this.webView.stopLoading();
      }
    };
    localButton9.setOnClickListener(local5);
    WebView localWebView5 = this.webView;
    WebViewClient local6 = new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        InternelBrowser.this.buttonRefresh.setVisibility(0);
        InternelBrowser.this.buttonStopRefresh.setVisibility(8);
        InternelBrowser.this.UpdateButtons();
      }

      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        InternelBrowser.this.buttonRefresh.setVisibility(8);
        InternelBrowser.this.buttonStopRefresh.setVisibility(0);
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        return true;
      }
    };
    localWebView5.setWebViewClient(local6);
    UpdateButtons();
  }

  public static Drawable GetDrawable(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      Drawable localDrawable = Drawable.createFromStream(paramContext.getAssets().open(paramString), null);
      localObject = localDrawable;
      label17: return localObject;
    }
    catch (IOException localIOException)
    {
      break label17;
    }
  }

  public static StateListDrawable GetSelector(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    int[] arrayOfInt1 = { -16842919, 16842910 };
    Drawable localDrawable1 = GetDrawable(paramContext, paramString1);
    localStateListDrawable.addState(arrayOfInt1, localDrawable1);
    if (paramString2 != null)
    {
      int[] arrayOfInt2 = { 16842919, 16842910 };
      Drawable localDrawable2 = GetDrawable(paramContext, paramString2);
      localStateListDrawable.addState(arrayOfInt2, localDrawable2);
    }
    if (paramString3 != null)
    {
      int[] arrayOfInt3 = new int[1];
      arrayOfInt3[0] = -16842910;
      Drawable localDrawable3 = GetDrawable(paramContext, paramString3);
      localStateListDrawable.addState(arrayOfInt3, localDrawable3);
    }
    while (true)
    {
      return localStateListDrawable;
      int[] arrayOfInt4 = new int[1];
      arrayOfInt4[0] = -16842910;
      Drawable localDrawable4 = GetDrawable(paramContext, paramString1);
      localStateListDrawable.addState(arrayOfInt4, localDrawable4);
    }
  }

  Button AddButton(LinearLayout paramLinearLayout, String paramString1, String paramString2, String paramString3)
  {
    InternelBrowser localInternelBrowser = this;
    LinearLayout localLinearLayout = paramLinearLayout;
    String str1 = paramString1;
    String str2 = paramString2;
    String str3 = paramString3;
    return localInternelBrowser.AddButton(localLinearLayout, str1, str2, str3, false);
  }

  Button AddButton(LinearLayout paramLinearLayout, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Context localContext1 = this._context;
    Button localButton1 = new Button(localContext1);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
    localButton1.setLayoutParams(localLayoutParams1);
    StateListDrawable localStateListDrawable1 = GetSelector(this._context, paramString1, paramString2, paramString3);
    localButton1.setBackgroundDrawable(localStateListDrawable1);
    Context localContext2 = this._context;
    LinearLayout localLinearLayout = new LinearLayout(localContext2);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLinearLayout.setLayoutParams(localLayoutParams2);
    localLinearLayout.setGravity(17);
    localLinearLayout.addView(localButton1);
    if (paramBoolean)
    {
      Context localContext3 = this._context;
      Button localButton2 = new Button(localContext3);
      this.buttonStopRefresh = localButton2;
      Button localButton3 = this.buttonStopRefresh;
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -1);
      localButton3.setLayoutParams(localLayoutParams3);
      Button localButton4 = this.buttonStopRefresh;
      StateListDrawable localStateListDrawable2 = GetSelector(this._context, "ib_close_regular.png", "ib_close_press.png", null);
      localButton4.setBackgroundDrawable(localStateListDrawable2);
      Button localButton5 = this.buttonStopRefresh;
      localLinearLayout.addView(localButton5);
      this.buttonStopRefresh.setVisibility(8);
    }
    paramLinearLayout.addView(localLinearLayout);
    return localButton1;
  }

  void UpdateButtons()
  {
    Button localButton1 = this.buttonBack;
    boolean bool1 = this.webView.canGoBack();
    localButton1.setEnabled(bool1);
    Button localButton2 = this.buttonForward;
    boolean bool2 = this.webView.canGoForward();
    localButton2.setEnabled(bool2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.InternelBrowser
 * JD-Core Version:    0.6.2
 */