package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnumStringType extends BaseEnumType
{
  public static int DEFAULT_WIDTH = 100;
  private static final EnumStringType singleTon = new EnumStringType();

  private EnumStringType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected EnumStringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static EnumStringType getSingleton()
  {
    return singleTon;
  }

  public int getDefaultWidth()
  {
    return DEFAULT_WIDTH;
  }

  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return ((Enum)paramObject).name();
  }

  public Object makeConfigObject(FieldType paramFieldType)
    throws SQLException
  {
    HashMap localHashMap = new HashMap();
    Enum[] arrayOfEnum1 = (Enum[])paramFieldType.getType().getEnumConstants();
    if (arrayOfEnum1 == null)
    {
      String str1 = "Field " + paramFieldType + " improperly configured as type " + this;
      throw new SQLException(str1);
    }
    Enum[] arrayOfEnum2 = arrayOfEnum1;
    int i = arrayOfEnum2.length;
    int j = 0;
    while (j < i)
    {
      Enum localEnum = arrayOfEnum2[j];
      String str2 = localEnum.name();
      Object localObject = localHashMap.put(str2, localEnum);
      j += 1;
    }
    return localHashMap;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return paramString;
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getString(paramInt);
  }

  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    if (paramFieldType == null);
    while (true)
    {
      return paramObject;
      String str = (String)paramObject;
      Map localMap = (Map)paramFieldType.getDataTypeConfigObj();
      if (localMap == null)
      {
        Enum localEnum1 = paramFieldType.getUnknownEnumVal();
        paramObject = enumVal(paramFieldType, str, null, localEnum1);
      }
      else
      {
        Enum localEnum2 = (Enum)localMap.get(str);
        Enum localEnum3 = paramFieldType.getUnknownEnumVal();
        paramObject = enumVal(paramFieldType, str, localEnum2, localEnum3);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.EnumStringType
 * JD-Core Version:    0.6.2
 */