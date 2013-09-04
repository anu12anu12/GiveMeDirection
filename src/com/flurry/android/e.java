package com.flurry.android;

import java.io.DataInput;

final class e extends ak
{
  String a;
  byte b;
  byte c;
  c d;

  e()
  {
  }

  e(DataInput paramDataInput)
  {
    String str = paramDataInput.readUTF();
    this.a = str;
    byte b1 = paramDataInput.readByte();
    this.b = b1;
    byte b2 = paramDataInput.readByte();
    this.c = b2;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("{name: ");
    String str = this.a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str).append(", blockId: ");
    int i = this.b;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(i).append(", themeId: ");
    int j = this.c;
    return j;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.e
 * JD-Core Version:    0.6.2
 */