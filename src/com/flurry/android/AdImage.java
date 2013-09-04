package com.flurry.android;

import java.io.DataInput;

public final class AdImage extends ak
{
  long a;
  int b;
  int c;
  String d;
  byte[] e;

  AdImage()
  {
  }

  AdImage(DataInput paramDataInput)
  {
    a(paramDataInput);
  }

  final void a(DataInput paramDataInput)
  {
    long l = paramDataInput.readLong();
    this.a = l;
    int i = paramDataInput.readInt();
    this.b = i;
    int j = paramDataInput.readInt();
    this.c = j;
    String str = paramDataInput.readUTF();
    this.d = str;
    byte[] arrayOfByte1 = new byte[paramDataInput.readInt()];
    this.e = arrayOfByte1;
    byte[] arrayOfByte2 = this.e;
    paramDataInput.readFully(arrayOfByte2);
  }

  public final int getHeight()
  {
    return this.c;
  }

  public final long getId()
  {
    return this.a;
  }

  public final byte[] getImageData()
  {
    return this.e;
  }

  public final String getMimeType()
  {
    return this.d;
  }

  public final int getWidth()
  {
    return this.b;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.AdImage
 * JD-Core Version:    0.6.2
 */