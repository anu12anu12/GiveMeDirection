package com.skyhookwireless;

import java.io.IOException;
import java.io.InputStream;

public abstract class _sdkrb
{
  protected int _sdka = 0;
  protected String _sdkb = "";
  protected String _sdkc = null;
  protected long _sdkd = 65535L;
  protected InputStream _sdke = null;

  public int _sdka()
  {
    return this._sdka;
  }

  public String _sdkb()
  {
    return this._sdkb;
  }

  public long _sdkc()
  {
    return this._sdkd;
  }

  public String _sdkd()
  {
    return this._sdkc;
  }

  public InputStream _sdke()
  {
    return this._sdke;
  }

  public void _sdkf()
    throws IOException
  {
    this._sdke.close();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkrb
 * JD-Core Version:    0.6.2
 */