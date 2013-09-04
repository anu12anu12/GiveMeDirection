package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

class MetaModel
{
  private Map<String, MetaInfo> metaInfos;

  MetaModel()
  {
    HashMap localHashMap = new HashMap();
    this.metaInfos = localHashMap;
  }

  public void addField(String paramString1, String paramString2, String paramString3, Formatter paramFormatter)
  {
    Map localMap = this.metaInfos;
    MetaInfo localMetaInfo = new MetaInfo(paramString2, paramString3, paramFormatter);
    Object localObject = localMap.put(paramString1, localMetaInfo);
  }

  MetaInfo getMetaInfo(String paramString)
  {
    String str1;
    if (paramString.startsWith("&"))
      str1 = paramString.substring(1);
    String str2;
    for (MetaInfo localMetaInfo = new MetaInfo(str1, null, null); ; localMetaInfo = (MetaInfo)this.metaInfos.get(str2))
    {
      return localMetaInfo;
      str2 = paramString;
      if (paramString.contains("*"))
      {
        int i = paramString.indexOf("*");
        str2 = paramString.substring(0, i);
      }
    }
  }

  public static class MetaInfo
  {
    private final String defaultValue;
    private final MetaModel.Formatter formatter;
    private final String urlParam;

    public MetaInfo(String paramString1, String paramString2, MetaModel.Formatter paramFormatter)
    {
      this.urlParam = paramString1;
      this.defaultValue = paramString2;
      this.formatter = paramFormatter;
    }

    public String getDefaultValue()
    {
      return this.defaultValue;
    }

    public MetaModel.Formatter getFormatter()
    {
      return this.formatter;
    }

    public String getUrlParam(String paramString)
    {
      String str1 = null;
      String str2;
      String[] arrayOfString;
      int i;
      if (paramString.contains("*"))
      {
        str2 = this.urlParam;
        arrayOfString = paramString.split("\\*");
        if (arrayOfString.length > 1)
          i = 1;
      }
      while (true)
      {
        try
        {
          int j = Integer.parseInt(arrayOfString[i]);
          int k = j;
          str1 = str2 + k;
          return str1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int m = Log.w("Unable to parse slot for url parameter " + str2);
          continue;
        }
        str1 = this.urlParam;
      }
    }
  }

  public static abstract interface Formatter
  {
    public abstract String format(String paramString);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.MetaModel
 * JD-Core Version:    0.6.2
 */