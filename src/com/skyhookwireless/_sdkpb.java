package com.skyhookwireless;

public abstract class _sdkpb
{
  private static _sdkpb _sdka;
  public static boolean _sdkb;
  private static final String z;

  static
  {
    Object localObject1 = "\034\022\016oV_��\005<\002\017\001\017<M\013\n\020-Q".toCharArray();
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
        i2 = 34;
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
      _sdka = null;
      return;
      i2 = 127;
      continue;
      i2 = 115;
      continue;
      i2 = 96;
      continue;
      i2 = 72;
    }
  }

  public static void _sdka(_sdkpb param_sdkpb)
  {
    String str = z;
    throw new UnsupportedOperationException(str);
  }

  public static _sdkpb _sdkb(_sdkt param_sdkt)
  {
    if (_sdka == null);
    for (Object localObject = new _sdkqb(param_sdkt); ; localObject = _sdka._sdka(param_sdkt))
      return localObject;
  }

  protected abstract _sdkpb _sdka(_sdkt param_sdkt);

  public abstract String _sdka();

  public abstract boolean _sdka(String paramString);

  public abstract boolean _sdka(String paramString1, String paramString2);

  public abstract String _sdkb(String paramString);

  public abstract void _sdkb();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkpb
 * JD-Core Version:    0.6.2
 */