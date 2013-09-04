package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends Activity
  implements View.OnClickListener
{
  private static volatile String a = "<html><body><table height='100%' width='100%' border='0'><tr><td style='vertical-align:middle;text-align:center'>No recommendations available<p><button type='input' onClick='activity.finish()'>Back</button></td></tr></table></body></html>";
  private WebView b;
  private x c;
  private List d;
  private v e;
  private p f;

  public CatalogActivity()
  {
    ArrayList localArrayList = new ArrayList();
    this.d = localArrayList;
  }

  private void a(y paramy)
  {
    try
    {
      WebView localWebView = this.b;
      String str1 = paramy.a;
      localWebView.loadUrl(str1);
      x localx = this.c;
      List localList = paramy.b;
      localx.a(localList);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Error loading url: ");
      String str2 = paramy.a;
      String str3 = str2;
      int i = ai.a("FlurryAgent", str3);
    }
  }

  public void finish()
  {
    super.finish();
  }

  public void onClick(View paramView)
  {
    if ((paramView instanceof z))
    {
      y localy1 = new y();
      String str1 = this.b.getUrl();
      localy1.a = str1;
      List localList1 = this.c.b();
      ArrayList localArrayList = new ArrayList(localList1);
      localy1.b = localArrayList;
      boolean bool = this.d.add(localy1);
      if (this.d.size() > 5)
        Object localObject = this.d.remove(0);
      y localy2 = new y();
      z localz = (z)paramView;
      v localv1 = this.e;
      p localp1 = localz.a();
      p localp2 = localv1.b(localp1);
      this.f = localp2;
      p localp3 = this.f;
      localz.a(localp3);
      v localv2 = this.e;
      p localp4 = localz.a();
      String str2 = localv2.a(localp4);
      StringBuilder localStringBuilder = new StringBuilder();
      String str3 = this.e.i();
      String str4 = str3 + str2;
      localy2.a = str4;
      x localx = this.c;
      Context localContext = paramView.getContext();
      List localList2 = localx.a(localContext);
      localy2.b = localList2;
      a(localy2);
      return;
    }
    if (paramView.getId() == 10000)
    {
      finish();
      return;
    }
    if (paramView.getId() == 10002)
    {
      this.c.a();
      return;
    }
    if (this.d.isEmpty())
    {
      finish();
      return;
    }
    List localList3 = this.d;
    int i = this.d.size() + -1;
    y localy3 = (y)localList3.remove(i);
    a(localy3);
  }

  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973839);
    super.onCreate(paramBundle);
    v localv1 = FlurryAgent.b();
    this.e = localv1;
    Object localObject = getIntent();
    if (((Intent)localObject).getExtras() != null)
    {
      localObject = Long.valueOf(((Intent)localObject).getExtras().getLong("o"));
      if (localObject != null)
      {
        v localv2 = this.e;
        long l = ((Long)localObject).longValue();
        p localp = localv2.b(l);
        this.f = localp;
      }
    }
    ac localac = new ac(this, this);
    localac.setId(1);
    localac.setBackgroundColor(-16777216);
    WebView localWebView1 = new WebView(this);
    this.b = localWebView1;
    this.b.setId(2);
    this.b.setScrollBarStyle(0);
    this.b.setBackgroundColor(-1);
    if (this.f != null)
    {
      WebView localWebView2 = this.b;
      q localq = new q(this);
      localWebView2.setWebViewClient(localq);
    }
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.addJavascriptInterface(this, "activity");
    x localx1 = new x(this, this);
    this.c = localx1;
    this.c.setId(3);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    localRelativeLayout.setLayoutParams(localLayoutParams);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    int i = localac.getId();
    localLayoutParams1.addRule(10, i);
    localRelativeLayout.addView(localac, localLayoutParams1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    int j = localac.getId();
    localLayoutParams2.addRule(3, j);
    int k = this.c.getId();
    localLayoutParams2.addRule(2, k);
    WebView localWebView3 = this.b;
    localRelativeLayout.addView(localWebView3, localLayoutParams2);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
    int m = localac.getId();
    localLayoutParams3.addRule(12, m);
    x localx2 = this.c;
    localRelativeLayout.addView(localx2, localLayoutParams3);
    Bundle localBundle = getIntent().getExtras();
    String str1;
    if (localBundle == null)
    {
      str1 = null;
      if (str1 != null)
        break label461;
      WebView localWebView4 = this.b;
      String str2 = a;
      String str3 = null;
      localWebView4.loadDataWithBaseURL(null, str2, "text/html", "utf-8", str3);
    }
    while (true)
    {
      setContentView(localRelativeLayout);
      return;
      str1 = localBundle.getString("u");
      break;
      label461: this.b.loadUrl(str1);
    }
  }

  protected void onDestroy()
  {
    this.e.g();
    super.onDestroy();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.CatalogActivity
 * JD-Core Version:    0.6.2
 */