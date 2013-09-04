package com.google.analytics.tracking.android;

class Hit
{
  private final long hitId;
  private String hitString;
  private final long hitTime;
  private String hitUrl;

  Hit(String paramString, long paramLong1, long paramLong2)
  {
    this.hitString = paramString;
    this.hitId = paramLong1;
    this.hitTime = paramLong2;
  }

  long getHitId()
  {
    return this.hitId;
  }

  String getHitParams()
  {
    return this.hitString;
  }

  long getHitTime()
  {
    return this.hitTime;
  }

  public String getHitUrl()
  {
    return this.hitUrl;
  }

  void setHitString(String paramString)
  {
    this.hitString = paramString;
  }

  public void setHitUrl(String paramString)
  {
    this.hitUrl = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Hit
 * JD-Core Version:    0.6.2
 */