package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;

public class ViewStepReverseNewSearch
  implements ViewStep
{
  private static final long serialVersionUID = 521066523738253698L;
  private double _x1;
  private double _x2;
  private double _y1;
  private double _y2;
  private String city1;
  private String city2;
  private String fullAddress1 = null;
  private String fullAddress2 = null;

  public ViewStepReverseNewSearch cloneItself()
  {
    ViewStepReverseNewSearch localViewStepReverseNewSearch = new ViewStepReverseNewSearch();
    String str1 = this.fullAddress1;
    localViewStepReverseNewSearch.setFullAddress1(str1);
    String str2 = this.fullAddress2;
    localViewStepReverseNewSearch.setFullAddress2(str2);
    return localViewStepReverseNewSearch;
  }

  public void downloadError(int paramInt)
  {
  }

  public Bitmap getBitmap()
  {
    return null;
  }

  public String getCity1()
  {
    return this.city1;
  }

  public String getCity2()
  {
    return this.city2;
  }

  public String getFullAddress1()
  {
    return this.fullAddress1;
  }

  public String getFullAddress2()
  {
    return this.fullAddress2;
  }

  public String getURL()
  {
    return null;
  }

  public double getX1()
  {
    return this._x1;
  }

  public double getX2()
  {
    return this._x2;
  }

  public double getY1()
  {
    return this._y1;
  }

  public double getY2()
  {
    return this._y2;
  }

  public boolean isDownloading()
  {
    return false;
  }

  public void recycle(boolean paramBoolean)
  {
  }

  public void setBitmap(Bitmap paramBitmap)
  {
  }

  public void setCity1(String paramString)
  {
    this.city1 = paramString;
  }

  public void setCity2(String paramString)
  {
    this.city2 = paramString;
  }

  public void setDownloading(boolean paramBoolean)
  {
  }

  public void setFullAddress1(String paramString)
  {
    this.fullAddress1 = paramString;
  }

  public void setFullAddress2(String paramString)
  {
    this.fullAddress2 = paramString;
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
  }

  public void setX1(double paramDouble)
  {
    this._x1 = paramDouble;
  }

  public void setX2(double paramDouble)
  {
    this._x2 = paramDouble;
  }

  public void setY1(double paramDouble)
  {
    this._y1 = paramDouble;
  }

  public void setY2(double paramDouble)
  {
    this._y2 = paramDouble;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ViewStepReverseNewSearch
 * JD-Core Version:    0.6.2
 */