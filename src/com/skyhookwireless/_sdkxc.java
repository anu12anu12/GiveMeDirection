package com.skyhookwireless;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import com.skyhookwireless.wps._sdkib;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class _sdkxc extends _sdkuc
{
  private static final String[] z;
  private final Callable<LocationManager> _sdke;
  private final _sdkhb _sdkf;
  private final Context _sdkg;
  private final LocationManager _sdkh;
  private final _sdkgb _sdki;
  private final _sdkdb _sdkj;
  private final String _sdkk;
  private long _sdkl;
  private _sdkib _sdkm;
  private boolean _sdkn;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[21];
    Object localObject2 = "\023:>".toCharArray();
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
          i2 = 114;
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
      Object localObject5 = "T=$\032T:(y\033\033.m".toCharArray();
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
            i8 = 114;
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
        Object localObject7 = "\007>\"{\002\021.m��\025)&b\034\023j".toCharArray();
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
              i17 = 114;
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
          Object localObject9 = "\027%8g\026\032m9+��\021'\"}\027T?=o\023��/>".toCharArray();
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
                i25 = 114;
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
            Object localObject11 = "3\032\036".toCharArray();
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
                  i33 = 114;
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
              Object localObject13 = "\032/9|\035\006!".toCharArray();
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
                    i41 = 114;
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
                Object localObject15 = "T:?d\004\035.(yR\025<,b\036\025(!n".toCharArray();
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
                      i49 = 114;
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
                  Object localObject17 = "\027%8g\026T$\"R\023/9+>\033),\033\033$��j\034\025-(y".toCharArray();
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
                        i57 = 114;
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
                    Object localObject19 = ":\017\031\\=&\001".toCharArray();
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
                          i65 = 114;
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
                      Object localObject21 = "\025)9b\004\035>4+\026\033/>eU��j%j\004\021j=n��\031#>x\033\033$m\035T?>nR\0048\"}\033\020/?+".toCharArray();
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
                            i73 = 114;
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
                        Object localObject23 = "\032%m".toCharArray();
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
                              i81 = 114;
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
                          Object localObject25 = "T##x\006\021+)+\035\022j".toCharArray();
                          int i84 = localObject25.length;
                          int i85;
                          label1837: int i88;
                          if (i84 <= 1)
                          {
                            i85 = 0;
                            localObject3 = localObject25;
                            k = i85;
                            int i86 = i84;
                            Object localObject26 = localObject25;
                            int i87 = i86;
                            while (true)
                            {
                              i76 = localObject26[i85];
                              switch (k % 5)
                              {
                              default:
                                i88 = 114;
                                label1904: int i89 = (char)(i88 ^ i76);
                                localObject26[i85] = i89;
                                i85 = k + 1;
                                if (i87 != 0)
                                  break label1945;
                                localObject26 = localObject3;
                                int i90 = i85;
                                i85 = i87;
                              case 0:
                              case 1:
                              case 2:
                              case 3:
                              }
                            }
                            label1945: i84 = i87;
                            localObject25 = localObject3;
                          }
                          while (true)
                          {
                            if (i84 > i85)
                              break label1837;
                            String str12 = new String((char[])localObject25).intern();
                            arrayOfString[11] = str12;
                            int i91 = 12;
                            Object localObject27 = "\007>,y\006\021.m��\025)&b\034\023j".toCharArray();
                            int i92 = localObject27.length;
                            int i93;
                            label2005: int i96;
                            if (i92 <= 1)
                            {
                              i93 = 0;
                              localObject3 = localObject27;
                              k = i93;
                              int i94 = i92;
                              Object localObject28 = localObject27;
                              int i95 = i94;
                              while (true)
                              {
                                i16 = localObject28[i93];
                                switch (k % 5)
                                {
                                default:
                                  i96 = 114;
                                  label2072: int i97 = (char)(i96 ^ i16);
                                  localObject28[i93] = i97;
                                  i93 = k + 1;
                                  if (i95 != 0)
                                    break label2113;
                                  localObject28 = localObject3;
                                  int i98 = i93;
                                  i93 = i95;
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                }
                              }
                              label2113: i92 = i95;
                              localObject27 = localObject3;
                            }
                            while (true)
                            {
                              if (i92 > i93)
                                break label2005;
                              String str13 = new String((char[])localObject27).intern();
                              arrayOfString[i91] = str13;
                              int i99 = 13;
                              Object localObject29 = "\004+>x\033\002/".toCharArray();
                              int i100 = localObject29.length;
                              int i101;
                              label2173: int i104;
                              if (i100 <= 1)
                              {
                                i101 = 0;
                                localObject3 = localObject29;
                                k = i101;
                                int i102 = i100;
                                Object localObject30 = localObject29;
                                int i103 = i102;
                                while (true)
                                {
                                  i16 = localObject30[i101];
                                  switch (k % 5)
                                  {
                                  default:
                                    i104 = 114;
                                    label2240: int i105 = (char)(i104 ^ i16);
                                    localObject30[i101] = i105;
                                    i101 = k + 1;
                                    if (i103 != 0)
                                      break label2281;
                                    localObject30 = localObject3;
                                    int i106 = i101;
                                    i101 = i103;
                                  case 0:
                                  case 1:
                                  case 2:
                                  case 3:
                                  }
                                }
                                label2281: i100 = i103;
                                localObject29 = localObject3;
                              }
                              while (true)
                              {
                                if (i100 > i101)
                                  break label2173;
                                String str14 = new String((char[])localObject29).intern();
                                arrayOfString[i99] = str14;
                                int i107 = 14;
                                Object localObject31 = "\007=$\021\034##lR��%m{\035\003/?+\001\025<$e\025T'\"o\027".toCharArray();
                                int i108 = localObject31.length;
                                int i109;
                                label2341: int i112;
                                if (i108 <= 1)
                                {
                                  i109 = 0;
                                  localObject3 = localObject31;
                                  k = i109;
                                  int i110 = i108;
                                  Object localObject32 = localObject31;
                                  int i111 = i110;
                                  while (true)
                                  {
                                    i16 = localObject32[i109];
                                    switch (k % 5)
                                    {
                                    default:
                                      i112 = 114;
                                      label2408: int i113 = (char)(i112 ^ i16);
                                      localObject32[i109] = i113;
                                      i109 = k + 1;
                                      if (i111 != 0)
                                        break label2449;
                                      localObject32 = localObject3;
                                      int i114 = i109;
                                      i109 = i111;
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    }
                                  }
                                  label2449: i108 = i111;
                                  localObject31 = localObject3;
                                }
                                while (true)
                                {
                                  if (i108 > i109)
                                    break label2341;
                                  String str15 = new String((char[])localObject31).intern();
                                  arrayOfString[i107] = str15;
                                  int i115 = 15;
                                  Object localObject33 = "\027%8g\026\032m9+\001\003#9h\032T>\"+\002\033=(yR\007+;b\034\023j d\026\021".toCharArray();
                                  int i116 = localObject33.length;
                                  int i117;
                                  label2509: int i120;
                                  if (i116 <= 1)
                                  {
                                    i117 = 0;
                                    localObject3 = localObject33;
                                    k = i117;
                                    int i118 = i116;
                                    Object localObject34 = localObject33;
                                    int i119 = i118;
                                    while (true)
                                    {
                                      i16 = localObject34[i117];
                                      switch (k % 5)
                                      {
                                      default:
                                        i120 = 114;
                                        label2576: int i121 = (char)(i120 ^ i16);
                                        localObject34[i117] = i121;
                                        i117 = k + 1;
                                        if (i119 != 0)
                                          break label2617;
                                        localObject34 = localObject3;
                                        int i122 = i117;
                                        i117 = i119;
                                      case 0:
                                      case 1:
                                      case 2:
                                      case 3:
                                      }
                                    }
                                    label2617: i116 = i119;
                                    localObject33 = localObject3;
                                  }
                                  while (true)
                                  {
                                    if (i116 > i117)
                                      break label2509;
                                    String str16 = new String((char[])localObject33).intern();
                                    arrayOfString[i115] = str16;
                                    int i123 = 16;
                                    Object localObject35 = "\027%8g\026\032m9+\025\021>mg\035\027+9b\035\032j8{\026\025>(xR\022%?+\002\006%;b\026\0218m".toCharArray();
                                    int i124 = localObject35.length;
                                    int i125;
                                    label2677: int i128;
                                    if (i124 <= 1)
                                    {
                                      i125 = 0;
                                      localObject3 = localObject35;
                                      k = i125;
                                      int i126 = i124;
                                      Object localObject36 = localObject35;
                                      int i127 = i126;
                                      while (true)
                                      {
                                        i16 = localObject36[i125];
                                        switch (k % 5)
                                        {
                                        default:
                                          i128 = 114;
                                          label2744: int i129 = (char)(i128 ^ i16);
                                          localObject36[i125] = i129;
                                          i125 = k + 1;
                                          if (i127 != 0)
                                            break label2785;
                                          localObject36 = localObject3;
                                          int i130 = i125;
                                          i125 = i127;
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        }
                                      }
                                      label2785: i124 = i127;
                                      localObject35 = localObject3;
                                    }
                                    while (true)
                                    {
                                      if (i124 > i125)
                                        break label2677;
                                      String str17 = new String((char[])localObject35).intern();
                                      arrayOfString[i123] = str17;
                                      int i131 = 17;
                                      Object localObject37 = "\035$;j\036\035.m{\027\006#\"oHT".toCharArray();
                                      int i132 = localObject37.length;
                                      int i133;
                                      label2845: int i136;
                                      if (i132 <= 1)
                                      {
                                        i133 = 0;
                                        localObject3 = localObject37;
                                        k = i133;
                                        int i134 = i132;
                                        Object localObject38 = localObject37;
                                        int i135 = i134;
                                        while (true)
                                        {
                                          i16 = localObject38[i133];
                                          switch (k % 5)
                                          {
                                          default:
                                            i136 = 114;
                                            label2912: int i137 = (char)(i136 ^ i16);
                                            localObject38[i133] = i137;
                                            i133 = k + 1;
                                            if (i135 != 0)
                                              break label2953;
                                            localObject38 = localObject3;
                                            int i138 = i133;
                                            i133 = i135;
                                          case 0:
                                          case 1:
                                          case 2:
                                          case 3:
                                          }
                                        }
                                        label2953: i132 = i135;
                                        localObject37 = localObject3;
                                      }
                                      while (true)
                                      {
                                        if (i132 > i133)
                                          break label2845;
                                        String str18 = new String((char[])localObject37).intern();
                                        arrayOfString[i131] = str18;
                                        int i139 = 18;
                                        Object localObject39 = "��8,h\031\035$*+\002\0218$d\026T=,xR\032%9+\021\034+#l\027\020".toCharArray();
                                        int i140 = localObject39.length;
                                        int i141;
                                        label3013: int i144;
                                        if (i140 <= 1)
                                        {
                                          i141 = 0;
                                          localObject3 = localObject39;
                                          k = i141;
                                          int i142 = i140;
                                          Object localObject40 = localObject39;
                                          int i143 = i142;
                                          while (true)
                                          {
                                            i16 = localObject40[i141];
                                            switch (k % 5)
                                            {
                                            default:
                                              i144 = 114;
                                              label3080: int i145 = (char)(i144 ^ i16);
                                              localObject40[i141] = i145;
                                              i141 = k + 1;
                                              if (i143 != 0)
                                                break label3121;
                                              localObject40 = localObject3;
                                              int i146 = i141;
                                              i141 = i143;
                                            case 0:
                                            case 1:
                                            case 2:
                                            case 3:
                                            }
                                          }
                                          label3121: i140 = i143;
                                          localObject39 = localObject3;
                                        }
                                        while (true)
                                        {
                                          if (i140 > i141)
                                            break label3013;
                                          String str19 = new String((char[])localObject39).intern();
                                          arrayOfString[i139] = str19;
                                          int i147 = 19;
                                          Object localObject41 = "]\027".toCharArray();
                                          int i148 = localObject41.length;
                                          label3181: int i153;
                                          label3248: int i150;
                                          if (i148 <= 1)
                                          {
                                            int i149 = 0;
                                            localObject3 = localObject41;
                                            k = i149;
                                            int i151 = i148;
                                            Object localObject43 = localObject41;
                                            int i152 = i151;
                                            while (true)
                                            {
                                              i16 = localObject43[i149];
                                              switch (k % 5)
                                              {
                                              default:
                                                i153 = 114;
                                                int i154 = (char)(i153 ^ i16);
                                                localObject43[i149] = i154;
                                                i150 = k + 1;
                                                if (i152 != 0)
                                                  break label3289;
                                                localObject43 = localObject3;
                                                int i155 = i150;
                                                i150 = i152;
                                              case 0:
                                              case 1:
                                              case 2:
                                              case 3:
                                              }
                                            }
                                            label3289: i148 = i152;
                                            localObject41 = localObject3;
                                          }
                                          while (true)
                                          {
                                            if (i148 > i150)
                                              break label3181;
                                            String str20 = new String((char[])localObject41).intern();
                                            arrayOfString[i147] = str20;
                                            int i156 = 20;
                                            Object localObject44 = "/\013#o��\033#)+>\033),\033\033$\035y\035\002#)n��='=gZ".toCharArray();
                                            Object localObject45 = localObject44.length;
                                            label3346: Object localObject47;
                                            Object localObject48;
                                            label3365: int i157;
                                            if (localObject45 <= 1)
                                            {
                                              localObject42 = localObject44;
                                              localObject3 = localObject1;
                                              Object localObject46 = localObject45;
                                              localObject47 = localObject44;
                                              localObject48 = localObject46;
                                              i147 = localObject47[localObject1];
                                              switch (localObject3 % 5)
                                              {
                                              default:
                                                i157 = 114;
                                              case 0:
                                              case 1:
                                              case 2:
                                              case 3:
                                              }
                                            }
                                            while (true)
                                            {
                                              int i158 = (char)(i157 ^ i147);
                                              localObject47[localObject1] = i158;
                                              localObject1 = localObject3 + 1;
                                              if (localObject48 == 0)
                                              {
                                                localObject47 = localObject42;
                                                int i159 = localObject1;
                                                localObject1 = localObject48;
                                                break label3365;
                                              }
                                              localObject45 = localObject48;
                                              localObject44 = localObject42;
                                              if (localObject45 > localObject1)
                                                break label3346;
                                              String str21 = new String((char[])localObject44).intern();
                                              arrayOfString[i156] = str21;
                                              z = arrayOfString;
                                              return;
                                              i2 = 116;
                                              break;
                                              i2 = 74;
                                              break;
                                              i2 = 77;
                                              break;
                                              i2 = 11;
                                              break;
                                              i8 = 116;
                                              break label244;
                                              i8 = 74;
                                              break label244;
                                              i8 = 77;
                                              break label244;
                                              i8 = 11;
                                              break label244;
                                              i17 = 116;
                                              break label408;
                                              i17 = 74;
                                              break label408;
                                              i17 = 77;
                                              break label408;
                                              i17 = 11;
                                              break label408;
                                              i25 = 116;
                                              break label572;
                                              i25 = 74;
                                              break label572;
                                              i25 = 77;
                                              break label572;
                                              i25 = 11;
                                              break label572;
                                              i33 = 116;
                                              break label736;
                                              i33 = 74;
                                              break label736;
                                              i33 = 77;
                                              break label736;
                                              i33 = 11;
                                              break label736;
                                              i41 = 116;
                                              break label900;
                                              i41 = 74;
                                              break label900;
                                              i41 = 77;
                                              break label900;
                                              i41 = 11;
                                              break label900;
                                              i49 = 116;
                                              break label1068;
                                              i49 = 74;
                                              break label1068;
                                              i49 = 77;
                                              break label1068;
                                              i49 = 11;
                                              break label1068;
                                              i57 = 116;
                                              break label1236;
                                              i57 = 74;
                                              break label1236;
                                              i57 = 77;
                                              break label1236;
                                              i57 = 11;
                                              break label1236;
                                              i65 = 116;
                                              break label1404;
                                              i65 = 74;
                                              break label1404;
                                              i65 = 77;
                                              break label1404;
                                              i65 = 11;
                                              break label1404;
                                              i73 = 116;
                                              break label1572;
                                              i73 = 74;
                                              break label1572;
                                              i73 = 77;
                                              break label1572;
                                              i73 = 11;
                                              break label1572;
                                              i81 = 116;
                                              break label1740;
                                              i81 = 74;
                                              break label1740;
                                              i81 = 77;
                                              break label1740;
                                              i81 = 11;
                                              break label1740;
                                              i88 = 116;
                                              break label1904;
                                              i88 = 74;
                                              break label1904;
                                              i88 = 77;
                                              break label1904;
                                              i88 = 11;
                                              break label1904;
                                              i96 = 116;
                                              break label2072;
                                              i96 = 74;
                                              break label2072;
                                              i96 = 77;
                                              break label2072;
                                              i96 = 11;
                                              break label2072;
                                              i104 = 116;
                                              break label2240;
                                              i104 = 74;
                                              break label2240;
                                              i104 = 77;
                                              break label2240;
                                              i104 = 11;
                                              break label2240;
                                              i112 = 116;
                                              break label2408;
                                              i112 = 74;
                                              break label2408;
                                              i112 = 77;
                                              break label2408;
                                              i112 = 11;
                                              break label2408;
                                              i120 = 116;
                                              break label2576;
                                              i120 = 74;
                                              break label2576;
                                              i120 = 77;
                                              break label2576;
                                              i120 = 11;
                                              break label2576;
                                              i128 = 116;
                                              break label2744;
                                              i128 = 74;
                                              break label2744;
                                              i128 = 77;
                                              break label2744;
                                              i128 = 11;
                                              break label2744;
                                              i136 = 116;
                                              break label2912;
                                              i136 = 74;
                                              break label2912;
                                              i136 = 77;
                                              break label2912;
                                              i136 = 11;
                                              break label2912;
                                              i144 = 116;
                                              break label3080;
                                              i144 = 74;
                                              break label3080;
                                              i144 = 77;
                                              break label3080;
                                              i144 = 11;
                                              break label3080;
                                              i153 = 116;
                                              break label3248;
                                              i153 = 74;
                                              break label3248;
                                              i153 = 77;
                                              break label3248;
                                              i153 = 11;
                                              break label3248;
                                              i157 = 116;
                                              continue;
                                              i157 = 74;
                                              continue;
                                              i157 = 77;
                                              continue;
                                              i157 = 11;
                                            }
                                            Object localObject42 = null;
                                          }
                                          i141 = 0;
                                        }
                                        i133 = 0;
                                      }
                                      i125 = 0;
                                    }
                                    i117 = 0;
                                  }
                                  i109 = 0;
                                }
                                i101 = 0;
                              }
                              i93 = 0;
                            }
                            i85 = 0;
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

  _sdkxc(_sdkt param_sdkt, String paramString)
    throws _sdkk
  {
    _sdkfb local_sdkfb = new _sdkfb(this);
    this._sdke = local_sdkfb;
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkxc.class);
    this._sdkf = local_sdkhb;
    Context localContext = ((_sdkq)param_sdkt)._sdka();
    this._sdkg = localContext;
    this._sdkl = 65535L;
    this._sdkn = false;
    if (z[4].equals(paramString))
    {
      String str1 = z[0];
      this._sdkk = str1;
      if (i == 0)
        break label203;
      if (!_sdkhb._sdkd)
        break label197;
    }
    label197: for (boolean bool = false; ; bool = true)
    {
      _sdkhb._sdkd = bool;
      if (z[8].equals(paramString))
      {
        String str2 = z[5];
        this._sdkk = str2;
        if (i == 0)
          break;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str3 = z[10];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append(paramString);
      String str4 = z[6];
      String str5 = str4;
      throw new _sdkk(str5);
    }
    try
    {
      label203: Future localFuture = _sdkr._sdka(this._sdke);
      TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
      LocationManager localLocationManager1 = (LocationManager)localFuture.get(5000L, localTimeUnit);
      this._sdkh = localLocationManager1;
      if (this._sdkh == null)
      {
        String str6 = z[7];
        throw new _sdkk(str6);
      }
    }
    catch (Throwable localThrowable)
    {
      String str7 = z[7];
      throw new _sdkk(str7, localThrowable);
    }
    String str8 = z[0];
    String str9 = this._sdkk;
    if (str8.equals(str9))
    {
      LocationManager localLocationManager2 = this._sdkh;
      _sdkdb local_sdkdb = new _sdkdb(localLocationManager2);
      this._sdkj = local_sdkdb;
      if (i == 0);
    }
    else
    {
      this._sdkj = null;
    }
    _sdkgb local_sdkgb = new _sdkgb(this, null);
    this._sdki = local_sdkgb;
    List localList1 = this._sdkh.getProviders(false);
    String str10 = this._sdkk;
    if (localList1.contains(str10))
      return;
    List localList2 = this._sdkh.getAllProviders();
    String str11 = this._sdkk;
    if (localList2.contains(str11))
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      String str12 = z[9];
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str12);
      String str13 = this._sdkk;
      String str14 = str13;
      throw new _sdkk(str14);
    }
    StringBuilder localStringBuilder5 = new StringBuilder();
    String str15 = z[10];
    StringBuilder localStringBuilder6 = localStringBuilder5.append(str15);
    String str16 = this._sdkk;
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str16);
    String str17 = z[6];
    String str18 = str17;
    throw new _sdkk(str18);
  }

  static Context _sdka(_sdkxc param_sdkxc)
  {
    return param_sdkxc._sdkg;
  }

  static _sdkib _sdka(Location paramLocation)
  {
    _sdkib local_sdkib;
    if (paramLocation == null)
      local_sdkib = null;
    while (true)
    {
      return local_sdkib;
      local_sdkib = new _sdkib();
      if ((paramLocation.getLatitude() != 0.0D) || (paramLocation.getLongitude() != 0.0D))
      {
        double d1 = paramLocation.getLatitude();
        local_sdkib.setLatitude(d1);
        double d2 = paramLocation.getLongitude();
        local_sdkib.setLongitude(d2);
      }
      if (paramLocation.getTime() != 0L)
      {
        long l = paramLocation.getTime();
        local_sdkib.setTime(l);
      }
      if (paramLocation.hasAccuracy())
      {
        int i = Math.round(paramLocation.getAccuracy());
        local_sdkib.setHPE(i);
      }
      if (paramLocation.hasAltitude())
      {
        double d3 = paramLocation.getAltitude();
        local_sdkib.setAltitude(d3);
      }
      if (paramLocation.hasBearing())
      {
        double d4 = paramLocation.getBearing();
        local_sdkib.setBearing(d4);
      }
      if (paramLocation.hasSpeed())
      {
        double d5 = paramLocation.getSpeed();
        local_sdkib.setSpeed(d5);
      }
    }
  }

  static _sdkib _sdka(_sdkxc param_sdkxc, _sdkib param_sdkib)
  {
    param_sdkxc._sdkm = param_sdkib;
    return param_sdkib;
  }

  private void _sdka(String paramString, long paramLong)
    throws Throwable
  {
    LocationManager localLocationManager = this._sdkh;
    _sdkgb local_sdkgb = this._sdki;
    Looper localLooper = _sdkr._sdkb();
    String str1 = paramString;
    long l1 = paramLong;
    localLocationManager.requestLocationUpdates(str1, l1, 0.0F, local_sdkgb, localLooper);
    if (this._sdkf._sdkb())
    {
      _sdkhb local_sdkhb = this._sdkf;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str2 = z[12];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(paramString);
      String str3 = z[1];
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str3).append(paramLong);
      String str4 = z[11];
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str4);
      long l2 = this._sdkl;
      String str5 = l2;
      local_sdkhb._sdkb(str5);
    }
    String str6 = z[0];
    String str7 = this._sdkk;
    if (!str6.equals(str7))
      return;
    boolean bool = this._sdkj._sdka();
  }

  static _sdkhb _sdkb(_sdkxc param_sdkxc)
  {
    return param_sdkxc._sdkf;
  }

  static String _sdkc(_sdkxc param_sdkxc)
  {
    return param_sdkxc._sdkk;
  }

  static boolean _sdkd(_sdkxc param_sdkxc)
  {
    return param_sdkxc._sdkn;
  }

  static _sdkdb _sdke(_sdkxc param_sdkxc)
  {
    return param_sdkxc._sdkj;
  }

  static _sdkib _sdkf(_sdkxc param_sdkxc)
  {
    return param_sdkxc._sdkm;
  }

  static void _sdkg(_sdkxc param_sdkxc)
  {
    param_sdkxc._sdka();
  }

  public _sdkuc _sdka(_sdkt param_sdkt, String paramString)
    throws _sdkk
  {
    return new _sdkxc(param_sdkt, paramString);
  }

  public void _sdka(long paramLong)
  {
    if (paramLong < 0L)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = z[17];
      String str2 = str1 + paramLong;
      throw new IllegalArgumentException(str2);
    }
    long l = this._sdkl;
    if (paramLong == l)
    {
      _sdkhb local_sdkhb1 = this._sdkf;
      String str3 = z[18];
      local_sdkhb1._sdkb(str3);
      return;
    }
    _sdkc();
    try
    {
      String str4 = this._sdkk;
      _sdka(str4, paramLong);
      this._sdkl = paramLong;
      return;
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb2 = this._sdkf;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str5 = z[16];
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str5);
      String str6 = this._sdkk;
      String str7 = str6;
      local_sdkhb2._sdkc(str7, localThrowable);
    }
  }

  public boolean _sdka()
  {
    boolean bool = true;
    if (this._sdkn);
    while (true)
    {
      return bool;
      String str1 = z[0];
      String str2 = this._sdkk;
      if (str1.equals(str2))
      {
        LocationManager localLocationManager = this._sdkh;
        String str3 = z[13];
        if (localLocationManager.getProvider(str3) == null);
      }
      try
      {
        _sdkc();
        _sdkhb local_sdkhb1 = this._sdkf;
        String str4 = z[14];
        local_sdkhb1._sdkb(str4);
        String str5 = z[13];
        _sdka(str5, 0L);
        this._sdkn = true;
        bool = this._sdkn;
      }
      catch (Throwable localThrowable)
      {
        while (true)
        {
          _sdkhb local_sdkhb2 = this._sdkf;
          String str6 = z[15];
          local_sdkhb2._sdkb(str6, localThrowable);
        }
      }
    }
  }

  public boolean _sdkb()
  {
    if (this._sdkl > 65535L);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void _sdkc()
  {
    if ((!this._sdkn) && (!_sdkb()))
      return;
    try
    {
      LocationManager localLocationManager = this._sdkh;
      _sdkgb local_sdkgb = this._sdki;
      localLocationManager.removeUpdates(local_sdkgb);
      if (this._sdkf._sdkb())
      {
        _sdkhb local_sdkhb1 = this._sdkf;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[2];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
        String str2 = this._sdkk;
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
        String str3 = z[1];
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str3);
        long l = this._sdkl;
        String str4 = l;
        local_sdkhb1._sdkb(str4);
      }
      this._sdkm = null;
      this._sdkl = 65535L;
      this._sdkn = false;
      String str5 = z[0];
      String str6 = this._sdkk;
      if (!str5.equals(str6))
        return;
      this._sdkj._sdkb();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        _sdkhb local_sdkhb2 = this._sdkf;
        String str7 = z[3];
        local_sdkhb2._sdkd(str7, localThrowable);
      }
    }
  }

  /** @deprecated */
  public _sdkib _sdkd()
  {
    try
    {
      _sdkib local_sdkib1 = this._sdkm;
      if (local_sdkib1 == null);
      _sdkib local_sdkib2;
      for (Object localObject1 = null; ; localObject1 = local_sdkib2)
      {
        return localObject1;
        local_sdkib2 = this._sdkm.clone();
      }
    }
    finally
    {
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[20];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = this._sdkk;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
    String str3 = z[19];
    return str3;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkxc
 * JD-Core Version:    0.6.2
 */