package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;

final class DisplayBitmapTask
  implements Runnable
{
  private final Bitmap bitmap;
  private final BitmapDisplayer bitmapDisplayer;
  private final ImageView imageView;
  private final ImageLoadingListener listener;

  public DisplayBitmapTask(Bitmap paramBitmap, ImageView paramImageView, BitmapDisplayer paramBitmapDisplayer, ImageLoadingListener paramImageLoadingListener)
  {
    this.bitmap = paramBitmap;
    this.imageView = paramImageView;
    this.bitmapDisplayer = paramBitmapDisplayer;
    this.listener = paramImageLoadingListener;
  }

  public void run()
  {
    BitmapDisplayer localBitmapDisplayer = this.bitmapDisplayer;
    Bitmap localBitmap1 = this.bitmap;
    ImageView localImageView = this.imageView;
    Bitmap localBitmap2 = localBitmapDisplayer.display(localBitmap1, localImageView);
    this.listener.onLoadingComplete(localBitmap2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DisplayBitmapTask
 * JD-Core Version:    0.6.2
 */