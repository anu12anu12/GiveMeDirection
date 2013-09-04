package com.MASTAdView.ormma.util;

import android.os.Bundle;

public class OrmmaUtils
{
  private static final String CHAR_SET = "ISO-8859-1";

  public static String byteToHex(byte paramByte)
  {
    char[] arrayOfChar1 = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    char[] arrayOfChar2 = new char[2];
    int i = paramByte >> 4 & 0xF;
    int j = arrayOfChar1[i];
    arrayOfChar2[0] = j;
    int k = paramByte & 0xF;
    int m = arrayOfChar1[k];
    arrayOfChar2[1] = m;
    return new String(arrayOfChar2);
  }

  public static String convert(String paramString)
  {
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes();
      StringBuffer localStringBuffer1 = new StringBuffer();
      int i = 0;
      int j = arrayOfByte1.length;
      if (i >= j)
      {
        byte[] arrayOfByte2 = localStringBuffer1.toString().getBytes();
        str1 = new String(arrayOfByte2, "ISO-8859-1");
        return str1;
      }
      if ((arrayOfByte1[i] & 0x80) > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder("%");
        String str2 = byteToHex(arrayOfByte1[i]);
        String str3 = str2;
        StringBuffer localStringBuffer2 = localStringBuffer1.append(str3);
      }
      while (true)
      {
        i += 1;
        break;
        char c = (char)arrayOfByte1[i];
        StringBuffer localStringBuffer3 = localStringBuffer1.append(c);
      }
    }
    catch (Exception localException)
    {
      while (true)
        String str1 = null;
    }
  }

  public static String getData(String paramString, Bundle paramBundle)
  {
    return paramBundle.getString(paramString);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.util.OrmmaUtils
 * JD-Core Version:    0.6.2
 */