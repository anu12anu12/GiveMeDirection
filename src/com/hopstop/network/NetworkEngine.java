package com.hopstop.network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.widget.ImageView;
import com.hopstop.ClientModel.DateTimeUtil;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.xml.sax.SAXException;

public class NetworkEngine
{
  static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier()
  {
    public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
    {
      return true;
    }
  };
  private DateTimeUtil time;
  TrustManager[] trustAllCerts;

  public NetworkEngine()
  {
    DateTimeUtil localDateTimeUtil = new DateTimeUtil();
    this.time = localDateTimeUtil;
    TrustManager[] arrayOfTrustManager = new TrustManager[1];
    X509TrustManager local1 = new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
      }

      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
      }

      public X509Certificate[] getAcceptedIssuers()
      {
        return null;
      }
    };
    arrayOfTrustManager[0] = local1;
    this.trustAllCerts = arrayOfTrustManager;
  }

  private static InputStream OpenHttpConnection(String paramString)
    throws IOException
  {
    Object localObject = null;
    URLConnection localURLConnection = new URL(paramString).openConnection();
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURLConnection;
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.connect();
      if (localHttpURLConnection.getResponseCode() == 200)
      {
        InputStream localInputStream = localHttpURLConnection.getInputStream();
        localObject = localInputStream;
      }
      label48: return localObject;
    }
    catch (Exception localException)
    {
      break label48;
    }
  }

  private static InputStream OpenHttpsConnection(String paramString)
    throws IOException
  {
    Object localObject1 = null;
    URL localURL = new URL(paramString);
    Object localObject2;
    if (localURL.getProtocol().toLowerCase().equals("https"))
    {
      trustAllHosts();
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)localURL.openConnection();
      HostnameVerifier localHostnameVerifier = DO_NOT_VERIFY;
      localHttpsURLConnection.setHostnameVerifier(localHostnameVerifier);
      localObject2 = localHttpsURLConnection;
    }
    try
    {
      while (true)
      {
        ((HttpURLConnection)localObject2).setRequestMethod("GET");
        ((HttpURLConnection)localObject2).connect();
        if (((HttpURLConnection)localObject2).getResponseCode() == 200)
        {
          InputStream localInputStream = ((HttpURLConnection)localObject2).getInputStream();
          localObject1 = localInputStream;
        }
        label84: return localObject1;
        localObject2 = (HttpURLConnection)localURL.openConnection();
      }
    }
    catch (Exception localException)
    {
      break label84;
    }
  }

  private InputStream connectInBackground(String paramString)
    throws ParserConfigurationException, Exception
  {
    InputStream localInputStream = null;
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    int i = NetworkSettings.NETWORK_CONNECTION_TIMEOUT;
    localHttpURLConnection.setConnectTimeout(i);
    int j = NetworkSettings.NETWORK_READ_TIMEOUT;
    localHttpURLConnection.setReadTimeout(j);
    localHttpURLConnection.setRequestMethod("GET");
    localHttpURLConnection.connect();
    if (localHttpURLConnection.getResponseCode() == 200)
      localInputStream = localHttpURLConnection.getInputStream();
    return localInputStream;
  }

  public static boolean dataNetworkAvail(Activity paramActivity)
  {
    boolean bool1 = true;
    if (paramActivity == null);
    while (true)
    {
      return bool1;
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramActivity.getSystemService("connectivity");
        if ((localConnectivityManager != null) && (localConnectivityManager.getActiveNetworkInfo() != null) && (localConnectivityManager.getActiveNetworkInfo().isAvailable()))
        {
          boolean bool2 = localConnectivityManager.getActiveNetworkInfo().isConnected();
          if (bool2);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        bool1 = false;
      }
    }
  }

  public static Drawable fetchDrawable(String paramString)
    throws OutOfMemoryError, IOException
  {
    return ApplicationEngine.getDrawableManager().fetchDrawable(paramString);
  }

  public static void fetchDrawableOnThread(String paramString, ImageView paramImageView)
  {
    ApplicationEngine.getDrawableManager().fetchDrawableOnThread(paramString, paramImageView);
  }

  public static void fetchImageViewOnThread(String paramString, ImageView paramImageView)
  {
    ApplicationEngine.getDrawableManager().fetchImageViewOnThread(paramString, paramImageView);
  }

  public static Drawable fetchNewDrawable(String paramString)
  {
    return ApplicationEngine.getDrawableManager().fetchNewDrawable(paramString);
  }

  public static Bitmap loadImage(String paramString, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap = null;
    try
    {
      InputStream localInputStream = OpenHttpConnection(paramString);
      if (localInputStream != null)
      {
        localBitmap = BitmapFactory.decodeStream(localInputStream, null, paramOptions);
        localInputStream.close();
      }
      label22: return localBitmap;
    }
    catch (IOException localIOException)
    {
      break label22;
    }
  }

  private static void trustAllHosts()
  {
    TrustManager[] arrayOfTrustManager = new TrustManager[1];
    X509TrustManager local5 = new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {
      }

      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {
      }

      public X509Certificate[] getAcceptedIssuers()
      {
        return new X509Certificate[0];
      }
    };
    arrayOfTrustManager[0] = local5;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, arrayOfTrustManager, localSecureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void execute(BaseActivity paramBaseActivity, final String paramString)
  {
    final Handler localHandler = new Handler();
    final Runnable local3 = new Runnable()
    {
      public void run()
      {
      }
    };
    new Thread()
    {
      public void run()
      {
        try
        {
          NetworkEngine localNetworkEngine = NetworkEngine.this;
          String str = paramString;
          InputStream localInputStream = localNetworkEngine.connectInBackground(str);
          Handler localHandler = localHandler;
          Runnable localRunnable = local3;
          boolean bool = localHandler.post(localRunnable);
          return;
        }
        catch (ParserConfigurationException localParserConfigurationException)
        {
          while (true)
            localParserConfigurationException.printStackTrace();
        }
        catch (SAXException localSAXException)
        {
          while (true)
            localSAXException.printStackTrace();
        }
        catch (Exception localException)
        {
          while (true)
            localException.printStackTrace();
        }
      }
    }
    .start();
  }

  // ERROR //
  public org.xml.sax.helpers.DefaultHandler getSynchronousExecute(Activity paramActivity, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_3
    //   7: ifnonnull +6 -> 13
    //   10: aload 4
    //   12: areturn
    //   13: aload_1
    //   14: invokestatic 233	com/hopstop/network/NetworkEngine:dataNetworkAvail	(Landroid/app/Activity;)Z
    //   17: ifeq -7 -> 10
    //   20: invokestatic 160	com/hopstop/core/ApplicationEngine:getDrawableManager	()Lcom/hopstop/network/DrawableManager;
    //   23: astore 6
    //   25: invokestatic 237	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   28: iconst_1
    //   29: invokevirtual 243	com/hopstop/ClientModel/Model:setLastConnSuccess	(Z)V
    //   32: aload_3
    //   33: ldc 86
    //   35: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   38: ifeq +311 -> 349
    //   41: aload_3
    //   42: invokestatic 249	com/hopstop/network/NetworkEngine:OpenHttpsConnection	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore 7
    //   47: invokestatic 255	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   50: invokevirtual 259	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   53: invokevirtual 265	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   56: astore 8
    //   58: getstatic 268	com/hopstop/network/NetworkSettings:GET_CITIES	I
    //   61: iload_2
    //   62: if_icmpeq +467 -> 529
    //   65: new 270	com/hopstop/ClientModel/xml/GetCitiesHandler
    //   68: dup
    //   69: invokespecial 271	com/hopstop/ClientModel/xml/GetCitiesHandler:<init>	()V
    //   72: astore 9
    //   74: getstatic 274	com/hopstop/network/NetworkSettings:GET_DIRECTIONS	I
    //   77: iload_2
    //   78: if_icmpeq +29 -> 107
    //   81: aload_1
    //   82: invokevirtual 278	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   85: invokeinterface 284 1 0
    //   90: invokevirtual 289	android/view/Display:getWidth	()I
    //   93: istore 10
    //   95: new 291	com/hopstop/ClientModel/xml/GetDirectionRequestHandler
    //   98: dup
    //   99: iload 10
    //   101: aload_3
    //   102: invokespecial 294	com/hopstop/ClientModel/xml/GetDirectionRequestHandler:<init>	(ILjava/lang/String;)V
    //   105: astore 9
    //   107: getstatic 297	com/hopstop/network/NetworkSettings:GET_DIRECTIONS_FOR_TAXI	I
    //   110: iload_2
    //   111: if_icmpeq +42 -> 153
    //   114: aload_1
    //   115: invokevirtual 278	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   118: invokeinterface 284 1 0
    //   123: invokevirtual 289	android/view/Display:getWidth	()I
    //   126: istore 11
    //   128: new 291	com/hopstop/ClientModel/xml/GetDirectionRequestHandler
    //   131: dup
    //   132: iload 11
    //   134: aload_3
    //   135: invokespecial 294	com/hopstop/ClientModel/xml/GetDirectionRequestHandler:<init>	(ILjava/lang/String;)V
    //   138: astore 5
    //   140: aload 5
    //   142: checkcast 291	com/hopstop/ClientModel/xml/GetDirectionRequestHandler
    //   145: iconst_1
    //   146: invokevirtual 300	com/hopstop/ClientModel/xml/GetDirectionRequestHandler:setTaxiMode	(Z)V
    //   149: aload 5
    //   151: astore 9
    //   153: getstatic 274	com/hopstop/network/NetworkSettings:GET_DIRECTIONS	I
    //   156: iload_2
    //   157: if_icmpeq +29 -> 186
    //   160: aload_1
    //   161: invokevirtual 278	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   164: invokeinterface 284 1 0
    //   169: invokevirtual 289	android/view/Display:getWidth	()I
    //   172: istore 12
    //   174: new 291	com/hopstop/ClientModel/xml/GetDirectionRequestHandler
    //   177: dup
    //   178: iload 12
    //   180: aload_3
    //   181: invokespecial 294	com/hopstop/ClientModel/xml/GetDirectionRequestHandler:<init>	(ILjava/lang/String;)V
    //   184: astore 9
    //   186: getstatic 303	com/hopstop/network/NetworkSettings:GET_MAP	I
    //   189: iload_2
    //   190: if_icmpeq +12 -> 202
    //   193: new 305	com/hopstop/ClientModel/xml/GetMapHandler
    //   196: dup
    //   197: invokespecial 306	com/hopstop/ClientModel/xml/GetMapHandler:<init>	()V
    //   200: astore 9
    //   202: getstatic 309	com/hopstop/network/NetworkSettings:UPDATE_MAP	I
    //   205: iload_2
    //   206: if_icmpeq +12 -> 218
    //   209: new 305	com/hopstop/ClientModel/xml/GetMapHandler
    //   212: dup
    //   213: invokespecial 306	com/hopstop/ClientModel/xml/GetMapHandler:<init>	()V
    //   216: astore 9
    //   218: getstatic 312	com/hopstop/network/NetworkSettings:GET_TAXI	I
    //   221: iload_2
    //   222: if_icmpeq +12 -> 234
    //   225: new 314	com/hopstop/ClientModel/xml/GetTaxisHandler
    //   228: dup
    //   229: invokespecial 315	com/hopstop/ClientModel/xml/GetTaxisHandler:<init>	()V
    //   232: astore 9
    //   234: getstatic 318	com/hopstop/network/NetworkSettings:GET_LONLAN_TO_CITY	I
    //   237: iload_2
    //   238: if_icmpeq +12 -> 250
    //   241: new 320	com/hopstop/ClientModel/xml/GetLonLanToCityRequestHandler
    //   244: dup
    //   245: invokespecial 321	com/hopstop/ClientModel/xml/GetLonLanToCityRequestHandler:<init>	()V
    //   248: astore 9
    //   250: getstatic 324	com/hopstop/network/NetworkSettings:GET_NEARBY_BUSINESS	I
    //   253: iload_2
    //   254: if_icmpeq +12 -> 266
    //   257: new 326	com/hopstop/ClientModel/xml/GetNearbyRequestHandler
    //   260: dup
    //   261: invokespecial 327	com/hopstop/ClientModel/xml/GetNearbyRequestHandler:<init>	()V
    //   264: astore 9
    //   266: getstatic 330	com/hopstop/network/NetworkSettings:GET_SERVICE_ADVISOR_SUBWAY_TRAIN	I
    //   269: iload_2
    //   270: if_icmpeq +17 -> 287
    //   273: getstatic 333	com/hopstop/network/NetworkSettings:GET_SERVICE_ADVISOR_REGIONAL_RAIL	I
    //   276: iload_2
    //   277: if_icmpeq +10 -> 287
    //   280: getstatic 336	com/hopstop/network/NetworkSettings:GET_SERVICE_ADVISOR_BUS	I
    //   283: iload_2
    //   284: if_icmpeq +13 -> 297
    //   287: new 338	com/hopstop/ClientModel/xml/GetServiceAdvisorHandler
    //   290: dup
    //   291: iload_2
    //   292: invokespecial 340	com/hopstop/ClientModel/xml/GetServiceAdvisorHandler:<init>	(I)V
    //   295: astore 9
    //   297: getstatic 343	com/hopstop/network/NetworkSettings:GET_COUNT_IMPRESSION	I
    //   300: iload_2
    //   301: if_icmpeq +221 -> 522
    //   304: new 345	com/hopstop/ClientModel/xml/GetCountImpressionsHandler
    //   307: dup
    //   308: invokespecial 346	com/hopstop/ClientModel/xml/GetCountImpressionsHandler:<init>	()V
    //   311: astore 5
    //   313: aload 8
    //   315: aload 5
    //   317: invokeinterface 352 2 0
    //   322: new 354	org/xml/sax/InputSource
    //   325: dup
    //   326: aload 7
    //   328: invokespecial 357	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   331: astore 13
    //   333: aload 8
    //   335: aload 13
    //   337: invokeinterface 361 2 0
    //   342: aload 5
    //   344: astore 4
    //   346: goto -336 -> 10
    //   349: aload_0
    //   350: aload_3
    //   351: invokevirtual 364	com/hopstop/network/NetworkEngine:tryConnect	(Ljava/lang/String;)Ljava/io/InputStream;
    //   354: astore 7
    //   356: goto -309 -> 47
    //   359: invokevirtual 365	java/io/IOException:printStackTrace	()V
    //   362: aconst_null
    //   363: astore 5
    //   365: goto -23 -> 342
    //   368: invokevirtual 366	org/xml/sax/SAXException:printStackTrace	()V
    //   371: aconst_null
    //   372: astore 5
    //   374: goto -32 -> 342
    //   377: astore 14
    //   379: aload 14
    //   381: invokevirtual 367	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   384: invokestatic 237	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   387: iconst_0
    //   388: invokevirtual 243	com/hopstop/ClientModel/Model:setLastConnSuccess	(Z)V
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -52 -> 342
    //   397: astore 14
    //   399: aload 14
    //   401: invokevirtual 366	org/xml/sax/SAXException:printStackTrace	()V
    //   404: invokestatic 237	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   407: iconst_0
    //   408: invokevirtual 243	com/hopstop/ClientModel/Model:setLastConnSuccess	(Z)V
    //   411: aconst_null
    //   412: astore 5
    //   414: goto -72 -> 342
    //   417: astore 14
    //   419: aload 14
    //   421: invokevirtual 368	org/apache/http/HttpException:printStackTrace	()V
    //   424: invokestatic 237	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   427: iconst_0
    //   428: invokevirtual 243	com/hopstop/ClientModel/Model:setLastConnSuccess	(Z)V
    //   431: aconst_null
    //   432: astore 5
    //   434: goto -92 -> 342
    //   437: astore 14
    //   439: aload 14
    //   441: invokevirtual 365	java/io/IOException:printStackTrace	()V
    //   444: invokestatic 237	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   447: iconst_0
    //   448: invokevirtual 243	com/hopstop/ClientModel/Model:setLastConnSuccess	(Z)V
    //   451: aconst_null
    //   452: astore 5
    //   454: goto -112 -> 342
    //   457: astore 14
    //   459: aload 14
    //   461: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   464: invokestatic 237	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   467: iconst_0
    //   468: invokevirtual 243	com/hopstop/ClientModel/Model:setLastConnSuccess	(Z)V
    //   471: aconst_null
    //   472: astore 5
    //   474: goto -132 -> 342
    //   477: astore 14
    //   479: aload 9
    //   481: astore 15
    //   483: goto -24 -> 459
    //   486: astore 14
    //   488: aload 9
    //   490: astore 16
    //   492: goto -53 -> 439
    //   495: astore 14
    //   497: aload 9
    //   499: astore 17
    //   501: goto -82 -> 419
    //   504: astore 14
    //   506: aload 9
    //   508: astore 18
    //   510: goto -111 -> 399
    //   513: astore 14
    //   515: aload 9
    //   517: astore 19
    //   519: goto -140 -> 379
    //   522: aload 9
    //   524: astore 5
    //   526: goto -213 -> 313
    //   529: aconst_null
    //   530: astore 9
    //   532: goto -458 -> 74
    //
    // Exception table:
    //   from	to	target	type
    //   322	342	359	java/io/IOException
    //   322	342	368	org/xml/sax/SAXException
    //   20	74	377	javax/xml/parsers/ParserConfigurationException
    //   140	149	377	javax/xml/parsers/ParserConfigurationException
    //   313	322	377	javax/xml/parsers/ParserConfigurationException
    //   322	342	377	javax/xml/parsers/ParserConfigurationException
    //   349	371	377	javax/xml/parsers/ParserConfigurationException
    //   20	74	397	org/xml/sax/SAXException
    //   140	149	397	org/xml/sax/SAXException
    //   313	322	397	org/xml/sax/SAXException
    //   349	371	397	org/xml/sax/SAXException
    //   20	74	417	org/apache/http/HttpException
    //   140	149	417	org/apache/http/HttpException
    //   313	322	417	org/apache/http/HttpException
    //   322	342	417	org/apache/http/HttpException
    //   349	371	417	org/apache/http/HttpException
    //   20	74	437	java/io/IOException
    //   140	149	437	java/io/IOException
    //   313	322	437	java/io/IOException
    //   349	371	437	java/io/IOException
    //   20	74	457	java/lang/Exception
    //   140	149	457	java/lang/Exception
    //   313	322	457	java/lang/Exception
    //   322	342	457	java/lang/Exception
    //   349	371	457	java/lang/Exception
    //   74	140	477	java/lang/Exception
    //   153	313	477	java/lang/Exception
    //   74	140	486	java/io/IOException
    //   153	313	486	java/io/IOException
    //   74	140	495	org/apache/http/HttpException
    //   153	313	495	org/apache/http/HttpException
    //   74	140	504	org/xml/sax/SAXException
    //   153	313	504	org/xml/sax/SAXException
    //   74	140	513	javax/xml/parsers/ParserConfigurationException
    //   153	313	513	javax/xml/parsers/ParserConfigurationException
  }

  public String retrieve(String paramString)
    throws IOException
  {
    Object localObject = null;
    HttpGet localHttpGet = new HttpGet(paramString);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    int i = NetworkSettings.NETWORK_CONNECTION_TIMEOUT;
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
    int j = NetworkSettings.NETWORK_SOCKET_TIMEOUT;
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, j);
    long l = NetworkSettings.NETWORK_CONNECTION_TIMEOUT;
    ConnManagerParams.setTimeout(localBasicHttpParams, l);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    try
    {
      HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpGet);
      if (localHttpResponse.getStatusLine().getStatusCode() != 200);
      while (true)
      {
        return localObject;
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity != null)
        {
          String str = EntityUtils.toString(localHttpEntity, "UTF8");
          localObject = str;
        }
      }
    }
    catch (IOException localIOException)
    {
      localHttpGet.abort();
      throw localIOException;
    }
  }

  public InputStream tryConnect(String paramString)
    throws ParserConfigurationException, HttpException, IOException, Exception
  {
    HttpGet localHttpGet = new HttpGet(paramString);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    int i = NetworkSettings.NETWORK_CONNECTION_TIMEOUT;
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
    int j = NetworkSettings.NETWORK_SOCKET_TIMEOUT;
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, j);
    long l = NetworkSettings.NETWORK_CONNECTION_TIMEOUT;
    ConnManagerParams.setTimeout(localBasicHttpParams, l);
    return new DefaultHttpClient(localBasicHttpParams).execute(localHttpGet).getEntity().getContent();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.network.NetworkEngine
 * JD-Core Version:    0.6.2
 */