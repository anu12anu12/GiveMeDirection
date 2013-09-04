package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache<K, V>
  implements MemoryCacheAware<K, V>
{
  private final MemoryCacheAware<K, V> cache;
  private final Comparator<K> keyComparator;

  public FuzzyKeyMemoryCache(MemoryCacheAware<K, V> paramMemoryCacheAware, Comparator<K> paramComparator)
  {
    this.cache = paramMemoryCacheAware;
    this.keyComparator = paramComparator;
  }

  /** @deprecated */
  public void clear()
  {
    try
    {
      this.cache.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public V get(K paramK)
  {
    try
    {
      Object localObject1 = this.cache.get(paramK);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      localObject3 = finally;
      throw localObject3;
    }
  }

  /** @deprecated */
  public Collection<K> keys()
  {
    try
    {
      Collection localCollection1 = this.cache.keys();
      Collection localCollection2 = localCollection1;
      return localCollection2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public boolean put(K paramK, V paramV)
  {
    Object localObject1 = null;
    try
    {
      Iterator localIterator = this.cache.keys().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (this.keyComparator.compare(paramK, localObject2) == 0)
          localObject1 = localObject2;
      }
      this.cache.remove(localObject1);
      boolean bool1 = this.cache.put(paramK, paramV);
      boolean bool2 = bool1;
      return bool2;
    }
    finally
    {
      localObject3 = finally;
      throw localObject3;
    }
  }

  /** @deprecated */
  public void remove(K paramK)
  {
    try
    {
      this.cache.remove(paramK);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache
 * JD-Core Version:    0.6.2
 */