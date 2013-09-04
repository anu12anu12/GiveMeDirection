package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.NullArgHolder;
import java.sql.SQLException;

public class SetValue extends BaseComparison
{
  private static final ArgumentHolder nullValue = new NullArgHolder();

  public SetValue(String paramString, FieldType paramFieldType, Object paramObject)
    throws SQLException
  {
    super(paramString, paramFieldType, paramObject, false);
  }

  public void appendOperation(StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("= ");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.SetValue
 * JD-Core Version:    0.6.2
 */