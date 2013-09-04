package com.hopstop.ClientModel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;

public class HopStopMap
{
  private String Id;
  private int height = 0;
  protected Drawable map;
  private ImageView map_View;
  private Bitmap map_bitmap;
  private int number;
  private String title;
  protected String url;
  private int width;

  public HopStopMap()
  {
  }

  public HopStopMap(String paramString1, String paramString2)
  {
    this.url = paramString1;
    this.title = paramString2;
  }

  private void setBitmap(Bitmap paramBitmap)
  {
    this.map_bitmap = paramBitmap;
  }

  public HopStopMap clone()
  {
    HopStopMap localHopStopMap = new HopStopMap();
    Bitmap localBitmap = this.map_bitmap;
    localHopStopMap.setBitmap(localBitmap);
    String str1 = this.title;
    localHopStopMap.setTitle(str1);
    String str2 = this.url;
    localHopStopMap.copyUrl(str2);
    int i = this.width;
    localHopStopMap.setWidth(i);
    int j = this.height;
    localHopStopMap.setHeight(j);
    return localHopStopMap;
  }

  public void convertBitmap(Drawable paramDrawable, String paramString)
  {
    if (paramDrawable != null)
    {
      Bitmap localBitmap1 = ((BitmapDrawable)paramDrawable).getBitmap();
      this.map_bitmap = localBitmap1;
      return;
    }
    if (paramString == null)
      return;
    if (paramString.length() <= 0)
      return;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 1;
    Bitmap localBitmap2 = NetworkEngine.loadImage(paramString, localOptions);
    this.map_bitmap = localBitmap2;
  }

  public void copyUrl(String paramString)
  {
    this.url = paramString;
  }

  public Bitmap getBitmap()
  {
    return this.map_bitmap;
  }

  public int getHeight()
  {
    return this.height;
  }

  public String getId()
  {
    return this.Id;
  }

  public Drawable getMap()
  {
    return this.map;
  }

  public ImageView getMapImageView()
  {
    return this.map_View;
  }

  public int getNumber()
  {
    return this.number;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getUrl()
  {
    return this.url;
  }

  public int getWidth()
  {
    return this.width;
  }

  public Bitmap loadImageFromDB(ImageView paramImageView)
  {
    HistoryManager localHistoryManager = ApplicationEngine.getHistoryManager(null);
    String str = this.url;
    return localHistoryManager.loadImageFromDB(str);
  }

  public void setBitmap(String paramString)
  {
    if (paramString == null)
      return;
    if (paramString.length() <= 0)
      return;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 1;
    Bitmap localBitmap = NetworkEngine.loadImage(paramString, localOptions);
    this.map_bitmap = localBitmap;
  }

  public void setBitmapFromDB(Bitmap paramBitmap)
  {
    this.map_bitmap = paramBitmap;
  }

  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }

  public void setId(String paramString)
  {
    this.Id = paramString;
  }

  public void setMap(Drawable paramDrawable)
  {
    this.map = paramDrawable;
  }

  public void setNumber(int paramInt)
  {
    this.number = paramInt;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
  }

  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.HopStopMap
 * JD-Core Version:    0.6.2
 */