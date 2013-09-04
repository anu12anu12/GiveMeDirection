package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class Between extends BaseComparison
{
  private Object high;
  private Object low;

  public Between(String paramString, FieldType paramFieldType, Object paramObject1, Object paramObject2)
    throws SQLException
  {
    super(paramString, paramFieldType, null, true);
    this.low = paramObject1;
    this.high = paramObject2;
  }

  public void appendOperation(StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("BETWEEN ");
  }

  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    if (this.low == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("BETWEEN low value for '");
      String str1 = this.columnName;
      String str2 = str1 + "' is null";
      throw new IllegalArgumentException(str2);
    }
    if (this.high == null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append("BETWEEN high value for '");
      String str3 = this.columnName;
      String str4 = str3 + "' is null";
      throw new IllegalArgumentException(str4);
    }
    FieldType localFieldType1 = this.fieldType;
    Object localObject1 = this.low;
    Between localBetween1 = this;
    DatabaseType localDatabaseType1 = paramDatabaseType;
    StringBuilder localStringBuilder3 = paramStringBuilder;
    List<ArgumentHolder> localList1 = paramList;
    localBetween1.appendArgOrValue(localDatabaseType1, localFieldType1, localStringBuilder3, localList1, localObject1);
    StringBuilder localStringBuilder4 = paramStringBuilder.append("AND ");
    FieldType localFieldType2 = this.fieldType;
    Object localObject2 = this.high;
    Between localBetween2 = this;
    DatabaseType localDatabaseType2 = paramDatabaseType;
    StringBuilder localStringBuilder5 = paramStringBuilder;
    List<ArgumentHolder> localList2 = paramList;
    localBetween2.appendArgOrValue(localDatabaseType2, localFieldType2, localStringBuilder5, localList2, localObject2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.Between
 * JD-Core Version:    0.6.2
 */