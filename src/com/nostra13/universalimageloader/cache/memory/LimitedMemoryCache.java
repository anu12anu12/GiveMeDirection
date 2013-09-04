package com.nostra13.universalimageloader.cache.memory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class LimitedMemoryCache<K, V> extends BaseMemoryCache<K, V>
{
  private int cacheSize = 0;
  private final List<V> hardCache;
  private final int sizeLimit;

  public LimitedMemoryCache(int paramInt)
  {
    List localList = Collections.synchronizedList(new LinkedList());
    this.hardCache = localList;
    this.sizeLimit = paramInt;
  }

  public void clear()
  {
    this.hardCache.clear();
    this.cacheSize = 0;
    super.clear();
  }

  protected abstract int getSize(V paramV);

  protected int getSizeLimit()
  {
    return this.sizeLimit;
  }

  public boolean put(K paramK, V paramV)
  {
    boolean bool1 = false;
    int i = getSize(paramV);
    int j = getSizeLimit();
    if (i < j)
    {
      while (this.cacheSize + i > j)
      {
        Object localObject = removeNext();
        if (this.hardCache.remove(localObject))
        {
          int k = this.cacheSize;
          int m = getSize(localObject);
          int n = k - m;
          this.cacheSize = n;
        }
      }
      boolean bool2 = this.hardCache.add(paramV);
      int i1 = this.cacheSize + i;
      this.cacheSize = i1;
      bool1 = true;
    }
    boolean bool3 = super.put(paramK, paramV);
    return bool1;
  }

  public void remove(K paramK)
  {
    Object localObject = super.get(paramK);
    if ((localObject != null) && (this.hardCache.remove(localObject)))
    {
      int i = this.cacheSize;
      int j = getSize(localObject);
      int k = i - j;
      this.cacheSize = k;
    }
    super.remove(paramK);
  }

  protected abstract V removeNext();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache
 * JD-Core Version:    0.6.2
 */