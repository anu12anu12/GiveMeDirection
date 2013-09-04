package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.impl.FileCountLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.assist.MemoryCacheKeyUtil;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.URLConnectionImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.util.Comparator;

public class DefaultConfigurationFactory
{
  public static BitmapDisplayer createBitmapDisplayer()
  {
    return new SimpleBitmapDisplayer();
  }

  public static DiscCacheAware createDiscCache(Context paramContext, FileNameGenerator paramFileNameGenerator, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt1 > 0)
    {
      File localFile1 = StorageUtils.getIndividualCacheDirectory(paramContext);
      localObject = new TotalSizeLimitedDiscCache(localFile1, paramFileNameGenerator, paramInt1);
    }
    while (true)
    {
      return localObject;
      if (paramInt2 > 0)
      {
        File localFile2 = StorageUtils.getIndividualCacheDirectory(paramContext);
        localObject = new FileCountLimitedDiscCache(localFile2, paramFileNameGenerator, paramInt2);
      }
      else
      {
        File localFile3 = StorageUtils.getCacheDirectory(paramContext);
        localObject = new UnlimitedDiscCache(localFile3, paramFileNameGenerator);
      }
    }
  }

  public static FileNameGenerator createFileNameGenerator()
  {
    return new HashCodeFileNameGenerator();
  }

  public static ImageDownloader createImageDownloader()
  {
    return new URLConnectionImageDownloader();
  }

  public static MemoryCacheAware<String, Bitmap> createMemoryCache(int paramInt, boolean paramBoolean)
  {
    Object localObject = new UsingFreqLimitedMemoryCache(paramInt);
    if (paramBoolean)
    {
      Comparator localComparator = MemoryCacheKeyUtil.createFuzzyKeyComparator();
      localObject = new FuzzyKeyMemoryCache((MemoryCacheAware)localObject, localComparator);
    }
    return localObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DefaultConfigurationFactory
 * JD-Core Version:    0.6.2
 */