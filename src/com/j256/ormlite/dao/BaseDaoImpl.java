package com.j256.ormlite.dao;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.SelectIterator;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public abstract class BaseDaoImpl<T, ID>
  implements Dao<T, ID>
{
  private static final ThreadLocal<DaoConfigArray> daoConfigLevelLocal = new ThreadLocal()
  {
    protected BaseDaoImpl.DaoConfigArray initialValue()
    {
      return new BaseDaoImpl.DaoConfigArray(null);
    }
  };
  private static ReferenceObjectCache defaultObjectCache;
  protected ConnectionSource connectionSource;
  protected final Class<T> dataClass;
  protected DatabaseType databaseType;
  private boolean initialized;
  protected CloseableIterator<T> lastIterator;
  private ObjectCache objectCache;
  protected StatementExecutor<T, ID> statementExecutor;
  protected DatabaseTableConfig<T> tableConfig;
  protected TableInfo<T, ID> tableInfo;

  protected BaseDaoImpl(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    this(paramConnectionSource, localClass, paramDatabaseTableConfig);
  }

  protected BaseDaoImpl(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    this(paramConnectionSource, paramClass, null);
  }

  private BaseDaoImpl(ConnectionSource paramConnectionSource, Class<T> paramClass, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    this.dataClass = paramClass;
    this.tableConfig = paramDatabaseTableConfig;
    if (paramConnectionSource == null)
      return;
    this.connectionSource = paramConnectionSource;
    initialize();
  }

  protected BaseDaoImpl(Class<T> paramClass)
    throws SQLException
  {
    this(null, paramClass, null);
  }

  /** @deprecated */
  public static void clearAllInternalObjectCaches()
  {
    try
    {
      if (defaultObjectCache != null)
      {
        defaultObjectCache.clearAll();
        defaultObjectCache = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static <T, ID> Dao<T, ID> createDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    return new BaseDaoImpl(paramConnectionSource, paramDatabaseTableConfig)
    {
    };
  }

  static <T, ID> Dao<T, ID> createDao(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return new BaseDaoImpl(paramConnectionSource, paramClass)
    {
    };
  }

  private CloseableIterator<T> createIterator(int paramInt)
  {
    try
    {
      StatementExecutor localStatementExecutor = this.statementExecutor;
      ConnectionSource localConnectionSource = this.connectionSource;
      ObjectCache localObjectCache = this.objectCache;
      SelectIterator localSelectIterator = localStatementExecutor.buildIterator(this, localConnectionSource, paramInt, localObjectCache);
      return localSelectIterator;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Could not build iterator for ");
      Class localClass = this.dataClass;
      String str = localClass;
      throw new IllegalStateException(str, localException);
    }
  }

  private CloseableIterator<T> createIterator(PreparedQuery<T> paramPreparedQuery, int paramInt)
    throws SQLException
  {
    try
    {
      StatementExecutor localStatementExecutor = this.statementExecutor;
      ConnectionSource localConnectionSource = this.connectionSource;
      ObjectCache localObjectCache = this.objectCache;
      BaseDaoImpl localBaseDaoImpl = this;
      PreparedQuery<T> localPreparedQuery = paramPreparedQuery;
      int i = paramInt;
      SelectIterator localSelectIterator = localStatementExecutor.buildIterator(localBaseDaoImpl, localConnectionSource, localPreparedQuery, localObjectCache, i);
      return localSelectIterator;
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Could not build prepared-query iterator for ");
      Class localClass = this.dataClass;
      throw SqlExceptionUtil.create(localClass, localSQLException);
    }
  }

  private List<T> queryForFieldValues(Map<String, Object> paramMap, boolean paramBoolean)
    throws SQLException
  {
    checkForInitialized();
    QueryBuilder localQueryBuilder = queryBuilder();
    Where localWhere1 = localQueryBuilder.where();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      if (paramBoolean)
        localObject = new SelectArg(localObject);
      String str = (String)localEntry.getKey();
      Where localWhere2 = localWhere1.eq(str, localObject);
    }
    if (paramMap.size() == 0);
    for (List localList = Collections.emptyList(); ; localList = localQueryBuilder.query())
    {
      return localList;
      int i = paramMap.size();
      Where localWhere3 = localWhere1.and(i);
    }
  }

  private List<T> queryForMatching(T paramT, boolean paramBoolean)
    throws SQLException
  {
    checkForInitialized();
    QueryBuilder localQueryBuilder = queryBuilder();
    Where localWhere1 = localQueryBuilder.where();
    int i = 0;
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int j = arrayOfFieldType.length;
    int k = 0;
    while (k < j)
    {
      FieldType localFieldType = arrayOfFieldType[k];
      Object localObject = localFieldType.getFieldValueIfNotDefault(paramT);
      if (localObject != null)
      {
        if (paramBoolean)
          localObject = new SelectArg(localObject);
        String str = localFieldType.getColumnName();
        Where localWhere2 = localWhere1.eq(str, localObject);
        i += 1;
      }
      k += 1;
    }
    if (i == 0);
    for (List localList = Collections.emptyList(); ; localList = localQueryBuilder.query())
    {
      return localList;
      Where localWhere3 = localWhere1.and(i);
    }
  }

  public <CT> CT callBatchTasks(Callable<CT> paramCallable)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      boolean bool = this.connectionSource.saveSpecialConnection(localDatabaseConnection);
      Object localObject1 = this.statementExecutor.callBatchTasks(localDatabaseConnection, bool, paramCallable);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      this.connectionSource.clearSpecialConnection(localDatabaseConnection);
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  protected void checkForInitialized()
  {
    if (this.initialized)
      return;
    throw new IllegalStateException("you must call initialize() before you can use the dao");
  }

  public void clearObjectCache()
  {
    if (this.objectCache == null)
      return;
    ObjectCache localObjectCache = this.objectCache;
    Class localClass = this.dataClass;
    localObjectCache.clear(localClass);
  }

  public void closeLastIterator()
    throws SQLException
  {
    if (this.lastIterator == null)
      return;
    this.lastIterator.close();
    this.lastIterator = null;
  }

  public CloseableIterator<T> closeableIterator()
  {
    return iterator(-1);
  }

  public void commit(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    paramDatabaseConnection.commit(null);
  }

  public long countOf()
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      long l1 = this.statementExecutor.queryForCountStar(localDatabaseConnection);
      long l2 = l1;
      return l2;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public long countOf(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    checkForInitialized();
    StatementBuilder.StatementType localStatementType1 = paramPreparedQuery.getType();
    StatementBuilder.StatementType localStatementType2 = StatementBuilder.StatementType.SELECT_LONG;
    if (localStatementType1 != localStatementType2)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Prepared query is not of type ");
      StatementBuilder.StatementType localStatementType3 = StatementBuilder.StatementType.SELECT_LONG;
      String str = localStatementType3 + ", did you call QueryBuilder.setCountOf(true)?";
      throw new IllegalArgumentException(str);
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      long l1 = this.statementExecutor.queryForCountStar(localDatabaseConnection, paramPreparedQuery);
      long l2 = l1;
      return l2;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public int create(T paramT)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if (paramT == null)
      i = 0;
    while (true)
    {
      return i;
      if ((paramT instanceof BaseDaoEnabled))
        ((BaseDaoEnabled)paramT).setDao(this);
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.create(localDatabaseConnection, paramT, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public T createIfNotExists(T paramT)
    throws SQLException
  {
    if (paramT == null)
      paramT = null;
    while (true)
    {
      return paramT;
      Object localObject = queryForSameId(paramT);
      if (localObject == null)
        int i = create(paramT);
      else
        paramT = localObject;
    }
  }

  public Dao.CreateOrUpdateStatus createOrUpdate(T paramT)
    throws SQLException
  {
    Dao.CreateOrUpdateStatus localCreateOrUpdateStatus;
    if (paramT == null)
      localCreateOrUpdateStatus = new Dao.CreateOrUpdateStatus(false, false, 0);
    while (true)
    {
      return localCreateOrUpdateStatus;
      Object localObject = extractId(paramT);
      if ((localObject == null) || (!idExists(localObject)))
      {
        int i = create(paramT);
        localCreateOrUpdateStatus = new Dao.CreateOrUpdateStatus(true, false, i);
      }
      else
      {
        int j = update(paramT);
        localCreateOrUpdateStatus = new Dao.CreateOrUpdateStatus(false, true, j);
      }
    }
  }

  public int delete(PreparedDelete<T> paramPreparedDelete)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.delete(localDatabaseConnection, paramPreparedDelete);
      int j = i;
      return j;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public int delete(T paramT)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if (paramT == null)
      i = 0;
    while (true)
    {
      return i;
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.delete(localDatabaseConnection, paramT, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public int delete(Collection<T> paramCollection)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if ((paramCollection == null) || (paramCollection.isEmpty()))
      i = 0;
    while (true)
    {
      return i;
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.deleteObjects(localDatabaseConnection, paramCollection, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public DeleteBuilder<T, ID> deleteBuilder()
  {
    checkForInitialized();
    DatabaseType localDatabaseType = this.databaseType;
    TableInfo localTableInfo = this.tableInfo;
    return new DeleteBuilder(localDatabaseType, localTableInfo, this);
  }

  public int deleteById(ID paramID)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if (paramID == null)
      i = 0;
    while (true)
    {
      return i;
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.deleteById(localDatabaseConnection, paramID, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public int deleteIds(Collection<ID> paramCollection)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if ((paramCollection == null) || (paramCollection.isEmpty()))
      i = 0;
    while (true)
    {
      return i;
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.deleteIds(localDatabaseConnection, paramCollection, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public void endThreadConnection(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    this.connectionSource.clearSpecialConnection(paramDatabaseConnection);
    this.connectionSource.releaseConnection(paramDatabaseConnection);
  }

  public int executeRaw(String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.executeRaw(localDatabaseConnection, paramString, paramArrayOfString);
      int j = i;
      return j;
    }
    catch (SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Could not run raw execute statement " + paramString, localSQLException);
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public ID extractId(T paramT)
    throws SQLException
  {
    checkForInitialized();
    FieldType localFieldType = this.tableInfo.getIdField();
    if (localFieldType == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Class ");
      Class localClass = this.dataClass;
      String str = localClass + " does not have an id field";
      throw new SQLException(str);
    }
    return localFieldType.extractJavaFieldValue(paramT);
  }

  public FieldType findForeignFieldType(Class<?> paramClass)
  {
    checkForInitialized();
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int i = arrayOfFieldType.length;
    int j = 0;
    FieldType localFieldType;
    if (j < i)
    {
      localFieldType = arrayOfFieldType[j];
      if (localFieldType.getType() != paramClass);
    }
    while (true)
    {
      return localFieldType;
      j += 1;
      break;
      localFieldType = null;
    }
  }

  public Class<T> getDataClass()
  {
    return this.dataClass;
  }

  public <FT> ForeignCollection<FT> getEmptyForeignCollection(String paramString)
    throws SQLException
  {
    checkForInitialized();
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int i = arrayOfFieldType.length;
    int j = 0;
    while (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      if (localFieldType.getColumnName().equals(paramString))
        return localFieldType.buildForeignCollection(null, null, true);
      j += 1;
    }
    String str = "Could not find a field named " + paramString;
    throw new IllegalArgumentException(str);
  }

  public ObjectCache getObjectCache()
  {
    return this.objectCache;
  }

  public GenericRowMapper<T> getSelectStarRowMapper()
    throws SQLException
  {
    return this.statementExecutor.getSelectStarRowMapper();
  }

  public DatabaseTableConfig<T> getTableConfig()
  {
    return this.tableConfig;
  }

  public TableInfo<T, ID> getTableInfo()
  {
    return this.tableInfo;
  }

  public CloseableWrappedIterable<T> getWrappedIterable()
  {
    checkForInitialized();
    CloseableIterable local2 = new CloseableIterable()
    {
      public CloseableIterator<T> closeableIterator()
      {
        try
        {
          CloseableIterator localCloseableIterator = BaseDaoImpl.this.createIterator(-1);
          return localCloseableIterator;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Could not build iterator for ");
          Class localClass = BaseDaoImpl.this.dataClass;
          String str = localClass;
          throw new IllegalStateException(str, localException);
        }
      }

      public Iterator<T> iterator()
      {
        return closeableIterator();
      }
    };
    return new CloseableWrappedIterableImpl(local2);
  }

  public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> paramPreparedQuery)
  {
    checkForInitialized();
    CloseableIterable local3 = new CloseableIterable()
    {
      public CloseableIterator<T> closeableIterator()
      {
        try
        {
          BaseDaoImpl localBaseDaoImpl = BaseDaoImpl.this;
          PreparedQuery localPreparedQuery = paramPreparedQuery;
          CloseableIterator localCloseableIterator = localBaseDaoImpl.createIterator(localPreparedQuery, -1);
          return localCloseableIterator;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Could not build prepared-query iterator for ");
          Class localClass = BaseDaoImpl.this.dataClass;
          String str = localClass;
          throw new IllegalStateException(str, localException);
        }
      }

      public Iterator<T> iterator()
      {
        return closeableIterator();
      }
    };
    return new CloseableWrappedIterableImpl(local3);
  }

  public boolean idExists(ID paramID)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      boolean bool1 = this.statementExecutor.ifExists(localDatabaseConnection, paramID);
      boolean bool2 = bool1;
      return bool2;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public void initialize()
    throws SQLException
  {
    if (this.initialized)
      return;
    if (this.connectionSource == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("connectionSource was never set on ");
      String str1 = getClass().getSimpleName();
      String str2 = str1;
      throw new IllegalStateException(str2);
    }
    DatabaseType localDatabaseType1 = this.connectionSource.getDatabaseType();
    this.databaseType = localDatabaseType1;
    if (this.databaseType == null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append("connectionSource is getting a null DatabaseType in ");
      String str3 = getClass().getSimpleName();
      String str4 = str3;
      throw new IllegalStateException(str4);
    }
    TableInfo localTableInfo1;
    if (this.tableConfig == null)
    {
      ConnectionSource localConnectionSource1 = this.connectionSource;
      Class localClass1 = this.dataClass;
      localTableInfo1 = new TableInfo(localConnectionSource1, this, localClass1);
    }
    DaoConfigArray localDaoConfigArray;
    TableInfo localTableInfo3;
    for (this.tableInfo = localTableInfo1; ; this.tableInfo = localTableInfo3)
    {
      DatabaseType localDatabaseType2 = this.databaseType;
      TableInfo localTableInfo2 = this.tableInfo;
      StatementExecutor localStatementExecutor = new StatementExecutor(localDatabaseType2, localTableInfo2, this);
      this.statementExecutor = localStatementExecutor;
      localDaoConfigArray = (DaoConfigArray)daoConfigLevelLocal.get();
      if (localDaoConfigArray.size() <= 0)
        break;
      localDaoConfigArray.addDao(this);
      return;
      DatabaseTableConfig localDatabaseTableConfig1 = this.tableConfig;
      ConnectionSource localConnectionSource2 = this.connectionSource;
      localDatabaseTableConfig1.extractFieldTypes(localConnectionSource2);
      DatabaseType localDatabaseType3 = this.databaseType;
      DatabaseTableConfig localDatabaseTableConfig2 = this.tableConfig;
      localTableInfo3 = new TableInfo(localDatabaseType3, this, localDatabaseTableConfig2);
    }
    localDaoConfigArray.addDao(this);
    int i = 0;
    while (true)
    {
      BaseDaoImpl localBaseDaoImpl;
      try
      {
        int j = localDaoConfigArray.size();
        if (i >= j)
          break;
        localBaseDaoImpl = localDaoConfigArray.get(i);
        DaoManager.registerDao(this.connectionSource, localBaseDaoImpl);
        try
        {
          FieldType[] arrayOfFieldType = localBaseDaoImpl.getTableInfo().getFieldTypes();
          int k = arrayOfFieldType.length;
          int m = 0;
          if (m < k)
          {
            FieldType localFieldType = arrayOfFieldType[m];
            ConnectionSource localConnectionSource3 = this.connectionSource;
            Class localClass2 = localBaseDaoImpl.getDataClass();
            localFieldType.configDaoInformation(localConnectionSource3, localClass2);
            m += 1;
            continue;
          }
        }
        catch (SQLException localSQLException)
        {
          DaoManager.unregisterDao(this.connectionSource, localBaseDaoImpl);
          throw localSQLException;
        }
      }
      finally
      {
        localDaoConfigArray.clear();
      }
      boolean bool = true;
      localBaseDaoImpl.initialized = bool;
      i += 1;
    }
    localDaoConfigArray.clear();
  }

  public boolean isAutoCommit()
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      boolean bool1 = isAutoCommit(localDatabaseConnection);
      boolean bool2 = bool1;
      return bool2;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public boolean isAutoCommit(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    return paramDatabaseConnection.isAutoCommit();
  }

  public boolean isTableExists()
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      String str = this.tableInfo.getTableName();
      boolean bool1 = localDatabaseConnection.isTableExists(str);
      boolean bool2 = bool1;
      return bool2;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public boolean isUpdatable()
  {
    return this.tableInfo.isUpdatable();
  }

  public CloseableIterator<T> iterator()
  {
    return iterator(-1);
  }

  public CloseableIterator<T> iterator(int paramInt)
  {
    checkForInitialized();
    CloseableIterator localCloseableIterator = createIterator(paramInt);
    this.lastIterator = localCloseableIterator;
    return this.lastIterator;
  }

  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    return iterator(paramPreparedQuery, -1);
  }

  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery, int paramInt)
    throws SQLException
  {
    checkForInitialized();
    CloseableIterator localCloseableIterator = createIterator(paramPreparedQuery, paramInt);
    this.lastIterator = localCloseableIterator;
    return this.lastIterator;
  }

  public T mapSelectStarRow(DatabaseResults paramDatabaseResults)
    throws SQLException
  {
    return this.statementExecutor.getSelectStarRowMapper().mapRow(paramDatabaseResults);
  }

  public String objectToString(T paramT)
  {
    checkForInitialized();
    return this.tableInfo.objectToString(paramT);
  }

  public boolean objectsEqual(T paramT1, T paramT2)
    throws SQLException
  {
    checkForInitialized();
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int i = arrayOfFieldType.length;
    int j = 0;
    if (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      Object localObject1 = localFieldType.extractJavaFieldValue(paramT1);
      Object localObject2 = localFieldType.extractJavaFieldValue(paramT2);
      if (localFieldType.getDataPersister().dataIsEqual(localObject1, localObject2));
    }
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      j += 1;
      break;
    }
  }

  public List<T> query(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    checkForInitialized();
    StatementExecutor localStatementExecutor = this.statementExecutor;
    ConnectionSource localConnectionSource = this.connectionSource;
    ObjectCache localObjectCache = this.objectCache;
    return localStatementExecutor.query(localConnectionSource, paramPreparedQuery, localObjectCache);
  }

  public QueryBuilder<T, ID> queryBuilder()
  {
    checkForInitialized();
    DatabaseType localDatabaseType = this.databaseType;
    TableInfo localTableInfo = this.tableInfo;
    return new QueryBuilder(localDatabaseType, localTableInfo, this);
  }

  public List<T> queryForAll()
    throws SQLException
  {
    checkForInitialized();
    StatementExecutor localStatementExecutor = this.statementExecutor;
    ConnectionSource localConnectionSource = this.connectionSource;
    ObjectCache localObjectCache = this.objectCache;
    return localStatementExecutor.queryForAll(localConnectionSource, localObjectCache);
  }

  public List<T> queryForEq(String paramString, Object paramObject)
    throws SQLException
  {
    return queryBuilder().where().eq(paramString, paramObject).query();
  }

  public List<T> queryForFieldValues(Map<String, Object> paramMap)
    throws SQLException
  {
    return queryForFieldValues(paramMap, false);
  }

  public List<T> queryForFieldValuesArgs(Map<String, Object> paramMap)
    throws SQLException
  {
    return queryForFieldValues(paramMap, true);
  }

  public T queryForFirst(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      StatementExecutor localStatementExecutor = this.statementExecutor;
      ObjectCache localObjectCache = this.objectCache;
      Object localObject1 = localStatementExecutor.queryForFirst(localDatabaseConnection, paramPreparedQuery, localObjectCache);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public T queryForId(ID paramID)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      StatementExecutor localStatementExecutor = this.statementExecutor;
      ObjectCache localObjectCache = this.objectCache;
      Object localObject1 = localStatementExecutor.queryForId(localDatabaseConnection, paramID, localObjectCache);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public List<T> queryForMatching(T paramT)
    throws SQLException
  {
    return queryForMatching(paramT, false);
  }

  public List<T> queryForMatchingArgs(T paramT)
    throws SQLException
  {
    return queryForMatching(paramT, true);
  }

  public T queryForSameId(T paramT)
    throws SQLException
  {
    Object localObject1 = null;
    checkForInitialized();
    if (paramT == null);
    while (true)
    {
      return localObject1;
      Object localObject2 = extractId(paramT);
      if (localObject2 != null)
        localObject1 = queryForId(localObject2);
    }
  }

  public <GR> GenericRawResults<GR> queryRaw(String paramString, RawRowMapper<GR> paramRawRowMapper, String[] paramArrayOfString)
    throws SQLException
  {
    checkForInitialized();
    try
    {
      StatementExecutor localStatementExecutor = this.statementExecutor;
      ConnectionSource localConnectionSource = this.connectionSource;
      ObjectCache localObjectCache = this.objectCache;
      String str = paramString;
      RawRowMapper<GR> localRawRowMapper = paramRawRowMapper;
      String[] arrayOfString = paramArrayOfString;
      GenericRawResults localGenericRawResults = localStatementExecutor.queryRaw(localConnectionSource, str, localRawRowMapper, arrayOfString, localObjectCache);
      return localGenericRawResults;
    }
    catch (SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Could not build iterator for " + paramString, localSQLException);
    }
  }

  public GenericRawResults<Object[]> queryRaw(String paramString, DataType[] paramArrayOfDataType, String[] paramArrayOfString)
    throws SQLException
  {
    checkForInitialized();
    try
    {
      StatementExecutor localStatementExecutor = this.statementExecutor;
      ConnectionSource localConnectionSource = this.connectionSource;
      ObjectCache localObjectCache = this.objectCache;
      String str = paramString;
      DataType[] arrayOfDataType = paramArrayOfDataType;
      String[] arrayOfString = paramArrayOfString;
      GenericRawResults localGenericRawResults = localStatementExecutor.queryRaw(localConnectionSource, str, arrayOfDataType, arrayOfString, localObjectCache);
      return localGenericRawResults;
    }
    catch (SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Could not build iterator for " + paramString, localSQLException);
    }
  }

  public GenericRawResults<String[]> queryRaw(String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    checkForInitialized();
    try
    {
      StatementExecutor localStatementExecutor = this.statementExecutor;
      ConnectionSource localConnectionSource = this.connectionSource;
      ObjectCache localObjectCache = this.objectCache;
      GenericRawResults localGenericRawResults = localStatementExecutor.queryRaw(localConnectionSource, paramString, paramArrayOfString, localObjectCache);
      return localGenericRawResults;
    }
    catch (SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Could not build iterator for " + paramString, localSQLException);
    }
  }

  public int refresh(T paramT)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if (paramT == null)
      i = 0;
    while (true)
    {
      return i;
      if ((paramT instanceof BaseDaoEnabled))
        ((BaseDaoEnabled)paramT).setDao(this);
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.refresh(localDatabaseConnection, paramT, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public void rollBack(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    paramDatabaseConnection.rollback(null);
  }

  public void setAutoCommit(DatabaseConnection paramDatabaseConnection, boolean paramBoolean)
    throws SQLException
  {
    paramDatabaseConnection.setAutoCommit(paramBoolean);
  }

  public void setAutoCommit(boolean paramBoolean)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      setAutoCommit(localDatabaseConnection, paramBoolean);
      return;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public void setConnectionSource(ConnectionSource paramConnectionSource)
  {
    this.connectionSource = paramConnectionSource;
  }

  public void setObjectCache(ObjectCache paramObjectCache)
    throws SQLException
  {
    if (paramObjectCache == null)
    {
      if (this.objectCache == null)
        return;
      ObjectCache localObjectCache1 = this.objectCache;
      Class localClass1 = this.dataClass;
      localObjectCache1.clear(localClass1);
      this.objectCache = null;
      return;
    }
    if ((this.objectCache != null) && (this.objectCache != paramObjectCache))
    {
      ObjectCache localObjectCache2 = this.objectCache;
      Class localClass2 = this.dataClass;
      localObjectCache2.clear(localClass2);
    }
    if (this.tableInfo.getIdField() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Class ");
      Class localClass3 = this.dataClass;
      String str = localClass3 + " must have an id field to enable the object cache";
      throw new SQLException(str);
    }
    this.objectCache = paramObjectCache;
    ObjectCache localObjectCache3 = this.objectCache;
    Class localClass4 = this.dataClass;
    localObjectCache3.registerClass(localClass4);
  }

  public void setObjectCache(boolean paramBoolean)
    throws SQLException
  {
    if (paramBoolean)
    {
      if (this.objectCache != null)
        return;
      if (this.tableInfo.getIdField() == null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Class ");
        Class localClass1 = this.dataClass;
        String str = localClass1 + " must have an id field to enable the object cache";
        throw new SQLException(str);
      }
      synchronized (getClass())
      {
        if (defaultObjectCache == null)
          defaultObjectCache = ReferenceObjectCache.makeWeakCache();
        ReferenceObjectCache localReferenceObjectCache = defaultObjectCache;
        this.objectCache = localReferenceObjectCache;
        ObjectCache localObjectCache1 = this.objectCache;
        Class localClass3 = this.dataClass;
        localObjectCache1.registerClass(localClass3);
        return;
      }
    }
    if (this.objectCache == null)
      return;
    ObjectCache localObjectCache2 = this.objectCache;
    Class localClass4 = this.dataClass;
    localObjectCache2.clear(localClass4);
    this.objectCache = null;
  }

  public void setTableConfig(DatabaseTableConfig<T> paramDatabaseTableConfig)
  {
    this.tableConfig = paramDatabaseTableConfig;
  }

  public DatabaseConnection startThreadConnection()
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    boolean bool = this.connectionSource.saveSpecialConnection(localDatabaseConnection);
    return localDatabaseConnection;
  }

  public int update(PreparedUpdate<T> paramPreparedUpdate)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.update(localDatabaseConnection, paramPreparedUpdate);
      int j = i;
      return j;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public int update(T paramT)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if (paramT == null)
      i = 0;
    while (true)
    {
      return i;
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.update(localDatabaseConnection, paramT, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public UpdateBuilder<T, ID> updateBuilder()
  {
    checkForInitialized();
    DatabaseType localDatabaseType = this.databaseType;
    TableInfo localTableInfo = this.tableInfo;
    return new UpdateBuilder(localDatabaseType, localTableInfo, this);
  }

  public int updateId(T paramT, ID paramID)
    throws SQLException
  {
    checkForInitialized();
    int i;
    if (paramT == null)
      i = 0;
    while (true)
    {
      return i;
      DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
      try
      {
        StatementExecutor localStatementExecutor = this.statementExecutor;
        ObjectCache localObjectCache = this.objectCache;
        int j = localStatementExecutor.updateId(localDatabaseConnection, paramT, paramID, localObjectCache);
        i = j;
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
      finally
      {
        this.connectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public int updateRaw(String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.updateRaw(localDatabaseConnection, paramString, paramArrayOfString);
      int j = i;
      return j;
    }
    catch (SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Could not run raw update statement " + paramString, localSQLException);
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  private static class DaoConfigArray
  {
    private BaseDaoImpl<?, ?>[] daoArray;
    private int daoArrayC;

    private DaoConfigArray()
    {
      BaseDaoImpl[] arrayOfBaseDaoImpl = new BaseDaoImpl[10];
      this.daoArray = arrayOfBaseDaoImpl;
      this.daoArrayC = 0;
    }

    public void addDao(BaseDaoImpl<?, ?> paramBaseDaoImpl)
    {
      int i = this.daoArrayC;
      int j = this.daoArray.length;
      if (i != j)
      {
        BaseDaoImpl[] arrayOfBaseDaoImpl1 = new BaseDaoImpl[this.daoArray.length * 2];
        int k = 0;
        while (true)
        {
          int m = this.daoArray.length;
          if (k >= m)
            break;
          BaseDaoImpl localBaseDaoImpl = this.daoArray[k];
          arrayOfBaseDaoImpl1[k] = localBaseDaoImpl;
          this.daoArray[k] = null;
          k += 1;
        }
        this.daoArray = arrayOfBaseDaoImpl1;
      }
      BaseDaoImpl[] arrayOfBaseDaoImpl2 = this.daoArray;
      int n = this.daoArrayC;
      int i1 = n + 1;
      this.daoArrayC = i1;
      arrayOfBaseDaoImpl2[n] = paramBaseDaoImpl;
    }

    public void clear()
    {
      int i = 0;
      while (true)
      {
        int j = this.daoArrayC;
        if (i >= j)
          break;
        this.daoArray[i] = null;
        i += 1;
      }
      this.daoArrayC = 0;
    }

    public BaseDaoImpl<?, ?> get(int paramInt)
    {
      return this.daoArray[paramInt];
    }

    public int size()
    {
      return this.daoArrayC;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.BaseDaoImpl
 * JD-Core Version:    0.6.2
 */