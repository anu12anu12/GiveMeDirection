package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class ShortObjectType extends BaseDataType
{
  private static final ShortObjectType singleTon = new ShortObjectType();

  private ShortObjectType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected ShortObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static ShortObjectType getSingleton()
  {
    return singleTon;
  }

  public boolean isEscapedValue()
  {
    return false;
  }

  public boolean isValidForVersion()
  {
    return true;
  }

  public Object moveToNextValue(Object paramObject)
  {
    if (paramObject == null);
    for (Short localShort = Short.valueOf((short)1); ; localShort = Short.valueOf((short)(((Short)paramObject).shortValue() + 1)))
      return localShort;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return Short.valueOf(Short.parseShort(paramString));
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Short.valueOf(paramDatabaseResults.getShort(paramInt));
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.ShortObjectType
 * JD-Core Version:    0.6.2
 */