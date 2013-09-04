package com.hopstop.Localization;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.Locale;

public class LocalizationUtil
{
  public static final String LANG_SPANISH_CASTILIAN = "es-ES";
  public static final String LANG_SPANISH_COLUMBIAN = "es-US";
  public static final String LANG_SPANISH_MEXICAN = "es-MX";

  public static String appLangToDeviceLang(String paramString)
  {
    if (paramString.equals("es-MX"))
      paramString = "es-US";
    return paramString;
  }

  private SharedPreferences getDefaultSharePreference()
  {
    return null;
  }

  public static String getLanguagePreference()
  {
    return "es-US";
  }

  public static void updateLocaleInfo(Context paramContext)
  {
    String str1 = getLanguagePreference();
    if (str1 == null)
      return;
    if (str1.equals(""))
      return;
    Resources localResources = paramContext.getApplicationContext().getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    String[] arrayOfString = appLangToDeviceLang(str1).split("-");
    Locale localLocale1;
    if (arrayOfString.length == 1)
    {
      String str2 = arrayOfString[0];
      localLocale1 = new Locale(str2);
    }
    Locale localLocale2;
    for (localConfiguration.locale = localLocale1; ; localConfiguration.locale = localLocale2)
    {
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      return;
      String str3 = arrayOfString[0];
      String str4 = arrayOfString[1];
      localLocale2 = new Locale(str3, str4);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.Localization.LocalizationUtil
 * JD-Core Version:    0.6.2
 */