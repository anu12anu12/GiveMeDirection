package com.MASTAdView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.UUID;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.ByteArrayBuffer;

public class ContentManager
{
  private static final String INSTALLATION = "INSTALLATION";
  private static ContentManager instance;
  private static boolean isSimAvailable;
  private String autoDetectParameters = "";
  private Context context;
  private String id;
  private HashMap<MASTAdViewCore, ContentParameters> senderParameters;
  private boolean useSystemDeviceId;
  private String userAgent = "";

  private ContentManager(WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    this.senderParameters = localHashMap;
    this.id = null;
    this.useSystemDeviceId = false;
    String str = paramWebView.getSettings().getUserAgentString();
    this.userAgent = str;
    Context localContext = paramWebView.getContext().getApplicationContext();
    this.context = localContext;
    runInitDefaultParameters();
  }

  private String getDeviceId(TelephonyManager paramTelephonyManager)
  {
    if (this.id != null)
    {
      localObject = this.id;
      return localObject;
    }
    Object localObject = null;
    String str1;
    if (this.useSystemDeviceId)
    {
      str1 = paramTelephonyManager.getDeviceId();
      if (str1 == null)
        break label43;
      String str2 = str1;
    }
    while (true)
    {
      this.id = ((String)localObject);
      break;
      label43: str1 = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
      if (str1 != null)
      {
        localObject = str1;
      }
      else
      {
        Context localContext = this.context;
        localObject = makeDeviceId(localContext);
      }
    }
  }

  public static ContentManager getInstance(WebView paramWebView)
  {
    if (instance == null)
      instance = new ContentManager(paramWebView);
    return instance;
  }

