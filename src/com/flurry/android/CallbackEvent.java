package com.flurry.android;

public final class CallbackEvent
{
  public static final int ADS_LOADED_FROM_CACHE = 201;
  public static final int ADS_UPDATED = 202;
  public static final int ERROR_MARKET_LAUNCH = 101;
  private int a;
  private long b;
  private String c;

  CallbackEvent(int paramInt)
  {
    this.a = paramInt;
    long l = System.currentTimeMillis();
    this.b = l;
  }

  public final String getMessage()
  {
    return this.c;
  }

  public final long getTimestamp()
  {
    return this.b;
  }

  public final int getType()
  {
    return this.a;
  }

  public final void setMessage(String paramString)
  {
    this.c = paramString;
  }

  public final void setTimestamp(long paramLong)
  {
    this.b = paramLong;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.CallbackEvent
 * JD-Core Version:    0.6.2
 */