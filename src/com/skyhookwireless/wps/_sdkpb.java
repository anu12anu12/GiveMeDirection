package com.skyhookwireless.wps;

import com.skyhookwireless._sdkec;

class _sdkpb
{
  private final _sdks<_sdkib> _sdka;
  private final _sdks<_sdkib> _sdkb;

  static
  {
    if (!_sdkpb.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkc = bool;
      return;
    }
  }

  _sdkpb(long paramLong)
  {
    _sdks local_sdks1 = new _sdks(paramLong);
    this._sdka = local_sdks1;
    _sdks local_sdks2 = new _sdks(paramLong);
    this._sdkb = local_sdks2;
  }

  _sdkib _sdka(_sdkec param_sdkec, long paramLong)
  {
    return (_sdkib)this._sdka._sdkb(param_sdkec, paramLong);
  }

  void _sdka()
  {
    this._sdka._sdkb();
    this._sdkb._sdkb();
  }

  void _sdka(_sdkec param_sdkec)
  {
    int i = this._sdka._sdka(param_sdkec);
    int j = this._sdkb._sdka(param_sdkec);
  }

  void _sdka(_sdkib param_sdkib1, _sdkib param_sdkib2, _sdkec param_sdkec)
  {
    if ((!_sdkc) && ((param_sdkib1 == null) || (param_sdkib2 == null)))
      throw new AssertionError();
    _sdkib local_sdkib1 = param_sdkib2.clone();
    local_sdkib1.setAge(param_sdkec);
    _sdks local_sdks = this._sdka;
    _sdkib local_sdkib2 = param_sdkib1.clone();
    local_sdks._sdka(local_sdkib2);
    this._sdkb._sdka(local_sdkib1);
  }

  _sdkib _sdkb()
  {
    return (_sdkib)this._sdka._sdkc();
  }

  Iterable<_sdkib> _sdkb(_sdkec param_sdkec, long paramLong)
  {
    return this._sdka._sdkc(param_sdkec, paramLong);
  }

  _sdkib _sdkc()
  {
    return (_sdkib)this._sdkb._sdkc();
  }

  Iterable<_sdkib> _sdkc(_sdkec param_sdkec, long paramLong)
  {
    return this._sdkb._sdkc(param_sdkec, paramLong);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkpb
 * JD-Core Version:    0.6.2
 */