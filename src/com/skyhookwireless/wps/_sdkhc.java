package com.skyhookwireless.wps;

import java.io.File;
import java.util.Comparator;

class _sdkhc
  implements Comparable<_sdkhc>
{
  final _sdkic _sdka;
  _sdkeb _sdkb;
  final long _sdkc;
  final _sdkgc _sdkd;

  public _sdkhc(_sdkgc param_sdkgc, _sdkic param_sdkic)
  {
    this._sdka = param_sdkic;
    this._sdkb = null;
    String str = param_sdkic._sdkf();
    long l = new File(str).length();
    this._sdkc = l;
  }

  public int _sdka(_sdkhc param_sdkhc)
  {
    Comparator localComparator = _sdkic._sdka;
    _sdkic local_sdkic1 = this._sdka;
    _sdkic local_sdkic2 = param_sdkhc._sdka;
    return localComparator.compare(local_sdkic1, local_sdkic2);
  }

  public String toString()
  {
    return this._sdka.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkhc
 * JD-Core Version:    0.6.2
 */