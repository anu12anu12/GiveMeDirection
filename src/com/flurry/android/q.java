package com.flurry.android;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.List;

final class q extends WebViewClient
{
  q(CatalogActivity paramCatalogActivity)
  {
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    try
    {
      p localp = CatalogActivity.a(this.a);
      long l1 = CatalogActivity.b(this.a);
      f localf = new f((byte)5, l1);
      long l2 = CatalogActivity.a(this.a).d;
      boolean bool = localp.e.add(localf);
      localp.d = l2;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    String str = "Failed to load url: " + paramString2 + " with an errorCode of " + paramInt;
    int i = ai.c("FlurryAgent", str);
    paramWebView.loadData("Cannot find Android Market information. <p>Please check your network", "text/html", "UTF-8");
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString == null);
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      if (CatalogActivity.a(this.a) != null)
      {
        p localp1 = CatalogActivity.a(this.a);
        long l = CatalogActivity.b(this.a);
        f localf = new f((byte)6, l);
        localp1.a(localf);
      }
      v localv = CatalogActivity.c(this.a);
      Context localContext = paramWebView.getContext();
      p localp2 = CatalogActivity.a(this.a);
      localv.a(localContext, localp2, paramString);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.q
 * JD-Core Version:    0.6.2
 */