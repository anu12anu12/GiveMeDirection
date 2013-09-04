package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeMemoryCache<K, V>
  implements MemoryCacheAware<K, V>
{
  private final MemoryCacheAware<K, V> cache;
  private final Map<K, Long> loadingDates;
  private final long maxAge;

  public LimitedAgeMemoryCache(MemoryCacheAware<K, V> paramMemoryCacheAware, long paramLong)
  {
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.loadingDates = localMap;
    this.cache = paramMemoryCacheAware;
    long l = 1000L * paramLong;
    this.maxAge = l;
  }

  public void clear()
  {
    this.cache.clear();
    this.loadingDates.clear();
  }

  public V get(K paramK)
  {
    Long localLong = (Long)this.loadingDates.get(paramK);
    if (localLong != null)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localLong.longValue();
      long l3 = l1 - l2;
      long l4 = this.maxAge;
      if (l3 > l4)
      {
        this.cache.remove(paramK);
        Object localObject = this.loadingDates.remove(paramK);
      }
    }
    return this.cache.get(paramK);
  }

  public Collection<K> keys()
  {
    return this.cache.keys();
  }

  public boolean put(K paramK, V paramV)
  {
    boolean bool = this.cache.put(paramK, paramV);
    if (bool)
    {
      Map localMap = this.loadingDates;
      Long localLong = Long.valueOf(System.currentTimeMillis());
      Object localObject = localMap.put(paramK, localLong);
    }
    return bool;
  }

  public void remove(K paramK)
  {
    this.cache.remove(paramK);
    Object localObject = this.loadingDates.remove(paramK);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LimitedAgeMemoryCache
 * JD-Core Version:    0.6.2
 */