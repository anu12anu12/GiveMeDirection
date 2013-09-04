package com.ls.widgets.map.config;

import com.ls.widgets.map.utils.MapCalibrationData;

public class GPSConfig
{
  private boolean a = false;
  private int b = 1000;
  private int c = 10;
  private MapCalibrationData d;

  public MapCalibrationData getCalibration()
  {
    return this.d;
  }

  public int getMinDistance()
  {
    return this.c;
  }

  public int getMinTime()
  {
    return this.b;
  }

  public boolean getPassiveMode()
  {
    return this.a;
  }

  public boolean isMapCalibrated()
  {
    if (this.d != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setGPSUpdateInterval(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public void setGeoArea(MapCalibrationData paramMapCalibrationData)
  {
    this.d = paramMapCalibrationData;
  }

  public void setPassiveMode(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.config.GPSConfig
 * JD-Core Version:    0.6.2
 */