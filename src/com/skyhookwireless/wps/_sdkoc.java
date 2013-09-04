package com.skyhookwireless.wps;

import com.skyhookwireless._sdkrb;
import com.skyhookwireless._sdktb;
import java.io.IOException;
import java.io.InputStream;

final class _sdkoc
  implements _sdke
{
  private static final String[] z;
  private final _sdkic _sdka;
  private final _sdkqc _sdkb;
  private final _sdktb _sdkc;
  private final int _sdkd;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    int j = "T+$\003\022P-".toCharArray();
    int k = j.length;
    int i1;
    int i8;
    int n;
    if (k <= 1)
    {
      int m = 0;
      i1 = j;
      int i2 = m;
      int i4 = k;
      int i5 = j;
      int i6 = i4;
      while (true)
      {
        int i7 = i5[m];
        switch (i2 % 5)
        {
        default:
          i8 = 102;
          int i9 = (char)(i8 ^ i7);
          i5[m] = i9;
          n = i2 + 1;
          if (i6 != 0)
            break label129;
          i5 = i1;
          int i3 = n;
          n = i6;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: k = i6;
      j = i1;
    }
    while (k <= n)
    {
      String str1 = new String(j).intern();
      arrayOfString[0] = str1;
      Object localObject2 = "P1(\024\026A $\037FZ*(\004\024G,/KF".toCharArray();
      int i10 = localObject2.length;
      label177: Object localObject3;
      int i12;
      label196: int i13;
      int i14;
      if (i10 <= 1)
      {
        localObject1 = localObject2;
        i1 = i;
        int i11 = i10;
        localObject3 = localObject2;
        i12 = i11;
        i13 = localObject3[i];
        switch (i1 % 5)
        {
        default:
          i14 = 102;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      while (true)
      {
        int i15 = (char)(i14 ^ i13);
        localObject3[i] = i15;
        i = i1 + 1;
        if (i12 == 0)
        {
          localObject3 = localObject1;
          int i16 = i;
          i = i12;
          break label196;
        }
        i10 = i12;
        localObject2 = localObject1;
        if (i10 > i)
          break label177;
        String str2 = new String((char[])localObject2).intern();
        arrayOfString[1] = str2;
        z = arrayOfString;
        return;
        i8 = 53;
        break;
        i8 = 73;
        break;
        i8 = 75;
        break;
        i8 = 113;
        break;
        i14 = 53;
        continue;
        i14 = 73;
        continue;
        i14 = 75;
        continue;
        i14 = 113;
      }
      Object localObject1 = null;
    }
  }

  _sdkoc(_sdkic param_sdkic, _sdkqc param_sdkqc, int paramInt)
  {
    this._sdka = param_sdkic;
    this._sdkb = param_sdkqc;
    _sdktb local_sdktb = _sdktb._sdkc();
    this._sdkc = local_sdktb;
    this._sdkd = paramInt;
  }

  public void abort()
  {
    this._sdkc._sdka();
  }

  public void run()
  {
    _sdkrb local_sdkrb = null;
    try
    {
      if (this._sdka._sdkc())
      {
        _sdktb local_sdktb1 = this._sdkc;
        String str1 = this._sdka._sdkd();
        String str2 = this._sdka._sdke();
        local_sdkrb = local_sdktb1._sdkb(str1, str2);
      }
      while (true)
      {
        if (Thread.interrupted())
        {
          _sdkqc local_sdkqc1 = this._sdkb;
          String str3 = z[0];
          local_sdkqc1._sdkb(-1, str3);
          if (local_sdkrb == null)
            return;
        }
        try
        {
          local_sdkrb._sdkf();
          return;
          _sdktb local_sdktb2 = this._sdkc;
          String str4 = this._sdka._sdke();
          local_sdkrb = local_sdktb2._sdka(str4);
          continue;
          if (local_sdkrb._sdka() != 200)
          {
            _sdkqc local_sdkqc2 = this._sdkb;
            int i = local_sdkrb._sdka();
            local_sdkqc2._sdkb(i, "");
            if (local_sdkrb == null)
              return;
            local_sdkrb._sdkf();
            return;
          }
        }
        catch (IOException localIOException1)
        {
          return;
        }
      }
      _sdkqc local_sdkqc3 = this._sdkb;
      _sdkic local_sdkic = this._sdka;
      InputStream localInputStream = local_sdkrb._sdke();
      int j = this._sdkd;
      local_sdkqc3._sdka(local_sdkic, localInputStream, j);
      if (local_sdkrb == null)
        return;
      local_sdkrb._sdkf();
      return;
    }
    catch (Exception localException)
    {
      _sdkqc local_sdkqc4 = this._sdkb;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str5 = z[1];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str5);
      String str6 = localException.toString();
      String str7 = str6;
      local_sdkqc4._sdkb(-1, str7);
      if (local_sdkrb == null)
        return;
      local_sdkrb._sdkf();
      return;
    }
    finally
    {
      if (local_sdkrb == null);
    }
    try
    {
      local_sdkrb._sdkf();
      label284: throw localObject;
    }
    catch (IOException localIOException2)
    {
      break label284;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkoc
 * JD-Core Version:    0.6.2
 */