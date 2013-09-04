package com.skyhookwireless;

public final class _sdkic
  implements Comparable<_sdkic>
{
  private static final char[] _sdka;
  public static boolean _sdkc;
  private static final String[] z;
  private long _sdkb;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    int j = "r\036\037^l\\>2C#K>HlQ:;L8V)9".toCharArray();
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
          i8 = 76;
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
      Object localObject2 = "\0376/\r%Q)=A%[0H\"X+4".toCharArray();
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
          i14 = 76;
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
        _sdka = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
        return;
        i8 = 63;
        break;
        i8 = 95;
        break;
        i8 = 92;
        break;
        i8 = 45;
        break;
        i14 = 63;
        continue;
        i14 = 95;
        continue;
        i14 = 92;
        continue;
        i14 = 45;
      }
      Object localObject1 = null;
    }
  }

  public _sdkic(String paramString)
  {
    if (paramString.length() != 12)
    {
      StringBuilder localStringBuilder1 = new StringBuilder(12);
      int i = 0;
      do
      {
        int j = paramString.length();
        if (i >= j)
          break;
        char c = paramString.charAt(i);
        if (((c >= '0') && (c <= '9')) || ((c >= 'a') && (c <= 'f')) || ((c >= 'A') && (c <= 'F')))
          StringBuilder localStringBuilder2 = localStringBuilder1.append(c);
        i += 1;
      }
      while (!bool);
      if (localStringBuilder1.length() == 12)
        paramString = localStringBuilder1.toString();
    }
    if (paramString.length() != 12)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      int k = paramString.length();
      StringBuilder localStringBuilder4 = localStringBuilder3.append(k);
      String str1 = z[1];
      String str2 = str1;
      throw new IllegalArgumentException(str2);
    }
    long l = Long.parseLong(paramString, 16);
    this._sdkb = l;
    if (this._sdkb >= 0L)
      return;
    String str3 = z[0];
    throw new IllegalArgumentException(str3);
  }

  public int _sdka(_sdkic param_sdkic)
  {
    long l1 = this._sdkb;
    long l2 = param_sdkic._sdkb;
    int i;
    if (l1 < l2)
      i = -1;
    while (true)
    {
      return i;
      long l3 = param_sdkic._sdkb;
      long l4 = this._sdkb;
      if (l3 < l4)
        i = 1;
      else
        i = 0;
    }
  }

  public long _sdka()
  {
    return this._sdkb;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null);
    while (true)
    {
      return bool;
      try
      {
        long l1 = this._sdkb;
        long l2 = ((_sdkic)paramObject)._sdkb;
        if (l1 == l2)
          bool = true;
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  public int hashCode()
  {
    return (int)this._sdkb;
  }

  public String toString()
  {
    boolean bool = _sdkc;
    StringBuilder localStringBuilder1 = new StringBuilder(12);
    int i = 11;
    do
    {
      if (i < 0)
        break;
      char[] arrayOfChar = _sdka;
      long l = this._sdkb;
      int j = i * 4;
      int k = (int)(l >> j & 0xF);
      char c = arrayOfChar[k];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(c);
      i += -1;
    }
    while (!bool);
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkic
 * JD-Core Version:    0.6.2
 */