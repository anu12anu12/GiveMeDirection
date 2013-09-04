package com.skyhookwireless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _sdknd
  implements _sdkod
{
  private ArrayList<_sdkpd> _sdka;

  public _sdknd(_sdkpd[] paramArrayOf_sdkpd)
  {
    int i = paramArrayOf_sdkpd.length;
    ArrayList localArrayList = new ArrayList(i);
    this._sdka = localArrayList;
    int j = paramArrayOf_sdkpd.length;
    int k = 0;
    if (k >= j)
      return;
    _sdkpd local_sdkpd = paramArrayOf_sdkpd[k];
    if (local_sdkpd == null);
    while (true)
    {
      k += 1;
      if (!bool)
        break;
      return;
      local_sdkpd.setEventSink(this);
    }
  }

  public List<_sdkpd> _sdka()
    throws InterruptedException
  {
    return _sdka(9223372036854775807L);
  }

  /** @deprecated */
  public List<_sdkpd> _sdka(long paramLong)
    throws InterruptedException
  {
    try
    {
      if (this._sdka.isEmpty())
        wait(paramLong);
      ArrayList localArrayList1 = this._sdka;
      ArrayList localArrayList2 = new ArrayList();
      this._sdka = localArrayList2;
      return localArrayList1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public void _sdka(_sdkpd param_sdkpd)
  {
    try
    {
      if (!this._sdka.contains(param_sdkpd))
        boolean bool = this._sdka.add(param_sdkpd);
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void _sdka(List<_sdkpd> paramList, long paramLong)
    throws InterruptedException
  {
    boolean bool1 = _sdkpc._sdkb;
    Iterator localIterator = _sdka(paramLong).iterator();
    do
    {
      if (!localIterator.hasNext())
        return;
      _sdkpd local_sdkpd = (_sdkpd)localIterator.next();
      if (!paramList.contains(local_sdkpd))
        boolean bool2 = paramList.add(local_sdkpd);
    }
    while (!bool1);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdknd
 * JD-Core Version:    0.6.2
 */