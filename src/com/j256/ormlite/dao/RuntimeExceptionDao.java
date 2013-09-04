package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class RuntimeExceptionDao<T, ID>
{
  private static final Log.Level LOG_LEVEL = Log.Level.DEBUG;
  private static final Logger logger = LoggerFactory.getLogger(RuntimeExceptionDao.class);
  private Dao<T, ID> dao;

  public RuntimeExceptionDao(Dao<T, ID> paramDao)
  {
    this.dao = paramDao;
  }

  public static <T, ID> RuntimeExceptionDao<T, ID> createDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    return new RuntimeExceptionDao(localDao);
  }

  public static <T, ID> RuntimeExceptionDao<T, ID> createDao(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramClass);
    return new RuntimeExceptionDao(localDao);
  }

  private void logMessage(Exception paramException, String paramString)
  {
    Logger localLogger = logger;
    Log.Level localLevel = LOG_LEVEL;
    localLogger.log(localLevel, paramException, paramString);
  }

  public <CT> CT callBatchTasks(Callable<CT> paramCallable)
  {
    try
    {
      Object localObject = this.dao.callBatchTasks(paramCallable);
      return localObject;
    }
    catch (Exception localException)
    {
      String str = "callBatchTasks threw exception on: " + paramCallable;
      logMessage(localException, str);
      throw new RuntimeException(localException);
    }
  }

  public void clearObjectCache()
  {
    this.dao.clearObjectCache();
  }

  public void closeLastIterator()
  {
    try
    {
      this.dao.closeLastIterator();
      return;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "closeLastIterator threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public void commit(DatabaseConnection paramDatabaseConnection)
  {
    try
    {
      this.dao.commit(paramDatabaseConnection);
      return;
    }
    catch (SQLException localSQLException)
    {
      String str = "commit(" + paramDatabaseConnection + ") threw exception";
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public long countOf()
  {
    try
    {
      long l = this.dao.countOf();
      return l;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "countOf threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public long countOf(PreparedQuery<T> paramPreparedQuery)
  {
    try
    {
      long l = this.dao.countOf(paramPreparedQuery);
      return l;
    }
    catch (SQLException localSQLException)
    {
      String str = "countOf threw exception on " + paramPreparedQuery;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int create(T paramT)
  {
    try
    {
      int i = this.dao.create(paramT);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "create threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public T createIfNotExists(T paramT)
  {
    try
    {
      Object localObject = this.dao.createIfNotExists(paramT);
      return localObject;
    }
    catch (SQLException localSQLException)
    {
      String str = "createIfNotExists threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public Dao.CreateOrUpdateStatus createOrUpdate(T paramT)
  {
    try
    {
      Dao.CreateOrUpdateStatus localCreateOrUpdateStatus = this.dao.createOrUpdate(paramT);
      return localCreateOrUpdateStatus;
    }
    catch (SQLException localSQLException)
    {
      String str = "createOrUpdate threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int delete(PreparedDelete<T> paramPreparedDelete)
  {
    try
    {
      int i = this.dao.delete(paramPreparedDelete);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "delete threw exception on: " + paramPreparedDelete;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int delete(T paramT)
  {
    try
    {
      int i = this.dao.delete(paramT);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "delete threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int delete(Collection<T> paramCollection)
  {
    try
    {
      int i = this.dao.delete(paramCollection);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "delete threw exception on: " + paramCollection;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public DeleteBuilder<T, ID> deleteBuilder()
  {
    return this.dao.deleteBuilder();
  }

  public int deleteById(ID paramID)
  {
    try
    {
      int i = this.dao.deleteById(paramID);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "deleteById threw exception on: " + paramID;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int deleteIds(Collection<ID> paramCollection)
  {
    try
    {
      int i = this.dao.deleteIds(paramCollection);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "deleteIds threw exception on: " + paramCollection;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public void endThreadConnection(DatabaseConnection paramDatabaseConnection)
  {
    try
    {
      this.dao.endThreadConnection(paramDatabaseConnection);
      return;
    }
    catch (SQLException localSQLException)
    {
      String str = "endThreadConnection(" + paramDatabaseConnection + ") threw exception";
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int executeRaw(String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = this.dao.executeRaw(paramString, paramArrayOfString);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "executeRaw threw exception on: " + paramString;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public ID extractId(T paramT)
  {
    try
    {
      Object localObject = this.dao.extractId(paramT);
      return localObject;
    }
    catch (SQLException localSQLException)
    {
      String str = "extractId threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public FieldType findForeignFieldType(Class<?> paramClass)
  {
    return this.dao.findForeignFieldType(paramClass);
  }

  public Class<T> getDataClass()
  {
    return this.dao.getDataClass();
  }

  public <FT> ForeignCollection<FT> getEmptyForeignCollection(String paramString)
  {
    try
    {
      ForeignCollection localForeignCollection = this.dao.getEmptyForeignCollection(paramString);
      return localForeignCollection;
    }
    catch (SQLException localSQLException)
    {
      String str = "getEmptyForeignCollection threw exception on " + paramString;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public ObjectCache getObjectCache()
  {
    return this.dao.getObjectCache();
  }

  public GenericRowMapper<T> getSelectStarRowMapper()
  {
    try
    {
      GenericRowMapper localGenericRowMapper = this.dao.getSelectStarRowMapper();
      return localGenericRowMapper;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "getSelectStarRowMapper threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public CloseableWrappedIterable<T> getWrappedIterable()
  {
    return this.dao.getWrappedIterable();
  }

  public CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> paramPreparedQuery)
  {
    return this.dao.getWrappedIterable(paramPreparedQuery);
  }

  public boolean idExists(ID paramID)
  {
    try
    {
      boolean bool = this.dao.idExists(paramID);
      return bool;
    }
    catch (SQLException localSQLException)
    {
      String str = "idExists threw exception on " + paramID;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  @Deprecated
  public boolean isAutoCommit()
  {
    try
    {
      boolean bool = this.dao.isAutoCommit();
      return bool;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "isAutoCommit() threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public boolean isAutoCommit(DatabaseConnection paramDatabaseConnection)
  {
    try
    {
      boolean bool = this.dao.isAutoCommit(paramDatabaseConnection);
      return bool;
    }
    catch (SQLException localSQLException)
    {
      String str = "isAutoCommit(" + paramDatabaseConnection + ") threw exception";
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public boolean isTableExists()
  {
    try
    {
      boolean bool = this.dao.isTableExists();
      return bool;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "isTableExists threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public boolean isUpdatable()
  {
    return this.dao.isUpdatable();
  }

  public CloseableIterator<T> iterator()
  {
    return this.dao.iterator();
  }

  public CloseableIterator<T> iterator(int paramInt)
  {
    return this.dao.iterator(paramInt);
  }

  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery)
  {
    try
    {
      CloseableIterator localCloseableIterator = this.dao.iterator(paramPreparedQuery);
      return localCloseableIterator;
    }
    catch (SQLException localSQLException)
    {
      String str = "iterator threw exception on: " + paramPreparedQuery;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery, int paramInt)
  {
    try
    {
      CloseableIterator localCloseableIterator = this.dao.iterator(paramPreparedQuery, paramInt);
      return localCloseableIterator;
    }
    catch (SQLException localSQLException)
    {
      String str = "iterator threw exception on: " + paramPreparedQuery;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public T mapSelectStarRow(DatabaseResults paramDatabaseResults)
  {
    try
    {
      Object localObject = this.dao.mapSelectStarRow(paramDatabaseResults);
      return localObject;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "mapSelectStarRow threw exception on results");
      throw new RuntimeException(localSQLException);
    }
  }

  public String objectToString(T paramT)
  {
    return this.dao.objectToString(paramT);
  }

  public boolean objectsEqual(T paramT1, T paramT2)
  {
    try
    {
      boolean bool = this.dao.objectsEqual(paramT1, paramT2);
      return bool;
    }
    catch (SQLException localSQLException)
    {
      String str = "objectsEqual threw exception on: " + paramT1 + " and " + paramT2;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public List<T> query(PreparedQuery<T> paramPreparedQuery)
  {
    try
    {
      List localList = this.dao.query(paramPreparedQuery);
      return localList;
    }
    catch (SQLException localSQLException)
    {
      String str = "query threw exception on: " + paramPreparedQuery;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public QueryBuilder<T, ID> queryBuilder()
  {
    return this.dao.queryBuilder();
  }

  public List<T> queryForAll()
  {
    try
    {
      List localList = this.dao.queryForAll();
      return localList;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "queryForAll threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public List<T> queryForEq(String paramString, Object paramObject)
  {
    try
    {
      List localList = this.dao.queryForEq(paramString, paramObject);
      return localList;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryForEq threw exception on: " + paramString;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public List<T> queryForFieldValues(Map<String, Object> paramMap)
  {
    try
    {
      List localList = this.dao.queryForFieldValues(paramMap);
      return localList;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "queryForFieldValues threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public List<T> queryForFieldValuesArgs(Map<String, Object> paramMap)
  {
    try
    {
      List localList = this.dao.queryForFieldValuesArgs(paramMap);
      return localList;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "queryForFieldValuesArgs threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public T queryForFirst(PreparedQuery<T> paramPreparedQuery)
  {
    try
    {
      Object localObject = this.dao.queryForFirst(paramPreparedQuery);
      return localObject;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryForFirst threw exception on: " + paramPreparedQuery;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public T queryForId(ID paramID)
  {
    try
    {
      Object localObject = this.dao.queryForId(paramID);
      return localObject;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryForId threw exception on: " + paramID;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public List<T> queryForMatching(T paramT)
  {
    try
    {
      List localList = this.dao.queryForMatching(paramT);
      return localList;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryForMatching threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public List<T> queryForMatchingArgs(T paramT)
  {
    try
    {
      List localList = this.dao.queryForMatchingArgs(paramT);
      return localList;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryForMatchingArgs threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public T queryForSameId(T paramT)
  {
    try
    {
      Object localObject = this.dao.queryForSameId(paramT);
      return localObject;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryForSameId threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public <UO> GenericRawResults<UO> queryRaw(String paramString, RawRowMapper<UO> paramRawRowMapper, String[] paramArrayOfString)
  {
    try
    {
      GenericRawResults localGenericRawResults = this.dao.queryRaw(paramString, paramRawRowMapper, paramArrayOfString);
      return localGenericRawResults;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryRaw threw exception on: " + paramString;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public GenericRawResults<Object[]> queryRaw(String paramString, DataType[] paramArrayOfDataType, String[] paramArrayOfString)
  {
    try
    {
      GenericRawResults localGenericRawResults = this.dao.queryRaw(paramString, paramArrayOfDataType, paramArrayOfString);
      return localGenericRawResults;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryRaw threw exception on: " + paramString;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public GenericRawResults<String[]> queryRaw(String paramString, String[] paramArrayOfString)
  {
    try
    {
      GenericRawResults localGenericRawResults = this.dao.queryRaw(paramString, paramArrayOfString);
      return localGenericRawResults;
    }
    catch (SQLException localSQLException)
    {
      String str = "queryRaw threw exception on: " + paramString;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int refresh(T paramT)
  {
    try
    {
      int i = this.dao.refresh(paramT);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "refresh threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public void rollBack(DatabaseConnection paramDatabaseConnection)
  {
    try
    {
      this.dao.rollBack(paramDatabaseConnection);
      return;
    }
    catch (SQLException localSQLException)
    {
      String str = "rollBack(" + paramDatabaseConnection + ") threw exception";
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public void setAutoCommit(DatabaseConnection paramDatabaseConnection, boolean paramBoolean)
  {
    try
    {
      this.dao.setAutoCommit(paramDatabaseConnection, paramBoolean);
      return;
    }
    catch (SQLException localSQLException)
    {
      String str = "setAutoCommit(" + paramDatabaseConnection + "," + paramBoolean + ") threw exception";
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  @Deprecated
  public void setAutoCommit(boolean paramBoolean)
  {
    try
    {
      this.dao.setAutoCommit(paramBoolean);
      return;
    }
    catch (SQLException localSQLException)
    {
      String str = "setAutoCommit(" + paramBoolean + ") threw exception";
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public void setObjectCache(ObjectCache paramObjectCache)
  {
    try
    {
      this.dao.setObjectCache(paramObjectCache);
      return;
    }
    catch (SQLException localSQLException)
    {
      String str = "setObjectCache threw exception on " + paramObjectCache;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public void setObjectCache(boolean paramBoolean)
  {
    try
    {
      this.dao.setObjectCache(paramBoolean);
      return;
    }
    catch (SQLException localSQLException)
    {
      String str = "setObjectCache(" + paramBoolean + ") threw exception";
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public DatabaseConnection startThreadConnection()
  {
    try
    {
      DatabaseConnection localDatabaseConnection = this.dao.startThreadConnection();
      return localDatabaseConnection;
    }
    catch (SQLException localSQLException)
    {
      logMessage(localSQLException, "startThreadConnection() threw exception");
      throw new RuntimeException(localSQLException);
    }
  }

  public int update(PreparedUpdate<T> paramPreparedUpdate)
  {
    try
    {
      int i = this.dao.update(paramPreparedUpdate);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "update threw exception on: " + paramPreparedUpdate;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int update(T paramT)
  {
    try
    {
      int i = this.dao.update(paramT);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "update threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public UpdateBuilder<T, ID> updateBuilder()
  {
    return this.dao.updateBuilder();
  }

  public int updateId(T paramT, ID paramID)
  {
    try
    {
      int i = this.dao.updateId(paramT, paramID);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "updateId threw exception on: " + paramT;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }

  public int updateRaw(String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = this.dao.updateRaw(paramString, paramArrayOfString);
      return i;
    }
    catch (SQLException localSQLException)
    {
      String str = "updateRaw threw exception on: " + paramString;
      logMessage(localSQLException, str);
      throw new RuntimeException(localSQLException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.RuntimeExceptionDao
 * JD-Core Version:    0.6.2
 */