package com.skyhookwireless;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.concurrent.Callable;

class _sdku
  implements Callable<Boolean>
{
  private static final String[] z;
  final _sdksc _sdka;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[3];
    Object localObject2 = "\005f\037W\023\006)~t!;}Zb`-fJ~$".toCharArray();
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
          i2 = 64;
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
      Object localObject5 = ";aP~%k}F`%k4\037".toCharArray();
      int i4 = localObject5.length;
      label180: int i9;
      label244: int i6;
      if (i4 <= 1)
      {
        int i5 = 0;
        localObject3 = localObject5;
        k = i5;
        int i7 = i4;
        Object localObject7 = localObject5;
        int i8 = i7;
        while (true)
        {
          i1 = localObject7[i5];
          switch (k % 5)
          {
          default:
            i9 = 64;
            int i10 = (char)(i9 ^ i1);
            localObject7[i5] = i10;
            i6 = k + 1;
            if (i8 != 0)
              break label285;
            localObject7 = localObject3;
            int i11 = i6;
            i6 = i8;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i4 = i8;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i6)
          break label180;
        String str2 = new String((char[])localObject5).intern();
        arrayOfString[1] = str2;
        int i12 = 2;
        Object localObject8 = ";aP~%".toCharArray();
        Object localObject9 = localObject8.length;
        label340: Object localObject11;
        Object localObject12;
        label359: int i13;
        if (localObject9 <= 1)
        {
          localObject6 = localObject8;
          localObject3 = localObject1;
          Object localObject10 = localObject9;
          localObject11 = localObject8;
          localObject12 = localObject10;
          i1 = localObject11[localObject1];
          switch (localObject3 % 5)
          {
          default:
            i13 = 64;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        while (true)
        {
          int i14 = (char)(i13 ^ i1);
          localObject11[localObject1] = i14;
          localObject1 = localObject3 + 1;
          if (localObject12 == 0)
          {
            localObject11 = localObject6;
            int i15 = localObject1;
            localObject1 = localObject12;
            break label359;
          }
          localObject9 = localObject12;
          localObject8 = localObject6;
          if (localObject9 > localObject1)
            break label340;
          String str3 = new String((char[])localObject8).intern();
          arrayOfString[i12] = str3;
          z = arrayOfString;
          return;
          i2 = 75;
          break;
          i2 = 9;
          break;
          i2 = 63;
          break;
          i2 = 16;
          break;
          i9 = 75;
          break label244;
          i9 = 9;
          break label244;
          i9 = 63;
          break label244;
          i9 = 16;
          break label244;
          i13 = 75;
          continue;
          i13 = 9;
          continue;
          i13 = 63;
          continue;
          i13 = 16;
        }
        Object localObject6 = null;
      }
      j = 0;
    }
  }

  _sdku(_sdksc param_sdksc)
  {
  }

  public Boolean _sdka()
    throws Exception
  {
    int i = _sdkab._sdkf;
    _sdkd local_sdkd = new _sdkd(this);
    synchronized (this._sdka)
    {
      _sdksc local_sdksc2 = this._sdka;
      Context localContext = _sdksc._sdki(this._sdka);
      String str1 = z[2];
      TelephonyManager localTelephonyManager1 = (TelephonyManager)localContext.getSystemService(str1);
      TelephonyManager localTelephonyManager2 = _sdksc._sdka(local_sdksc2, localTelephonyManager1);
      int j = _sdksc._sdkb(this._sdka).getPhoneType();
      _sdkhb local_sdkhb = _sdksc._sdka(this._sdka);
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = z[1];
      String str3 = str2 + j;
      local_sdkhb._sdkb(str3);
      if (j != 1)
      {
        TelephonyManager localTelephonyManager3 = _sdksc._sdka(this._sdka, null);
        String str4 = z[0];
        throw new _sdkyd(str4);
      }
    }
    PhoneStateListener localPhoneStateListener = _sdksc._sdka(this._sdka, local_sdkd);
    Boolean localBoolean = Boolean.valueOf(true);
    if (i != 0)
      if (!_sdkhb._sdkd)
        break label203;
    label203: for (boolean bool = false; ; bool = true)
    {
      _sdkhb._sdkd = bool;
      return localBoolean;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdku
 * JD-Core Version:    0.6.2
 */