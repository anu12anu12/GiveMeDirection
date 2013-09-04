package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

public class NullArgHolder
  implements ArgumentHolder
{
  public String getColumnName()
  {
    return "null-holder";
  }

  public FieldType getFieldType()
  {
    return null;
  }

  public Object getSqlArgValue()
  {
    return null;
  }

  public SqlType getSqlType()
  {
    return SqlType.STRING;
  }

  public void setMetaInfo(FieldType paramFieldType)
  {
  }

  public void setMetaInfo(String paramString)
  {
  }

  public void setMetaInfo(String paramString, FieldType paramFieldType)
  {
  }

  public void setValue(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Cannot set null on ");
    Class localClass = getClass();
    String str = localClass;
    throw new UnsupportedOperationException(str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.NullArgHolder
 * JD-Core Version:    0.6.2
 */