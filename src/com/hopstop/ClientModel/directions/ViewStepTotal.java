package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import com.google.android.maps.GeoPoint;
import com.hopstop.util.Util;
import java.util.ArrayList;
import java.util.Hashtable;

public class ViewStepTotal
  implements ViewStep
{
  private static final long serialVersionUID = 3727948905898655350L;
  private String _fare;
  private ArrayList<GeoPoints> _geoPointList;
  private Hashtable<String, RouteIcons> _routeIcons;
  private int _walkingTime;
  private String arrival;
  private String calories;
  private String co2;
  private String departure;
  private String distance;
  private String duration;
  private boolean isMostRecentSaved = false;
  private boolean isRecent;
  private int isTaxi = 0;
  private String myTripName;
  private String routeId;
  private int totalDayInSeconds = 86399;
  private String totalTimeVerb;
  private View view = null;
  private int wheelChairOut;

  public ViewStepTotal()
  {
    Hashtable localHashtable = new Hashtable();
    this._routeIcons = localHashtable;
    ArrayList localArrayList = new ArrayList();
    this._geoPointList = localArrayList;
  }

  public ViewStep cloneItself()
  {
    ViewStepTotal localViewStepTotal = new ViewStepTotal();
    String str1 = this.totalTimeVerb;
    localViewStepTotal.setTotalTimeVerb(str1);
    View localView = this.view;
    localViewStepTotal.setView(localView);
    String str2 = this.myTripName;
    localViewStepTotal.setMyTripName(str2);
    String str3 = this.routeId;
    localViewStepTotal.setRouteId(str3);
    boolean bool = this.isRecent;
    localViewStepTotal.isRecent = bool;
    String str4 = this.calories;
    localViewStepTotal.setCalories(str4);
    String str5 = this.co2;
    localViewStepTotal.setCo2(str5);
    String str6 = this.departure;
    localViewStepTotal.departure = str6;
    String str7 = this.arrival;
    localViewStepTotal.arrival = str7;
    String str8 = this.distance;
    localViewStepTotal.setDistance(str8);
    String str9 = this.duration;
    localViewStepTotal.setDuration(str9);
    int i = this.wheelChairOut;
    localViewStepTotal.setWheelChairOut(i);
    int j = this._walkingTime;
    localViewStepTotal.setWalkingTime(j);
    String str10 = this._fare;
    localViewStepTotal.setFare(str10);
    int k = this.isTaxi;
    localViewStepTotal.isTaxi = k;
    Hashtable localHashtable = (Hashtable)this._routeIcons.clone();
    localViewStepTotal.setRouteIconsHashtable(localHashtable);
    ArrayList localArrayList = (ArrayList)this._geoPointList.clone();
    localViewStepTotal.setGeoPointsArrayList(localArrayList);
    return localViewStepTotal;
  }

  public void downloadError(int paramInt)
  {
  }

  public String getArrival()
  {
    if (this.arrival == null);
    for (String str = "N/A"; ; str = this.arrival)
      return str;
  }

  public Bitmap getBitmap()
  {
    return null;
  }

  public String getCalories()
  {
    if (this.calories == null);
    for (String str = "N/A"; ; str = this.calories)
      return str;
  }

  public String getCo2()
  {
    if (this.co2 == null);
    for (String str = "N/A"; ; str = this.co2)
      return str;
  }

  public String getDeparture()
  {
    if (this.departure == null);
    for (String str = "N/A"; ; str = this.departure)
      return str;
  }

  public String getDistance()
  {
    return this.distance;
  }

  public String getDistance(boolean paramBoolean)
  {
    try
    {
      float f1 = Float.parseFloat(this.distance);
      float f2 = f1;
      str1 = Util.getDistance(paramBoolean, f2);
      return str1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        localNumberFormatException.printStackTrace();
        String str2 = String.valueOf(this.distance);
        String str1 = str2 + " mi";
      }
    }
  }

  public String getDuration()
  {
    return this.duration;
  }

  public String getFare()
  {
    if (this._fare == null);
    for (String str = "$0.00"; ; str = this._fare)
      return str;
  }

  public String getMyTripName()
  {
    return this.myTripName;
  }

  /** @deprecated */
  public Hashtable<String, RouteIcons> getRouteIcons()
  {
    try
    {
      Hashtable localHashtable = this._routeIcons;
      return localHashtable;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getRouteId()
  {
    return this.routeId;
  }

  /** @deprecated */
  public ArrayList<GeoPoints> getRouteLines()
  {
    try
    {
      ArrayList localArrayList = this._geoPointList;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getTotalTimeVerb()
  {
    return this.totalTimeVerb;
  }

  public String getURL()
  {
    return null;
  }

  public View getView()
  {
    return this.view;
  }

  public int getWalkingTime()
  {
    return this._walkingTime;
  }

  public int getWheelChairOut()
  {
    return this.wheelChairOut;
  }

  public boolean isDownloading()
  {
    return false;
  }

  public boolean isMostRecentSaved()
  {
    return this.isMostRecentSaved;
  }

  public boolean isRecent()
  {
    return this.isRecent;
  }

  public int isTaxi()
  {
    return this.isTaxi;
  }

  public void recycle(boolean paramBoolean)
  {
  }

  public void setArrival(String paramString)
  {
    this.arrival = paramString;
  }

  public void setArrivalFromDB(String paramString)
  {
    this.arrival = paramString;
  }

  public void setBitmap(Bitmap paramBitmap)
  {
  }

  public void setCalories(String paramString)
  {
    this.calories = paramString;
  }

  public void setCo2(String paramString)
  {
    this.co2 = paramString;
  }

  public void setDeparture(String paramString)
  {
    this.departure = paramString;
  }

  public void setDepartureFromDB(String paramString)
  {
    this.departure = paramString;
  }

  public void setDistance(String paramString)
  {
    this.distance = paramString;
  }

  public void setDownloading(boolean paramBoolean)
  {
  }

  public void setDuration(String paramString)
  {
    this.duration = paramString;
  }

  public void setFare(String paramString)
  {
    this._fare = paramString;
  }

  public void setGeoPointsArrayList(ArrayList<GeoPoints> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList);
    this._geoPointList = localArrayList;
  }

  public void setMostRecentSaved(boolean paramBoolean)
  {
    this.isMostRecentSaved = paramBoolean;
  }

  public void setMyTripName(String paramString)
  {
    String str = paramString;
    this.myTripName = str;
  }

  public void setRecent(boolean paramBoolean)
  {
    this.isRecent = paramBoolean;
  }

  public void setRouteIcons(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = paramString.split("\n");
    int i = 0;
    while (true)
    {
      int j = arrayOfString1.length;
      if (i >= j)
        return;
      try
      {
        arrayOfString2 = arrayOfString1[i].split("\t");
        localRouteIcons = new RouteIcons();
        int k = Integer.parseInt(arrayOfString2[0]);
        localRouteIcons.setLon(k);
        int m = Integer.parseInt(arrayOfString2[1]);
        localRouteIcons.setLat(m);
        String str1 = arrayOfString2[2];
        localRouteIcons.setUrl(str1);
        if (arrayOfString2.length > 4)
        {
          String str2 = arrayOfString2[4];
          localRouteIcons.setName(str2);
        }
        if (arrayOfString2[2] != null)
        {
          if ((!arrayOfString2[2].equals("start")) && (!arrayOfString2[2].equals("end")))
            break label245;
          Hashtable localHashtable1 = this._routeIcons;
          String str3 = arrayOfString2[2];
          Object localObject1 = localHashtable1.put(str3, localRouteIcons);
          String str4 = arrayOfString2[2];
          localRouteIcons.setName(str4);
        }
        while (true)
        {
          if ((arrayOfString2.length > 3) && (arrayOfString2[3] != null) && (arrayOfString2[3].length() > 0))
          {
            String str5 = arrayOfString2[3];
            if (localArrayList.contains(str5))
              localRouteIcons.setOccurred(1);
            boolean bool1 = localArrayList.add(str5);
          }
          i += 1;
          break;
          label245: if ((!arrayOfString2[2].equals("walk")) && (!arrayOfString2[2].equals("ride")))
            break label361;
          Hashtable localHashtable2 = this._routeIcons;
          String str6 = String.valueOf(arrayOfString2[2]);
          StringBuilder localStringBuilder1 = new StringBuilder(str6).append("_");
          String str7 = arrayOfString2[1];
          StringBuilder localStringBuilder2 = localStringBuilder1.append(str7).append("_");
          String str8 = arrayOfString2[0];
          String str9 = str8;
          Object localObject2 = localHashtable2.put(str9, localRouteIcons);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          String[] arrayOfString2;
          RouteIcons localRouteIcons;
          continue;
          label361: String str10 = arrayOfString2[2];
          if (localArrayList.contains(str10))
            localRouteIcons.setOccurred(1);
          boolean bool2 = localArrayList.add(str10);
          Hashtable localHashtable3 = this._routeIcons;
          String str11 = String.valueOf(arrayOfString2[2]);
          StringBuilder localStringBuilder3 = new StringBuilder(str11).append("_");
          String str12 = arrayOfString2[1];
          StringBuilder localStringBuilder4 = localStringBuilder3.append(str12).append("_");
          String str13 = arrayOfString2[0];
          String str14 = str13;
          Object localObject3 = localHashtable3.put(str14, localRouteIcons);
        }
      }
    }
  }

  public void setRouteIconsHashtable(Hashtable<String, RouteIcons> paramHashtable)
  {
    Hashtable localHashtable = new Hashtable(paramHashtable);
    this._routeIcons = localHashtable;
  }

  public void setRouteId(String paramString)
  {
    this.routeId = paramString;
  }

  public void setRouteLines(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\n");
    int i = 0;
    while (true)
    {
      int j = arrayOfString1.length;
      if (i >= j)
        return;
      String[] arrayOfString2 = arrayOfString1[i].split("\t");
      GeoPoints localGeoPoints = new GeoPoints();
      int k = Integer.parseInt(arrayOfString2[1]);
      int m = Integer.parseInt(arrayOfString2[0]);
      GeoPoint localGeoPoint1 = new GeoPoint(k, m);
      localGeoPoints.setStart(localGeoPoint1);
      int n = Integer.parseInt(arrayOfString2[3]);
      int i1 = Integer.parseInt(arrayOfString2[2]);
      GeoPoint localGeoPoint2 = new GeoPoint(n, i1);
      localGeoPoints.setEnd(localGeoPoint2);
      if (arrayOfString2[4].length() > 2)
      {
        StringBuilder localStringBuilder = new StringBuilder("#");
        String str = arrayOfString2[4];
        int i2 = Color.parseColor(str);
        localGeoPoints.setRouteColor(i2);
      }
      boolean bool = this._geoPointList.add(localGeoPoints);
      i += 1;
    }
  }

  public void setTaxi(int paramInt)
  {
    this.isTaxi = paramInt;
  }

  public void setTotalTimeVerb(String paramString)
  {
    this.totalTimeVerb = paramString;
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
  }

  public void setView(View paramView)
  {
    this.view = paramView;
  }

  public void setWalkingTime(int paramInt)
  {
    this._walkingTime = paramInt;
  }

  public void setWheelChairOut(int paramInt)
  {
    this.wheelChairOut = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ViewStepTotal
 * JD-Core Version:    0.6.2
 */