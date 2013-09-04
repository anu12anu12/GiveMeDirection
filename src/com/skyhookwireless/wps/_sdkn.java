package com.skyhookwireless.wps;

import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdknd;
import com.skyhookwireless._sdkpd;
import com.skyhookwireless._sdktb;
import com.skyhookwireless._sdktd;
import com.skyhookwireless._sdkwb;
import java.util.ArrayList;
import java.util.List;

final class _sdkn
  implements _sdkvc
{
  static final boolean _sdkn;
  private static final String[] z;
  private final _sdkhb _sdka;
  private final _sdkxb _sdkb;
  private final WPSAuthentication _sdkc;
  private final _sdkec _sdkd;
  private final WPSLocationCallback _sdke;
  private final WPSStreetAddressLookup _sdkf;
  private final _sdkzb _sdkg;
  private final long _sdkh;
  private _sdkib _sdki;
  private boolean _sdkj;
  private WPSReturnCode _sdkk;
  private int _sdkl;
  private int _sdkm;
  final _sdkf _sdko;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[15];
    Object localObject1 = "O{jw\030M:wt]Nw;\021Fybo\024Ft#}\017Fw#h\030[lfiG\t".toCharArray();
    int j = localObject1.length;
    int k;
    Object localObject2;
    int m;
    int i2;
    int i3;
    if (j <= i)
    {
      k = 0;
      localObject2 = localObject1;
      m = k;
      int n = j;
      Object localObject3 = localObject1;
      int i1 = n;
      while (true)
      {
        i2 = localObject3[k];
        switch (m % 5)
        {
        default:
          i3 = 125;
          int i4 = (char)(i3 ^ i2);
          localObject3[k] = i4;
          k = m + 1;
          if (i1 != 0)
            break label129;
          localObject3 = localObject2;
          m = k;
          k = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: j = i1;
      localObject1 = localObject2;
    }
    while (j <= k)
    {
      String str1 = new String((char[])localObject1).intern();
      arrayOfString[0] = str1;
      Object localObject4 = "Di".toCharArray();
      int i5 = localObject4.length;
      int i6;
      label180: int i9;
      if (i5 <= 1)
      {
        i6 = 0;
        localObject2 = localObject4;
        m = i6;
        int i7 = i5;
        Object localObject5 = localObject4;
        int i8 = i7;
        while (true)
        {
          i2 = localObject5[i6];
          switch (m % 5)
          {
          default:
            i9 = 125;
            label244: int i10 = (char)(i9 ^ i2);
            localObject5[i6] = i10;
            i6 = m + 1;
            if (i8 != 0)
              break label285;
            localObject5 = localObject2;
            int i11 = i6;
            i6 = i8;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i5 = i8;
        localObject4 = localObject2;
      }
      while (true)
      {
        if (i5 > i6)
          break label180;
        String str2 = new String((char[])localObject4).intern();
        arrayOfString[1] = str2;
        int i12 = 2;
        Object localObject6 = "\t[Sh]Zu#}\034[2".toCharArray();
        int i13 = localObject6.length;
        int i14;
        label343: int i17;
        int i18;
        if (i13 <= 1)
        {
          i14 = 0;
          localObject2 = localObject6;
          m = i14;
          int i15 = i13;
          Object localObject7 = localObject6;
          int i16 = i15;
          while (true)
          {
            i17 = localObject7[i14];
            switch (m % 5)
            {
            default:
              i18 = 125;
              label408: int i19 = (char)(i18 ^ i17);
              localObject7[i14] = i19;
              i14 = m + 1;
              if (i16 != 0)
                break label449;
              localObject7 = localObject2;
              int i20 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i13 = i16;
          localObject6 = localObject2;
        }
        while (true)
        {
          if (i13 > i14)
            break label343;
          String str3 = new String((char[])localObject6).intern();
          arrayOfString[i12] = str3;
          Object localObject8 = "Zqm\030[:`z\023\016n#\030]qv\024G#w\022J{wr\022G".toCharArray();
          int i21 = localObject8.length;
          int i22;
          label505: int i25;
          if (i21 <= 1)
          {
            i22 = 0;
            localObject2 = localObject8;
            m = i22;
            int i23 = i21;
            Object localObject9 = localObject8;
            int i24 = i23;
            while (true)
            {
              i12 = localObject9[i22];
              switch (m % 5)
              {
              default:
                i25 = 125;
                label572: int i26 = (char)(i25 ^ i12);
                localObject9[i22] = i26;
                i22 = m + 1;
                if (i24 != 0)
                  break label613;
                localObject9 = localObject2;
                int i27 = i22;
                i22 = i24;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label613: i21 = i24;
            localObject8 = localObject2;
          }
          while (true)
          {
            if (i21 > i22)
              break label505;
            String str4 = new String((char[])localObject8).intern();
            arrayOfString[3] = str4;
            int i28 = 4;
            Object localObject10 = "Eu`z\t@um;U[nt\tL39;".toCharArray();
            int i29 = localObject10.length;
            int i30;
            label671: int i33;
            if (i29 <= 1)
            {
              i30 = 0;
              localObject2 = localObject10;
              m = i30;
              int i31 = i29;
              Object localObject11 = localObject10;
              int i32 = i31;
              while (true)
              {
                i17 = localObject11[i30];
                switch (m % 5)
                {
                default:
                  i33 = 125;
                  label736: int i34 = (char)(i33 ^ i17);
                  localObject11[i30] = i34;
                  i30 = m + 1;
                  if (i32 != 0)
                    break label777;
                  localObject11 = localObject2;
                  int i35 = i30;
                  i30 = i32;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i29 = i32;
              localObject10 = localObject2;
            }
            while (true)
            {
              if (i29 > i30)
                break label671;
              String str5 = new String((char[])localObject10).intern();
              arrayOfString[i28] = str5;
              int i36 = 5;
              Object localObject12 = "Eu`z\t@um;\017Lkv~\016]:pn\036Jf\030M:q~\020Fnfw\004\023:".toCharArray();
              int i37 = localObject12.length;
              int i38;
              label836: int i41;
              if (i37 <= 1)
              {
                i38 = 0;
                localObject2 = localObject12;
                m = i38;
                int i39 = i37;
                Object localObject13 = localObject12;
                int i40 = i39;
                while (true)
                {
                  i17 = localObject13[i38];
                  switch (m % 5)
                  {
                  default:
                    i41 = 125;
                    label900: int i42 = (char)(i41 ^ i17);
                    localObject13[i38] = i42;
                    i38 = m + 1;
                    if (i40 != 0)
                      break label941;
                    localObject13 = localObject2;
                    int i43 = i38;
                    i38 = i40;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i37 = i40;
                localObject12 = localObject2;
              }
              while (true)
              {
                if (i37 > i38)
                  break label836;
                String str6 = new String((char[])localObject12).intern();
                arrayOfString[i36] = str6;
                int i44 = 6;
                Object localObject14 = "Gt;<yi#h\024Gyf;\021Hiw;\017Lwlo\030\tvlx\034]slu][rn\030Zn9;".toCharArray();
                int i45 = localObject14.length;
                int i46;
                label1001: int i49;
                if (i45 <= 1)
                {
                  i46 = 0;
                  localObject2 = localObject14;
                  m = i46;
                  int i47 = i45;
                  Object localObject15 = localObject14;
                  int i48 = i47;
                  while (true)
                  {
                    i17 = localObject15[i46];
                    switch (m % 5)
                    {
                    default:
                      i49 = 125;
                      label1068: int i50 = (char)(i49 ^ i17);
                      localObject15[i46] = i50;
                      i46 = m + 1;
                      if (i48 != 0)
                        break label1109;
                      localObject15 = localObject2;
                      int i51 = i46;
                      i46 = i48;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i45 = i48;
                  localObject14 = localObject2;
                }
                while (true)
                {
                  if (i45 > i46)
                    break label1001;
                  String str7 = new String((char[])localObject14).intern();
                  arrayOfString[i44] = str7;
                  int i52 = 7;
                  Object localObject16 = "\toz\rZg;".toCharArray();
                  int i53 = localObject16.length;
                  int i54;
                  label1169: int i57;
                  if (i53 <= 1)
                  {
                    i54 = 0;
                    localObject2 = localObject16;
                    m = i54;
                    int i55 = i53;
                    Object localObject17 = localObject16;
                    int i56 = i55;
                    while (true)
                    {
                      i17 = localObject17[i54];
                      switch (m % 5)
                      {
                      default:
                        i57 = 125;
                        label1236: int i58 = (char)(i57 ^ i17);
                        localObject17[i54] = i58;
                        i54 = m + 1;
                        if (i56 != 0)
                          break label1277;
                        localObject17 = localObject2;
                        int i59 = i54;
                        i54 = i56;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i53 = i56;
                    localObject16 = localObject2;
                  }
                  while (true)
                  {
                    if (i53 > i54)
                      break label1169;
                    String str8 = new String((char[])localObject16).intern();
                    arrayOfString[i52] = str8;
                    int i60 = 8;
                    Object localObject18 = "Eu`z\t@um;UEu`z\021�� #".toCharArray();
                    int i61 = localObject18.length;
                    int i62;
                    label1337: int i65;
                    if (i61 <= 1)
                    {
                      i62 = 0;
                      localObject2 = localObject18;
                      m = i62;
                      int i63 = i61;
                      Object localObject19 = localObject18;
                      int i64 = i63;
                      while (true)
                      {
                        i17 = localObject19[i62];
                        switch (m % 5)
                        {
                        default:
                          i65 = 125;
                          label1404: int i66 = (char)(i65 ^ i17);
                          localObject19[i62] = i66;
                          i62 = m + 1;
                          if (i64 != 0)
                            break label1445;
                          localObject19 = localObject2;
                          int i67 = i62;
                          i62 = i64;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1445: i61 = i64;
                      localObject18 = localObject2;
                    }
                    while (true)
                    {
                      if (i61 > i62)
                        break label1337;
                      String str9 = new String((char[])localObject18).intern();
                      arrayOfString[i60] = str9;
                      int i68 = 9;
                      Object localObject20 = "Eu`z\t@um;\017Lkv~\016]:pn\036Jf\030M:ot\036HvobG\t".toCharArray();
                      int i69 = localObject20.length;
                      int i70;
                      label1505: int i73;
                      if (i69 <= 1)
                      {
                        i70 = 0;
                        localObject2 = localObject20;
                        m = i70;
                        int i71 = i69;
                        Object localObject21 = localObject20;
                        int i72 = i71;
                        while (true)
                        {
                          i17 = localObject21[i70];
                          switch (m % 5)
                          {
                          default:
                            i73 = 125;
                            label1572: int i74 = (char)(i73 ^ i17);
                            localObject21[i70] = i74;
                            i70 = m + 1;
                            if (i72 != 0)
                              break label1613;
                            localObject21 = localObject2;
                            int i75 = i70;
                            i70 = i72;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1613: i69 = i72;
                        localObject20 = localObject2;
                      }
                      while (true)
                      {
                        if (i69 > i70)
                          break label1505;
                        String str10 = new String((char[])localObject20).intern();
                        arrayOfString[i68] = str10;
                        int i76 = 10;
                        Object localObject22 = "Zqm\030[:q~\033\\if][rn\030Zn".toCharArray();
                        int i77 = localObject22.length;
                        int i78;
                        label1673: int i81;
                        if (i77 <= 1)
                        {
                          i78 = 0;
                          localObject2 = localObject22;
                          m = i78;
                          int i79 = i77;
                          Object localObject23 = localObject22;
                          int i80 = i79;
                          while (true)
                          {
                            i17 = localObject23[i78];
                            switch (m % 5)
                            {
                            default:
                              i81 = 125;
                              label1740: int i82 = (char)(i81 ^ i17);
                              localObject23[i78] = i82;
                              i78 = m + 1;
                              if (i80 != 0)
                                break label1781;
                              localObject23 = localObject2;
                              int i83 = i78;
                              i78 = i80;
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            }
                          }
                          label1781: i77 = i80;
                          localObject22 = localObject2;
                        }
                        while (true)
                        {
                          if (i77 > i78)
                            break label1673;
                          String str11 = new String((char[])localObject22).intern();
                          arrayOfString[i76] = str11;
                          int i84 = 11;
                          Object localObject24 = "Jrfx\026@td;\021Fybo\024Ft#r\023\tybx\025L:+~\021Hjp~\031\tnjv\030\023:".toCharArray();
                          int i85 = localObject24.length;
                          int i86;
                          label1841: int i89;
                          if (i85 <= 1)
                          {
                            i86 = 0;
                            localObject2 = localObject24;
                            m = i86;
                            int i87 = i85;
                            Object localObject25 = localObject24;
                            int i88 = i87;
                            while (true)
                            {
                              i17 = localObject25[i86];
                              switch (m % 5)
                              {
                              default:
                                i89 = 125;
                                label1908: int i90 = (char)(i89 ^ i17);
                                localObject25[i86] = i90;
                                i86 = m + 1;
                                if (i88 != 0)
                                  break label1949;
                                localObject25 = localObject2;
                                int i91 = i86;
                                i86 = i88;
                              case 0:
                              case 1:
                              case 2:
                              case 3:
                              }
                            }
                            label1949: i85 = i88;
                            localObject24 = localObject2;
                          }
                          while (true)
                          {
                            if (i85 > i86)
                              break label1841;
                            String str12 = new String((char[])localObject24).intern();
                            arrayOfString[i84] = str12;
                            int i92 = 12;
                            Object localObject26 = "Zybu\023L~#".toCharArray();
                            int i93 = localObject26.length;
                            int i94;
                            label2009: int i97;
                            if (i93 <= 1)
                            {
                              i94 = 0;
                              localObject2 = localObject26;
                              m = i94;
                              int i95 = i93;
                              Object localObject27 = localObject26;
                              int i96 = i95;
                              while (true)
                              {
                                i17 = localObject27[i94];
                                switch (m % 5)
                                {
                                default:
                                  i97 = 125;
                                  label2076: int i98 = (char)(i97 ^ i17);
                                  localObject27[i94] = i98;
                                  i94 = m + 1;
                                  if (i96 != 0)
                                    break label2117;
                                  localObject27 = localObject2;
                                  int i99 = i94;
                                  i94 = i96;
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                }
                              }
                              label2117: i93 = i96;
                              localObject26 = localObject2;
                            }
                            while (true)
                            {
                              if (i93 > i94)
                                break label2009;
                              String str13 = new String((char[])localObject26).intern();
                              arrayOfString[i92] = str13;
                              int i100 = 13;
                              Object localObject28 = "Ouvu\031\tvlx\034]slu]@t#x\034Jrf;\n@nk;\023Hj#&]".toCharArray();
                              int i101 = localObject28.length;
                              int i102;
                              label2177: int i105;
                              if (i101 <= 1)
                              {
                                i102 = 0;
                                localObject2 = localObject28;
                                m = i102;
                                int i103 = i101;
                                Object localObject29 = localObject28;
                                int i104 = i103;
                                while (true)
                                {
                                  i17 = localObject29[i102];
                                  switch (m % 5)
                                  {
                                  default:
                                    i105 = 125;
                                    label2244: int i106 = (char)(i105 ^ i17);
                                    localObject29[i102] = i106;
                                    i102 = m + 1;
                                    if (i104 != 0)
                                      break label2285;
                                    localObject29 = localObject2;
                                    int i107 = i102;
                                    i102 = i104;
                                  case 0:
                                  case 1:
                                  case 2:
                                  case 3:
                                  }
                                }
                                label2285: i101 = i104;
                                localObject28 = localObject2;
                              }
                              while (true)
                              {
                                if (i101 > i102)
                                  break label2177;
                                String str14 = new String((char[])localObject28).intern();
                                arrayOfString[i100] = str14;
                                int i108 = 14;
                                Object localObject30 = "Gt;\036Lvoh]Zsmx\030\tvbh\t\thfv\022]#w\022J{wr\022G:q~\f\\poG\t".toCharArray();
                                int i109 = localObject30.length;
                                int i110;
                                label2345: int i113;
                                if (i109 <= 1)
                                {
                                  i110 = 0;
                                  localObject2 = localObject30;
                                  m = i110;
                                  int i111 = i109;
                                  Object localObject31 = localObject30;
                                  int i112 = i111;
                                  while (true)
                                  {
                                    i17 = localObject31[i110];
                                    switch (m % 5)
                                    {
                                    default:
                                      i113 = 125;
                                      label2412: int i114 = (char)(i113 ^ i17);
                                      localObject31[i110] = i114;
                                      i110 = m + 1;
                                      if (i112 != 0)
                                        break label2453;
                                      localObject31 = localObject2;
                                      int i115 = i110;
                                      i110 = i112;
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    }
                                  }
                                  label2453: i109 = i112;
                                  localObject30 = localObject2;
                                }
                                while (true)
                                {
                                  if (i109 > i110)
                                    break label2345;
                                  String str15 = new String((char[])localObject30).intern();
                                  arrayOfString[i108] = str15;
                                  z = arrayOfString;
                                  if (!_sdkf.class.desiredAssertionStatus());
                                  while (true)
                                  {
                                    _sdkn = i;
                                    return;
                                    i = 0;
                                  }
                                  i3 = 41;
                                  break;
                                  i3 = 26;
                                  break;
                                  i3 = 3;
                                  break;
                                  i3 = 27;
                                  break;
                                  i9 = 41;
                                  break label244;
                                  i9 = 26;
                                  break label244;
                                  i9 = 3;
                                  break label244;
                                  i9 = 27;
                                  break label244;
                                  i18 = 41;
                                  break label408;
                                  i18 = 26;
                                  break label408;
                                  i18 = 3;
                                  break label408;
                                  i18 = 27;
                                  break label408;
                                  i25 = 41;
                                  break label572;
                                  i25 = 26;
                                  break label572;
                                  i25 = 3;
                                  break label572;
                                  i25 = 27;
                                  break label572;
                                  i33 = 41;
                                  break label736;
                                  i33 = 26;
                                  break label736;
                                  i33 = 3;
                                  break label736;
                                  i33 = 27;
                                  break label736;
                                  i41 = 41;
                                  break label900;
                                  i41 = 26;
                                  break label900;
                                  i41 = 3;
                                  break label900;
                                  i41 = 27;
                                  break label900;
                                  i49 = 41;
                                  break label1068;
                                  i49 = 26;
                                  break label1068;
                                  i49 = 3;
                                  break label1068;
                                  i49 = 27;
                                  break label1068;
                                  i57 = 41;
                                  break label1236;
                                  i57 = 26;
                                  break label1236;
                                  i57 = 3;
                                  break label1236;
                                  i57 = 27;
                                  break label1236;
                                  i65 = 41;
                                  break label1404;
                                  i65 = 26;
                                  break label1404;
                                  i65 = 3;
                                  break label1404;
                                  i65 = 27;
                                  break label1404;
                                  i73 = 41;
                                  break label1572;
                                  i73 = 26;
                                  break label1572;
                                  i73 = 3;
                                  break label1572;
                                  i73 = 27;
                                  break label1572;
                                  i81 = 41;
                                  break label1740;
                                  i81 = 26;
                                  break label1740;
                                  i81 = 3;
                                  break label1740;
                                  i81 = 27;
                                  break label1740;
                                  i89 = 41;
                                  break label1908;
                                  i89 = 26;
                                  break label1908;
                                  i89 = 3;
                                  break label1908;
                                  i89 = 27;
                                  break label1908;
                                  i97 = 41;
                                  break label2076;
                                  i97 = 26;
                                  break label2076;
                                  i97 = 3;
                                  break label2076;
                                  i97 = 27;
                                  break label2076;
                                  i105 = 41;
                                  break label2244;
                                  i105 = 26;
                                  break label2244;
                                  i105 = 3;
                                  break label2244;
                                  i105 = 27;
                                  break label2244;
                                  i113 = 41;
                                  break label2412;
                                  i113 = 26;
                                  break label2412;
                                  i113 = 3;
                                  break label2412;
                                  i113 = 27;
                                  break label2412;
                                  i110 = 0;
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
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  private _sdkn(_sdkf param_sdkf, WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, long paramLong, WPSLocationCallback paramWPSLocationCallback)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkn.class);
    this._sdka = local_sdkhb;
    _sdkxb local_sdkxb = new _sdkxb();
    this._sdkb = local_sdkxb;
    _sdkec local_sdkec = _sdkec._sdkd();
    this._sdkd = local_sdkec;
    this._sdkc = paramWPSAuthentication;
    this._sdkf = paramWPSStreetAddressLookup;
    this._sdki = null;
    this._sdke = paramWPSLocationCallback;
    _sdkzb local_sdkzb = new _sdkzb();
    this._sdkg = local_sdkzb;
    WPSReturnCode localWPSReturnCode = WPSReturnCode.WPS_ERROR_NO_WIFI_IN_RANGE;
    this._sdkk = localWPSReturnCode;
    this._sdkl = 0;
    this._sdkm = 0;
    this._sdkh = paramLong;
  }

  _sdkn(_sdkf param_sdkf, WPSAuthentication paramWPSAuthentication, WPSStreetAddressLookup paramWPSStreetAddressLookup, long paramLong, WPSLocationCallback paramWPSLocationCallback, _sdkh param_sdkh)
  {
    this(param_sdkf, paramWPSAuthentication, paramWPSStreetAddressLookup, paramLong, paramWPSLocationCallback);
  }

  /** @deprecated */
  private boolean _sdka()
  {
    try
    {
      boolean bool = this._sdkj;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void abort()
  {
    this._sdkb._sdka();
    try
    {
      this._sdkj = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public void done()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 138	com/skyhookwireless/wps/_sdkn:_sdkk	Lcom/skyhookwireless/wps/WPSReturnCode;
    //   4: astore_1
    //   5: getstatic 156	com/skyhookwireless/wps/WPSReturnCode:WPS_OK	Lcom/skyhookwireless/wps/WPSReturnCode;
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: if_acmpne +108 -> 119
    //   14: getstatic 94	com/skyhookwireless/wps/_sdkn:_sdkn	Z
    //   17: ifne +53 -> 70
    //   20: aload_0
    //   21: getfield 124	com/skyhookwireless/wps/_sdkn:_sdki	Lcom/skyhookwireless/wps/_sdkib;
    //   24: ifnonnull +46 -> 70
    //   27: new 158	java/lang/AssertionError
    //   30: dup
    //   31: invokespecial 159	java/lang/AssertionError:<init>	()V
    //   34: athrow
    //   35: astore_3
    //   36: aload_0
    //   37: monitorenter
    //   38: iconst_0
    //   39: istore 4
    //   41: aload_0
    //   42: iload 4
    //   44: putfield 149	com/skyhookwireless/wps/_sdkn:_sdkj	Z
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: getfield 97	com/skyhookwireless/wps/_sdkn:_sdko	Lcom/skyhookwireless/wps/_sdkf;
    //   53: getfield 162	com/skyhookwireless/wps/_sdkf:_sdke	Lcom/skyhookwireless/wps/_sdknb;
    //   56: invokevirtual 166	com/skyhookwireless/wps/_sdknb:_sdkb	()V
    //   59: aload_0
    //   60: getfield 126	com/skyhookwireless/wps/_sdkn:_sdke	Lcom/skyhookwireless/wps/WPSLocationCallback;
    //   63: invokeinterface 170 1 0
    //   68: aload_3
    //   69: athrow
    //   70: aload_0
    //   71: getfield 124	com/skyhookwireless/wps/_sdkn:_sdki	Lcom/skyhookwireless/wps/_sdkib;
    //   74: astore 5
    //   76: aload_0
    //   77: getfield 131	com/skyhookwireless/wps/_sdkn:_sdkg	Lcom/skyhookwireless/wps/_sdkzb;
    //   80: astore 6
    //   82: aload 5
    //   84: aload 6
    //   86: putfield 175	com/skyhookwireless/wps/_sdkib:_sdkp	Lcom/skyhookwireless/wps/_sdkzb;
    //   89: aload_0
    //   90: getfield 126	com/skyhookwireless/wps/_sdkn:_sdke	Lcom/skyhookwireless/wps/WPSLocationCallback;
    //   93: astore 7
    //   95: aload_0
    //   96: getfield 124	com/skyhookwireless/wps/_sdkn:_sdki	Lcom/skyhookwireless/wps/_sdkib;
    //   99: invokevirtual 179	com/skyhookwireless/wps/_sdkib:clone	()Lcom/skyhookwireless/wps/_sdkib;
    //   102: astore 8
    //   104: aload 7
    //   106: aload 8
    //   108: invokeinterface 183 2 0
    //   113: getstatic 187	com/skyhookwireless/wps/Location:_sdki	I
    //   116: ifeq +33 -> 149
    //   119: aload_0
    //   120: invokespecial 189	com/skyhookwireless/wps/_sdkn:_sdka	()Z
    //   123: ifne +26 -> 149
    //   126: aload_0
    //   127: getfield 126	com/skyhookwireless/wps/_sdkn:_sdke	Lcom/skyhookwireless/wps/WPSLocationCallback;
    //   130: astore 9
    //   132: aload_0
    //   133: getfield 138	com/skyhookwireless/wps/_sdkn:_sdkk	Lcom/skyhookwireless/wps/WPSReturnCode;
    //   136: astore 10
    //   138: aload 9
    //   140: aload 10
    //   142: invokeinterface 193 2 0
    //   147: astore 11
    //   149: aload_0
    //   150: monitorenter
    //   151: aconst_null
    //   152: astore 12
    //   154: aload_0
    //   155: aload 12
    //   157: putfield 149	com/skyhookwireless/wps/_sdkn:_sdkj	Z
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_0
    //   163: getfield 97	com/skyhookwireless/wps/_sdkn:_sdko	Lcom/skyhookwireless/wps/_sdkf;
    //   166: getfield 162	com/skyhookwireless/wps/_sdkf:_sdke	Lcom/skyhookwireless/wps/_sdknb;
    //   169: invokevirtual 166	com/skyhookwireless/wps/_sdknb:_sdkb	()V
    //   172: aload_0
    //   173: getfield 126	com/skyhookwireless/wps/_sdkn:_sdke	Lcom/skyhookwireless/wps/WPSLocationCallback;
    //   176: invokeinterface 170 1 0
    //   181: return
    //   182: astore_3
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_3
    //   186: athrow
    //   187: astore 12
    //   189: aload_0
    //   190: monitorexit
    //   191: aload 12
    //   193: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	35	35	finally
    //   70	149	35	finally
    //   41	49	182	finally
    //   183	185	182	finally
    //   154	162	187	finally
    //   189	191	187	finally
  }

  public long getGpsPeriod()
  {
    return 1000L;
  }

  public long getWifiPeriod()
  {
    return this._sdkh;
  }

  public WPSContinuation handleError(WPSReturnCode paramWPSReturnCode)
  {
    WPSContinuation localWPSContinuation;
    if (_sdka())
      localWPSContinuation = WPSContinuation.WPS_STOP;
    while (true)
    {
      return localWPSContinuation;
      WPSReturnCode localWPSReturnCode = WPSReturnCode.WPS_ERROR_WIFI_NOT_AVAILABLE;
      if (paramWPSReturnCode == localWPSReturnCode)
      {
        localWPSContinuation = this._sdke.handleError(paramWPSReturnCode);
      }
      else
      {
        this._sdkk = paramWPSReturnCode;
        localWPSContinuation = WPSContinuation.WPS_STOP;
      }
    }
  }

  public WPSContinuation handleEvents(List<_sdkpd> paramList, _sdknd param_sdknd)
  {
    return WPSContinuation.WPS_CONTINUE;
  }

  public WPSContinuation handleScan(_sdkzb param_sdkzb, _sdknd param_sdknd, boolean paramBoolean1, boolean paramBoolean2, List<_sdkwb> paramList)
  {
    _sdkec local_sdkec = _sdkec._sdkd();
    this._sdkg.merge(param_sdkzb);
    this._sdkg.filterOld(local_sdkec);
    _sdkzb local_sdkzb = this._sdkg.clone();
    boolean bool1 = this._sdka._sdkb();
    int i;
    long l1;
    int j;
    int k;
    _sdktd local_sdktd1;
    int m;
    WPSContinuation localWPSContinuation;
    if (this._sdki != null)
    {
      i = this._sdki.getNAP();
      l1 = this._sdkd._sdka(local_sdkec);
      j = local_sdkzb.getAPs().size();
      k = local_sdkzb.getCells().size();
      if (bool1)
      {
        _sdkhb local_sdkhb1 = this._sdka;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[12];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(j);
        String str2 = z[2];
        String str3 = str2 + l1 + ")";
        local_sdkhb1._sdkb(str3);
        _sdkhb local_sdkhb2 = this._sdka;
        StringBuilder localStringBuilder3 = new StringBuilder();
        String str4 = z[12];
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str4).append(k);
        String str5 = z[2];
        String str6 = str5 + l1 + ")";
        local_sdkhb2._sdkb(str6);
      }
      local_sdktd1 = _sdkf._sdka(this._sdko, local_sdkzb);
      WPSStreetAddressLookup localWPSStreetAddressLookup1 = this._sdkf;
      WPSStreetAddressLookup localWPSStreetAddressLookup2 = WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP;
      if (localWPSStreetAddressLookup1 != localWPSStreetAddressLookup2)
        break label625;
      _sdknb local_sdknb = this._sdko._sdke;
      long l2 = this._sdkh;
      boolean bool2 = paramBoolean1;
      boolean bool3 = paramBoolean2;
      List<_sdkwb> localList = paramList;
      m = local_sdknb._sdka(local_sdkzb, bool2, bool3, l2, localList);
      Object localObject1 = m.first;
      WPSReturnCode localWPSReturnCode1 = WPSReturnCode.WPS_OK;
      if (localObject1 != localWPSReturnCode1)
        break label603;
      WPSReturnCode localWPSReturnCode2 = (WPSReturnCode)m.first;
      this._sdkk = localWPSReturnCode2;
      _sdkib local_sdkib1 = (_sdkib)m.second;
      this._sdki = local_sdkib1;
      if (this._sdki.getNAP() >= 3)
        break label489;
      if (bool1)
      {
        _sdkhb local_sdkhb3 = this._sdka;
        StringBuilder localStringBuilder5 = new StringBuilder();
        String str7 = z[9];
        StringBuilder localStringBuilder6 = localStringBuilder5.append(str7);
        Object localObject2 = m.second;
        StringBuilder localStringBuilder7 = localStringBuilder6.append(localObject2);
        String str8 = z[7];
        StringBuilder localStringBuilder8 = localStringBuilder7.append(str8).append(l1);
        String str9 = z[1];
        String str10 = str9;
        local_sdkhb3._sdkb(str10);
      }
      localWPSContinuation = WPSContinuation.WPS_CONTINUE;
    }
    while (true)
    {
      return localWPSContinuation;
      i = 0;
      break;
      label489: if (this._sdka._sdkc())
      {
        _sdkhb local_sdkhb4 = this._sdka;
        StringBuilder localStringBuilder9 = new StringBuilder();
        String str11 = z[8];
        StringBuilder localStringBuilder10 = localStringBuilder9.append(str11);
        Object localObject3 = m.second;
        StringBuilder localStringBuilder11 = localStringBuilder10.append(localObject3);
        String str12 = z[7];
        StringBuilder localStringBuilder12 = localStringBuilder11.append(str12).append(l1);
        String str13 = z[1];
        String str14 = str13;
        local_sdkhb4._sdkc(str14);
      }
      localWPSContinuation = WPSContinuation.WPS_STOP;
      continue;
      label603: if (!_sdktb._sdkf())
      {
        WPSReturnCode localWPSReturnCode3 = (WPSReturnCode)m.first;
        this._sdkk = localWPSReturnCode3;
      }
      label625: if (!_sdktb._sdkf())
      {
        localWPSContinuation = WPSContinuation.WPS_CONTINUE;
      }
      else
      {
        int i1 = this._sdkl;
        int i2 = j - i1;
        int i3 = this._sdkm;
        int n = k - i3;
        if (bool1)
        {
          _sdkhb local_sdkhb5 = this._sdka;
          StringBuilder localStringBuilder13 = new StringBuilder();
          String str15 = z[6];
          String str16 = str15 + i2;
          local_sdkhb5._sdkb(str16);
          _sdkhb local_sdkhb6 = this._sdka;
          StringBuilder localStringBuilder14 = new StringBuilder();
          String str17 = z[14];
          String str18 = str17 + n;
          local_sdkhb6._sdkb(str18);
        }
        if ((i2 + i >= 3) || ((i2 + n > 0) && (i == 0) && (l1 >= 3000L)))
        {
          WPSReturnCode localWPSReturnCode4 = this._sdkk;
          WPSReturnCode localWPSReturnCode5 = WPSReturnCode.WPS_ERROR_UNAUTHORIZED;
          if (localWPSReturnCode4 != localWPSReturnCode5)
          {
            if ((!_sdkn) && (i2 + n <= 0))
              throw new AssertionError();
            _sdkxb local_sdkxb = this._sdkb;
            WPSAuthentication localWPSAuthentication = this._sdkc;
            WPSStreetAddressLookup localWPSStreetAddressLookup3 = this._sdkf;
            _sdktd local_sdktd2 = local_sdkxb._sdka(localWPSAuthentication, localWPSStreetAddressLookup3, local_sdkzb);
            _sdkf._sdka(this._sdko, local_sdktd2, local_sdkzb);
            WPSReturnCode localWPSReturnCode6 = (WPSReturnCode)local_sdktd2.first;
            this._sdkk = localWPSReturnCode6;
            this._sdkl = j;
            this._sdkm = k;
            Object localObject4 = local_sdktd2.first;
            WPSReturnCode localWPSReturnCode7 = WPSReturnCode.WPS_OK;
            if (localObject4 == localWPSReturnCode7)
            {
              _sdkib local_sdkib2 = (_sdkib)local_sdktd2.second;
              this._sdki = local_sdkib2;
              if (this._sdki.getNAP() < 3)
              {
                if (bool1)
                {
                  _sdkhb local_sdkhb7 = this._sdka;
                  StringBuilder localStringBuilder15 = new StringBuilder();
                  String str19 = z[5];
                  StringBuilder localStringBuilder16 = localStringBuilder15.append(str19);
                  _sdkib local_sdkib3 = this._sdki;
                  StringBuilder localStringBuilder17 = localStringBuilder16.append(local_sdkib3);
                  String str20 = z[7];
                  StringBuilder localStringBuilder18 = localStringBuilder17.append(str20).append(l1);
                  String str21 = z[1];
                  String str22 = str21;
                  local_sdkhb7._sdkb(str22);
                }
                localWPSContinuation = WPSContinuation.WPS_CONTINUE;
                continue;
              }
              if (this._sdka._sdkc())
              {
                _sdkhb local_sdkhb8 = this._sdka;
                StringBuilder localStringBuilder19 = new StringBuilder();
                String str23 = z[4];
                StringBuilder localStringBuilder20 = localStringBuilder19.append(str23);
                _sdkib local_sdkib4 = this._sdki;
                StringBuilder localStringBuilder21 = localStringBuilder20.append(local_sdkib4);
                String str24 = z[7];
                StringBuilder localStringBuilder22 = localStringBuilder21.append(str24).append(l1);
                String str25 = z[1];
                String str26 = str25;
                local_sdkhb8._sdkc(str26);
              }
              localWPSContinuation = WPSContinuation.WPS_STOP;
              continue;
            }
            Object localObject5 = local_sdktd2.first;
            WPSReturnCode localWPSReturnCode8 = WPSReturnCode.WPS_ERROR_LOCATION_CANNOT_BE_DETERMINED;
            if (localObject5 == localWPSReturnCode8)
            {
              _sdkhb local_sdkhb9 = this._sdka;
              String str27 = z[3];
              local_sdkhb9._sdkc(str27);
              localWPSContinuation = WPSContinuation.WPS_CONTINUE;
              continue;
            }
            Object localObject6 = local_sdktd2.first;
            WPSReturnCode localWPSReturnCode9 = WPSReturnCode.WPS_ERROR_UNAUTHORIZED;
            if (localObject6 == localWPSReturnCode9)
            {
              _sdkhb local_sdkhb10 = this._sdka;
              String str28 = z[10];
              local_sdkhb10._sdkc(str28);
              localWPSContinuation = WPSContinuation.WPS_CONTINUE;
              continue;
            }
            _sdkhb local_sdkhb11 = this._sdka;
            StringBuilder localStringBuilder23 = new StringBuilder();
            String str29 = z[0];
            StringBuilder localStringBuilder24 = localStringBuilder23.append(str29);
            Object localObject7 = local_sdktd2.first;
            String str30 = localObject7;
            local_sdkhb11._sdke(str30);
            localWPSContinuation = WPSContinuation.WPS_STOP;
          }
        }
        else if ((i2 > 0) && (l1 >= 2000L))
        {
          _sdkhb local_sdkhb12 = this._sdka;
          StringBuilder localStringBuilder25 = new StringBuilder();
          String str31 = z[11];
          String str32 = str31 + l1 + ")";
          local_sdkhb12._sdkb(str32);
          Object localObject8 = local_sdktd1.first;
          WPSReturnCode localWPSReturnCode10 = WPSReturnCode.WPS_OK;
          if ((localObject8 == localWPSReturnCode10) && (((_sdkib)local_sdktd1.second).getNAP() > i))
          {
            if (bool1)
            {
              _sdkhb local_sdkhb13 = this._sdka;
              StringBuilder localStringBuilder26 = new StringBuilder();
              String str33 = z[13];
              StringBuilder localStringBuilder27 = localStringBuilder26.append(str33);
              int i4 = ((_sdkib)local_sdktd1.second).getNAP();
              String str34 = i4;
              local_sdkhb13._sdkb(str34);
            }
            WPSReturnCode localWPSReturnCode11 = WPSReturnCode.WPS_OK;
            this._sdkk = localWPSReturnCode11;
            _sdkib local_sdkib5 = (_sdkib)local_sdktd1.second;
            this._sdki = local_sdkib5;
            this._sdkl = j;
            localWPSContinuation = WPSContinuation.WPS_STOP;
          }
        }
        else
        {
          localWPSContinuation = WPSContinuation.WPS_CONTINUE;
        }
      }
    }
  }

  public void init()
  {
    this._sdko._sdke._sdka();
  }

  public _sdkib lastLocation()
  {
    return this._sdki;
  }

  public boolean reportedFirstFix()
  {
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkn
 * JD-Core Version:    0.6.2
 */