package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RawResultsImpl<T>
  implements GenericRawResults<T>
{
  private final String[] columnNames;
  private SelectIterator<T, Void> iterator;

  public RawResultsImpl(ConnectionSource paramConnectionSource, DatabaseConnection paramDatabaseConnection, String paramString, Class<?> paramClass, CompiledStatement paramCompiledStatement, String[] paramArrayOfString, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache)
    throws SQLException
  {
    Class<?> localClass = paramClass;
    GenericRowMapper<T> localGenericRowMapper = paramGenericRowMapper;
    ConnectionSource localConnectionSource = paramConnectionSource;
    DatabaseConnection localDatabaseConnection = paramDatabaseConnection;
    CompiledStatement localCompiledStatement = paramCompiledStatement;
    String str = paramString;
    ObjectCache localObjectCache = paramObjectCache;
    SelectIterator localSelectIterator = new SelectIterator(localClass, null, localGenericRowMapper, localConnectionSource, localDatabaseConnection, localCompiledStatement, str, localObjectCache);
    this.iterator = localSelectIterator;
    this.columnNames = paramArrayOfString;
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
    return this.iterator;
  }

  public String[] getColumnNames()
  {
    return this.columnNames;
  }

  public T getFirstResult()
    throws SQLException
  {
    try
    {
      if (this.iterator.hasNextThrow())
      {
        Object localObject1 = this.iterator.nextThrow();
        localObject2 = localObject1;
        return localObject2;
      }
      Object localObject2 = null;
      close();
    }
    finally
    {
      close();
    }
  }

  public int getNumberColumns()
  {
    return this.columnNames.length;
  }

  public List<T> getResults()
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (this.iterator.hasNext())
      {
        Object localObject1 = this.iterator.next();
        boolean bool = localArrayList.add(localObject1);
      }
    }
    finally
    {
      this.iterator.close();
    }
    return localArrayList;
  }

  public CloseableIterator<T> iterator()
  {
    return this.iterator;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.RawResultsImpl
 * JD-Core Version:    0.6.2
 */