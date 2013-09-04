package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleTracker
  implements Tracker
{
  private static final DecimalFormat DF = new DecimalFormat("0.######", localDecimalFormatSymbols);
  private volatile ExceptionParser exceptionParser;
  private final TrackerHandler handler;
  private final SimpleModel model;
  private volatile boolean trackerClosed = false;
  private volatile boolean trackingStarted = false;

  static
  {
    Locale localLocale = Locale.US;
    DecimalFormatSymbols localDecimalFormatSymbols = new DecimalFormatSymbols(localLocale);
  }

  GoogleTracker(String paramString, TrackerHandler paramTrackerHandler)
  {
    if (paramString == null)
      throw new IllegalArgumentException("trackingId cannot be null");
    this.handler = paramTrackerHandler;
    SimpleModel localSimpleModel = new SimpleModel(null);
    this.model = localSimpleModel;
    this.model.set("trackingId", paramString);
    this.model.set("sampleRate", "100");
    this.model.setForNextHit("sessionControl", "start");
  }

  private void assertTrackerOpen()
  {
    if (!this.trackerClosed)
      return;
    throw new IllegalStateException("Tracker closed");
  }

  private void internalSend(String paramString, Map<String, String> paramMap)
  {
    this.trackingStarted = true;
    if (paramMap == null)
      paramMap = new HashMap();
    Object localObject = paramMap.put("hitType", paramString);
    SimpleModel localSimpleModel = this.model;
    Boolean localBoolean = Boolean.valueOf(true);
    localSimpleModel.setAll(paramMap, localBoolean);
    TrackerHandler localTrackerHandler = this.handler;
    Map localMap = this.model.getKeysAndValues();
    localTrackerHandler.sendHit(localMap);
    this.model.clearTemporaryValues();
  }

  private static String microsToCurrencyString(long paramLong)
  {
    DecimalFormat localDecimalFormat = DF;
    double d = paramLong / 1000000.0D;
    return localDecimalFormat.format(d);
  }

  public boolean anonymizeIpEnabled()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_ANONYMIZE_IP;
    localGAUsage.setUsage(localField);
    return Utils.safeParseBoolean(this.model.get("anonymizeIp"));
  }

  public void close()
  {
    this.trackerClosed = true;
    this.handler.closeTracker(this);
  }

  public Map<String, String> constructEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = localHashMap.put("eventCategory", paramString1);
    Object localObject2 = localHashMap.put("eventAction", paramString2);
    Object localObject3 = localHashMap.put("eventLabel", paramString3);
    if (paramLong != null)
    {
      String str = Long.toString(paramLong.longValue());
      Object localObject4 = localHashMap.put("eventValue", str);
    }
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.CONSTRUCT_EVENT;
    localGAUsage.setUsage(localField);
    return localHashMap;
  }

  public Map<String, String> constructException(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = localHashMap.put("exDescription", paramString);
    String str = Boolean.toString(paramBoolean);
    Object localObject2 = localHashMap.put("exFatal", str);
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.CONSTRUCT_EXCEPTION;
    localGAUsage.setUsage(localField);
    return localHashMap;
  }

  Map<String, String> constructItem(Item paramItem, Transaction paramTransaction)
  {
    HashMap localHashMap = new HashMap();
    String str1 = paramTransaction.getTransactionId();
    Object localObject1 = localHashMap.put("transactionId", str1);
    String str2 = paramTransaction.getCurrencyCode();
    Object localObject2 = localHashMap.put("currencyCode", str2);
    String str3 = paramItem.getProductSKU();
    Object localObject3 = localHashMap.put("itemCode", str3);
    String str4 = paramItem.getProductName();
    Object localObject4 = localHashMap.put("itemName", str4);
    String str5 = paramItem.getProductCategory();
    Object localObject5 = localHashMap.put("itemCategory", str5);
    String str6 = microsToCurrencyString(paramItem.getItemPriceInMicros());
    Object localObject6 = localHashMap.put("itemPrice", str6);
    String str7 = Long.toString(paramItem.getItemQuantity());
    Object localObject7 = localHashMap.put("itemQuantity", str7);
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.CONSTRUCT_ITEM;
    localGAUsage.setUsage(localField);
    return localHashMap;
  }

  public Map<String, String> constructRawException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramThrowable);
    localObjectOutputStream.close();
    String str1 = Utils.hexEncode(localByteArrayOutputStream.toByteArray());
    Object localObject1 = localHashMap.put("rawException", str1);
    if (paramString != null)
      Object localObject2 = localHashMap.put("exceptionThreadName", paramString);
    String str2 = Boolean.toString(paramBoolean);
    Object localObject3 = localHashMap.put("exFatal", str2);
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.CONSTRUCT_RAW_EXCEPTION;
    localGAUsage.setUsage(localField);
    return localHashMap;
  }

  public Map<String, String> constructSocial(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = localHashMap.put("socialNetwork", paramString1);
    Object localObject2 = localHashMap.put("socialAction", paramString2);
    Object localObject3 = localHashMap.put("socialTarget", paramString3);
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.CONSTRUCT_SOCIAL;
    localGAUsage.setUsage(localField);
    return localHashMap;
  }

  public Map<String, String> constructTiming(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = localHashMap.put("timingCategory", paramString1);
    String str = Long.toString(paramLong);
    Object localObject2 = localHashMap.put("timingValue", str);
    Object localObject3 = localHashMap.put("timingVar", paramString2);
    Object localObject4 = localHashMap.put("timingLabel", paramString3);
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.CONSTRUCT_TIMING;
    localGAUsage.setUsage(localField);
    return localHashMap;
  }

  public Map<String, String> constructTransaction(Transaction paramTransaction)
  {
    HashMap localHashMap = new HashMap();
    String str1 = paramTransaction.getTransactionId();
    Object localObject1 = localHashMap.put("transactionId", str1);
    String str2 = paramTransaction.getAffiliation();
    Object localObject2 = localHashMap.put("transactionAffiliation", str2);
    String str3 = microsToCurrencyString(paramTransaction.getShippingCostInMicros());
    Object localObject3 = localHashMap.put("transactionShipping", str3);
    String str4 = microsToCurrencyString(paramTransaction.getTotalTaxInMicros());
    Object localObject4 = localHashMap.put("transactionTax", str4);
    String str5 = microsToCurrencyString(paramTransaction.getTotalCostInMicros());
    Object localObject5 = localHashMap.put("transactionTotal", str5);
    String str6 = paramTransaction.getCurrencyCode();
    Object localObject6 = localHashMap.put("currencyCode", str6);
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.CONSTRUCT_TRANSACTION;
    localGAUsage.setUsage(localField);
    return localHashMap;
  }

  public String get(String paramString)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET;
    localGAUsage.setUsage(localField);
    return this.model.get(paramString);
  }

  public String getAppId()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_APP_ID;
    localGAUsage.setUsage(localField);
    return this.model.get("appId");
  }

  public String getAppInstallerId()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_APP_INSTALLER_ID;
    localGAUsage.setUsage(localField);
    return this.model.get("appInstallerId");
  }

  public ExceptionParser getExceptionParser()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_EXCEPTION_PARSER;
    localGAUsage.setUsage(localField);
    return this.exceptionParser;
  }

  public double getSampleRate()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_SAMPLE_RATE;
    localGAUsage.setUsage(localField);
    return Utils.safeParseDouble(this.model.get("sampleRate"));
  }

  public String getTrackingId()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_TRACKING_ID;
    localGAUsage.setUsage(localField);
    return this.model.get("trackingId");
  }

  public boolean getUseSecure()
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.GET_USE_SECURE;
    localGAUsage.setUsage(localField);
    return Boolean.parseBoolean(this.model.get("useSecure"));
  }

  public void send(String paramString, Map<String, String> paramMap)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SEND;
    localGAUsage.setUsage(localField);
    internalSend(paramString, paramMap);
  }

  public void set(String paramString1, String paramString2)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET;
    localGAUsage.setUsage(localField);
    this.model.set(paramString1, paramString2);
  }

  public void setAnonymizeIp(boolean paramBoolean)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_ANONYMIZE_IP;
    localGAUsage.setUsage(localField);
    SimpleModel localSimpleModel = this.model;
    String str = Boolean.toString(paramBoolean);
    localSimpleModel.set("anonymizeIp", str);
  }

  public void setAppId(String paramString)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_APP_ID;
    localGAUsage.setUsage(localField);
    this.model.set("appId", paramString);
  }

  public void setAppInstallerId(String paramString)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_APP_INSTALLER_ID;
    localGAUsage.setUsage(localField);
    this.model.set("appInstallerId", paramString);
  }

  public void setAppName(String paramString)
  {
    if (this.trackingStarted)
    {
      int i = Log.wDebug("Tracking already started, setAppName call ignored");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      int j = Log.wDebug("setting appName to empty value not allowed, call ignored");
      return;
    }
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_APP_NAME;
    localGAUsage.setUsage(localField);
    this.model.set("appName", paramString);
  }

  public void setAppScreen(String paramString)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_APP_SCREEN;
    localGAUsage.setUsage(localField);
    this.model.set("description", paramString);
  }

  public void setAppVersion(String paramString)
  {
    if (this.trackingStarted)
    {
      int i = Log.wDebug("Tracking already started, setAppVersion call ignored");
      return;
    }
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_APP_VERSION;
    localGAUsage.setUsage(localField);
    this.model.set("appVersion", paramString);
  }

  public void setCampaign(String paramString)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_CAMPAIGN;
    localGAUsage.setUsage(localField);
    this.model.setForNextHit("campaign", paramString);
  }

  public void setCustomDimension(int paramInt, String paramString)
  {
    if (paramInt < 1)
    {
      int i = Log.w("slot must be > 0, ignoring setCustomDimension call for " + paramInt + ", " + paramString);
      return;
    }
    SimpleModel localSimpleModel = this.model;
    String str = Utils.getSlottedModelField("customDimension", paramInt);
    localSimpleModel.setForNextHit(str, paramString);
  }

  public void setCustomDimensionsAndMetrics(Map<Integer, String> paramMap, Map<Integer, Long> paramMap1)
  {
    if (paramMap != null)
    {
      localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger1 = (Integer)localIterator.next();
        int i = localInteger1.intValue();
        String str = (String)paramMap.get(localInteger1);
        setCustomDimension(i, str);
      }
    }
    if (paramMap1 == null)
      return;
    Iterator localIterator = paramMap1.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Integer localInteger2 = (Integer)localIterator.next();
      int j = localInteger2.intValue();
      Long localLong = (Long)paramMap1.get(localInteger2);
      setCustomMetric(j, localLong);
    }
  }

  public void setCustomMetric(int paramInt, Long paramLong)
  {
    if (paramInt < 1)
    {
      int i = Log.w("slot must be > 0, ignoring setCustomMetric call for " + paramInt + ", " + paramLong);
      return;
    }
    String str1 = null;
    if (paramLong != null)
      str1 = Long.toString(paramLong.longValue());
    SimpleModel localSimpleModel = this.model;
    String str2 = Utils.getSlottedModelField("customMetric", paramInt);
    localSimpleModel.setForNextHit(str2, str1);
  }

  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_EXCEPTION_PARSER;
    localGAUsage.setUsage(localField);
    this.exceptionParser = paramExceptionParser;
  }

  public void setReferrer(String paramString)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_REFERRER;
    localGAUsage.setUsage(localField);
    this.model.setForNextHit("referrer", paramString);
  }

  public void setSampleRate(double paramDouble)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_SAMPLE_RATE;
    localGAUsage.setUsage(localField);
    SimpleModel localSimpleModel = this.model;
    String str = Double.toString(paramDouble);
    localSimpleModel.set("sampleRate", str);
  }

  public void setStartSession(boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_START_SESSION;
    localGAUsage.setUsage(localField);
    SimpleModel localSimpleModel = this.model;
    if (paramBoolean);
    for (String str = "start"; ; str = null)
    {
      localSimpleModel.setForNextHit("sessionControl", str);
      return;
    }
  }

  public void setUseSecure(boolean paramBoolean)
  {
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.SET_USE_SECURE;
    localGAUsage.setUsage(localField);
    SimpleModel localSimpleModel = this.model;
    String str = Boolean.toString(paramBoolean);
    localSimpleModel.set("useSecure", str);
  }

  public void trackEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_EVENT;
    localGAUsage.setUsage(localField);
    GAUsage.getInstance().setDisableUsage(true);
    Map localMap = constructEvent(paramString1, paramString2, paramString3, paramLong);
    internalSend("event", localMap);
    GAUsage.getInstance().setDisableUsage(false);
  }

  public void trackException(String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_EXCEPTION_WITH_THROWABLE;
    localGAUsage.setUsage(localField);
    String str;
    if (this.exceptionParser != null)
      str = this.exceptionParser.getDescription(paramString, paramThrowable);
    while (true)
    {
      GAUsage.getInstance().setDisableUsage(true);
      trackException(str, paramBoolean);
      GAUsage.getInstance().setDisableUsage(false);
      return;
      try
      {
        GAUsage.getInstance().setDisableUsage(true);
        Map localMap = constructRawException(paramString, paramThrowable, paramBoolean);
        internalSend("exception", localMap);
        GAUsage.getInstance().setDisableUsage(false);
        return;
      }
      catch (IOException localIOException)
      {
        int i = Log.w("trackException: couldn't serialize, sending \"Unknown Exception\"");
        str = "Unknown Exception";
      }
    }
  }

  public void trackException(String paramString, boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_EXCEPTION_WITH_DESCRIPTION;
    localGAUsage.setUsage(localField);
    GAUsage.getInstance().setDisableUsage(true);
    Map localMap = constructException(paramString, paramBoolean);
    internalSend("exception", localMap);
    GAUsage.getInstance().setDisableUsage(false);
  }

  public void trackSocial(String paramString1, String paramString2, String paramString3)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_SOCIAL;
    localGAUsage.setUsage(localField);
    GAUsage.getInstance().setDisableUsage(true);
    Map localMap = constructSocial(paramString1, paramString2, paramString3);
    internalSend("social", localMap);
    GAUsage.getInstance().setDisableUsage(false);
  }

  public void trackTiming(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_TIMING;
    localGAUsage.setUsage(localField);
    GAUsage.getInstance().setDisableUsage(true);
    Map localMap = constructTiming(paramString1, paramLong, paramString2, paramString3);
    internalSend("timing", localMap);
    GAUsage.getInstance().setDisableUsage(false);
  }

  public void trackTransaction(Transaction paramTransaction)
  {
    assertTrackerOpen();
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_TRANSACTION;
    localGAUsage.setUsage(localField);
    GAUsage.getInstance().setDisableUsage(true);
    Map localMap1 = constructTransaction(paramTransaction);
    internalSend("tran", localMap1);
    Iterator localIterator = paramTransaction.getItems().iterator();
    while (localIterator.hasNext())
    {
      Item localItem = (Item)localIterator.next();
      Map localMap2 = constructItem(localItem, paramTransaction);
      internalSend("item", localMap2);
    }
    GAUsage.getInstance().setDisableUsage(false);
  }

  public void trackView()
  {
    assertTrackerOpen();
    if (TextUtils.isEmpty(this.model.get("description")))
      throw new IllegalStateException("trackView requires a appScreen to be set");
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_VIEW;
    localGAUsage.setUsage(localField);
    internalSend("appview", null);
  }

  public void trackView(String paramString)
  {
    assertTrackerOpen();
    if (TextUtils.isEmpty(paramString))
      throw new IllegalStateException("trackView requires a appScreen to be set");
    GAUsage localGAUsage = GAUsage.getInstance();
    GAUsage.Field localField = GAUsage.Field.TRACK_VIEW_WITH_APPSCREEN;
    localGAUsage.setUsage(localField);
    this.model.set("description", paramString);
    internalSend("appview", null);
  }

  private static class SimpleModel
  {
    private Map<String, String> permanentMap;
    private Map<String, String> temporaryMap;

    private SimpleModel()
    {
      HashMap localHashMap1 = new HashMap();
      this.temporaryMap = localHashMap1;
      HashMap localHashMap2 = new HashMap();
      this.permanentMap = localHashMap2;
    }

    /** @deprecated */
    public void clearTemporaryValues()
    {
      try
      {
        this.temporaryMap.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    /** @deprecated */
    public String get(String paramString)
    {
      try
      {
        Object localObject1 = (String)this.temporaryMap.get(paramString);
        if (localObject1 != null);
        while (true)
        {
          return localObject1;
          String str = (String)this.permanentMap.get(paramString);
          localObject1 = str;
        }
      }
      finally
      {
      }
    }

    /** @deprecated */
    public Map<String, String> getKeysAndValues()
    {
      try
      {
        Map localMap1 = this.permanentMap;
        HashMap localHashMap = new HashMap(localMap1);
        Map localMap2 = this.temporaryMap;
        localHashMap.putAll(localMap2);
        return localHashMap;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    /** @deprecated */
    public void set(String paramString1, String paramString2)
    {
      try
      {
        Object localObject1 = this.permanentMap.put(paramString1, paramString2);
        return;
      }
      finally
      {
        localObject2 = finally;
        throw localObject2;
      }
    }

    /** @deprecated */
    public void setAll(Map<String, String> paramMap, Boolean paramBoolean)
    {
      try
      {
        if (paramBoolean.booleanValue())
          this.temporaryMap.putAll(paramMap);
        while (true)
        {
          return;
          this.permanentMap.putAll(paramMap);
        }
      }
      finally
      {
      }
    }

    /** @deprecated */
    public void setForNextHit(String paramString1, String paramString2)
    {
      try
      {
        Object localObject1 = this.temporaryMap.put(paramString1, paramString2);
        return;
      }
      finally
      {
        localObject2 = finally;
        throw localObject2;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GoogleTracker
 * JD-Core Version:    0.6.2
 */