package com.hopstop.ClientModel.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HopStopDB extends SQLiteOpenHelper
{
  static final String CELL_GATEWAY_COL = "cellGateway";
  private static final String DB_NAME = "hopstop_db.db";
  private static final int DB_VERSION = 6;
  static final String DEFAUL_COUNTRY_COL = "defaultCounty";
  static final String ID_COL = "id";
  static final String LAST_TIME_GET_CITIES_UPDATED = "last_time_cities_updated";
  static final String NAME_COL = "name";
  static final String SETTINGS_VALUES = "Settings_Values";
  static final String STATE_COL = "state";
  static final String TABLE_NAME_CITIES = "cities";
  static final String TABLE_NAME_SETTINGS = "settings_db";
  static final String TIMESTAMP_COL = "timestamp";
  static final String USE_PLACES_COL = "usePlaces";

  public HopStopDB(Context paramContext)
  {
    super(paramContext, "hopstop_db.db", null, 6);
  }

  public HopStopDB(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
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
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings_db (Settings_Values TEXT, timestamp LONG);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cities (cellGateway TEXT, defaultCounty TEXT, id TEXT, name TEXT, state TEXT, usePlaces TEXT);");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 5) && (paramInt2 == 6))
      return;
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS cities");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS settings_db");
      label24: onCreate(paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      break label24;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.db.HopStopDB
 * JD-Core Version:    0.6.2
 */