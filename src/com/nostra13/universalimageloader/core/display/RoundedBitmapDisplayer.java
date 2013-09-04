package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.Log;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class RoundedBitmapDisplayer
  implements BitmapDisplayer
{
  private int roundPixels;

  public RoundedBitmapDisplayer(int paramInt)
  {
    this.roundPixels = paramInt;
  }

  private Bitmap getRoundedCornerBitmap(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    Rect localRect = new Rect(0, 0, k, m);
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-1);
    float f1 = this.roundPixels;
    float f2 = this.roundPixels;
    localCanvas.drawRoundRect(localRectF, f1, f2, localPaint);
    PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
    PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(localMode);
    Xfermode localXfermode = localPaint.setXfermode(localPorterDuffXfermode);
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }

  public Bitmap display(Bitmap paramBitmap, ImageView paramImageView)
  {
    try
    {
      Bitmap localBitmap1 = getRoundedCornerBitmap(paramBitmap);
      localBitmap2 = localBitmap1;
      paramImageView.setImageBitmap(localBitmap2);
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        int i = Log.e(ImageLoader.TAG, "Can't create bitmap with rounded corners. Not enough memory.", localOutOfMemoryError);
        Bitmap localBitmap2 = paramBitmap;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer
 * JD-Core Version:    0.6.2
 */