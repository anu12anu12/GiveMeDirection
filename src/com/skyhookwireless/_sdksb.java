package com.skyhookwireless;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

final class _sdksb extends _sdkrb
{
  HttpEntity _sdkf;

  _sdksb(HttpResponse paramHttpResponse)
    throws IOException
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    this._sdka = i;
    String str1 = paramHttpResponse.getStatusLine().getReasonPhrase();
    this._sdkb = str1;
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    this._sdkf = localHttpEntity;
    if (this._sdkf == null)
      return;
    InputStream localInputStream = this._sdkf.getContent();
    this._sdke = localInputStream;
    long l = this._sdkf.getContentLength();
    this._sdkd = l;
    if (this._sdkf.getContentType() == null)
      return;
    String str2 = this._sdkf.getContentType().getValue();
    this._sdkc = str2;
  }

  public void _sdkf()
    throws IOException
  {
    super._sdkf();
    this._sdkf.consumeContent();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdksb
 * JD-Core Version:    0.6.2
 */