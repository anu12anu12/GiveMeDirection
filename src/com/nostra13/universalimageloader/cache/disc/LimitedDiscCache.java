package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class LimitedDiscCache extends BaseDiscCache
{
  private int cacheSize = 0;
  private final Map<File, Long> lastUsageDates;
  private int sizeLimit;

  public LimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, localFileNameGenerator, paramInt);
  }

  public LimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator);
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.lastUsageDates = localMap;
    this.sizeLimit = paramInt;
    calculateCacheSizeAndFillUsageMap();
  }

  private void calculateCacheSizeAndFillUsageMap()
  {
    int i = 0;
    File[] arrayOfFile = getCacheDir().listFiles();
    int j = arrayOfFile.length;
    int k = 0;
    while (k < j)
    {
      File localFile = arrayOfFile[k];
      int m = getSize(localFile);
      i += m;
      Map localMap = this.lastUsageDates;
      Long localLong = Long.valueOf(localFile.lastModified());
      Object localObject = localMap.put(localFile, localLong);
      k += 1;
    }
    this.cacheSize = i;
  }

  private int removeNext()
  {
    int i;
    if (this.lastUsageDates.isEmpty())
      i = 0;
    while (true)
    {
      return i;
      Object localObject1 = null;
      File localFile = null;
      Set localSet = this.lastUsageDates.entrySet();
      synchronized (this.lastUsageDates)
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localFile == null)
          {
            localFile = (File)localEntry.getKey();
            localObject1 = (Long)localEntry.getValue();
          }
          else
          {
            Long localLong = (Long)localEntry.getValue();
            long l1 = localLong.longValue();
            long l2 = ((Long)localObject1).longValue();
            if (l1 < l2)
            {
              localObject1 = localLong;
              localFile = (File)localEntry.getKey();
            }
          }
        }
        i = getSize(localFile);
        if (!localFile.delete())
          continue;
        Object localObject2 = this.lastUsageDates.remove(localFile);
      }
    }
  }

  public void clear()
  {
    this.lastUsageDates.clear();
    this.cacheSize = 0;
    super.clear();
  }

  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    long l = localLong.longValue();
    boolean bool = localFile.setLastModified(l);
    Object localObject = this.lastUsageDates.put(localFile, localLong);
    return localFile;
  }

  protected abstract int getSize(File paramFile);

  public void put(String paramString, File paramFile)
  {
    int i = getSize(paramFile);
    while (true)
    {
      int j = this.cacheSize + i;
      int k = this.sizeLimit;
      int m;
      if (j > k)
      {
        m = removeNext();
        if (m != 0);
      }
      else
      {
        int n = this.cacheSize + i;
        this.cacheSize = n;
        Long localLong = Long.valueOf(System.currentTimeMillis());
        long l = localLong.longValue();
        boolean bool = paramFile.setLastModified(l);
        Object localObject = this.lastUsageDates.put(paramFile, localLong);
        return;
      }
      int i1 = this.cacheSize - m;
      this.cacheSize = i1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.LimitedDiscCache
 * JD-Core Version:    0.6.2
 */