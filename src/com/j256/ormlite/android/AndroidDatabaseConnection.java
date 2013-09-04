package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.Savepoint;

public class AndroidDatabaseConnection
  implements DatabaseConnection
{
  private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
  private final SQLiteDatabase db;
  private final boolean readWrite;

  public AndroidDatabaseConnection(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    this.db = paramSQLiteDatabase;
    this.readWrite = paramBoolean;
    Logger localLogger = logger;
    Boolean localBoolean = Boolean.valueOf(paramBoolean);
    localLogger.trace("{}: db {} opened, read-write = {}", this, paramSQLiteDatabase, localBoolean);
  }

  private void bindArgs(SQLiteStatement paramSQLiteStatement, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    if (paramArrayOfObject == null)
      return;
    int i = 0;
    int j = paramArrayOfObject.length;
    if (i >= j)
      return;
    Object localObject = paramArrayOfObject[i];
    if (localObject == null)
    {
      int k = i + 1;
      paramSQLiteStatement.bindNull(k);
    }
    while (true)
    {
      i += 1;
      break;
      int[] arrayOfInt = 1.$SwitchMap$com$j256$ormlite$field$SqlType;
      int m = paramArrayOfFieldType[i].getSqlType().ordinal();
      switch (arrayOfInt[m])
      {
      default:
        StringBuilder localStringBuilder = new StringBuilder().append("Unknown sql argument type ");
        SqlType localSqlType = paramArrayOfFieldType[i].getSqlType();
        String str1 = localSqlType;
        throw new java.sql.SQLException(str1);
      case 1:
      case 2:
      case 3:
        int n = i + 1;
        String str2 = localObject.toString();
        paramSQLiteStatement.bindString(n, str2);
        break;
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
        int i1 = i + 1;
        long l = ((Number)localObject).longValue();
        paramSQLiteStatement.bindLong(i1, l);
        break;
      case 9:
      case 10:
        int i2 = i + 1;
        double d = ((Number)localObject).doubleValue();
        paramSQLiteStatement.bindDouble(i2, d);
        break;
      case 11:
      case 12:
        int i3 = i + 1;
        byte[] arrayOfByte = (byte[])localObject;
        paramSQLiteStatement.bindBlob(i3, arrayOfByte);
      }
    }
  }

  private String[] toStrings(Object[] paramArrayOfObject)
  {
    String[] arrayOfString;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
      arrayOfString = null;
    int i;
    int j;
    do
    {
      return arrayOfString;
      arrayOfString = new String[paramArrayOfObject.length];
      i = 0;
      j = paramArrayOfObject.length;
    }
    while (i >= j);
    Object localObject = paramArrayOfObject[i];
    if (localObject == null)
      arrayOfString[i] = null;
    while (true)
    {
      i += 1;
      break;
      String str = localObject.toString();
      arrayOfString[i] = str;
    }
  }

  // ERROR //
  private int update(String paramString1, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, String paramString2)
    throws java.sql.SQLException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/j256/ormlite/android/AndroidDatabaseConnection:db	Landroid/database/sqlite/SQLiteDatabase;
    //   4: aload_1
    //   5: invokevirtual 138	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   8: astore 5
    //   10: aload_0
    //   11: aload 5
    //   13: aload_2
    //   14: aload_3
    //   15: invokespecial 140	com/j256/ormlite/android/AndroidDatabaseConnection:bindArgs	(Landroid/database/sqlite/SQLiteStatement;[Ljava/lang/Object;[Lcom/j256/ormlite/field/FieldType;)V
    //   18: aload 5
    //   20: invokevirtual 143	android/database/sqlite/SQLiteStatement:execute	()V
    //   23: aload 5
    //   25: ifnull +8 -> 33
    //   28: aload 5
    //   30: invokevirtual 146	android/database/sqlite/SQLiteStatement:close	()V
    //   33: aload_0
    //   34: getfield 34	com/j256/ormlite/android/AndroidDatabaseConnection:db	Landroid/database/sqlite/SQLiteDatabase;
    //   37: ldc 148
    //   39: invokevirtual 138	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   42: astore 5
    //   44: aload 5
    //   46: invokevirtual 151	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   49: lstore 6
    //   51: lload 6
    //   53: l2i
    //   54: istore 8
    //   56: aload 5
    //   58: ifnull +8 -> 66
    //   61: aload 5
    //   63: invokevirtual 146	android/database/sqlite/SQLiteStatement:close	()V
    //   66: getstatic 28	com/j256/ormlite/android/AndroidDatabaseConnection:logger	Lcom/j256/ormlite/logger/Logger;
    //   69: astore 9
    //   71: iload 8
    //   73: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: astore 10
    //   78: aload 9
    //   80: ldc 158
    //   82: aload 4
    //   84: aload 10
    //   86: aload_1
    //   87: invokevirtual 50	com/j256/ormlite/logger/Logger:trace	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   90: iload 8
    //   92: ireturn
    //   93: astore 11
    //   95: new 78	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   102: ldc 160
    //   104: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: aload 11
    //   116: invokestatic 166	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   119: athrow
    //   120: astore 12
    //   122: aload 5
    //   124: ifnull +8 -> 132
    //   127: aload 5
    //   129: invokevirtual 146	android/database/sqlite/SQLiteStatement:close	()V
    //   132: aload 12
    //   134: athrow
    //   135: astore 13
    //   137: iconst_1
    //   138: istore 8
    //   140: aload 5
    //   142: ifnull -76 -> 66
    //   145: aload 5
    //   147: invokevirtual 146	android/database/sqlite/SQLiteStatement:close	()V
    //   150: goto -84 -> 66
    //   153: astore 14
    //   155: aload 5
    //   157: ifnull +8 -> 165
    //   160: aload 5
    //   162: invokevirtual 146	android/database/sqlite/SQLiteStatement:close	()V
    //   165: aload 14
    //   167: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	23	93	android/database/SQLException
    //   0	23	120	finally
    //   95	120	120	finally
    //   33	51	135	android/database/SQLException
    //   33	51	153	finally
  }

  public void close()
    throws java.sql.SQLException
  {
    try
    {
      this.db.close();
      Logger localLogger = logger;
      SQLiteDatabase localSQLiteDatabase = this.db;
      localLogger.trace("{}: db {} closed", this, localSQLiteDatabase);
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems closing the database connection", localSQLException);
    }
  }

  public void commit(Savepoint paramSavepoint)
    throws java.sql.SQLException
  {
    try
    {
      this.db.setTransactionSuccessful();
      this.db.endTransaction();
      if (paramSavepoint == null)
      {
        logger.trace("{}: transaction is successfuly ended", this);
        return;
      }
      Logger localLogger = logger;
      String str1 = paramSavepoint.getSavepointName();
      localLogger.trace("{}: transaction {} is successfuly ended", this, str1);
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("problems commiting transaction ");
      String str2 = paramSavepoint.getSavepointName();
      throw SqlExceptionUtil.create(str2, localSQLException);
    }
  }

  public CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType)
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    AndroidCompiledStatement localAndroidCompiledStatement = new AndroidCompiledStatement(paramString, localSQLiteDatabase, paramStatementType);
    logger.trace("{}: compiled statement got {}: {}", this, localAndroidCompiledStatement, paramString);
    return localAndroidCompiledStatement;
  }

  public CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType, int paramInt)
  {
    return compileStatement(paramString, paramStatementType, paramArrayOfFieldType);
  }

  public int delete(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    return update(paramString, paramArrayOfObject, paramArrayOfFieldType, "deleted");
  }

  public int insert(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GeneratedKeyHolder paramGeneratedKeyHolder)
    throws java.sql.SQLException
  {
    try
    {
      localSQLiteStatement = this.db.compileStatement(paramString);
      bindArgs(localSQLiteStatement, paramArrayOfObject, paramArrayOfFieldType);
      long l = localSQLiteStatement.executeInsert();
      if (paramGeneratedKeyHolder != null)
      {
        Long localLong = Long.valueOf(l);
        paramGeneratedKeyHolder.addKey(localLong);
      }
      int i = 1;
      Logger localLogger = logger;
      Integer localInteger = Integer.valueOf(i);
      localLogger.trace("{}: insert statement is compiled and executed, changed {}: {}", this, localInteger, paramString);
      return i;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("inserting to database failed: " + paramString, localSQLException);
    }
    finally
    {
      SQLiteStatement localSQLiteStatement;
      if (localSQLiteStatement != null)
        localSQLiteStatement.close();
    }
  }

  public boolean isAutoCommit()
    throws java.sql.SQLException
  {
    try
    {
      boolean bool1 = this.db.inTransaction();
      Logger localLogger = logger;
      Boolean localBoolean = Boolean.valueOf(bool1);
      localLogger.trace("{}: in transaction is {}", this, localBoolean);
      if (!bool1);
      for (boolean bool2 = true; ; bool2 = false)
        return bool2;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems getting auto-commit from database", localSQLException);
    }
  }

  public boolean isAutoCommitSupported()
  {
    return false;
  }

  public boolean isClosed()
    throws java.sql.SQLException
  {
    try
    {
      boolean bool1 = this.db.isOpen();
      Logger localLogger = logger;
      SQLiteDatabase localSQLiteDatabase = this.db;
      Boolean localBoolean = Boolean.valueOf(bool1);
      localLogger.trace("{}: db {} isOpen returned {}", this, localSQLiteDatabase, localBoolean);
      if (!bool1);
      for (boolean bool2 = true; ; bool2 = false)
        return bool2;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems detecting if the database is closed", localSQLException);
    }
  }

  public boolean isReadWrite()
  {
    return this.readWrite;
  }

  public boolean isTableExists(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    String str = "SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + paramString + "'";
    Cursor localCursor = localSQLiteDatabase.rawQuery(str, null);
    if ((localCursor != null) && (localCursor.getCount() > 0));
    for (boolean bool = true; ; bool = false)
    {
      Logger localLogger = logger;
      Boolean localBoolean = Boolean.valueOf(bool);
      localLogger.trace("{}: isTableExists '{}' returned {}", this, paramString, localBoolean);
      return bool;
    }
  }

  public long queryForLong(String paramString)
    throws java.sql.SQLException
  {
    try
    {
      localSQLiteStatement = this.db.compileStatement(paramString);
      long l = localSQLiteStatement.simpleQueryForLong();
      Logger localLogger = logger;
      Long localLong = Long.valueOf(l);
      localLogger.trace("{}: query for long simple query returned {}: {}", this, localLong, paramString);
      return l;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("queryForLong from database failed: " + paramString, localSQLException);
    }
    finally
    {
      SQLiteStatement localSQLiteStatement;
      if (localSQLiteStatement != null)
        localSQLiteStatement.close();
    }
  }

  public long queryForLong(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.db;
      String[] arrayOfString = toStrings(paramArrayOfObject);
      localCursor = localSQLiteDatabase.rawQuery(paramString, arrayOfString);
      AndroidDatabaseResults localAndroidDatabaseResults = new AndroidDatabaseResults(localCursor, null);
      if (localAndroidDatabaseResults.first());
      for (long l = localAndroidDatabaseResults.getLong(0); ; l = 0L)
      {
        Logger localLogger = logger;
        Long localLong = Long.valueOf(l);
        localLogger.trace("{}: query for long raw query returned {}: {}", this, localLong, paramString);
        return l;
      }
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("queryForLong from database failed: " + paramString, localSQLException);
    }
    finally
    {
      Cursor localCursor;
      if (localCursor != null)
        localCursor.close();
    }
  }

  public <T> Object queryForOne(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache)
    throws java.sql.SQLException
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.db;
      String[] arrayOfString = toStrings(paramArrayOfObject);
      localCursor = localSQLiteDatabase.rawQuery(paramString, arrayOfString);
      AndroidDatabaseResults localAndroidDatabaseResults = new AndroidDatabaseResults(localCursor, paramObjectCache);
      logger.trace("{}: queried for one result: {}", this, paramString);
      boolean bool = localAndroidDatabaseResults.first();
      Object localObject1;
      if (!bool)
        localObject1 = null;
      while (true)
      {
        return localObject1;
        localObject1 = paramGenericRowMapper.mapRow(localAndroidDatabaseResults);
        if (localAndroidDatabaseResults.next())
        {
          localObject1 = MORE_THAN_ONE;
          if (localCursor != null)
            localCursor.close();
        }
        else if (localCursor != null)
        {
          localCursor.close();
        }
      }
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("queryForOne from database failed: " + paramString, localSQLException);
    }
    finally
    {
      Cursor localCursor;
      if (localCursor != null)
        localCursor.close();
    }
  }

  public void rollback(Savepoint paramSavepoint)
    throws java.sql.SQLException
  {
    try
    {
      this.db.endTransaction();
      if (paramSavepoint == null)
      {
        logger.trace("{}: transaction is ended, unsuccessfuly", this);
        return;
      }
      Logger localLogger = logger;
      String str1 = paramSavepoint.getSavepointName();
      localLogger.trace("{}: transaction {} is ended, unsuccessfuly", this, str1);
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("problems rolling back transaction ");
      String str2 = paramSavepoint.getSavepointName();
      throw SqlExceptionUtil.create(str2, localSQLException);
    }
  }

  public void setAutoCommit(boolean paramBoolean)
  {
  }

  public Savepoint setSavePoint(String paramString)
    throws java.sql.SQLException
  {
    try
    {
      this.db.beginTransaction();
      logger.trace("{}: save-point set with name {}", this, paramString);
      OurSavePoint localOurSavePoint = new OurSavePoint(paramString);
      return localOurSavePoint;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems beginning transaction " + paramString, localSQLException);
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = getClass().getSimpleName();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("@");
    String str2 = Integer.toHexString(super.hashCode());
    return str2;
  }

  public int update(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    return update(paramString, paramArrayOfObject, paramArrayOfFieldType, "updated");
  }

  private static class OurSavePoint
    implements Savepoint
  {
    private String name;

    public OurSavePoint(String paramString)
    {
      this.name = paramString;
    }

    public int getSavepointId()
    {
      return 0;
    }

    public String getSavepointName()
    {
      return this.name;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.android.AndroidDatabaseConnection
 * JD-Core Version:    0.6.2
 */