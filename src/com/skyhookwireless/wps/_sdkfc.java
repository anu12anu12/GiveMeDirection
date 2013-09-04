package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;
import java.util.ListIterator;

final class _sdkfc
{
  private static final String[] z;
  private final _sdkhb _sdka;
  private final int _sdkb;
  private ScanHistory _sdkc;
  private ScanHistory _sdkd;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[7];
    Object localObject2 = "\036W)X\021\"_eV\031/SeG\026-H6\\\0278".toCharArray();
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
          i2 = 120;
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
      Object localObject5 = "\r\0306Z\031<K-[\flU0G\fl]=]\0138\030#[\nlQ1\024\f#\030'QX>W)X\035(\030'U\033'".toCharArray();
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
            i8 = 120;
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
        Object localObject7 = "\r\0306Z\031<K-[\flU0G\fl]=]\0138\030'Q\036#J \024\037)L\026Z\031<K-[\flQ6\024\033-T)Q\034".toCharArray();
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
              i17 = 120;
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
          Object localObject9 = "\017T U\n%V\"\024\013\"Y5G\020#L".toCharArray();
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
                i25 = 120;
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
            Object localObject11 = "\r\0306Z\031<K-[\flU0G\fl]=]\0138\030#[\nlQ1\024\f#\030'QX/T U\n)\\".toCharArray();
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
                  i33 = 120;
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
              Object localObject13 = "\030Y.]\026+\0306Z\031<K-[\f".toCharArray();
              int i37 = localObject13.length;
              label836: int i42;
              label900: int i39;
              if (i37 <= 1)
              {
                int i38 = 0;
                localObject3 = localObject13;
                k = i38;
                int i40 = i37;
                Object localObject15 = localObject13;
                int i41 = i40;
                while (true)
                {
                  i16 = localObject15[i38];
                  switch (k % 5)
                  {
                  default:
                    i42 = 120;
                    int i43 = (char)(i42 ^ i16);
                    localObject15[i38] = i43;
                    i39 = k + 1;
                    if (i41 != 0)
                      break label941;
                    localObject15 = localObject3;
                    int i44 = i39;
                    i39 = i41;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i37 = i41;
                localObject13 = localObject3;
              }
              while (true)
              {
                if (i37 > i39)
                  break label836;
                String str6 = new String((char[])localObject13).intern();
                arrayOfString[i36] = str6;
                int i45 = 6;
                Object localObject16 = "\030P \024\013\"Y5G\020#LeY\r?LeV\035l[)Q\031>]!\024\027>\0307[\024 ]!\024\032-[.\024\032)^*F\035lY+[\f$]7\024\027\"]e]\013lL$_\035\"".toCharArray();
                Object localObject17 = localObject16.length;
                label998: Object localObject19;
                Object localObject20;
                label1017: int i46;
                if (localObject17 <= 1)
                {
                  localObject14 = localObject16;
                  localObject3 = localObject1;
                  Object localObject18 = localObject17;
                  localObject19 = localObject16;
                  localObject20 = localObject18;
                  i36 = localObject19[localObject1];
                  switch (localObject3 % 5)
                  {
                  default:
                    i46 = 120;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                while (true)
                {
                  int i47 = (char)(i46 ^ i36);
                  localObject19[localObject1] = i47;
                  localObject1 = localObject3 + 1;
                  if (localObject20 == 0)
                  {
                    localObject19 = localObject14;
                    int i48 = localObject1;
                    localObject1 = localObject20;
                    break label1017;
                  }
                  localObject17 = localObject20;
                  localObject16 = localObject14;
                  if (localObject17 > localObject1)
                    break label998;
                  String str7 = new String((char[])localObject16).intern();
                  arrayOfString[i45] = str7;
                  z = arrayOfString;
                  return;
                  i2 = 76;
                  break;
                  i2 = 56;
                  break;
                  i2 = 69;
                  break;
                  i2 = 52;
                  break;
                  i8 = 76;
                  break label244;
                  i8 = 56;
                  break label244;
                  i8 = 69;
                  break label244;
                  i8 = 52;
                  break label244;
                  i17 = 76;
                  break label408;
                  i17 = 56;
                  break label408;
                  i17 = 69;
                  break label408;
                  i17 = 52;
                  break label408;
                  i25 = 76;
                  break label572;
                  i25 = 56;
                  break label572;
                  i25 = 69;
                  break label572;
                  i25 = 52;
                  break label572;
                  i33 = 76;
                  break label736;
                  i33 = 56;
                  break label736;
                  i33 = 69;
                  break label736;
                  i33 = 52;
                  break label736;
                  i42 = 76;
                  break label900;
                  i42 = 56;
                  break label900;
                  i42 = 69;
                  break label900;
                  i42 = 52;
                  break label900;
                  i46 = 76;
                  continue;
                  i46 = 56;
                  continue;
                  i46 = 69;
                  continue;
                  i46 = 52;
                }
                Object localObject14 = null;
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

  public _sdkfc()
  {
    this(500);
  }

  private _sdkfc(int paramInt)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkfc.class);
    this._sdka = local_sdkhb;
    this._sdkb = paramInt;
    int i = this._sdkb;
    ScanHistory localScanHistory = new ScanHistory(i);
    this._sdkc = localScanHistory;
    this._sdkd = null;
  }

  private boolean _sdkg()
  {
    if (this._sdkd != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void _sdka()
  {
    this._sdkc.clear();
    this._sdkd = null;
  }

  public void _sdka(_sdkzb param_sdkzb)
  {
    this._sdkc.add(param_sdkzb);
  }

  public ScanHistory _sdkb()
  {
    return this._sdkc;
  }

  public ScanHistory _sdkc()
  {
    if (!_sdkg())
    {
      String str = z[2];
      throw new IllegalStateException(str);
    }
    return this._sdkd;
  }

  public ScanHistory _sdkd()
  {
    if (_sdkg())
    {
      String str1 = z[6];
      throw new IllegalStateException(str1);
    }
    _sdkhb local_sdkhb = this._sdka;
    String str2 = z[5];
    local_sdkhb._sdkb(str2);
    ScanHistory localScanHistory1 = this._sdkc;
    this._sdkd = localScanHistory1;
    int i = this._sdkb;
    ScanHistory localScanHistory2 = new ScanHistory(i);
    this._sdkc = localScanHistory2;
    return _sdkc();
  }

  public void _sdke()
  {
    if (!_sdkg())
    {
      String str1 = z[4];
      throw new IllegalStateException(str1);
    }
    _sdkhb local_sdkhb = this._sdka;
    String str2 = z[3];
    local_sdkhb._sdkb(str2);
    this._sdkd = null;
  }

  public void _sdkf()
  {
    boolean bool = _sdkkc._sdkr;
    if (!_sdkg())
    {
      String str1 = z[1];
      throw new IllegalStateException(str1);
    }
    _sdkhb local_sdkhb = this._sdka;
    String str2 = z[0];
    local_sdkhb._sdkb(str2);
    ListIterator localListIterator = this._sdkc.reverseIterator();
    do
    {
      if (!localListIterator.hasPrevious())
        break;
      ScanHistory localScanHistory1 = this._sdkd;
      _sdkzb local_sdkzb = (_sdkzb)localListIterator.previous();
      localScanHistory1.add(local_sdkzb);
    }
    while (!bool);
    ScanHistory localScanHistory2 = this._sdkd;
    this._sdkc = localScanHistory2;
    this._sdkd = null;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkfc
 * JD-Core Version:    0.6.2
 */