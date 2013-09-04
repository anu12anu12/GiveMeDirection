package com.MASTAdView.ormma.util;

import java.io.File;
import java.util.Comparator;

public class FileComparatorByDate
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    Long localLong1 = Long.valueOf(paramFile1.lastModified());
    Long localLong2 = Long.valueOf(paramFile2.lastModified());
    return localLong1.compareTo(localLong2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.util.FileComparatorByDate
 * JD-Core Version:    0.6.2
 */