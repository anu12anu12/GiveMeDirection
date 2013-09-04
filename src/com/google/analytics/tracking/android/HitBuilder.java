package com.google.analytics.tracking.android;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HitBuilder
{
  public static String encode(String paramString)
  {
    try
    {
      String str1 = URLEncoder.encode(paramString, "UTF-8");
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str2 = "URL encoding failed for: " + paramString;
      throw new AssertionError(str2);
    }
  }

  public static Map<String, String> generateHitParams(MetaModel paramMetaModel, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      MetaModel.MetaInfo localMetaInfo = paramMetaModel.getMetaInfo(str1);
      if (localMetaInfo != null)
      {
        String str2 = (String)localEntry.getKey();
        String str3 = localMetaInfo.getUrlParam(str2);
        if (str3 != null)
        {
          String str4 = (String)localEntry.getValue();
          if (localMetaInfo.getFormatter() != null)
            str4 = localMetaInfo.getFormatter().format(str4);
          if (str4 != null)
          {
            String str5 = localMetaInfo.getDefaultValue();
            if (!str4.equals(str5))
              Object localObject = localHashMap.put(str3, str4);
          }
        }
      }
    }
    return localHashMap;
  }

  static String postProcessHit(Hit paramHit, long paramLong)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str = paramHit.getHitParams();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str);
    if (paramHit.getHitTime() > 0L)
    {
      long l1 = paramHit.getHitTime();
      long l2 = paramLong - l1;
      if (l2 >= 0L)
        StringBuilder localStringBuilder3 = localStringBuilder1.append("&").append("qt").append("=").append(l2);
    }
    StringBuilder localStringBuilder4 = localStringBuilder1.append("&").append("z").append("=");
    long l3 = paramHit.getHitId();
    StringBuilder localStringBuilder5 = localStringBuilder4.append(l3);
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.HitBuilder
 * JD-Core Version:    0.6.2
 */