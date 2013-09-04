package com.skyhookwireless.wps;

import com.skyhookwireless._sdkab;
import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkgc;
import com.skyhookwireless._sdkhd;
import com.skyhookwireless._sdkic;
import com.skyhookwireless._sdkjc;
import com.skyhookwireless._sdkv;
import com.skyhookwireless._sdkw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class _sdkzb
  implements Cloneable
{
  static final boolean _sdkd;
  private ArrayList<_sdkjc> _sdka;
  private ArrayList<_sdkab> _sdkb;
  private ArrayList<_sdkib> _sdkc;

  static
  {
    if (!_sdkzb.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkd = bool;
      return;
    }
  }

  public _sdkzb()
  {
    ArrayList localArrayList1 = new ArrayList();
    this._sdka = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this._sdkb = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    this._sdkc = localArrayList3;
  }

  public _sdkzb(ArrayList<_sdkjc> paramArrayList, ArrayList<_sdkab> paramArrayList1, _sdkib param_sdkib)
  {
    ArrayList localArrayList1;
    if (paramArrayList != null)
    {
      localArrayList1 = (ArrayList)paramArrayList.clone();
      this._sdka = localArrayList1;
      if (paramArrayList1 == null)
        break label99;
    }
    label99: for (ArrayList localArrayList2 = (ArrayList)paramArrayList1.clone(); ; localArrayList2 = new ArrayList())
    {
      this._sdkb = localArrayList2;
      ArrayList localArrayList3 = new ArrayList();
      this._sdkc = localArrayList3;
      if (param_sdkib != null)
      {
        ArrayList localArrayList4 = this._sdkc;
        _sdkib local_sdkib = param_sdkib.clone();
        boolean bool = localArrayList4.add(local_sdkib);
      }
      _sdka();
      return;
      localArrayList1 = new ArrayList();
      break;
    }
  }

  private void _sdka()
  {
    if (this._sdkc.isEmpty())
      return;
    if (!hasBeacons())
      return;
    boolean[] arrayOfBoolean = new boolean[this._sdkc.size()];
    Arrays.fill(arrayOfBoolean, false);
    ArrayList localArrayList1 = this._sdkc;
    ArrayList localArrayList2 = this._sdka;
    _sdka(localArrayList1, localArrayList2, arrayOfBoolean);
    ArrayList localArrayList3 = this._sdkc;
    ArrayList localArrayList4 = this._sdkb;
    _sdka(localArrayList3, localArrayList4, arrayOfBoolean);
    _sdka(this._sdkc, arrayOfBoolean);
    _sdkhd._sdka(this._sdkc, arrayOfBoolean);
  }

  private static void _sdka(ArrayList<_sdkib> paramArrayList, ArrayList<? extends _sdkbb> paramArrayList1, boolean[] paramArrayOfBoolean)
  {
    int i = Location._sdki;
    Iterator localIterator1 = paramArrayList1.iterator();
    Object localObject = null;
    _sdkbb local_sdkbb;
    _sdkec local_sdkec1;
    _sdkec local_sdkec2;
    do
    {
      if (!localIterator1.hasNext())
        return;
      local_sdkbb = (_sdkbb)localIterator1.next();
      if (localObject == null)
        break;
      local_sdkec1 = local_sdkbb.getAge();
      local_sdkec2 = localObject.getAge();
    }
    while (local_sdkec1.equals(local_sdkec2));
    Iterator localIterator2 = paramArrayList.iterator();
    int j = -1;
    int k = 0;
    long l1 = 3600000L;
    int m = j;
    while (true)
    {
      int i1;
      if (localIterator2.hasNext())
      {
        _sdkib local_sdkib = (_sdkib)localIterator2.next();
        _sdkec local_sdkec3 = local_sdkbb.getAge();
        _sdkec local_sdkec4 = local_sdkib.getAge();
        long l2 = local_sdkec3._sdkb(local_sdkec4);
        if ((l2 < l1) && (l2 >= 0L))
        {
          int n = k;
          l1 = l2;
        }
        i1 = k + 1;
        if (i == 0);
      }
      else
      {
        if (m > -1)
          paramArrayOfBoolean[m] = true;
        if (i != 0)
          return;
        localObject = local_sdkbb;
        break;
      }
      k = i1;
    }
  }

  private static void _sdka(ArrayList<? extends _sdkbb> paramArrayList, boolean[] paramArrayOfBoolean)
  {
    int i = Location._sdki;
    int j = -1;
    Object localObject = null;
    int n;
    for (int k = 0; ; k = n)
    {
      int m = paramArrayList.size();
      if (k < m)
      {
        _sdkbb local_sdkbb = (_sdkbb)paramArrayList.get(k);
        if ((localObject == null) || (_sdkbb.COMPARATOR.compare(local_sdkbb, localObject) < 0))
        {
          j = k;
          localObject = local_sdkbb;
        }
        n = k + 1;
        if (i == 0);
      }
      else
      {
        if (j <= -1)
          return;
        paramArrayOfBoolean[j] = true;
        return;
      }
    }
  }

  private static void _sdka(Collection<? extends _sdkbb> paramCollection, long paramLong)
  {
    if (paramCollection.size() <= 1)
      return;
    Comparator localComparator = _sdkbb.COMPARATOR;
    _sdkec local_sdkec = ((_sdkbb)Collections.min(paramCollection, localComparator)).getAge();
    _sdka(paramCollection, paramLong, local_sdkec);
  }

  private static void _sdka(Collection<? extends _sdkbb> paramCollection, long paramLong, _sdkec param_sdkec)
  {
    _sdkac local_sdkac = new _sdkac(param_sdkec, paramLong);
    _sdkhd._sdka(paramCollection, local_sdkac);
  }

  public _sdkzb clone()
  {
    try
    {
      _sdkzb local_sdkzb = (_sdkzb)super.clone();
      ArrayList localArrayList1 = this._sdka;
      ArrayList localArrayList2 = new ArrayList(localArrayList1);
      local_sdkzb._sdka = localArrayList2;
      ArrayList localArrayList3 = this._sdkb;
      ArrayList localArrayList4 = new ArrayList(localArrayList3);
      local_sdkzb._sdkb = localArrayList4;
      ArrayList localArrayList5 = this._sdkc;
      ArrayList localArrayList6 = new ArrayList(localArrayList5);
      local_sdkzb._sdkc = localArrayList6;
      return local_sdkzb;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (paramObject == null)
      bool1 = false;
    while (true)
    {
      return bool1;
      try
      {
        paramObject = (_sdkzb)paramObject;
        int i = this._sdka.size();
        int j = paramObject._sdka.size();
        if (i != j)
        {
          int k = this._sdkb.size();
          int m = paramObject._sdkb.size();
          if (k == m);
        }
        else
        {
          bool1 = false;
          continue;
        }
        Iterator localIterator1 = this._sdka.iterator();
        Iterator localIterator2 = paramObject._sdka.iterator();
        while (true)
          if (localIterator1.hasNext())
          {
            _sdkic local_sdkic1 = ((_sdkjc)localIterator1.next())._sdka();
            _sdkic local_sdkic2 = ((_sdkjc)localIterator2.next())._sdka();
            if (!local_sdkic1.equals(local_sdkic2))
            {
              bool1 = false;
              break;
            }
          }
        localIterator1 = this._sdkb.iterator();
        localIterator2 = paramObject._sdkb.iterator();
        while (true)
          if (localIterator1.hasNext())
          {
            _sdkv local_sdkv1 = ((_sdkab)localIterator1.next())._sdka();
            _sdkv local_sdkv2 = ((_sdkab)localIterator2.next())._sdka();
            boolean bool2 = local_sdkv1.equals(local_sdkv2);
            if (!bool2)
            {
              bool1 = false;
              break;
            }
          }
        bool1 = true;
      }
      catch (ClassCastException localClassCastException)
      {
        bool1 = false;
      }
    }
  }

  public void filterOld(_sdkec param_sdkec)
  {
    _sdka(this._sdka, 5000L, param_sdkec);
    _sdka(this._sdkb, 20000L);
    _sdka();
  }

  public final ArrayList<_sdkjc> getAPs()
  {
    return this._sdka;
  }

  public final ArrayList<_sdkab> getCells()
  {
    return this._sdkb;
  }

  public final ArrayList<_sdkib> getGpsLocations()
  {
    return this._sdkc;
  }

  public _sdkzb getLatestBeacons()
  {
    _sdkzb local_sdkzb = clone();
    _sdka(local_sdkzb._sdka, 5000L);
    _sdka(local_sdkzb._sdkb, 20000L);
    local_sdkzb._sdka();
    return local_sdkzb;
  }

  public boolean hasBeacons()
  {
    if ((!this._sdka.isEmpty()) || (!this._sdkb.isEmpty()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    int i = 0;
    if (this._sdka.size() > 0)
      i = ((_sdkjc)this._sdka.get(0))._sdka().hashCode();
    while (true)
    {
      return i;
      if (this._sdkb.size() > 0)
        i = ((_sdkab)this._sdkb.get(0))._sdka().hashCode();
    }
  }

  public boolean isEmpty()
  {
    if ((!hasBeacons()) && (this._sdkc.isEmpty()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isSortedAndUnique()
  {
    ArrayList localArrayList1 = getAPs();
    Comparator localComparator1 = _sdkgc.COMPARATOR;
    if (_sdkhd._sdka(localArrayList1, localComparator1))
    {
      ArrayList localArrayList2 = getCells();
      Comparator localComparator2 = _sdkw.CELL_COMPARATOR;
      if (_sdkhd._sdka(localArrayList2, localComparator2))
      {
        ArrayList localArrayList3 = getAPs();
        Comparator localComparator3 = _sdkgc.COMPARATOR;
        if (_sdkhd._sdkb(localArrayList3, localComparator3))
        {
          ArrayList localArrayList4 = getCells();
          Comparator localComparator4 = _sdkw.CELL_COMPARATOR;
          if (!_sdkhd._sdkb(localArrayList4, localComparator4));
        }
      }
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isSubsetOf(_sdkzb param_sdkzb)
  {
    boolean bool = true;
    int i;
    int j;
    if (!this._sdkc.isEmpty())
    {
      i = 1;
      if (param_sdkzb._sdkc.isEmpty())
        break label102;
      j = 1;
      label27: ArrayList localArrayList1 = this._sdka;
      ArrayList localArrayList2 = param_sdkzb._sdka;
      Comparator localComparator1 = _sdkgc.COMPARATOR;
      if ((!_sdkhd._sdka(localArrayList1, localArrayList2, localComparator1)) || ((i != j) && (i != 0)))
        break label108;
      ArrayList localArrayList3 = this._sdkb;
      ArrayList localArrayList4 = param_sdkzb._sdkb;
      Comparator localComparator2 = _sdkab.CELL_COMPARATOR;
      if (!_sdkhd._sdka(localArrayList3, localArrayList4, localComparator2))
        break label108;
    }
    while (true)
    {
      return bool;
      i = 0;
      break;
      label102: j = 0;
      break label27;
      label108: bool = false;
    }
  }

  public void merge(_sdkzb param_sdkzb)
  {
    int i = Location._sdki;
    Iterator localIterator1 = param_sdkzb._sdka.iterator();
    do
    {
      if (!localIterator1.hasNext())
        break;
      _sdkjc local_sdkjc = (_sdkjc)localIterator1.next();
      boolean bool1 = this._sdka.add(local_sdkjc);
    }
    while (i == 0);
    if (this._sdka.size() >= 2)
    {
      Collections.sort(this._sdka);
      ArrayList localArrayList1 = this._sdka;
      Comparator localComparator1 = _sdkgc.COMPARATOR;
      _sdkhd._sdkc(localArrayList1, localComparator1);
    }
    if (param_sdkzb._sdkb.isEmpty())
    {
      this._sdkb.clear();
      if (i == 0);
    }
    else
    {
      localIterator1 = param_sdkzb._sdkb.iterator();
      do
      {
        if (!localIterator1.hasNext())
          break;
        _sdkab local_sdkab = (_sdkab)localIterator1.next();
        boolean bool2 = this._sdkb.add(local_sdkab);
      }
      while (i == 0);
      if (this._sdkb.size() >= 2)
      {
        Collections.sort(this._sdkb);
        ArrayList localArrayList2 = this._sdkb;
        Comparator localComparator2 = _sdkab.CELL_COMPARATOR;
        _sdkhd._sdkc(localArrayList2, localComparator2);
      }
    }
    Iterator localIterator2 = param_sdkzb._sdkc.iterator();
    do
    {
      if (!localIterator2.hasNext())
        break;
      _sdkib local_sdkib = (_sdkib)localIterator2.next();
      boolean bool3 = this._sdkc.add(local_sdkib);
    }
    while (i == 0);
    if (this._sdkc.size() >= 2)
    {
      ArrayList localArrayList3 = this._sdkc;
      Comparator localComparator3 = _sdkbb.COMPARATOR;
      Collections.sort(localArrayList3, localComparator3);
      ArrayList localArrayList4 = this._sdkc;
      Comparator localComparator4 = _sdkbb.COMPARATOR;
      _sdkhd._sdkc(localArrayList4, localComparator4);
    }
    if (!_sdkd)
    {
      ArrayList localArrayList5 = param_sdkzb._sdka;
      Comparator localComparator5 = _sdkgc.COMPARATOR;
      if (!_sdkhd._sdka(localArrayList5, localComparator5))
        throw new AssertionError();
    }
    if (!_sdkd)
    {
      ArrayList localArrayList6 = param_sdkzb._sdkb;
      Comparator localComparator6 = _sdkw.CELL_COMPARATOR;
      if (!_sdkhd._sdka(localArrayList6, localComparator6))
        throw new AssertionError();
    }
    if (!_sdkd)
    {
      ArrayList localArrayList7 = param_sdkzb._sdka;
      Comparator localComparator7 = _sdkgc.COMPARATOR;
      if (!_sdkhd._sdkb(localArrayList7, localComparator7))
        throw new AssertionError();
    }
    if (_sdkd)
      return;
    ArrayList localArrayList8 = param_sdkzb._sdkb;
    Comparator localComparator8 = _sdkw.CELL_COMPARATOR;
    if (_sdkhd._sdkb(localArrayList8, localComparator8))
      return;
    throw new AssertionError();
  }

  public int size()
  {
    int i = this._sdka.size();
    int j = this._sdkb.size();
    int k = i + j;
    int m = this._sdkc.size();
    return k + m;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkzb
 * JD-Core Version:    0.6.2
 */