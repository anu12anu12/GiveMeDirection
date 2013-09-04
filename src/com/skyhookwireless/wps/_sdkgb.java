package com.skyhookwireless.wps;

import com.skyhookwireless._sdkic;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

class _sdkgb
{
  private static final double _sdka;
  private static final String z;
  private final _sdka _sdkb;
  private final String _sdkc;
  private final byte[] _sdkd;
  private final int _sdke;
  private final int _sdkf;
  private final int _sdkg;
  private final int _sdkh;
  private final long _sdki;
  private final long _sdkj;
  private final int _sdkk;
  private final int _sdkl;
  private final int _sdkm;
  private final int _sdkn;
  private final int _sdko;
  private final double _sdkp;
  private final double _sdkq;

  static
  {
    Object localObject1 = "b\033'\017".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    Object localObject3;
    int n;
    label31: int i1;
    int i2;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      int m = i;
      localObject3 = localObject1;
      n = m;
      i1 = localObject3[j];
      switch (k % 5)
      {
      default:
        i2 = 55;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i3 = (char)(i2 ^ i1);
      localObject3[j] = i3;
      j = k + 1;
      if (n == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = n;
        break label31;
      }
      i = n;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      _sdka = Math.log(2.0D);
      return;
      i2 = 55;
      continue;
      i2 = 43;
      continue;
      i2 = 93;
      continue;
      i2 = 10;
    }
  }

  _sdkgb(_sdkb param_sdkb, String paramString, int paramInt)
    throws IOException
  {
    this._sdkc = paramString;
    this._sdke = paramInt;
    _sdka local_sdka1 = new _sdka(param_sdkb);
    this._sdkb = local_sdka1;
    int j = this._sdkb._sdkb(3);
    if (j == 0)
      throw new _sdkc();
    int k = j + 11;
    double d1 = -k;
    double d2 = Math.pow(2.0D, d1);
    this._sdkp = d2;
    _sdka local_sdka2 = this._sdkb;
    int m = _sdka(180.0D, k);
    long l1 = local_sdka2._sdka(m);
    this._sdki = l1;
    _sdka local_sdka3 = this._sdkb;
    int n = _sdka(360.0D, k);
    long l2 = local_sdka3._sdka(n);
    this._sdkj = l2;
    int i1 = this._sdkb._sdkb(5);
    this._sdkk = i1;
    int i2 = this._sdkb._sdkb(5);
    this._sdkl = i2;
    int i3 = this._sdkb._sdkb(3);
    this._sdkm = i3;
    int i4 = this._sdkb._sdkb(3);
    this._sdkn = i4;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = Long.toString(this._sdki);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = Long.toString(this._sdkj);
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
    String str3 = this._sdkc;
    String str4 = str3;
    String str5 = z;
    byte[] arrayOfByte = str4.getBytes(str5);
    this._sdkd = arrayOfByte;
    int i5 = this._sdkk;
    int i6 = this._sdkl;
    int i7 = i5 + i6;
    int i8 = this._sdkm;
    int i9 = i7 + i8;
    int i10 = this._sdkn;
    int i11 = i9 + i10;
    this._sdko = i11;
    if ((this._sdkp == 0.0D) || (this._sdki == 0L) || (this._sdkj == 0L) || (this._sdkk == 0) || (this._sdkl == 0) || (this._sdkm == 0) || (this._sdkk == 0))
      throw new _sdkc();
    double d3 = this._sdkn;
    double d4 = Math.pow(2.0D, d3) - 1.0D;
    double d5 = 3.0D * d4;
    this._sdkq = d5;
    this._sdkb._sdkd();
    long l3 = this._sdkb._sdke();
    int i12 = (int)this._sdkb._sdke();
    this._sdkh = i12;
    int i13 = this._sdkh * 8 + -2;
    this._sdkg = i13;
    int i14 = param_sdkb._sdka();
    int i15 = this._sdkb.available() >>> 3;
    int i16 = i14 - i15;
    this._sdkf = i16;
    if (!com.skyhookwireless._sdkhb._sdkd)
      return;
    _sdkc._sdkb = i + 1;
  }

  private static int _sdka(double paramDouble, int paramInt)
  {
    int i = 0;
    if (paramDouble == 0.0D);
    while (true)
    {
      return i;
      double d1 = Math.log(paramDouble);
      double d2 = _sdka;
      double d3 = d1 / d2;
      double d4 = paramInt;
      double d5 = d3 + d4;
      if (d5 > 0.0D)
        i = (int)Math.ceil(d5);
    }
  }

