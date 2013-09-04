package com.flurry.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class r
{
  static int a(Context paramContext, int paramInt)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    float f2 = paramInt;
    return (int)(f1 * f2 + 0.5F);
  }

  static String a(String paramString)
  {
    try
    {
      String str1 = URLEncoder.encode(paramString, "UTF-8");
      str2 = str1;
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        String str3 = "Cannot encode '" + paramString + "'";
        int i = ai.d("FlurryAgent", str3);
        String str2 = "";
      }
    }
  }

  static String a(String paramString, int paramInt)
  {
    if (paramString == null)
      paramString = "";
    while (true)
    {
      return paramString;
      if (paramString.length() > paramInt)
        paramString = paramString.substring(0, paramInt);
    }
  }

  static void a(Context paramContext, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView.setAdjustViewBounds(true);
    int i = a(paramContext, paramInt1);
    paramImageView.setMinimumWidth(i);
    int j = a(paramContext, paramInt2);
    paramImageView.setMinimumHeight(j);
    int k = a(paramContext, paramInt1);
    paramImageView.setMaxWidth(k);
    int m = a(paramContext, paramInt2);
    paramImageView.setMaxHeight(m);
  }

  static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  static byte[] b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte1 = paramString.getBytes();
      int i = paramString.length();
      localMessageDigest.update(arrayOfByte1, 0, i);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      arrayOfByte3 = arrayOfByte2;
      return arrayOfByte3;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Unsupported SHA1: ");
        String str1 = localNoSuchAlgorithmException.getMessage();
        String str2 = str1;
        int j = ai.b("FlurryAgent", str2);
        byte[] arrayOfByte3 = null;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.r
 * JD-Core Version:    0.6.2
 */