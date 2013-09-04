package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdksd;

class _sdkec
{
  private static final _sdkhb _sdkb;
  private static final String[] z;
  private _sdkib _sdka;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[15];
    Object localObject2 = "6\030*\033`0\0244\0232*\030-T~+\036;��{+\023z\\e-\t2T".toCharArray();
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
          i2 = 18;
          int i3 = (char)(i2 ^ i1);
          localObject4[j] = i3;
          j = k + 1;
          if (n != 0)
            break label129;
          localObject4 = localObject3;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: i = n;
      localObject2 = localObject3;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject2).intern();
      arrayOfString[0] = str1;
      Object localObject5 = "6\030*\033`0\0244\02324\017?\002{+\b)T~+\036;��{+\023z\\e-\t2T".toCharArray();
      int i4 = localObject5.length;
      int i5;
      label180: int i8;
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
            i8 = 18;
            label244: int i9 = (char)(i8 ^ i1);
            localObject6[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label285;
            localObject6 = localObject3;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i4 = i7;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i5)
          break label180;
        String str2 = new String((char[])localObject5).intern();
        arrayOfString[1] = str2;
        int i11 = 2;
        Object localObject7 = "*\022.Ta0\034.\035}*\034(\r".toCharArray();
        int i12 = localObject7.length;
        int i13;
        label343: int i16;
        int i17;
        if (i12 <= 1)
        {
          i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i14 = i12;
          Object localObject8 = localObject7;
          int i15 = i14;
          while (true)
          {
            i16 = localObject8[i13];
            switch (k % 5)
            {
            default:
              i17 = 18;
              label408: int i18 = (char)(i17 ^ i16);
              localObject8[i13] = i18;
              i13 = k + 1;
              if (i15 != 0)
                break label449;
              localObject8 = localObject3;
              int i19 = i13;
              i13 = i15;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i12 = i15;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i13)
            break label343;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i20 = 3;
          Object localObject9 = "*\030-T~+\036;��{+\023z\020}!\0164Sfd\022,\021`(\034*Tf,\030z\027s'\025?\0202+\023?".toCharArray();
          int i21 = localObject9.length;
          int i22;
          label508: int i25;
          if (i21 <= 1)
          {
            i22 = 0;
            localObject3 = localObject9;
            k = i22;
            int i23 = i21;
            Object localObject10 = localObject9;
            int i24 = i23;
            while (true)
            {
              i16 = localObject10[i22];
              switch (k % 5)
              {
              default:
                i25 = 18;
                label572: int i26 = (char)(i25 ^ i16);
                localObject10[i22] = i26;
                i22 = k + 1;
                if (i24 != 0)
                  break label613;
                localObject10 = localObject3;
                int i27 = i22;
                i22 = i24;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label613: i21 = i24;
            localObject9 = localObject3;
          }
          while (true)
          {
            if (i21 > i22)
              break label508;
            String str4 = new String((char[])localObject9).intern();
            arrayOfString[i20] = str4;
            int i28 = 4;
            Object localObject11 = "6\030*\033`0\0244\0232*\030-T~+\036;��{+\023z\\".toCharArray();
            int i29 = localObject11.length;
            int i30;
            label672: int i33;
            if (i29 <= 1)
            {
              i30 = 0;
              localObject3 = localObject11;
              k = i30;
              int i31 = i29;
              Object localObject12 = localObject11;
              int i32 = i31;
              while (true)
              {
                i16 = localObject12[i30];
                switch (k % 5)
                {
                default:
                  i33 = 18;
                  label736: int i34 = (char)(i33 ^ i16);
                  localObject12[i30] = i34;
                  i30 = k + 1;
                  if (i32 != 0)
                    break label777;
                  localObject12 = localObject3;
                  int i35 = i30;
                  i30 = i32;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i29 = i32;
              localObject11 = localObject3;
            }
            while (true)
            {
              if (i29 > i30)
                break label672;
              String str5 = new String((char[])localObject11).intern();
              arrayOfString[i28] = str5;
              int i36 = 5;
              Object localObject13 = "6\030*\033`0\0244\0232*\030-T~+\036;��{+\023z\\23\024.\0342".toCharArray();
              int i37 = localObject13.length;
              int i38;
              label836: int i41;
              if (i37 <= 1)
              {
                i38 = 0;
                localObject3 = localObject13;
                k = i38;
                int i39 = i37;
                Object localObject14 = localObject13;
                int i40 = i39;
                while (true)
                {
                  i16 = localObject14[i38];
                  switch (k % 5)
                  {
                  default:
                    i41 = 18;
                    label900: int i42 = (char)(i41 ^ i16);
                    localObject14[i38] = i42;
                    i38 = k + 1;
                    if (i40 != 0)
                      break label941;
                    localObject14 = localObject3;
                    int i43 = i38;
                    i38 = i40;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i37 = i40;
                localObject13 = localObject3;
              }
              while (true)
              {
                if (i37 > i38)
                  break label836;
                String str6 = new String((char[])localObject13).intern();
                arrayOfString[i36] = str6;
                int i44 = 6;
                Object localObject15 = "6\030*\033`0\0244\0232'\0349\034w ]6\033q%\t3\033|d\034)T|!\n".toCharArray();
                int i45 = localObject15.length;
                int i46;
                label1001: int i49;
                if (i45 <= 1)
                {
                  i46 = 0;
                  localObject3 = localObject15;
                  k = i46;
                  int i47 = i45;
                  Object localObject16 = localObject15;
                  int i48 = i47;
                  while (true)
                  {
                    i16 = localObject16[i46];
                    switch (k % 5)
                    {
                    default:
                      i49 = 18;
                      label1068: int i50 = (char)(i49 ^ i16);
                      localObject16[i46] = i50;
                      i46 = k + 1;
                      if (i48 != 0)
                        break label1109;
                      localObject16 = localObject3;
                      int i51 = i46;
                      i46 = i48;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i45 = i48;
                  localObject15 = localObject3;
                }
                while (true)
                {
                  if (i45 > i46)
                    break label1001;
                  String str7 = new String((char[])localObject15).intern();
                  arrayOfString[i44] = str7;
                  int i52 = 7;
                  Object localObject17 = "d\016;��am".toCharArray();
                  int i53 = localObject17.length;
                  int i54;
                  label1169: int i57;
                  if (i53 <= 1)
                  {
                    i54 = 0;
                    localObject3 = localObject17;
                    k = i54;
                    int i55 = i53;
                    Object localObject18 = localObject17;
                    int i56 = i55;
                    while (true)
                    {
                      i16 = localObject18[i54];
                      switch (k % 5)
                      {
                      default:
                        i57 = 18;
                        label1236: int i58 = (char)(i57 ^ i16);
                        localObject18[i54] = i58;
                        i54 = k + 1;
                        if (i56 != 0)
                          break label1277;
                        localObject18 = localObject3;
                        int i59 = i54;
                        i54 = i56;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i53 = i56;
                    localObject17 = localObject3;
                  }
                  while (true)
                  {
                    if (i53 > i54)
                      break label1169;
                    String str8 = new String((char[])localObject17).intern();
                    arrayOfString[i52] = str8;
                    int i60 = 8;
                    Object localObject19 = "*\030-T~+\036;��{+\023z\033d!\0176\025b7].\034wd\036;\027z!\031z\033|!".toCharArray();
                    int i61 = localObject19.length;
                    int i62;
                    label1337: int i65;
                    if (i61 <= 1)
                    {
                      i62 = 0;
                      localObject3 = localObject19;
                      k = i62;
                      int i63 = i61;
                      Object localObject20 = localObject19;
                      int i64 = i63;
                      while (true)
                      {
                        i16 = localObject20[i62];
                        switch (k % 5)
                        {
                        default:
                          i65 = 18;
                          label1404: int i66 = (char)(i65 ^ i16);
                          localObject20[i62] = i66;
                          i62 = k + 1;
                          if (i64 != 0)
                            break label1445;
                          localObject20 = localObject3;
                          int i67 = i62;
                          i62 = i64;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1445: i61 = i64;
                      localObject19 = localObject3;
                    }
                    while (true)
                    {
                      if (i61 > i62)
                        break label1337;
                      String str9 = new String((char[])localObject19).intern();
                      arrayOfString[i60] = str9;
                      int i68 = 9;
                      Object localObject21 = "#\022.Tt-\017)��27\t;��{+\023;\006kd\0215\027s0\0245\032".toCharArray();
                      int i69 = localObject21.length;
                      int i70;
                      label1505: int i73;
                      if (i69 <= 1)
                      {
                        i70 = 0;
                        localObject3 = localObject21;
                        k = i70;
                        int i71 = i69;
                        Object localObject22 = localObject21;
                        int i72 = i71;
                        while (true)
                        {
                          i16 = localObject22[i70];
                          switch (k % 5)
                          {
                          default:
                            i73 = 18;
                            label1572: int i74 = (char)(i73 ^ i16);
                            localObject22[i70] = i74;
                            i70 = k + 1;
                            if (i72 != 0)
                              break label1613;
                            localObject22 = localObject3;
                            int i75 = i70;
                            i70 = i72;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1613: i69 = i72;
                        localObject21 = localObject3;
                      }
                      while (true)
                      {
                        if (i69 > i70)
                          break label1505;
                        String str10 = new String((char[])localObject21).intern();
                        arrayOfString[i68] = str10;
                        int i76 = 10;
                        Object localObject23 = "&\022.\0342*\030-Ts*\031z\027s'\025?\0202%\017?TU\024.z\030}'\034.\035}*\016".toCharArray();
                        int i77 = localObject23.length;
                        int i78;
                        label1673: int i81;
                        if (i77 <= 1)
                        {
                          i78 = 0;
                          localObject3 = localObject23;
                          k = i78;
                          int i79 = i77;
                          Object localObject24 = localObject23;
                          int i80 = i79;
                          while (true)
                          {
                            i16 = localObject24[i78];
                            switch (k % 5)
                            {
                            default:
                              i81 = 18;
                              label1740: int i82 = (char)(i81 ^ i16);
                              localObject24[i78] = i82;
                              i78 = k + 1;
                              if (i80 != 0)
                                break label1781;
                              localObject24 = localObject3;
                              int i83 = i78;
                              i78 = i80;
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            }
                          }
                          label1781: i77 = i80;
                          localObject23 = localObject3;
                        }
                        while (true)
                        {
                          if (i77 > i78)
                            break label1673;
                          String str11 = new String((char[])localObject23).intern();
                          arrayOfString[i76] = str11;
                          int i84 = 11;
                          Object localObject25 = "d\020)T}(\031s".toCharArray();
                          int i85 = localObject25.length;
                          int i86;
                          label1841: int i89;
                          if (i85 <= 1)
                          {
                            i86 = 0;
                            localObject3 = localObject25;
                            k = i86;
                            int i87 = i85;
                            Object localObject26 = localObject25;
                            int i88 = i87;
                            while (true)
                            {
                              i16 = localObject26[i86];
                              switch (k % 5)
                              {
                              default:
                                i89 = 18;
                                label1908: int i90 = (char)(i89 ^ i16);
                                localObject26[i86] = i90;
                                i86 = k + 1;
                                if (i88 != 0)
                                  break label1949;
                                localObject26 = localObject3;
                                int i91 = i86;
                                i86 = i88;
                              case 0:
                              case 1:
                              case 2:
                              case 3:
                              }
                            }
                            label1949: i85 = i88;
                            localObject25 = localObject3;
                          }
                          while (true)
                          {
                            if (i85 > i86)
                              break label1841;
                            String str12 = new String((char[])localObject25).intern();
                            arrayOfString[i84] = str12;
                            int i92 = 12;
                            Object localObject27 = "d\034*\007;".toCharArray();
                            int i93 = localObject27.length;
                            int i94;
                            label2009: int i97;
                            if (i93 <= 1)
                            {
                              i94 = 0;
                              localObject3 = localObject27;
                              k = i94;
                              int i95 = i93;
                              Object localObject28 = localObject27;
                              int i96 = i95;
                              while (true)
                              {
                                i16 = localObject28[i94];
                                switch (k % 5)
                                {
                                default:
                                  i97 = 18;
                                  label2076: int i98 = (char)(i97 ^ i16);
                                  localObject28[i94] = i98;
                                  i94 = k + 1;
                                  if (i96 != 0)
                                    break label2117;
                                  localObject28 = localObject3;
                                  int i99 = i94;
                                  i94 = i96;
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                }
                              }
                              label2117: i93 = i96;
                              localObject27 = localObject3;
                            }
                            while (true)
                            {
                              if (i93 > i94)
                                break label2009;
                              String str13 = new String((char[])localObject27).intern();
                              arrayOfString[i92] = str13;
                              int i100 = 13;
                              Object localObject29 = "6\030*\033`0\0244\0232*\030-T~+\036;��{+\023".toCharArray();
                              int i101 = localObject29.length;
                              label2177: int i106;
                              label2244: int i103;
                              if (i101 <= 1)
                              {
                                int i102 = 0;
                                localObject3 = localObject29;
                                k = i102;
                                int i104 = i101;
                                Object localObject31 = localObject29;
                                int i105 = i104;
                                while (true)
                                {
                                  i16 = localObject31[i102];
                                  switch (k % 5)
                                  {
                                  default:
                                    i106 = 18;
                                    int i107 = (char)(i106 ^ i16);
                                    localObject31[i102] = i107;
                                    i103 = k + 1;
                                    if (i105 != 0)
                                      break label2285;
                                    localObject31 = localObject3;
                                    int i108 = i103;
                                    i103 = i105;
                                  case 0:
                                  case 1:
                                  case 2:
                                  case 3:
                                  }
                                }
                                label2285: i101 = i105;
                                localObject29 = localObject3;
                              }
                              while (true)
                              {
                                if (i101 > i103)
                                  break label2177;
                                String str14 = new String((char[])localObject29).intern();
                                arrayOfString[i100] = str14;
                                int i109 = 14;
                                Object localObject32 = "d\036?\030~7T".toCharArray();
                                Object localObject33 = localObject32.length;
                                label2342: Object localObject35;
                                Object localObject36;
                                label2361: int i110;
                                if (localObject33 <= 1)
                                {
                                  localObject30 = localObject32;
                                  localObject3 = localObject1;
                                  Object localObject34 = localObject33;
                                  localObject35 = localObject32;
                                  localObject36 = localObject34;
                                  i100 = localObject35[localObject1];
                                  switch (localObject3 % 5)
                                  {
                                  default:
                                    i110 = 18;
                                  case 0:
                                  case 1:
                                  case 2:
                                  case 3:
                                  }
                                }
                                while (true)
                                {
                                  int i111 = (char)(i110 ^ i100);
                                  localObject35[localObject1] = i111;
                                  localObject1 = localObject3 + 1;
                                  if (localObject36 == 0)
                                  {
                                    localObject35 = localObject30;
                                    int i112 = localObject1;
                                    localObject1 = localObject36;
                                    break label2361;
                                  }
                                  localObject33 = localObject36;
                                  localObject32 = localObject30;
                                  if (localObject33 > localObject1)
                                    break label2342;
                                  String str15 = new String((char[])localObject32).intern();
                                  arrayOfString[i109] = str15;
                                  z = arrayOfString;
                                  _sdkb = _sdkhb._sdkb(_sdkec.class);
                                  return;
                                  i2 = 68;
                                  break;
                                  i2 = 125;
                                  break;
                                  i2 = 90;
                                  break;
                                  i2 = 116;
                                  break;
                                  i8 = 68;
                                  break label244;
                                  i8 = 125;
                                  break label244;
                                  i8 = 90;
                                  break label244;
                                  i8 = 116;
                                  break label244;
                                  i17 = 68;
                                  break label408;
                                  i17 = 125;
                                  break label408;
                                  i17 = 90;
                                  break label408;
                                  i17 = 116;
                                  break label408;
                                  i25 = 68;
                                  break label572;
                                  i25 = 125;
                                  break label572;
                                  i25 = 90;
                                  break label572;
                                  i25 = 116;
                                  break label572;
                                  i33 = 68;
                                  break label736;
                                  i33 = 125;
                                  break label736;
                                  i33 = 90;
                                  break label736;
                                  i33 = 116;
                                  break label736;
                                  i41 = 68;
                                  break label900;
                                  i41 = 125;
                                  break label900;
                                  i41 = 90;
                                  break label900;
                                  i41 = 116;
                                  break label900;
                                  i49 = 68;
                                  break label1068;
                                  i49 = 125;
                                  break label1068;
                                  i49 = 90;
                                  break label1068;
                                  i49 = 116;
                                  break label1068;
                                  i57 = 68;
                                  break label1236;
                                  i57 = 125;
                                  break label1236;
                                  i57 = 90;
                                  break label1236;
                                  i57 = 116;
                                  break label1236;
                                  i65 = 68;
                                  break label1404;
                                  i65 = 125;
                                  break label1404;
                                  i65 = 90;
                                  break label1404;
                                  i65 = 116;
                                  break label1404;
                                  i73 = 68;
                                  break label1572;
                                  i73 = 125;
                                  break label1572;
                                  i73 = 90;
                                  break label1572;
                                  i73 = 116;
                                  break label1572;
                                  i81 = 68;
                                  break label1740;
                                  i81 = 125;
                                  break label1740;
                                  i81 = 90;
                                  break label1740;
                                  i81 = 116;
                                  break label1740;
                                  i89 = 68;
                                  break label1908;
                                  i89 = 125;
                                  break label1908;
                                  i89 = 90;
                                  break label1908;
                                  i89 = 116;
                                  break label1908;
                                  i97 = 68;
                                  break label2076;
                                  i97 = 125;
                                  break label2076;
                                  i97 = 90;
                                  break label2076;
                                  i97 = 116;
                                  break label2076;
                                  i106 = 68;
                                  break label2244;
                                  i106 = 125;
                                  break label2244;
                                  i106 = 90;
                                  break label2244;
                                  i106 = 116;
                                  break label2244;
                                  i110 = 68;
                                  continue;
                                  i110 = 125;
                                  continue;
                                  i110 = 90;
                                  continue;
                                  i110 = 116;
                                }
                                Object localObject30 = null;
                              }
                              i94 = 0;
                            }
                            i86 = 0;
                          }
                          i78 = 0;
                        }
                        i70 = 0;
                      }
                      i62 = 0;
                    }
                    i54 = 0;
                  }
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

  _sdkib _sdka(boolean paramBoolean, _sdkib param_sdkib, com.skyhookwireless._sdkec param_sdkec)
  {
    if (param_sdkib == null)
      this._sdka = null;
    while (true)
    {
      return param_sdkib;
      if (!paramBoolean)
      {
        _sdkhb local_sdkhb1 = _sdkb;
        String str1 = z[2];
        local_sdkhb1._sdkb(str1);
        this._sdka = null;
      }
      else if (this._sdka == null)
      {
        _sdkhb local_sdkhb2 = _sdkb;
        String str2 = z[9];
        local_sdkhb2._sdkb(str2);
        _sdkib local_sdkib1 = param_sdkib.clone();
        this._sdka = local_sdkib1;
      }
      else if ((param_sdkib._sdke()) && (this._sdka._sdke()))
      {
        _sdkhb local_sdkhb3 = _sdkb;
        String str3 = z[10];
        local_sdkhb3._sdkb(str3);
        _sdkib local_sdkib2 = param_sdkib.clone();
        this._sdka = local_sdkib2;
      }
      else
      {
        int i = this._sdka.getHPE();
        int j = param_sdkib.getHPE();
        double d1 = _sdksd._sdka(this._sdka, param_sdkib);
        double d2 = i + j;
        if (d1 <= d2)
        {
          _sdkhb local_sdkhb4 = _sdkb;
          String str4 = z[8];
          local_sdkhb4._sdkb(str4);
          int k = param_sdkib.getNCell();
          int m = this._sdka.getNCell();
          int n = Math.max(k, m);
          if (j < i)
          {
            _sdkib local_sdkib3 = param_sdkib.clone();
            this._sdka = local_sdkib3;
            _sdkhb local_sdkhb5 = _sdkb;
            String str5 = z[13];
            local_sdkhb5._sdkc(str5);
            if (Location._sdki == 0);
          }
          else
          {
            _sdkib local_sdkib4 = this._sdka;
            com.skyhookwireless._sdkec local_sdkec = param_sdkib.getAge();
            local_sdkib4.setAge(local_sdkec);
            _sdkib local_sdkib5 = this._sdka;
            long l1 = param_sdkib.getTime();
            local_sdkib5.setTime(l1);
            if (param_sdkib.hasSpeed())
            {
              _sdkib local_sdkib6 = this._sdka;
              double d3 = param_sdkib.getSpeed();
              local_sdkib6.setSpeed(d3);
            }
            _sdkhb local_sdkhb6 = _sdkb;
            String str6 = z[6];
            local_sdkhb6._sdkc(str6);
          }
          this._sdka.setNCell(n);
          param_sdkib = this._sdka;
        }
        else
        {
          _sdkhb local_sdkhb7 = _sdkb;
          String str7 = z[3];
          local_sdkhb7._sdkb(str7);
          boolean bool = _sdkb._sdkc();
          long l2 = this._sdka.getAge()._sdka(param_sdkec);
          if (l2 >= 20000L)
          {
            if (bool)
            {
              _sdkhb local_sdkhb8 = _sdkb;
              StringBuilder localStringBuilder1 = new StringBuilder();
              String str8 = z[4];
              StringBuilder localStringBuilder2 = localStringBuilder1.append(str8).append(l2);
              String str9 = z[11];
              String str10 = str9;
              local_sdkhb8._sdkc(str10);
            }
            _sdkib local_sdkib7 = param_sdkib.clone();
            this._sdka = local_sdkib7;
            param_sdkib = this._sdka;
          }
          else if (param_sdkib.getSatellites() >= 1)
          {
            if (bool)
            {
              _sdkhb local_sdkhb9 = _sdkb;
              StringBuilder localStringBuilder3 = new StringBuilder();
              String str11 = z[0];
              StringBuilder localStringBuilder4 = localStringBuilder3.append(str11);
              int i1 = param_sdkib.getSatellites();
              StringBuilder localStringBuilder5 = localStringBuilder4.append(i1);
              String str12 = z[7];
              String str13 = str12;
              local_sdkhb9._sdkc(str13);
            }
            _sdkib local_sdkib8 = param_sdkib.clone();
            this._sdka = local_sdkib8;
            param_sdkib = this._sdka;
          }
          else if (this._sdka.getSatellites() >= 1)
          {
            if (bool)
            {
              _sdkhb local_sdkhb10 = _sdkb;
              StringBuilder localStringBuilder6 = new StringBuilder();
              String str14 = z[1];
              StringBuilder localStringBuilder7 = localStringBuilder6.append(str14);
              int i2 = this._sdka.getSatellites();
              StringBuilder localStringBuilder8 = localStringBuilder7.append(i2);
              String str15 = z[7];
              String str16 = str15;
              local_sdkhb10._sdkc(str16);
            }
            param_sdkib = this._sdka;
          }
          else if (param_sdkib.getNCell() >= 1)
          {
            if (bool)
            {
              _sdkhb local_sdkhb11 = _sdkb;
              StringBuilder localStringBuilder9 = new StringBuilder();
              String str17 = z[5];
              StringBuilder localStringBuilder10 = localStringBuilder9.append(str17);
              int i3 = param_sdkib.getNCell();
              StringBuilder localStringBuilder11 = localStringBuilder10.append(i3);
              String str18 = z[14];
              String str19 = str18;
              local_sdkhb11._sdkc(str19);
            }
            _sdkib local_sdkib9 = param_sdkib.clone();
            this._sdka = local_sdkib9;
            param_sdkib = this._sdka;
          }
          else if (this._sdka.getNCell() >= 1)
          {
            if (bool)
            {
              _sdkhb local_sdkhb12 = _sdkb;
              StringBuilder localStringBuilder12 = new StringBuilder();
              String str20 = z[1];
              StringBuilder localStringBuilder13 = localStringBuilder12.append(str20);
              int i4 = this._sdka.getNCell();
              StringBuilder localStringBuilder14 = localStringBuilder13.append(i4);
              String str21 = z[14];
              String str22 = str21;
              local_sdkhb12._sdkc(str22);
            }
            param_sdkib = this._sdka;
          }
          else if (param_sdkib.getNAP() >= 3)
          {
            if (bool)
            {
              _sdkhb local_sdkhb13 = _sdkb;
              StringBuilder localStringBuilder15 = new StringBuilder();
              String str23 = z[0];
              StringBuilder localStringBuilder16 = localStringBuilder15.append(str23);
              int i5 = param_sdkib.getNAP();
              StringBuilder localStringBuilder17 = localStringBuilder16.append(i5);
              String str24 = z[12];
              String str25 = str24;
              local_sdkhb13._sdkc(str25);
            }
            _sdkib local_sdkib10 = param_sdkib.clone();
            this._sdka = local_sdkib10;
            param_sdkib = this._sdka;
          }
          else if (this._sdka.getNAP() >= 3)
          {
            if (bool)
            {
              _sdkhb local_sdkhb14 = _sdkb;
              StringBuilder localStringBuilder18 = new StringBuilder();
              String str26 = z[1];
              StringBuilder localStringBuilder19 = localStringBuilder18.append(str26);
              int i6 = this._sdka.getNAP();
              StringBuilder localStringBuilder20 = localStringBuilder19.append(i6);
              String str27 = z[12];
              String str28 = str27;
              local_sdkhb14._sdkc(str28);
            }
            param_sdkib = this._sdka;
          }
          else
          {
            int i7 = param_sdkib.getNAP();
            int i8 = this._sdka.getNAP();
            if (i7 > i8)
            {
              if (bool)
              {
                _sdkhb local_sdkhb15 = _sdkb;
                StringBuilder localStringBuilder21 = new StringBuilder();
                String str29 = z[0];
                StringBuilder localStringBuilder22 = localStringBuilder21.append(str29);
                int i9 = param_sdkib.getNAP();
                StringBuilder localStringBuilder23 = localStringBuilder22.append(i9);
                String str30 = z[12];
                String str31 = str30;
                local_sdkhb15._sdkc(str31);
              }
              _sdkib local_sdkib11 = param_sdkib.clone();
              this._sdka = local_sdkib11;
              param_sdkib = this._sdka;
            }
            else
            {
              if (bool)
              {
                _sdkhb local_sdkhb16 = _sdkb;
                StringBuilder localStringBuilder24 = new StringBuilder();
                String str32 = z[1];
                StringBuilder localStringBuilder25 = localStringBuilder24.append(str32);
                int i10 = this._sdka.getNAP();
                StringBuilder localStringBuilder26 = localStringBuilder25.append(i10);
                String str33 = z[12];
                String str34 = str33;
                local_sdkhb16._sdkc(str34);
              }
              param_sdkib = this._sdka;
            }
          }
        }
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkec
 * JD-Core Version:    0.6.2
 */