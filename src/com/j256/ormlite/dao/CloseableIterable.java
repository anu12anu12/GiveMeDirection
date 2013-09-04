package com.j256.ormlite.dao;

public abstract interface CloseableIterable<T> extends Iterable<T>
{
  public abstract CloseableIterator<T> closeableIterator();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.CloseableIterable
 * JD-Core Version:    0.6.2
 */