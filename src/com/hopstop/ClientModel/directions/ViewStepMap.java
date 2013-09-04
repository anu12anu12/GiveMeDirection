package com.hopstop.ClientModel.directions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.crittercism.app.Crittercism;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.ClientView.DirectionsResultActivity;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.DrawableManager;
import com.hopstop.network.NetworkEngine;
import com.hopstop.util.Util;
import java.io.IOException;
import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(strict=false)
public class ViewStepMap
  implements Serializable, ViewStep
{
  private Context _context;
  private Bitmap bitmap;

  @Element(name="Height")
  private int height;

  @Element(name="Id")
  private String id;
  private ImageView img_view;

  @Element(name="Title", required=false)
  private String info;
  private boolean isDestroyed = false;
  private boolean isDownloading;
  private boolean isSaved = false;

  @Element(name="Number")
  private int number;

  @Element(name="URL", required=false)
  private String url;

  @Element(name="Width")
  private int width;

  @Commit
  public void build()
  {
    try
    {
      Bitmap localBitmap = DrawableManager.resizeDrawable(NetworkEngine.fetchDrawable(getURL()));
      this.bitmap = localBitmap;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public ViewStepMap cloneItself()
  {
    ViewStepMap localViewStepMap = new ViewStepMap();
    String str1 = this.url;
    localViewStepMap.setURL(str1, false);
    String str2 = this.info;
    localViewStepMap.setInfo(str2);
    if (this.bitmap != null);
    try
    {
      Bitmap localBitmap1 = this.bitmap;
      Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
      Bitmap localBitmap2 = localBitmap1.copy(localConfig, false);
      localViewStepMap.setBitmap(localBitmap2);
      boolean bool1 = this.isDownloading;
      localViewStepMap.isDownloading = bool1;
      String str3 = this.id;
      localViewStepMap.setId(str3);
      return localViewStepMap;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool2 = Crittercism.logHandledException(localException);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        localOutOfMemoryError.printStackTrace();
        boolean bool3 = Crittercism.logHandledException(localOutOfMemoryError);
      }
    }
  }

  public void downloadError(int paramInt)
  {
  }

  public Bitmap getBitmap()
  {
    return this.bitmap;
  }

  public String getDisplayInfo()
  {
    boolean bool = ApplicationEngine.getModel().getIsMiles();
    String str = this.info;
    return Util.getDistance(bool, str);
  }

  public int getHeight()
  {
    return this.height;
  }

  public String getId()
  {
    return this.id;
  }

  public String getInfo()
  {
    return this.info;
  }

  public int getNumber()
  {
    return this.number;
  }

  public String getTitle()
  {
    return this.info;
  }

  public String getURL()
  {
    return this.url;
  }

  public int getWidth()
  {
    return this.width;
  }

  public boolean isDestroyed()
  {
    return this.isDestroyed;
  }

  public boolean isDownloading()
  {
    return this.isDownloading;
  }

  public boolean isSaved()
  {
    return this.isSaved;
  }

  public Bitmap loadImageFromDB(ImageView paramImageView)
  {
    HistoryManager localHistoryManager = ApplicationEngine.getHistoryManager(null);
    String str = this.url;
    return localHistoryManager.loadImageFromDB(str);
  }

  public void recycle(boolean paramBoolean)
  {
    if (this.img_view != null)
      this.img_view = null;
    if (this.bitmap == null)
      return;
    this.bitmap.recycle();
    this.bitmap = null;
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if ((this.img_view != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()))
    {
      ImageView localImageView = this.img_view;
      Bitmap localBitmap = this.bitmap;
      localImageView.setImageBitmap(localBitmap);
      this.img_view = null;
    }
    if (this._context == null)
      return;
    SavingManager localSavingManager = ((DirectionsResultActivity)this._context).getSavingManager();
    String str = this.url;
    localSavingManager.mapkStepDownloaded(str);
    this._context = null;
  }

  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }

  public void setDestroyed(boolean paramBoolean)
  {
    this.isDestroyed = paramBoolean;
  }

  public void setDownloading(boolean paramBoolean)
  {
    this.isDownloading = paramBoolean;
  }

  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setIdFromURL(String paramString)
  {
    int i = paramString.indexOf("?") + 1;
    String str = paramString.substring(i);
    this.id = str;
  }

  public void setImageView(ImageView paramImageView)
  {
    this.img_view = paramImageView;
  }

  public void setInfo(String paramString)
  {
    this.info = paramString;
  }

  public void setNumber(int paramInt)
  {
    this.number = paramInt;
  }

  public void setSaved(boolean paramBoolean)
  {
    this.isSaved = paramBoolean;
  }

  public void setTitle(String paramString)
  {
    this.info = paramString;
  }

  public void setURL(String paramString)
  {
    this.url = paramString;
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
    this.url = paramString;
    if (!paramBoolean)
      return;
    LoadImageFromNetworkTask localLoadImageFromNetworkTask = new LoadImageFromNetworkTask();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this;
    arrayOfObject[1] = null;
    AsyncTask localAsyncTask = localLoadImageFromNetworkTask.execute(arrayOfObject);
  }

  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ViewStepMap
 * JD-Core Version:    0.6.2
 */