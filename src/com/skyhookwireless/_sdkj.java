package com.skyhookwireless;

 enum _sdkj
{
  private static final _sdkj[] _sdka;
  private static final String[] z;

  static
  {
    String[] arrayOfString = new String[3];
    Object localObject1 = "=/j\016\026".toCharArray();
    int i = localObject1.length;
    int j;
    Object localObject2;
    int k;
    int i1;
    int i2;
    if (i <= 1)
    {
      j = 0;
      localObject2 = localObject1;
      k = j;
      int m = i;
      Object localObject3 = localObject1;
      int n = m;
      while (true)
      {
        i1 = localObject3[j];
        switch (k % 5)
        {
        default:
          i2 = 68;
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
      label117: i = n;
      localObject1 = localObject2;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject1).intern();
      arrayOfString[0] = str1;
      Object localObject4 = "<2v\004".toCharArray();
      int i4 = localObject4.length;
      int i5;
      label167: int i8;
      if (i4 <= 1)
      {
        i5 = 0;
        localObject2 = localObject4;
        k = i5;
        int i6 = i4;
        Object localObject5 = localObject4;
        int i7 = i6;
        while (true)
        {
          i1 = localObject5[i5];
          switch (k % 5)
          {
          default:
            i8 = 68;
            label232: int i9 = (char)(i8 ^ i1);
            localObject5[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label273;
            localObject5 = localObject2;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label273: i4 = i7;
        localObject4 = localObject2;
      }
      while (true)
      {
        if (i4 > i5)
          break label167;
        String str2 = new String((char[])localObject4).intern();
        arrayOfString[1] = str2;
        Object localObject6 = ":(k\030".toCharArray();
        int i11 = localObject6.length;
        int i12;
        label328: int i15;
        if (i11 <= 1)
        {
          i12 = 0;
          localObject2 = localObject6;
          k = i12;
          int i13 = i11;
          Object localObject7 = localObject6;
          int i14 = i13;
          while (true)
          {
            i1 = localObject7[i12];
            switch (k % 5)
            {
            default:
              i15 = 68;
              label392: int i16 = (char)(i15 ^ i1);
              localObject7[i12] = i16;
              i12 = k + 1;
              if (i14 != 0)
                break label433;
              localObject7 = localObject2;
              int i17 = i12;
              i12 = i14;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label433: i11 = i14;
          localObject6 = localObject2;
        }
        while (true)
        {
          if (i11 > i12)
            break label328;
          String str3 = new String((char[])localObject6).intern();
          arrayOfString[2] = str3;
          z = arrayOfString;
          String str4 = z[1];
          DONE = new _sdkj(str4, 0);
          String str5 = z[2];
          BUSY = new _sdkj(str5, 1);
          String str6 = z[0];
          ERROR = new _sdkj(str6, 2);
          _sdkj[] arrayOf_sdkj = new _sdkj[3];
          _sdkj local_sdkj1 = DONE;
          arrayOf_sdkj[0] = local_sdkj1;
          _sdkj local_sdkj2 = BUSY;
          arrayOf_sdkj[1] = local_sdkj2;
          _sdkj local_sdkj3 = ERROR;
          arrayOf_sdkj[2] = local_sdkj3;
          _sdka = arrayOf_sdkj;
          return;
          i2 = 120;
          break;
          i2 = 125;
          break;
          i2 = 56;
          break;
          i2 = 65;
          break;
          i8 = 120;
          break label232;
          i8 = 125;
          break label232;
          i8 = 56;
          break label232;
          i8 = 65;
          break label232;
          i15 = 120;
          break label392;
          i15 = 125;
          break label392;
          i15 = 56;
          break label392;
          i15 = 65;
          break label392;
          i12 = 0;
        }
        i5 = 0;
      }
      j = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkj
 * JD-Core Version:    0.6.2
 */