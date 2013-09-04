package com.j256.ormlite.field;

import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

public class DatabaseFieldConfigLoader
{
  private static final String CONFIG_FILE_END_MARKER = "# --field-end--";
  private static final String CONFIG_FILE_START_MARKER = "# --field-start--";
  private static final boolean DEFAULT_CAN_BE_NULL = true;
  private static final DataPersister DEFAULT_DATA_PERSISTER = DataType.UNKNOWN.getDataPersister();
  private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
  private static final int DEFAULT_MAX_FOREIGN_AUTO_REFRESH_LEVEL = 2;
  private static final Class<? extends DataPersister> DEFAULT_PERSISTER_CLASS = VoidType.class;
  private static final String FIELD_NAME_ALLOW_GENERATED_ID_INSERT = "allowGeneratedIdInsert";
  private static final String FIELD_NAME_CAN_BE_NULL = "canBeNull";
  private static final String FIELD_NAME_COLUMN_DEFINITION = "columnDefinition";
  private static final String FIELD_NAME_COLUMN_NAME = "columnName";
  private static final String FIELD_NAME_DATA_PERSISTER = "dataPersister";
  private static final String FIELD_NAME_DEFAULT_VALUE = "defaultValue";
  private static final String FIELD_NAME_FIELD_NAME = "fieldName";
  private static final String FIELD_NAME_FOREIGN = "foreign";
  private static final String FIELD_NAME_FOREIGN_AUTO_CREATE = "foreignAutoCreate";
  private static final String FIELD_NAME_FOREIGN_AUTO_REFRESH = "foreignAutoRefresh";
  private static final String FIELD_NAME_FOREIGN_COLLECTION = "foreignCollection";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME = "foreignCollectionColumnName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_EAGER = "foreignCollectionEager";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME = "foreignCollectionForeignFieldName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME_OLD = "foreignCollectionForeignColumnName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME = "foreignCollectionOrderColumnName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME_OLD = "foreignCollectionOrderColumn";
  private static final String FIELD_NAME_FORMAT = "format";
  private static final String FIELD_NAME_GENERATED_ID = "generatedId";
  private static final String FIELD_NAME_GENERATED_ID_SEQUENCE = "generatedIdSequence";
  private static final String FIELD_NAME_ID = "id";
  private static final String FIELD_NAME_INDEX = "index";
  private static final String FIELD_NAME_INDEX_NAME = "indexName";
  private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = "foreignCollectionMaxEagerLevel";
  private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL_OLD = "maxEagerForeignCollectionLevel";
  private static final String FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL = "maxForeignAutoRefreshLevel";
  private static final String FIELD_NAME_PERSISTER_CLASS = "persisterClass";
  private static final String FIELD_NAME_THROW_IF_NULL = "throwIfNull";
  private static final String FIELD_NAME_UNIQUE = "unique";
  private static final String FIELD_NAME_UNIQUE_COMBO = "uniqueCombo";
  private static final String FIELD_NAME_UNIQUE_INDEX = "uniqueIndex";
  private static final String FIELD_NAME_UNIQUE_INDEX_NAME = "uniqueIndexName";
  private static final String FIELD_NAME_UNKNOWN_ENUM_VALUE = "unknownEnumValue";
  private static final String FIELD_NAME_USE_GET_SET = "useGetSet";
  private static final String FIELD_NAME_VERSION = "version";
  private static final String FIELD_NAME_WIDTH = "width";
  private static final String FOREIGN_COLUMN_NAME = "foreignColumnName";

  public static DatabaseFieldConfig fromReader(BufferedReader paramBufferedReader)
    throws SQLException
  {
    DatabaseFieldConfig localDatabaseFieldConfig = new DatabaseFieldConfig();
    int i = 0;
    while (true)
    {
      String str2;
      try
      {
        String str1 = paramBufferedReader.readLine();
        str2 = str1;
        if (str2 == null)
        {
          if (i == 0)
            break label152;
          return localDatabaseFieldConfig;
        }
      }
      catch (IOException localIOException)
      {
        throw SqlExceptionUtil.create("Could not read DatabaseFieldConfig from stream", localIOException);
      }
      if (!str2.equals("# --field-end--"))
        if ((str2.length() != 0) && (!str2.startsWith("#")) && (!str2.equals("# --field-start--")))
        {
          String[] arrayOfString = str2.split("=", -1);
          if (arrayOfString.length != 2)
          {
            String str3 = "DatabaseFieldConfig reading from stream cannot parse line: " + str2;
            throw new SQLException(str3);
          }
          String str4 = arrayOfString[0];
          String str5 = arrayOfString[1];
          readField(localDatabaseFieldConfig, str4, str5);
          i = 1;
          continue;
          label152: localDatabaseFieldConfig = null;
        }
    }
  }

