package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.Random;

class AdMobInfo
{
  private static final AdMobInfo INSTANCE = new AdMobInfo();
  private int adHitId;
  private Random random;

  private AdMobInfo()
  {
    Random localRandom = new Random();
    this.random = localRandom;
  }

  static AdMobInfo getInstance()
  {
    return INSTANCE;
  }

  int generateAdHitId()
  {
    int i = this.random.nextInt(2147483646) + 1;
    this.adHitId = i;
    return this.adHitId;
  }

  int getAdHitId()
  {
    return this.adHitId;
  }

  Map<String, String> getJoinIds()
  {
    return null;
  }

  void setAdHitId(int paramInt)
  {
    this.adHitId = paramInt;
  }

  static enum AdMobKey
  {
    private String bowParameter;

    static
    {
      AdMobKey[] arrayOfAdMobKey = new AdMobKey[4];
      AdMobKey localAdMobKey1 = CLIENT_ID_KEY;
      arrayOfAdMobKey[0] = localAdMobKey1;
      AdMobKey localAdMobKey2 = HIT_ID_KEY;
      arrayOfAdMobKey[1] = localAdMobKey2;
      AdMobKey localAdMobKey3 = PROPERTY_ID_KEY;
      arrayOfAdMobKey[2] = localAdMobKey3;
      AdMobKey localAdMobKey4 = VISITOR_ID_KEY;
      arrayOfAdMobKey[3] = localAdMobKey4;
    }

    private AdMobKey(String paramString)
    {
      this.bowParameter = paramString;
    }

    String getBowParameter()
    {
      return this.bowParameter;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.AdMobInfo
 * JD-Core Version:    0.6.2
 */