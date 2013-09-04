package com.google.analytics.tracking.android;

import java.util.SortedSet;
import java.util.TreeSet;

class GAUsage
{
  private static final String BASE_64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
  private static final GAUsage INSTANCE = new GAUsage();
  private boolean disableUsage;
  private StringBuilder sequence;
  private SortedSet<Field> usedFields;

  private GAUsage()
  {
    TreeSet localTreeSet = new TreeSet();
    this.usedFields = localTreeSet;
    StringBuilder localStringBuilder = new StringBuilder();
    this.sequence = localStringBuilder;
    this.disableUsage = false;
  }

  public static GAUsage getInstance()
  {
    return INSTANCE;
  }

  static GAUsage getPrivateInstance()
  {
    return new GAUsage();
  }

  /** @deprecated */
  public String getAndClearSequence()
  {
    try
    {
      if (this.sequence.length() > 0)
        StringBuilder localStringBuilder1 = this.sequence.insert(0, ".");
      String str = this.sequence.toString();
      StringBuilder localStringBuilder2 = new StringBuilder();
      this.sequence = localStringBuilder2;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public String getAndClearUsage()
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i = 0;
      int j = 6;
      while (this.usedFields.size() > 0)
      {
        Field localField = (Field)this.usedFields.first();
        boolean bool = this.usedFields.remove(localField);
        int k = localField.ordinal();
        while (k >= j)
        {
          char c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i);
          StringBuilder localStringBuilder2 = localStringBuilder1.append(c1);
          i = 0;
          j += 6;
        }
        int m = localField.ordinal() % 6;
        int n = 1 << m;
        i += n;
      }
      if ((i > 0) || (localStringBuilder1.length() == 0))
      {
        char c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i);
        StringBuilder localStringBuilder3 = localStringBuilder1.append(c2);
      }
      this.usedFields.clear();
      String str1 = localStringBuilder1.toString();
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
  public void setDisableUsage(boolean paramBoolean)
  {
    try
    {
      this.disableUsage = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public void setUsage(Field paramField)
  {
    try
    {
      if (!this.disableUsage)
      {
        boolean bool = this.usedFields.add(paramField);
        StringBuilder localStringBuilder1 = this.sequence;
        int i = paramField.ordinal();
        char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(c);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static enum Field
  {
    static
    {
      TRACK_EVENT = new Field("TRACK_EVENT", 2);
      TRACK_TRANSACTION = new Field("TRACK_TRANSACTION", 3);
      TRACK_EXCEPTION_WITH_DESCRIPTION = new Field("TRACK_EXCEPTION_WITH_DESCRIPTION", 4);
      TRACK_EXCEPTION_WITH_THROWABLE = new Field("TRACK_EXCEPTION_WITH_THROWABLE", 5);
      BLANK_06 = new Field("BLANK_06", 6);
      TRACK_TIMING = new Field("TRACK_TIMING", 7);
      TRACK_SOCIAL = new Field("TRACK_SOCIAL", 8);
      GET = new Field("GET", 9);
      SET = new Field("SET", 10);
      SEND = new Field("SEND", 11);
      SET_START_SESSION = new Field("SET_START_SESSION", 12);
      BLANK_13 = new Field("BLANK_13", 13);
      SET_APP_NAME = new Field("SET_APP_NAME", 14);
      BLANK_15 = new Field("BLANK_15", 15);
      SET_APP_VERSION = new Field("SET_APP_VERSION", 16);
      BLANK_17 = new Field("BLANK_17", 17);
      SET_APP_SCREEN = new Field("SET_APP_SCREEN", 18);
      GET_TRACKING_ID = new Field("GET_TRACKING_ID", 19);
      SET_ANONYMIZE_IP = new Field("SET_ANONYMIZE_IP", 20);
      GET_ANONYMIZE_IP = new Field("GET_ANONYMIZE_IP", 21);
      SET_SAMPLE_RATE = new Field("SET_SAMPLE_RATE", 22);
      GET_SAMPLE_RATE = new Field("GET_SAMPLE_RATE", 23);
      SET_USE_SECURE = new Field("SET_USE_SECURE", 24);
      GET_USE_SECURE = new Field("GET_USE_SECURE", 25);
      SET_REFERRER = new Field("SET_REFERRER", 26);
      SET_CAMPAIGN = new Field("SET_CAMPAIGN", 27);
      SET_APP_ID = new Field("SET_APP_ID", 28);
      GET_APP_ID = new Field("GET_APP_ID", 29);
      SET_EXCEPTION_PARSER = new Field("SET_EXCEPTION_PARSER", 30);
      GET_EXCEPTION_PARSER = new Field("GET_EXCEPTION_PARSER", 31);
      CONSTRUCT_TRANSACTION = new Field("CONSTRUCT_TRANSACTION", 32);
      CONSTRUCT_EXCEPTION = new Field("CONSTRUCT_EXCEPTION", 33);
      CONSTRUCT_RAW_EXCEPTION = new Field("CONSTRUCT_RAW_EXCEPTION", 34);
      CONSTRUCT_TIMING = new Field("CONSTRUCT_TIMING", 35);
      CONSTRUCT_SOCIAL = new Field("CONSTRUCT_SOCIAL", 36);
      SET_DEBUG = new Field("SET_DEBUG", 37);
      GET_DEBUG = new Field("GET_DEBUG", 38);
      GET_TRACKER = new Field("GET_TRACKER", 39);
      GET_DEFAULT_TRACKER = new Field("GET_DEFAULT_TRACKER", 40);
      SET_DEFAULT_TRACKER = new Field("SET_DEFAULT_TRACKER", 41);
      SET_APP_OPT_OUT = new Field("SET_APP_OPT_OUT", 42);
      REQUEST_APP_OPT_OUT = new Field("REQUEST_APP_OPT_OUT", 43);
      DISPATCH = new Field("DISPATCH", 44);
      SET_DISPATCH_PERIOD = new Field("SET_DISPATCH_PERIOD", 45);
      BLANK_48 = new Field("BLANK_48", 46);
      REPORT_UNCAUGHT_EXCEPTIONS = new Field("REPORT_UNCAUGHT_EXCEPTIONS", 47);
      SET_AUTO_ACTIVITY_TRACKING = new Field("SET_AUTO_ACTIVITY_TRACKING", 48);
      SET_SESSION_TIMEOUT = new Field("SET_SESSION_TIMEOUT", 49);
      CONSTRUCT_EVENT = new Field("CONSTRUCT_EVENT", 50);
      CONSTRUCT_ITEM = new Field("CONSTRUCT_ITEM", 51);
      SET_APP_INSTALLER_ID = new Field("SET_APP_INSTALLER_ID", 52);
      GET_APP_INSTALLER_ID = new Field("GET_APP_INSTALLER_ID", 53);
      Field[] arrayOfField = new Field[54];
      Field localField1 = TRACK_VIEW;
      arrayOfField[0] = localField1;
      Field localField2 = TRACK_VIEW_WITH_APPSCREEN;
      arrayOfField[1] = localField2;
      Field localField3 = TRACK_EVENT;
      arrayOfField[2] = localField3;
      Field localField4 = TRACK_TRANSACTION;
      arrayOfField[3] = localField4;
      Field localField5 = TRACK_EXCEPTION_WITH_DESCRIPTION;
      arrayOfField[4] = localField5;
      Field localField6 = TRACK_EXCEPTION_WITH_THROWABLE;
      arrayOfField[5] = localField6;
      Field localField7 = BLANK_06;
      arrayOfField[6] = localField7;
      Field localField8 = TRACK_TIMING;
      arrayOfField[7] = localField8;
      Field localField9 = TRACK_SOCIAL;
      arrayOfField[8] = localField9;
      Field localField10 = GET;
      arrayOfField[9] = localField10;
      Field localField11 = SET;
      arrayOfField[10] = localField11;
      Field localField12 = SEND;
      arrayOfField[11] = localField12;
      Field localField13 = SET_START_SESSION;
      arrayOfField[12] = localField13;
      Field localField14 = BLANK_13;
      arrayOfField[13] = localField14;
      Field localField15 = SET_APP_NAME;
      arrayOfField[14] = localField15;
      Field localField16 = BLANK_15;
      arrayOfField[15] = localField16;
      Field localField17 = SET_APP_VERSION;
      arrayOfField[16] = localField17;
      Field localField18 = BLANK_17;
      arrayOfField[17] = localField18;
      Field localField19 = SET_APP_SCREEN;
      arrayOfField[18] = localField19;
      Field localField20 = GET_TRACKING_ID;
      arrayOfField[19] = localField20;
      Field localField21 = SET_ANONYMIZE_IP;
      arrayOfField[20] = localField21;
      Field localField22 = GET_ANONYMIZE_IP;
      arrayOfField[21] = localField22;
      Field localField23 = SET_SAMPLE_RATE;
      arrayOfField[22] = localField23;
      Field localField24 = GET_SAMPLE_RATE;
      arrayOfField[23] = localField24;
      Field localField25 = SET_USE_SECURE;
      arrayOfField[24] = localField25;
      Field localField26 = GET_USE_SECURE;
      arrayOfField[25] = localField26;
      Field localField27 = SET_REFERRER;
      arrayOfField[26] = localField27;
      Field localField28 = SET_CAMPAIGN;
      arrayOfField[27] = localField28;
      Field localField29 = SET_APP_ID;
      arrayOfField[28] = localField29;
      Field localField30 = GET_APP_ID;
      arrayOfField[29] = localField30;
      Field localField31 = SET_EXCEPTION_PARSER;
      arrayOfField[30] = localField31;
      Field localField32 = GET_EXCEPTION_PARSER;
      arrayOfField[31] = localField32;
      Field localField33 = CONSTRUCT_TRANSACTION;
      arrayOfField[32] = localField33;
      Field localField34 = CONSTRUCT_EXCEPTION;
      arrayOfField[33] = localField34;
      Field localField35 = CONSTRUCT_RAW_EXCEPTION;
      arrayOfField[34] = localField35;
      Field localField36 = CONSTRUCT_TIMING;
      arrayOfField[35] = localField36;
      Field localField37 = CONSTRUCT_SOCIAL;
      arrayOfField[36] = localField37;
      Field localField38 = SET_DEBUG;
      arrayOfField[37] = localField38;
      Field localField39 = GET_DEBUG;
      arrayOfField[38] = localField39;
      Field localField40 = GET_TRACKER;
      arrayOfField[39] = localField40;
      Field localField41 = GET_DEFAULT_TRACKER;
      arrayOfField[40] = localField41;
      Field localField42 = SET_DEFAULT_TRACKER;
      arrayOfField[41] = localField42;
      Field localField43 = SET_APP_OPT_OUT;
      arrayOfField[42] = localField43;
      Field localField44 = REQUEST_APP_OPT_OUT;
      arrayOfField[43] = localField44;
      Field localField45 = DISPATCH;
      arrayOfField[44] = localField45;
      Field localField46 = SET_DISPATCH_PERIOD;
      arrayOfField[45] = localField46;
      Field localField47 = BLANK_48;
      arrayOfField[46] = localField47;
      Field localField48 = REPORT_UNCAUGHT_EXCEPTIONS;
      arrayOfField[47] = localField48;
      Field localField49 = SET_AUTO_ACTIVITY_TRACKING;
      arrayOfField[48] = localField49;
      Field localField50 = SET_SESSION_TIMEOUT;
      arrayOfField[49] = localField50;
      Field localField51 = CONSTRUCT_EVENT;
      arrayOfField[50] = localField51;
      Field localField52 = CONSTRUCT_ITEM;
      arrayOfField[51] = localField52;
      Field localField53 = SET_APP_INSTALLER_ID;
      arrayOfField[52] = localField53;
      Field localField54 = GET_APP_INSTALLER_ID;
      arrayOfField[53] = localField54;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAUsage
 * JD-Core Version:    0.6.2
 */