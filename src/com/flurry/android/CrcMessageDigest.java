package com.flurry.android;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class CrcMessageDigest extends MessageDigest
{
  private CRC32 a;

  public CrcMessageDigest()
  {
    super("CRC");
    CRC32 localCRC32 = new CRC32();
    this.a = localCRC32;
  }

  protected byte[] engineDigest()
  {
    long l = this.a.getValue();
    byte[] arrayOfByte = new byte[4];
    int i = (byte)(int)((0xFF000000 & l) >> 24);
    arrayOfByte[0] = i;
    int j = (byte)(int)((0xFF0000 & l) >> 16);
    arrayOfByte[1] = j;
    int k = (byte)(int)((0xFF00 & l) >> 8);
    arrayOfByte[2] = k;
    int m = (byte)(int)(l & 0xFF);
    arrayOfByte[3] = m;
    return arrayOfByte;
  }

  protected void engineReset()
  {
    this.a.reset();
  }

  protected void engineUpdate(byte paramByte)
  {
    this.a.update(paramByte);
  }

  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.update(paramArrayOfByte, paramInt1, paramInt2);
  }

  public int getChecksum()
  {
    return ByteBuffer.wrap(engineDigest()).getInt();
  }

  public byte[] getDigest()
  {
    return engineDigest();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.CrcMessageDigest
 * JD-Core Version:    0.6.2
 */