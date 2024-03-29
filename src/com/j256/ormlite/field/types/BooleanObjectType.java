package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class BooleanObjectType extends BaseDataType
{
  private static final BooleanObjectType singleTon = new BooleanObjectType();

  private BooleanObjectType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected BooleanObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static BooleanObjectType getSingleton()
  {
    return singleTon;
  }

  public boolean isAppropriateId()
  {
    return false;
  }

  public boolean isEscapedValue()
  {
    return false;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return Boolean.valueOf(Boolean.parseBoolean(paramString));
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Boolean.valueOf(paramDatabaseResults.getBoolean(paramInt));
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.BooleanObjectType
 * JD-Core Version:    0.6.2
 */