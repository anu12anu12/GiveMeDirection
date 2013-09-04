package com.ls.widgets.map.utils;

import android.graphics.Point;
import android.location.Location;
import android.util.Log;
import com.ls.widgets.map.MapWidget;
import com.ls.widgets.map.config.GPSConfig;
import com.ls.widgets.map.config.OfflineMapConfig;

public class GeoUtils
{
  public static void translate(MapWidget paramMapWidget, int paramInt1, int paramInt2, Location paramLocation)
  {
    MapCalibrationData localMapCalibrationData = paramMapWidget.getConfig().getGpsConfig().getCalibration();
    if (localMapCalibrationData == null)
      int i = Log.w("GeoUtils", "Can't translate. No calibration data!");
    localMapCalibrationData.translate(paramInt1, paramInt2, paramLocation);
  }

  public static void translate(MapWidget paramMapWidget, Point paramPoint, Location paramLocation)
  {
    MapCalibrationData localMapCalibrationData = paramMapWidget.getConfig().getGpsConfig().getCalibration();
    if (localMapCalibrationData == null)
      int i = Log.w("GeoUtils", "Can't translate. No calibration data!");
    int j = paramPoint.x;
    int k = paramPoint.y;
    localMapCalibrationData.translate(j, k, paramLocation);
  }

  public static void translate(MapWidget paramMapWidget, Location paramLocation, Point paramPoint)
  {
    MapCalibrationData localMapCalibrationData = paramMapWidget.getConfig().getGpsConfig().getCalibration();
    if (localMapCalibrationData == null)
      int i = Log.w("GeoUtils", "Can't translate. No calibration data!");
    Point localPoint = localMapCalibrationData.translate(paramLocation, paramPoint);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.utils.GeoUtils
 * JD-Core Version:    0.6.2
 */