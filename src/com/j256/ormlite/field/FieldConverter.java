package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public abstract interface FieldConverter
{
  public abstract SqlType getSqlType();

  public abstract boolean isStreamType();

  public abstract Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    throws SQLException;

  public abstract Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException;

  public abstract Object resultToJava(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException;

  public abstract Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException;

  public abstract Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.FieldConverter
 * JD-Core Version:    0.6.2
 */