  private long _sdkb(_sdkic param_sdkic)
  {
    long l1;
    if ((this._sdkc == null) || (this._sdkc.length() == 0))
      l1 = param_sdkic._sdka();
    while (true)
    {
      return l1;
      try
      {
        String str1 = param_sdkic.toString().substring(0, 8);
        String str2 = z;
        byte[] arrayOfByte1 = str1.getBytes(str2);
        byte[] arrayOfByte2 = arrayOfByte1;
        _sdkbb local_sdkbb = new _sdkbb();
        local_sdkbb._sdka(arrayOfByte2);
        byte[] arrayOfByte3 = this._sdkd;
        local_sdkbb._sdka(arrayOfByte3);
        byte[] arrayOfByte4 = local_sdkbb._sdka();
        long l2 = arrayOfByte4[0] << 40 & 0x0;
        long l3 = arrayOfByte4[1] << 32 & 0x0;
        long l4 = l2 | l3;
        long l5 = arrayOfByte4[2] << 24 & 0xFF000000;
        long l6 = l4 | l5;
        long l7 = arrayOfByte4[3] << 16 & 0xFF0000;
        long l8 = l6 | l7;
        long l9 = param_sdkic._sdka() & 0xFFFF;
        l1 = l8 | l9;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException(localUnsupportedEncodingException);
      }
    }
  }

  int _sdka()
  {
    return this._sdke;
  }

  _sdkhb _sdka(_sdkic param_sdkic)
    throws IOException
  {
    int i = 1;
    int j = _sdkc._sdkb;
    long l1 = _sdkb(param_sdkic);
    this._sdkb.reset();
    _sdka local_sdka1 = this._sdkb;
    long l2 = this._sdkf * 8;
    long l3 = local_sdka1.skip(l2);
    long l4 = this._sdkb._sdkc();
    int k = this._sdkf;
    int m = this._sdkg;
    int n = (k + m) * 8;
    int i1;
    _sdkhb local_sdkhb;
    if (this._sdkh != i)
    {
      i1 = this._sdkb.available();
      if (l4 <= l1)
        break label117;
      local_sdkhb = null;
    }
    while (true)
    {
      return local_sdkhb;
      i1 = 0;
      break;
      label113: Object localObject;
      l4 = localObject;
      label117: int i2 = this._sdkh;
      long l5;
      if (i < i2)
      {
        l5 = this._sdkb._sdkc();
        i1 = this._sdkb._sdkb();
        if (l5 <= l1)
          break label181;
      }
      while (true)
      {
        int i3 = this._sdkh;
        if ((i == i3) || (l4 >= l1))
          break label224;
        local_sdkhb = null;
        break;
        label181: n += i1;
        if (l5 == l1)
        {
          i1 = this._sdko + 8;
          if (j == 0);
        }
        else
        {
          i += 1;
          if (j == 0)
            break label113;
        }
        l4 = l5;
      }
      label224: this._sdkb.reset();
      _sdka local_sdka2 = this._sdkb;
      long l6 = n;
      long l7 = local_sdka2.skip(l6);
      long l8 = l1 - l4;
      int i4 = this._sdkb.available() - i1;
      long l9 = l8;
      do
      {
        long l10 = this._sdkb._sdke();
        l9 -= l10;
        if (l9 > 0L)
        {
          _sdka local_sdka3 = this._sdkb;
          long l11 = this._sdko;
          long l12 = local_sdka3.skip(l11);
          if (j == 0);
        }
        else
        {
          if (l9 < 0L)
          {
            local_sdkhb = null;
            break;
          }
          long l13 = this._sdki;
          _sdka local_sdka4 = this._sdkb;
          int i5 = this._sdkk;
          long l14 = local_sdka4._sdkb(i5);
          double d1 = l13 + l14;
          double d2 = this._sdkp * d1;
          long l15 = this._sdkj;
          _sdka local_sdka5 = this._sdkb;
          int i6 = this._sdkl;
          long l16 = local_sdka5._sdkb(i6);
          double d3 = l15 + l16;
          double d4 = this._sdkp * d3;
          _sdka local_sdka6 = this._sdkb;
          int i7 = this._sdkm;
          int i8 = local_sdka6._sdkb(i7) + 18;
          _sdka local_sdka7 = this._sdkb;
          int i9 = this._sdkn;
          double d5 = local_sdka7._sdkb(i9);
          double d6 = this._sdkq;
          double d7 = d5 / d6 + 0.1666666666666667D;
          _sdkic local_sdkic = param_sdkic;
          local_sdkhb = new _sdkhb(local_sdkic, d2, d4, i8, d7);
          break;
        }
      }
      while (this._sdkb.available() > i4);
      local_sdkhb = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkgb
 * JD-Core Version:    0.6.2
 */