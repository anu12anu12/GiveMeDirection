package com.nostra13.universalimageloader.cache.memory;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMemoryCache<K, V>
  implements MemoryCacheAware<K, V>
{
  private final Map<K, Reference<V>> softMap;

  public BaseMemoryCache()
  {
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.softMap = localMap;
  }

  public void clear()
  {
    this.softMap.clear();
  }

  protected abstract Reference<V> createReference(V paramV);

  public V get(K paramK)
  {
    Object localObject = null;
    Reference localReference = (Reference)this.softMap.get(paramK);
    if (localReference != null)
      localObject = localReference.get();
    return localObject;
  }

  public Collection<K> keys()
  {
    return this.softMap.keySet();
  }

  public boolean put(K paramK, V paramV)
  {
    Map localMap = this.softMap;
    Reference localReference = createReference(paramV);
    Object localObject = localMap.put(paramK, localReference);
    return true;
  }

  public void remove(K paramK)
  {
    Object localObject = this.softMap.remove(paramK);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.BaseMemoryCache
 * JD-Core Version:    0.6.2
 */