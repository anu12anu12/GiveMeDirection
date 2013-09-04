package com.skyhookwireless;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class _sdkbc extends _sdkzb
{
  private static final String[] z;
  private final _sdkhb _sdkd;
  private final TelephonyManager _sdke;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[6];
    Object localObject2 = ",=i0\b$7C#\023$%hx3(?h2\017\"=t\017\006#2j'\025\004>}.".toCharArray();
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
          i2 = 103;
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
      Object localObject5 = "96a'\027%<c;G)6{+\004(sD\006]m".toCharArray();
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
            i8 = 103;
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
        Object localObject7 = "$={#\013$7-&\002;:n'G\004\0277b".toCharArray();
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
              i17 = 103;
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
          Object localObject9 = "+2d.\002)sy-G*6yb\003(%d!\002m\032I".toCharArray();
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
                i25 = 103;
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
            Object localObject11 = ".2ce\023m7h6\002?>d,\002m7h4\016.6-\013#".toCharArray();
            int i29 = localObject11.length;
            label672: int i34;
            label736: int i31;
            if (i29 <= 1)
            {
              int i30 = 0;
              localObject3 = localObject11;
              k = i30;
              int i32 = i29;
              Object localObject13 = localObject11;
              int i33 = i32;
              while (true)
              {
                i16 = localObject13[i30];
                switch (k % 5)
                {
                default:
                  i34 = 103;
                  int i35 = (char)(i34 ^ i16);
                  localObject13[i30] = i35;
                  i31 = k + 1;
                  if (i33 != 0)
                    break label777;
                  localObject13 = localObject3;
                  int i36 = i31;
                  i31 = i33;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i29 = i33;
              localObject11 = localObject3;
            }
            while (true)
            {
              if (i29 > i31)
                break label672;
              String str5 = new String((char[])localObject11).intern();
              arrayOfString[i28] = str5;
              int i37 = 5;
              Object localObject14 = ".<x.\003m=b6G*6yb\023(?h2\017\"=tb\n,=l%\002?s~'\025;:n'".toCharArray();
              Object localObject15 = localObject14.length;
              label833: Object localObject17;
              Object localObject18;
              label852: int i38;
              if (localObject15 <= 1)
              {
                localObject12 = localObject14;
                localObject3 = localObject1;
                Object localObject16 = localObject15;
                localObject17 = localObject14;
                localObject18 = localObject16;
                i28 = localObject17[localObject1];
                switch (localObject3 % 5)
                {
                default:
                  i38 = 103;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              while (true)
              {
                int i39 = (char)(i38 ^ i28);
                localObject17[localObject1] = i39;
                localObject1 = localObject3 + 1;
                if (localObject18 == 0)
                {
                  localObject17 = localObject12;
                  int i40 = localObject1;
                  localObject1 = localObject18;
                  break label852;
                }
                localObject15 = localObject18;
                localObject14 = localObject12;
                if (localObject15 > localObject1)
                  break label833;
                String str6 = new String((char[])localObject14).intern();
                arrayOfString[i37] = str6;
                z = arrayOfString;
                return;
                i2 = 77;
                break;
                i2 = 83;
                break;
                i2 = 13;
                break;
                i2 = 66;
                break;
                i8 = 77;
                break label244;
                i8 = 83;
                break label244;
                i8 = 13;
                break label244;
                i8 = 66;
                break label244;
                i17 = 77;
                break label408;
                i17 = 83;
                break label408;
                i17 = 13;
                break label408;
                i17 = 66;
                break label408;
                i25 = 77;
                break label572;
                i25 = 83;
                break label572;
                i25 = 13;
                break label572;
                i25 = 66;
                break label572;
                i34 = 77;
                break label736;
                i34 = 83;
                break label736;
                i34 = 13;
                break label736;
                i34 = 66;
                break label736;
                i38 = 77;
                continue;
                i38 = 83;
                continue;
                i38 = 13;
                continue;
                i38 = 66;
              }
              Object localObject12 = null;
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

  public _sdkbc(_sdkt param_sdkt)
    throws _sdkm
  {
    Context localContext = ((_sdkq)param_sdkt)._sdka();
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkbc.class);
    this._sdkd = local_sdkhb;
    while (true)
    {
      try
      {
        Future localFuture = _sdkr._sdka(new _sdkcc(this, localContext));
        TimeUnit localTimeUnit = TimeUnit.SECONDS;
        TelephonyManager localTelephonyManager = (TelephonyManager)localFuture.get(2L, localTimeUnit);
        this._sdke = localTelephonyManager;
        if (!bool1)
          return;
        if (_sdkhb._sdkd)
        {
          bool2 = false;
          _sdkhb._sdkd = bool2;
          return;
        }
      }
      catch (Exception localException)
      {
        String str = z[5];
        throw new _sdkm(str, localException);
      }
      boolean bool2 = true;
    }
  }

  protected _sdkzb _sdka(_sdkt param_sdkt)
    throws _sdkm
  {
    return new _sdkbc(param_sdkt);
  }

  public String _sdka()
  {
    return z[0];
  }

  /** @deprecated */
  public String _sdkb()
  {
    Object localObject1 = null;
    while (true)
    {
      try
      {
        String str1 = this._sdke.getDeviceId();
        String str2 = str1;
        if (str2 == null)
        {
          _sdkhb local_sdkhb1 = this._sdkd;
          String str3 = z[4];
          local_sdkhb1._sdke(str3);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        _sdkhb local_sdkhb2 = this._sdkd;
        String str4 = z[3];
        local_sdkhb2._sdkb(str4, localException);
        continue;
      }
      finally
      {
      }
      if (localException.length() < 8)
      {
        _sdkhb local_sdkhb3 = this._sdkd;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str5 = z[2];
        String str6 = str5 + localException;
        local_sdkhb3._sdke(str6);
      }
      else
      {
        if (this._sdkd._sdkb())
        {
          _sdkhb local_sdkhb4 = this._sdkd;
          StringBuilder localStringBuilder2 = new StringBuilder();
          String str7 = z[1];
          String str8 = str7 + localException;
          local_sdkhb4._sdkb(str8);
        }
        localObject1 = localException;
      }
    }
  }

  public String toString()
  {
    return _sdka();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkbc
 * JD-Core Version:    0.6.2
 */