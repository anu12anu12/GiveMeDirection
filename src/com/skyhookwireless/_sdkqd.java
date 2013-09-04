package com.skyhookwireless;

import java.util.Iterator;

class _sdkqd<T>
  implements Iterable<T>
{
  private final Iterable<T> _sdka;
  private final _sdkvd<? super T> _sdkb;

  _sdkqd(Iterable<T> paramIterable, _sdkvd<? super T> param_sdkvd)
  {
    this._sdka = paramIterable;
    this._sdkb = param_sdkvd;
  }

  public Iterator<T> iterator()
  {
    Iterator localIterator = this._sdka.iterator();
    _sdkvd local_sdkvd = this._sdkb;
    return new _sdkrd(this, localIterator, local_sdkvd);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkqd
 * JD-Core Version:    0.6.2
 */