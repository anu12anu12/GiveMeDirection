package com.crashlytics.android;

import java.io.File;
import java.io.FilenameFilter;

final class p
  implements FilenameFilter
{
  private String a;

  public p(j paramj, String paramString)
  {
    this.a = paramString;
  }

  public final boolean accept(File paramFile, String paramString)
  {
    String str = this.a;
    if (paramString.contains(str));
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.p
 * JD-Core Version:    0.6.2
 */