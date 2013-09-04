package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseTableConfig<T>
{
  private Constructor<T> constructor;
  private Class<T> dataClass;
  private List<DatabaseFieldConfig> fieldConfigs;
  private FieldType[] fieldTypes;
  private String tableName;

  public DatabaseTableConfig()
  {
  }

  public DatabaseTableConfig(Class<T> paramClass, String paramString, List<DatabaseFieldConfig> paramList)
  {
    this.dataClass = paramClass;
    this.tableName = paramString;
    this.fieldConfigs = paramList;
  }

  private DatabaseTableConfig(Class<T> paramClass, String paramString, FieldType[] paramArrayOfFieldType)
  {
    this.dataClass = paramClass;
    this.tableName = paramString;
    this.fieldTypes = paramArrayOfFieldType;
  }

  public DatabaseTableConfig(Class<T> paramClass, List<DatabaseFieldConfig> paramList)
  {
    this(paramClass, str, paramList);
  }

  private FieldType[] convertFieldConfigs(ConnectionSource paramConnectionSource, String paramString, List<DatabaseFieldConfig> paramList)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DatabaseFieldConfig localDatabaseFieldConfig = (DatabaseFieldConfig)localIterator.next();
      FieldType localFieldType = null;
      Class localClass1 = this.dataClass;
      while (true)
      {
        if (localClass1 != null);
        try
        {
          String str1 = localDatabaseFieldConfig.getFieldName();
          Field localField1 = localClass1.getDeclaredField(str1);
          Field localField2 = localField1;
          if (localField2 != null)
          {
            Class localClass2 = this.dataClass;
            ConnectionSource localConnectionSource = paramConnectionSource;
            String str2 = paramString;
            localFieldType = new FieldType(localConnectionSource, str2, localField2, localDatabaseFieldConfig, localClass2);
            if (localFieldType != null)
              break;
            StringBuilder localStringBuilder1 = new StringBuilder().append("Could not find declared field with name '");
            String str3 = localDatabaseFieldConfig.getFieldName();
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append("' for ");
            Class localClass3 = this.dataClass;
            String str4 = localClass3;
            throw new SQLException(str4);
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localClass1 = localClass1.getSuperclass();
        }
      }
      boolean bool = localArrayList.add(localFieldType);
    }
    if (localArrayList.isEmpty())
    {
      StringBuilder localStringBuilder3 = new StringBuilder().append("No fields were configured for class ");
      Class localClass4 = this.dataClass;
      String str5 = localClass4;
      throw new SQLException(str5);
    }
    FieldType[] arrayOfFieldType = new FieldType[localArrayList.size()];
    return (FieldType[])localArrayList.toArray(arrayOfFieldType);
  }

  private static <T> FieldType[] extractFieldTypes(ConnectionSource paramConnectionSource, Class<T> paramClass, String paramString)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    for (Object localObject = paramClass; localObject != null; localObject = ((Class)localObject).getSuperclass())
    {
      Field[] arrayOfField = ((Class)localObject).getDeclaredFields();
      int i = arrayOfField.length;
      int j = 0;
      while (j < i)
      {
        Field localField = arrayOfField[j];
        FieldType localFieldType = FieldType.createFieldType(paramConnectionSource, paramString, localField, paramClass);
        if (localFieldType != null)
          boolean bool = localArrayList.add(localFieldType);
        j += 1;
      }
    }
    if (localArrayList.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("No fields have a ");
      String str1 = DatabaseField.class.getSimpleName();
      String str2 = str1 + " annotation in " + paramClass;
      throw new IllegalArgumentException(str2);
    }
    FieldType[] arrayOfFieldType = new FieldType[localArrayList.size()];
    return (FieldType[])localArrayList.toArray(arrayOfFieldType);
  }

  public static <T> String extractTableName(Class<T> paramClass)
  {
    DatabaseTable localDatabaseTable = (DatabaseTable)paramClass.getAnnotation(DatabaseTable.class);
    String str;
    if ((localDatabaseTable != null) && (localDatabaseTable.tableName() != null) && (localDatabaseTable.tableName().length() > 0))
      str = localDatabaseTable.tableName();
    while (true)
    {
      return str;
      str = JavaxPersistence.getEntityName(paramClass);
      if (str == null)
        str = paramClass.getSimpleName().toLowerCase();
    }
  }

  // ERROR //
  public static <T> Constructor<T> findNoArgConstructor(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 177	java/lang/Class:getDeclaredConstructors	()[Ljava/lang/reflect/Constructor;
    //   4: checkcast 179	[Ljava/lang/reflect/Constructor;
    //   7: astore_1
    //   8: aload_1
    //   9: astore_2
    //   10: aload_2
    //   11: arraylength
    //   12: istore_3
    //   13: iconst_0
    //   14: istore 4
    //   16: iload 4
    //   18: iload_3
    //   19: if_icmpge +116 -> 135
    //   22: aload_2
    //   23: iload 4
    //   25: aaload
    //   26: astore 5
    //   28: aload 5
    //   30: invokevirtual 185	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   33: arraylength
    //   34: ifne +92 -> 126
    //   37: aload 5
    //   39: invokevirtual 188	java/lang/reflect/Constructor:isAccessible	()Z
    //   42: ifne +13 -> 55
    //   45: iconst_1
    //   46: istore 6
    //   48: aload 5
    //   50: iload 6
    //   52: invokevirtual 192	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   55: aload 5
    //   57: areturn
    //   58: astore 7
    //   60: new 84	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   67: ldc 194
    //   69: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 8
    //   81: new 145	java/lang/IllegalArgumentException
    //   84: dup
    //   85: aload 8
    //   87: aload 7
    //   89: invokespecial 197	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   92: athrow
    //   93: astore 9
    //   95: new 84	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   102: ldc 199
    //   104: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 10
    //   116: new 145	java/lang/IllegalArgumentException
    //   119: dup
    //   120: aload 10
    //   122: invokespecial 146	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //   126: iload 4
    //   128: iconst_1
    //   129: iadd
    //   130: istore 4
    //   132: goto -116 -> 16
    //   135: aload_0
    //   136: invokevirtual 202	java/lang/Class:getEnclosingClass	()Ljava/lang/Class;
    //   139: ifnonnull +34 -> 173
    //   142: new 84	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   149: ldc 204
    //   151: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: astore 11
    //   163: new 145	java/lang/IllegalArgumentException
    //   166: dup
    //   167: aload 11
    //   169: invokespecial 146	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   172: athrow
    //   173: new 84	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   180: ldc 204
    //   182: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   189: ldc 206
    //   191: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore 12
    //   199: new 145	java/lang/IllegalArgumentException
    //   202: dup
    //   203: aload 12
    //   205: invokespecial 146	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	58	java/lang/Exception
    //   48	55	93	java/lang/SecurityException
  }

  public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    String str = extractTableName(paramClass);
    if (paramConnectionSource.getDatabaseType().isEntityNamesMustBeUpCase())
      str = str.toUpperCase();
    FieldType[] arrayOfFieldType = extractFieldTypes(paramConnectionSource, paramClass, str);
    return new DatabaseTableConfig(paramClass, str, arrayOfFieldType);
  }

  public void extractFieldTypes(ConnectionSource paramConnectionSource)
    throws SQLException
  {
    if (this.fieldTypes != null)
      return;
    if (this.fieldConfigs == null)
    {
      Class localClass = this.dataClass;
      String str1 = this.tableName;
      FieldType[] arrayOfFieldType1 = extractFieldTypes(paramConnectionSource, localClass, str1);
      this.fieldTypes = arrayOfFieldType1;
      return;
    }
    String str2 = this.tableName;
    List localList = this.fieldConfigs;
    FieldType[] arrayOfFieldType2 = convertFieldConfigs(paramConnectionSource, str2, localList);
    this.fieldTypes = arrayOfFieldType2;
  }

  public Constructor<T> getConstructor()
  {
    if (this.constructor == null)
    {
      Constructor localConstructor = findNoArgConstructor(this.dataClass);
      this.constructor = localConstructor;
    }
    return this.constructor;
  }

  public Class<T> getDataClass()
  {
    return this.dataClass;
  }

  public List<DatabaseFieldConfig> getFieldConfigs()
  {
    return this.fieldConfigs;
  }

  public FieldType[] getFieldTypes(DatabaseType paramDatabaseType)
    throws SQLException
  {
    if (this.fieldTypes == null)
      throw new SQLException("Field types have not been extracted in table config");
    return this.fieldTypes;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public void initialize()
  {
    if (this.dataClass == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("dataClass was never set on ");
      String str1 = getClass().getSimpleName();
      String str2 = str1;
      throw new IllegalStateException(str2);
    }
    if (this.tableName != null)
      return;
    String str3 = extractTableName(this.dataClass);
    this.tableName = str3;
  }

  public void setConstructor(Constructor<T> paramConstructor)
  {
    this.constructor = paramConstructor;
  }

  public void setDataClass(Class<T> paramClass)
  {
    this.dataClass = paramClass;
  }

  public void setFieldConfigs(List<DatabaseFieldConfig> paramList)
  {
    this.fieldConfigs = paramList;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.table.DatabaseTableConfig
 * JD-Core Version:    0.6.2
 */