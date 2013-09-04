package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Collection;

public abstract interface ForeignCollection<T> extends Collection<T>, CloseableIterable<T>
{
  public abstract void closeLastIterator()
    throws SQLException;

  public abstract CloseableWrappedIterable<T> getWrappedIterable();

  public abstract boolean isEager();

  public abstract CloseableIterator<T> iteratorThrow()
    throws SQLException;

  public abstract int refresh(T paramT)
    throws SQLException;

  public abstract int refreshAll()
    throws SQLException;

  public abstract int refreshCollection()
    throws SQLException;

  public abstract int update(T paramT)
    throws SQLException;

  public abstract int updateAll()
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.ForeignCollection
 * JD-Core Version:    0.6.2
 */