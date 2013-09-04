package com.skyhookwireless;

class _sdkoc
  implements Runnable
{
  final boolean _sdka;
  final _sdknc _sdkb;

  _sdkoc(_sdknc param_sdknc, boolean paramBoolean)
  {
  }

  public void run()
  {
    synchronized (this._sdkb)
    {
      int i = _sdknc._sdka(this._sdkb);
      _sdknc local_sdknc2 = this._sdkb;
      boolean bool = this._sdka;
      _sdknc._sdka(local_sdknc2, bool);
      return;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkoc
 * JD-Core Version:    0.6.2
 */