package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

public abstract class BaseDiscCache
  implements DiscCacheAware
{
  private File cacheDir;
  private FileNameGenerator fileNameGenerator;

  public BaseDiscCache(File paramFile)
  {
    this(paramFile, localFileNameGenerator);
  }

  public BaseDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    this.cacheDir = paramFile;
    this.fileNameGenerator = paramFileNameGenerator;
  }

  public void clear()
  {
    File[] arrayOfFile1 = this.cacheDir.listFiles();
    if (arrayOfFile1 == null)
      return;
    File[] arrayOfFile2 = arrayOfFile1;
    int i = arrayOfFile2.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      boolean bool = arrayOfFile2[j].delete();
      j += 1;
    }
  }

  public File get(String paramString)
  {
    String str = this.fileNameGenerator.generate(paramString);
    File localFile = this.cacheDir;
    return new File(localFile, str);
  }

  protected File getCacheDir()
  {
    return this.cacheDir;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.BaseDiscCache
 * JD-Core Version:    0.6.2
 */