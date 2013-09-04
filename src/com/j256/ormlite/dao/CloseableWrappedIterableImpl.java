package com.j256.ormlite.dao;

import java.sql.SQLException;

public class CloseableWrappedIterableImpl<T>
  implements CloseableWrappedIterable<T>
{
  private final CloseableIterable<T> iterable;
  private CloseableIterator<T> iterator;

  public CloseableWrappedIterableImpl(CloseableIterable<T> paramCloseableIterable)
  {
    this.iterable = paramCloseableIterable;
  }

  public void close()
    throws SQLException
  {
    if (this.iterator == null)
      return;
    this.iterator.close();
    this.iterator = null;
  }

  public CloseableIterator<T> closeableIterator()
  {
    try
    {
      close();
      label4: CloseableIterator localCloseableIterator = this.iterable.closeableIterator();
      this.iterator = localCloseableIterator;
      return this.iterator;
    }
    catch (SQLException localSQLException)
    {
      break label4;
    }
  }

  public CloseableIterator<T> iterator()
  {
    return closeableIterator();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.CloseableWrappedIterableImpl
 * JD-Core Version:    0.6.2
 */