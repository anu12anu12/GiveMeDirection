package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeDiscCache extends BaseDiscCache
{
  private final Map<File, Long> loadingDates;
  private final long maxFileAge;

  public LimitedAgeDiscCache(File paramFile, long paramLong)
  {
    this(paramFile, localFileNameGenerator, paramLong);
  }

  public LimitedAgeDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, long paramLong)
  {
    super(paramFile, paramFileNameGenerator);
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.loadingDates = localMap;
    long l = 1000L * paramLong;
    this.maxFileAge = l;
    readLoadingDates();
  }

  private void readLoadingDates()
  {
    File[] arrayOfFile = getCacheDir().listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      File localFile = arrayOfFile[j];
      Map localMap = this.loadingDates;
      Long localLong = Long.valueOf(localFile.lastModified());
      Object localObject = localMap.put(localFile, localLong);
      j += 1;
    }
  }

  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    if (localFile.exists())
    {
      Long localLong = (Long)this.loadingDates.get(localFile);
      if (localLong == null)
        localLong = Long.valueOf(localFile.lastModified());
      long l1 = System.currentTimeMillis();
      long l2 = localLong.longValue();
      long l3 = l1 - l2;
      long l4 = this.maxFileAge;
      if (l3 > l4)
      {
        boolean bool = localFile.delete();
        Object localObject = this.loadingDates.remove(localFile);
      }
    }
    return localFile;
  }

  public void put(String paramString, File paramFile)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramFile.setLastModified(l);
    Map localMap = this.loadingDates;
    Long localLong = Long.valueOf(l);
    Object localObject = localMap.put(paramFile, localLong);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiscCache
 * JD-Core Version:    0.6.2
 */