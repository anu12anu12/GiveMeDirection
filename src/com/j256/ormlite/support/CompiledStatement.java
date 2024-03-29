package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract interface CompiledStatement
{
  public abstract void close()
    throws SQLException;

  public abstract int getColumnCount()
    throws SQLException;

  public abstract String getColumnName(int paramInt)
    throws SQLException;

  public abstract int runExecute()
    throws SQLException;

  public abstract DatabaseResults runQuery(ObjectCache paramObjectCache)
    throws SQLException;

  public abstract int runUpdate()
    throws SQLException;

  public abstract void setMaxRows(int paramInt)
    throws SQLException;

  public abstract void setObject(int paramInt, Object paramObject, SqlType paramSqlType)
    throws SQLException;

  public abstract void setQueryTimeout(long paramLong)
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.support.CompiledStatement
 * JD-Core Version:    0.6.2
 */