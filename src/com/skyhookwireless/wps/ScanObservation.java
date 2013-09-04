package com.skyhookwireless.wps;

import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdkjc;
import com.skyhookwireless._sdkwb;
import com.skyhookwireless._sdkwd;
import java.util.Iterator;
import java.util.List;

public class ScanObservation
{
  private static final _sdkhb _sdkf;
  static final boolean _sdkg;
  private static final String[] z;
  private final _sdkbc _sdka;
  private final _sdks<_sdkwb> _sdkb;
  private Double _sdkc;
  private Double _sdkd;
  private Double _sdke;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[4];
    Object localObject1 = "#fh|$#fi;)mh?$!ln=5$fr|2,dl0$>)4y%d)u2a%`o(.?p".toCharArray();
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
          i3 = 65;
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
      Object localObject4 = "9fh=-mh?$!ln=5$fr|7,{u=/.l<52m,z|i\"y.ahm</  yp92m`r|)$zh334 ".toCharArray();
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
            i9 = 65;
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
        Object localObject6 = "#fh|$#fi;)mHL|2,dl0$>)4y%d)u2a%`o(.?p".toCharArray();
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
              i18 = 65;
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
          Object localObject8 = "#fh|$#fi;)mys+$?)o=,=ey/ae,xua9f<8$9l(a>}}((\"g}.8".toCharArray();
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
                i26 = 65;
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
            if (!ScanObservation.class.desiredAssertionStatus());
            while (true)
            {
              _sdkg = i;
              _sdkf = _sdkhb._sdkb(ScanObservation.class);
              return;
              i = 0;
            }
            i3 = 77;
            break;
            i3 = 9;
            break;
            i3 = 28;
            break;
            i3 = 92;
            break;
            i9 = 77;
            break label244;
            i9 = 9;
            break label244;
            i9 = 28;
            break label244;
            i9 = 92;
            break label244;
            i18 = 77;
            break label408;
            i18 = 9;
            break label408;
            i18 = 28;
            break label408;
            i18 = 92;
            break label408;
            i26 = 77;
            break label572;
            i26 = 9;
            break label572;
            i26 = 28;
            break label572;
            i26 = 92;
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

  ScanObservation()
  {
    _sdkbc local_sdkbc = new _sdkbc(21000);
    this._sdka = local_sdkbc;
    _sdks local_sdks = new _sdks(10000L);
    this._sdkb = local_sdks;
  }

  private Double _sdka(_sdkec param_sdkec)
  {
    int i = Location._sdki;
    Iterator localIterator = this._sdka._sdka(11000L, param_sdkec).iterator();
    int j = 0;
    double d1 = 0.0D;
    double d5;
    int m;
    if (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int k = localList.size();
      if (k > 1)
      {
        double d2 = Math.sqrt(_sdkwd._sdkc(localList).doubleValue());
        double d3 = k;
        double d4 = d2 * d3;
        d5 = d1 + d4;
        m = j + k;
        label103: if (i == 0);
      }
    }
    while (true)
    {
      if (m < 4)
      {
        _sdkhb local_sdkhb = _sdkf;
        String str1 = z[3];
        Object[] arrayOfObject = new Object[1];
        Integer localInteger = Integer.valueOf(m);
        arrayOfObject[0] = localInteger;
        String str2 = String.format(str1, arrayOfObject);
        local_sdkhb._sdkb(str2);
      }
      double d6;
      for (Double localDouble = null; ; localDouble = Double.valueOf(d5 / d6))
      {
        return localDouble;
        d6 = m;
      }
      j = m;
      d1 = d5;
      break;
      d5 = d1;
      m = j;
      break label103;
      d5 = d1;
      m = j;
    }
  }

  private Double _sdkb(_sdkec param_sdkec)
  {
    int i = this._sdka._sdkc();
    int j = this._sdka._sdkd();
    if (i < 4)
      if (_sdkf._sdkb())
      {
        _sdkhb local_sdkhb = _sdkf;
        String str1 = z[2];
        Object[] arrayOfObject = new Object[1];
        Integer localInteger = Integer.valueOf(i);
        arrayOfObject[0] = localInteger;
        String str2 = String.format(str1, arrayOfObject);
        local_sdkhb._sdkb(str2);
      }
    double d3;
    double d4;
    for (Double localDouble = null; ; localDouble = Double.valueOf(d3 / d4))
    {
      return localDouble;
      double d1 = i;
      double d2 = this._sdka._sdkb();
      d3 = d1 / d2;
      d4 = j;
    }
  }

