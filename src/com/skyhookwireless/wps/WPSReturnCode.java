package com.skyhookwireless.wps;

public enum WPSReturnCode
{
  private static final String[] z;

  static
  {
    String[] arrayOfString = new String[7];
    Object localObject1 = "?!F8(#".toCharArray();
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
          i2 = 103;
          int i3 = (char)(i2 ^ i1);
          localObject3[j] = i3;
          j = k + 1;
          if (n != 0)
            break label121;
          localObject3 = localObject2;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label121: i = n;
      localObject1 = localObject2;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject1).intern();
      arrayOfString[0] = str1;
      Object localObject4 = "?!F8\":#Z5".toCharArray();
      int i4 = localObject4.length;
      int i5;
      label171: int i8;
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
            i8 = 103;
            label236: int i9 = (char)(i8 ^ i1);
            localObject5[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label277;
            localObject5 = localObject2;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label277: i4 = i7;
        localObject4 = localObject2;
      }
      while (true)
      {
        if (i4 > i5)
          break label171;
        String str2 = new String((char[])localObject4).intern();
        arrayOfString[1] = str2;
        int i11 = 2;
        Object localObject6 = "?!F8\":#Z58;4G1\":.@)&>0\\+&*=P".toCharArray();
        int i12 = localObject6.length;
        int i13;
        label335: int i16;
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
              i17 = 103;
              label400: int i18 = (char)(i17 ^ i16);
              localObject7[i13] = i18;
              i13 = k + 1;
              if (i15 != 0)
                break label441;
              localObject7 = localObject2;
              int i19 = i13;
              i13 = i15;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label441: i12 = i15;
          localObject6 = localObject2;
        }
        while (true)
        {
          if (i12 > i13)
            break label335;
          String str3 = new String((char[])localObject6).intern();
          arrayOfString[i11] = str3;
          int i20 = 3;
          Object localObject8 = "?!F8\":#Z58=?T23 >G.=-5".toCharArray();
          int i21 = localObject8.length;
          int i22;
          label500: int i25;
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
                i25 = 103;
                label564: int i26 = (char)(i25 ^ i16);
                localObject9[i22] = i26;
                i22 = k + 1;
                if (i24 != 0)
                  break label605;
                localObject9 = localObject2;
                int i27 = i22;
                i22 = i24;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label605: i21 = i24;
            localObject8 = localObject2;
          }
          while (true)
          {
            if (i21 > i22)
              break label500;
            String str4 = new String((char[])localObject8).intern();
            arrayOfString[i20] = str4;
            int i28 = 4;
            Object localObject10 = "?!F8\":#Z58?8S.8&>A8&>0\\+&*=P".toCharArray();
            int i29 = localObject10.length;
            int i30;
            label664: int i33;
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
                  i33 = 103;
                  label728: int i34 = (char)(i33 ^ i16);
                  localObject11[i30] = i34;
                  i30 = k + 1;
                  if (i32 != 0)
                    break label769;
                  localObject11 = localObject2;
                  int i35 = i30;
                  i30 = i32;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label769: i29 = i32;
              localObject10 = localObject2;
            }
            while (true)
            {
              if (i29 > i30)
                break label664;
              String str5 = new String((char[])localObject10).intern();
              arrayOfString[i28] = str5;
              int i36 = 5;
              Object localObject12 = "?!F8\":#Z58$>V&3!>[8$)?[(373P8#-%P5*!?P#".toCharArray();
              int i37 = localObject12.length;
              int i38;
              label828: int i41;
              if (i37 <= 1)
              {
                i38 = 0;
                localObject2 = localObject12;
                k = i38;
                int i39 = i37;
                Object localObject13 = localObject12;
                int i40 = i39;
                while (true)
                {
                  i16 = localObject13[i38];
                  switch (k % 5)
                  {
                  default:
                    i41 = 103;
                    label892: int i42 = (char)(i41 ^ i16);
                    localObject13[i38] = i42;
                    i38 = k + 1;
                    if (i40 != 0)
                      break label933;
                    localObject13 = localObject2;
                    int i43 = i38;
                    i38 = i40;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label933: i37 = i40;
                localObject12 = localObject2;
              }
              while (true)
              {
                if (i37 > i38)
                  break label828;
                String str6 = new String((char[])localObject12).intern();
                arrayOfString[i36] = str6;
                int i44 = 6;
                Object localObject14 = "?!F8\":#Z58&>J0..8J.)7#T) -".toCharArray();
                int i45 = localObject14.length;
                int i46;
                label993: int i49;
                if (i45 <= 1)
                {
                  i46 = 0;
                  localObject2 = localObject14;
                  k = i46;
                  int i47 = i45;
                  Object localObject15 = localObject14;
                  int i48 = i47;
                  while (true)
                  {
                    i16 = localObject15[i46];
                    switch (k % 5)
                    {
                    default:
                      i49 = 103;
                      label1060: int i50 = (char)(i49 ^ i16);
                      localObject15[i46] = i50;
                      i46 = k + 1;
                      if (i48 != 0)
                        break label1101;
                      localObject15 = localObject2;
                      int i51 = i46;
                      i46 = i48;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1101: i45 = i48;
                  localObject14 = localObject2;
                }
                while (true)
                {
                  if (i45 > i46)
                    break label993;
                  String str7 = new String((char[])localObject14).intern();
                  arrayOfString[i44] = str7;
                  z = arrayOfString;
                  String str8 = z[0];
                  WPS_OK = new WPSReturnCode(str8, 0);
                  String str9 = z[4];
                  WPS_ERROR_WIFI_NOT_AVAILABLE = new WPSReturnCode(str9, 1);
                  String str10 = z[6];
                  WPS_ERROR_NO_WIFI_IN_RANGE = new WPSReturnCode(str10, 2);
                  String str11 = z[3];
                  WPS_ERROR_UNAUTHORIZED = new WPSReturnCode(str11, 3);
                  String str12 = z[2];
                  WPS_ERROR_SERVER_UNAVAILABLE = new WPSReturnCode(str12, 4);
                  String str13 = z[5];
                  WPS_ERROR_LOCATION_CANNOT_BE_DETERMINED = new WPSReturnCode(str13, 5);
                  String str14 = z[1];
                  WPS_ERROR = new WPSReturnCode(str14, 6);
                  WPSReturnCode[] arrayOfWPSReturnCode = new WPSReturnCode[7];
                  WPSReturnCode localWPSReturnCode1 = WPS_OK;
                  arrayOfWPSReturnCode[0] = localWPSReturnCode1;
                  WPSReturnCode localWPSReturnCode2 = WPS_ERROR_WIFI_NOT_AVAILABLE;
                  arrayOfWPSReturnCode[1] = localWPSReturnCode2;
                  WPSReturnCode localWPSReturnCode3 = WPS_ERROR_NO_WIFI_IN_RANGE;
                  arrayOfWPSReturnCode[2] = localWPSReturnCode3;
                  WPSReturnCode localWPSReturnCode4 = WPS_ERROR_UNAUTHORIZED;
                  arrayOfWPSReturnCode[3] = localWPSReturnCode4;
                  WPSReturnCode localWPSReturnCode5 = WPS_ERROR_SERVER_UNAVAILABLE;
                  arrayOfWPSReturnCode[4] = localWPSReturnCode5;
                  WPSReturnCode localWPSReturnCode6 = WPS_ERROR_LOCATION_CANNOT_BE_DETERMINED;
                  arrayOfWPSReturnCode[5] = localWPSReturnCode6;
                  WPSReturnCode localWPSReturnCode7 = WPS_ERROR;
                  arrayOfWPSReturnCode[6] = localWPSReturnCode7;
                  _sdka = arrayOfWPSReturnCode;
                  return;
                  i2 = 104;
                  break;
                  i2 = 113;
                  break;
                  i2 = 21;
                  break;
                  i2 = 103;
                  break;
                  i8 = 104;
                  break label236;
                  i8 = 113;
                  break label236;
                  i8 = 21;
                  break label236;
                  i8 = 103;
                  break label236;
                  i17 = 104;
                  break label400;
                  i17 = 113;
                  break label400;
                  i17 = 21;
                  break label400;
                  i17 = 103;
                  break label400;
                  i25 = 104;
                  break label564;
                  i25 = 113;
                  break label564;
                  i25 = 21;
                  break label564;
                  i25 = 103;
                  break label564;
                  i33 = 104;
                  break label728;
                  i33 = 113;
                  break label728;
                  i33 = 21;
                  break label728;
                  i33 = 103;
                  break label728;
                  i41 = 104;
                  break label892;
                  i41 = 113;
                  break label892;
                  i41 = 21;
                  break label892;
                  i41 = 103;
                  break label892;
                  i49 = 104;
                  break label1060;
                  i49 = 113;
                  break label1060;
                  i49 = 21;
                  break label1060;
                  i49 = 103;
                  break label1060;
                  i46 = 0;
                }
                i38 = 0;
              }
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
 * Qualified Name:     com.skyhookwireless.wps.WPSReturnCode
 * JD-Core Version:    0.6.2
 */