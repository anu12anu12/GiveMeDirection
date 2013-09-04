package com.j256.ormlite.misc;

import java.sql.SQLException;

public class SqlExceptionUtil
{
  public static SQLException create(String paramString, Throwable paramThrowable)
  {
    SQLException localSQLException = new SQLException(paramString);
    Throwable localThrowable = localSQLException.initCause(paramThrowable);
    return localSQLException;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.misc.SqlExceptionUtil
 * JD-Core Version:    0.6.2
 */