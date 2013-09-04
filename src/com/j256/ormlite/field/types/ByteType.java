package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class ByteType extends ByteObjectType
{
  private static final ByteType singleTon = new ByteType();

  private ByteType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected ByteType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static ByteType getSingleton()
  {
    return singleTon;
  }

  public boolean isPrimitive()
  {
    return true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.ByteType
 * JD-Core Version:    0.6.2
 */