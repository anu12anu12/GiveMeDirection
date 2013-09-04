package com.skyhookwireless.wps;

import com.skyhookwireless._sdkic;
import com.skyhookwireless._sdktd;
import java.util.Iterator;
import java.util.LinkedList;

final class _sdkdb
{
  private static final String[] z;
  private final com.skyhookwireless._sdkhb _sdka;
  private final WPSAuthentication _sdkb;
  private final LinkedList<_sdktd<_sdkeb, Integer>> _sdkc;
  private final _sdkz _sdkd;
  private int _sdke;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[9];
    Object localObject1 = "\\u\\\023m\fyMW(I~\fL-Xr\fU+\f|EW!_".toCharArray();
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
          i3 = 68;
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
      Object localObject4 = "\\hCV+XsB\\d\\u_R0EuBR*K:JR(I:^^%H^".toCharArray();
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
            i9 = 68;
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
        Object localObject6 = "IbO^4XsCUd[rEW!\fvCZ EtK\033\"EvI\033".toCharArray();
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
              i18 = 68;
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
          Object localObject8 = "JuYU \f".toCharArray();
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
                i26 = 68;
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
            int i29 = 4;
            Object localObject10 = "\ftCOdJuYU \fsB\033&@{OP(EiX".toCharArray();
            int i30 = localObject10.length;
            int i31;
            label672: int i34;
            if (i30 <= 1)
            {
              i31 = 0;
              localObject2 = localObject10;
              m = i31;
              int i32 = i30;
              Object localObject11 = localObject10;
              int i33 = i32;
              while (true)
              {
                i17 = localObject11[i31];
                switch (m % 5)
                {
                default:
                  i34 = 68;
                  label736: int i35 = (char)(i34 ^ i17);
                  localObject11[i31] = i35;
                  i31 = m + 1;
                  if (i33 != 0)
                    break label777;
                  localObject11 = localObject2;
                  int i36 = i31;
                  i31 = i33;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i30 = i33;
              localObject10 = localObject2;
            }
            while (true)
            {
              if (i30 > i31)
                break label672;
              String str5 = new String((char[])localObject10).intern();
              arrayOfString[i29] = str5;
              int i37 = 5;
              Object localObject12 = "B[^7X:JR(I:K^*IhMO-Ct\fR7\f".toCharArray();
              int i38 = localObject12.length;
              int i39;
              label836: int i42;
              if (i38 <= 1)
              {
                i39 = 0;
                localObject2 = localObject12;
                m = i39;
                int i40 = i38;
                Object localObject13 = localObject12;
                int i41 = i40;
                while (true)
                {
                  i17 = localObject13[i39];
                  switch (m % 5)
                  {
                  default:
                    i42 = 68;
                    label900: int i43 = (char)(i42 ^ i17);
                    localObject13[i39] = i43;
                    i39 = m + 1;
                    if (i41 != 0)
                      break label941;
                    localObject13 = localObject2;
                    int i44 = i39;
                    i39 = i41;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i38 = i41;
                localObject12 = localObject2;
              }
              while (true)
              {
                if (i38 > i39)
                  break label836;
                String str6 = new String((char[])localObject12).intern();
                arrayOfString[i37] = str6;
                int i45 = 6;
                Object localObject14 = "\f{X\033#ItII%XsCUd".toCharArray();
                int i46 = localObject14.length;
                int i47;
                label1001: int i50;
                if (i46 <= 1)
                {
                  i47 = 0;
                  localObject2 = localObject14;
                  m = i47;
                  int i48 = i46;
                  Object localObject15 = localObject14;
                  int i49 = i48;
                  while (true)
                  {
                    i17 = localObject15[i47];
                    switch (m % 5)
                    {
                    default:
                      i50 = 68;
                      label1068: int i51 = (char)(i50 ^ i17);
                      localObject15[i47] = i51;
                      i47 = m + 1;
                      if (i49 != 0)
                        break label1109;
                      localObject15 = localObject2;
                      int i52 = i47;
                      i47 = i49;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i46 = i49;
                  localObject14 = localObject2;
                }
                while (true)
                {
                  if (i46 > i47)
                    break label1001;
                  String str7 = new String((char[])localObject14).intern();
                  arrayOfString[i45] = str7;
                  int i53 = 7;
                  Object localObject16 = "\fsB\033&@{OP(EiX\0333EnD\033#ItII%XsCUd".toCharArray();
                  int i54 = localObject16.length;
                  int i55;
                  label1169: int i58;
                  if (i54 <= 1)
                  {
                    i55 = 0;
                    localObject2 = localObject16;
                    m = i55;
                    int i56 = i54;
                    Object localObject17 = localObject16;
                    int i57 = i56;
                    while (true)
                    {
                      i17 = localObject17[i55];
                      switch (m % 5)
                      {
                      default:
                        i58 = 68;
                        label1236: int i59 = (char)(i58 ^ i17);
                        localObject17[i55] = i59;
                        i55 = m + 1;
                        if (i57 != 0)
                          break label1277;
                        localObject17 = localObject2;
                        int i60 = i55;
                        i55 = i57;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i54 = i57;
                    localObject16 = localObject2;
                  }
                  while (true)
                  {
                    if (i54 > i55)
                      break label1169;
                    String str8 = new String((char[])localObject16).intern();
                    arrayOfString[i53] = str8;
                    int i61 = 8;
                    Object localObject18 = "NvMX/@s_O-B}\f".toCharArray();
                    int i62 = localObject18.length;
                    int i63;
                    label1337: int i66;
                    if (i62 <= 1)
                    {
                      i63 = 0;
                      localObject2 = localObject18;
                      m = i63;
                      int i64 = i62;
                      Object localObject19 = localObject18;
                      int i65 = i64;
                      while (true)
                      {
                        i17 = localObject19[i63];
                        switch (m % 5)
                        {
                        default:
                          i66 = 68;
                          label1404: int i67 = (char)(i66 ^ i17);
                          localObject19[i63] = i67;
                          i63 = m + 1;
                          if (i65 != 0)
                            break label1445;
                          localObject19 = localObject2;
                          int i68 = i63;
                          i63 = i65;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1445: i62 = i65;
                      localObject18 = localObject2;
                    }
                    while (true)
                    {
                      if (i62 > i63)
                        break label1337;
                      String str9 = new String((char[])localObject18).intern();
                      arrayOfString[i61] = str9;
                      z = arrayOfString;
                      if (!_sdkdb.class.desiredAssertionStatus());
                      while (true)
                      {
                        _sdkf = i;
                        return;
                        i = 0;
                      }
                      i3 = 44;
                      break;
                      i3 = 26;
                      break;
                      i3 = 44;
                      break;
                      i3 = 59;
                      break;
                      i9 = 44;
                      break label244;
                      i9 = 26;
                      break label244;
                      i9 = 44;
                      break label244;
                      i9 = 59;
                      break label244;
                      i18 = 44;
                      break label408;
                      i18 = 26;
                      break label408;
                      i18 = 44;
                      break label408;
                      i18 = 59;
                      break label408;
                      i26 = 44;
                      break label572;
                      i26 = 26;
                      break label572;
                      i26 = 44;
                      break label572;
                      i26 = 59;
                      break label572;
                      i34 = 44;
                      break label736;
                      i34 = 26;
                      break label736;
                      i34 = 44;
                      break label736;
                      i34 = 59;
                      break label736;
                      i42 = 44;
                      break label900;
                      i42 = 26;
                      break label900;
                      i42 = 44;
                      break label900;
                      i42 = 59;
                      break label900;
                      i50 = 44;
                      break label1068;
                      i50 = 26;
                      break label1068;
                      i50 = 44;
                      break label1068;
                      i50 = 59;
                      break label1068;
                      i58 = 44;
                      break label1236;
                      i58 = 26;
                      break label1236;
                      i58 = 44;
                      break label1236;
                      i58 = 59;
                      break label1236;
                      i66 = 44;
                      break label1404;
                      i66 = 26;
                      break label1404;
                      i66 = 44;
                      break label1404;
                      i66 = 59;
                      break label1404;
                      i63 = 0;
                    }
                    i55 = 0;
                  }
                  i47 = 0;
                }
                i39 = 0;
              }
              i31 = 0;
            }
            i23 = 0;
          }
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  _sdkdb(WPSAuthentication paramWPSAuthentication)
  {
    LinkedList localLinkedList = new LinkedList();
    this._sdkc = localLinkedList;
    com.skyhookwireless._sdkhb local_sdkhb = com.skyhookwireless._sdkhb._sdkb(_sdkdb.class);
    this._sdka = local_sdkhb;
    this._sdkb = paramWPSAuthentication;
    this._sdke = -1;
    _sdkz local_sdkz = new _sdkz(256);
    this._sdkd = local_sdkz;
  }

  _sdktd<_sdkeb, _sdkhb> _sdka(_sdkic param_sdkic)
    throws _sdkc
  {
    int i = _sdkc._sdkb;
    int j = this._sdkd._sdka(param_sdkic);
    if ((!_sdkf) && (j < -1))
      throw new AssertionError();
    if (!_sdkf)
    {
      int k = this._sdke;
      if (j > k)
        throw new AssertionError();
    }
    if (this._sdka._sdkb())
    {
      if (j == -1)
      {
        com.skyhookwireless._sdkhb local_sdkhb1 = this._sdka;
        StringBuilder localStringBuilder1 = new StringBuilder().append(param_sdkic);
        String str1 = z[4];
        String str2 = str1;
        local_sdkhb1._sdkb(str2);
        if (i == 0);
      }
      else
      {
        com.skyhookwireless._sdkhb local_sdkhb2 = this._sdka;
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str3 = z[3];
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str3).append(param_sdkic);
        String str4 = z[7];
        String str5 = str4 + j;
        local_sdkhb2._sdkb(str5);
      }
      com.skyhookwireless._sdkhb local_sdkhb3 = this._sdka;
      StringBuilder localStringBuilder4 = new StringBuilder();
      String str6 = z[5];
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str6);
      int m = this._sdke;
      String str7 = m;
      local_sdkhb3._sdkb(str7);
    }
    int n = this._sdke;
    Object localObject;
    if (j != n)
      localObject = null;
    while (true)
    {
      return localObject;
      Iterator localIterator = this._sdkc.iterator();
      do
      {
        if (!localIterator.hasNext())
          break label378;
        _sdktd local_sdktd = (_sdktd)localIterator.next();
        if (((Integer)local_sdktd.second).intValue() > j)
        {
          _sdkhb local_sdkhb = ((_sdkeb)local_sdktd.first)._sdka(param_sdkic);
          if (local_sdkhb != null)
          {
            if (j > -1)
              this._sdkd._sdkb(param_sdkic);
            localIterator.remove();
            this._sdkc.addFirst(local_sdktd);
            localObject = _sdktd._sdka(local_sdktd.first, local_sdkhb);
            break;
          }
        }
      }
      while (i == 0);
      label378: if (this._sdka._sdkb())
      {
        com.skyhookwireless._sdkhb local_sdkhb4 = this._sdka;
        StringBuilder localStringBuilder6 = new StringBuilder();
        String str8 = z[8];
        StringBuilder localStringBuilder7 = localStringBuilder6.append(str8).append(param_sdkic);
        String str9 = z[6];
        StringBuilder localStringBuilder8 = localStringBuilder7.append(str9);
        int i1 = this._sdke;
        String str10 = i1;
        local_sdkhb4._sdkb(str10);
      }
      _sdkz local_sdkz = this._sdkd;
      int i2 = this._sdke;
      local_sdkz._sdka(param_sdkic, i2);
      localObject = null;
    }
  }

  _sdkeb _sdka()
  {
    if (!this._sdkc.isEmpty());
    for (_sdkeb local_sdkeb = (_sdkeb)((_sdktd)this._sdkc.removeLast()).first; ; local_sdkeb = null)
    {
      return local_sdkeb;
      com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
      String str = z[0];
      local_sdkhb._sdke(str);
    }
  }

  _sdkeb _sdka(int paramInt, String paramString)
  {
    try
    {
      local_sdkeb = _sdkeb._sdkb(this._sdkb.getRealm(), paramString);
      LinkedList localLinkedList = this._sdkc;
      int i = this._sdkc.size();
      int j = Math.min(paramInt, i);
      int k = this._sdke + 1;
      this._sdke = k;
      Integer localInteger = Integer.valueOf(k);
      _sdktd local_sdktd = _sdktd._sdka(local_sdkeb, localInteger);
      localLinkedList.add(j, local_sdktd);
      return local_sdkeb;
    }
    catch (Exception localException)
    {
      while (true)
      {
        com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
        StringBuilder localStringBuilder = new StringBuilder();
        String str1 = z[2];
        String str2 = str1 + paramString;
        local_sdkhb._sdke(str2, localException);
        _sdkeb local_sdkeb = null;
      }
    }
  }

  void _sdka(_sdkeb param_sdkeb)
  {
    int i = _sdkc._sdkb;
    Iterator localIterator = this._sdkc.iterator();
    do
    {
      do
        if (!localIterator.hasNext())
          return;
      while (!((_sdkeb)((_sdktd)localIterator.next()).first).equals(param_sdkeb));
      localIterator.remove();
    }
    while (i == 0);
  }

  int _sdkb()
  {
    return this._sdkc.size();
  }

  void _sdkb(_sdkeb param_sdkeb)
  {
    int i = _sdkc._sdkb;
    Iterator localIterator = this._sdkc.iterator();
    int k;
    for (int j = 1; ; j = k)
    {
      if (!localIterator.hasNext())
        return;
      _sdktd local_sdktd = (_sdktd)localIterator.next();
      Object localObject = local_sdktd.first;
      if (param_sdkeb == localObject)
      {
        if (j != 0)
          return;
        com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
        String str = z[1];
        local_sdkhb._sdkb(str);
        localIterator.remove();
        this._sdkc.addFirst(local_sdktd);
        if (i == 0)
          return;
      }
      k = 0;
      if (i != 0)
        return;
    }
  }

  boolean _sdkc()
  {
    return this._sdkc.isEmpty();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkdb
 * JD-Core Version:    0.6.2
 */