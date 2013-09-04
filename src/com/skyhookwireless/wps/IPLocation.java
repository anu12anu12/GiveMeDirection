package com.skyhookwireless.wps;

public final class IPLocation extends Location
{
  private static final long serialVersionUID = -2752328055732645637L;
  private static final String[] z;
  protected final String _sdkj;
  protected final StreetAddress _sdkk;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    int j = "S\r".toCharArray();
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
          i8 = 70;
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
      Object localObject2 = "_\027".toCharArray();
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
          i14 = 70;
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
        i8 = 127;
        break;
        i8 = 45;
        break;
        i8 = 46;
        break;
        i8 = 12;
        break;
        i14 = 127;
        continue;
        i14 = 45;
        continue;
        i14 = 46;
        continue;
        i14 = 12;
      }
      Object localObject1 = null;
    }
  }

  IPLocation(double paramDouble1, double paramDouble2, long paramLong, String paramString, StreetAddress paramStreetAddress)
  {
    super(paramDouble1, paramDouble2, paramLong);
    this._sdkj = paramString;
    this._sdkk = paramStreetAddress;
  }

  public String getIP()
  {
    return this._sdkj;
  }

  public StreetAddress getStreetAddress()
  {
    return this._sdkk;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = getIP();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = z[1];
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
    double d1 = getLatitude();
    StringBuilder localStringBuilder4 = localStringBuilder3.append(d1);
    String str3 = z[0];
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str3);
    double d2 = getLongitude();
    StringBuilder localStringBuilder6 = localStringBuilder5.append(d2);
    StringBuilder localStringBuilder7;
    StreetAddress localStreetAddress;
    if (this._sdkk != null)
    {
      localStringBuilder7 = new StringBuilder().append("\n");
      localStreetAddress = this._sdkk;
    }
    for (String str4 = localStreetAddress; ; str4 = "")
      return str4;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.IPLocation
 * JD-Core Version:    0.6.2
 */