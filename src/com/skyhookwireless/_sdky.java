package com.skyhookwireless;

import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class _sdky
{
  private static final String[] z;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[11];
    Object localObject2 = "l(\013&\007*)\033!\004b%\021:Ci\"\022$\020".toCharArray();
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
          i2 = 99;
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
      Object localObject5 = "c \020'\021og\020-\nm/\034'\021*".toCharArray();
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
            i8 = 99;
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
        Object localObject7 = "d\"\027/\013h(\fh��o+\022h\002y2^'\026~g\021.Ch(\013&\007y}^".toCharArray();
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
              i17 = 99;
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
          Object localObject9 = "z&\f;\nd ^\0173X\024^+\006f+".toCharArray();
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
                i25 = 99;
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
            Object localObject11 = "z&\f;\006ng\020'\r'��.\0320*$\033$\0170g".toCharArray();
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
                  i33 = 99;
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
              Object localObject13 = "i(\013$\007d`\nh\023k5\r-Cd\"\027/\013h(\fh��o+\022".toCharArray();
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
                    i41 = 99;
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
                Object localObject15 = "d\"\n?\fx,^<\032z\"^=\ra)\021?\r".toCharArray();
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
                      i49 = 99;
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
                  Object localObject17 = "z&\f;\nd ^&\fdj9\0301Yg\035-\017f".toCharArray();
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
                        i57 = 99;
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
                    Object localObject19 = "z&\f;\006ng9\0301Yg\035-\017f}^".toCharArray();
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
                          i65 = 99;
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
                      Object localObject21 = "d(^&\006c \026*\fxg\035-\017f4".toCharArray();
                      int i69 = localObject21.length;
                      label1505: int i74;
                      label1572: int i71;
                      if (i69 <= 1)
                      {
                        int i70 = 0;
                        localObject3 = localObject21;
                        k = i70;
                        int i72 = i69;
                        Object localObject23 = localObject21;
                        int i73 = i72;
                        while (true)
                        {
                          i16 = localObject23[i70];
                          switch (k % 5)
                          {
                          default:
                            i74 = 99;
                            int i75 = (char)(i74 ^ i16);
                            localObject23[i70] = i75;
                            i71 = k + 1;
                            if (i73 != 0)
                              break label1613;
                            localObject23 = localObject3;
                            int i76 = i71;
                            i71 = i73;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1613: i69 = i73;
                        localObject21 = localObject3;
                      }
                      while (true)
                      {
                        if (i69 > i71)
                          break label1505;
                        String str10 = new String((char[])localObject21).intern();
                        arrayOfString[i68] = str10;
                        Object localObject24 = "i(\013$\007d`\nh\023k5\r-Ci.\032g\017k$Dh".toCharArray();
                        Object localObject25 = localObject24.length;
                        label1666: Object localObject27;
                        Object localObject28;
                        label1685: int i77;
                        int i78;
                        if (localObject25 <= 1)
                        {
                          localObject22 = localObject24;
                          localObject3 = localObject1;
                          Object localObject26 = localObject25;
                          localObject27 = localObject24;
                          localObject28 = localObject26;
                          i77 = localObject27[localObject1];
                          switch (localObject3 % 5)
                          {
                          default:
                            i78 = 99;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        while (true)
                        {
                          int i79 = (char)(i78 ^ i77);
                          localObject27[localObject1] = i79;
                          localObject1 = localObject3 + 1;
                          if (localObject28 == 0)
                          {
                            localObject27 = localObject22;
                            int i80 = localObject1;
                            localObject1 = localObject28;
                            break label1685;
                          }
                          localObject25 = localObject28;
                          localObject24 = localObject22;
                          if (localObject25 > localObject1)
                            break label1666;
                          String str11 = new String((char[])localObject24).intern();
                          arrayOfString[10] = str11;
                          z = arrayOfString;
                          return;
                          i2 = 10;
                          break;
                          i2 = 71;
                          break;
                          i2 = 126;
                          break;
                          i2 = 72;
                          break;
                          i8 = 10;
                          break label244;
                          i8 = 71;
                          break label244;
                          i8 = 126;
                          break label244;
                          i8 = 72;
                          break label244;
                          i17 = 10;
                          break label408;
                          i17 = 71;
                          break label408;
                          i17 = 126;
                          break label408;
                          i17 = 72;
                          break label408;
                          i25 = 10;
                          break label572;
                          i25 = 71;
                          break label572;
                          i25 = 126;
                          break label572;
                          i25 = 72;
                          break label572;
                          i33 = 10;
                          break label736;
                          i33 = 71;
                          break label736;
                          i33 = 126;
                          break label736;
                          i33 = 72;
                          break label736;
                          i41 = 10;
                          break label900;
                          i41 = 71;
                          break label900;
                          i41 = 126;
                          break label900;
                          i41 = 72;
                          break label900;
                          i49 = 10;
                          break label1068;
                          i49 = 71;
                          break label1068;
                          i49 = 126;
                          break label1068;
                          i49 = 72;
                          break label1068;
                          i57 = 10;
                          break label1236;
                          i57 = 71;
                          break label1236;
                          i57 = 126;
                          break label1236;
                          i57 = 72;
                          break label1236;
                          i65 = 10;
                          break label1404;
                          i65 = 71;
                          break label1404;
                          i65 = 126;
                          break label1404;
                          i65 = 72;
                          break label1404;
                          i74 = 10;
                          break label1572;
                          i74 = 71;
                          break label1572;
                          i74 = 126;
                          break label1572;
                          i74 = 72;
                          break label1572;
                          i78 = 10;
                          continue;
                          i78 = 71;
                          continue;
                          i78 = 126;
                          continue;
                          i78 = 72;
                        }
                        Object localObject22 = null;
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

  static List<_sdkab> _sdka(TelephonyManager paramTelephonyManager, _sdkhb param_sdkhb, _sdkv param_sdkv)
  {
    int i = _sdkab._sdkf;
    int j = paramTelephonyManager.getNeighboringCellInfo();
    int m;
    if ((j != 0) && (!j.isEmpty()))
    {
      String str1 = z[0];
      param_sdkhb._sdkb(str1);
      m = paramTelephonyManager.getNetworkType();
      if (m == 0)
      {
        String str2 = z[6];
        param_sdkhb._sdkd(str2);
      }
    }
    for (Object localObject1 = Collections.emptyList(); ; localObject1 = Collections.emptyList())
    {
      return localObject1;
      int n;
      _sdkec local_sdkec;
      ArrayList localArrayList;
      label120: NeighboringCellInfo localNeighboringCellInfo;
      if ((m == 1) || (m == 2))
      {
        n = 1;
        local_sdkec = _sdkec._sdkd();
        int i1 = j.size();
        localArrayList = new ArrayList(i1);
        Iterator localIterator = j.iterator();
        while (localIterator.hasNext())
        {
          localNeighboringCellInfo = (NeighboringCellInfo)localIterator.next();
          if ((localNeighboringCellInfo.getCid() == -1) || (localNeighboringCellInfo.getRssi() == 99))
          {
            if (param_sdkhb._sdkb())
            {
              StringBuilder localStringBuilder1 = new StringBuilder();
              String str3 = z[1];
              String str4 = str3 + localNeighboringCellInfo;
              param_sdkhb._sdkb(str4);
              if (i == 0)
                break;
            }
          }
          else
            if (n == 0)
              break label607;
        }
      }
      while (true)
      {
        try
        {
          String str5 = z[3];
          param_sdkhb._sdkb(str5);
          int i2 = Integer.toHexString(localNeighboringCellInfo.getCid());
          if ((i2.length() < 4) || (i2.length() > 8))
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            String str6 = z[10];
            String str7 = str6 + i2;
            param_sdkhb._sdkd(str7);
            if (i == 0)
              break label120;
          }
          int i4 = i2.length() + -4;
          int i5 = Integer.valueOf(i2.substring(0, i4), 16).intValue();
          int i6 = i2.length() + -4;
          int i7 = Integer.valueOf(i2.substring(i6), 16).intValue();
          int i3 = localNeighboringCellInfo.getRssi();
          if (!_sdkab._sdka(i3))
          {
            i3 = _sdkab._sdkb(i3);
            if (i == 0);
          }
          else
          {
            if (param_sdkhb._sdkd())
            {
              StringBuilder localStringBuilder3 = new StringBuilder();
              String str8 = z[2];
              StringBuilder localStringBuilder4 = localStringBuilder3.append(str8);
              int i8 = localNeighboringCellInfo.getRssi();
              String str9 = i8;
              param_sdkhb._sdkd(str9);
            }
            i3 = 65423;
          }
          int i9 = param_sdkv._sdkd();
          int i10 = param_sdkv._sdke();
          _sdkv local_sdkv1 = new _sdkv(i9, i10, i7, i5);
          _sdkab local_sdkab1 = new _sdkab(local_sdkv1, 0, i3, local_sdkec);
          boolean bool1 = localArrayList.add(local_sdkab1);
          if (param_sdkhb._sdkb())
          {
            StringBuilder localStringBuilder5 = new StringBuilder();
            String str10 = z[8];
            StringBuilder localStringBuilder6 = localStringBuilder5.append(str10);
            int i11 = localArrayList.size() + -1;
            Object localObject2 = localArrayList.get(i11);
            String str11 = localObject2;
            param_sdkhb._sdkb(str11);
          }
          if (i == 0)
            break label120;
          localObject1 = localArrayList;
          break;
          n = 0;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          String str12 = z[5];
          param_sdkhb._sdke(str12, localNumberFormatException);
          if (i == 0)
            continue;
        }
        label607: String str13 = z[7];
        param_sdkhb._sdkb(str13);
        int k = localNeighboringCellInfo.getRssi();
        if (k >= 0)
          int i12 = k + -115;
        int i13 = param_sdkv._sdkd();
        int i14 = param_sdkv._sdke();
        int i15 = localNeighboringCellInfo.getCid();
        _sdkv local_sdkv2 = new _sdkv(i13, i14, i15);
        _sdkab local_sdkab2 = new _sdkab(local_sdkv2, 0, k, local_sdkec);
        boolean bool2 = localArrayList.add(local_sdkab2);
        if (param_sdkhb._sdkb())
        {
          StringBuilder localStringBuilder7 = new StringBuilder();
          String str14 = z[4];
          StringBuilder localStringBuilder8 = localStringBuilder7.append(str14);
          int i16 = localArrayList.size() + -1;
          Object localObject3 = localArrayList.get(i16);
          String str15 = localObject3;
          param_sdkhb._sdkb(str15);
        }
      }
      String str16 = z[9];
      param_sdkhb._sdkb(str16);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdky
 * JD-Core Version:    0.6.2
 */