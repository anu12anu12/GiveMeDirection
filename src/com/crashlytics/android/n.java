package com.crashlytics.android;

import java.io.File;
import java.util.concurrent.locks.Lock;

final class n
  implements Runnable
{
  n(j paramj, File[] paramArrayOfFile)
  {
  }

  public final void run()
  {
    j.a(this.b).lock();
    try
    {
      if (!j.b(this.b).exists())
        boolean bool = j.b(this.b).mkdirs();
      File[] arrayOfFile = this.a;
      int i = arrayOfFile.length;
      int j = 0;
      while (j < i)
      {
        File localFile1 = arrayOfFile[j];
        D.c("Stashing invalid temp file: " + localFile1);
        File localFile2 = j.b(this.b);
        String str = localFile1.getName();
        File localFile3 = new File(localFile2, str);
        if (!localFile1.renameTo(localFile3))
          D.a("Could not rename temp file " + localFile1, null);
        j += 1;
      }
      return;
    }
    finally
    {
      j.a(this.b).unlock();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.n
 * JD-Core Version:    0.6.2
 */