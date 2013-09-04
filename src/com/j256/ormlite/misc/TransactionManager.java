package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager
{
  private static final String SAVE_POINT_PREFIX = "ORMLITE";
  private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
  private static AtomicInteger savePointCounter = new AtomicInteger();
  private ConnectionSource connectionSource;

  public TransactionManager()
  {
  }

  public TransactionManager(ConnectionSource paramConnectionSource)
  {
    this.connectionSource = paramConnectionSource;
    initialize();
  }

  public static <T> T callInTransaction(ConnectionSource paramConnectionSource, Callable<T> paramCallable)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadWriteConnection();
    try
    {
      boolean bool = paramConnectionSource.saveSpecialConnection(localDatabaseConnection);
      DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
      Object localObject1 = callInTransaction(localDatabaseConnection, bool, localDatabaseType, paramCallable);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      paramConnectionSource.clearSpecialConnection(localDatabaseConnection);
      paramConnectionSource.releaseConnection(localDatabaseConnection);
    }
  }

  public static <T> T callInTransaction(DatabaseConnection paramDatabaseConnection, DatabaseType paramDatabaseType, Callable<T> paramCallable)
    throws SQLException
  {
    return callInTransaction(paramDatabaseConnection, false, paramDatabaseType, paramCallable);
  }

  // ERROR //
  public static <T> T callInTransaction(DatabaseConnection paramDatabaseConnection, boolean paramBoolean, DatabaseType paramDatabaseType, Callable<T> paramCallable)
    throws SQLException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iload_1
    //   10: ifne +12 -> 22
    //   13: aload_2
    //   14: invokeinterface 76 1 0
    //   19: ifeq +100 -> 119
    //   22: aload_0
    //   23: invokeinterface 81 1 0
    //   28: ifeq +31 -> 59
    //   31: aload_0
    //   32: invokeinterface 84 1 0
    //   37: istore 4
    //   39: iload 4
    //   41: ifeq +18 -> 59
    //   44: aload_0
    //   45: iconst_0
    //   46: invokeinterface 88 2 0
    //   51: getstatic 25	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   54: ldc 90
    //   56: invokevirtual 96	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   59: new 98	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   66: ldc 9
    //   68: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: astore 7
    //   73: getstatic 32	com/j256/ormlite/misc/TransactionManager:savePointCounter	Ljava/util/concurrent/atomic/AtomicInteger;
    //   76: invokevirtual 107	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   79: istore 8
    //   81: aload 7
    //   83: iload 8
    //   85: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore 9
    //   93: aload_0
    //   94: aload 9
    //   96: invokeinterface 118 2 0
    //   101: astore 6
    //   103: aload 6
    //   105: ifnonnull +56 -> 161
    //   108: getstatic 25	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   111: ldc 120
    //   113: invokevirtual 96	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   116: iconst_1
    //   117: istore 5
    //   119: aload_3
    //   120: invokeinterface 126 1 0
    //   125: astore 10
    //   127: iload 5
    //   129: ifeq +9 -> 138
    //   132: aload_0
    //   133: aload 6
    //   135: invokestatic 130	com/j256/ormlite/misc/TransactionManager:commit	(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   138: iload 4
    //   140: ifeq +18 -> 158
    //   143: aload_0
    //   144: iconst_1
    //   145: invokeinterface 88 2 0
    //   150: getstatic 25	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   153: ldc 132
    //   155: invokevirtual 96	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   158: aload 10
    //   160: areturn
    //   161: getstatic 25	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   164: astore 11
    //   166: aload 6
    //   168: invokeinterface 137 1 0
    //   173: astore 12
    //   175: aload 11
    //   177: ldc 139
    //   179: aload 12
    //   181: invokevirtual 142	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   184: goto -68 -> 116
    //   187: astore 13
    //   189: iload 4
    //   191: ifeq +18 -> 209
    //   194: aload_0
    //   195: iconst_1
    //   196: invokeinterface 88 2 0
    //   201: getstatic 25	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   204: ldc 132
    //   206: invokevirtual 96	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   209: aload 13
    //   211: athrow
    //   212: astore 14
    //   214: iload 5
    //   216: ifeq +9 -> 225
    //   219: aload_0
    //   220: aload 6
    //   222: invokestatic 145	com/j256/ormlite/misc/TransactionManager:rollBack	(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   225: aload 14
    //   227: athrow
    //   228: astore 14
    //   230: iload 5
    //   232: ifeq +9 -> 241
    //   235: aload_0
    //   236: aload 6
    //   238: invokestatic 145	com/j256/ormlite/misc/TransactionManager:rollBack	(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   241: ldc 147
    //   243: aload 14
    //   245: invokestatic 153	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   248: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   13	116	187	finally
    //   119	138	187	finally
    //   161	184	187	finally
    //   219	249	187	finally
    //   119	138	212	java/sql/SQLException
    //   119	138	228	java/lang/Exception
  }

  private static void commit(DatabaseConnection paramDatabaseConnection, Savepoint paramSavepoint)
    throws SQLException
  {
    if (paramSavepoint == null);
    for (String str = null; ; str = paramSavepoint.getSavepointName())
    {
      paramDatabaseConnection.commit(paramSavepoint);
      if (str != null)
        break;
      logger.debug("committed savePoint transaction");
      return;
    }
    logger.debug("committed savePoint transaction {}", str);
  }

  private static void rollBack(DatabaseConnection paramDatabaseConnection, Savepoint paramSavepoint)
    throws SQLException
  {
    if (paramSavepoint == null);
    for (String str = null; ; str = paramSavepoint.getSavepointName())
    {
      paramDatabaseConnection.rollback(paramSavepoint);
      if (str != null)
        break;
      logger.debug("rolled back savePoint transaction");
      return;
    }
    logger.debug("rolled back savePoint transaction {}", str);
  }

  public <T> T callInTransaction(Callable<T> paramCallable)
    throws SQLException
  {
    return callInTransaction(this.connectionSource, paramCallable);
  }

  public void initialize()
  {
    if (this.connectionSource != null)
      return;
    StringBuilder localStringBuilder = new StringBuilder().append("dataSource was not set on ");
    String str1 = getClass().getSimpleName();
    String str2 = str1;
    throw new IllegalStateException(str2);
  }

  public void setConnectionSource(ConnectionSource paramConnectionSource)
  {
    this.connectionSource = paramConnectionSource;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.misc.TransactionManager
 * JD-Core Version:    0.6.2
 */