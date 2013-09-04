package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

public class DeleteBuilder<T, ID> extends StatementBuilder<T, ID>
{
  public DeleteBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    super(paramDatabaseType, paramTableInfo, paramDao, localStatementType);
  }

  protected void appendStatementEnd(StringBuilder paramStringBuilder)
  {
  }

  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
    StringBuilder localStringBuilder1 = paramStringBuilder.append("DELETE FROM ");
    DatabaseType localDatabaseType = this.databaseType;
    String str = this.tableInfo.getTableName();
    localDatabaseType.appendEscapedEntityName(paramStringBuilder, str);
    StringBuilder localStringBuilder2 = paramStringBuilder.append(' ');
  }

  public void clear()
  {
    super.clear();
  }

  public int delete()
    throws SQLException
  {
    Dao localDao = this.dao;
    PreparedDelete localPreparedDelete = prepare();
    return localDao.delete(localPreparedDelete);
  }

  public PreparedDelete<T> prepare()
    throws SQLException
  {
    return super.prepareStatement(null);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.DeleteBuilder
 * JD-Core Version:    0.6.2
 */