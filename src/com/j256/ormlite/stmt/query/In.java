package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class In extends BaseComparison
{
  private final boolean in;
  private Iterable<?> objects;

  public In(String paramString, FieldType paramFieldType, Iterable<?> paramIterable, boolean paramBoolean)
    throws SQLException
  {
    super(paramString, paramFieldType, null, true);
    this.objects = paramIterable;
    this.in = paramBoolean;
  }

  public In(String paramString, FieldType paramFieldType, Object[] paramArrayOfObject, boolean paramBoolean)
    throws SQLException
  {
    super(paramString, paramFieldType, null, true);
    List localList = Arrays.asList(paramArrayOfObject);
    this.objects = localList;
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
    int i = 1;
    Iterator localIterator = this.objects.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject == null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder().append("one of the IN values for '");
        String str1 = this.columnName;
        String str2 = str1 + "' is null";
        throw new IllegalArgumentException(str2);
      }
      if (i != 0)
        i = 0;
      while (true)
      {
        FieldType localFieldType = this.fieldType;
        In localIn = this;
        DatabaseType localDatabaseType = paramDatabaseType;
        StringBuilder localStringBuilder3 = paramStringBuilder;
        List<ArgumentHolder> localList = paramList;
        localIn.appendArgOrValue(localDatabaseType, localFieldType, localStringBuilder3, localList, localObject);
        break;
        StringBuilder localStringBuilder4 = paramStringBuilder.append(',');
      }
    }
    StringBuilder localStringBuilder5 = paramStringBuilder.append(") ");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.In
 * JD-Core Version:    0.6.2
 */