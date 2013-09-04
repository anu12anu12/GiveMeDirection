package com.skyhookwireless;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class _sdktb
{
  protected static final _sdkhb _sdka = _sdkhb._sdkb(_sdktb.class);
  private static _sdktb _sdkb = null;
  private static String _sdkc = z(z("5+\035{\rgpFj\0164q\032`\00750\006`\t4-\fg\033.,Gh\0210p\036{\ro"));
  public static int _sdkd;
  private static final String[] z;

  static
  {
    String[] arrayOfString = new String[11];
    String str1 = z(z("\034+\035n\023-+I\021},\f^)7\f+\r8-\037n\f\b-\005+\033,*\bg^)0Ih\013/-\fe\ns:`\027-/��e\031"));
    arrayOfString[0] = str1;
    String str2 = z(z("-0\032V"));
    arrayOfString[1] = str2;
    String str3 = z(z("q\004"));
    arrayOfString[2] = str3;
    String str4 = z(z("<=\006y\nuvIe\021)\032~\016-0\033\0339"));
    arrayOfString[3] = str4;
    String str5 = z(z("::\035#"));
    arrayOfString[4] = str5;
    String str6 = z(z("5+\035{\r"));
    arrayOfString[5] = str6;
    String str7 = z(z(">>\007,\n},\f^--\006\021)&\031n\r"));
    arrayOfString[6] = str7;
    String str8 = z(z("/:\032{\0213,\f+\03521\035n\020)\035r\0168eI"));
    arrayOfString[7] = str8;
    String str9 = z(z("/:\032{\0213,\f+\03521\035n\020)eI"));
    arrayOfString[8] = str9;
    String str10 = z(z("/:\032{\0213,\f+\0352;\f1^"));
    arrayOfString[9] = str10;
    String str11 = z(z("):\021Q"));
    arrayOfString[10] = str11;
    z = arrayOfString;
  }

  private void _sdka(_sdkrb param_sdkrb)
    throws IOException
  {
    int i = _sdkd;
    if (!_sdka._sdkb())
      return;
    _sdkhb local_sdkhb1 = _sdka;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[9];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    int j = param_sdkrb._sdka();
    String str2 = j;
    local_sdkhb1._sdkb(str2);
    InputStream localInputStream = param_sdkrb._sdke();
    if (localInputStream == null)
      return;
    String str3 = param_sdkrb._sdkd();
    _sdkhb local_sdkhb2 = _sdka;
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str4 = z[7];
    String str5 = str4 + str3;
    local_sdkhb2._sdkb(str5);
    String str6 = z[10];
    if (!str3.startsWith(str6))
      return;
    byte[] arrayOfByte = new byte[1024];
    Object localObject1;
    Object localObject2;
    label243: ByteArrayInputStream localByteArrayInputStream;
    if (!localInputStream.markSupported())
    {
      localObject1 = arrayOfByte;
      int k = 0;
      do
      {
        int m = localObject1.length - k;
        int n = localInputStream.read((byte[])localObject1, k, m);
        if (n <= 0)
          break;
        k += n;
      }
      while (localObject1.length == k);
      localObject2 = new byte[localObject1.length * 2];
      int i1 = localObject1.length;
      System.arraycopy(localObject1, 0, localObject2, 0, i1);
      if (i != 0)
      {
        localByteArrayInputStream = new ByteArrayInputStream((byte[])localObject2, 0, k);
        param_sdkrb._sdke = localByteArrayInputStream;
      }
    }
    for (Object localObject3 = localByteArrayInputStream; ; localObject3 = localInputStream)
    {
      ((InputStream)localObject3).mark(1024);
      int i2 = 0;
      int i3 = 1024;
      try
      {
        int i4 = ((InputStream)localObject3).read((byte[])localObject2, i2, i3);
        _sdkhb local_sdkhb3 = _sdka;
        StringBuilder localStringBuilder4 = new StringBuilder();
        String str7 = z[8];
        StringBuilder localStringBuilder5 = localStringBuilder4.append(str7);
        String str8 = new String((byte[])localObject2, 0, i4);
        String str9 = str8;
        local_sdkhb3._sdkb(str9);
        return;
      }
      finally
      {
        ((InputStream)localObject3).reset();
      }
      localObject1 = localObject2;
      break;
      localObject2 = localObject1;
      break label243;
      localObject2 = arrayOfByte;
    }
  }

  public static void _sdka(_sdktb param_sdktb)
  {
    String str = z[6];
    throw new UnsupportedOperationException(str);
  }

  /** @deprecated */
  public static _sdktb _sdkc()
  {
    try
    {
      if (_sdkb == null);
      _sdktb local_sdktb;
      for (Object localObject1 = new _sdkub(); ; localObject1 = local_sdktb)
      {
        return localObject1;
        local_sdktb = _sdkb._sdkb();
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public static void _sdkc(String paramString)
  {
    try
    {
      if ((_sdkc == null) || (!_sdkc.equals(paramString)))
      {
        _sdkc = paramString;
        if (_sdkd == 0);
      }
      else
      {
        _sdkhb local_sdkhb = _sdka;
        String str = z[0];
        local_sdkhb._sdkb(str);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public static String _sdkd()
  {
    try
    {
      String str = _sdkc;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public static boolean _sdke()
  {
    try
    {
      if (_sdkc != null)
      {
        String str1 = _sdkc;
        String str2 = z[5];
        boolean bool1 = str1.startsWith(str2);
        if (bool1)
        {
          bool2 = true;
          return bool2;
        }
      }
      boolean bool2 = false;
    }
    finally
    {
    }
  }

  /** @deprecated */
  public static boolean _sdkf()
  {
    try
    {
      if (_sdkc != null)
      {
        int i = _sdkc.length();
        if (i != 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private static String z(char[] paramArrayOfChar)
  {
    int i = paramArrayOfChar.length;
    int j = 0;
    if (i <= 1);
    label120: 
    while (i > j)
    {
      char[] arrayOfChar = paramArrayOfChar;
      int k = j;
      int m = paramArrayOfChar[j];
      int n;
      switch (k % 5)
      {
      default:
        n = 126;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        int i1 = (char)(n ^ m);
        paramArrayOfChar[j] = i1;
        j = k + 1;
        if (i != 0)
          break label120;
        paramArrayOfChar = arrayOfChar;
        k = j;
        j = i;
        break;
        n = 93;
        continue;
        n = 95;
        continue;
        n = 105;
        continue;
        n = 11;
      }
      paramArrayOfChar = arrayOfChar;
    }
    return new String(paramArrayOfChar).intern();
  }

  private static char[] z(String paramString)
  {
    Object localObject1 = paramString.toCharArray();
    Object localObject2 = localObject1;
    while (true)
    {
      int i = localObject1.length;
      if (i < 2)
      {
        if (i != 0)
        {
          int j = (char)(localObject2[0] ^ 0x7E);
          localObject2[0] = j;
        }
      }
      else
        return localObject2;
      localObject1 = localObject2;
    }
  }

  public final _sdkrb _sdka(String paramString)
    throws IOException
  {
    String str = _sdkd();
    return _sdkb(str, paramString);
  }

  public final _sdkrb _sdka(String paramString1, String paramString2)
    throws IOException
  {
    String str = _sdkd();
    return _sdka(str, paramString1, paramString2);
  }

  public final _sdkrb _sdka(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    String str1 = paramString1 + paramString2;
    if (_sdka._sdkb())
    {
      _sdkhb local_sdkhb = _sdka;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str2 = z[1];
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(str1);
      String str3 = z[2];
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str3);
      int i = paramString3.length();
      String str4 = i + "]" + paramString3 + ")";
      local_sdkhb._sdkb(str4);
    }
    _sdkrb local_sdkrb = _sdkc(str1, paramString3);
    _sdka(local_sdkrb);
    return local_sdkrb;
  }

  public void _sdka()
  {
    String str = z[3];
    throw new UnsupportedOperationException(str);
  }

  protected abstract _sdkrb _sdkb(String paramString)
    throws IOException;

  public final _sdkrb _sdkb(String paramString1, String paramString2)
    throws IOException
  {
    String str1 = paramString1 + paramString2;
    if (_sdka._sdkb())
    {
      _sdkhb local_sdkhb = _sdka;
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = z[4];
      String str3 = str2 + str1 + ")";
      local_sdkhb._sdkb(str3);
    }
    _sdkrb local_sdkrb = _sdkb(str1);
    _sdka(local_sdkrb);
    return local_sdkrb;
  }

  protected abstract _sdktb _sdkb();

  protected abstract _sdkrb _sdkc(String paramString1, String paramString2)
    throws IOException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdktb
 * JD-Core Version:    0.6.2
 */