package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.util.concurrent.ThreadFactory;

public final class ImageLoaderConfiguration
{
  final DisplayImageOptions defaultDisplayImageOptions;
  final DiscCacheAware discCache;
  final ThreadFactory displayImageThreadFactory;
  final ImageDownloader downloader;
  final boolean handleOutOfMemory;
  final Bitmap.CompressFormat imageCompressFormatForDiscCache;
  final int imageQualityForDiscCache;
  final boolean loggingEnabled;
  final int maxImageHeightForDiscCache;
  final int maxImageHeightForMemoryCache;
  final int maxImageWidthForDiscCache;
  final int maxImageWidthForMemoryCache;
  final MemoryCacheAware<String, Bitmap> memoryCache;
  final int threadPoolSize;

  private ImageLoaderConfiguration(final Builder paramBuilder)
  {
    int i = paramBuilder.maxImageWidthForMemoryCache;
    this.maxImageWidthForMemoryCache = i;
    int j = paramBuilder.maxImageHeightForMemoryCache;
    this.maxImageHeightForMemoryCache = j;
    int k = paramBuilder.maxImageWidthForDiscCache;
    this.maxImageWidthForDiscCache = k;
    int m = paramBuilder.maxImageHeightForDiscCache;
    this.maxImageHeightForDiscCache = m;
    Bitmap.CompressFormat localCompressFormat = paramBuilder.imageCompressFormatForDiscCache;
    this.imageCompressFormatForDiscCache = localCompressFormat;
    int n = paramBuilder.imageQualityForDiscCache;
    this.imageQualityForDiscCache = n;
    int i1 = paramBuilder.threadPoolSize;
    this.threadPoolSize = i1;
    boolean bool1 = paramBuilder.handleOutOfMemory;
    this.handleOutOfMemory = bool1;
    DiscCacheAware localDiscCacheAware = paramBuilder.discCache;
    this.discCache = localDiscCacheAware;
    MemoryCacheAware localMemoryCacheAware = paramBuilder.memoryCache;
    this.memoryCache = localMemoryCacheAware;
    DisplayImageOptions localDisplayImageOptions = paramBuilder.defaultDisplayImageOptions;
    this.defaultDisplayImageOptions = localDisplayImageOptions;
    boolean bool2 = paramBuilder.loggingEnabled;
    this.loggingEnabled = bool2;
    ImageDownloader localImageDownloader = paramBuilder.downloader;
    this.downloader = localImageDownloader;
    ThreadFactory local1 = new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        Thread localThread = new Thread(paramAnonymousRunnable);
        int i = ImageLoaderConfiguration.Builder.access$1300(paramBuilder);
        localThread.setPriority(i);
        return localThread;
      }
    };
    this.displayImageThreadFactory = local1;
  }

  public static ImageLoaderConfiguration createDefault(Context paramContext)
  {
    return new Builder(paramContext).build();
  }

  public static class Builder
  {
    public static final int DEFAULT_MEMORY_CACHE_SIZE = 2097152;
    public static final int DEFAULT_THREAD_POOL_SIZE = 3;
    public static final int DEFAULT_THREAD_PRIORITY = 4;
    private static final String WARNING_DISC_CACHE_ALREADY_SET = "You already have set disc cache. This method call will make no effect.";
    private static final String WARNING_MEMORY_CACHE_ALREADY_SET = "You already have set memory cache. This method call will make no effect.";
    private static final String WARNING_OVERLAP_DISC_CACHE_FILE_COUNT = "This method's call overlaps discCacheFileCount() method call";
    private static final String WARNING_OVERLAP_DISC_CACHE_FILE_NAME_GENERATOR = "This method's call overlaps discCacheFileNameGenerator() method call";
    private static final String WARNING_OVERLAP_DISC_CACHE_SIZE = "This method's call overlaps discCacheSize() method call";
    private static final String WARNING_OVERLAP_MEMORY_CACHE_SIZE = "This method's call overlaps memoryCacheSize() method call";
    private Context context;
    private DisplayImageOptions defaultDisplayImageOptions = null;
    private boolean denyCacheImageMultipleSizesInMemory = false;
    private DiscCacheAware discCache = null;
    private int discCacheFileCount = 0;
    private FileNameGenerator discCacheFileNameGenerator = null;
    private int discCacheSize = 0;
    private ImageDownloader downloader = null;
    private boolean handleOutOfMemory = true;
    private Bitmap.CompressFormat imageCompressFormatForDiscCache = null;
    private int imageQualityForDiscCache = 0;
    private boolean loggingEnabled = false;
    private int maxImageHeightForDiscCache = 0;
    private int maxImageHeightForMemoryCache = 0;
    private int maxImageWidthForDiscCache = 0;
    private int maxImageWidthForMemoryCache = 0;
    private MemoryCacheAware<String, Bitmap> memoryCache = null;
    private int memoryCacheSize = 2097152;
    private int threadPoolSize = 3;
    private int threadPriority = 4;

    public Builder(Context paramContext)
    {
      this.context = paramContext;
    }

    private void initEmptyFiledsWithDefaultValues()
    {
      if (this.discCache == null)
      {
        if (this.discCacheFileNameGenerator == null)
        {
          FileNameGenerator localFileNameGenerator1 = DefaultConfigurationFactory.createFileNameGenerator();
          this.discCacheFileNameGenerator = localFileNameGenerator1;
        }
        Context localContext = this.context;
        FileNameGenerator localFileNameGenerator2 = this.discCacheFileNameGenerator;
        int i = this.discCacheSize;
        int j = this.discCacheFileCount;
        DiscCacheAware localDiscCacheAware = DefaultConfigurationFactory.createDiscCache(localContext, localFileNameGenerator2, i, j);
        this.discCache = localDiscCacheAware;
      }
      if (this.memoryCache == null)
      {
        int k = this.memoryCacheSize;
        boolean bool = this.denyCacheImageMultipleSizesInMemory;
        MemoryCacheAware localMemoryCacheAware = DefaultConfigurationFactory.createMemoryCache(k, bool);
        this.memoryCache = localMemoryCacheAware;
      }
      if (this.downloader == null)
      {
        ImageDownloader localImageDownloader = DefaultConfigurationFactory.createImageDownloader();
        this.downloader = localImageDownloader;
      }
      if (this.defaultDisplayImageOptions == null)
      {
        DisplayImageOptions localDisplayImageOptions = DisplayImageOptions.createSimple();
        this.defaultDisplayImageOptions = localDisplayImageOptions;
      }
      DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
      if (this.maxImageWidthForMemoryCache == 0)
      {
        int m = localDisplayMetrics.widthPixels;
        this.maxImageWidthForMemoryCache = m;
      }
      if (this.maxImageHeightForMemoryCache != 0)
        return;
      int n = localDisplayMetrics.heightPixels;
      this.maxImageHeightForMemoryCache = n;
    }

    public ImageLoaderConfiguration build()
    {
      initEmptyFiledsWithDefaultValues();
      return new ImageLoaderConfiguration(this, null);
    }

    public Builder defaultDisplayImageOptions(DisplayImageOptions paramDisplayImageOptions)
    {
      this.defaultDisplayImageOptions = paramDisplayImageOptions;
      return this;
    }

    public Builder denyCacheImageMultipleSizesInMemory()
    {
      this.denyCacheImageMultipleSizesInMemory = true;
      return this;
    }

    public Builder discCache(DiscCacheAware paramDiscCacheAware)
    {
      if (this.discCacheSize > 0)
        int i = Log.w(ImageLoader.TAG, "This method's call overlaps discCacheSize() method call");
      if (this.discCacheFileCount > 0)
        int j = Log.w(ImageLoader.TAG, "This method's call overlaps discCacheFileCount() method call");
      if (this.discCacheFileNameGenerator != null)
        int k = Log.w(ImageLoader.TAG, "This method's call overlaps discCacheFileNameGenerator() method call");
      this.discCache = paramDiscCacheAware;
      return this;
    }

    public Builder discCacheExtraOptions(int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3)
    {
      this.maxImageWidthForDiscCache = paramInt1;
      this.maxImageHeightForDiscCache = paramInt2;
      this.imageCompressFormatForDiscCache = paramCompressFormat;
      this.imageQualityForDiscCache = paramInt3;
      return this;
    }

    public Builder discCacheFileCount(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("maxFileCount must be a positive number");
      if (this.discCache != null)
        int i = Log.w(ImageLoader.TAG, "You already have set disc cache. This method call will make no effect.");
      if (this.discCacheSize > 0)
        int j = Log.w(ImageLoader.TAG, "This method's call overlaps discCacheSize() method call");
      this.discCacheSize = 0;
      this.discCacheFileCount = paramInt;
      return this;
    }

    public Builder discCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator)
    {
      if (this.discCache != null)
        int i = Log.w(ImageLoader.TAG, "You already have set disc cache. This method call will make no effect.");
      this.discCacheFileNameGenerator = paramFileNameGenerator;
      return this;
    }

    public Builder discCacheSize(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("maxCacheSize must be a positive number");
      if (this.discCache != null)
        int i = Log.w(ImageLoader.TAG, "You already have set disc cache. This method call will make no effect.");
      if (this.discCacheFileCount > 0)
        int j = Log.w(ImageLoader.TAG, "This method's call overlaps discCacheFileCount() method call");
      this.discCacheSize = paramInt;
      return this;
    }

    public Builder enableLogging()
    {
      this.loggingEnabled = true;
      return this;
    }

    public Builder imageDownloader(ImageDownloader paramImageDownloader)
    {
      this.downloader = paramImageDownloader;
      return this;
    }

    public Builder memoryCache(MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
    {
      if (this.memoryCacheSize != 2097152)
        int i = Log.w(ImageLoader.TAG, "This method's call overlaps memoryCacheSize() method call");
      this.memoryCache = paramMemoryCacheAware;
      return this;
    }

    public Builder memoryCacheExtraOptions(int paramInt1, int paramInt2)
    {
      this.maxImageWidthForMemoryCache = paramInt1;
      this.maxImageHeightForMemoryCache = paramInt2;
      return this;
    }

    public Builder memoryCacheSize(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("memoryCacheSize must be a positive number");
      if (this.memoryCache != null)
        int i = Log.w(ImageLoader.TAG, "You already have set memory cache. This method call will make no effect.");
      this.memoryCacheSize = paramInt;
      return this;
    }

    public Builder offOutOfMemoryHandling()
    {
      this.handleOutOfMemory = false;
      return this;
    }

    public Builder threadPoolSize(int paramInt)
    {
      this.threadPoolSize = paramInt;
      return this;
    }

    public Builder threadPriority(int paramInt)
    {
      if (paramInt < 1)
        this.threadPriority = 1;
      while (true)
      {
        return this;
        if (paramInt <= 10)
          this.threadPriority = paramInt;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderConfiguration
 * JD-Core Version:    0.6.2
 */