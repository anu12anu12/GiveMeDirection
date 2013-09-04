package com.skyhookwireless.wps;

import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkhd;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

class _sdks<T extends _sdkbb>
  implements Iterable<T>
{
  static final boolean _sdkc;
  private final long _sdka;
  private final LinkedList<T> _sdkb;

  static
  {
    if (!_sdks.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkc = bool;
      return;
    }
  }

  _sdks(long paramLong)
  {
    this._sdka = paramLong;
    LinkedList localLinkedList = new LinkedList();
    this._sdkb = localLinkedList;
  }

  int _sdka()
  {
    return this._sdkb.size();
  }

  int _sdka(_sdkec param_sdkec)
  {
    int i = Location._sdki;
    int k;
    for (int j = 0; ; j = k)
    {
      if (!this._sdkb.isEmpty())
      {
        long l1 = ((_sdkbb)this._sdkb.getLast()).getAge()._sdka(param_sdkec);
        long l2 = this._sdka;
        if (l1 > l2)
        {
          Object localObject = this._sdkb.removeLast();
          k = j + 1;
          if (i == 0)
            continue;
          j = k;
        }
      }
      return j;
    }
  }

  int _sdka(_sdkec param_sdkec, long paramLong)
  {
    int i = Location._sdki;
    Iterator localIterator = _sdkc(param_sdkec, paramLong).iterator();
    int j = 0;
    int k;
    if (localIterator.hasNext())
    {
      _sdkbb local_sdkbb = (_sdkbb)localIterator.next();
      k = j + 1;
      if (i == 0);
    }
    while (true)
    {
      return k;
      j = k;
      break;
      k = j;
    }
  }

  void _sdka(T paramT)
  {
    this._sdkb.addFirst(paramT);
    if (_sdkc)
      return;
    LinkedList localLinkedList = this._sdkb;
    Comparator localComparator = _sdkbb.COMPARATOR;
    if (_sdkhd._sdka(localLinkedList, localComparator))
      return;
    throw new AssertionError();
  }

  void _sdka(Collection<? extends T> paramCollection)
  {
    int i = Location._sdki;
    Iterator localIterator = paramCollection.iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      _sdkbb local_sdkbb = (_sdkbb)localIterator.next();
      this._sdkb.addFirst(local_sdkbb);
    }
    while (i == 0);
    if (_sdkc)
      return;
    LinkedList localLinkedList = this._sdkb;
    Comparator localComparator = _sdkbb.COMPARATOR;
    if (_sdkhd._sdka(localLinkedList, localComparator))
      return;
    throw new AssertionError();
  }

  T _sdkb(_sdkec param_sdkec, long paramLong)
  {
    _sdkbb local_sdkbb = _sdkc();
    if ((local_sdkbb == null) || (local_sdkbb.getAge()._sdka(param_sdkec) > paramLong))
      local_sdkbb = null;
    return local_sdkbb;
  }

  void _sdkb()
  {
    this._sdkb.clear();
  }

  T _sdkc()
  {
    if (!this._sdkb.isEmpty());
    for (_sdkbb local_sdkbb = (_sdkbb)this._sdkb.getFirst(); ; local_sdkbb = null)
      return local_sdkbb;
  }

  Iterable<T> _sdkc(_sdkec param_sdkec, long paramLong)
  {
    LinkedList localLinkedList = this._sdkb;
    _sdkt local_sdkt = new _sdkt(this, param_sdkec, paramLong);
    return _sdkhd._sdkb(localLinkedList, local_sdkt);
  }

  public Iterator<T> iterator()
  {
    return this._sdkb.iterator();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdks
 * JD-Core Version:    0.6.2
 */