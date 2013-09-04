package crittercism.android;

import android.content.Context;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class c
{
  private final DefaultHttpClient a;
  private final String b;
  private Context c;

  public c()
  {
    this.b = "";
    DefaultHttpClient localDefaultHttpClient = a();
    this.a = localDefaultHttpClient;
  }

  public c(String paramString)
  {
    this.b = paramString;
    DefaultHttpClient localDefaultHttpClient = a();
    this.a = localDefaultHttpClient;
  }

  public c(String paramString, Context paramContext)
  {
    this.b = paramString;
    DefaultHttpClient localDefaultHttpClient = a();
    this.a = localDefaultHttpClient;
    this.c = paramContext;
  }

  private String a(HttpRequestBase paramHttpRequestBase)
  {
    int i = 0;
    Object localObject = "";
    try
    {
      this.a.getConnectionManager().closeExpiredConnections();
      HttpResponse localHttpResponse = this.a.execute(paramHttpRequestBase);
      int j = localHttpResponse.getStatusLine().getStatusCode();
      switch (j)
      {
      default:
        String str1 = c.class.getCanonicalName();
        StringBuilder localStringBuilder1 = new StringBuilder("executeHttpRequest error=").append(j).append(" - ");
        String str2 = localHttpResponse.getStatusLine().toString();
        String str3 = str2;
        localHttpResponse.getEntity().consumeContent();
      case 200:
      }
      while (true)
      {
        return localObject;
        String str4 = EntityUtils.toString(localHttpResponse.getEntity(), "UTF-8");
        localObject = str4;
      }
    }
    catch (ConnectTimeoutException localConnectTimeoutException)
    {
      String str5 = c.class.getClass().getCanonicalName();
      String str6 = a.a(11);
      g.a locala1 = g.a.b;
      throw new g(str6, locala1);
    }
    catch (IOException localIOException)
    {
      paramHttpRequestBase.abort();
      localIOException.printStackTrace();
      int k = i;
      while (true)
      {
        int m = paramHttpRequestBase.getAllHeaders().length;
        if (k >= m)
          break;
        Header localHeader = paramHttpRequestBase.getAllHeaders()[k];
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str7 = localHeader.getName();
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str7).append(": ");
        String str8 = localHeader.getValue();
        String str9 = str8;
        k += 1;
      }
      if (localIOException.getMessage().toLowerCase().contains("no route to host"))
      {
        String str10 = a.a(10);
        g.a locala2 = g.a.a;
        throw new g(str10, locala2);
      }
      if (localIOException.getStackTrace()[i].toString().contains("java.net.InetAddress.lookupHostByName"))
      {
        String str11 = c.class.getClass().getCanonicalName();
        String str12 = a.a(10);
        g.a locala3 = g.a.a;
        throw new g(str12, locala3);
      }
      throw localIOException;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str13 = c.class.getClass().getCanonicalName();
        StringBuilder localStringBuilder4 = new StringBuilder("Neither ConnectTimeoutException nor IOException.  Instead: ");
        String str14 = localException.getClass().getName();
        String str15 = str14;
        localException.printStackTrace();
      }
    }
  }

  private static DefaultHttpClient a()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    PlainSocketFactory localPlainSocketFactory = PlainSocketFactory.getSocketFactory();
    Scheme localScheme1 = new Scheme("http", localPlainSocketFactory, 80);
    Scheme localScheme2 = localSchemeRegistry.register(localScheme1);
    X509HostnameVerifier localX509HostnameVerifier1 = SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
    SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    X509HostnameVerifier localX509HostnameVerifier2 = (X509HostnameVerifier)localX509HostnameVerifier1;
    localSSLSocketFactory.setHostnameVerifier(localX509HostnameVerifier2);
    Scheme localScheme3 = new Scheme("https", localSSLSocketFactory, 443);
    Scheme localScheme4 = localSchemeRegistry.register(localScheme3);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpClientParams.setRedirecting(localBasicHttpParams, false);
    ThreadSafeClientConnManager localThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
    return new DefaultHttpClient(localThreadSafeClientConnManager, localBasicHttpParams);
  }

  public final String a(String paramString)
  {
    HttpGet localHttpGet = new HttpGet(paramString);
    String str = this.b;
    localHttpGet.addHeader("User-Agent", str);
    return a(localHttpGet);
  }

  // ERROR //
  public final String a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 149	java/lang/String
    //   3: dup
    //   4: invokespecial 256	java/lang/String:<init>	()V
    //   7: astore 4
    //   9: bipush 30
    //   11: newarray byte
    //   13: astore 5
    //   15: new 258	java/util/Random
    //   18: dup
    //   19: invokespecial 259	java/util/Random:<init>	()V
    //   22: aload 5
    //   24: invokevirtual 263	java/util/Random:nextBytes	([B)V
    //   27: aload 5
    //   29: invokestatic 268	crittercism/android/h:a	([B)Ljava/lang/String;
    //   32: istore 6
    //   34: new 69	java/lang/StringBuilder
    //   37: dup
    //   38: ldc_w 270
    //   41: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: iload 6
    //   46: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 7
    //   54: new 272	org/apache/http/client/methods/HttpPost
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 273	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   62: astore 8
    //   64: aload_0
    //   65: getfield 18	crittercism/android/c:b	Ljava/lang/String;
    //   68: astore 9
    //   70: aload 8
    //   72: ldc 248
    //   74: aload 9
    //   76: invokevirtual 274	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: new 69	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 276
    //   86: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: iload 6
    //   91: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 278
    //   97: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 10
    //   105: aload 8
    //   107: ldc_w 280
    //   110: aload 10
    //   112: invokevirtual 274	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 8
    //   117: ldc_w 282
    //   120: ldc_w 284
    //   123: invokevirtual 274	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 8
    //   128: ldc_w 286
    //   131: ldc_w 288
    //   134: invokevirtual 274	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: new 69	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 290
    //   144: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: iload 6
    //   149: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc_w 292
    //   155: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_2
    //   159: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 294
    //   165: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: astore 11
    //   170: aload_3
    //   171: invokevirtual 297	org/json/JSONObject:toString	()Ljava/lang/String;
    //   174: astore 12
    //   176: aload 11
    //   178: aload 12
    //   180: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 299
    //   186: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 6
    //   191: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc_w 290
    //   197: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: ldc 97
    //   205: invokevirtual 303	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   208: astore 13
    //   210: new 305	org/apache/http/entity/ByteArrayEntity
    //   213: dup
    //   214: aload 13
    //   216: invokespecial 307	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   219: astore 14
    //   221: aload 8
    //   223: aload 14
    //   225: invokevirtual 311	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   228: new 313	java/io/ByteArrayOutputStream
    //   231: dup
    //   232: invokespecial 314	java/io/ByteArrayOutputStream:<init>	()V
    //   235: astore 15
    //   237: aload 14
    //   239: aload 15
    //   241: invokevirtual 318	org/apache/http/entity/ByteArrayEntity:writeTo	(Ljava/io/OutputStream;)V
    //   244: iconst_0
    //   245: istore 6
    //   247: aload 8
    //   249: invokevirtual 319	org/apache/http/client/methods/HttpPost:getAllHeaders	()[Lorg/apache/http/Header;
    //   252: arraylength
    //   253: istore 16
    //   255: iload 6
    //   257: iload 16
    //   259: if_icmpge +75 -> 334
    //   262: aload 8
    //   264: invokevirtual 319	org/apache/http/client/methods/HttpPost:getAllHeaders	()[Lorg/apache/http/Header;
    //   267: iload 6
    //   269: aaload
    //   270: astore 17
    //   272: new 69	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   279: astore 18
    //   281: aload 17
    //   283: invokeinterface 139 1 0
    //   288: astore 19
    //   290: aload 18
    //   292: aload 19
    //   294: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc 141
    //   299: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: astore 20
    //   304: aload 17
    //   306: invokeinterface 144 1 0
    //   311: astore 21
    //   313: aload 20
    //   315: aload 21
    //   317: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: astore 22
    //   325: iload 6
    //   327: iconst_1
    //   328: iadd
    //   329: istore 6
    //   331: goto -84 -> 247
    //   334: aload 15
    //   336: ldc 97
    //   338: invokevirtual 321	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 23
    //   343: aload_0
    //   344: aload 8
    //   346: invokespecial 254	crittercism/android/c:a	(Lorg/apache/http/client/methods/HttpRequestBase;)Ljava/lang/String;
    //   349: areturn
    //   350: istore 6
    //   352: new 69	java/lang/StringBuilder
    //   355: dup
    //   356: ldc_w 323
    //   359: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: astore 24
    //   364: iload 6
    //   366: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   369: invokevirtual 172	java/lang/Class:getName	()Ljava/lang/String;
    //   372: astore 25
    //   374: aload 24
    //   376: aload 25
    //   378: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: astore 26
    //   386: goto -43 -> 343
    //   389: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   137	343	350	java/lang/Exception
    //   137	343	389	finally
    //   352	386	389	finally
  }

  public final String a(String paramString, List paramList)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    String str = this.b;
    localHttpPost.addHeader("User-Agent", str);
    try
    {
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(paramList, "UTF-8");
      localHttpPost.setEntity(localUrlEncodedFormEntity);
      return a(localHttpPost);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new IllegalArgumentException("Error encoding http params");
  }

  public final String a(String paramString, JSONObject paramJSONObject)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    String str1 = this.b;
    localHttpPost.addHeader("User-Agent", str1);
    localHttpPost.addHeader("Content-Type", "application/json");
    try
    {
      byte[] arrayOfByte = paramJSONObject.toString().getBytes("UTF8");
      ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(arrayOfByte);
      localHttpPost.setEntity(localByteArrayEntity);
      StringBuilder localStringBuilder1 = new StringBuilder("JSON Object for request: ");
      String str2 = paramJSONObject.toString();
      String str3 = str2;
      StringBuilder localStringBuilder2 = new StringBuilder("httpPost Entity is: ");
      String str4 = localHttpPost.getEntity().getContent().toString();
      String str5 = str4;
      return a(localHttpPost);
    }
    catch (Exception localException)
    {
    }
    throw new IllegalArgumentException("Error encoding http params");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     crittercism.android.c
 * JD-Core Version:    0.6.2
 */