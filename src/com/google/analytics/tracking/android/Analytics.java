package com.google.analytics.tracking.android;

public abstract interface Analytics
{
  public abstract boolean debugEnabled();

  public abstract Tracker getDefaultTracker();

  public abstract Tracker getTracker(String paramString);

  public abstract void requestAppOptOut(AppOptOutCallback paramAppOptOutCallback);

  public abstract void setAppOptOut(boolean paramBoolean);

  public abstract void setDebug(boolean paramBoolean);

  public abstract void setDefaultTracker(Tracker paramTracker);

  public static abstract interface AppOptOutCallback
  {
    public abstract void reportAppOptOut(boolean paramBoolean);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Analytics
 * JD-Core Version:    0.6.2
 */