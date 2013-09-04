package com.skyhookwireless.wps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class ScanHistory
  implements Iterable<_sdkzb>
{
  private static final String[] z;
  private final List<_sdkzb> _sdka;
  private int _sdkb;
  private int _sdkc;
  private int _sdkd;
  private final int _sdke;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[3];
    Object localObject1 = "?{&\013\035\br-\013\003\036`7\013\r\004}7J\007\0053\"_N\007v\"X\032K|-NN*CcD\034Kp&G\002Kg,\\\013\031".toCharArray();
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
          i3 = 110;
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
      Object localObject4 = "?{&\013\003\nk\020B\024\0163.^\035\0373!NN\fa&J\032\016ac_\006\n}cQ\013\031|y\013".toCharArray();
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
            i9 = 110;
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
        Object localObject6 = "&f0_N\005|7\013\f\0163 J\002\007v'\013\031\003v-\013\032\003vcC\007\030g,Y\027Kz0\013\013\006c7R".toCharArray();
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
              i18 = 110;
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
          if (!ScanHistory.class.desiredAssertionStatus());
          while (true)
          {
            _sdkf = i;
            return;
            i = 0;
          }
          i3 = 107;
          break;
          i3 = 19;
          break;
          i3 = 67;
          break;
          i3 = 43;
          break;
          i9 = 107;
          break label244;
          i9 = 19;
          break label244;
          i9 = 67;
          break label244;
          i9 = 43;
          break label244;
          i18 = 107;
          break label408;
          i18 = 19;
          break label408;
          i18 = 67;
          break label408;
          i18 = 43;
          break label408;
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  public ScanHistory(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    this._sdka = localLinkedList;
    this._sdke = paramInt;
    clear();
    if (this._sdke >= 1)
      return;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[1];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    int i = this._sdke;
    String str2 = i;
    throw new IllegalArgumentException(str2);
  }

  private void _sdka()
  {
    Iterator localIterator = iterator();
    _sdka(localIterator);
  }

  private void _sdka(_sdkzb param_sdkzb)
  {
    _sdkd(param_sdkzb);
    this._sdka.add(0, param_sdkzb);
  }

  private void _sdka(Iterator<_sdkzb> paramIterator)
  {
    if ((!_sdkf) && (isEmpty()))
      throw new AssertionError();
    if ((!_sdkf) && (!paramIterator.hasNext()))
      throw new AssertionError();
    _sdkzb local_sdkzb = (_sdkzb)paramIterator.next();
    _sdke(local_sdkzb);
    paramIterator.remove();
  }

  private void _sdka(ListIterator<_sdkzb> paramListIterator)
  {
    if ((!_sdkf) && (!paramListIterator.hasPrevious()))
      throw new AssertionError();
    Object localObject = paramListIterator.previous();
    _sdka(paramListIterator);
  }

  private static boolean _sdka(Iterator<_sdkzb> paramIterator, _sdkzb param_sdkzb)
  {
    _sdkzb local_sdkzb;
    do
    {
      if (!paramIterator.hasNext())
        break;
      local_sdkzb = (_sdkzb)paramIterator.next();
    }
    while (!param_sdkzb.isSubsetOf(local_sdkzb));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void _sdkb()
  {
    ListIterator localListIterator = reverseIterator();
    _sdka(localListIterator);
  }

  private void _sdkb(_sdkzb param_sdkzb)
  {
    int i = Location._sdki;
    int j = param_sdkzb.size();
    do
    {
      int k = size() + j;
      int m = this._sdke;
      if (k <= m)
        return;
      _sdkb();
    }
    while (i == 0);
  }

  private void _sdkc()
  {
    if (isEmpty())
      return;
    Iterator localIterator = iterator();
    Object localObject = localIterator.next();
    _sdkzb local_sdkzb = getLastScan();
    if (!_sdka(localIterator, local_sdkzb))
      return;
    _sdka();
  }

  private void _sdkc(_sdkzb param_sdkzb)
  {
    int i = Location._sdki;
    ListIterator localListIterator = this._sdka.listIterator();
    do
    {
      do
        if (!localListIterator.hasNext())
          return;
      while (!((_sdkzb)localListIterator.next()).isSubsetOf(param_sdkzb));
      _sdka(localListIterator);
    }
    while (i == 0);
  }

  private void _sdkd(_sdkzb param_sdkzb)
  {
    int i = this._sdkb;
    int j = param_sdkzb.getAPs().size();
    int k = i + j;
    this._sdkb = k;
    int m = this._sdkc;
    int n = param_sdkzb.getCells().size();
    int i1 = m + n;
    this._sdkc = i1;
    int i2 = this._sdkd;
    int i3 = param_sdkzb.getGpsLocations().size();
    int i4 = i2 + i3;
    this._sdkd = i4;
  }

  private void _sdke(_sdkzb param_sdkzb)
  {
    int i = this._sdkb;
    int j = param_sdkzb.getAPs().size();
    int k = i - j;
    this._sdkb = k;
    int m = this._sdkc;
    int n = param_sdkzb.getCells().size();
    int i1 = m - n;
    this._sdkc = i1;
    int i2 = this._sdkd;
    int i3 = param_sdkzb.getGpsLocations().size();
    int i4 = i2 - i3;
    this._sdkd = i4;
  }

  public void add(_sdkzb param_sdkzb)
  {
    if (!param_sdkzb.hasBeacons())
    {
      String str = z[0];
      throw new IllegalArgumentException(str);
    }
    _sdkc();
    _sdkc(param_sdkzb);
    _sdkb(param_sdkzb);
    _sdka(param_sdkzb);
  }

  public void clear()
  {
    this._sdka.clear();
    this._sdkd = 0;
    this._sdkc = 0;
    this._sdkb = 0;
  }

  public _sdkzb getLastScan()
  {
    if (this._sdka.isEmpty())
    {
      String str = z[2];
      throw new IllegalStateException(str);
    }
    return (_sdkzb)this._sdka.get(0);
  }

  public boolean isEmpty()
  {
    return this._sdka.isEmpty();
  }

  public Iterator<_sdkzb> iterator()
  {
    return this._sdka.iterator();
  }

  public int numAPs()
  {
    return this._sdkb;
  }

  public int numCells()
  {
    return this._sdkc;
  }

  public int numGpsLocations()
  {
    return this._sdkd;
  }

  public ListIterator<_sdkzb> reverseIterator()
  {
    List localList = this._sdka;
    int i = this._sdka.size();
    return localList.listIterator(i);
  }

  public int size()
  {
    int i = numAPs();
    int j = numCells();
    int k = i + j;
    int m = numGpsLocations();
    return k + m;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.ScanHistory
 * JD-Core Version:    0.6.2
 */