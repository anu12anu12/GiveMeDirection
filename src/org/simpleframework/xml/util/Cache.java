package org.simpleframework.xml.util;

public abstract interface Cache<T>
{
  public abstract void cache(Object paramObject, T paramT);

  public abstract boolean contains(Object paramObject);

  public abstract T fetch(Object paramObject);

  public abstract boolean isEmpty();

  public abstract T take(Object paramObject);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.Cache
 * JD-Core Version:    0.6.2
 */