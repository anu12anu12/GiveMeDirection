package com.skyhookwireless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class _sdkzc extends _sdkyc
{
  private static final String[] z;
  private final _sdkhb _sdke;
  private Context _sdkf;
  private BroadcastReceiver _sdkg;
  private _sdki _sdkh;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = "3&\027G*v!\013Z=1=\026\\=$=\013Ox$1\006M1 1\027".toCharArray();
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
          i2 = 88;
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
      Object localObject5 = "78\027M92-EK49'��L".toCharArray();
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
            i8 = 88;
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
        Object localObject7 = "7:\001Z7?0KA6\"1\013\\v77\021A78z'i\f\002\0217q\007\025\034$f\037\023\020".toCharArray();
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
              i18 = 88;
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
          Object localObject10 = "78\027M92-EG(3:".toCharArray();
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
              i22 = 88;
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
            i2 = 86;
            break;
            i2 = 84;
            break;
            i2 = 101;
            break;
            i2 = 40;
            break;
            i8 = 86;
            break label244;
            i8 = 84;
            break label244;
            i8 = 101;
            break label244;
            i8 = 40;
            break label244;
            i18 = 86;
            break label408;
            i18 = 84;
            break label408;
            i18 = 101;
            break label408;
            i18 = 40;
            break label408;
            i22 = 86;
            continue;
            i22 = 84;
            continue;
            i22 = 101;
            continue;
            i22 = 40;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  public _sdkzc(_sdkt param_sdkt)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkzc.class);
    this._sdke = local_sdkhb;
    Context localContext = ((_sdkq)param_sdkt)._sdka();
    this._sdkf = localContext;
    _sdki local_sdki = _sdki.UNKNOWN;
    this._sdkh = local_sdki;
    if (!bool1)
      return;
    if (_sdkhb._sdkd);
    for (boolean bool2 = false; ; bool2 = true)
    {
      _sdkhb._sdkd = bool2;
      return;
    }
  }

  static _sdkhb _sdka(_sdkzc param_sdkzc)
  {
    return param_sdkzc._sdke;
  }

  static _sdki _sdka(_sdkzc param_sdkzc, _sdki param_sdki)
  {
    param_sdkzc._sdkh = param_sdki;
    return param_sdki;
  }

  static _sdki _sdkb(_sdkzc param_sdkzc)
  {
    return param_sdkzc._sdkh;
  }

  static void _sdkc(_sdkzc param_sdkzc)
  {
    param_sdkzc._sdka();
  }

  public _sdkyc _sdka(_sdkt param_sdkt)
  {
    return new _sdkzc(param_sdkt);
  }

  public void _sdkb()
  {
    if (this._sdkg != null)
    {
      _sdkhb local_sdkhb = this._sdke;
      String str1 = z[3];
      local_sdkhb._sdkb(str1);
      return;
    }
    _sdka local_sdka = new _sdka(this);
    this._sdkg = local_sdka;
    _sdki local_sdki = _sdki.UNKNOWN;
    this._sdkh = local_sdki;
    String str2 = z[2];
    IntentFilter localIntentFilter = new IntentFilter(str2);
    Context localContext = this._sdkf;
    BroadcastReceiver localBroadcastReceiver = this._sdkg;
    Intent localIntent = localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
  }

  public void _sdkc()
  {
    if (this._sdkg == null)
    {
      _sdkhb local_sdkhb1 = this._sdke;
      String str1 = z[1];
      local_sdkhb1._sdkb(str1);
      return;
    }
    try
    {
      Context localContext = this._sdkf;
      BroadcastReceiver localBroadcastReceiver = this._sdkg;
      localContext.unregisterReceiver(localBroadcastReceiver);
      _sdki local_sdki1;
      return;
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb2 = this._sdke;
      String str2 = z[0];
      local_sdkhb2._sdkb(str2, localThrowable);
      _sdki local_sdki2;
      return;
    }
    finally
    {
      this._sdkg = null;
      _sdki local_sdki3 = _sdki.UNKNOWN;
      this._sdkh = local_sdki3;
    }
  }

  /** @deprecated */
  public _sdki _sdkd()
  {
    try
    {
      _sdki local_sdki = this._sdkh;
      return local_sdki;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkzc
 * JD-Core Version:    0.6.2
 */