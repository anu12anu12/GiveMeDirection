package com.skyhookwireless;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class _sdkqb extends _sdkpb
{
  private static final String[] z;
  private final _sdkhb _sdkc;
  private final Context _sdkd;
  private SharedPreferences _sdke;
  private String _sdkf;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[12];
    Object localObject2 = "\017'\0250\037\rf\b3Z\033#\0358Z\0314\031:\037\033#\022?\037Sf".toCharArray();
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
          i2 = 122;
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
      Object localObject5 = "4|\\".toCharArray();
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
            i8 = 122;
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
        Object localObject7 = "\007)\b|\025\031#\022".toCharArray();
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
              i17 = 122;
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
          Object localObject9 = "\033#\0358Z\0314\031:\037\033#\022?\0372".toCharArray();
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
                i25 = 122;
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
            Object localObject11 = "\002#\005|\027\0345\b|\024\0062\\>\037I#\021,\016\020".toCharArray();
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
                  i33 = 122;
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
              Object localObject13 = "\002#\005|\027\0345\b|\024\0062\\>\037I(\t0\026".toCharArray();
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
                    i41 = 122;
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
                Object localObject15 = "\0364\025(\023\007!\\,\b\f \031.\037\007%\031\007".toCharArray();
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
                      i49 = 122;
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
                  Object localObject17 = "\017'\0250\037\rf\b3Z\0364\025(\037I6\0169\034\f4\0312\031\f".toCharArray();
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
                        i57 = 122;
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
                    Object localObject19 = "\033#\0350\027I+\t/\016I(\023(Z\013#\\2\017\005*".toCharArray();
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
                          i65 = 122;
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
                      Object localObject21 = "\033#\0350\027I+\t/\016I(\023(Z\013#\\9\027\0312\005".toCharArray();
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
                            i73 = 122;
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
                        Object localObject23 = "\032-\0054\025\006-".toCharArray();
                        int i77 = localObject23.length;
                        label1673: int i82;
                        label1740: int i79;
                        if (i77 <= 1)
                        {
                          int i78 = 0;
                          localObject3 = localObject23;
                          k = i78;
                          int i80 = i77;
                          Object localObject25 = localObject23;
                          int i81 = i80;
                          while (true)
                          {
                            i16 = localObject25[i78];
                            switch (k % 5)
                            {
                            default:
                              i82 = 122;
                              int i83 = (char)(i82 ^ i16);
                              localObject25[i78] = i83;
                              i79 = k + 1;
                              if (i81 != 0)
                                break label1781;
                              localObject25 = localObject3;
                              int i84 = i79;
                              i79 = i81;
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            }
                          }
                          label1781: i77 = i81;
                          localObject23 = localObject3;
                        }
                        while (true)
                        {
                          if (i77 > i79)
                            break label1673;
                          String str11 = new String((char[])localObject23).intern();
                          arrayOfString[i76] = str11;
                          int i85 = 11;
                          Object localObject26 = "\b(\030.\025��\"2=\016��0\031f*\033#\0329\b\f(\0379\t +\f0".toCharArray();
                          Object localObject27 = localObject26.length;
                          label1838: Object localObject29;
                          Object localObject30;
                          label1857: int i86;
                          if (localObject27 <= 1)
                          {
                            localObject24 = localObject26;
                            localObject3 = localObject1;
                            Object localObject28 = localObject27;
                            localObject29 = localObject26;
                            localObject30 = localObject28;
                            i76 = localObject29[localObject1];
                            switch (localObject3 % 5)
                            {
                            default:
                              i86 = 122;
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            }
                          }
                          while (true)
                          {
                            int i87 = (char)(i86 ^ i76);
                            localObject29[localObject1] = i87;
                            localObject1 = localObject3 + 1;
                            if (localObject30 == 0)
                            {
                              localObject29 = localObject24;
                              int i88 = localObject1;
                              localObject1 = localObject30;
                              break label1857;
                            }
                            localObject27 = localObject30;
                            localObject26 = localObject24;
                            if (localObject27 > localObject1)
                              break label1838;
                            String str12 = new String((char[])localObject26).intern();
                            arrayOfString[i85] = str12;
                            z = arrayOfString;
                            return;
                            i2 = 105;
                            break;
                            i2 = 70;
                            break;
                            i2 = 124;
                            break;
                            i2 = 92;
                            break;
                            i8 = 105;
                            break label244;
                            i8 = 70;
                            break label244;
                            i8 = 124;
                            break label244;
                            i8 = 92;
                            break label244;
                            i17 = 105;
                            break label408;
                            i17 = 70;
                            break label408;
                            i17 = 124;
                            break label408;
                            i17 = 92;
                            break label408;
                            i25 = 105;
                            break label572;
                            i25 = 70;
                            break label572;
                            i25 = 124;
                            break label572;
                            i25 = 92;
                            break label572;
                            i33 = 105;
                            break label736;
                            i33 = 70;
                            break label736;
                            i33 = 124;
                            break label736;
                            i33 = 92;
                            break label736;
                            i41 = 105;
                            break label900;
                            i41 = 70;
                            break label900;
                            i41 = 124;
                            break label900;
                            i41 = 92;
                            break label900;
                            i49 = 105;
                            break label1068;
                            i49 = 70;
                            break label1068;
                            i49 = 124;
                            break label1068;
                            i49 = 92;
                            break label1068;
                            i57 = 105;
                            break label1236;
                            i57 = 70;
                            break label1236;
                            i57 = 124;
                            break label1236;
                            i57 = 92;
                            break label1236;
                            i65 = 105;
                            break label1404;
                            i65 = 70;
                            break label1404;
                            i65 = 124;
                            break label1404;
                            i65 = 92;
                            break label1404;
                            i73 = 105;
                            break label1572;
                            i73 = 70;
                            break label1572;
                            i73 = 124;
                            break label1572;
                            i73 = 92;
                            break label1572;
                            i82 = 105;
                            break label1740;
                            i82 = 70;
                            break label1740;
                            i82 = 124;
                            break label1740;
                            i82 = 92;
                            break label1740;
                            i86 = 105;
                            continue;
                            i86 = 70;
                            continue;
                            i86 = 124;
                            continue;
                            i86 = 92;
                          }
                          Object localObject24 = null;
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

  public _sdkqb(_sdkt param_sdkt)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkqb.class);
    this._sdkc = local_sdkhb;
    Context localContext = ((_sdkq)param_sdkt)._sdka();
    this._sdkd = localContext;
    if (!_sdkhb._sdkd)
      return;
    if (bool);
    for (bool = false; ; bool = true)
    {
      _sdkpb._sdkb = bool;
      return;
    }
  }

  protected _sdkpb _sdka(_sdkt param_sdkt)
  {
    return new _sdkqb(param_sdkt);
  }

  public String _sdka()
  {
    return z[11];
  }

  public boolean _sdka(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = _sdkpb._sdkb;
    if (paramString == null)
    {
      String str1 = z[8];
      throw new NullPointerException(str1);
    }
    if (paramString.length() == 0)
    {
      String str2 = z[9];
      throw new IllegalArgumentException(str2);
    }
    Context localContext = this._sdkd;
    String str3 = z[10];
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences(str3, 0);
    this._sdke = localSharedPreferences;
    this._sdkf = paramString;
    if (bool2)
      if (!_sdkhb._sdkd)
        break label104;
    while (true)
    {
      _sdkhb._sdkd = bool1;
      return true;
      label104: bool1 = true;
    }
  }

  public boolean _sdka(String paramString1, String paramString2)
  {
    boolean bool;
    if (this._sdke == null)
    {
      _sdkhb local_sdkhb1 = this._sdkc;
      String str1 = z[2];
      local_sdkhb1._sdke(str1);
      bool = false;
    }
    while (true)
    {
      return bool;
      if (paramString1 == null)
      {
        String str2 = z[5];
        throw new NullPointerException(str2);
      }
      if (paramString1.length() == 0)
      {
        String str3 = z[4];
        throw new IllegalArgumentException(str3);
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str4 = this._sdkf;
      String str5 = str4 + ":" + paramString1;
      SharedPreferences.Editor localEditor1 = this._sdke.edit();
      if (this._sdkc._sdkb())
      {
        _sdkhb local_sdkhb2 = this._sdkc;
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str6 = z[6];
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str6).append(str5);
        String str7 = z[1];
        String str8 = str7 + paramString2;
        local_sdkhb2._sdkb(str8);
      }
      SharedPreferences.Editor localEditor2 = localEditor1.putString(str5, paramString2);
      bool = localEditor1.commit();
      if (!bool)
      {
        _sdkhb local_sdkhb3 = this._sdkc;
        String str9 = z[7];
        local_sdkhb3._sdke(str9);
      }
    }
  }

  public String _sdkb(String paramString)
  {
    String str1 = null;
    if (this._sdke == null)
    {
      _sdkhb local_sdkhb1 = this._sdkc;
      String str2 = z[2];
      local_sdkhb1._sdke(str2);
    }
    while (true)
    {
      return str1;
      if (paramString == null)
      {
        String str3 = z[5];
        throw new NullPointerException(str3);
      }
      if (paramString.length() == 0)
      {
        String str4 = z[4];
        throw new IllegalArgumentException(str4);
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str5 = this._sdkf;
      String str6 = str5 + ":" + paramString;
      try
      {
        str1 = this._sdke.getString(str6, null);
        if (this._sdkc._sdkb())
        {
          _sdkhb local_sdkhb2 = this._sdkc;
          StringBuilder localStringBuilder2 = new StringBuilder();
          String str7 = z[3];
          StringBuilder localStringBuilder3 = localStringBuilder2.append(str7).append(str6);
          String str8 = z[1];
          String str9 = str8 + str1;
          local_sdkhb2._sdkb(str9);
        }
      }
      catch (ClassCastException localClassCastException)
      {
        _sdkhb local_sdkhb3 = this._sdkc;
        StringBuilder localStringBuilder4 = new StringBuilder();
        String str10 = z[0];
        String str11 = str10 + str6;
        local_sdkhb3._sdke(str11);
      }
    }
  }

  public void _sdkb()
  {
    this._sdke = null;
    this._sdkf = null;
  }

  public String toString()
  {
    return _sdka();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkqb
 * JD-Core Version:    0.6.2
 */