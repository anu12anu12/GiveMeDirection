package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class StatementBuilder<T, ID>
{
  private static Logger logger = LoggerFactory.getLogger(StatementBuilder.class);
  protected final Dao<T, ID> dao;
  protected final DatabaseType databaseType;
  protected final TableInfo<T, ID> tableInfo;
  protected StatementType type;
  private Where<T, ID> where = null;

  public StatementBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao, StatementType paramStatementType)
  {
    this.databaseType = paramDatabaseType;
    this.tableInfo = paramTableInfo;
    this.dao = paramDao;
    this.type = paramStatementType;
    if (paramStatementType.isOkForStatementBuilder())
      return;
    String str = "Building a statement from a " + paramStatementType + " statement is not allowed";
    throw new IllegalStateException(str);
  }

  private String buildStatementString(List<ArgumentHolder> paramList)
    throws SQLException
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    appendStatementString(localStringBuilder, paramList);
    String str = localStringBuilder.toString();
    logger.debug("built statement {}", str);
    return str;
  }

  protected abstract void appendStatementEnd(StringBuilder paramStringBuilder)
    throws SQLException;

  protected abstract void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException;

  protected void appendStatementString(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    appendStatementStart(paramStringBuilder, paramList);
    if (this.where != null)
    {
      StringBuilder localStringBuilder = paramStringBuilder.append("WHERE ");
      this.where.appendSql(paramStringBuilder, paramList);
    }
    appendStatementEnd(paramStringBuilder);
  }

  public void clear()
  {
    this.where = null;
  }

  protected FieldType[] getResultFieldTypes()
  {
    return null;
  }

  StatementType getType()
  {
    return this.type;
  }

  protected MappedPreparedStmt<T, ID> prepareStatement(Long paramLong)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = buildStatementString(localArrayList);
    ArgumentHolder[] arrayOfArgumentHolder1 = new ArgumentHolder[localArrayList.size()];
    ArgumentHolder[] arrayOfArgumentHolder2 = (ArgumentHolder[])localArrayList.toArray(arrayOfArgumentHolder1);
    FieldType[] arrayOfFieldType1 = getResultFieldTypes();
    FieldType[] arrayOfFieldType2 = new FieldType[localArrayList.size()];
    int i = 0;
    while (true)
    {
      int j = arrayOfArgumentHolder2.length;
      if (i >= j)
        break;
      FieldType localFieldType = arrayOfArgumentHolder2[i].getFieldType();
      arrayOfFieldType2[i] = localFieldType;
      i += 1;
    }
    if (!this.type.isOkForStatementBuilder())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Building a statement from a ");
      StatementType localStatementType1 = this.type;
      String str2 = localStatementType1 + " statement is not allowed";
      throw new IllegalStateException(str2);
    }
    MappedPreparedStmt localMappedPreparedStmt = new com/j256/ormlite/stmt/mapped/MappedPreparedStmt;
    TableInfo localTableInfo = this.tableInfo;
    if (this.databaseType.isLimitSqlSupported());
    for (Long localLong = null; ; localLong = paramLong)
    {
      StatementType localStatementType2 = this.type;
      localMappedPreparedStmt.<init>(localTableInfo, str1, arrayOfFieldType2, arrayOfFieldType1, arrayOfArgumentHolder2, localLong, localStatementType2);
      return localMappedPreparedStmt;
    }
  }

  public String prepareStatementString()
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    return buildStatementString(localArrayList);
  }

  public void setWhere(Where<T, ID> paramWhere)
  {
    this.where = paramWhere;
  }

  protected FieldType verifyColumnName(String paramString)
  {
    return this.tableInfo.getFieldTypeByColumnName(paramString);
  }

  public Where<T, ID> where()
  {
    TableInfo localTableInfo = this.tableInfo;
    DatabaseType localDatabaseType = this.databaseType;
    Where localWhere = new Where(localTableInfo, this, localDatabaseType);
    this.where = localWhere;
    return this.where;
  }

  public static enum StatementType
  {
    private final boolean okForExecute;
    private final boolean okForQuery;
    private final boolean okForStatementBuilder;
    private final boolean okForUpdate;

    static
    {
      boolean bool1 = true;
      boolean bool2 = false;
      boolean bool3 = false;
      SELECT = new StatementType("SELECT", 0, true, bool1, bool2, bool3);
      int i = 1;
      boolean bool4 = true;
      boolean bool5 = true;
      boolean bool6 = false;
      boolean bool7 = false;
      SELECT_LONG = new StatementType("SELECT_LONG", i, bool4, bool5, bool6, bool7);
      int j = 2;
      boolean bool8 = true;
      boolean bool9 = true;
      boolean bool10 = false;
      boolean bool11 = false;
      SELECT_RAW = new StatementType("SELECT_RAW", j, bool8, bool9, bool10, bool11);
      int k = 3;
      boolean bool12 = true;
      boolean bool13 = false;
      boolean bool14 = true;
      boolean bool15 = false;
      UPDATE = new StatementType("UPDATE", k, bool12, bool13, bool14, bool15);
      int m = 4;
      boolean bool16 = true;
      boolean bool17 = false;
      boolean bool18 = true;
      boolean bool19 = false;
      DELETE = new StatementType("DELETE", m, bool16, bool17, bool18, bool19);
      boolean bool20 = false;
      boolean bool21 = false;
      boolean bool22 = false;
      boolean bool23 = true;
      EXECUTE = new StatementType("EXECUTE", 5, bool20, bool21, bool22, bool23);
      StatementType[] arrayOfStatementType = new StatementType[6];
      StatementType localStatementType1 = SELECT;
      arrayOfStatementType[0] = localStatementType1;
      StatementType localStatementType2 = SELECT_LONG;
      arrayOfStatementType[1] = localStatementType2;
      StatementType localStatementType3 = SELECT_RAW;
      arrayOfStatementType[2] = localStatementType3;
      StatementType localStatementType4 = UPDATE;
      arrayOfStatementType[3] = localStatementType4;
      StatementType localStatementType5 = DELETE;
      arrayOfStatementType[4] = localStatementType5;
      StatementType localStatementType6 = EXECUTE;
      arrayOfStatementType[5] = localStatementType6;
    }

    private StatementType(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.okForStatementBuilder = paramBoolean1;
      this.okForQuery = paramBoolean2;
      this.okForUpdate = paramBoolean3;
      this.okForExecute = paramBoolean4;
    }

    public boolean isOkForExecute()
    {
      return this.okForExecute;
    }

    public boolean isOkForQuery()
    {
      return this.okForQuery;
    }

    public boolean isOkForStatementBuilder()
    {
      return this.okForStatementBuilder;
    }

    public boolean isOkForUpdate()
    {
      return this.okForUpdate;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.StatementBuilder
 * JD-Core Version:    0.6.2
 */