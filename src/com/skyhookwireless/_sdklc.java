package com.skyhookwireless;

import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import java.lang.reflect.Method;

class _sdklc
{
  private static final String[] z;
  private WifiManager.WifiLock _sdka;
  final _sdkfd _sdkb;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[11];
    Object localObject2 = "\003!\032^\016i~VK\025+x\017\032\f!i\035\032\023:k\002O\023".toCharArray();
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
          i2 = 58;
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
      Object localObject5 = "\001-{\003S\022+nVM\t(cVV\017-a".toCharArray();
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
            i8 = 58;
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
        Object localObject7 = "\003!\032^\016i~V[\003?\037H\005nf\031Y\013".toCharArray();
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
              i17 = 58;
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
          Object localObject9 = "\003!\032^\016i~VS\0168e\035_@9c\020S@\"e\025Q@9c\002R@\031C0s?\003E2?\035I7t?\001D:c".toCharArray();
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
                i25 = 58;
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
            Object localObject11 = "\003!\032^\016i~VY\022+k\002_@/*\001S\006'*\032U\003%".toCharArray();
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
                  i33 = 58;
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
              Object localObject13 = "3%s\036U\017%*.j3n]\037\\\tnF\031Y\013".toCharArray();
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
                    i41 = 58;
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
                Object localObject15 = "\003<o\027N\005**!s&\007U;u$\013U%y!��U9t,\027*\001S\006'*\032U\003%".toCharArray();
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
                      i49 = 58;
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
                  Object localObject17 = "\003<o\027N\005**\001S\006'*\032U\003%".toCharArray();
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
                        i57 = 58;
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
                    Object localObject19 = "\003<o\027N\005\031c\020S,!i\035".toCharArray();
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
                          i65 = 58;
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
                      Object localObject21 = "\022+f\023[\023+nVM\t(cVV\017-a".toCharArray();
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
                            i74 = 58;
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
                        Object localObject24 = "\003!\032^\016i~VH\005\"o\027I\005nf\031Y\013".toCharArray();
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
                            i78 = 58;
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
                          i2 = 96;
                          break;
                          i2 = 78;
                          break;
                          i2 = 10;
                          break;
                          i2 = 118;
                          break;
                          i8 = 96;
                          break label244;
                          i8 = 78;
                          break label244;
                          i8 = 10;
                          break label244;
                          i8 = 118;
                          break label244;
                          i17 = 96;
                          break label408;
                          i17 = 78;
                          break label408;
                          i17 = 10;
                          break label408;
                          i17 = 118;
                          break label408;
                          i25 = 96;
                          break label572;
                          i25 = 78;
                          break label572;
                          i25 = 10;
                          break label572;
                          i25 = 118;
                          break label572;
                          i33 = 96;
                          break label736;
                          i33 = 78;
                          break label736;
                          i33 = 10;
                          break label736;
                          i33 = 118;
                          break label736;
                          i41 = 96;
                          break label900;
                          i41 = 78;
                          break label900;
                          i41 = 10;
                          break label900;
                          i41 = 118;
                          break label900;
                          i49 = 96;
                          break label1068;
                          i49 = 78;
                          break label1068;
                          i49 = 10;
                          break label1068;
                          i49 = 118;
                          break label1068;
                          i57 = 96;
                          break label1236;
                          i57 = 78;
                          break label1236;
                          i57 = 10;
                          break label1236;
                          i57 = 118;
                          break label1236;
                          i65 = 96;
                          break label1404;
                          i65 = 78;
                          break label1404;
                          i65 = 10;
                          break label1404;
                          i65 = 118;
                          break label1404;
                          i74 = 96;
                          break label1572;
                          i74 = 78;
                          break label1572;
                          i74 = 10;
                          break label1572;
                          i74 = 118;
                          break label1572;
                          i78 = 96;
                          continue;
                          i78 = 78;
                          continue;
                          i78 = 10;
                          continue;
                          i78 = 118;
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

  _sdklc(_sdkfd param_sdkfd, WifiManager paramWifiManager)
  {
    try
    {
      String str1 = z[8];
      Class[] arrayOfClass = new Class[2];
      Class localClass = Integer.TYPE;
      arrayOfClass[0] = localClass;
      arrayOfClass[1] = String.class;
      Method localMethod = WifiManager.class.getMethod(str1, arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      Integer localInteger = Integer.valueOf(2);
      arrayOfObject[0] = localInteger;
      String str2 = z[5];
      arrayOfObject[1] = str2;
      WifiManager.WifiLock localWifiLock1 = (WifiManager.WifiLock)localMethod.invoke(paramWifiManager, arrayOfObject);
      this._sdka = localWifiLock1;
      _sdkhb local_sdkhb1 = _sdkfd._sdka(param_sdkfd);
      String str3 = z[6];
      local_sdkhb1._sdkb(str3);
      this._sdka.setReferenceCounted(false);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
      {
        _sdkhb local_sdkhb2 = _sdkfd._sdka(param_sdkfd);
        String str4 = z[3];
        local_sdkhb2._sdkb(str4);
        String str5 = z[5];
        WifiManager.WifiLock localWifiLock2 = paramWifiManager.createWifiLock(str5);
        this._sdka = localWifiLock2;
        _sdkhb local_sdkhb3 = _sdkfd._sdka(param_sdkfd);
        String str6 = z[7];
        local_sdkhb3._sdkb(str6);
      }
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb4 = _sdkfd._sdka(param_sdkfd);
      String str7 = z[4];
      local_sdkhb4._sdkb(str7, localThrowable);
      this._sdka = null;
    }
  }

  public void _sdka()
  {
    if (this._sdka == null)
      return;
    try
    {
      this._sdka.acquire();
      _sdkhb local_sdkhb1 = _sdkfd._sdka(this._sdkb);
      String str1 = z[1];
      local_sdkhb1._sdkb(str1);
      return;
    }
    catch (Exception localException)
    {
      _sdkhb local_sdkhb2 = _sdkfd._sdka(this._sdkb);
      String str2 = z[2];
      local_sdkhb2._sdkd(str2, localException);
    }
  }

  public void _sdkb()
  {
    if (!_sdkc())
      return;
    try
    {
      this._sdka.release();
      _sdkhb local_sdkhb1 = _sdkfd._sdka(this._sdkb);
      String str1 = z[9];
      local_sdkhb1._sdkb(str1);
      return;
    }
    catch (Exception localException)
    {
      _sdkhb local_sdkhb2 = _sdkfd._sdka(this._sdkb);
      String str2 = z[10];
      local_sdkhb2._sdkb(str2, localException);
    }
  }

  public boolean _sdkc()
  {
    boolean bool1 = false;
    if (this._sdka != null);
    try
    {
      boolean bool2 = this._sdka.isHeld();
      bool1 = bool2;
      return bool1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        _sdkhb local_sdkhb = _sdkfd._sdka(this._sdkb);
        String str = z[0];
        local_sdkhb._sdkd(str, localException);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdklc
 * JD-Core Version:    0.6.2
 */