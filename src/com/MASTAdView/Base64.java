package com.MASTAdView;

public class Base64
{
  private static char[] map1 = new char[64];
  private static byte[] map2;

  static
  {
    int i = 65;
    int j = 0;
    int k;
    label21: int m;
    label30: int i2;
    label81: int i4;
    if (i > 90)
    {
      k = 97;
      if (k <= 122)
        break label131;
      m = 48;
      if (m <= 57)
        break label157;
      char[] arrayOfChar1 = map1;
      int n = j + 1;
      arrayOfChar1[j] = '+';
      char[] arrayOfChar2 = map1;
      int i1 = n + 1;
      arrayOfChar2[n] = '/';
      map2 = new byte[''];
      i2 = 0;
      int i3 = map2.length;
      if (i2 < i3)
        break label183;
      i4 = 0;
    }
    while (true)
    {
      if (i4 >= 64)
      {
        return;
        char[] arrayOfChar3 = map1;
        int i5 = j + 1;
        arrayOfChar3[j] = i;
        i = (char)(i + 1);
        j = i5;
        break;
        label131: char[] arrayOfChar4 = map1;
        int i6 = j + 1;
        arrayOfChar4[j] = k;
        k = (char)(k + 1);
        j = i6;
        break label21;
        label157: char[] arrayOfChar5 = map1;
        int i7 = j + 1;
        arrayOfChar5[j] = m;
        m = (char)(m + 1);
        j = i7;
        break label30;
        label183: map2[i2] = -1;
        i2 += 1;
        break label81;
      }
      byte[] arrayOfByte = map2;
      int i8 = map1[i4];
      int i9 = (byte)i4;
      arrayOfByte[i8] = i9;
      i4 += 1;
    }
  }

  public static byte[] decode(String paramString)
  {
    return decode(paramString.toCharArray());
  }

  public static byte[] decode(char[] paramArrayOfChar)
  {
    int i = paramArrayOfChar.length;
    if (i % 4 != 0)
      throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    int k;
    int m;
    do
    {
      i += -1;
      if (i <= 0)
        break;
      int j = i + -1;
      k = paramArrayOfChar[j];
      m = 61;
    }
    while (k == m);
    int n = i * 3 / 4;
    byte[] arrayOfByte = new byte[n];
    int i1 = 0;
    int i2 = 0;
    if (i2 >= i)
      return arrayOfByte;
    int i3 = i2 + 1;
    int i4 = paramArrayOfChar[i2];
    int i5 = i3 + 1;
    int i6 = paramArrayOfChar[i3];
    int i8;
    int i9;
    int i10;
    if (i5 < i)
    {
      int i7 = i5 + 1;
      i8 = paramArrayOfChar[i5];
      i5 = i7;
      if (i5 >= i)
        break label200;
      i9 = i5 + 1;
      i10 = paramArrayOfChar[i5];
    }
    while (true)
    {
      int i11 = 127;
      if (i4 <= i11)
      {
        int i12 = 127;
        if (i6 <= i12)
        {
          int i13 = 127;
          if (i8 <= i13)
          {
            int i14 = 127;
            if (i10 <= i14)
              break label211;
          }
        }
      }
      throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
      i8 = 65;
      break;
      label200: i10 = 65;
      i9 = i5;
    }
    label211: int i15 = map2[i4];
    int i16 = map2[i6];
    int i17 = map2[i8];
    int i18 = map2[i10];
    if ((i15 < 0) || (i16 < 0) || (i17 < 0) || (i18 < 0))
    {
      String str = "Illegal character in Base64 encoded data. " + i4;
      throw new IllegalArgumentException(str);
    }
    int i19 = i15 << 2;
    int i20 = i16 >>> 4;
    int i21 = i19 | i20;
    int i22 = (i16 & 0xF) << 4;
    int i23 = i17 >>> 2;
    int i24 = i22 | i23;
    int i25 = (i17 & 0x3) << 6 | i18;
    int i26 = i1 + 1;
    int i27 = (byte)i21;
    arrayOfByte[i1] = i27;
    int i28 = i26;
    int i29 = n;
    if (i28 < i29)
    {
      i1 = i26 + 1;
      int i30 = (byte)i24;
      arrayOfByte[i26] = i30;
    }
    while (true)
    {
      int i31 = i1;
      int i32 = n;
      if (i31 < i32)
      {
        int i33 = i1 + 1;
        int i34 = (byte)i25;
        arrayOfByte[i1] = i34;
        i1 = i33;
        i2 = i9;
        break;
      }
      i2 = i9;
      break;
      i1 = i26;
    }
  }

  public static String decodeString(String paramString)
  {
    byte[] arrayOfByte = decode(paramString);
    return new String(arrayOfByte);
  }

  public static char[] encode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return encode(paramArrayOfByte, i);
  }

  public static char[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (paramInt * 4 + 2) / 3;
    char[] arrayOfChar = new char[(paramInt + 2) / 3 * 4];
    int j = 0;
    int k = 0;
    int m = paramInt;
    if (k >= m)
      return arrayOfChar;
    int n = k + 1;
    int i1 = paramArrayOfByte[k] & 0xFF;
    int i2 = paramInt;
    int i3;
    int i4;
    label78: int i6;
    int i7;
    label104: int i15;
    int i20;
    label215: int i21;
    if (n < i2)
    {
      i3 = n + 1;
      i4 = paramArrayOfByte[n] & 0xFF;
      int i5 = paramInt;
      if (i3 >= i5)
        break label270;
      i6 = i3 + 1;
      i7 = paramArrayOfByte[i3] & 0xFF;
      int i8 = i1 >>> 2;
      int i9 = (i1 & 0x3) << 4;
      int i10 = i4 >>> 4;
      int i11 = i9 | i10;
      int i12 = (i4 & 0xF) << 2;
      int i13 = i7 >>> 6;
      int i14 = i12 | i13;
      i15 = i7 & 0x3F;
      int i16 = j + 1;
      int i17 = map1[i8];
      arrayOfChar[j] = i17;
      int i18 = i16 + 1;
      int i19 = map1[i11];
      arrayOfChar[i16] = i19;
      if (i18 >= i)
        break label280;
      i20 = map1[i14];
      arrayOfChar[i18] = i20;
      i21 = i18 + 1;
      if (i21 >= i)
        break label287;
    }
    label270: label280: label287: for (int i22 = map1[i15]; ; i22 = 61)
    {
      arrayOfChar[i21] = i22;
      j = i21 + 1;
      k = i6;
      break;
      i4 = 0;
      i3 = n;
      break label78;
      i7 = 0;
      i6 = i3;
      break label104;
      i20 = 61;
      break label215;
    }
  }

  public static String encodeString(String paramString)
  {
    char[] arrayOfChar = encode(paramString.getBytes());
    return new String(arrayOfChar);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.Base64
 * JD-Core Version:    0.6.2
 */