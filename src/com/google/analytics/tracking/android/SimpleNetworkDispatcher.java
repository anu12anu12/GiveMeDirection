package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher
  implements Dispatcher
{
  private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
  private final Context ctx;
  private final HttpClientFactory httpClientFactory;
  private final String userAgent;

  SimpleNetworkDispatcher(AnalyticsStore paramAnalyticsStore, HttpClientFactory paramHttpClientFactory, Context paramContext)
  {
    this(paramHttpClientFactory, paramContext);
  }

  SimpleNetworkDispatcher(HttpClientFactory paramHttpClientFactory, Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    this.ctx = localContext;
    String str1 = Build.VERSION.RELEASE;
    String str2 = Utils.getLanguage(Locale.getDefault());
    String str3 = Build.MODEL;
    String str4 = Build.ID;
    String str5 = createUserAgentString("GoogleAnalytics", "2.0", str1, str2, str3, str4);
    this.userAgent = str5;
    this.httpClientFactory = paramHttpClientFactory;
  }

  private HttpEntityEnclosingRequest buildRequest(String paramString1, String paramString2)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString1))
    {
      int i = Log.w("Empty hit, discarding.");
      localObject = null;
    }
    while (true)
    {
      return localObject;
      String str1 = paramString2 + "?" + paramString1;
      if (str1.length() < 2036)
        localObject = new BasicHttpEntityEnclosingRequest("GET", str1);
      while (true)
      {
        String str2 = this.userAgent;
        ((HttpEntityEnclosingRequest)localObject).addHeader("User-Agent", str2);
        break;
        localObject = new BasicHttpEntityEnclosingRequest("POST", paramString2);
        try
        {
          StringEntity localStringEntity = new StringEntity(paramString1);
          ((HttpEntityEnclosingRequest)localObject).setEntity(localStringEntity);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          int j = Log.w("Encoding error, discarding hit");
          localObject = null;
        }
      }
    }
  }

  private URL getUrl(Hit paramHit)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramHit.getHitUrl()));
    while (true)
    {
      return localObject;
      try
      {
        String str = paramHit.getHitUrl();
        localURL = new URL(str);
        localObject = localURL;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          URL localURL = new URL("http://www.google-analytics.com/collect");
          localObject = localURL;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
        }
      }
    }
  }

  private void logDebugInformation(boolean paramBoolean, HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    if (!paramBoolean)
      return;
    StringBuffer localStringBuffer1 = new StringBuffer();
    Header[] arrayOfHeader = paramHttpEntityEnclosingRequest.getAllHeaders();
    int i = arrayOfHeader.length;
    int j = 0;
    while (j < i)
    {
      String str1 = arrayOfHeader[j].toString();
      StringBuffer localStringBuffer2 = localStringBuffer1.append(str1).append("\n");
      j += 1;
    }
    String str2 = paramHttpEntityEnclosingRequest.getRequestLine().toString();
    StringBuffer localStringBuffer3 = localStringBuffer1.append(str2).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null);
    try
    {
      InputStream localInputStream = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (localInputStream != null)
      {
        int k = localInputStream.available();
        if (k > 0)
        {
          byte[] arrayOfByte = new byte[k];
          int m = localInputStream.read(arrayOfByte);
          StringBuffer localStringBuffer4 = localStringBuffer1.append("POST:\n");
          String str3 = new String(arrayOfByte);
          StringBuffer localStringBuffer5 = localStringBuffer1.append(str3).append("\n");
        }
      }
      int n = Log.i(localStringBuffer1.toString());
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        int i1 = Log.w("Error Writing hit to log...");
    }
  }

  String createUserAgentString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = paramString3;
    arrayOfObject[3] = paramString4;
    arrayOfObject[4] = paramString5;
    arrayOfObject[5] = paramString6;
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", arrayOfObject);
  }

  public int dispatchHits(List<Hit> paramList)
  {
    int i = 0;
    int j = Math.min(paramList.size(), 40);
    int k = 0;
    HttpClient localHttpClient;
    HttpHost localHttpHost;
    HttpEntityEnclosingRequest localHttpEntityEnclosingRequest;
    if (k < j)
    {
      localHttpClient = this.httpClientFactory.newInstance();
      Hit localHit = (Hit)paramList.get(k);
      URL localURL = getUrl(localHit);
      if (localURL == null)
      {
        if (Log.debugEnabled())
        {
          StringBuilder localStringBuilder1 = new StringBuilder().append("No destination: discarding hit: ");
          String str1 = localHit.getHitParams();
          int m = Log.w(str1);
        }
        while (true)
        {
          i += 1;
          k += 1;
          break;
          int n = Log.w("No destination: discarding hit.");
        }
      }
      String str2 = localURL.getHost();
      int i1 = localURL.getPort();
      String str3 = localURL.getProtocol();
      localHttpHost = new HttpHost(str2, i1, str3);
      String str4 = localURL.getPath();
      if (TextUtils.isEmpty(localHit.getHitParams()));
      long l;
      for (String str5 = ""; ; str5 = HitBuilder.postProcessHit(localHit, l))
      {
        localHttpEntityEnclosingRequest = buildRequest(str5, str4);
        if (localHttpEntityEnclosingRequest != null)
          break label223;
        i += 1;
        break;
        l = System.currentTimeMillis();
      }
      label223: String str6 = localHttpHost.toHostString();
      localHttpEntityEnclosingRequest.addHeader("Host", str6);
      boolean bool = Log.debugEnabled();
      logDebugInformation(bool, localHttpEntityEnclosingRequest);
      if (str5.length() > 8192)
        int i2 = Log.w("Hit too long (> 8192 bytes)--not sent");
    }
    while (true)
    {
      i += 1;
      break;
      try
      {
        HttpResponse localHttpResponse = localHttpClient.execute(localHttpHost, localHttpEntityEnclosingRequest);
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
          continue;
        StringBuilder localStringBuilder2 = new StringBuilder().append("Bad response: ");
        int i3 = localHttpResponse.getStatusLine().getStatusCode();
        int i4 = Log.w(i3);
        return i;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        int i5 = Log.w("ClientProtocolException sending hit; discarding hit...");
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          StringBuilder localStringBuilder3 = new StringBuilder().append("Exception sending hit: ");
          String str7 = localIOException.getClass().getSimpleName();
          int i6 = Log.w(str7);
          int i7 = Log.w(localIOException.getMessage());
        }
      }
    }
  }

  public boolean okToDispatch()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
      int i = Log.vDebug("...no network connectivity");
    for (boolean bool = false; ; bool = true)
      return bool;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.SimpleNetworkDispatcher
 * JD-Core Version:    0.6.2
 */