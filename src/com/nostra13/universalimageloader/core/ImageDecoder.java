package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

class ImageDecoder
{
  private static final String LOG_IMAGE_SCALED = "Subsampled image (%1$dx%2$d) was scaled to %3$dx%4$d";
  private static final String LOG_IMAGE_SUBSAMPLED = "Original image (%1$dx%2$d) is going to be subsampled to %3$dx%4$d view. Computed scale size - %5$d";
  private final ImageDownloader imageDownloader;
  private final URI imageUri;
  private boolean loggingEnabled;

  ImageDecoder(URI paramURI, ImageDownloader paramImageDownloader)
  {
    this.imageUri = paramURI;
    this.imageDownloader = paramImageDownloader;
  }

  private int computeImageScale(ImageSize paramImageSize, ImageScaleType paramImageScaleType, ViewScaleType paramViewScaleType)
    throws IOException
  {
    int i = paramImageSize.getWidth();
    int j = paramImageSize.getHeight();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    ImageDownloader localImageDownloader = this.imageDownloader;
    URI localURI = this.imageUri;
    InputStream localInputStream = localImageDownloader.getStream(localURI);
    int k;
    int m;
    int n;
    int i1;
    int i2;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, localOptions);
      localInputStream.close();
      k = 1;
      m = localOptions.outWidth;
      n = localOptions.outHeight;
      i1 = m / i;
      i2 = n / j;
      ViewScaleType localViewScaleType = ViewScaleType.FIT_INSIDE;
      if (paramViewScaleType == localViewScaleType)
      {
        ImageScaleType localImageScaleType1 = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        if (paramImageScaleType != localImageScaleType1)
        {
          ImageScaleType localImageScaleType2 = ImageScaleType.POWER_OF_2;
          if (paramImageScaleType != localImageScaleType2);
        }
        else
        {
          if ((m / 2 < i) && (n / 2 < j))
            break label185;
          m /= 2;
          n /= 2;
          k *= 2;
        }
      }
    }
    finally
    {
      localInputStream.close();
    }
    while (true)
    {
      label185: if (k < 1)
        k = 1;
      if (this.loggingEnabled)
      {
        String str1 = ImageLoader.TAG;
        Object[] arrayOfObject = new Object[5];
        Integer localInteger1 = Integer.valueOf(m);
        arrayOfObject[0] = localInteger1;
        Integer localInteger2 = Integer.valueOf(n);
        arrayOfObject[1] = localInteger2;
        Integer localInteger3 = Integer.valueOf(i);
        arrayOfObject[2] = localInteger3;
        Integer localInteger4 = Integer.valueOf(j);
        arrayOfObject[3] = localInteger4;
        Integer localInteger5 = Integer.valueOf(k);
        arrayOfObject[4] = localInteger5;
        String str2 = String.format("Original image (%1$dx%2$d) is going to be subsampled to %3$dx%4$d view. Computed scale size - %5$d", arrayOfObject);
        int i3 = Log.d(str1, str2);
      }
      return k;
      ImageScaleType localImageScaleType3 = ImageScaleType.IN_SAMPLE_POWER_OF_2;
      if (paramImageScaleType != localImageScaleType3)
      {
        ImageScaleType localImageScaleType4 = ImageScaleType.POWER_OF_2;
        if (paramImageScaleType != localImageScaleType4);
      }
      else
      {
        while ((m / 2 >= i) && (n / 2 >= j))
        {
          m /= 2;
          n /= 2;
          k *= 2;
        }
        continue;
      }
      k = Math.min(i1, i2);
    }
  }

  private BitmapFactory.Options getBitmapOptionsForImageDecoding(ImageSize paramImageSize, ImageScaleType paramImageScaleType, ViewScaleType paramViewScaleType)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int i = computeImageScale(paramImageSize, paramImageScaleType, paramViewScaleType);
    localOptions.inSampleSize = i;
    return localOptions;
  }

  private Bitmap scaleImageExactly(Bitmap paramBitmap, ImageSize paramImageSize, ImageScaleType paramImageScaleType, ViewScaleType paramViewScaleType)
  {
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    float f3 = paramImageSize.getWidth();
    float f4 = f1 / f3;
    float f5 = paramImageSize.getHeight();
    float f6 = f2 / f5;
    ViewScaleType localViewScaleType1 = ViewScaleType.FIT_INSIDE;
    int i;
    int j;
    Bitmap localBitmap;
    if ((paramViewScaleType != localViewScaleType1) || (f4 < f6))
    {
      ViewScaleType localViewScaleType2 = ViewScaleType.CROP;
      if ((paramViewScaleType != localViewScaleType2) || (f4 >= f6));
    }
    else
    {
      i = paramImageSize.getWidth();
      j = (int)(f2 / f4);
      ImageScaleType localImageScaleType1 = ImageScaleType.EXACTLY;
      if ((paramImageScaleType != localImageScaleType1) || (i >= f1) || (j >= f2))
      {
        ImageScaleType localImageScaleType2 = ImageScaleType.EXACTLY_STRETCHED;
        if ((paramImageScaleType != localImageScaleType2) || (i == f1) || (j == f2))
          break label279;
      }
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      paramBitmap.recycle();
      if (this.loggingEnabled)
      {
        String str1 = ImageLoader.TAG;
        Object[] arrayOfObject = new Object[4];
        Integer localInteger1 = Integer.valueOf((int)f1);
        arrayOfObject[0] = localInteger1;
        Integer localInteger2 = Integer.valueOf((int)f2);
        arrayOfObject[1] = localInteger2;
        Integer localInteger3 = Integer.valueOf(i);
        arrayOfObject[2] = localInteger3;
        Integer localInteger4 = Integer.valueOf(j);
        arrayOfObject[3] = localInteger4;
        String str2 = String.format("Subsampled image (%1$dx%2$d) was scaled to %3$dx%4$d", arrayOfObject);
        int k = Log.d(str1, str2);
      }
    }
    while (true)
    {
      return localBitmap;
      i = (int)(f1 / f6);
      j = paramImageSize.getHeight();
      break;
      label279: localBitmap = paramBitmap;
    }
  }

  public Bitmap decode(ImageSize paramImageSize, ImageScaleType paramImageScaleType)
    throws IOException
  {
    ViewScaleType localViewScaleType = ViewScaleType.FIT_INSIDE;
    return decode(paramImageSize, paramImageScaleType, localViewScaleType);
  }

  public Bitmap decode(ImageSize paramImageSize, ImageScaleType paramImageScaleType, ViewScaleType paramViewScaleType)
    throws IOException
  {
    Object localObject1 = null;
    BitmapFactory.Options localOptions = getBitmapOptionsForImageDecoding(paramImageSize, paramImageScaleType, paramViewScaleType);
    ImageDownloader localImageDownloader = this.imageDownloader;
    URI localURI = this.imageUri;
    InputStream localInputStream = localImageDownloader.getStream(localURI);
    while (true)
    {
      Bitmap localBitmap2;
      try
      {
        Bitmap localBitmap1 = BitmapFactory.decodeStream(localInputStream, null, localOptions);
        localBitmap2 = localBitmap1;
        localInputStream.close();
        if (localBitmap2 == null)
          return localObject1;
      }
      finally
      {
        localInputStream.close();
      }
      ImageScaleType localImageScaleType1 = ImageScaleType.EXACTLY;
      if (paramImageScaleType != localImageScaleType1)
      {
        ImageScaleType localImageScaleType2 = ImageScaleType.EXACTLY_STRETCHED;
        if (paramImageScaleType != localImageScaleType2);
      }
      else
      {
        localBitmap2 = scaleImageExactly(localBitmap2, paramImageSize, paramImageScaleType, paramViewScaleType);
      }
      localObject1 = localBitmap2;
    }
  }

  void setLoggingEnabled(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageDecoder
 * JD-Core Version:    0.6.2
 */