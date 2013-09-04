package com.nostra13.universalimageloader.core.download;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionImageDownloader extends ImageDownloader
{
  public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
  public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
  private int connectTimeout;
  private int readTimeout;

  public URLConnectionImageDownloader()
  {
    this(5000, 20000);
  }

  public URLConnectionImageDownloader(int paramInt1, int paramInt2)
  {
    this.connectTimeout = paramInt1;
    this.readTimeout = paramInt2;
  }

  public InputStream getStreamFromNetwork(URI paramURI)
    throws IOException
  {
    URLConnection localURLConnection = paramURI.toURL().openConnection();
    int i = this.connectTimeout;
    localURLConnection.setConnectTimeout(i);
    int j = this.readTimeout;
    localURLConnection.setReadTimeout(j);
    InputStream localInputStream = localURLConnection.getInputStream();
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(localInputStream);
    return new FlushedInputStream(localBufferedInputStream);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.URLConnectionImageDownloader
 * JD-Core Version:    0.6.2
 */