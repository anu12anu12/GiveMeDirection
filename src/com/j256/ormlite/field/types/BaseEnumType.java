package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;

public abstract class BaseEnumType extends BaseDataType
{
  protected BaseEnumType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  protected static Enum<?> enumVal(FieldType paramFieldType, Object paramObject, Enum<?> paramEnum1, Enum<?> paramEnum2)
    throws SQLException
  {
    if (paramEnum1 != null);
    while (true)
    {
      return paramEnum1;
      if (paramEnum2 == null)
      {
        String str = "Cannot get enum value of '" + paramObject + "' for field " + paramFieldType;
        throw new SQLException(str);
      }
      paramEnum1 = paramEnum2;
    }
  }

  public boolean isValidForField(Field paramField)
  {
    return paramField.getType().isEnum();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.BaseEnumType
 * JD-Core Version:    0.6.2
 */