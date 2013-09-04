package com.skyhookwireless.wps;

import com.skyhookwireless._sdkic;
import com.skyhookwireless._sdkjc;
import com.skyhookwireless._sdktd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class _sdky
{
  private static final String[] z;
  private final com.skyhookwireless._sdkhb _sdka;
  private WPSAuthentication _sdkb;
  private List<String> _sdkc;
  private _sdkcb _sdkd;
  private _sdkrc _sdke;
  private _sdkkc _sdkf;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[6];
    Object localObject2 = "\007MNH\004\024\004R@\030\022IGU\017\001W\002B\002\022JED\016".toCharArray();
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
          i2 = 106;
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
      Object localObject5 = "\007MNH\004\024tCS\013\036W\002L\037��P\002O\005\007\004@DJ\035QNM".toCharArray();
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
            i8 = 106;
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
        Object localObject7 = "\032JVD\030\001QRU\017\027".toCharArray();
        int i12 = localObject7.length;
        int i13;
        label343: int i16;
        int i17;
        if (i12 <= 1)
        {
          i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i14 = i12;
          Object localObject8 = localObject7;
          int i15 = i14;
          while (true)
          {
            i16 = localObject8[i13];
            switch (k % 5)
            {
            default:
              i17 = 106;
              label408: int i18 = (char)(i17 ^ i16);
              localObject8[i13] = i18;
              i13 = k + 1;
              if (i15 != 0)
                break label449;
              localObject8 = localObject3;
              int i19 = i13;
              i13 = i15;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i12 = i15;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i13)
            break label343;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i20 = 3;
          Object localObject9 = "\007MNH\004\024\004KRJ\027MQ@\b\037AF\001B\035K\002@\037\007LGO\036\032GCU\003\034J\013".toCharArray();
          int i21 = localObject9.length;
          int i22;
          label508: int i25;
          if (i21 <= 1)
          {
            i22 = 0;
            localObject3 = localObject9;
            k = i22;
            int i23 = i21;
            Object localObject10 = localObject9;
            int i24 = i23;
            while (true)
            {
              i16 = localObject10[i22];
              switch (k % 5)
              {
              default:
                i25 = 106;
                label572: int i26 = (char)(i25 ^ i16);
                localObject10[i22] = i26;
                i22 = k + 1;
                if (i24 != 0)
                  break label613;
                localObject10 = localObject3;
                int i27 = i22;
                i22 = i24;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label613: i21 = i24;
            localObject9 = localObject3;
          }
          while (true)
          {
            if (i21 > i22)
              break label508;
            String str4 = new String((char[])localObject9).intern();
            arrayOfString[i20] = str4;
            int i28 = 4;
            Object localObject11 = "\037KA@\006SBKM\017SQQ@\r\026\004KRJ\027MQ@\b\037AF".toCharArray();
            int i29 = localObject11.length;
            label672: int i34;
            label736: int i31;
            if (i29 <= 1)
            {
              int i30 = 0;
              localObject3 = localObject11;
              k = i30;
              int i32 = i29;
              Object localObject13 = localObject11;
              int i33 = i32;
              while (true)
              {
                i16 = localObject13[i30];
                switch (k % 5)
                {
                default:
                  i34 = 106;
                  int i35 = (char)(i34 ^ i16);
                  localObject13[i30] = i35;
                  i31 = k + 1;
                  if (i33 != 0)
                    break label777;
                  localObject13 = localObject3;
                  int i36 = i31;
                  i31 = i33;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i29 = i33;
              localObject11 = localObject3;
            }
            while (true)
            {
              if (i29 > i31)
                break label672;
              String str5 = new String((char[])localObject11).intern();
              arrayOfString[i28] = str5;
              int i37 = 5;
              Object localObject14 = "\001AON\034\032JE\001\t\034VPT\032\007AF\001\036\032HG".toCharArray();
              Object localObject15 = localObject14.length;
              label833: Object localObject17;
              Object localObject18;
              label852: int i38;
              if (localObject15 <= 1)
              {
                localObject12 = localObject14;
                localObject3 = localObject1;
                Object localObject16 = localObject15;
                localObject17 = localObject14;
                localObject18 = localObject16;
                i28 = localObject17[localObject1];
                switch (localObject3 % 5)
                {
                default:
                  i38 = 106;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              while (true)
              {
                int i39 = (char)(i38 ^ i28);
                localObject17[localObject1] = i39;
                localObject1 = localObject3 + 1;
                if (localObject18 == 0)
                {
                  localObject17 = localObject12;
                  int i40 = localObject1;
                  localObject1 = localObject18;
                  break label852;
                }
                localObject15 = localObject18;
                localObject14 = localObject12;
                if (localObject15 > localObject1)
                  break label833;
                String str6 = new String((char[])localObject14).intern();
                arrayOfString[i37] = str6;
                z = arrayOfString;
                return;
                i2 = 115;
                break;
                i2 = 36;
                break;
                i2 = 34;
                break;
                i2 = 33;
                break;
                i8 = 115;
                break label244;
                i8 = 36;
                break label244;
                i8 = 34;
                break label244;
                i8 = 33;
                break label244;
                i17 = 115;
                break label408;
                i17 = 36;
                break label408;
                i17 = 34;
                break label408;
                i17 = 33;
                break label408;
                i25 = 115;
                break label572;
                i25 = 36;
                break label572;
                i25 = 34;
                break label572;
                i25 = 33;
                break label572;
                i34 = 115;
                break label736;
                i34 = 36;
                break label736;
                i34 = 34;
                break label736;
                i34 = 33;
                break label736;
                i38 = 115;
                continue;
                i38 = 36;
                continue;
                i38 = 34;
                continue;
                i38 = 33;
              }
              Object localObject12 = null;
            }
            i22 = 0;
          }
          i13 = 0;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  public _sdky(WPSAuthentication paramWPSAuthentication, List<String> paramList, _sdkrc param_sdkrc)
  {
    _sdkrc local_sdkrc = _sdkrc.NULL_TILING_PARAMETERS;
    this._sdke = local_sdkrc;
    com.skyhookwireless._sdkhb local_sdkhb = com.skyhookwireless._sdkhb._sdkb(_sdky.class);
    this._sdka = local_sdkhb;
    _sdka(paramWPSAuthentication);
    _sdka(param_sdkrc);
    _sdka(paramList);
  }

  private void _sdkc()
  {
    this._sdkd = null;
  }

  private void _sdkd()
  {
    try
    {
      if (this._sdkf != null)
        this._sdkf._sdka();
      this._sdkf = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        if (this._sdka._sdkb())
        {
          com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
          String str = z[2];
          local_sdkhb._sdkb(str, localInterruptedException);
        }
    }
  }

  public void _sdka()
  {
    int i = _sdkc._sdkb;
    Iterator localIterator;
    if ((this._sdkd == null) && (this._sdkc != null) && (this._sdkb != null))
    {
      WPSAuthentication localWPSAuthentication1 = this._sdkb;
      _sdkcb local_sdkcb1 = new _sdkcb(localWPSAuthentication1);
      this._sdkd = local_sdkcb1;
      localIterator = this._sdkc.iterator();
    }
    int k;
    for (int j = 0; ; j = k)
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        _sdkcb local_sdkcb2 = this._sdkd;
        k = j + 1;
        _sdkeb local_sdkeb = local_sdkcb2._sdka(j, str);
        if (i == 0);
      }
      else
      {
        if (this._sdkf != null)
          return;
        if (this._sdkb == null)
          return;
        WPSAuthentication localWPSAuthentication2 = this._sdkb;
        _sdkrc local_sdkrc = this._sdke;
        _sdkkc local_sdkkc = new _sdkkc(localWPSAuthentication2, local_sdkrc);
        this._sdkf = local_sdkkc;
        return;
      }
  }

  public void _sdka(WPSAuthentication paramWPSAuthentication)
  {
    if ((this._sdkb == null) || (paramWPSAuthentication == null))
    {
      if (this._sdkb != paramWPSAuthentication)
      {
        _sdkc();
        _sdkd();
        if (_sdkc._sdkb == 0);
      }
    }
    else if (!this._sdkb.equals(paramWPSAuthentication))
    {
      _sdkc();
      _sdkd();
    }
    this._sdkb = paramWPSAuthentication;
    if ((this._sdkb != null) && (this._sdkb.getUsername() != null) && (this._sdkb.getUsername().length() != 0) && (this._sdkb.getRealm() != null) && (this._sdkb.getRealm().length() != 0))
      return;
    com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
    String str = z[3];
    local_sdkhb._sdkb(str);
    this._sdkb = null;
  }

  public void _sdka(_sdkrc param_sdkrc)
  {
    if (param_sdkrc == null)
    {
      String str1 = z[1];
      throw new IllegalArgumentException(str1);
    }
    if (this._sdke.equals(param_sdkrc))
      return;
    _sdkd();
    this._sdke = param_sdkrc;
    com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
    String str2 = z[0];
    local_sdkhb._sdkb(str2);
  }

  public void _sdka(_sdkzb param_sdkzb, ArrayList<_sdkhb> paramArrayList)
  {
    int i = _sdkc._sdkb;
    if (!param_sdkzb.hasBeacons())
      return;
    _sdka();
    if (this._sdkf != null)
    {
      this._sdkf._sdka(param_sdkzb, paramArrayList);
      if (!paramArrayList.isEmpty())
        return;
    }
    if (this._sdkd == null)
      return;
    Iterator localIterator = param_sdkzb.getAPs().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      _sdkjc local_sdkjc = (_sdkjc)localIterator.next();
      Object localObject1 = null;
      try
      {
        _sdkcb local_sdkcb1 = this._sdkd;
        _sdkic local_sdkic = local_sdkjc._sdka();
        _sdktd local_sdktd = local_sdkcb1._sdka(local_sdkic);
        localObject2 = local_sdktd;
        if (localObject2 != null)
        {
          Object localObject3 = ((_sdktd)localObject2).second;
          boolean bool = paramArrayList.add(localObject3);
        }
        if (i == 0)
          continue;
        return;
      }
      catch (_sdkc local_sdkc)
      {
        while (true)
        {
          com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
          String str = z[5];
          local_sdkhb._sdkd(str);
          _sdkcb local_sdkcb2 = this._sdkd;
          _sdkeb local_sdkeb = local_sdkc._sdka();
          local_sdkcb2._sdka(local_sdkeb);
          Object localObject2 = localObject1;
        }
      }
    }
  }

  public void _sdka(List<String> paramList)
  {
    if ((this._sdkc == null) || (paramList == null))
    {
      if (this._sdkc != paramList)
      {
        _sdkc();
        if (_sdkc._sdkb == 0);
      }
    }
    else if (!this._sdkc.equals(paramList))
      _sdkc();
    this._sdkc = paramList;
    if ((this._sdkc != null) && (!this._sdkc.isEmpty()))
      return;
    com.skyhookwireless._sdkhb local_sdkhb = this._sdka;
    String str = z[4];
    local_sdkhb._sdkb(str);
    this._sdkc = null;
  }

  public void _sdkb()
  {
    if (this._sdkf == null)
      return;
    this._sdkf._sdkb();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdky
 * JD-Core Version:    0.6.2
 */