package com.google.analytics.tracking.android;

class AdHitIdGenerator
{
  private boolean adMobSdkInstalled;

  AdHitIdGenerator()
  {
    try
    {
      if (Class.forName("com.google.ads.AdRequest") != null);
      for (boolean bool = true; ; bool = false)
      {
        this.adMobSdkInstalled = bool;
        return;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      this.adMobSdkInstalled = false;
    }
  }

  AdHitIdGenerator(boolean paramBoolean)
  {
    this.adMobSdkInstalled = paramBoolean;
  }

  int getAdHitId()
  {
    if (!this.adMobSdkInstalled);
    for (int i = 0; ; i = AdMobInfo.getInstance().generateAdHitId())
      return i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.AdHitIdGenerator
 * JD-Core Version:    0.6.2
 */