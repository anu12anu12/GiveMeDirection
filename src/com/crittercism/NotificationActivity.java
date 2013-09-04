package com.crittercism;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.crittercism.app.Crittercism;
import crittercism.android.a;
import crittercism.android.d;
import java.lang.reflect.Method;

public class NotificationActivity extends Activity
  implements View.OnClickListener, View.OnTouchListener
{
  private static Method c;
  WebView a;
  ProgressDialog b;

  static
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      Class localClass = Boolean.TYPE;
      arrayOfClass[0] = localClass;
      c = WebView.class.getMethod("setDomStorageEnabled", arrayOfClass);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
  }

  public void onClick(View paramView)
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("com.crittercism.notification")))
    {
      setTheme(16973835);
      boolean bool = requestWindowFeature(1);
      String str1 = localBundle.getString("com.crittercism.notification");
      Crittercism localCrittercism = Crittercism.a();
      LinearLayout localLinearLayout = new LinearLayout(this);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(0);
      int i = localCrittercism.e();
      localLinearLayout.setPadding(i, i, i, i);
      localLinearLayout.setId(13);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout.setOnTouchListener(this);
      ImageView localImageView = new ImageView(this);
      localImageView.setId(52);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
      int j = localCrittercism.e();
      localLayoutParams2.setMargins(0, 0, j, 0);
      localImageView.setLayoutParams(localLayoutParams2);
      BitmapDrawable localBitmapDrawable = a.a();
      localImageView.setImageDrawable(localBitmapDrawable);
      TextView localTextView = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -1);
      int k = localCrittercism.e();
      localLayoutParams3.setMargins(0, 0, k, 0);
      localTextView.setLayoutParams(localLayoutParams3);
      localTextView.setTextSize(16.0F);
      localTextView.setTextColor(-1);
      localTextView.setId(51);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str2 = Crittercism.a().b();
      String str3 = str2 + ": " + str1;
      localTextView.setText(str3);
      localLinearLayout.addView(localImageView);
      localLinearLayout.addView(localTextView);
      setContentView(localLinearLayout);
      return;
    }
    if (localBundle == null)
      return;
    if (!localBundle.containsKey("com.crittercism.about_us"))
      return;
    WebView localWebView1 = new WebView(this);
    this.a = localWebView1;
    this.a.getSettings().setJavaScriptEnabled(true);
    if (c != null);
    try
    {
      Method localMethod = c;
      Object[] arrayOfObject = new Object[1];
      Boolean localBoolean = Boolean.valueOf(true);
      arrayOfObject[0] = localBoolean;
      Object localObject = localMethod.invoke(null, arrayOfObject);
      label408: WebView localWebView2 = this.a;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str4 = d.a();
      String str5 = str4 + "/mobile/about_android";
      localWebView2.loadUrl(str5);
      WebView localWebView3 = this.a;
      WebViewClient local1 = new WebViewClient()
      {
        public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          if (NotificationActivity.this.b == null)
            return;
          if (!NotificationActivity.this.b.isShowing())
            return;
          NotificationActivity.this.b.hide();
          NotificationActivity.this.b.dismiss();
        }
      };
      localWebView3.setWebViewClient(local1);
      WebView localWebView4 = this.a;
      NotificationJavascriptInterface localNotificationJavascriptInterface = new NotificationJavascriptInterface();
      localWebView4.addJavascriptInterface(localNotificationJavascriptInterface, "interface");
      WebView localWebView5 = this.a;
      setContentView(localWebView5);
      String str6 = a.a(29);
      ProgressDialog localProgressDialog = ProgressDialog.show(this, "", str6, true);
      this.b = localProgressDialog;
      return;
    }
    catch (Exception localException)
    {
      break label408;
    }
  }

  protected void onPause()
  {
    if (this.b != null)
    {
      this.b.hide();
      this.b.dismiss();
    }
    super.onPause();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    finish();
    return true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crittercism.NotificationActivity
 * JD-Core Version:    0.6.2
 */