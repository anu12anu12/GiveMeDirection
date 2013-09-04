package com.hopstop.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.text.NumberFormat;
import java.util.Hashtable;

public class Util
{
  public static Hashtable<String, String> convertToHashtable(String paramString)
  {
    if (paramString == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Object localObject1 = new Hashtable();
    int i = paramString.lastIndexOf("?") + 1;
    String[] arrayOfString1 = paramString.substring(i).split("&");
    int j = 0;
    while (true)
    {
      int k = arrayOfString1.length;
      if (j >= k)
        break;
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if ((arrayOfString2 != null) && (arrayOfString2.length == 2))
      {
        String str1 = arrayOfString2[0];
        String str2 = arrayOfString2[1];
        Object localObject2 = ((Hashtable)localObject1).put(str1, str2);
      }
      j += 1;
    }
  }

  public static String formatAddress(String paramString)
  {
    if (paramString == null);
    for (String str = null; ; str = URLDecoder.decode(paramString))
      return str;
  }

  public static String formatCityFromURL(String paramString)
  {
    if (paramString == null);
    for (String str = null; ; str = URLDecoder.decode(paramString))
      return str;
  }

  public static Bitmap getBitmapFromByteArray(byte[] paramArrayOfByte)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    localOptions.inPreferredConfig = localConfig;
    Object localObject = null;
    try
    {
      int i = paramArrayOfByte.length;
      Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, i, localOptions);
      localObject = localBitmap;
      label41: return localObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label41;
    }
  }

  public static byte[] getBytesFromBitmap(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    boolean bool = paramBitmap.compress(localCompressFormat, 0, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public static byte[] getBytesFromDrawable(Drawable paramDrawable)
  {
    Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    boolean bool = localBitmap.compress(localCompressFormat, 0, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public static String getDistance(boolean paramBoolean, float paramFloat)
  {
    String str1;
    if (paramBoolean)
      str1 = String.valueOf(roundToDecimal(paramFloat));
    String str3;
    for (String str2 = str1 + " mi"; ; str2 = str3 + " km")
    {
      return str2;
      str3 = String.valueOf(roundToDecimal(paramFloat * 1.609D));
    }
  }

  public static String getDistance(boolean paramBoolean, String paramString)
  {
    try
    {
      int i = paramString.indexOf("Total Walking: ");
      int j = paramString.indexOf(" miles");
      float f1;
      StringBuilder localStringBuilder2;
      String str2;
      if ((i < j) && (i != -1) && (j != -1))
      {
        int k = "Total Walking: ".length() + i;
        f1 = Float.parseFloat(paramString.substring(k, j));
        if (!paramBoolean)
          break label134;
        String str1 = String.valueOf(paramString.substring(0, i));
        StringBuilder localStringBuilder1 = new StringBuilder(str1).append("Total Walking: ");
        float f2 = roundToDecimal(f1);
        localStringBuilder2 = localStringBuilder1.append(f2).append(" mi");
        int m = " miles".length() + j;
        str2 = paramString.substring(m);
      }
      label134: String str5;
      for (paramString = str2; ; paramString = str5)
      {
        return paramString;
        String str3 = String.valueOf(paramString.substring(0, i));
        StringBuilder localStringBuilder3 = new StringBuilder(str3).append("Total Walking: ");
        float f3 = roundToDecimal(f1 * 1.609D);
        StringBuilder localStringBuilder4 = localStringBuilder3.append(f3).append(" km");
        int n = " miles".length() + j;
        String str4 = paramString.substring(n);
        str5 = str4;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static String getTimeStringFromSeconds(int paramInt)
  {
    int i = paramInt / 3600;
    int j = paramInt / 60 % 60;
    int k = paramInt % 60;
    StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
    String str2;
    String str5;
    label96: StringBuilder localStringBuilder2;
    String str6;
    if (i > 0)
    {
      String str1 = String.valueOf(i);
      str2 = str1 + " h ";
      String str3 = String.valueOf(str2);
      localStringBuilder1.<init>(str3);
      if (j <= 0)
        break label152;
      String str4 = String.valueOf(j);
      str5 = str4 + " m ";
      localStringBuilder2 = localStringBuilder1.append(str5);
      if (k <= 0)
        break label159;
      str6 = String.valueOf(k);
    }
    label152: label159: for (String str7 = str6 + " s"; ; str7 = "")
    {
      return str7;
      str2 = "";
      break;
      str5 = "";
      break label96;
    }
  }

  public static boolean isBikeModeAvailble(String paramString1, String paramString2)
  {
    if ((!paramString1.equalsIgnoreCase("New York")) && (!paramString2.equalsIgnoreCase("New York")) && (!paramString1.equalsIgnoreCase("Chicago")) && (!paramString2.equalsIgnoreCase("Chicago")) && (!paramString1.equalsIgnoreCase("San Francisco")) && (!paramString2.equalsIgnoreCase("San Francisco")) && (!paramString1.equalsIgnoreCase("Washington, DC")) && (!paramString2.equalsIgnoreCase("Washington, DC")));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public static String parseUriFromHypertext(Hashtable<String, String> paramHashtable, String paramString)
  {
    if ((paramHashtable == null) || (!paramHashtable.containsKey(paramString)));
    for (String str = null; ; str = (String)paramHashtable.get(paramString))
      return str;
  }

  public static String requiresBoroughChange(String paramString)
  {
    String str;
    if (paramString.equalsIgnoreCase("Metro North Area"))
      str = "metronorth";
    while (true)
    {
      return str;
      if (paramString.equalsIgnoreCase("Long Island"))
        str = "longisland";
      else if (paramString.equalsIgnoreCase("New Jersey"))
        str = "newjersey";
      else
        str = null;
    }
  }

  public static String roundMyDataTwoDecimal(double paramDouble)
  {
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMinimumFractionDigits(2);
    return localNumberFormat.format(paramDouble);
  }

  public static float roundToDecimal(double paramDouble)
  {
    return (float)Math.round(100.0D * paramDouble) / 100.0F;
  }

  public static float roundToDecimal(float paramFloat)
  {
    return Math.round(paramFloat * 100.0F) / 100.0F;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.util.Util
 * JD-Core Version:    0.6.2
 */