package com.ls.widgets.map.config;

import android.graphics.Rect;

public class OfflineMapConfig
{
  private String a;
  private int b;
  private int c;
  private Rect d;
  private int e;
  private int f;
  private String g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private GPSConfig r;
  private MapGraphicsConfig s;

  public OfflineMapConfig(OfflineMapConfig paramOfflineMapConfig)
  {
    String str1 = paramOfflineMapConfig.a;
    this.a = str1;
    int i1 = paramOfflineMapConfig.b;
    this.b = i1;
    int i2 = paramOfflineMapConfig.c;
    this.c = i2;
    int i3 = paramOfflineMapConfig.e;
    this.e = i3;
    int i4 = paramOfflineMapConfig.f;
    this.f = i4;
    String str2 = paramOfflineMapConfig.g;
    this.g = str2;
    boolean bool1 = paramOfflineMapConfig.h;
    this.h = bool1;
    boolean bool2 = paramOfflineMapConfig.i;
    this.i = bool2;
    boolean bool3 = paramOfflineMapConfig.j;
    this.j = bool3;
    boolean bool4 = paramOfflineMapConfig.k;
    this.k = bool4;
    int i5 = paramOfflineMapConfig.l;
    this.l = i5;
    int i6 = paramOfflineMapConfig.m;
    this.m = i6;
    int i7 = paramOfflineMapConfig.n;
    this.n = i7;
    int i8 = paramOfflineMapConfig.o;
    this.o = i8;
    boolean bool5 = paramOfflineMapConfig.q;
    this.q = bool5;
    int i9 = paramOfflineMapConfig.p;
    this.p = i9;
  }

  public OfflineMapConfig(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.m = 64;
    this.l = 64;
    this.n = 0;
    this.o = 0;
    this.p = 5;
    this.q = true;
    this.h = false;
    this.k = true;
    this.i = true;
    this.a = paramString1;
    this.g = paramString2;
    this.b = paramInt1;
    this.c = paramInt2;
    Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
    this.d = localRect;
    this.e = paramInt3;
    this.f = paramInt4;
    GPSConfig localGPSConfig = new GPSConfig();
    this.r = localGPSConfig;
    MapGraphicsConfig localMapGraphicsConfig = new MapGraphicsConfig();
    this.s = localMapGraphicsConfig;
  }

  public GPSConfig getGpsConfig()
  {
    return this.r;
  }

  public MapGraphicsConfig getGraphicsConfig()
  {
    return this.s;
  }

  public String getImageFormat()
  {
    return this.g;
  }

  public int getImageHeight()
  {
    return this.c;
  }

  public Rect getImageRect()
  {
    return this.d;
  }

  public int getImageWidth()
  {
    return this.b;
  }

  public String getMapRootPath()
  {
    return this.a;
  }

  public int getMaxZoomLevelLimit()
  {
    return this.o;
  }

  public int getMinZoomLevelLimit()
  {
    return this.n;
  }

  public int getOverlap()
  {
    return this.f;
  }

  public int getTileSize()
  {
    return this.e;
  }

  public int getTouchAreaSize()
  {
    return this.p;
  }

  public int getTrackballScrollStepX()
  {
    return this.l;
  }

  public int getTrackballScrollStepY()
  {
    return this.m;
  }

  public boolean isFlingEnabled()
  {
    return this.h;
  }

  public boolean isMapCenteringEnabled()
  {
    return this.i;
  }

  public boolean isPinchZoomEnabled()
  {
    return this.j;
  }

  public boolean isSoftwareZoomEnabled()
  {
    return this.q;
  }

  public boolean isZoomBtnsVisible()
  {
    return this.k;
  }

  public void setFlingEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void setMapCenteringEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setMaxZoomLevelLimit(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException();
    this.o = paramInt;
  }

  public void setMinZoomLevelLimit(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException();
    this.n = paramInt;
  }

  public void setPinchZoomEnabled(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void setSoftwareZoomEnabled(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public void setTouchAreaSize(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException();
    this.p = paramInt;
  }

  public void setTrackballScrollStepX(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException();
    this.l = paramInt;
  }

  public void setTrackballScrollStepY(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException();
    this.m = paramInt;
  }

  public void setZoomBtnsVisible(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.config.OfflineMapConfig
 * JD-Core Version:    0.6.2
 */