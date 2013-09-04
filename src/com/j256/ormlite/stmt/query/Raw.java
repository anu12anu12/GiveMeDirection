package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.util.List;

public class Raw
  implements Clause
{
  private final ArgumentHolder[] args;
  private final String statement;

  public Raw(String paramString, ArgumentHolder[] paramArrayOfArgumentHolder)
  {
    this.statement = paramString;
    this.args = paramArrayOfArgumentHolder;
  }

  public void appendSql(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
    String str = this.statement;
    StringBuilder localStringBuilder1 = paramStringBuilder.append(str);
    StringBuilder localStringBuilder2 = paramStringBuilder.append(' ');
    ArgumentHolder[] arrayOfArgumentHolder = this.args;
    int i = arrayOfArgumentHolder.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      ArgumentHolder localArgumentHolder = arrayOfArgumentHolder[j];
      boolean bool = paramList.add(localArgumentHolder);
      j += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.Raw
 * JD-Core Version:    0.6.2
 */