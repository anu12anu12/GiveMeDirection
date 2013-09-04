package com.skyhookwireless;

import java.util.Collections;
import java.util.List;

final class _sdkbd extends _sdkad
{
  private static final String[] z;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    int j = "}Os\t\001rY|��\022vHp\b\033g_m\032\037w[o\021\033a".toCharArray();
    int k = j.length;
    int i1;
    int i8;
    int n;
    if (k <= 1)
    {
      int m = 0;
      i1 = j;
      int i2 = m;
      int i4 = k;
      int i5 = j;
      int i6 = i4;
      while (true)
      {
        int i7 = i5[m];
        switch (i2 % 5)
        {
        default:
          i8 = 94;
          int i9 = (char)(i8 ^ i7);
          i5[m] = i9;
          n = i2 + 1;
          if (i6 != 0)
            break label129;
          i5 = i1;
          int i3 = n;
          n = i6;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: k = i6;
      j = i1;
    }
    while (k <= n)
    {
      String str1 = new String(j).intern();
      arrayOfString[0] = str1;
      Object localObject2 = "P{Qb*\023uO 0\023Tj\t\022l[|\006\033_m\n\023vNz\027\001r^~\025\nvH".toCharArray();
      int i10 = localObject2.length;
      label177: Object localObject3;
      int i12;
      label196: int i13;
      int i14;
      if (i10 <= 1)
      {
        localObject1 = localObject2;
        i1 = i;
        int i11 = i10;
        localObject3 = localObject2;
        i12 = i11;
        i13 = localObject3[i];
        switch (i1 % 5)
        {
        default:
          i14 = 94;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      while (true)
      {
        int i15 = (char)(i14 ^ i13);
        localObject3[i] = i15;
        i = i1 + 1;
        if (i12 == 0)
        {
          localObject3 = localObject1;
          int i16 = i;
          i = i12;
          break label196;
        }
        i10 = i12;
        localObject2 = localObject1;
        if (i10 > i)
          break label177;
        String str2 = new String((char[])localObject2).intern();
        arrayOfString[1] = str2;
        z = arrayOfString;
        return;
        i8 = 51;
        break;
        i8 = 26;
        break;
        i8 = 63;
        break;
        i8 = 69;
        break;
        i14 = 51;
        continue;
        i14 = 26;
        continue;
        i14 = 63;
        continue;
        i14 = 69;
      }
      Object localObject1 = null;
    }
  }

  protected _sdkad _sdka(_sdkt param_sdkt)
  {
    return this;
  }

  public String _sdka()
  {
    return z[0];
  }

  public void _sdkb()
    throws _sdkl
  {
    String str = z[1];
    throw new _sdkl(str);
  }

  public void _sdkc()
  {
  }

  public List<_sdkwb> _sdkd()
  {
    return Collections.emptyList();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkbd
 * JD-Core Version:    0.6.2
 */