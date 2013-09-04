package com.google.analytics.tracking.android;

import android.preference.PreferenceActivity;

public class TrackedPreferenceActivity extends PreferenceActivity
{
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance().activityStart(this);
  }

  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance().activityStop(this);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.TrackedPreferenceActivity
 * JD-Core Version:    0.6.2
 */