package com.j256.ormlite.field;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class DatabaseFieldConfig
{
  private static final boolean DEFAULT_CAN_BE_NULL = true;
  private static final DataType DEFAULT_DATA_TYPE = DataType.UNKNOWN;
  private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
  private static final int DEFAULT_MAX_FOREIGN_AUTO_REFRESH_LEVEL = 2;
  private static final Class<? extends DataPersister> DEFAULT_PERSISTER_CLASS = VoidType.class;
  private boolean allowGeneratedIdInsert;
  private boolean canBeNull;
  private String columnDefinition;
  private String columnName;
  private DataPersister dataPersister;
  private DataType dataType;
  private String defaultValue;
  private String fieldName;
  private boolean foreign;
  private boolean foreignAutoCreate;
  private boolean foreignAutoRefresh;
  private boolean foreignCollection;
  private String foreignCollectionColumnName;
  private boolean foreignCollectionEager;
  private String foreignCollectionForeignFieldName;
  private int foreignCollectionMaxEagerLevel;
  private String foreignCollectionOrderColumnName;
  private String foreignColumnName;
  private DatabaseTableConfig<?> foreignTableConfig;
  private String format;
  private boolean generatedId;
  private String generatedIdSequence;
  private boolean id;
  private boolean index;
  private String indexName;
  private int maxForeignAutoRefreshLevel;
  private boolean persisted;
  private Class<? extends DataPersister> persisterClass;
  private boolean throwIfNull;
  private boolean unique;
  private boolean uniqueCombo;
  private boolean uniqueIndex;
  private String uniqueIndexName;
  private Enum<?> unknownEnumValue;
  private boolean useGetSet;
  private boolean version;
  private int width;

  public DatabaseFieldConfig()
  {
    DataType localDataType = DEFAULT_DATA_TYPE;
    this.dataType = localDataType;
    this.canBeNull = true;
    this.persisted = true;
    this.maxForeignAutoRefreshLevel = 2;
    Class localClass = DEFAULT_PERSISTER_CLASS;
    this.persisterClass = localClass;
    this.foreignCollectionMaxEagerLevel = 1;
  }

  public DatabaseFieldConfig(String paramString)
  {
    DataType localDataType = DEFAULT_DATA_TYPE;
    this.dataType = localDataType;
    this.canBeNull = true;
    this.persisted = true;
    this.maxForeignAutoRefreshLevel = 2;
    Class localClass = DEFAULT_PERSISTER_CLASS;
    this.persisterClass = localClass;
    this.foreignCollectionMaxEagerLevel = 1;
    this.fieldName = paramString;
  }

  public DatabaseFieldConfig(String paramString1, String paramString2, DataType paramDataType, String paramString3, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, boolean paramBoolean4, DatabaseTableConfig<?> paramDatabaseTableConfig, boolean paramBoolean5, Enum<?> paramEnum, boolean paramBoolean6, String paramString5, boolean paramBoolean7, String paramString6, String paramString7, boolean paramBoolean8, int paramInt2, int paramInt3)
  {
    DataType localDataType1 = DEFAULT_DATA_TYPE;
    this.dataType = localDataType1;
    this.canBeNull = true;
    this.persisted = true;
    this.maxForeignAutoRefreshLevel = 2;
    Class localClass = DEFAULT_PERSISTER_CLASS;
    this.persisterClass = localClass;
    this.foreignCollectionMaxEagerLevel = 1;
    this.fieldName = paramString1;
    this.columnName = paramString2;
    DataType localDataType2 = DataType.UNKNOWN;
    this.dataType = localDataType2;
    this.defaultValue = paramString3;
    this.width = paramInt1;
    this.canBeNull = paramBoolean1;
    this.id = paramBoolean2;
    this.generatedId = paramBoolean3;
    this.generatedIdSequence = paramString4;
    this.foreign = paramBoolean4;
    this.foreignTableConfig = paramDatabaseTableConfig;
    this.useGetSet = paramBoolean5;
    this.unknownEnumValue = paramEnum;
    boolean bool1 = paramBoolean6;
    this.throwIfNull = bool1;
    String str1 = paramString5;
    this.format = str1;
    boolean bool2 = paramBoolean7;
    this.unique = bool2;
    String str2 = paramString6;
    this.indexName = str2;
    String str3 = paramString7;
    this.uniqueIndexName = str3;
    boolean bool3 = paramBoolean8;
    this.foreignAutoRefresh = bool3;
    int i = paramInt2;
    this.maxForeignAutoRefreshLevel = i;
    int j = paramInt3;
    this.foreignCollectionMaxEagerLevel = j;
  }

  public static Method findGetMethod(Field paramField, boolean paramBoolean)
  {
    String str1 = methodFromField(paramField, "get");
    Method localMethod2;
    try
    {
      Class localClass1 = paramField.getDeclaringClass();
      Class[] arrayOfClass = new Class[0];
      Method localMethod1 = localClass1.getMethod(str1, arrayOfClass);
      localMethod2 = localMethod1;
      Class localClass2 = localMethod2.getReturnType();
      Class localClass3 = paramField.getType();
      if (localClass2 != localClass3)
      {
        if (!paramBoolean)
          break label149;
        StringBuilder localStringBuilder = new StringBuilder().append("Return type of get method ").append(str1).append(" does not return ");
        Class localClass4 = paramField.getType();
        String str2 = localClass4;
        throw new IllegalArgumentException(str2);
      }
    }
    catch (Exception localException)
    {
      if (paramBoolean)
      {
        String str3 = "Could not find appropriate get method for " + paramField;
        throw new IllegalArgumentException(str3);
      }
      localMethod2 = null;
    }
    while (true)
    {
      return localMethod2;
      label149: localMethod2 = null;
    }
  }

  private String findIndexName(String paramString)
  {
    StringBuilder localStringBuilder1;
    String str1;
    if (this.columnName == null)
    {
      localStringBuilder1 = new StringBuilder().append(paramString).append("_");
      str1 = this.fieldName;
    }
    StringBuilder localStringBuilder2;
    String str3;
    for (String str2 = str1 + "_idx"; ; str2 = str3 + "_idx")
    {
      return str2;
      localStringBuilder2 = new StringBuilder().append(paramString).append("_");
      str3 = this.columnName;
    }
  }

  public static Enum<?> findMatchingEnumVal(Field paramField, String paramString)
  {
    Enum<?> localEnum;
    if ((paramString == null) || (paramString.length() == 0))
    {
      localEnum = null;
      return localEnum;
    }
    Enum[] arrayOfEnum = (Enum[])paramField.getType().getEnumConstants();
    int i = arrayOfEnum.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        break label68;
      localEnum = arrayOfEnum[j];
      if (localEnum.name().equals(paramString))
        break;
      j += 1;
    }
    label68: String str = "Unknwown enum unknown name " + paramString + " for field " + paramField;
    throw new IllegalArgumentException(str);
  }

  public static Method findSetMethod(Field paramField, boolean paramBoolean)
  {
    String str1 = methodFromField(paramField, "set");
    Method localMethod2;
    try
    {
      Class localClass1 = paramField.getDeclaringClass();
      Class[] arrayOfClass = new Class[1];
      Class localClass2 = paramField.getType();
      arrayOfClass[0] = localClass2;
      Method localMethod1 = localClass1.getMethod(str1, arrayOfClass);
      localMethod2 = localMethod1;
      Class localClass3 = localMethod2.getReturnType();
      Class localClass4 = Void.TYPE;
      if (localClass3 != localClass4)
      {
        if (!paramBoolean)
          break label166;
        StringBuilder localStringBuilder = new StringBuilder().append("Return type of set method ").append(str1).append(" returns ");
        Class localClass5 = localMethod2.getReturnType();
        String str2 = localClass5 + " instead of void";
        throw new IllegalArgumentException(str2);
      }
    }
    catch (Exception localException)
    {
      if (paramBoolean)
      {
        String str3 = "Could not find appropriate set method for " + paramField;
        throw new IllegalArgumentException(str3);
      }
      localMethod2 = null;
    }
    while (true)
    {
      return localMethod2;
      label166: localMethod2 = null;
    }
  }

  public static DatabaseFieldConfig fromDatabaseField(DatabaseType paramDatabaseType, String paramString, Field paramField, DatabaseField paramDatabaseField)
  {
    DatabaseFieldConfig localDatabaseFieldConfig = new DatabaseFieldConfig();
    String str1 = paramField.getName();
    localDatabaseFieldConfig.fieldName = str1;
    if (paramDatabaseType.isEntityNamesMustBeUpCase())
    {
      String str2 = localDatabaseFieldConfig.fieldName.toUpperCase();
      localDatabaseFieldConfig.fieldName = str2;
    }
    String str3 = valueIfNotBlank(paramDatabaseField.columnName());
    localDatabaseFieldConfig.columnName = str3;
    DataType localDataType = paramDatabaseField.dataType();
    localDatabaseFieldConfig.dataType = localDataType;
    String str4 = paramDatabaseField.defaultValue();
    if (!str4.equals("__ormlite__ no default value string was specified"))
      localDatabaseFieldConfig.defaultValue = str4;
    int i = paramDatabaseField.width();
    localDatabaseFieldConfig.width = i;
    boolean bool1 = paramDatabaseField.canBeNull();
    localDatabaseFieldConfig.canBeNull = bool1;
    boolean bool2 = paramDatabaseField.id();
    localDatabaseFieldConfig.id = bool2;
    boolean bool3 = paramDatabaseField.generatedId();
    localDatabaseFieldConfig.generatedId = bool3;
    String str5 = valueIfNotBlank(paramDatabaseField.generatedIdSequence());
    localDatabaseFieldConfig.generatedIdSequence = str5;
    boolean bool4 = paramDatabaseField.foreign();
    localDatabaseFieldConfig.foreign = bool4;
    boolean bool5 = paramDatabaseField.useGetSet();
    localDatabaseFieldConfig.useGetSet = bool5;
    String str6 = paramDatabaseField.unknownEnumName();
    Enum localEnum = findMatchingEnumVal(paramField, str6);
    localDatabaseFieldConfig.unknownEnumValue = localEnum;
    boolean bool6 = paramDatabaseField.throwIfNull();
    localDatabaseFieldConfig.throwIfNull = bool6;
    String str7 = valueIfNotBlank(paramDatabaseField.format());
    localDatabaseFieldConfig.format = str7;
    boolean bool7 = paramDatabaseField.unique();
    localDatabaseFieldConfig.unique = bool7;
    boolean bool8 = paramDatabaseField.uniqueCombo();
    localDatabaseFieldConfig.uniqueCombo = bool8;
    boolean bool9 = paramDatabaseField.index();
    localDatabaseFieldConfig.index = bool9;
    String str8 = valueIfNotBlank(paramDatabaseField.indexName());
    localDatabaseFieldConfig.indexName = str8;
    boolean bool10 = paramDatabaseField.uniqueIndex();
    localDatabaseFieldConfig.uniqueIndex = bool10;
    String str9 = valueIfNotBlank(paramDatabaseField.uniqueIndexName());
    localDatabaseFieldConfig.uniqueIndexName = str9;
    boolean bool11 = paramDatabaseField.foreignAutoRefresh();
    localDatabaseFieldConfig.foreignAutoRefresh = bool11;
    int j = paramDatabaseField.maxForeignAutoRefreshLevel();
    localDatabaseFieldConfig.maxForeignAutoRefreshLevel = j;
    Class localClass = paramDatabaseField.persisterClass();
    localDatabaseFieldConfig.persisterClass = localClass;
    boolean bool12 = paramDatabaseField.allowGeneratedIdInsert();
    localDatabaseFieldConfig.allowGeneratedIdInsert = bool12;
    String str10 = valueIfNotBlank(paramDatabaseField.columnDefinition());
    localDatabaseFieldConfig.columnDefinition = str10;
    boolean bool13 = paramDatabaseField.foreignAutoCreate();
    localDatabaseFieldConfig.foreignAutoCreate = bool13;
    boolean bool14 = paramDatabaseField.version();
    localDatabaseFieldConfig.version = bool14;
    String str11 = valueIfNotBlank(paramDatabaseField.foreignColumnName());
    localDatabaseFieldConfig.foreignColumnName = str11;
    return localDatabaseFieldConfig;
  }

  public static DatabaseFieldConfig fromField(DatabaseType paramDatabaseType, String paramString, Field paramField)
    throws SQLException
  {
    DatabaseField localDatabaseField = (DatabaseField)paramField.getAnnotation(DatabaseField.class);
    DatabaseFieldConfig localDatabaseFieldConfig;
    if (localDatabaseField != null)
      if (localDatabaseField.persisted())
        localDatabaseFieldConfig = fromDatabaseField(paramDatabaseType, paramString, paramField, localDatabaseField);
    while (true)
    {
      return localDatabaseFieldConfig;
      localDatabaseFieldConfig = null;
      continue;
      ForeignCollectionField localForeignCollectionField = (ForeignCollectionField)paramField.getAnnotation(ForeignCollectionField.class);
      if (localForeignCollectionField != null)
        localDatabaseFieldConfig = fromForeignCollection(paramDatabaseType, paramField, localForeignCollectionField);
      else
        localDatabaseFieldConfig = JavaxPersistence.createFieldConfig(paramDatabaseType, paramField);
    }
  }

  private static DatabaseFieldConfig fromForeignCollection(DatabaseType paramDatabaseType, Field paramField, ForeignCollectionField paramForeignCollectionField)
  {
    DatabaseFieldConfig localDatabaseFieldConfig = new DatabaseFieldConfig();
    String str1 = paramField.getName();
    localDatabaseFieldConfig.fieldName = str1;
    if (paramForeignCollectionField.columnName().length() > 0)
    {
      String str2 = paramForeignCollectionField.columnName();
      localDatabaseFieldConfig.columnName = str2;
    }
    localDatabaseFieldConfig.foreignCollection = true;
    boolean bool = paramForeignCollectionField.eager();
    localDatabaseFieldConfig.foreignCollectionEager = bool;
    int i = paramForeignCollectionField.maxEagerForeignCollectionLevel();
    String str5;
    String str6;
    if (i != 1)
    {
      localDatabaseFieldConfig.foreignCollectionMaxEagerLevel = i;
      String str3 = valueIfNotBlank(paramForeignCollectionField.orderColumnName());
      localDatabaseFieldConfig.foreignCollectionOrderColumnName = str3;
      String str4 = valueIfNotBlank(paramForeignCollectionField.columnName());
      localDatabaseFieldConfig.foreignCollectionColumnName = str4;
      str5 = valueIfNotBlank(paramForeignCollectionField.foreignFieldName());
      if (str5 != null)
        break label174;
      str6 = valueIfNotBlank(valueIfNotBlank(paramForeignCollectionField.foreignColumnName()));
    }
    label174: for (localDatabaseFieldConfig.foreignCollectionForeignFieldName = str6; ; localDatabaseFieldConfig.foreignCollectionForeignFieldName = str5)
    {
      return localDatabaseFieldConfig;
      int j = paramForeignCollectionField.maxEagerLevel();
      localDatabaseFieldConfig.foreignCollectionMaxEagerLevel = j;
      break;
    }
  }

  private static String methodFromField(Field paramField, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append(paramString);
    String str1 = paramField.getName().substring(0, 1).toUpperCase();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = paramField.getName().substring(1);
    return str2;
  }

  private static String valueIfNotBlank(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      paramString = null;
    return paramString;
  }

  public String getColumnDefinition()
  {
    return this.columnDefinition;
  }

  public String getColumnName()
  {
    return this.columnName;
  }

  public DataPersister getDataPersister()
  {
    if (this.dataPersister == null);
    for (DataPersister localDataPersister = this.dataType.getDataPersister(); ; localDataPersister = this.dataPersister)
      return localDataPersister;
  }

  public DataType getDataType()
  {
    return this.dataType;
  }

  public String getDefaultValue()
  {
    return this.defaultValue;
  }

  public String getFieldName()
  {
    return this.fieldName;
  }

  public String getForeignCollectionColumnName()
  {
    return this.foreignCollectionColumnName;
  }

  public String getForeignCollectionForeignFieldName()
  {
    return this.foreignCollectionForeignFieldName;
  }

  public int getForeignCollectionMaxEagerLevel()
  {
    return this.foreignCollectionMaxEagerLevel;
  }

  public String getForeignCollectionOrderColumnName()
  {
    return this.foreignCollectionOrderColumnName;
  }

  public String getForeignColumnName()
  {
    return this.foreignColumnName;
  }

  public DatabaseTableConfig<?> getForeignTableConfig()
  {
    return this.foreignTableConfig;
  }

  public String getFormat()
  {
    return this.format;
  }

  public String getGeneratedIdSequence()
  {
    return this.generatedIdSequence;
  }

  public String getIndexName(String paramString)
  {
    if ((this.index) && (this.indexName == null))
    {
      String str = findIndexName(paramString);
      this.indexName = str;
    }
    return this.indexName;
  }

  public int getMaxForeignAutoRefreshLevel()
  {
    return this.maxForeignAutoRefreshLevel;
  }

  public Class<? extends DataPersister> getPersisterClass()
  {
    return this.persisterClass;
  }

  public String getUniqueIndexName(String paramString)
  {
    if ((this.uniqueIndex) && (this.uniqueIndexName == null))
    {
      String str = findIndexName(paramString);
      this.uniqueIndexName = str;
    }
    return this.uniqueIndexName;
  }

  public Enum<?> getUnknownEnumValue()
  {
    return this.unknownEnumValue;
  }

  @Deprecated
  public Enum<?> getUnknownEnumvalue()
  {
    return this.unknownEnumValue;
  }

  public int getWidth()
  {
    return this.width;
  }

  public boolean isAllowGeneratedIdInsert()
  {
    return this.allowGeneratedIdInsert;
  }

  public boolean isCanBeNull()
  {
    return this.canBeNull;
  }

  public boolean isForeign()
  {
    return this.foreign;
  }

  public boolean isForeignAutoCreate()
  {
    return this.foreignAutoCreate;
  }

  public boolean isForeignAutoRefresh()
  {
    return this.foreignAutoRefresh;
  }

  public boolean isForeignCollection()
  {
    return this.foreignCollection;
  }

  public boolean isForeignCollectionEager()
  {
    return this.foreignCollectionEager;
  }

  public boolean isGeneratedId()
  {
    return this.generatedId;
  }

  public boolean isId()
  {
    return this.id;
  }

  public boolean isIndex()
  {
    return this.index;
  }

  public boolean isPersisted()
  {
    return this.persisted;
  }

  public boolean isThrowIfNull()
  {
    return this.throwIfNull;
  }

  public boolean isUnique()
  {
    return this.unique;
  }

  public boolean isUniqueCombo()
  {
    return this.uniqueCombo;
  }

  public boolean isUniqueIndex()
  {
    return this.uniqueIndex;
  }

  public boolean isUseGetSet()
  {
    return this.useGetSet;
  }

  public boolean isVersion()
  {
    return this.version;
  }

  public void setAllowGeneratedIdInsert(boolean paramBoolean)
  {
    this.allowGeneratedIdInsert = paramBoolean;
  }

  public void setCanBeNull(boolean paramBoolean)
  {
    this.canBeNull = paramBoolean;
  }

  public void setColumnDefinition(String paramString)
  {
    this.columnDefinition = paramString;
  }

  public void setColumnName(String paramString)
  {
    this.columnName = paramString;
  }

  public void setDataPersister(DataPersister paramDataPersister)
  {
    this.dataPersister = paramDataPersister;
  }

  public void setDataType(DataType paramDataType)
  {
    this.dataType = paramDataType;
  }

  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }

  public void setFieldName(String paramString)
  {
    this.fieldName = paramString;
  }

  public void setForeign(boolean paramBoolean)
  {
    this.foreign = paramBoolean;
  }

  public void setForeignAutoCreate(boolean paramBoolean)
  {
    this.foreignAutoCreate = paramBoolean;
  }

  public void setForeignAutoRefresh(boolean paramBoolean)
  {
    this.foreignAutoRefresh = paramBoolean;
  }

  public void setForeignCollection(boolean paramBoolean)
  {
    this.foreignCollection = paramBoolean;
  }

  public void setForeignCollectionColumnName(String paramString)
  {
    this.foreignCollectionColumnName = paramString;
  }

  public void setForeignCollectionEager(boolean paramBoolean)
  {
    this.foreignCollectionEager = paramBoolean;
  }

  @Deprecated
  public void setForeignCollectionForeignColumnName(String paramString)
  {
    this.foreignCollectionForeignFieldName = paramString;
  }

  public void setForeignCollectionForeignFieldName(String paramString)
  {
    this.foreignCollectionForeignFieldName = paramString;
  }

  @Deprecated
  public void setForeignCollectionMaxEagerForeignCollectionLevel(int paramInt)
  {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }

  public void setForeignCollectionMaxEagerLevel(int paramInt)
  {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }

  @Deprecated
  public void setForeignCollectionOrderColumn(String paramString)
  {
    this.foreignCollectionOrderColumnName = paramString;
  }

  public void setForeignCollectionOrderColumnName(String paramString)
  {
    this.foreignCollectionOrderColumnName = paramString;
  }

  public void setForeignColumnName(String paramString)
  {
    this.foreignColumnName = paramString;
  }

  public void setForeignTableConfig(DatabaseTableConfig<?> paramDatabaseTableConfig)
  {
    this.foreignTableConfig = paramDatabaseTableConfig;
  }

  public void setFormat(String paramString)
  {
    this.format = paramString;
  }

  public void setGeneratedId(boolean paramBoolean)
  {
    this.generatedId = paramBoolean;
  }

  public void setGeneratedIdSequence(String paramString)
  {
    this.generatedIdSequence = paramString;
  }

  public void setId(boolean paramBoolean)
  {
    this.id = paramBoolean;
  }

  public void setIndex(boolean paramBoolean)
  {
    this.index = paramBoolean;
  }

  public void setIndexName(String paramString)
  {
    this.indexName = paramString;
  }

  @Deprecated
  public void setMaxEagerForeignCollectionLevel(int paramInt)
  {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }

  public void setMaxForeignAutoRefreshLevel(int paramInt)
  {
    this.maxForeignAutoRefreshLevel = paramInt;
  }

  public void setPersisted(boolean paramBoolean)
  {
    this.persisted = paramBoolean;
  }

  public void setPersisterClass(Class<? extends DataPersister> paramClass)
  {
    this.persisterClass = paramClass;
  }

  public void setThrowIfNull(boolean paramBoolean)
  {
    this.throwIfNull = paramBoolean;
  }

  public void setUnique(boolean paramBoolean)
  {
    this.unique = paramBoolean;
  }

  public void setUniqueCombo(boolean paramBoolean)
  {
    this.uniqueCombo = paramBoolean;
  }

  public void setUniqueIndex(boolean paramBoolean)
  {
    this.uniqueIndex = paramBoolean;
  }

  public void setUniqueIndexName(String paramString)
  {
    this.uniqueIndexName = paramString;
  }

  public void setUnknownEnumValue(Enum<?> paramEnum)
  {
    this.unknownEnumValue = paramEnum;
  }

  public void setUseGetSet(boolean paramBoolean)
  {
    this.useGetSet = paramBoolean;
  }

  public void setVersion(boolean paramBoolean)
  {
    this.version = paramBoolean;
  }

  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.DatabaseFieldConfig
 * JD-Core Version:    0.6.2
 */