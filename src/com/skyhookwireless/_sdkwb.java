package com.skyhookwireless;

public class _sdkwb
  implements _sdkbb
{
  private static final String[] z;
  public final double _magnitude;
  private final _sdkec _sdka;
  final _sdkad _sdkb;
  public final float _x;
  public final float _y;
  public final float _z;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = "*~".toCharArray();
    int i = localObject2.length;
    int j;
    Object localObject3;
    int k;
    int i1;
    int i2;
    if (i <= 1)
    {
      j = 0;
      localObject3 = localObject2;
      k = j;
      int m = i;
      Object localObject4 = localObject2;
      int n = m;
      while (true)
      {
        i1 = localObject4[j];
        switch (k % 5)
        {
        default:
          i2 = 52;
          int i3 = (char)(i2 ^ i1);
          localObject4[j] = i3;
          j = k + 1;
          if (n != 0)
            break label129;
          localObject4 = localObject3;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: i = n;
      localObject2 = localObject3;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject2).intern();
      arrayOfString[0] = str1;
      Object localObject5 = "k-".toCharArray();
      int i4 = localObject5.length;
      int i5;
      label180: int i8;
      if (i4 <= 1)
      {
        i5 = 0;
        localObject3 = localObject5;
        k = i5;
        int i6 = i4;
        Object localObject6 = localObject5;
        int i7 = i6;
        while (true)
        {
          i1 = localObject6[i5];
          switch (k % 5)
          {
          default:
            i8 = 52;
            label244: int i9 = (char)(i8 ^ i1);
            localObject6[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label285;
            localObject6 = localObject3;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i4 = i7;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i5)
          break label180;
        String str2 = new String((char[])localObject5).intern();
        arrayOfString[1] = str2;
        int i11 = 2;
        Object localObject7 = "gl6V\t".toCharArray();
        int i12 = localObject7.length;
        label343: int i18;
        label408: int i14;
        if (i12 <= 1)
        {
          int i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i15 = i12;
          Object localObject9 = localObject7;
          int i16 = i15;
          while (true)
          {
            int i17 = localObject9[i13];
            switch (k % 5)
            {
            default:
              i18 = 52;
              int i19 = (char)(i18 ^ i17);
              localObject9[i13] = i19;
              i14 = k + 1;
              if (i16 != 0)
                break label449;
              localObject9 = localObject3;
              int i20 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i12 = i16;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i14)
            break label343;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i21 = 3;
          Object localObject10 = "n-<RS)d%FP\"0".toCharArray();
          Object localObject11 = localObject10.length;
          label505: Object localObject13;
          Object localObject14;
          label524: int i22;
          if (localObject11 <= 1)
          {
            localObject8 = localObject10;
            localObject3 = localObject1;
            Object localObject12 = localObject11;
            localObject13 = localObject10;
            localObject14 = localObject12;
            i11 = localObject13[localObject1];
            switch (localObject3 % 5)
            {
            default:
              i22 = 52;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          while (true)
          {
            int i23 = (char)(i22 ^ i11);
            localObject13[localObject1] = i23;
            localObject1 = localObject3 + 1;
            if (localObject14 == 0)
            {
              localObject13 = localObject8;
              int i24 = localObject1;
              localObject1 = localObject14;
              break label524;
            }
            localObject11 = localObject14;
            localObject10 = localObject8;
            if (localObject11 > localObject1)
              break label505;
            String str4 = new String((char[])localObject10).intern();
            arrayOfString[i21] = str4;
            z = arrayOfString;
            return;
            i2 = 71;
            break;
            i2 = 13;
            break;
            i2 = 81;
            break;
            i2 = 51;
            break;
            i8 = 71;
            break label244;
            i8 = 13;
            break label244;
            i8 = 81;
            break label244;
            i8 = 51;
            break label244;
            i18 = 71;
            break label408;
            i18 = 13;
            break label408;
            i18 = 81;
            break label408;
            i18 = 51;
            break label408;
            i22 = 71;
            continue;
            i22 = 13;
            continue;
            i22 = 81;
            continue;
            i22 = 51;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  _sdkwb(_sdkad param_sdkad, float paramFloat1, float paramFloat2, float paramFloat3, _sdkec param_sdkec)
  {
    this._sdka = param_sdkec;
    this._x = paramFloat1;
    this._y = paramFloat2;
    this._z = paramFloat3;
    float f1 = paramFloat1 * paramFloat1;
    float f2 = paramFloat2 * paramFloat2;
    float f3 = f1 + f2;
    float f4 = paramFloat3 * paramFloat3;
    double d = Math.sqrt(f3 + f4);
    this._magnitude = d;
    if (!_sdkhb._sdkd)
      return;
    if (bool);
    for (bool = false; ; bool = true)
    {
      _sdkad._sdkd = bool;
      return;
    }
  }

  public float _sdka()
  {
    return this._x;
  }

  public float _sdkb()
  {
    return this._y;
  }

  public float _sdkc()
  {
    return this._z;
  }

  public double _sdkd()
  {
    return this._magnitude;
  }

  public _sdkec getAge()
  {
    return this._sdka;
  }

  public String toString()
  {
    boolean bool1 = false;
    boolean bool2 = _sdkad._sdkd;
    StringBuilder localStringBuilder1 = new StringBuilder().append("(");
    float f1 = this._x;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(f1);
    String str1 = z[1];
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str1);
    float f2 = this._y;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(f2);
    String str2 = z[1];
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str2);
    float f3 = this._z;
    StringBuilder localStringBuilder6 = localStringBuilder5.append(f3);
    String str3 = z[3];
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str3);
    double d = this._magnitude;
    StringBuilder localStringBuilder8 = localStringBuilder7.append(d);
    String str4 = z[2];
    StringBuilder localStringBuilder9 = localStringBuilder8.append(str4);
    long l = this._sdka._sdka();
    StringBuilder localStringBuilder10 = localStringBuilder9.append(l);
    String str5 = z[bool1];
    String str6 = str5;
    if (bool2)
      if (!_sdkhb._sdkd)
        break label196;
    while (true)
    {
      _sdkhb._sdkd = bool1;
      return str6;
      label196: bool1 = true;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkwb
 * JD-Core Version:    0.6.2
 */