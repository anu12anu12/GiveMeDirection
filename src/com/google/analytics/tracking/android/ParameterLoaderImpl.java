package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

class ParameterLoaderImpl
  implements ParameterLoader
{
  private final Context ctx;

  public ParameterLoaderImpl(Context paramContext)
  {
    if (paramContext == null)
      throw new NullPointerException("Context cannot be null");
    Context localContext = paramContext.getApplicationContext();
    this.ctx = localContext;
  }

  private int getResourceIdForType(String paramString1, String paramString2)
  {
    if (this.ctx == null);
    Resources localResources;
    String str;
    for (int i = 0; ; i = localResources.getIdentifier(paramString1, paramString2, str))
    {
      return i;
      localResources = this.ctx.getResources();
      str = this.ctx.getPackageName();
    }
  }

  public boolean getBoolean(String paramString)
  {
    int i = getResourceIdForType(paramString, "bool");
    if (i == 0);
    String str;
    for (boolean bool = false; ; bool = "true".equalsIgnoreCase(str))
    {
      return bool;
      str = this.ctx.getString(i);
    }
  }

  public Double getDoubleFromString(String paramString)
  {
    Object localObject = null;
    String str = getString(paramString);
    if (TextUtils.isEmpty(str));
    while (true)
    {
      return localObject;
      try
      {
        Double localDouble = Double.valueOf(Double.parseDouble(str));
        localObject = localDouble;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i = Log.w("NumberFormatException parsing " + str);
      }
    }
  }

  public int getInt(String paramString, int paramInt)
  {
    int i = getResourceIdForType(paramString, "integer");
    if (i == 0);
    while (true)
    {
      return paramInt;
      try
      {
        int j = Integer.parseInt(this.ctx.getString(i));
        paramInt = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("NumberFormatException parsing ");
        String str = this.ctx.getString(i);
        int k = Log.w(str);
      }
    }
  }

  public String getString(String paramString)
  {
    int i = getResourceIdForType(paramString, "string");
    if (i == 0);
    for (String str = null; ; str = this.ctx.getString(i))
      return str;
  }

  public boolean isBooleanKeyPresent(String paramString)
  {
    if (getResourceIdForType(paramString, "bool") != 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.ParameterLoaderImpl
 * JD-Core Version:    0.6.2
 */