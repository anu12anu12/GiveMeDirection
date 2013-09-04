package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;
import java.io.Serializable;

public abstract interface ViewStep extends Serializable
{
  public abstract ViewStep cloneItself();

  public abstract void downloadError(int paramInt);

  public abstract Bitmap getBitmap();

  public abstract String getURL();

  public abstract boolean isDownloading();

  public abstract void recycle(boolean paramBoolean);

  public abstract void setBitmap(Bitmap paramBitmap);

  public abstract void setDownloading(boolean paramBoolean);

  public abstract void setURL(String paramString, boolean paramBoolean);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ViewStep
 * JD-Core Version:    0.6.2
 */