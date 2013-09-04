package com.androidquery.util;

import java.io.ByteArrayOutputStream;

public class PredefinedBAOS extends ByteArrayOutputStream
{
  public PredefinedBAOS(int paramInt)
  {
    super(paramInt);
  }

  public byte[] toByteArray()
  {
    int i = this.count;
    int j = this.buf.length;
    if (i != j);
    for (byte[] arrayOfByte = this.buf; ; arrayOfByte = super.toByteArray())
      return arrayOfByte;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.PredefinedBAOS
 * JD-Core Version:    0.6.2
 */