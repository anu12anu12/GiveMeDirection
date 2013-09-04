package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Where<T, ID>
{
  private static final int START_CLAUSE_SIZE = 4;
  private Clause[] clauseStack;
  private int clauseStackLevel;
  private final DatabaseType databaseType;
  private final String idColumnName;
  private final FieldType idFieldType;
  private NeedsFutureClause needsFuture;
  private final StatementBuilder<T, ID> statementBuilder;
  private final TableInfo<T, ID> tableInfo;

  Where(TableInfo<T, ID> paramTableInfo, StatementBuilder<T, ID> paramStatementBuilder, DatabaseType paramDatabaseType)
  {
    Clause[] arrayOfClause = new Clause[4];
    this.clauseStack = arrayOfClause;
    this.clauseStackLevel = 0;
    this.needsFuture = null;
    this.tableInfo = paramTableInfo;
    this.statementBuilder = paramStatementBuilder;
    FieldType localFieldType = paramTableInfo.getIdField();
    this.idFieldType = localFieldType;
    if (this.idFieldType == null);
    String str;
    for (this.idColumnName = null; ; this.idColumnName = str)
    {
      this.databaseType = paramDatabaseType;
      return;
      str = this.idFieldType.getColumnName();
    }
  }

  private void addClause(Clause paramClause)
  {
    if (this.needsFuture == null)
    {
      push(paramClause);
      return;
    }
    this.needsFuture.setMissingClause(paramClause);
    this.needsFuture = null;
  }

  private void addNeedsFuture(NeedsFutureClause paramNeedsFutureClause)
  {
    if (this.needsFuture != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      NeedsFutureClause localNeedsFutureClause = this.needsFuture;
      String str = localNeedsFutureClause + " is already waiting for a future clause, can't add: " + paramNeedsFutureClause;
      throw new IllegalStateException(str);
    }
    this.needsFuture = paramNeedsFutureClause;
    push(paramNeedsFutureClause);
  }

  private Clause[] buildClauseArray(Where<T, ID>[] paramArrayOfWhere, String paramString)
  {
    Clause[] arrayOfClause;
    if (paramArrayOfWhere.length == 0)
      arrayOfClause = null;
    while (true)
    {
      return arrayOfClause;
      arrayOfClause = new Clause[paramArrayOfWhere.length];
      int i = paramArrayOfWhere.length + -1;
      while (i >= 0)
      {
        Clause localClause = pop(paramString);
        arrayOfClause[i] = localClause;
        i += -1;
      }
    }
  }

  private FieldType findColumnFieldType(String paramString)
  {
    return this.tableInfo.getFieldTypeByColumnName(paramString);
  }

  private Where<T, ID> in(boolean paramBoolean, String paramString, QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    if (paramQueryBuilder.getSelectColumnCount() != 1)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Inner query must have only 1 select column specified instead of ");
      int i = paramQueryBuilder.getSelectColumnCount();
      String str = i;
      throw new SQLException(str);
    }
    paramQueryBuilder.enableInnerQuery();
    FieldType localFieldType = findColumnFieldType(paramString);
    QueryBuilder.InternalQueryBuilderWrapper localInternalQueryBuilderWrapper = new QueryBuilder.InternalQueryBuilderWrapper(paramQueryBuilder);
    InSubQuery localInSubQuery = new InSubQuery(paramString, localFieldType, localInternalQueryBuilderWrapper, paramBoolean);
    addClause(localInSubQuery);
    return this;
  }

  private Where<T, ID> in(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    if (paramArrayOfObject.length == 1)
    {
      if (paramArrayOfObject[0].getClass().isArray())
        throw new IllegalArgumentException("Object argument to IN seems to be an array within an array");
      if (paramArrayOfObject[0].getClass() == Where.class)
        throw new IllegalArgumentException("Object argument to IN seems to be a Where.class instead of a QueryBuilder.class");
    }
    FieldType localFieldType = findColumnFieldType(paramString);
    In localIn = new In(paramString, localFieldType, paramArrayOfObject, paramBoolean);
    addClause(localIn);
    return this;
  }

  private Clause peek()
  {
    Clause[] arrayOfClause = this.clauseStack;
    int i = this.clauseStackLevel + -1;
    return arrayOfClause[i];
  }

  private Clause pop(String paramString)
  {
    if (this.clauseStackLevel == 0)
    {
      String str = "Expecting there to be a clause already defined for '" + paramString + "' operation";
      throw new IllegalStateException(str);
    }
    Clause[] arrayOfClause1 = this.clauseStack;
    int i = this.clauseStackLevel + -1;
    this.clauseStackLevel = i;
    Clause localClause = arrayOfClause1[i];
    Clause[] arrayOfClause2 = this.clauseStack;
    int j = this.clauseStackLevel;
    arrayOfClause2[j] = null;
    return localClause;
  }

  private void push(Clause paramClause)
  {
    int i = this.clauseStackLevel;
    int j = this.clauseStack.length;
    if (i != j)
    {
      Clause[] arrayOfClause1 = new Clause[this.clauseStackLevel * 2];
      int k = 0;
      while (true)
      {
        int m = this.clauseStackLevel;
        if (k >= m)
          break;
        Clause localClause = this.clauseStack[k];
        arrayOfClause1[k] = localClause;
        this.clauseStack[k] = null;
        k += 1;
      }
      this.clauseStack = arrayOfClause1;
    }
    Clause[] arrayOfClause2 = this.clauseStack;
    int n = this.clauseStackLevel;
    int i1 = n + 1;
    this.clauseStackLevel = i1;
    arrayOfClause2[n] = paramClause;
  }

  public Where<T, ID> and()
  {
    Clause localClause = pop("AND");
    ManyClause localManyClause = new ManyClause(localClause, "AND");
    addNeedsFuture(localManyClause);
    return this;
  }

  public Where<T, ID> and(int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
    Clause[] arrayOfClause = new Clause[paramInt];
    int i = paramInt + -1;
    while (i >= 0)
    {
      Clause localClause = pop("AND");
      arrayOfClause[i] = localClause;
      i += -1;
    }
    ManyClause localManyClause = new ManyClause(arrayOfClause, "AND");
    addClause(localManyClause);
    return this;
  }

  public Where<T, ID> and(Where<T, ID> paramWhere1, Where<T, ID> paramWhere2, Where<T, ID>[] paramArrayOfWhere)
  {
    Clause[] arrayOfClause = buildClauseArray(paramArrayOfWhere, "AND");
    Clause localClause1 = pop("AND");
    Clause localClause2 = pop("AND");
    ManyClause localManyClause = new ManyClause(localClause2, localClause1, arrayOfClause, "AND");
    addClause(localManyClause);
    return this;
  }

  void appendSql(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    if (this.clauseStackLevel == 0)
      throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
    if (this.clauseStackLevel != 1)
      throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
    Clause localClause = peek();
    DatabaseType localDatabaseType = this.databaseType;
    localClause.appendSql(localDatabaseType, paramStringBuilder, paramList);
  }

  public Where<T, ID> between(String paramString, Object paramObject1, Object paramObject2)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    Between localBetween = new Between(paramString, localFieldType, paramObject1, paramObject2);
    addClause(localBetween);
    return this;
  }

  public Where<T, ID> clear()
  {
    int i = 0;
    while (true)
    {
      int j = this.clauseStackLevel;
      if (i >= j)
        break;
      this.clauseStack[i] = null;
      i += 1;
    }
    this.clauseStackLevel = 0;
    return this;
  }

  public Where<T, ID> eq(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString, localFieldType, paramObject, "=");
    addClause(localSimpleComparison);
    return this;
  }

  public Where<T, ID> exists(QueryBuilder<?, ?> paramQueryBuilder)
  {
    paramQueryBuilder.enableInnerQuery();
    QueryBuilder.InternalQueryBuilderWrapper localInternalQueryBuilderWrapper = new QueryBuilder.InternalQueryBuilderWrapper(paramQueryBuilder);
    Exists localExists = new Exists(localInternalQueryBuilderWrapper);
    addClause(localExists);
    return this;
  }

  public Where<T, ID> ge(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString, localFieldType, paramObject, ">=");
    addClause(localSimpleComparison);
    return this;
  }

  public String getStatement()
    throws SQLException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = new ArrayList();
    appendSql(localStringBuilder, localArrayList);
    return localStringBuilder.toString();
  }

  public Where<T, ID> gt(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString, localFieldType, paramObject, ">");
    addClause(localSimpleComparison);
    return this;
  }

  public <OD> Where<T, ID> idEq(Dao<OD, ?> paramDao, OD paramOD)
    throws SQLException
  {
    if (this.idColumnName == null)
      throw new SQLException("Object has no id column specified");
    String str = this.idColumnName;
    FieldType localFieldType = this.idFieldType;
    Object localObject = paramDao.extractId(paramOD);
    SimpleComparison localSimpleComparison = new SimpleComparison(str, localFieldType, localObject, "=");
    addClause(localSimpleComparison);
    return this;
  }

  public Where<T, ID> idEq(ID paramID)
    throws SQLException
  {
    if (this.idColumnName == null)
      throw new SQLException("Object has no id column specified");
    String str = this.idColumnName;
    FieldType localFieldType = this.idFieldType;
    SimpleComparison localSimpleComparison = new SimpleComparison(str, localFieldType, paramID, "=");
    addClause(localSimpleComparison);
    return this;
  }

  public Where<T, ID> in(String paramString, QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    return in(true, paramString, paramQueryBuilder);
  }

  public Where<T, ID> in(String paramString, Iterable<?> paramIterable)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    In localIn = new In(paramString, localFieldType, paramIterable, true);
    addClause(localIn);
    return this;
  }

  public Where<T, ID> in(String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    return in(true, paramString, paramArrayOfObject);
  }

  public Where<T, ID> isNotNull(String paramString)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    IsNotNull localIsNotNull = new IsNotNull(paramString, localFieldType);
    addClause(localIsNotNull);
    return this;
  }

  public Where<T, ID> isNull(String paramString)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    IsNull localIsNull = new IsNull(paramString, localFieldType);
    addClause(localIsNull);
    return this;
  }

  public CloseableIterator<T> iterator()
    throws SQLException
  {
    if ((this.statementBuilder instanceof QueryBuilder))
      return ((QueryBuilder)this.statementBuilder).iterator();
    StringBuilder localStringBuilder = new StringBuilder().append("Cannot call iterator on a statement of type ");
    StatementBuilder.StatementType localStatementType = this.statementBuilder.getType();
    String str = localStatementType;
    throw new SQLException(str);
  }

  public Where<T, ID> le(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString, localFieldType, paramObject, "<=");
    addClause(localSimpleComparison);
    return this;
  }

  public Where<T, ID> like(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString, localFieldType, paramObject, "LIKE");
    addClause(localSimpleComparison);
    return this;
  }

  public Where<T, ID> lt(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString, localFieldType, paramObject, "<");
    addClause(localSimpleComparison);
    return this;
  }

  public Where<T, ID> ne(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString, localFieldType, paramObject, "<>");
    addClause(localSimpleComparison);
    return this;
  }

  public Where<T, ID> not()
  {
    Not localNot = new Not();
    addNeedsFuture(localNot);
    return this;
  }

  public Where<T, ID> not(Where<T, ID> paramWhere)
  {
    Clause localClause = pop("NOT");
    Not localNot = new Not(localClause);
    addClause(localNot);
    return this;
  }

  public Where<T, ID> notIn(String paramString, QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    return in(false, paramString, paramQueryBuilder);
  }

  public Where<T, ID> notIn(String paramString, Iterable<?> paramIterable)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString);
    In localIn = new In(paramString, localFieldType, paramIterable, false);
    addClause(localIn);
    return this;
  }

  public Where<T, ID> notIn(String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    return in(false, paramString, paramArrayOfObject);
  }

  public Where<T, ID> or()
  {
    Clause localClause = pop("OR");
    ManyClause localManyClause = new ManyClause(localClause, "OR");
    addNeedsFuture(localManyClause);
    return this;
  }

  public Where<T, ID> or(int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
    Clause[] arrayOfClause = new Clause[paramInt];
    int i = paramInt + -1;
    while (i >= 0)
    {
      Clause localClause = pop("OR");
      arrayOfClause[i] = localClause;
      i += -1;
    }
    ManyClause localManyClause = new ManyClause(arrayOfClause, "OR");
    addClause(localManyClause);
    return this;
  }

  public Where<T, ID> or(Where<T, ID> paramWhere1, Where<T, ID> paramWhere2, Where<T, ID>[] paramArrayOfWhere)
  {
    Clause[] arrayOfClause = buildClauseArray(paramArrayOfWhere, "OR");
    Clause localClause1 = pop("OR");
    Clause localClause2 = pop("OR");
    ManyClause localManyClause = new ManyClause(localClause2, localClause1, arrayOfClause, "OR");
    addClause(localManyClause);
    return this;
  }

  public PreparedQuery<T> prepare()
    throws SQLException
  {
    return this.statementBuilder.prepareStatement(null);
  }

  public List<T> query()
    throws SQLException
  {
    if ((this.statementBuilder instanceof QueryBuilder))
      return ((QueryBuilder)this.statementBuilder).query();
    StringBuilder localStringBuilder = new StringBuilder().append("Cannot call query on a statement of type ");
    StatementBuilder.StatementType localStatementType = this.statementBuilder.getType();
    String str = localStatementType;
    throw new SQLException(str);
  }

  public Where<T, ID> raw(String paramString, ArgumentHolder[] paramArrayOfArgumentHolder)
  {
    ArgumentHolder[] arrayOfArgumentHolder = paramArrayOfArgumentHolder;
    int i = arrayOfArgumentHolder.length;
    int j = 0;
    while (j < i)
    {
      ArgumentHolder localArgumentHolder = arrayOfArgumentHolder[j];
      String str = localArgumentHolder.getColumnName();
      if (str == null)
      {
        if (localArgumentHolder.getSqlType() == null)
          throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument");
      }
      else
      {
        FieldType localFieldType = findColumnFieldType(str);
        localArgumentHolder.setMetaInfo(localFieldType);
      }
      j += 1;
    }
    Raw localRaw = new Raw(paramString, paramArrayOfArgumentHolder);
    addClause(localRaw);
    return this;
  }

  public Where<T, ID> rawComparison(String paramString1, String paramString2, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = findColumnFieldType(paramString1);
    SimpleComparison localSimpleComparison = new SimpleComparison(paramString1, localFieldType, paramObject, paramString2);
    addClause(localSimpleComparison);
    return this;
  }

  public String toString()
  {
    if (this.clauseStackLevel == 0);
    Clause localClause;
    for (String str = "empty where clause"; ; str = "where clause: " + localClause)
    {
      return str;
      localClause = peek();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.Where
 * JD-Core Version:    0.6.2
 */