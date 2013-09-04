package com.skyhookwireless;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class _sdkrd
  implements Iterator<T>
{
  private final Iterator<T> _sdka;
  private final _sdkvd<? super T> _sdkb;
  private T _sdkc;
  private boolean _sdkd;
  final _sdkqd _sdke;

  public _sdkrd(Iterator<T> paramIterator, _sdkvd<? super T> param_sdkvd)
  {
    this._sdka = param_sdkvd;
    Object localObject;
    this._sdkb = localObject;
    this._sdkd = false;
  }

  public boolean hasNext()
  {
    boolean bool;
    while ((!this._sdkd) && (this._sdka.hasNext()))
    {
      Object localObject1 = this._sdka.next();
      this._sdkc = localObject1;
      _sdkvd local_sdkvd = this._sdkb;
      Object localObject2 = this._sdkc;
      if (local_sdkvd.eval(localObject2))
      {
        bool = true;
        this._sdkd = bool;
      }
    }
    while (true)
    {
      return bool;
      bool = this._sdkd;
    }
  }

  public T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    Object localObject = this._sdkc;
    this._sdkc = null;
    this._sdkd = false;
    return localObject;
  }

  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkrd
 * JD-Core Version:    0.6.2
 */