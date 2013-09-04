package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;

public class SerializableType extends BaseDataType
{
  private static final SerializableType singleTon = new SerializableType();

  private SerializableType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected SerializableType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static SerializableType getSingleton()
  {
    return singleTon;
  }

  public boolean isAppropriateId()
  {
    return false;
  }

  public boolean isArgumentHolderRequired()
  {
    return true;
  }

  public boolean isComparable()
  {
    return false;
  }

  public boolean isStreamType()
  {
    return true;
  }

  public boolean isValidForField(Field paramField)
  {
    Class localClass = paramField.getType();
    return Serializable.class.isAssignableFrom(localClass);
  }

  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    throws SQLException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramObject);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw SqlExceptionUtil.create("Could not write serialized object to byte array: " + paramObject, localException);
    }
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    throw new SQLException("Default values for serializable types are not supported");
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getBytes(paramInt);
  }

  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    byte[] arrayOfByte = (byte[])paramObject;
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
      Object localObject = new ObjectInputStream(localByteArrayInputStream).readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("Could not read serialized object from byte array: ");
      String str = Arrays.toString(arrayOfByte);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str).append("(len ");
      int i = arrayOfByte.length;
      throw SqlExceptionUtil.create(i + ")", localException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.SerializableType
 * JD-Core Version:    0.6.2
 */