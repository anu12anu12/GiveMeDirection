package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.List;

public abstract interface GenericRawResults<T> extends CloseableWrappedIterable<T>
{
  public abstract void close()
    throws SQLException;

  public abstract String[] getColumnNames();

  public abstract T getFirstResult()
    throws SQLException;

  public abstract int getNumberColumns();

  public abstract List<T> getResults()
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.GenericRawResults
 * JD-Core Version:    0.6.2
 */