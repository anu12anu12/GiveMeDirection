package com.hopstop.ClientModel.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.List;

public class HopStopMyTripsDB extends SQLiteOpenHelper
{
  static final String ADDRESS1_COL = "address1";
  static final String ADDRESS2_COL = "address2";
  static final String CITY1_COL = "city1";
  static final String CITY2_COL = "city2";
  static final String COUNTY1_COL = "county1";
  static final String COUNTY2_COL = "county2";
  private static final String DB_NAME = "hopstop_db.db";
  static final int DB_VERSION = 6;
  static final String DIRECTIONS_COL = "directions";
  static final String END_POINT_LATITUDE = "end_point_latitude";
  static final String END_POINT_LONGTITUDE = "end_point_longitude";
  static final String FARE = "fare";
  static final String HAS_DIVERSION_COL = "has_diversion";
  static final String ICON_HEIGHT_COL = "icon_height";
  static final String ICON_WIDTH_COL = "icon_width";
  private static final String[] ID_COL_UPDATE_DISTANCE_AND_DURATION = arrayOfString;
  static final String IS_ROAD_BIKE_FRIENDLY = "is_bike_friendly";
  static final String IS_TAXI_COL = "is_taxi";
  static final String IS_WHEELCHAIR_ACCESSIBLE = "wheelchair_accessible";
  static final String LANGUAGE_COL = "language";
  static final String LATITUDE = "latitude";
  static final String LONGTITUDE = "longitude";
  static final String MAP_ID = "map_id";
  static final String MAP_IMAGE_COL = "map_image";
  static final String MAP_TITLE_COL = "map_title";
  static final String MAP_URL_COL = "map_url";
  static final String OPTION_VEHICLES_COL = "optional_vehicles";
  static final String PATH_COL = "path";
  static final String PATH_ICON_COL = "path_icon";
  static final String ROUTEID_COL = "routeId";
  static final String ROUTE_COLOR = "route_color";
  static final String ROUTE_GEO_POINTS_ID = "route_geo_points_id";
  static final String ROUTE_ICON_NAME = "route_icon_name";
  static final String ROUTE_ICON_OCCURRED = "route_icon_occurred";
  static final String ROUTE_ICON_URL = "route_icon_url";
  static final String START_POINT_LATITUDE = "start_point_latitude";
  static final String START_POINT_LONGTITUDE = "start_point_longitude";
  static final String STEP_ID = "step_id";
  static final String STEP_TIME_COL = "step_time";
  static final String STOP_ID_COL = "stop_id";
  static final String TABLE_MY_TRIPS = "my_trips";
  static final String TABLE_MY_TRIPS_MAPS = "my_trips_maps";
  static final String TABLE_MY_TRIPS_STEPS = "my_trips_steps";
  static final String TABLE_MY_TRIPS_TAXI = "my_trips_taxis";
  static final String TABLE_ROUTE_GEO_POINTS = "my_trips_route_geo_points";
  static final String TABLE_ROUTE_ICONS = "my_trips_route_icons";
  static final String TAXI_DESCRIPTION = "description";
  static final String TAXI_DISTANCE = "distance";
  static final String TAXI_DRIVING_TIME = "driving_time";
  static final String TAXI_ID = "id";
  static final String TAXI_NAME = "name";
  static final String TAXI_NOTE = "note";
  static final String TAXI_PHONE = "phone";
  static final String TAXI_PRICE = "price";
  static final String TAXI_STEP_ID = "step_id";
  static final String TRIP_ARRIVE = "trip_arrive";
  static final String TRIP_C02 = "trip_co2";
  static final String TRIP_CALORIES = "trip_calories";
  static final String TRIP_DEPART = "trip_depart";
  static final String TRIP_DISTANCE = "trip_distance";
  static final String TRIP_DURATION = "trip_duration";
  static final String TRIP_NAME = "trip_name";
  static final String TRIP_TOTAL_TIME = "trip_total_time";
  static final String TYPE_COL = "type";
  static final String VEHICLES_ID_COL = "vehicle_id";
  static final String VEHICLES_NAME_COL = "vehicle_name";
  static final String WALKING_TIME = "walking_time";
  static final String ZIP1_COL = "zip1";
  static final String ZIP2_COL = "zip2";

