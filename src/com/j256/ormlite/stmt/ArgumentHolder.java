package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract interface ArgumentHolder
{
  public abstract String getColumnName();

  public abstract FieldType getFieldType();

  public abstract Object getSqlArgValue()
    throws SQLException;

  public abstract SqlType getSqlType();

  public abstract void setMetaInfo(FieldType paramFieldType);

  public abstract void setMetaInfo(String paramString);

  public abstract void setMetaInfo(String paramString, FieldType paramFieldType);

  public abstract void setValue(Object paramObject);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.ArgumentHolder
 * JD-Core Version:    0.6.2
 */