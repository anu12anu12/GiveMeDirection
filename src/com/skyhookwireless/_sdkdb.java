package com.skyhookwireless;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.LocationManager;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class _sdkdb
  implements GpsStatus.Listener
{
  private static final String[] z;
  private final _sdkhb _sdka;
  private final LocationManager _sdkb;
  private boolean _sdkc;
  private int _sdkd;
  private int _sdke;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[9];
    Object localObject2 = ".\017'X\034#G&\024\031)\004rS\b>@!@\0319\025!\024\024$\023&Q\026(\022r\034\n(\024'F\026(\004rR\031!\0237\035".toCharArray();
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
          i2 = 120;
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
      Object localObject5 = ".\017'X\034#G&\024\031)\004rS\b>@!@\0319\025!\024\024$\023&Q\026(\022".toCharArray();
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
            i8 = 120;
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
        Object localObject7 = ",\0046Q\034m\007\"GX>\0243@\r>@zG\0319\005>X\0219\005{\024\024$\023&Q\026(\022".toCharArray();
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
              i17 = 120;
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
          Object localObject9 = ".\017'X\034#G&\024\n(\r=B\035m\007\"GX>\0243@\r>@>]\0139\005<Q\n".toCharArray();
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
                i25 = 120;
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
            Object localObject11 = "?\005?[\016(\004rS\b>@!@\0319\025!\024P>\001&Q\024!\t&QQm\f;G\f(\0167F".toCharArray();
            int i29 = localObject11.length;
            int i30;
            label672: int i33;
            if (i29 <= 1)
            {
              i30 = 0;
              localObject3 = localObject11;
              k = i30;
              int i31 = i29;
              Object localObject12 = localObject11;
              int i32 = i31;
              while (true)
              {
                i16 = localObject12[i30];
                switch (k % 5)
                {
                default:
                  i33 = 120;
                  label736: int i34 = (char)(i33 ^ i16);
                  localObject12[i30] = i34;
                  i30 = k + 1;
                  if (i32 != 0)
                    break label777;
                  localObject12 = localObject3;
                  int i35 = i30;
                  i30 = i32;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i29 = i32;
              localObject11 = localObject3;
            }
            while (true)
            {
              if (i29 > i30)
                break label672;
              String str5 = new String((char[])localObject11).intern();
              arrayOfString[i28] = str5;
              int i36 = 5;
              Object localObject13 = "#\017rx\027.\001&]\027#-3Z\031*\005 \024\021#\023&U\026.\005rU\016,\t>U\032!\005".toCharArray();
              int i37 = localObject13.length;
              int i38;
              label836: int i41;
              if (i37 <= 1)
              {
                i38 = 0;
                localObject3 = localObject13;
                k = i38;
                int i39 = i37;
                Object localObject14 = localObject13;
                int i40 = i39;
                while (true)
                {
                  i16 = localObject14[i38];
                  switch (k % 5)
                  {
                  default:
                    i41 = 120;
                    label900: int i42 = (char)(i41 ^ i16);
                    localObject14[i38] = i42;
                    i38 = k + 1;
                    if (i40 != 0)
                      break label941;
                    localObject14 = localObject3;
                    int i43 = i38;
                    i38 = i40;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i37 = i40;
                localObject13 = localObject3;
              }
              while (true)
              {
                if (i37 > i38)
                  break label836;
                String str6 = new String((char[])localObject13).intern();
                arrayOfString[i36] = str6;
                int i44 = 6;
                Object localObject15 = "#\017&\024\024$\023&Q\026$\0165\024\036\"\022rA\b)\001&Q\013".toCharArray();
                int i45 = localObject15.length;
                int i46;
                label1001: int i49;
                if (i45 <= 1)
                {
                  i46 = 0;
                  localObject3 = localObject15;
                  k = i46;
                  int i47 = i45;
                  Object localObject16 = localObject15;
                  int i48 = i47;
                  while (true)
                  {
                    i16 = localObject16[i46];
                    switch (k % 5)
                    {
                    default:
                      i49 = 120;
                      label1068: int i50 = (char)(i49 ^ i16);
                      localObject16[i46] = i50;
                      i46 = k + 1;
                      if (i48 != 0)
                        break label1109;
                      localObject16 = localObject3;
                      int i51 = i46;
                      i46 = i48;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i45 = i48;
                  localObject15 = localObject3;
                }
                while (true)
                {
                  if (i45 > i46)
                    break label1001;
                  String str7 = new String((char[])localObject15).intern();
                  arrayOfString[i44] = str7;
                  int i52 = 7;
                  Object localObject17 = ">\001&Q\024!\t&QX.\017'Z\fm\t!\024\026\"\027r".toCharArray();
                  int i53 = localObject17.length;
                  label1169: int i58;
                  label1236: int i55;
                  if (i53 <= 1)
                  {
                    int i54 = 0;
                    localObject3 = localObject17;
                    k = i54;
                    int i56 = i53;
                    Object localObject19 = localObject17;
                    int i57 = i56;
                    while (true)
                    {
                      i16 = localObject19[i54];
                      switch (k % 5)
                      {
                      default:
                        i58 = 120;
                        int i59 = (char)(i58 ^ i16);
                        localObject19[i54] = i59;
                        i55 = k + 1;
                        if (i57 != 0)
                          break label1277;
                        localObject19 = localObject3;
                        int i60 = i55;
                        i55 = i57;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i53 = i57;
                    localObject17 = localObject3;
                  }
                  while (true)
                  {
                    if (i53 > i55)
                      break label1169;
                    String str8 = new String((char[])localObject17).intern();
                    arrayOfString[i52] = str8;
                    int i61 = 8;
                    Object localObject20 = "\"\016\025D\013\036\0243@\r>#:U\026*\0056\034".toCharArray();
                    Object localObject21 = localObject20.length;
                    label1334: Object localObject23;
                    Object localObject24;
                    label1353: int i62;
                    if (localObject21 <= 1)
                    {
                      localObject18 = localObject20;
                      localObject3 = localObject1;
                      Object localObject22 = localObject21;
                      localObject23 = localObject20;
                      localObject24 = localObject22;
                      i52 = localObject23[localObject1];
                      switch (localObject3 % 5)
                      {
                      default:
                        i62 = 120;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    while (true)
                    {
                      int i63 = (char)(i62 ^ i52);
                      localObject23[localObject1] = i63;
                      localObject1 = localObject3 + 1;
                      if (localObject24 == 0)
                      {
                        localObject23 = localObject18;
                        int i64 = localObject1;
                        localObject1 = localObject24;
                        break label1353;
                      }
                      localObject21 = localObject24;
                      localObject20 = localObject18;
                      if (localObject21 > localObject1)
                        break label1334;
                      String str9 = new String((char[])localObject20).intern();
                      arrayOfString[i61] = str9;
                      z = arrayOfString;
                      return;
                      i2 = 77;
                      break;
                      i2 = 96;
                      break;
                      i2 = 82;
                      break;
                      i2 = 52;
                      break;
                      i8 = 77;
                      break label244;
                      i8 = 96;
                      break label244;
                      i8 = 82;
                      break label244;
                      i8 = 52;
                      break label244;
                      i17 = 77;
                      break label408;
                      i17 = 96;
                      break label408;
                      i17 = 82;
                      break label408;
                      i17 = 52;
                      break label408;
                      i25 = 77;
                      break label572;
                      i25 = 96;
                      break label572;
                      i25 = 82;
                      break label572;
                      i25 = 52;
                      break label572;
                      i33 = 77;
                      break label736;
                      i33 = 96;
                      break label736;
                      i33 = 82;
                      break label736;
                      i33 = 52;
                      break label736;
                      i41 = 77;
                      break label900;
                      i41 = 96;
                      break label900;
                      i41 = 82;
                      break label900;
                      i41 = 52;
                      break label900;
                      i49 = 77;
                      break label1068;
                      i49 = 96;
                      break label1068;
                      i49 = 82;
                      break label1068;
                      i49 = 52;
                      break label1068;
                      i58 = 77;
                      break label1236;
                      i58 = 96;
                      break label1236;
                      i58 = 82;
                      break label1236;
                      i58 = 52;
                      break label1236;
                      i62 = 77;
                      continue;
                      i62 = 96;
                      continue;
                      i62 = 82;
                      continue;
                      i62 = 52;
                    }
                    Object localObject18 = null;
                  }
                  i46 = 0;
                }
                i38 = 0;
              }
              i30 = 0;
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

  public _sdkdb(LocationManager paramLocationManager)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkdb.class);
    this._sdka = local_sdkhb;
    this._sdkb = paramLocationManager;
  }

  static LocationManager _sdka(_sdkdb param_sdkdb)
  {
    return param_sdkdb._sdkb;
  }

  /** @deprecated */
  public boolean _sdka()
  {
    try
    {
      boolean bool1;
      if (this._sdkc)
        bool1 = this._sdkc;
      while (true)
      {
        return bool1;
        try
        {
          Future localFuture = _sdkr._sdka(new _sdkeb(this));
          TimeUnit localTimeUnit = TimeUnit.SECONDS;
          boolean bool2 = ((Boolean)localFuture.get(2L, localTimeUnit)).booleanValue();
          this._sdkc = bool2;
          if (this._sdkc)
          {
            _sdkhb local_sdkhb1 = this._sdka;
            String str1 = z[2];
            local_sdkhb1._sdkb(str1);
            if (_sdkuc._sdkd == 0);
          }
          else
          {
            _sdkhb local_sdkhb2 = this._sdka;
            String str2 = z[0];
            local_sdkhb2._sdkd(str2);
          }
          bool1 = this._sdkc;
        }
        catch (Throwable localThrowable)
        {
          while (true)
          {
            _sdkhb local_sdkhb3 = this._sdka;
            String str3 = z[1];
            local_sdkhb3._sdkd(str3, localThrowable);
          }
        }
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  // ERROR //
  public void _sdkb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/skyhookwireless/_sdkdb:_sdkc	Z
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 65	com/skyhookwireless/_sdkdb:_sdkb	Landroid/location/LocationManager;
    //   18: aload_0
    //   19: invokevirtual 118	android/location/LocationManager:removeGpsStatusListener	(Landroid/location/GpsStatus$Listener;)V
    //   22: aload_0
    //   23: getfield 63	com/skyhookwireless/_sdkdb:_sdka	Lcom/skyhookwireless/_sdkhb;
    //   26: astore_2
    //   27: getstatic 53	com/skyhookwireless/_sdkdb:z	[Ljava/lang/String;
    //   30: iconst_4
    //   31: aaload
    //   32: astore_3
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 103	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_0
    //   41: iload_1
    //   42: putfield 71	com/skyhookwireless/_sdkdb:_sdkc	Z
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 120	com/skyhookwireless/_sdkdb:_sdke	I
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 121	com/skyhookwireless/_sdkdb:_sdkd	I
    //   55: goto -44 -> 11
    //   58: astore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 4
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 63	com/skyhookwireless/_sdkdb:_sdka	Lcom/skyhookwireless/_sdkhb;
    //   70: astore 5
    //   72: getstatic 53	com/skyhookwireless/_sdkdb:z	[Ljava/lang/String;
    //   75: iconst_3
    //   76: aaload
    //   77: astore 6
    //   79: aload 5
    //   81: aload 6
    //   83: aload_1
    //   84: invokevirtual 112	com/skyhookwireless/_sdkhb:_sdkd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: goto -49 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	58	finally
    //   14	38	58	finally
    //   40	55	58	finally
    //   66	87	58	finally
    //   14	38	65	java/lang/Throwable
  }

  /** @deprecated */
  public int _sdkc()
  {
    try
    {
      int i = this._sdkd;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  public int _sdkd()
  {
    try
    {
      int i = this._sdke;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onGpsStatusChanged(int paramInt)
  {
    int i = _sdkuc._sdkd;
    if (this._sdka._sdkb())
    {
      _sdkhb local_sdkhb1 = this._sdka;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = z[8];
      String str2 = str1 + paramInt + ")";
      local_sdkhb1._sdkb(str2);
    }
    if (paramInt != 4)
      return;
    try
    {
      if (!this._sdkc)
      {
        _sdkhb local_sdkhb2 = this._sdka;
        String str3 = z[6];
        local_sdkhb2._sdkb(str3);
        return;
      }
      if (this._sdkb == null)
      {
        _sdkhb local_sdkhb3 = this._sdka;
        String str4 = z[5];
        local_sdkhb3._sdkb(str4);
        return;
      }
    }
    finally
    {
    }
    int j = 0;
    this._sdke = j;
    this._sdkd = j;
    Iterator localIterator = this._sdkb.getGpsStatus(null).getSatellites().iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
      int k = this._sdkd + 1;
      this._sdkd = k;
      if (localGpsSatellite.usedInFix())
      {
        int m = this._sdke + 1;
        this._sdke = m;
      }
    }
    while (i == 0);
    if (this._sdka._sdkb())
    {
      _sdkhb local_sdkhb4 = this._sdka;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str5 = z[7];
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str5);
      int n = this._sdke;
      StringBuilder localStringBuilder4 = localStringBuilder3.append(n).append('/');
      int i1 = this._sdkd;
      String str6 = i1;
      local_sdkhb4._sdkb(str6);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkdb
 * JD-Core Version:    0.6.2
 */