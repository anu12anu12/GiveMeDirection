package com.skyhookwireless;

public enum _sdkf
{
  public static boolean _sdkb;
  private static final String[] z;

  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "=@6U;.F<E".toCharArray();
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
          i2 = 126;
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
      Object localObject4 = "=S:J?*W".toCharArray();
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
            i8 = 126;
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
        int i11 = 2;
        Object localObject6 = "=@0W?9W".toCharArray();
        int i12 = localObject6.length;
        int i13;
        label331: int i16;
        int i17;
        if (i12 <= 1)
        {
          i13 = 0;
          localObject2 = localObject6;
          k = i13;
          int i14 = i12;
          Object localObject7 = localObject6;
          int i15 = i14;
          while (true)
          {
            i16 = localObject7[i13];
            switch (k % 5)
            {
            default:
              i17 = 126;
              label396: int i18 = (char)(i17 ^ i16);
              localObject7[i13] = i18;
              i13 = k + 1;
              if (i15 != 0)
                break label437;
              localObject7 = localObject2;
              int i19 = i13;
              i13 = i15;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label437: i12 = i15;
          localObject6 = localObject2;
        }
        while (true)
        {
          if (i12 > i13)
            break label331;
          String str3 = new String((char[])localObject6).intern();
          arrayOfString[i11] = str3;
          int i20 = 3;
          Object localObject8 = "=G;M7.".toCharArray();
          int i21 = localObject8.length;
          int i22;
          label496: int i25;
          if (i21 <= 1)
          {
            i22 = 0;
            localObject2 = localObject8;
            k = i22;
            int i23 = i21;
            Object localObject9 = localObject8;
            int i24 = i23;
            while (true)
            {
              i16 = localObject9[i22];
              switch (k % 5)
              {
              default:
                i25 = 126;
                label560: int i26 = (char)(i25 ^ i16);
                localObject9[i22] = i26;
                i22 = k + 1;
                if (i24 != 0)
                  break label601;
                localObject9 = localObject2;
                int i27 = i22;
                i22 = i24;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label601: i21 = i24;
            localObject8 = localObject2;
          }
          while (true)
          {
            if (i21 > i22)
              break label496;
            String str4 = new String((char[])localObject8).intern();
            arrayOfString[i20] = str4;
            int i28 = 4;
            Object localObject10 = "#]7D".toCharArray();
            int i29 = localObject10.length;
            int i30;
            label660: int i33;
            if (i29 <= 1)
            {
              i30 = 0;
              localObject2 = localObject10;
              k = i30;
              int i31 = i29;
              Object localObject11 = localObject10;
              int i32 = i31;
              while (true)
              {
                i16 = localObject11[i30];
                switch (k % 5)
                {
                default:
                  i33 = 126;
                  label724: int i34 = (char)(i33 ^ i16);
                  localObject11[i30] = i34;
                  i30 = k + 1;
                  if (i32 != 0)
                    break label765;
                  localObject11 = localObject2;
                  int i35 = i30;
                  i30 = i32;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label765: i29 = i32;
              localObject10 = localObject2;
            }
            while (true)
            {
              if (i29 > i30)
                break label660;
              String str5 = new String((char[])localObject10).intern();
              arrayOfString[i28] = str5;
              z = arrayOfString;
              String str6 = z[3];
              PUBLIC = new _sdkf(str6, 0);
              String str7 = z[1];
              PACKAGE = new _sdkf(str7, 1);
              String str8 = z[0];
              PROTECTED = new _sdkf(str8, 2);
              String str9 = z[2];
              PRIVATE = new _sdkf(str9, 3);
              String str10 = z[4];
              NONE = new _sdkf(str10, 4);
              _sdkf[] arrayOf_sdkf = new _sdkf[5];
              _sdkf local_sdkf1 = PUBLIC;
              arrayOf_sdkf[0] = local_sdkf1;
              _sdkf local_sdkf2 = PACKAGE;
              arrayOf_sdkf[1] = local_sdkf2;
              _sdkf local_sdkf3 = PROTECTED;
              arrayOf_sdkf[2] = local_sdkf3;
              _sdkf local_sdkf4 = PRIVATE;
              arrayOf_sdkf[3] = local_sdkf4;
              _sdkf local_sdkf5 = NONE;
              arrayOf_sdkf[4] = local_sdkf5;
              _sdka = arrayOf_sdkf;
              return;
              i2 = 109;
              break;
              i2 = 18;
              break;
              i2 = 121;
              break;
              i2 = 1;
              break;
              i8 = 109;
              break label232;
              i8 = 18;
              break label232;
              i8 = 121;
              break label232;
              i8 = 1;
              break label232;
              i17 = 109;
              break label396;
              i17 = 18;
              break label396;
              i17 = 121;
              break label396;
              i17 = 1;
              break label396;
              i25 = 109;
              break label560;
              i25 = 18;
              break label560;
              i25 = 121;
              break label560;
              i25 = 1;
              break label560;
              i33 = 109;
              break label724;
              i33 = 18;
              break label724;
              i33 = 121;
              break label724;
              i33 = 1;
              break label724;
              i30 = 0;
            }
            i22 = 0;
          }
          i13 = 0;
        }
        i5 = 0;
      }
      j = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkf
 * JD-Core Version:    0.6.2
 */