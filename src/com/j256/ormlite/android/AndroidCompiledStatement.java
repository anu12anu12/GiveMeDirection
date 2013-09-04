package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.util.ArrayList;
import java.util.List;

public class AndroidCompiledStatement
  implements CompiledStatement
{
  private static final String[] NO_STRING_ARGS = new String[0];
  private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
  private List<Object> args;
  private Cursor cursor;
  private final SQLiteDatabase db;
  private Integer max;
  private final String sql;
  private final StatementBuilder.StatementType type;

  public AndroidCompiledStatement(String paramString, SQLiteDatabase paramSQLiteDatabase, StatementBuilder.StatementType paramStatementType)
  {
    this.sql = paramString;
    this.db = paramSQLiteDatabase;
    this.type = paramStatementType;
  }

  // ERROR //
  private int execSql(String paramString1, String paramString2)
    throws java.sql.SQLException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/j256/ormlite/android/AndroidCompiledStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_3
    //   5: aload_0
    //   6: invokespecial 58	com/j256/ormlite/android/AndroidCompiledStatement:getArgArray	()[Ljava/lang/Object;
    //   9: astore 4
    //   11: aload_3
    //   12: aload_2
    //   13: aload 4
    //   15: invokevirtual 64	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: getfield 46	com/j256/ormlite/android/AndroidCompiledStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   22: ldc 66
    //   24: invokevirtual 70	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 76	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   34: lstore 6
    //   36: lload 6
    //   38: l2i
    //   39: istore 8
    //   41: aload 5
    //   43: ifnull +8 -> 51
    //   46: aload 5
    //   48: invokevirtual 79	android/database/sqlite/SQLiteStatement:close	()V
    //   51: getstatic 34	com/j256/ormlite/android/AndroidCompiledStatement:logger	Lcom/j256/ormlite/logger/Logger;
    //   54: astore 9
    //   56: iload 8
    //   58: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: astore 10
    //   63: aload 9
    //   65: ldc 87
    //   67: aload_1
    //   68: aload 10
    //   70: aload_2
    //   71: invokevirtual 93	com/j256/ormlite/logger/Logger:trace	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   74: iload 8
    //   76: ireturn
    //   77: astore 11
    //   79: new 95	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   86: ldc 98
    //   88: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 104
    //   97: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload 11
    //   109: invokestatic 114	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   112: athrow
    //   113: astore 12
    //   115: iconst_1
    //   116: istore 8
    //   118: aload 5
    //   120: ifnull -69 -> 51
    //   123: aload 5
    //   125: invokevirtual 79	android/database/sqlite/SQLiteStatement:close	()V
    //   128: goto -77 -> 51
    //   131: astore 13
    //   133: aload 5
    //   135: ifnull +8 -> 143
    //   138: aload 5
    //   140: invokevirtual 79	android/database/sqlite/SQLiteStatement:close	()V
    //   143: aload 13
    //   145: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	18	77	android/database/SQLException
    //   18	36	113	android/database/SQLException
    //   18	36	131	finally
  }

  private Object[] getArgArray()
  {
    if (this.args == null);
    List localList;
    Object[] arrayOfObject;
    for (Object localObject = NO_STRING_ARGS; ; localObject = localList.toArray(arrayOfObject))
    {
      return localObject;
      localList = this.args;
      arrayOfObject = new Object[this.args.size()];
    }
  }

  private String[] getStringArray()
  {
    if (this.args == null);
    List localList;
    String[] arrayOfString2;
    for (String[] arrayOfString1 = NO_STRING_ARGS; ; arrayOfString1 = (String[])localList.toArray(arrayOfString2))
    {
      return arrayOfString1;
      localList = this.args;
      arrayOfString2 = new String[this.args.size()];
    }
  }

  private void isInPrep()
    throws java.sql.SQLException
  {
    if (this.cursor == null)
      return;
    throw new java.sql.SQLException("Query already run. Cannot add argument values.");
  }

  public void close()
    throws java.sql.SQLException
  {
    if (this.cursor == null)
      return;
    try
    {
      this.cursor.close();
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Problems closing Android cursor", localSQLException);
    }
  }

  public int getColumnCount()
    throws java.sql.SQLException
  {
    return getCursor().getColumnCount();
  }

  public String getColumnName(int paramInt)
    throws java.sql.SQLException
  {
    return getCursor().getColumnName(paramInt);
  }

  public Cursor getCursor()
    throws java.sql.SQLException
  {
    Object localObject;
    if (this.cursor == null)
      localObject = null;
    try
    {
      if (this.max == null);
      String str2;
      for (localObject = this.sql; ; localObject = str2)
      {
        SQLiteDatabase localSQLiteDatabase = this.db;
        String[] arrayOfString = getStringArray();
        Cursor localCursor = localSQLiteDatabase.rawQuery((String)localObject, arrayOfString);
        this.cursor = localCursor;
        boolean bool = this.cursor.moveToFirst();
        logger.trace("{}: started rawQuery cursor for: {}", this, localObject);
        return this.cursor;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = this.sql;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" ");
        Integer localInteger = this.max;
        str2 = localInteger;
      }
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Problems executing Android query: " + (String)localObject, localSQLException);
    }
  }

  public int runExecute()
    throws java.sql.SQLException
  {
    if (!this.type.isOkForExecute())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Cannot call execute on a ");
      StatementBuilder.StatementType localStatementType = this.type;
      String str1 = localStatementType + " statement";
      throw new IllegalArgumentException(str1);
    }
    String str2 = this.sql;
    return execSql("runExecute", str2);
  }

  public DatabaseResults runQuery(ObjectCache paramObjectCache)
    throws java.sql.SQLException
  {
    if (!this.type.isOkForQuery())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Cannot call query on a ");
      StatementBuilder.StatementType localStatementType = this.type;
      String str = localStatementType + " statement";
      throw new IllegalArgumentException(str);
    }
    Cursor localCursor = getCursor();
    return new AndroidDatabaseResults(localCursor, paramObjectCache);
  }

  public int runUpdate()
    throws java.sql.SQLException
  {
    if (!this.type.isOkForUpdate())
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("Cannot call update on a ");
      StatementBuilder.StatementType localStatementType = this.type;
      String str1 = localStatementType + " statement";
      throw new IllegalArgumentException(str1);
    }
    if (this.max == null);
    StringBuilder localStringBuilder3;
    Integer localInteger;
    for (String str2 = this.sql; ; str2 = localInteger)
    {
      return execSql("runUpdate", str2);
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str3 = this.sql;
      localStringBuilder3 = localStringBuilder2.append(str3).append(" ");
      localInteger = this.max;
    }
  }

  public void setMaxRows(int paramInt)
    throws java.sql.SQLException
  {
    isInPrep();
    Integer localInteger = Integer.valueOf(paramInt);
    this.max = localInteger;
  }

  public void setObject(int paramInt, Object paramObject, SqlType paramSqlType)
    throws java.sql.SQLException
  {
    isInPrep();
    if (this.args == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.args = localArrayList;
    }
    if (paramObject == null)
    {
      this.args.add(paramInt, null);
      return;
    }
    List localList = this.args;
    String str = paramObject.toString();
    localList.add(paramInt, str);
  }

  public void setQueryTimeout(long paramLong)
  {
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
 * Qualified Name:     com.j256.ormlite.android.AndroidCompiledStatement
 * JD-Core Version:    0.6.2
 */