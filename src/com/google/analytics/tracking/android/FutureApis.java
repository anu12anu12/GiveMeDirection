package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

class FutureApis
{
  static boolean setOwnerOnlyReadWrite(String paramString)
  {
    boolean bool1 = false;
    if (version() < 9);
    while (true)
    {
      return bool1;
      File localFile = new File(paramString);
      boolean bool2 = localFile.setReadable(false, false);
      boolean bool3 = localFile.setWritable(false, false);
      boolean bool4 = localFile.setReadable(true, true);
      boolean bool5 = localFile.setWritable(true, true);
      bool1 = true;
    }
  }

  public static int version()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      j = i;
      return j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Invalid version number: ");
        String str = Build.VERSION.SDK;
        int k = Log.e(str);
        int j = 0;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.FutureApis
 * JD-Core Version:    0.6.2
 */