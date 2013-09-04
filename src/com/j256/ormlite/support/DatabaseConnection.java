package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import java.sql.SQLException;
import java.sql.Savepoint;

public abstract interface DatabaseConnection
{
  public static final int DEFAULT_RESULT_FLAGS = 255;
  public static final Object MORE_THAN_ONE = new Object();

  public abstract void close()
    throws SQLException;

  public abstract void commit(Savepoint paramSavepoint)
    throws SQLException;

  public abstract CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType)
    throws SQLException;

  public abstract CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType, int paramInt)
    throws SQLException;

  public abstract int delete(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws SQLException;

  public abstract int insert(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GeneratedKeyHolder paramGeneratedKeyHolder)
    throws SQLException;

  public abstract boolean isAutoCommit()
    throws SQLException;

  public abstract boolean isAutoCommitSupported()
    throws SQLException;

  public abstract boolean isClosed()
    throws SQLException;

  public abstract boolean isTableExists(String paramString)
    throws SQLException;

  public abstract long queryForLong(String paramString)
    throws SQLException;

  public abstract long queryForLong(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws SQLException;

  public abstract <T> Object queryForOne(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache)
    throws SQLException;

  public abstract void rollback(Savepoint paramSavepoint)
    throws SQLException;

  public abstract void setAutoCommit(boolean paramBoolean)
    throws SQLException;

  public abstract Savepoint setSavePoint(String paramString)
    throws SQLException;

  public abstract int update(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.support.DatabaseConnection
 * JD-Core Version:    0.6.2
 */