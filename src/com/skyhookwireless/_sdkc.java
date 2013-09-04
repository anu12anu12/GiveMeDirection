package com.skyhookwireless;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.cdma.CdmaCellLocation;

class _sdkc extends PhoneStateListener
{
  static final boolean _sdka;
  private static final String[] z;
  final _sdkvc _sdkb;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[4];
    Object localObject1 = "\026\031\017Lx\007\b\003G(\032\017LFf0\004��ED\034\002\r]a\034\017/Ai\035\006\tM".toCharArray();
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
          i3 = 8;
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
      Object localObject4 = "\034\017/Ld\037-\003Ji\007\b\003GK\033��\002Nm\027I".toCharArray();
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
            i9 = 8;
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
        Object localObject6 = "\034\017?Lz\005\b\017L[\007��\030LK\033��\002Nm\027I".toCharArray();
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
              i18 = 8;
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
          Object localObject8 = "\026\031\017Lx\007\b\003G(\032\017LFf \004\036_a\020\004?]i\007\004/Ai\035\006\tM Z".toCharArray();
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
                i26 = 8;
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
            z = arrayOfString;
            if (!_sdkvc.class.desiredAssertionStatus());
            while (true)
            {
              _sdka = i;
              return;
              i = 0;
            }
            i3 = 115;
            break;
            i3 = 97;
            break;
            i3 = 108;
            break;
            i3 = 41;
            break;
            i9 = 115;
            break label244;
            i9 = 97;
            break label244;
            i9 = 108;
            break label244;
            i9 = 41;
            break label244;
            i18 = 115;
            break label408;
            i18 = 97;
            break label408;
            i18 = 108;
            break label408;
            i18 = 41;
            break label408;
            i26 = 115;
            break label572;
            i26 = 97;
            break label572;
            i26 = 108;
            break label572;
            i26 = 41;
            break label572;
            i23 = 0;
          }
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  _sdkc(_sdkvc param_sdkvc)
  {
  }

  public void onCellLocationChanged(CellLocation paramCellLocation)
  {
    try
    {
      if (_sdkvc._sdkb(this._sdkb)._sdkb())
      {
        _sdkhb local_sdkhb1 = _sdkvc._sdkb(this._sdkb);
        StringBuilder localStringBuilder = new StringBuilder();
        String str1 = z[1];
        String str2 = str1 + paramCellLocation + ")";
        local_sdkhb1._sdkb(str2);
      }
      if ((!_sdka) && (paramCellLocation != null) && (!(paramCellLocation instanceof CdmaCellLocation)))
        throw new AssertionError();
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb2 = _sdkvc._sdkb(this._sdkb);
      String str3 = z[0];
      local_sdkhb2._sdke(str3, localThrowable);
      return;
    }
    _sdkvc local_sdkvc = this._sdkb;
    CdmaCellLocation localCdmaCellLocation = (CdmaCellLocation)paramCellLocation;
    _sdkvc._sdka(local_sdkvc, localCdmaCellLocation);
  }

  public void onServiceStateChanged(ServiceState paramServiceState)
  {
    boolean bool1 = _sdkvc._sdkk;
    try
    {
      if (_sdkvc._sdkb(this._sdkb)._sdkb())
      {
        _sdkhb local_sdkhb1 = _sdkvc._sdkb(this._sdkb);
        StringBuilder localStringBuilder = new StringBuilder();
        String str1 = z[2];
        String str2 = str1 + paramServiceState + ")";
        local_sdkhb1._sdkb(str2);
      }
      int i = paramServiceState.getState();
      switch (i)
      {
      case 2:
      default:
      case 1:
      case 3:
      }
      while (true)
      {
        if (!_sdkhb._sdkd)
          return;
        if (!bool1)
          break;
        bool2 = false;
        _sdkvc._sdkk = bool2;
        return;
        _sdkvc._sdka(this._sdkb, null);
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        _sdkhb local_sdkhb2 = _sdkvc._sdkb(this._sdkb);
        String str3 = z[3];
        local_sdkhb2._sdke(str3, localThrowable);
        continue;
        boolean bool2 = true;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkc
 * JD-Core Version:    0.6.2
 */