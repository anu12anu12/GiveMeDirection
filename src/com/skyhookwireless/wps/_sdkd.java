package com.skyhookwireless.wps;

 enum _sdkd
{
  private static final _sdkd[] _sdka;
  private static final String[] z;

  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "WM~\021xMP~".toCharArray();
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
          i2 = 54;
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
      Object localObject4 = "WM~\021qRMd\034wU".toCharArray();
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
            i8 = 54;
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
        Object localObject6 = "WM~\021nRM".toCharArray();
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
              i15 = 54;
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
          int i18 = 3;
          Object localObject8 = "WM~\021aRM".toCharArray();
          int i19 = localObject8.length;
          int i20;
          label491: int i23;
          int i24;
          if (i19 <= 1)
          {
            i20 = 0;
            localObject2 = localObject8;
            k = i20;
            int i21 = i19;
            Object localObject9 = localObject8;
            int i22 = i21;
            while (true)
            {
              i23 = localObject9[i20];
              switch (k % 5)
              {
              default:
                i24 = 54;
                label556: int i25 = (char)(i24 ^ i23);
                localObject9[i20] = i25;
                i20 = k + 1;
                if (i22 != 0)
                  break label597;
                localObject9 = localObject2;
                int i26 = i20;
                i20 = i22;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label597: i19 = i22;
            localObject8 = localObject2;
          }
          while (true)
          {
            if (i19 > i20)
              break label491;
            String str4 = new String((char[])localObject8).intern();
            arrayOfString[i18] = str4;
            int i27 = 4;
            Object localObject10 = "WM~\021qRMd\035{MQo\006sF".toCharArray();
            int i28 = localObject10.length;
            int i29;
            label656: int i32;
            if (i28 <= 1)
            {
              i29 = 0;
              localObject2 = localObject10;
              k = i29;
              int i30 = i28;
              Object localObject11 = localObject10;
              int i31 = i30;
              while (true)
              {
                i23 = localObject11[i29];
                switch (k % 5)
                {
                default:
                  i32 = 54;
                  label720: int i33 = (char)(i32 ^ i23);
                  localObject11[i29] = i33;
                  i29 = k + 1;
                  if (i31 != 0)
                    break label761;
                  localObject11 = localObject2;
                  int i34 = i29;
                  i29 = i31;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label761: i28 = i31;
              localObject10 = localObject2;
            }
            while (true)
            {
              if (i28 > i29)
                break label656;
              String str5 = new String((char[])localObject10).intern();
              arrayOfString[i27] = str5;
              z = arrayOfString;
              String str6 = z[1];
              USE_GPS_RAW = new _sdkd(str6, 0);
              String str7 = z[4];
              USE_GPS_SMOOTHED = new _sdkd(str7, 1);
              String str8 = z[3];
              USE_WPS = new _sdkd(str8, 2);
              String str9 = z[2];
              USE_XPS = new _sdkd(str9, 3);
              String str10 = z[0];
              USE_NONE = new _sdkd(str10, 4);
              _sdkd[] arrayOf_sdkd = new _sdkd[5];
              _sdkd local_sdkd1 = USE_GPS_RAW;
              arrayOf_sdkd[0] = local_sdkd1;
              _sdkd local_sdkd2 = USE_GPS_SMOOTHED;
              arrayOf_sdkd[1] = local_sdkd2;
              _sdkd local_sdkd3 = USE_WPS;
              arrayOf_sdkd[2] = local_sdkd3;
              _sdkd local_sdkd4 = USE_XPS;
              arrayOf_sdkd[3] = local_sdkd4;
              _sdkd local_sdkd5 = USE_NONE;
              arrayOf_sdkd[4] = local_sdkd5;
              _sdka = arrayOf_sdkd;
              return;
              i2 = 2;
              break;
              i2 = 30;
              break;
              i2 = 59;
              break;
              i2 = 78;
              break;
              i8 = 2;
              break label232;
              i8 = 30;
              break label232;
              i8 = 59;
              break label232;
              i8 = 78;
              break label232;
              i15 = 2;
              break label392;
              i15 = 30;
              break label392;
              i15 = 59;
              break label392;
              i15 = 78;
              break label392;
              i24 = 2;
              break label556;
              i24 = 30;
              break label556;
              i24 = 59;
              break label556;
              i24 = 78;
              break label556;
              i32 = 2;
              break label720;
              i32 = 30;
              break label720;
              i32 = 59;
              break label720;
              i32 = 78;
              break label720;
              i29 = 0;
            }
            i20 = 0;
          }
          i12 = 0;
        }
        i5 = 0;
      }
      j = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkd
 * JD-Core Version:    0.6.2
 */