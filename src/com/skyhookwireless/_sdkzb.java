package com.skyhookwireless;

public abstract class _sdkzb
{
  public static final _sdkzb NULL_TELEPHONY_MANAGER;
  private static _sdkzb _sdka;
  static final boolean _sdkb;
  public static boolean _sdkc;
  private static final String z;

  static
  {
    _sdkac local_sdkac = null;
    Object localObject1 = "\002xc3\003Ajh`W\021kb`\030\025`}q\004".toCharArray();
    int i = localObject1.length;
    int j;
    int i2;
    if (i <= local_sdkac)
    {
      j = 0;
      label117: label123: 
      do
      {
        Object localObject2 = localObject1;
        int k = j;
        int m = i;
        Object localObject3 = localObject1;
        int n = m;
        while (true)
        {
          int i1 = localObject3[j];
          switch (k % 5)
          {
          default:
            i2 = 119;
            int i3 = (char)(i2 ^ i1);
            localObject3[j] = i3;
            j = k + 1;
            if (n != 0)
              break label117;
            localObject3 = localObject2;
            k = j;
            j = n;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        i = n;
        localObject1 = localObject2;
      }
      while (i > j);
      z = new String((char[])localObject1).intern();
      if (!_sdkzb.class.desiredAssertionStatus())
        _sdkb = local_sdkac;
    }
    while (true)
    {
      try
      {
        local_sdkac = new _sdkac();
        NULL_TELEPHONY_MANAGER = local_sdkac;
        _sdka = null;
        return;
        local_sdkac = null;
      }
      catch (_sdkm local_sdkm)
      {
        if (_sdkb)
          break label225;
      }
      throw new AssertionError();
      i2 = 97;
      break;
      i2 = 25;
      break;
      i2 = 13;
      break;
      i2 = 20;
      break;
      j = 0;
      break label123;
      label225: local_sdkac = null;
    }
  }

  _sdkzb()
    throws _sdkm
  {
  }

  public static void _sdka(_sdkzb param_sdkzb)
  {
    String str = z;
    throw new UnsupportedOperationException(str);
  }

  public static _sdkzb _sdkb(_sdkt param_sdkt)
    throws _sdkm
  {
    if (_sdka == null);
    for (Object localObject = new _sdkbc(param_sdkt); ; localObject = _sdka._sdka(param_sdkt))
      return localObject;
  }

  protected abstract _sdkzb _sdka(_sdkt param_sdkt)
    throws _sdkm;

  public abstract String _sdka();

  public abstract String _sdkb();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkzb
 * JD-Core Version:    0.6.2
 */