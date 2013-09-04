package com.crashlytics.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import javax.security.auth.x500.X500Principal;

class c
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;

  private c(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    int i = paramArrayOfByte.length;
    this.b = i;
  }

  public static c a(OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    return new c(paramOutputStream, arrayOfByte);
  }

  private static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    boolean bool = false;
    X500Principal localX500Principal1 = paramX509Certificate1.getSubjectX500Principal();
    X500Principal localX500Principal2 = paramX509Certificate2.getIssuerX500Principal();
    if (!localX500Principal1.equals(localX500Principal2));
    while (true)
    {
      return bool;
      try
      {
        PublicKey localPublicKey = paramX509Certificate1.getPublicKey();
        paramX509Certificate2.verify(localPublicKey);
        bool = true;
      }
      catch (GeneralSecurityException localGeneralSecurityException)
      {
      }
    }
  }

  public static X509Certificate[] a(X509Certificate[] paramArrayOfX509Certificate, C paramC)
    throws CertificateException
  {
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    X509Certificate localX509Certificate1 = paramArrayOfX509Certificate[0];
    if (paramC.a(localX509Certificate1));
    for (int j = 1; ; j = 0)
    {
      X509Certificate localX509Certificate2 = paramArrayOfX509Certificate[0];
      boolean bool1 = localLinkedList.add(localX509Certificate2);
      int k = j;
      int m = 1;
      while (true)
      {
        int n = paramArrayOfX509Certificate.length;
        if (m >= n)
          break;
        X509Certificate localX509Certificate3 = paramArrayOfX509Certificate[m];
        if (paramC.a(localX509Certificate3))
          k = 1;
        X509Certificate localX509Certificate4 = paramArrayOfX509Certificate[m];
        int i1 = m + -1;
        X509Certificate localX509Certificate5 = paramArrayOfX509Certificate[i1];
        if (!a(localX509Certificate4, localX509Certificate5))
          break;
        X509Certificate localX509Certificate6 = paramArrayOfX509Certificate[m];
        boolean bool2 = localLinkedList.add(localX509Certificate6);
        m += 1;
      }
      int i2 = m + -1;
      X509Certificate localX509Certificate7 = paramArrayOfX509Certificate[i2];
      X509Certificate localX509Certificate8 = paramC.b(localX509Certificate7);
      if (localX509Certificate8 != null)
        boolean bool3 = localLinkedList.add(localX509Certificate8);
      while (true)
      {
        if (i != 0)
        {
          X509Certificate[] arrayOfX509Certificate = new X509Certificate[localLinkedList.size()];
          return (X509Certificate[])localLinkedList.toArray(arrayOfX509Certificate);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
        i = k;
      }
    }
  }

  public static int b(int paramInt, long paramLong)
  {
    int i = f(paramInt);
    int j;
    if ((0xFF80 & paramLong) == 0L)
      j = 1;
    while (true)
    {
      return j + i;
      if ((0xC000 & paramLong) == 0L)
        j = 2;
      else if ((0xFFE00000 & paramLong) == 0L)
        j = 3;
      else if ((0xF0000000 & paramLong) == 0L)
        j = 4;
      else if ((0x0 & paramLong) == 0L)
        j = 5;
      else if ((0x0 & paramLong) == 0L)
        j = 6;
      else if ((0x0 & paramLong) == 0L)
        j = 7;
      else if ((0x0 & paramLong) == 0L)
        j = 8;
      else if ((0x0 & paramLong) == 0L)
        j = 9;
      else
        j = 10;
    }
  }

  public static int b(int paramInt, a parama)
  {
    int i = f(paramInt);
    int j = h(parama.a());
    int k = parama.a();
    int m = j + k;
    return i + m;
  }

  private void b()
    throws IOException
  {
    if (this.d == null)
      throw new f();
    OutputStream localOutputStream = this.d;
    byte[] arrayOfByte = this.a;
    int i = this.c;
    localOutputStream.write(arrayOfByte, 0, i);
    this.c = 0;
  }

  public static int d(int paramInt1, int paramInt2)
  {
    int i = f(paramInt1);
    int j = h(paramInt2);
    return i + j;
  }

  public static int e(int paramInt1, int paramInt2)
  {
    int i = f(paramInt1);
    if (paramInt2 >= 0);
    for (int j = h(paramInt2); ; j = 10)
      return j + i;
  }

  public static int f(int paramInt)
  {
    return h(F.a(paramInt, 0));
  }

  public static int h(int paramInt)
  {
    int i;
    if ((paramInt & 0xFFFFFF80) == 0)
      i = 1;
    while (true)
    {
      return i;
      if ((paramInt & 0xFFFFC000) == 0)
        i = 2;
      else if ((0xFFE00000 & paramInt) == 0)
        i = 3;
      else if ((0xF0000000 & paramInt) == 0)
        i = 4;
      else
        i = 5;
    }
  }

  public static int j(int paramInt)
  {
    int i = paramInt << 1;
    int j = paramInt >> 31;
    return i ^ j;
  }

  public static int k(int paramInt)
  {
    int i = 0;
    if ((paramInt >= 200) && (paramInt <= 299));
    while (true)
    {
      return i;
      if ((paramInt >= 300) && (paramInt <= 399))
        i = 1;
      else if ((paramInt < 400) || (paramInt > 499))
        if (paramInt >= 500)
          i = 1;
        else
          i = 1;
    }
  }

  public void a()
    throws IOException
  {
    if (this.d == null)
      return;
    b();
  }

  public void a(byte paramByte)
    throws IOException
  {
    int i = this.c;
    int j = this.b;
    if (i != j)
      b();
    byte[] arrayOfByte = this.a;
    int k = this.c;
    int m = k + 1;
    this.c = m;
    arrayOfByte[k] = paramByte;
  }

  public void a(float paramFloat)
    throws IOException
  {
    int i = Float.floatToRawIntBits(paramFloat);
    i(i);
  }

  public void a(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      g(paramInt);
      return;
    }
    long l = paramInt;
    b(l);
  }

  public void a(int paramInt, float paramFloat)
    throws IOException
  {
    f(1, 5);
    a(paramFloat);
  }

  public void a(int paramInt1, int paramInt2)
    throws IOException
  {
    f(paramInt1, 0);
    b(paramInt2);
  }

  public void a(int paramInt, long paramLong)
    throws IOException
  {
    f(paramInt, 0);
    a(paramLong);
  }

  public void a(int paramInt, a parama)
    throws IOException
  {
    f(paramInt, 2);
    a(parama);
  }

  public void a(int paramInt, String paramString)
    throws IOException
  {
    f(1, 2);
    a(paramString);
  }

  public void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    f(paramInt, 0);
    a(paramBoolean);
  }

  public void a(long paramLong)
    throws IOException
  {
    b(paramLong);
  }

  public void a(a parama)
    throws IOException
  {
    int i = parama.a();
    g(i);
    b(parama);
  }

  public void a(a parama, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.b;
    int j = this.c;
    if (i - j >= paramInt2)
    {
      byte[] arrayOfByte1 = this.a;
      int k = this.c;
      parama.a(arrayOfByte1, 0, k, paramInt2);
      int m = this.c + paramInt2;
      this.c = m;
      return;
    }
    int n = this.b;
    int i1 = this.c;
    int i2 = n - i1;
    byte[] arrayOfByte2 = this.a;
    int i3 = this.c;
    parama.a(arrayOfByte2, 0, i3, i2);
    int i4 = i2 + 0;
    int i5 = paramInt2 - i2;
    int i6 = this.b;
    this.c = i6;
    b();
    int i7 = this.b;
    if (i5 <= i7)
    {
      byte[] arrayOfByte3 = this.a;
      parama.a(arrayOfByte3, i4, 0, i5);
      this.c = i5;
      return;
    }
    InputStream localInputStream = parama.c();
    long l1 = i4;
    long l2 = i4;
    long l3 = localInputStream.skip(l2);
    if (l1 != l3)
      throw new IllegalStateException("Skip failed.");
    int i8;
    int i10;
    do
    {
      OutputStream localOutputStream = this.d;
      byte[] arrayOfByte4 = this.a;
      localOutputStream.write(arrayOfByte4, 0, i8);
      i5 -= i8;
      if (i5 <= 0)
        return;
      int i9 = this.b;
      i10 = Math.min(i5, i9);
      byte[] arrayOfByte5 = this.a;
      i8 = localInputStream.read(arrayOfByte5, 0, i10);
    }
    while (i8 == i10);
    throw new IllegalStateException("Read failed.");
  }

  public void a(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    int i = arrayOfByte.length;
    g(i);
    a(arrayOfByte);
  }

  public void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      e(i);
      return;
    }
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    a(paramArrayOfByte, 0, i);
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.b;
    int j = this.c;
    if (i - j >= paramInt2)
    {
      byte[] arrayOfByte1 = this.a;
      int k = this.c;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, k, paramInt2);
      int m = this.c + paramInt2;
      this.c = m;
      return;
    }
    int n = this.b;
    int i1 = this.c;
    int i2 = n - i1;
    byte[] arrayOfByte2 = this.a;
    int i3 = this.c;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i3, i2);
    int i4 = i2 + 0;
    int i5 = paramInt2 - i2;
    int i6 = this.b;
    this.c = i6;
    b();
    int i7 = this.b;
    if (i5 <= i7)
    {
      byte[] arrayOfByte3 = this.a;
      System.arraycopy(paramArrayOfByte, i4, arrayOfByte3, 0, i5);
      this.c = i5;
      return;
    }
    this.d.write(paramArrayOfByte, i4, i5);
  }

  public void b(int paramInt)
    throws IOException
  {
    g(paramInt);
  }

  public void b(int paramInt1, int paramInt2)
    throws IOException
  {
    f(paramInt1, 0);
    c(paramInt2);
  }

  public void b(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFF80 & paramLong) == 0L)
      {
        int i = (int)paramLong;
        e(i);
        return;
      }
      int j = (int)paramLong & 0x7F | 0x80;
      e(j);
      paramLong >>>= 7;
    }
  }

  public void b(a parama)
    throws IOException
  {
    int i = parama.a();
    a(parama, 0, i);
  }

  public void c(int paramInt)
    throws IOException
  {
    a(paramInt);
  }

  public void c(int paramInt1, int paramInt2)
    throws IOException
  {
    f(2, 0);
    d(paramInt2);
  }

  public void d(int paramInt)
    throws IOException
  {
    int i = j(paramInt);
    g(i);
  }

  public void e(int paramInt)
    throws IOException
  {
    byte b1 = (byte)paramInt;
    a(b1);
  }

  public void f(int paramInt1, int paramInt2)
    throws IOException
  {
    int i = F.a(paramInt1, paramInt2);
    g(i);
  }

  public void g(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        e(paramInt);
        return;
      }
      int i = paramInt & 0x7F | 0x80;
      e(i);
      paramInt >>>= 7;
    }
  }

  public void i(int paramInt)
    throws IOException
  {
    int i = paramInt & 0xFF;
    e(i);
    int j = paramInt >> 8 & 0xFF;
    e(j);
    int k = paramInt >> 16 & 0xFF;
    e(k);
    int m = paramInt >>> 24;
    e(m);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c
 * JD-Core Version:    0.6.2
 */