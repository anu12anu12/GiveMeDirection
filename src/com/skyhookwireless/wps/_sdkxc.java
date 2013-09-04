package com.skyhookwireless.wps;

public class _sdkxc extends Thread
{
  private final _sdke _sdka;

  public _sdkxc(_sdke param_sdke)
  {
    super(param_sdke);
    this._sdka = param_sdke;
  }

  public final void abort()
  {
    this._sdka.abort();
    interrupt();
    boolean bool = interrupted();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkxc
 * JD-Core Version:    0.6.2
 */