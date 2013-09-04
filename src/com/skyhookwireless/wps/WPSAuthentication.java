package com.skyhookwireless.wps;

import java.io.Serializable;

public final class WPSAuthentication
  implements Serializable
{
  private static final long serialVersionUID = -6753952426227660682L;
  private final String _sdka;
  private final String _sdkb;

  public WPSAuthentication(String paramString1, String paramString2)
  {
    this._sdka = paramString1;
    this._sdkb = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject == null);
    while (true)
    {
      return bool1;
      try
      {
        paramObject = (WPSAuthentication)paramObject;
        String str1 = this._sdka;
        String str2 = paramObject._sdka;
        if (str1 != str2)
        {
          if (this._sdka != null)
          {
            String str3 = this._sdka;
            String str4 = paramObject._sdka;
            if (!str3.equals(str4));
          }
        }
        else
        {
          String str5 = this._sdkb;
          String str6 = paramObject._sdkb;
          if (str5 != str6)
          {
            if (this._sdkb != null)
            {
              String str7 = this._sdkb;
              String str8 = paramObject._sdkb;
              boolean bool2 = str7.equals(str8);
              if (!bool2);
            }
          }
          else
            bool1 = true;
        }
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  public String getRealm()
  {
    return this._sdkb;
  }

  public String getUsername()
  {
    return this._sdka;
  }

  public int hashCode()
  {
    int i = (this._sdka.hashCode() + 629) * 37;
    int j = this._sdkb.hashCode();
    return i + j;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this._sdkb;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(":");
    String str2 = this._sdka;
    return str2;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.WPSAuthentication
 * JD-Core Version:    0.6.2
 */