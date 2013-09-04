package com.skyhookwireless.wps;

import com.skyhookwireless._sdkab;
import com.skyhookwireless._sdkgc;
import com.skyhookwireless._sdkhd;
import com.skyhookwireless._sdkud;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

final class _sdkqb
{
  static final boolean _sdkc;
  private final Cache.Finder<_sdkzb, _sdkib> _sdka;
  private final Cache<_sdkzb, _sdkib> _sdkb;

  static
  {
    if (!_sdkqb.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkc = bool;
      return;
    }
  }

  public _sdkqb()
  {
    this(60);
  }

  public _sdkqb(int paramInt)
  {
    _sdkrb local_sdkrb = new _sdkrb(this);
    this._sdka = local_sdkrb;
    Cache localCache = new Cache(paramInt);
    this._sdkb = localCache;
  }

  private static int _sdka(Collection<?> paramCollection, float paramFloat)
  {
    int i = paramCollection.size();
    if (i <= 3);
    float f;
    for (int j = 0; ; j = (int)Math.ceil(i * f))
    {
      return j;
      f = 1.0F - paramFloat;
    }
  }

  private static _sdkud<Integer, Integer> _sdka(_sdkud<Integer, Integer> param_sdkud)
  {
    int i = ((Integer)param_sdkud.first).intValue();
    Integer localInteger = Integer.valueOf(((Integer)param_sdkud.second).intValue() + i);
    Comparable localComparable = (Comparable)param_sdkud.first;
    return _sdkud._sdka(localInteger, localComparable);
  }

  private static _sdkud<Integer, Integer> _sdka(_sdkzb param_sdkzb, float paramFloat)
  {
    Integer localInteger1 = Integer.valueOf(_sdka(param_sdkzb.getAPs(), paramFloat));
    Integer localInteger2 = Integer.valueOf(_sdka(param_sdkzb.getCells(), 1.0F));
    return _sdkud._sdka(localInteger1, localInteger2);
  }

  private static _sdkud<Integer, Integer> _sdka(_sdkzb param_sdkzb1, _sdkzb param_sdkzb2)
  {
    ArrayList localArrayList1 = param_sdkzb1.getAPs();
    ArrayList localArrayList2 = param_sdkzb2.getAPs();
    Comparator localComparator1 = _sdkgc.COMPARATOR;
    Integer localInteger1 = Integer.valueOf(_sdkhd._sdkb(localArrayList1, localArrayList2, localComparator1));
    ArrayList localArrayList3 = param_sdkzb1.getCells();
    ArrayList localArrayList4 = param_sdkzb2.getCells();
    Comparator localComparator2 = _sdkab.CELL_COMPARATOR;
    Integer localInteger2 = Integer.valueOf(_sdkhd._sdkb(localArrayList3, localArrayList4, localComparator2));
    return _sdkud._sdka(localInteger1, localInteger2);
  }

  private _sdkib _sdka(_sdkzb param_sdkzb)
  {
    _sdkib local_sdkib1;
    if ((param_sdkzb.getCells().isEmpty()) || (!param_sdkzb.getAPs().isEmpty()))
      local_sdkib1 = null;
    while (true)
    {
      return local_sdkib1;
      Cache localCache = this._sdkb;
      Cache.Finder localFinder = this._sdka;
      _sdkib local_sdkib2 = (_sdkib)localCache.get(param_sdkzb, localFinder);
      if (local_sdkib2 == null)
      {
        local_sdkib1 = null;
      }
      else
      {
        local_sdkib1 = local_sdkib2.clone();
        if (local_sdkib1.getNAP() > 0)
        {
          local_sdkib1.setHPE(1500);
          local_sdkib1.setNAP(0);
        }
      }
    }
  }

  private _sdkib _sdka(_sdkzb param_sdkzb, _sdkib param_sdkib)
  {
    if (param_sdkib != null);
    while (true)
    {
      return param_sdkib;
      param_sdkib = _sdka(param_sdkzb);
    }
  }

  private static boolean _sdka(_sdkud<Integer, Integer> param_sdkud1, _sdkud<Integer, Integer> param_sdkud2)
  {
    int i = ((Integer)param_sdkud2.first).intValue();
    int j = ((Integer)param_sdkud1.first).intValue();
    if (i <= j)
    {
      int k = ((Integer)param_sdkud2.second).intValue();
      int m = ((Integer)param_sdkud1.second).intValue();
      if (k > m);
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  static _sdkud _sdkb(_sdkud param_sdkud)
  {
    return _sdka(param_sdkud);
  }

  static _sdkud _sdkb(_sdkzb param_sdkzb, float paramFloat)
  {
    return _sdka(param_sdkzb, paramFloat);
  }

  static _sdkud _sdkb(_sdkzb param_sdkzb1, _sdkzb param_sdkzb2)
  {
    return _sdka(param_sdkzb1, param_sdkzb2);
  }

  static boolean _sdkb(_sdkud param_sdkud1, _sdkud param_sdkud2)
  {
    return _sdka(param_sdkud1, param_sdkud2);
  }

  public void add(_sdkzb param_sdkzb, _sdkib param_sdkib)
  {
    if ((!_sdkc) && (param_sdkib._sdke()))
      throw new AssertionError();
    if ((!_sdkc) && (!param_sdkzb.hasBeacons()))
      throw new AssertionError();
    if ((!_sdkc) && (!param_sdkzb.isSortedAndUnique()))
      throw new AssertionError();
    this._sdkb.add(param_sdkzb, param_sdkib);
  }

  public _sdkib get(_sdkzb param_sdkzb)
  {
    if ((!_sdkc) && (!param_sdkzb.isSortedAndUnique()))
      throw new AssertionError();
    _sdkib local_sdkib = (_sdkib)this._sdkb.get(param_sdkzb);
    return _sdka(param_sdkzb, local_sdkib);
  }

  public _sdkib get(_sdkzb param_sdkzb, float paramFloat)
  {
    if ((!_sdkc) && (!param_sdkzb.isSortedAndUnique()))
      throw new AssertionError();
    Cache localCache = this._sdkb;
    _sdksb local_sdksb = new _sdksb(this, paramFloat, null);
    _sdkib local_sdkib = (_sdkib)localCache.get(param_sdkzb, local_sdksb);
    return _sdka(param_sdkzb, local_sdkib);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkqb
 * JD-Core Version:    0.6.2
 */