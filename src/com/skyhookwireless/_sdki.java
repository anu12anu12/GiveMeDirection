package com.skyhookwireless;

public enum _sdki
{
  private static final _sdki[] _sdka;
  private static final String[] z;

  static
  {
    String[] arrayOfString = new String[3];
    Object localObject1 = "$\bR\020<&\b".toCharArray();
    int i = localObject1.length;
    int j;
    Object localObject2;
    int k;
    int i1;
    int i2;
    if (i <= 1)
    {
      j = 0;
      localObject2 = localObject1;
      k = j;
      int m = i;
      Object localObject3 = localObject1;
      int n = m;
      while (true)
      {
        i1 = localObject3[j];
        switch (k % 5)
        {
        default:
          i2 = 115;
          int i3 = (char)(i2 ^ i1);
          localObject3[j] = i3;
          j = k + 1;
          if (n != 0)
            break label117;
          localObject3 = localObject2;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label117: i = n;
      localObject1 = localObject2;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject1).intern();
      arrayOfString[0] = str1;
      Object localObject4 = "3\007M\n6#\037".toCharArray();
      int i4 = localObject4.length;
      int i5;
      label167: int i8;
      if (i4 <= 1)
      {
        i5 = 0;
        localObject2 = localObject4;
        k = i5;
        int i6 = i4;
        Object localObject5 = localObject4;
        int i7 = i6;
        while (true)
        {
          i1 = localObject5[i5];
          switch (k % 5)
          {
          default:
            i8 = 115;
            label232: int i9 = (char)(i8 ^ i1);
            localObject5[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label273;
            localObject5 = localObject2;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label273: i4 = i7;
        localObject4 = localObject2;
      }
      while (true)
      {
        if (i4 > i5)
          break label167;
        String str2 = new String((char[])localObject4).intern();
        arrayOfString[1] = str2;
        Object localObject6 = "4\036M\033!?\007U".toCharArray();
        int i11 = localObject6.length;
        int i12;
        label328: int i15;
        if (i11 <= 1)
        {
          i12 = 0;
          localObject2 = localObject6;
          k = i12;
          int i13 = i11;
          Object localObject7 = localObject6;
          int i14 = i13;
          while (true)
          {
            i1 = localObject7[i12];
            switch (k % 5)
            {
            default:
              i15 = 115;
              label392: int i16 = (char)(i15 ^ i1);
              localObject7[i12] = i16;
              i12 = k + 1;
              if (i14 != 0)
                break label433;
              localObject7 = localObject2;
              int i17 = i12;
              i12 = i14;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label433: i11 = i14;
          localObject6 = localObject2;
        }
        while (true)
        {
          if (i11 > i12)
            break label328;
          String str3 = new String((char[])localObject6).intern();
          arrayOfString[2] = str3;
          z = arrayOfString;
          String str4 = z[2];
          EXTERNAL = new _sdki(str4, 0);
          String str5 = z[1];
          BATTERY = new _sdki(str5, 1);
          String str6 = z[0];
          UNKNOWN = new _sdki(str6, 2);
          _sdki[] arrayOf_sdki = new _sdki[3];
          _sdki local_sdki1 = EXTERNAL;
          arrayOf_sdki[0] = local_sdki1;
          _sdki local_sdki2 = BATTERY;
          arrayOf_sdki[1] = local_sdki2;
          _sdki local_sdki3 = UNKNOWN;
          arrayOf_sdki[2] = local_sdki3;
          _sdka = arrayOf_sdki;
          return;
          i2 = 113;
          break;
          i2 = 70;
          break;
          i2 = 25;
          break;
          i2 = 94;
          break;
          i8 = 113;
          break label232;
          i8 = 70;
          break label232;
          i8 = 25;
          break label232;
          i8 = 94;
          break label232;
          i15 = 113;
          break label392;
          i15 = 70;
          break label392;
          i15 = 25;
          break label392;
          i15 = 94;
          break label392;
          i12 = 0;
        }
        i5 = 0;
      }
      j = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdki
 * JD-Core Version:    0.6.2
 */