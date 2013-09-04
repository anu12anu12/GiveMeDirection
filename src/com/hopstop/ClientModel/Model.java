package com.hopstop.ClientModel;

import android.location.Location;
import android.view.View;
import com.hopstop.ClientModel.Schedules.Cities;
import com.hopstop.ClientModel.Schedules.Groups;
import com.hopstop.ClientModel.Schedules.Stations;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.ClientModel.directions.RouteInfo;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.ClientModel.xml.MapsSet;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Model
{
  private static final String DATE_FORMAT_NOW = "HH:mm";
  private String[] CountyNames;
  private String[] CountyUrlIds;
  private ServiceAdvisorResponse _sar;
  private String _skyhook_user;
  private ArrayList<HopStopCity> cities;
  private Map<String, String> citiesIdTable;
  private Map<String, String> citiesNameTable;
  private DirectionMode dMode;
  private int day;
  private String defaultCity;
  private String defaultCityA;
  private String defaultCityB;
  private String defaultCityMap;
  private int defaultCitySelectionDone;
  private int defaultCity_map;
  private int defaultCounty;
  private int defaultCounty_A;
  private int defaultCounty_B;
  private int defaultCounty_map;
  private Long delayUpdateTime;
  private DirectionRequest dr;
  private LinkedList<Hashtable<String, Long>> history_calls;
  private boolean isArriveBy;
  private boolean isExpressBusIncluded;
  private boolean isMiles;
  private boolean isSimplifiedDirections;
  private boolean isSmartRouteEnabled;
  private String lang;
  private String[] languages;
  private boolean lastConnSuccess;
  private Address lastReqMapAddr;
  private Location loc;
  private MapResponse mResStore;
  private String mapID;
  private String map_mode;
  private ArrayList<MapsSet> mapsSets;
  private ArrayList<ViewStep> mostRecentMyTrip;
  private boolean private_vehicles;
  private boolean regional_rail;
  private Cities scheduleCities;
  private Map<String, Stations> schedulesStationMapping;
  private Map<String, Groups> stationGroupMapping;
  private TaxiResponse taxiRes;
  private String time;
  private int transferPriority;
  private DirectionResponse trips;
  private ArrayList<ArrayList<ViewStep>> viewSteps;
  private Hashtable<Integer, View> views;
  private boolean wheel_chair;

  public Model()
  {
    Hashtable localHashtable = new Hashtable();
    this.views = localHashtable;
    ArrayList localArrayList1 = new ArrayList();
    this.mapsSets = localArrayList1;
    LinkedList localLinkedList = new LinkedList();
    this.history_calls = localLinkedList;
    MapResponse localMapResponse = new MapResponse();
    this.mResStore = localMapResponse;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    Date localDate = new Date();
    String str = localSimpleDateFormat.format(localDate);
    this.time = str;
    this.transferPriority = 1;
    this.cities = null;
    HashMap localHashMap1 = new HashMap();
    this.citiesIdTable = localHashMap1;
    HashMap localHashMap2 = new HashMap();
    this.citiesNameTable = localHashMap2;
    HashMap localHashMap3 = new HashMap();
    this.stationGroupMapping = localHashMap3;
    Cities localCities = new Cities();
    this.scheduleCities = localCities;
    HashMap localHashMap4 = new HashMap();
    this.schedulesStationMapping = localHashMap4;
    String[] arrayOfString1 = new String[8];
    arrayOfString1[0] = "Bronx";
    arrayOfString1[1] = "Brooklyn";
    arrayOfString1[2] = "Manhattan";
    arrayOfString1[3] = "Queens";
    arrayOfString1[4] = "Staten Island";
    arrayOfString1[5] = "Long Island";
    arrayOfString1[6] = "Metro North Area";
    arrayOfString1[7] = "New Jersey";
    this.CountyNames = arrayOfString1;
    String[] arrayOfString2 = new String[5];
    arrayOfString2[0] = "BRONX, NY, USA";
    arrayOfString2[1] = "BROOKLYN, NY, USA";
    arrayOfString2[2] = "MANHATTAN, NY, USA";
    arrayOfString2[3] = "QUEENS, NY, USA";
    arrayOfString2[4] = "STATEN ISLAND, NY, USA";
    this.CountyUrlIds = arrayOfString2;
    this._skyhook_user = null;
    this.lastConnSuccess = true;
    ArrayList localArrayList2 = new ArrayList();
    this.viewSteps = localArrayList2;
    this.defaultCounty = 2;
    this.defaultCitySelectionDone = 0;
    this.regional_rail = false;
    this.private_vehicles = false;
    this.wheel_chair = false;
    this.isArriveBy = false;
    this.isSimplifiedDirections = false;
    this.isExpressBusIncluded = true;
    this.isSmartRouteEnabled = true;
    this.isMiles = true;
    DirectionMode localDirectionMode = new DirectionMode();
    this.dMode = localDirectionMode;
  }

  private void deleteMyTripFromDB(String paramString)
  {
    int i = ApplicationEngine.getHistoryManager(null).deleteMyTripRecord(paramString);
  }

  private void deleteRecord(String paramString)
  {
    int i = ApplicationEngine.getHistoryManager(null).deleteHistoryRecord(paramString);
  }

  private void moveSelectedItemOnTop(String paramString)
  {
    if (this.cities == null)
      return;
    if (paramString == null)
      return;
    ArrayList localArrayList1 = this.cities;
    ArrayList localArrayList2 = new ArrayList(localArrayList1);
    int i = 0;
    while (true)
    {
      int j = localArrayList2.size();
      if (i >= j)
      {
        this.cities = localArrayList2;
        return;
      }
      if (((HopStopCity)localArrayList2.get(i)).getName().equalsIgnoreCase(paramString))
      {
        HopStopCity localHopStopCity = (HopStopCity)localArrayList2.remove(i);
        localArrayList2.add(0, localHopStopCity);
      }
      i += 1;
    }
  }

  private String now()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    Date localDate = localCalendar.getTime();
    return localSimpleDateFormat.format(localDate);
  }

  private void sortHopStopCities()
  {
    ArrayList localArrayList1 = this.cities;
    ArrayList localArrayList2 = new ArrayList(localArrayList1);
    HopStopCityComparator localHopStopCityComparator = new HopStopCityComparator(null);
    Collections.sort(localArrayList2, localHopStopCityComparator);
    this.cities = localArrayList2;
  }

  private void updateDatabase(String paramString, long paramLong)
  {
    HistoryManager localHistoryManager = ApplicationEngine.getHistoryManager(null);
    String[] arrayOfString = paramString.split("&&");
    String str = arrayOfString[0];
    int i = localHistoryManager.deleteHistoryRecord(str);
    if ((arrayOfString != null) && (arrayOfString.length == 2))
      int j = localHistoryManager.deleteHistoryRecord(paramString);
    localHistoryManager.insertToHistoryCalls(paramString, paramLong);
  }

  private void updateMyTripsDB(ArrayList<ViewStep> paramArrayList)
    throws OutOfMemoryError, IOException
  {
    ApplicationEngine.getHistoryManager(null).executeInserTask(paramArrayList, false);
  }

  public void AddSchedulesStationsMapping(String paramString, Stations paramStations)
  {
    if (this.schedulesStationMapping.containsKey(paramString))
      return;
    Stations localStations = paramStations.clone();
    Object localObject = this.schedulesStationMapping.put(paramString, localStations);
  }

  public void AddStationGroupMapping(String paramString, Groups paramGroups)
  {
    if (this.stationGroupMapping.containsKey(paramString))
      return;
    Groups localGroups = paramGroups.clone();
    Object localObject = this.stationGroupMapping.put(paramString, localGroups);
  }

  public double Latitude()
  {
    return this.loc.getLatitude();
  }

  public double Longitude()
  {
    return this.loc.getLongitude();
  }

  public boolean addHopStopCities(ArrayList<HopStopCity> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      this.cities = paramArrayList;
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void addMapResponses(int paramInt, MapResponse paramMapResponse)
  {
    this.mResStore = paramMapResponse;
  }

  public void addMapSets(MapsSet paramMapsSet)
  {
    boolean bool = this.mapsSets.add(paramMapsSet);
  }

  public int addMyTrip(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localIterator = this.mostRecentMyTrip.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          ((ViewStepTotal)localArrayList.get(0)).setMyTripName(paramString);
          this.viewSteps.add(0, localArrayList);
          updateMyTripsDB(localArrayList);
          localIterator = null;
          return localIterator;
        }
        ViewStep localViewStep = ((ViewStep)localIterator.next()).cloneItself();
        boolean bool = localArrayList.add(localViewStep);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
        localIterator = null;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        Iterator localIterator = null;
      }
    }
  }

  public void addMyTrip(int paramInt, ArrayList<ViewStep> paramArrayList)
  {
    this.viewSteps.add(paramInt, paramArrayList);
  }

  public void addTrip(int paramInt, DirectionResponse paramDirectionResponse)
    throws OutOfMemoryError, IOException
  {
    this.trips = paramDirectionResponse;
    if (this.trips.isSmartRoute())
      return;
    DirectionResponse localDirectionResponse = this.trips;
    updateRecentTrip(localDirectionResponse);
  }

  public void addView(int paramInt, View paramView)
  {
    if (paramView == null)
      return;
    Hashtable localHashtable = this.views;
    Integer localInteger = Integer.valueOf(paramInt);
    Object localObject = localHashtable.put(localInteger, paramView);
  }

  public boolean checkForDuplicateTrip(String paramString)
  {
    boolean bool = false;
    if ((this.viewSteps == null) || (this.viewSteps.size() == 0))
      break label29;
    while (true)
    {
      return bool;
      Iterator localIterator = this.viewSteps.iterator();
      label29: if (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)localIterator.next();
        if (localArrayList == null)
          break;
        ViewStepTotal localViewStepTotal = (ViewStepTotal)localArrayList.get(0);
        if ((localViewStepTotal == null) || (localViewStepTotal.getMyTripName() == null) || (!localViewStepTotal.getMyTripName().equalsIgnoreCase(paramString)))
          break;
        bool = true;
      }
    }
  }

  public void cleanMyRecentTrip()
  {
    if (this.mostRecentMyTrip == null)
      return;
    this.mostRecentMyTrip.clear();
    this.mostRecentMyTrip = null;
  }

  public void deleteHistoryCalls(String paramString)
  {
    Iterator localIterator = this.history_calls.iterator();
    Hashtable localHashtable;
    do
    {
      if (!localIterator.hasNext())
        return;
      localHashtable = (Hashtable)localIterator.next();
    }
    while (!localHashtable.containsKey(paramString));
    deleteRecord(paramString);
    boolean bool = this.history_calls.remove(localHashtable);
  }

  public void deleteMyTrip(int paramInt)
  {
    if (getMyTrips() == null)
      return;
    int i = getMyTrips().size();
    if (paramInt >= i)
      return;
    String str = ((ViewStepTotal)((ArrayList)getMyTrips().remove(paramInt)).get(0)).getMyTripName();
    deleteMyTripFromDB(str);
  }

  public String findSelectedCityFromShotName(String paramString)
  {
    String str = null;
    int i;
    if (this.cities != null)
      i = 0;
    while (true)
    {
      int j = this.cities.size();
      if (i >= j);
      while (true)
      {
        return str;
        HopStopCity localHopStopCity = (HopStopCity)this.cities.get(i);
        if (!localHopStopCity.getId().equalsIgnoreCase(paramString))
          break;
        str = localHopStopCity.getName();
      }
      i += 1;
    }
  }

  public int getCitiesCount()
  {
    if (this.cities == null);
    for (int i = 0; ; i = this.cities.size())
      return i;
  }

  public String[] getCitiesNames()
  {
    String[] arrayOfString = new String[this.cities.size()];
    int i = 0;
    Iterator localIterator = this.cities.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return arrayOfString;
      HopStopCity localHopStopCity = (HopStopCity)localIterator.next();
      int j = i + 1;
      String str = localHopStopCity.getName();
      arrayOfString[i] = str;
      i = j;
    }
  }

  public String getCountyId(int paramInt)
  {
    return this.CountyUrlIds[paramInt];
  }

  public String[] getCountyNames()
  {
    return this.CountyNames;
  }

  public int getDay()
  {
    int i = 1;
    if ((this.day < i) || (this.day > 7));
    while (true)
    {
      return i;
      i = this.day;
    }
  }

  public int getDefaultCity()
  {
    int i = 0;
    while (true)
    {
      int j = this.cities.size();
      if (i >= j)
        i = -1;
      while (((HopStopCity)this.cities.get(i)).getId().equals("newyork"))
        return i;
      i += 1;
    }
  }

  public String getDefaultCityAId()
  {
    return getDefaultCityId();
  }

  public String getDefaultCityBId()
  {
    return getDefaultCityId();
  }

  public String getDefaultCityByWidgetId(int paramInt)
  {
    return getDefaultCityId();
  }

  public String getDefaultCityId()
  {
    if (this.defaultCity != null);
    for (String str = this.defaultCity; ; str = "newyork")
      return str;
  }

  public String getDefaultCityMapId()
  {
    return getDefaultCityId();
  }

  public String getDefaultCityName()
  {
    String str1;
    if ((this.defaultCity != null) && (this.citiesNameTable != null))
      str1 = this.defaultCity;
    for (String str2 = getNameFromCitiesMap(str1); ; str2 = "")
      return str2;
  }

  public int getDefaultCityPosition(int paramInt)
  {
    String str1 = getDefaultCityId();
    int i;
    if ((this.cities != null) && (str1 != null))
      i = 0;
    while (true)
    {
      int j = this.cities.size();
      if (i >= j)
        i = 0;
      String str2;
      do
      {
        return i;
        str2 = ((HopStopCity)this.cities.get(i)).getId();
      }
      while (str1.equals(str2));
      i += 1;
    }
  }

  public int getDefaultCitySelectionDone()
  {
    return this.defaultCitySelectionDone;
  }

  public int getDefaultCounty()
  {
    if ((this.defaultCounty >= 0) && (this.defaultCounty <= 4));
    for (int i = this.defaultCounty; ; i = 2)
      return i;
  }

  public String getDefaultCountyNames_A()
  {
    String[] arrayOfString = this.CountyNames;
    int i = this.defaultCounty_A;
    return arrayOfString[i];
  }

  public String getDefaultCountyNames_B()
  {
    String[] arrayOfString = this.CountyNames;
    int i = this.defaultCounty_B;
    return arrayOfString[i];
  }

  public int getDefaultCountySelection()
  {
    return this.defaultCounty;
  }

  public String getDefaultCountyUrlIds_Map()
  {
    String[] arrayOfString;
    int i;
    if ((this.defaultCounty_map >= 0) && (this.defaultCounty_map <= 4))
    {
      arrayOfString = this.CountyUrlIds;
      i = this.defaultCounty_map;
    }
    for (String str = arrayOfString[i]; ; str = null)
      return str;
  }

  public int getDefaultMapCitySelection()
  {
    return this.defaultCity_map;
  }

  public int getDefaultMapCountySelection()
  {
    return this.defaultCounty_map;
  }

  public long getDelayUpdateTime()
  {
    return this.delayUpdateTime.longValue();
  }

  public DirectionMode getDirectionMode()
  {
    return this.dMode;
  }

  public DirectionRequest getDirectionRequest()
  {
    return this.dr;
  }

  public LinkedList<Hashtable<String, Long>> getHistoryCalls()
  {
    return this.history_calls;
  }

  public LinkedList<String> getHistoryCallsKeys()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.history_calls.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localLinkedList;
      Enumeration localEnumeration = ((Hashtable)localIterator.next()).keys();
      while (localEnumeration.hasMoreElements())
      {
        String str = (String)localEnumeration.nextElement();
        boolean bool = localLinkedList.add(str);
      }
    }
  }

  public ArrayList<HopStopCity> getHopStopCities()
  {
    return this.cities;
  }

  public String getIdFromCitiesMap(String paramString)
  {
    if (this.citiesIdTable == null);
    for (String str = null; ; str = (String)this.citiesIdTable.get(paramString))
      return str;
  }

  public boolean getIsArriveBy()
  {
    return this.isArriveBy;
  }

  public int getIsArriveByInt()
  {
    if (this.isArriveBy);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean getIsExpressBusIncluded()
  {
    return this.isExpressBusIncluded;
  }

  public int getIsExpressBusIncludedInt()
  {
    if (this.isExpressBusIncluded);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean getIsMiles()
  {
    return this.isMiles;
  }

  public boolean getIsSimplifiedDirections()
  {
    return this.isSimplifiedDirections;
  }

  public int getIsSimplifiedDirectionsInt()
  {
    if (this.isSimplifiedDirections);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean getIsSmartRouteEnabled()
  {
    return this.isSmartRouteEnabled;
  }

  public String getLanguage()
  {
    if (this.lang == null);
    for (String str = "en"; ; str = this.lang)
      return str;
  }

  public String[] getLanguages()
  {
    return this.languages;
  }

  public boolean getLastConnSuccess()
  {
    return this.lastConnSuccess;
  }

  public Address getLastMapAddress()
  {
    return this.lastReqMapAddr;
  }

  public MapsSet getLastMapsSet()
  {
    ArrayList localArrayList;
    int i;
    if (this.mapsSets.size() > 0)
    {
      localArrayList = this.mapsSets;
      i = this.mapsSets.size() + -1;
    }
    for (MapsSet localMapsSet = (MapsSet)localArrayList.get(i); ; localMapsSet = null)
      return localMapsSet;
  }

  public String getLongLanguage(String paramString)
  {
    int i = 0;
    if (paramString.equalsIgnoreCase("en"))
      i = 0;
    while (true)
    {
      return this.languages[i];
      if (paramString.equalsIgnoreCase("es"))
        i = 1;
      else if (paramString.equalsIgnoreCase("ru"))
        i = 2;
      else if (paramString.equalsIgnoreCase("fr"))
        i = 3;
      else if (paramString.equalsIgnoreCase("zh"))
        i = 4;
      else if (paramString.equalsIgnoreCase("de"))
        i = 5;
      else if (paramString.equalsIgnoreCase("el"))
        i = 6;
      else if (paramString.equalsIgnoreCase("it"))
        i = 7;
      else if (paramString.equalsIgnoreCase("sw"))
        i = 8;
    }
  }

  public ViewStepTotal getMRViewStepTotal()
  {
    if ((this.mostRecentMyTrip != null) && (this.mostRecentMyTrip.size() > 0));
    for (ViewStepTotal localViewStepTotal = (ViewStepTotal)this.mostRecentMyTrip.get(0); ; localViewStepTotal = null)
      return localViewStepTotal;
  }

  public String getMapCityID()
  {
    ArrayList localArrayList;
    int i;
    if (this.cities != null)
    {
      localArrayList = this.cities;
      i = this.defaultCity_map;
    }
    for (String str = ((HopStopCity)localArrayList.get(i)).getId(); ; str = "")
      return str;
  }

  public String getMapID()
  {
    return this.mapID;
  }

  public String getMapMode()
  {
    if (this.map_mode == null);
    for (String str = "s"; ; str = this.map_mode)
      return str;
  }

  public MapsSet getMapsSet(int paramInt)
  {
    if (this.mapsSets.size() < 0);
    for (MapsSet localMapsSet = null; ; localMapsSet = (MapsSet)this.mapsSets.get(paramInt))
      return localMapsSet;
  }

  public ArrayList<ViewStep> getMyTrip(int paramInt)
  {
    if (this.viewSteps == null);
    for (Object localObject = null; ; localObject = (ArrayList)this.viewSteps.get(paramInt))
      return localObject;
  }

  /** @deprecated */
  public ArrayList<ArrayList<ViewStep>> getMyTrips()
  {
    try
    {
      ArrayList localArrayList = this.viewSteps;
      if (localArrayList == null);
      for (Object localObject1 = null; ; localObject1 = this.viewSteps)
        return localObject1;
    }
    finally
    {
    }
  }

  public int getMyTripsCount()
  {
    if (this.viewSteps == null);
    for (int i = 0; ; i = this.viewSteps.size())
      return i;
  }

  public String getNameFromCitiesMap(String paramString)
  {
    if (this.citiesNameTable == null);
    for (String str = null; ; str = (String)this.citiesNameTable.get(paramString))
      return str;
  }

  public ArrayList<ViewStep> getRecentTrip()
  {
    if (this.mostRecentMyTrip != null);
    for (ArrayList localArrayList = this.mostRecentMyTrip; ; localArrayList = null)
      return localArrayList;
  }

  public Cities getScheduleCities()
  {
    return this.scheduleCities;
  }

  public Stations getScheduleStations(String paramString)
  {
    return (Stations)this.schedulesStationMapping.get(paramString);
  }

  public Map<String, Stations> getSchedulesStationMapping()
  {
    return this.schedulesStationMapping;
  }

  public String getSelectedCityFromName(String paramString)
  {
    Iterator localIterator;
    String str;
    if (this.cities != null)
    {
      localIterator = this.cities.iterator();
      if (!localIterator.hasNext())
        str = "newyork";
    }
    while (true)
    {
      return str;
      HopStopCity localHopStopCity = (HopStopCity)localIterator.next();
      if (!localHopStopCity.getName().equalsIgnoreCase(paramString))
        break;
      str = localHopStopCity.getId();
      continue;
      str = "";
    }
  }

  public int getSelectedCityFromShotName(String paramString)
  {
    int i;
    if (this.cities != null)
    {
      i = 0;
      int j = this.cities.size();
      if (i >= j)
        i = -1;
    }
    while (true)
    {
      return i;
      if (!((HopStopCity)this.cities.get(i)).getId().equalsIgnoreCase(paramString))
      {
        i += 1;
        break;
        i = -1;
      }
    }
  }

  public String getSelectedCityID(int paramInt)
  {
    if (this.cities != null);
    for (String str = ((HopStopCity)this.cities.get(paramInt)).getId(); ; str = "")
      return str;
  }

  public int getSelectedLanguageId()
  {
    if (this.languages == null)
    {
      i = -1;
      return i;
    }
    String str1 = getLanguage();
    String str2 = getLongLanguage(str1);
    int i = 0;
    while (true)
    {
      int j = this.languages.length;
      if (i >= j)
      {
        i = -1;
        break;
      }
      if (this.languages[i].equalsIgnoreCase(str2))
        break;
      i += 1;
    }
  }

  public ServiceAdvisorResponse getServiceAdvisorResponse()
  {
    return this._sar;
  }

  public String getShortLanguage(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = null;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return str;
      str = "en";
      continue;
      str = "es";
      continue;
      str = "ru";
      continue;
      str = "fr";
      continue;
      str = "zh";
      continue;
      str = "de";
      continue;
      str = "el";
      continue;
      str = "it";
      continue;
      str = "sw";
    }
  }

  public String getSkyHookUser()
  {
    return this._skyhook_user;
  }

  public Groups getStationGroupMapping(String paramString)
  {
    return (Groups)this.stationGroupMapping.get(paramString);
  }

  public Map<String, Groups> getStationGroupMapping()
  {
    return this.stationGroupMapping;
  }

  public TaxiResponse getTaxiResponse()
  {
    return this.taxiRes;
  }

  public String getTime()
  {
    SimpleDateFormat localSimpleDateFormat;
    Date localDate;
    if ((this.time.equals("")) || (this.time == null))
    {
      localSimpleDateFormat = new SimpleDateFormat("HH:mm");
      localDate = new Date();
    }
    for (String str = localSimpleDateFormat.format(localDate); ; str = this.time)
      return str;
  }

  public String getTimeAMPM()
  {
    Object localObject;
    if ((this.time.equals("")) || (this.time == null))
    {
      SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("hh:mm a");
      Date localDate1 = new Date();
      localObject = localSimpleDateFormat1.format(localDate1);
    }
    while (true)
    {
      return localObject;
      try
      {
        SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("HH:mm");
        String str1 = this.time;
        Date localDate2 = localSimpleDateFormat2.parse(str1);
        String str2 = new SimpleDateFormat("h:mm a").format(localDate2);
        localObject = str2;
      }
      catch (ParseException localParseException)
      {
        localObject = this.time;
      }
    }
  }

  public int getTransferPriority()
  {
    return this.transferPriority;
  }

  public DirectionResponse getTrip(int paramInt)
  {
    return this.trips;
  }

  public void initHistory(LinkedList<Hashtable<String, Long>> paramLinkedList)
  {
    this.history_calls.clear();
    boolean bool = this.history_calls.addAll(paramLinkedList);
  }

  public void initMyTrips(ArrayList<ArrayList<ViewStep>> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList);
    this.viewSteps = localArrayList;
  }

  public boolean isBikeModeAvailble()
  {
    if ((this.defaultCityA.equalsIgnoreCase("newyork")) && (this.defaultCityB.equalsIgnoreCase("newyork")));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isPrivate_vehicles()
  {
    return this.private_vehicles;
  }

  public boolean isRegional_rail()
  {
    return this.regional_rail;
  }

  public boolean isWheelChairOn()
  {
    return this.wheel_chair;
  }

  public Location lastKnownLocation()
  {
    return this.loc;
  }

  public void placeSelectedCityOnTop()
  {
  }

  public void rearrangeCities(String paramString)
  {
    sortHopStopCities();
    moveSelectedItemOnTop(paramString);
  }

  public boolean removeMyTrip(int paramInt)
  {
    boolean bool = false;
    if (this.viewSteps == null);
    while (true)
    {
      return bool;
      try
      {
        Object localObject = this.viewSteps.remove(paramInt);
        bool = true;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
      }
    }
  }

  public void resetToDefault()
  {
    setIsArriveBy(false);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    Date localDate = new Date();
    String str = localSimpleDateFormat.format(localDate);
    this.time = str;
  }

  public int return_selection_from_day()
  {
    return this.day + -1;
  }

  public void saveRecentBeforeFinish()
    throws OutOfMemoryError, IOException
  {
    if (this.mostRecentMyTrip == null)
      return;
    if (this.mostRecentMyTrip.size() <= 0)
      return;
    ((ViewStepTotal)this.mostRecentMyTrip.get(0)).setRecent(true);
    ArrayList localArrayList = this.mostRecentMyTrip;
    updateMyTripsDB(localArrayList);
  }

  public void setDay(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 7))
    {
      this.day = paramInt;
      return;
    }
    this.day = 1;
  }

  public void setDefaultCityAId(String paramString)
  {
    if (paramString == null)
      return;
    this.defaultCityA = paramString;
  }

  public void setDefaultCityBId(String paramString)
  {
    if (paramString == null)
      return;
    this.defaultCityB = paramString;
  }

  public void setDefaultCityByWidgetId(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2131493001:
      setDefaultCityAId(paramString);
      return;
    case 2131493009:
      setDefaultCityBId(paramString);
      return;
    case 2131493023:
      setDefaultCityMapId(paramString);
      return;
    case 2131492900:
    }
    setDefaultCityId(paramString);
    setDefaultCityAId(paramString);
    setDefaultCityBId(paramString);
    setDefaultCityMapId(paramString);
  }

  public void setDefaultCityId(String paramString)
  {
    if (paramString == null)
      return;
    this.defaultCity = paramString;
  }

  public void setDefaultCityMapId(String paramString)
  {
    if (paramString == null)
      return;
    this.defaultCityMap = paramString;
  }

  public void setDefaultCityPosition(int paramInt)
  {
    if (paramInt == -1)
    {
      String str1 = getSelectedCityID(0);
      setDefaultCityByWidgetId(0, str1);
      return;
    }
    String str2 = getSelectedCityID(paramInt);
    setDefaultCityByWidgetId(paramInt, str2);
  }

  public void setDefaultCitySelectionDone(int paramInt)
  {
    this.defaultCitySelectionDone = paramInt;
  }

  public void setDefaultCounty(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 4))
    {
      this.defaultCounty = paramInt;
      return;
    }
    this.defaultCounty = 2;
  }

  public void setDefaultCountySelection(int paramInt)
  {
    if (paramInt == -1)
    {
      int i = getDefaultCounty();
      this.defaultCounty = i;
      return;
    }
    this.defaultCounty = paramInt;
  }

  public void setDefaultMapCitySelection(int paramInt)
  {
    if (paramInt == -1)
    {
      int i = getDefaultCity();
      this.defaultCity_map = i;
      return;
    }
    this.defaultCity_map = paramInt;
  }

  public void setDefaultMapCountySelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 4))
    {
      this.defaultCounty_map = paramInt;
      return;
    }
    this.defaultCounty_map = 2;
  }

  public void setDelayUpdateTime(long paramLong)
  {
    Long localLong = Long.valueOf(paramLong);
    this.delayUpdateTime = localLong;
  }

  public void setDirectionRequest(DirectionRequest paramDirectionRequest)
  {
    this.dr = paramDirectionRequest;
  }

  public void setIsArriveBy(boolean paramBoolean)
  {
    this.isArriveBy = paramBoolean;
  }

  public void setIsExpressBusIncluded(boolean paramBoolean)
  {
    this.isExpressBusIncluded = paramBoolean;
  }

  public void setIsMiles(boolean paramBoolean)
  {
    this.isMiles = paramBoolean;
  }

  public void setIsSimplifiedDirections(boolean paramBoolean)
  {
    this.isSimplifiedDirections = paramBoolean;
  }

  public void setIsSmartRouteEnabled(boolean paramBoolean)
  {
    this.isSmartRouteEnabled = paramBoolean;
  }

  public void setLanguage(String paramString)
  {
    this.lang = paramString;
  }

  public void setLanguages(String[] paramArrayOfString)
  {
    this.languages = paramArrayOfString;
  }

  public void setLastConnSuccess(boolean paramBoolean)
  {
    this.lastConnSuccess = paramBoolean;
  }

  public void setLastMapAddress(Address paramAddress)
  {
    if (paramAddress == null)
      return;
    this.lastReqMapAddr = paramAddress;
  }

  public void setMapID(String paramString)
  {
    if (paramString == null)
      return;
    this.mapID = paramString;
  }

  public void setMapMode(String paramString)
  {
    if (paramString.equals(""))
    {
      this.map_mode = "a";
      return;
    }
    this.map_mode = paramString;
  }

  public void setPrivate_vehicles(boolean paramBoolean)
  {
    this.private_vehicles = paramBoolean;
  }

  public void setRegional_rail(boolean paramBoolean)
  {
    this.regional_rail = paramBoolean;
  }

  public void setScheduleCities(Cities paramCities)
  {
    this.scheduleCities = paramCities;
  }

  public void setSchedulesStationMapping(Map<String, Stations> paramMap)
  {
    this.schedulesStationMapping = paramMap;
  }

  public void setServiceAdvisorResponse(ServiceAdvisorResponse paramServiceAdvisorResponse)
  {
    this._sar = paramServiceAdvisorResponse;
  }

  public void setSkyHookUser(String paramString)
  {
    if (paramString == null)
      return;
    if (paramString.length() <= 0)
      return;
    this._skyhook_user = paramString;
  }

  public void setStationGroupMapping(Map<String, Groups> paramMap)
  {
    this.stationGroupMapping = paramMap;
  }

  public void setTaxiResponse(TaxiResponse paramTaxiResponse)
  {
    this.taxiRes = paramTaxiResponse;
    ArrayList localArrayList = this.taxiRes.getViewStepTaxi();
    this.mostRecentMyTrip = localArrayList;
  }

  public void setTime(String paramString)
  {
    if (paramString.equals(""))
    {
      String str = now();
      this.time = str;
      return;
    }
    this.time = paramString;
  }

  public void setTransferPriority(int paramInt)
  {
    this.transferPriority = paramInt;
  }

  public void setWheelChairOn(boolean paramBoolean)
  {
    this.wheel_chair = paramBoolean;
  }

  public void set_selection_for_day(int paramInt)
  {
    int i = paramInt + 1;
    this.day = i;
  }

  public void updateCitiesMap()
  {
    if (this.cities == null)
      return;
    this.citiesIdTable.clear();
    Iterator localIterator1 = this.cities.iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        this.citiesNameTable.clear();
        Iterator localIterator2 = this.cities.iterator();
        while (true)
        {
          if (!localIterator2.hasNext())
            return;
          HopStopCity localHopStopCity1 = (HopStopCity)localIterator2.next();
          if (localHopStopCity1 != null)
          {
            Map localMap1 = this.citiesNameTable;
            String str1 = localHopStopCity1.getId();
            String str2 = localHopStopCity1.getName();
            Object localObject1 = localMap1.put(str1, str2);
          }
        }
      }
      HopStopCity localHopStopCity2 = (HopStopCity)localIterator1.next();
      if (localHopStopCity2 != null)
      {
        Map localMap2 = this.citiesIdTable;
        String str3 = localHopStopCity2.getName();
        String str4 = localHopStopCity2.getId();
        Object localObject2 = localMap2.put(str3, str4);
      }
    }
  }

  public void updateCurrentLocation(Location paramLocation, int paramInt1, int paramInt2, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    this.loc = paramLocation;
    if (paramUiCallBack == null)
      return;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramLocation;
    paramUiCallBack.onStatusChanged(paramInt1, paramInt2, arrayOfObject);
  }

  public void updateHistoryCalls(String paramString)
  {
    long l = Calendar.getInstance().getTime().getTime();
    Iterator localIterator = this.history_calls.iterator();
    if (!localIterator.hasNext());
    while (true)
    {
      Hashtable localHashtable1 = new Hashtable();
      Long localLong = Long.valueOf(l);
      Object localObject = localHashtable1.put(paramString, localLong);
      this.history_calls.add(0, localHashtable1);
      updateDatabase(paramString, l);
      return;
      Hashtable localHashtable2 = (Hashtable)localIterator.next();
      String[] arrayOfString = paramString.split("&&");
      if (!localHashtable2.containsKey(paramString))
      {
        String str = arrayOfString[0];
        if (!localHashtable2.containsKey(str))
          break;
      }
      boolean bool = this.history_calls.remove(localHashtable2);
    }
  }

  public void updateRecentTrip(DirectionResponse paramDirectionResponse)
  {
    if (paramDirectionResponse == null)
      return;
    ArrayList localArrayList1 = new ArrayList();
    this.mostRecentMyTrip = localArrayList1;
    ArrayList localArrayList2 = this.mostRecentMyTrip;
    ViewStepTotal localViewStepTotal = paramDirectionResponse.getViewStepTotal();
    boolean bool1 = localArrayList2.add(localViewStepTotal);
    ArrayList localArrayList3 = this.mostRecentMyTrip;
    ViewStepAddress localViewStepAddress1 = paramDirectionResponse.getRouteInfo().getViewStepAddress1();
    boolean bool2 = localArrayList3.add(localViewStepAddress1);
    ArrayList localArrayList4 = this.mostRecentMyTrip;
    ViewStepAddress localViewStepAddress2 = paramDirectionResponse.getRouteInfo().getViewStepAddress2();
    boolean bool3 = localArrayList4.add(localViewStepAddress2);
    ArrayList localArrayList5 = this.mostRecentMyTrip;
    ArrayList localArrayList6 = paramDirectionResponse.getRouteInfo().getSteps();
    boolean bool4 = localArrayList5.addAll(localArrayList6);
    ArrayList localArrayList7 = this.mostRecentMyTrip;
    ArrayList localArrayList8 = paramDirectionResponse.getMaps();
    boolean bool5 = localArrayList7.addAll(localArrayList8);
  }

  public void updateRecentTrip(ArrayList<ViewStep> paramArrayList)
  {
    if (this.mostRecentMyTrip != null)
      this.mostRecentMyTrip.clear();
    ((ViewStepTotal)paramArrayList.get(0)).setRecent(true);
    ArrayList localArrayList = new ArrayList(paramArrayList);
    this.mostRecentMyTrip = localArrayList;
  }

  private class HopStopCityComparator
    implements Comparator<HopStopCity>
  {
    private HopStopCityComparator()
    {
    }

    public int compare(HopStopCity paramHopStopCity1, HopStopCity paramHopStopCity2)
    {
      String str1 = paramHopStopCity1.getName();
      String str2 = paramHopStopCity2.getName();
      return str1.compareTo(str2);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Model
 * JD-Core Version:    0.6.2
 */