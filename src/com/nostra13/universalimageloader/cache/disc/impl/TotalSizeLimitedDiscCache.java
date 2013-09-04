package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.LimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

public class TotalSizeLimitedDiscCache extends LimitedDiscCache
{
  public TotalSizeLimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, localFileNameGenerator, paramInt);
  }

  public TotalSizeLimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator, paramInt);
  }

  protected int getSize(File paramFile)
  {
    return (int)paramFile.length();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache
 * JD-Core Version:    0.6.2
 */