  static
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "trip_total_time";
  }

  public HopStopMyTripsDB(Context paramContext)
  {
    super(paramContext, "hopstop_db.db", null, 6);
  }

  public HopStopMyTripsDB(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }

  private void updateDistanceAndDuration(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString1 = ID_COL_UPDATE_DISTANCE_AND_DURATION;
    Cursor localCursor = paramSQLiteDatabase.query("my_trips", arrayOfString1, null, null, null, null, null);
    while (true)
    {
      if (!localCursor.moveToNext())
        return;
      String str1 = localCursor.getString(0);
      ContentValues localContentValues = new ContentValues();
      String[] arrayOfString2 = str1.split(",");
      String str2 = arrayOfString2[0].split(" ")[2];
      localContentValues.put("trip_distance", str2);
      String str3 = arrayOfString2[1];
      localContentValues.put("trip_duration", str3);
      try
      {
        String[] arrayOfString3 = new String[1];
        arrayOfString3[0] = str1;
        int i = paramSQLiteDatabase.update("my_trips", localContentValues, "trip_total_time=?", arrayOfString3);
        int j = i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }

  private void upgradeVersion3(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    List localList1 = DBUtils.GetColumns(paramSQLiteDatabase, "my_trips");
    paramSQLiteDatabase.execSQL("ALTER table my_trips RENAME TO 'temp_my_trips';");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips (trip_name TEXT, trip_total_time TEXT, trip_distance TEXT, trip_duration TEXT, trip_depart TEXT, trip_arrive TEXT, trip_calories TEXT, trip_co2 TEXT, address1 TEXT, county1 DOUBLE, city1 TEXT, zip1 TEXT, address2 TEXT, county2 DOUBLE, city2 TEXT, zip2 TEXT, routeId TEXT, language TEXT, is_taxi BOOLEAN, wheelchair_accessible BOOLEAN, walking_time INTEGER, fare TEXT);");
    List localList2 = DBUtils.GetColumns(paramSQLiteDatabase, "my_trips");
    boolean bool = localList1.retainAll(localList2);
    String str1 = DBUtils.join(localList1, ",");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "my_trips";
    arrayOfObject[1] = str1;
    arrayOfObject[2] = str1;
    arrayOfObject[3] = "my_trips";
    String str2 = String.format("INSERT INTO %s (%s) SELECT %s from temp_%s", arrayOfObject);
    paramSQLiteDatabase.execSQL(str2);
    paramSQLiteDatabase.execSQL("DROP table 'temp_my_trips';");
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
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips (trip_name TEXT, trip_total_time TEXT, trip_distance TEXT, trip_duration TEXT, trip_depart TEXT, trip_arrive TEXT, trip_calories TEXT, trip_co2 TEXT, address1 TEXT, county1 DOUBLE, city1 TEXT, zip1 TEXT, address2 TEXT, county2 DOUBLE, city2 TEXT, zip2 TEXT, routeId TEXT, language TEXT, is_taxi BOOLEAN, wheelchair_accessible BOOLEAN, walking_time INTEGER, fare TEXT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips_steps (step_id INTEGER, trip_name TEXT, directions TEXT, step_time TEXT, type TEXT, path TEXT, path_icon BLOB, icon_width INTEGER, icon_height INTEGER, optional_vehicles TEXT, stop_id INTEGER, vehicle_id INTEGER, vehicle_name TEXT, has_diversion INTEGER, is_bike_friendly BOOLEAN);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips_maps (map_id INTEGER, trip_name TEXT, map_url TEXT, map_title TEXT, map_image BLOB);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips_taxis (step_id INTEGER, trip_name TEXT, description TEXT, distance FLOAT, driving_time INTEGER, id TEXT, name TEXT, note TEXT, phone TEXT, price FLOAT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips_route_icons (trip_name TEXT, longitude INTEGER, latitude INTEGER, route_icon_name TEXT, route_icon_url TEXT, route_icon_occurred INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips_route_geo_points (route_geo_points_id INTEGER, trip_name TEXT, start_point_longitude INTEGER, start_point_latitude INTEGER, end_point_longitude INTEGER, end_point_latitude INTEGER, route_color INTEGER);");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS notes");
      onCreate(paramSQLiteDatabase);
      return;
      try
      {
        List localList1 = DBUtils.GetColumns(paramSQLiteDatabase, "my_trips");
        paramSQLiteDatabase.execSQL("ALTER table my_trips RENAME TO 'temp_my_trips';");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips (trip_name TEXT, trip_total_time TEXT, trip_distance TEXT, trip_duration TEXT, trip_depart TEXT, trip_arrive TEXT, trip_calories TEXT, trip_co2 TEXT, address1 TEXT, county1 DOUBLE, city1 TEXT, zip1 TEXT, address2 TEXT, county2 DOUBLE, city2 TEXT, zip2 TEXT, routeId TEXT, language TEXT, is_taxi BOOLEAN, wheelchair_accessible BOOLEAN, walking_time INTEGER, fare TEXT);");
        List localList2 = DBUtils.GetColumns(paramSQLiteDatabase, "my_trips");
        boolean bool1 = localList1.retainAll(localList2);
        String str1 = DBUtils.join(localList1, ",");
        Object[] arrayOfObject1 = new Object[4];
        arrayOfObject1[0] = "my_trips";
        arrayOfObject1[1] = str1;
        arrayOfObject1[2] = str1;
        arrayOfObject1[3] = "my_trips";
        String str2 = String.format("INSERT INTO %s (%s) SELECT %s from temp_%s", arrayOfObject1);
        paramSQLiteDatabase.execSQL(str2);
        updateDistanceAndDuration(paramSQLiteDatabase);
        paramSQLiteDatabase.execSQL("DROP table 'temp_my_trips';");
        List localList3 = DBUtils.GetColumns(paramSQLiteDatabase, "my_trips_steps");
        paramSQLiteDatabase.execSQL("ALTER table my_trips_steps RENAME TO 'temp_my_trips_steps';");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS my_trips_steps (step_id INTEGER, trip_name TEXT, directions TEXT, step_time TEXT, type TEXT, path TEXT, path_icon BLOB, icon_width INTEGER, icon_height INTEGER, optional_vehicles TEXT, stop_id INTEGER, vehicle_id INTEGER, vehicle_name TEXT, has_diversion INTEGER, is_bike_friendly BOOLEAN);");
        List localList4 = DBUtils.GetColumns(paramSQLiteDatabase, "my_trips_steps");
        boolean bool2 = localList3.retainAll(localList4);
        String str3 = DBUtils.join(localList3, ",");
        Object[] arrayOfObject2 = new Object[4];
        arrayOfObject2[0] = "my_trips_steps";
        arrayOfObject2[1] = str3;
        arrayOfObject2[2] = str3;
        arrayOfObject2[3] = "my_trips_steps";
        String str4 = String.format("INSERT INTO %s (%s) SELECT %s from temp_%s", arrayOfObject2);
        paramSQLiteDatabase.execSQL(str4);
        paramSQLiteDatabase.execSQL("DROP table 'temp_my_trips_steps';");
        try
        {
          label256: upgradeVersion3(paramSQLiteDatabase, paramInt1, paramInt2);
        }
        catch (SQLException localSQLException2)
        {
          try
          {
            while (true)
            {
              while (true)
              {
                paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS cities");
                paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS settings_db");
                try
                {
                  label277: paramSQLiteDatabase.execSQL("ALTER TABLE my_trips ADD COLUMN walking_time INTEGER");
                  paramSQLiteDatabase.execSQL("ALTER TABLE my_trips ADD COLUMN fare TEXT");
                }
                catch (SQLException localSQLException1)
                {
                }
              }
              break;
              localSQLException2 = localSQLException2;
            }
          }
          catch (SQLException localSQLException3)
          {
            break label277;
          }
        }
      }
      catch (SQLException localSQLException4)
      {
        break label256;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.db.HopStopMyTripsDB
 * JD-Core Version:    0.6.2
 */