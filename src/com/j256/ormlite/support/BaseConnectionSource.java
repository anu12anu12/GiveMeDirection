package com.j256.ormlite.support;

import com.j256.ormlite.logger.Logger;
import java.sql.SQLException;

public abstract class BaseConnectionSource
  implements ConnectionSource
{
  private ThreadLocal<NestedConnection> specialConnection;

  public BaseConnectionSource()
  {
    ThreadLocal localThreadLocal = new ThreadLocal();
    this.specialConnection = localThreadLocal;
  }

  protected boolean clearSpecial(DatabaseConnection paramDatabaseConnection, Logger paramLogger)
  {
    NestedConnection localNestedConnection = (NestedConnection)this.specialConnection.get();
    boolean bool = false;
    if (paramDatabaseConnection == null);
    while (true)
    {
      return bool;
      if (localNestedConnection == null)
      {
        paramLogger.error("no connection has been saved when clear() called");
      }
      else if (localNestedConnection.connection == paramDatabaseConnection)
      {
        if (localNestedConnection.decrementAndGet() == 0)
          this.specialConnection.set(null);
        bool = true;
      }
      else
      {
        DatabaseConnection localDatabaseConnection = localNestedConnection.connection;
        paramLogger.error("connection saved {} is not the one being cleared {}", localDatabaseConnection, paramDatabaseConnection);
      }
    }
  }

  protected DatabaseConnection getSavedConnection()
  {
    NestedConnection localNestedConnection = (NestedConnection)this.specialConnection.get();
    if (localNestedConnection == null);
    for (DatabaseConnection localDatabaseConnection = null; ; localDatabaseConnection = localNestedConnection.connection)
      return localDatabaseConnection;
  }

  public DatabaseConnection getSpecialConnection()
  {
    NestedConnection localNestedConnection = (NestedConnection)this.specialConnection.get();
    if (localNestedConnection == null);
    for (DatabaseConnection localDatabaseConnection = null; ; localDatabaseConnection = localNestedConnection.connection)
      return localDatabaseConnection;
  }

  protected boolean isSavedConnection(DatabaseConnection paramDatabaseConnection)
  {
    boolean bool = false;
    NestedConnection localNestedConnection = (NestedConnection)this.specialConnection.get();
    if (localNestedConnection == null);
    while (true)
    {
      return bool;
      if (localNestedConnection.connection == paramDatabaseConnection)
        bool = true;
    }
  }

  protected boolean saveSpecial(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    NestedConnection localNestedConnection1 = (NestedConnection)this.specialConnection.get();
    if (localNestedConnection1 == null)
    {
      ThreadLocal localThreadLocal = this.specialConnection;
      NestedConnection localNestedConnection2 = new NestedConnection(paramDatabaseConnection);
      localThreadLocal.set(localNestedConnection2);
    }
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      if (localNestedConnection1.connection != paramDatabaseConnection)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("trying to save connection ").append(paramDatabaseConnection).append(" but already have saved connection ");
        DatabaseConnection localDatabaseConnection = localNestedConnection1.connection;
        String str = localDatabaseConnection;
        throw new SQLException(str);
      }
      localNestedConnection1.increment();
    }
  }

  private static class NestedConnection
  {
    public final DatabaseConnection connection;
    private int nestedC;

    public NestedConnection(DatabaseConnection paramDatabaseConnection)
    {
      this.connection = paramDatabaseConnection;
      this.nestedC = 1;
    }

    public int decrementAndGet()
    {
      int i = this.nestedC + -1;
      this.nestedC = i;
      return this.nestedC;
    }

    public void increment()
    {
      int i = this.nestedC + 1;
      this.nestedC = i;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.support.BaseConnectionSource
 * JD-Core Version:    0.6.2
 */