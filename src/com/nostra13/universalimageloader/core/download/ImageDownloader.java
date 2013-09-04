package com.nostra13.universalimageloader.core.download;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public abstract class ImageDownloader
{
  protected static final String PROTOCOL_FILE = "file";
  protected static final String PROTOCOL_FTP = "ftp";
  protected static final String PROTOCOL_HTTP = "http";
  protected static final String PROTOCOL_HTTPS = "https";

  public InputStream getStream(URI paramURI)
    throws IOException
  {
    String str = paramURI.getScheme();
    InputStream localInputStream;
    if (("http".equals(str)) || ("https".equals(str)) || ("ftp".equals(str)))
      localInputStream = getStreamFromNetwork(paramURI);
    while (true)
    {
      return localInputStream;
      if ("file".equals(str))
        localInputStream = getStreamFromFile(paramURI);
      else
        localInputStream = getStreamFromOtherSource(paramURI);
    }
  }

  protected InputStream getStreamFromFile(URI paramURI)
    throws IOException
  {
    InputStream localInputStream = paramURI.toURL().openStream();
    return new BufferedInputStream(localInputStream);
  }

  protected abstract InputStream getStreamFromNetwork(URI paramURI)
    throws IOException;

  protected InputStream getStreamFromOtherSource(URI paramURI)
    throws IOException
  {
    return null;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.ImageDownloader
 * JD-Core Version:    0.6.2
 */