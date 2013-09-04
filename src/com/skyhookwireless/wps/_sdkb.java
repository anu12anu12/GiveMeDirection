package com.skyhookwireless.wps;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class _sdkb extends InputStream
{
  private final ByteBuffer _sdka;
  private final int _sdkb;

  static
  {
    if (!_sdkb.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkc = bool;
      return;
    }
  }

  public _sdkb(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if ((!_sdkc) && (!paramByteBuffer.isDirect()))
      throw new AssertionError();
    this._sdkb = paramInt1;
    ByteBuffer localByteBuffer1 = paramByteBuffer.asReadOnlyBuffer();
    this._sdka = localByteBuffer1;
    ByteBuffer localByteBuffer2 = this._sdka;
    int i = this._sdkb;
    Buffer localBuffer1 = localByteBuffer2.position(i);
    ByteBuffer localByteBuffer3 = this._sdka;
    int j = paramInt1 + paramInt2;
    Buffer localBuffer2 = localByteBuffer3.limit(j);
    if (_sdkc)
      return;
    if (this._sdka.isDirect())
      return;
    throw new AssertionError();
  }

  public int _sdka()
  {
    int i = this._sdka.limit();
    int j = this._sdkb;
    return i - j;
  }

  public int available()
  {
    return this._sdka.remaining();
  }

  public int read()
  {
    try
    {
      int i = this._sdka.get();
      j = i & 0xFF;
      return j;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      while (true)
        int j = -1;
    }
  }

  public void reset()
  {
    ByteBuffer localByteBuffer = this._sdka;
    int i = this._sdkb;
    Buffer localBuffer = localByteBuffer.position(i);
  }

  public long skip(long paramLong)
  {
    long l = Math.min(available(), paramLong);
    ByteBuffer localByteBuffer = this._sdka;
    int i = (int)(this._sdka.position() + l);
    Buffer localBuffer = localByteBuffer.position(i);
    return l;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkb
 * JD-Core Version:    0.6.2
 */