package com.google.analytics.tracking.android;

import java.text.DecimalFormat;

class MetaModelInitializer
{
  private static final MetaModel.Formatter BOOLEAN_FORMATTER = new MetaModel.Formatter()
  {
    public String format(String paramAnonymousString)
    {
      if (Utils.safeParseBoolean(paramAnonymousString));
      for (String str = "1"; ; str = "0")
        return str;
    }
  };
  private static final MetaModel.Formatter UP_TO_TWO_DIGIT_FLOAT_FORMATTER = new MetaModel.Formatter()
  {
    private final DecimalFormat floatFormat;

    public String format(String paramAnonymousString)
    {
      DecimalFormat localDecimalFormat = this.floatFormat;
      double d = Utils.safeParseDouble(paramAnonymousString);
      return localDecimalFormat.format(d);
    }
  };

  public static void set(MetaModel paramMetaModel)
  {
    paramMetaModel.addField("apiVersion", "v", null, null);
    paramMetaModel.addField("libraryVersion", "_v", null, null);
    MetaModel.Formatter localFormatter1 = BOOLEAN_FORMATTER;
    paramMetaModel.addField("anonymizeIp", "aip", "0", localFormatter1);
    paramMetaModel.addField("trackingId", "tid", null, null);
    paramMetaModel.addField("hitType", "t", null, null);
    paramMetaModel.addField("sessionControl", "sc", null, null);
    paramMetaModel.addField("adSenseAdMobHitId", "a", null, null);
    paramMetaModel.addField("usage", "_u", null, null);
    paramMetaModel.addField("title", "dt", null, null);
    paramMetaModel.addField("referrer", "dr", null, null);
    paramMetaModel.addField("language", "ul", null, null);
    paramMetaModel.addField("encoding", "de", null, null);
    paramMetaModel.addField("page", "dp", null, null);
    paramMetaModel.addField("screenColors", "sd", null, null);
    paramMetaModel.addField("screenResolution", "sr", null, null);
    paramMetaModel.addField("viewportSize", "vp", null, null);
    MetaModel.Formatter localFormatter2 = BOOLEAN_FORMATTER;
    paramMetaModel.addField("javaEnabled", "je", "1", localFormatter2);
    paramMetaModel.addField("flashVersion", "fl", null, null);
    paramMetaModel.addField("clientId", "cid", null, null);
    paramMetaModel.addField("campaignName", "cn", null, null);
    paramMetaModel.addField("campaignSource", "cs", null, null);
    paramMetaModel.addField("campaignMedium", "cm", null, null);
    paramMetaModel.addField("campaignKeyword", "ck", null, null);
    paramMetaModel.addField("campaignContent", "cc", null, null);
    paramMetaModel.addField("campaignId", "ci", null, null);
    paramMetaModel.addField("gclid", "gclid", null, null);
    paramMetaModel.addField("dclid", "dclid", null, null);
    paramMetaModel.addField("gmob_t", "gmob_t", null, null);
    paramMetaModel.addField("eventCategory", "ec", null, null);
    paramMetaModel.addField("eventAction", "ea", null, null);
    paramMetaModel.addField("eventLabel", "el", null, null);
    paramMetaModel.addField("eventValue", "ev", null, null);
    MetaModel.Formatter localFormatter3 = BOOLEAN_FORMATTER;
    paramMetaModel.addField("nonInteraction", "ni", "0", localFormatter3);
    paramMetaModel.addField("socialNetwork", "sn", null, null);
    paramMetaModel.addField("socialAction", "sa", null, null);
    paramMetaModel.addField("socialTarget", "st", null, null);
    paramMetaModel.addField("appName", "an", null, null);
    paramMetaModel.addField("appVersion", "av", null, null);
    paramMetaModel.addField("description", "cd", null, null);
    paramMetaModel.addField("appId", "aid", null, null);
    paramMetaModel.addField("appInstallerId", "aiid", null, null);
    paramMetaModel.addField("transactionId", "ti", null, null);
    paramMetaModel.addField("transactionAffiliation", "ta", null, null);
    paramMetaModel.addField("transactionShipping", "ts", null, null);
    paramMetaModel.addField("transactionTotal", "tr", null, null);
    paramMetaModel.addField("transactionTax", "tt", null, null);
    paramMetaModel.addField("currencyCode", "cu", null, null);
    paramMetaModel.addField("itemPrice", "ip", null, null);
    paramMetaModel.addField("itemCode", "ic", null, null);
    paramMetaModel.addField("itemName", "in", null, null);
    paramMetaModel.addField("itemCategory", "iv", null, null);
    paramMetaModel.addField("itemQuantity", "iq", null, null);
    paramMetaModel.addField("exDescription", "exd", null, null);
    MetaModel.Formatter localFormatter4 = BOOLEAN_FORMATTER;
    paramMetaModel.addField("exFatal", "exf", "1", localFormatter4);
    paramMetaModel.addField("timingVar", "utv", null, null);
    paramMetaModel.addField("timingValue", "utt", null, null);
    paramMetaModel.addField("timingCategory", "utc", null, null);
    paramMetaModel.addField("timingLabel", "utl", null, null);
    MetaModel.Formatter localFormatter5 = UP_TO_TWO_DIGIT_FLOAT_FORMATTER;
    paramMetaModel.addField("sampleRate", "sf", "100", localFormatter5);
    paramMetaModel.addField("customDimension", "cd", null, null);
    paramMetaModel.addField("customMetric", "cm", null, null);
    paramMetaModel.addField("contentGrouping", "cg", null, null);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.MetaModelInitializer
 * JD-Core Version:    0.6.2
 */