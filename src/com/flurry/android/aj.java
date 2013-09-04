package com.flurry.android;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

final class aj extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a;

  public aj(FlurryAgent paramFlurryAgent, KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    SSLContext localSSLContext1 = SSLContext.getInstance("TLS");
    this.a = localSSLContext1;
    n localn = new n();
    SSLContext localSSLContext2 = this.a;
    TrustManager[] arrayOfTrustManager = new TrustManager[1];
    arrayOfTrustManager[0] = localn;
    localSSLContext2.init(null, arrayOfTrustManager, null);
  }

  public final Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }

  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.aj
 * JD-Core Version:    0.6.2
 */