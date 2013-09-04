package com.hopstop.ClientModel.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.hopstop.ClientModel.Schedules.City;
import com.hopstop.ClientModel.Schedules.CityStationGroupMapping;
import com.hopstop.ClientModel.Schedules.Group;
import com.hopstop.ClientModel.Schedules.Station;
import com.hopstop.ClientModel.Schedules.StationGroupStationMapping;
import com.hopstop.util.OperationTimeCount;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HSOrmLiteDBHelper extends OrmLiteSqliteOpenHelper
{
  private static final String DATABASE_NAME = "hopstop_db.db";
  private static final int DATABASE_VERSION = 6;
  private static HSOrmLiteDBHelper helper = null;
  private Dao<City, Integer> citiesDao = null;
  private Dao<CityStationGroupMapping, Integer> cityStationGroupMappingDao = null;
  private Dao<Group, Integer> groupsDao = null;
  private Dao<StationGroupStationMapping, Integer> stationGroupStationMappingDao = null;
  private Dao<Station, Integer> stationsDao = null;
  private OperationTimeCount timecount;

  public HSOrmLiteDBHelper(Context paramContext)
  {
    super(paramContext, "hopstop_db.db", null, 6);
    OperationTimeCount localOperationTimeCount = new OperationTimeCount();
    this.timecount = localOperationTimeCount;
  }

  public static HSOrmLiteDBHelper getHelper(Context paramContext)
  {
    if (helper == null)
    {
      helper = new HSOrmLiteDBHelper(paramContext);
      SQLiteDatabase localSQLiteDatabase = helper.getWritableDatabase();
      helper.onCreate(localSQLiteDatabase);
    }
    return helper;
  }

  /** @deprecated */
  public boolean UpdateCities(ArrayList<City> paramArrayList)
  {
    try
    {
      this.timecount.countExecutionTimeStart("UpdateCities");
      int i = TableUtils.clearTable(getConnectionSource(), City.class);
      Iterator localIterator = paramArrayList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.timecount.countExecutionTimeEnd("UpdateCities");
          bool = true;
          return bool;
        }
        City localCity = (City)localIterator.next();
        int j = getCitiesDao().create(localCity);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool = false;
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public boolean UpdateOrInsertCityStationGroupMapping(ArrayList<CityStationGroupMapping> paramArrayList, String paramString1, String paramString2)
  {
    try
    {
      this.timecount.countExecutionTimeStart("UpdateOrInsertCityStationGroupMapping");
      List localList = getCityStationGroupDao().queryForEq(paramString1, paramString2);
      int i = getCityStationGroupDao().delete(localList);
      Iterator localIterator = paramArrayList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.timecount.countExecutionTimeEnd("UpdateOrInsertCityStationGroupMapping");
          bool = true;
          return bool;
        }
        CityStationGroupMapping localCityStationGroupMapping = (CityStationGroupMapping)localIterator.next();
        Object localObject1 = getCityStationGroupDao().createIfNotExists(localCityStationGroupMapping);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool = false;
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public boolean UpdateOrInsertGroups(ArrayList<Group> paramArrayList)
  {
    try
    {
      this.timecount.countExecutionTimeStart("UpdateOrInsertGroups");
      Iterator localIterator = paramArrayList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.timecount.countExecutionTimeEnd("UpdateOrInsertGroups");
          bool = true;
          return bool;
        }
        Group localGroup = (Group)localIterator.next();
        Dao.CreateOrUpdateStatus localCreateOrUpdateStatus = getGroupsDao().createOrUpdate(localGroup);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool = false;
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public boolean UpdateOrInsertStationGroupStationMapping(ArrayList<StationGroupStationMapping> paramArrayList, String paramString1, String paramString2)
  {
    try
    {
      this.timecount.countExecutionTimeStart("UpdateOrInsertStationGroupStationMapping");
      List localList = getStationGroupStationMappingDao().queryForEq(paramString1, paramString2);
      int i = getStationGroupStationMappingDao().delete(localList);
      Iterator localIterator = paramArrayList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.timecount.countExecutionTimeEnd("UpdateOrInsertStationGroupStationMapping");
          bool = true;
          return bool;
        }
        StationGroupStationMapping localStationGroupStationMapping = (StationGroupStationMapping)localIterator.next();
        Object localObject1 = getStationGroupStationMappingDao().createIfNotExists(localStationGroupStationMapping);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool = false;
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public boolean UpdateOrInsertStations(ArrayList<Station> paramArrayList)
  {
    try
    {
      this.timecount.countExecutionTimeStart("UpdateOrInsertStations");
      Iterator localIterator = paramArrayList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.timecount.countExecutionTimeEnd("UpdateOrInsertStations");
          bool = true;
          return bool;
        }
        Station localStation = (Station)localIterator.next();
        Dao.CreateOrUpdateStatus localCreateOrUpdateStatus = getStationsDao().createOrUpdate(localStation);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool = false;
      }
    }
    finally
    {
    }
  }

  public void close()
  {
    super.close();
    this.citiesDao = null;
    this.groupsDao = null;
    this.stationsDao = null;
    this.cityStationGroupMappingDao = null;
    this.stationGroupStationMappingDao = null;
  }

  public Dao<City, Integer> getCitiesDao()
    throws SQLException
  {
    if (this.citiesDao == null)
    {
      Dao localDao = getDao(City.class);
      this.citiesDao = localDao;
    }
    return this.citiesDao;
  }

  public Dao<CityStationGroupMapping, Integer> getCityStationGroupDao()
  {
    if (this.cityStationGroupMappingDao == null);
    try
    {
      Dao localDao = getDao(CityStationGroupMapping.class);
      this.cityStationGroupMappingDao = localDao;
      return this.cityStationGroupMappingDao;
    }
    catch (SQLException localSQLException)
    {
      while (true)
        localSQLException.printStackTrace();
    }
  }

  public Dao<Group, Integer> getGroupsDao()
    throws SQLException
  {
    if (this.groupsDao == null)
    {
      Dao localDao = getDao(Group.class);
      this.groupsDao = localDao;
    }
    return this.groupsDao;
  }

  public Dao<StationGroupStationMapping, Integer> getStationGroupStationMappingDao()
  {
    if (this.stationGroupStationMappingDao == null);
    try
    {
      Dao localDao = getDao(StationGroupStationMapping.class);
      this.stationGroupStationMappingDao = localDao;
      return this.stationGroupStationMappingDao;
    }
    catch (SQLException localSQLException)
    {
      while (true)
        localSQLException.printStackTrace();
    }
  }

  public Dao<Station, Integer> getStationsDao()
    throws SQLException
  {
    if (this.stationsDao == null)
    {
      Dao localDao = getDao(Station.class);
      this.stationsDao = localDao;
    }
    return this.stationsDao;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource)
  {
    try
    {
      int i = TableUtils.createTableIfNotExists(paramConnectionSource, City.class);
      int j = TableUtils.createTableIfNotExists(paramConnectionSource, Group.class);
      int k = TableUtils.createTableIfNotExists(paramConnectionSource, Station.class);
      int m = TableUtils.createTableIfNotExists(paramConnectionSource, CityStationGroupMapping.class);
      int n = TableUtils.createTableIfNotExists(paramConnectionSource, StationGroupStationMapping.class);
      long l = System.currentTimeMillis();
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 5) && (paramInt2 == 6))
      return;
    try
    {
      int i = TableUtils.dropTable(paramConnectionSource, City.class, true);
      int j = TableUtils.dropTable(paramConnectionSource, Group.class, true);
      int k = TableUtils.dropTable(paramConnectionSource, Station.class, true);
      int m = TableUtils.dropTable(paramConnectionSource, CityStationGroupMapping.class, true);
      int n = TableUtils.dropTable(paramConnectionSource, StationGroupStationMapping.class, true);
      onCreate(paramSQLiteDatabase, paramConnectionSource);
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.db.HSOrmLiteDBHelper
 * JD-Core Version:    0.6.2
 */