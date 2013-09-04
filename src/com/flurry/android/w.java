package com.flurry.android;

import java.io.DataInput;

final class w extends ak
{
  long a;
  long b;
  String c;
  String d;
  long e;
  Long f;
  byte[] g;
  AdImage h;

  w()
  {
  }

  w(DataInput paramDataInput)
  {
    b(paramDataInput);
  }

  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    int j = paramArrayOfByte.length;
    if (i < j)
    {
      int k = paramArrayOfByte[i] >> 4 & 0xF;
      label51: int m;
      if (k < 10)
      {
        char c1 = (char)(k + 48);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(c1);
        m = paramArrayOfByte[i] & 0xF;
        if (m >= 10)
          break label111;
        char c2 = (char)(m + 48);
        StringBuilder localStringBuilder3 = localStringBuilder1.append(c2);
      }
      while (true)
      {
        i += 1;
        break;
        char c3 = (char)(k + 65 + -10);
        StringBuilder localStringBuilder4 = localStringBuilder1.append(c3);
        break label51;
        label111: char c4 = (char)(m + 65 + -10);
        StringBuilder localStringBuilder5 = localStringBuilder1.append(c4);
      }
    }
    return localStringBuilder1.toString();
  }

  private void b(DataInput paramDataInput)
  {
    long l1 = paramDataInput.readLong();
    this.a = l1;
    long l2 = paramDataInput.readLong();
    this.b = l2;
    String str1 = paramDataInput.readUTF();
    this.d = str1;
    String str2 = paramDataInput.readUTF();
    this.c = str2;
    long l3 = paramDataInput.readLong();
    this.e = l3;
    Long localLong = Long.valueOf(paramDataInput.readLong());
    this.f = localLong;
    byte[] arrayOfByte1 = new byte[paramDataInput.readUnsignedByte()];
    this.g = arrayOfByte1;
    byte[] arrayOfByte2 = this.g;
    paramDataInput.readFully(arrayOfByte2);
  }

  final void a(DataInput paramDataInput)
  {
    b(paramDataInput);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("ad {id=");
    long l = this.a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(l).append(", name='");
    String str1 = this.d;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str1).append("', cookie: '");
    String str2 = a(this.g);
    return str2 + "'}";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.w
 * JD-Core Version:    0.6.2
 */