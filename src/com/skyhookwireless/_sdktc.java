package com.skyhookwireless;

import com.skyhookwireless.wps._sdkib;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class _sdktc extends _sdkpc
{
  private static final _sdkhb _sdkf;
  private static final WeakHashMap<_sdktc, Boolean> _sdkg;
  private static final _sdktd<Object, Method> _sdkh;
  private static _sdkib _sdki;
  private static final String[] z;
  private final _sdkt _sdkc;
  private boolean _sdkd = false;
  private _sdkib _sdke = null;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[6];
    Object localObject2 = "K\027t_zZ\006xT*G\001aUaG\001p\032zA\003{_x".toCharArray();
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
          i2 = 10;
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
      Object localObject5 = "B��t[~G��y\032c]OyU~\016\0167\\cVC7Sm@��eSdI".toCharArray();
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
            i8 = 10;
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
        Object localObject7 = "K\034cSgO\033r^*B��t[~G��y\032kI\n7Xk]\ns\032e@OgHoX\006xOy\016\003xYkZ\006xT0\016".toCharArray();
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
              i17 = 10;
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
          Object localObject9 = "B��t[~G��y\032bO\0347Te\016\016p_&\016\006pTe\\\006y]".toCharArray();
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
                i25 = 10;
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
            Object localObject11 = "O\013sveM\016cSe@G".toCharArray();
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
                  i34 = 10;
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
              Object localObject14 = "K\034cSgO\033r^*O\br\032c]OgHeL\016uVs\016\033xU*G\001vYi[\035vNo\002O~]dA\035~Tm\016\003xYkZ\006xT".toCharArray();
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
                  i38 = 10;
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
                _sdkf = _sdkhb._sdkb(_sdktc.class);
                _sdkg = new WeakHashMap();
                _sdkh = null;
                return;
                i2 = 46;
                break;
                i2 = 111;
                break;
                i2 = 23;
                break;
                i2 = 58;
                break;
                i8 = 46;
                break label244;
                i8 = 111;
                break label244;
                i8 = 23;
                break label244;
                i8 = 58;
                break label244;
                i17 = 46;
                break label408;
                i17 = 111;
                break label408;
                i17 = 23;
                break label408;
                i17 = 58;
                break label408;
                i25 = 46;
                break label572;
                i25 = 111;
                break label572;
                i25 = 23;
                break label572;
                i25 = 58;
                break label572;
                i34 = 46;
                break label736;
                i34 = 111;
                break label736;
                i34 = 23;
                break label736;
                i34 = 58;
                break label736;
                i38 = 46;
                continue;
                i38 = 111;
                continue;
                i38 = 23;
                continue;
                i38 = 58;
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

  public _sdktc(_sdkt param_sdkt)
  {
    this._sdkc = param_sdkt;
  }

  // ERROR //
  static void _sdka(_sdktc param_sdktc)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 65	com/skyhookwireless/_sdktc:_sdkg	Ljava/util/WeakHashMap;
    //   6: astore_1
    //   7: iconst_1
    //   8: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   11: astore_2
    //   12: aload_1
    //   13: aload_0
    //   14: aload_2
    //   15: invokevirtual 89	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: astore_3
    //   19: getstatic 91	com/skyhookwireless/_sdktc:_sdki	Lcom/skyhookwireless/wps/_sdkib;
    //   22: ifnull +14 -> 36
    //   25: getstatic 91	com/skyhookwireless/_sdktc:_sdki	Lcom/skyhookwireless/wps/_sdkib;
    //   28: astore 4
    //   30: aload_0
    //   31: aload 4
    //   33: invokespecial 94	com/skyhookwireless/_sdktc:_sdka	(Lcom/skyhookwireless/wps/_sdkib;)V
    //   36: ldc 2
    //   38: monitorexit
    //   39: getstatic 67	com/skyhookwireless/_sdktc:_sdkh	Lcom/skyhookwireless/_sdktd;
    //   42: ifnonnull +4 -> 46
    //   45: return
    //   46: getstatic 67	com/skyhookwireless/_sdktc:_sdkh	Lcom/skyhookwireless/_sdktd;
    //   49: getfield 100	com/skyhookwireless/_sdktd:second	Ljava/lang/Object;
    //   52: checkcast 102	java/lang/reflect/Method
    //   55: astore 5
    //   57: getstatic 67	com/skyhookwireless/_sdktc:_sdkh	Lcom/skyhookwireless/_sdktd;
    //   60: getfield 105	com/skyhookwireless/_sdktd:first	Ljava/lang/Object;
    //   63: astore 6
    //   65: iconst_1
    //   66: anewarray 107	java/lang/Object
    //   69: astore 7
    //   71: aload_0
    //   72: getfield 75	com/skyhookwireless/_sdktc:_sdkc	Lcom/skyhookwireless/_sdkt;
    //   75: astore 8
    //   77: aload 7
    //   79: iconst_0
    //   80: aload 8
    //   82: aastore
    //   83: aload 5
    //   85: aload 6
    //   87: aload 7
    //   89: invokevirtual 111	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 9
    //   94: return
    //   95: astore 10
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload 10
    //   102: athrow
    //   103: astore 11
    //   105: getstatic 59	com/skyhookwireless/_sdktc:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   108: astore 12
    //   110: getstatic 51	com/skyhookwireless/_sdktc:z	[Ljava/lang/String;
    //   113: iconst_0
    //   114: aaload
    //   115: astore 13
    //   117: aload 12
    //   119: aload 13
    //   121: aload 11
    //   123: invokevirtual 114	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //
    // Exception table:
    //   from	to	target	type
    //   3	39	95	finally
    //   97	100	95	finally
    //   46	94	103	java/lang/Throwable
  }

  /** @deprecated */
  private void _sdka(_sdkib param_sdkib)
  {
    try
    {
      boolean bool = _sdka();
      if (!bool);
      while (true)
      {
        return;
        this._sdke = param_sdkib;
        _sdka();
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  static void _sdkb(_sdktc param_sdktc)
  {
    try
    {
      Object localObject1 = _sdkg.remove(param_sdktc);
      return;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }

  public static void _sdkb(_sdkib param_sdkib)
  {
    int i = _sdkuc._sdkd;
    if (_sdkf._sdkb())
    {
      _sdkhb local_sdkhb1 = _sdkf;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = z[4];
      String str2 = str1 + param_sdkib + ")";
      local_sdkhb1._sdkb(str2);
    }
    synchronized (_sdktc.class)
    {
      if (_sdki != null)
      {
        if (param_sdkib.getAge() == null)
        {
          long l1 = _sdki.getAge()._sdka();
          long l2 = param_sdkib.getTime();
          long l3 = _sdki.getTime();
          long l4 = l2 - l3;
          long l5 = l1 - l4;
          if (_sdkf._sdkb())
          {
            _sdkhb local_sdkhb2 = _sdkf;
            StringBuilder localStringBuilder2 = new StringBuilder();
            String str3 = z[2];
            String str4 = str3 + l5;
            local_sdkhb2._sdkb(str4);
          }
          if ((l5 < 63536L) || (l5 > 2000L))
          {
            _sdkhb local_sdkhb3 = _sdkf;
            String str5 = z[5];
            local_sdkhb3._sdkb(str5);
            return;
          }
          _sdkec local_sdkec = _sdkec._sdka(Math.max(0L, l5));
          param_sdkib.setAge(local_sdkec);
          if (i == 0);
        }
      }
      else if (((param_sdkib.getLatitude() == 0.0D) && (param_sdkib.getLongitude() == 0.0D)) || (!param_sdkib.hasHPE()))
      {
        _sdkhb local_sdkhb4 = _sdkf;
        String str6 = z[1];
        local_sdkhb4._sdkb(str6);
        return;
      }
    }
    if (param_sdkib.getAge() == null)
    {
      _sdkhb local_sdkhb5 = _sdkf;
      String str7 = z[3];
      local_sdkhb5._sdkb(str7);
      return;
    }
    _sdki = param_sdkib;
    Iterator localIterator = _sdkg.keySet().iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      ((_sdktc)localIterator.next())._sdka(param_sdkib);
    }
    while (i == 0);
    if (!_sdkhb._sdkd)
      return;
    _sdkuc._sdkd = i + 1;
  }

  /** @deprecated */
  public void _sdka(List<_sdkib> paramList)
  {
    try
    {
      if (this._sdke != null)
      {
        _sdkib local_sdkib = this._sdke;
        boolean bool = paramList.add(local_sdkib);
        this._sdke = null;
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
  public boolean _sdka()
  {
    try
    {
      boolean bool = this._sdkd;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void _sdkb()
  {
    Object localObject1 = null;
    try
    {
      this._sdkd = true;
      _sdka(this);
      return;
    }
    finally
    {
    }
  }

  public void _sdkc()
  {
    Object localObject1 = null;
    try
    {
      this._sdkd = false;
      this._sdke = null;
      _sdkb(this);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdktc
 * JD-Core Version:    0.6.2
 */