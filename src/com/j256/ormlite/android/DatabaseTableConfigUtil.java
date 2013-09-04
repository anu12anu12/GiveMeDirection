package com.j256.ormlite.android;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTableConfigUtil
{
  private static final int ALLOW_GENERATED_ID_INSERT = 24;
  private static final int CAN_BE_NULL = 5;
  private static final int COLUMN_DEFINITON = 25;
  private static final int COLUMN_NAME = 1;
  private static final int DATA_TYPE = 2;
  private static final int DEFAULT_VALUE = 3;
  private static final int FOREIGN = 9;
  private static final int FOREIGN_AUTO_CREATE = 26;
  private static final int FOREIGN_AUTO_REFRESH = 21;
  private static final int FOREIGN_COLUMN_NAME = 28;
  private static final int FORMAT = 14;
  private static final int GENERATED_ID = 7;
  private static final int GENERATED_ID_SEQUENCE = 8;
  private static final int ID = 6;
  private static final int INDEX = 17;
  private static final int INDEX_NAME = 19;
  private static final int MAX_FOREIGN_AUTO_REFRESH_LEVEL = 22;
  private static final int PERSISTED = 13;
  private static final int PERSISTER_CLASS = 23;
  private static final int THROW_IF_NULL = 12;
  private static final int UNIQUE = 15;
  private static final int UNIQUE_COMBO = 16;
  private static final int UNIQUE_INDEX = 18;
  private static final int UNIQUE_INDEX_NAME = 20;
  private static final int UNKNOWN_ENUM_NAME = 11;
  private static final int USE_GET_SET = 10;
  private static final int VERSION = 27;
  private static final int WIDTH = 4;
  private static Class<?> annotationFactoryClazz;
  private static Class<?> annotationMemberClazz;
  private static final int[] configFieldNums = lookupClasses();
  private static Field elementsField;
  private static Field nameField;
  private static Field valueField;
  private static int workedC = 0;

  private static void assignConfigField(int paramInt, DatabaseFieldConfig paramDatabaseFieldConfig, Field paramField, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      String str1 = "Could not find support for DatabaseField number " + paramInt;
      throw new IllegalStateException(str1);
    case 1:
      String str2 = valueIfNotBlank((String)paramObject);
      paramDatabaseFieldConfig.setColumnName(str2);
      return;
    case 2:
      DataType localDataType = (DataType)paramObject;
      paramDatabaseFieldConfig.setDataType(localDataType);
      return;
    case 3:
      String str3 = (String)paramObject;
      if (str3 == null)
        return;
      if (str3.equals("__ormlite__ no default value string was specified"))
        return;
      paramDatabaseFieldConfig.setDefaultValue(str3);
      return;
    case 4:
      int i = ((Integer)paramObject).intValue();
      paramDatabaseFieldConfig.setWidth(i);
      return;
    case 5:
      boolean bool1 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setCanBeNull(bool1);
      return;
    case 6:
      boolean bool2 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setId(bool2);
      return;
    case 7:
      boolean bool3 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setGeneratedId(bool3);
      return;
    case 8:
      String str4 = valueIfNotBlank((String)paramObject);
      paramDatabaseFieldConfig.setGeneratedIdSequence(str4);
      return;
    case 9:
      boolean bool4 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setForeign(bool4);
      return;
    case 10:
      boolean bool5 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setUseGetSet(bool5);
      return;
    case 11:
      String str5 = (String)paramObject;
      Enum localEnum = DatabaseFieldConfig.findMatchingEnumVal(paramField, str5);
      paramDatabaseFieldConfig.setUnknownEnumValue(localEnum);
      return;
    case 12:
      boolean bool6 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setThrowIfNull(bool6);
      return;
    case 13:
      boolean bool7 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setPersisted(bool7);
      return;
    case 14:
      String str6 = valueIfNotBlank((String)paramObject);
      paramDatabaseFieldConfig.setFormat(str6);
      return;
    case 15:
      boolean bool8 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setUnique(bool8);
      return;
    case 16:
      boolean bool9 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setUniqueCombo(bool9);
      return;
    case 17:
      boolean bool10 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setIndex(bool10);
      return;
    case 18:
      boolean bool11 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setUniqueIndex(bool11);
      return;
    case 19:
      String str7 = valueIfNotBlank((String)paramObject);
      paramDatabaseFieldConfig.setIndexName(str7);
      return;
    case 20:
      String str8 = valueIfNotBlank((String)paramObject);
      paramDatabaseFieldConfig.setUniqueIndexName(str8);
      return;
    case 21:
      boolean bool12 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setForeignAutoRefresh(bool12);
      return;
    case 22:
      int j = ((Integer)paramObject).intValue();
      paramDatabaseFieldConfig.setMaxForeignAutoRefreshLevel(j);
      return;
    case 23:
      Class localClass = (Class)paramObject;
      paramDatabaseFieldConfig.setPersisterClass(localClass);
      return;
    case 24:
      boolean bool13 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setAllowGeneratedIdInsert(bool13);
      return;
    case 25:
      String str9 = valueIfNotBlank((String)paramObject);
      paramDatabaseFieldConfig.setColumnDefinition(str9);
      return;
    case 26:
      boolean bool14 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setForeignAutoCreate(bool14);
      return;
    case 27:
      boolean bool15 = ((Boolean)paramObject).booleanValue();
      paramDatabaseFieldConfig.setVersion(bool15);
      return;
    case 28:
    }
    String str10 = valueIfNotBlank((String)paramObject);
    paramDatabaseFieldConfig.setForeignColumnName(str10);
  }

  private static DatabaseFieldConfig buildConfig(DatabaseField paramDatabaseField, String paramString, Field paramField)
    throws Exception
  {
    DatabaseFieldConfig localDatabaseFieldConfig = null;
    InvocationHandler localInvocationHandler = Proxy.getInvocationHandler(paramDatabaseField);
    Class localClass1 = localInvocationHandler.getClass();
    Class localClass2 = annotationFactoryClazz;
    if (localClass1 != localClass2);
    Object localObject1;
    do
    {
      return localDatabaseFieldConfig;
      localObject1 = elementsField.get(localInvocationHandler);
    }
    while (localObject1 == null);
    String str = paramField.getName();
    localDatabaseFieldConfig = new DatabaseFieldConfig(str);
    Object[] arrayOfObject = (Object[])localObject1;
    int i = 0;
    while (true)
    {
      int j = configFieldNums.length;
      if (i >= j)
        break;
      Field localField = valueField;
      Object localObject2 = arrayOfObject[i];
      Object localObject3 = localField.get(localObject2);
      if (localObject3 != null)
        assignConfigField(configFieldNums[i], localDatabaseFieldConfig, paramField, localObject3);
      i += 1;
    }
  }

  private static int configFieldNameToNum(String paramString)
  {
    int i;
    if (paramString.equals("columnName"))
      i = 1;
    while (true)
    {
      return i;
      if (paramString.equals("dataType"))
      {
        i = 2;
      }
      else if (paramString.equals("defaultValue"))
      {
        i = 3;
      }
      else if (paramString.equals("width"))
      {
        i = 4;
      }
      else if (paramString.equals("canBeNull"))
      {
        i = 5;
      }
      else if (paramString.equals("id"))
      {
        i = 6;
      }
      else if (paramString.equals("generatedId"))
      {
        i = 7;
      }
      else if (paramString.equals("generatedIdSequence"))
      {
        i = 8;
      }
      else if (paramString.equals("foreign"))
      {
        i = 9;
      }
      else if (paramString.equals("useGetSet"))
      {
        i = 10;
      }
      else if (paramString.equals("unknownEnumName"))
      {
        i = 11;
      }
      else if (paramString.equals("throwIfNull"))
      {
        i = 12;
      }
      else if (paramString.equals("persisted"))
      {
        i = 13;
      }
      else if (paramString.equals("format"))
      {
        i = 14;
      }
      else if (paramString.equals("unique"))
      {
        i = 15;
      }
      else if (paramString.equals("uniqueCombo"))
      {
        i = 16;
      }
      else if (paramString.equals("index"))
      {
        i = 17;
      }
      else if (paramString.equals("uniqueIndex"))
      {
        i = 18;
      }
      else if (paramString.equals("indexName"))
      {
        i = 19;
      }
      else if (paramString.equals("uniqueIndexName"))
      {
        i = 20;
      }
      else if (paramString.equals("foreignAutoRefresh"))
      {
        i = 21;
      }
      else if (paramString.equals("maxForeignAutoRefreshLevel"))
      {
        i = 22;
      }
      else if (paramString.equals("persisterClass"))
      {
        i = 23;
      }
      else if (paramString.equals("allowGeneratedIdInsert"))
      {
        i = 24;
      }
      else if (paramString.equals("columnDefinition"))
      {
        i = 25;
      }
      else if (paramString.equals("foreignAutoCreate"))
      {
        i = 26;
      }
      else if (paramString.equals("version"))
      {
        i = 27;
      }
      else
      {
        if (!paramString.equals("foreignColumnName"))
          break;
        i = 28;
      }
    }
    String str = "Could not find support for DatabaseField " + paramString;
    throw new IllegalStateException(str);
  }

  private static DatabaseFieldConfig configFromField(DatabaseType paramDatabaseType, String paramString, Field paramField)
    throws SQLException
  {
    DatabaseFieldConfig localDatabaseFieldConfig1;
    if (configFieldNums == null)
      localDatabaseFieldConfig1 = DatabaseFieldConfig.fromField(paramDatabaseType, paramString, paramField);
    while (true)
    {
      return localDatabaseFieldConfig1;
      DatabaseField localDatabaseField = (DatabaseField)paramField.getAnnotation(DatabaseField.class);
      localDatabaseFieldConfig1 = null;
      if (localDatabaseField != null);
      try
      {
        DatabaseFieldConfig localDatabaseFieldConfig2 = buildConfig(localDatabaseField, paramString, paramField);
        DatabaseFieldConfig localDatabaseFieldConfig3 = localDatabaseFieldConfig2;
        label47: if (localDatabaseFieldConfig1 == null)
        {
          localDatabaseFieldConfig1 = DatabaseFieldConfig.fromField(paramDatabaseType, paramString, paramField);
          continue;
        }
        workedC += 1;
      }
      catch (Exception localException)
      {
        break label47;
      }
    }
  }

  public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    String str = DatabaseTableConfig.extractTableName(paramClass);
    ArrayList localArrayList = new ArrayList();
    for (Object localObject1 = paramClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass())
    {
      Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
      int i = arrayOfField.length;
      int j = 0;
      while (j < i)
      {
        Field localField = arrayOfField[j];
        DatabaseFieldConfig localDatabaseFieldConfig = configFromField(localDatabaseType, str, localField);
        if ((localDatabaseFieldConfig != null) && (localDatabaseFieldConfig.isPersisted()))
          boolean bool = localArrayList.add(localDatabaseFieldConfig);
        j += 1;
      }
    }
    if (localArrayList.size() == 0);
    for (Object localObject2 = null; ; localObject2 = new DatabaseTableConfig(paramClass, str, localArrayList))
      return localObject2;
  }

  public static int getWorkedC()
  {
    return workedC;
  }

  private static int[] lookupClasses()
  {
    try
    {
      annotationFactoryClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationFactory");
      annotationMemberClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationMember");
      localClass1 = Class.forName("[Lorg.apache.harmony.lang.annotation.AnnotationMember;");
      annotationMemberClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationMember");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        elementsField = annotationFactoryClazz.getDeclaredField("elements");
        elementsField.setAccessible(true);
        nameField = annotationMemberClazz.getDeclaredField("name");
        nameField.setAccessible(true);
        valueField = annotationMemberClazz.getDeclaredField("value");
        valueField.setAccessible(true);
        Field localField1 = DatabaseFieldSample.class.getDeclaredField("field");
        localInvocationHandler = Proxy.getInvocationHandler((DatabaseField)localField1.getAnnotation(DatabaseField.class));
        Class localClass2 = localInvocationHandler.getClass();
        Class localClass3 = annotationFactoryClazz;
        if (localClass2 != localClass3)
          for (arrayOfInt = null; ; arrayOfInt = null)
          {
            return arrayOfInt;
            localClassNotFoundException = localClassNotFoundException;
          }
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
          arrayOfInt = null;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        while (true)
        {
          Class localClass1;
          InvocationHandler localInvocationHandler;
          int[] arrayOfInt = null;
          continue;
          try
          {
            Object localObject1 = elementsField.get(localInvocationHandler);
            if ((localObject1 == null) || (localObject1.getClass() != localClass1))
            {
              arrayOfInt = null;
            }
            else
            {
              Object[] arrayOfObject = (Object[])localObject1;
              arrayOfInt = new int[arrayOfObject.length];
              int i = 0;
              while (true)
              {
                int j = arrayOfObject.length;
                if (i >= j)
                  break;
                Field localField2 = nameField;
                Object localObject2 = arrayOfObject[i];
                int k = configFieldNameToNum((String)localField2.get(localObject2));
                arrayOfInt[i] = k;
                i += 1;
              }
            }
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            arrayOfInt = null;
          }
        }
      }
    }
  }

  private static String valueIfNotBlank(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      paramString = null;
    return paramString;
  }

  private static class DatabaseFieldSample
  {

    @DatabaseField
    String field;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.android.DatabaseTableConfigUtil
 * JD-Core Version:    0.6.2
 */