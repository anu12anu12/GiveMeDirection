package com.j256.ormlite.db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType
  implements DatabaseType
{
  protected void appendBooleanType(StringBuilder paramStringBuilder, int paramInt)
  {
    appendShortType(paramStringBuilder, paramInt);
  }

  protected void appendDateType(StringBuilder paramStringBuilder, int paramInt)
  {
    appendStringType(paramStringBuilder, paramInt);
  }

  public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return DatabaseTableConfigUtil.fromClass(paramConnectionSource, paramClass);
  }

  public String getDatabaseName()
  {
    return "Android SQLite";
  }

  protected String getDriverClassName()
  {
    return null;
  }

  public FieldConverter getFieldConverter(DataPersister paramDataPersister)
  {
    int[] arrayOfInt = 1.$SwitchMap$com$j256$ormlite$field$SqlType;
    int i = paramDataPersister.getSqlType().ordinal();
    switch (arrayOfInt[i])
    {
    default:
    case 1:
    }
    for (Object localObject = super.getFieldConverter(paramDataPersister); ; localObject = DateStringType.getSingleton())
      return localObject;
  }

  public boolean isBatchUseTransaction()
  {
    return true;
  }

  public boolean isDatabaseUrlThisType(String paramString1, String paramString2)
  {
    return true;
  }

  public boolean isNestedSavePointsSupported()
  {
    return false;
  }

  public void loadDriver()
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.db.SqliteAndroidDatabaseType
 * JD-Core Version:    0.6.2
 */