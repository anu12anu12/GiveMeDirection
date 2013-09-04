package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class SetExpression extends BaseComparison
{
  public SetExpression(String paramString1, FieldType paramFieldType, String paramString2)
    throws SQLException
  {
    super(paramString1, paramFieldType, paramString2, true);
  }

  protected void appendArgOrValue(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, Object paramObject)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append(paramObject).append(' ');
  }

  public void appendOperation(StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("= ");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.SetExpression
 * JD-Core Version:    0.6.2
 */