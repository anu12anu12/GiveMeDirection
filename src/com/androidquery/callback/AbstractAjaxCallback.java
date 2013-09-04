package com.androidquery.callback;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import com.androidquery.auth.AccountHandle;
import com.androidquery.auth.GoogleHandle;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.Progress;
import com.androidquery.util.XmlDom;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.xmlpull.v1.XmlPullParser;

public abstract class AbstractAjaxCallback<T, K>
  implements Runnable
{
  private static String AGENT;
  private static final Class<?>[] DEFAULT_SIG = arrayOfClass;
  private static boolean GZIP = false;
  private static int NETWORK_POOL = 0;
  private static int NET_TIMEOUT = 0;
  private static boolean REUSE_CLIENT = false;
  private static final String boundary = "*****";
  private static DefaultHttpClient client;
  private static ExecutorService fetchExe;
  private static int lastStatus = 0;
  private static final String lineEnd = "\r\n";
  private static SocketFactory ssf;
  private static Transformer st;
  private static final String twoHyphens = "--";
  private boolean abort;
  private WeakReference<Activity> act;
  private AccountHandle ah;
  private boolean blocked;
  private File cacheDir;
  private String callback;
  private boolean completed;
  private Map<String, String> cookies;
  private String encoding = "UTF-8";
  private long expire;
  protected boolean fileCache;
  private Object handler;
  private Map<String, String> headers;
  protected boolean memCache;
  private int method = 4;
  private String networkUrl;
  private Map<String, Object> params;
  private int policy = 0;
  private WeakReference<Object> progress;
  private HttpHost proxy;
  private boolean reauth;
  private boolean refresh;
  private HttpUriRequest request;
  protected T result;
  protected AjaxStatus status;
  private File targetFile;
  private int timeout = 0;
  private Transformer transformer;
  private Class<T> type;
  private boolean uiCallback = true;
  private String url;
  private Reference<Object> whandler;

  static
  {
    AGENT = null;
    NETWORK_POOL = 4;
    GZIP = true;
    REUSE_CLIENT = true;
    Class[] arrayOfClass = new Class[3];
    arrayOfClass[0] = String.class;
    arrayOfClass[1] = Object.class;
    arrayOfClass[2] = AjaxStatus.class;
  }

  private void afterWork()
  {
    if ((this.url != null) && (this.memCache))
    {
      String str = this.url;
      Object localObject = this.result;
      memPut(str, localObject);
    }
    callback();
    clear();
  }

  private void backgroundWork()
  {
    if ((!this.refresh) && (this.fileCache))
      fileWork();
    if (this.result == null)
      datastoreWork();
    if (this.result != null)
      return;
    networkWork();
  }

  public static void cancel()
  {
    if (fetchExe != null)
    {
      List localList = fetchExe.shutdownNow();
      fetchExe = null;
    }
    BitmapAjaxCallback.clearTasks();
  }

  private void clear()
  {
    this.whandler = null;
    this.handler = null;
    this.progress = null;
    this.request = null;
    this.transformer = null;
    this.ah = null;
    this.act = null;
  }

  private void copy(InputStream paramInputStream, OutputStream paramOutputStream, String paramString, int paramInt)
    throws IOException
  {
    if ("gzip".equalsIgnoreCase(paramString))
      paramInputStream = new GZIPInputStream(paramInputStream);
    Object localObject = null;
    if (this.progress != null)
      localObject = this.progress.get();
    Progress localProgress = null;
    if (localObject != null)
      localProgress = new Progress(localObject);
    AQUtility.copy(paramInputStream, paramOutputStream, paramInt, localProgress);
  }

  private String correctEncoding(byte[] paramArrayOfByte, String paramString, AjaxStatus paramAjaxStatus)
  {
    Object localObject1 = null;
    Object localObject2;
    try
    {
      if (!"utf-8".equalsIgnoreCase(paramString));
      String str2;
      for (localObject2 = new String(paramArrayOfByte, paramString); ; localObject2 = new String(paramArrayOfByte, str2))
      {
        return localObject2;
        String str1 = paramAjaxStatus.getHeader("Content-Type");
        str2 = parseCharset(str1);
        AQUtility.debug("parsing header", str2);
        if (str2 == null)
          break;
      }
    }
    catch (Exception localException1)
    {
    }
    label71: AQUtility.report(localException1);
    while (true)
    {
      localObject2 = localObject1;
      break;
      String str3 = new String(paramArrayOfByte, "utf-8");
      try
      {
        String str4 = getCharset(str3);
        AQUtility.debug("parsing needed", str4);
        if ((str4 == null) || ("utf-8".equalsIgnoreCase(str4)))
          break label173;
        AQUtility.debug("correction needed", str4);
        localObject1 = new String(paramArrayOfByte, str4);
        byte[] arrayOfByte = ((String)localObject1).getBytes("utf-8");
        AjaxStatus localAjaxStatus = paramAjaxStatus.data(arrayOfByte);
      }
      catch (Exception localException2)
      {
        localObject1 = str3;
      }
      break label71;
      label173: localObject1 = str3;
    }
  }

  private void datastoreWork()
  {
    String str = this.url;
    Object localObject = datastoreGet(str);
    this.result = localObject;
    if (this.result == null)
      return;
    AjaxStatus localAjaxStatus = this.status.source(2).done();
  }

  public static void execute(Runnable paramRunnable)
  {
    if (fetchExe == null)
      fetchExe = Executors.newFixedThreadPool(NETWORK_POOL);
    fetchExe.execute(paramRunnable);
  }

  private static Map<String, Object> extractParams(Uri paramUri)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramUri.getQuery().split("&");
    int i = arrayOfString1.length;
    int j = 0;
    if (j >= i)
      return localHashMap;
    String[] arrayOfString2 = arrayOfString1[j].split("=");
    if (arrayOfString2.length >= 2)
    {
      String str1 = arrayOfString2[0];
      String str2 = arrayOfString2[1];
      Object localObject1 = localHashMap.put(str1, str2);
    }
    while (true)
    {
      j += 1;
      break;
      if (arrayOfString2.length == 1)
      {
        String str3 = arrayOfString2[0];
        Object localObject2 = localHashMap.put(str3, "");
      }
    }
  }

  private static String extractUrl(Uri paramUri)
  {
    String str1 = String.valueOf(paramUri.getScheme());
    StringBuilder localStringBuilder1 = new StringBuilder(str1).append("://");
    String str2 = paramUri.getAuthority();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
    String str3 = paramUri.getPath();
    String str4 = str3;
    String str5 = paramUri.getFragment();
    if (str5 != null)
    {
      String str6 = String.valueOf(str4);
      str4 = str6 + "#" + str5;
    }
    return str4;
  }

  private void filePut()
  {
    if (this.result == null)
      return;
    if (!this.fileCache)
      return;
    byte[] arrayOfByte = this.status.getData();
    if (arrayOfByte != null);
    try
    {
      File localFile;
      if (this.status.getSource() == 1)
      {
        localFile = getCacheFile();
        if (this.status.getInvalid())
          break label85;
        String str = this.url;
        Object localObject = this.result;
        filePut(str, localObject, localFile, arrayOfByte);
      }
      while (true)
      {
        AjaxStatus localAjaxStatus = this.status.data(null);
        return;
        label85: if (localFile.exists())
          boolean bool = localFile.delete();
      }
    }
    catch (Exception localException)
    {
      while (true)
        AQUtility.debug(localException);
    }
  }

  private void fileWork()
  {
    File localFile1 = this.cacheDir;
    String str1 = getCacheUrl();
    File localFile2 = accessFile(localFile1, str1);
    if (localFile2 == null)
      return;
    AjaxStatus localAjaxStatus1 = this.status.source(3);
    String str2 = this.url;
    AjaxStatus localAjaxStatus2 = this.status;
    Object localObject = fileGet(str2, localFile2, localAjaxStatus2);
    this.result = localObject;
    if (this.result == null)
      return;
    AjaxStatus localAjaxStatus3 = this.status;
    long l = localFile2.lastModified();
    Date localDate = new Date(l);
    AjaxStatus localAjaxStatus4 = localAjaxStatus3.time(localDate).done();
  }

  private String getCacheUrl()
  {
    AccountHandle localAccountHandle;
    String str1;
    if (this.ah != null)
    {
      localAccountHandle = this.ah;
      str1 = this.url;
    }
    for (String str2 = localAccountHandle.getCacheUrl(str1); ; str2 = this.url)
      return str2;
  }

  private String getCharset(String paramString)
  {
    Matcher localMatcher = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(paramString);
    if (!localMatcher.find());
    String str2;
    for (String str1 = null; ; str1 = parseCharset(str2))
    {
      return str1;
      str2 = localMatcher.group();
    }
  }

  private static DefaultHttpClient getClient()
  {
    BasicHttpParams localBasicHttpParams;
    SchemeRegistry localSchemeRegistry;
    Scheme localScheme3;
    String str;
    if ((client == null) || (!REUSE_CLIENT))
    {
      AQUtility.debug("creating http client");
      localBasicHttpParams = new BasicHttpParams();
      int i = NET_TIMEOUT;
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
      int j = NET_TIMEOUT;
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, j);
      ConnPerRouteBean localConnPerRouteBean = new ConnPerRouteBean(25);
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, localConnPerRouteBean);
      HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
      localSchemeRegistry = new SchemeRegistry();
      PlainSocketFactory localPlainSocketFactory = PlainSocketFactory.getSocketFactory();
      Scheme localScheme1 = new Scheme("http", localPlainSocketFactory, 80);
      Scheme localScheme2 = localSchemeRegistry.register(localScheme1);
      localScheme3 = new org/apache/http/conn/scheme/Scheme;
      str = "https";
      if (ssf != null)
        break label176;
    }
    label176: for (Object localObject = SSLSocketFactory.getSocketFactory(); ; localObject = ssf)
    {
      localScheme3.<init>(str, (SocketFactory)localObject, 443);
      Scheme localScheme4 = localSchemeRegistry.register(localScheme3);
      ThreadSafeClientConnManager localThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
      client = new DefaultHttpClient(localThreadSafeClientConnManager, localBasicHttpParams);
      return client;
    }
  }

  private String getEncoding(HttpEntity paramHttpEntity)
  {
    String str = null;
    if (paramHttpEntity == null);
    while (true)
    {
      return str;
      Header localHeader = paramHttpEntity.getContentEncoding();
      if (localHeader != null)
        str = localHeader.getValue();
    }
  }

  protected static int getLastStatus()
  {
    return lastStatus;
  }

  private String getNetworkUrl(String paramString)
  {
    String str = paramString;
    if (this.networkUrl != null)
      str = this.networkUrl;
    if (this.ah != null)
      str = this.ah.getNetworkUrl(str);
    return str;
  }

  private File getPreFile()
  {
    boolean bool1 = isStreamingContent();
    File localFile1 = null;
    if (bool1)
    {
      if (this.targetFile == null)
        break label50;
      localFile1 = this.targetFile;
    }
    while (true)
    {
      if ((localFile1 != null) && (!localFile1.exists()));
      try
      {
        boolean bool2 = localFile1.getParentFile().mkdirs();
        boolean bool3 = localFile1.createNewFile();
        return localFile1;
        label50: if (this.fileCache)
        {
          localFile1 = getCacheFile();
          continue;
        }
        File localFile2 = AQUtility.getTempDir();
        if (localFile2 == null)
          localFile2 = this.cacheDir;
        String str = this.url;
        localFile1 = AQUtility.getCacheFile(localFile2, str);
      }
      catch (Exception localException)
      {
        while (true)
        {
          AQUtility.report(localException);
          localFile1 = null;
        }
      }
    }
  }

  private void httpDelete(String paramString, Map<String, String> paramMap, AjaxStatus paramAjaxStatus)
    throws IOException
  {
    AQUtility.debug("get", paramString);
    String str = patchUrl(paramString);
    HttpDelete localHttpDelete = new HttpDelete(str);
    httpDo(localHttpDelete, str, paramMap, paramAjaxStatus);
  }

  // ERROR //
  private void httpDo(HttpUriRequest paramHttpUriRequest, String paramString, Map<String, String> paramMap, AjaxStatus paramAjaxStatus)
    throws ClientProtocolException, IOException
  {
    // Byte code:
    //   0: getstatic 96	com/androidquery/callback/AbstractAjaxCallback:AGENT	Ljava/lang/String;
    //   3: ifnull +31 -> 34
    //   6: getstatic 96	com/androidquery/callback/AbstractAjaxCallback:AGENT	Ljava/lang/String;
    //   9: astore 5
    //   11: aload_1
    //   12: astore 6
    //   14: ldc_w 557
    //   17: astore 7
    //   19: aload 5
    //   21: astore 8
    //   23: aload 6
    //   25: aload 7
    //   27: aload 8
    //   29: invokeinterface 563 3 0
    //   34: aload_3
    //   35: ifnull +26 -> 61
    //   38: aload_3
    //   39: invokeinterface 567 1 0
    //   44: invokeinterface 573 1 0
    //   49: astore 9
    //   51: aload 9
    //   53: invokeinterface 578 1 0
    //   58: ifne +304 -> 362
    //   61: getstatic 100	com/androidquery/callback/AbstractAjaxCallback:GZIP	Z
    //   64: ifeq +50 -> 114
    //   67: aload_3
    //   68: ifnull +23 -> 91
    //   71: aload_3
    //   72: astore 10
    //   74: ldc_w 580
    //   77: astore 11
    //   79: aload 10
    //   81: aload 11
    //   83: invokeinterface 584 2 0
    //   88: ifne +26 -> 114
    //   91: aload_1
    //   92: astore 12
    //   94: ldc_w 580
    //   97: astore 13
    //   99: ldc 193
    //   101: astore 14
    //   103: aload 12
    //   105: aload 13
    //   107: aload 14
    //   109: invokeinterface 563 3 0
    //   114: aload_0
    //   115: invokespecial 587	com/androidquery/callback/AbstractAjaxCallback:makeCookie	()Ljava/lang/String;
    //   118: astore 15
    //   120: aload 15
    //   122: ifnull +22 -> 144
    //   125: aload_1
    //   126: astore 16
    //   128: ldc_w 589
    //   131: astore 17
    //   133: aload 16
    //   135: aload 17
    //   137: aload 15
    //   139: invokeinterface 563 3 0
    //   144: aload_0
    //   145: getfield 185	com/androidquery/callback/AbstractAjaxCallback:ah	Lcom/androidquery/auth/AccountHandle;
    //   148: ifnull +24 -> 172
    //   151: aload_0
    //   152: getfield 185	com/androidquery/callback/AbstractAjaxCallback:ah	Lcom/androidquery/auth/AccountHandle;
    //   155: astore 18
    //   157: aload_0
    //   158: astore 19
    //   160: aload_1
    //   161: astore 20
    //   163: aload 18
    //   165: aload 19
    //   167: aload 20
    //   169: invokevirtual 593	com/androidquery/auth/AccountHandle:applyToken	(Lcom/androidquery/callback/AbstractAjaxCallback;Lorg/apache/http/HttpRequest;)V
    //   172: invokestatic 595	com/androidquery/callback/AbstractAjaxCallback:getClient	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   175: astore 21
    //   177: aload_1
    //   178: invokeinterface 599 1 0
    //   183: astore 22
    //   185: aload_0
    //   186: getfield 601	com/androidquery/callback/AbstractAjaxCallback:proxy	Lorg/apache/http/HttpHost;
    //   189: ifnull +35 -> 224
    //   192: aload_0
    //   193: getfield 601	com/androidquery/callback/AbstractAjaxCallback:proxy	Lorg/apache/http/HttpHost;
    //   196: astore 23
    //   198: aload 22
    //   200: astore 24
    //   202: ldc_w 603
    //   205: astore 25
    //   207: aload 23
    //   209: astore 26
    //   211: aload 24
    //   213: aload 25
    //   215: aload 26
    //   217: invokeinterface 609 3 0
    //   222: astore 27
    //   224: aload_0
    //   225: getfield 119	com/androidquery/callback/AbstractAjaxCallback:timeout	I
    //   228: ifle +73 -> 301
    //   231: aload_0
    //   232: getfield 119	com/androidquery/callback/AbstractAjaxCallback:timeout	I
    //   235: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: astore 28
    //   240: aload 22
    //   242: astore 29
    //   244: ldc_w 616
    //   247: astore 30
    //   249: aload 28
    //   251: astore 31
    //   253: aload 29
    //   255: aload 30
    //   257: aload 31
    //   259: invokeinterface 609 3 0
    //   264: astore 32
    //   266: aload_0
    //   267: getfield 119	com/androidquery/callback/AbstractAjaxCallback:timeout	I
    //   270: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: astore 33
    //   275: aload 22
    //   277: astore 34
    //   279: ldc_w 618
    //   282: astore 35
    //   284: aload 33
    //   286: astore 36
    //   288: aload 34
    //   290: aload 35
    //   292: aload 36
    //   294: invokeinterface 609 3 0
    //   299: astore 37
    //   301: new 620	org/apache/http/protocol/BasicHttpContext
    //   304: dup
    //   305: invokespecial 621	org/apache/http/protocol/BasicHttpContext:<init>	()V
    //   308: astore 38
    //   310: new 623	org/apache/http/impl/client/BasicCookieStore
    //   313: dup
    //   314: invokespecial 624	org/apache/http/impl/client/BasicCookieStore:<init>	()V
    //   317: astore 39
    //   319: ldc_w 626
    //   322: astore 40
    //   324: aload 38
    //   326: aload 40
    //   328: aload 39
    //   330: invokeinterface 631 3 0
    //   335: aload_1
    //   336: astore 41
    //   338: aload_0
    //   339: aload 41
    //   341: putfield 181	com/androidquery/callback/AbstractAjaxCallback:request	Lorg/apache/http/client/methods/HttpUriRequest;
    //   344: aload_0
    //   345: getfield 633	com/androidquery/callback/AbstractAjaxCallback:abort	Z
    //   348: ifeq +72 -> 420
    //   351: new 191	java/io/IOException
    //   354: dup
    //   355: ldc_w 635
    //   358: invokespecial 636	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   361: athrow
    //   362: aload 9
    //   364: invokeinterface 639 1 0
    //   369: checkcast 106	java/lang/String
    //   372: astore 42
    //   374: aload_3
    //   375: astore 43
    //   377: aload 42
    //   379: astore 44
    //   381: aload 43
    //   383: aload 44
    //   385: invokeinterface 642 2 0
    //   390: checkcast 106	java/lang/String
    //   393: astore 45
    //   395: aload_1
    //   396: astore 46
    //   398: aload 42
    //   400: astore 47
    //   402: aload 45
    //   404: astore 48
    //   406: aload 46
    //   408: aload 47
    //   410: aload 48
    //   412: invokeinterface 563 3 0
    //   417: goto -366 -> 51
    //   420: aload_1
    //   421: astore 49
    //   423: aload 21
    //   425: aload 49
    //   427: aload 38
    //   429: invokevirtual 645	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   432: astore 50
    //   434: aload 50
    //   436: astore 51
    //   438: aconst_null
    //   439: astore 52
    //   441: aload_2
    //   442: astore 54
    //   444: aload 51
    //   446: invokeinterface 651 1 0
    //   451: invokeinterface 656 1 0
    //   456: istore 55
    //   458: aload 51
    //   460: invokeinterface 651 1 0
    //   465: invokeinterface 659 1 0
    //   470: astore 56
    //   472: aconst_null
    //   473: astore 57
    //   475: aload 51
    //   477: invokeinterface 663 1 0
    //   482: astore 58
    //   484: aconst_null
    //   485: astore 59
    //   487: sipush 200
    //   490: istore 60
    //   492: iload 55
    //   494: iload 60
    //   496: if_icmplt +15 -> 511
    //   499: sipush 300
    //   502: istore 61
    //   504: iload 55
    //   506: iload 61
    //   508: if_icmplt +329 -> 837
    //   511: aconst_null
    //   512: astore 62
    //   514: aload 58
    //   516: ifnull +88 -> 604
    //   519: aload 58
    //   521: invokeinterface 667 1 0
    //   526: astore 62
    //   528: aload_0
    //   529: aload 58
    //   531: invokespecial 669	com/androidquery/callback/AbstractAjaxCallback:getEncoding	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   534: astore 63
    //   536: aload_0
    //   537: astore 64
    //   539: aload 63
    //   541: astore 65
    //   543: aload 62
    //   545: astore 66
    //   547: aload 64
    //   549: aload 65
    //   551: aload 66
    //   553: invokespecial 673	com/androidquery/callback/AbstractAjaxCallback:toData	(Ljava/lang/String;Ljava/io/InputStream;)[B
    //   556: astore 67
    //   558: new 106	java/lang/String
    //   561: astore 68
    //   563: aload 68
    //   565: astore 69
    //   567: aload 67
    //   569: astore 70
    //   571: ldc 121
    //   573: astore 71
    //   575: aload 69
    //   577: aload 70
    //   579: aload 71
    //   581: invokespecial 227	java/lang/String:<init>	([BLjava/lang/String;)V
    //   584: ldc_w 675
    //   587: astore 72
    //   589: aload 68
    //   591: astore 73
    //   593: aload 72
    //   595: aload 73
    //   597: invokestatic 242	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   600: aload 68
    //   602: astore 57
    //   604: aload 62
    //   606: invokestatic 679	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   609: iload 55
    //   611: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: astore 74
    //   616: ldc_w 681
    //   619: aload 74
    //   621: invokestatic 242	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   624: aload 52
    //   626: ifnull +21 -> 647
    //   629: aload 52
    //   631: arraylength
    //   632: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   635: astore 75
    //   637: aload_2
    //   638: astore 76
    //   640: aload 75
    //   642: aload 76
    //   644: invokestatic 242	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   647: aload 4
    //   649: iload 55
    //   651: invokevirtual 684	com/androidquery/callback/AjaxStatus:code	(I)Lcom/androidquery/callback/AjaxStatus;
    //   654: astore 77
    //   656: aload 56
    //   658: astore 78
    //   660: aload 77
    //   662: aload 78
    //   664: invokevirtual 688	com/androidquery/callback/AjaxStatus:message	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
    //   667: aload 57
    //   669: invokevirtual 690	com/androidquery/callback/AjaxStatus:error	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
    //   672: astore 79
    //   674: aload 54
    //   676: astore 80
    //   678: aload 79
    //   680: aload 80
    //   682: invokevirtual 693	com/androidquery/callback/AjaxStatus:redirect	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
    //   685: astore 81
    //   687: new 395	java/util/Date
    //   690: dup
    //   691: invokespecial 694	java/util/Date:<init>	()V
    //   694: astore 82
    //   696: aload 81
    //   698: aload 82
    //   700: invokevirtual 402	com/androidquery/callback/AjaxStatus:time	(Ljava/util/Date;)Lcom/androidquery/callback/AjaxStatus;
    //   703: aload 52
    //   705: invokevirtual 261	com/androidquery/callback/AjaxStatus:data	([B)Lcom/androidquery/callback/AjaxStatus;
    //   708: astore 83
    //   710: aload 59
    //   712: astore 84
    //   714: aload 83
    //   716: aload 84
    //   718: invokevirtual 698	com/androidquery/callback/AjaxStatus:file	(Ljava/io/File;)Lcom/androidquery/callback/AjaxStatus;
    //   721: aload 21
    //   723: invokevirtual 701	com/androidquery/callback/AjaxStatus:client	(Lorg/apache/http/impl/client/DefaultHttpClient;)Lcom/androidquery/callback/AjaxStatus;
    //   726: aload 38
    //   728: invokevirtual 705	com/androidquery/callback/AjaxStatus:context	(Lorg/apache/http/protocol/HttpContext;)Lcom/androidquery/callback/AjaxStatus;
    //   731: astore 85
    //   733: aload 51
    //   735: invokeinterface 709 1 0
    //   740: astore 86
    //   742: aload 85
    //   744: aload 86
    //   746: invokevirtual 712	com/androidquery/callback/AjaxStatus:headers	([Lorg/apache/http/Header;)Lcom/androidquery/callback/AjaxStatus;
    //   749: astore 87
    //   751: return
    //   752: astore 88
    //   754: aload_0
    //   755: getfield 601	com/androidquery/callback/AbstractAjaxCallback:proxy	Lorg/apache/http/HttpHost;
    //   758: ifnull +51 -> 809
    //   761: ldc_w 714
    //   764: invokestatic 434	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
    //   767: aload 22
    //   769: astore 89
    //   771: ldc_w 603
    //   774: astore 90
    //   776: aconst_null
    //   777: astore 91
    //   779: aload 89
    //   781: aload 90
    //   783: aload 91
    //   785: invokeinterface 609 3 0
    //   790: astore 92
    //   792: aload_1
    //   793: astore 93
    //   795: aload 21
    //   797: aload 93
    //   799: aload 38
    //   801: invokevirtual 645	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   804: astore 51
    //   806: goto -368 -> 438
    //   809: aload 88
    //   811: athrow
    //   812: astore 94
    //   814: aload 94
    //   816: invokestatic 376	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
    //   819: aload 62
    //   821: invokestatic 679	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   824: goto -215 -> 609
    //   827: astore 95
    //   829: aload 62
    //   831: invokestatic 679	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   834: aload 95
    //   836: athrow
    //   837: ldc_w 716
    //   840: astore 96
    //   842: aload 38
    //   844: aload 96
    //   846: invokeinterface 719 2 0
    //   851: checkcast 721	org/apache/http/HttpHost
    //   854: astore 97
    //   856: ldc_w 723
    //   859: astore 98
    //   861: aload 38
    //   863: aload 98
    //   865: invokeinterface 719 2 0
    //   870: checkcast 559	org/apache/http/client/methods/HttpUriRequest
    //   873: astore 99
    //   875: aload 97
    //   877: invokevirtual 726	org/apache/http/HttpHost:toURI	()Ljava/lang/String;
    //   880: invokestatic 321	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   883: astore 100
    //   885: new 323	java/lang/StringBuilder
    //   888: dup
    //   889: aload 100
    //   891: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   894: astore 101
    //   896: aload 99
    //   898: invokeinterface 730 1 0
    //   903: astore 102
    //   905: aload 101
    //   907: aload 102
    //   909: invokevirtual 733	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: astore 54
    //   917: aload 58
    //   919: invokeinterface 736 1 0
    //   924: l2i
    //   925: istore 103
    //   927: ldc_w 737
    //   930: iload 103
    //   932: invokestatic 743	java/lang/Math:min	(II)I
    //   935: istore 104
    //   937: bipush 32
    //   939: iload 104
    //   941: invokestatic 746	java/lang/Math:max	(II)I
    //   944: istore 105
    //   946: aconst_null
    //   947: astore 106
    //   949: aconst_null
    //   950: astore 62
    //   952: aload_0
    //   953: invokespecial 748	com/androidquery/callback/AbstractAjaxCallback:getPreFile	()Ljava/io/File;
    //   956: astore 59
    //   958: aload 59
    //   960: ifnonnull +123 -> 1083
    //   963: new 750	com/androidquery/util/PredefinedBAOS
    //   966: astore 107
    //   968: aload 107
    //   970: astore 108
    //   972: iload 105
    //   974: istore 109
    //   976: aload 108
    //   978: iload 109
    //   980: invokespecial 751	com/androidquery/util/PredefinedBAOS:<init>	(I)V
    //   983: aload 107
    //   985: astore 106
    //   987: aload 58
    //   989: invokeinterface 667 1 0
    //   994: astore 110
    //   996: aload_0
    //   997: aload 58
    //   999: invokespecial 669	com/androidquery/callback/AbstractAjaxCallback:getEncoding	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1002: astore 111
    //   1004: aload 58
    //   1006: invokeinterface 736 1 0
    //   1011: l2i
    //   1012: istore 112
    //   1014: aload_0
    //   1015: astore 113
    //   1017: aload 110
    //   1019: astore 114
    //   1021: aload 106
    //   1023: astore 115
    //   1025: aload 111
    //   1027: astore 116
    //   1029: iload 112
    //   1031: istore 117
    //   1033: aload 113
    //   1035: aload 114
    //   1037: aload 115
    //   1039: aload 116
    //   1041: iload 117
    //   1043: invokespecial 753	com/androidquery/callback/AbstractAjaxCallback:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/lang/String;I)V
    //   1046: aload 106
    //   1048: invokevirtual 758	java/io/OutputStream:flush	()V
    //   1051: aload 59
    //   1053: ifnonnull +84 -> 1137
    //   1056: aload 106
    //   1058: checkcast 750	com/androidquery/util/PredefinedBAOS
    //   1061: invokevirtual 761	com/androidquery/util/PredefinedBAOS:toByteArray	()[B
    //   1064: lstore 118
    //   1066: lload 118
    //   1068: lstore 52
    //   1070: aload 62
    //   1072: invokestatic 679	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   1075: aload 106
    //   1077: invokestatic 679	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   1080: goto -471 -> 609
    //   1083: aload 59
    //   1085: invokevirtual 533	java/io/File:createNewFile	()Z
    //   1088: istore 120
    //   1090: new 763	java/io/BufferedOutputStream
    //   1093: astore 121
    //   1095: new 765	java/io/FileOutputStream
    //   1098: astore 122
    //   1100: aload 122
    //   1102: astore 123
    //   1104: aload 59
    //   1106: astore 124
    //   1108: aload 123
    //   1110: aload 124
    //   1112: invokespecial 768	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1115: aload 121
    //   1117: astore 125
    //   1119: aload 122
    //   1121: astore 126
    //   1123: aload 125
    //   1125: aload 126
    //   1127: invokespecial 771	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1130: aload 121
    //   1132: astore 106
    //   1134: goto -147 -> 987
    //   1137: aload 59
    //   1139: invokevirtual 371	java/io/File:exists	()Z
    //   1142: ifeq +19 -> 1161
    //   1145: aload 59
    //   1147: invokevirtual 774	java/io/File:length	()J
    //   1150: lstore 118
    //   1152: lload 118
    //   1154: ldc2_w 775
    //   1157: lcmp
    //   1158: ifne -88 -> 1070
    //   1161: aconst_null
    //   1162: astore 59
    //   1164: goto -94 -> 1070
    //   1167: astore 127
    //   1169: aload 62
    //   1171: invokestatic 679	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   1174: aload 106
    //   1176: invokestatic 679	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   1179: aload 127
    //   1181: athrow
    //   1182: astore 95
    //   1184: aload 68
    //   1186: astore 128
    //   1188: goto -359 -> 829
    //   1191: astore 94
    //   1193: aload 68
    //   1195: astore 57
    //   1197: goto -383 -> 814
    //
    // Exception table:
    //   from	to	target	type
    //   420	434	752	org/apache/http/conn/HttpHostConnectException
    //   519	584	812	java/lang/Exception
    //   519	584	827	finally
    //   814	819	827	finally
    //   952	1066	1167	finally
    //   1083	1152	1167	finally
    //   584	600	1182	finally
    //   584	600	1191	java/lang/Exception
  }

  private void httpEntity(String paramString, HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, Map<String, String> paramMap, Map<String, Object> paramMap1, AjaxStatus paramAjaxStatus)
    throws ClientProtocolException, IOException
  {
    HttpParams localHttpParams = paramHttpEntityEnclosingRequestBase.getParams().setBooleanParameter("http.protocol.expect-continue", false);
    Object localObject1 = paramMap1.get("%entity");
    Object localObject2;
    if ((localObject1 instanceof HttpEntity))
    {
      localObject2 = (HttpEntity)localObject1;
      if ((paramMap != null) && (!paramMap.containsKey("Content-Type")))
        Object localObject3 = paramMap.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
      paramHttpEntityEnclosingRequestBase.setEntity((HttpEntity)localObject2);
      httpDo(paramHttpEntityEnclosingRequestBase, paramString, paramMap, paramAjaxStatus);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap1.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localObject2 = new UrlEncodedFormEntity(localArrayList, "UTF-8");
        break;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObject1 = localEntry.getValue();
      if (localObject1 != null)
      {
        String str1 = (String)localEntry.getKey();
        String str2 = localObject1.toString();
        BasicNameValuePair localBasicNameValuePair = new BasicNameValuePair(str1, str2);
        boolean bool = localArrayList.add(localBasicNameValuePair);
      }
    }
  }

  private void httpGet(String paramString, Map<String, String> paramMap, AjaxStatus paramAjaxStatus)
    throws IOException
  {
    AQUtility.debug("get", paramString);
    String str = patchUrl(paramString);
    HttpGet localHttpGet = new HttpGet(str);
    httpDo(localHttpGet, str, paramMap, paramAjaxStatus);
  }

  private void httpMulti(String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1, AjaxStatus paramAjaxStatus)
    throws IOException
  {
    String str1 = paramString;
    AQUtility.debug("multipart", str1);
    String str2 = paramString;
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str2).openConnection();
    localHttpURLConnection.setInstanceFollowRedirects(false);
    int i = NET_TIMEOUT * 4;
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
    localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=*****");
    Iterator localIterator1;
    DataOutputStream localDataOutputStream;
    Iterator localIterator2;
    label194: int j;
    String str4;
    byte[] arrayOfByte1;
    String str5;
    String str6;
    if (paramMap != null)
    {
      localIterator1 = paramMap.keySet().iterator();
      if (localIterator1.hasNext());
    }
    else
    {
      String str3 = makeCookie();
      if (str3 != null)
        localHttpURLConnection.setRequestProperty("Cookie", str3);
      if (this.ah != null)
        this.ah.applyToken(this, localHttpURLConnection);
      OutputStream localOutputStream = localHttpURLConnection.getOutputStream();
      localDataOutputStream = new DataOutputStream(localOutputStream);
      localIterator2 = paramMap1.entrySet().iterator();
      if (localIterator2.hasNext())
        break label442;
      localDataOutputStream.writeBytes("--*****--\r\n");
      localDataOutputStream.flush();
      localDataOutputStream.close();
      localHttpURLConnection.connect();
      j = localHttpURLConnection.getResponseCode();
      str4 = localHttpURLConnection.getResponseMessage();
      arrayOfByte1 = null;
      str5 = localHttpURLConnection.getContentEncoding();
      str6 = null;
      if ((j >= 200) && (j < 300))
        break label487;
      InputStream localInputStream1 = localHttpURLConnection.getErrorStream();
      byte[] arrayOfByte2 = toData(str5, localInputStream1);
      str6 = new String(arrayOfByte2, "UTF-8");
      AQUtility.debug("error", str6);
    }
    while (true)
    {
      Integer localInteger1 = Integer.valueOf(j);
      AQUtility.debug("response", localInteger1);
      if (arrayOfByte1 != null)
      {
        Integer localInteger2 = Integer.valueOf(arrayOfByte1.length);
        String str7 = paramString;
        AQUtility.debug(localInteger2, str7);
      }
      AjaxStatus localAjaxStatus1 = paramAjaxStatus.code(j).message(str4);
      String str8 = paramString;
      AjaxStatus localAjaxStatus2 = localAjaxStatus1.redirect(str8);
      Date localDate = new Date();
      AjaxStatus localAjaxStatus3 = localAjaxStatus2.time(localDate).data(arrayOfByte1).error(str6).client(null);
      return;
      String str9 = (String)localIterator1.next();
      String str10 = (String)paramMap.get(str9);
      localHttpURLConnection.setRequestProperty(str9, str10);
      break;
      label442: Map.Entry localEntry = (Map.Entry)localIterator2.next();
      String str11 = (String)localEntry.getKey();
      Object localObject = localEntry.getValue();
      writeObject(localDataOutputStream, str11, localObject);
      break label194;
      label487: InputStream localInputStream2 = localHttpURLConnection.getInputStream();
      arrayOfByte1 = toData(str5, localInputStream2);
    }
  }

  private void httpPost(String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1, AjaxStatus paramAjaxStatus)
    throws ClientProtocolException, IOException
  {
    AQUtility.debug("post", paramString);
    HttpPost localHttpPost = new HttpPost(paramString);
    AbstractAjaxCallback localAbstractAjaxCallback = this;
    String str = paramString;
    Map<String, String> localMap = paramMap;
    Map<String, Object> localMap1 = paramMap1;
    AjaxStatus localAjaxStatus = paramAjaxStatus;
    localAbstractAjaxCallback.httpEntity(str, localHttpPost, localMap, localMap1, localAjaxStatus);
  }

  private void httpPut(String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1, AjaxStatus paramAjaxStatus)
    throws ClientProtocolException, IOException
  {
    AQUtility.debug("put", paramString);
    HttpPut localHttpPut = new HttpPut(paramString);
    AbstractAjaxCallback localAbstractAjaxCallback = this;
    String str = paramString;
    Map<String, String> localMap = paramMap;
    Map<String, Object> localMap1 = paramMap1;
    AjaxStatus localAjaxStatus = paramAjaxStatus;
    localAbstractAjaxCallback.httpEntity(str, localHttpPut, localMap, localMap1, localAjaxStatus);
  }

  private boolean isActive()
  {
    boolean bool = true;
    if (this.act == null);
    while (true)
    {
      return bool;
      Activity localActivity = (Activity)this.act.get();
      if ((localActivity == null) || (localActivity.isFinishing()))
        bool = false;
    }
  }

  private static boolean isMultiPart(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    if (!localIterator.hasNext());
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      AQUtility.debug(localEntry.getKey(), localObject);
      if ((!(localObject instanceof File)) && (!(localObject instanceof byte[])) && (!(localObject instanceof InputStream)))
        break;
    }
  }

  private String makeCookie()
  {
    String str1;
    if ((this.cookies == null) || (this.cookies.size() == 0))
    {
      str1 = null;
      return str1;
    }
    Iterator localIterator = this.cookies.keySet().iterator();
    StringBuilder localStringBuilder1 = new StringBuilder();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        str1 = localStringBuilder1.toString();
        break;
      }
      String str2 = (String)localIterator.next();
      String str3 = (String)this.cookies.get(str2);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
      StringBuilder localStringBuilder3 = localStringBuilder1.append("=");
      StringBuilder localStringBuilder4 = localStringBuilder1.append(str3);
      if (localIterator.hasNext())
        StringBuilder localStringBuilder5 = localStringBuilder1.append("; ");
    }
  }

  private void network()
    throws IOException
  {
    String str1 = this.url;
    Object localObject = this.params;
    if ((localObject == null) && (str1.length() > 2000))
    {
      Uri localUri = Uri.parse(str1);
      str1 = extractUrl(localUri);
      localObject = extractParams(localUri);
    }
    String str2 = getNetworkUrl(str1);
    int i = this.method;
    if (2 != i)
    {
      Map localMap1 = this.headers;
      AjaxStatus localAjaxStatus1 = this.status;
      httpDelete(str2, localMap1, localAjaxStatus1);
      return;
    }
    int j = this.method;
    if (3 != j)
    {
      Map localMap2 = this.headers;
      AjaxStatus localAjaxStatus2 = this.status;
      httpPut(str2, localMap2, (Map)localObject, localAjaxStatus2);
      return;
    }
    int k = this.method;
    if ((1 != k) && (localObject == null))
      localObject = new HashMap();
    if (localObject == null)
    {
      Map localMap3 = this.headers;
      AjaxStatus localAjaxStatus3 = this.status;
      httpGet(str2, localMap3, localAjaxStatus3);
      return;
    }
    if (isMultiPart((Map)localObject))
    {
      Map localMap4 = this.headers;
      AjaxStatus localAjaxStatus4 = this.status;
      httpMulti(str2, localMap4, (Map)localObject, localAjaxStatus4);
      return;
    }
    Map localMap5 = this.headers;
    AjaxStatus localAjaxStatus5 = this.status;
    httpPost(str2, localMap5, (Map)localObject, localAjaxStatus5);
  }

  private void networkWork()
  {
    if (this.url == null)
    {
      AjaxStatus localAjaxStatus1 = this.status.code(65435).done();
      return;
    }
    Object localObject1 = null;
    try
    {
      network();
      if (this.ah != null)
      {
        AccountHandle localAccountHandle = this.ah;
        AjaxStatus localAjaxStatus2 = this.status;
        if ((localAccountHandle.expired(this, localAjaxStatus2)) && (!this.reauth))
        {
          String str1 = this.status.getMessage();
          AQUtility.debug("reauth needed", str1);
          this.reauth = true;
          if (!this.ah.reauth(this))
            break label190;
          network();
        }
      }
      byte[] arrayOfByte = this.status.getData();
      localObject1 = arrayOfByte;
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          String str2 = this.url;
          AjaxStatus localAjaxStatus3 = this.status;
          Object localObject2 = transform(str2, localObject1, localAjaxStatus3);
          this.result = localObject2;
          if ((this.result == null) && (localObject1 != null))
            AjaxStatus localAjaxStatus4 = this.status.code(65433).message("transform error");
          lastStatus = this.status.getCode();
          AjaxStatus localAjaxStatus5 = this.status.done();
          return;
          label190: AjaxStatus localAjaxStatus6 = this.status.reauth(true);
          return;
          AQUtility.debug(localException1);
          AjaxStatus localAjaxStatus7 = this.status.code(65435).message("network error");
        }
      }
      catch (Exception localException2)
      {
        while (true)
          AQUtility.debug(localException2);
      }
    }
  }

  private String parseCharset(String paramString)
  {
    String str = null;
    if (paramString == null);
    while (true)
    {
      return str;
      int i = paramString.indexOf("charset");
      if (i != -1)
      {
        int j = i + 7;
        str = paramString.substring(j).replaceAll("[^\\w-]", "");
      }
    }
  }

  private static String patchUrl(String paramString)
  {
    return paramString.replaceAll(" ", "%20").replaceAll("\\|", "%7C");
  }

  private K self()
  {
    return this;
  }

  public static void setAgent(String paramString)
  {
    AGENT = paramString;
  }

  public static void setGZip(boolean paramBoolean)
  {
    GZIP = paramBoolean;
  }

  public static void setNetworkLimit(int paramInt)
  {
    int i = Math.min(25, paramInt);
    NETWORK_POOL = Math.max(1, i);
    fetchExe = null;
    Integer localInteger = Integer.valueOf(NETWORK_POOL);
    AQUtility.debug("setting network limit", localInteger);
  }

  public static void setReuseHttpClient(boolean paramBoolean)
  {
    REUSE_CLIENT = paramBoolean;
    client = null;
  }

  public static void setSSF(SocketFactory paramSocketFactory)
  {
    ssf = paramSocketFactory;
    client = null;
  }

  public static void setTimeout(int paramInt)
  {
    NET_TIMEOUT = paramInt;
  }

  public static void setTransformer(Transformer paramTransformer)
  {
    st = paramTransformer;
  }

  private byte[] toData(String paramString, InputStream paramInputStream)
    throws IOException
  {
    if ("gzip".equalsIgnoreCase(paramString))
      paramInputStream = new GZIPInputStream(paramInputStream);
    return AQUtility.toBytes(paramInputStream);
  }

  // ERROR //
  private void wake()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1047	com/androidquery/callback/AbstractAjaxCallback:blocked	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: invokevirtual 1050	java/lang/Object:notifyAll	()V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    //   22: astore_2
    //   23: goto -9 -> 14
    //
    // Exception table:
    //   from	to	target	type
    //   10	14	17	finally
    //   14	17	17	finally
    //   10	14	22	java/lang/Exception
  }

  private void work(Context paramContext)
  {
    String str = this.url;
    Object localObject = memGet(str);
    if (localObject != null)
    {
      this.result = localObject;
      AjaxStatus localAjaxStatus = this.status.source(4).done();
      callback();
      return;
    }
    int i = this.policy;
    File localFile = AQUtility.getCacheDir(paramContext, i);
    this.cacheDir = localFile;
    execute(this);
  }

  private static void writeData(DataOutputStream paramDataOutputStream, String paramString1, String paramString2, InputStream paramInputStream)
    throws IOException
  {
    paramDataOutputStream.writeBytes("--*****\r\n");
    String str = "Content-Disposition: form-data; name=\"" + paramString1 + "\";" + " filename=\"" + paramString2 + "\"" + "\r\n";
    paramDataOutputStream.writeBytes(str);
    paramDataOutputStream.writeBytes("\r\n");
    AQUtility.copy(paramInputStream, paramDataOutputStream);
    paramDataOutputStream.writeBytes("\r\n");
  }

  private static void writeField(DataOutputStream paramDataOutputStream, String paramString1, String paramString2)
    throws IOException
  {
    paramDataOutputStream.writeBytes("--*****\r\n");
    String str = "Content-Disposition: form-data; name=\"" + paramString1 + "\"";
    paramDataOutputStream.writeBytes(str);
    paramDataOutputStream.writeBytes("\r\n");
    paramDataOutputStream.writeBytes("\r\n");
    byte[] arrayOfByte = paramString2.getBytes("UTF-8");
    paramDataOutputStream.write(arrayOfByte);
    paramDataOutputStream.writeBytes("\r\n");
  }

  private static void writeObject(DataOutputStream paramDataOutputStream, String paramString, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
      return;
    if ((paramObject instanceof File))
    {
      File localFile = (File)paramObject;
      String str1 = localFile.getName();
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      writeData(paramDataOutputStream, paramString, str1, localFileInputStream);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      byte[] arrayOfByte = (byte[])paramObject;
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
      writeData(paramDataOutputStream, paramString, paramString, localByteArrayInputStream);
      return;
    }
    if ((paramObject instanceof InputStream))
    {
      InputStream localInputStream = (InputStream)paramObject;
      writeData(paramDataOutputStream, paramString, paramString, localInputStream);
      return;
    }
    String str2 = paramObject.toString();
    writeField(paramDataOutputStream, paramString, str2);
  }

  public void abort()
  {
    this.abort = true;
    if (this.request == null)
      return;
    if (this.request.isAborted())
      return;
    this.request.abort();
  }

  protected File accessFile(File paramFile, String paramString)
  {
    File localFile;
    if (this.expire < 0L)
      localFile = null;
    while (true)
    {
      return localFile;
      localFile = AQUtility.getExistedCacheByUrl(paramFile, paramString);
      if ((localFile != null) && (this.expire != 0L))
      {
        long l1 = System.currentTimeMillis();
        long l2 = localFile.lastModified();
        long l3 = l1 - l2;
        long l4 = this.expire;
        if (l3 > l4)
          localFile = null;
      }
    }
  }

  public void async(Activity paramActivity)
  {
    if (paramActivity.isFinishing())
      AQUtility.warn("Warning", "Possible memory leak. Calling ajax with a terminated activity.");
    if (this.type == null)
    {
      AQUtility.warn("Warning", "type() is not called with response type.");
      return;
    }
    WeakReference localWeakReference = new WeakReference(paramActivity);
    this.act = localWeakReference;
    async(paramActivity);
  }

  public void async(Context paramContext)
  {
    if (this.status == null)
    {
      AjaxStatus localAjaxStatus1 = new AjaxStatus();
      this.status = localAjaxStatus1;
      AjaxStatus localAjaxStatus2 = this.status;
      String str1 = this.url;
      AjaxStatus localAjaxStatus3 = localAjaxStatus2.redirect(str1);
      boolean bool = this.refresh;
      AjaxStatus localAjaxStatus4 = localAjaxStatus3.refresh(bool);
    }
    while (true)
    {
      showProgress(true);
      if ((this.ah == null) || (this.ah.authenticated()))
        break;
      String str2 = this.url;
      AQUtility.debug("auth needed", str2);
      this.ah.auth(this);
      return;
      if (this.status.getDone())
      {
        AjaxStatus localAjaxStatus5 = this.status.reset();
        this.result = null;
      }
    }
    work(paramContext);
  }

  public K auth(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((Build.VERSION.SDK_INT >= 5) && (paramString1.startsWith("g.")))
    {
      GoogleHandle localGoogleHandle = new GoogleHandle(paramActivity, paramString1, paramString2);
      this.ah = localGoogleHandle;
    }
    return self();
  }

  public K auth(AccountHandle paramAccountHandle)
  {
    this.ah = paramAccountHandle;
    return self();
  }

  public void block()
  {
    if (AQUtility.isUIThread())
      throw new IllegalStateException("Cannot block UI thread.");
    if (this.completed)
      return;
    try
    {
      boolean bool = true;
      try
      {
        this.blocked = bool;
        long l = NET_TIMEOUT + 5000;
        wait(l);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    catch (Exception localException)
    {
    }
  }

  protected boolean cacheAvailable(Context paramContext)
  {
    if (this.fileCache)
    {
      int i = this.policy;
      File localFile = AQUtility.getCacheDir(paramContext, i);
      String str = this.url;
      if (AQUtility.getExistedCacheByUrl(localFile, str) == null);
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  void callback()
  {
    showProgress(false);
    this.completed = true;
    if (isActive())
      if (this.callback != null)
      {
        Object localObject1 = getHandler();
        Class[] arrayOfClass1 = new Class[3];
        arrayOfClass1[0] = String.class;
        Class localClass = this.type;
        arrayOfClass1[1] = localClass;
        arrayOfClass1[2] = AjaxStatus.class;
        String str1 = this.callback;
        Class[] arrayOfClass2 = DEFAULT_SIG;
        Object[] arrayOfObject = new Object[3];
        String str2 = this.url;
        arrayOfObject[0] = str2;
        Object localObject2 = this.result;
        arrayOfObject[1] = localObject2;
        AjaxStatus localAjaxStatus1 = this.status;
        arrayOfObject[2] = localAjaxStatus1;
        boolean bool = true;
        Object localObject3 = AQUtility.invokeHandler(localObject1, str1, true, bool, arrayOfClass1, arrayOfClass2, arrayOfObject);
      }
    while (true)
    {
      filePut();
      if (!this.blocked)
        this.status.close();
      wake();
      AQUtility.debugNotify();
      return;
      try
      {
        String str3 = this.url;
        Object localObject4 = this.result;
        AjaxStatus localAjaxStatus2 = this.status;
        callback(str3, localObject4, localAjaxStatus2);
      }
      catch (Exception localException)
      {
        AQUtility.report(localException);
      }
      continue;
      String str4 = this.url;
      Object localObject5 = this.result;
      AjaxStatus localAjaxStatus3 = this.status;
      skip(str4, localObject5, localAjaxStatus3);
    }
  }

  public void callback(String paramString, T paramT, AjaxStatus paramAjaxStatus)
  {
  }

  public K cookie(String paramString1, String paramString2)
  {
    if (this.cookies == null)
    {
      HashMap localHashMap = new HashMap();
      this.cookies = localHashMap;
    }
    Object localObject = this.cookies.put(paramString1, paramString2);
    return self();
  }

  protected T datastoreGet(String paramString)
  {
    return null;
  }

  public K encoding(String paramString)
  {
    this.encoding = paramString;
    return self();
  }

  public K expire(long paramLong)
  {
    this.expire = paramLong;
    return self();
  }

  public void failure(int paramInt, String paramString)
  {
    if (this.status == null)
      return;
    AjaxStatus localAjaxStatus = this.status.code(paramInt).message(paramString);
    callback();
  }

  public K fileCache(boolean paramBoolean)
  {
    this.fileCache = paramBoolean;
    return self();
  }

  protected T fileGet(String paramString, File paramFile, AjaxStatus paramAjaxStatus)
  {
    Object localObject1 = null;
    try
    {
      if (isStreamingContent())
        AjaxStatus localAjaxStatus = paramAjaxStatus.file(paramFile);
      while (true)
      {
        localObject2 = transform(paramString, (byte[])localObject1, paramAjaxStatus);
        return localObject2;
        byte[] arrayOfByte = AQUtility.toBytes(new FileInputStream(paramFile));
        localObject1 = arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        AQUtility.debug(localException);
        Object localObject2 = null;
      }
    }
  }

  protected void filePut(String paramString, T paramT, File paramFile, byte[] paramArrayOfByte)
  {
    if (paramFile == null)
      return;
    if (paramArrayOfByte == null)
      return;
    AQUtility.storeAsync(paramFile, paramArrayOfByte, 0L);
  }

  protected File getCacheFile()
  {
    File localFile = this.cacheDir;
    String str = getCacheUrl();
    return AQUtility.getCacheFile(localFile, str);
  }

  public String getCallback()
  {
    return this.callback;
  }

  public String getEncoding()
  {
    return this.encoding;
  }

  public Object getHandler()
  {
    Object localObject;
    if (this.handler != null)
      localObject = this.handler;
    while (true)
    {
      return localObject;
      if (this.whandler == null)
        localObject = null;
      else
        localObject = this.whandler.get();
    }
  }

  public T getResult()
  {
    return this.result;
  }

  public AjaxStatus getStatus()
  {
    return this.status;
  }

  public Class<T> getType()
  {
    return this.type;
  }

  public String getUrl()
  {
    return this.url;
  }

  public K handler(Object paramObject, String paramString)
  {
    this.handler = paramObject;
    this.callback = paramString;
    this.whandler = null;
    return self();
  }

  public K header(String paramString1, String paramString2)
  {
    if (this.headers == null)
    {
      HashMap localHashMap = new HashMap();
      this.headers = localHashMap;
    }
    Object localObject = this.headers.put(paramString1, paramString2);
    return self();
  }

  protected boolean isStreamingContent()
  {
    Class localClass1 = this.type;
    if (!File.class.equals(localClass1))
    {
      Class localClass2 = this.type;
      if (!XmlPullParser.class.equals(localClass2))
      {
        Class localClass3 = this.type;
        if (!InputStream.class.equals(localClass3))
        {
          Class localClass4 = this.type;
          if (XmlDom.class.equals(localClass4));
        }
      }
    }
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public K memCache(boolean paramBoolean)
  {
    this.memCache = paramBoolean;
    return self();
  }

  protected T memGet(String paramString)
  {
    return null;
  }

  protected void memPut(String paramString, T paramT)
  {
  }

  public K method(int paramInt)
  {
    this.method = paramInt;
    return self();
  }

  public K networkUrl(String paramString)
  {
    this.networkUrl = paramString;
    return self();
  }

  public K param(String paramString, Object paramObject)
  {
    if (this.params == null)
    {
      HashMap localHashMap = new HashMap();
      this.params = localHashMap;
    }
    Object localObject = this.params.put(paramString, paramObject);
    return self();
  }

  public K params(Map<String, ?> paramMap)
  {
    this.params = paramMap;
    return self();
  }

  public K policy(int paramInt)
  {
    this.policy = paramInt;
    return self();
  }

  public K progress(Dialog paramDialog)
  {
    return progress(paramDialog);
  }

  public K progress(View paramView)
  {
    return progress(paramView);
  }

  public K progress(Object paramObject)
  {
    if (paramObject != null)
    {
      WeakReference localWeakReference = new WeakReference(paramObject);
      this.progress = localWeakReference;
    }
    return self();
  }

  public K proxy(String paramString, int paramInt)
  {
    HttpHost localHttpHost = new HttpHost(paramString, paramInt);
    this.proxy = localHttpHost;
    return self();
  }

  public K refresh(boolean paramBoolean)
  {
    this.refresh = paramBoolean;
    return self();
  }

  public void run()
  {
    if (!this.status.getDone())
      try
      {
        backgroundWork();
        if (this.status.getReauth())
          return;
        if (this.uiCallback)
        {
          AQUtility.post(this);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        while (true)
        {
          AQUtility.debug(localThrowable);
          AjaxStatus localAjaxStatus = this.status.code(65435).done();
        }
        afterWork();
        return;
      }
    afterWork();
  }

  protected void showProgress(final boolean paramBoolean)
  {
    if (this.progress == null);
    for (final Object localObject = null; ; localObject = this.progress.get())
    {
      if (localObject == null)
        return;
      if (!AQUtility.isUIThread())
        break;
      String str = this.url;
      Common.showProgress(localObject, str, paramBoolean);
      return;
    }
    AQUtility.post(new Runnable()
    {
      public void run()
      {
        Object localObject = localObject;
        String str = AbstractAjaxCallback.this.url;
        boolean bool = paramBoolean;
        Common.showProgress(localObject, str, bool);
      }
    });
  }

  protected void skip(String paramString, T paramT, AjaxStatus paramAjaxStatus)
  {
  }

  public K targetFile(File paramFile)
  {
    this.targetFile = paramFile;
    return self();
  }

  public K timeout(int paramInt)
  {
    this.timeout = paramInt;
    return self();
  }

  // ERROR //
  protected T transform(String paramString, byte[] paramArrayOfByte, AjaxStatus paramAjaxStatus)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   4: ifnonnull +9 -> 13
    //   7: aconst_null
    //   8: astore 4
    //   10: aload 4
    //   12: areturn
    //   13: aload_3
    //   14: invokevirtual 1273	com/androidquery/callback/AjaxStatus:getFile	()Ljava/io/File;
    //   17: astore 5
    //   19: aload_2
    //   20: ifnull +412 -> 432
    //   23: aload_0
    //   24: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   27: ldc_w 1275
    //   30: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +19 -> 52
    //   36: aload_2
    //   37: arraylength
    //   38: istore 6
    //   40: aload_2
    //   41: iconst_0
    //   42: iload 6
    //   44: invokestatic 1281	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   47: astore 4
    //   49: goto -39 -> 10
    //   52: aload_0
    //   53: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   56: ldc_w 1283
    //   59: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +79 -> 141
    //   65: aconst_null
    //   66: astore 4
    //   68: aconst_null
    //   69: astore 7
    //   71: new 106	java/lang/String
    //   74: astore 8
    //   76: aload_0
    //   77: getfield 123	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
    //   80: astore 9
    //   82: aload 8
    //   84: astore 10
    //   86: aload_2
    //   87: astore 11
    //   89: aload 10
    //   91: aload 11
    //   93: aload 9
    //   95: invokespecial 227	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: aload 8
    //   100: astore 12
    //   102: new 1285	org/json/JSONTokener
    //   105: dup
    //   106: aload 12
    //   108: invokespecial 1286	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   111: invokevirtual 1289	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   114: checkcast 1283	org/json/JSONObject
    //   117: astore 4
    //   119: aload 8
    //   121: astore 13
    //   123: goto -113 -> 10
    //   126: astore 14
    //   128: aload 14
    //   130: invokestatic 376	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
    //   133: aload 7
    //   135: invokestatic 434	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
    //   138: goto -128 -> 10
    //   141: aload_0
    //   142: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   145: ldc_w 1291
    //   148: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +51 -> 202
    //   154: aload_0
    //   155: getfield 123	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
    //   158: astore 15
    //   160: aload_2
    //   161: astore 16
    //   163: new 106	java/lang/String
    //   166: dup
    //   167: aload 16
    //   169: aload 15
    //   171: invokespecial 227	java/lang/String:<init>	([BLjava/lang/String;)V
    //   174: astore 17
    //   176: new 1285	org/json/JSONTokener
    //   179: dup
    //   180: aload 17
    //   182: invokespecial 1286	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   185: invokevirtual 1289	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   188: checkcast 1291	org/json/JSONArray
    //   191: astore 4
    //   193: goto -183 -> 10
    //   196: invokestatic 376	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
    //   199: goto -189 -> 10
    //   202: aload_0
    //   203: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   206: ldc 106
    //   208: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   211: ifeq +92 -> 303
    //   214: aconst_null
    //   215: astore 4
    //   217: aload_3
    //   218: invokevirtual 355	com/androidquery/callback/AjaxStatus:getSource	()I
    //   221: iconst_1
    //   222: if_icmpne +40 -> 262
    //   225: ldc_w 1292
    //   228: invokestatic 434	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
    //   231: aload_0
    //   232: getfield 123	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
    //   235: astore 18
    //   237: aload_0
    //   238: astore 19
    //   240: aload_2
    //   241: astore 20
    //   243: aload_3
    //   244: astore 21
    //   246: aload 19
    //   248: aload 20
    //   250: aload 18
    //   252: aload 21
    //   254: invokespecial 1294	com/androidquery/callback/AbstractAjaxCallback:correctEncoding	([BLjava/lang/String;Lcom/androidquery/callback/AjaxStatus;)Ljava/lang/String;
    //   257: astore 4
    //   259: goto -249 -> 10
    //   262: ldc_w 1295
    //   265: invokestatic 434	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
    //   268: aload_0
    //   269: getfield 123	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
    //   272: astore 22
    //   274: aload_2
    //   275: astore 23
    //   277: new 106	java/lang/String
    //   280: dup
    //   281: aload 23
    //   283: aload 22
    //   285: invokespecial 227	java/lang/String:<init>	([BLjava/lang/String;)V
    //   288: astore 24
    //   290: aload 24
    //   292: astore 4
    //   294: goto -284 -> 10
    //   297: invokestatic 376	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
    //   300: goto -290 -> 10
    //   303: aload_0
    //   304: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   307: ldc_w 932
    //   310: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   313: ifeq +9 -> 322
    //   316: aload_2
    //   317: astore 4
    //   319: goto -309 -> 10
    //   322: aload_0
    //   323: getfield 183	com/androidquery/callback/AbstractAjaxCallback:transformer	Lcom/androidquery/callback/Transformer;
    //   326: ifnull +52 -> 378
    //   329: aload_0
    //   330: getfield 183	com/androidquery/callback/AbstractAjaxCallback:transformer	Lcom/androidquery/callback/Transformer;
    //   333: astore 25
    //   335: aload_0
    //   336: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   339: astore 26
    //   341: aload_0
    //   342: getfield 123	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
    //   345: astore 27
    //   347: aload_1
    //   348: astore 28
    //   350: aload_2
    //   351: astore 29
    //   353: aload_3
    //   354: astore 30
    //   356: aload 25
    //   358: aload 28
    //   360: aload 26
    //   362: aload 27
    //   364: aload 29
    //   366: aload 30
    //   368: invokeinterface 1300 6 0
    //   373: astore 4
    //   375: goto -365 -> 10
    //   378: getstatic 1040	com/androidquery/callback/AbstractAjaxCallback:st	Lcom/androidquery/callback/Transformer;
    //   381: ifnull +251 -> 632
    //   384: getstatic 1040	com/androidquery/callback/AbstractAjaxCallback:st	Lcom/androidquery/callback/Transformer;
    //   387: astore 31
    //   389: aload_0
    //   390: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   393: astore 32
    //   395: aload_0
    //   396: getfield 123	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
    //   399: astore 33
    //   401: aload_1
    //   402: astore 34
    //   404: aload_2
    //   405: astore 35
    //   407: aload_3
    //   408: astore 36
    //   410: aload 31
    //   412: aload 34
    //   414: aload 32
    //   416: aload 33
    //   418: aload 35
    //   420: aload 36
    //   422: invokeinterface 1300 6 0
    //   427: astore 4
    //   429: goto -419 -> 10
    //   432: aload 5
    //   434: ifnull +198 -> 632
    //   437: aload_0
    //   438: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   441: ldc_w 368
    //   444: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   447: ifeq +10 -> 457
    //   450: aload 5
    //   452: astore 4
    //   454: goto -444 -> 10
    //   457: aload_0
    //   458: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   461: ldc_w 1237
    //   464: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   467: ifeq +51 -> 518
    //   470: new 1086	java/io/FileInputStream
    //   473: dup
    //   474: aload 5
    //   476: invokespecial 1087	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   479: astore 37
    //   481: new 1237	com/androidquery/util/XmlDom
    //   484: dup
    //   485: aload 37
    //   487: invokespecial 1301	com/androidquery/util/XmlDom:<init>	(Ljava/io/InputStream;)V
    //   490: astore 24
    //   492: aload_3
    //   493: aload 37
    //   495: invokevirtual 1304	com/androidquery/callback/AjaxStatus:closeLater	(Ljava/io/Closeable;)V
    //   498: aload 24
    //   500: astore 4
    //   502: goto -492 -> 10
    //   505: astore 14
    //   507: aload 14
    //   509: invokestatic 246	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
    //   512: aconst_null
    //   513: astore 4
    //   515: goto -505 -> 10
    //   518: aload_0
    //   519: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   522: ldc_w 1235
    //   525: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   528: ifeq +58 -> 586
    //   531: invokestatic 1310	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   534: astore 38
    //   536: new 1086	java/io/FileInputStream
    //   539: dup
    //   540: aload 5
    //   542: invokespecial 1087	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   545: astore 39
    //   547: aload_0
    //   548: getfield 123	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
    //   551: astore 40
    //   553: aload 38
    //   555: aload 39
    //   557: aload 40
    //   559: invokeinterface 1314 3 0
    //   564: aload_3
    //   565: aload 39
    //   567: invokevirtual 1304	com/androidquery/callback/AjaxStatus:closeLater	(Ljava/io/Closeable;)V
    //   570: aload 38
    //   572: astore 4
    //   574: goto -564 -> 10
    //   577: invokestatic 246	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
    //   580: aconst_null
    //   581: astore 4
    //   583: goto -573 -> 10
    //   586: aload_0
    //   587: getfield 1121	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
    //   590: ldc_w 934
    //   593: invokevirtual 1233	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   596: ifeq +36 -> 632
    //   599: new 1086	java/io/FileInputStream
    //   602: dup
    //   603: aload 5
    //   605: invokespecial 1087	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   608: astore 37
    //   610: aload_3
    //   611: aload 37
    //   613: invokevirtual 1304	com/androidquery/callback/AjaxStatus:closeLater	(Ljava/io/Closeable;)V
    //   616: aload 37
    //   618: astore 4
    //   620: goto -610 -> 10
    //   623: invokestatic 246	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
    //   626: aconst_null
    //   627: astore 4
    //   629: goto -619 -> 10
    //   632: aconst_null
    //   633: astore 4
    //   635: goto -625 -> 10
    //   638: astore 14
    //   640: aload 24
    //   642: astore 41
    //   644: goto -137 -> 507
    //   647: astore 14
    //   649: aload 8
    //   651: astore 7
    //   653: goto -525 -> 128
    //
    // Exception table:
    //   from	to	target	type
    //   71	98	126	java/lang/Exception
    //   154	193	196	java/lang/Exception
    //   268	290	297	java/lang/Exception
    //   470	492	505	java/lang/Exception
    //   536	570	577	java/lang/Exception
    //   599	616	623	java/lang/Exception
    //   492	498	638	java/lang/Exception
    //   98	119	647	java/lang/Exception
  }

  public K transformer(Transformer paramTransformer)
  {
    this.transformer = paramTransformer;
    return self();
  }

  public K type(Class<T> paramClass)
  {
    this.type = paramClass;
    return self();
  }

  public K uiCallback(boolean paramBoolean)
  {
    this.uiCallback = paramBoolean;
    return self();
  }

  public K url(String paramString)
  {
    this.url = paramString;
    return self();
  }

  public K weakHandler(Object paramObject, String paramString)
  {
    WeakReference localWeakReference = new WeakReference(paramObject);
    this.whandler = localWeakReference;
    this.callback = paramString;
    this.handler = null;
    return self();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.callback.AbstractAjaxCallback
 * JD-Core Version:    0.6.2
 */