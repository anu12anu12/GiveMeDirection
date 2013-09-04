package com.google.analytics.tracking.android;

import java.util.Map;

abstract interface TrackerHandler
{
  public abstract void closeTracker(Tracker paramTracker);

  public abstract void sendHit(Map<String, String> paramMap);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.TrackerHandler
 * JD-Core Version:    0.6.2
 */