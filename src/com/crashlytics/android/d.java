package com.crashlytics.android;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

final class d extends FileOutputStream
{
  public static final FilenameFilter a = new e();
  private final String b;
  private File c;
  private File d;
  private boolean e = false;

  public d(File paramFile, String paramString)
    throws FileNotFoundException
  {
    super(localFile1);
    StringBuilder localStringBuilder1 = new StringBuilder().append(paramFile);
    String str2 = File.separator;
    String str3 = str2 + paramString;
    this.b = str3;
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str4 = this.b;
    String str5 = str4 + ".cls_temp";
    File localFile2 = new File(str5);
    this.c = localFile2;
  }

  public final File a()
  {
    return this.d;
  }

  /** @deprecated */
  public final void close()
    throws IOException
  {
    File localFile1;
    try
    {
      boolean bool = this.e;
      if (bool != null);
      while (true)
      {
        return;
        bool = true;
        this.e = bool;
        super.flush();
        super.close();
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str2 = this.b;
        String str3 = str2 + ".cls";
        localFile1 = new File(str3);
        if (!this.c.renameTo(localFile1))
          break;
        this.c = null;
        this.d = localFile1;
      }
    }
    finally
    {
    }
    String str1 = "";
    if (this.d.exists())
      str1 = " (target already exists)";
    while (true)
    {
      StringBuilder localStringBuilder2 = new StringBuilder("Could not rename temp file: ");
      File localFile2 = this.c;
      String str4 = localFile2 + " -> " + localFile1 + str1;
      throw new IOException(str4);
      if (!this.c.exists())
        str1 = " (source does not exist)";
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.d
 * JD-Core Version:    0.6.2
 */