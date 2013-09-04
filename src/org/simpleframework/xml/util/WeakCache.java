package org.simpleframework.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class WeakCache<T>
  implements Cache<T>
{
  private WeakCache<T>.SegmentList list;

  public WeakCache()
  {
    this(10);
  }

  public WeakCache(int paramInt)
  {
    SegmentList localSegmentList = new SegmentList(paramInt);
    this.list = localSegmentList;
  }

  private WeakCache<T>.Segment map(Object paramObject)
  {
    return this.list.get(paramObject);
  }

  public void cache(Object paramObject, T paramT)
  {
    map(paramObject).cache(paramObject, paramT);
  }

  public boolean contains(Object paramObject)
  {
    return map(paramObject).contains(paramObject);
  }

  public T fetch(Object paramObject)
  {
    return map(paramObject).fetch(paramObject);
  }

  public boolean isEmpty()
  {
    Iterator localIterator = this.list.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((Segment)localIterator.next()).isEmpty());
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public T take(Object paramObject)
  {
    return map(paramObject).take(paramObject);
  }

  private class Segment extends WeakHashMap<Object, T>
  {
    private Segment()
    {
    }

    /** @deprecated */
    public void cache(Object paramObject, T paramT)
    {
      try
      {
        Object localObject1 = put(paramObject, paramT);
        return;
      }
      finally
      {
        localObject2 = finally;
        throw localObject2;
      }
    }

    /** @deprecated */
    public boolean contains(Object paramObject)
    {
      try
      {
        boolean bool1 = containsKey(paramObject);
        boolean bool2 = bool1;
        return bool2;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    /** @deprecated */
    public T fetch(Object paramObject)
    {
      try
      {
        Object localObject1 = get(paramObject);
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
    public T take(Object paramObject)
    {
      try
      {
        Object localObject1 = remove(paramObject);
        Object localObject2 = localObject1;
        return localObject2;
      }
      finally
      {
        localObject3 = finally;
        throw localObject3;
      }
    }
  }

  private class SegmentList
    implements Iterable<WeakCache<T>.Segment>
  {
    private List<WeakCache<T>.Segment> list;
    private int size;

    public SegmentList(int arg2)
    {
      ArrayList localArrayList = new ArrayList();
      this.list = localArrayList;
      int i;
      this.size = i;
      create(i);
    }

    private void create(int paramInt)
    {
      int j;
      for (int i = paramInt; ; i = j)
      {
        j = i + -1;
        if (i <= 0)
          return;
        List localList = this.list;
        WeakCache localWeakCache = WeakCache.this;
        WeakCache.Segment localSegment = new WeakCache.Segment(localWeakCache, null);
        boolean bool = localList.add(localSegment);
      }
    }

    private int segment(Object paramObject)
    {
      int i = paramObject.hashCode();
      int j = this.size;
      return Math.abs(i % j);
    }

    public WeakCache<T>.Segment get(Object paramObject)
    {
      int i = segment(paramObject);
      int j = this.size;
      if (i < j);
      for (WeakCache.Segment localSegment = (WeakCache.Segment)this.list.get(i); ; localSegment = null)
        return localSegment;
    }

    public Iterator<WeakCache<T>.Segment> iterator()
    {
      return this.list.iterator();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.WeakCache
 * JD-Core Version:    0.6.2
 */