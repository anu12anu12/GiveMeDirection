package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils
{
  private static final char[] HEXBYTES = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };

  public static String filterCampaign(String paramString)
  {
    String str1 = null;
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return str1;
      Object localObject = paramString;
      if (paramString.contains("?"))
        String str2 = paramString.split("[\\?]")[1];
      if (((String)localObject).contains("%3D"));
      StringBuilder localStringBuilder1;
      while (true)
      {
        try
        {
          String str3 = URLDecoder.decode((String)localObject, "UTF-8");
          localObject = str3;
          Map localMap = parseURLParameters((String)localObject);
          String[] arrayOfString = new String[9];
          arrayOfString[0] = "dclid";
          arrayOfString[1] = "utm_source";
          arrayOfString[2] = "gclid";
          arrayOfString[3] = "utm_campaign";
          arrayOfString[4] = "utm_medium";
          arrayOfString[5] = "utm_term";
          arrayOfString[6] = "utm_content";
          arrayOfString[7] = "utm_id";
          arrayOfString[8] = "gmob_t";
          localStringBuilder1 = new StringBuilder();
          int i = 0;
          int j = arrayOfString.length;
          if (i >= j)
            break label264;
          String str4 = arrayOfString[i];
          if (!TextUtils.isEmpty((CharSequence)localMap.get(str4)))
          {
            if (localStringBuilder1.length() > 0)
              StringBuilder localStringBuilder2 = localStringBuilder1.append("&");
            String str5 = arrayOfString[i];
            StringBuilder localStringBuilder3 = localStringBuilder1.append(str5).append("=");
            String str6 = arrayOfString[i];
            String str7 = (String)localMap.get(str6);
            StringBuilder localStringBuilder4 = localStringBuilder3.append(str7);
          }
          i += 1;
          continue;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
        }
        break;
        if (!((String)localObject).contains("="))
          break;
      }
      label264: str1 = localStringBuilder1.toString();
    }
  }

  static int fromHexDigit(char paramChar)
  {
    int i = paramChar + '￐';
    if (i > 9)
      i += -7;
    return i;
  }

  static String getLanguage(Locale paramLocale)
  {
    String str1 = null;
    if (paramLocale == null);
    while (true)
    {
      return str1;
      if (!TextUtils.isEmpty(paramLocale.getLanguage()))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str2 = paramLocale.getLanguage().toLowerCase();
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
        if (!TextUtils.isEmpty(paramLocale.getCountry()))
        {
          StringBuilder localStringBuilder3 = localStringBuilder1.append("-");
          String str3 = paramLocale.getCountry().toLowerCase();
          StringBuilder localStringBuilder4 = localStringBuilder3.append(str3);
        }
        str1 = localStringBuilder1.toString();
      }
    }
  }

  static String getSlottedModelField(String paramString, int paramInt)
  {
    return paramString + "*" + paramInt;
  }

  static byte[] hexDecode(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (true)
    {
      int j = arrayOfByte.length;
      if (i >= j)
        break;
      int k = i * 2;
      int m = fromHexDigit(paramString.charAt(k)) << 4;
      int n = i * 2 + 1;
      int i1 = fromHexDigit(paramString.charAt(n));
      int i2 = (byte)(m | i1);
      arrayOfByte[i] = i2;
      i += 1;
    }
    return arrayOfByte;
  }

  static String hexEncode(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (true)
    {
      int j = paramArrayOfByte.length;
      if (i >= j)
        break;
      int k = paramArrayOfByte[i] & 0xFF;
      int m = i * 2;
      char[] arrayOfChar2 = HEXBYTES;
      int n = k >> 4;
      int i1 = arrayOfChar2[n];
      arrayOfChar1[m] = i1;
      int i2 = i * 2 + 1;
      char[] arrayOfChar3 = HEXBYTES;
      int i3 = k & 0xF;
      int i4 = arrayOfChar3[i3];
      arrayOfChar1[i2] = i4;
      i += 1;
    }
    return new String(arrayOfChar1);
  }

  public static Map<String, String> parseURLParameters(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramString.split("&");
    int i = arrayOfString1.length;
    int j = 0;
    if (j < i)
    {
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length > 1)
      {
        String str1 = arrayOfString2[0];
        String str2 = arrayOfString2[1];
        Object localObject1 = localHashMap.put(str1, str2);
      }
      while (true)
      {
        j += 1;
        break;
        if ((arrayOfString2.length == 1) && (arrayOfString2[0].length() != 0))
        {
          String str3 = arrayOfString2[0];
          Object localObject2 = localHashMap.put(str3, null);
        }
      }
    }
    return localHashMap;
  }

  public static boolean safeParseBoolean(String paramString)
  {
    return Boolean.parseBoolean(paramString);
  }

  public static double safeParseDouble(String paramString)
  {
    double d1 = 0.0D;
    if (paramString == null);
    while (true)
    {
      return d1;
      try
      {
        double d2 = Double.parseDouble(paramString);
        d1 = d2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public static long safeParseLong(String paramString)
  {
    long l1 = 0L;
    if (paramString == null);
    while (true)
    {
      return l1;
      try
      {
        long l2 = Long.parseLong(paramString);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Utils
 * JD-Core Version:    0.6.2
 */