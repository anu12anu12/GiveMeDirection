package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.MemoryCacheKeyUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FakeBitmapDisplayer;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

public class ImageLoader
{
  private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
  private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
  private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference are required)";
  private static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
  public static final String TAG = ImageLoader.class.getSimpleName();
  private static volatile ImageLoader instance;
  private Map<ImageView, String> cacheKeyForImageView;
  private ExecutorService cachedImageLoadingExecutor;
  private ImageLoaderConfiguration configuration;
  private ImageLoadingListener emptyListener;
  private BitmapDisplayer fakeBitmapDisplayer;
  private ExecutorService imageLoadingExecutor;
  private Map<String, ReentrantLock> uriLocks;

  private ImageLoader()
  {
    Map localMap1 = Collections.synchronizedMap(new WeakHashMap());
    this.cacheKeyForImageView = localMap1;
    Map localMap2 = Collections.synchronizedMap(new WeakHashMap());
    this.uriLocks = localMap2;
  }

  private void checkExecutors()
  {
    if ((this.imageLoadingExecutor == null) || (this.imageLoadingExecutor.isShutdown()))
    {
      int i = this.configuration.threadPoolSize;
      ThreadFactory localThreadFactory1 = this.configuration.displayImageThreadFactory;
      ExecutorService localExecutorService1 = Executors.newFixedThreadPool(i, localThreadFactory1);
      this.imageLoadingExecutor = localExecutorService1;
    }
    if ((this.cachedImageLoadingExecutor != null) && (!this.cachedImageLoadingExecutor.isShutdown()))
      return;
    int j = this.configuration.threadPoolSize;
    ThreadFactory localThreadFactory2 = this.configuration.displayImageThreadFactory;
    ExecutorService localExecutorService2 = Executors.newFixedThreadPool(j, localThreadFactory2);
    this.cachedImageLoadingExecutor = localExecutorService2;
  }

  private int getFieldValue(Object paramObject, String paramString)
  {
    int i = 0;
    try
    {
      Field localField = ImageView.class.getDeclaredField(paramString);
      localField.setAccessible(true);
      int j = ((Integer)localField.get(paramObject)).intValue();
      int k = j;
      if ((k > 0) && (k < 2147483647))
        i = k;
      return i;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str1 = TAG;
        String str2 = localException.getMessage();
        int m = Log.e(str1, str2, localException);
      }
    }
  }

  private ImageSize getImageSizeScaleTo(ImageView paramImageView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    int i = localLayoutParams.width;
    if (i <= 0)
      i = getFieldValue(paramImageView, "mMaxWidth");
    if (i <= 0)
      i = this.configuration.maxImageWidthForMemoryCache;
    int j = localLayoutParams.height;
    if (j <= 0)
      j = getFieldValue(paramImageView, "mMaxHeight");
    if (j <= 0)
      j = this.configuration.maxImageHeightForMemoryCache;
    int k = paramImageView.getContext().getResources().getConfiguration().orientation;
    if (((k == 1) && (i > j)) || ((k == 2) && (i < j)))
    {
      int m = i;
      i = j;
      j = m;
    }
    return new ImageSize(i, j);
  }

  public static ImageLoader getInstance()
  {
    if (instance == null);
    synchronized (ImageLoader.class)
    {
      if (instance == null)
        instance = new ImageLoader();
      return instance;
    }
  }

  private ReentrantLock getLockForUri(String paramString)
  {
    synchronized (this.uriLocks)
    {
      ReentrantLock localReentrantLock = (ReentrantLock)this.uriLocks.get(paramString);
      if (localReentrantLock == null)
      {
        localReentrantLock = new ReentrantLock();
        Object localObject1 = this.uriLocks.put(paramString, localReentrantLock);
      }
      return localReentrantLock;
    }
  }

  public void cancelDisplayTask(ImageView paramImageView)
  {
    Object localObject = this.cacheKeyForImageView.remove(paramImageView);
  }

  public void clearDiscCache()
  {
    if (this.configuration == null)
      return;
    this.configuration.discCache.clear();
  }

  public void clearMemoryCache()
  {
    if (this.configuration == null)
      return;
    this.configuration.memoryCache.clear();
  }

  public void displayImage(String paramString, ImageView paramImageView)
  {
    displayImage(paramString, paramImageView, null, null);
  }

  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions)
  {
    displayImage(paramString, paramImageView, paramDisplayImageOptions, null);
  }

  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    if (this.configuration == null)
      throw new RuntimeException("ImageLoader must be init with configuration before using");
    if (paramImageView == null)
    {
      int i = Log.w(TAG, "Wrong arguments were passed to displayImage() method (ImageView reference are required)");
      return;
    }
    if (paramImageLoadingListener == null)
      paramImageLoadingListener = this.emptyListener;
    if (paramDisplayImageOptions == null)
      paramDisplayImageOptions = this.configuration.defaultDisplayImageOptions;
    if ((paramString == null) || (paramString.length() == 0))
    {
      Object localObject1 = this.cacheKeyForImageView.remove(paramImageView);
      paramImageLoadingListener.onLoadingStarted();
      if (paramDisplayImageOptions.isShowImageForEmptyUri())
      {
        int j = paramDisplayImageOptions.getImageForEmptyUri().intValue();
        paramImageView.setImageResource(j);
      }
      while (true)
      {
        paramImageLoadingListener.onLoadingComplete(null);
        return;
        paramImageView.setImageBitmap(null);
      }
    }
    ImageSize localImageSize = getImageSizeScaleTo(paramImageView);
    String str1 = MemoryCacheKeyUtil.generateKey(paramString, localImageSize);
    Object localObject2 = this.cacheKeyForImageView.put(paramImageView, str1);
    Bitmap localBitmap1 = (Bitmap)this.configuration.memoryCache.get(str1);
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      if (this.configuration.loggingEnabled)
      {
        String str2 = TAG;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = str1;
        String str3 = String.format("Load image from memory cache [%s]", arrayOfObject);
        int k = Log.i(str2, str3);
      }
      paramImageLoadingListener.onLoadingStarted();
      Bitmap localBitmap2 = paramDisplayImageOptions.getDisplayer().display(localBitmap1, paramImageView);
      paramImageView.setImageBitmap(localBitmap2);
      paramImageLoadingListener.onLoadingComplete(localBitmap1);
      return;
    }
    paramImageLoadingListener.onLoadingStarted();
    if (paramDisplayImageOptions.isShowStubImage())
    {
      int m = paramDisplayImageOptions.getStubImage().intValue();
      paramImageView.setImageResource(m);
    }
    LoadAndDisplayImageTask localLoadAndDisplayImageTask;
    while (true)
    {
      checkExecutors();
      ReentrantLock localReentrantLock = getLockForUri(paramString);
      String str4 = paramString;
      ImageView localImageView = paramImageView;
      DisplayImageOptions localDisplayImageOptions = paramDisplayImageOptions;
      ImageLoadingListener localImageLoadingListener = paramImageLoadingListener;
      ImageLoadingInfo localImageLoadingInfo = new ImageLoadingInfo(str4, localImageView, localImageSize, localDisplayImageOptions, localImageLoadingListener, localReentrantLock);
      ImageLoaderConfiguration localImageLoaderConfiguration = this.configuration;
      Handler localHandler = new Handler();
      localLoadAndDisplayImageTask = new LoadAndDisplayImageTask(localImageLoaderConfiguration, localImageLoadingInfo, localHandler);
      if (!this.configuration.discCache.get(paramString).exists())
        break;
      Future localFuture1 = this.cachedImageLoadingExecutor.submit(localLoadAndDisplayImageTask);
      return;
      if (paramDisplayImageOptions.isResetViewBeforeLoading())
        paramImageView.setImageBitmap(null);
    }
    Future localFuture2 = this.imageLoadingExecutor.submit(localLoadAndDisplayImageTask);
  }

  public void displayImage(String paramString, ImageView paramImageView, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageView, null, paramImageLoadingListener);
  }

  public DiscCacheAware getDiscCache()
  {
    return this.configuration.discCache;
  }

  public String getLoadingUriForView(ImageView paramImageView)
  {
    return (String)this.cacheKeyForImageView.get(paramImageView);
  }

  public MemoryCacheAware<String, Bitmap> getMemoryCache()
  {
    return this.configuration.memoryCache;
  }

  /** @deprecated */
  public void init(ImageLoaderConfiguration paramImageLoaderConfiguration)
  {
    if (paramImageLoaderConfiguration == null)
      try
      {
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
      }
      finally
      {
      }
    if (this.configuration == null)
    {
      this.configuration = paramImageLoaderConfiguration;
      SimpleImageLoadingListener localSimpleImageLoadingListener = new SimpleImageLoadingListener();
      this.emptyListener = localSimpleImageLoadingListener;
      FakeBitmapDisplayer localFakeBitmapDisplayer = new FakeBitmapDisplayer();
      this.fakeBitmapDisplayer = localFakeBitmapDisplayer;
    }
  }

  public void loadImage(Context paramContext, String paramString, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader localImageLoader = this;
    Context localContext = paramContext;
    String str = paramString;
    DisplayImageOptions localDisplayImageOptions = paramDisplayImageOptions;
    ImageLoadingListener localImageLoadingListener = paramImageLoadingListener;
    localImageLoader.loadImage(localContext, str, null, localDisplayImageOptions, localImageLoadingListener);
  }

  public void loadImage(Context paramContext, String paramString, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader localImageLoader = this;
    Context localContext = paramContext;
    String str = paramString;
    DisplayImageOptions localDisplayImageOptions = null;
    ImageLoadingListener localImageLoadingListener = paramImageLoadingListener;
    localImageLoader.loadImage(localContext, str, null, localDisplayImageOptions, localImageLoadingListener);
  }

  public void loadImage(Context paramContext, String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    if (paramImageSize == null)
    {
      int i = this.configuration.maxImageWidthForMemoryCache;
      int j = this.configuration.maxImageHeightForMemoryCache;
      paramImageSize = new ImageSize(i, j);
    }
    if (paramDisplayImageOptions == null)
      paramDisplayImageOptions = this.configuration.defaultDisplayImageOptions;
    if ((paramDisplayImageOptions.getDisplayer() instanceof FakeBitmapDisplayer));
    DisplayImageOptions.Builder localBuilder1;
    for (DisplayImageOptions localDisplayImageOptions = paramDisplayImageOptions; ; localDisplayImageOptions = localBuilder1.build())
    {
      ImageView localImageView = new ImageView(paramContext);
      int k = paramImageSize.getWidth();
      int m = paramImageSize.getHeight();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(k, m);
      localImageView.setLayoutParams(localLayoutParams);
      ImageView.ScaleType localScaleType = ImageView.ScaleType.CENTER_CROP;
      localImageView.setScaleType(localScaleType);
      displayImage(paramString, localImageView, localDisplayImageOptions, paramImageLoadingListener);
      return;
      localBuilder1 = new DisplayImageOptions.Builder();
      if (paramDisplayImageOptions.isCacheInMemory())
        DisplayImageOptions.Builder localBuilder2 = localBuilder1.cacheInMemory();
      if (paramDisplayImageOptions.isCacheOnDisc())
        DisplayImageOptions.Builder localBuilder3 = localBuilder1.cacheOnDisc();
      if (paramDisplayImageOptions.isResetViewBeforeLoading())
        DisplayImageOptions.Builder localBuilder4 = localBuilder1.resetViewBeforeLoading();
      if (paramDisplayImageOptions.isShowImageForEmptyUri())
      {
        int n = paramDisplayImageOptions.getImageForEmptyUri().intValue();
        DisplayImageOptions.Builder localBuilder5 = localBuilder1.showImageForEmptyUri(n);
      }
      if (paramDisplayImageOptions.isShowStubImage())
      {
        int i1 = paramDisplayImageOptions.getStubImage().intValue();
        DisplayImageOptions.Builder localBuilder6 = localBuilder1.showStubImage(i1);
      }
      ImageScaleType localImageScaleType = paramDisplayImageOptions.getImageScaleType();
      DisplayImageOptions.Builder localBuilder7 = localBuilder1.imageScaleType(localImageScaleType);
      BitmapDisplayer localBitmapDisplayer = this.fakeBitmapDisplayer;
      DisplayImageOptions.Builder localBuilder8 = localBuilder1.displayer(localBitmapDisplayer);
    }
  }

  public void loadImage(Context paramContext, String paramString, ImageSize paramImageSize, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader localImageLoader = this;
    Context localContext = paramContext;
    String str = paramString;
    ImageSize localImageSize = paramImageSize;
    ImageLoadingListener localImageLoadingListener = paramImageLoadingListener;
    localImageLoader.loadImage(localContext, str, localImageSize, null, localImageLoadingListener);
  }

  public void stop()
  {
    if (this.imageLoadingExecutor != null)
      List localList1 = this.imageLoadingExecutor.shutdownNow();
    if (this.cachedImageLoadingExecutor == null)
      return;
    List localList2 = this.cachedImageLoadingExecutor.shutdownNow();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoader
 * JD-Core Version:    0.6.2
 */