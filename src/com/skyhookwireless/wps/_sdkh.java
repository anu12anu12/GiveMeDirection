package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;

class _sdkh
  implements RegistrationCallback
{
  private static final String[] z;
  final WPSAuthentication _sdka;
  final WPSAuthentication _sdkb;
  final RegistrationCallback _sdkc;
  final _sdkf _sdkd;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = "\002\021\030\034\r\021\001\013\032S\027\026\r\007I\f\nL\026R\021\013\036I��".toCharArray();
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
          i2 = 32;
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
      Object localObject5 = "\002\021\030\034\r\021\001\013\032S\027\026\r\007I\f\nL\027O\r\001".toCharArray();
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
            i8 = 32;
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
        Object localObject7 = "\005\005\005\037E\007D\030\034��\020\005\032\026��\021\001\013\032S\027\001\036\026DC\005\031\007H".toCharArray();
        int i12 = localObject7.length;
        label343: int i18;
        label408: int i14;
        if (i12 <= 1)
        {
          int i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i15 = i12;
          Object localObject9 = localObject7;
          int i16 = i15;
          while (true)
          {
            int i17 = localObject9[i13];
            switch (k % 5)
            {
            default:
              i18 = 32;
              int i19 = (char)(i18 ^ i17);
              localObject9[i13] = i19;
              i14 = k + 1;
              if (i16 != 0)
                break label449;
              localObject9 = localObject3;
              int i20 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i12 = i16;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i14)
            break label343;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i21 = 3;
          Object localObject10 = "\002\021\030\034\r\021\001\013\032S\027\026\r\007I\f\nL��U��\007\t��S\005\021��".toCharArray();
          Object localObject11 = localObject10.length;
          label505: Object localObject13;
          Object localObject14;
          label524: int i22;
          if (localObject11 <= 1)
          {
            localObject8 = localObject10;
            localObject3 = localObject1;
            Object localObject12 = localObject11;
            localObject13 = localObject10;
            localObject14 = localObject12;
            i11 = localObject13[localObject1];
            switch (localObject3 % 5)
            {
            default:
              i22 = 32;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          while (true)
          {
            int i23 = (char)(i22 ^ i11);
            localObject13[localObject1] = i23;
            localObject1 = localObject3 + 1;
            if (localObject14 == 0)
            {
              localObject13 = localObject8;
              int i24 = localObject1;
              localObject1 = localObject14;
              break label524;
            }
            localObject11 = localObject14;
            localObject10 = localObject8;
            if (localObject11 > localObject1)
              break label505;
            String str4 = new String((char[])localObject10).intern();
            arrayOfString[i21] = str4;
            z = arrayOfString;
            return;
            i2 = 99;
            break;
            i2 = 100;
            break;
            i2 = 108;
            break;
            i2 = 115;
            break;
            i8 = 99;
            break label244;
            i8 = 100;
            break label244;
            i8 = 108;
            break label244;
            i8 = 115;
            break label244;
            i18 = 99;
            break label408;
            i18 = 100;
            break label408;
            i18 = 108;
            break label408;
            i18 = 115;
            break label408;
            i22 = 99;
            continue;
            i22 = 100;
            continue;
            i22 = 108;
            continue;
            i22 = 115;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  _sdkh(_sdkf param_sdkf, WPSAuthentication paramWPSAuthentication1, WPSAuthentication paramWPSAuthentication2, RegistrationCallback paramRegistrationCallback)
  {
  }

  public void done()
  {
    _sdkhb local_sdkhb = this._sdkd._sdka;
    String str = z[1];
    local_sdkhb._sdkb(str);
    this._sdkc.done();
  }

  public WPSContinuation handleError(WPSReturnCode paramWPSReturnCode)
  {
    _sdkhb local_sdkhb = this._sdkd._sdka;
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = z[0];
    String str2 = str1 + paramWPSReturnCode;
    local_sdkhb._sdke(str2);
    return this._sdkc.handleError(paramWPSReturnCode);
  }

  public void handleSuccess()
  {
    _sdkhb local_sdkhb1 = this._sdkd._sdka;
    String str1 = z[3];
    local_sdkhb1._sdkb(str1);
    _sdkf local_sdkf = this._sdkd;
    WPSAuthentication localWPSAuthentication1 = this._sdka;
    WPSAuthentication localWPSAuthentication2 = this._sdkb;
    if (!_sdkf._sdka(local_sdkf, localWPSAuthentication1, localWPSAuthentication2))
    {
      _sdkhb local_sdkhb2 = this._sdkd._sdka;
      String str2 = z[2];
      local_sdkhb2._sdke(str2);
    }
    this._sdkc.handleSuccess();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkh
 * JD-Core Version:    0.6.2
 */