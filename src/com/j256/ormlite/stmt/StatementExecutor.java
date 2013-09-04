package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StatementExecutor<T, ID>
  implements GenericRowMapper<String[]>
{
  private static Logger logger = LoggerFactory.getLogger(StatementExecutor.class);
  private static final FieldType[] noFieldTypes = new FieldType[0];
  private String countStarQuery = null;
  private final Dao<T, ID> dao;
  private final DatabaseType databaseType;
  private FieldType[] ifExistsFieldTypes = null;
  private String ifExistsQuery = null;
  private MappedDelete<T, ID> mappedDelete;
  private MappedCreate<T, ID> mappedInsert;
  private MappedQueryForId<T, ID> mappedQueryForId;
  private MappedRefresh<T, ID> mappedRefresh;
  private MappedUpdate<T, ID> mappedUpdate;
  private MappedUpdateId<T, ID> mappedUpdateId;
  private PreparedQuery<T> preparedQueryForAll;
  private final TableInfo<T, ID> tableInfo;

  public StatementExecutor(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    this.databaseType = paramDatabaseType;
    this.tableInfo = paramTableInfo;
    this.dao = paramDao;
  }

  private void assignStatementArguments(CompiledStatement paramCompiledStatement, String[] paramArrayOfString)
    throws SQLException
  {
    int i = 0;
    while (true)
    {
      int j = paramArrayOfString.length;
      if (i >= j)
        return;
      String str = paramArrayOfString[i];
      SqlType localSqlType = SqlType.STRING;
      paramCompiledStatement.setObject(i, str, localSqlType);
      i += 1;
    }
  }

  private String[] extractColumnNames(CompiledStatement paramCompiledStatement)
    throws SQLException
  {
    int i = paramCompiledStatement.getColumnCount();
    String[] arrayOfString = new String[i];
    int j = 0;
    while (j < i)
    {
      String str = paramCompiledStatement.getColumnName(j);
      arrayOfString[j] = str;
      j += 1;
    }
    return arrayOfString;
  }

  private void prepareQueryForAll()
    throws SQLException
  {
    if (this.preparedQueryForAll != null)
      return;
    DatabaseType localDatabaseType = this.databaseType;
    TableInfo localTableInfo = this.tableInfo;
    Dao localDao = this.dao;
    PreparedQuery localPreparedQuery = new QueryBuilder(localDatabaseType, localTableInfo, localDao).prepare();
    this.preparedQueryForAll = localPreparedQuery;
  }

  public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> paramBaseDaoImpl, ConnectionSource paramConnectionSource, int paramInt, ObjectCache paramObjectCache)
    throws SQLException
  {
    prepareQueryForAll();
    PreparedQuery localPreparedQuery = this.preparedQueryForAll;
    StatementExecutor localStatementExecutor = this;
    BaseDaoImpl<T, ID> localBaseDaoImpl = paramBaseDaoImpl;
    ConnectionSource localConnectionSource = paramConnectionSource;
    ObjectCache localObjectCache = paramObjectCache;
    int i = paramInt;
    return localStatementExecutor.buildIterator(localBaseDaoImpl, localConnectionSource, localPreparedQuery, localObjectCache, i);
  }

  public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> paramBaseDaoImpl, ConnectionSource paramConnectionSource, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache, int paramInt)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection1 = paramConnectionSource.getReadOnlyConnection();
    try
    {
      StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.SELECT;
      localCompiledStatement = paramPreparedStmt.compile(localDatabaseConnection1, localStatementType, paramInt);
      Class localClass = this.tableInfo.getDataClass();
      String str = paramPreparedStmt.getStatement();
      BaseDaoImpl<T, ID> localBaseDaoImpl = paramBaseDaoImpl;
      PreparedStmt<T> localPreparedStmt = paramPreparedStmt;
      ConnectionSource localConnectionSource = paramConnectionSource;
      ObjectCache localObjectCache = paramObjectCache;
      SelectIterator localSelectIterator = new SelectIterator(localClass, localBaseDaoImpl, localPreparedStmt, localConnectionSource, localDatabaseConnection1, localCompiledStatement, str, localObjectCache);
      DatabaseConnection localDatabaseConnection2 = null;
      Object localObject1 = null;
      return localSelectIterator;
    }
    finally
    {
      CompiledStatement localCompiledStatement;
      if (localCompiledStatement != null)
        localCompiledStatement.close();
      if (localDatabaseConnection1 != null)
        paramConnectionSource.releaseConnection(localDatabaseConnection1);
    }
  }

  // ERROR //
  public <CT> CT callBatchTasks(DatabaseConnection paramDatabaseConnection, boolean paramBoolean, java.util.concurrent.Callable<CT> paramCallable)
    throws SQLException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/j256/ormlite/stmt/StatementExecutor:databaseType	Lcom/j256/ormlite/db/DatabaseType;
    //   4: invokeinterface 177 1 0
    //   9: ifeq +22 -> 31
    //   12: aload_0
    //   13: getfield 77	com/j256/ormlite/stmt/StatementExecutor:databaseType	Lcom/j256/ormlite/db/DatabaseType;
    //   16: astore 4
    //   18: aload_1
    //   19: iload_2
    //   20: aload 4
    //   22: aload_3
    //   23: invokestatic 183	com/j256/ormlite/misc/TransactionManager:callInTransaction	(Lcom/j256/ormlite/support/DatabaseConnection;ZLcom/j256/ormlite/db/DatabaseType;Ljava/util/concurrent/Callable;)Ljava/lang/Object;
    //   26: astore 5
    //   28: aload 5
    //   30: areturn
    //   31: iconst_0
    //   32: istore 6
    //   34: aload_1
    //   35: invokeinterface 188 1 0
    //   40: ifeq +46 -> 86
    //   43: aload_1
    //   44: invokeinterface 191 1 0
    //   49: istore 6
    //   51: iload 6
    //   53: ifeq +33 -> 86
    //   56: aload_1
    //   57: iconst_0
    //   58: invokeinterface 195 2 0
    //   63: getstatic 61	com/j256/ormlite/stmt/StatementExecutor:logger	Lcom/j256/ormlite/logger/Logger;
    //   66: astore 7
    //   68: aload_0
    //   69: getfield 79	com/j256/ormlite/stmt/StatementExecutor:tableInfo	Lcom/j256/ormlite/table/TableInfo;
    //   72: invokevirtual 198	com/j256/ormlite/table/TableInfo:getTableName	()Ljava/lang/String;
    //   75: astore 8
    //   77: aload 7
    //   79: ldc 200
    //   81: aload 8
    //   83: invokevirtual 206	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokeinterface 212 1 0
    //   92: astore 9
    //   94: aload 9
    //   96: astore 5
    //   98: iload 6
    //   100: ifeq -72 -> 28
    //   103: aload_1
    //   104: iconst_1
    //   105: invokeinterface 195 2 0
    //   110: getstatic 61	com/j256/ormlite/stmt/StatementExecutor:logger	Lcom/j256/ormlite/logger/Logger;
    //   113: astore 10
    //   115: aload_0
    //   116: getfield 79	com/j256/ormlite/stmt/StatementExecutor:tableInfo	Lcom/j256/ormlite/table/TableInfo;
    //   119: invokevirtual 198	com/j256/ormlite/table/TableInfo:getTableName	()Ljava/lang/String;
    //   122: astore 11
    //   124: aload 10
    //   126: ldc 214
    //   128: aload 11
    //   130: invokevirtual 206	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   133: goto -105 -> 28
    //   136: astore 12
    //   138: aload 12
    //   140: athrow
    //   141: astore 13
    //   143: iload 6
    //   145: ifeq +33 -> 178
    //   148: aload_1
    //   149: iconst_1
    //   150: invokeinterface 195 2 0
    //   155: getstatic 61	com/j256/ormlite/stmt/StatementExecutor:logger	Lcom/j256/ormlite/logger/Logger;
    //   158: astore 14
    //   160: aload_0
    //   161: getfield 79	com/j256/ormlite/stmt/StatementExecutor:tableInfo	Lcom/j256/ormlite/table/TableInfo;
    //   164: invokevirtual 198	com/j256/ormlite/table/TableInfo:getTableName	()Ljava/lang/String;
    //   167: astore 15
    //   169: aload 14
    //   171: ldc 214
    //   173: aload 15
    //   175: invokevirtual 206	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   178: aload 13
    //   180: athrow
    //   181: astore 12
    //   183: ldc 216
    //   185: aload 12
    //   187: invokestatic 222	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   190: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   86	94	136	java/sql/SQLException
    //   34	86	141	finally
    //   86	94	141	finally
    //   138	141	141	finally
    //   183	191	141	finally
    //   86	94	181	java/lang/Exception
  }

  public int create(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedInsert == null)
    {
      DatabaseType localDatabaseType1 = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      MappedCreate localMappedCreate1 = MappedCreate.build(localDatabaseType1, localTableInfo);
      this.mappedInsert = localMappedCreate1;
    }
    MappedCreate localMappedCreate2 = this.mappedInsert;
    DatabaseType localDatabaseType2 = this.databaseType;
    return localMappedCreate2.insert(localDatabaseType2, paramDatabaseConnection, paramT, paramObjectCache);
  }

  public int delete(DatabaseConnection paramDatabaseConnection, PreparedDelete<T> paramPreparedDelete)
    throws SQLException
  {
    StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.DELETE;
    CompiledStatement localCompiledStatement = paramPreparedDelete.compile(paramDatabaseConnection, localStatementType);
    try
    {
      int i = localCompiledStatement.runUpdate();
      int j = i;
      return j;
    }
    finally
    {
      localCompiledStatement.close();
    }
  }

  public int delete(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedDelete == null)
    {
      DatabaseType localDatabaseType = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      MappedDelete localMappedDelete = MappedDelete.build(localDatabaseType, localTableInfo);
      this.mappedDelete = localMappedDelete;
    }
    return this.mappedDelete.delete(paramDatabaseConnection, paramT, paramObjectCache);
  }

  public int deleteById(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedDelete == null)
    {
      DatabaseType localDatabaseType = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      MappedDelete localMappedDelete = MappedDelete.build(localDatabaseType, localTableInfo);
      this.mappedDelete = localMappedDelete;
    }
    return this.mappedDelete.deleteById(paramDatabaseConnection, paramID, paramObjectCache);
  }

  public int deleteIds(DatabaseConnection paramDatabaseConnection, Collection<ID> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    DatabaseType localDatabaseType = this.databaseType;
    TableInfo localTableInfo = this.tableInfo;
    return MappedDeleteCollection.deleteIds(localDatabaseType, localTableInfo, paramDatabaseConnection, paramCollection, paramObjectCache);
  }

  public int deleteObjects(DatabaseConnection paramDatabaseConnection, Collection<T> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    DatabaseType localDatabaseType = this.databaseType;
    TableInfo localTableInfo = this.tableInfo;
    return MappedDeleteCollection.deleteObjects(localDatabaseType, localTableInfo, paramDatabaseConnection, paramCollection, paramObjectCache);
  }

  public int executeRaw(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    logger.debug("running raw execute statement: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("execute arguments: {}", paramArrayOfString);
    StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.EXECUTE;
    FieldType[] arrayOfFieldType = noFieldTypes;
    CompiledStatement localCompiledStatement = paramDatabaseConnection.compileStatement(paramString, localStatementType, arrayOfFieldType);
    try
    {
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      int i = localCompiledStatement.runExecute();
      int j = i;
      return j;
    }
    finally
    {
      localCompiledStatement.close();
    }
  }

  public GenericRowMapper<T> getSelectStarRowMapper()
    throws SQLException
  {
    prepareQueryForAll();
    return this.preparedQueryForAll;
  }

  public boolean ifExists(DatabaseConnection paramDatabaseConnection, ID paramID)
    throws SQLException
  {
    boolean bool = true;
    if (this.ifExistsQuery == null)
    {
      DatabaseType localDatabaseType = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      Dao localDao = this.dao;
      QueryBuilder localQueryBuilder1 = new QueryBuilder(localDatabaseType, localTableInfo, localDao);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "COUNT(*)";
      QueryBuilder localQueryBuilder2 = localQueryBuilder1.selectRaw(arrayOfString);
      Where localWhere1 = localQueryBuilder1.where();
      String str1 = this.tableInfo.getIdField().getColumnName();
      SelectArg localSelectArg = new SelectArg();
      Where localWhere2 = localWhere1.eq(str1, localSelectArg);
      String str2 = localQueryBuilder1.prepareStatementString();
      this.ifExistsQuery = str2;
      FieldType[] arrayOfFieldType1 = new FieldType[1];
      FieldType localFieldType = this.tableInfo.getIdField();
      arrayOfFieldType1[0] = localFieldType;
      this.ifExistsFieldTypes = arrayOfFieldType1;
    }
    String str3 = this.ifExistsQuery;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramID;
    FieldType[] arrayOfFieldType2 = this.ifExistsFieldTypes;
    long l = paramDatabaseConnection.queryForLong(str3, arrayOfObject, arrayOfFieldType2);
    Logger localLogger = logger;
    String str4 = this.ifExistsQuery;
    Long localLong = Long.valueOf(l);
    localLogger.debug("query of '{}' returned {}", str4, localLong);
    if (l != 0L);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public String[] mapRow(DatabaseResults paramDatabaseResults)
    throws SQLException
  {
    int i = paramDatabaseResults.getColumnCount();
    String[] arrayOfString = new String[i];
    int j = 0;
    while (j < i)
    {
      String str = paramDatabaseResults.getString(j);
      arrayOfString[j] = str;
      j += 1;
    }
    return arrayOfString;
  }

  public List<T> query(ConnectionSource paramConnectionSource, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache)
    throws SQLException
  {
    StatementExecutor localStatementExecutor = this;
    ConnectionSource localConnectionSource = paramConnectionSource;
    PreparedStmt<T> localPreparedStmt = paramPreparedStmt;
    ObjectCache localObjectCache = paramObjectCache;
    SelectIterator localSelectIterator = localStatementExecutor.buildIterator(null, localConnectionSource, localPreparedStmt, localObjectCache, -1);
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      while (localSelectIterator.hasNextThrow())
      {
        Object localObject1 = localSelectIterator.nextThrow();
        boolean bool = localArrayList.add(localObject1);
      }
    }
    finally
    {
      localSelectIterator.close();
    }
    Logger localLogger = logger;
    String str = paramPreparedStmt.getStatement();
    Integer localInteger = Integer.valueOf(localArrayList.size());
    localLogger.debug("query of '{}' returned {} results", str, localInteger);
    localSelectIterator.close();
    return localArrayList;
  }

  public List<T> queryForAll(ConnectionSource paramConnectionSource, ObjectCache paramObjectCache)
    throws SQLException
  {
    prepareQueryForAll();
    PreparedQuery localPreparedQuery = this.preparedQueryForAll;
    return query(paramConnectionSource, localPreparedQuery, paramObjectCache);
  }

  public long queryForCountStar(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    if (this.countStarQuery == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder(64);
      StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT COUNT(*) FROM ");
      DatabaseType localDatabaseType = this.databaseType;
      String str1 = this.tableInfo.getTableName();
      localDatabaseType.appendEscapedEntityName(localStringBuilder1, str1);
      String str2 = localStringBuilder1.toString();
      this.countStarQuery = str2;
    }
    String str3 = this.countStarQuery;
    long l = paramDatabaseConnection.queryForLong(str3);
    Logger localLogger = logger;
    String str4 = this.countStarQuery;
    Long localLong = Long.valueOf(l);
    localLogger.debug("query of '{}' returned {}", str4, localLong);
    return l;
  }

  public long queryForCountStar(DatabaseConnection paramDatabaseConnection, PreparedStmt<T> paramPreparedStmt)
    throws SQLException
  {
    StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.SELECT_LONG;
    CompiledStatement localCompiledStatement = paramPreparedStmt.compile(paramDatabaseConnection, localStatementType);
    try
    {
      DatabaseResults localDatabaseResults = localCompiledStatement.runQuery(null);
      if (localDatabaseResults.first())
      {
        long l1 = localDatabaseResults.getLong(0);
        l2 = l1;
        return l2;
      }
      long l2 = 0L;
      localCompiledStatement.close();
    }
    finally
    {
      localCompiledStatement.close();
    }
  }

  public T queryForFirst(DatabaseConnection paramDatabaseConnection, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache)
    throws SQLException
  {
    StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.SELECT;
    CompiledStatement localCompiledStatement = paramPreparedStmt.compile(paramDatabaseConnection, localStatementType);
    try
    {
      DatabaseResults localDatabaseResults = localCompiledStatement.runQuery(paramObjectCache);
      Object localObject2;
      if (localDatabaseResults.first())
      {
        Logger localLogger1 = logger;
        String str1 = paramPreparedStmt.getStatement();
        localLogger1.debug("query-for-first of '{}' returned at least 1 result", str1);
        Object localObject1 = paramPreparedStmt.mapRow(localDatabaseResults);
        localObject2 = localObject1;
      }
      while (true)
      {
        return localObject2;
        Logger localLogger2 = logger;
        String str2 = paramPreparedStmt.getStatement();
        localLogger2.debug("query-for-first of '{}' returned at 0 results", str2);
        localObject2 = null;
        localCompiledStatement.close();
      }
    }
    finally
    {
      localCompiledStatement.close();
    }
  }

  public T queryForId(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedQueryForId == null)
    {
      DatabaseType localDatabaseType = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      MappedQueryForId localMappedQueryForId = MappedQueryForId.build(localDatabaseType, localTableInfo, null);
      this.mappedQueryForId = localMappedQueryForId;
    }
    return this.mappedQueryForId.execute(paramDatabaseConnection, paramID, paramObjectCache);
  }

  public <UO> GenericRawResults<UO> queryRaw(ConnectionSource paramConnectionSource, String paramString, RawRowMapper<UO> paramRawRowMapper, String[] paramArrayOfString, ObjectCache paramObjectCache)
    throws SQLException
  {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString);
    DatabaseConnection localDatabaseConnection1 = paramConnectionSource.getReadOnlyConnection();
    try
    {
      StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.SELECT;
      FieldType[] arrayOfFieldType = noFieldTypes;
      localCompiledStatement = localDatabaseConnection1.compileStatement(paramString, localStatementType, arrayOfFieldType);
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      String[] arrayOfString = extractColumnNames(localCompiledStatement);
      UserObjectRowMapper localUserObjectRowMapper = new UserObjectRowMapper(paramRawRowMapper, arrayOfString, this);
      ConnectionSource localConnectionSource = paramConnectionSource;
      String str = paramString;
      ObjectCache localObjectCache = paramObjectCache;
      RawResultsImpl localRawResultsImpl = new RawResultsImpl(localConnectionSource, localDatabaseConnection1, str, [Ljava.lang.String.class, localCompiledStatement, arrayOfString, localUserObjectRowMapper, localObjectCache);
      Object localObject1 = null;
      DatabaseConnection localDatabaseConnection2 = null;
      return localRawResultsImpl;
    }
    finally
    {
      CompiledStatement localCompiledStatement;
      if (localCompiledStatement != null)
        localCompiledStatement.close();
      if (localDatabaseConnection1 != null)
        paramConnectionSource.releaseConnection(localDatabaseConnection1);
    }
  }

  public GenericRawResults<Object[]> queryRaw(ConnectionSource paramConnectionSource, String paramString, DataType[] paramArrayOfDataType, String[] paramArrayOfString, ObjectCache paramObjectCache)
    throws SQLException
  {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString);
    DatabaseConnection localDatabaseConnection1 = paramConnectionSource.getReadOnlyConnection();
    try
    {
      StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.SELECT;
      FieldType[] arrayOfFieldType = noFieldTypes;
      localCompiledStatement = localDatabaseConnection1.compileStatement(paramString, localStatementType, arrayOfFieldType);
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      String[] arrayOfString = extractColumnNames(localCompiledStatement);
      ObjectArrayRowMapper localObjectArrayRowMapper = new ObjectArrayRowMapper(paramArrayOfDataType);
      ConnectionSource localConnectionSource = paramConnectionSource;
      String str = paramString;
      ObjectCache localObjectCache = paramObjectCache;
      RawResultsImpl localRawResultsImpl = new RawResultsImpl(localConnectionSource, localDatabaseConnection1, str, [Ljava.lang.Object.class, localCompiledStatement, arrayOfString, localObjectArrayRowMapper, localObjectCache);
      Object localObject1 = null;
      DatabaseConnection localDatabaseConnection2 = null;
      return localRawResultsImpl;
    }
    finally
    {
      CompiledStatement localCompiledStatement;
      if (localCompiledStatement != null)
        localCompiledStatement.close();
      if (localDatabaseConnection1 != null)
        paramConnectionSource.releaseConnection(localDatabaseConnection1);
    }
  }

  public GenericRawResults<String[]> queryRaw(ConnectionSource paramConnectionSource, String paramString, String[] paramArrayOfString, ObjectCache paramObjectCache)
    throws SQLException
  {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString);
    DatabaseConnection localDatabaseConnection1 = paramConnectionSource.getReadOnlyConnection();
    try
    {
      StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.SELECT;
      FieldType[] arrayOfFieldType = noFieldTypes;
      localCompiledStatement = localDatabaseConnection1.compileStatement(paramString, localStatementType, arrayOfFieldType);
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      String[] arrayOfString = extractColumnNames(localCompiledStatement);
      ConnectionSource localConnectionSource = paramConnectionSource;
      String str = paramString;
      StatementExecutor localStatementExecutor = this;
      ObjectCache localObjectCache = paramObjectCache;
      RawResultsImpl localRawResultsImpl = new RawResultsImpl(localConnectionSource, localDatabaseConnection1, str, [Ljava.lang.String.class, localCompiledStatement, arrayOfString, localStatementExecutor, localObjectCache);
      Object localObject1 = null;
      DatabaseConnection localDatabaseConnection2 = null;
      return localRawResultsImpl;
    }
    finally
    {
      CompiledStatement localCompiledStatement;
      if (localCompiledStatement != null)
        localCompiledStatement.close();
      if (localDatabaseConnection1 != null)
        paramConnectionSource.releaseConnection(localDatabaseConnection1);
    }
  }

  public int refresh(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedRefresh == null)
    {
      DatabaseType localDatabaseType = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      MappedRefresh localMappedRefresh = MappedRefresh.build(localDatabaseType, localTableInfo);
      this.mappedRefresh = localMappedRefresh;
    }
    return this.mappedRefresh.executeRefresh(paramDatabaseConnection, paramT, paramObjectCache);
  }

  public int update(DatabaseConnection paramDatabaseConnection, PreparedUpdate<T> paramPreparedUpdate)
    throws SQLException
  {
    StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.UPDATE;
    CompiledStatement localCompiledStatement = paramPreparedUpdate.compile(paramDatabaseConnection, localStatementType);
    try
    {
      int i = localCompiledStatement.runUpdate();
      int j = i;
      return j;
    }
    finally
    {
      localCompiledStatement.close();
    }
  }

  public int update(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedUpdate == null)
    {
      DatabaseType localDatabaseType = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      MappedUpdate localMappedUpdate = MappedUpdate.build(localDatabaseType, localTableInfo);
      this.mappedUpdate = localMappedUpdate;
    }
    return this.mappedUpdate.update(paramDatabaseConnection, paramT, paramObjectCache);
  }

  public int updateId(DatabaseConnection paramDatabaseConnection, T paramT, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedUpdateId == null)
    {
      DatabaseType localDatabaseType = this.databaseType;
      TableInfo localTableInfo = this.tableInfo;
      MappedUpdateId localMappedUpdateId = MappedUpdateId.build(localDatabaseType, localTableInfo);
      this.mappedUpdateId = localMappedUpdateId;
    }
    return this.mappedUpdateId.execute(paramDatabaseConnection, paramT, paramID, paramObjectCache);
  }

  public int updateRaw(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    logger.debug("running raw update statement: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("update arguments: {}", paramArrayOfString);
    StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.UPDATE;
    FieldType[] arrayOfFieldType = noFieldTypes;
    CompiledStatement localCompiledStatement = paramDatabaseConnection.compileStatement(paramString, localStatementType, arrayOfFieldType);
    try
    {
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      int i = localCompiledStatement.runUpdate();
      int j = i;
      return j;
    }
    finally
    {
      localCompiledStatement.close();
    }
  }

  private static class ObjectArrayRowMapper
    implements GenericRowMapper<Object[]>
  {
    private final DataType[] columnTypes;

    public ObjectArrayRowMapper(DataType[] paramArrayOfDataType)
    {
      this.columnTypes = paramArrayOfDataType;
    }

    public Object[] mapRow(DatabaseResults paramDatabaseResults)
      throws SQLException
    {
      int i = paramDatabaseResults.getColumnCount();
      Object[] arrayOfObject = new Object[i];
      int j = 0;
      if (j < i)
      {
        int k = this.columnTypes.length;
        if (j >= k);
        for (DataType localDataType = DataType.STRING; ; localDataType = this.columnTypes[j])
        {
          Object localObject = localDataType.getDataPersister().resultToJava(null, paramDatabaseResults, j);
          arrayOfObject[j] = localObject;
          j += 1;
          break;
        }
      }
      return arrayOfObject;
    }
  }

  private static class UserObjectRowMapper<UO>
    implements GenericRowMapper<UO>
  {
    private final String[] columnNames;
    private final RawRowMapper<UO> mapper;
    private final GenericRowMapper<String[]> stringRowMapper;

    public UserObjectRowMapper(RawRowMapper<UO> paramRawRowMapper, String[] paramArrayOfString, GenericRowMapper<String[]> paramGenericRowMapper)
    {
      this.mapper = paramRawRowMapper;
      this.columnNames = paramArrayOfString;
      this.stringRowMapper = paramGenericRowMapper;
    }

    public UO mapRow(DatabaseResults paramDatabaseResults)
      throws SQLException
    {
      String[] arrayOfString1 = (String[])this.stringRowMapper.mapRow(paramDatabaseResults);
      RawRowMapper localRawRowMapper = this.mapper;
      String[] arrayOfString2 = this.columnNames;
      return localRawRowMapper.mapRow(arrayOfString2, arrayOfString1);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.StatementExecutor
 * JD-Core Version:    0.6.2
 */