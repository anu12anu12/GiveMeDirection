package com.skyhookwireless;

import java.io.IOException;
import java.io.OutputStream;

final class _sdke extends OutputStream
{
  final _sdkh _sdka;
  final StringBuilder _sdkb;
  final _sdkhb _sdkc;

  public _sdke(_sdkhb param_sdkhb, _sdkh param_sdkh)
  {
    this._sdka = param_sdkh;
    StringBuilder localStringBuilder = new StringBuilder();
    this._sdkb = localStringBuilder;
  }

  public void close()
  {
    if (this._sdkb.length() <= 0)
      return;
    _sdkhb local_sdkhb = this._sdkc;
    _sdkh local_sdkh = this._sdka;
    String str = this._sdkb.toString();
    local_sdkhb._sdka(local_sdkh, str, null);
  }

  public void write(int paramInt)
    throws IOException
  {
    StringBuilder localStringBuilder = this._sdkb.appendCodePoint(paramInt);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdke
 * JD-Core Version:    0.6.2
 */