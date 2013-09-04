package com.j256.ormlite.table;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TableInfo<T, ID>
{
  private static final FieldType[] NO_FOREIGN_COLLECTIONS = new FieldType[0];
  private final Constructor<T> constructor;
  private final Dao<T, ID> dao;
  private final Class<T> dataClass;
  private Map<String, FieldType> fieldNameMap;
  private final FieldType[] fieldTypes;
  private final boolean foreignAutoCreate;
  private final FieldType[] foreignCollections;
  private final FieldType idField;
  private final String tableName;

  public TableInfo(DatabaseType paramDatabaseType, Dao<T, ID> paramDao, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    this.dao = paramDao;
    Class localClass1 = paramDatabaseTableConfig.getDataClass();
    this.dataClass = localClass1;
    String str1 = paramDatabaseTableConfig.getTableName();
    this.tableName = str1;
    FieldType[] arrayOfFieldType1 = paramDatabaseTableConfig.getFieldTypes(paramDatabaseType);
    this.fieldTypes = arrayOfFieldType1;
    Object localObject = null;
    boolean bool = false;
    int i = 0;
    FieldType[] arrayOfFieldType2 = this.fieldTypes;
    int j = arrayOfFieldType2.length;
    int k = 0;
    while (k < j)
    {
      FieldType localFieldType1 = arrayOfFieldType2[k];
      if ((localFieldType1.isId()) || (localFieldType1.isGeneratedId()) || (localFieldType1.isGeneratedIdSequence()))
      {
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("More than 1 idField configured for class ");
          Class localClass2 = this.dataClass;
          String str2 = localClass2 + " (" + localObject + "," + localFieldType1 + ")";
          throw new SQLException(str2);
        }
        localObject = localFieldType1;
      }
      if (localFieldType1.isForeignAutoCreate())
        bool = true;
      if (localFieldType1.isForeignCollection())
        i += 1;
      k += 1;
    }
    this.idField = localObject;
    Constructor localConstructor = paramDatabaseTableConfig.getConstructor();
    this.constructor = localConstructor;
    this.foreignAutoCreate = bool;
    if (i == 0)
    {
      FieldType[] arrayOfFieldType3 = NO_FOREIGN_COLLECTIONS;
      this.foreignCollections = arrayOfFieldType3;
      return;
    }
    FieldType[] arrayOfFieldType4 = new FieldType[i];
    this.foreignCollections = arrayOfFieldType4;
    i = 0;
    arrayOfFieldType2 = this.fieldTypes;
    j = arrayOfFieldType2.length;
    k = 0;
    while (true)
    {
      if (k >= j)
        return;
      FieldType localFieldType2 = arrayOfFieldType2[k];
      if (localFieldType2.isForeignCollection())
      {
        this.foreignCollections[i] = localFieldType2;
        int m = i + 1;
      }
      k += 1;
    }
  }

  public TableInfo(ConnectionSource paramConnectionSource, Dao<T, ID> paramDao, Class<T> paramClass)
    throws SQLException
  {
    this(localDatabaseType, paramDao, localDatabaseTableConfig);
  }

  public static <T, ID> T createObject(Constructor<?> paramConstructor, Dao<T, ID> paramDao)
    throws SQLException
  {
    try
    {
      Object[] arrayOfObject = new Object[0];
      Object localObject = paramConstructor.newInstance(arrayOfObject);
      if ((localObject instanceof BaseDaoEnabled))
        ((BaseDaoEnabled)localObject).setDao(paramDao);
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Could not create object for ");
      Class localClass = paramConstructor.getDeclaringClass();
      throw SqlExceptionUtil.create(localClass, localException);
    }
  }

  public T createObject()
    throws SQLException
  {
    Constructor localConstructor = this.constructor;
    Dao localDao = this.dao;
    return createObject(localConstructor, localDao);
  }

  public Constructor<T> getConstructor()
  {
    return this.constructor;
  }

  public Class<T> getDataClass()
  {
    return this.dataClass;
  }

  public FieldType getFieldTypeByColumnName(String paramString)
  {
    if (this.fieldNameMap == null)
    {
      HashMap localHashMap = new HashMap();
      FieldType[] arrayOfFieldType1 = this.fieldTypes;
      int i = arrayOfFieldType1.length;
      int j = 0;
      while (j < i)
      {
        FieldType localFieldType1 = arrayOfFieldType1[j];
        String str1 = localFieldType1.getColumnName();
        Object localObject = localHashMap.put(str1, localFieldType1);
        j += 1;
      }
      this.fieldNameMap = localHashMap;
    }
    FieldType localFieldType2 = (FieldType)this.fieldNameMap.get(paramString);
    if (localFieldType2 != null)
      return localFieldType2;
    FieldType[] arrayOfFieldType2 = this.fieldTypes;
    int k = arrayOfFieldType2.length;
    int m = 0;
    while (m < k)
    {
      FieldType localFieldType3 = arrayOfFieldType2[m];
      if (localFieldType3.getFieldName().equals(paramString))
      {
        StringBuilder localStringBuilder1 = new StringBuilder().append("You should use columnName '");
        String str2 = localFieldType3.getColumnName();
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("' for table ");
        String str3 = this.tableName;
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str3).append(" instead of fieldName '");
        String str4 = localFieldType3.getFieldName();
        String str5 = str4 + "'";
        throw new IllegalArgumentException(str5);
      }
      m += 1;
    }
    StringBuilder localStringBuilder4 = new StringBuilder().append("Unknown column name '").append(paramString).append("' in table ");
    String str6 = this.tableName;
    String str7 = str6;
    throw new IllegalArgumentException(str7);
  }

  public FieldType[] getFieldTypes()
  {
    return this.fieldTypes;
  }

  public FieldType[] getForeignCollections()
  {
    return this.foreignCollections;
  }

  public FieldType getIdField()
  {
    return this.idField;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public boolean hasColumnName(String paramString)
  {
    FieldType[] arrayOfFieldType = this.fieldTypes;
    int i = arrayOfFieldType.length;
    int j = 0;
    if (j < i)
      if (!arrayOfFieldType[j].getColumnName().equals(paramString));
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      j += 1;
      break;
    }
  }

  public boolean isForeignAutoCreate()
  {
    return this.foreignAutoCreate;
  }

  public boolean isUpdatable()
  {
    boolean bool = true;
    if ((this.idField != null) && (this.fieldTypes.length > 1));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public String objectToString(T paramT)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(64);
    String str1 = paramT.getClass().getSimpleName();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    FieldType[] arrayOfFieldType = this.fieldTypes;
    int i = arrayOfFieldType.length;
    int j = 0;
    while (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      StringBuilder localStringBuilder3 = localStringBuilder1.append(' ');
      String str2 = localFieldType.getColumnName();
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str2).append("=");
      try
      {
        Object localObject = localFieldType.extractJavaFieldValue(paramT);
        StringBuilder localStringBuilder5 = localStringBuilder1.append(localObject);
        j += 1;
      }
      catch (Exception localException)
      {
        String str3 = "Could not generate toString of field " + localFieldType;
        throw new IllegalStateException(str3, localException);
      }
    }
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.table.TableInfo
 * JD-Core Version:    0.6.2
 */