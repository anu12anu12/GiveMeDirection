package com.skyhookwireless.wps;

import com.skyhookwireless._sdktd;
import com.skyhookwireless._sdkud;
import java.util.Iterator;
import java.util.Map.Entry;

class _sdksb
  implements Cache.Finder<_sdkzb, _sdkib>
{
  static final boolean _sdkb;
  private final float _sdka;
  final _sdkqb _sdkc;

  static
  {
    if (!_sdkqb.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      _sdkb = bool;
      return;
    }
  }

  private _sdksb(_sdkqb param_sdkqb, float paramFloat)
  {
    this._sdka = paramFloat;
  }

  _sdksb(_sdkqb param_sdkqb, float paramFloat, _sdkrb param_sdkrb)
  {
    this(param_sdkqb, paramFloat);
  }

  public Map.Entry<_sdkzb, _sdkib> call(Iterator<Map.Entry<_sdkzb, _sdkib>> paramIterator, _sdkzb param_sdkzb)
  {
    int i = Location._sdki;
    if (!_sdkb)
    {
      float f1 = this._sdka;
      if ((0.0F >= f1) || (this._sdka >= 1.0D))
        throw new AssertionError();
    }
    float f2 = this._sdka;
    _sdkud local_sdkud1 = _sdkqb._sdkb(param_sdkzb, f2);
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    _sdkud local_sdkud2 = _sdkud._sdka(localInteger1, localInteger2);
    Integer localInteger3 = Integer.valueOf(2147483647);
    Integer localInteger4 = Integer.valueOf(2147483647);
    _sdkud local_sdkud3 = _sdkud._sdka(localInteger3, localInteger4);
    int j = 0;
    Object localObject = local_sdkud3;
    int k;
    _sdkud local_sdkud4;
    while (true)
      if (paramIterator.hasNext())
      {
        k = (Map.Entry)paramIterator.next();
        _sdkzb local_sdkzb = (_sdkzb)k.getKey();
        local_sdkud4 = _sdkqb._sdkb(param_sdkzb, local_sdkzb);
        if (_sdkqb._sdkb(local_sdkud1, local_sdkud4))
        {
          local_sdkud4 = _sdkqb._sdkb(local_sdkud4);
          if (local_sdkud4._sdka((_sdktd)localObject) <= 0)
          {
            j = local_sdkud4.equals(local_sdkud2);
            if (j == 0)
              break;
          }
        }
      }
    while (true)
    {
      return k;
      if (i == 0)
      {
        int m = k;
        localObject = local_sdkud4;
        break;
        k = j;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdksb
 * JD-Core Version:    0.6.2
 */