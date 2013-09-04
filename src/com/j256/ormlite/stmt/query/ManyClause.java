package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class ManyClause
  implements Clause, NeedsFutureClause
{
  public static final String AND_OPERATION = "AND";
  public static final String OR_OPERATION = "OR";
  private final Clause first;
  private final String operation;
  private final Clause[] others;
  private Clause second;
  private final int startOthersAt;

  public ManyClause(Clause paramClause1, Clause paramClause2, Clause[] paramArrayOfClause, String paramString)
  {
    this.first = paramClause1;
    this.second = paramClause2;
    this.others = paramArrayOfClause;
    this.startOthersAt = 0;
    this.operation = paramString;
  }

  public ManyClause(Clause paramClause, String paramString)
  {
    this.first = paramClause;
    this.second = null;
    this.others = null;
    this.startOthersAt = 0;
    this.operation = paramString;
  }

  public ManyClause(Clause[] paramArrayOfClause, String paramString)
  {
    Clause localClause1 = paramArrayOfClause[0];
    this.first = localClause1;
    int i;
    if (paramArrayOfClause.length < 2)
    {
      this.second = null;
      i = paramArrayOfClause.length;
    }
    for (this.startOthersAt = i; ; this.startOthersAt = 2)
    {
      this.others = paramArrayOfClause;
      this.operation = paramString;
      return;
      Clause localClause2 = paramArrayOfClause[1];
      this.second = localClause2;
    }
  }

  public void appendSql(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    StringBuilder localStringBuilder1 = paramStringBuilder.append("(");
    this.first.appendSql(paramDatabaseType, paramStringBuilder, paramList);
    if (this.second != null)
    {
      String str1 = this.operation;
      StringBuilder localStringBuilder2 = paramStringBuilder.append(str1);
      StringBuilder localStringBuilder3 = paramStringBuilder.append(' ');
      this.second.appendSql(paramDatabaseType, paramStringBuilder, paramList);
    }
    if (this.others != null)
    {
      int i = this.startOthersAt;
      while (true)
      {
        int j = this.others.length;
        if (i >= j)
          break;
        String str2 = this.operation;
        StringBuilder localStringBuilder4 = paramStringBuilder.append(str2);
        StringBuilder localStringBuilder5 = paramStringBuilder.append(' ');
        this.others[i].appendSql(paramDatabaseType, paramStringBuilder, paramList);
        i += 1;
      }
    }
    StringBuilder localStringBuilder6 = paramStringBuilder.append(") ");
  }

  public void setMissingClause(Clause paramClause)
  {
    this.second = paramClause;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.ManyClause
 * JD-Core Version:    0.6.2
 */