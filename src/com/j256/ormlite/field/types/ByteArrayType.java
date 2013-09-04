package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Arrays;

public class ByteArrayType extends BaseDataType
{
  private static final ByteArrayType singleTon = new ByteArrayType();

  private ByteArrayType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected ByteArrayType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static ByteArrayType getSingleton()
  {
    return singleTon;
  }

  public boolean dataIsEqual(Object paramObject1, Object paramObject2)
  {
    boolean bool = false;
    if (paramObject1 == null)
      if (paramObject2 == null)
        bool = true;
    while (true)
    {
      return bool;
      if (paramObject2 != null)
      {
        byte[] arrayOfByte1 = (byte[])paramObject1;
        byte[] arrayOfByte2 = (byte[])paramObject2;
        bool = Arrays.equals(arrayOfByte1, arrayOfByte2);
      }
    }
  }

  public boolean isAppropriateId()
  {
    return false;
  }

  public boolean isArgumentHolderRequired()
  {
    return true;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    throw new SQLException("byte[] type cannot have default values");
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return (byte[])paramDatabaseResults.getBytes(paramInt);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.ByteArrayType
 * JD-Core Version:    0.6.2
 */