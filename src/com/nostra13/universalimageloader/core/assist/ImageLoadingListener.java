package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;

public abstract interface ImageLoadingListener
{
  public abstract void onLoadingCancelled();

  public abstract void onLoadingComplete(Bitmap paramBitmap);

  public abstract void onLoadingFailed(FailReason paramFailReason);

  public abstract void onLoadingStarted();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ImageLoadingListener
 * JD-Core Version:    0.6.2
 */