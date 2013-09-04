package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.FileUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.locks.ReentrantLock;

final class LoadAndDisplayImageTask
  implements Runnable
{
  private static final int ATTEMPT_COUNT_TO_DECODE_BITMAP = 3;
  private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
  private static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
  private static final String LOG_DISPLAY_IMAGE_IN_IMAGEVIEW = "Display image in ImageView [%s]";
  private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_INTERNET = "Load image from Internet [%s]";
  private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
  private static final String LOG_WAITING = "Image already is loading. Waiting... [%s]";
  private final ImageLoaderConfiguration configuration;
  private final Handler handler;
  private final ImageLoadingInfo imageLoadingInfo;

  public LoadAndDisplayImageTask(ImageLoaderConfiguration paramImageLoaderConfiguration, ImageLoadingInfo paramImageLoadingInfo, Handler paramHandler)
  {
    this.configuration = paramImageLoaderConfiguration;
    this.imageLoadingInfo = paramImageLoadingInfo;
    this.handler = paramHandler;
  }

  private Bitmap decodeImage(URI paramURI)
    throws IOException
  {
    if (this.configuration.handleOutOfMemory);
    ImageDecoder localImageDecoder;
    ViewScaleType localViewScaleType;
    ImageSize localImageSize;
    ImageScaleType localImageScaleType;
    for (Bitmap localBitmap = decodeWithOOMHandling(paramURI); ; localBitmap = localImageDecoder.decode(localImageSize, localImageScaleType, localViewScaleType))
    {
      return localBitmap;
      ImageDownloader localImageDownloader = this.configuration.downloader;
      localImageDecoder = new ImageDecoder(paramURI, localImageDownloader);
      boolean bool = this.configuration.loggingEnabled;
      localImageDecoder.setLoggingEnabled(bool);
      localViewScaleType = ViewScaleType.fromImageView(this.imageLoadingInfo.imageView);
      localImageSize = this.imageLoadingInfo.targetSize;
      localImageScaleType = this.imageLoadingInfo.options.getImageScaleType();
    }
  }

  private Bitmap decodeWithOOMHandling(URI paramURI)
    throws IOException
  {
    Object localObject = null;
    ImageDownloader localImageDownloader = this.configuration.downloader;
    ImageDecoder localImageDecoder = new ImageDecoder(paramURI, localImageDownloader);
    boolean bool = this.configuration.loggingEnabled;
    localImageDecoder.setLoggingEnabled(bool);
    int i = 1;
    if (i <= 3);
    while (true)
    {
      try
      {
        ViewScaleType localViewScaleType = ViewScaleType.fromImageView(this.imageLoadingInfo.imageView);
        ImageSize localImageSize = this.imageLoadingInfo.targetSize;
        ImageScaleType localImageScaleType = this.imageLoadingInfo.options.getImageScaleType();
        Bitmap localBitmap = localImageDecoder.decode(localImageSize, localImageScaleType, localViewScaleType);
        localObject = localBitmap;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        String str1 = ImageLoader.TAG;
        String str2 = localOutOfMemoryError.getMessage();
        int j = Log.e(str1, str2, localOutOfMemoryError);
        switch (i)
        {
        default:
          SystemClock.sleep(i * 1000);
          i += 1;
        case 1:
        case 2:
        case 3:
        }
      }
      break;
      System.gc();
      continue;
      this.configuration.memoryCache.clear();
      System.gc();
    }
    throw localOutOfMemoryError;
  }

  private void fireImageLoadingFailedEvent(final FailReason paramFailReason)
  {
    if (Thread.interrupted())
      return;
    Handler localHandler = this.handler;
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        ImageLoadingListener localImageLoadingListener = LoadAndDisplayImageTask.this.imageLoadingInfo.listener;
        FailReason localFailReason = paramFailReason;
        localImageLoadingListener.onLoadingFailed(localFailReason);
      }
    };
    boolean bool = localHandler.post(local2);
  }

  private void saveImageOnDisc(File paramFile)
    throws IOException, URISyntaxException
  {
    int i = this.configuration.maxImageWidthForDiscCache;
    int j = this.configuration.maxImageHeightForDiscCache;
    if ((i > 0) || (j > 0))
    {
      ImageSize localImageSize = new ImageSize(i, j);
      String str1 = this.imageLoadingInfo.uri;
      URI localURI1 = new URI(str1);
      ImageDownloader localImageDownloader1 = this.configuration.downloader;
      ImageDecoder localImageDecoder = new ImageDecoder(localURI1, localImageDownloader1);
      boolean bool = this.configuration.loggingEnabled;
      localImageDecoder.setLoggingEnabled(bool);
      ImageScaleType localImageScaleType = ImageScaleType.IN_SAMPLE_INT;
      ViewScaleType localViewScaleType = ViewScaleType.FIT_INSIDE;
      Bitmap localBitmap = localImageDecoder.decode(localImageSize, localImageScaleType, localViewScaleType);
      FileOutputStream localFileOutputStream1 = new FileOutputStream(paramFile);
      BufferedOutputStream localBufferedOutputStream1 = new BufferedOutputStream(localFileOutputStream1);
      Bitmap.CompressFormat localCompressFormat = this.configuration.imageCompressFormatForDiscCache;
      int k = this.configuration.imageQualityForDiscCache;
      if (localBitmap.compress(localCompressFormat, k, localBufferedOutputStream1))
      {
        localBitmap.recycle();
        return;
      }
    }
    ImageDownloader localImageDownloader2 = this.configuration.downloader;
    String str2 = this.imageLoadingInfo.uri;
    URI localURI2 = new URI(str2);
    InputStream localInputStream = localImageDownloader2.getStream(localURI2);
    try
    {
      FileOutputStream localFileOutputStream2 = new FileOutputStream(paramFile);
      BufferedOutputStream localBufferedOutputStream2 = new BufferedOutputStream(localFileOutputStream2);
      try
      {
        FileUtils.copyStream(localInputStream, localBufferedOutputStream2);
        return;
      }
      finally
      {
      }
    }
    finally
    {
      localInputStream.close();
    }
  }

  private Bitmap tryLoadBitmap()
  {
    DiscCacheAware localDiscCacheAware1 = this.configuration.discCache;
    String str1 = this.imageLoadingInfo.uri;
    File localFile = localDiscCacheAware1.get(str1);
    Bitmap localBitmap1 = null;
    try
    {
      Bitmap localBitmap2;
      if (localFile.exists())
      {
        if (this.configuration.loggingEnabled)
        {
          String str2 = ImageLoader.TAG;
          Object[] arrayOfObject1 = new Object[1];
          String str3 = this.imageLoadingInfo.memoryCacheKey;
          arrayOfObject1[0] = str3;
          String str4 = String.format("Load image from disc cache [%s]", arrayOfObject1);
          int i = Log.i(str2, str4);
        }
        URI localURI1 = localFile.toURI();
        localBitmap2 = decodeImage(localURI1);
        if (localBitmap2 != null)
          return localBitmap2;
      }
      if (this.configuration.loggingEnabled)
      {
        String str5 = ImageLoader.TAG;
        Object[] arrayOfObject2 = new Object[1];
        String str6 = this.imageLoadingInfo.memoryCacheKey;
        arrayOfObject2[0] = str6;
        String str7 = String.format("Load image from Internet [%s]", arrayOfObject2);
        int j = Log.i(str5, str7);
      }
      if (this.imageLoadingInfo.options.isCacheOnDisc())
      {
        if (this.configuration.loggingEnabled)
        {
          String str8 = ImageLoader.TAG;
          Object[] arrayOfObject3 = new Object[1];
          String str9 = this.imageLoadingInfo.memoryCacheKey;
          arrayOfObject3[0] = str9;
          String str10 = String.format("Cache image on disc [%s]", arrayOfObject3);
          int k = Log.i(str8, str10);
        }
        saveImageOnDisc(localFile);
        DiscCacheAware localDiscCacheAware2 = this.configuration.discCache;
        String str11 = this.imageLoadingInfo.uri;
        localDiscCacheAware2.put(str11, localFile);
      }
      String str12;
      for (URI localURI2 = localFile.toURI(); ; localURI2 = new URI(str12))
      {
        localBitmap1 = decodeImage(localURI2);
        if (localBitmap1 == null)
        {
          FailReason localFailReason1 = FailReason.IO_ERROR;
          fireImageLoadingFailedEvent(localFailReason1);
        }
        localBitmap2 = localBitmap1;
        break;
        str12 = this.imageLoadingInfo.uri;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        String str13 = ImageLoader.TAG;
        String str14 = localIOException.getMessage();
        int m = Log.e(str13, str14, localIOException);
        FailReason localFailReason2 = FailReason.IO_ERROR;
        fireImageLoadingFailedEvent(localFailReason2);
        if (localFile.exists())
          boolean bool = localFile.delete();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        String str15 = ImageLoader.TAG;
        String str16 = localOutOfMemoryError.getMessage();
        int n = Log.e(str15, str16, localOutOfMemoryError);
        FailReason localFailReason3 = FailReason.OUT_OF_MEMORY;
        fireImageLoadingFailedEvent(localFailReason3);
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        String str17 = ImageLoader.TAG;
        String str18 = localThrowable.getMessage();
        int i1 = Log.e(str17, str18, localThrowable);
        FailReason localFailReason4 = FailReason.UNKNOWN;
        fireImageLoadingFailedEvent(localFailReason4);
      }
    }
  }

  boolean checkTaskIsNotActual()
  {
    ImageLoader localImageLoader = ImageLoader.getInstance();
    ImageView localImageView = this.imageLoadingInfo.imageView;
    String str = localImageLoader.getLoadingUriForView(localImageView);
    if (!this.imageLoadingInfo.memoryCacheKey.equals(str));
    for (boolean bool1 = true; ; bool1 = false)
    {
      if (bool1)
      {
        Handler localHandler = this.handler;
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            LoadAndDisplayImageTask.this.imageLoadingInfo.listener.onLoadingCancelled();
          }
        };
        boolean bool2 = localHandler.post(local1);
      }
      return bool1;
    }
  }

  public void run()
  {
    if (this.configuration.loggingEnabled)
    {
      String str1 = ImageLoader.TAG;
      Object[] arrayOfObject1 = new Object[1];
      String str2 = this.imageLoadingInfo.memoryCacheKey;
      arrayOfObject1[0] = str2;
      String str3 = String.format("Start display image task [%s]", arrayOfObject1);
      int i = Log.i(str1, str3);
      if (this.imageLoadingInfo.loadFromUriLock.isLocked())
      {
        String str4 = ImageLoader.TAG;
        Object[] arrayOfObject2 = new Object[1];
        String str5 = this.imageLoadingInfo.memoryCacheKey;
        arrayOfObject2[0] = str5;
        String str6 = String.format("Image already is loading. Waiting... [%s]", arrayOfObject2);
        int j = Log.i(str4, str6);
      }
    }
    this.imageLoadingInfo.loadFromUriLock.lock();
    try
    {
      boolean bool1 = checkTaskIsNotActual();
      if (bool1)
        return;
      MemoryCacheAware localMemoryCacheAware1 = ImageLoader.getInstance().getMemoryCache();
      String str7 = this.imageLoadingInfo.memoryCacheKey;
      Bitmap localBitmap2 = (Bitmap)localMemoryCacheAware1.get(str7);
      if (localBitmap2 == null)
      {
        Bitmap localBitmap1 = tryLoadBitmap();
        localBitmap2 = localBitmap1;
        if (localBitmap2 == null)
          return;
        boolean bool2 = checkTaskIsNotActual();
        if (bool2)
          return;
        if (this.imageLoadingInfo.options.isCacheInMemory())
        {
          if (this.configuration.loggingEnabled)
          {
            String str8 = ImageLoader.TAG;
            Object[] arrayOfObject3 = new Object[1];
            String str9 = this.imageLoadingInfo.memoryCacheKey;
            arrayOfObject3[0] = str9;
            String str10 = String.format("Cache image in memory [%s]", arrayOfObject3);
            int k = Log.i(str8, str10);
          }
          MemoryCacheAware localMemoryCacheAware2 = this.configuration.memoryCache;
          String str11 = this.imageLoadingInfo.memoryCacheKey;
          boolean bool3 = localMemoryCacheAware2.put(str11, localBitmap2);
        }
      }
      while (true)
      {
        this.imageLoadingInfo.loadFromUriLock.unlock();
        if (Thread.interrupted())
          return;
        if (checkTaskIsNotActual())
          return;
        if (this.configuration.loggingEnabled)
        {
          String str12 = ImageLoader.TAG;
          Object[] arrayOfObject4 = new Object[1];
          String str13 = this.imageLoadingInfo.memoryCacheKey;
          arrayOfObject4[0] = str13;
          String str14 = String.format("Display image in ImageView [%s]", arrayOfObject4);
          int m = Log.i(str12, str14);
        }
        ImageView localImageView = this.imageLoadingInfo.imageView;
        BitmapDisplayer localBitmapDisplayer = this.imageLoadingInfo.options.getDisplayer();
        ImageLoadingListener localImageLoadingListener = this.imageLoadingInfo.listener;
        DisplayBitmapTask localDisplayBitmapTask = new DisplayBitmapTask(localBitmap2, localImageView, localBitmapDisplayer, localImageLoadingListener);
        boolean bool4 = this.handler.post(localDisplayBitmapTask);
        return;
        if (this.configuration.loggingEnabled)
        {
          String str15 = ImageLoader.TAG;
          Object[] arrayOfObject5 = new Object[1];
          String str16 = this.imageLoadingInfo.memoryCacheKey;
          arrayOfObject5[0] = str16;
          String str17 = String.format("...Get cached bitmap from memory after waiting. [%s]", arrayOfObject5);
          int n = Log.i(str15, str17);
        }
      }
    }
    finally
    {
      this.imageLoadingInfo.loadFromUriLock.unlock();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask
 * JD-Core Version:    0.6.2
 */