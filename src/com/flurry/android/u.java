package com.flurry.android;

final class u
{
  long a;
  p b;
  String c;
  String d;
  int e;
  AdImage f;

  u(long paramLong, p paramp, AdImage paramAdImage, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramLong;
    this.b = paramp;
    this.c = paramString1;
    this.f = paramAdImage;
    this.d = paramString2;
    this.e = paramInt;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder().append("[id=");
    long l = this.a;
    String str1 = l;
    StringBuilder localStringBuilder3 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder4 = new StringBuilder().append(",name=");
    String str2 = this.c;
    String str3 = str2 + "]";
    StringBuilder localStringBuilder5 = localStringBuilder3.append(str3);
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.u
 * JD-Core Version:    0.6.2
 */