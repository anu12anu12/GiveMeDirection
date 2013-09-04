package com.skyhookwireless;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import com.skyhookwireless.wps._sdkib;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class _sdkvc extends _sdkuc
{
  public static boolean _sdkk;
  private static final String[] z;
  private final PhoneStateListener _sdke;
  private final _sdkhb _sdkf;
  private final Context _sdkg;
  private final TelephonyManager _sdkh;
  private boolean _sdki;
  private _sdkib _sdkj;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[14];
    Object localObject2 = "v`\032\035p{(\033Qq{n\r\035q5c��\022uaf��\0374`\013\020`p|UQ".toCharArray();
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
          i2 = 20;
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
      Object localObject5 = "ta\013\003{|kA\001qgb\006\002g|`\001_WZA;#[YP#>WT[&>ZJZ?5UAJ<".toCharArray();
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
            i8 = 20;
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
        Object localObject7 = "pa\016\023xpC��\022uaf��\037Aek\016\005qf".toCharArray();
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
              i17 = 20;
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
          Object localObject9 = "{`\033Quyc��\006qq/\033\0364pa\016\023xp \013\030gtm\003\0244y`\f\020`|`\001Qaek\016\005qf".toCharArray();
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
                i25 = 20;
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
            Object localObject11 = "y`\f\020`|`\001Qaek\016\005qf/\n\037uwc\n\025".toCharArray();
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
                  i33 = 20;
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
              Object localObject13 = "`a\004\037{baO\022pxnO\035{vn\033\030{{".toCharArray();
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
                    i41 = 20;
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
                Object localObject15 = "{`O\022pxnO\002qgy\006\037s5l\n\035x".toCharArray();
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
                      i49 = 20;
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
                  Object localObject17 = "vk\002\0204y`\f\020`|`\001K4".toCharArray();
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
                        i57 = 20;
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
                    Object localObject19 = "|a\031\020x|kO\022pxnO\035{vn\033\030{{".toCharArray();
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
                          i65 = 20;
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
                      Object localObject21 = "r`\033QzpxO\035{vn\033\030{{/\030\031}yjO\037{a/\033\003uvd\006\037s".toCharArray();
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
                            i73 = 20;
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
                        Object localObject23 = "eg��\037q".toCharArray();
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
                              i81 = 20;
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
                          Object localObject25 = "eg��\037q5{\026\001q52O".toCharArray();
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
                                i89 = 20;
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
                            Object localObject27 = "qf\034\020vyj#\036wt{\006\036z@\013\020`p|".toCharArray();
                            int i93 = localObject27.length;
                            label2009: int i98;
                            label2076: int i95;
                            if (i93 <= 1)
                            {
                              int i94 = 0;
                              localObject3 = localObject27;
                              k = i94;
                              int i96 = i93;
                              Object localObject29 = localObject27;
                              int i97 = i96;
                              while (true)
                              {
                                i16 = localObject29[i94];
                                switch (k % 5)
                                {
                                default:
                                  i98 = 20;
                                  int i99 = (char)(i98 ^ i16);
                                  localObject29[i94] = i99;
                                  i95 = k + 1;
                                  if (i97 != 0)
                                    break label2117;
                                  localObject29 = localObject3;
                                  int i100 = i95;
                                  i95 = i97;
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                }
                              }
                              label2117: i93 = i97;
                              localObject27 = localObject3;
                            }
                            while (true)
                            {
                              if (i93 > i95)
                                break label2009;
                              String str13 = new String((char[])localObject27).intern();
                              arrayOfString[i92] = str13;
                              int i101 = 13;
                              Object localObject30 = "v`\032\035p{(\033Qp||\016\023xp/\003\036wt{\006\036z5z\037\025uaj\034K4".toCharArray();
                              Object localObject31 = localObject30.length;
                              label2174: Object localObject33;
                              Object localObject34;
                              label2193: int i102;
                              if (localObject31 <= 1)
                              {
                                localObject28 = localObject30;
                                localObject3 = localObject1;
                                Object localObject32 = localObject31;
                                localObject33 = localObject30;
                                localObject34 = localObject32;
                                i92 = localObject33[localObject1];
                                switch (localObject3 % 5)
                                {
                                default:
                                  i102 = 20;
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                }
                              }
                              while (true)
                              {
                                int i103 = (char)(i102 ^ i92);
                                localObject33[localObject1] = i103;
                                localObject1 = localObject3 + 1;
                                if (localObject34 == 0)
                                {
                                  localObject33 = localObject28;
                                  int i104 = localObject1;
                                  localObject1 = localObject34;
                                  break label2193;
                                }
                                localObject31 = localObject34;
                                localObject30 = localObject28;
                                if (localObject31 > localObject1)
                                  break label2174;
                                String str14 = new String((char[])localObject30).intern();
                                arrayOfString[i101] = str14;
                                z = arrayOfString;
                                return;
                                i2 = 21;
                                break;
                                i2 = 15;
                                break;
                                i2 = 111;
                                break;
                                i2 = 113;
                                break;
                                i8 = 21;
                                break label244;
                                i8 = 15;
                                break label244;
                                i8 = 111;
                                break label244;
                                i8 = 113;
                                break label244;
                                i17 = 21;
                                break label408;
                                i17 = 15;
                                break label408;
                                i17 = 111;
                                break label408;
                                i17 = 113;
                                break label408;
                                i25 = 21;
                                break label572;
                                i25 = 15;
                                break label572;
                                i25 = 111;
                                break label572;
                                i25 = 113;
                                break label572;
                                i33 = 21;
                                break label736;
                                i33 = 15;
                                break label736;
                                i33 = 111;
                                break label736;
                                i33 = 113;
                                break label736;
                                i41 = 21;
                                break label900;
                                i41 = 15;
                                break label900;
                                i41 = 111;
                                break label900;
                                i41 = 113;
                                break label900;
                                i49 = 21;
                                break label1068;
                                i49 = 15;
                                break label1068;
                                i49 = 111;
                                break label1068;
                                i49 = 113;
                                break label1068;
                                i57 = 21;
                                break label1236;
                                i57 = 15;
                                break label1236;
                                i57 = 111;
                                break label1236;
                                i57 = 113;
                                break label1236;
                                i65 = 21;
                                break label1404;
                                i65 = 15;
                                break label1404;
                                i65 = 111;
                                break label1404;
                                i65 = 113;
                                break label1404;
                                i73 = 21;
                                break label1572;
                                i73 = 15;
                                break label1572;
                                i73 = 111;
                                break label1572;
                                i73 = 113;
                                break label1572;
                                i81 = 21;
                                break label1740;
                                i81 = 15;
                                break label1740;
                                i81 = 111;
                                break label1740;
                                i81 = 113;
                                break label1740;
                                i89 = 21;
                                break label1908;
                                i89 = 15;
                                break label1908;
                                i89 = 111;
                                break label1908;
                                i89 = 113;
                                break label1908;
                                i98 = 21;
                                break label2076;
                                i98 = 15;
                                break label2076;
                                i98 = 111;
                                break label2076;
                                i98 = 113;
                                break label2076;
                                i102 = 21;
                                continue;
                                i102 = 15;
                                continue;
                                i102 = 111;
                                continue;
                                i102 = 113;
                              }
                              Object localObject28 = null;
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

  public _sdkvc(_sdkt param_sdkt)
    throws _sdkk
  {
    _sdkc local_sdkc = new _sdkc(this);
    this._sdke = local_sdkc;
    this._sdkj = null;
    _sdkhb local_sdkhb1 = _sdkhb._sdkb(_sdkvc.class);
    this._sdkf = local_sdkhb1;
    Context localContext = ((_sdkq)param_sdkt)._sdka();
    this._sdkg = localContext;
    try
    {
      Future localFuture = _sdkr._sdka(new _sdks(this));
      TimeUnit localTimeUnit = TimeUnit.SECONDS;
      TelephonyManager localTelephonyManager = (TelephonyManager)localFuture.get(2L, localTimeUnit);
      this._sdkh = localTelephonyManager;
      i = this._sdkh.getPhoneType();
      if (i != 2)
      {
        _sdkhb local_sdkhb2 = this._sdkf;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[11];
        String str2 = str1 + i;
        local_sdkhb2._sdkb(str2);
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str3 = z[11];
        String str4 = str3 + i;
        throw new _sdkk(str4);
      }
    }
    catch (Exception localException)
    {
      String str5 = z[10];
      throw new _sdkk(str5, localException);
    }
    this._sdki = false;
    this._sdkj = null;
    if (!bool)
      return;
    if (_sdkhb._sdkd);
    for (int i = 0; ; i = 1)
    {
      _sdkhb._sdkd = i;
      return;
    }
  }

  static Context _sdka(_sdkvc param_sdkvc)
  {
    return param_sdkvc._sdkg;
  }

  /** @deprecated */
  private void _sdka(CdmaCellLocation paramCdmaCellLocation)
  {
    try
    {
      boolean bool = _sdkk;
      if (!_sdkb())
      {
        _sdkhb local_sdkhb1 = this._sdkf;
        String str1 = z[9];
        local_sdkhb1._sdkb(str1);
      }
      while (true)
      {
        return;
        double d1;
        if (paramCdmaCellLocation == null)
        {
          d1 = 0.0D;
          this._sdkj = d1;
          _sdkhb local_sdkhb2 = this._sdkf;
          String str2 = z[6];
          local_sdkhb2._sdkb(str2);
          if (!bool);
        }
        else if ((paramCdmaCellLocation.getBaseStationLatitude() == 2147483647) || (paramCdmaCellLocation.getBaseStationLongitude() == 2147483647))
        {
          this._sdkj = null;
          _sdkhb local_sdkhb3 = this._sdkf;
          String str3 = z[5];
          local_sdkhb3._sdkb(str3);
          if (!bool);
        }
        else
        {
          d1 = paramCdmaCellLocation.getBaseStationLatitude() * 6.944444444444444E-005D;
          double d2 = paramCdmaCellLocation.getBaseStationLongitude() * 6.944444444444444E-005D;
          if ((d1 < -90.0D) || (90.0D < d1) || (d2 < -180.0D) || (180.0D < d2))
          {
            this._sdkj = null;
            _sdkhb local_sdkhb4 = this._sdkf;
            String str4 = z[8];
            local_sdkhb4._sdkd(str4);
            if (!bool);
          }
          else
          {
            _sdkib local_sdkib1 = new _sdkib();
            this._sdkj = local_sdkib1;
            _sdkib local_sdkib2 = this._sdkj;
            long l = System.currentTimeMillis();
            local_sdkib2.setTime(l);
            this._sdkj.setLatitude(d1);
            this._sdkj.setLongitude(d2);
            this._sdkj.setNCell(1);
            if (this._sdkf._sdkb())
            {
              _sdkhb local_sdkhb5 = this._sdkf;
              StringBuilder localStringBuilder1 = new StringBuilder();
              String str5 = z[7];
              StringBuilder localStringBuilder2 = localStringBuilder1.append(str5);
              _sdkib local_sdkib3 = this._sdkj;
              String str6 = local_sdkib3;
              local_sdkhb5._sdkb(str6);
            }
          }
        }
      }
    }
    finally
    {
    }
  }

  static void _sdka(_sdkvc param_sdkvc, CdmaCellLocation paramCdmaCellLocation)
  {
    param_sdkvc._sdka(paramCdmaCellLocation);
  }

  static _sdkhb _sdkb(_sdkvc param_sdkvc)
  {
    return param_sdkvc._sdkf;
  }

  protected _sdkuc _sdka(_sdkt param_sdkt, String paramString)
    throws _sdkk
  {
    return new _sdkvc(param_sdkt);
  }

  /** @deprecated */
  // ERROR //
  public void _sdka(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 152	com/skyhookwireless/_sdkvc:_sdki	Z
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: aload_3
    //   18: putfield 152	com/skyhookwireless/_sdkvc:_sdki	Z
    //   21: aload_0
    //   22: getfield 125	com/skyhookwireless/_sdkvc:_sdkh	Landroid/telephony/TelephonyManager;
    //   25: astore 4
    //   27: aload_0
    //   28: getfield 81	com/skyhookwireless/_sdkvc:_sdke	Landroid/telephony/PhoneStateListener;
    //   31: astore 5
    //   33: aload 4
    //   35: aload 5
    //   37: bipush 17
    //   39: invokevirtual 226	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   42: aload_0
    //   43: getfield 99	com/skyhookwireless/_sdkvc:_sdkg	Landroid/content/Context;
    //   46: astore 6
    //   48: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   51: iconst_1
    //   52: aaload
    //   53: astore 7
    //   55: aload 6
    //   57: aload 7
    //   59: invokevirtual 232	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   62: ifeq +31 -> 93
    //   65: aload_0
    //   66: getfield 91	com/skyhookwireless/_sdkvc:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   69: astore 8
    //   71: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   74: iconst_3
    //   75: aaload
    //   76: astore 9
    //   78: aload 8
    //   80: aload 9
    //   82: invokevirtual 145	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   85: getstatic 72	com/skyhookwireless/_sdkvc:_sdkk	Z
    //   88: astore_3
    //   89: aload_3
    //   90: ifnull +89 -> 179
    //   93: aload_0
    //   94: getfield 125	com/skyhookwireless/_sdkvc:_sdkh	Landroid/telephony/TelephonyManager;
    //   97: invokevirtual 238	java/lang/Object:getClass	()Ljava/lang/Class;
    //   100: astore 10
    //   102: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   105: iconst_2
    //   106: aaload
    //   107: astore 11
    //   109: iconst_0
    //   110: anewarray 240	java/lang/Class
    //   113: astore 12
    //   115: aload 10
    //   117: aload 11
    //   119: aload 12
    //   121: invokevirtual 244	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: astore_3
    //   125: aload_3
    //   126: invokevirtual 249	java/lang/reflect/Method:isAccessible	()Z
    //   129: ifne +8 -> 137
    //   132: aload_3
    //   133: iconst_1
    //   134: invokevirtual 253	java/lang/reflect/Method:setAccessible	(Z)V
    //   137: aload_0
    //   138: getfield 125	com/skyhookwireless/_sdkvc:_sdkh	Landroid/telephony/TelephonyManager;
    //   141: astore 13
    //   143: iconst_0
    //   144: anewarray 234	java/lang/Object
    //   147: astore 14
    //   149: aload_3
    //   150: aload 13
    //   152: aload 14
    //   154: invokevirtual 257	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   157: astore 15
    //   159: aload_0
    //   160: getfield 91	com/skyhookwireless/_sdkvc:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   163: astore 16
    //   165: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   168: iconst_4
    //   169: aaload
    //   170: astore 17
    //   172: aload 16
    //   174: aload 17
    //   176: invokevirtual 145	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   179: invokestatic 262	android/telephony/CellLocation:requestLocationUpdate	()V
    //   182: goto -171 -> 11
    //   185: astore 18
    //   187: aload_0
    //   188: monitorexit
    //   189: aload 18
    //   191: athrow
    //   192: astore_3
    //   193: aload_0
    //   194: getfield 91	com/skyhookwireless/_sdkvc:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   197: astore 19
    //   199: new 131	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   206: astore 20
    //   208: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   211: iconst_0
    //   212: aaload
    //   213: astore 21
    //   215: aload 20
    //   217: aload 21
    //   219: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: astore 22
    //   224: aload_3
    //   225: invokevirtual 266	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   228: astore 23
    //   230: aload 22
    //   232: aload 23
    //   234: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore 24
    //   242: aload 19
    //   244: aload 24
    //   246: invokevirtual 145	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   249: goto -70 -> 179
    //   252: astore 25
    //   254: aload_0
    //   255: getfield 91	com/skyhookwireless/_sdkvc:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   258: astore 26
    //   260: new 131	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   267: astore 27
    //   269: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   272: iconst_0
    //   273: aaload
    //   274: astore 28
    //   276: aload 27
    //   278: aload 28
    //   280: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 25
    //   285: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: astore 29
    //   293: aload 26
    //   295: aload 29
    //   297: invokevirtual 145	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   300: goto -121 -> 179
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	185	finally
    //   16	89	185	finally
    //   93	179	185	finally
    //   179	182	185	finally
    //   193	300	185	finally
    //   93	179	192	java/lang/reflect/InvocationTargetException
    //   93	179	252	java/lang/Throwable
  }

  public boolean _sdka()
  {
    return false;
  }

  /** @deprecated */
  public boolean _sdkb()
  {
    try
    {
      boolean bool = this._sdki;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  // ERROR //
  public void _sdkc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 152	com/skyhookwireless/_sdkvc:_sdki	Z
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 99	com/skyhookwireless/_sdkvc:_sdkg	Landroid/content/Context;
    //   18: astore_2
    //   19: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   22: iconst_1
    //   23: aaload
    //   24: astore_3
    //   25: aload_2
    //   26: aload_3
    //   27: invokevirtual 232	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   30: istore 4
    //   32: iload 4
    //   34: ifne +70 -> 104
    //   37: aload_0
    //   38: getfield 125	com/skyhookwireless/_sdkvc:_sdkh	Landroid/telephony/TelephonyManager;
    //   41: invokevirtual 238	java/lang/Object:getClass	()Ljava/lang/Class;
    //   44: astore 5
    //   46: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   49: bipush 12
    //   51: aaload
    //   52: astore 6
    //   54: iconst_0
    //   55: anewarray 240	java/lang/Class
    //   58: astore 7
    //   60: aload 5
    //   62: aload 6
    //   64: aload 7
    //   66: invokevirtual 244	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 249	java/lang/reflect/Method:isAccessible	()Z
    //   74: ifne +8 -> 82
    //   77: aload_1
    //   78: iconst_1
    //   79: invokevirtual 253	java/lang/reflect/Method:setAccessible	(Z)V
    //   82: aload_0
    //   83: getfield 125	com/skyhookwireless/_sdkvc:_sdkh	Landroid/telephony/TelephonyManager;
    //   86: astore 8
    //   88: iconst_0
    //   89: anewarray 234	java/lang/Object
    //   92: astore 9
    //   94: aload_1
    //   95: aload 8
    //   97: aload 9
    //   99: invokevirtual 257	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore 10
    //   104: aload_0
    //   105: getfield 125	com/skyhookwireless/_sdkvc:_sdkh	Landroid/telephony/TelephonyManager;
    //   108: astore 11
    //   110: aload_0
    //   111: getfield 81	com/skyhookwireless/_sdkvc:_sdke	Landroid/telephony/PhoneStateListener;
    //   114: astore 12
    //   116: aload 11
    //   118: aload 12
    //   120: iconst_0
    //   121: invokevirtual 226	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   124: aload_0
    //   125: iconst_0
    //   126: putfield 152	com/skyhookwireless/_sdkvc:_sdki	Z
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 83	com/skyhookwireless/_sdkvc:_sdkj	Lcom/skyhookwireless/wps/_sdkib;
    //   134: goto -123 -> 11
    //   137: astore 13
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 13
    //   143: athrow
    //   144: astore_1
    //   145: aload_0
    //   146: getfield 91	com/skyhookwireless/_sdkvc:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   149: astore 14
    //   151: new 131	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   158: astore 15
    //   160: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   163: bipush 13
    //   165: aaload
    //   166: astore 16
    //   168: aload 15
    //   170: aload 16
    //   172: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: astore 17
    //   177: aload_1
    //   178: invokevirtual 266	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   181: astore 18
    //   183: aload 17
    //   185: aload 18
    //   187: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: astore 19
    //   195: aload 14
    //   197: aload 19
    //   199: invokevirtual 145	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   202: goto -98 -> 104
    //   205: astore 20
    //   207: aload_0
    //   208: getfield 91	com/skyhookwireless/_sdkvc:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   211: astore 21
    //   213: new 131	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   220: astore 22
    //   222: getstatic 65	com/skyhookwireless/_sdkvc:z	[Ljava/lang/String;
    //   225: bipush 13
    //   227: aaload
    //   228: astore 23
    //   230: aload 22
    //   232: aload 23
    //   234: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 20
    //   239: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore 24
    //   247: aload 21
    //   249: aload 24
    //   251: invokevirtual 145	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   254: goto -150 -> 104
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	137	finally
    //   14	32	137	finally
    //   37	104	137	finally
    //   104	134	137	finally
    //   145	254	137	finally
    //   37	104	144	java/lang/reflect/InvocationTargetException
    //   37	104	205	java/lang/Throwable
  }

  /** @deprecated */
  public _sdkib _sdkd()
  {
    try
    {
      _sdkib local_sdkib1 = this._sdkj;
      if (local_sdkib1 == null);
      _sdkib local_sdkib2;
      for (Object localObject1 = null; ; localObject1 = local_sdkib2)
      {
        return localObject1;
        local_sdkib2 = this._sdkj.clone();
      }
    }
    finally
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkvc
 * JD-Core Version:    0.6.2
 */