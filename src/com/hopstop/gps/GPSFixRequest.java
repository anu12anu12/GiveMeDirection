package com.hopstop.gps;

import java.util.ArrayList;
import java.util.List;

public class GPSFixRequest
{
  private String friendlyName;
  private int id;
  private boolean isRequested;
  private String mode;
  private List<String> providerNames;
  private boolean singleShot;

  public GPSFixRequest(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.providerNames = localArrayList;
    this.isRequested = false;
    this.friendlyName = paramString1;
    this.mode = paramString2;
    this.singleShot = paramBoolean;
    this.id = paramInt;
  }

  public void addProviderName(String paramString)
  {
    boolean bool = this.providerNames.add(paramString);
  }

  public String getFriendlyName()
  {
    return this.friendlyName;
  }

  public int getId()
  {
    return this.id;
  }

  public String getMode()
  {
    return this.mode;
  }

  public String getProviderName(int paramInt)
  {
    return (String)this.providerNames.get(paramInt);
  }

  public List<String> getProviderNames()
  {
    return this.providerNames;
  }

  public boolean isRequested()
  {
    return this.isRequested;
  }

  public boolean isSingleShot()
  {
    return this.singleShot;
  }

  public void setFriendlyName(String paramString)
  {
    this.friendlyName = paramString;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }

  public void setMode(String paramString)
  {
    this.mode = paramString;
  }

  public void setRequested(boolean paramBoolean)
  {
    this.isRequested = paramBoolean;
  }

  public void setSingleShot(boolean paramBoolean)
  {
    this.singleShot = paramBoolean;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.gps.GPSFixRequest
 * JD-Core Version:    0.6.2
 */