package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;

public class HttpClientImageDownloader extends ImageDownloader
{
  private HttpClient httpClient;

  public HttpClientImageDownloader(HttpClient paramHttpClient)
  {
    this.httpClient = paramHttpClient;
  }

  protected InputStream getStreamFromNetwork(URI paramURI)
    throws IOException
  {
    String str = paramURI.toString();
    HttpGet localHttpGet = new HttpGet(str);
    HttpEntity localHttpEntity = this.httpClient.execute(localHttpGet).getEntity();
    return new BufferedHttpEntity(localHttpEntity).getContent();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.HttpClientImageDownloader
 * JD-Core Version:    0.6.2
 */