package com.hopstop.ClientModel.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HopStopHistoryCallsDB extends SQLiteOpenHelper
{
  static String ADDRESS_VALUES = "Address_Values";
  private static final String DB_NAME = "hopstop_db.db";
  private static final int DB_VERSION = 6;
  public static final String HISTORY_ADDRESS_CONNECTOR = "&&";
  static final String TABLE_NAME_HISTORY_CALLS = "history_calls";
  static final String TIMESTAMP_COL = "timestamp";

  public HopStopHistoryCallsDB(Context paramContext)
  {
    super(paramContext, "hopstop_db.db", null, 6);
  }

  public HopStopHistoryCallsDB(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }

  /** @deprecated */
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS history_calls (");
    String str1 = ADDRESS_VALUES;
    String str2 = str1 + " TEXT, " + "timestamp" + " LONG" + ");";
    paramSQLiteDatabase.execSQL(str2);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS dimitare");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.db.HopStopHistoryCallsDB
 * JD-Core Version:    0.6.2
 */