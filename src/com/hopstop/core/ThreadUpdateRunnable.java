package com.hopstop.core;

import android.graphics.Bitmap;
import android.widget.ImageView;

public abstract interface ThreadUpdateRunnable extends Runnable
{
  public abstract void getImageView(ImageView paramImageView, Bitmap paramBitmap);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.core.ThreadUpdateRunnable
 * JD-Core Version:    0.6.2
 */