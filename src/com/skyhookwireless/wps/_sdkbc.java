package com.skyhookwireless.wps;

import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkic;
import com.skyhookwireless._sdkjc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class _sdkbc
{
  static final boolean _sdke;
  private static final String[] z;
  private final long _sdka;
  private _sdks<_sdkbb> _sdkb;
  private Map<_sdkic, _sdks<_sdkjc>> _sdkc;
  private int _sdkd;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[2];
    Object localObject1 = "PM".toCharArray();
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
          i3 = 113;
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
      Object localObject4 = "!g".toCharArray();
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
            i9 = 113;
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
        z = arrayOfString;
        if (!_sdkbc.class.desiredAssertionStatus());
        while (true)
        {
          _sdke = i;
          return;
          i = 0;
        }
        i3 = 124;
        break;
        i3 = 109;
        break;
        i3 = 43;
        break;
        i3 = 127;
        break;
        i9 = 124;
        break label244;
        i9 = 109;
        break label244;
        i9 = 43;
        break label244;
        i9 = 127;
        break label244;
        i6 = 0;
      }
      k = 0;
    }
  }

  _sdkbc(int paramInt)
  {
    long l = paramInt;
    this._sdka = l;
    _sdka();
  }

  private _sdkjc _sdka(_sdkic param_sdkic)
  {
    _sdks local_sdks = (_sdks)this._sdkc.get(param_sdkic);
    if (local_sdks == null);
    for (_sdkjc local_sdkjc = null; ; local_sdkjc = (_sdkjc)local_sdks._sdkc())
    {
      return local_sdkjc;
      if ((!_sdke) && (local_sdks._sdka() <= 0))
        throw new AssertionError();
    }
  }

  private List<Integer> _sdka(_sdkic param_sdkic, long paramLong, _sdkec param_sdkec)
  {
    int i = Location._sdki;
    _sdks local_sdks = (_sdks)this._sdkc.get(param_sdkic);
    if (local_sdks == null);
    ArrayList localArrayList;
    for (Object localObject = null; ; localObject = localArrayList)
    {
      return localObject;
      localArrayList = new ArrayList();
      Iterator localIterator = local_sdks._sdkc(param_sdkec, paramLong).iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        int j = ((_sdkjc)localIterator.next())._sdka();
        Integer localInteger = new Integer(j);
        boolean bool = localArrayList.add(localInteger);
      }
      while (i == 0);
    }
  }

  private void _sdka(_sdkec param_sdkec)
  {
    int i = Location._sdki;
    Iterator localIterator = this._sdkc.entrySet().iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      _sdks local_sdks = (_sdks)((Map.Entry)localIterator.next()).getValue();
      int j = this._sdkd;
      int k = local_sdks._sdka(param_sdkec);
      int m = j - k;
      this._sdkd = m;
      if (local_sdks._sdka() == 0)
        localIterator.remove();
    }
    while (i == 0);
    int n = this._sdkb._sdka(param_sdkec);
  }

  private boolean _sdka(_sdkjc param_sdkjc)
  {
    _sdkic local_sdkic1 = param_sdkjc._sdka();
    _sdkjc local_sdkjc = _sdka(local_sdkic1);
    if ((local_sdkjc != null) && (local_sdkjc.equals(param_sdkjc)));
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      int i = this._sdkd + 1;
      this._sdkd = i;
      _sdkic local_sdkic2 = param_sdkjc._sdka();
      _sdks local_sdks1 = (_sdks)this._sdkc.get(local_sdkic2);
      if (local_sdks1 != null)
      {
        local_sdks1._sdka(param_sdkjc);
        if (Location._sdki == 0);
      }
      else
      {
        long l = this._sdka;
        _sdks local_sdks2 = new _sdks(l);
        local_sdks2._sdka(param_sdkjc);
        Object localObject = this._sdkc.put(local_sdkic2, local_sdks2);
      }
    }
  }

  int _sdka(List<_sdkjc> paramList1, _sdkec param_sdkec, List<_sdkjc> paramList2)
  {
    int i = Location._sdki;
    int j = _sdkb();
    Iterator localIterator = paramList1.iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      _sdkjc local_sdkjc = (_sdkjc)localIterator.next();
      if ((_sdka(local_sdkjc)) && (paramList2 != null))
        boolean bool = paramList2.add(local_sdkjc);
    }
    while (i == 0);
    int k = _sdkb() - j;
    _sdks local_sdks = this._sdkb;
    _sdkcc local_sdkcc = new _sdkcc(this, param_sdkec);
    local_sdks._sdka(local_sdkcc);
    _sdka(param_sdkec);
    return k;
  }

  List<List<Integer>> _sdka(long paramLong, _sdkec param_sdkec)
  {
    int i = Location._sdki;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this._sdkc.keySet().iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      _sdkic local_sdkic = (_sdkic)localIterator.next();
      List localList = _sdka(local_sdkic, paramLong, param_sdkec);
      boolean bool = localArrayList.add(localList);
    }
    while (i == 0);
    return localArrayList;
  }

  void _sdka()
  {
    long l = this._sdka;
    _sdks local_sdks = new _sdks(l);
    this._sdkb = local_sdks;
    HashMap localHashMap = new HashMap();
    this._sdkc = localHashMap;
    this._sdkd = 0;
  }

  int _sdkb()
  {
    return this._sdkc.size();
  }

  int _sdkc()
  {
    return this._sdkd;
  }

  int _sdkd()
  {
    return this._sdkb._sdka();
  }

  public String toString()
  {
    int i = Location._sdki;
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator1 = this._sdkc.entrySet().iterator();
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("[");
      localIterator2 = ((_sdks)localEntry.getValue()).iterator();
    }
    for (int j = 1; ; j = 0)
      if (localIterator2.hasNext())
      {
        _sdkjc local_sdkjc = (_sdkjc)localIterator2.next();
        if (j == 0)
        {
          String str1 = z[0];
          StringBuilder localStringBuilder3 = localStringBuilder1.append(str1);
        }
        String str2 = local_sdkjc.toString();
        StringBuilder localStringBuilder4 = localStringBuilder1.append(str2);
        if (i == 0);
      }
      else
      {
        String str3 = z[1];
        StringBuilder localStringBuilder5 = localStringBuilder1.append(str3);
        if (i == 0)
          break;
        if (localStringBuilder1.length() > 1)
        {
          int k = localStringBuilder1.length() + -1;
          StringBuilder localStringBuilder6 = localStringBuilder1.deleteCharAt(k);
        }
        return localStringBuilder1.toString();
      }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkbc
 * JD-Core Version:    0.6.2
 */