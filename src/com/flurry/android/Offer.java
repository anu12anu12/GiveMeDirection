package com.flurry.android;

public final class Offer
{
  private long a;
  private String b;
  private String c;
  private int d;
  private AdImage e;

  Offer(long paramLong, AdImage paramAdImage, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.e = paramAdImage;
    this.c = paramString2;
    this.d = paramInt;
  }

  public final String getDescription()
  {
    return this.c;
  }

  public final long getId()
  {
    return this.a;
  }

  public final AdImage getImage()
  {
    return this.e;
  }

  public final String getName()
  {
    return this.b;
  }

  public final int getPrice()
  {
    return this.d;
  }

  public final String getUrl()
  {
    return "";
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder().append("[id=");
    long l = this.a;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(l).append(",name=");
    String str1 = this.b;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str1).append(",price=");
    int i = this.d;
    StringBuilder localStringBuilder5 = localStringBuilder4.append(i).append(", image size: ");
    int j = this.e.e.length;
    String str2 = j;
    StringBuilder localStringBuilder6 = localStringBuilder1.append(str2);
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.Offer
 * JD-Core Version:    0.6.2
 */