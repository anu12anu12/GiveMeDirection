package com.skyhookwireless.wps;

public enum WPSContinuation
{
  private static final String[] z;

  static
  {
    String[] arrayOfString = new String[2];
    Object localObject1 = "\037wMC\032\034hN".toCharArray();
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
          i2 = 73;
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
      Object localObject4 = "\037wMC\n\007iJU\007\035b".toCharArray();
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
            i8 = 73;
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
        z = arrayOfString;
        String str3 = z[1];
        WPS_CONTINUE = new WPSContinuation(str3, 0);
        String str4 = z[0];
        WPS_STOP = new WPSContinuation(str4, 1);
        WPSContinuation[] arrayOfWPSContinuation = new WPSContinuation[2];
        WPSContinuation localWPSContinuation1 = WPS_CONTINUE;
        arrayOfWPSContinuation[0] = localWPSContinuation1;
        WPSContinuation localWPSContinuation2 = WPS_STOP;
        arrayOfWPSContinuation[1] = localWPSContinuation2;
        _sdka = arrayOfWPSContinuation;
        return;
        i2 = 72;
        break;
        i2 = 39;
        break;
        i2 = 30;
        break;
        i2 = 28;
        break;
        i8 = 72;
        break label232;
        i8 = 39;
        break label232;
        i8 = 30;
        break label232;
        i8 = 28;
        break label232;
        i5 = 0;
      }
      j = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.WPSContinuation
 * JD-Core Version:    0.6.2
 */