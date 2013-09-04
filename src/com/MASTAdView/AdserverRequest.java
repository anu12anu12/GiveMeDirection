package com.MASTAdView;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdserverRequest
{
  private static final String parameter_Ad_Call_Timeout = "timeout";
  public static final String parameter_device_id = "udid";
  private MASTAdLog AdLog;
  private String adserverURL;
  private Context appContext;
  private Hashtable<String, String> customParameters;
  private final String parameter_area;
  private final String parameter_background;
  private final String parameter_carrier;
  private final String parameter_city;
  private final String parameter_count;
  private final String parameter_country;
  private final String parameter_dma;
  private final String parameter_excampaigns;
  private final String parameter_keywords;
  private final String parameter_latitude;
  private final String parameter_link;
  private final String parameter_longitude;
  private final String parameter_metro;
  private final String parameter_min_size_x;
  private final String parameter_min_size_y;
  private final String parameter_premium;
  private final String parameter_region;
  private final String parameter_site;
  private final String parameter_size_required;
  private final String parameter_size_x;
  private final String parameter_size_y;
  private final String parameter_test;
  private final String parameter_track;
  private final String parameter_type;
  private final String parameter_userAgent;
  private final String parameter_version;
  private final String parameter_zip;
  private final String parameter_zone;
  private Map<String, String> parameters;
  public int sizeX = -1;
  public int sizeY = -1;
  public int timeout = 3000;

  public AdserverRequest(MASTAdLog paramMASTAdLog, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    this.parameters = localHashMap;
    this.parameter_site = "site";
    this.parameter_zone = "zone";
    this.parameter_userAgent = "ua";
    this.parameter_keywords = "keywords";
    this.parameter_premium = "premium";
    this.parameter_track = "track";
    this.parameter_test = "test";
    this.parameter_count = "count";
    this.parameter_country = "country";
    this.parameter_region = "region";
    this.parameter_city = "city";
    this.parameter_area = "area";
    this.parameter_metro = "metro";
    this.parameter_dma = "dma";
    this.parameter_zip = "zip";
    this.parameter_latitude = "lat";
    this.parameter_longitude = "long";
    this.parameter_background = "paramBG";
    this.parameter_link = "paramLINK";
    this.parameter_carrier = "carrier";
    this.parameter_min_size_x = "min_size_x";
    this.parameter_min_size_y = "min_size_y";
    this.parameter_size_x = "size_x";
    this.parameter_size_y = "size_y";
    this.parameter_excampaigns = "excampaigns";
    this.parameter_version = "version";
    this.parameter_size_required = "size_required";
    this.parameter_type = "type";
    this.adserverURL = "http://ads.mocean.mobi/ad";
    this.AdLog = paramMASTAdLog;
    this.appContext = paramContext;
    Integer localInteger = Integer.valueOf(2);
    AdserverRequest localAdserverRequest = setPremium(localInteger);
  }

  private void appendParameters(StringBuilder paramStringBuilder, Map<String, String> paramMap)
  {
    if (paramMap == null)
      return;
    Iterator localIterator = paramMap.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      if (str2 != null)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("&");
        String str3 = URLEncoder.encode(str1);
        String str4 = str3 + "=";
        StringBuilder localStringBuilder2 = paramStringBuilder.append(str4);
        if ((str1.equals("paramBG")) || (str1.equals("paramLINK")))
        {
          StringBuilder localStringBuilder3 = new StringBuilder("%23");
          String str5 = URLEncoder.encode(str2.toUpperCase());
          String str6 = str5;
          StringBuilder localStringBuilder4 = paramStringBuilder.append(str6);
        }
        else
        {
          String str7 = URLEncoder.encode(str2);
          StringBuilder localStringBuilder5 = paramStringBuilder.append(str7);
        }
      }
    }
  }

  private Integer getIntParameter(String paramString, Integer paramInteger)
  {
    if (paramString != null)
      paramInteger = Integer.valueOf(Integer.parseInt(paramString));
    return paramInteger;
  }

  /** @deprecated */
  public String createURL()
    throws IllegalStateException
  {
    try
    {
      String str1 = toString();
      String str2 = str1;
      return str2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public String getAdserverURL()
  {
    try
    {
      String str = this.adserverURL;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getArea()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("area");
      return str;
    }
  }

  public String getCarrier()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("carrier");
      return str;
    }
  }

  public String getCity()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("city");
      return str;
    }
  }

  public Integer getCount()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("count");
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  public String getCountry()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("country");
      return str;
    }
  }

  public Hashtable<String, String> getCustomParameters()
  {
    return this.customParameters;
  }

  public String getDma()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("dma");
      return str;
    }
  }

  public String getExcampaigns()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("excampaigns");
      return str;
    }
  }

  public String getKeywords()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("keywords");
      return str;
    }
  }

  public String getLatitude()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("lat");
      return str;
    }
  }

  public String getLongitude()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("long");
      return str;
    }
  }

  @Deprecated
  public String getMetro()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("dma");
      return str;
    }
  }

  public Integer getMinSizeX()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("min_size_x");
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  public Integer getMinSizeY()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("min_size_y");
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  public int getParamBG()
  {
    synchronized (this.parameters)
    {
      if (this.parameters.get("paramBG") == null)
      {
        i = -1;
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder("#");
      String str = (String)this.parameters.get("paramBG");
      int i = Integer.decode(str).intValue();
    }
  }

  public Integer getParamLINK()
  {
    synchronized (this.parameters)
    {
      if (this.parameters.get("paramLINK") == null)
      {
        localInteger = Integer.valueOf(-1);
        return localInteger;
      }
      StringBuilder localStringBuilder = new StringBuilder("#");
      String str = (String)this.parameters.get("paramLINK");
      Integer localInteger = Integer.decode(str);
    }
  }

  public Integer getPremium()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("premium");
      Integer localInteger1 = Integer.valueOf(2);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  public String getRegion()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("region");
      return str;
    }
  }

  public Integer getSite()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("site");
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  public Integer getSizeRequired()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("size_required");
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  public Integer getSizeX()
  {
    while (true)
    {
      synchronized (this.parameters)
      {
        String str = (String)this.parameters.get("size_x");
        if (str != null)
        {
          Integer localInteger1 = Integer.valueOf(0);
          localInteger2 = getIntParameter(str, localInteger1);
          return localInteger2;
        }
      }
      Integer localInteger2 = new Integer(0);
    }
  }

  public Integer getSizeY()
  {
    while (true)
    {
      synchronized (this.parameters)
      {
        String str = (String)this.parameters.get("size_y");
        if (str != null)
        {
          Integer localInteger1 = Integer.valueOf(0);
          localInteger2 = getIntParameter(str, localInteger1);
          return localInteger2;
        }
      }
      Integer localInteger2 = new Integer(0);
    }
  }

  public Boolean getTestModeEnabled()
  {
    while (true)
    {
      synchronized (this.parameters)
      {
        String str = (String)this.parameters.get("test");
        if (str != null)
        {
          if (str.equals("1"))
          {
            localBoolean = Boolean.valueOf(true);
            return localBoolean;
          }
          localBoolean = Boolean.valueOf(false);
        }
      }
      Boolean localBoolean = null;
      localBoolean = Boolean.valueOf(localBoolean);
    }
  }

  public Integer getTrack()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("track");
      Integer localInteger = getIntParameter(str, null);
      return localInteger;
    }
  }

  public Integer getType()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("type");
      Integer localInteger1 = Integer.valueOf(3);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  public String getUa()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("ua");
      return str;
    }
  }

  public String getVersion()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("version");
      return str;
    }
  }

  public String getZip()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("zip");
      return str;
    }
  }

  public Integer getZone()
  {
    synchronized (this.parameters)
    {
      String str = (String)this.parameters.get("zone");
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = getIntParameter(str, localInteger1);
      return localInteger2;
    }
  }

  /** @deprecated */
  public void setAdserverURL(String paramString)
  {
    if (paramString != null);
    try
    {
      if (paramString.length() > 0)
        this.adserverURL = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public AdserverRequest setArea(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("area", paramString);
      return this;
    }
  }

  public AdserverRequest setCarrier(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("carrier", paramString);
      return this;
    }
  }

  public AdserverRequest setCity(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("city", paramString);
      return this;
    }
  }

  public AdserverRequest setCount(Integer paramInteger)
  {
    if (paramInteger != null);
    synchronized (this.parameters)
    {
      Map localMap2 = this.parameters;
      String str = String.valueOf(paramInteger);
      Object localObject1 = localMap2.put("count", str);
      return this;
    }
  }

  public AdserverRequest setCountry(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("country", paramString);
      return this;
    }
  }

  public void setCustomParameters(Hashtable<String, String> paramHashtable)
  {
    this.customParameters = paramHashtable;
  }

  public AdserverRequest setDma(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("dma", paramString);
      return this;
    }
  }

  public AdserverRequest setExcampaigns(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0));
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("excampaigns", paramString);
      return this;
    }
  }

  public AdserverRequest setKeywords(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("keywords", paramString);
      return this;
    }
  }

  public AdserverRequest setLatitude(String paramString)
  {
    double d1;
    if (paramString != null)
      d1 = -1000.0D;
    try
    {
      double d2 = Double.parseDouble(paramString);
      d1 = d2;
      label17: if ((d1 >= -90.0D) && (d1 <= 90.0D));
      while (true)
      {
        synchronized (this.parameters)
        {
          Object localObject1 = this.parameters.put("lat", paramString);
          return this;
        }
        MASTAdLog localMASTAdLog = this.AdLog;
        ??? = null;
        String str = "latitude=" + paramString + "  (valid: -90<=double<=90)";
        localMASTAdLog.log(???, 1, "invalid param", str);
      }
    }
    catch (Exception localException)
    {
      break label17;
    }
  }

  public AdserverRequest setLongitude(String paramString)
  {
    double d1;
    if (paramString != null)
      d1 = -1000.0D;
    try
    {
      double d2 = Double.parseDouble(paramString);
      d1 = d2;
      label17: if ((d1 >= -180.0D) && (d1 <= 180.0D));
      while (true)
      {
        synchronized (this.parameters)
        {
          Object localObject1 = this.parameters.put("long", paramString);
          return this;
        }
        MASTAdLog localMASTAdLog = this.AdLog;
        ??? = null;
        String str = "longitude=" + paramString + " (valid: -180<=double<=180)";
        localMASTAdLog.log(???, 1, "invalid param", str);
      }
    }
    catch (Exception localException)
    {
      break label17;
    }
  }

  @Deprecated
  public AdserverRequest setMetro(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("dma", paramString);
      return this;
    }
  }

  public AdserverRequest setMinSizeX(Integer paramInteger)
  {
    if (paramInteger != null)
      if (paramInteger.intValue() <= 0);
    while (true)
    {
      synchronized (this.parameters)
      {
        Map localMap1 = this.parameters;
        String str1 = String.valueOf(paramInteger);
        Object localObject2 = localMap1.put("min_size_x", str1);
        return this;
      }
      MASTAdLog localMASTAdLog = this.AdLog;
      ??? = null;
      StringBuilder localStringBuilder = new StringBuilder("minSizeX=");
      String str2 = paramInteger.toString();
      String str3 = str2 + " valid>0";
      localMASTAdLog.log((int)???, 1, "invalid param", str3);
      continue;
      Map localMap2 = this.parameters;
      ??? = "min_size_x";
      Object localObject4 = localMap2.remove(???);
    }
  }

  public AdserverRequest setMinSizeY(Integer paramInteger)
  {
    if (paramInteger != null)
      if (paramInteger.intValue() <= 0);
    while (true)
    {
      synchronized (this.parameters)
      {
        Map localMap1 = this.parameters;
        String str1 = String.valueOf(paramInteger);
        Object localObject2 = localMap1.put("min_size_y", str1);
        return this;
      }
      MASTAdLog localMASTAdLog = this.AdLog;
      ??? = null;
      StringBuilder localStringBuilder = new StringBuilder("minSizeY=");
      String str2 = paramInteger.toString();
      String str3 = str2 + " valid>0";
      localMASTAdLog.log((int)???, 1, "invalid param", str3);
      continue;
      Map localMap2 = this.parameters;
      ??? = "min_size_y";
      Object localObject4 = localMap2.remove(???);
    }
  }

  public AdserverRequest setParamBG(Integer paramInteger)
  {
    if (paramInteger != null);
    synchronized (this.parameters)
    {
      String str = Integer.toHexString(Integer.valueOf(paramInteger.intValue() & 0xFFFFFF).intValue());
      if (str.length() >= 6)
      {
        Object localObject1 = this.parameters.put("paramBG", str);
        return this;
      }
      str = "0" + str;
    }
  }

  public AdserverRequest setParamLINK(Integer paramInteger)
  {
    if (paramInteger != null);
    synchronized (this.parameters)
    {
      String str = Integer.toHexString(Integer.valueOf(paramInteger.intValue() & 0xFFFFFF).intValue());
      if (str.length() >= 6)
      {
        Object localObject1 = this.parameters.put("paramLINK", str);
        return this;
      }
      str = "0" + str;
    }
  }

  public AdserverRequest setPremium(Integer paramInteger)
  {
    if (paramInteger != null)
      switch (paramInteger.intValue())
      {
      default:
        MASTAdLog localMASTAdLog = this.AdLog;
        StringBuilder localStringBuilder = new StringBuilder("premium=");
        String str1 = paramInteger.toString();
        String str2 = str1 + "  (valid: 0 - non-premium, 1 - premium only, 2 - both)";
        localMASTAdLog.log(3, 1, "invalid param", str2);
      case 0:
      case 1:
      case 2:
      }
    while (true)
    {
      return this;
      synchronized (this.parameters)
      {
        Map localMap2 = this.parameters;
        String str3 = String.valueOf(paramInteger);
        Object localObject1 = localMap2.put("premium", str3);
      }
    }
  }

  public AdserverRequest setRegion(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("region", paramString);
      return this;
    }
  }

  public AdserverRequest setSite(Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() > 0));
    while (true)
    {
      synchronized (this.parameters)
      {
        Map localMap2 = this.parameters;
        String str1 = paramInteger.toString();
        Object localObject1 = localMap2.put("site", str1);
        return this;
      }
      if ((paramInteger != null) && (paramInteger.intValue() < 1))
      {
        MASTAdLog localMASTAdLog = this.AdLog;
        ??? = null;
        StringBuilder localStringBuilder = new StringBuilder("site=");
        String str2 = paramInteger.toString();
        String str3 = str2 + " (valid: int>0)";
        localMASTAdLog.log(???, 1, "invalid param", str3);
      }
    }
  }

  public AdserverRequest setSizeRequired(Integer paramInteger)
  {
    if (paramInteger != null);
    synchronized (this.parameters)
    {
      Map localMap2 = this.parameters;
      String str = String.valueOf(paramInteger);
      Object localObject1 = localMap2.put("size_required", str);
      return this;
    }
  }

  public AdserverRequest setSizeX(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger.intValue() > 0));
    while (true)
    {
      MASTAdLog localMASTAdLog2;
      synchronized (this.parameters)
      {
        int i = paramInteger.intValue();
        int j = getMinSizeX().intValue();
        if (i < j)
        {
          Map localMap1 = this.parameters;
          String str1 = (String)this.parameters.get("min_size_x");
          Object localObject2 = localMap1.put("size_x", str1);
          MASTAdLog localMASTAdLog1 = this.AdLog;
          StringBuilder localStringBuilder1 = new StringBuilder("maxSizeX=");
          String str2 = paramInteger.toString();
          String str3 = str2 + " <minSizeX";
          localMASTAdLog1.log(3, 1, "invalid param", str3);
          return this;
        }
        Map localMap2 = this.parameters;
        String str4 = String.valueOf(paramInteger);
        Object localObject3 = localMap2.put("size_x", str4);
      }
      ??? = "invalid param";
      StringBuilder localStringBuilder2 = new StringBuilder("maxSizeX=");
      String str5 = paramInteger.toString();
      String str6 = str5 + " valid>0";
      localMASTAdLog2.log(3, 1, (String)???, str6);
    }
  }

  public AdserverRequest setSizeY(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger.intValue() > 0));
    while (true)
    {
      MASTAdLog localMASTAdLog2;
      synchronized (this.parameters)
      {
        int i = paramInteger.intValue();
        int j = getMinSizeY().intValue();
        if (i < j)
        {
          Map localMap1 = this.parameters;
          String str1 = (String)this.parameters.get("min_size_y");
          Object localObject2 = localMap1.put("size_y", str1);
          MASTAdLog localMASTAdLog1 = this.AdLog;
          StringBuilder localStringBuilder1 = new StringBuilder("maxSizeY=");
          String str2 = paramInteger.toString();
          String str3 = str2 + " <minSizeY";
          localMASTAdLog1.log(3, 1, "invalid param", str3);
          return this;
        }
        Map localMap2 = this.parameters;
        String str4 = String.valueOf(paramInteger);
        Object localObject3 = localMap2.put("size_y", str4);
      }
      ??? = "invalid param";
      StringBuilder localStringBuilder2 = new StringBuilder("maxSizeY=");
      String str5 = paramInteger.toString();
      String str6 = str5 + " valid>0";
      localMASTAdLog2.log(3, 1, (String)???, str6);
    }
  }

  public AdserverRequest setTestModeEnabled(Boolean paramBoolean)
  {
    if (paramBoolean != null);
    synchronized (this.parameters)
    {
      if (paramBoolean.booleanValue())
      {
        Object localObject1 = this.parameters.put("test", "1");
        return this;
      }
      Object localObject2 = this.parameters.remove("test");
    }
  }

  public AdserverRequest setTrack(Boolean paramBoolean)
  {
    Map localMap = this.parameters;
    if (paramBoolean != null);
    while (true)
    {
      try
      {
        if (paramBoolean.booleanValue())
        {
          Object localObject1 = this.parameters.put("track", "1");
          return this;
        }
        Object localObject2 = this.parameters.put("track", "0");
        continue;
      }
      finally
      {
      }
      Object localObject4 = this.parameters.remove("track");
    }
  }

  public AdserverRequest setType(Integer paramInteger)
  {
    if ((paramInteger == null) || ((paramInteger.intValue() > 0) && (paramInteger.intValue() < 8)));
    while (true)
    {
      synchronized (this.parameters)
      {
        Map localMap2 = this.parameters;
        String str1 = String.valueOf(paramInteger);
        Object localObject1 = localMap2.put("type", str1);
        return this;
      }
      MASTAdLog localMASTAdLog = this.AdLog;
      ??? = null;
      StringBuilder localStringBuilder = new StringBuilder("type=");
      String str2 = paramInteger.toString();
      String str3 = str2 + " (valid: 1<=int<=7, 1 - text, 2 - image, 4 - richmedia ad, set combinations as sum of this values)";
      localMASTAdLog.log(???, 1, "invalid param", str3);
    }
  }

  public AdserverRequest setUa(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("ua", paramString);
      return this;
    }
  }

  public AdserverRequest setVersion(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("version", paramString);
      return this;
    }
  }

  public AdserverRequest setZip(String paramString)
  {
    if (paramString != null);
    synchronized (this.parameters)
    {
      Object localObject1 = this.parameters.put("zip", paramString);
      return this;
    }
  }

  public AdserverRequest setZone(Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() > 0));
    while (true)
    {
      synchronized (this.parameters)
      {
        Map localMap2 = this.parameters;
        String str1 = paramInteger.toString();
        Object localObject1 = localMap2.put("zone", str1);
        return this;
      }
      if ((paramInteger != null) && (paramInteger.intValue() < 1))
      {
        MASTAdLog localMASTAdLog = this.AdLog;
        ??? = null;
        StringBuilder localStringBuilder = new StringBuilder("zone=");
        String str2 = paramInteger.toString();
        String str3 = str2 + " (valid: int>0)";
        localMASTAdLog.log(???, 1, "invalid param", str3);
      }
    }
  }

  // ERROR //
  public String toString()
  {
    // Byte code:
    //   0: new 232	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 186	com/MASTAdView/AdserverRequest:adserverURL	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: astore_3
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: ldc_w 455
    //   27: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: astore 4
    //   32: aconst_null
    //   33: invokestatic 461	com/MASTAdView/ContentManager:getInstance	(Landroid/webkit/WebView;)Lcom/MASTAdView/ContentManager;
    //   36: invokevirtual 464	com/MASTAdView/ContentManager:getAutoDetectParameters	()Ljava/lang/String;
    //   39: astore 5
    //   41: aload_1
    //   42: aload 5
    //   44: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: astore 6
    //   49: aload_0
    //   50: getfield 70	com/MASTAdView/AdserverRequest:parameters	Ljava/util/Map;
    //   53: astore 7
    //   55: aload 7
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 70	com/MASTAdView/AdserverRequest:parameters	Ljava/util/Map;
    //   62: astore 8
    //   64: aload_0
    //   65: aload_1
    //   66: aload 8
    //   68: invokespecial 466	com/MASTAdView/AdserverRequest:appendParameters	(Ljava/lang/StringBuilder;Ljava/util/Map;)V
    //   71: aload 7
    //   73: monitorexit
    //   74: aload_0
    //   75: getfield 285	com/MASTAdView/AdserverRequest:customParameters	Ljava/util/Hashtable;
    //   78: astore 9
    //   80: aload_0
    //   81: aload_1
    //   82: aload 9
    //   84: invokespecial 466	com/MASTAdView/AdserverRequest:appendParameters	(Ljava/lang/StringBuilder;Ljava/util/Map;)V
    //   87: aload_0
    //   88: invokevirtual 468	com/MASTAdView/AdserverRequest:getSizeX	()Ljava/lang/Integer;
    //   91: invokevirtual 305	java/lang/Integer:intValue	()I
    //   94: ifgt +53 -> 147
    //   97: aload_0
    //   98: getfield 61	com/MASTAdView/AdserverRequest:sizeX	I
    //   101: bipush 255
    //   103: if_icmple +44 -> 147
    //   106: new 232	java/lang/StringBuilder
    //   109: dup
    //   110: ldc_w 470
    //   113: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: astore 10
    //   118: aload_0
    //   119: getfield 61	com/MASTAdView/AdserverRequest:sizeX	I
    //   122: invokestatic 472	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   125: astore 11
    //   127: aload 10
    //   129: aload 11
    //   131: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 12
    //   139: aload_1
    //   140: aload 12
    //   142: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: astore 13
    //   147: aload_0
    //   148: invokevirtual 474	com/MASTAdView/AdserverRequest:getSizeY	()Ljava/lang/Integer;
    //   151: invokevirtual 305	java/lang/Integer:intValue	()I
    //   154: ifgt +53 -> 207
    //   157: aload_0
    //   158: getfield 63	com/MASTAdView/AdserverRequest:sizeY	I
    //   161: bipush 255
    //   163: if_icmple +44 -> 207
    //   166: new 232	java/lang/StringBuilder
    //   169: dup
    //   170: ldc_w 476
    //   173: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: astore 14
    //   178: aload_0
    //   179: getfield 63	com/MASTAdView/AdserverRequest:sizeY	I
    //   182: invokestatic 472	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   185: astore 15
    //   187: aload 14
    //   189: aload 15
    //   191: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore 16
    //   199: aload_1
    //   200: aload 16
    //   202: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: astore 17
    //   207: new 232	java/lang/StringBuilder
    //   210: dup
    //   211: ldc_w 478
    //   214: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: astore 18
    //   219: aload_0
    //   220: getfield 65	com/MASTAdView/AdserverRequest:timeout	I
    //   223: invokestatic 472	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   226: astore 19
    //   228: aload 18
    //   230: aload 19
    //   232: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore 20
    //   240: aload_1
    //   241: aload 20
    //   243: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: astore 21
    //   248: aload_1
    //   249: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: areturn
    //   253: astore 22
    //   255: aload_0
    //   256: monitorexit
    //   257: aload 22
    //   259: athrow
    //   260: astore 23
    //   262: aload 7
    //   264: monitorexit
    //   265: aload 23
    //   267: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   10	23	253	finally
    //   255	257	253	finally
    //   58	74	260	finally
    //   262	265	260	finally
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.AdserverRequest
 * JD-Core Version:    0.6.2
 */