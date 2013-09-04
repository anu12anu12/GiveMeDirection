package com.skyhookwireless.wps;

import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkvd;

class _sdkv
  implements _sdkvd<T>
{
  private int _sdka = 0;
  private boolean _sdkb = true;
  final int _sdkc;
  final _sdkec _sdkd;
  final long _sdke;
  final _sdku _sdkf;

  _sdkv(_sdku param_sdku, int paramInt, _sdkec param_sdkec, long paramLong)
  {
  }

  public boolean eval(T paramT)
  {
    boolean bool1 = this._sdkb;
    int i = this._sdka;
    int j = this._sdkc + -1;
    if (i >= j)
    {
      _sdkec local_sdkec1 = paramT.getAge();
      _sdkec local_sdkec2 = this._sdkd;
      long l1 = local_sdkec1._sdka(local_sdkec2);
      long l2 = this._sdke;
      if (l1 >= l2)
        break label87;
    }
    label87: for (boolean bool2 = true; ; bool2 = false)
    {
      this._sdkb = bool2;
      int k = this._sdka + 1;
      this._sdka = k;
      return bool1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkv
 * JD-Core Version:    0.6.2
 */