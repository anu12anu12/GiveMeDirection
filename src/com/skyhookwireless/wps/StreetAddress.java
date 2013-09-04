package com.skyhookwireless.wps;

import java.io.Serializable;

public final class StreetAddress
  implements Cloneable, Serializable
{
  private static final long serialVersionUID = 1483717758264923325L;
  private static final String[] z;
  String _sdka = null;
  String _sdkb = null;
  String _sdkc = null;
  String _sdkd = null;
  String _sdke = null;
  String _sdkf = null;
  String _sdkg = null;
  String _sdkh = null;
  String _sdki = null;
  String _sdkj = null;
  String[] _sdkk = null;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    int j = "RG".toCharArray();
    int k = j.length;
    int i1;
    int i8;
    int n;
    if (k <= 1)
    {
      int m = 0;
      i1 = j;
      int i2 = m;
      int i4 = k;
      int i5 = j;
      int i6 = i4;
      while (true)
      {
        int i7 = i5[m];
        switch (i2 % 5)
        {
        default:
          i8 = 94;
          int i9 = (char)(i8 ^ i7);
          i5[m] = i9;
          n = i2 + 1;
          if (i6 != 0)
            break label129;
          i5 = i1;
          int i3 = n;
          n = i6;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: k = i6;
      j = i1;
    }
    while (k <= n)
    {
      String str1 = new String(j).intern();
      arrayOfString[0] = str1;
      Object localObject2 = "^O".toCharArray();
      int i10 = localObject2.length;
      label177: Object localObject3;
      int i12;
      label196: int i13;
      int i14;
      if (i10 <= 1)
      {
        localObject1 = localObject2;
        i1 = i;
        int i11 = i10;
        localObject3 = localObject2;
        i12 = i11;
        i13 = localObject3[i];
        switch (i1 % 5)
        {
        default:
          i14 = 94;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      while (true)
      {
        int i15 = (char)(i14 ^ i13);
        localObject3[i] = i15;
        i = i1 + 1;
        if (i12 == 0)
        {
          localObject3 = localObject1;
          int i16 = i;
          i = i12;
          break label196;
        }
        i10 = i12;
        localObject2 = localObject1;
        if (i10 > i)
          break label177;
        String str2 = new String((char[])localObject2).intern();
        arrayOfString[1] = str2;
        z = arrayOfString;
        return;
        i8 = 114;
        break;
        i8 = 111;
        break;
        i8 = 86;
        break;
        i8 = 39;
        break;
        i14 = 114;
        continue;
        i14 = 111;
        continue;
        i14 = 86;
        continue;
        i14 = 39;
      }
      Object localObject1 = null;
    }
  }

  public StreetAddress clone()
  {
    try
    {
      StreetAddress localStreetAddress = (StreetAddress)super.clone();
      if (this._sdkk != null)
      {
        String[] arrayOfString = (String[])this._sdkk.clone();
        localStreetAddress._sdkk = arrayOfString;
      }
      return localStreetAddress;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }

  public String[] getAddressLine()
  {
    return this._sdkk;
  }

  public String getCity()
  {
    return this._sdkb;
  }

  public String getCountryCode()
  {
    return this._sdkj;
  }

  public String getCountryName()
  {
    return this._sdki;
  }

  public String getCounty()
  {
    return this._sdkd;
  }

  public String getPostalCode()
  {
    return this._sdkc;
  }

  public String getProvince()
  {
    return this._sdke;
  }

  public String getRegion()
  {
    return this._sdkf;
  }

  public String getStateCode()
  {
    return this._sdkh;
  }

  public String getStateName()
  {
    return this._sdkg;
  }

  public String getStreetNumber()
  {
    return this._sdka;
  }

  public void setAddressLines(String[] paramArrayOfString)
  {
    this._sdkk = paramArrayOfString;
  }

  public void setCity(String paramString)
  {
    this._sdkb = paramString;
  }

  public void setCountryCode(String paramString)
  {
    this._sdkj = paramString;
  }

  public void setCountryName(String paramString)
  {
    this._sdki = paramString;
  }

  public void setCounty(String paramString)
  {
    this._sdkd = paramString;
  }

  public void setPostalCode(String paramString)
  {
    this._sdkc = paramString;
  }

  public void setProvince(String paramString)
  {
    this._sdke = paramString;
  }

  public void setRegion(String paramString)
  {
    this._sdkf = paramString;
  }

  public void setStateCode(String paramString)
  {
    this._sdkh = paramString;
  }

  public void setStateName(String paramString)
  {
    this._sdkg = paramString;
  }

  public void setStreetNumber(String paramString)
  {
    this._sdka = paramString;
  }

  public String toString()
  {
    int i = Location._sdki;
    StringBuilder localStringBuilder1 = new StringBuilder();
    if ((this._sdka != null) && (this._sdkk != null))
    {
      String str1 = this._sdka;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" ");
      String[] arrayOfString = this._sdkk;
      int j = arrayOfString.length;
      int k = 0;
      do
      {
        if (k >= j)
          break;
        String str2 = arrayOfString[k];
        String str3 = str2 + "\n";
        StringBuilder localStringBuilder3 = localStringBuilder1.append(str3);
        k += 1;
      }
      while (i == 0);
    }
    if ((this._sdki != null) && (this._sdkj != null))
    {
      if ((this._sdkb != null) && (this._sdkh != null) && (this._sdkc != null))
      {
        StringBuilder localStringBuilder4 = new StringBuilder();
        String str4 = this._sdkb;
        StringBuilder localStringBuilder5 = localStringBuilder4.append(str4);
        String str5 = z[1];
        StringBuilder localStringBuilder6 = localStringBuilder5.append(str5);
        String str6 = this._sdkh;
        StringBuilder localStringBuilder7 = localStringBuilder6.append(str6).append(" ");
        String str7 = this._sdkc;
        String str8 = str7 + "\n";
        StringBuilder localStringBuilder8 = localStringBuilder1.append(str8);
      }
      String str9 = this._sdki;
      StringBuilder localStringBuilder9 = localStringBuilder1.append(str9);
      StringBuilder localStringBuilder10 = new StringBuilder();
      String str10 = z[0];
      StringBuilder localStringBuilder11 = localStringBuilder10.append(str10);
      String str11 = this._sdkj;
      String str12 = str11 + ")";
      StringBuilder localStringBuilder12 = localStringBuilder9.append(str12);
    }
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.StreetAddress
 * JD-Core Version:    0.6.2
 */