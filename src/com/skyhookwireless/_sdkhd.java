package com.skyhookwireless;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class _sdkhd
{
  private static final Comparator<Object> _sdka;
  static final boolean _sdkb;

  static
  {
    if (!_sdkhd.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkb = bool;
      _sdka = new _sdkid();
      return;
    }
  }

  public static <T extends Comparable<T>> int _sdka(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    Comparator localComparator = _sdka;
    return _sdka(paramList1, paramList2, localComparator);
  }

  public static <T> int _sdka(List<? extends T> paramList1, List<? extends T> paramList2, Comparator<T> paramComparator)
  {
    boolean bool = _sdkpc._sdkb;
    if ((!_sdkb) && (!_sdkb(paramList1, paramComparator)))
      throw new AssertionError();
    if ((!_sdkb) && (!_sdkb(paramList2, paramComparator)))
      throw new AssertionError();
    int i = paramList1.size();
    int j = paramList2.size();
    int k = i + j;
    Iterator localIterator1 = paramList1.iterator();
    do
    {
      if (!localIterator1.hasNext())
        break;
      Object localObject1 = localIterator1.next();
      Iterator localIterator2 = paramList2.iterator();
      do
      {
        if (!localIterator2.hasNext())
          break;
        Object localObject2 = localIterator2.next();
        if (paramComparator.compare(localObject1, localObject2) == 0)
        {
          k += -2;
          if (!bool)
            break;
        }
      }
      while (!bool);
    }
    while (!bool);
    if (!_sdkb)
    {
      int m = paramList1.size();
      int n = paramList2.size();
      if (m + n < k)
        throw new AssertionError();
    }
    return k;
  }

  public static _sdkbb _sdka(Collection<? extends _sdkbb> paramCollection)
  {
    if ((!_sdkb) && (paramCollection.isEmpty()))
      throw new AssertionError();
    Comparator localComparator = _sdkbb.COMPARATOR;
    return (_sdkbb)Collections.min(paramCollection, localComparator);
  }

  public static <T extends Comparable<? super T>> T _sdka(T paramT1, T paramT2)
  {
    Comparator localComparator = _sdka;
    return (Comparable)_sdka(paramT1, paramT2, localComparator);
  }

  public static <T> T _sdka(T paramT1, T paramT2, Comparator<? super T> paramComparator)
  {
    if (paramComparator.compare(paramT1, paramT2) >= 0);
    while (true)
    {
      return paramT1;
      paramT1 = paramT2;
    }
  }

  public static <T> void _sdka(Iterable<T> paramIterable, _sdkvd<? super T> param_sdkvd)
  {
    boolean bool = _sdkpc._sdkb;
    Iterator localIterator = paramIterable.iterator();
    do
    {
      Object localObject;
      do
      {
        if (!localIterator.hasNext())
          return;
        localObject = localIterator.next();
      }
      while (!param_sdkvd.eval(localObject));
      localIterator.remove();
    }
    while (!bool);
  }

  public static <T extends Comparable<T>> void _sdka(List<? extends T> paramList1, List<? extends T> paramList2, _sdkld param_sdkld)
  {
    Comparator localComparator = _sdka;
    _sdka(paramList1, paramList2, param_sdkld, localComparator);
  }

  public static <T> void _sdka(List<? extends T> paramList1, List<? extends T> paramList2, _sdkld param_sdkld, Comparator<T> paramComparator)
  {
    int i = 0;
    boolean bool = _sdkpc._sdkb;
    if ((!_sdkb) && (!_sdka(paramList1, paramComparator)))
      throw new AssertionError();
    if ((!_sdkb) && (!_sdka(paramList2, paramComparator)))
      throw new AssertionError();
    if ((!_sdkb) && (!_sdkb(paramList1, paramComparator)))
      throw new AssertionError();
    if ((!_sdkb) && (!_sdkb(paramList2, paramComparator)))
      throw new AssertionError();
    int j = 0;
    int k = paramList1.size();
    int n;
    int i1;
    if (j < k)
    {
      int m = paramList2.size();
      if (i < m)
      {
        Object localObject1 = paramList1.get(j);
        Object localObject2 = paramList2.get(i);
        n = paramComparator.compare(localObject1, localObject2);
        if (n >= 0)
          break label360;
        i1 = j + 1;
        param_sdkld._sdka(j, i);
        if (!bool)
          break label353;
      }
    }
    while (true)
    {
      if (n > 0)
      {
        j = i + 1;
        param_sdkld._sdkb(i1, i);
        if (bool)
          i = j;
      }
      else
      {
        int i2 = i1 + 1;
        int i3 = i + 1;
        param_sdkld._sdkc(i1, i);
        i = i3;
        j = i2;
      }
      while (bool)
      {
        do
        {
          int i4 = paramList1.size();
          if (j >= i4)
            break;
          int i5 = paramList2.size();
          param_sdkld._sdka(j, i5);
          j += 1;
        }
        while (!bool);
        do
        {
          int i6 = paramList2.size();
          if (i >= i6)
            return;
          int i7 = paramList1.size();
          param_sdkld._sdkb(i7, i);
          i += 1;
        }
        while (!bool);
        return;
        i = j;
        j = i1;
        continue;
        label353: j = i1;
      }
      break;
      label360: i1 = j;
    }
  }

  public static <T> void _sdka(List<T> paramList, boolean[] paramArrayOfBoolean)
  {
    _sdka(paramList, paramArrayOfBoolean, true);
  }

  private static <T> void _sdka(List<T> paramList, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    boolean bool = _sdkpc._sdkb;
    Iterator localIterator = paramList.iterator();
    int i = 0;
    do
    {
      if (!localIterator.hasNext())
        return;
      Object localObject = localIterator.next();
      if ((paramArrayOfBoolean[i] ^ paramBoolean) != 0)
        localIterator.remove();
      i += 1;
    }
    while (!bool);
  }

  public static <T extends Comparable<? super T>> boolean _sdka(Iterable<T> paramIterable)
  {
    Comparator localComparator = _sdka;
    return _sdka(paramIterable, localComparator);
  }

  public static <T> boolean _sdka(Iterable<T> paramIterable, Comparator<? super T> paramComparator)
  {
    boolean bool1 = _sdkpc._sdkb;
    _sdkmd._sdkb();
    Iterator localIterator = paramIterable.iterator();
    boolean bool2;
    if (!localIterator.hasNext())
    {
      bool2 = true;
      return bool2;
    }
    Object localObject2;
    for (Object localObject1 = localIterator.next(); ; localObject1 = localObject2)
    {
      if (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        if (paramComparator.compare(localObject1, localObject2) > 0)
        {
          bool2 = false;
          break;
        }
        if (!bool1)
          continue;
      }
      bool2 = true;
      break;
    }
  }

  public static <T> boolean _sdka(Collection<T> paramCollection1, Collection<T> paramCollection2, Comparator<? super T> paramComparator)
  {
    boolean bool1 = false;
    boolean bool2 = _sdkpc._sdkb;
    int i = paramCollection1.size();
    int j = paramCollection2.size();
    if (i > j);
    label130: label134: 
    while (true)
    {
      return bool1;
      Iterator localIterator1 = paramCollection1.iterator();
      label40: int k;
      if (localIterator1.hasNext())
      {
        Object localObject1 = localIterator1.next();
        Iterator localIterator2 = paramCollection2.iterator();
        k = 0;
        do
        {
          if (!localIterator2.hasNext())
            break;
          Object localObject2 = localIterator2.next();
          if (paramComparator.compare(localObject2, localObject1) == 0)
          {
            if (!bool2)
              break label130;
            int m = 1;
          }
        }
        while (!bool2);
      }
      while (true)
      {
        if (k == 0)
          break label134;
        if (!bool2)
          break label40;
        bool1 = true;
        break;
        k = 1;
      }
    }
  }

  public static <T extends Comparable<T>> int _sdkb(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    Comparator localComparator = _sdka;
    return _sdkb(paramList1, paramList2, localComparator);
  }

  public static <T> int _sdkb(List<? extends T> paramList1, List<? extends T> paramList2, Comparator<T> paramComparator)
  {
    int i = paramList1.size();
    int j = paramList2.size();
    int k = i + j;
    int m = _sdkc(paramList1, paramList2, paramComparator) * 2;
    int n = k - m;
    if (!_sdkb)
    {
      int i1 = paramList1.size();
      int i2 = paramList2.size();
      int i3 = i1 + i2;
      if (n > i3)
        throw new AssertionError();
    }
    return n;
  }

  public static <T extends Comparable<? super T>> T _sdkb(T paramT1, T paramT2)
  {
    Comparator localComparator = _sdka;
    return (Comparable)_sdkb(paramT1, paramT2, localComparator);
  }

  public static <T> Iterable<T> _sdkb(Iterable<T> paramIterable, _sdkvd<? super T> param_sdkvd)
  {
    return new _sdkqd(paramIterable, param_sdkvd);
  }

  public static <T> T _sdkb(T paramT1, T paramT2, Comparator<? super T> paramComparator)
  {
    if (paramComparator.compare(paramT1, paramT2) >= 0);
    while (true)
    {
      return paramT2;
      paramT2 = paramT1;
    }
  }

  public static <T> void _sdkb(List<T> paramList, boolean[] paramArrayOfBoolean)
  {
    _sdka(paramList, paramArrayOfBoolean, false);
  }

  public static <T extends Comparable<? super T>> boolean _sdkb(Iterable<T> paramIterable)
  {
    Comparator localComparator = _sdka;
    return _sdkb(paramIterable, localComparator);
  }

  public static <T> boolean _sdkb(Iterable<T> paramIterable, Comparator<? super T> paramComparator)
  {
    boolean bool1 = _sdkpc._sdkb;
    _sdkmd._sdkb();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramIterable.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext())
        break;
      Object localObject2 = ((Iterator)localObject1).next();
      boolean bool2 = localArrayList.add(localObject2);
    }
    while (!bool1);
    Collections.sort(localArrayList, paramComparator);
    Iterator localIterator = localArrayList.iterator();
    boolean bool3;
    if (!localIterator.hasNext())
    {
      bool3 = true;
      return bool3;
    }
    for (Object localObject3 = localIterator.next(); ; localObject3 = localObject1)
    {
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (localObject3.equals(localObject1))
        {
          bool3 = false;
          break;
        }
        if (!bool1)
          continue;
      }
      bool3 = true;
      break;
    }
  }

  public static <T> boolean _sdkb(Collection<T> paramCollection1, Collection<T> paramCollection2, Comparator<? super T> paramComparator)
  {
    boolean bool1 = false;
    boolean bool2 = _sdkpc._sdkb;
    int i = paramCollection1.size();
    int j = paramCollection2.size();
    if (i != j);
    while (true)
    {
      return bool1;
      Iterator localIterator1 = paramCollection2.iterator();
      Iterator localIterator2 = paramCollection1.iterator();
      do
      {
        if (!localIterator2.hasNext())
          break label94;
        Object localObject1 = localIterator2.next();
        Object localObject2 = localIterator1.next();
        if (paramComparator.compare(localObject1, localObject2) != 0)
          break;
      }
      while (!bool2);
      label94: bool1 = true;
    }
  }

  public static <T> int _sdkc(List<? extends T> paramList1, List<? extends T> paramList2, Comparator<T> paramComparator)
  {
    _sdkkd local_sdkkd = new _sdkkd();
    _sdka(paramList1, paramList2, local_sdkkd, paramComparator);
    if (!_sdkb)
    {
      int i = local_sdkkd.count;
      int j = paramList1.size();
      int k = paramList2.size();
      int m = Math.min(j, k);
      if (i > m)
        throw new AssertionError();
    }
    return local_sdkkd.count;
  }

  public static <T extends Comparable<? super T>> void _sdkc(Iterable<T> paramIterable)
  {
    Comparator localComparator = _sdka;
    _sdkc(paramIterable, localComparator);
  }

  public static <T> void _sdkc(Iterable<T> paramIterable, Comparator<? super T> paramComparator)
  {
    boolean bool = _sdkpc._sdkb;
    if ((!_sdkb) && (!_sdka(paramIterable, paramComparator)))
      throw new AssertionError();
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext())
      return;
    Object localObject2;
    for (Object localObject1 = localIterator.next(); ; localObject1 = localObject2)
      if (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        if (paramComparator.compare(localObject1, localObject2) == 0)
          localIterator.remove();
        if (!bool);
      }
      else
      {
        if (_sdkb)
          return;
        if (_sdkb(paramIterable, paramComparator))
          return;
        throw new AssertionError();
      }
  }

  public static <T, X extends T, Y extends T> void _sdkd(List<X> paramList, List<Y> paramList1, Comparator<T> paramComparator)
  {
    boolean bool = _sdkpc._sdkb;
    _sdkjd local_sdkjd = new _sdkjd(paramList, paramList1);
    _sdka(paramList, paramList1, local_sdkjd, paramComparator);
    do
    {
      int i = paramList.size();
      int j = local_sdkjd.i;
      if (i <= j)
        break;
      int k = paramList.size() + -1;
      Object localObject1 = paramList.remove(k);
    }
    while (!bool);
    do
    {
      int m = paramList1.size();
      int n = local_sdkjd.i;
      if (m <= n)
        break;
      int i1 = paramList1.size() + -1;
      Object localObject2 = paramList1.remove(i1);
    }
    while (!bool);
    if (_sdkb)
      return;
    int i2 = paramList.size();
    int i3 = paramList1.size();
    if (i2 != i3)
      return;
    throw new AssertionError();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkhd
 * JD-Core Version:    0.6.2
 */