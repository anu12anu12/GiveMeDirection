package com.skyhookwireless;

import android.content.Context;

public class _sdkq
  implements _sdkt
{
  private static final String z;
  private final Context _sdka;

  static
  {
    Object localObject1 = "\020x4go\030<bEl\037,'~wQ11&q\024)7oq\024<".toCharArray();
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
        i2 = 3;
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
      i2 = 113;
      continue;
      i2 = 88;
      continue;
      i2 = 66;
      continue;
      i2 = 6;
    }
  }

  public _sdkq(Context paramContext)
  {
    if (paramContext == null)
    {
      String str = z;
      throw new NullPointerException(str);
    }
    if (paramContext.getApplicationContext() != null)
    {
      Context localContext = paramContext.getApplicationContext();
      this._sdka = localContext;
      if (!bool);
    }
    else
    {
      this._sdka = paramContext;
    }
    if (!_sdkhb._sdkd)
      return;
    if (bool);
    for (bool = false; ; bool = true)
    {
      _sdkec._sdkc = bool;
      return;
    }
  }

  public Context _sdka()
  {
    return this._sdka;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkq
 * JD-Core Version:    0.6.2
 */