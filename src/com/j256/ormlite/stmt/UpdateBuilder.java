package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.SetExpression;
import com.j256.ormlite.stmt.query.SetValue;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateBuilder<T, ID> extends StatementBuilder<T, ID>
{
  private List<Clause> updateClauseList = null;

  public UpdateBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    super(paramDatabaseType, paramTableInfo, paramDao, localStatementType);
  }

  private void addUpdateColumnToList(String paramString, Clause paramClause)
  {
    if (this.updateClauseList == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.updateClauseList = localArrayList;
    }
    boolean bool = this.updateClauseList.add(paramClause);
  }

  protected void appendStatementEnd(StringBuilder paramStringBuilder)
  {
  }

  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    if ((this.updateClauseList == null) || (this.updateClauseList.isEmpty()))
      throw new IllegalArgumentException("UPDATE statements must have at least one SET column");
    StringBuilder localStringBuilder1 = paramStringBuilder.append("UPDATE ");
    DatabaseType localDatabaseType1 = this.databaseType;
    String str = this.tableInfo.getTableName();
    localDatabaseType1.appendEscapedEntityName(paramStringBuilder, str);
    StringBuilder localStringBuilder2 = paramStringBuilder.append(" SET ");
    int i = 1;
    Iterator localIterator = this.updateClauseList.iterator();
    if (!localIterator.hasNext())
      return;
    Clause localClause = (Clause)localIterator.next();
    if (i != 0)
      i = 0;
    while (true)
    {
      DatabaseType localDatabaseType2 = this.databaseType;
      localClause.appendSql(localDatabaseType2, paramStringBuilder, paramList);
      break;
      StringBuilder localStringBuilder3 = paramStringBuilder.append(',');
    }
  }

  public void clear()
  {
    super.clear();
    this.updateClauseList = null;
  }

  public String escapeColumnName(String paramString)
  {
    int i = paramString.length() + 4;
    StringBuilder localStringBuilder = new StringBuilder(i);
    this.databaseType.appendEscapedEntityName(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }

  public void escapeColumnName(StringBuilder paramStringBuilder, String paramString)
  {
    this.databaseType.appendEscapedEntityName(paramStringBuilder, paramString);
  }

  public String escapeValue(String paramString)
  {
    int i = paramString.length() + 4;
    StringBuilder localStringBuilder = new StringBuilder(i);
    this.databaseType.appendEscapedWord(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }

  public void escapeValue(StringBuilder paramStringBuilder, String paramString)
  {
    this.databaseType.appendEscapedWord(paramStringBuilder, paramString);
  }

  public PreparedUpdate<T> prepare()
    throws SQLException
  {
    return super.prepareStatement(null);
  }

  public int update()
    throws SQLException
  {
    Dao localDao = this.dao;
    PreparedUpdate localPreparedUpdate = prepare();
    return localDao.update(localPreparedUpdate);
  }

  public StatementBuilder<T, ID> updateColumnExpression(String paramString1, String paramString2)
    throws SQLException
  {
    FieldType localFieldType = verifyColumnName(paramString1);
    if (localFieldType.isForeignCollection())
    {
      String str = "Can't update foreign colletion field: " + paramString1;
      throw new SQLException(str);
    }
    SetExpression localSetExpression = new SetExpression(paramString1, localFieldType, paramString2);
    addUpdateColumnToList(paramString1, localSetExpression);
    return this;
  }

  public StatementBuilder<T, ID> updateColumnValue(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = verifyColumnName(paramString);
    if (localFieldType.isForeignCollection())
    {
      String str = "Can't update foreign colletion field: " + paramString;
      throw new SQLException(str);
    }
    SetValue localSetValue = new SetValue(paramString, localFieldType, paramObject);
    addUpdateColumnToList(paramString, localSetValue);
    return this;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.UpdateBuilder
 * JD-Core Version:    0.6.2
 */