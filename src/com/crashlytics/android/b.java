package com.crashlytics.android;

import android.os.Process;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

final class b
{
  private static final AtomicLong a = new AtomicLong(0L);
  private static String b;

  public b()
  {
    byte[] arrayOfByte1 = new byte[10];
    long l1 = new Date().getTime();
    long l2 = l1 / 1000L;
    long l3 = l1 % 1000L;
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
    int i = (int)l2;
    ByteBuffer localByteBuffer2 = localByteBuffer1.putInt(i);
    ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;
    ByteBuffer localByteBuffer3 = localByteBuffer1.order(localByteOrder);
    Buffer localBuffer = localByteBuffer1.position(0);
    byte[] arrayOfByte2 = localByteBuffer1.array();
    int j = arrayOfByte2[0];
    arrayOfByte1[0] = j;
    int k = arrayOfByte2[1];
    arrayOfByte1[1] = k;
    int m = arrayOfByte2[2];
    arrayOfByte1[2] = m;
    int n = arrayOfByte2[3];
    arrayOfByte1[3] = n;
    byte[] arrayOfByte3 = a(l3);
    int i1 = arrayOfByte3[0];
    arrayOfByte1[4] = i1;
    int i2 = arrayOfByte3[1];
    arrayOfByte1[5] = i2;
    byte[] arrayOfByte4 = a(a.incrementAndGet());
    int i3 = arrayOfByte4[0];
    arrayOfByte1[6] = i3;
    int i4 = arrayOfByte4[1];
    arrayOfByte1[7] = i4;
    int i5 = Process.myPid();
    byte[] arrayOfByte5 = a(new Integer(i5).shortValue());
    int i6 = arrayOfByte5[0];
    arrayOfByte1[8] = i6;
    int i7 = arrayOfByte5[1];
    arrayOfByte1[9] = i7;
    String str1 = D.b(Crashlytics.getInstance().e().b());
    String str2 = D.a(arrayOfByte1);
    Object[] arrayOfObject = new Object[4];
    String str3 = str2.substring(0, 12);
    arrayOfObject[0] = str3;
    String str4 = str2.substring(12, 16);
    arrayOfObject[1] = str4;
    CharSequence localCharSequence = str2.subSequence(16, 20);
    arrayOfObject[2] = localCharSequence;
    String str5 = str1.substring(0, 12);
    arrayOfObject[3] = str5;
    b = String.format("%s-%s-%s-%s", arrayOfObject).toUpperCase();
  }

  private static byte[] a(long paramLong)
  {
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(2);
    short s = (short)(int)paramLong;
    ByteBuffer localByteBuffer2 = localByteBuffer1.putShort(s);
    ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;
    ByteBuffer localByteBuffer3 = localByteBuffer1.order(localByteOrder);
    Buffer localBuffer = localByteBuffer1.position(0);
    return localByteBuffer1.array();
  }

  public final String toString()
  {
    return b;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.b
 * JD-Core Version:    0.6.2
 */