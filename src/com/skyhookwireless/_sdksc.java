package com.skyhookwireless;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class _sdksc extends _sdkqc
{
  private static Method _sdke;
  private static final String[] z;
  private final Callable<Boolean> _sdkd;
  private final _sdkhb _sdkf;
  private final Context _sdkg;
  private final ArrayList<_sdkab> _sdkh;
  private PhoneStateListener _sdki;
  private TelephonyManager _sdkj;
  private _sdkv _sdkk;
  private _sdkec _sdkl;
  private Integer _sdkm;
  private List<_sdkab> _sdkn;

  static
  {
    String[] arrayOfString = new String[20];
    String str1 = z(z("\021b!v*\031h\013e1\031z >\002#A\004`$��x v\f\035|)"));
    arrayOfString[0] = str1;
    String str2 = z(z("\034c6pe\003i7r,\036keg \034`"));
    arrayOfString[1] = str2;
    String str3 = z(z("/!o$"));
    arrayOfString[2] = str3;
    String str4 = z(z("\023c0h!Pb*pe\027i1$5\030c+ae\003x0b#"));
    arrayOfString[3] = str4;
    String str5 = z(z("\025b$f)\025@*g$\004e*j\020��h$p \003"));
    arrayOfString[4] = str5;
    String str6 = z(z("\004i)a5\030c+}e\035m+e\"\025~ej0\034`i$&\034c6amY,5v*\022m'h<P{$we\023m)h \024,,je\021b*p-\025~ep-\002i$`"));
    arrayOfString[5] = str6;
    String str7 = z(z("\021b!v*\031hkt \002a,w6\031c+*\006?B\021V\n<S\tK\0061X\fK\013/Y\025@\004$I\026"));
    arrayOfString[6] = str7;
    String str8 = z(z("\036c1$$\034`*s \024,1ke\025b$f)\025#!m6\021n)ae\034c&e1\031c+$0��h$p \003"));
    arrayOfString[7] = str8;
    String str9 = z(z("\023c0h!\036+1$ \036m'h P`*g$\004e*je\005|!e1\025$"));
    arrayOfString[8] = str9;
    String str10 = z(z("\034c&e1\031c+$0��h$p \003, j$\022` `"));
    arrayOfString[9] = str10;
    String str11 = z(z("\024e6e'\034i\tk&\021x,k+%|!e1\025"));
    arrayOfString[10] = str11;
    String str12 = z(z("\023m+#1Ph,w$\022` $)\037o$p,\037beq5\024m1a6J,"));
    arrayOfString[11] = str12;
    String str13 = z(z("\036cet7\025z,k0\003,6g$\036b `e\023i)h6Px*$&\021o-a"));
    arrayOfString[12] = str13;
    String str14 = z(z("\023m&l \024,5v \006e*q6Po h)\003 eg$\023d $,\003,+k2J,"));
    arrayOfString[13] = str14;
    String str15 = z(z("\035m,je\023i)he\035o&>e"));
    arrayOfString[14] = str15;
    String str16 = z(z("\031b3e)\031heg \034`$"));
    arrayOfString[15] = str16;
    String str17 = z(z("\023c0h!\036+1$5\021~6ae\035o&+(\036o$"));
    arrayOfString[16] = str17;
    String str18 = z(z("\005b$f)\025,1ke��m7w Pk p\013\025x2k7\033C5a7\021x*vmY6e"));
    arrayOfString[17] = str18;
    String str19 = z(z("Pa+gP"));
    arrayOfString[18] = str19;
    String str20 = z(z("\023c0h!\036+1$,\036z*o Pk p\013\025e\"l'\037~\006a)\034m-"));
    arrayOfString[19] = str20;
    z = arrayOfString;
    _sdke = null;
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdksc.class);
    try
    {
      String str21 = "\023c(*6\033u-k*\033{,v \034i6wk/!o?";
      str21 = z(z(str21));
      _sdke = _sdka(str21);
      if (_sdke != null);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        String str22 = "\023c(*6\033u-k*\033{,v \034i6wk/!o<";
        str22 = z(z(str22));
        _sdke = _sdka(str22);
        if (_sdke == null)
        {
          String str23 = z(z("\023c0h!\036+1$\"\025xec \004B m\"\030n*v\006\025`)wmY"));
          local_sdkhb._sdkb(str23);
          return;
          String str24 = localThrowable1.toString();
          local_sdkhb._sdkb(str24);
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
        {
          String str25 = localThrowable2.toString();
          local_sdkhb._sdkb(str25);
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str26 = z(z("\005,j\"P"));
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str26);
        Method localMethod = _sdke;
        String str27 = localMethod;
        local_sdkhb._sdkb(str27);
      }
    }
  }

  public _sdksc(_sdkt param_sdkt)
  {
    _sdku local_sdku = new _sdku(this);
    this._sdkd = local_sdku;
    this._sdkj = null;
    this._sdkk = null;
    this._sdkl = null;
    this._sdkm = null;
    this._sdkn = null;
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdksc.class);
    this._sdkf = local_sdkhb;
    Context localContext = ((_sdkq)param_sdkt)._sdka();
    this._sdkg = localContext;
    ArrayList localArrayList = new ArrayList();
    this._sdkh = localArrayList;
    if (!_sdkhb._sdkd)
      return;
    _sdkab._sdkf = i + 1;
  }

  static PhoneStateListener _sdka(_sdksc param_sdksc, PhoneStateListener paramPhoneStateListener)
  {
    param_sdksc._sdki = paramPhoneStateListener;
    return paramPhoneStateListener;
  }

  static TelephonyManager _sdka(_sdksc param_sdksc, TelephonyManager paramTelephonyManager)
  {
    param_sdksc._sdkj = paramTelephonyManager;
    return paramTelephonyManager;
  }

  static _sdkec _sdka(_sdksc param_sdksc, _sdkec param_sdkec)
  {
    param_sdksc._sdkl = param_sdkec;
    return param_sdkec;
  }

  static _sdkhb _sdka(_sdksc param_sdksc)
  {
    return param_sdksc._sdkf;
  }

  private _sdkv _sdka(GsmCellLocation paramGsmCellLocation)
  {
    _sdkv local_sdkv = null;
    int i = this._sdkj.getNetworkOperator();
    if (i.length() < 4)
      if (this._sdkf._sdkb())
      {
        _sdkhb local_sdkhb1 = this._sdkf;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[17];
        String str2 = str1 + i;
        local_sdkhb1._sdkb(str2);
      }
    while (true)
    {
      return local_sdkv;
      int j = 0;
      int k = 3;
      int m;
      try
      {
        m = Integer.valueOf(i.substring(j, k)).intValue();
        int n = Integer.valueOf(i.substring(3)).intValue();
        i = n;
        if (this._sdkf._sdkb())
        {
          _sdkhb local_sdkhb2 = this._sdkf;
          StringBuilder localStringBuilder2 = new StringBuilder();
          String str3 = z[14];
          StringBuilder localStringBuilder3 = localStringBuilder2.append(str3).append(m);
          String str4 = z[18];
          String str5 = str4 + i;
          local_sdkhb2._sdkb(str5);
        }
        if ((m != 0) || (i != 0) || (paramGsmCellLocation.getCid() != 0) || (paramGsmCellLocation.getLac() != 0))
          break label317;
        _sdkhb local_sdkhb3 = this._sdkf;
        StringBuilder localStringBuilder4 = new StringBuilder();
        String str6 = z[15];
        String str7 = str6 + paramGsmCellLocation;
        local_sdkhb3._sdkd(str7);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        _sdkhb local_sdkhb4 = this._sdkf;
        StringBuilder localStringBuilder5 = new StringBuilder();
        String str8 = z[16];
        String str9 = str8 + i;
        local_sdkhb4._sdke(str9, localNumberFormatException);
      }
      continue;
      label317: int i1 = paramGsmCellLocation.getCid();
      int i2 = paramGsmCellLocation.getLac();
      local_sdkv = new _sdkv(m, i, i1, i2);
    }
  }

  static _sdkv _sdka(_sdksc param_sdksc, GsmCellLocation paramGsmCellLocation)
  {
    return param_sdksc._sdka(paramGsmCellLocation);
  }

  static _sdkv _sdka(_sdksc param_sdksc, _sdkv param_sdkv)
  {
    param_sdksc._sdkk = param_sdkv;
    return param_sdkv;
  }

  static Integer _sdka(_sdksc param_sdksc, Integer paramInteger)
  {
    param_sdksc._sdkm = paramInteger;
    return paramInteger;
  }

  private static Method _sdka(String paramString)
    throws ClassNotFoundException, SecurityException, NoSuchMethodException
  {
    Class localClass = Class.forName(paramString);
    String str = z[2];
    Class[] arrayOfClass = new Class[3];
    arrayOfClass[0] = TelephonyManager.class;
    arrayOfClass[1] = _sdkhb.class;
    arrayOfClass[2] = _sdkv.class;
    return localClass.getDeclaredMethod(str, arrayOfClass);
  }

  static List _sdka(_sdksc param_sdksc, List paramList)
  {
    param_sdksc._sdkn = paramList;
    return paramList;
  }

  private List<_sdkab> _sdka(_sdkv param_sdkv)
  {
    if (_sdke != null);
    while (true)
    {
      try
      {
        Method localMethod = _sdke;
        Object[] arrayOfObject = new Object[3];
        TelephonyManager localTelephonyManager = this._sdkj;
        arrayOfObject[0] = localTelephonyManager;
        _sdkhb local_sdkhb1 = this._sdkf;
        arrayOfObject[1] = local_sdkhb1;
        arrayOfObject[2] = param_sdkv;
        localList = (List)localMethod.invoke(null, arrayOfObject);
        return localList;
      }
      catch (Throwable localThrowable)
      {
        _sdkhb local_sdkhb2 = this._sdkf;
        String str = z[19];
        local_sdkhb2._sdke(str, localThrowable);
      }
      List localList = Collections.emptyList();
    }
  }

  private void _sdka(_sdkab param_sdkab, List<_sdkab> paramList)
  {
    int i = _sdkab._sdkf;
    if (paramList == null)
      return;
    if (param_sdkab == null)
      return;
    ListIterator localListIterator = paramList.listIterator();
    do
    {
      _sdkv local_sdkv1;
      _sdkv local_sdkv2;
      do
      {
        if (!localListIterator.hasNext())
          return;
        local_sdkv1 = ((_sdkab)localListIterator.next())._sdka();
        local_sdkv2 = param_sdkab._sdka();
      }
      while (!local_sdkv1.equals(local_sdkv2));
      localListIterator.remove();
    }
    while (i == 0);
  }

  static TelephonyManager _sdkb(_sdksc param_sdksc)
  {
    return param_sdksc._sdkj;
  }

  static List _sdkb(_sdksc param_sdksc, _sdkv param_sdkv)
  {
    return param_sdksc._sdka(param_sdkv);
  }

  /** @deprecated */
  private void _sdkb(ArrayList<_sdkab> paramArrayList)
  {
    try
    {
      if ((this._sdkk != null) && (this._sdkm != null) && (this._sdkl != null))
      {
        _sdkv local_sdkv = this._sdkk;
        int i = this._sdkm.intValue();
        _sdkec local_sdkec = this._sdkl;
        _sdkab local_sdkab = new _sdkab(local_sdkv, 0, i, local_sdkec);
        boolean bool1 = paramArrayList.add(local_sdkab);
        if (this._sdkn != null)
        {
          List localList = this._sdkn;
          boolean bool2 = paramArrayList.addAll(localList);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static _sdkv _sdkc(_sdksc param_sdksc)
  {
    return param_sdksc._sdkk;
  }

  static Integer _sdkd(_sdksc param_sdksc)
  {
    return param_sdksc._sdkm;
  }

  /** @deprecated */
  private void _sdkd()
  {
    try
    {
      int i = _sdkab._sdkf;
      if ((this._sdkk == null) || (this._sdkm == null) || (this._sdkl == null))
      {
        _sdkhb local_sdkhb1 = this._sdkf;
        String str1 = z[12];
        local_sdkhb1._sdkb(str1);
      }
      while (true)
      {
        return;
        _sdkv local_sdkv = this._sdkk;
        int j = this._sdkm.intValue();
        _sdkec local_sdkec = this._sdkl;
        _sdkab local_sdkab1 = new _sdkab(local_sdkv, 0, j, local_sdkec);
        ArrayList localArrayList1 = this._sdkh;
        _sdka(local_sdkab1, localArrayList1);
        boolean bool1 = this._sdkh.add(local_sdkab1);
        if (this._sdkn != null)
        {
          Iterator localIterator = this._sdkn.iterator();
          do
          {
            if (!localIterator.hasNext())
              break;
            _sdkab local_sdkab2 = (_sdkab)localIterator.next();
            ArrayList localArrayList2 = this._sdkh;
            _sdka(local_sdkab2, localArrayList2);
          }
          while (i == 0);
          ArrayList localArrayList3 = this._sdkh;
          List localList = this._sdkn;
          boolean bool2 = localArrayList3.addAll(localList);
          this._sdkn = null;
        }
        if (this._sdkf._sdkb())
        {
          _sdkhb local_sdkhb2 = this._sdkf;
          StringBuilder localStringBuilder1 = new StringBuilder();
          String str2 = z[13];
          StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
          ArrayList localArrayList4 = this._sdkh;
          String str3 = localArrayList4;
          local_sdkhb2._sdkb(str3);
        }
      }
    }
    finally
    {
    }
  }

  static _sdkec _sdke(_sdksc param_sdksc)
  {
    return param_sdksc._sdkl;
  }

  private void _sdke()
  {
    _sdkhb local_sdkhb = this._sdkf;
    String str = z[1];
    local_sdkhb._sdkb(str);
    try
    {
      _sdkd();
      this._sdkk = null;
      this._sdkm = null;
      this._sdkl = null;
      this._sdkn = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static void _sdkf(_sdksc param_sdksc)
  {
    param_sdksc._sdkd();
  }

  static void _sdkg(_sdksc param_sdksc)
  {
    param_sdksc._sdke();
  }

  static void _sdkh(_sdksc param_sdksc)
  {
    param_sdksc._sdka();
  }

  static Context _sdki(_sdksc param_sdksc)
  {
    return param_sdksc._sdkg;
  }

  private static String z(char[] paramArrayOfChar)
  {
    int i = paramArrayOfChar.length;
    int j = 0;
    if (i <= 1);
    label119: 
    while (i > j)
    {
      char[] arrayOfChar = paramArrayOfChar;
      int k = j;
      int m = paramArrayOfChar[j];
      int n;
      switch (k % 5)
      {
      default:
        n = 69;
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
          break label119;
        paramArrayOfChar = arrayOfChar;
        k = j;
        j = i;
        break;
        n = 112;
        continue;
        n = 12;
        continue;
        n = 69;
        continue;
        n = 4;
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
          int j = (char)(localObject2[0] ^ 0x45);
          localObject2[0] = j;
        }
      }
      else
        return localObject2;
      localObject1 = localObject2;
    }
  }

  protected _sdkqc _sdka(_sdkt param_sdkt)
  {
    return new _sdksc(param_sdkt);
  }

  /** @deprecated */
  public void _sdka(ArrayList<_sdkab> paramArrayList)
  {
    try
    {
      _sdkb(paramArrayList);
      ArrayList localArrayList = this._sdkh;
      boolean bool = paramArrayList.addAll(localArrayList);
      this._sdkh.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void _sdkb()
  {
    try
    {
      Future localFuture = _sdkr._sdka(this._sdkd);
      TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
      Object localObject1 = localFuture.get(5000L, localTimeUnit);
      try
      {
        if (this._sdkj == null)
        {
          String str1 = z[5];
          throw new _sdkyd(str1);
        }
      }
      finally
      {
      }
    }
    catch (Throwable localThrowable1)
    {
      String str2 = z[3];
      throw new _sdkyd(str2, localThrowable1);
    }
    TelephonyManager localTelephonyManager1 = this._sdkj;
    PhoneStateListener localPhoneStateListener = this._sdki;
    localTelephonyManager1.listen(localPhoneStateListener, 19);
    Context localContext = this._sdkg;
    String str3 = z[6];
    int i = localContext.checkCallingOrSelfPermission(str3);
    if (i == 0);
    while (true)
    {
      try
      {
        Class localClass = this._sdkj.getClass();
        String str4 = z[4];
        Class[] arrayOfClass = new Class[0];
        Method localMethod = localClass.getMethod(str4, arrayOfClass);
        if (!localMethod.isAccessible())
          localMethod.setAccessible(true);
        TelephonyManager localTelephonyManager2 = this._sdkj;
        Object[] arrayOfObject = new Object[0];
        Object localObject3 = localMethod.invoke(localTelephonyManager2, arrayOfObject);
        _sdkhb local_sdkhb1 = this._sdkf;
        String str5 = z[9];
        local_sdkhb1._sdkb(str5);
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        _sdkhb local_sdkhb2 = this._sdkf;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str6 = z[8];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str6);
        Throwable localThrowable2 = localInvocationTargetException.getTargetException();
        String str7 = localThrowable2;
        local_sdkhb2._sdkb(str7);
        continue;
      }
      catch (Throwable localThrowable3)
      {
        _sdkhb local_sdkhb3 = this._sdkf;
        StringBuilder localStringBuilder3 = new StringBuilder();
        String str8 = z[8];
        String str9 = str8 + localThrowable3;
        local_sdkhb3._sdkb(str9);
        if (_sdkab._sdkf == 0)
          continue;
      }
      _sdkhb local_sdkhb4 = this._sdkf;
      String str10 = z[7];
      local_sdkhb4._sdkb(str10);
    }
  }

  /** @deprecated */
  public void _sdkc()
  {
    try
    {
      if (this._sdkj != null)
      {
        Context localContext = this._sdkg;
        String str1 = z[6];
        int i = localContext.checkCallingOrSelfPermission(str1);
        if (i != 0);
      }
      try
      {
        Class localClass = this._sdkj.getClass();
        String str2 = z[10];
        Class[] arrayOfClass = new Class[0];
        Method localMethod = localClass.getMethod(str2, arrayOfClass);
        if (!localMethod.isAccessible())
          localMethod.setAccessible(true);
        TelephonyManager localTelephonyManager1 = this._sdkj;
        Object[] arrayOfObject = new Object[0];
        Object localObject1 = localMethod.invoke(localTelephonyManager1, arrayOfObject);
        if (this._sdki != null)
        {
          TelephonyManager localTelephonyManager2 = this._sdkj;
          PhoneStateListener localPhoneStateListener = this._sdki;
          localTelephonyManager2.listen(localPhoneStateListener, 0);
        }
        this._sdki = null;
        this._sdkj = null;
        this._sdkh.clear();
        _sdke();
        return;
      }
      catch (Throwable localThrowable)
      {
        while (true)
        {
          _sdkhb local_sdkhb = this._sdkf;
          StringBuilder localStringBuilder = new StringBuilder();
          String str3 = z[11];
          String str4 = str3 + localThrowable;
          local_sdkhb._sdkb(str4);
        }
      }
    }
    finally
    {
    }
  }

  public String _sdkd()
  {
    return z[0];
  }

  public boolean _sdke()
  {
    CellLocation.requestLocationUpdate();
    return true;
  }

  public String toString()
  {
    return _sdkd();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdksc
 * JD-Core Version:    0.6.2
 */