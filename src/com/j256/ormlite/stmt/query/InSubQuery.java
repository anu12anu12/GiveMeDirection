package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder.InternalQueryBuilderWrapper;
import java.sql.SQLException;
import java.util.List;

public class InSubQuery extends BaseComparison
{
  private final boolean in;
  private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;

  public InSubQuery(String paramString, FieldType paramFieldType, QueryBuilder.InternalQueryBuilderWrapper paramInternalQueryBuilderWrapper, boolean paramBoolean)
    throws SQLException
  {
    super(paramString, paramFieldType, null, true);
    this.subQueryBuilder = paramInternalQueryBuilderWrapper;
    this.in = paramBoolean;
  }

  public void appendOperation(StringBuilder paramStringBuilder)
  {
    if (this.in)
    {
      StringBuilder localStringBuilder1 = paramStringBuilder.append("IN ");
      return;
    }
    StringBuilder localStringBuilder2 = paramStringBuilder.append("NOT IN ");
  }

  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    StringBuilder localStringBuilder1 = paramStringBuilder.append('(');
    this.subQueryBuilder.appendStatementString(paramStringBuilder, paramList);
    FieldType[] arrayOfFieldType = this.subQueryBuilder.getResultFieldTypes();
    if (arrayOfFieldType.length != 1)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append("There must be only 1 result column in sub-query but we found ");
      int i = arrayOfFieldType.length;
      String str1 = i;
      throw new SQLException(str1);
    }
    SqlType localSqlType1 = this.fieldType.getSqlType();
    SqlType localSqlType2 = arrayOfFieldType[0].getSqlType();
    if (localSqlType1 != localSqlType2)
    {
      StringBuilder localStringBuilder3 = new StringBuilder().append("Outer column ");
      FieldType localFieldType1 = this.fieldType;
      StringBuilder localStringBuilder4 = localStringBuilder3.append(localFieldType1).append(" is not the same type as inner column ");
      FieldType localFieldType2 = arrayOfFieldType[0];
      String str2 = localFieldType2;
      throw new SQLException(str2);
    }
    StringBuilder localStringBuilder5 = paramStringBuilder.append(") ");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.InSubQuery
 * JD-Core Version:    0.6.2
 */