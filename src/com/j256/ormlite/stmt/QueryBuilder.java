package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryBuilder<T, ID> extends StatementBuilder<T, ID>
{
  private boolean countOf = false;
  private boolean distinct = false;
  private List<String> groupByList = null;
  private String groupByRaw = null;
  private String having = null;
  private final FieldType idField;
  private boolean isInnerQuery = false;
  private Long limit = null;
  private Long offset = null;
  private List<OrderBy> orderByList = null;
  private String orderByRaw = null;
  private FieldType[] resultFieldTypes;
  private List<String> selectColumnList = null;
  private boolean selectIdColumn = true;
  private List<String> selectRawList = null;

  public QueryBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    super(paramDatabaseType, paramTableInfo, paramDao, localStatementType);
    FieldType localFieldType = paramTableInfo.getIdField();
    this.idField = localFieldType;
  }

  private void addSelectColumnToList(String paramString)
  {
    FieldType localFieldType = verifyColumnName(paramString);
    boolean bool = this.selectColumnList.add(paramString);
  }

  private void appendColumns(StringBuilder paramStringBuilder)
  {
    if (this.selectColumnList == null)
    {
      StringBuilder localStringBuilder1 = paramStringBuilder.append("* ");
      FieldType[] arrayOfFieldType1 = this.tableInfo.getFieldTypes();
      this.resultFieldTypes = arrayOfFieldType1;
      return;
    }
    int i = 1;
    if (this.isInnerQuery);
    ArrayList localArrayList;
    FieldType localFieldType1;
    for (int j = 1; ; j = 0)
    {
      int k = this.selectColumnList.size() + 1;
      localArrayList = new ArrayList(k);
      Iterator localIterator = this.selectColumnList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label184;
        String str = (String)localIterator.next();
        localFieldType1 = this.tableInfo.getFieldTypeByColumnName(str);
        if (!localFieldType1.isForeignCollection())
          break;
        boolean bool = localArrayList.add(localFieldType1);
      }
    }
    if (i != 0)
      i = 0;
    while (true)
    {
      appendFieldColumnName(paramStringBuilder, localFieldType1, localArrayList);
      FieldType localFieldType2 = this.idField;
      if (localFieldType1 != localFieldType2)
        break;
      j = 1;
      break;
      StringBuilder localStringBuilder2 = paramStringBuilder.append(',');
    }
    label184: if ((j == 0) && (this.selectIdColumn))
    {
      if (i == 0)
        StringBuilder localStringBuilder3 = paramStringBuilder.append(',');
      FieldType localFieldType3 = this.idField;
      appendFieldColumnName(paramStringBuilder, localFieldType3, localArrayList);
    }
    StringBuilder localStringBuilder4 = paramStringBuilder.append(' ');
    FieldType[] arrayOfFieldType2 = new FieldType[localArrayList.size()];
    FieldType[] arrayOfFieldType3 = (FieldType[])localArrayList.toArray(arrayOfFieldType2);
    this.resultFieldTypes = arrayOfFieldType3;
  }

  private void appendFieldColumnName(StringBuilder paramStringBuilder, FieldType paramFieldType, List<FieldType> paramList)
  {
    DatabaseType localDatabaseType = this.databaseType;
    String str = paramFieldType.getColumnName();
    localDatabaseType.appendEscapedEntityName(paramStringBuilder, str);
    if (paramList == null)
      return;
    boolean bool = paramList.add(paramFieldType);
  }

  private void appendGroupBys(StringBuilder paramStringBuilder)
  {
    if (((this.groupByList == null) || (this.groupByList.isEmpty())) && (this.groupByRaw == null))
      return;
    StringBuilder localStringBuilder1 = paramStringBuilder.append("GROUP BY ");
    if (this.groupByRaw != null)
    {
      String str1 = this.groupByRaw;
      StringBuilder localStringBuilder2 = paramStringBuilder.append(str1);
      StringBuilder localStringBuilder3 = paramStringBuilder.append(' ');
      return;
    }
    int i = 1;
    Iterator localIterator = this.groupByList.iterator();
    label76: String str2;
    if (localIterator.hasNext())
    {
      str2 = (String)localIterator.next();
      if (i == 0)
        break label121;
      i = 0;
    }
    while (true)
    {
      this.databaseType.appendEscapedEntityName(paramStringBuilder, str2);
      break label76;
      break;
      label121: StringBuilder localStringBuilder4 = paramStringBuilder.append(',');
    }
  }

  private void appendHaving(StringBuilder paramStringBuilder)
  {
    if (this.having == null)
      return;
    StringBuilder localStringBuilder1 = paramStringBuilder.append("HAVING ");
    String str = this.having;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str).append(' ');
  }

  private void appendLimit(StringBuilder paramStringBuilder)
  {
    if (this.limit == null)
      return;
    if (!this.databaseType.isLimitSqlSupported())
      return;
    DatabaseType localDatabaseType = this.databaseType;
    long l = this.limit.longValue();
    Long localLong = this.offset;
    localDatabaseType.appendLimitValue(paramStringBuilder, l, localLong);
  }

  private void appendOffset(StringBuilder paramStringBuilder)
    throws SQLException
  {
    if (this.offset == null)
      return;
    if (this.databaseType.isOffsetLimitArgument())
    {
      if (this.limit != null)
        return;
      throw new SQLException("If the offset is specified, limit must also be specified with this database");
    }
    DatabaseType localDatabaseType = this.databaseType;
    long l = this.offset.longValue();
    localDatabaseType.appendOffsetValue(paramStringBuilder, l);
  }

  private void appendOrderBys(StringBuilder paramStringBuilder)
  {
    if (((this.orderByList == null) || (this.orderByList.isEmpty())) && (this.orderByRaw == null))
      return;
    StringBuilder localStringBuilder1 = paramStringBuilder.append("ORDER BY ");
    if (this.orderByRaw != null)
    {
      String str1 = this.orderByRaw;
      StringBuilder localStringBuilder2 = paramStringBuilder.append(str1);
      StringBuilder localStringBuilder3 = paramStringBuilder.append(' ');
      return;
    }
    int i = 1;
    Iterator localIterator = this.orderByList.iterator();
    label76: OrderBy localOrderBy;
    if (localIterator.hasNext())
    {
      localOrderBy = (OrderBy)localIterator.next();
      if (i == 0)
        break label144;
      i = 0;
    }
    while (true)
    {
      String str2 = localOrderBy.getColumnName();
      this.databaseType.appendEscapedEntityName(paramStringBuilder, str2);
      if (localOrderBy.isAscending())
        break label76;
      StringBuilder localStringBuilder4 = paramStringBuilder.append(" DESC");
      break label76;
      break;
      label144: StringBuilder localStringBuilder5 = paramStringBuilder.append(',');
    }
  }

  private void appendRawColumns(StringBuilder paramStringBuilder)
  {
    int i = 1;
    Iterator localIterator = this.selectRawList.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != 0)
        i = 0;
      while (true)
      {
        StringBuilder localStringBuilder1 = paramStringBuilder.append(str);
        break;
        StringBuilder localStringBuilder2 = paramStringBuilder.append(", ");
      }
    }
    StringBuilder localStringBuilder3 = paramStringBuilder.append(' ');
  }

  protected void appendStatementEnd(StringBuilder paramStringBuilder)
    throws SQLException
  {
    appendGroupBys(paramStringBuilder);
    appendOrderBys(paramStringBuilder);
    appendHaving(paramStringBuilder);
    if (!this.databaseType.isLimitAfterSelect())
      appendLimit(paramStringBuilder);
    appendOffset(paramStringBuilder);
  }

  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
    StringBuilder localStringBuilder1 = paramStringBuilder.append("SELECT ");
    if (this.databaseType.isLimitAfterSelect())
      appendLimit(paramStringBuilder);
    if (this.distinct)
      StringBuilder localStringBuilder2 = paramStringBuilder.append("DISTINCT ");
    if (this.countOf)
    {
      StatementBuilder.StatementType localStatementType1 = StatementBuilder.StatementType.SELECT_LONG;
      this.type = localStatementType1;
      StringBuilder localStringBuilder3 = paramStringBuilder.append("COUNT(*) ");
    }
    while (true)
    {
      StringBuilder localStringBuilder4 = paramStringBuilder.append("FROM ");
      DatabaseType localDatabaseType = this.databaseType;
      String str = this.tableInfo.getTableName();
      localDatabaseType.appendEscapedEntityName(paramStringBuilder, str);
      StringBuilder localStringBuilder5 = paramStringBuilder.append(' ');
      return;
      if ((this.selectRawList != null) && (!this.selectRawList.isEmpty()))
      {
        StatementBuilder.StatementType localStatementType2 = StatementBuilder.StatementType.SELECT_RAW;
        this.type = localStatementType2;
        appendRawColumns(paramStringBuilder);
      }
      else
      {
        StatementBuilder.StatementType localStatementType3 = StatementBuilder.StatementType.SELECT;
        this.type = localStatementType3;
        appendColumns(paramStringBuilder);
      }
    }
  }

  public void clear()
  {
    super.clear();
    this.distinct = false;
    this.selectIdColumn = true;
    this.selectColumnList = null;
    this.selectRawList = null;
    this.orderByList = null;
    this.orderByRaw = null;
    this.groupByList = null;
    this.groupByRaw = null;
    this.isInnerQuery = false;
    this.countOf = false;
    this.having = null;
    this.limit = null;
    this.offset = null;
  }

  public QueryBuilder<T, ID> distinct()
  {
    this.distinct = true;
    this.selectIdColumn = false;
    return this;
  }

  void enableInnerQuery()
  {
    this.isInnerQuery = true;
  }

  protected FieldType[] getResultFieldTypes()
  {
    return this.resultFieldTypes;
  }

  int getSelectColumnCount()
  {
    if (this.selectColumnList == null);
    for (int i = 0; ; i = this.selectColumnList.size())
      return i;
  }

  public QueryBuilder<T, ID> groupBy(String paramString)
  {
    if (verifyColumnName(paramString).isForeignCollection())
    {
      String str = "Can't groupBy foreign colletion field: " + paramString;
      throw new IllegalArgumentException(str);
    }
    if (this.groupByList == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.groupByList = localArrayList;
    }
    boolean bool = this.groupByList.add(paramString);
    this.selectIdColumn = false;
    return this;
  }

  public QueryBuilder<T, ID> groupByRaw(String paramString)
  {
    this.groupByRaw = paramString;
    return this;
  }

  public QueryBuilder<T, ID> having(String paramString)
  {
    this.having = paramString;
    return this;
  }

  public CloseableIterator<T> iterator()
    throws SQLException
  {
    Dao localDao = this.dao;
    PreparedQuery localPreparedQuery = prepare();
    return localDao.iterator(localPreparedQuery);
  }

  @Deprecated
  public QueryBuilder<T, ID> limit(int paramInt)
  {
    Long localLong = Long.valueOf(paramInt);
    return limit(localLong);
  }

  public QueryBuilder<T, ID> limit(Long paramLong)
  {
    this.limit = paramLong;
    return this;
  }

  @Deprecated
  public QueryBuilder<T, ID> offset(int paramInt)
    throws SQLException
  {
    Long localLong = Long.valueOf(paramInt);
    return offset(localLong);
  }

  public QueryBuilder<T, ID> offset(Long paramLong)
    throws SQLException
  {
    if (this.databaseType.isOffsetSqlSupported())
    {
      this.offset = paramLong;
      return this;
    }
    throw new SQLException("Offset is not supported by this database");
  }

  public QueryBuilder<T, ID> orderBy(String paramString, boolean paramBoolean)
  {
    if (verifyColumnName(paramString).isForeignCollection())
    {
      String str = "Can't orderBy foreign colletion field: " + paramString;
      throw new IllegalArgumentException(str);
    }
    if (this.orderByList == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.orderByList = localArrayList;
    }
    List localList = this.orderByList;
    OrderBy localOrderBy = new OrderBy(paramString, paramBoolean);
    boolean bool = localList.add(localOrderBy);
    return this;
  }

  public QueryBuilder<T, ID> orderByRaw(String paramString)
  {
    this.orderByRaw = paramString;
    return this;
  }

  public PreparedQuery<T> prepare()
    throws SQLException
  {
    Long localLong = this.limit;
    return super.prepareStatement(localLong);
  }

  public List<T> query()
    throws SQLException
  {
    Dao localDao = this.dao;
    PreparedQuery localPreparedQuery = prepare();
    return localDao.query(localPreparedQuery);
  }

  public T queryForFirst()
    throws SQLException
  {
    Dao localDao = this.dao;
    PreparedQuery localPreparedQuery = prepare();
    return localDao.queryForFirst(localPreparedQuery);
  }

  public String[] queryRawFirst()
    throws SQLException
  {
    Dao localDao = this.dao;
    String str = prepareStatementString();
    String[] arrayOfString = new String[0];
    return (String[])localDao.queryRaw(str, arrayOfString).getFirstResult();
  }

  public QueryBuilder<T, ID> selectColumns(Iterable<String> paramIterable)
  {
    if (this.selectColumnList == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.selectColumnList = localArrayList;
    }
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      addSelectColumnToList(str);
    }
    return this;
  }

  public QueryBuilder<T, ID> selectColumns(String[] paramArrayOfString)
  {
    if (this.selectColumnList == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.selectColumnList = localArrayList;
    }
    String[] arrayOfString = paramArrayOfString;
    int i = arrayOfString.length;
    int j = 0;
    while (j < i)
    {
      String str = arrayOfString[j];
      addSelectColumnToList(str);
      j += 1;
    }
    return this;
  }

  public QueryBuilder<T, ID> selectRaw(String[] paramArrayOfString)
  {
    if (this.selectRawList == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.selectRawList = localArrayList;
    }
    String[] arrayOfString = paramArrayOfString;
    int i = arrayOfString.length;
    int j = 0;
    while (j < i)
    {
      String str = arrayOfString[j];
      boolean bool = this.selectRawList.add(str);
      j += 1;
    }
    return this;
  }

  public QueryBuilder<T, ID> setCountOf(boolean paramBoolean)
  {
    this.countOf = paramBoolean;
    return this;
  }

  public static class InternalQueryBuilderWrapper
  {
    private final QueryBuilder<?, ?> queryBuilder;

    InternalQueryBuilderWrapper(QueryBuilder<?, ?> paramQueryBuilder)
    {
      this.queryBuilder = paramQueryBuilder;
    }

    public void appendStatementString(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
      throws SQLException
    {
      this.queryBuilder.appendStatementString(paramStringBuilder, paramList);
    }

    public FieldType[] getResultFieldTypes()
    {
      return this.queryBuilder.resultFieldTypes;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.QueryBuilder
 * JD-Core Version:    0.6.2
 */