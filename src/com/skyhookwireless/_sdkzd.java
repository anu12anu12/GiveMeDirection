package com.skyhookwireless;

import java.util.AbstractList;

public final class _sdkzd<T> extends AbstractList<T>
{
  private static final String[] z;
  private int _sdka;
  private int _sdkb;
  private final Object[] _sdkc;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    int j = "\024.!\021".toCharArray();
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
          i8 = 107;
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
      Object localObject2 = "\024~sEK]~<j[\030".toCharArray();
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
          i14 = 107;
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
        i8 = 52;
        break;
        i8 = 16;
        break;
        i8 = 28;
        break;
        i8 = 49;
        break;
        i14 = 52;
        continue;
        i14 = 16;
        continue;
        i14 = 28;
        continue;
        i14 = 49;
      }
      Object localObject1 = null;
    }
  }

  public _sdkzd(int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    this._sdkc = arrayOfObject;
    this._sdka = 0;
    int i = this._sdkc.length;
    this._sdkb = i;
  }

  public T _sdka()
  {
    Object[] arrayOfObject = this._sdkc;
    int i = this._sdkb;
    int j = this._sdka;
    int k = i + j;
    int m = this._sdkc.length;
    int n = k % m;
    return arrayOfObject[n];
  }

  public int _sdkb()
  {
    return this._sdkc.length;
  }

  public boolean add(T paramT)
  {
    int i = this._sdkb + -1;
    this._sdkb = i;
    if (i < 0)
    {
      int j = this._sdkc.length + -1;
      this._sdkb = j;
    }
    Object[] arrayOfObject = this._sdkc;
    int k = this._sdkb;
    arrayOfObject[k] = paramT;
    int m = this._sdka;
    int n = this._sdkc.length;
    if (m < n)
    {
      int i1 = this._sdka + 1;
      this._sdka = i1;
    }
    return true;
  }

  public void clear()
  {
    boolean bool = _sdkpc._sdkb;
    int i = 0;
    do
    {
      int j = this._sdkc.length;
      if (i >= j)
        break;
      this._sdkc[i] = null;
      i += 1;
    }
    while (!bool);
    this._sdka = 0;
    int k = this._sdkc.length;
    this._sdkb = k;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = _sdkpc._sdkb;
    if (paramObject == null);
    while (true)
    {
      return bool1;
      try
      {
        paramObject = (_sdkzd)paramObject;
        int i = this._sdka;
        int j = paramObject._sdka;
        if (i != j)
        {
          int k = 0;
          do
          {
            int m = this._sdka;
            if (k >= m)
              break label92;
            Object localObject1 = get(k);
            Object localObject2 = paramObject.get(k);
            boolean bool3 = localObject1.equals(localObject2);
            if (!bool3)
              break;
            k += 1;
          }
          while (!bool2);
          label92: bool1 = true;
        }
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  public T get(int paramInt)
  {
    int i = this._sdka;
    if ((paramInt >= i) || (paramInt < 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append(paramInt);
      String str1 = z[0];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      int j = this._sdka;
      String str2 = j;
      throw new IndexOutOfBoundsException(str2);
    }
    Object[] arrayOfObject = this._sdkc;
    int k = this._sdkb + paramInt;
    int m = this._sdkc.length;
    int n = k % m;
    return arrayOfObject[n];
  }

  public int hashCode()
  {
    if (this._sdka <= 0);
    Object[] arrayOfObject;
    int j;
    for (int i = 0; ; i = arrayOfObject[j].hashCode())
    {
      return i;
      arrayOfObject = this._sdkc;
      j = this._sdkb;
    }
  }

  public T set(int paramInt, T paramT)
  {
    int i = this._sdka;
    if ((paramInt > i) || (paramInt < 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append(paramInt);
      String str1 = z[1];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      int j = this._sdka;
      String str2 = j + "]";
      throw new IndexOutOfBoundsException(str2);
    }
    int k = this._sdkb + paramInt;
    int m = this._sdkc.length;
    int n = k % m;
    Object localObject = this._sdkc[n];
    this._sdkc[n] = paramT;
    return localObject;
  }

  public int size()
  {
    return this._sdka;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkzd
 * JD-Core Version:    0.6.2
 */