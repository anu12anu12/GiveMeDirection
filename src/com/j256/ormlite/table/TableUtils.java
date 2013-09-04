package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TableUtils
{
  private static Logger logger = LoggerFactory.getLogger(TableUtils.class);
  private static final FieldType[] noFieldTypes = new FieldType[0];

  private static <T, ID> void addCreateIndexStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int i = arrayOfFieldType.length;
    int j = 0;
    if (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      String str1;
      if (paramBoolean2)
      {
        str1 = localFieldType.getUniqueIndexName();
        label49: if (str1 != null)
          break label73;
      }
      while (true)
      {
        j += 1;
        break;
        str1 = localFieldType.getIndexName();
        break label49;
        label73: Object localObject1 = (List)localHashMap.get(str1);
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          Object localObject2 = localHashMap.put(str1, localObject1);
        }
        String str2 = localFieldType.getColumnName();
        boolean bool1 = ((List)localObject1).add(str2);
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    Iterator localIterator1 = localHashMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
        return;
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Logger localLogger = logger;
      Object localObject3 = localEntry.getKey();
      String str3 = paramTableInfo.getTableName();
      localLogger.info("creating index '{}' for table '{}", localObject3, str3);
      StringBuilder localStringBuilder2 = localStringBuilder1.append("CREATE ");
      if (paramBoolean2)
        StringBuilder localStringBuilder3 = localStringBuilder1.append("UNIQUE ");
      StringBuilder localStringBuilder4 = localStringBuilder1.append("INDEX ");
      if ((paramBoolean1) && (paramDatabaseType.isCreateIndexIfNotExistsSupported()))
        StringBuilder localStringBuilder5 = localStringBuilder1.append("IF NOT EXISTS ");
      String str4 = (String)localEntry.getKey();
      paramDatabaseType.appendEscapedEntityName(localStringBuilder1, str4);
      StringBuilder localStringBuilder6 = localStringBuilder1.append(" ON ");
      String str5 = paramTableInfo.getTableName();
      paramDatabaseType.appendEscapedEntityName(localStringBuilder1, str5);
      StringBuilder localStringBuilder7 = localStringBuilder1.append(" ( ");
      int k = 1;
      Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
      if (localIterator2.hasNext())
      {
        String str6 = (String)localIterator2.next();
        if (k != 0)
          k = 0;
        while (true)
        {
          paramDatabaseType.appendEscapedEntityName(localStringBuilder1, str6);
          break;
          StringBuilder localStringBuilder8 = localStringBuilder1.append(", ");
        }
      }
      StringBuilder localStringBuilder9 = localStringBuilder1.append(" )");
      String str7 = localStringBuilder1.toString();
      boolean bool2 = paramList.add(str7);
      localStringBuilder1.setLength(0);
    }
  }

  private static <T, ID> List<String> addCreateTableStatements(ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean)
    throws SQLException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    addCreateTableStatements(paramConnectionSource.getDatabaseType(), paramTableInfo, localArrayList1, localArrayList2, paramBoolean);
    return localArrayList1;
  }

  private static <T, ID> void addCreateTableStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
    throws SQLException
  {
    StringBuilder localStringBuilder1 = new StringBuilder(256);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("CREATE TABLE ");
    if ((paramBoolean) && (paramDatabaseType.isCreateIfNotExistsSupported()))
      StringBuilder localStringBuilder3 = localStringBuilder1.append("IF NOT EXISTS ");
    String str1 = paramTableInfo.getTableName();
    paramDatabaseType.appendEscapedEntityName(localStringBuilder1, str1);
    StringBuilder localStringBuilder4 = localStringBuilder1.append(" (");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 1;
    FieldType[] arrayOfFieldType1 = paramTableInfo.getFieldTypes();
    int j = arrayOfFieldType1.length;
    int k = 0;
    int m = k;
    int n = j;
    if (m < n)
    {
      FieldType localFieldType = arrayOfFieldType1[k];
      if (localFieldType.isForeignCollection());
      while (true)
      {
        k += 1;
        break;
        if (i != 0)
          i = 0;
        String str2;
        while (true)
        {
          str2 = localFieldType.getColumnDefinition();
          if (str2 != null)
            break label220;
          String str3 = paramTableInfo.getTableName();
          DatabaseType localDatabaseType1 = paramDatabaseType;
          List<String> localList1 = paramList2;
          localDatabaseType1.appendColumnArg(str3, localStringBuilder1, localFieldType, localArrayList1, localArrayList2, localArrayList3, localList1);
          break;
          StringBuilder localStringBuilder5 = localStringBuilder1.append(", ");
        }
        label220: String str4 = localFieldType.getColumnName();
        paramDatabaseType.appendEscapedEntityName(localStringBuilder1, str4);
        StringBuilder localStringBuilder6 = localStringBuilder1.append(' ');
        String str5 = str2;
        StringBuilder localStringBuilder7 = localStringBuilder6.append(str5).append(' ');
      }
    }
    FieldType[] arrayOfFieldType2 = paramTableInfo.getFieldTypes();
    DatabaseType localDatabaseType2 = paramDatabaseType;
    ArrayList localArrayList4 = localArrayList1;
    ArrayList localArrayList5 = localArrayList2;
    ArrayList localArrayList6 = localArrayList3;
    List<String> localList2 = paramList2;
    localDatabaseType2.addPrimaryKeySql(arrayOfFieldType2, localArrayList4, localArrayList5, localArrayList6, localList2);
    FieldType[] arrayOfFieldType3 = paramTableInfo.getFieldTypes();
    DatabaseType localDatabaseType3 = paramDatabaseType;
    ArrayList localArrayList7 = localArrayList1;
    ArrayList localArrayList8 = localArrayList2;
    ArrayList localArrayList9 = localArrayList3;
    List<String> localList3 = paramList2;
    localDatabaseType3.addUniqueComboSql(arrayOfFieldType3, localArrayList7, localArrayList8, localArrayList9, localList3);
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      String str6 = (String)localIterator.next();
      StringBuilder localStringBuilder8 = localStringBuilder1.append(", ");
      String str7 = str6;
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str7);
    }
    StringBuilder localStringBuilder10 = localStringBuilder1.append(") ");
    paramDatabaseType.appendCreateTableSuffix(localStringBuilder1);
    boolean bool1 = paramList1.addAll(localArrayList2);
    String str8 = localStringBuilder1.toString();
    boolean bool2 = paramList1.add(str8);
    boolean bool3 = paramList1.addAll(localArrayList3);
    DatabaseType localDatabaseType4 = paramDatabaseType;
    TableInfo<T, ID> localTableInfo1 = paramTableInfo;
    List<String> localList4 = paramList1;
    boolean bool4 = paramBoolean;
    addCreateIndexStatements(localDatabaseType4, localTableInfo1, localList4, bool4, false);
    DatabaseType localDatabaseType5 = paramDatabaseType;
    TableInfo<T, ID> localTableInfo2 = paramTableInfo;
    List<String> localList5 = paramList1;
    boolean bool5 = paramBoolean;
    addCreateIndexStatements(localDatabaseType5, localTableInfo2, localList5, bool5, true);
  }

  private static <T, ID> void addDropIndexStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList)
  {
    HashSet localHashSet = new HashSet();
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int i = arrayOfFieldType.length;
    int j = 0;
    while (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      String str1 = localFieldType.getIndexName();
      if (str1 != null)
        boolean bool1 = localHashSet.add(str1);
      String str2 = localFieldType.getUniqueIndexName();
      if (str2 != null)
        boolean bool2 = localHashSet.add(str2);
      j += 1;
    }
    StringBuilder localStringBuilder1 = new StringBuilder(48);
    Iterator localIterator = localHashSet.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str3 = (String)localIterator.next();
      Logger localLogger = logger;
      String str4 = paramTableInfo.getTableName();
      localLogger.info("dropping index '{}' for table '{}", str3, str4);
      StringBuilder localStringBuilder2 = localStringBuilder1.append("DROP INDEX ");
      paramDatabaseType.appendEscapedEntityName(localStringBuilder1, str3);
      String str5 = localStringBuilder1.toString();
      boolean bool3 = paramList.add(str5);
      localStringBuilder1.setLength(0);
    }
  }

  private static <T, ID> void addDropTableStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int i = arrayOfFieldType.length;
    int j = 0;
    while (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      paramDatabaseType.dropColumnArg(localFieldType, localArrayList1, localArrayList2);
      j += 1;
    }
    StringBuilder localStringBuilder1 = new StringBuilder(64);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("DROP TABLE ");
    String str1 = paramTableInfo.getTableName();
    paramDatabaseType.appendEscapedEntityName(localStringBuilder1, str1);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(' ');
    boolean bool1 = paramList.addAll(localArrayList1);
    String str2 = localStringBuilder1.toString();
    boolean bool2 = paramList.add(str2);
    boolean bool3 = paramList.addAll(localArrayList2);
  }

  public static <T> int clearTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    String str = paramDatabaseTableConfig.getTableName();
    return clearTable(paramConnectionSource, str);
  }

  public static <T> int clearTable(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    String str = DatabaseTableConfig.extractTableName(paramClass);
    if (paramConnectionSource.getDatabaseType().isEntityNamesMustBeUpCase())
      str = str.toUpperCase();
    return clearTable(paramConnectionSource, str);
  }

  private static <T> int clearTable(ConnectionSource paramConnectionSource, String paramString)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    StringBuilder localStringBuilder1 = new StringBuilder(48);
    if (localDatabaseType.isTruncateSupported())
      StringBuilder localStringBuilder2 = localStringBuilder1.append("TRUNCATE TABLE ");
    while (true)
    {
      localDatabaseType.appendEscapedEntityName(localStringBuilder1, paramString);
      String str = localStringBuilder1.toString();
      logger.info("clearing table '{}' with '{}", paramString, str);
      DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadWriteConnection();
      try
      {
        StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.EXECUTE;
        FieldType[] arrayOfFieldType = noFieldTypes;
        localCompiledStatement = localDatabaseConnection.compileStatement(str, localStatementType, arrayOfFieldType);
        int i = localCompiledStatement.runExecute();
        int j = i;
        return j;
        StringBuilder localStringBuilder3 = localStringBuilder1.append("DELETE FROM ");
      }
      finally
      {
        CompiledStatement localCompiledStatement;
        if (localCompiledStatement != null)
          localCompiledStatement.close();
        paramConnectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }

  public static <T> int createTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramDatabaseTableConfig, false);
  }

  private static <T, ID> int createTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig, boolean paramBoolean)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    TableInfo localTableInfo1;
    if ((localDao instanceof BaseDaoImpl))
      localTableInfo1 = ((BaseDaoImpl)localDao).getTableInfo();
    TableInfo localTableInfo2;
    for (int i = doCreateTable(paramConnectionSource, localTableInfo1, paramBoolean); ; i = doCreateTable(paramConnectionSource, localTableInfo2, paramBoolean))
    {
      return i;
      paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
      DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
      localTableInfo2 = new TableInfo(localDatabaseType, null, paramDatabaseTableConfig);
    }
  }

  public static <T> int createTable(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramClass, false);
  }

  private static <T, ID> int createTable(ConnectionSource paramConnectionSource, Class<T> paramClass, boolean paramBoolean)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramClass);
    TableInfo localTableInfo1;
    if ((localDao instanceof BaseDaoImpl))
      localTableInfo1 = ((BaseDaoImpl)localDao).getTableInfo();
    TableInfo localTableInfo2;
    for (int i = doCreateTable(paramConnectionSource, localTableInfo1, paramBoolean); ; i = doCreateTable(paramConnectionSource, localTableInfo2, paramBoolean))
    {
      return i;
      localTableInfo2 = new TableInfo(paramConnectionSource, null, paramClass);
    }
  }

  public static <T> int createTableIfNotExists(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramDatabaseTableConfig, true);
  }

  public static <T> int createTableIfNotExists(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramClass, true);
  }

  private static <T, ID> int doCreateTable(ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    Logger localLogger = logger;
    String str = paramTableInfo.getTableName();
    localLogger.info("creating table '{}'", str);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    addCreateTableStatements(localDatabaseType, paramTableInfo, localArrayList1, localArrayList2, paramBoolean);
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadWriteConnection();
    try
    {
      boolean bool1 = localDatabaseType.isCreateTableReturnsNegative();
      boolean bool2 = localDatabaseType.isCreateTableReturnsZero();
      int i = doStatements(localDatabaseConnection, "create", localArrayList1, false, bool1, bool2);
      int j = doCreateTestQueries(localDatabaseConnection, localDatabaseType, localArrayList2);
      int k = j;
      int m = i + k;
      return m;
    }
    finally
    {
      paramConnectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  private static int doCreateTestQueries(DatabaseConnection paramDatabaseConnection, DatabaseType paramDatabaseType, List<String> paramList)
    throws SQLException
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.SELECT;
        FieldType[] arrayOfFieldType = noFieldTypes;
        localCompiledStatement = paramDatabaseConnection.compileStatement(str, localStatementType, arrayOfFieldType);
        DatabaseResults localDatabaseResults = localCompiledStatement.runQuery(null);
        int j = 0;
        for (boolean bool = localDatabaseResults.first(); bool; bool = localDatabaseResults.next())
          j += 1;
        Logger localLogger = logger;
        Integer localInteger = Integer.valueOf(j);
        localLogger.info("executing create table after-query got {} results: {}", localInteger, str);
        if (localCompiledStatement != null)
          localCompiledStatement.close();
        i += 1;
      }
      catch (SQLException localSQLException)
      {
        throw SqlExceptionUtil.create("executing create table after-query failed: " + str, localSQLException);
      }
      finally
      {
        CompiledStatement localCompiledStatement;
        if (localCompiledStatement != null)
          localCompiledStatement.close();
      }
    }
    return i;
  }

  private static <T, ID> int doDropTable(DatabaseType paramDatabaseType, ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean)
    throws SQLException
  {
    Logger localLogger = logger;
    String str = paramTableInfo.getTableName();
    localLogger.info("dropping table '{}'", str);
    ArrayList localArrayList = new ArrayList();
    addDropIndexStatements(paramDatabaseType, paramTableInfo, localArrayList);
    addDropTableStatements(paramDatabaseType, paramTableInfo, localArrayList);
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadWriteConnection();
    try
    {
      boolean bool1 = paramDatabaseType.isCreateTableReturnsNegative();
      boolean bool2 = paramBoolean;
      int i = doStatements(localDatabaseConnection, "drop", localArrayList, bool2, bool1, false);
      int j = i;
      return j;
    }
    finally
    {
      paramConnectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  private static int doStatements(DatabaseConnection paramDatabaseConnection, String paramString, Collection<String> paramCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws SQLException
  {
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      int j;
      try
      {
        StatementBuilder.StatementType localStatementType = StatementBuilder.StatementType.EXECUTE;
        FieldType[] arrayOfFieldType = noFieldTypes;
        localCompiledStatement = paramDatabaseConnection.compileStatement(str1, localStatementType, arrayOfFieldType);
        j = localCompiledStatement.runExecute();
        Logger localLogger = logger;
        Integer localInteger = Integer.valueOf(j);
        localLogger.info("executed {} table statement changed {} rows: {}", paramString, localInteger, str1);
        if (localCompiledStatement != null)
          localCompiledStatement.close();
        if (j < 0)
        {
          if (paramBoolean2)
            break label296;
          String str2 = "SQL statement " + str1 + " updated " + j + " rows, we were expecting >= 0";
          throw new SQLException(str2);
        }
      }
      catch (SQLException localSQLException)
      {
        while (paramBoolean1)
        {
          logger.info("ignoring {} error '{}' for statement: {}", paramString, localSQLException, str1);
          if (localCompiledStatement != null)
            localCompiledStatement.close();
        }
        throw SqlExceptionUtil.create("SQL statement failed: " + str1, localSQLException);
      }
      finally
      {
        CompiledStatement localCompiledStatement;
        if (localCompiledStatement != null)
          localCompiledStatement.close();
      }
      if ((j > 0) && (paramBoolean3))
      {
        String str3 = "SQL statement updated " + j + " rows, we were expecting == 0: " + str1;
        throw new SQLException(str3);
      }
      label296: i += 1;
    }
    return i;
  }

  public static <T, ID> int dropTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig, boolean paramBoolean)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    TableInfo localTableInfo1;
    if ((localDao instanceof BaseDaoImpl))
      localTableInfo1 = ((BaseDaoImpl)localDao).getTableInfo();
    TableInfo localTableInfo2;
    for (int i = doDropTable(localDatabaseType, paramConnectionSource, localTableInfo1, paramBoolean); ; i = doDropTable(localDatabaseType, paramConnectionSource, localTableInfo2, paramBoolean))
    {
      return i;
      paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
      localTableInfo2 = new TableInfo(localDatabaseType, null, paramDatabaseTableConfig);
    }
  }

  public static <T, ID> int dropTable(ConnectionSource paramConnectionSource, Class<T> paramClass, boolean paramBoolean)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramClass);
    TableInfo localTableInfo1;
    if ((localDao instanceof BaseDaoImpl))
      localTableInfo1 = ((BaseDaoImpl)localDao).getTableInfo();
    TableInfo localTableInfo2;
    for (int i = doDropTable(localDatabaseType, paramConnectionSource, localTableInfo1, paramBoolean); ; i = doDropTable(localDatabaseType, paramConnectionSource, localTableInfo2, paramBoolean))
    {
      return i;
      localTableInfo2 = new TableInfo(paramConnectionSource, null, paramClass);
    }
  }

  public static <T, ID> List<String> getCreateTableStatements(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    TableInfo localTableInfo1;
    if ((localDao instanceof BaseDaoImpl))
      localTableInfo1 = ((BaseDaoImpl)localDao).getTableInfo();
    TableInfo localTableInfo2;
    for (List localList = addCreateTableStatements(paramConnectionSource, localTableInfo1, false); ; localList = addCreateTableStatements(paramConnectionSource, localTableInfo2, false))
    {
      return localList;
      paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
      DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
      localTableInfo2 = new TableInfo(localDatabaseType, null, paramDatabaseTableConfig);
    }
  }

  public static <T, ID> List<String> getCreateTableStatements(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramClass);
    TableInfo localTableInfo1;
    if ((localDao instanceof BaseDaoImpl))
      localTableInfo1 = ((BaseDaoImpl)localDao).getTableInfo();
    TableInfo localTableInfo2;
    for (List localList = addCreateTableStatements(paramConnectionSource, localTableInfo1, false); ; localList = addCreateTableStatements(paramConnectionSource, localTableInfo2, false))
    {
      return localList;
      localTableInfo2 = new TableInfo(paramConnectionSource, null, paramClass);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.table.TableUtils
 * JD-Core Version:    0.6.2
 */