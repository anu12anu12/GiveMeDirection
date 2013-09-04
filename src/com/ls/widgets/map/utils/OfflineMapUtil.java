package com.ls.widgets.map.utils;

public class OfflineMapUtil
{
  private static String a;
  private static String b;

  private static String a(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i != -1)
    {
      int j = i + 1;
      paramString = paramString.substring(j);
    }
    return paramString;
  }

  public static String getConfigFilePath(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("root can't be null");
    if (paramString.lastIndexOf('/') == -1);
    StringBuilder localStringBuilder;
    String str2;
    for (String str1 = paramString + "/" + paramString + ".xml"; ; str1 = str2 + ".xml")
    {
      return str1;
      localStringBuilder = new StringBuilder().append(paramString).append("/");
      str2 = a(paramString);
    }
  }

  public static String getFilesPath(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("root can't be null");
    String str1;
    if (a != null)
    {
      int i = b.hashCode();
      int j = paramString.hashCode();
      if (i != j)
        str1 = a;
    }
    while (true)
    {
      return str1;
      if (paramString.lastIndexOf('/') == -1)
      {
        a = paramString + "/" + paramString + "_files/";
        b = paramString;
        str1 = a;
      }
      else
      {
        if (paramString.lastIndexOf('/') != -1)
        {
          StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("/");
          String str2 = a(paramString);
          a = str2 + "_files/";
          b = paramString;
        }
        str1 = a;
      }
    }
  }

  public static int getMaxZoomLevel(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      if (paramInt1 != 0)
        break label18;
    label18: double d1;
    double d2;
    for (int i = 0; ; i = (int)Math.ceil(d1 / d2))
    {
      return i;
      paramInt1 = paramInt2;
      break;
      d1 = Math.log(paramInt1);
      d2 = Math.log(2.0D);
    }
  }

  public static int getScaledImageSize(int paramInt1, int paramInt2, int paramInt3)
  {
    double d1 = paramInt1 - paramInt2;
    double d2 = Math.pow(2.0D, d1);
    double d3 = 1.0D / d2;
    double d4 = paramInt3;
    return (int)Math.ceil(d3 * d4);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.utils.OfflineMapUtil
 * JD-Core Version:    0.6.2
 */