package com.skyhookwireless.wps;

import com.skyhookwireless._sdkgd;
import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdknd;
import com.skyhookwireless._sdkpd;
import com.skyhookwireless._sdkt;
import java.util.List;

final class _sdkk extends _sdki
{
  private static final String[] z;
  private final _sdkhb _sdkb;
  private final WPSAuthentication _sdkc;
  private final _sdkt _sdkd;
  private final WPSAuthentication _sdke;
  private final RegistrationCallback _sdkf;
  private final _sdkgd _sdkg;
  private boolean _sdkh;
  final _sdkf _sdki;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[14];
    Object localObject2 = "]\rZ0UY\013\0255IU\003PbRP\nP2HR\b".toCharArray();
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
          i2 = 33;
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
      Object localObject5 = "Q\034".toCharArray();
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
            i8 = 33;
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
        Object localObject7 = "O\033Z2\001N\nA7SR\nQbGN��XbB]\003Y @_\004".toCharArray();
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
              i17 = 33;
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
          Object localObject9 = "U\001C-JU\001RbSY\b\\1UN\016A+NRO]#OX\003P\007SN��Gx\001".toCharArray();
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
                i25 = 33;
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
            Object localObject11 = "H\035L+O[OA-\001N\nR+RH\nGl\017\022".toCharArray();
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
                  i33 = 33;
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
              Object localObject13 = "O\033Z2QU\001RbCY\fT7RYOZ$\001I\001T7UT��G+[Y\013\025'SN��G".toCharArray();
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
                    i41 = 33;
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
                Object localObject15 = "U\001C-JU\001RbSY\b\\1UN\016A+NRO]#OX\003P\021T_\fP1R".toCharArray();
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
                      i49 = 33;
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
                  Object localObject17 = "K\006Y.\001N\nA0X\034\035P%HO\033G#UU��[bHRO".toCharArray();
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
                        i57 = 33;
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
                    Object localObject19 = "]\rZ0UY\013\025&TN\006[%\001N\nD7DO\033".toCharArray();
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
                          i65 = 33;
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
                      Object localObject21 = "U\001C-JU\001RbSY\b\\1UN\016A+NROQ-OY".toCharArray();
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
                            i73 = 33;
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
                        Object localObject23 = "n\nR+RH\035T6HS\001g7OR\016W.D\034\tT+MY\013\0255HH\007\025'Y_\nE6HS\001".toCharArray();
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
                              i81 = 33;
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
                          Object localObject25 = "_��@.E\034\001Z6\001Y\027A0@_\033\025\017`OE0DZ\006M".toCharArray();
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
                                i89 = 33;
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
                            Object localObject27 = "O\032V!DO\034S7MP\026\0250D[\006F6DN\nQ".toCharArray();
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
                                  i98 = 33;
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
                              Object localObject30 = "O\003P'Q\034\033\\/D\034\035P#BT\nQbVU\033]-THOT,\001Y\031P,U".toCharArray();
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
                                  i102 = 33;
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
                                i2 = 60;
                                break;
                                i2 = 111;
                                break;
                                i2 = 53;
                                break;
                                i2 = 66;
                                break;
                                i8 = 60;
                                break label244;
                                i8 = 111;
                                break label244;
                                i8 = 53;
                                break label244;
                                i8 = 66;
                                break label244;
                                i17 = 60;
                                break label408;
                                i17 = 111;
                                break label408;
                                i17 = 53;
                                break label408;
                                i17 = 66;
                                break label408;
                                i25 = 60;
                                break label572;
                                i25 = 111;
                                break label572;
                                i25 = 53;
                                break label572;
                                i25 = 66;
                                break label572;
                                i33 = 60;
                                break label736;
                                i33 = 111;
                                break label736;
                                i33 = 53;
                                break label736;
                                i33 = 66;
                                break label736;
                                i41 = 60;
                                break label900;
                                i41 = 111;
                                break label900;
                                i41 = 53;
                                break label900;
                                i41 = 66;
                                break label900;
                                i49 = 60;
                                break label1068;
                                i49 = 111;
                                break label1068;
                                i49 = 53;
                                break label1068;
                                i49 = 66;
                                break label1068;
                                i57 = 60;
                                break label1236;
                                i57 = 111;
                                break label1236;
                                i57 = 53;
                                break label1236;
                                i57 = 66;
                                break label1236;
                                i65 = 60;
                                break label1404;
                                i65 = 111;
                                break label1404;
                                i65 = 53;
                                break label1404;
                                i65 = 66;
                                break label1404;
                                i73 = 60;
                                break label1572;
                                i73 = 111;
                                break label1572;
                                i73 = 53;
                                break label1572;
                                i73 = 66;
                                break label1572;
                                i81 = 60;
                                break label1740;
                                i81 = 111;
                                break label1740;
                                i81 = 53;
                                break label1740;
                                i81 = 66;
                                break label1740;
                                i89 = 60;
                                break label1908;
                                i89 = 111;
                                break label1908;
                                i89 = 53;
                                break label1908;
                                i89 = 66;
                                break label1908;
                                i98 = 60;
                                break label2076;
                                i98 = 111;
                                break label2076;
                                i98 = 53;
                                break label2076;
                                i98 = 66;
                                break label2076;
                                i102 = 60;
                                continue;
                                i102 = 111;
                                continue;
                                i102 = 53;
                                continue;
                                i102 = 66;
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

