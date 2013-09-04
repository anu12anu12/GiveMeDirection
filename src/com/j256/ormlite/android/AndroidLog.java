package com.j256.ormlite.android;

import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.logger.LoggerFactory;

public class AndroidLog
  implements com.j256.ormlite.logger.Log
{
  private static final String ALL_LOGS_NAME = "ORMLite";
  private static final int MAX_TAG_LENGTH = 23;
  private static final int REFRESH_LEVEL_CACHE_EVERY = 200;
  private String className;
  private final boolean[] levelCache;
  private volatile int levelCacheC = 0;

  public AndroidLog(String paramString)
  {
    String str1 = LoggerFactory.getSimpleClassName(paramString);
    this.className = str1;
    int i = this.className.length();
    if (i > 23)
    {
      String str2 = this.className;
      int j = i + -23;
      String str3 = str2.substring(j, i);
      this.className = str3;
    }
    int k = 0;
    Log.Level[] arrayOfLevel = Log.Level.values();
    int m = arrayOfLevel.length;
    int n = 0;
    while (n < m)
    {
      Log.Level localLevel = arrayOfLevel[n];
      int i1 = levelToAndroidLevel(localLevel);
      if (i1 > k)
        k = i1;
      n += 1;
    }
    boolean[] arrayOfBoolean = new boolean[k + 1];
    this.levelCache = arrayOfBoolean;
    refreshLevelCache();
  }

  private boolean isLevelEnabledInternal(int paramInt)
  {
    if ((android.util.Log.isLoggable(this.className, paramInt)) || (android.util.Log.isLoggable("ORMLite", paramInt)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private int levelToAndroidLevel(Log.Level paramLevel)
  {
    int i = 4;
    int[] arrayOfInt = 1.$SwitchMap$com$j256$ormlite$logger$Log$Level;
    int j = paramLevel.ordinal();
    switch (arrayOfInt[j])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      return i;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 6;
    }
  }

  private void refreshLevelCache()
  {
    Log.Level[] arrayOfLevel = Log.Level.values();
    int i = arrayOfLevel.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Log.Level localLevel = arrayOfLevel[j];
      int k = levelToAndroidLevel(localLevel);
      int m = this.levelCache.length;
      if (k < m)
      {
        boolean[] arrayOfBoolean = this.levelCache;
        boolean bool = isLevelEnabledInternal(k);
        arrayOfBoolean[k] = bool;
      }
      j += 1;
    }
  }

  public boolean isLevelEnabled(Log.Level paramLevel)
  {
    int i = this.levelCacheC + 1;
    this.levelCacheC = i;
    if (i >= 200)
    {
      refreshLevelCache();
      this.levelCacheC = 0;
    }
    int j = levelToAndroidLevel(paramLevel);
    int k = this.levelCache.length;
    if (j < k);
    boolean bool;
    for (int m = this.levelCache[j]; ; bool = isLevelEnabledInternal(j))
      return m;
  }

  public void log(Log.Level paramLevel, String paramString)
  {
    int[] arrayOfInt = 1.$SwitchMap$com$j256$ormlite$logger$Log$Level;
    int i = paramLevel.ordinal();
    switch (arrayOfInt[i])
    {
    default:
      int j = android.util.Log.i(this.className, paramString);
      return;
    case 1:
      int k = android.util.Log.v(this.className, paramString);
      return;
    case 2:
      int m = android.util.Log.d(this.className, paramString);
      return;
    case 3:
      int n = android.util.Log.i(this.className, paramString);
      return;
    case 4:
      int i1 = android.util.Log.w(this.className, paramString);
      return;
    case 5:
      int i2 = android.util.Log.e(this.className, paramString);
      return;
    case 6:
    }
    int i3 = android.util.Log.e(this.className, paramString);
  }

  public void log(Log.Level paramLevel, String paramString, Throwable paramThrowable)
  {
    int[] arrayOfInt = 1.$SwitchMap$com$j256$ormlite$logger$Log$Level;
    int i = paramLevel.ordinal();
    switch (arrayOfInt[i])
    {
    default:
      int j = android.util.Log.i(this.className, paramString, paramThrowable);
      return;
    case 1:
      int k = android.util.Log.v(this.className, paramString, paramThrowable);
      return;
    case 2:
      int m = android.util.Log.d(this.className, paramString, paramThrowable);
      return;
    case 3:
      int n = android.util.Log.i(this.className, paramString, paramThrowable);
      return;
    case 4:
      int i1 = android.util.Log.w(this.className, paramString, paramThrowable);
      return;
    case 5:
      int i2 = android.util.Log.e(this.className, paramString, paramThrowable);
      return;
    case 6:
    }
    int i3 = android.util.Log.e(this.className, paramString, paramThrowable);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.android.AndroidLog
 * JD-Core Version:    0.6.2
 */