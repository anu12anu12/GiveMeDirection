package com.j256.ormlite.dao;

import java.sql.SQLException;

public abstract interface CloseableWrappedIterable<T> extends CloseableIterable<T>
{
  public abstract void close()
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.CloseableWrappedIterable
 * JD-Core Version:    0.6.2
 */