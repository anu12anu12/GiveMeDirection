package com.MASTAdView;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils
{
  public static Drawable GetDrawable(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      Drawable localDrawable = Drawable.createFromStream(paramContext.getAssets().open(paramString), null);
      localObject = localDrawable;
      try
      {
        label17: int i = paramContext.getResources().getDisplayMetrics().densityDpi;
        int j = paramContext.getResources().getConfiguration().screenLayout;
        if ((j & 0xF) == 4)
          if (i == 240)
          {
            AssetManager localAssetManager1 = paramContext.getAssets();
            String str1 = "xlarge/" + paramString;
            localObject = Drawable.createFromStream(localAssetManager1.open(str1), null);
          }
        while (true)
        {
          label94: return localObject;
          if (i == 160)
          {
            AssetManager localAssetManager2 = paramContext.getAssets();
            String str2 = "large/" + paramString;
            localObject = Drawable.createFromStream(localAssetManager2.open(str2), null);
          }
          else if (i == 120)
          {
            AssetManager localAssetManager3 = paramContext.getAssets();
            String str3 = "large/" + paramString;
            localObject = Drawable.createFromStream(localAssetManager3.open(str3), null);
          }
          else
          {
            AssetManager localAssetManager4 = paramContext.getAssets();
            String str4 = "xlarge/" + paramString;
            localObject = Drawable.createFromStream(localAssetManager4.open(str4), null);
            continue;
            if ((j & 0xF) == 3)
            {
              if (i == 240)
              {
                AssetManager localAssetManager5 = paramContext.getAssets();
                String str5 = "large/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager5.open(str5), null);
              }
              else if (i == 160)
              {
                AssetManager localAssetManager6 = paramContext.getAssets();
                String str6 = "normal/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager6.open(str6), null);
              }
              else if (i == 120)
              {
                AssetManager localAssetManager7 = paramContext.getAssets();
                String str7 = "normal/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager7.open(str7), null);
              }
              else
              {
                AssetManager localAssetManager8 = paramContext.getAssets();
                String str8 = "large/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager8.open(str8), null);
              }
            }
            else if ((j & 0xF) == 2)
            {
              if (i == 240)
              {
                AssetManager localAssetManager9 = paramContext.getAssets();
                String str9 = "normal/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager9.open(str9), null);
              }
              else if (i == 160)
              {
                AssetManager localAssetManager10 = paramContext.getAssets();
                String str10 = "small/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager10.open(str10), null);
              }
              else if (i == 120)
              {
                AssetManager localAssetManager11 = paramContext.getAssets();
                String str11 = "small/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager11.open(str11), null);
              }
              else
              {
                AssetManager localAssetManager12 = paramContext.getAssets();
                String str12 = "normal/" + paramString;
                localObject = Drawable.createFromStream(localAssetManager12.open(str12), null);
              }
            }
            else if ((j & 0xF) == 1)
            {
              AssetManager localAssetManager13 = paramContext.getAssets();
              String str13 = "small/" + paramString;
              localObject = Drawable.createFromStream(localAssetManager13.open(str13), null);
            }
            else
            {
              AssetManager localAssetManager14 = paramContext.getAssets();
              String str14 = "normal/" + paramString;
              localDrawable = Drawable.createFromStream(localAssetManager14.open(str14), null);
              localObject = localDrawable;
            }
          }
        }
      }
      catch (IOException localIOException1)
      {
        break label94;
      }
    }
    catch (IOException localIOException2)
    {
      break label17;
    }
  }

  public static StateListDrawable GetSelector(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    int[] arrayOfInt1 = { -16842919, 16842910 };
    Drawable localDrawable1 = GetDrawable(paramContext, paramString1);
    localStateListDrawable.addState(arrayOfInt1, localDrawable1);
    if (paramString2 != null)
    {
      int[] arrayOfInt2 = { 16842919, 16842910 };
      Drawable localDrawable2 = GetDrawable(paramContext, paramString2);
      localStateListDrawable.addState(arrayOfInt2, localDrawable2);
    }
    if (paramString3 != null)
    {
      int[] arrayOfInt3 = new int[1];
      arrayOfInt3[0] = -16842910;
      Drawable localDrawable3 = GetDrawable(paramContext, paramString3);
      localStateListDrawable.addState(arrayOfInt3, localDrawable3);
    }
    while (true)
    {
      return localStateListDrawable;
      int[] arrayOfInt4 = new int[1];
      arrayOfInt4[0] = -16842910;
      Drawable localDrawable4 = GetDrawable(paramContext, paramString1);
      localStateListDrawable.addState(arrayOfInt4, localDrawable4);
    }
  }

  public static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    int i = paramArrayOfByte.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return localStringBuffer1.toString();
      int k = paramArrayOfByte[j] & 0xFF;
      if (k < 16)
        StringBuffer localStringBuffer2 = localStringBuffer1.append("0");
      String str = Integer.toHexString(k);
      StringBuffer localStringBuffer3 = localStringBuffer1.append(str);
      j += 1;
    }
  }

  public static String md5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = paramString.getBytes();
      localMessageDigest.update(arrayOfByte);
      String str1 = byteArrayToHexString(localMessageDigest.digest());
      str2 = str1;
      return str2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
        String str2 = null;
    }
  }

  public static String scrape(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2);
    String str;
    if (i < 0)
      str = "";
    while (true)
    {
      return str;
      int j = paramString2.length() + i;
      int k = paramString1.indexOf(paramString3, j);
      if (k < 0)
      {
        str = "";
      }
      else
      {
        int m = paramString2.length() + i;
        str = paramString1.substring(m, k);
      }
    }
  }

  public static String scrapeIgnoreCase(String paramString1, String paramString2, String paramString3)
  {
    String str1 = paramString1.toLowerCase();
    String str2 = paramString2.toLowerCase();
    String str3 = paramString3.toLowerCase();
    int i = str1.indexOf(str2);
    String str4;
    if (i < 0)
      str4 = "";
    while (true)
    {
      return str4;
      int j = str2.length() + i;
      int k = str1.indexOf(str3, j);
      if (k < 0)
      {
        str4 = "";
      }
      else
      {
        int m = str2.length() + i;
        str4 = paramString1.substring(m, k);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.Utils
 * JD-Core Version:    0.6.2
 */