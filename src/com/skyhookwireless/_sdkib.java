package com.skyhookwireless;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

final class _sdkib extends _sdkhb
{
  private static FileWriter _sdke;
  private static final String[] z;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    int j = "JX\027`DBL\0020]\013I\026%\r\033=\0351\030K\0354".toCharArray();
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
          i8 = 41;
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
      Object localObject2 = "@\032WwH\035\r\034cY\034\005\\s\007\033\021G".toCharArray();
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
          i14 = 41;
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
        try
        {
          String str3 = z[1];
          _sdke = new FileWriter(str3, true);
          return;
        }
        catch (Exception localException)
        {
          _sdke = null;
          return;
        }
        i8 = 111;
        break;
        i8 = 105;
        break;
        i8 = 51;
        break;
        i8 = 20;
        break;
        i14 = 111;
        continue;
        i14 = 105;
        continue;
        i14 = 51;
        continue;
        i14 = 20;
      }
      Object localObject1 = null;
    }
  }

  public _sdkib(Class<?> paramClass)
  {
    super(paramClass);
  }

  protected _sdkhb _sdka(Class<?> paramClass)
  {
    return new _sdkib(paramClass);
  }

  protected void _sdka(_sdkh param_sdkh, String paramString)
  {
    try
    {
      try
      {
        if (_sdke != null)
        {
          FileWriter localFileWriter = _sdke;
          String str1 = z[0];
          Object[] arrayOfObject = new Object[1];
          long l = System.currentTimeMillis();
          Date localDate = new Date(l);
          arrayOfObject[0] = localDate;
          String str2 = String.format(str1, arrayOfObject);
          localFileWriter.write(str2);
          _sdke.write(paramString);
          _sdke.write("\n");
          _sdke.flush();
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    catch (IOException localIOException)
    {
      _sdke = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkib
 * JD-Core Version:    0.6.2
 */