  private void initDefaultParameters()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.context.getSystemService("phone");
    boolean bool;
    Integer localInteger;
    int i;
    int j;
    if (localTelephonyManager.getSimState() > 1)
    {
      bool = true;
      isSimAvailable = bool;
      String str1 = getDeviceId(localTelephonyManager);
      String str2 = null;
      if (str1 != null)
        str2 = Utils.md5(str1);
      this.autoDetectParameters = "";
      if (localTelephonyManager != null)
      {
        String str3 = localTelephonyManager.getNetworkOperator();
        if ((str3 != null) && (str3.length() > 3))
        {
          String str4 = str3.substring(0, 3);
          String str5 = str3.substring(3);
          String str6 = String.valueOf(this.autoDetectParameters);
          String str7 = str6 + "&mcc=" + str4;
          this.autoDetectParameters = str7;
          String str8 = String.valueOf(this.autoDetectParameters);
          String str9 = str8 + "&mnc=" + str5;
          this.autoDetectParameters = str9;
        }
      }
      if ((str2 != null) && (str2.length() > 0))
      {
        String str10 = String.valueOf(this.autoDetectParameters);
        String str11 = str10 + "&udid=" + str2;
        this.autoDetectParameters = str11;
      }
      localInteger = null;
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        i = localNetworkInfo.getType();
        j = localNetworkInfo.getSubtype();
        if (i != 1)
          break label336;
        localInteger = Integer.valueOf(1);
      }
    }
    while (true)
    {
      if (localInteger == null)
        return;
      String str12 = String.valueOf(this.autoDetectParameters);
      StringBuilder localStringBuilder = new StringBuilder(str12).append("&connection_speed=");
      String str13 = localInteger.toString();
      String str14 = str13;
      this.autoDetectParameters = str14;
      return;
      bool = false;
      break;
      label336: if (i == 0)
        if (j == 2)
          localInteger = Integer.valueOf(0);
        else if (j == 1)
          localInteger = Integer.valueOf(0);
        else if (j == 3)
          localInteger = Integer.valueOf(1);
    }
  }

  public static boolean isSimAvailable()
  {
    return isSimAvailable;
  }

  /** @deprecated */
  private String makeDeviceId(Context paramContext)
  {
    try
    {
      File localFile2;
      if (this.id == null)
      {
        File localFile1 = paramContext.getFilesDir();
        localFile2 = new File(localFile1, "INSTALLATION");
      }
      try
      {
        if (!localFile2.exists())
          writeInstallationFile(localFile2);
        String str1 = readInstallationFile(localFile2);
        this.id = str1;
        String str2 = this.id;
        return str2;
      }
      catch (Exception localException)
      {
        while (true)
          this.id = "1234567890";
      }
    }
    finally
    {
    }
  }

  private static String readInstallationFile(File paramFile)
    throws IOException
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)localRandomAccessFile.length()];
    localRandomAccessFile.readFully(arrayOfByte);
    localRandomAccessFile.close();
    return new String(arrayOfByte);
  }

  private void runInitDefaultParameters()
  {
    Thread local1 = new Thread()
    {
      public void run()
      {
        ContentManager.this.initDefaultParameters();
      }
    };
    local1.setName("[ContentManager] InitDefaultParameters");
    local1.start();
  }

  private static void writeInstallationFile(File paramFile)
    throws IOException
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    byte[] arrayOfByte = UUID.randomUUID().toString().getBytes();
    localFileOutputStream.write(arrayOfByte);
    localFileOutputStream.close();
  }

  public String getAutoDetectParameters()
  {
    return this.autoDetectParameters;
  }

  public String getDeviceId()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.context.getSystemService("phone");
    return getDeviceId(localTelephonyManager);
  }

  public boolean getUseSystemDeviceId()
  {
    return this.useSystemDeviceId;
  }

  public String getUserAgent()
  {
    return this.userAgent;
  }

  public boolean sendImpr(String paramString)
  {
    boolean bool = false;
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpGet localHttpGet = new HttpGet(paramString);
    try
    {
      int i = localDefaultHttpClient.execute(localHttpGet).getStatusLine().getStatusCode();
      if (i != 200)
        return bool;
    }
    catch (Exception localException)
    {
      while (true)
      {
        continue;
        bool = true;
      }
    }
  }

  public void sendImpression(final String paramString, final MASTAdLog paramMASTAdLog)
  {
    new Thread()
    {
      public void run()
      {
        ContentManager localContentManager = ContentManager.this;
        String str1 = paramString;
        if (localContentManager.sendImpr(str1))
          return;
        MASTAdLog localMASTAdLog = paramMASTAdLog;
        String str2 = paramString;
        localMASTAdLog.log(1, 2, "Impression is not sent", str2);
      }
    }
    .start();
  }

  public void setDeviceId(String paramString)
  {
    int i = 0;
    if ((this.id != null) && (this.id.compareTo(paramString) != 0))
      i = 1;
    this.id = paramString;
    if (i == 0)
      return;
    runInitDefaultParameters();
  }

  public void setUseSystemDeviceId(boolean paramBoolean)
  {
    int i = 0;
    if (this.useSystemDeviceId != paramBoolean)
      i = 1;
    this.useSystemDeviceId = paramBoolean;
    if (i == 0)
      return;
    runInitDefaultParameters();
  }

  public void startLoadContent(MASTAdViewCore paramMASTAdViewCore, String paramString)
  {
    if (this.senderParameters.containsKey(paramMASTAdViewCore))
      stopLoadContent(paramMASTAdViewCore);
    ContentParameters localContentParameters = new ContentParameters(null);
    localContentParameters.sender = paramMASTAdViewCore;
    localContentParameters.url = paramString;
    Object localObject = this.senderParameters.put(paramMASTAdViewCore, localContentParameters);
    ContentThread localContentThread = new ContentThread(localContentParameters);
    localContentParameters.cTh = localContentThread;
    localContentThread.setName("[ContentManager] LoadContent");
    localContentThread.start();
  }

  public void stopLoadContent(MASTAdViewCore paramMASTAdViewCore)
  {
    if (!this.senderParameters.containsKey(paramMASTAdViewCore))
      return;
    ((ContentParameters)this.senderParameters.get(paramMASTAdViewCore)).sender = null;
    ((ContentParameters)this.senderParameters.get(paramMASTAdViewCore)).cTh.cancel();
    Object localObject = this.senderParameters.remove(paramMASTAdViewCore);
  }

  class AsyncImpression
  {
    public int counter = 0;
    public String uri;

    AsyncImpression()
    {
    }
  }

  private class ContentParameters
  {
    ContentManager.ContentThread cTh;
    public MASTAdViewCore sender;
    public String url;

    private ContentParameters()
    {
    }
  }

  private class ContentThread extends Thread
  {
    boolean isCanceled = false;
    ContentManager.ContentParameters parameters;

    public ContentThread(ContentManager.ContentParameters arg2)
    {
      Object localObject;
      this.parameters = localObject;
    }

    private String readInputStream(BufferedInputStream paramBufferedInputStream)
      throws IOException
    {
      byte[] arrayOfByte1 = new byte[1024];
      ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(1);
      while (true)
      {
        int i = paramBufferedInputStream.read(arrayOfByte1);
        byte[] arrayOfByte2;
        int j;
        if (i == -1)
        {
          arrayOfByte2 = localByteArrayBuffer.buffer();
          j = localByteArrayBuffer.length();
        }
        for (String str = new String(arrayOfByte2, 0, j); ; str = "")
        {
          return str;
          if (!this.isCanceled)
            break;
        }
        localByteArrayBuffer.append(arrayOfByte1, 0, i);
      }
    }

    public void cancel()
    {
      this.isCanceled = true;
    }

    public void run()
    {
      try
      {
        String str1 = System.setProperty("http.keepAlive", "false");
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        String str2 = this.parameters.url;
        HttpGet localHttpGet = new HttpGet(str2);
        String str3 = ContentManager.this.userAgent;
        localHttpGet.addHeader("User-Agent", str3);
        localHttpGet.addHeader("Connection", "close");
        HttpConnectionParams.setConnectionTimeout(localHttpGet.getParams(), 120000);
        HttpConnectionParams.setSoTimeout(localHttpGet.getParams(), 20000);
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpGet);
        if (localHttpResponse.getStatusLine().getStatusCode() != 200)
        {
          if (this.parameters.sender != null)
          {
            MASTAdViewCore localMASTAdViewCore1 = this.parameters.sender;
            StringBuilder localStringBuilder1 = new StringBuilder("Response code = ");
            String str4 = String.valueOf(localHttpResponse.getStatusLine().getStatusCode());
            String str5 = str4;
            localMASTAdViewCore1.setResult("", str5);
          }
          ContentManager localContentManager1 = ContentManager.this;
          MASTAdViewCore localMASTAdViewCore2 = this.parameters.sender;
          localContentManager1.stopLoadContent(localMASTAdViewCore2);
          return;
        }
        InputStream localInputStream = localHttpResponse.getEntity().getContent();
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(localInputStream, 1024);
        String str6 = "";
        if (!this.isCanceled)
          str6 = readInputStream(localBufferedInputStream);
        localBufferedInputStream.close();
        localInputStream.close();
        MASTAdViewCore localMASTAdViewCore3;
        if (this.parameters.sender != null)
        {
          localMASTAdViewCore3 = this.parameters.sender;
          if (!this.isCanceled)
            break label318;
        }
        label318: for (String str7 = "canceled"; ; str7 = null)
        {
          localMASTAdViewCore3.setResult(str6, str7);
          ContentManager localContentManager2 = ContentManager.this;
          MASTAdViewCore localMASTAdViewCore4 = this.parameters.sender;
          localContentManager2.stopLoadContent(localMASTAdViewCore4);
          return;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        while (true)
          if (this.parameters.sender != null)
          {
            MASTAdViewCore localMASTAdViewCore5 = this.parameters.sender;
            String str8 = String.valueOf(localClientProtocolException.toString());
            StringBuilder localStringBuilder2 = new StringBuilder(str8).append(": ");
            String str9 = localClientProtocolException.getMessage();
            String str10 = str9;
            localMASTAdViewCore5.setResult(null, str10);
          }
      }
      catch (IOException localIOException)
      {
        while (true)
          if (this.parameters.sender != null)
          {
            MASTAdViewCore localMASTAdViewCore6 = this.parameters.sender;
            String str11 = String.valueOf(localIOException.toString());
            StringBuilder localStringBuilder3 = new StringBuilder(str11).append(": ");
            String str12 = localIOException.getMessage();
            String str13 = str12;
            localMASTAdViewCore6.setResult(null, str13);
          }
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ContentManager
 * JD-Core Version:    0.6.2
 */