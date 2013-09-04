package com.skyhookwireless;

import java.util.List;

final class _sdkjd
  implements _sdkld
{
  static final boolean _sdka;
  final List _sdkb;
  final List _sdkc;
  public int i = 0;

  static
  {
    if (!_sdkhd.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdka = bool;
      return;
    }
  }

  public void _sdka(int paramInt1, int paramInt2)
  {
  }

  public void _sdkb(int paramInt1, int paramInt2)
  {
  }

  public void _sdkc(int paramInt1, int paramInt2)
  {
    if ((!_sdka) && ((this.i > paramInt1) || (this.i > paramInt2)))
      throw new AssertionError();
    List localList1 = this._sdkb;
    int j = this.i;
    Object localObject1 = this._sdkb.get(paramInt1);
    Object localObject2 = localList1.set(j, localObject1);
    List localList2 = this._sdkc;
    int k = this.i;
    Object localObject3 = this._sdkc.get(paramInt2);
    Object localObject4 = localList2.set(k, localObject3);
    int m = this.i + 1;
    this.i = m;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkjd
 * JD-Core Version:    0.6.2
 */