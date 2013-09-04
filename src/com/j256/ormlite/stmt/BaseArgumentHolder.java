package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract class BaseArgumentHolder
  implements ArgumentHolder
{
  private String columnName = null;
  private FieldType fieldType = null;
  private SqlType sqlType = null;

  public BaseArgumentHolder()
  {
  }

  public BaseArgumentHolder(SqlType paramSqlType)
  {
    this.sqlType = paramSqlType;
  }

  public BaseArgumentHolder(String paramString)
  {
    this.columnName = paramString;
  }

  public String getColumnName()
  {
    return this.columnName;
  }

  public FieldType getFieldType()
  {
    return this.fieldType;
  }

  public Object getSqlArgValue()
    throws SQLException
  {
    if (!isValueSet())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Column value has not been set for ");
      String str1 = this.columnName;
      String str2 = str1;
      throw new SQLException(str2);
    }
    Object localObject = getValue();
    if (localObject == null)
      localObject = null;
    while (true)
    {
      return localObject;
      if (this.fieldType != null)
        if (this.fieldType.isForeign())
        {
          Class localClass1 = this.fieldType.getType();
          Class localClass2 = localObject.getClass();
          if (localClass1 == localClass2)
            localObject = this.fieldType.getForeignIdField().extractJavaFieldValue(localObject);
        }
        else
        {
          localObject = this.fieldType.convertJavaFieldToSqlArgValue(localObject);
        }
    }
  }

  public SqlType getSqlType()
  {
    return this.sqlType;
  }

  protected abstract Object getValue();

  protected abstract boolean isValueSet();

  public void setMetaInfo(FieldType paramFieldType)
  {
    if (this.fieldType == null);
    while (this.fieldType == paramFieldType)
    {
      this.fieldType = paramFieldType;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("FieldType name cannot be set twice from ");
    FieldType localFieldType = this.fieldType;
    String str = localFieldType + " to " + paramFieldType + ".  Using a SelectArg twice in query with different columns?";
    throw new IllegalArgumentException(str);
  }

  public void setMetaInfo(String paramString)
  {
    if (this.columnName == null);
    while (this.columnName.equals(paramString))
    {
      this.columnName = paramString;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Column name cannot be set twice from ");
    String str1 = this.columnName;
    String str2 = str1 + " to " + paramString + ".  Using a SelectArg twice in query with different columns?";
    throw new IllegalArgumentException(str2);
  }

  public void setMetaInfo(String paramString, FieldType paramFieldType)
  {
    setMetaInfo(paramString);
    setMetaInfo(paramFieldType);
  }

  public abstract void setValue(Object paramObject);

  public String toString()
  {
    Object localObject1;
    if (!isValueSet())
      localObject1 = "[unset]";
    while (true)
    {
      return localObject1;
      try
      {
        Object localObject2 = getSqlArgValue();
        if (localObject2 == null)
        {
          localObject1 = "[null]";
        }
        else
        {
          String str = localObject2.toString();
          localObject1 = str;
        }
      }
      catch (SQLException localSQLException)
      {
        localObject1 = "[could not get value: " + localSQLException + "]";
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.BaseArgumentHolder
 * JD-Core Version:    0.6.2
 */