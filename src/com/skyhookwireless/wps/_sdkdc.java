package com.skyhookwireless.wps;

import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdksd;
import com.skyhookwireless._sdkwd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class _sdkdc
{
  private static final String[] z;
  private final _sdkhb _sdka;
  private final ScanObservation _sdkb;
  private final _sdkpb _sdkc;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[3];
    Object localObject1 = "H\030T!8T\030\021#jR\tP1tDKF2tV\002_4".toCharArray();
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
          i3 = 24;
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
      Object localObject4 = "H\030T!8T\030\021#jR\tP1tDK\\<nT\005VskQ\004F?a\035CS2kX\017\021<v\035\030R2v\035\004S }O\035P'qR\005\030".toCharArray();
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
            i9 = 24;
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
        Object localObject6 = "H\030T!8T\030\021#jR\tP1tDKB'yI\002^=yO\022\021{z\\\030T78R\005\021 {\\\005\021<zN\016C%yI\002^=1".toCharArray();
        int i13 = localObject6.length;
        int i14;
        label343: int i18;
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
            int i17 = localObject7[i14];
            switch (m % 5)
            {
            default:
              i18 = 24;
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
          z = arrayOfString;
          if (!_sdkdc.class.desiredAssertionStatus());
          while (true)
          {
            _sdkd = i;
            return;
            i = 0;
          }
          i3 = 61;
          break;
          i3 = 107;
          break;
          i3 = 49;
          break;
          i3 = 83;
          break;
          i9 = 61;
          break label244;
          i9 = 107;
          break label244;
          i9 = 49;
          break label244;
          i9 = 83;
          break label244;
          i18 = 61;
          break label408;
          i18 = 107;
          break label408;
          i18 = 49;
          break label408;
          i18 = 83;
          break label408;
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  _sdkdc(ScanObservation paramScanObservation, _sdkpb param_sdkpb)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkdc.class);
    this._sdka = local_sdkhb;
    this._sdkb = paramScanObservation;
    this._sdkc = param_sdkpb;
  }

  private static void _sdka(_sdkib param_sdkib, long paramLong, _sdkec param_sdkec, List<Double> paramList1, List<Double> paramList2)
  {
    if (!param_sdkib.hasBearing())
      return;
    Double localDouble1 = Double.valueOf(param_sdkib.getBearing());
    boolean bool1 = paramList1.add(localDouble1);
    long l1 = param_sdkib.getAge()._sdka(param_sdkec);
    double d1 = l1 / 1000.0D;
    long l2 = paramLong / 2L;
    if (l1 < l2);
    for (double d2 = 1.0D + d1; (!_sdkd) && (d2 < 0.0D); d2 = 5.0D - d1)
      throw new AssertionError();
    Double localDouble2 = Double.valueOf(d2);
    boolean bool2 = paramList2.add(localDouble2);
  }

  private static void _sdka(_sdkib param_sdkib, long paramLong, _sdkec param_sdkec, boolean paramBoolean, List<Double> paramList1, List<Double> paramList2, List<Double> paramList3)
  {
    if (!paramBoolean)
    {
      long l1 = param_sdkib.getAge()._sdka(param_sdkec);
      double d1 = l1 / 1000.0D;
      long l2 = paramLong / 2L;
      if (l1 < l2);
      for (double d2 = 2.0D + d1; (!_sdkd) && (d2 < 0.0D); d2 = 10.0D - d1)
        throw new AssertionError();
      Double localDouble1 = Double.valueOf(d2);
      boolean bool1 = paramList3.add(localDouble1);
      if (Location._sdki == 0);
    }
    else
    {
      Double localDouble2 = Double.valueOf(1.0D);
      boolean bool2 = paramList3.add(localDouble2);
    }
    Double localDouble3 = Double.valueOf(param_sdkib.getLatitude());
    boolean bool3 = paramList1.add(localDouble3);
    Double localDouble4 = Double.valueOf(param_sdkib.getLongitude());
    boolean bool4 = paramList2.add(localDouble4);
  }

  void _sdka(_sdkib param_sdkib1, _sdkib param_sdkib2)
  {
    int i = Location._sdki;
    if (param_sdkib1.hasSpeed())
    {
      _sdkib local_sdkib = this._sdkc._sdkc();
      if ((local_sdkib != null) && (local_sdkib.hasSpeed()))
      {
        double d1 = param_sdkib1.getSpeed() * 0.88D;
        double d2 = local_sdkib.getSpeed() * 0.12D;
        double d3 = d1 + d2;
        param_sdkib2.setSpeed(d3);
      }
    }
    if ((this._sdkb._sdkc()) && (this._sdkb._sdkf()))
    {
      _sdkhb local_sdkhb1 = this._sdka;
      String str1 = z[0];
      local_sdkhb1._sdkb(str1);
      if (!param_sdkib1.hasSpeed())
        return;
      double d4 = _sdkwd._sdka(param_sdkib1.getSpeed(), 0.1D, 8.0D);
      param_sdkib2.setSpeed(d4);
      if (i == 0)
        return;
    }
    if ((this._sdkb._sdka()) && (this._sdkb._sdkd()))
    {
      _sdkhb local_sdkhb2 = this._sdka;
      String str2 = z[2];
      local_sdkhb2._sdkb(str2);
      param_sdkib2.setSpeed(0.0D);
      if (i == 0)
        return;
    }
    if (!this._sdkb._sdkb())
      return;
    if (!this._sdkb._sdke())
      return;
    _sdkhb local_sdkhb3 = this._sdka;
    String str3 = z[1];
    local_sdkhb3._sdkb(str3);
    if (!param_sdkib1.hasSpeed())
      return;
    double d5 = Math.min(param_sdkib1.getSpeed(), 2.0D);
    param_sdkib2.setSpeed(d5);
  }

  void _sdka(_sdkib param_sdkib1, _sdkib param_sdkib2, _sdkec param_sdkec)
  {
    int i = Location._sdki;
    Object localObject = this._sdkc._sdkc();
    if (localObject == null)
      return;
    boolean bool;
    if ((!((_sdkib)localObject).hasSpeed()) || (((_sdkib)localObject)._sdkf()))
    {
      bool = true;
      if (!bool)
        break label253;
    }
    label253: long l2;
    for (long l1 = 10000L; ; l2 = 8000L)
    {
      if (param_sdkib1.getAge()._sdka(param_sdkec) > l1)
        return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      _sdkib local_sdkib1 = param_sdkib1;
      _sdkec local_sdkec1 = param_sdkec;
      _sdka(local_sdkib1, l1, local_sdkec1, bool, localArrayList1, localArrayList2, localArrayList3);
      Iterator localIterator = this._sdkc._sdkb(param_sdkec, l1).iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        _sdkib local_sdkib2 = (_sdkib)localIterator.next();
        _sdkec local_sdkec2 = param_sdkec;
        _sdka(local_sdkib2, l1, local_sdkec2, bool, localArrayList1, localArrayList2, localArrayList3);
      }
      while (i == 0);
      if (localArrayList3.size() < 2)
        return;
      localObject = _sdkwd._sdka(localArrayList1, localArrayList3);
      Double localDouble = _sdkwd._sdka(localArrayList2, localArrayList3);
      if (localObject == null)
        return;
      if (localDouble == null)
        return;
      double d1 = ((Double)localObject).doubleValue();
      param_sdkib2.setLatitude(d1);
      double d2 = localDouble.doubleValue();
      param_sdkib2.setLongitude(d2);
      return;
      bool = false;
      break;
    }
  }

  void _sdkb(_sdkib param_sdkib1, _sdkib param_sdkib2, _sdkec param_sdkec)
  {
    int i = Location._sdki;
    if (param_sdkib1.getAge()._sdka(param_sdkec) > 5000L)
      return;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    _sdkib local_sdkib1 = param_sdkib1;
    _sdkec local_sdkec1 = param_sdkec;
    _sdka(local_sdkib1, 5000L, local_sdkec1, localArrayList1, localArrayList2);
    Iterator localIterator = this._sdkc._sdkb(param_sdkec, 5000L).iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      _sdkib local_sdkib2 = (_sdkib)localIterator.next();
      _sdkec local_sdkec2 = param_sdkec;
      _sdka(local_sdkib2, 5000L, local_sdkec2, localArrayList1, localArrayList2);
    }
    while (i == 0);
    if (localArrayList2.size() < 2)
      return;
    _sdksd._sdka(localArrayList1, true);
    Double localDouble = _sdkwd._sdka(localArrayList1, localArrayList2);
    if (localDouble == null)
      return;
    double d = _sdksd._sdka(localDouble.doubleValue(), false);
    param_sdkib2.setBearing(d);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkdc
 * JD-Core Version:    0.6.2
 */