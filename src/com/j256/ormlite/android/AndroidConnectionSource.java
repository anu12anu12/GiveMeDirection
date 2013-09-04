package com.j256.ormlite.android;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;

public class AndroidConnectionSource extends BaseConnectionSource
  implements ConnectionSource
{
  private static final Logger logger = LoggerFactory.getLogger(AndroidConnectionSource.class);
  private AndroidDatabaseConnection connection = null;
  private final DatabaseType databaseType;
  private final SQLiteOpenHelper helper;
  private volatile boolean isOpen = true;
  private final SQLiteDatabase sqliteDatabase;

  public AndroidConnectionSource(SQLiteDatabase paramSQLiteDatabase)
  {
    SqliteAndroidDatabaseType localSqliteAndroidDatabaseType = new SqliteAndroidDatabaseType();
    this.databaseType = localSqliteAndroidDatabaseType;
    this.helper = null;
    this.sqliteDatabase = paramSQLiteDatabase;
  }

  public AndroidConnectionSource(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    SqliteAndroidDatabaseType localSqliteAndroidDatabaseType = new SqliteAndroidDatabaseType();
    this.databaseType = localSqliteAndroidDatabaseType;
    this.helper = paramSQLiteOpenHelper;
    this.sqliteDatabase = null;
  }

  public void clearSpecialConnection(DatabaseConnection paramDatabaseConnection)
  {
    Logger localLogger = logger;
    boolean bool = clearSpecial(paramDatabaseConnection, localLogger);
  }

  public void close()
  {
    this.isOpen = false;
  }

  public DatabaseType getDatabaseType()
  {
    return this.databaseType;
  }

  public DatabaseConnection getReadOnlyConnection()
    throws java.sql.SQLException
  {
    return getReadWriteConnection();
  }

  public DatabaseConnection getReadWriteConnection()
    throws java.sql.SQLException
  {
    Object localObject = getSavedConnection();
    if (localObject != null)
      return localObject;
    if (this.connection == null)
      if (this.sqliteDatabase != null);
    while (true)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase1 = this.helper.getWritableDatabase();
        localSQLiteDatabase2 = localSQLiteDatabase1;
        AndroidDatabaseConnection localAndroidDatabaseConnection1 = new AndroidDatabaseConnection(localSQLiteDatabase2, true);
        this.connection = localAndroidDatabaseConnection1;
        Logger localLogger1 = logger;
        AndroidDatabaseConnection localAndroidDatabaseConnection2 = this.connection;
        SQLiteOpenHelper localSQLiteOpenHelper1 = this.helper;
        localLogger1.trace("created connection {} for db {}, helper {}", localAndroidDatabaseConnection2, localSQLiteDatabase2, localSQLiteOpenHelper1);
        localObject = this.connection;
      }
      catch (android.database.SQLException localSQLException)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Getting a writable database from helper ");
        SQLiteOpenHelper localSQLiteOpenHelper2 = this.helper;
        throw SqlExceptionUtil.create(localSQLiteOpenHelper2 + " failed", localSQLException);
      }
      SQLiteDatabase localSQLiteDatabase2 = this.sqliteDatabase;
      continue;
      Logger localLogger2 = logger;
      AndroidDatabaseConnection localAndroidDatabaseConnection3 = this.connection;
      SQLiteOpenHelper localSQLiteOpenHelper3 = this.helper;
      localLogger2.trace("{}: returning read-write connection {}, helper {}", this, localAndroidDatabaseConnection3, localSQLiteOpenHelper3);
    }
  }

  public boolean isOpen()
  {
    return this.isOpen;
  }

  public void releaseConnection(DatabaseConnection paramDatabaseConnection)
  {
  }

  public boolean saveSpecialConnection(DatabaseConnection paramDatabaseConnection)
    throws java.sql.SQLException
  {
    return saveSpecial(paramDatabaseConnection);
  }

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
 * Qualified Name:     com.j256.ormlite.android.AndroidConnectionSource
 * JD-Core Version:    0.6.2
 */