package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public abstract class BaseFieldConverter
  implements FieldConverter
{
  public boolean isStreamType()
  {
    return false;
  }

  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    throws SQLException
  {
    return paramObject;
  }

  public Object resultToJava(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    Object localObject1 = resultToSqlArg(paramFieldType, paramDatabaseResults, paramInt);
    if (localObject1 == null);
    for (Object localObject2 = null; ; localObject2 = sqlArgToJava(paramFieldType, localObject1, paramInt))
      return localObject2;
  }

  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    return paramObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.BaseFieldConverter
 * JD-Core Version:    0.6.2
 */