package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnumIntegerType extends BaseEnumType
{
  private static final EnumIntegerType singleTon = new EnumIntegerType();

  private EnumIntegerType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected EnumIntegerType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static EnumIntegerType getSingleton()
  {
    return singleTon;
  }

  public boolean isEscapedValue()
  {
    return false;
  }

  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return Integer.valueOf(((Enum)paramObject).ordinal());
  }

  public Object makeConfigObject(FieldType paramFieldType)
    throws SQLException
  {
    HashMap localHashMap = new HashMap();
    Enum[] arrayOfEnum1 = (Enum[])paramFieldType.getType().getEnumConstants();
    if (arrayOfEnum1 == null)
    {
      String str = "Field " + paramFieldType + " improperly configured as type " + this;
      throw new SQLException(str);
    }
    Enum[] arrayOfEnum2 = arrayOfEnum1;
    int i = arrayOfEnum2.length;
    int j = 0;
    while (j < i)
    {
      Enum localEnum = arrayOfEnum2[j];
      Integer localInteger = Integer.valueOf(localEnum.ordinal());
      Object localObject = localHashMap.put(localInteger, localEnum);
      j += 1;
    }
    return localHashMap;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return Integer.valueOf(Integer.parseInt(paramString));
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Integer.valueOf(paramDatabaseResults.getInt(paramInt));
  }

  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    if (paramFieldType == null);
    while (true)
    {
      return paramObject;
      Integer localInteger = (Integer)paramObject;
      Map localMap = (Map)paramFieldType.getDataTypeConfigObj();
      if (localMap == null)
      {
        Enum localEnum1 = paramFieldType.getUnknownEnumVal();
        paramObject = enumVal(paramFieldType, localInteger, null, localEnum1);
      }
      else
      {
        Enum localEnum2 = (Enum)localMap.get(localInteger);
        Enum localEnum3 = paramFieldType.getUnknownEnumVal();
        paramObject = enumVal(paramFieldType, localInteger, localEnum2, localEnum3);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.EnumIntegerType
 * JD-Core Version:    0.6.2
 */