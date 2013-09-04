package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class Not
  implements Clause, NeedsFutureClause
{
  private Comparison comparison = null;
  private Exists exists = null;

  public Not()
  {
  }

  public Not(Clause paramClause)
  {
    setMissingClause(paramClause);
  }

  public void appendSql(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    if ((this.comparison == null) && (this.exists == null))
      throw new IllegalStateException("Clause has not been set in NOT operation");
    if (this.comparison == null)
    {
      StringBuilder localStringBuilder1 = paramStringBuilder.append("(NOT ");
      this.exists.appendSql(paramDatabaseType, paramStringBuilder, paramList);
    }
    while (true)
    {
      StringBuilder localStringBuilder2 = paramStringBuilder.append(") ");
      return;
      StringBuilder localStringBuilder3 = paramStringBuilder.append("(NOT ");
      String str = this.comparison.getColumnName();
      paramDatabaseType.appendEscapedEntityName(paramStringBuilder, str);
      StringBuilder localStringBuilder4 = paramStringBuilder.append(' ');
      this.comparison.appendOperation(paramStringBuilder);
      this.comparison.appendValue(paramDatabaseType, paramStringBuilder, paramList);
    }
  }

  public void setMissingClause(Clause paramClause)
  {
    if (this.comparison != null)
      throw new IllegalArgumentException("NOT operation already has a comparison set");
    if ((paramClause instanceof Comparison))
    {
      Comparison localComparison = (Comparison)paramClause;
      this.comparison = localComparison;
      return;
    }
    if ((paramClause instanceof Exists))
    {
      Exists localExists = (Exists)paramClause;
      this.exists = localExists;
      return;
    }
    String str = "NOT operation can only work with comparison SQL clauses, not " + paramClause;
    throw new IllegalArgumentException(str);
  }

  public String toString()
  {
    if (this.comparison == null);
    StringBuilder localStringBuilder;
    Comparison localComparison;
    for (String str = "NOT without comparison"; ; str = localComparison)
    {
      return str;
      localStringBuilder = new StringBuilder().append("NOT comparison ");
      localComparison = this.comparison;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.Not
 * JD-Core Version:    0.6.2
 */