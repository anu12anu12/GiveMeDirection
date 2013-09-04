package com.skyhookwireless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.List;

final class _sdkb extends BroadcastReceiver
{
  private static final String[] z;
  final _sdkfd _sdka;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[16];
    Object localObject2 = "yN\034[\002pD\020\013\022}U\r\037WwO\034\036\031j\033H".toCharArray();
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
          i2 = 119;
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
      Object localObject5 = "iH\016\022WpN\037[\022p@\n\027\022z".toCharArray();
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
            i8 = 119;
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
        Object localObject7 = "O\f\t\030wEF\025\022j\017\037\022\021w\017?21W~;/6Jd78?_o/>3".toCharArray();
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
              i17 = 119;
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
          Object localObject9 = "O\f\t\030wEF\025\022j\017\037\022\021w\017;86P~:>$Km<(".toCharArray();
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
                i25 = 119;
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
            Object localObject11 = "yN\034[\022hD\006\017WiI\001\027\022>E\r\b\003lN\021\036\023".toCharArray();
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
                  i33 = 119;
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
              Object localObject13 = "{S\032\024\005>H\006[��wG\001[\025lN\t\037\024R\034[\005{B\r\022\001{S".toCharArray();
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
                    i41 = 119;
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
                Object localObject15 = "mB\t\025W}N\005\013\033{U\r[��wU��[".toCharArray();
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
                      i49 = 119;
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
                  Object localObject17 = "sR".toCharArray();
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
                        i57 = 119;
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
                    Object localObject19 = "mB\t\025\031{EH\032\007m\033H".toCharArray();
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
                          i65 = 119;
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
                      Object localObject21 = "iH\016\022WzH\033\032\025rD\f[\023kS\001\025\020>R\013\032\031".toCharArray();
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
                            i73 = 119;
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
                        Object localObject23 = ">`8\b".toCharArray();
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
                              i81 = 119;
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
                          Object localObject25 = "r@\034\036\004j\001\033\030\026p\001\032\036\004kM\034\bWS\r[\022sQ\034\002".toCharArray();
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
                                i89 = 119;
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
                            Object localObject27 = "mB\t\025WlD\033\016\033jRH\037\036zOO\017W}N\006\017\026wOH\017\037{\001\013\024\031pD\013\017\022z\001)+[>@\f\037\036pFH\022\003".toCharArray();
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
                                  i97 = 119;
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
                              Object localObject29 = "iH\016\022WpN\037[\023wR\t\031\033{E".toCharArray();
                              int i101 = localObject29.length;
                              int i102;
                              label2177: int i105;
                              if (i101 <= 1)
                              {
                                i102 = 0;
                                localObject3 = localObject29;
                                k = i102;
                                int i103 = i101;
                                Object localObject30 = localObject29;
                                int i104 = i103;
                                while (true)
                                {
                                  i16 = localObject30[i102];
                                  switch (k % 5)
                                  {
                                  default:
                                    i105 = 119;
                                    label2244: int i106 = (char)(i105 ^ i16);
                                    localObject30[i102] = i106;
                                    i102 = k + 1;
                                    if (i104 != 0)
                                      break label2285;
                                    localObject30 = localObject3;
                                    int i107 = i102;
                                    i102 = i104;
                                  case 0:
                                  case 1:
                                  case 2:
                                  case 3:
                                  }
                                }
                                label2285: i101 = i104;
                                localObject29 = localObject3;
                              }
                              while (true)
                              {
                                if (i101 > i102)
                                  break label2177;
                                String str14 = new String((char[])localObject29).intern();
                                arrayOfString[i100] = str14;
                                int i108 = 14;
                                Object localObject31 = ">`8\bWwOH".toCharArray();
                                int i109 = localObject31.length;
                                label2345: int i114;
                                label2412: int i111;
                                if (i109 <= 1)
                                {
                                  int i110 = 0;
                                  localObject3 = localObject31;
                                  k = i110;
                                  int i112 = i109;
                                  Object localObject33 = localObject31;
                                  int i113 = i112;
                                  while (true)
                                  {
                                    i16 = localObject33[i110];
                                    switch (k % 5)
                                    {
                                    default:
                                      i114 = 119;
                                      int i115 = (char)(i114 ^ i16);
                                      localObject33[i110] = i115;
                                      i111 = k + 1;
                                      if (i113 != 0)
                                        break label2453;
                                      localObject33 = localObject3;
                                      int i116 = i111;
                                      i111 = i113;
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    }
                                  }
                                  label2453: i109 = i113;
                                  localObject31 = localObject3;
                                }
                                while (true)
                                {
                                  if (i109 > i111)
                                    break label2345;
                                  String str15 = new String((char[])localObject31).intern();
                                  arrayOfString[i108] = str15;
                                  int i117 = 15;
                                  Object localObject34 = "iH\016\022WmU\t\017\022>B��\032\031yD\fAW".toCharArray();
                                  Object localObject35 = localObject34.length;
                                  label2510: Object localObject37;
                                  Object localObject38;
                                  label2529: int i118;
                                  if (localObject35 <= 1)
                                  {
                                    localObject32 = localObject34;
                                    localObject3 = localObject1;
                                    Object localObject36 = localObject35;
                                    localObject37 = localObject34;
                                    localObject38 = localObject36;
                                    i108 = localObject37[localObject1];
                                    switch (localObject3 % 5)
                                    {
                                    default:
                                      i118 = 119;
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    }
                                  }
                                  while (true)
                                  {
                                    int i119 = (char)(i118 ^ i108);
                                    localObject37[localObject1] = i119;
                                    localObject1 = localObject3 + 1;
                                    if (localObject38 == 0)
                                    {
                                      localObject37 = localObject32;
                                      int i120 = localObject1;
                                      localObject1 = localObject38;
                                      break label2529;
                                    }
                                    localObject35 = localObject38;
                                    localObject34 = localObject32;
                                    if (localObject35 > localObject1)
                                      break label2510;
                                    String str16 = new String((char[])localObject34).intern();
                                    arrayOfString[i117] = str16;
                                    z = arrayOfString;
                                    return;
                                    i2 = 30;
                                    break;
                                    i2 = 33;
                                    break;
                                    i2 = 104;
                                    break;
                                    i2 = 123;
                                    break;
                                    i8 = 30;
                                    break label244;
                                    i8 = 33;
                                    break label244;
                                    i8 = 104;
                                    break label244;
                                    i8 = 123;
                                    break label244;
                                    i17 = 30;
                                    break label408;
                                    i17 = 33;
                                    break label408;
                                    i17 = 104;
                                    break label408;
                                    i17 = 123;
                                    break label408;
                                    i25 = 30;
                                    break label572;
                                    i25 = 33;
                                    break label572;
                                    i25 = 104;
                                    break label572;
                                    i25 = 123;
                                    break label572;
                                    i33 = 30;
                                    break label736;
                                    i33 = 33;
                                    break label736;
                                    i33 = 104;
                                    break label736;
                                    i33 = 123;
                                    break label736;
                                    i41 = 30;
                                    break label900;
                                    i41 = 33;
                                    break label900;
                                    i41 = 104;
                                    break label900;
                                    i41 = 123;
                                    break label900;
                                    i49 = 30;
                                    break label1068;
                                    i49 = 33;
                                    break label1068;
                                    i49 = 104;
                                    break label1068;
                                    i49 = 123;
                                    break label1068;
                                    i57 = 30;
                                    break label1236;
                                    i57 = 33;
                                    break label1236;
                                    i57 = 104;
                                    break label1236;
                                    i57 = 123;
                                    break label1236;
                                    i65 = 30;
                                    break label1404;
                                    i65 = 33;
                                    break label1404;
                                    i65 = 104;
                                    break label1404;
                                    i65 = 123;
                                    break label1404;
                                    i73 = 30;
                                    break label1572;
                                    i73 = 33;
                                    break label1572;
                                    i73 = 104;
                                    break label1572;
                                    i73 = 123;
                                    break label1572;
                                    i81 = 30;
                                    break label1740;
                                    i81 = 33;
                                    break label1740;
                                    i81 = 104;
                                    break label1740;
                                    i81 = 123;
                                    break label1740;
                                    i89 = 30;
                                    break label1908;
                                    i89 = 33;
                                    break label1908;
                                    i89 = 104;
                                    break label1908;
                                    i89 = 123;
                                    break label1908;
                                    i97 = 30;
                                    break label2076;
                                    i97 = 33;
                                    break label2076;
                                    i97 = 104;
                                    break label2076;
                                    i97 = 123;
                                    break label2076;
                                    i105 = 30;
                                    break label2244;
                                    i105 = 33;
                                    break label2244;
                                    i105 = 104;
                                    break label2244;
                                    i105 = 123;
                                    break label2244;
                                    i114 = 30;
                                    break label2412;
                                    i114 = 33;
                                    break label2412;
                                    i114 = 104;
                                    break label2412;
                                    i114 = 123;
                                    break label2412;
                                    i118 = 30;
                                    continue;
                                    i118 = 33;
                                    continue;
                                    i118 = 104;
                                    continue;
                                    i118 = 123;
                                  }
                                  Object localObject32 = null;
                                }
                                i102 = 0;
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

  private _sdkb(_sdkfd param_sdkfd)
  {
  }

  _sdkb(_sdkfd param_sdkfd, _sdkkc param_sdkkc)
  {
    this(param_sdkfd);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    boolean bool1 = _sdkic._sdkc;
    int i;
    try
    {
      synchronized (this._sdka)
      {
        if (!_sdkfd._sdkc(this._sdka))
        {
          _sdkhb local_sdkhb1 = _sdkfd._sdka(this._sdka);
          String str1 = z[4];
          local_sdkhb1._sdkb(str1);
          return;
        }
        String str2 = paramIntent.getAction();
        String str3 = z[3];
        if (!str2.equals(str3))
          break label633;
        i = _sdkfd._sdkd(this._sdka).getScanResults();
        if (i == 0)
        {
          _sdkhb local_sdkhb2 = _sdkfd._sdka(this._sdka);
          String str4 = z[11];
          local_sdkhb2._sdkd(str4);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb3 = _sdkfd._sdka(this._sdka);
      String str5 = z[5];
      local_sdkhb3._sdke(str5, localThrowable);
      return;
    }
    if (_sdkfd._sdka(this._sdka)._sdkb())
      if (_sdkfd._sdke(this._sdka) != null)
      {
        long l1 = _sdkfd._sdke(this._sdka)._sdka();
        _sdkhb local_sdkhb4 = _sdkfd._sdka(this._sdka);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str6 = z[6];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str6);
        int k = i.size();
        StringBuilder localStringBuilder3 = localStringBuilder2.append(k);
        String str7 = z[14];
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str7).append(l1);
        String str8 = z[7];
        String str9 = str8;
        local_sdkhb4._sdkb(str9);
        if (!bool1);
      }
      else
      {
        _sdkhb local_sdkhb5 = _sdkfd._sdka(this._sdka);
        StringBuilder localStringBuilder5 = new StringBuilder();
        String str10 = z[6];
        StringBuilder localStringBuilder6 = localStringBuilder5.append(str10);
        int m = i.size();
        StringBuilder localStringBuilder7 = localStringBuilder6.append(m);
        String str11 = z[10];
        String str12 = str11;
        local_sdkhb5._sdkb(str12);
      }
    if (_sdkfd._sdkf(this._sdka))
      _sdkfd._sdka(this._sdka, true);
    long l2 = System.currentTimeMillis();
    _sdkec local_sdkec = _sdkec._sdkd();
    _sdkfd local_sdkfd2 = this._sdka;
    ArrayList localArrayList1 = _sdkfd._sdkg(this._sdka);
    _sdkfd._sdka(local_sdkfd2, i, l2, local_sdkec, localArrayList1);
    WifiInfo localWifiInfo = _sdkfd._sdkd(this._sdka).getConnectionInfo();
    Object localObject3 = _sdkfd._sdka(this._sdka, localWifiInfo, l2, local_sdkec);
    if ((localObject3 != null) && (!_sdkfd._sdkb(_sdkfd._sdkg(this._sdka), (_sdkjc)localObject3)))
    {
      _sdkhb local_sdkhb6 = _sdkfd._sdka(this._sdka);
      String str13 = z[12];
      local_sdkhb6._sdkb(str13);
      boolean bool2 = _sdkfd._sdkg(this._sdka).add(localObject3);
    }
    if (_sdkfd._sdka(this._sdka)._sdkb())
    {
      _sdkhb local_sdkhb7 = _sdkfd._sdka(this._sdka);
      StringBuilder localStringBuilder8 = new StringBuilder();
      String str14 = z[8];
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str14);
      ArrayList localArrayList2 = _sdkfd._sdkg(this._sdka);
      String str15 = localArrayList2;
      local_sdkhb7._sdkb(str15);
    }
    if (_sdkfd._sdkh(this._sdka)._sdkc())
      _sdkfd._sdkh(this._sdka)._sdkb();
    boolean bool3 = _sdkfd._sdkb(this._sdka, false);
    if (bool1)
    {
      localObject3 = null;
      label633: String str16 = paramIntent.getAction();
      String str17 = z[2];
      if (str16.equals(str17))
      {
        int j = _sdkfd._sdkd(this._sdka).getWifiState();
        if (_sdkfd._sdka(this._sdka)._sdkb())
        {
          _sdkhb local_sdkhb8 = _sdkfd._sdka(this._sdka);
          StringBuilder localStringBuilder10 = new StringBuilder();
          String str18 = z[15];
          String str19 = str18 + j;
          local_sdkhb8._sdkb(str19);
        }
        if (j == 3)
        {
          _sdkhb local_sdkhb9 = _sdkfd._sdka(this._sdka);
          String str20 = z[1];
          local_sdkhb9._sdkb(str20);
          if (bool1)
            localObject3 = null;
        }
        else
        {
          if (j != 1)
            break label849;
          if (!_sdkfd._sdkf(this._sdka))
            break label918;
          _sdkhb local_sdkhb10 = _sdkfd._sdka(this._sdka);
          String str21 = z[9];
          local_sdkhb10._sdkb(str21);
          boolean bool4 = _sdkfd._sdkb(this._sdka, false);
          if (bool1)
          {
            _sdkhb local_sdkhb11 = _sdkfd._sdka(this._sdka);
            String str22 = z[13];
            local_sdkhb11._sdkb(str22);
          }
        }
        localObject3 = localObject4;
        label849: if (!bool1);
      }
      else
      {
        _sdkhb local_sdkhb12 = _sdkfd._sdka(this._sdka);
        StringBuilder localStringBuilder11 = new StringBuilder();
        String str23 = z[0];
        String str24 = str23 + paramIntent;
        local_sdkhb12._sdkd(str24);
      }
    }
    while (true)
    {
      if (localObject3 == null)
        return;
      _sdkfd._sdki(this._sdka);
      return;
      label918: localObject4 = localObject3;
      break;
      localObject3 = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkb
 * JD-Core Version:    0.6.2
 */