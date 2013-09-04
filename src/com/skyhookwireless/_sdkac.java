package com.skyhookwireless;

final class _sdkac extends _sdkzb
{
  private static final String z;

  static
  {
    Object localObject1 = "x.\f\020\rb>\f\031\002~4\016\005\r{:\016\035\025s)".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    Object localObject3;
    int n;
    label31: int i1;
    int i2;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      int m = i;
      localObject3 = localObject1;
      n = m;
      i1 = localObject3[j];
      switch (k % 5)
      {
      default:
        i2 = 82;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i3 = (char)(i2 ^ i1);
      localObject3[j] = i3;
      j = k + 1;
      if (n == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = n;
        break label31;
      }
      i = n;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i2 = 54;
      continue;
      i2 = 123;
      continue;
      i2 = 64;
      continue;
      i2 = 92;
    }
  }

  _sdkac()
    throws _sdkm
  {
  }

  protected _sdkzb _sdka(_sdkt param_sdkt)
    throws _sdkm
  {
    return this;
  }

  public String _sdka()
  {
    return z;
  }

  public String _sdkb()
  {
    return null;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkac
 * JD-Core Version:    0.6.2
 */