  private static void readField(DatabaseFieldConfig paramDatabaseFieldConfig, String paramString1, String paramString2)
  {
    if (paramString1.equals("fieldName"))
    {
      String str1 = paramString2;
      paramDatabaseFieldConfig.setFieldName(str1);
      return;
    }
    if (paramString1.equals("columnName"))
    {
      String str2 = paramString2;
      paramDatabaseFieldConfig.setColumnName(str2);
      return;
    }
    if (paramString1.equals("dataPersister"))
    {
      DataPersister localDataPersister = DataType.valueOf(paramString2).getDataPersister();
      paramDatabaseFieldConfig.setDataPersister(localDataPersister);
      return;
    }
    if (paramString1.equals("defaultValue"))
    {
      String str3 = paramString2;
      paramDatabaseFieldConfig.setDefaultValue(str3);
      return;
    }
    if (paramString1.equals("width"))
    {
      int i = Integer.parseInt(paramString2);
      paramDatabaseFieldConfig.setWidth(i);
      return;
    }
    if (paramString1.equals("canBeNull"))
    {
      boolean bool1 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setCanBeNull(bool1);
      return;
    }
    if (paramString1.equals("id"))
    {
      boolean bool2 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setId(bool2);
      return;
    }
    if (paramString1.equals("generatedId"))
    {
      boolean bool3 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setGeneratedId(bool3);
      return;
    }
    if (paramString1.equals("generatedIdSequence"))
    {
      String str4 = paramString2;
      paramDatabaseFieldConfig.setGeneratedIdSequence(str4);
      return;
    }
    if (paramString1.equals("foreign"))
    {
      boolean bool4 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setForeign(bool4);
      return;
    }
    if (paramString1.equals("useGetSet"))
    {
      boolean bool5 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setUseGetSet(bool5);
      return;
    }
    if (paramString1.equals("unknownEnumValue"))
    {
      String[] arrayOfString = paramString2.split("#", -1);
      if (arrayOfString.length != 2)
      {
        StringBuilder localStringBuilder1 = new StringBuilder().append("Invalid value for unknownEnumValue which should be in class#name format: ");
        String str5 = paramString2;
        String str6 = str5;
        throw new IllegalArgumentException(str6);
      }
      int j = 0;
      Object[] arrayOfObject;
      try
      {
        Class localClass1 = Class.forName(arrayOfString[j]);
        arrayOfObject = localClass1.getEnumConstants();
        if (arrayOfObject == null)
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("Invalid class is not an Enum for unknownEnumValue: ");
          String str7 = paramString2;
          String str8 = str7;
          throw new IllegalArgumentException(str8);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        StringBuilder localStringBuilder3 = new StringBuilder().append("Unknown class specified for unknownEnumValue: ");
        String str9 = paramString2;
        String str10 = str9;
        throw new IllegalArgumentException(str10);
      }
      Enum[] arrayOfEnum1 = (Enum[])arrayOfObject;
      int k = 0;
      Enum[] arrayOfEnum2 = arrayOfEnum1;
      int m = arrayOfEnum2.length;
      int n = 0;
      while (n < m)
      {
        Enum localEnum = arrayOfEnum2[n];
        String str11 = localEnum.name();
        String str12 = arrayOfString[1];
        if (str11.equals(str12))
        {
          paramDatabaseFieldConfig.setUnknownEnumValue(localEnum);
          k = 1;
        }
        n += 1;
      }
      if (k != 0)
        return;
      StringBuilder localStringBuilder4 = new StringBuilder().append("Invalid enum value name for unknownEnumvalue: ");
      String str13 = paramString2;
      String str14 = str13;
      throw new IllegalArgumentException(str14);
    }
    if (paramString1.equals("throwIfNull"))
    {
      boolean bool6 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setThrowIfNull(bool6);
      return;
    }
    if (paramString1.equals("format"))
    {
      String str15 = paramString2;
      paramDatabaseFieldConfig.setFormat(str15);
      return;
    }
    if (paramString1.equals("unique"))
    {
      boolean bool7 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setUnique(bool7);
      return;
    }
    if (paramString1.equals("uniqueCombo"))
    {
      boolean bool8 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setUniqueCombo(bool8);
      return;
    }
    if (paramString1.equals("index"))
    {
      boolean bool9 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setIndex(bool9);
      return;
    }
    if (paramString1.equals("indexName"))
    {
      paramDatabaseFieldConfig.setIndex(true);
      String str16 = paramString2;
      paramDatabaseFieldConfig.setIndexName(str16);
      return;
    }
    if (paramString1.equals("uniqueIndex"))
    {
      boolean bool10 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setUniqueIndex(bool10);
      return;
    }
    if (paramString1.equals("uniqueIndexName"))
    {
      paramDatabaseFieldConfig.setUniqueIndex(true);
      String str17 = paramString2;
      paramDatabaseFieldConfig.setUniqueIndexName(str17);
      return;
    }
    if (paramString1.equals("foreignAutoRefresh"))
    {
      boolean bool11 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setForeignAutoRefresh(bool11);
      return;
    }
    if (paramString1.equals("maxForeignAutoRefreshLevel"))
    {
      int i1 = Integer.parseInt(paramString2);
      paramDatabaseFieldConfig.setMaxForeignAutoRefreshLevel(i1);
      return;
    }
    if (paramString1.equals("persisterClass"))
      try
      {
        Class localClass2 = Class.forName(paramString2);
        paramDatabaseFieldConfig.setPersisterClass(localClass2);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        StringBuilder localStringBuilder5 = new StringBuilder().append("Could not find persisterClass: ");
        String str18 = paramString2;
        String str19 = str18;
        throw new IllegalArgumentException(str19);
      }
    if (paramString1.equals("allowGeneratedIdInsert"))
    {
      boolean bool12 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setAllowGeneratedIdInsert(bool12);
      return;
    }
    if (paramString1.equals("columnDefinition"))
    {
      String str20 = paramString2;
      paramDatabaseFieldConfig.setColumnDefinition(str20);
      return;
    }
    if (paramString1.equals("foreignAutoCreate"))
    {
      boolean bool13 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setForeignAutoCreate(bool13);
      return;
    }
    if (paramString1.equals("version"))
    {
      boolean bool14 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setVersion(bool14);
      return;
    }
    if (paramString1.equals("foreignColumnName"))
    {
      String str21 = paramString2;
      paramDatabaseFieldConfig.setForeignColumnName(str21);
      return;
    }
    if (paramString1.equals("foreignCollection"))
    {
      boolean bool15 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setForeignCollection(bool15);
      return;
    }
    if (paramString1.equals("foreignCollectionEager"))
    {
      boolean bool16 = Boolean.parseBoolean(paramString2);
      paramDatabaseFieldConfig.setForeignCollectionEager(bool16);
      return;
    }
    if (paramString1.equals("maxEagerForeignCollectionLevel"))
    {
      int i2 = Integer.parseInt(paramString2);
      paramDatabaseFieldConfig.setForeignCollectionMaxEagerLevel(i2);
      return;
    }
    if (paramString1.equals("foreignCollectionMaxEagerLevel"))
    {
      int i3 = Integer.parseInt(paramString2);
      paramDatabaseFieldConfig.setForeignCollectionMaxEagerLevel(i3);
      return;
    }
    if (paramString1.equals("foreignCollectionColumnName"))
    {
      String str22 = paramString2;
      paramDatabaseFieldConfig.setForeignCollectionColumnName(str22);
      return;
    }
    if (paramString1.equals("foreignCollectionOrderColumn"))
    {
      String str23 = paramString2;
      paramDatabaseFieldConfig.setForeignCollectionOrderColumnName(str23);
      return;
    }
    if (paramString1.equals("foreignCollectionOrderColumnName"))
    {
      String str24 = paramString2;
      paramDatabaseFieldConfig.setForeignCollectionOrderColumnName(str24);
      return;
    }
    if (paramString1.equals("foreignCollectionForeignColumnName"))
    {
      String str25 = paramString2;
      paramDatabaseFieldConfig.setForeignCollectionForeignFieldName(str25);
      return;
    }
    if (!paramString1.equals("foreignCollectionForeignFieldName"))
      return;
    String str26 = paramString2;
    paramDatabaseFieldConfig.setForeignCollectionForeignFieldName(str26);
  }

