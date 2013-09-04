package com.crashlytics.android;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

final class r
  implements X509TrustManager
{
  private final TrustManager[] a;
  private final C b;
  private final List<byte[]> c;
  private final Set<X509Certificate> d;

  public r(C paramC, String[] paramArrayOfString)
  {
    LinkedList localLinkedList = new LinkedList();
    this.c = localLinkedList;
    Set localSet = Collections.synchronizedSet(new HashSet());
    this.d = localSet;
    TrustManager[] arrayOfTrustManager = a(paramC);
    this.a = arrayOfTrustManager;
    this.b = paramC;
    int i = paramArrayOfString.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      String str = paramArrayOfString[j];
      List localList = this.c;
      byte[] arrayOfByte = a(str);
      boolean bool = localList.add(arrayOfByte);
      j += 1;
    }
  }

  private boolean a(X509Certificate paramX509Certificate)
    throws CertificateException
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      byte[] arrayOfByte1 = paramX509Certificate.getPublicKey().getEncoded();
      byte[] arrayOfByte2 = localMessageDigest.digest(arrayOfByte1);
      Iterator localIterator = this.c.iterator();
      boolean bool1;
      do
      {
        if (!localIterator.hasNext())
          break;
        bool1 = Arrays.equals((byte[])localIterator.next(), arrayOfByte2);
      }
      while (!bool1);
      for (boolean bool2 = true; ; bool2 = false)
        return bool2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new CertificateException(localNoSuchAlgorithmException);
    }
  }

  private static byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i / 2];
    int j = 0;
    while (j < i)
    {
      int k = j / 2;
      int m = Character.digit(paramString.charAt(j), 16) << 4;
      int n = j + 1;
      int i1 = Character.digit(paramString.charAt(n), 16);
      int i2 = (byte)(m + i1);
      arrayOfByte[k] = i2;
      j += 2;
    }
    return arrayOfByte;
  }

  private static TrustManager[] a(C paramC)
  {
    try
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
      KeyStore localKeyStore = paramC.a;
      localTrustManagerFactory.init(localKeyStore);
      TrustManager[] arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
      return arrayOfTrustManager;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
    catch (KeyStoreException localKeyStoreException)
    {
      throw new AssertionError(localKeyStoreException);
    }
  }

  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    throw new CertificateException("Client certificates not supported!");
  }

  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    Set localSet1 = this.d;
    X509Certificate localX509Certificate1 = paramArrayOfX509Certificate[0];
    if (localSet1.contains(localX509Certificate1))
      return;
    TrustManager[] arrayOfTrustManager = this.a;
    int i = arrayOfTrustManager.length;
    int j = 0;
    while (j < i)
    {
      ((X509TrustManager)arrayOfTrustManager[j]).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      j += 1;
    }
    C localC = this.b;
    X509Certificate[] arrayOfX509Certificate = c.a(paramArrayOfX509Certificate, localC);
    int k = arrayOfX509Certificate.length;
    int m = 0;
    while (m < k)
    {
      X509Certificate localX509Certificate2 = arrayOfX509Certificate[m];
      if (a(localX509Certificate2))
        break label131;
      m += 1;
    }
    throw new CertificateException("No valid pins found in chain!");
    label131: Set localSet2 = this.d;
    X509Certificate localX509Certificate3 = paramArrayOfX509Certificate[0];
    boolean bool = localSet2.add(localX509Certificate3);
  }

  public final X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.r
 * JD-Core Version:    0.6.2
 */