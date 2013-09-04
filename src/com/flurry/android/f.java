package com.flurry.android;

final class f
{
  final byte a;
  final long b;

  f(byte paramByte, long paramLong)
  {
    this.a = paramByte;
    this.b = paramLong;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("[");
    long l = this.b;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(l).append("] ");
    int i = this.a;
    return i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.f
 * JD-Core Version:    0.6.2
 */