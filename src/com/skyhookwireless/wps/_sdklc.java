package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdkhd;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class _sdklc
  implements _sdkqc
{
  static final boolean _sdka;
  private static final String[] z;
  final _sdkkc _sdkb;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[16];
    Object localObject1 = "PN\f6XTN\013seKG\n\001b".toCharArray();
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
          i3 = 49;
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
      Object localObject4 = "FD\030=]MJ\0136U\002_\006?T\002".toCharArray();
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
            i9 = 49;
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
        Object localObject6 = "DJ\006?TF\013\033<\021QJ\0316\021VB\0036\021".toCharArray();
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
              i18 = 49;
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
          int i21 = 3;
          Object localObject8 = "M[\n=XLLO'XNNO".toCharArray();
          int i22 = localObject8.length;
          int i23;
          label508: int i26;
          if (i22 <= 1)
          {
            i23 = 0;
            localObject2 = localObject8;
            m = i23;
            int i24 = i22;
            Object localObject9 = localObject8;
            int i25 = i24;
            while (true)
            {
              i17 = localObject9[i23];
              switch (m % 5)
              {
              default:
                i26 = 49;
                label572: int i27 = (char)(i26 ^ i17);
                localObject9[i23] = i27;
                i23 = m + 1;
                if (i25 != 0)
                  break label613;
                localObject9 = localObject2;
                int i28 = i23;
                i23 = i25;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label613: i22 = i25;
            localObject8 = localObject2;
          }
          while (true)
          {
            if (i22 > i23)
              break label508;
            String str4 = new String((char[])localObject8).intern();
            arrayOfString[i21] = str4;
            int i29 = 4;
            Object localObject10 = "OJ\006=\021VB\0036\021QN\033sXQ\013\001<F\030\013".toCharArray();
            int i30 = localObject10.length;
            int i31;
            label672: int i34;
            if (i30 <= 1)
            {
              i31 = 0;
              localObject2 = localObject10;
              m = i31;
              int i32 = i30;
              Object localObject11 = localObject10;
              int i33 = i32;
              while (true)
              {
                i17 = localObject11[i31];
                switch (m % 5)
                {
                default:
                  i34 = 49;
                  label736: int i35 = (char)(i34 ^ i17);
                  localObject11[i31] = i35;
                  i31 = m + 1;
                  if (i33 != 0)
                    break label777;
                  localObject11 = localObject2;
                  int i36 = i31;
                  i31 = i33;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i30 = i33;
              localObject10 = localObject2;
            }
            while (true)
            {
              if (i30 > i31)
                break label672;
              String str5 = new String((char[])localObject10).intern();
              arrayOfString[i29] = str5;
              int i37 = 5;
              Object localObject12 = "CO\013:_E\013".toCharArray();
              int i38 = localObject12.length;
              int i39;
              label836: int i42;
              if (i38 <= 1)
              {
                i39 = 0;
                localObject2 = localObject12;
                m = i39;
                int i40 = i38;
                Object localObject13 = localObject12;
                int i41 = i40;
                while (true)
                {
                  i17 = localObject13[i39];
                  switch (m % 5)
                  {
                  default:
                    i42 = 49;
                    label900: int i43 = (char)(i42 ^ i17);
                    localObject13[i39] = i43;
                    i39 = m + 1;
                    if (i41 != 0)
                      break label941;
                    localObject13 = localObject2;
                    int i44 = i39;
                    i39 = i41;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i38 = i41;
                localObject12 = localObject2;
              }
              while (true)
              {
                if (i38 > i39)
                  break label836;
                String str6 = new String((char[])localObject12).intern();
                arrayOfString[i37] = str6;
                int i45 = 6;
                Object localObject14 = "\002_��s\\CB\001sEKG\nsBG_".toCharArray();
                int i46 = localObject14.length;
                int i47;
                label1001: int i50;
                if (i46 <= 1)
                {
                  i47 = 0;
                  localObject2 = localObject14;
                  m = i47;
                  int i48 = i46;
                  Object localObject15 = localObject14;
                  int i49 = i48;
                  while (true)
                  {
                    i17 = localObject15[i47];
                    switch (m % 5)
                    {
                    default:
                      i50 = 49;
                      label1068: int i51 = (char)(i50 ^ i17);
                      localObject15[i47] = i51;
                      i47 = m + 1;
                      if (i49 != 0)
                        break label1109;
                      localObject15 = localObject2;
                      int i52 = i47;
                      i47 = i49;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i46 = i49;
                  localObject14 = localObject2;
                }
                while (true)
                {
                  if (i46 > i47)
                    break label1001;
                  String str7 = new String((char[])localObject14).intern();
                  arrayOfString[i45] = str7;
                  int i53 = 7;
                  Object localObject16 = "CO\013:_E\013\n=EPRO'^\002E\032?]\017_\006?T\002H\0160YG".toCharArray();
                  int i54 = localObject16.length;
                  int i55;
                  label1169: int i58;
                  if (i54 <= 1)
                  {
                    i55 = 0;
                    localObject2 = localObject16;
                    m = i55;
                    int i56 = i54;
                    Object localObject17 = localObject16;
                    int i57 = i56;
                    while (true)
                    {
                      i17 = localObject17[i55];
                      switch (m % 5)
                      {
                      default:
                        i58 = 49;
                        label1236: int i59 = (char)(i58 ^ i17);
                        localObject17[i55] = i59;
                        i55 = m + 1;
                        if (i57 != 0)
                          break label1277;
                        localObject17 = localObject2;
                        int i60 = i55;
                        i55 = i57;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i54 = i57;
                    localObject16 = localObject2;
                  }
                  while (true)
                  {
                    if (i54 > i55)
                      break label1169;
                    String str8 = new String((char[])localObject16).intern();
                    arrayOfString[i53] = str8;
                    int i61 = 8;
                    Object localObject18 = "\002B\001'TPX\n0EKE\bs".toCharArray();
                    int i62 = localObject18.length;
                    int i63;
                    label1337: int i66;
                    if (i62 <= 1)
                    {
                      i63 = 0;
                      localObject2 = localObject18;
                      m = i63;
                      int i64 = i62;
                      Object localObject19 = localObject18;
                      int i65 = i64;
                      while (true)
                      {
                        i17 = localObject19[i63];
                        switch (m % 5)
                        {
                        default:
                          i66 = 49;
                          label1404: int i67 = (char)(i66 ^ i17);
                          localObject19[i63] = i67;
                          i63 = m + 1;
                          if (i65 != 0)
                            break label1445;
                          localObject19 = localObject2;
                          int i68 = i63;
                          i63 = i65;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1445: i62 = i65;
                      localObject18 = localObject2;
                    }
                    while (true)
                    {
                      if (i62 > i63)
                        break label1337;
                      String str9 = new String((char[])localObject18).intern();
                      arrayOfString[i61] = str9;
                      int i69 = 9;
                      Object localObject20 = "\002J\003!TCO\026sXL\013\f2RJNO".toCharArray();
                      int i70 = localObject20.length;
                      int i71;
                      label1505: int i74;
                      if (i70 <= 1)
                      {
                        i71 = 0;
                        localObject2 = localObject20;
                        m = i71;
                        int i72 = i70;
                        Object localObject21 = localObject20;
                        int i73 = i72;
                        while (true)
                        {
                          i17 = localObject21[i71];
                          switch (m % 5)
                          {
                          default:
                            i74 = 49;
                            label1572: int i75 = (char)(i74 ^ i17);
                            localObject21[i71] = i75;
                            i71 = m + 1;
                            if (i73 != 0)
                              break label1613;
                            localObject21 = localObject2;
                            int i76 = i71;
                            i71 = i73;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1613: i70 = i73;
                        localObject20 = localObject2;
                      }
                      while (true)
                      {
                        if (i70 > i71)
                          break label1505;
                        String str10 = new String((char[])localObject20).intern();
                        arrayOfString[i69] = str10;
                        int i77 = 10;
                        Object localObject22 = "\002_\006?TQ".toCharArray();
                        int i78 = localObject22.length;
                        int i79;
                        label1673: int i82;
                        if (i78 <= 1)
                        {
                          i79 = 0;
                          localObject2 = localObject22;
                          m = i79;
                          int i80 = i78;
                          Object localObject23 = localObject22;
                          int i81 = i80;
                          while (true)
                          {
                            i17 = localObject23[i79];
                            switch (m % 5)
                            {
                            default:
                              i82 = 49;
                              label1740: int i83 = (char)(i82 ^ i17);
                              localObject23[i79] = i83;
                              i79 = m + 1;
                              if (i81 != 0)
                                break label1781;
                              localObject23 = localObject2;
                              int i84 = i79;
                              i79 = i81;
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            }
                          }
                          label1781: i78 = i81;
                          localObject22 = localObject2;
                        }
                        while (true)
                        {
                          if (i78 > i79)
                            break label1673;
                          String str11 = new String((char[])localObject22).intern();
                          arrayOfString[i77] = str11;
                          int i85 = 11;
                          Object localObject24 = "ND\f2EKD\001sBGY\0316C\002Y\n'DPE\n7\021".toCharArray();
                          int i86 = localObject24.length;
                          int i87;
                          label1841: int i90;
                          if (i86 <= 1)
                          {
                            i87 = 0;
                            localObject2 = localObject24;
                            m = i87;
                            int i88 = i86;
                            Object localObject25 = localObject24;
                            int i89 = i88;
                            while (true)
                            {
                              i17 = localObject25[i87];
                              switch (m % 5)
                              {
                              default:
                                i90 = 49;
                                label1908: int i91 = (char)(i90 ^ i17);
                                localObject25[i87] = i91;
                                i87 = m + 1;
                                if (i89 != 0)
                                  break label1949;
                                localObject25 = localObject2;
                                int i92 = i87;
                                i87 = i89;
                              case 0:
                              case 1:
                              case 2:
                              case 3:
                              }
                            }
                            label1949: i86 = i89;
                            localObject24 = localObject2;
                          }
                          while (true)
                          {
                            if (i86 > i87)
                              break label1841;
                            String str12 = new String((char[])localObject24).intern();
                            arrayOfString[i85] = str12;
                            int i93 = 12;
                            Object localObject26 = "\002_\006?TQ\013\033<\021FD\030=]MJ\013".toCharArray();
                            int i94 = localObject26.length;
                            int i95;
                            label2009: int i98;
                            if (i94 <= 1)
                            {
                              i95 = 0;
                              localObject2 = localObject26;
                              m = i95;
                              int i96 = i94;
                              Object localObject27 = localObject26;
                              int i97 = i96;
                              while (true)
                              {
                                i17 = localObject27[i95];
                                switch (m % 5)
                                {
                                default:
                                  i98 = 49;
                                  label2076: int i99 = (char)(i98 ^ i17);
                                  localObject27[i95] = i99;
                                  i95 = m + 1;
                                  if (i97 != 0)
                                    break label2117;
                                  localObject27 = localObject2;
                                  int i100 = i95;
                                  i95 = i97;
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                }
                              }
                              label2117: i94 = i97;
                              localObject26 = localObject2;
                            }
                            while (true)
                            {
                              if (i94 > i95)
                                break label2009;
                              String str13 = new String((char[])localObject26).intern();
                              arrayOfString[i93] = str13;
                              int i101 = 13;
                              Object localObject28 = "vB\003:_Eh\003:TL_O5XPN\013sEKG\nsUM\\\001?^COO5PKG\032!T\002\003".toCharArray();
                              int i102 = localObject28.length;
                              int i103;
                              label2177: int i106;
                              if (i102 <= 1)
                              {
                                i103 = 0;
                                localObject2 = localObject28;
                                m = i103;
                                int i104 = i102;
                                Object localObject29 = localObject28;
                                int i105 = i104;
                                while (true)
                                {
                                  i17 = localObject29[i103];
                                  switch (m % 5)
                                  {
                                  default:
                                    i106 = 49;
                                    label2244: int i107 = (char)(i106 ^ i17);
                                    localObject29[i103] = i107;
                                    i103 = m + 1;
                                    if (i105 != 0)
                                      break label2285;
                                    localObject29 = localObject2;
                                    int i108 = i103;
                                    i103 = i105;
                                  case 0:
                                  case 1:
                                  case 2:
                                  case 3:
                                  }
                                }
                                label2285: i102 = i105;
                                localObject28 = localObject2;
                              }
                              while (true)
                              {
                                if (i102 > i103)
                                  break label2177;
                                String str14 = new String((char[])localObject28).intern();
                                arrayOfString[i101] = str14;
                                int i109 = 14;
                                Object localObject30 = "\013\013".toCharArray();
                                int i110 = localObject30.length;
                                int i111;
                                label2345: int i114;
                                if (i110 <= 1)
                                {
                                  i111 = 0;
                                  localObject2 = localObject30;
                                  m = i111;
                                  int i112 = i110;
                                  Object localObject31 = localObject30;
                                  int i113 = i112;
                                  while (true)
                                  {
                                    i17 = localObject31[i111];
                                    switch (m % 5)
                                    {
                                    default:
                                      i114 = 49;
                                      label2412: int i115 = (char)(i114 ^ i17);
                                      localObject31[i111] = i115;
                                      i111 = m + 1;
                                      if (i113 != 0)
                                        break label2453;
                                      localObject31 = localObject2;
                                      int i116 = i111;
                                      i111 = i113;
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    }
                                  }
                                  label2453: i110 = i113;
                                  localObject30 = localObject2;
                                }
                                while (true)
                                {
                                  if (i110 > i111)
                                    break label2345;
                                  String str15 = new String((char[])localObject30).intern();
                                  arrayOfString[i109] = str15;
                                  int i117 = 15;
                                  Object localObject32 = "vB\003:_Eh\003:TL_O5XPN\013sEKG\006=V\002M\016:]WY\ns\031".toCharArray();
                                  int i118 = localObject32.length;
                                  int i119;
                                  label2513: int i122;
                                  if (i118 <= 1)
                                  {
                                    i119 = 0;
                                    localObject2 = localObject32;
                                    m = i119;
                                    int i120 = i118;
                                    Object localObject33 = localObject32;
                                    int i121 = i120;
                                    while (true)
                                    {
                                      i17 = localObject33[i119];
                                      switch (m % 5)
                                      {
                                      default:
                                        i122 = 49;
                                        label2580: int i123 = (char)(i122 ^ i17);
                                        localObject33[i119] = i123;
                                        i119 = m + 1;
                                        if (i121 != 0)
                                          break label2621;
                                        localObject33 = localObject2;
                                        int i124 = i119;
                                        i119 = i121;
                                      case 0:
                                      case 1:
                                      case 2:
                                      case 3:
                                      }
                                    }
                                    label2621: i118 = i121;
                                    localObject32 = localObject2;
                                  }
                                  while (true)
                                  {
                                    if (i118 > i119)
                                      break label2513;
                                    String str16 = new String((char[])localObject32).intern();
                                    arrayOfString[i117] = str16;
                                    z = arrayOfString;
                                    if (!_sdkkc.class.desiredAssertionStatus());
                                    while (true)
                                    {
                                      _sdka = i;
                                      return;
                                      i = 0;
                                    }
                                    i3 = 34;
                                    break;
                                    i3 = 43;
                                    break;
                                    i3 = 111;
                                    break;
                                    i3 = 83;
                                    break;
                                    i9 = 34;
                                    break label244;
                                    i9 = 43;
                                    break label244;
                                    i9 = 111;
                                    break label244;
                                    i9 = 83;
                                    break label244;
                                    i18 = 34;
                                    break label408;
                                    i18 = 43;
                                    break label408;
                                    i18 = 111;
                                    break label408;
                                    i18 = 83;
                                    break label408;
                                    i26 = 34;
                                    break label572;
                                    i26 = 43;
                                    break label572;
                                    i26 = 111;
                                    break label572;
                                    i26 = 83;
                                    break label572;
                                    i34 = 34;
                                    break label736;
                                    i34 = 43;
                                    break label736;
                                    i34 = 111;
                                    break label736;
                                    i34 = 83;
                                    break label736;
                                    i42 = 34;
                                    break label900;
                                    i42 = 43;
                                    break label900;
                                    i42 = 111;
                                    break label900;
                                    i42 = 83;
                                    break label900;
                                    i50 = 34;
                                    break label1068;
                                    i50 = 43;
                                    break label1068;
                                    i50 = 111;
                                    break label1068;
                                    i50 = 83;
                                    break label1068;
                                    i58 = 34;
                                    break label1236;
                                    i58 = 43;
                                    break label1236;
                                    i58 = 111;
                                    break label1236;
                                    i58 = 83;
                                    break label1236;
                                    i66 = 34;
                                    break label1404;
                                    i66 = 43;
                                    break label1404;
                                    i66 = 111;
                                    break label1404;
                                    i66 = 83;
                                    break label1404;
                                    i74 = 34;
                                    break label1572;
                                    i74 = 43;
                                    break label1572;
                                    i74 = 111;
                                    break label1572;
                                    i74 = 83;
                                    break label1572;
                                    i82 = 34;
                                    break label1740;
                                    i82 = 43;
                                    break label1740;
                                    i82 = 111;
                                    break label1740;
                                    i82 = 83;
                                    break label1740;
                                    i90 = 34;
                                    break label1908;
                                    i90 = 43;
                                    break label1908;
                                    i90 = 111;
                                    break label1908;
                                    i90 = 83;
                                    break label1908;
                                    i98 = 34;
                                    break label2076;
                                    i98 = 43;
                                    break label2076;
                                    i98 = 111;
                                    break label2076;
                                    i98 = 83;
                                    break label2076;
                                    i106 = 34;
                                    break label2244;
                                    i106 = 43;
                                    break label2244;
                                    i106 = 111;
                                    break label2244;
                                    i106 = 83;
                                    break label2244;
                                    i114 = 34;
                                    break label2412;
                                    i114 = 43;
                                    break label2412;
                                    i114 = 111;
                                    break label2412;
                                    i114 = 83;
                                    break label2412;
                                    i122 = 34;
                                    break label2580;
                                    i122 = 43;
                                    break label2580;
                                    i122 = 111;
                                    break label2580;
                                    i122 = 83;
                                    break label2580;
                                    i119 = 0;
                                  }
                                  i111 = 0;
                                }
                                i103 = 0;
                              }
                              i95 = 0;
                            }
                            i87 = 0;
                          }
                          i79 = 0;
                        }
                        i71 = 0;
                      }
                      i63 = 0;
                    }
                    i55 = 0;
                  }
                  i47 = 0;
                }
                i39 = 0;
              }
              i31 = 0;
            }
            i23 = 0;
          }
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  _sdklc(_sdkkc param_sdkkc)
  {
  }

  public void _sdka(int paramInt, String paramString)
  {
    _sdkhb local_sdkhb = _sdkkc._sdka(this._sdkb);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[15];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(paramInt);
    String str2 = z[14];
    String str3 = str2 + paramString;
    local_sdkhb._sdke(str3);
    synchronized (this._sdkb)
    {
      _sdkkc._sdkl(this._sdkb);
      return;
    }
  }

  public void _sdka(_sdkic param_sdkic, InputStream paramInputStream, int paramInt)
  {
    _sdkhb local_sdkhb1 = _sdkkc._sdka(this._sdkb);
    String str1 = z[0];
    local_sdkhb1._sdkb(str1);
    try
    {
      _sdkkc._sdka(this._sdkb, param_sdkic, paramInputStream, paramInt);
      if (_sdkkc._sdka(this._sdkb)._sdkb())
      {
        _sdkhb local_sdkhb2 = _sdkkc._sdka(this._sdkb);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str2 = z[1];
        String str3 = str2 + param_sdkic;
        local_sdkhb2._sdkb(str3);
      }
      _sdkkc._sdkk(this._sdkb);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        _sdkhb local_sdkhb3 = _sdkkc._sdka(this._sdkb);
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str4 = z[2];
        String str5 = str4 + param_sdkic;
        local_sdkhb3._sdke(str5, localIOException);
      }
    }
  }

  public void _sdka(LinkedList<_sdkic> paramLinkedList)
  {
    boolean bool1 = _sdkkc._sdkr;
    if (_sdkkc._sdka(this._sdkb)._sdkb())
    {
      _sdkhb local_sdkhb1 = _sdkkc._sdka(this._sdkb);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = z[11];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      int i = paramLinkedList.size();
      StringBuilder localStringBuilder3 = localStringBuilder2.append(i);
      String str2 = z[10];
      String str3 = str2;
      local_sdkhb1._sdkb(str3);
    }
    synchronized (this._sdkb)
    {
      if ((!_sdka) && (!_sdkkc._sdkb(this._sdkb)))
        throw new AssertionError();
    }
    boolean bool2 = _sdkkc._sdka(this._sdkb, false);
    int j = _sdkkc._sdkc(this._sdkb)._sdkc().getLastScan().getAPs();
    _sdkkc._sdkc(this._sdkb)._sdke();
    if ((!_sdkkc._sdkd(this._sdkb)) && (paramLinkedList.isEmpty()))
    {
      _sdkhb local_sdkhb2 = _sdkkc._sdka(this._sdkb);
      String str4 = z[7];
      local_sdkhb2._sdkb(str4);
      if (!_sdka)
      {
        Comparator localComparator1 = com.skyhookwireless._sdkgc.COMPARATOR;
        if (!_sdkhd._sdka(j, localComparator1))
          throw new AssertionError();
      }
      if (!_sdka)
      {
        Comparator localComparator2 = com.skyhookwireless._sdkgc.COMPARATOR;
        if (!_sdkhd._sdkb(j, localComparator2))
          throw new AssertionError();
      }
      Cache localCache = _sdkkc._sdke(this._sdkb);
      _sdkzb local_sdkzb = new _sdkzb(j, null, null);
      Boolean localBoolean1 = Boolean.valueOf(true);
      localCache.add(local_sdkzb, localBoolean1);
      return;
    }
    int k = ((_sdkic)paramLinkedList.getFirst())._sdka();
    Map localMap1 = _sdkkc._sdkf(this._sdkb);
    Boolean localBoolean2 = Boolean.valueOf(true);
    Object localObject2 = localMap1.put(k, localBoolean2);
    if (_sdkkc._sdka(this._sdkb)._sdkb())
    {
      _sdkhb local_sdkhb3 = _sdkkc._sdka(this._sdkb);
      StringBuilder localStringBuilder4 = new StringBuilder();
      String str5 = z[5];
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str5).append(k);
      String str6 = z[6];
      String str7 = str6;
      local_sdkhb3._sdkb(str7);
      _sdkhb local_sdkhb4 = _sdkkc._sdka(this._sdkb);
      StringBuilder localStringBuilder6 = new StringBuilder();
      String str8 = z[4];
      StringBuilder localStringBuilder7 = localStringBuilder6.append(str8);
      Map localMap2 = _sdkkc._sdkf(this._sdkb);
      String str9 = localMap2;
      local_sdkhb4._sdkb(str9);
    }
    _sdkkc._sdkg(this._sdkb).clear();
    if (!_sdkkc._sdkd(this._sdkb))
      boolean bool3 = _sdkkc._sdkg(this._sdkb).addAll(paramLinkedList);
    _sdkkc local_sdkkc2 = this._sdkb;
    int n = _sdkkc._sdkg(this._sdkb).size();
    int i1 = _sdkkc._sdka(local_sdkkc2, n);
    Iterator localIterator = _sdkkc._sdkg(this._sdkb).iterator();
    int m;
    for (int i2 = 0; ; i2 = m)
      if (localIterator.hasNext())
      {
        _sdkic local_sdkic1 = (_sdkic)localIterator.next();
        _sdkic local_sdkic2 = _sdkkc._sdkh(this._sdkb)._sdka(local_sdkic1);
        if (local_sdkic2 != null)
        {
          if (_sdkkc._sdka(this._sdkb)._sdkb())
          {
            _sdkhb local_sdkhb5 = _sdkkc._sdka(this._sdkb);
            StringBuilder localStringBuilder8 = new StringBuilder();
            String str10 = z[3];
            StringBuilder localStringBuilder9 = localStringBuilder8.append(str10).append(i2);
            String str11 = z[9];
            StringBuilder localStringBuilder10 = localStringBuilder9.append(str11).append(local_sdkic2);
            String str12 = z[8];
            String str13 = str12 + local_sdkic1;
            local_sdkhb5._sdkb(str13);
          }
          _sdkkc._sdkh(this._sdkb)._sdka(i2, local_sdkic2);
        }
        m = i2 + 1;
        if (!bool1);
      }
      else
      {
        if (_sdkkc._sdka(this._sdkb)._sdkb())
        {
          _sdkhb local_sdkhb6 = _sdkkc._sdka(this._sdkb);
          StringBuilder localStringBuilder11 = new StringBuilder();
          int i3 = _sdkkc._sdki(this._sdkb);
          StringBuilder localStringBuilder12 = localStringBuilder11.append(i3);
          String str14 = z[12];
          String str15 = str14;
          local_sdkhb6._sdkb(str15);
        }
        if (!_sdkkc._sdkj(this._sdkb))
        {
          boolean bool4 = _sdkkc._sdkb(this._sdkb, true);
          _sdkkc._sdkk(this._sdkb);
        }
        if (!_sdkhb._sdkd)
          return;
        if (bool1);
        for (m = 0; ; m = 1)
        {
          _sdkkc._sdkr = m;
          return;
        }
      }
  }

  public void _sdkb(int paramInt, String paramString)
  {
    _sdkhb local_sdkhb = _sdkkc._sdka(this._sdkb);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[13];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(paramInt);
    String str2 = z[14];
    String str3 = str2 + paramString;
    local_sdkhb._sdke(str3);
    _sdkkc._sdkk(this._sdkb);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdklc
 * JD-Core Version:    0.6.2
 */