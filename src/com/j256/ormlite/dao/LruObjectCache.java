package com.j256.ormlite.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LruObjectCache
  implements ObjectCache
{
  private final int capacity;
  private final ConcurrentHashMap<Class<?>, Map<Object, Object>> classMaps;

  public LruObjectCache(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    this.classMaps = localConcurrentHashMap;
    this.capacity = paramInt;
  }

  private Map<Object, Object> getMapForClass(Class<?> paramClass)
  {
    Map localMap = (Map)this.classMaps.get(paramClass);
    if (localMap == null)
      localMap = null;
    return localMap;
  }

  public <T> void clear(Class<T> paramClass)
  {
    Map localMap = getMapForClass(paramClass);
    if (localMap == null)
      return;
    localMap.clear();
  }

  public void clearAll()
  {
    Iterator localIterator = this.classMaps.values().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((Map)localIterator.next()).clear();
    }
  }

  public <T, ID> T get(Class<T> paramClass, ID paramID)
  {
    Map localMap = getMapForClass(paramClass);
    if (localMap == null);
    for (Object localObject = null; ; localObject = localMap.get(paramID))
      return localObject;
  }

  public <T, ID> void put(Class<T> paramClass, ID paramID, T paramT)
  {
    Map localMap = getMapForClass(paramClass);
    if (localMap == null)
      return;
    Object localObject = localMap.put(paramID, paramT);
  }

  /** @deprecated */
  public <T> void registerClass(Class<T> paramClass)
  {
    try
    {
      if ((Map)this.classMaps.get(paramClass) == null)
      {
        int i = this.capacity;
        Map localMap = Collections.synchronizedMap(new LimitedLinkedHashMap(i));
        Object localObject1 = this.classMaps.put(paramClass, localMap);
      }
      return;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }

  public <T, ID> void remove(Class<T> paramClass, ID paramID)
  {
    Map localMap = getMapForClass(paramClass);
    if (localMap == null)
      return;
    Object localObject = localMap.remove(paramID);
  }

  public <T> int size(Class<T> paramClass)
  {
    Map localMap = getMapForClass(paramClass);
    if (localMap == null);
    for (int i = 0; ; i = localMap.size())
      return i;
  }

  public int sizeAll()
  {
    int i = 0;
    Iterator localIterator = this.classMaps.values().iterator();
    while (localIterator.hasNext())
    {
      int j = ((Map)localIterator.next()).size();
      i += j;
    }
    return i;
  }

  public <T, ID> T updateId(Class<T> paramClass, ID paramID1, ID paramID2)
  {
    Object localObject1 = null;
    Map localMap = getMapForClass(paramClass);
    if (localMap == null);
    while (true)
    {
      return localObject1;
      Object localObject2 = localMap.remove(paramID1);
      if (localObject2 != null)
      {
        Object localObject3 = localMap.put(paramID2, localObject2);
        localObject1 = localObject2;
      }
    }
  }

  private static class LimitedLinkedHashMap<K, V> extends LinkedHashMap<K, V>
  {
    private static final long serialVersionUID = -4566528080395573236L;
    private final int capacity;

    public LimitedLinkedHashMap(int paramInt)
    {
      super(0.75F, true);
      this.capacity = paramInt;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      int i = size();
      int j = this.capacity;
      if (i > j);
      for (boolean bool = true; ; bool = false)
        return bool;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.LruObjectCache
 * JD-Core Version:    0.6.2
 */