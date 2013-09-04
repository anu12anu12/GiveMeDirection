package org.simpleframework.xml.util;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache<T> extends ConcurrentHashMap<Object, T>
  implements Cache<T>
{
  public void cache(Object paramObject, T paramT)
  {
    Object localObject = put(paramObject, paramT);
  }

  public boolean contains(Object paramObject)
  {
    return containsKey(paramObject);
  }

  public T fetch(Object paramObject)
  {
    return get(paramObject);
  }

  public T take(Object paramObject)
  {
    return remove(paramObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.ConcurrentCache
 * JD-Core Version:    0.6.2
 */