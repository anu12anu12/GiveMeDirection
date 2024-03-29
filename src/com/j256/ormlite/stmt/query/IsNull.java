package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class IsNull extends BaseComparison
{
  public IsNull(String paramString, FieldType paramFieldType)
    throws SQLException
  {
    super(paramString, paramFieldType, null, true);
  }

  public void appendOperation(StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("IS NULL ");
  }

  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.IsNull
 * JD-Core Version:    0.6.2
 */