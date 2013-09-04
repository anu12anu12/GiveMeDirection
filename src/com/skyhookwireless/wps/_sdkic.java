package com.skyhookwireless.wps;

import java.util.Comparator;

final class _sdkic
{
  static Comparator<_sdkic> _sdka;
  private static final String[] z;
  private final String _sdkb;
  private final int _sdkc;
  private final String _sdkd;
  private final boolean _sdke;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = "\0056XpqF0S#%\022?Swg\007$SwP4\033\0261j\024wWwc\017;S".toCharArray();
    int i = localObject2.length;
    int j;
    Object localObject3;
    int k;
    int i1;
    int i2;
    if (i <= 1)
    {
      j = 0;
      localObject3 = localObject2;
      k = j;
      int m = i;
      Object localObject4 = localObject2;
      int n = m;
      while (true)
      {
        i1 = localObject4[j];
        switch (k % 5)
        {
        default:
          i2 = 5;
          int i3 = (char)(i2 ^ i1);
          localObject4[j] = i3;
          j = k + 1;
          if (n != 0)
            break label128;
          localObject4 = localObject3;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label128: i = n;
      localObject2 = localObject3;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject2).intern();
      arrayOfString[0] = str1;
      Object localObject5 = "\b8\0265d\0252\026\002W*wW!d\017;W5i\003".toCharArray();
      int i4 = localObject5.length;
      int i5;
      label179: int i8;
      if (i4 <= 1)
      {
        i5 = 0;
        localObject3 = localObject5;
        k = i5;
        int i6 = i4;
        Object localObject6 = localObject5;
        int i7 = i6;
        while (true)
        {
          i1 = localObject6[i5];
          switch (k % 5)
          {
          default:
            i8 = 5;
            label243: int i9 = (char)(i8 ^ i1);
            localObject6[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label284;
            localObject6 = localObject3;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label284: i4 = i7;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i5)
          break label179;
        String str2 = new String((char[])localObject5).intern();
        arrayOfString[1] = str2;
        int i11 = 2;
        Object localObject7 = "\0056XpqF0S#%\022?Swc\017;Swu\007#^wc\t%\0266%3\005z".toCharArray();
        int i12 = localObject7.length;
        label342: int i18;
        label407: int i14;
        if (i12 <= 1)
        {
          int i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i15 = i12;
          Object localObject9 = localObject7;
          int i16 = i15;
          while (true)
          {
            int i17 = localObject9[i13];
            switch (k % 5)
            {
            default:
              i18 = 5;
              int i19 = (char)(i18 ^ i17);
              localObject9[i13] = i19;
              i14 = k + 1;
              if (i16 != 0)
                break label448;
              localObject9 = localObject3;
              int i20 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label448: i12 = i16;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i14)
            break label342;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i21 = 3;
          Object localObject10 = "\0056XpqF0S#%\022?Swj\026wP8wF6\0261l\n2".toCharArray();
          Object localObject11 = localObject10.length;
          label504: Object localObject13;
          Object localObject14;
          label523: int i22;
          if (localObject11 <= 1)
          {
            localObject8 = localObject10;
            localObject3 = localObject1;
            Object localObject12 = localObject11;
            localObject13 = localObject10;
            localObject14 = localObject12;
            i11 = localObject13[localObject1];
            switch (localObject3 % 5)
            {
            default:
              i22 = 5;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          while (true)
          {
            int i23 = (char)(i22 ^ i11);
            localObject13[localObject1] = i23;
            localObject1 = localObject3 + 1;
            if (localObject14 == 0)
            {
              localObject13 = localObject8;
              int i24 = localObject1;
              localObject1 = localObject14;
              break label523;
            }
            localObject11 = localObject14;
            localObject10 = localObject8;
            if (localObject11 > localObject1)
              break label504;
            String str4 = new String((char[])localObject10).intern();
            arrayOfString[i21] = str4;
            z = arrayOfString;
            _sdka = new _sdkjc();
            return;
            i2 = 102;
            break;
            i2 = 87;
            break;
            i2 = 54;
            break;
            i2 = 87;
            break;
            i8 = 102;
            break label243;
            i8 = 87;
            break label243;
            i8 = 54;
            break label243;
            i8 = 87;
            break label243;
            i18 = 102;
            break label407;
            i18 = 87;
            break label407;
            i18 = 54;
            break label407;
            i18 = 87;
            break label407;
            i22 = 102;
            continue;
            i22 = 87;
            continue;
            i22 = 54;
            continue;
            i22 = 87;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  private _sdkic(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    this._sdkb = paramString1;
    this._sdkd = paramString2;
    this._sdke = paramBoolean;
    this._sdkc = paramInt;
  }

  static _sdkic _sdka(String paramString1, int paramInt, String paramString2)
  {
    return new _sdkic(paramString1, paramInt, paramString2, true);
  }

  static _sdkic _sdka(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = paramString2.trim();
    String str2 = str1 + " " + paramString3;
    return new _sdkic(paramString1, paramInt, str2, false);
  }

  static _sdkic _sdkb(String paramString1, int paramInt, String paramString2)
  {
    return new _sdkic(paramString1, paramInt, paramString2, false);
  }

  String _sdka()
  {
    return this._sdkb;
  }

  boolean _sdka(_sdkic param_sdkic)
  {
    int i = this._sdkb.length();
    int j = param_sdkic._sdkb.length();
    String str1;
    String str2;
    if (i <= j)
    {
      str1 = param_sdkic._sdkb;
      str2 = this._sdkb;
    }
    String str3;
    String str4;
    for (boolean bool = str1.startsWith(str2); ; bool = str3.startsWith(str4))
    {
      return bool;
      str3 = this._sdkb;
      str4 = param_sdkic._sdkb;
    }
  }

  int _sdkb()
  {
    return this._sdkc;
  }

  boolean _sdkb(_sdkic param_sdkic)
  {
    int i = this._sdkb.length();
    int j = param_sdkic._sdkb.length();
    if (i >= j);
    String str1;
    String str2;
    for (boolean bool = false; ; bool = str1.startsWith(str2))
    {
      return bool;
      str1 = param_sdkic._sdkb;
      str2 = this._sdkb;
    }
  }

  boolean _sdkc()
  {
    boolean bool = false;
    if (this._sdke)
    {
      String str = z[0];
      throw new UnsupportedOperationException(str);
    }
    if (!this._sdkd.startsWith("/"))
      bool = true;
    return bool;
  }

  String _sdkd()
  {
    if (this._sdke)
    {
      String str1 = z[0];
      throw new UnsupportedOperationException(str1);
    }
    if (!_sdkc())
    {
      String str2 = z[1];
      throw new UnsupportedOperationException(str2);
    }
    return this._sdkd.split(" ")[0];
  }

  String _sdke()
  {
    if (this._sdke)
    {
      String str1 = z[3];
      throw new UnsupportedOperationException(str1);
    }
    if (!_sdkc());
    for (String str2 = this._sdkd; ; str2 = this._sdkd.split(" ")[1])
      return str2;
  }

  String _sdkf()
  {
    if (!this._sdke)
    {
      String str = z[2];
      throw new UnsupportedOperationException(str);
    }
    return this._sdkd;
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
        paramObject = (_sdkic)paramObject;
        boolean bool2 = this._sdke;
        boolean bool3 = paramObject._sdke;
        if (bool2 != bool3)
        {
          String str1 = this._sdkb;
          String str2 = paramObject._sdkb;
          if (str1.equals(str2))
          {
            int i = this._sdkc;
            int j = paramObject._sdkc;
            if (i != j)
            {
              String str3 = this._sdkd;
              String str4 = paramObject._sdkd;
              boolean bool4 = str3.equals(str4);
              if (bool4)
                bool1 = true;
            }
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  public int hashCode()
  {
    if (this._sdke);
    for (int i = 0; ; i = 1)
    {
      int j = (i + 629) * 37;
      int k = this._sdkb.hashCode();
      int m = (j + k) * 37;
      int n = this._sdkc;
      int i1 = (m + n) * 37;
      int i2 = this._sdkd.hashCode();
      return i1 + i2;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str = this._sdkb;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str).append("_");
    int i = this._sdkc;
    return i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkic
 * JD-Core Version:    0.6.2
 */