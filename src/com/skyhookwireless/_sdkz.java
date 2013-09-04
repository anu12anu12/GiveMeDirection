package com.skyhookwireless;

import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class _sdkz
{
  private static final String[] z;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[10];
    Object localObject2 = "[\002;\020\003W\b W\bP\013>W\nF\022r\030\036AG=\021KW\b'\031\017F]r".toCharArray();
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
          i2 = 107;
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
      Object localObject5 = "E\006 \004\016QG\007:?fG1\022\007Y]r".toCharArray();
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
            i8 = 107;
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
        Object localObject7 = "\025\t7\036\f]\005=\005KV\002>\033\030".toCharArray();
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
              i17 = 107;
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
          Object localObject9 = "E\006 \004\016QG\025'9fG1\022\007Y]r".toCharArray();
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
                i25 = 107;
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
            Object localObject11 = "S\b'\031\017\025".toCharArray();
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
                  i33 = 107;
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
              Object localObject13 = "E\006 \004\002[��r0;g4r\031\016\\��:\025\004GG".toCharArray();
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
                    i41 = 107;
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
                Object localObject15 = "[\br\031\016\\��:\025\004GG1\022\007Y\024".toCharArray();
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
                      i49 = 107;
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
                  Object localObject17 = "E\006 \004\002[��r\"&a4r\031\016\\��:\025\004GG".toCharArray();
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
                        i57 = 107;
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
                    Object localObject19 = "@\t9\031\004B\tr\031\016A\020=\005��\025\023+\007\016\017G".toCharArray();
                    int i61 = localObject19.length;
                    label1337: int i66;
                    label1404: int i63;
                    if (i61 <= 1)
                    {
                      int i62 = 0;
                      localObject3 = localObject19;
                      k = i62;
                      int i64 = i61;
                      Object localObject21 = localObject19;
                      int i65 = i64;
                      while (true)
                      {
                        i16 = localObject21[i62];
                        switch (k % 5)
                        {
                        default:
                          i66 = 107;
                          int i67 = (char)(i66 ^ i16);
                          localObject21[i62] = i67;
                          i63 = k + 1;
                          if (i65 != 0)
                            break label1445;
                          localObject21 = localObject3;
                          int i68 = i63;
                          i63 = i65;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1445: i61 = i65;
                      localObject19 = localObject3;
                    }
                    while (true)
                    {
                      if (i61 > i63)
                        break label1337;
                      String str9 = new String((char[])localObject19).intern();
                      arrayOfString[i60] = str9;
                      int i69 = 9;
                      Object localObject22 = "\\��<\030\031\\\t5W\005P\0165\037\tZ\025r".toCharArray();
                      Object localObject23 = localObject22.length;
                      label1502: Object localObject25;
                      Object localObject26;
                      label1521: int i70;
                      if (localObject23 <= 1)
                      {
                        localObject20 = localObject22;
                        localObject3 = localObject1;
                        Object localObject24 = localObject23;
                        localObject25 = localObject22;
                        localObject26 = localObject24;
                        i60 = localObject25[localObject1];
                        switch (localObject3 % 5)
                        {
                        default:
                          i70 = 107;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      while (true)
                      {
                        int i71 = (char)(i70 ^ i60);
                        localObject25[localObject1] = i71;
                        localObject1 = localObject3 + 1;
                        if (localObject26 == 0)
                        {
                          localObject25 = localObject20;
                          int i72 = localObject1;
                          localObject1 = localObject26;
                          break label1521;
                        }
                        localObject23 = localObject26;
                        localObject22 = localObject20;
                        if (localObject23 > localObject1)
                          break label1502;
                        String str10 = new String((char[])localObject22).intern();
                        arrayOfString[i69] = str10;
                        z = arrayOfString;
                        return;
                        i2 = 53;
                        break;
                        i2 = 103;
                        break;
                        i2 = 82;
                        break;
                        i2 = 119;
                        break;
                        i8 = 53;
                        break label244;
                        i8 = 103;
                        break label244;
                        i8 = 82;
                        break label244;
                        i8 = 119;
                        break label244;
                        i17 = 53;
                        break label408;
                        i17 = 103;
                        break label408;
                        i17 = 82;
                        break label408;
                        i17 = 119;
                        break label408;
                        i25 = 53;
                        break label572;
                        i25 = 103;
                        break label572;
                        i25 = 82;
                        break label572;
                        i25 = 119;
                        break label572;
                        i33 = 53;
                        break label736;
                        i33 = 103;
                        break label736;
                        i33 = 82;
                        break label736;
                        i33 = 119;
                        break label736;
                        i41 = 53;
                        break label900;
                        i41 = 103;
                        break label900;
                        i41 = 82;
                        break label900;
                        i41 = 119;
                        break label900;
                        i49 = 53;
                        break label1068;
                        i49 = 103;
                        break label1068;
                        i49 = 82;
                        break label1068;
                        i49 = 119;
                        break label1068;
                        i57 = 53;
                        break label1236;
                        i57 = 103;
                        break label1236;
                        i57 = 82;
                        break label1236;
                        i57 = 119;
                        break label1236;
                        i66 = 53;
                        break label1404;
                        i66 = 103;
                        break label1404;
                        i66 = 82;
                        break label1404;
                        i66 = 119;
                        break label1404;
                        i70 = 53;
                        continue;
                        i70 = 103;
                        continue;
                        i70 = 82;
                        continue;
                        i70 = 119;
                      }
                      Object localObject20 = null;
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
    if ((j == 0) || (j.isEmpty()))
    {
      String str1 = z[6];
      param_sdkhb._sdkb(str1);
    }
    ArrayList localArrayList;
    label764: for (Object localObject = Collections.emptyList(); ; localObject = localArrayList)
    {
      return localObject;
      _sdkec local_sdkec = _sdkec._sdkd();
      boolean bool1 = param_sdkhb._sdkb();
      if (bool1)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str2 = z[4];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
        int n = j.size();
        StringBuilder localStringBuilder3 = localStringBuilder2.append(n);
        String str3 = z[2];
        String str4 = str3;
        param_sdkhb._sdkb(str4);
      }
      int i1 = j.size();
      localArrayList = new ArrayList(i1);
      Iterator localIterator = j.iterator();
      do
      {
        int k;
        int i2;
        do
        {
          do
          {
            if (!localIterator.hasNext())
              break label764;
            k = (NeighboringCellInfo)localIterator.next();
            i2 = k.getNetworkType();
            int i3 = k.getCid();
            if ((i3 != -1) && (k.getRssi() != 99) && (i2 != 0))
              break;
          }
          while (!bool1);
          StringBuilder localStringBuilder4 = new StringBuilder();
          String str6 = z[9];
          String str5 = str6 + k;
          param_sdkhb._sdkb(str5);
        }
        while (i == 0);
        if ((i2 == 1) || (i2 == 2))
        {
          if (bool1)
          {
            StringBuilder localStringBuilder5 = new StringBuilder();
            String str7 = z[5];
            String str8 = str7 + k;
            param_sdkhb._sdkb(str8);
          }
          int i5 = k.getLac();
          int i6 = k.getCid();
          int i7 = k.getRssi();
          int i4;
          if (!_sdkab._sdka(i7))
          {
            i4 = _sdkab._sdkb(i7);
            if (i == 0);
          }
          else if (param_sdkhb._sdkd())
          {
            StringBuilder localStringBuilder6 = new StringBuilder();
            String str9 = z[0];
            StringBuilder localStringBuilder7 = localStringBuilder6.append(str9);
            int i8 = k.getRssi();
            String str10 = i8;
            param_sdkhb._sdkd(str10);
          }
          int i9 = param_sdkv._sdkd();
          int i10 = param_sdkv._sdke();
          _sdkv local_sdkv1 = new _sdkv(i9, i10, i6, i5);
          _sdkab local_sdkab1 = new _sdkab(local_sdkv1, 0, i4, local_sdkec);
          if (bool1)
          {
            StringBuilder localStringBuilder8 = new StringBuilder();
            String str11 = z[3];
            String str12 = str11 + local_sdkab1;
            param_sdkhb._sdkb(str12);
          }
          boolean bool2 = localArrayList.add(local_sdkab1);
          if (i == 0);
        }
        else if ((i2 == 3) || (i2 == 8) || (i2 == 9) || (i2 == 10))
        {
          if (bool1)
          {
            StringBuilder localStringBuilder9 = new StringBuilder();
            String str13 = z[7];
            String str14 = str13 + k;
            param_sdkhb._sdkb(str14);
          }
          int i11 = k.getPsc();
          int m = k.getRssi();
          if (m >= 0)
            int i12 = m + -115;
          int i13 = param_sdkv._sdkd();
          int i14 = param_sdkv._sdke();
          _sdkv local_sdkv2 = new _sdkv(i13, i14, i11);
          _sdkab local_sdkab2 = new _sdkab(local_sdkv2, 0, m, local_sdkec);
          if (bool1)
          {
            StringBuilder localStringBuilder10 = new StringBuilder();
            String str15 = z[1];
            String str16 = str15 + local_sdkab2;
            param_sdkhb._sdkb(str16);
          }
          boolean bool3 = localArrayList.add(local_sdkab2);
          if (i == 0);
        }
        else
        {
          StringBuilder localStringBuilder11 = new StringBuilder();
          String str17 = z[8];
          String str18 = str17 + i2;
          param_sdkhb._sdkd(str18);
        }
      }
      while (i == 0);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkz
 * JD-Core Version:    0.6.2
 */