  public static void write(BufferedWriter paramBufferedWriter, DatabaseFieldConfig paramDatabaseFieldConfig, String paramString)
    throws SQLException
  {
    try
    {
      writeConfig(paramBufferedWriter, paramDatabaseFieldConfig, paramString);
      return;
    }
    catch (IOException localIOException)
    {
      throw SqlExceptionUtil.create("Could not write config to writer", localIOException);
    }
  }

  public static void writeConfig(BufferedWriter paramBufferedWriter, DatabaseFieldConfig paramDatabaseFieldConfig, String paramString)
    throws IOException
  {
    Writer localWriter1 = paramBufferedWriter.append("# --field-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseFieldConfig.getFieldName() != null)
    {
      Writer localWriter2 = paramBufferedWriter.append("fieldName").append('=');
      String str1 = paramDatabaseFieldConfig.getFieldName();
      Writer localWriter3 = localWriter2.append(str1);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getColumnName() != null)
    {
      Writer localWriter4 = paramBufferedWriter.append("columnName").append('=');
      String str2 = paramDatabaseFieldConfig.getColumnName();
      Writer localWriter5 = localWriter4.append(str2);
      paramBufferedWriter.newLine();
    }
    DataPersister localDataPersister1 = paramDatabaseFieldConfig.getDataPersister();
    DataPersister localDataPersister2 = DEFAULT_DATA_PERSISTER;
    if (localDataPersister1 != localDataPersister2)
    {
      int i = 0;
      DataType[] arrayOfDataType = DataType.values();
      int j = arrayOfDataType.length;
      int k = 0;
      while (true)
      {
        if (k < j)
        {
          DataType localDataType = arrayOfDataType[k];
          DataPersister localDataPersister3 = localDataType.getDataPersister();
          DataPersister localDataPersister4 = paramDatabaseFieldConfig.getDataPersister();
          if (localDataPersister3 == localDataPersister4)
          {
            Writer localWriter6 = paramBufferedWriter.append("dataPersister").append('=');
            String str3 = localDataType.name();
            Writer localWriter7 = localWriter6.append(str3);
            paramBufferedWriter.newLine();
            i = 1;
          }
        }
        else
        {
          if (i != 0)
            break;
          StringBuilder localStringBuilder = new StringBuilder().append("Unknown data persister field: ");
          DataPersister localDataPersister5 = paramDatabaseFieldConfig.getDataPersister();
          String str4 = localDataPersister5;
          throw new IllegalArgumentException(str4);
        }
        k += 1;
      }
    }
    if (paramDatabaseFieldConfig.getDefaultValue() != null)
    {
      Writer localWriter8 = paramBufferedWriter.append("defaultValue").append('=');
      String str5 = paramDatabaseFieldConfig.getDefaultValue();
      Writer localWriter9 = localWriter8.append(str5);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getWidth() != 0)
    {
      Writer localWriter10 = paramBufferedWriter.append("width").append('=');
      String str6 = Integer.toString(paramDatabaseFieldConfig.getWidth());
      Writer localWriter11 = localWriter10.append(str6);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isCanBeNull() != true)
    {
      Writer localWriter12 = paramBufferedWriter.append("canBeNull").append('=');
      String str7 = Boolean.toString(paramDatabaseFieldConfig.isCanBeNull());
      Writer localWriter13 = localWriter12.append(str7);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isId())
    {
      Writer localWriter14 = paramBufferedWriter.append("id").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isGeneratedId())
    {
      Writer localWriter15 = paramBufferedWriter.append("generatedId").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getGeneratedIdSequence() != null)
    {
      Writer localWriter16 = paramBufferedWriter.append("generatedIdSequence").append('=');
      String str8 = paramDatabaseFieldConfig.getGeneratedIdSequence();
      Writer localWriter17 = localWriter16.append(str8);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeign())
    {
      Writer localWriter18 = paramBufferedWriter.append("foreign").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isUseGetSet())
    {
      Writer localWriter19 = paramBufferedWriter.append("useGetSet").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getUnknownEnumValue() != null)
    {
      Writer localWriter20 = paramBufferedWriter.append("unknownEnumValue").append('=');
      String str9 = paramDatabaseFieldConfig.getUnknownEnumValue().getClass().getName();
      Writer localWriter21 = localWriter20.append(str9).append("#");
      String str10 = paramDatabaseFieldConfig.getUnknownEnumValue().name();
      Writer localWriter22 = localWriter21.append(str10);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isThrowIfNull())
    {
      Writer localWriter23 = paramBufferedWriter.append("throwIfNull").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getFormat() != null)
    {
      Writer localWriter24 = paramBufferedWriter.append("format").append('=');
      String str11 = paramDatabaseFieldConfig.getFormat();
      Writer localWriter25 = localWriter24.append(str11);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isUnique())
    {
      Writer localWriter26 = paramBufferedWriter.append("unique").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isUniqueCombo())
    {
      Writer localWriter27 = paramBufferedWriter.append("uniqueCombo").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    String str12 = paramDatabaseFieldConfig.getIndexName(paramString);
    if (str12 != null)
    {
      Writer localWriter28 = paramBufferedWriter.append("indexName").append('=').append(str12);
      paramBufferedWriter.newLine();
    }
    String str13 = paramDatabaseFieldConfig.getUniqueIndexName(paramString);
    if (str13 != null)
    {
      Writer localWriter29 = paramBufferedWriter.append("uniqueIndexName").append('=').append(str13);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignAutoRefresh())
    {
      Writer localWriter30 = paramBufferedWriter.append("foreignAutoRefresh").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel() != 2)
    {
      Writer localWriter31 = paramBufferedWriter.append("maxForeignAutoRefreshLevel").append('=');
      String str14 = Integer.toString(paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel());
      Writer localWriter32 = localWriter31.append(str14);
      paramBufferedWriter.newLine();
    }
    Class localClass1 = paramDatabaseFieldConfig.getPersisterClass();
    Class localClass2 = DEFAULT_PERSISTER_CLASS;
    if (localClass1 != localClass2)
    {
      Writer localWriter33 = paramBufferedWriter.append("persisterClass").append('=');
      String str15 = paramDatabaseFieldConfig.getPersisterClass().getName();
      Writer localWriter34 = localWriter33.append(str15);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isAllowGeneratedIdInsert())
    {
      Writer localWriter35 = paramBufferedWriter.append("allowGeneratedIdInsert").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getColumnDefinition() != null)
    {
      Writer localWriter36 = paramBufferedWriter.append("columnDefinition").append('=');
      String str16 = paramDatabaseFieldConfig.getColumnDefinition();
      Writer localWriter37 = localWriter36.append(str16);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignAutoCreate())
    {
      Writer localWriter38 = paramBufferedWriter.append("foreignAutoCreate").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isVersion())
    {
      Writer localWriter39 = paramBufferedWriter.append("version").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    String str17 = paramDatabaseFieldConfig.getForeignColumnName();
    if (str17 != null)
    {
      Writer localWriter40 = paramBufferedWriter.append("foreignColumnName").append('=').append(str17);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignCollection())
    {
      Writer localWriter41 = paramBufferedWriter.append("foreignCollection").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignCollectionEager())
    {
      Writer localWriter42 = paramBufferedWriter.append("foreignCollectionEager").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionMaxEagerLevel() != 1)
    {
      Writer localWriter43 = paramBufferedWriter.append("foreignCollectionMaxEagerLevel").append('=');
      String str18 = Integer.toString(paramDatabaseFieldConfig.getForeignCollectionMaxEagerLevel());
      Writer localWriter44 = localWriter43.append(str18);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionColumnName() != null)
    {
      Writer localWriter45 = paramBufferedWriter.append("foreignCollectionColumnName").append('=');
      String str19 = paramDatabaseFieldConfig.getForeignCollectionColumnName();
      Writer localWriter46 = localWriter45.append(str19);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionOrderColumnName() != null)
    {
      Writer localWriter47 = paramBufferedWriter.append("foreignCollectionOrderColumnName").append('=');
      String str20 = paramDatabaseFieldConfig.getForeignCollectionOrderColumnName();
      Writer localWriter48 = localWriter47.append(str20);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionForeignFieldName() != null)
    {
      Writer localWriter49 = paramBufferedWriter.append("foreignCollectionForeignFieldName").append('=');
      String str21 = paramDatabaseFieldConfig.getForeignCollectionForeignFieldName();
      Writer localWriter50 = localWriter49.append(str21);
      paramBufferedWriter.newLine();
    }
    Writer localWriter51 = paramBufferedWriter.append("# --field-end--");
    paramBufferedWriter.newLine();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.DatabaseFieldConfigLoader
 * JD-Core Version:    0.6.2
 */