  private _sdkk(_sdkf param_sdkf, WPSAuthentication paramWPSAuthentication1, WPSAuthentication paramWPSAuthentication2, _sdkt param_sdkt, RegistrationCallback paramRegistrationCallback)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkk.class);
    this._sdkb = local_sdkhb;
    this._sdkc = paramWPSAuthentication1;
    this._sdkd = param_sdkt;
    this._sdke = paramWPSAuthentication2;
    this._sdkf = paramRegistrationCallback;
    _sdkgd local_sdkgd = new _sdkgd();
    this._sdkg = local_sdkgd;
  }

  _sdkk(_sdkf param_sdkf, WPSAuthentication paramWPSAuthentication1, WPSAuthentication paramWPSAuthentication2, _sdkt param_sdkt, RegistrationCallback paramRegistrationCallback, _sdkh param_sdkh)
  {
    this(param_sdkf, paramWPSAuthentication1, paramWPSAuthentication2, param_sdkt, paramRegistrationCallback);
  }

  /** @deprecated */
  private boolean _sdka()
  {
    try
    {
      boolean bool = this._sdkh;
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
    Object localObject1 = null;
    try
    {
      this._sdkh = true;
      this._sdkg._sdka();
      super.abort();
      return;
    }
    finally
    {
    }
  }

  public void run()
  {
    int i = Location._sdki;
    try
    {
      localObject = _sdkf._sdke(this._sdkd);
      String str1 = null;
      if ((localObject != null) && (((String)localObject).length() >= 8))
      {
        str1 = ((String)localObject).substring(0, 8);
        _sdkpd[] arrayOf_sdkpd = new _sdkpd[1];
        _sdkgd local_sdkgd = this._sdkg;
        arrayOf_sdkpd[0] = local_sdkgd;
        localObject = new _sdknd(arrayOf_sdkpd);
        _sdkhb local_sdkhb1 = this._sdkb;
        String str2 = z[4];
        local_sdkhb1._sdkb(str2);
        _sdkxb local_sdkxb = this._sdka;
        WPSAuthentication localWPSAuthentication1 = this._sdkc;
        WPSAuthentication localWPSAuthentication2 = this._sdke;
        l1 = local_sdkxb._sdka(localWPSAuthentication1, localWPSAuthentication2, str1);
        WPSReturnCode localWPSReturnCode1 = WPSReturnCode.WPS_OK;
        if (l1 == localWPSReturnCode1)
        {
          _sdkhb local_sdkhb2 = this._sdkb;
          String str3 = z[12];
          local_sdkhb2._sdkb(str3);
          _sdkhb local_sdkhb3 = this._sdkb;
          String str4 = z[6];
          local_sdkhb3._sdkb(str4);
          _sdkf._sdka(this._sdki);
          _sdkf._sdkb(this._sdkf);
          if (i == 0);
        }
        else if (_sdka())
        {
          _sdkhb local_sdkhb4 = this._sdkb;
          String str5 = z[8];
          local_sdkhb4._sdkb(str5);
          if (i == 0);
        }
        else
        {
          _sdkhb local_sdkhb5 = this._sdkb;
          StringBuilder localStringBuilder1 = new StringBuilder();
          String str6 = z[3];
          String str7 = str6 + l1;
          local_sdkhb5._sdkb(str7);
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        do
        {
          Object localObject;
          WPSContinuation localWPSContinuation1 = this._sdkf.handleError(l1);
          WPSContinuation localWPSContinuation2 = WPSContinuation.WPS_STOP;
          if (localWPSContinuation1 == localWPSContinuation2)
          {
            _sdkhb local_sdkhb6 = this._sdkb;
            String str8 = z[2];
            local_sdkhb6._sdkb(str8);
            if (i == 0)
              break;
          }
          WPSReturnCode localWPSReturnCode2 = WPSReturnCode.WPS_ERROR_UNAUTHORIZED;
          if (l1 == localWPSReturnCode2)
          {
            _sdkhb local_sdkhb7 = this._sdkb;
            String str9 = z[5];
            local_sdkhb7._sdkb(str9);
            if (i == 0)
              break;
          }
          long l2 = ()(Math.random() * 10.0D * 1000.0D);
          long l1 = 10000L + l2;
          if (this._sdkb._sdkb())
          {
            _sdkhb local_sdkhb8 = this._sdkb;
            StringBuilder localStringBuilder2 = new StringBuilder();
            String str10 = z[7];
            StringBuilder localStringBuilder3 = localStringBuilder2.append(str10).append(l1);
            String str11 = z[1];
            String str12 = str11;
            local_sdkhb8._sdkb(str12);
          }
          if (((_sdknd)localObject)._sdka(l1).isEmpty())
          {
            _sdkhb local_sdkhb9 = this._sdkb;
            String str13 = z[13];
            local_sdkhb9._sdkb(str13);
          }
          if (_sdka())
          {
            _sdkhb local_sdkhb10 = this._sdkb;
            String str14 = z[0];
            local_sdkhb10._sdkb(str14);
            if (i == 0)
              break;
          }
        }
        while (i == 0);
        while (true)
        {
          _sdkhb local_sdkhb11 = this._sdkb;
          String str15 = z[9];
          local_sdkhb11._sdkb(str15);
          _sdkf._sdka(this._sdkf);
          return;
          _sdkhb local_sdkhb12 = this._sdkb;
          String str16 = z[11];
          local_sdkhb12._sdke(str16);
          break;
          localThrowable1 = localThrowable1;
          _sdkhb local_sdkhb13 = this._sdkb;
          String str17 = z[10];
          local_sdkhb13._sdke(str17, localThrowable1);
          RegistrationCallback localRegistrationCallback = this._sdkf;
          WPSReturnCode localWPSReturnCode3 = WPSReturnCode.WPS_ERROR;
          _sdkf._sdkc(localRegistrationCallback, localWPSReturnCode3);
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          if (i == 0);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkk
 * JD-Core Version:    0.6.2
 */