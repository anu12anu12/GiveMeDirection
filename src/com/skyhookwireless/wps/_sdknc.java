package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;

final class _sdknc
{
  static final boolean _sdkh;
  private static final String z;
  private final _sdkhb _sdka;
  private final WPSAuthentication _sdkb;
  private final long _sdkc;
  private final _sdkqc _sdkd;
  private volatile boolean _sdke = false;
  private _sdkxc _sdkf = null;
  private _sdkxc _sdkg = null;

  static
  {
    int i = 1;
    Object localObject1 = "\030yeNn\020um".toCharArray();
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
          i3 = 26;
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
      if (!_sdknc.class.desiredAssertionStatus());
      while (true)
      {
        _sdkh = i;
        return;
        i = 0;
      }
      i3 = 121;
      break label80;
      i3 = 27;
      break label80;
      i3 = 10;
      break label80;
      i3 = 60;
      break label80;
      k = 0;
    }
  }

  _sdknc(WPSAuthentication paramWPSAuthentication, long paramLong, _sdkqc param_sdkqc)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdknc.class);
    this._sdka = local_sdkhb;
    this._sdkb = paramWPSAuthentication;
    this._sdkc = paramLong;
    this._sdkd = param_sdkqc;
  }

  void _sdka()
    throws InterruptedException
  {
    boolean bool = _sdkkc._sdkr;
    _sdkhb local_sdkhb = this._sdka;
    String str = z;
    local_sdkhb._sdkc(str);
    this._sdke = true;
    _sdkxc[] arrayOf_sdkxc = new _sdkxc[2];
    Object localObject1 = null;
    try
    {
      _sdkxc local_sdkxc1 = this._sdkf;
      arrayOf_sdkxc[0] = local_sdkxc1;
      _sdkxc local_sdkxc2 = this._sdkg;
      arrayOf_sdkxc[1] = local_sdkxc2;
      int i = arrayOf_sdkxc.length;
      int j = 0;
      _sdkxc local_sdkxc3;
      do
      {
        if (j >= i)
          break;
        local_sdkxc3 = arrayOf_sdkxc[j];
        if (local_sdkxc3 != null)
          local_sdkxc3.abort();
        j += 1;
      }
      while (!bool);
      int k = arrayOf_sdkxc.length;
      int m = 0;
      do
      {
        if (m >= k)
          break;
        local_sdkxc3 = arrayOf_sdkxc[m];
        if (local_sdkxc3 != null)
          local_sdkxc3.join();
        m += 1;
      }
      while (!bool);
      this._sdke = false;
      return;
    }
    finally
    {
    }
  }

  boolean _sdka(ScanHistory paramScanHistory)
  {
    boolean bool;
    if (this._sdke)
      bool = false;
    while (true)
    {
      return bool;
      try
      {
        WPSAuthentication localWPSAuthentication = this._sdkb;
        _sdkqc local_sdkqc = this._sdkd;
        long l = this._sdkc;
        ScanHistory localScanHistory = paramScanHistory;
        _sdkpc local_sdkpc = new _sdkpc(localWPSAuthentication, localScanHistory, local_sdkqc, l);
        _sdkxc local_sdkxc = new _sdkxc(local_sdkpc);
        this._sdkf = local_sdkxc;
        this._sdkf.start();
        bool = true;
      }
      finally
      {
      }
    }
  }

  boolean _sdka(_sdkic param_sdkic, int paramInt)
  {
    if ((!_sdkh) && (this._sdkc <= 0L))
      throw new AssertionError();
    boolean bool;
    if (this._sdke)
      bool = false;
    while (true)
    {
      return bool;
      try
      {
        _sdkqc local_sdkqc = this._sdkd;
        _sdkoc local_sdkoc = new _sdkoc(param_sdkic, local_sdkqc, paramInt);
        _sdkxc local_sdkxc = new _sdkxc(local_sdkoc);
        this._sdkg = local_sdkxc;
        this._sdkg.start();
        bool = true;
      }
      finally
      {
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdknc
 * JD-Core Version:    0.6.2
 */