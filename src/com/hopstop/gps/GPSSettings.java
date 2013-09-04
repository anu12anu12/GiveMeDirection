package com.hopstop.gps;

import java.util.ArrayList;

public class GPSSettings
{
  public int acc;
  public int cycleTime;
  public ArrayList<String> gpsProviders;
  public int minTime;
  public String mode;
  public boolean singleShot;
  public int timeout;

  public GPSSettings(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = new ArrayList();
    this.gpsProviders = localArrayList1;
    this.singleShot = false;
    this.mode = "MSA";
    this.minTime = 1000;
    this.timeout = 60000;
    this.cycleTime = 1000;
    this.acc = 550;
    ArrayList localArrayList2 = new ArrayList();
    this.gpsProviders = localArrayList2;
    this.singleShot = false;
    this.mode = "MSA";
    this.minTime = 1000;
    this.cycleTime = 1000;
    this.timeout = paramInt1;
    this.acc = paramInt2;
  }

  public void setGPSSettingsTimeout(int paramInt)
  {
    this.timeout = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.GPSSettings
 * JD-Core Version:    0.6.2
 */