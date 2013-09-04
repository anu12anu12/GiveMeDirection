package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class DateTimeType extends BaseDataType
{
  private static final String[] associatedClassNames = arrayOfString;
  private static Class<?> dateTimeClass;
  private static Method getMillisMethod;
  private static Constructor<?> millisConstructor;
  private static final DateTimeType singleTon = new DateTimeType();

  static
  {
    dateTimeClass = null;
    getMillisMethod = null;
    millisConstructor = null;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "org.joda.time.DateTime";
  }

  private DateTimeType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected DateTimeType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  private Constructor<?> getConstructor()
    throws Exception
  {
    if (millisConstructor == null)
    {
      Class localClass1 = getDateTimeClass();
      Class[] arrayOfClass = new Class[1];
      Class localClass2 = Long.TYPE;
      arrayOfClass[0] = localClass2;
      millisConstructor = localClass1.getConstructor(arrayOfClass);
    }
    return millisConstructor;
  }

  private Class<?> getDateTimeClass()
    throws ClassNotFoundException
  {
    if (dateTimeClass == null)
      dateTimeClass = Class.forName("org.joda.time.DateTime");
    return dateTimeClass;
  }

  private Method getMillisMethod()
    throws Exception
  {
    if (getMillisMethod == null)
    {
      Class localClass = getDateTimeClass();
      Class[] arrayOfClass = new Class[0];
      getMillisMethod = localClass.getMethod("getMillis", arrayOfClass);
    }
    return getMillisMethod;
  }

  public static DateTimeType getSingleton()
  {
    return singleTon;
  }

  public String[] getAssociatedClassNames()
  {
    return associatedClassNames;
  }

  public boolean isAppropriateId()
  {
    return false;
  }

  public boolean isEscapedValue()
  {
    return false;
  }

  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    throws SQLException
  {
    try
    {
      Method localMethod = getMillisMethod();
      if (paramObject == null);
      Object localObject2;
      for (Object localObject1 = null; ; localObject1 = localObject2)
      {
        return localObject1;
        Object[] arrayOfObject = new Object[0];
        localObject2 = localMethod.invoke(paramObject, arrayOfObject);
      }
    }
    catch (Exception localException)
    {
      throw SqlExceptionUtil.create("Could not use reflection to get millis from Joda DateTime: " + paramObject, localException);
    }
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return Long.valueOf(Long.parseLong(paramString));
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Long.valueOf(paramDatabaseResults.getLong(paramInt));
  }

  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    try
    {
      Constructor localConstructor = getConstructor();
      Object[] arrayOfObject = new Object[1];
      Long localLong = (Long)paramObject;
      arrayOfObject[0] = localLong;
      Object localObject = localConstructor.newInstance(arrayOfObject);
      return localObject;
    }
    catch (Exception localException)
    {
      throw SqlExceptionUtil.create("Could not use reflection to construct a Joda DateTime", localException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.DateTimeType
 * JD-Core Version:    0.6.2
 */