  private Double _sdkg()
  {
    int i = Location._sdki;
    int j = this._sdkb._sdka();
    Double localDouble1;
    if (j < 20)
    {
      if (_sdkf._sdkb())
      {
        _sdkhb local_sdkhb1 = _sdkf;
        String str1 = z[0];
        Object[] arrayOfObject1 = new Object[1];
        Integer localInteger1 = Integer.valueOf(j);
        arrayOfObject1[0] = localInteger1;
        String str2 = String.format(str1, arrayOfObject1);
        local_sdkhb1._sdkb(str2);
      }
      localDouble1 = null;
      return localDouble1;
    }
    Iterator localIterator = this._sdkb.iterator();
    double d1 = 0.0D;
    double d2 = 0.0D;
    double d3 = d1;
    double d4 = 0.0D;
    double d5 = d2;
    label109: double d7;
    double d12;
    if (localIterator.hasNext())
    {
      double d6 = ((_sdkwb)localIterator.next())._sdkd();
      d7 = 1L + d4;
      double d8 = d6 - d5;
      double d9 = d7;
      d4 = d8 / d9 + d5;
      double d10 = d6 - d5;
      double d11 = d6 - d4;
      d5 = d10 * d11;
      d12 = d3 + d5;
      if (i == 0);
    }
    while (true)
    {
      double d13;
      if (d7 > 1L)
        d13 = d7 - 1L;
      for (double d14 = d12 / d13; ; d14 = 0.0D)
      {
        if (_sdkf._sdkb())
        {
          _sdkhb local_sdkhb2 = _sdkf;
          String str3 = z[1];
          Object[] arrayOfObject2 = new Object[2];
          Double localDouble2 = Double.valueOf(d14);
          arrayOfObject2[0] = localDouble2;
          Integer localInteger2 = Integer.valueOf(j);
          arrayOfObject2[1] = localInteger2;
          String str4 = String.format(str3, arrayOfObject2);
          local_sdkhb2._sdkb(str4);
        }
        localDouble1 = Double.valueOf(d14);
        break;
      }
      double d15 = d4;
      double d16 = d7;
      d3 = d12;
      break label109;
      d7 = d4;
      d12 = d3;
    }
  }

  int _sdka(List<_sdkjc> paramList1, List<_sdkwb> paramList, _sdkec param_sdkec, List<_sdkjc> paramList2)
  {
    int i = this._sdka._sdka(paramList1, param_sdkec, paramList2);
    if (_sdkf._sdka())
    {
      _sdkhb local_sdkhb = _sdkf;
      String str = this._sdka.toString();
      local_sdkhb._sdka(str);
    }
    if (paramList != null)
      this._sdkb._sdka(paramList);
    int j = this._sdkb._sdka(param_sdkec);
    Double localDouble1 = _sdka(param_sdkec);
    this._sdkc = localDouble1;
    Double localDouble2 = _sdkb(param_sdkec);
    this._sdkd = localDouble2;
    Double localDouble3 = _sdkg();
    this._sdke = localDouble3;
    return i;
  }

  boolean _sdka()
  {
    if ((this._sdkc != null) && (this._sdkd != null));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean _sdkb()
  {
    return _sdka();
  }

  boolean _sdkc()
  {
    if (this._sdke != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean _sdkd()
  {
    boolean bool = false;
    if ((!_sdkg) && (!_sdka()))
      throw new AssertionError();
    if ((_sdkc()) && (_sdkf()));
    while (true)
    {
      return bool;
      if ((this._sdkc.doubleValue() < 2.0D) || (this._sdkd.doubleValue() > 0.3809523809523809D))
        bool = true;
    }
  }

  boolean _sdke()
  {
    if ((!_sdkg) && (!_sdkb()))
      throw new AssertionError();
    if (this._sdkd.doubleValue() > 0.3571428571428572D);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean _sdkf()
  {
    if ((!_sdkg) && (!_sdkc()))
      throw new AssertionError();
    if (this._sdke.doubleValue() > 1.0D);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.ScanObservation
 * JD-Core Version:    0.6.2
 */