package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID>
  implements PreparedQuery<T>, PreparedDelete<T>, PreparedUpdate<T>
{
  private final ArgumentHolder[] argHolders;
  private final Long limit;
  private final StatementBuilder.StatementType type;

  public MappedPreparedStmt(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2, ArgumentHolder[] paramArrayOfArgumentHolder, Long paramLong, StatementBuilder.StatementType paramStatementType)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType1, paramArrayOfFieldType2);
    this.argHolders = paramArrayOfArgumentHolder;
    this.limit = paramLong;
    this.type = paramStatementType;
  }

  private CompiledStatement compileStatement(DatabaseConnection paramDatabaseConnection, CompiledStatement paramCompiledStatement)
    throws SQLException
  {
    try
    {
      if (this.limit != null)
      {
        int i = this.limit.intValue();
        paramCompiledStatement.setMaxRows(i);
      }
      Object[] arrayOfObject = null;
      Logger localLogger1 = logger;
      Log.Level localLevel = Log.Level.TRACE;
      if ((localLogger1.isLevelEnabled(localLevel)) && (this.argHolders.length > 0))
        arrayOfObject = new Object[this.argHolders.length];
      int j = 0;
      int k = this.argHolders.length;
      if (j < k)
      {
        Object localObject1 = this.argHolders[j].getSqlArgValue();
        FieldType localFieldType = this.argFieldTypes[j];
        if (localFieldType == null);
        for (SqlType localSqlType = this.argHolders[j].getSqlType(); ; localSqlType = localFieldType.getSqlType())
        {
          paramCompiledStatement.setObject(j, localObject1, localSqlType);
          if (arrayOfObject != null)
            arrayOfObject[j] = localObject1;
          j += 1;
          break;
        }
      }
      Logger localLogger2 = logger;
      String str = this.statement;
      Integer localInteger = Integer.valueOf(this.argHolders.length);
      localLogger2.debug("prepared statement '{}' with {} args", str, localInteger);
      if (arrayOfObject != null)
        logger.trace("prepared statement arguments: {}", arrayOfObject);
      if (1 == 0)
        paramCompiledStatement.close();
      return paramCompiledStatement;
    }
    finally
    {
      if (0 == 0)
        paramCompiledStatement.close();
    }
  }

  public CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType)
    throws SQLException
  {
    return compile(paramDatabaseConnection, paramStatementType, -1);
  }

  public CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType, int paramInt)
    throws SQLException
  {
    if (this.type != paramStatementType)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Could not compile this ");
      StatementBuilder.StatementType localStatementType = this.type;
      String str1 = localStatementType + " statement since the caller is expecting a " + paramStatementType + " statement.  Check your QueryBuilder methods.";
      throw new SQLException(str1);
    }
    String str2 = this.statement;
    FieldType[] arrayOfFieldType = this.argFieldTypes;
    CompiledStatement localCompiledStatement = paramDatabaseConnection.compileStatement(str2, paramStatementType, arrayOfFieldType, paramInt);
    return compileStatement(paramDatabaseConnection, localCompiledStatement);
  }

  public String getStatement()
  {
    return this.statement;
  }

  public StatementBuilder.StatementType getType()
  {
    return this.type;
  }

  public void setArgumentHolderValue(int paramInt, Object paramObject)
    throws SQLException
  {
    if (paramInt < 0)
    {
      String str1 = "argument holder index " + paramInt + " must be >= 0";
      throw new SQLException(str1);
    }
    if (this.argHolders.length <= paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("argument holder index ").append(paramInt).append(" not valid, only ");
      int i = this.argHolders.length;
      String str2 = i + " in statement";
      throw new SQLException(str2);
    }
    this.argHolders[paramInt].setValue(paramObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedPreparedStmt
 * JD-Core Version:    0.6.2
 */