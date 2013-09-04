package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public abstract class OrmLiteSqliteOpenHelper extends SQLiteOpenHelper
{
  protected static Logger logger = LoggerFactory.getLogger(OrmLiteSqliteOpenHelper.class);
  protected AndroidConnectionSource connectionSource;
  private volatile boolean isOpen;

  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    AndroidConnectionSource localAndroidConnectionSource1 = new AndroidConnectionSource(this);
    this.connectionSource = localAndroidConnectionSource1;
    this.isOpen = true;
    Logger localLogger = logger;
    AndroidConnectionSource localAndroidConnectionSource2 = this.connectionSource;
    localLogger.trace("{}: constructed connectionSource {}", this, localAndroidConnectionSource2);
  }

  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, int paramInt2)
  {
  }

  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, File paramFile)
  {
  }

  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, InputStream paramInputStream)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    AndroidConnectionSource localAndroidConnectionSource = new AndroidConnectionSource(this);
    this.connectionSource = localAndroidConnectionSource;
    this.isOpen = true;
    if (paramInputStream == null)
      return;
    try
    {
      InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream);
      DaoManager.addCachedDatabaseConfigs(DatabaseTableConfigLoader.loadDatabaseConfigFromReader(new BufferedReader(localInputStreamReader, 4096)));
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        return;
      }
    }
    catch (SQLException localSQLException)
    {
      localSQLException = localSQLException;
      throw new IllegalStateException("Could not load object config file", localSQLException);
    }
    finally
    {
    }
    try
    {
      paramInputStream.close();
      label95: throw localObject;
    }
    catch (IOException localIOException2)
    {
      break label95;
    }
  }

  private static InputStream openFile(File paramFile)
  {
    Object localObject;
    if (paramFile == null)
      localObject = null;
    while (true)
    {
      return localObject;
      try
      {
        localObject = new FileInputStream(paramFile);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        String str = "Could not open config file " + paramFile;
        throw new IllegalArgumentException(str, localFileNotFoundException);
      }
    }
  }

  private static InputStream openFileId(Context paramContext, int paramInt)
  {
    InputStream localInputStream = paramContext.getResources().openRawResource(paramInt);
    if (localInputStream == null)
    {
      String str = "Could not find object config file with id " + paramInt;
      throw new IllegalStateException(str);
    }
    return localInputStream;
  }

  public void close()
  {
    super.close();
    this.connectionSource.close();
    this.isOpen = false;
  }

  public ConnectionSource getConnectionSource()
  {
    if (!this.isOpen)
    {
      Logger localLogger = logger;
      IllegalStateException localIllegalStateException = new IllegalStateException();
      localLogger.warn(localIllegalStateException, "Getting connectionSource was called after closed");
    }
    return this.connectionSource;
  }

  public <D extends Dao<T, ?>, T> D getDao(Class<T> paramClass)
    throws SQLException
  {
    return DaoManager.createDao(getConnectionSource(), paramClass);
  }

  public <D extends RuntimeExceptionDao<T, ?>, T> D getRuntimeExceptionDao(Class<T> paramClass)
  {
    try
    {
      Dao localDao = getDao(paramClass);
      RuntimeExceptionDao localRuntimeExceptionDao = new RuntimeExceptionDao(localDao);
      return localRuntimeExceptionDao;
    }
    catch (SQLException localSQLException)
    {
      String str = "Could not create RuntimeExcepitionDao for class " + paramClass;
      throw new RuntimeException(str, localSQLException);
    }
  }

  public boolean isOpen()
  {
    return this.isOpen;
  }

  // ERROR //
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 155	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:getConnectionSource	()Lcom/j256/ormlite/support/ConnectionSource;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface 182 1 0
    //   11: astore_3
    //   12: iconst_0
    //   13: istore 4
    //   15: aload_3
    //   16: ifnonnull +25 -> 41
    //   19: new 184	com/j256/ormlite/android/AndroidDatabaseConnection
    //   22: dup
    //   23: aload_1
    //   24: iconst_1
    //   25: invokespecial 187	com/j256/ormlite/android/AndroidDatabaseConnection:<init>	(Landroid/database/sqlite/SQLiteDatabase;Z)V
    //   28: astore_3
    //   29: aload_2
    //   30: aload_3
    //   31: invokeinterface 191 2 0
    //   36: istore 5
    //   38: iconst_1
    //   39: istore 4
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokevirtual 194	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:onCreate	(Landroid/database/sqlite/SQLiteDatabase;Lcom/j256/ormlite/support/ConnectionSource;)V
    //   47: iload 4
    //   49: ifne +4 -> 53
    //   52: return
    //   53: aload_2
    //   54: aload_3
    //   55: invokeinterface 198 2 0
    //   60: return
    //   61: astore 6
    //   63: new 88	java/lang/IllegalStateException
    //   66: dup
    //   67: ldc 200
    //   69: aload 6
    //   71: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: athrow
    //   75: astore 7
    //   77: iload 4
    //   79: ifeq +10 -> 89
    //   82: aload_2
    //   83: aload_3
    //   84: invokeinterface 198 2 0
    //   89: aload 7
    //   91: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   29	38	61	java/sql/SQLException
    //   41	47	75	finally
  }

  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource);

  // ERROR //
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 155	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:getConnectionSource	()Lcom/j256/ormlite/support/ConnectionSource;
    //   4: astore 4
    //   6: aload 4
    //   8: invokeinterface 182 1 0
    //   13: astore 5
    //   15: iconst_0
    //   16: istore 6
    //   18: aload 5
    //   20: ifnonnull +28 -> 48
    //   23: new 184	com/j256/ormlite/android/AndroidDatabaseConnection
    //   26: dup
    //   27: aload_1
    //   28: iconst_1
    //   29: invokespecial 187	com/j256/ormlite/android/AndroidDatabaseConnection:<init>	(Landroid/database/sqlite/SQLiteDatabase;Z)V
    //   32: astore 5
    //   34: aload 4
    //   36: aload 5
    //   38: invokeinterface 191 2 0
    //   43: istore 7
    //   45: iconst_1
    //   46: istore 6
    //   48: aload_0
    //   49: aload_1
    //   50: aload 4
    //   52: iload_2
    //   53: iload_3
    //   54: invokevirtual 205	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:onUpgrade	(Landroid/database/sqlite/SQLiteDatabase;Lcom/j256/ormlite/support/ConnectionSource;II)V
    //   57: iload 6
    //   59: ifne +4 -> 63
    //   62: return
    //   63: aload 4
    //   65: aload 5
    //   67: invokeinterface 198 2 0
    //   72: return
    //   73: astore 8
    //   75: new 88	java/lang/IllegalStateException
    //   78: dup
    //   79: ldc 200
    //   81: aload 8
    //   83: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore 9
    //   89: iload 6
    //   91: ifeq +12 -> 103
    //   94: aload 4
    //   96: aload 5
    //   98: invokeinterface 198 2 0
    //   103: aload 9
    //   105: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   34	45	73	java/sql/SQLException
    //   48	57	87	finally
  }

  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource, int paramInt1, int paramInt2);

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = getClass().getSimpleName();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("@");
    String str2 = Integer.toHexString(super.hashCode());
    return str2;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
 * JD-Core Version:    0.6.2
 */