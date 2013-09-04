package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseTableConfigLoader
{
  private static final String CONFIG_FILE_END_MARKER = "# --table-end--";
  private static final String CONFIG_FILE_FIELDS_END = "# --table-fields-end--";
  private static final String CONFIG_FILE_FIELDS_START = "# --table-fields-start--";
  private static final String CONFIG_FILE_START_MARKER = "# --table-start--";
  private static final String FIELD_NAME_DATA_CLASS = "dataClass";
  private static final String FIELD_NAME_TABLE_NAME = "tableName";

  public static <T> DatabaseTableConfig<T> fromReader(BufferedReader paramBufferedReader)
    throws SQLException
  {
    DatabaseTableConfig localDatabaseTableConfig = new DatabaseTableConfig();
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
            break label170;
          return localDatabaseTableConfig;
        }
      }
      catch (IOException localIOException)
      {
        throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", localIOException);
      }
      if (!str2.equals("# --table-end--"))
        if (str2.equals("# --table-fields-start--"))
        {
          readFields(paramBufferedReader, localDatabaseTableConfig);
        }
        else if ((str2.length() != 0) && (!str2.startsWith("#")) && (!str2.equals("# --table-start--")))
        {
          String[] arrayOfString = str2.split("=", -1);
          if (arrayOfString.length != 2)
          {
            String str3 = "DatabaseTableConfig reading from stream cannot parse line: " + str2;
            throw new SQLException(str3);
          }
          String str4 = arrayOfString[0];
          String str5 = arrayOfString[1];
          readTableField(localDatabaseTableConfig, str4, str5);
          i = 1;
          continue;
          label170: localDatabaseTableConfig = null;
        }
    }
  }

  public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader paramBufferedReader)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      DatabaseTableConfig localDatabaseTableConfig = fromReader(paramBufferedReader);
      if (localDatabaseTableConfig == null)
        return localArrayList;
      boolean bool = localArrayList.add(localDatabaseTableConfig);
    }
  }

  private static <T> void readFields(BufferedReader paramBufferedReader, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      try
      {
        String str1 = paramBufferedReader.readLine();
        String str2 = str1;
        if ((str2 == null) || (str2.equals("# --table-fields-end--")))
        {
          paramDatabaseTableConfig.setFieldConfigs(localArrayList);
          return;
        }
      }
      catch (IOException localIOException)
      {
        throw SqlExceptionUtil.create("Could not read next field from config file", localIOException);
      }
      DatabaseFieldConfig localDatabaseFieldConfig = DatabaseFieldConfigLoader.fromReader(paramBufferedReader);
      if (localDatabaseFieldConfig != null)
        boolean bool = localArrayList.add(localDatabaseFieldConfig);
    }
  }

  private static <T> void readTableField(DatabaseTableConfig<T> paramDatabaseTableConfig, String paramString1, String paramString2)
  {
    if (paramString1.equals("dataClass"))
      try
      {
        Class localClass = Class.forName(paramString2);
        paramDatabaseTableConfig.setDataClass(localClass);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        String str = "Unknown class specified for dataClass: " + paramString2;
        throw new IllegalArgumentException(str);
      }
    if (!paramString1.equals("tableName"))
      return;
    paramDatabaseTableConfig.setTableName(paramString2);
  }

  public static <T> void write(BufferedWriter paramBufferedWriter, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    try
    {
      writeConfig(paramBufferedWriter, paramDatabaseTableConfig);
      return;
    }
    catch (IOException localIOException)
    {
      throw SqlExceptionUtil.create("Could not write config to writer", localIOException);
    }
  }

  private static <T> void writeConfig(BufferedWriter paramBufferedWriter, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws IOException, SQLException
  {
    Writer localWriter1 = paramBufferedWriter.append("# --table-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseTableConfig.getDataClass() != null)
    {
      Writer localWriter2 = paramBufferedWriter.append("dataClass").append('=');
      String str1 = paramDatabaseTableConfig.getDataClass().getName();
      Writer localWriter3 = localWriter2.append(str1);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseTableConfig.getTableName() != null)
    {
      Writer localWriter4 = paramBufferedWriter.append("tableName").append('=');
      String str2 = paramDatabaseTableConfig.getTableName();
      Writer localWriter5 = localWriter4.append(str2);
      paramBufferedWriter.newLine();
    }
    Writer localWriter6 = paramBufferedWriter.append("# --table-fields-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseTableConfig.getFieldConfigs() != null)
    {
      Iterator localIterator = paramDatabaseTableConfig.getFieldConfigs().iterator();
      while (localIterator.hasNext())
      {
        DatabaseFieldConfig localDatabaseFieldConfig = (DatabaseFieldConfig)localIterator.next();
        String str3 = paramDatabaseTableConfig.getTableName();
        DatabaseFieldConfigLoader.write(paramBufferedWriter, localDatabaseFieldConfig, str3);
      }
    }
    Writer localWriter7 = paramBufferedWriter.append("# --table-fields-end--");
    paramBufferedWriter.newLine();
    Writer localWriter8 = paramBufferedWriter.append("# --table-end--");
    paramBufferedWriter.newLine();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.table.DatabaseTableConfigLoader
 * JD-Core Version:    0.6.2
 */