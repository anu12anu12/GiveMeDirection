package com.crashlytics.android;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

final class a
{
  private static a b = new a(arrayOfByte);
  private final byte[] a;
  private volatile int c = 0;

  static
  {
    byte[] arrayOfByte = new byte[0];
  }

  private a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }

  public static a a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      a locala = new a(arrayOfByte);
      return locala;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported.", localUnsupportedEncodingException);
    }
  }

  public static a a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    ByteBuffer localByteBuffer = paramByteBuffer.get(arrayOfByte);
    return new a(arrayOfByte);
  }

  public static a a(List<a> paramList)
  {
    a locala1;
    if (paramList.size() == 0)
      locala1 = b;
    while (true)
    {
      return locala1;
      if (paramList.size() == 1)
      {
        locala1 = (a)paramList.get(0);
      }
      else
      {
        Iterator localIterator1 = paramList.iterator();
        for (int i = 0; localIterator1.hasNext(); i = ((a)localIterator1.next()).a.length + i);
        byte[] arrayOfByte1 = new byte[i];
        Iterator localIterator2 = paramList.iterator();
        int j = 0;
        while (localIterator2.hasNext())
        {
          a locala2 = (a)localIterator2.next();
          byte[] arrayOfByte2 = locala2.a;
          int k = locala2.a.length;
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, k);
          int m = locala2.a.length + j;
        }
        locala1 = new a(arrayOfByte1);
      }
    }
  }

  public final int a()
  {
    return this.a.length;
  }

  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.a, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }

  public final String b()
  {
    try
    {
      byte[] arrayOfByte = this.a;
      String str = new String(arrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }

  public final InputStream c()
  {
    byte[] arrayOfByte = this.a;
    return new ByteArrayInputStream(arrayOfByte);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this);
    label104: 
    while (true)
    {
      return bool;
      if (!(paramObject instanceof a))
      {
        bool = false;
      }
      else
      {
        paramObject = (a)paramObject;
        int i = this.a.length;
        int j = paramObject.a.length;
        if (i != j)
        {
          bool = false;
        }
        else
        {
          byte[] arrayOfByte1 = this.a;
          byte[] arrayOfByte2 = paramObject.a;
          int k = 0;
          while (true)
          {
            if (k >= i)
              break label104;
            int m = arrayOfByte1[k];
            int n = arrayOfByte2[k];
            if (m != n)
            {
              bool = false;
              break;
            }
            k += 1;
          }
        }
      }
    }
  }

  public final int hashCode()
  {
    int i = this.c;
    if (i == 0)
    {
      byte[] arrayOfByte = this.a;
      int j = this.a.length;
      int k = 0;
      i = j;
      while (k < j)
      {
        int m = i * 31;
        int n = arrayOfByte[k] + m;
        k += 1;
        int i1 = n;
      }
      if (i == 0);
      this.c = i;
    }
    return i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a
 * JD-Core Version:    0.6.2
 */