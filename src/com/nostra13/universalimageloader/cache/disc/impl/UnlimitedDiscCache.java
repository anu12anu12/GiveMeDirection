package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

public class UnlimitedDiscCache extends BaseDiscCache
{
  public UnlimitedDiscCache(File paramFile)
  {
    this(paramFile, localFileNameGenerator);
  }

  public UnlimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    super(paramFile, paramFileNameGenerator);
  }

  public void put(String paramString, File paramFile)
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache
 * JD-Core Version:    0.6.2
 */