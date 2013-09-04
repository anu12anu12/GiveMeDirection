package com.skyhookwireless.wps;

import com.skyhookwireless._sdkic;
import java.util.Iterator;
import java.util.LinkedList;

public final class _sdkz
{
  static final boolean _sdkc;
  private final LinkedList<_sdkab> _sdka;
  private final int _sdkb;

  static
  {
    if (!_sdkz.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkc = bool;
      return;
    }
  }

  public _sdkz(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    this._sdka = localLinkedList;
    this._sdkb = paramInt;
  }

  public int _sdka(_sdkic param_sdkic)
  {
    int i = _sdkc._sdkb;
    _sdkab local_sdkab;
    if (this._sdka.size() > 0)
    {
      Iterator localIterator = this._sdka.iterator();
      if (localIterator.hasNext())
      {
        local_sdkab = (_sdkab)localIterator.next();
        if (local_sdkab._sdka.equals(param_sdkic))
        {
          localIterator.remove();
          this._sdka.addFirst(local_sdkab);
        }
      }
    }
    for (int j = local_sdkab._sdkb; ; j = -1)
    {
      return j;
      if (i == 0)
        break;
    }
  }

  public void _sdka(_sdkic param_sdkic, int paramInt)
  {
    int i = _sdkc._sdkb;
    if ((!_sdkc) && (param_sdkic == null))
      throw new AssertionError();
    if ((!_sdkc) && (paramInt <= -1))
      throw new AssertionError();
    int j;
    if (_sdka(param_sdkic) > -1)
      j = 1;
    while (j != 0)
      if ((!_sdkc) && (!((_sdkab)this._sdka.getFirst())._sdka.equals(param_sdkic)))
      {
        throw new AssertionError();
        j = 0;
      }
      else
      {
        ((_sdkab)this._sdka.getFirst())._sdkb = paramInt;
        if (i == 0)
          return;
      }
    int k = this._sdka.size();
    int m = this._sdkb;
    _sdkab local_sdkab;
    if (k != m)
    {
      local_sdkab = (_sdkab)this._sdka.removeLast();
      local_sdkab._sdka = param_sdkic;
      local_sdkab._sdkb = paramInt;
      if (i == 0);
    }
    else
    {
      local_sdkab = new _sdkab(param_sdkic, paramInt);
    }
    this._sdka.addFirst(local_sdkab);
    if (_sdkc)
      return;
    int n = this._sdka.size();
    int i1 = this._sdkb;
    if (n <= i1)
      return;
    throw new AssertionError();
  }

  public void _sdkb(_sdkic param_sdkic)
  {
    int i = _sdkc._sdkb;
    if (this._sdka.size() <= 0)
      return;
    Iterator localIterator = this._sdka.iterator();
    do
    {
      if (!localIterator.hasNext())
        return;
      if (((_sdkab)localIterator.next())._sdka.equals(param_sdkic))
        localIterator.remove();
    }
    while (i == 0);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkz
 * JD-Core Version:    0.6.2
 */