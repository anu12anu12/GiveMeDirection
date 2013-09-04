package com.j256.ormlite.dao;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ReferenceObjectCache
  implements ObjectCache
{
  private final ConcurrentHashMap<Class<?>, Map<Object, Reference<Object>>> classMaps;
  private final boolean useWeak;

  public ReferenceObjectCache(boolean paramBoolean)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    this.classMaps = localConcurrentHashMap;
    this.useWeak = paramBoolean;
  }

  private void cleanMap(Map<Object, Reference<Object>> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      if (((Reference)((Map.Entry)localIterator.next()).getValue()).get() == null)
        localIterator.remove();
    }
  }

  private Map<Object, Reference<Object>> getMapForClass(Class<?> paramClass)
  {
    Map localMap = (Map)this.classMaps.get(paramClass);
    if (localMap == null)
      localMap = null;
    return localMap;
  }

  public static ReferenceObjectCache makeSoftCache()
  {
    return new ReferenceObjectCache(false);
  }

  public static ReferenceObjectCache makeWeakCache()
  {
    return new ReferenceObjectCache(true);
  }

  public <T> void cleanNullReferences(Class<T> paramClass)
  {
    Map localMap = getMapForClass(paramClass);
    if (localMap == null)
      return;
    cleanMap(localMap);
  }

  public <T> void cleanNullReferencesAll()
  {
    Iterator localIterator = this.classMaps.values().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Map localMap = (Map)localIterator.next();
      cleanMap(localMap);
    }
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
    Object localObject1 = null;
    Map localMap = getMapForClass(paramClass);
    if (localMap == null);
    while (true)
    {
      return localObject1;
      Reference localReference = (Reference)localMap.get(paramID);
      if (localReference != null)
      {
        Object localObject2 = localReference.get();
        if (localObject2 == null)
          Object localObject3 = localMap.remove(paramID);
        else
          localObject1 = localObject2;
      }
    }
  }

  public <T, ID> void put(Class<T> paramClass, ID paramID, T paramT)
  {
    Map localMap = getMapForClass(paramClass);
    if (localMap == null)
      return;
    if (this.useWeak)
    {
      WeakReference localWeakReference = new WeakReference(paramT);
      Object localObject1 = localMap.put(paramID, localWeakReference);
      return;
    }
    SoftReference localSoftReference = new SoftReference(paramT);
    Object localObject2 = localMap.put(paramID, localSoftReference);
  }

  /** @deprecated */
  public <T> void registerClass(Class<T> paramClass)
  {
    try
    {
      if ((Map)this.classMaps.get(paramClass) == null)
      {
        ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
        Object localObject1 = this.classMaps.put(paramClass, localConcurrentHashMap);
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
      Reference localReference = (Reference)localMap.remove(paramID1);
      if (localReference != null)
      {
        Object localObject2 = localMap.put(paramID2, localReference);
        localObject1 = localReference.get();
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.ReferenceObjectCache
 * JD-Core Version:    0.6.2
 */