package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;
import java.io.IOException;

public final class StorageUtils
{
  private static final String INDIVIDUAL_DIR_NAME = "uil-images";

  public static File getCacheDirectory(Context paramContext)
  {
    File localFile = null;
    if (Environment.getExternalStorageState().equals("mounted"))
      localFile = getExternalCacheDir(paramContext);
    if (localFile == null)
      localFile = paramContext.getCacheDir();
    return localFile;
  }

  private static File getExternalCacheDir(Context paramContext)
  {
    File localFile1 = Environment.getExternalStorageDirectory();
    File localFile2 = new File(localFile1, "Android");
    File localFile3 = new File(localFile2, "data");
    String str = paramContext.getPackageName();
    File localFile4 = new File(localFile3, str);
    File localFile5 = new File(localFile4, "cache");
    if (!localFile5.exists());
    try
    {
      boolean bool = new File(localFile3, ".nomedia").createNewFile();
      if (!localFile5.mkdirs())
      {
        int i = Log.w(ImageLoader.TAG, "Unable to create external cache directory");
        localFile5 = null;
      }
      return localFile5;
    }
    catch (IOException localIOException)
    {
      while (true)
        int j = Log.w(ImageLoader.TAG, "Can't create \".nomedia\" file in application external cache directory", localIOException);
    }
  }

  public static File getIndividualCacheDirectory(Context paramContext)
  {
    File localFile1 = getCacheDirectory(paramContext);
    File localFile2 = new File(localFile1, "uil-images");
    if ((!localFile2.exists()) && (!localFile2.mkdir()))
      localFile2 = localFile1;
    return localFile2;
  }

  public static File getOwnCacheDirectory(Context paramContext, String paramString)
  {
    File localFile1 = null;
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      File localFile2 = Environment.getExternalStorageDirectory();
      localFile1 = new File(localFile2, paramString);
    }
    if ((localFile1 == null) || ((!localFile1.exists()) && (!localFile1.mkdirs())))
      localFile1 = paramContext.getCacheDir();
    return localFile1;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.StorageUtils
 * JD-Core Version:    0.6.2
 */