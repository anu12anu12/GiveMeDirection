package com.androidquery.callback;

import com.androidquery.util.AQUtility;
import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class AjaxStatus
{
  public static final int AUTH_ERROR = 154;
  public static final int DATASTORE = 2;
  public static final int DEVICE = 5;
  public static final int FILE = 3;
  public static final int MEMORY = 4;
  public static final int NETWORK = 1;
  public static final int NETWORK_ERROR = 155;
  public static final int TRANSFORM_ERROR = 153;
  private DefaultHttpClient client;
  private Closeable close;
  private int code = 200;
  private HttpContext context;
  private byte[] data;
  private boolean done;
  private long duration;
  private String error;
  private File file;
  private Header[] headers;
  private boolean invalid;
  private String message = "OK";
  private boolean reauth;
  private String redirect;
  private boolean refresh;
  private int source;
  private long start;
  private Date time;

  public AjaxStatus()
  {
    Date localDate = new Date();
    this.time = localDate;
    this.source = 1;
    long l = System.currentTimeMillis();
    this.start = l;
  }

  public AjaxStatus(int paramInt, String paramString)
  {
    Date localDate = new Date();
    this.time = localDate;
    this.source = 1;
    long l = System.currentTimeMillis();
    this.start = l;
    this.code = paramInt;
    this.message = paramString;
  }

  protected AjaxStatus client(DefaultHttpClient paramDefaultHttpClient)
  {
    this.client = paramDefaultHttpClient;
    return this;
  }

  public void close()
  {
    AQUtility.close(this.close);
    this.close = null;
  }

  protected void closeLater(Closeable paramCloseable)
  {
    this.close = paramCloseable;
  }

  public AjaxStatus code(int paramInt)
  {
    this.code = paramInt;
    return this;
  }

  protected AjaxStatus context(HttpContext paramHttpContext)
  {
    this.context = paramHttpContext;
    return this;
  }

  protected AjaxStatus data(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
  }

  public AjaxStatus done()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.start;
    long l3 = l1 - l2;
    this.duration = l3;
    this.done = true;
    this.reauth = false;
    return this;
  }

  protected AjaxStatus error(String paramString)
  {
    this.error = paramString;
    return this;
  }

  public boolean expired(long paramLong)
  {
    boolean bool = true;
    long l = this.time.getTime();
    if ((System.currentTimeMillis() - l > paramLong) && (getSource() != 1));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  protected AjaxStatus file(File paramFile)
  {
    this.file = paramFile;
    return this;
  }

  public DefaultHttpClient getClient()
  {
    return this.client;
  }

  public int getCode()
  {
    return this.code;
  }

  public List<Cookie> getCookies()
  {
    List localList;
    if (this.context == null)
      localList = Collections.emptyList();
    while (true)
    {
      return localList;
      CookieStore localCookieStore = (CookieStore)this.context.getAttribute("http.cookie-store");
      if (localCookieStore == null)
        localList = Collections.emptyList();
      else
        localList = localCookieStore.getCookies();
    }
  }

  protected byte[] getData()
  {
    return this.data;
  }

  protected boolean getDone()
  {
    return this.done;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public String getError()
  {
    return this.error;
  }

  protected File getFile()
  {
    return this.file;
  }

  public String getHeader(String paramString)
  {
    String str1 = null;
    if (this.headers == null)
      return str1;
    int i = 0;
    while (true)
    {
      int j = this.headers.length;
      if (i >= j)
        break;
      String str2 = this.headers[i].getName();
      if (paramString.equalsIgnoreCase(str2))
      {
        str1 = this.headers[i].getValue();
        break;
      }
      i += 1;
    }
  }

  public List<Header> getHeaders()
  {
    if (this.headers == null);
    for (List localList = Collections.emptyList(); ; localList = Arrays.asList(this.headers))
      return localList;
  }

  protected boolean getInvalid()
  {
    return this.invalid;
  }

  public String getMessage()
  {
    return this.message;
  }

  protected boolean getReauth()
  {
    return this.reauth;
  }

  public String getRedirect()
  {
    return this.redirect;
  }

  public boolean getRefresh()
  {
    return this.refresh;
  }

  public int getSource()
  {
    return this.source;
  }

  public Date getTime()
  {
    return this.time;
  }

  protected AjaxStatus headers(Header[] paramArrayOfHeader)
  {
    this.headers = paramArrayOfHeader;
    return this;
  }

  public AjaxStatus invalidate()
  {
    this.invalid = true;
    return this;
  }

  public AjaxStatus message(String paramString)
  {
    this.message = paramString;
    return this;
  }

  protected AjaxStatus reauth(boolean paramBoolean)
  {
    this.reauth = paramBoolean;
    return this;
  }

  protected AjaxStatus redirect(String paramString)
  {
    this.redirect = paramString;
    return this;
  }

  protected AjaxStatus refresh(boolean paramBoolean)
  {
    this.refresh = paramBoolean;
    return this;
  }

  protected AjaxStatus reset()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.start;
    long l3 = l1 - l2;
    this.duration = l3;
    this.done = false;
    close();
    return this;
  }

  protected AjaxStatus source(int paramInt)
  {
    this.source = paramInt;
    return this;
  }

  protected AjaxStatus time(Date paramDate)
  {
    this.time = paramDate;
    return this;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.callback.AjaxStatus
 * JD-Core Version:    0.6.2
 */