package com.skyhookwireless.wps;

import com.skyhookwireless._sdkic;
import com.skyhookwireless._sdktd;
import java.util.Iterator;
import java.util.LinkedList;

public final class _sdkcb
{
  private static final String[] z;
  private final com.skyhookwireless._sdkhb _sdka;
  private final _sdkdb _sdkb;
  private int _sdkc = 50;
  private final LinkedList<_sdktd<_sdkeb, _sdkhb>> _sdkd;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = "\025L\006-TuJC".toCharArray();
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
          i2 = 78;
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
      Object localObject5 = "QF\006 Zb\002@'[r\002".toCharArray();
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
            i8 = 78;
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
        Object localObject7 = "SyWH*\025".toCharArray();
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
              i18 = 78;
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
          Object localObject10 = "\025L\006(\\zGU".toCharArray();
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
              i22 = 78;
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
            i2 = 53;
            break;
            i2 = 22;
            break;
            i2 = 34;
            break;
            i2 = 38;
            break;
            i8 = 53;
            break label244;
            i8 = 22;
            break label244;
            i8 = 34;
            break label244;
            i8 = 38;
            break label244;
            i18 = 53;
            break label408;
            i18 = 22;
            break label408;
            i18 = 34;
            break label408;
            i18 = 38;
            break label408;
            i22 = 53;
            continue;
            i22 = 22;
            continue;
            i22 = 34;
            continue;
            i22 = 38;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  public _sdkcb(WPSAuthentication paramWPSAuthentication)
  {
    LinkedList localLinkedList = new LinkedList();
    this._sdkd = localLinkedList;
    com.skyhookwireless._sdkhb local_sdkhb = com.skyhookwireless._sdkhb._sdkb(_sdkcb.class);
    this._sdka = local_sdkhb;
    _sdkdb local_sdkdb = new _sdkdb(paramWPSAuthentication);
    this._sdkb = local_sdkdb;
  }

  private void _sdka(_sdktd<_sdkeb, _sdkhb> param_sdktd)
  {
    if (this._sdkc > 0)
    {
      int i = this._sdkc + -1;
      this._sdkc = i;
      if (_sdkc._sdkb == 0);
    }
    else
    {
      Object localObject = this._sdkd.removeLast();
    }
    this._sdkd.add(0, param_sdktd);
  }

  private _sdktd<_sdkeb, _sdkhb> _sdkb(_sdkic param_sdkic)
  {
    int i = _sdkc._sdkb;
    Iterator localIterator = this._sdkd.iterator();
    _sdktd local_sdktd;
    if (localIterator.hasNext())
    {
      local_sdktd = (_sdktd)localIterator.next();
      if (((_sdkhb)local_sdktd.second)._sdka().equals(param_sdkic))
      {
        boolean bool = this._sdkd.remove(local_sdktd);
        this._sdkd.add(0, local_sdktd);
      }
    }
    while (true)
    {
      return local_sdktd;
      if (i == 0)
        break;
      local_sdktd = null;
    }
  }

  private _sdkeb _sdkb(_sdkeb param_sdkeb)
  {
    int i = _sdkc._sdkb;
    Iterator localIterator = this._sdkd.iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      if (((_sdktd)localIterator.next()).first == param_sdkeb)
      {
        localIterator.remove();
        int j = this._sdkc + 1;
        this._sdkc = j;
      }
    }
    while (i == 0);
    return param_sdkeb;
  }

  public _sdktd<_sdkeb, _sdkhb> _sdka(_sdkic param_sdkic)
    throws _sdkc
  {
    _sdktd local_sdktd1 = _sdkb(param_sdkic);
    _sdktd local_sdktd2;
    if (local_sdktd1 != null)
    {
      if (this._sdka._sdkb())
      {
        com.skyhookwireless._sdkhb local_sdkhb1 = this._sdka;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[2];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(param_sdkic);
        String str2 = z[0];
        String str3 = str2;
        local_sdkhb1._sdkb(str3);
      }
      _sdkdb local_sdkdb = this._sdkb;
      _sdkeb local_sdkeb = (_sdkeb)local_sdktd1.first;
      local_sdkdb._sdkb(local_sdkeb);
      local_sdktd2 = local_sdktd1;
    }
    while (true)
    {
      return local_sdktd2;
      local_sdktd2 = this._sdkb._sdka(param_sdkic);
      if (local_sdktd2 != null)
      {
        if (this._sdka._sdkb())
        {
          com.skyhookwireless._sdkhb local_sdkhb2 = this._sdka;
          StringBuilder localStringBuilder3 = new StringBuilder();
          String str4 = z[2];
          StringBuilder localStringBuilder4 = localStringBuilder3.append(str4).append(param_sdkic);
          String str5 = z[3];
          String str6 = str5;
          local_sdkhb2._sdkb(str6);
        }
        _sdka(local_sdktd2);
        if (_sdkc._sdkb == 0);
      }
      else if (this._sdka._sdkb())
      {
        com.skyhookwireless._sdkhb local_sdkhb3 = this._sdka;
        StringBuilder localStringBuilder5 = new StringBuilder();
        String str7 = z[1];
        StringBuilder localStringBuilder6 = localStringBuilder5.append(str7).append(param_sdkic);
        String str8 = z[3];
        String str9 = str8;
        local_sdkhb3._sdkb(str9);
      }
    }
  }

  public _sdkeb _sdka()
  {
    _sdkeb local_sdkeb1 = this._sdkb._sdka();
    _sdkeb local_sdkeb2 = _sdkb(local_sdkeb1);
    local_sdkeb2.close();
    return local_sdkeb2;
  }

  public _sdkeb _sdka(int paramInt, String paramString)
  {
    return this._sdkb._sdka(paramInt, paramString);
  }

  public void _sdka(_sdkeb param_sdkeb)
  {
    _sdkdb local_sdkdb = this._sdkb;
    _sdkeb local_sdkeb = _sdkb(param_sdkeb);
    local_sdkdb._sdka(local_sdkeb);
    param_sdkeb.close();
  }

  public int _sdkb()
  {
    return this._sdkb._sdkb();
  }

  public boolean _sdkc()
  {
    return this._sdkb._sdkc();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkcb
 * JD-Core Version:    0.6.2
 */