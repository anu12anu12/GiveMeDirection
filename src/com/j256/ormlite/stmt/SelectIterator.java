package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class SelectIterator<T, ID>
  implements CloseableIterator<T>
{
  private static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
  private boolean alreadyMoved = false;
  private final Dao<T, ID> classDao;
  private boolean closed = false;
  private final CompiledStatement compiledStmt;
  private final DatabaseConnection connection;
  private final ConnectionSource connectionSource;
  private final Class<?> dataClass;
  private boolean first = true;
  private T last = null;
  private final DatabaseResults results;
  private int rowC = 0;
  private final GenericRowMapper<T> rowMapper;
  private final String statement;

  public SelectIterator(Class<?> paramClass, Dao<T, ID> paramDao, GenericRowMapper<T> paramGenericRowMapper, ConnectionSource paramConnectionSource, DatabaseConnection paramDatabaseConnection, CompiledStatement paramCompiledStatement, String paramString, ObjectCache paramObjectCache)
    throws SQLException
  {
    this.dataClass = paramClass;
    this.classDao = paramDao;
    this.rowMapper = paramGenericRowMapper;
    this.connectionSource = paramConnectionSource;
    this.connection = paramDatabaseConnection;
    this.compiledStmt = paramCompiledStatement;
    DatabaseResults localDatabaseResults = paramCompiledStatement.runQuery(paramObjectCache);
    this.results = localDatabaseResults;
    this.statement = paramString;
    if (paramString == null)
      return;
    Logger localLogger = logger;
    Integer localInteger = Integer.valueOf(hashCode());
    localLogger.debug("starting iterator @{} for '{}'", localInteger, paramString);
  }

  private void closeNoThrow()
  {
    try
    {
      close();
      return;
    }
    catch (SQLException localSQLException)
    {
    }
  }

  private T getCurrent()
    throws SQLException
  {
    GenericRowMapper localGenericRowMapper = this.rowMapper;
    DatabaseResults localDatabaseResults = this.results;
    Object localObject = localGenericRowMapper.mapRow(localDatabaseResults);
    this.last = localObject;
    this.alreadyMoved = false;
    int i = this.rowC + 1;
    this.rowC = i;
    return this.last;
  }

  public void close()
    throws SQLException
  {
    if (this.closed)
      return;
    this.compiledStmt.close();
    this.closed = true;
    this.last = null;
    if (this.statement != null)
    {
      Logger localLogger = logger;
      Integer localInteger1 = Integer.valueOf(hashCode());
      Integer localInteger2 = Integer.valueOf(this.rowC);
      localLogger.debug("closed iterator @{} after {} rows", localInteger1, localInteger2);
    }
    ConnectionSource localConnectionSource = this.connectionSource;
    DatabaseConnection localDatabaseConnection = this.connection;
    localConnectionSource.releaseConnection(localDatabaseConnection);
  }

  public T current()
    throws SQLException
  {
    Object localObject;
    if (this.closed)
      localObject = null;
    while (true)
    {
      return localObject;
      if (this.first)
        localObject = first();
      else
        localObject = getCurrent();
    }
  }

  public T first()
    throws SQLException
  {
    Object localObject = null;
    if (this.closed);
    while (true)
    {
      return localObject;
      this.first = false;
      if (this.results.first())
        localObject = getCurrent();
    }
  }

  public DatabaseResults getRawResults()
  {
    return this.results;
  }

  public boolean hasNext()
  {
    try
    {
      boolean bool = hasNextThrow();
      return bool;
    }
    catch (SQLException localSQLException)
    {
      this.last = null;
      closeNoThrow();
      StringBuilder localStringBuilder = new StringBuilder().append("Errors getting more results of ");
      Class localClass = this.dataClass;
      String str = localClass;
      throw new IllegalStateException(str, localSQLException);
    }
  }

  public boolean hasNextThrow()
    throws SQLException
  {
    boolean bool = false;
    if (this.closed);
    while (true)
    {
      return bool;
      if (!this.alreadyMoved)
        break;
      bool = true;
    }
    if (this.first)
      this.first = false;
    for (bool = this.results.first(); ; bool = this.results.next())
    {
      if (!bool)
        close();
      this.alreadyMoved = true;
      break;
    }
  }

  public T moveRelative(int paramInt)
    throws SQLException
  {
    Object localObject = null;
    if (this.closed);
    while (true)
    {
      return localObject;
      this.first = false;
      if (this.results.moveRelative(paramInt))
        localObject = getCurrent();
    }
  }

  public void moveToNext()
  {
    this.last = null;
    this.first = false;
    this.alreadyMoved = false;
  }

  public T next()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = nextThrow();
      Object localObject3 = localObject2;
      if (localObject3 != null)
        return localObject3;
    }
    catch (SQLException localSQLException)
    {
      this.last = null;
      closeNoThrow();
      StringBuilder localStringBuilder = new StringBuilder().append("Could not get next result for ");
      Class localClass = this.dataClass;
      String str = localClass;
      throw new IllegalStateException(str, localSQLException);
    }
  }

  public T nextThrow()
    throws SQLException
  {
    Object localObject = null;
    if (this.closed);
    while (true)
    {
      return localObject;
      if (!this.alreadyMoved)
      {
        if (this.first)
          this.first = false;
        for (boolean bool = this.results.first(); ; bool = this.results.next())
        {
          if (bool)
            break label65;
          this.first = false;
          break;
        }
      }
      label65: this.first = false;
      localObject = getCurrent();
    }
  }

  public T previous()
    throws SQLException
  {
    Object localObject = null;
    if (this.closed);
    while (true)
    {
      return localObject;
      this.first = false;
      if (this.results.previous())
        localObject = getCurrent();
    }
  }

  public void remove()
  {
    try
    {
      removeThrow();
      return;
    }
    catch (SQLException localSQLException)
    {
      closeNoThrow();
      StringBuilder localStringBuilder1 = new StringBuilder().append("Could not delete ");
      Class localClass = this.dataClass;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(localClass).append(" object ");
      Object localObject = this.last;
      String str = localObject;
      throw new IllegalStateException(str, localSQLException);
    }
  }

  public void removeThrow()
    throws SQLException
  {
    if (this.last == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("No last ");
      Class localClass1 = this.dataClass;
      String str1 = localClass1 + " object to remove. Must be called after a call to next.";
      throw new IllegalStateException(str1);
    }
    if (this.classDao == null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append("Cannot remove ");
      Class localClass2 = this.dataClass;
      String str2 = localClass2 + " object because classDao not initialized";
      throw new IllegalStateException(str2);
    }
    try
    {
      Dao localDao = this.classDao;
      Object localObject1 = this.last;
      int i = localDao.delete(localObject1);
      return;
    }
    finally
    {
      this.last = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.SelectIterator
 * JD-Core Version:    0.6.2
 */