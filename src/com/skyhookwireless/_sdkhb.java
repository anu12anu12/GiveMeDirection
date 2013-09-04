package com.skyhookwireless;

import java.io.OutputStream;
import java.io.PrintStream;

public abstract class _sdkhb
{
  private static _sdkh _sdkb;
  private static _sdkhb _sdkc = new _sdklb(_sdkhb.class);
  public static boolean _sdkd;
  private static final String[] z;
  protected final String _sdka;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[4];
    String str1 = z(z("\003\023>z^@\0015)\n\020��?)E\024\013 8Y"));
    arrayOfString[i] = str1;
    String str2 = z(z("@\0068/N]"));
    arrayOfString[1] = str2;
    String str3 = z(z("@)"));
    arrayOfString[2] = str3;
    String str4 = z(z("=R"));
    arrayOfString[3] = str4;
    z = arrayOfString;
    _sdkb = _sdkh.NONE;
    _sdkc = null;
    _sdkh[] arrayOf_sdkh = _sdkh.values();
    int j = arrayOf_sdkh.length;
    while (true)
    {
      int[] arrayOfInt;
      int k;
      if (i < j)
      {
        _sdkh local_sdkh = arrayOf_sdkh[i];
        String str5 = local_sdkh.name();
        String str6 = z(z("$7\022\bm"));
        if (str5.equals(str6))
          _sdkb = local_sdkh;
      }
      else
      {
        arrayOfInt = _sdkmb._sdka;
        k = _sdkp.loggerType.ordinal();
      }
      switch (arrayOfInt[k])
      {
      default:
        _sdkc = new _sdkjb();
        return;
        i += 1;
      case 1:
      case 2:
      case 3:
      }
    }
    _sdkc = new _sdkkb(_sdkhb.class);
    return;
    _sdkc = new _sdkib(_sdkhb.class);
    return;
  }

  private _sdkhb()
  {
    this._sdka = null;
  }

  _sdkhb(_sdkjb param_sdkjb)
  {
    this();
  }

  protected _sdkhb(Class<?> paramClass)
  {
    String str = paramClass.getName();
    this._sdka = str;
  }

  /** @deprecated */
  public static void _sdka(_sdkhb param_sdkhb)
  {
    try
    {
      String str = z[0];
      throw new UnsupportedOperationException(str);
    }
    finally
    {
    }
  }

  /** @deprecated */
  public static _sdkhb _sdkb(Class<?> paramClass)
  {
    try
    {
      _sdkhb local_sdkhb1 = _sdkc._sdka(paramClass);
      _sdkhb local_sdkhb2 = local_sdkhb1;
      return local_sdkhb2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private final String _sdkb(_sdkh param_sdkh, String paramString)
  {
    int i = paramString.length() + 256;
    StringBuilder localStringBuilder1 = new StringBuilder(i);
    String str1 = z[1];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    long l = Thread.currentThread().getId();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(l).append(" ");
    String str2 = this._sdka;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str2);
    String str3 = z[2];
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str3);
    String str4 = param_sdkh.toString();
    StringBuilder localStringBuilder6 = localStringBuilder5.append(str4);
    String str5 = z[3];
    return str5 + paramString;
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
        n = 42;
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
        n = 96;
        continue;
        n = 114;
        continue;
        n = 80;
        continue;
        n = 93;
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
          int j = (char)(localObject2[0] ^ 0x2A);
          localObject2[0] = j;
        }
      }
      else
        return localObject2;
      localObject1 = localObject2;
    }
  }

  protected abstract _sdkhb _sdka(Class<?> paramClass);

  protected abstract void _sdka(_sdkh param_sdkh, String paramString);

  public void _sdka(_sdkh param_sdkh, String paramString, Throwable paramThrowable)
  {
    if (!_sdka(param_sdkh))
      return;
    if (paramThrowable == null)
    {
      String str = _sdkb(param_sdkh, paramString);
      _sdka(param_sdkh, str);
      return;
    }
    OutputStream localOutputStream = _sdkb(param_sdkh);
    PrintStream localPrintStream = new PrintStream(localOutputStream);
    try
    {
      localPrintStream.println(paramString);
      paramThrowable.printStackTrace(localPrintStream);
      return;
    }
    finally
    {
      localPrintStream.close();
    }
  }

  public final void _sdka(String paramString)
  {
    _sdkh local_sdkh = _sdkh.TRACE;
    _sdka(local_sdkh, paramString, null);
  }

  public final void _sdka(String paramString, Throwable paramThrowable)
  {
    _sdkh local_sdkh = _sdkh.TRACE;
    _sdka(local_sdkh, paramString, paramThrowable);
  }

  public boolean _sdka()
  {
    _sdkh local_sdkh = _sdkh.TRACE;
    return _sdka(local_sdkh);
  }

  public boolean _sdka(_sdkh param_sdkh)
  {
    if ((_sdkb.compareTo(param_sdkh) <= 0) && (_sdknb._sdkb(param_sdkh)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public final OutputStream _sdkb(_sdkh param_sdkh)
  {
    return new _sdke(this, param_sdkh);
  }

  public final void _sdkb(String paramString)
  {
    _sdkh local_sdkh = _sdkh.DEBUG;
    _sdka(local_sdkh, paramString, null);
  }

  public final void _sdkb(String paramString, Throwable paramThrowable)
  {
    _sdkh local_sdkh = _sdkh.DEBUG;
    _sdka(local_sdkh, paramString, paramThrowable);
  }

  public boolean _sdkb()
  {
    _sdkh local_sdkh = _sdkh.DEBUG;
    return _sdka(local_sdkh);
  }

  public final void _sdkc(String paramString)
  {
    _sdkh local_sdkh = _sdkh.INFO;
    _sdka(local_sdkh, paramString, null);
  }

  public final void _sdkc(String paramString, Throwable paramThrowable)
  {
    _sdkh local_sdkh = _sdkh.INFO;
    _sdka(local_sdkh, paramString, paramThrowable);
  }

  public boolean _sdkc()
  {
    _sdkh local_sdkh = _sdkh.INFO;
    return _sdka(local_sdkh);
  }

  public final void _sdkd(String paramString)
  {
    _sdkh local_sdkh = _sdkh.WARN;
    _sdka(local_sdkh, paramString, null);
  }

  public final void _sdkd(String paramString, Throwable paramThrowable)
  {
    _sdkh local_sdkh = _sdkh.WARN;
    _sdka(local_sdkh, paramString, paramThrowable);
  }

  public boolean _sdkd()
  {
    _sdkh local_sdkh = _sdkh.WARN;
    return _sdka(local_sdkh);
  }

  public final void _sdke(String paramString)
  {
    _sdkh local_sdkh = _sdkh.ERROR;
    _sdka(local_sdkh, paramString, null);
  }

  public final void _sdke(String paramString, Throwable paramThrowable)
  {
    _sdkh local_sdkh = _sdkh.ERROR;
    _sdka(local_sdkh, paramString, paramThrowable);
  }

  public boolean _sdke()
  {
    _sdkh local_sdkh = _sdkh.ERROR;
    return _sdka(local_sdkh);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkhb
 * JD-Core Version:    0.6.2
 */