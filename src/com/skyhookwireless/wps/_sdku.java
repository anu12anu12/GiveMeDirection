package com.skyhookwireless.wps;

import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkhd;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

class _sdku<T extends _sdkbb>
  implements Iterable<T>
{
  static final boolean _sdkd;
  private static final String z;
  private final long _sdka;
  private final int _sdkb;
  private final LinkedList<T> _sdkc;

  static
  {
    int i = 1;
    Object localObject1 = "HnVdaQuQD|\005jMR{\005e]\001hWbYUjW'LInK'BD}J=\030".toCharArray();
    int j = localObject1.length;
    int k;
    int i3;
    if (j <= i)
    {
      k = 0;
      Object localObject2 = localObject1;
      int m = k;
      int n = j;
      Object localObject3 = localObject1;
      int i1 = n;
      while (true)
      {
        int i2 = localObject3[k];
        switch (m % 5)
        {
        default:
          i3 = 15;
          label80: int i4 = (char)(i3 ^ i2);
          localObject3[k] = i4;
          k = m + 1;
          if (i1 != 0)
            break label117;
          localObject3 = localObject2;
          m = k;
          k = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label117: j = i1;
      localObject1 = localObject2;
    }
    while (j <= k)
    {
      z = new String((char[])localObject1).intern();
      if (!_sdku.class.desiredAssertionStatus());
      while (true)
      {
        _sdkd = i;
        return;
        i = 0;
      }
      i3 = 37;
      break label80;
      i3 = 7;
      break label80;
      i3 = 56;
      break label80;
      i3 = 33;
      break label80;
      k = 0;
    }
  }

  _sdku(long paramLong, int paramInt)
  {
    if (paramInt <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = z;
      String str2 = str1 + paramInt;
      throw new IllegalArgumentException(str2);
    }
    this._sdka = paramLong;
    this._sdkb = paramInt;
    LinkedList localLinkedList = new LinkedList();
    this._sdkc = localLinkedList;
  }

  int _sdka()
  {
    return this._sdkc.size();
  }

  Iterable<T> _sdka(long paramLong, int paramInt, _sdkec param_sdkec)
  {
    if (paramInt <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = z;
      String str2 = str1 + paramInt;
      throw new IllegalArgumentException(str2);
    }
    LinkedList localLinkedList = this._sdkc;
    _sdku local_sdku = this;
    int i = paramInt;
    _sdkec local_sdkec = param_sdkec;
    long l = paramLong;
    _sdkv local_sdkv = new _sdkv(local_sdku, i, local_sdkec, l);
    return _sdkhd._sdkb(localLinkedList, local_sdkv);
  }

  void _sdka(T paramT)
  {
    this._sdkc.addFirst(paramT);
    if (_sdkd)
      return;
    LinkedList localLinkedList = this._sdkc;
    Comparator localComparator = _sdkbb.COMPARATOR;
    if (_sdkhd._sdka(localLinkedList, localComparator))
      return;
    throw new AssertionError();
  }

  void _sdka(_sdkec param_sdkec)
  {
    int i = Location._sdki;
    _sdkbb local_sdkbb;
    for (Object localObject = null; ; localObject = local_sdkbb)
    {
      int j = this._sdkc.size();
      int k = this._sdkb;
      if (j >= k)
      {
        long l1 = ((_sdkbb)this._sdkc.getLast()).getAge()._sdka(param_sdkec);
        long l2 = this._sdka;
        if (l1 >= l2)
        {
          local_sdkbb = (_sdkbb)this._sdkc.removeLast();
          if (i == 0)
            continue;
          localObject = local_sdkbb;
        }
      }
      if (localObject == null)
        return;
      this._sdkc.addLast(localObject);
      return;
    }
  }

  void _sdkb()
  {
    this._sdkc.clear();
  }

  public Iterator<T> iterator()
  {
    return this._sdkc.iterator();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdku
 * JD-Core Version:    0.6.2
 */