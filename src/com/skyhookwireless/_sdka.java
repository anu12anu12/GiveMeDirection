package com.skyhookwireless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class _sdka extends BroadcastReceiver
{
  private static final String[] z;
  final _sdkzc _sdka;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[3];
    Object localObject2 = ")H\026v\\yT\016f\\:BAz]yI\016d\016".toCharArray();
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
          i2 = 46;
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
      Object localObject5 = "<_\002v^-N\016}\0160IA|@\013B\002vG/BI:".toCharArray();
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
            i9 = 46;
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
        Object localObject8 = ")K\024tI<C".toCharArray();
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
            i13 = 46;
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
          i2 = 89;
          break;
          i2 = 39;
          break;
          i2 = 97;
          break;
          i2 = 19;
          break;
          i9 = 89;
          break label244;
          i9 = 39;
          break label244;
          i9 = 97;
          break label244;
          i9 = 19;
          break label244;
          i13 = 89;
          continue;
          i13 = 39;
          continue;
          i13 = 97;
          continue;
          i13 = 19;
        }
        Object localObject6 = null;
      }
      j = 0;
    }
  }

  _sdka(_sdkzc param_sdkzc)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = false;
    boolean bool2 = _sdkyc._sdkd;
    try
    {
      String str1 = z[2];
      int i = paramIntent.getIntExtra(str1, -1);
      _sdkzc local_sdkzc1 = this._sdka;
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 0:
      }
      try
      {
        while (true)
        {
          _sdkzc local_sdkzc2 = this._sdka;
          _sdki local_sdki1 = _sdki.UNKNOWN;
          _sdki local_sdki2 = _sdkzc._sdka(local_sdkzc2, local_sdki1);
          do
          {
            do
            {
              if (_sdkzc._sdka(this._sdka)._sdkb())
              {
                _sdkhb local_sdkhb1 = _sdkzc._sdka(this._sdka);
                StringBuilder localStringBuilder1 = new StringBuilder();
                String str2 = z[0];
                StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
                String str3 = _sdkzc._sdkb(this._sdka).name();
                String str4 = str3;
                local_sdkhb1._sdkb(str4);
              }
              _sdkzc._sdkc(this._sdka);
              if (!_sdkhb._sdkd)
                return;
              if (!bool2)
                break;
              _sdkyc._sdkd = bool1;
              return;
              _sdkzc local_sdkzc3 = this._sdka;
              _sdki local_sdki3 = _sdki.EXTERNAL;
              _sdki local_sdki4 = _sdkzc._sdka(local_sdkzc3, local_sdki3);
            }
            while (!bool2);
            _sdkzc local_sdkzc4 = this._sdka;
            _sdki local_sdki5 = _sdki.BATTERY;
            _sdki local_sdki6 = _sdkzc._sdka(local_sdkzc4, local_sdki5);
          }
          while (!bool2);
        }
      }
      finally
      {
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        _sdkhb local_sdkhb2 = _sdkzc._sdka(this._sdka);
        String str5 = z[1];
        local_sdkhb2._sdkb(str5, localThrowable);
        continue;
        bool1 = true;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdka
 * JD-Core Version:    0.6.2
 */