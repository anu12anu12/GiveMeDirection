package com.nostra13.universalimageloader.core.assist;

import java.util.Comparator;

public final class MemoryCacheKeyUtil
{
  private static final String MEMORY_CACHE_KEY_FORMAT = "%s_%sx%s";
  private static final String URI_AND_SIZE_SEPARATOR = "_";

  public static Comparator<String> createFuzzyKeyComparator()
  {
    return new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        int i = paramAnonymousString1.lastIndexOf("_");
        String str1 = paramAnonymousString1.substring(0, i);
        int j = paramAnonymousString2.lastIndexOf("_");
        String str2 = paramAnonymousString2.substring(0, j);
        return str1.compareTo(str2);
      }
    };
  }

  public static String generateKey(String paramString, ImageSize paramImageSize)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString;
    Integer localInteger1 = Integer.valueOf(paramImageSize.getWidth());
    arrayOfObject[1] = localInteger1;
    Integer localInteger2 = Integer.valueOf(paramImageSize.getHeight());
    arrayOfObject[2] = localInteger2;
    return String.format("%s_%sx%s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.MemoryCacheKeyUtil
 * JD-Core Version:    0.6.2
 */