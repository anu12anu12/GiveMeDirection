package com.hopstop.ClientModel.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import com.google.android.maps.GeoPoint;
import com.hopstop.ClientModel.HopStopCity;
import com.hopstop.ClientModel.directions.GeoPoints;
import com.hopstop.ClientModel.directions.RouteIcons;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepDirections;
import com.hopstop.ClientModel.directions.ViewStepMap;
import com.hopstop.ClientModel.directions.ViewStepTaxi;
import com.hopstop.ClientModel.xml.CitiesSet;
import com.hopstop.ClientModel.xml.GetCitiesHandler;
import com.hopstop.ClientView.MoreMyTripsDirectionActivity;
import com.hopstop.SplashScreen;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseActivity;
import com.hopstop.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class HistoryManager
{
  private static final String[] ID_COL_CITIES;
  private static final String[] ID_COL_HISTORY_CALLS;
  private static final String[] ID_COL_MY_TRIPS;
  private static final String[] ID_COL_MY_TRIPS_GEO_POINTS = arrayOfString9;
  private static final String[] ID_COL_MY_TRIPS_MAPS;
  private static final String[] ID_COL_MY_TRIPS_ROUTE_ICONS;
  private static final String[] ID_COL_MY_TRIPS_STEPS;
  private static final String[] ID_COL_MY_TRIPS_TAXIS;
  private static final String[] ID_COL_SETTINGS;
  private static final int MAX_ITEMS = 200;
  private final Context context;
  private DatabaseQueue dbQueue;
  private SQLiteOpenHelper history_calls;
  private HopStopMyTripsDB my_trips;
  private Hashtable<String, ImageView> observable;

  static
  {
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "Settings_Values";
    arrayOfString1[1] = "timestamp";
    ID_COL_SETTINGS = arrayOfString1;
    String[] arrayOfString2 = new String[7];
    arrayOfString2[0] = "cellGateway";
    arrayOfString2[1] = "defaultCounty";
    arrayOfString2[2] = "id";
    arrayOfString2[3] = "name";
    arrayOfString2[4] = "name";
    arrayOfString2[5] = "state";
    arrayOfString2[6] = "usePlaces";
    ID_COL_CITIES = arrayOfString2;
    String[] arrayOfString3 = new String[2];
    String str = HopStopHistoryCallsDB.ADDRESS_VALUES;
    arrayOfString3[0] = str;
    arrayOfString3[1] = "timestamp";
    ID_COL_HISTORY_CALLS = arrayOfString3;
    String[] arrayOfString4 = new String[21];
    arrayOfString4[0] = "trip_name";
    arrayOfString4[1] = "trip_total_time";
    arrayOfString4[2] = "trip_distance";
    arrayOfString4[3] = "trip_duration";
    arrayOfString4[4] = "trip_depart";
    arrayOfString4[5] = "trip_arrive";
    arrayOfString4[6] = "trip_calories";
    arrayOfString4[7] = "trip_co2";
    arrayOfString4[8] = "address1";
    arrayOfString4[9] = "county1";
    arrayOfString4[10] = "city1";
    arrayOfString4[11] = "zip1";
    arrayOfString4[12] = "address2";
    arrayOfString4[13] = "county2";
    arrayOfString4[14] = "city2";
    arrayOfString4[15] = "zip2";
    arrayOfString4[16] = "routeId";
    arrayOfString4[17] = "is_taxi";
    arrayOfString4[18] = "wheelchair_accessible";
    arrayOfString4[19] = "walking_time";
    arrayOfString4[20] = "fare";
    ID_COL_MY_TRIPS = arrayOfString4;
    String[] arrayOfString5 = new String[15];
    arrayOfString5[0] = "step_id";
    arrayOfString5[1] = "trip_name";
    arrayOfString5[2] = "directions";
    arrayOfString5[3] = "step_time";
    arrayOfString5[4] = "type";
    arrayOfString5[5] = "path";
    arrayOfString5[6] = "path_icon";
    arrayOfString5[7] = "icon_width";
    arrayOfString5[8] = "icon_height";
    arrayOfString5[9] = "optional_vehicles";
    arrayOfString5[10] = "stop_id";
    arrayOfString5[11] = "vehicle_id";
    arrayOfString5[12] = "vehicle_name";
    arrayOfString5[13] = "has_diversion";
    arrayOfString5[14] = "is_bike_friendly";
    ID_COL_MY_TRIPS_STEPS = arrayOfString5;
    String[] arrayOfString6 = new String[4];
    arrayOfString6[0] = "map_id";
    arrayOfString6[1] = "trip_name";
    arrayOfString6[2] = "map_url";
    arrayOfString6[3] = "map_title";
    ID_COL_MY_TRIPS_MAPS = arrayOfString6;
    String[] arrayOfString7 = new String[10];
    arrayOfString7[0] = "step_id";
    arrayOfString7[1] = "trip_name";
    arrayOfString7[2] = "description";
    arrayOfString7[3] = "distance";
    arrayOfString7[4] = "driving_time";
    arrayOfString7[5] = "id";
    arrayOfString7[6] = "name";
    arrayOfString7[7] = "note";
    arrayOfString7[8] = "phone";
    arrayOfString7[9] = "price";
    ID_COL_MY_TRIPS_TAXIS = arrayOfString7;
    String[] arrayOfString8 = new String[6];
    arrayOfString8[0] = "trip_name";
    arrayOfString8[1] = "longitude";
    arrayOfString8[2] = "latitude";
    arrayOfString8[3] = "route_icon_name";
    arrayOfString8[4] = "route_icon_url";
    arrayOfString8[5] = "route_icon_occurred";
    ID_COL_MY_TRIPS_ROUTE_ICONS = arrayOfString8;
    String[] arrayOfString9 = new String[7];
    arrayOfString9[0] = "route_geo_points_id";
    arrayOfString9[1] = "trip_name";
    arrayOfString9[2] = "start_point_longitude";
    arrayOfString9[3] = "start_point_latitude";
    arrayOfString9[4] = "end_point_longitude";
    arrayOfString9[5] = "end_point_latitude";
    arrayOfString9[6] = "route_color";
  }

  public HistoryManager(Context paramContext)
  {
    Hashtable localHashtable = new Hashtable();
    this.observable = localHashtable;
    DatabaseQueue localDatabaseQueue = new DatabaseQueue(null);
    this.dbQueue = localDatabaseQueue;
    this.context = paramContext;
    HopStopMyTripsDB localHopStopMyTripsDB = new HopStopMyTripsDB(paramContext);
    this.my_trips = localHopStopMyTripsDB;
    SQLiteDatabase localSQLiteDatabase1 = this.my_trips.getWritableDatabase();
    this.my_trips.onCreate(localSQLiteDatabase1);
    HopStopHistoryCallsDB localHopStopHistoryCallsDB = new HopStopHistoryCallsDB(paramContext);
    this.history_calls = localHopStopHistoryCallsDB;
    SQLiteDatabase localSQLiteDatabase2 = this.history_calls.getWritableDatabase();
    this.history_calls.onCreate(localSQLiteDatabase2);
    HopStopDB localHopStopDB = new HopStopDB(paramContext);
    SQLiteDatabase localSQLiteDatabase3 = localHopStopDB.getWritableDatabase();
    localHopStopDB.onCreate(localSQLiteDatabase3);
    if (localSQLiteDatabase3 != null)
      localSQLiteDatabase3.close();
    if (localHopStopDB != null)
      localHopStopDB.close();
    if (this.history_calls != null)
      this.history_calls.close();
    if (this.my_trips == null)
      return;
    this.my_trips.close();
  }

  private int cleanIfExsist(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    int i = 0;
    try
    {
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = paramString;
      int j = paramSQLiteDatabase.delete("my_trips", "trip_name=?", arrayOfString1);
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = paramString;
      int k = paramSQLiteDatabase.delete("my_trips_steps", "trip_name=?", arrayOfString2);
      String[] arrayOfString3 = new String[1];
      arrayOfString3[0] = paramString;
      int m = paramSQLiteDatabase.delete("my_trips_maps", "trip_name=?", arrayOfString3);
      String[] arrayOfString4 = new String[1];
      arrayOfString4[0] = paramString;
      int n = paramSQLiteDatabase.delete("my_trips_taxis", "trip_name=?", arrayOfString4);
      String[] arrayOfString5 = new String[1];
      arrayOfString5[0] = paramString;
      int i1 = paramSQLiteDatabase.delete("my_trips_route_icons", "trip_name=?", arrayOfString5);
      String[] arrayOfString6 = new String[1];
      arrayOfString6[0] = paramString;
      int i2 = paramSQLiteDatabase.delete("my_trips_route_geo_points", "trip_name=?", arrayOfString6);
      i = i2;
      return i;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private ArrayList<ViewStep> getTaxiSteps(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String[] arrayOfString1 = ID_COL_MY_TRIPS_TAXIS;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramString;
    Cursor localCursor = paramSQLiteDatabase.query("my_trips_taxis", arrayOfString1, "trip_name=?", arrayOfString2, null, null, "step_id ASC");
    ArrayList localArrayList1 = new ArrayList();
    while (true)
    {
      if (!localCursor.moveToNext())
        return localArrayList1;
      ViewStepTaxi localViewStepTaxi1 = new ViewStepTaxi();
      int i = localCursor.getInt(0);
      String str1 = localCursor.getString(2);
      localViewStepTaxi1.setDescription(str1);
      float f1 = localCursor.getFloat(3);
      localViewStepTaxi1.setDistance(f1);
      int j = localCursor.getInt(4);
      localViewStepTaxi1.setDrivingTime(j);
      String str2 = localCursor.getString(5);
      localViewStepTaxi1.setId(str2);
      String str3 = localCursor.getString(6);
      ViewStepTaxi localViewStepTaxi2 = localViewStepTaxi1;
      String str4 = str3;
      localViewStepTaxi2.setName(str4);
      String str5 = localCursor.getString(7);
      ViewStepTaxi localViewStepTaxi3 = localViewStepTaxi1;
      String str6 = str5;
      localViewStepTaxi3.setNotes(str6);
      String str7 = localCursor.getString(8);
      ViewStepTaxi localViewStepTaxi4 = localViewStepTaxi1;
      String str8 = str7;
      localViewStepTaxi4.setPhone(str8);
      float f2 = localCursor.getFloat(9);
      ViewStepTaxi localViewStepTaxi5 = localViewStepTaxi1;
      float f3 = f2;
      localViewStepTaxi5.setPrice(f3);
      ArrayList localArrayList2 = localArrayList1;
      ViewStepTaxi localViewStepTaxi6 = localViewStepTaxi1;
      boolean bool = localArrayList2.add(localViewStepTaxi6);
    }
  }

  private ArrayList<ViewStep> getTripMaps(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String[] arrayOfString1 = ID_COL_MY_TRIPS_MAPS;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramString;
    Cursor localCursor = paramSQLiteDatabase.query("my_trips_maps", arrayOfString1, "trip_name=?", arrayOfString2, null, null, "map_id ASC");
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      if (!localCursor.moveToNext())
      {
        if (localCursor != null)
          localCursor.close();
        return localArrayList;
      }
      ViewStepMap localViewStepMap = new ViewStepMap();
      int i = localCursor.getInt(0);
      String str1 = localCursor.getString(2);
      localViewStepMap.setURL(str1, false);
      String str2 = localCursor.getString(3);
      localViewStepMap.setInfo(str2);
      localViewStepMap.setIdFromURL(str1);
      boolean bool = localArrayList.add(localViewStepMap);
    }
  }

  private ArrayList<ViewStep> getTripSteps(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String[] arrayOfString1 = ID_COL_MY_TRIPS_STEPS;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramString;
    Cursor localCursor = paramSQLiteDatabase.query("my_trips_steps", arrayOfString1, "trip_name=?", arrayOfString2, null, null, "step_id ASC");
    ArrayList localArrayList1 = new ArrayList();
    Paint localPaint1 = new Paint();
    if (!localCursor.moveToNext())
    {
      if (localCursor != null)
        localCursor.close();
      return localArrayList1;
    }
    int i = ApplicationEngine.DISPLAY_WIDTH + -50 + -10;
    ViewStepDirections localViewStepDirections1 = new ViewStepDirections();
    String str1 = localCursor.getString(2);
    localViewStepDirections1.setDirections(str1);
    String str2 = localCursor.getString(3);
    ViewStepDirections localViewStepDirections2 = localViewStepDirections1;
    String str3 = str2;
    localViewStepDirections2.setStepTime(str3);
    if (str2 != null)
    {
      int j = str2.length();
      Paint localPaint2 = localPaint1;
      String str4 = str2;
      int k = (int)localPaint2.measureText(str4, 0, j);
      i -= k;
    }
    while (true)
    {
      String str5 = localCursor.getString(4);
      ViewStepDirections localViewStepDirections3 = localViewStepDirections1;
      String str6 = str5;
      localViewStepDirections3.setType(str6);
      String str7 = localCursor.getString(5);
      ViewStepDirections localViewStepDirections4 = localViewStepDirections1;
      String str8 = str7;
      localViewStepDirections4.setURL(str8, false);
      byte[] arrayOfByte = localCursor.getBlob(6);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        Bitmap localBitmap1 = Util.getBitmapFromByteArray(arrayOfByte);
        ViewStepDirections localViewStepDirections5 = localViewStepDirections1;
        Bitmap localBitmap2 = localBitmap1;
        localViewStepDirections5.setBitmap(localBitmap2);
        int m = localCursor.getInt(7);
        i -= m;
        localViewStepDirections1.setIconWidth(m);
        int n = localCursor.getInt(8);
        localViewStepDirections1.setIconHeight(n);
      }
      String str9 = localCursor.getString(9);
      ViewStepDirections localViewStepDirections6 = localViewStepDirections1;
      String str10 = str9;
      localViewStepDirections6.setOptionlVehicle(str10);
      String str11 = String.valueOf(localCursor.getInt(10));
      localViewStepDirections1.setUseAnotherStop(str11, null);
      String str12 = String.valueOf(localCursor.getInt(11));
      localViewStepDirections1.setUseAnotherTransfer(str12, null);
      String str13 = localCursor.getString(12);
      ViewStepDirections localViewStepDirections7 = localViewStepDirections1;
      String str14 = str13;
      localViewStepDirections7.setVehicle_name(str14);
      if (localCursor.getInt(13) == 1)
        localViewStepDirections1.setHasDiversion(true);
      ViewStepDirections localViewStepDirections8 = localViewStepDirections1;
      int i1 = i;
      localViewStepDirections8.setDirectionViewStarts(i1);
      if (localCursor.getInt(14) == 1)
        localViewStepDirections1.setBikeFriendly(true);
      ArrayList localArrayList2 = localArrayList1;
      ViewStepDirections localViewStepDirections9 = localViewStepDirections1;
      boolean bool = localArrayList2.add(localViewStepDirections9);
      break;
    }
  }

  /** @deprecated */
  private ArrayList<GeoPoints> loadGeoPoints(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        String[] arrayOfString1 = ID_COL_MY_TRIPS_GEO_POINTS;
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = paramString;
        Cursor localCursor = paramSQLiteDatabase.query("my_trips_route_geo_points", arrayOfString1, "trip_name=?", arrayOfString2, null, null, "route_geo_points_id ASC");
        while (true)
        {
          boolean bool1 = localCursor.moveToNext();
          if (!bool1)
            label60: return localArrayList;
          GeoPoints localGeoPoints = new GeoPoints();
          int i = localCursor.getInt(3);
          int j = localCursor.getInt(2);
          GeoPoint localGeoPoint1 = new GeoPoint(i, j);
          localGeoPoints.setStart(localGeoPoint1);
          int k = localCursor.getInt(5);
          int m = localCursor.getInt(4);
          GeoPoint localGeoPoint2 = new GeoPoint(k, m);
          localGeoPoints.setEnd(localGeoPoint2);
          int n = localCursor.getInt(6);
          if (n != 0)
            localGeoPoints.setRouteColor(n);
          boolean bool2 = localArrayList.add(localGeoPoints);
        }
      }
      catch (Exception localException)
      {
        break label60;
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  private Hashtable<String, RouteIcons> loadRouteIcons(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      Hashtable localHashtable = new Hashtable();
      try
      {
        String[] arrayOfString1 = ID_COL_MY_TRIPS_ROUTE_ICONS;
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = paramString;
        Cursor localCursor = paramSQLiteDatabase.query("my_trips_route_icons", arrayOfString1, "trip_name=?", arrayOfString2, null, null, null);
        while (true)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool)
            return localHashtable;
          localRouteIcons = new RouteIcons();
          int i = localCursor.getInt(1);
          localRouteIcons.setLon(i);
          int j = localCursor.getInt(2);
          localRouteIcons.setLat(j);
          String str1 = localCursor.getString(3);
          localRouteIcons.setName(str1);
          String str2 = localCursor.getString(4);
          localRouteIcons.setUrl(str2);
          int k = Integer.parseInt(localCursor.getString(5));
          localRouteIcons.setOccurred(k);
          if (localRouteIcons.getName() == null)
            localRouteIcons.setName("");
          if ((!localRouteIcons.getName().equals("start")) && (!localRouteIcons.getName().equals("end")))
            break;
          String str3 = localRouteIcons.getName();
          Object localObject1 = localHashtable.put(str3, localRouteIcons);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          RouteIcons localRouteIcons;
          continue;
          String str4 = String.valueOf(localRouteIcons.getName());
          StringBuilder localStringBuilder1 = new StringBuilder(str4).append("_");
          int m = localRouteIcons.getLat();
          StringBuilder localStringBuilder2 = localStringBuilder1.append(m).append("_");
          int n = localRouteIcons.getLon();
          String str5 = n;
          Object localObject2 = localHashtable.put(str5, localRouteIcons);
        }
      }
    }
    finally
    {
    }
  }

  private void notifyObservers(ViewStepMap paramViewStepMap)
  {
    try
    {
      Enumeration localEnumeration = this.observable.keys();
      while (true)
      {
        if (!localEnumeration.hasMoreElements())
          return;
        String str1 = localEnumeration.nextElement().toString();
        String str2 = paramViewStepMap.getId();
        if (str1.equals(str2))
        {
          Hashtable localHashtable1 = this.observable;
          String str3 = paramViewStepMap.getId();
          ImageView localImageView = (ImageView)localHashtable1.get(str3);
          if ((localImageView.getRootView().getContext() instanceof MoreMyTripsDirectionActivity))
          {
            MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity = (MoreMyTripsDirectionActivity)localImageView.getRootView().getContext();
            Bitmap localBitmap = paramViewStepMap.getBitmap();
            localMoreMyTripsDirectionActivity.updateImageView(localImageView, localBitmap);
          }
          Hashtable localHashtable2 = this.observable;
          String str4 = paramViewStepMap.getId();
          Object localObject = localHashtable2.remove(str4);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static ArrayList<HopStopCity> readCitiesFromHopStopDB(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    String[] arrayOfString1 = ID_COL_CITIES;
    SQLiteDatabase localSQLiteDatabase = paramSQLiteDatabase;
    String[] arrayOfString2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    Cursor localCursor = localSQLiteDatabase.query("cities", arrayOfString1, null, arrayOfString2, str1, str2, str3);
    if (localCursor.getCount() > 0)
    {
      if ((i < 200) && (localCursor.moveToNext()));
    }
    else
    {
      if (localCursor != null)
        localCursor.close();
      return localArrayList;
    }
    HopStopCity localHopStopCity = new HopStopCity();
    String str4 = localCursor.getString(1);
    String str5 = localCursor.getString(0);
    localHopStopCity.setCellGateway(str5);
    String str6 = localCursor.getString(1);
    if (str6 != null);
    for (String[] arrayOfString3 = str6.split(","); ; arrayOfString3 = null)
    {
      localHopStopCity.setDefaultCounty(arrayOfString3);
      String str7 = localCursor.getString(2);
      localHopStopCity.setId(str7);
      String str8 = localCursor.getString(4);
      localHopStopCity.setName(str8);
      String str9 = localCursor.getString(5);
      localHopStopCity.setState(str9);
      String str10 = localCursor.getString(6);
      localHopStopCity.setUsePlaces(str10);
      if ((localHopStopCity.getId() != null) && (localHopStopCity.getName() != null) && (localHopStopCity.getId().length() > 0) && (localHopStopCity.getName().length() > 0))
        boolean bool = localArrayList.add(localHopStopCity);
      i += 1;
      break;
    }
  }

  public void addObserver(String paramString, ImageView paramImageView)
  {
    try
    {
      Object localObject = this.observable.put(paramString, paramImageView);
      Enumeration localEnumeration = this.observable.keys();
      boolean bool;
      do
        bool = localEnumeration.hasMoreElements();
      while (bool);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void close()
  {
    if (this.history_calls == null)
      return;
    this.history_calls.close();
  }

  public int deleteHistoryRecord(String paramString)
  {
    int i = 0;
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.history_calls.getWritableDatabase();
      String str1 = String.valueOf(HopStopHistoryCallsDB.ADDRESS_VALUES);
      String str2 = str1 + "=?";
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString;
      int j = localSQLiteDatabase.delete("history_calls", str2, arrayOfString);
      i = j;
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.close();
      return i;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public int deleteMyTripRecord(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.my_trips.getWritableDatabase();
      int i = cleanIfExsist(localSQLiteDatabase, paramString);
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.close();
      return i;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public void executeInserTask(ArrayList<ViewStep> paramArrayList, boolean paramBoolean)
    throws OutOfMemoryError, IOException
  {
    insertToMyTripsRequest(paramArrayList, paramBoolean);
  }

  public void insertToHistoryCalls(String paramString, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = this.history_calls.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    String str = HopStopHistoryCallsDB.ADDRESS_VALUES;
    localContentValues.put(str, paramString);
    Long localLong = Long.valueOf(paramLong);
    localContentValues.put("timestamp", localLong);
    try
    {
      long l = localSQLiteDatabase.insert("history_calls", null, localContentValues);
      if (localSQLiteDatabase == null)
        return;
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  /** @deprecated */
  // ERROR //
  public void insertToMyTripsRequest(ArrayList<ViewStep> paramArrayList, boolean paramBoolean)
    throws OutOfMemoryError, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   18: invokevirtual 215	com/hopstop/ClientModel/db/HopStopMyTripsDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 4
    //   23: aload_1
    //   24: ifnull -13 -> 11
    //   27: aload_1
    //   28: invokevirtual 624	java/util/ArrayList:size	()I
    //   31: ifeq -20 -> 11
    //   34: aload_1
    //   35: astore 5
    //   37: iconst_0
    //   38: istore 6
    //   40: aload 5
    //   42: iload 6
    //   44: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 629	com/hopstop/ClientModel/directions/ViewStepTotal
    //   50: astore 7
    //   52: aload 7
    //   54: astore 8
    //   56: iconst_1
    //   57: istore 9
    //   59: aload 8
    //   61: iload 9
    //   63: invokevirtual 632	com/hopstop/ClientModel/directions/ViewStepTotal:setMostRecentSaved	(Z)V
    //   66: aload 7
    //   68: invokevirtual 635	com/hopstop/ClientModel/directions/ViewStepTotal:getMyTripName	()Ljava/lang/String;
    //   71: astore 10
    //   73: aload 7
    //   75: invokevirtual 638	com/hopstop/ClientModel/directions/ViewStepTotal:isRecent	()Z
    //   78: ifeq +22 -> 100
    //   81: ldc_w 640
    //   84: astore 10
    //   86: aload 7
    //   88: astore 11
    //   90: iconst_0
    //   91: istore 12
    //   93: aload 11
    //   95: iload 12
    //   97: invokevirtual 643	com/hopstop/ClientModel/directions/ViewStepTotal:setRecent	(Z)V
    //   100: aload_0
    //   101: astore 13
    //   103: aload 10
    //   105: astore 14
    //   107: aload 13
    //   109: aload 4
    //   111: aload 14
    //   113: invokespecial 593	com/hopstop/ClientModel/db/HistoryManager:cleanIfExsist	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   116: istore 15
    //   118: new 606	android/content/ContentValues
    //   121: dup
    //   122: invokespecial 607	android/content/ContentValues:<init>	()V
    //   125: astore 16
    //   127: aload 16
    //   129: astore 17
    //   131: ldc 69
    //   133: astore 18
    //   135: aload 10
    //   137: astore 19
    //   139: aload 17
    //   141: aload 18
    //   143: aload 19
    //   145: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 7
    //   150: invokevirtual 646	com/hopstop/ClientModel/directions/ViewStepTotal:getTotalTimeVerb	()Ljava/lang/String;
    //   153: astore 20
    //   155: aload 16
    //   157: astore 21
    //   159: ldc 71
    //   161: astore 22
    //   163: aload 20
    //   165: astore 23
    //   167: aload 21
    //   169: aload 22
    //   171: aload 23
    //   173: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 7
    //   178: invokevirtual 649	com/hopstop/ClientModel/directions/ViewStepTotal:getDistance	()Ljava/lang/String;
    //   181: astore 24
    //   183: aload 16
    //   185: astore 25
    //   187: ldc 73
    //   189: astore 26
    //   191: aload 24
    //   193: astore 27
    //   195: aload 25
    //   197: aload 26
    //   199: aload 27
    //   201: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 7
    //   206: invokevirtual 652	com/hopstop/ClientModel/directions/ViewStepTotal:getDuration	()Ljava/lang/String;
    //   209: astore 28
    //   211: aload 16
    //   213: astore 29
    //   215: ldc 75
    //   217: astore 30
    //   219: aload 28
    //   221: astore 31
    //   223: aload 29
    //   225: aload 30
    //   227: aload 31
    //   229: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 7
    //   234: invokevirtual 655	com/hopstop/ClientModel/directions/ViewStepTotal:getDeparture	()Ljava/lang/String;
    //   237: astore 32
    //   239: aload 16
    //   241: astore 33
    //   243: ldc 77
    //   245: astore 34
    //   247: aload 32
    //   249: astore 35
    //   251: aload 33
    //   253: aload 34
    //   255: aload 35
    //   257: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload 7
    //   262: invokevirtual 658	com/hopstop/ClientModel/directions/ViewStepTotal:getArrival	()Ljava/lang/String;
    //   265: astore 36
    //   267: aload 16
    //   269: astore 37
    //   271: ldc 79
    //   273: astore 38
    //   275: aload 36
    //   277: astore 39
    //   279: aload 37
    //   281: aload 38
    //   283: aload 39
    //   285: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 7
    //   290: invokevirtual 661	com/hopstop/ClientModel/directions/ViewStepTotal:getCalories	()Ljava/lang/String;
    //   293: astore 40
    //   295: aload 16
    //   297: astore 41
    //   299: ldc 81
    //   301: astore 42
    //   303: aload 40
    //   305: astore 43
    //   307: aload 41
    //   309: aload 42
    //   311: aload 43
    //   313: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 7
    //   318: invokevirtual 664	com/hopstop/ClientModel/directions/ViewStepTotal:getCo2	()Ljava/lang/String;
    //   321: astore 44
    //   323: aload 16
    //   325: astore 45
    //   327: ldc 83
    //   329: astore 46
    //   331: aload 44
    //   333: astore 47
    //   335: aload 45
    //   337: aload 46
    //   339: aload 47
    //   341: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload 7
    //   346: invokevirtual 667	com/hopstop/ClientModel/directions/ViewStepTotal:getRouteId	()Ljava/lang/String;
    //   349: astore 48
    //   351: aload 16
    //   353: astore 49
    //   355: ldc 101
    //   357: astore 50
    //   359: aload 48
    //   361: astore 51
    //   363: aload 49
    //   365: aload 50
    //   367: aload 51
    //   369: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload 7
    //   374: invokevirtual 670	com/hopstop/ClientModel/directions/ViewStepTotal:isTaxi	()I
    //   377: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   380: astore 52
    //   382: aload 16
    //   384: astore 53
    //   386: ldc 103
    //   388: astore 54
    //   390: aload 52
    //   392: astore 55
    //   394: aload 53
    //   396: aload 54
    //   398: aload 55
    //   400: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   403: aload 7
    //   405: invokevirtual 679	com/hopstop/ClientModel/directions/ViewStepTotal:getWheelChairOut	()I
    //   408: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: astore 56
    //   413: aload 16
    //   415: astore 57
    //   417: ldc 105
    //   419: astore 58
    //   421: aload 56
    //   423: astore 59
    //   425: aload 57
    //   427: aload 58
    //   429: aload 59
    //   431: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   434: aload_1
    //   435: astore 60
    //   437: iconst_1
    //   438: istore 61
    //   440: aload 60
    //   442: iload 61
    //   444: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   447: checkcast 681	com/hopstop/ClientModel/directions/ViewStepAddress
    //   450: astore 62
    //   452: aload 62
    //   454: invokevirtual 684	com/hopstop/ClientModel/directions/ViewStepAddress:getAddress	()Ljava/lang/String;
    //   457: astore 63
    //   459: aload 16
    //   461: astore 64
    //   463: ldc 85
    //   465: astore 65
    //   467: aload 63
    //   469: astore 66
    //   471: aload 64
    //   473: aload 65
    //   475: aload 66
    //   477: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload 62
    //   482: invokevirtual 687	com/hopstop/ClientModel/directions/ViewStepAddress:getCounty1	()Ljava/lang/String;
    //   485: astore 67
    //   487: aload 16
    //   489: astore 68
    //   491: ldc 87
    //   493: astore 69
    //   495: aload 67
    //   497: astore 70
    //   499: aload 68
    //   501: aload 69
    //   503: aload 70
    //   505: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload 62
    //   510: invokevirtual 690	com/hopstop/ClientModel/directions/ViewStepAddress:getCity1	()Ljava/lang/String;
    //   513: astore 71
    //   515: aload 16
    //   517: astore 72
    //   519: ldc 89
    //   521: astore 73
    //   523: aload 71
    //   525: astore 74
    //   527: aload 72
    //   529: aload 73
    //   531: aload 74
    //   533: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload 62
    //   538: invokevirtual 693	com/hopstop/ClientModel/directions/ViewStepAddress:getZip1	()Ljava/lang/String;
    //   541: astore 75
    //   543: aload 16
    //   545: astore 76
    //   547: ldc 91
    //   549: astore 77
    //   551: aload 75
    //   553: astore 78
    //   555: aload 76
    //   557: aload 77
    //   559: aload 78
    //   561: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload_1
    //   565: astore 79
    //   567: iconst_2
    //   568: istore 80
    //   570: aload 79
    //   572: iload 80
    //   574: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   577: checkcast 681	com/hopstop/ClientModel/directions/ViewStepAddress
    //   580: astore 81
    //   582: aload 81
    //   584: invokevirtual 684	com/hopstop/ClientModel/directions/ViewStepAddress:getAddress	()Ljava/lang/String;
    //   587: astore 82
    //   589: aload 16
    //   591: astore 83
    //   593: ldc 93
    //   595: astore 84
    //   597: aload 82
    //   599: astore 85
    //   601: aload 83
    //   603: aload 84
    //   605: aload 85
    //   607: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: aload 81
    //   612: invokevirtual 696	com/hopstop/ClientModel/directions/ViewStepAddress:getCounty2	()Ljava/lang/String;
    //   615: astore 86
    //   617: aload 16
    //   619: astore 87
    //   621: ldc 95
    //   623: astore 88
    //   625: aload 86
    //   627: astore 89
    //   629: aload 87
    //   631: aload 88
    //   633: aload 89
    //   635: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload 81
    //   640: invokevirtual 699	com/hopstop/ClientModel/directions/ViewStepAddress:getCity2	()Ljava/lang/String;
    //   643: astore 90
    //   645: aload 16
    //   647: astore 91
    //   649: ldc 97
    //   651: astore 92
    //   653: aload 90
    //   655: astore 93
    //   657: aload 91
    //   659: aload 92
    //   661: aload 93
    //   663: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   666: aload 81
    //   668: invokevirtual 702	com/hopstop/ClientModel/directions/ViewStepAddress:getZip2	()Ljava/lang/String;
    //   671: astore 94
    //   673: aload 16
    //   675: astore 95
    //   677: ldc 99
    //   679: astore 96
    //   681: aload 94
    //   683: astore 97
    //   685: aload 95
    //   687: aload 96
    //   689: aload 97
    //   691: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload 7
    //   696: invokevirtual 705	com/hopstop/ClientModel/directions/ViewStepTotal:getWalkingTime	()I
    //   699: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   702: astore 98
    //   704: aload 16
    //   706: astore 99
    //   708: ldc 107
    //   710: astore 100
    //   712: aload 98
    //   714: astore 101
    //   716: aload 99
    //   718: aload 100
    //   720: aload 101
    //   722: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   725: aload 7
    //   727: invokevirtual 708	com/hopstop/ClientModel/directions/ViewStepTotal:getFare	()Ljava/lang/String;
    //   730: astore 102
    //   732: aload 16
    //   734: astore 103
    //   736: ldc 109
    //   738: astore 104
    //   740: aload 102
    //   742: astore 105
    //   744: aload 103
    //   746: aload 104
    //   748: aload 105
    //   750: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   753: aload 4
    //   755: invokevirtual 711	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   758: ifne +12 -> 770
    //   761: aload_0
    //   762: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   765: invokevirtual 215	com/hopstop/ClientModel/db/HopStopMyTripsDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   768: astore 4
    //   770: ldc 241
    //   772: astore 106
    //   774: aconst_null
    //   775: astore 107
    //   777: aload 16
    //   779: astore 108
    //   781: aload 4
    //   783: aload 106
    //   785: aload 107
    //   787: aload 108
    //   789: invokevirtual 621	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   792: lstore 109
    //   794: aload 7
    //   796: invokevirtual 715	com/hopstop/ClientModel/directions/ViewStepTotal:getRouteIcons	()Ljava/util/Hashtable;
    //   799: astore 111
    //   801: new 195	java/util/Hashtable
    //   804: dup
    //   805: aload 111
    //   807: invokespecial 718	java/util/Hashtable:<init>	(Ljava/util/Map;)V
    //   810: astore 112
    //   812: aload 112
    //   814: ifnull +40 -> 854
    //   817: aload 112
    //   819: invokevirtual 719	java/util/Hashtable:size	()I
    //   822: ifle +32 -> 854
    //   825: new 606	android/content/ContentValues
    //   828: dup
    //   829: invokespecial 607	android/content/ContentValues:<init>	()V
    //   832: astore 113
    //   834: aload 112
    //   836: invokevirtual 509	java/util/Hashtable:keys	()Ljava/util/Enumeration;
    //   839: astore 114
    //   841: iconst_0
    //   842: istore 115
    //   844: aload 114
    //   846: invokeinterface 514 1 0
    //   851: ifne +211 -> 1062
    //   854: aload 7
    //   856: invokevirtual 723	com/hopstop/ClientModel/directions/ViewStepTotal:getRouteLines	()Ljava/util/ArrayList;
    //   859: astore 116
    //   861: new 270	java/util/ArrayList
    //   864: dup
    //   865: aload 116
    //   867: invokespecial 726	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   870: astore 117
    //   872: iconst_1
    //   873: istore 118
    //   875: aload 117
    //   877: ifnull +43 -> 920
    //   880: aload 117
    //   882: invokevirtual 624	java/util/ArrayList:size	()I
    //   885: ifle +35 -> 920
    //   888: new 606	android/content/ContentValues
    //   891: dup
    //   892: invokespecial 607	android/content/ContentValues:<init>	()V
    //   895: astore 119
    //   897: aload 117
    //   899: invokevirtual 730	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   902: astore_3
    //   903: iload 118
    //   905: istore 120
    //   907: aload_3
    //   908: invokeinterface 735 1 0
    //   913: ifne +398 -> 1311
    //   916: iload 120
    //   918: istore 121
    //   920: new 606	android/content/ContentValues
    //   923: dup
    //   924: invokespecial 607	android/content/ContentValues:<init>	()V
    //   927: astore 122
    //   929: aload_1
    //   930: astore 123
    //   932: iconst_3
    //   933: istore 124
    //   935: iconst_0
    //   936: istore 125
    //   938: aload 123
    //   940: invokevirtual 624	java/util/ArrayList:size	()I
    //   943: istore 126
    //   945: iload 124
    //   947: iload 126
    //   949: if_icmpge +16 -> 965
    //   952: aload 123
    //   954: iload 124
    //   956: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   959: instanceof 351
    //   962: ifne +604 -> 1566
    //   965: aload 7
    //   967: invokevirtual 670	com/hopstop/ClientModel/directions/ViewStepTotal:isTaxi	()I
    //   970: istore 127
    //   972: iconst_1
    //   973: istore 127
    //   975: iload 127
    //   977: iload 127
    //   979: if_icmpne +1663 -> 2642
    //   982: new 606	android/content/ContentValues
    //   985: dup
    //   986: invokespecial 607	android/content/ContentValues:<init>	()V
    //   989: astore 129
    //   991: aload_1
    //   992: invokevirtual 624	java/util/ArrayList:size	()I
    //   995: istore 130
    //   997: iload 124
    //   999: iload 130
    //   1001: if_icmpge +1685 -> 2686
    //   1004: aload 123
    //   1006: iload 124
    //   1008: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1011: instanceof 279
    //   1014: ifne +1149 -> 2163
    //   1017: iload 125
    //   1019: istore 131
    //   1021: iload_2
    //   1022: ifeq +27 -> 1049
    //   1025: iconst_0
    //   1026: istore 132
    //   1028: aload_1
    //   1029: invokevirtual 624	java/util/ArrayList:size	()I
    //   1032: istore 133
    //   1034: iload 132
    //   1036: istore 134
    //   1038: iload 133
    //   1040: istore 135
    //   1042: iload 134
    //   1044: iload 135
    //   1046: if_icmplt +2131 -> 3177
    //   1049: invokestatic 740	java/lang/System:gc	()V
    //   1052: goto -1041 -> 11
    //   1055: astore 136
    //   1057: aload_0
    //   1058: monitorexit
    //   1059: aload 136
    //   1061: athrow
    //   1062: iload 115
    //   1064: iconst_1
    //   1065: iadd
    //   1066: istore 115
    //   1068: aload 113
    //   1070: invokevirtual 743	android/content/ContentValues:clear	()V
    //   1073: aload 114
    //   1075: invokeinterface 518 1 0
    //   1080: checkcast 39	java/lang/String
    //   1083: astore 137
    //   1085: aload 112
    //   1087: aload 137
    //   1089: invokevirtual 526	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1092: checkcast 441	com/hopstop/ClientModel/directions/RouteIcons
    //   1095: astore 138
    //   1097: aload 113
    //   1099: astore 139
    //   1101: ldc 69
    //   1103: astore 140
    //   1105: aload 10
    //   1107: astore 141
    //   1109: aload 139
    //   1111: aload 140
    //   1113: aload 141
    //   1115: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1118: aload 138
    //   1120: invokevirtual 500	com/hopstop/ClientModel/directions/RouteIcons:getLon	()I
    //   1123: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1126: astore 142
    //   1128: aload 113
    //   1130: astore 143
    //   1132: ldc 165
    //   1134: astore 144
    //   1136: aload 142
    //   1138: astore 145
    //   1140: aload 143
    //   1142: aload 144
    //   1144: aload 145
    //   1146: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1149: aload 138
    //   1151: invokevirtual 494	com/hopstop/ClientModel/directions/RouteIcons:getLat	()I
    //   1154: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1157: astore 146
    //   1159: aload 113
    //   1161: astore 147
    //   1163: ldc 167
    //   1165: astore 148
    //   1167: aload 146
    //   1169: astore 149
    //   1171: aload 147
    //   1173: aload 148
    //   1175: aload 149
    //   1177: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1180: aload 138
    //   1182: invokevirtual 465	com/hopstop/ClientModel/directions/RouteIcons:getName	()Ljava/lang/String;
    //   1185: astore 150
    //   1187: aload 113
    //   1189: astore 151
    //   1191: ldc 169
    //   1193: astore 152
    //   1195: aload 150
    //   1197: astore 153
    //   1199: aload 151
    //   1201: aload 152
    //   1203: aload 153
    //   1205: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1208: aload 138
    //   1210: invokevirtual 746	com/hopstop/ClientModel/directions/RouteIcons:getUrl	()Ljava/lang/String;
    //   1213: astore 154
    //   1215: aload 113
    //   1217: astore 155
    //   1219: ldc 171
    //   1221: astore 156
    //   1223: aload 154
    //   1225: astore 157
    //   1227: aload 155
    //   1229: aload 156
    //   1231: aload 157
    //   1233: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1236: aload 138
    //   1238: invokevirtual 749	com/hopstop/ClientModel/directions/RouteIcons:isOccurred	()I
    //   1241: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1244: astore 158
    //   1246: aload 113
    //   1248: astore 159
    //   1250: ldc 173
    //   1252: astore 160
    //   1254: aload 158
    //   1256: astore 161
    //   1258: aload 159
    //   1260: aload 160
    //   1262: aload 161
    //   1264: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1267: aload 4
    //   1269: invokevirtual 711	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1272: ifne +12 -> 1284
    //   1275: aload_0
    //   1276: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   1279: invokevirtual 215	com/hopstop/ClientModel/db/HopStopMyTripsDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1282: astore 4
    //   1284: ldc 255
    //   1286: astore 162
    //   1288: aconst_null
    //   1289: astore 163
    //   1291: aload 113
    //   1293: astore 164
    //   1295: aload 4
    //   1297: aload 162
    //   1299: aload 163
    //   1301: aload 164
    //   1303: invokevirtual 621	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1306: lstore 165
    //   1308: goto -464 -> 844
    //   1311: aload_3
    //   1312: invokeinterface 752 1 0
    //   1317: checkcast 421	com/hopstop/ClientModel/directions/GeoPoints
    //   1320: astore 167
    //   1322: aload 119
    //   1324: invokevirtual 743	android/content/ContentValues:clear	()V
    //   1327: iload 120
    //   1329: iconst_1
    //   1330: iadd
    //   1331: istore 118
    //   1333: iload 120
    //   1335: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1338: astore 168
    //   1340: ldc 177
    //   1342: astore 169
    //   1344: aload 168
    //   1346: astore 170
    //   1348: aload 119
    //   1350: aload 169
    //   1352: aload 170
    //   1354: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1357: ldc 69
    //   1359: astore 171
    //   1361: aload 10
    //   1363: astore 172
    //   1365: aload 119
    //   1367: aload 171
    //   1369: aload 172
    //   1371: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1374: aload 167
    //   1376: invokevirtual 756	com/hopstop/ClientModel/directions/GeoPoints:getStart	()Lcom/google/android/maps/GeoPoint;
    //   1379: invokevirtual 759	com/google/android/maps/GeoPoint:getLongitudeE6	()I
    //   1382: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1385: astore 173
    //   1387: ldc 179
    //   1389: astore 174
    //   1391: aload 173
    //   1393: astore 175
    //   1395: aload 119
    //   1397: aload 174
    //   1399: aload 175
    //   1401: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1404: aload 167
    //   1406: invokevirtual 756	com/hopstop/ClientModel/directions/GeoPoints:getStart	()Lcom/google/android/maps/GeoPoint;
    //   1409: invokevirtual 762	com/google/android/maps/GeoPoint:getLatitudeE6	()I
    //   1412: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1415: astore 176
    //   1417: ldc 181
    //   1419: astore 177
    //   1421: aload 176
    //   1423: astore 178
    //   1425: aload 119
    //   1427: aload 177
    //   1429: aload 178
    //   1431: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1434: aload 167
    //   1436: invokevirtual 765	com/hopstop/ClientModel/directions/GeoPoints:getEnd	()Lcom/google/android/maps/GeoPoint;
    //   1439: invokevirtual 759	com/google/android/maps/GeoPoint:getLongitudeE6	()I
    //   1442: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1445: astore 179
    //   1447: ldc 183
    //   1449: astore 180
    //   1451: aload 179
    //   1453: astore 181
    //   1455: aload 119
    //   1457: aload 180
    //   1459: aload 181
    //   1461: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1464: aload 167
    //   1466: invokevirtual 765	com/hopstop/ClientModel/directions/GeoPoints:getEnd	()Lcom/google/android/maps/GeoPoint;
    //   1469: invokevirtual 762	com/google/android/maps/GeoPoint:getLatitudeE6	()I
    //   1472: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1475: astore 182
    //   1477: ldc 185
    //   1479: astore 183
    //   1481: aload 182
    //   1483: astore 184
    //   1485: aload 119
    //   1487: aload 183
    //   1489: aload 184
    //   1491: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1494: aload 167
    //   1496: invokevirtual 768	com/hopstop/ClientModel/directions/GeoPoints:getRouteColor	()I
    //   1499: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1502: astore 185
    //   1504: ldc 187
    //   1506: astore 186
    //   1508: aload 185
    //   1510: astore 187
    //   1512: aload 119
    //   1514: aload 186
    //   1516: aload 187
    //   1518: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1521: aload 4
    //   1523: invokevirtual 711	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1526: ifne +12 -> 1538
    //   1529: aload_0
    //   1530: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   1533: invokevirtual 215	com/hopstop/ClientModel/db/HopStopMyTripsDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1536: astore 4
    //   1538: ldc_w 257
    //   1541: astore 188
    //   1543: aconst_null
    //   1544: astore 189
    //   1546: aload 4
    //   1548: aload 188
    //   1550: aload 189
    //   1552: aload 119
    //   1554: invokevirtual 621	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1557: lstore 190
    //   1559: iload 118
    //   1561: istore 120
    //   1563: goto -656 -> 907
    //   1566: aload 122
    //   1568: invokevirtual 743	android/content/ContentValues:clear	()V
    //   1571: aload 123
    //   1573: iload 124
    //   1575: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1578: checkcast 351	com/hopstop/ClientModel/directions/ViewStepDirections
    //   1581: astore 192
    //   1583: aload 122
    //   1585: astore 193
    //   1587: ldc 69
    //   1589: astore 194
    //   1591: aload 10
    //   1593: astore 195
    //   1595: aload 193
    //   1597: aload 194
    //   1599: aload 195
    //   1601: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1604: iload 125
    //   1606: iconst_1
    //   1607: iadd
    //   1608: istore 196
    //   1610: iload 125
    //   1612: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1615: astore 197
    //   1617: aload 122
    //   1619: astore 198
    //   1621: ldc 113
    //   1623: astore 199
    //   1625: aload 197
    //   1627: astore 200
    //   1629: aload 198
    //   1631: aload 199
    //   1633: aload 200
    //   1635: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1638: aload 192
    //   1640: invokevirtual 771	com/hopstop/ClientModel/directions/ViewStepDirections:getDirections	()Ljava/lang/String;
    //   1643: astore 201
    //   1645: aload 122
    //   1647: astore 202
    //   1649: ldc 115
    //   1651: astore 203
    //   1653: aload 201
    //   1655: astore 204
    //   1657: aload 202
    //   1659: aload 203
    //   1661: aload 204
    //   1663: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1666: aload 192
    //   1668: invokevirtual 774	com/hopstop/ClientModel/directions/ViewStepDirections:getStepTime	()Ljava/lang/String;
    //   1671: astore 205
    //   1673: aload 122
    //   1675: astore 206
    //   1677: ldc 117
    //   1679: astore 207
    //   1681: aload 205
    //   1683: astore 208
    //   1685: aload 206
    //   1687: aload 207
    //   1689: aload 208
    //   1691: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1694: aload 192
    //   1696: invokevirtual 777	com/hopstop/ClientModel/directions/ViewStepDirections:getType	()Ljava/lang/String;
    //   1699: astore 209
    //   1701: aload 122
    //   1703: astore 210
    //   1705: ldc 119
    //   1707: astore 211
    //   1709: aload 209
    //   1711: astore 212
    //   1713: aload 210
    //   1715: aload 211
    //   1717: aload 212
    //   1719: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1722: aload 192
    //   1724: invokevirtual 780	com/hopstop/ClientModel/directions/ViewStepDirections:getURL	()Ljava/lang/String;
    //   1727: astore 213
    //   1729: aload 122
    //   1731: astore 214
    //   1733: ldc 121
    //   1735: astore 215
    //   1737: aload 213
    //   1739: astore 216
    //   1741: aload 214
    //   1743: aload 215
    //   1745: aload 216
    //   1747: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1750: aload 192
    //   1752: invokevirtual 780	com/hopstop/ClientModel/directions/ViewStepDirections:getURL	()Ljava/lang/String;
    //   1755: ifnull +68 -> 1823
    //   1758: aload 192
    //   1760: invokevirtual 780	com/hopstop/ClientModel/directions/ViewStepDirections:getURL	()Ljava/lang/String;
    //   1763: invokevirtual 362	java/lang/String:length	()I
    //   1766: ifle +57 -> 1823
    //   1769: aload 192
    //   1771: invokevirtual 781	com/hopstop/ClientModel/directions/ViewStepDirections:getBitmap	()Landroid/graphics/Bitmap;
    //   1774: ifnonnull +369 -> 2143
    //   1777: aload 192
    //   1779: invokevirtual 780	com/hopstop/ClientModel/directions/ViewStepDirections:getURL	()Ljava/lang/String;
    //   1782: invokestatic 787	com/hopstop/network/NetworkEngine:fetchDrawable	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1785: invokestatic 793	com/hopstop/network/DrawableManager:resizeDrawable	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   1788: astore 217
    //   1790: aload 217
    //   1792: ifnull +31 -> 1823
    //   1795: aload 217
    //   1797: invokestatic 797	com/hopstop/util/Util:getBytesFromBitmap	(Landroid/graphics/Bitmap;)[B
    //   1800: astore 218
    //   1802: aload 122
    //   1804: astore 219
    //   1806: ldc 123
    //   1808: astore 220
    //   1810: aload 218
    //   1812: astore 221
    //   1814: aload 219
    //   1816: aload 220
    //   1818: aload 221
    //   1820: invokevirtual 800	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   1823: aload 192
    //   1825: invokevirtual 803	com/hopstop/ClientModel/directions/ViewStepDirections:getIconWidth	()I
    //   1828: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1831: astore 222
    //   1833: aload 122
    //   1835: astore 223
    //   1837: ldc 125
    //   1839: astore 224
    //   1841: aload 222
    //   1843: astore 225
    //   1845: aload 223
    //   1847: aload 224
    //   1849: aload 225
    //   1851: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1854: aload 192
    //   1856: invokevirtual 806	com/hopstop/ClientModel/directions/ViewStepDirections:getIconHeight	()I
    //   1859: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1862: astore 226
    //   1864: aload 122
    //   1866: astore 227
    //   1868: ldc 127
    //   1870: astore 228
    //   1872: aload 226
    //   1874: astore 229
    //   1876: aload 227
    //   1878: aload 228
    //   1880: aload 229
    //   1882: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1885: aload 192
    //   1887: invokevirtual 809	com/hopstop/ClientModel/directions/ViewStepDirections:getOptionlVehicles	()Ljava/lang/String;
    //   1890: astore 230
    //   1892: aload 122
    //   1894: astore 231
    //   1896: ldc 129
    //   1898: astore 232
    //   1900: aload 230
    //   1902: astore 233
    //   1904: aload 231
    //   1906: aload 232
    //   1908: aload 233
    //   1910: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1913: aload 192
    //   1915: invokevirtual 812	com/hopstop/ClientModel/directions/ViewStepDirections:getUseAnotherStop	()Ljava/lang/String;
    //   1918: astore 234
    //   1920: aload 122
    //   1922: astore 235
    //   1924: ldc 131
    //   1926: astore 236
    //   1928: aload 234
    //   1930: astore 237
    //   1932: aload 235
    //   1934: aload 236
    //   1936: aload 237
    //   1938: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1941: aload 192
    //   1943: invokevirtual 815	com/hopstop/ClientModel/directions/ViewStepDirections:getVehicle_id	()Ljava/lang/String;
    //   1946: astore 238
    //   1948: aload 122
    //   1950: astore 239
    //   1952: ldc 133
    //   1954: astore 240
    //   1956: aload 238
    //   1958: astore 241
    //   1960: aload 239
    //   1962: aload 240
    //   1964: aload 241
    //   1966: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1969: aload 192
    //   1971: invokevirtual 818	com/hopstop/ClientModel/directions/ViewStepDirections:getVehicle_name	()Ljava/lang/String;
    //   1974: astore 242
    //   1976: aload 122
    //   1978: astore 243
    //   1980: ldc 135
    //   1982: astore 244
    //   1984: aload 242
    //   1986: astore 245
    //   1988: aload 243
    //   1990: aload 244
    //   1992: aload 245
    //   1994: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1997: ldc 137
    //   1999: astore 246
    //   2001: aload 192
    //   2003: invokevirtual 821	com/hopstop/ClientModel/directions/ViewStepDirections:hasDiversion	()Z
    //   2006: ifeq +147 -> 2153
    //   2009: aconst_null
    //   2010: astore_3
    //   2011: aload_3
    //   2012: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2015: astore 247
    //   2017: aload 122
    //   2019: astore 248
    //   2021: aload 246
    //   2023: astore 249
    //   2025: aload 247
    //   2027: astore 250
    //   2029: aload 248
    //   2031: aload 249
    //   2033: aload 250
    //   2035: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2038: ldc 139
    //   2040: astore 246
    //   2042: aload 192
    //   2044: invokevirtual 824	com/hopstop/ClientModel/directions/ViewStepDirections:isBikeFriendly	()Z
    //   2047: ifeq +111 -> 2158
    //   2050: aconst_null
    //   2051: astore_3
    //   2052: aload_3
    //   2053: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2056: astore 251
    //   2058: aload 122
    //   2060: astore 252
    //   2062: aload 246
    //   2064: astore 253
    //   2066: aload 251
    //   2068: astore 254
    //   2070: aload 252
    //   2072: aload 253
    //   2074: aload 254
    //   2076: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2079: aload 4
    //   2081: invokevirtual 711	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2084: ifne +12 -> 2096
    //   2087: aload_0
    //   2088: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   2091: invokevirtual 215	com/hopstop/ClientModel/db/HopStopMyTripsDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   2094: astore 4
    //   2096: ldc 249
    //   2098: astore 255
    //   2100: aconst_null
    //   2101: wide
    //   2105: aload 122
    //   2107: wide
    //   2111: aload 4
    //   2113: aload 255
    //   2115: wide
    //   2119: wide
    //   2123: invokevirtual 621	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   2126: wide
    //   2130: iload 124
    //   2132: iconst_1
    //   2133: iadd
    //   2134: istore 124
    //   2136: iload 196
    //   2138: istore 125
    //   2140: goto -1202 -> 938
    //   2143: aload 192
    //   2145: invokevirtual 781	com/hopstop/ClientModel/directions/ViewStepDirections:getBitmap	()Landroid/graphics/Bitmap;
    //   2148: astore 217
    //   2150: goto -360 -> 1790
    //   2153: aconst_null
    //   2154: astore_3
    //   2155: goto -144 -> 2011
    //   2158: aconst_null
    //   2159: astore_3
    //   2160: goto -108 -> 2052
    //   2163: aload_1
    //   2164: iload 124
    //   2166: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2169: checkcast 279	com/hopstop/ClientModel/directions/ViewStepTaxi
    //   2172: wide
    //   2176: iload 125
    //   2178: iconst_1
    //   2179: iadd
    //   2180: wide
    //   2184: iload 125
    //   2186: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2189: wide
    //   2193: aload 129
    //   2195: wide
    //   2199: ldc 113
    //   2201: wide
    //   2205: wide
    //   2209: wide
    //   2213: wide
    //   2217: wide
    //   2221: wide
    //   2225: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2228: aload 129
    //   2230: wide
    //   2234: ldc 69
    //   2236: wide
    //   2240: aload 10
    //   2242: wide
    //   2246: wide
    //   2250: wide
    //   2254: wide
    //   2258: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2261: wide
    //   2265: invokevirtual 827	com/hopstop/ClientModel/directions/ViewStepTaxi:getDescription	()Ljava/lang/String;
    //   2268: wide
    //   2272: aload 129
    //   2274: wide
    //   2278: ldc 151
    //   2280: wide
    //   2284: wide
    //   2288: wide
    //   2292: wide
    //   2296: wide
    //   2300: wide
    //   2304: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2307: wide
    //   2311: invokevirtual 830	com/hopstop/ClientModel/directions/ViewStepTaxi:getDrivingTime	()I
    //   2314: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2317: wide
    //   2321: aload 129
    //   2323: wide
    //   2327: ldc 155
    //   2329: wide
    //   2333: wide
    //   2337: wide
    //   2341: wide
    //   2345: wide
    //   2349: wide
    //   2353: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2356: wide
    //   2360: invokevirtual 831	com/hopstop/ClientModel/directions/ViewStepTaxi:getId	()Ljava/lang/String;
    //   2363: wide
    //   2367: aload 129
    //   2369: wide
    //   2373: ldc 51
    //   2375: wide
    //   2379: wide
    //   2383: wide
    //   2387: wide
    //   2391: wide
    //   2395: wide
    //   2399: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2402: wide
    //   2406: invokevirtual 832	com/hopstop/ClientModel/directions/ViewStepTaxi:getName	()Ljava/lang/String;
    //   2409: wide
    //   2413: aload 129
    //   2415: wide
    //   2419: ldc 53
    //   2421: wide
    //   2425: wide
    //   2429: wide
    //   2433: wide
    //   2437: wide
    //   2441: wide
    //   2445: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2448: wide
    //   2452: invokevirtual 835	com/hopstop/ClientModel/directions/ViewStepTaxi:getNotes	()Ljava/lang/String;
    //   2455: wide
    //   2459: aload 129
    //   2461: wide
    //   2465: ldc 157
    //   2467: wide
    //   2471: wide
    //   2475: wide
    //   2479: wide
    //   2483: wide
    //   2487: wide
    //   2491: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2494: wide
    //   2498: invokevirtual 838	com/hopstop/ClientModel/directions/ViewStepTaxi:getPhone	()Ljava/lang/String;
    //   2501: wide
    //   2505: aload 129
    //   2507: wide
    //   2511: ldc 159
    //   2513: wide
    //   2517: wide
    //   2521: wide
    //   2525: wide
    //   2529: wide
    //   2533: wide
    //   2537: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2540: wide
    //   2544: invokevirtual 842	com/hopstop/ClientModel/directions/ViewStepTaxi:getPrice	()F
    //   2547: invokestatic 847	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   2550: wide
    //   2554: aload 129
    //   2556: wide
    //   2560: ldc 161
    //   2562: wide
    //   2566: wide
    //   2570: wide
    //   2574: wide
    //   2578: wide
    //   2582: wide
    //   2586: invokevirtual 850	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Float;)V
    //   2589: ldc 253
    //   2591: wide
    //   2595: aconst_null
    //   2596: wide
    //   2600: aload 129
    //   2602: wide
    //   2606: aload 4
    //   2608: wide
    //   2612: wide
    //   2616: wide
    //   2620: invokevirtual 621	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   2623: wide
    //   2627: iload 124
    //   2629: iconst_1
    //   2630: iadd
    //   2631: istore 124
    //   2633: wide
    //   2637: istore 125
    //   2639: goto -1648 -> 991
    //   2642: new 606	android/content/ContentValues
    //   2645: dup
    //   2646: invokespecial 607	android/content/ContentValues:<init>	()V
    //   2649: wide
    //   2653: iconst_0
    //   2654: istore 125
    //   2656: aload_1
    //   2657: invokevirtual 624	java/util/ArrayList:size	()I
    //   2660: wide
    //   2664: iload 124
    //   2666: wide
    //   2670: if_icmpge +16 -> 2686
    //   2673: aload 123
    //   2675: iload 124
    //   2677: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2680: instanceof 329
    //   2683: ifne +12 -> 2695
    //   2686: iload 125
    //   2688: wide
    //   2692: goto -1671 -> 1021
    //   2695: aload_1
    //   2696: iload 124
    //   2698: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2701: checkcast 329	com/hopstop/ClientModel/directions/ViewStepMap
    //   2704: wide
    //   2708: iload 125
    //   2710: iconst_1
    //   2711: iadd
    //   2712: istore 196
    //   2714: iload 125
    //   2716: invokestatic 673	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2719: wide
    //   2723: wide
    //   2727: wide
    //   2731: ldc 143
    //   2733: wide
    //   2737: wide
    //   2741: wide
    //   2745: wide
    //   2749: wide
    //   2753: wide
    //   2757: invokevirtual 676	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2760: wide
    //   2764: wide
    //   2768: ldc 69
    //   2770: wide
    //   2774: aload 10
    //   2776: wide
    //   2780: wide
    //   2784: wide
    //   2788: wide
    //   2792: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2795: wide
    //   2799: invokevirtual 851	com/hopstop/ClientModel/directions/ViewStepMap:getURL	()Ljava/lang/String;
    //   2802: wide
    //   2806: wide
    //   2810: wide
    //   2814: ldc 145
    //   2816: wide
    //   2820: wide
    //   2824: wide
    //   2828: wide
    //   2832: wide
    //   2836: wide
    //   2840: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2843: wide
    //   2847: invokevirtual 854	com/hopstop/ClientModel/directions/ViewStepMap:getInfo	()Ljava/lang/String;
    //   2850: wide
    //   2854: wide
    //   2858: wide
    //   2862: ldc 147
    //   2864: wide
    //   2868: wide
    //   2872: wide
    //   2876: wide
    //   2880: wide
    //   2884: wide
    //   2888: invokevirtual 609	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2891: aconst_null
    //   2892: checkcast 856	[B
    //   2895: wide
    //   2899: wide
    //   2903: invokevirtual 544	com/hopstop/ClientModel/directions/ViewStepMap:getBitmap	()Landroid/graphics/Bitmap;
    //   2906: ifnull +189 -> 3095
    //   2909: wide
    //   2913: invokevirtual 544	com/hopstop/ClientModel/directions/ViewStepMap:getBitmap	()Landroid/graphics/Bitmap;
    //   2916: invokevirtual 861	android/graphics/Bitmap:isRecycled	()Z
    //   2919: ifne +176 -> 3095
    //   2922: wide
    //   2926: invokevirtual 544	com/hopstop/ClientModel/directions/ViewStepMap:getBitmap	()Landroid/graphics/Bitmap;
    //   2929: invokestatic 797	com/hopstop/util/Util:getBytesFromBitmap	(Landroid/graphics/Bitmap;)[B
    //   2932: wide
    //   2936: wide
    //   2940: invokevirtual 544	com/hopstop/ClientModel/directions/ViewStepMap:getBitmap	()Landroid/graphics/Bitmap;
    //   2943: wide
    //   2947: wide
    //   2951: ifnull +12 -> 2963
    //   2954: wide
    //   2958: arraylength
    //   2959: wide
    //   2963: wide
    //   2967: wide
    //   2971: ldc_w 863
    //   2974: wide
    //   2978: wide
    //   2982: wide
    //   2986: wide
    //   2990: wide
    //   2994: wide
    //   2998: invokevirtual 800	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   3001: aload_0
    //   3002: wide
    //   3006: wide
    //   3010: wide
    //   3014: wide
    //   3018: wide
    //   3022: invokespecial 865	com/hopstop/ClientModel/db/HistoryManager:notifyObservers	(Lcom/hopstop/ClientModel/directions/ViewStepMap;)V
    //   3025: aload 4
    //   3027: invokevirtual 711	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   3030: ifne +12 -> 3042
    //   3033: aload_0
    //   3034: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   3037: invokevirtual 215	com/hopstop/ClientModel/db/HopStopMyTripsDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   3040: astore 4
    //   3042: ldc 251
    //   3044: wide
    //   3048: aconst_null
    //   3049: wide
    //   3053: wide
    //   3057: wide
    //   3061: aload 4
    //   3063: wide
    //   3067: wide
    //   3071: wide
    //   3075: invokevirtual 621	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   3078: wide
    //   3082: iload 124
    //   3084: iconst_1
    //   3085: iadd
    //   3086: istore 124
    //   3088: iload 196
    //   3090: istore 125
    //   3092: goto -436 -> 2656
    //   3095: aconst_null
    //   3096: astore 217
    //   3098: wide
    //   3102: invokevirtual 851	com/hopstop/ClientModel/directions/ViewStepMap:getURL	()Ljava/lang/String;
    //   3105: invokestatic 787	com/hopstop/network/NetworkEngine:fetchDrawable	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   3108: invokestatic 793	com/hopstop/network/DrawableManager:resizeDrawable	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   3111: wide
    //   3115: wide
    //   3119: astore 217
    //   3121: aload 217
    //   3123: ifnull -176 -> 2947
    //   3126: aload 217
    //   3128: invokevirtual 861	android/graphics/Bitmap:isRecycled	()Z
    //   3131: ifne -184 -> 2947
    //   3134: wide
    //   3138: aload 217
    //   3140: invokevirtual 866	com/hopstop/ClientModel/directions/ViewStepMap:setBitmap	(Landroid/graphics/Bitmap;)V
    //   3143: wide
    //   3147: invokevirtual 544	com/hopstop/ClientModel/directions/ViewStepMap:getBitmap	()Landroid/graphics/Bitmap;
    //   3150: invokestatic 797	com/hopstop/util/Util:getBytesFromBitmap	(Landroid/graphics/Bitmap;)[B
    //   3153: wide
    //   3157: wide
    //   3161: invokevirtual 544	com/hopstop/ClientModel/directions/ViewStepMap:getBitmap	()Landroid/graphics/Bitmap;
    //   3164: wide
    //   3168: goto -221 -> 2947
    //   3171: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   3174: goto -53 -> 3121
    //   3177: aload_1
    //   3178: wide
    //   3182: iload 132
    //   3184: wide
    //   3188: wide
    //   3192: wide
    //   3196: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3199: checkcast 868	com/hopstop/ClientModel/directions/ViewStep
    //   3202: wide
    //   3206: wide
    //   3210: instanceof 329
    //   3213: ifeq +29 -> 3242
    //   3216: wide
    //   3220: wide
    //   3224: iconst_1
    //   3225: wide
    //   3229: wide
    //   3233: wide
    //   3237: invokeinterface 871 2 0
    //   3242: iload 132
    //   3244: iconst_1
    //   3245: iadd
    //   3246: istore 132
    //   3248: goto -2220 -> 1028
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	1055	finally
    //   14	1052	1055	finally
    //   1068	3082	1055	finally
    //   3098	3115	1055	finally
    //   3126	3242	1055	finally
    //   3098	3115	3171	java/lang/Exception
  }

  public ArrayList<HopStopCity> loadCities(SplashScreen paramSplashScreen)
  {
    HopStopDB localHopStopDB = new com/hopstop/ClientModel/db/HopStopDB;
    Context localContext = this.context;
    localHopStopDB.<init>(localContext);
    SQLiteDatabase localSQLiteDatabase = localHopStopDB.getWritableDatabase();
    int i = 1;
    ArrayList localArrayList = null;
    int j = 0;
    try
    {
      String[] arrayOfString1 = ID_COL_SETTINGS;
      localCursor = localSQLiteDatabase.query("settings_db", arrayOfString1, null, null, null, null, "timestamp DESC");
      int m;
      label218: String[] arrayOfString2;
      String[] arrayOfString3;
      if ((j >= 200) || (!localCursor.moveToNext()))
      {
        if (j == 0)
        {
          ContentValues localContentValues1 = new ContentValues();
          localContentValues1.put("Settings_Values", "last_time_cities_updated");
          Long localLong1 = Long.valueOf(0L);
          localContentValues1.put("timestamp", localLong1);
          ContentValues localContentValues2 = localContentValues1;
          long l1 = localSQLiteDatabase.insert("settings_db", "timestamp", localContentValues2);
        }
        if (i != 0)
        {
          NetworkEngine localNetworkEngine = new NetworkEngine();
          int k = NetworkSettings.GET_CITIES;
          String str1 = URLFactoryBuilder.getCitiesURL(NetworkSettings.keyNewAPI);
          SplashScreen localSplashScreen = paramSplashScreen;
          GetCitiesHandler localGetCitiesHandler = (GetCitiesHandler)localNetworkEngine.getSynchronousExecute(localSplashScreen, k, str1);
          if ((localGetCitiesHandler != null) && (localGetCitiesHandler.isSuccess()))
          {
            localArrayList = localGetCitiesHandler.getCitiesSet().getHopStopCities();
            localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS cities");
            localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cities (cellGateway TEXT, defaultCounty TEXT, id TEXT, name TEXT, state TEXT, usePlaces TEXT);");
            m = 0;
            int n = localArrayList.size();
            if (m < n)
              break label515;
            ContentValues localContentValues3 = new ContentValues();
            localContentValues3.put("Settings_Values", "last_time_cities_updated");
            Long localLong2 = Long.valueOf(Calendar.getInstance().getTime().getTime());
            localContentValues3.put("timestamp", localLong2);
            ContentValues localContentValues4 = localContentValues3;
            int i1 = localSQLiteDatabase.update("settings_db", localContentValues4, null, null);
          }
        }
        if (localArrayList == null)
        {
          localArrayList = readCitiesFromHopStopDB(localSQLiteDatabase);
          arrayOfString2 = paramSplashScreen.getResources().getStringArray(2131099649);
          arrayOfString3 = paramSplashScreen.getResources().getStringArray(2131099650);
          int i2 = localArrayList.size();
          int i3 = arrayOfString2.length;
          if (i2 < i3)
          {
            int i4 = arrayOfString2.length;
            int i5 = arrayOfString3.length;
            if (i4 != i5)
            {
              localArrayList.clear();
              m = 0;
            }
          }
        }
      }
      while (true)
      {
        int i6 = arrayOfString2.length;
        if (m >= i6)
        {
          return localArrayList;
          i6 = 0;
          if (!localCursor.getString(i6).equals("last_time_cities_updated"))
            break;
          long l2 = localCursor.getLong(1);
          Date localDate1 = new Date(l2);
          Calendar localCalendar = Calendar.getInstance();
          Date localDate2 = localCalendar.getTime();
          localCalendar.setTime(localDate1);
          localCalendar.add(5, 7);
          Date localDate3 = localCalendar.getTime();
          if (localDate2.before(localDate3))
            i = 0;
          j += 1;
          break;
          label515: int i7 = m;
          HopStopCity localHopStopCity1 = (HopStopCity)localArrayList.get(i7);
          ContentValues localContentValues5 = new ContentValues();
          String str2 = localHopStopCity1.getCellGateway();
          localContentValues5.put("cellGateway", str2);
          String str3 = localHopStopCity1.getDefaultCountyString();
          localContentValues5.put("defaultCounty", str3);
          String str4 = localHopStopCity1.getId();
          localContentValues5.put("id", str4);
          String str5 = localHopStopCity1.getName();
          localContentValues5.put("name", str5);
          String str6 = localHopStopCity1.getState();
          localContentValues5.put("state", str6);
          String str7 = localHopStopCity1.getUsePlaces();
          localContentValues5.put("usePlaces", str7);
          ContentValues localContentValues6 = localContentValues5;
          long l3 = localSQLiteDatabase.insert("cities", "name", localContentValues6);
          m += 1;
          break label218;
        }
        HopStopCity localHopStopCity2 = new HopStopCity();
        String str8 = arrayOfString2[m];
        localHopStopCity2.setName(str8);
        String str9 = arrayOfString3[m];
        localHopStopCity2.setId(str9);
        HopStopCity localHopStopCity3 = localHopStopCity2;
        boolean bool = localArrayList.add(localHopStopCity3);
        ContentValues localContentValues7 = new ContentValues();
        localContentValues7.put("cellGateway", null);
        localContentValues7.put("defaultCounty", null);
        String str10 = localHopStopCity2.getId();
        localContentValues7.put("id", str10);
        String str11 = localHopStopCity2.getName();
        localContentValues7.put("name", str11);
        localContentValues7.put("state", null);
        localContentValues7.put("usePlaces", null);
        ContentValues localContentValues8 = localContentValues7;
        long l4 = localSQLiteDatabase.insert("cities", "name", localContentValues8);
        m += 1;
      }
    }
    finally
    {
      Cursor localCursor;
      if (localHopStopDB != null)
        localHopStopDB.close();
      if (localCursor != null)
        localCursor.close();
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.close();
    }
  }

  /** @deprecated */
  // ERROR //
  public Bitmap loadDirectionIconFromDB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   6: invokevirtual 991	com/hopstop/ClientModel/db/HopStopMyTripsDB:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: astore_3
    //   12: aconst_null
    //   13: astore 4
    //   15: iconst_2
    //   16: anewarray 39	java/lang/String
    //   19: astore 5
    //   21: aload 5
    //   23: iconst_0
    //   24: ldc 121
    //   26: aastore
    //   27: aload 5
    //   29: iconst_1
    //   30: ldc 123
    //   32: aastore
    //   33: iconst_1
    //   34: anewarray 39	java/lang/String
    //   37: astore 6
    //   39: aload 6
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: aload_3
    //   45: ldc 249
    //   47: aload 5
    //   49: ldc_w 993
    //   52: aload 6
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: invokevirtual 268	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 7
    //   62: aload 7
    //   64: invokeinterface 277 1 0
    //   69: istore 8
    //   71: aload 7
    //   73: iconst_1
    //   74: invokeinterface 374 2 0
    //   79: astore_2
    //   80: aload_2
    //   81: astore 9
    //   83: aload 9
    //   85: ifnonnull +31 -> 116
    //   88: aload 7
    //   90: ifnull +10 -> 100
    //   93: aload 7
    //   95: invokeinterface 327 1 0
    //   100: aload_3
    //   101: ifnull +7 -> 108
    //   104: aload_3
    //   105: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   108: aconst_null
    //   109: astore 10
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 10
    //   115: areturn
    //   116: aload 9
    //   118: invokestatic 380	com/hopstop/util/Util:getBitmapFromByteArray	([B)Landroid/graphics/Bitmap;
    //   121: astore_2
    //   122: aload_2
    //   123: astore 4
    //   125: aload 7
    //   127: ifnull +10 -> 137
    //   130: aload 7
    //   132: invokeinterface 327 1 0
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   145: aload 4
    //   147: astore 10
    //   149: goto -38 -> 111
    //   152: astore 11
    //   154: aload 7
    //   156: ifnull +10 -> 166
    //   159: aload 7
    //   161: invokeinterface 327 1 0
    //   166: aload_3
    //   167: ifnull -22 -> 145
    //   170: aload_3
    //   171: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   174: goto -29 -> 145
    //   177: astore 12
    //   179: aload_0
    //   180: monitorexit
    //   181: aload 12
    //   183: athrow
    //   184: astore 13
    //   186: aload 7
    //   188: ifnull +10 -> 198
    //   191: aload 7
    //   193: invokeinterface 327 1 0
    //   198: aload_3
    //   199: ifnull +7 -> 206
    //   202: aload_3
    //   203: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   206: aload 13
    //   208: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   15	80	152	java/lang/Exception
    //   116	122	152	java/lang/Exception
    //   2	10	177	finally
    //   93	108	177	finally
    //   130	174	177	finally
    //   191	209	177	finally
    //   15	80	184	finally
    //   116	122	184	finally
  }

  public LinkedList<Hashtable<String, Long>> loadHistoryVisits(BaseActivity paramBaseActivity)
  {
    SQLiteDatabase localSQLiteDatabase = this.history_calls.getWritableDatabase();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      String[] arrayOfString = ID_COL_HISTORY_CALLS;
      localCursor = localSQLiteDatabase.query("history_calls", arrayOfString, null, null, null, null, "timestamp DESC");
      int i = 0;
      while (true)
      {
        if (i < 200)
        {
          boolean bool1 = localCursor.moveToNext();
          if (bool1);
        }
        else
        {
          return localLinkedList;
        }
        int j = 0;
        String str = localCursor.getString(j);
        long l = localCursor.getLong(1);
        Hashtable localHashtable = new Hashtable();
        Long localLong = Long.valueOf(l);
        Object localObject1 = localHashtable.put(str, localLong);
        boolean bool2 = localLinkedList.add(localHashtable);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        if (localCursor != null)
          localCursor.close();
        if (localSQLiteDatabase != null)
          localSQLiteDatabase.close();
      }
    }
    finally
    {
      Cursor localCursor;
      if (localCursor != null)
        localCursor.close();
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.close();
    }
  }

  /** @deprecated */
  // ERROR //
  public Bitmap loadImageFromDB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   6: invokevirtual 991	com/hopstop/ClientModel/db/HopStopMyTripsDB:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: astore_3
    //   12: aconst_null
    //   13: astore 4
    //   15: iconst_2
    //   16: anewarray 39	java/lang/String
    //   19: astore 5
    //   21: aload 5
    //   23: iconst_0
    //   24: ldc 145
    //   26: aastore
    //   27: aload 5
    //   29: iconst_1
    //   30: ldc_w 863
    //   33: aastore
    //   34: iconst_1
    //   35: anewarray 39	java/lang/String
    //   38: astore 6
    //   40: aload 6
    //   42: iconst_0
    //   43: aload_1
    //   44: aastore
    //   45: aload_3
    //   46: ldc 251
    //   48: aload 5
    //   50: ldc_w 1002
    //   53: aload 6
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 268	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 7
    //   63: aload 7
    //   65: invokeinterface 277 1 0
    //   70: istore 8
    //   72: aload 7
    //   74: iconst_1
    //   75: invokeinterface 374 2 0
    //   80: astore_2
    //   81: aload_2
    //   82: astore 9
    //   84: aload 9
    //   86: ifnonnull +31 -> 117
    //   89: aload 7
    //   91: ifnull +10 -> 101
    //   94: aload 7
    //   96: invokeinterface 327 1 0
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   109: aconst_null
    //   110: astore 10
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 10
    //   116: areturn
    //   117: aload 9
    //   119: invokestatic 380	com/hopstop/util/Util:getBitmapFromByteArray	([B)Landroid/graphics/Bitmap;
    //   122: astore_2
    //   123: aload_2
    //   124: astore 4
    //   126: aload 7
    //   128: ifnull +10 -> 138
    //   131: aload 7
    //   133: invokeinterface 327 1 0
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   146: aload 4
    //   148: astore 10
    //   150: goto -38 -> 112
    //   153: astore 11
    //   155: aload 7
    //   157: ifnull +10 -> 167
    //   160: aload 7
    //   162: invokeinterface 327 1 0
    //   167: aload_3
    //   168: ifnull -22 -> 146
    //   171: aload_3
    //   172: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: goto -29 -> 146
    //   178: astore 12
    //   180: aload_0
    //   181: monitorexit
    //   182: aload 12
    //   184: athrow
    //   185: astore 13
    //   187: aload 7
    //   189: ifnull +10 -> 199
    //   192: aload 7
    //   194: invokeinterface 327 1 0
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   207: aload 13
    //   209: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   15	81	153	java/lang/Exception
    //   117	123	153	java/lang/Exception
    //   2	10	178	finally
    //   94	109	178	finally
    //   131	175	178	finally
    //   192	210	178	finally
    //   15	81	185	finally
    //   117	123	185	finally
  }

  public ArrayList<ViewStep> loadMyTrips(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.my_trips.getReadableDatabase();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      if (MoreMyTripsDirectionActivity.DIRECTION_STEPS != paramInt)
      {
        ArrayList localArrayList2 = getTripSteps(localSQLiteDatabase, paramString);
        boolean bool1 = localArrayList1.addAll(localArrayList2);
      }
      while (true)
      {
        return localArrayList1;
        if (MoreMyTripsDirectionActivity.MAP_STEPS == paramInt)
          break;
        ArrayList localArrayList3 = getTripMaps(localSQLiteDatabase, paramString);
        boolean bool2 = localArrayList1.addAll(localArrayList3);
      }
    }
    catch (Exception localException)
    {
      while (true)
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.close();
          continue;
          if (MoreMyTripsDirectionActivity.TAXI_STEPS != paramInt)
          {
            ArrayList localArrayList4 = getTaxiSteps(localSQLiteDatabase, paramString);
            boolean bool3 = localArrayList1.addAll(localArrayList4);
          }
        }
    }
    finally
    {
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.close();
    }
  }

  /** @deprecated */
  // ERROR //
  public ArrayList<ArrayList<ViewStep>> loadMyTrips(ArrayList<ArrayList<ViewStep>> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 211	com/hopstop/ClientModel/db/HistoryManager:my_trips	Lcom/hopstop/ClientModel/db/HopStopMyTripsDB;
    //   6: invokevirtual 991	com/hopstop/ClientModel/db/HopStopMyTripsDB:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: new 270	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 271	java/util/ArrayList:<init>	()V
    //   17: astore_3
    //   18: getstatic 111	com/hopstop/ClientModel/db/HistoryManager:ID_COL_MY_TRIPS	[Ljava/lang/String;
    //   21: astore 4
    //   23: aload_2
    //   24: ldc 241
    //   26: aload 4
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 268	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 5
    //   38: iconst_0
    //   39: istore 6
    //   41: iload 6
    //   43: sipush 200
    //   46: if_icmpge +17 -> 63
    //   49: aload 5
    //   51: invokeinterface 277 1 0
    //   56: istore 7
    //   58: iload 7
    //   60: ifne +31 -> 91
    //   63: aload 5
    //   65: ifnull +10 -> 75
    //   68: aload 5
    //   70: invokeinterface 327 1 0
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   83: aload_1
    //   84: invokestatic 1030	java/util/Collections:reverse	(Ljava/util/List;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_3
    //   90: areturn
    //   91: new 270	java/util/ArrayList
    //   94: dup
    //   95: invokespecial 271	java/util/ArrayList:<init>	()V
    //   98: astore 8
    //   100: new 629	com/hopstop/ClientModel/directions/ViewStepTotal
    //   103: dup
    //   104: invokespecial 1031	com/hopstop/ClientModel/directions/ViewStepTotal:<init>	()V
    //   107: astore 9
    //   109: new 681	com/hopstop/ClientModel/directions/ViewStepAddress
    //   112: dup
    //   113: invokespecial 1032	com/hopstop/ClientModel/directions/ViewStepAddress:<init>	()V
    //   116: astore 10
    //   118: new 681	com/hopstop/ClientModel/directions/ViewStepAddress
    //   121: dup
    //   122: invokespecial 1032	com/hopstop/ClientModel/directions/ViewStepAddress:<init>	()V
    //   125: astore 11
    //   127: aload 11
    //   129: iconst_0
    //   130: invokevirtual 1034	com/hopstop/ClientModel/directions/ViewStepAddress:setStart	(Z)V
    //   133: aload 5
    //   135: iconst_0
    //   136: invokeinterface 288 2 0
    //   141: astore 12
    //   143: aload 9
    //   145: astore 13
    //   147: aload 12
    //   149: astore 14
    //   151: aload 13
    //   153: aload 14
    //   155: invokevirtual 1037	com/hopstop/ClientModel/directions/ViewStepTotal:setMyTripName	(Ljava/lang/String;)V
    //   158: aload 5
    //   160: iconst_1
    //   161: invokeinterface 288 2 0
    //   166: astore 15
    //   168: aload 9
    //   170: astore 16
    //   172: aload 15
    //   174: astore 17
    //   176: aload 16
    //   178: aload 17
    //   180: invokevirtual 1040	com/hopstop/ClientModel/directions/ViewStepTotal:setTotalTimeVerb	(Ljava/lang/String;)V
    //   183: aload 5
    //   185: iconst_2
    //   186: invokeinterface 288 2 0
    //   191: astore 18
    //   193: aload 9
    //   195: astore 19
    //   197: aload 18
    //   199: astore 20
    //   201: aload 19
    //   203: aload 20
    //   205: invokevirtual 1042	com/hopstop/ClientModel/directions/ViewStepTotal:setDistance	(Ljava/lang/String;)V
    //   208: aload 5
    //   210: iconst_3
    //   211: invokeinterface 288 2 0
    //   216: astore 21
    //   218: aload 9
    //   220: astore 22
    //   222: aload 21
    //   224: astore 23
    //   226: aload 22
    //   228: aload 23
    //   230: invokevirtual 1045	com/hopstop/ClientModel/directions/ViewStepTotal:setDuration	(Ljava/lang/String;)V
    //   233: aload 5
    //   235: iconst_4
    //   236: invokeinterface 288 2 0
    //   241: astore 24
    //   243: aload 9
    //   245: astore 25
    //   247: aload 24
    //   249: astore 26
    //   251: aload 25
    //   253: aload 26
    //   255: invokevirtual 1048	com/hopstop/ClientModel/directions/ViewStepTotal:setDepartureFromDB	(Ljava/lang/String;)V
    //   258: aload 5
    //   260: iconst_5
    //   261: invokeinterface 288 2 0
    //   266: astore 27
    //   268: aload 9
    //   270: astore 28
    //   272: aload 27
    //   274: astore 29
    //   276: aload 28
    //   278: aload 29
    //   280: invokevirtual 1051	com/hopstop/ClientModel/directions/ViewStepTotal:setArrivalFromDB	(Ljava/lang/String;)V
    //   283: aload 5
    //   285: bipush 6
    //   287: invokeinterface 288 2 0
    //   292: astore 30
    //   294: aload 9
    //   296: astore 31
    //   298: aload 30
    //   300: astore 32
    //   302: aload 31
    //   304: aload 32
    //   306: invokevirtual 1054	com/hopstop/ClientModel/directions/ViewStepTotal:setCalories	(Ljava/lang/String;)V
    //   309: aload 5
    //   311: bipush 7
    //   313: invokeinterface 288 2 0
    //   318: astore 33
    //   320: aload 9
    //   322: astore 34
    //   324: aload 33
    //   326: astore 35
    //   328: aload 34
    //   330: aload 35
    //   332: invokevirtual 1057	com/hopstop/ClientModel/directions/ViewStepTotal:setCo2	(Ljava/lang/String;)V
    //   335: aload 5
    //   337: bipush 8
    //   339: invokeinterface 288 2 0
    //   344: astore 36
    //   346: aload 10
    //   348: aload 36
    //   350: invokevirtual 1060	com/hopstop/ClientModel/directions/ViewStepAddress:setAddress	(Ljava/lang/String;)V
    //   353: aload 5
    //   355: bipush 9
    //   357: invokeinterface 288 2 0
    //   362: astore 37
    //   364: aload 10
    //   366: aload 37
    //   368: invokevirtual 1063	com/hopstop/ClientModel/directions/ViewStepAddress:setCounty1	(Ljava/lang/String;)V
    //   371: aload 5
    //   373: bipush 10
    //   375: invokeinterface 288 2 0
    //   380: astore 38
    //   382: aload 10
    //   384: aload 38
    //   386: invokevirtual 1066	com/hopstop/ClientModel/directions/ViewStepAddress:setCity1	(Ljava/lang/String;)V
    //   389: aload 5
    //   391: bipush 11
    //   393: invokeinterface 288 2 0
    //   398: astore 39
    //   400: aload 10
    //   402: astore 40
    //   404: aload 39
    //   406: astore 41
    //   408: aload 40
    //   410: aload 41
    //   412: invokevirtual 1069	com/hopstop/ClientModel/directions/ViewStepAddress:setZip1	(Ljava/lang/String;)V
    //   415: aload 5
    //   417: bipush 12
    //   419: invokeinterface 288 2 0
    //   424: astore 42
    //   426: aload 11
    //   428: aload 42
    //   430: invokevirtual 1060	com/hopstop/ClientModel/directions/ViewStepAddress:setAddress	(Ljava/lang/String;)V
    //   433: aload 5
    //   435: bipush 13
    //   437: invokeinterface 288 2 0
    //   442: astore 43
    //   444: aload 11
    //   446: astore 44
    //   448: aload 43
    //   450: astore 45
    //   452: aload 44
    //   454: aload 45
    //   456: invokevirtual 1072	com/hopstop/ClientModel/directions/ViewStepAddress:setCounty2	(Ljava/lang/String;)V
    //   459: aload 5
    //   461: bipush 14
    //   463: invokeinterface 288 2 0
    //   468: astore 46
    //   470: aload 11
    //   472: aload 46
    //   474: invokevirtual 1075	com/hopstop/ClientModel/directions/ViewStepAddress:setCity2	(Ljava/lang/String;)V
    //   477: aload 5
    //   479: bipush 15
    //   481: invokeinterface 288 2 0
    //   486: astore 47
    //   488: aload 11
    //   490: astore 48
    //   492: aload 47
    //   494: astore 49
    //   496: aload 48
    //   498: aload 49
    //   500: invokevirtual 1078	com/hopstop/ClientModel/directions/ViewStepAddress:setZip2	(Ljava/lang/String;)V
    //   503: aload 5
    //   505: bipush 16
    //   507: invokeinterface 288 2 0
    //   512: astore 50
    //   514: aload 9
    //   516: astore 51
    //   518: aload 50
    //   520: astore 52
    //   522: aload 51
    //   524: aload 52
    //   526: invokevirtual 1081	com/hopstop/ClientModel/directions/ViewStepTotal:setRouteId	(Ljava/lang/String;)V
    //   529: aload 5
    //   531: bipush 17
    //   533: invokeinterface 284 2 0
    //   538: istore 53
    //   540: aload 9
    //   542: astore 54
    //   544: iload 53
    //   546: istore 55
    //   548: aload 54
    //   550: iload 55
    //   552: invokevirtual 1084	com/hopstop/ClientModel/directions/ViewStepTotal:setTaxi	(I)V
    //   555: aload 5
    //   557: bipush 18
    //   559: invokeinterface 284 2 0
    //   564: istore 56
    //   566: aload 9
    //   568: astore 57
    //   570: iload 56
    //   572: istore 58
    //   574: aload 57
    //   576: iload 58
    //   578: invokevirtual 1087	com/hopstop/ClientModel/directions/ViewStepTotal:setWheelChairOut	(I)V
    //   581: aload 5
    //   583: bipush 19
    //   585: invokeinterface 284 2 0
    //   590: istore 59
    //   592: aload 9
    //   594: iload 59
    //   596: invokevirtual 1090	com/hopstop/ClientModel/directions/ViewStepTotal:setWalkingTime	(I)V
    //   599: aload 5
    //   601: bipush 20
    //   603: invokeinterface 288 2 0
    //   608: astore 60
    //   610: aload 9
    //   612: astore 61
    //   614: aload 60
    //   616: astore 62
    //   618: aload 61
    //   620: aload 62
    //   622: invokevirtual 1093	com/hopstop/ClientModel/directions/ViewStepTotal:setFare	(Ljava/lang/String;)V
    //   625: aload 8
    //   627: astore 63
    //   629: aload 9
    //   631: astore 64
    //   633: aload 63
    //   635: aload 64
    //   637: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   640: istore 65
    //   642: aload 8
    //   644: aload 10
    //   646: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   649: istore 66
    //   651: aload 8
    //   653: astore 67
    //   655: aload 11
    //   657: astore 68
    //   659: aload 67
    //   661: aload 68
    //   663: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   666: istore 69
    //   668: aload 9
    //   670: invokevirtual 670	com/hopstop/ClientModel/directions/ViewStepTotal:isTaxi	()I
    //   673: iconst_1
    //   674: if_icmpne +72 -> 746
    //   677: aload_0
    //   678: astore 70
    //   680: aload 12
    //   682: astore 71
    //   684: aload 70
    //   686: aload_2
    //   687: aload 71
    //   689: invokespecial 1023	com/hopstop/ClientModel/db/HistoryManager:getTaxiSteps	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/ArrayList;
    //   692: astore 72
    //   694: aload 8
    //   696: astore 73
    //   698: aload 72
    //   700: astore 74
    //   702: aload 73
    //   704: aload 74
    //   706: invokevirtual 1013	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   709: istore 75
    //   711: aload 12
    //   713: ldc_w 640
    //   716: invokevirtual 472	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   719: ifeq +194 -> 913
    //   722: invokestatic 1097	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   725: astore 76
    //   727: aload 8
    //   729: astore 77
    //   731: aload 76
    //   733: aload 77
    //   735: invokevirtual 1103	com/hopstop/ClientModel/Model:updateRecentTrip	(Ljava/util/ArrayList;)V
    //   738: goto -697 -> 41
    //   741: astore 78
    //   743: goto -702 -> 41
    //   746: aload_0
    //   747: astore 79
    //   749: aload 12
    //   751: astore 80
    //   753: aload 79
    //   755: aload_2
    //   756: aload 80
    //   758: invokespecial 1009	com/hopstop/ClientModel/db/HistoryManager:getTripSteps	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/ArrayList;
    //   761: astore 81
    //   763: aload_0
    //   764: astore 82
    //   766: aload 12
    //   768: astore 83
    //   770: aload 82
    //   772: aload_2
    //   773: aload 83
    //   775: invokespecial 1018	com/hopstop/ClientModel/db/HistoryManager:getTripMaps	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/ArrayList;
    //   778: astore 84
    //   780: aload 8
    //   782: astore 85
    //   784: aload 81
    //   786: astore 86
    //   788: aload 85
    //   790: aload 86
    //   792: invokevirtual 1013	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   795: istore 87
    //   797: aload 8
    //   799: astore 88
    //   801: aload 84
    //   803: astore 89
    //   805: aload 88
    //   807: aload 89
    //   809: invokevirtual 1013	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   812: istore 90
    //   814: aload_0
    //   815: astore 91
    //   817: aload 12
    //   819: astore 92
    //   821: aload 91
    //   823: aload_2
    //   824: aload 92
    //   826: invokespecial 1105	com/hopstop/ClientModel/db/HistoryManager:loadRouteIcons	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/Hashtable;
    //   829: astore 93
    //   831: aload 9
    //   833: astore 94
    //   835: aload 93
    //   837: astore 95
    //   839: aload 94
    //   841: aload 95
    //   843: invokevirtual 1109	com/hopstop/ClientModel/directions/ViewStepTotal:setRouteIconsHashtable	(Ljava/util/Hashtable;)V
    //   846: aload_0
    //   847: astore 96
    //   849: aload 12
    //   851: astore 97
    //   853: aload 96
    //   855: aload_2
    //   856: aload 97
    //   858: invokespecial 1111	com/hopstop/ClientModel/db/HistoryManager:loadGeoPoints	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/ArrayList;
    //   861: astore 98
    //   863: aload 9
    //   865: astore 99
    //   867: aload 98
    //   869: astore 100
    //   871: aload 99
    //   873: aload 100
    //   875: invokevirtual 1114	com/hopstop/ClientModel/directions/ViewStepTotal:setGeoPointsArrayList	(Ljava/util/ArrayList;)V
    //   878: goto -167 -> 711
    //   881: astore 101
    //   883: aload 5
    //   885: ifnull +10 -> 895
    //   888: aload 5
    //   890: invokeinterface 327 1 0
    //   895: aload_2
    //   896: ifnull +7 -> 903
    //   899: aload_2
    //   900: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   903: aload 101
    //   905: athrow
    //   906: astore 102
    //   908: aload_0
    //   909: monitorexit
    //   910: aload 102
    //   912: athrow
    //   913: aload_1
    //   914: astore 103
    //   916: aload 8
    //   918: astore 104
    //   920: aload 103
    //   922: aload 104
    //   924: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   927: istore 105
    //   929: goto -888 -> 41
    //   932: astore 106
    //   934: aload 5
    //   936: ifnull +10 -> 946
    //   939: aload 5
    //   941: invokeinterface 327 1 0
    //   946: aload_2
    //   947: ifnull -864 -> 83
    //   950: aload_2
    //   951: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   954: goto -871 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   91	741	741	java/lang/Exception
    //   913	929	741	java/lang/Exception
    //   18	58	881	finally
    //   91	878	881	finally
    //   913	929	881	finally
    //   2	18	906	finally
    //   68	87	906	finally
    //   888	906	906	finally
    //   939	954	906	finally
    //   18	58	932	java/lang/Exception
  }

  public int updateHistoryCalls(String paramString, long paramLong)
  {
    int i = 0;
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.history_calls.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      Long localLong = Long.valueOf(paramLong);
      localContentValues.put("timestamp", localLong);
      String str1 = HopStopHistoryCallsDB.ADDRESS_VALUES;
      localContentValues.put(str1, paramString);
      String[] arrayOfString1 = paramString.split("&&");
      String str2 = "history_calls";
      String str3 = String.valueOf(HopStopHistoryCallsDB.ADDRESS_VALUES);
      String str4 = str3 + "=?";
      String[] arrayOfString2 = new String[1];
      int j = 0;
      if ((arrayOfString1 != null) && (arrayOfString1.length == 1));
      while (true)
      {
        arrayOfString2[j] = paramString;
        int k = localSQLiteDatabase.update(str2, localContentValues, str4, arrayOfString2);
        i = k;
        if (localSQLiteDatabase != null)
          localSQLiteDatabase.close();
        return i;
        int m = 0;
        paramString = arrayOfString1[m];
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private class DatabaseQueue
  {
    private boolean isRunning;
    private ArrayList<ArrayList<ViewStep>> queue;

    private DatabaseQueue()
    {
      ArrayList localArrayList = new ArrayList();
      this.queue = localArrayList;
      this.isRunning = false;
    }

    /** @deprecated */
    private void execute()
    {
      try
      {
        ArrayList localArrayList1 = this.queue;
        Iterator localIterator = new ArrayList(localArrayList1).iterator();
        while (true)
        {
          boolean bool = localIterator.hasNext();
          if (!bool)
            return;
          ArrayList localArrayList2 = (ArrayList)localIterator.next();
          HistoryManager localHistoryManager = HistoryManager.this;
          HistoryManager.InsertToMyTripTask localInsertToMyTripTask = new HistoryManager.InsertToMyTripTask(localHistoryManager);
          ArrayList[] arrayOfArrayList = new ArrayList[1];
          arrayOfArrayList[0] = localArrayList2;
          AsyncTask localAsyncTask = localInsertToMyTripTask.execute(arrayOfArrayList);
          Object localObject1 = this.queue.remove(0);
        }
      }
      finally
      {
      }
    }

    public void add(ArrayList<ViewStep> paramArrayList)
    {
      synchronized (this.queue)
      {
        boolean bool = this.queue.add(paramArrayList);
        long l = 100L;
        try
        {
          Thread.sleep(l);
          if (!this.isRunning)
            execute();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
            localInterruptedException.printStackTrace();
        }
      }
    }
  }

  protected class InsertToMyTripTask extends AsyncTask<ArrayList<ViewStep>, Integer, String>
  {
    protected InsertToMyTripTask()
    {
    }

    protected String doInBackground(ArrayList<ViewStep>[] paramArrayOfArrayList)
    {
      try
      {
        HistoryManager localHistoryManager = HistoryManager.this;
        ArrayList<ViewStep> localArrayList = paramArrayOfArrayList[0];
        localHistoryManager.insertToMyTripsRequest(localArrayList, false);
        return null;
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
          localOutOfMemoryError.printStackTrace();
      }
    }

    protected void onPostExecute(String paramString)
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.db.HistoryManager
 * JD-Core Version:    0.6.2
 */