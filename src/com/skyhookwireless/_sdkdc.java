package com.skyhookwireless;

public final class _sdkdc
{
  public static final String COMPRESSED_FILE_READER_TEST_SCRIPT;
  public static final String LOCATION_DETERMINATION_ALGORITHM_TEST_SCRIPT;
  public static final String POWER_MANAGER_TEST_SCRIPT;
  public static final String TILING_TEST_FOLDER;
  public static boolean _sdka;

  static
  {
    Object localObject1 = 0;
    Object localObject2 = "1\0274Z1l��u?}\005$P?p 5M5l\t9W1j\r?W\021r\003?K9j\f=m5m\020~M(j".toCharArray();
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
          i2 = 80;
          int i3 = (char)(i2 ^ i1);
          localObject4[j] = i3;
          j = k + 1;
          if (n != 0)
            break label117;
          localObject4 = localObject3;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label117: i = n;
      localObject2 = localObject3;
    }
    while (i <= j)
    {
      LOCATION_DETERMINATION_ALGORITHM_TEST_SCRIPT = new String((char[])localObject2).intern();
      Object localObject5 = "1\0274Z1l��x>z\026?P4]\013=I\"{\027#\\4X\r<\\\002{\0054\\\"J\001#M~j\034$".toCharArray();
      int i4 = localObject5.length;
      int i5;
      label163: int i8;
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
            i8 = 80;
            label228: int i9 = (char)(i8 ^ i1);
            localObject6[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label269;
            localObject6 = localObject3;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label269: i4 = i7;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i5)
          break label163;
        COMPRESSED_FILE_READER_TEST_SCRIPT = new String((char[])localObject5).intern();
        Object localObject7 = "1\0274Z1l��i?i\001\"t1p\0057\\\"J\001#M~j\034$".toCharArray();
        int i11 = localObject7.length;
        label320: int i16;
        label384: int i13;
        if (i11 <= 1)
        {
          int i12 = 0;
          localObject3 = localObject7;
          k = i12;
          int i14 = i11;
          Object localObject9 = localObject7;
          int i15 = i14;
          while (true)
          {
            i1 = localObject9[i12];
            switch (k % 5)
            {
            default:
              i16 = 80;
              int i17 = (char)(i16 ^ i1);
              localObject9[i12] = i17;
              i13 = k + 1;
              if (i15 != 0)
                break label425;
              localObject9 = localObject3;
              int i18 = i13;
              i13 = i15;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label425: i11 = i15;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i11 > i13)
            break label320;
          POWER_MANAGER_TEST_SCRIPT = new String((char[])localObject7).intern();
          Object localObject10 = "1\0274Z1l��f\017j\r<P>y;$\\#j".toCharArray();
          Object localObject11 = localObject10.length;
          label473: Object localObject13;
          Object localObject14;
          label492: int i19;
          int i20;
          if (localObject11 <= 1)
          {
            localObject8 = localObject10;
            localObject3 = localObject1;
            Object localObject12 = localObject11;
            localObject13 = localObject10;
            localObject14 = localObject12;
            i19 = localObject13[localObject1];
            switch (localObject3 % 5)
            {
            default:
              i20 = 80;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          while (true)
          {
            int i21 = (char)(i20 ^ i19);
            localObject13[localObject1] = i21;
            localObject1 = localObject3 + 1;
            if (localObject14 == 0)
            {
              localObject13 = localObject8;
              int i22 = localObject1;
              localObject1 = localObject14;
              break label492;
            }
            localObject11 = localObject14;
            localObject10 = localObject8;
            if (localObject11 > localObject1)
              break label473;
            TILING_TEST_FOLDER = new String((char[])localObject10).intern();
            return;
            i2 = 30;
            break;
            i2 = 100;
            break;
            i2 = 80;
            break;
            i2 = 57;
            break;
            i8 = 30;
            break label228;
            i8 = 100;
            break label228;
            i8 = 80;
            break label228;
            i8 = 57;
            break label228;
            i16 = 30;
            break label384;
            i16 = 100;
            break label384;
            i16 = 80;
            break label384;
            i16 = 57;
            break label384;
            i20 = 30;
            continue;
            i20 = 100;
            continue;
            i20 = 80;
            continue;
            i20 = 57;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkdc
 * JD-Core Version:    0.6.2
 */