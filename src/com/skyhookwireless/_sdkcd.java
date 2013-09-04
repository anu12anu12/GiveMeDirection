package com.skyhookwireless;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;

final class _sdkcd extends _sdkad
{
  private static final String[] z;
  private final SensorEventListener _sdke;
  private final _sdkhb _sdkf;
  private final Context _sdkg;
  private SensorManager _sdkh;
  private List<_sdkwb> _sdki;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[6];
    Object localObject2 = "(O\0168 E$l# W\0177\026*B\017a2;N\007h#,S+i69U\017\036$Q\006".toCharArray();
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
          i2 = 87;
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
      Object localObject5 = "*M\005~>'FJl3(Q\036h%".toCharArray();
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
            i8 = 87;
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
        Object localObject7 = "<O\013o;,\001\036bw;D\rd$=D\030-6*B\017a2;N\007h#,SJa>:U\017c2;".toCharArray();
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
              i17 = 87;
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
          Object localObject9 = "'NJl4*D\006h%&L\017y2;\001\003cw=I\017-; R\036-8/\001\031h9:N\030~".toCharArray();
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
                i25 = 87;
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
            Object localObject11 = "(B\th;,S\005`2=D\030-6-@\032y2;\001\013a%,@\016tw&Q\017c".toCharArray();
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
                  i34 = 87;
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
              Object localObject14 = "*N\037a3iO\005yw.D\036-6*B\017a2;N\007h#,SJ`6'@\rh%iR\017! B\017".toCharArray();
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
                  i38 = 87;
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
                i2 = 73;
                break;
                i2 = 33;
                break;
                i2 = 106;
                break;
                i2 = 13;
                break;
                i8 = 73;
                break label244;
                i8 = 33;
                break label244;
                i8 = 106;
                break label244;
                i8 = 13;
                break label244;
                i17 = 73;
                break label408;
                i17 = 33;
                break label408;
                i17 = 106;
                break label408;
                i17 = 13;
                break label408;
                i25 = 73;
                break label572;
                i25 = 33;
                break label572;
                i25 = 106;
                break label572;
                i25 = 13;
                break label572;
                i34 = 73;
                break label736;
                i34 = 33;
                break label736;
                i34 = 106;
                break label736;
                i34 = 13;
                break label736;
                i38 = 73;
                continue;
                i38 = 33;
                continue;
                i38 = 106;
                continue;
                i38 = 13;
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

  public _sdkcd(_sdkt param_sdkt)
  {
    _sdkyb local_sdkyb = new _sdkyb(this);
    this._sdke = local_sdkyb;
    this._sdkh = null;
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkcd.class);
    this._sdkf = local_sdkhb;
    Context localContext = ((_sdkq)param_sdkt)._sdka();
    this._sdkg = localContext;
    ArrayList localArrayList = new ArrayList();
    this._sdki = localArrayList;
  }

  static Context _sdka(_sdkcd param_sdkcd)
  {
    return param_sdkcd._sdkg;
  }

  private boolean _sdka()
  {
    if (this._sdkh != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  static boolean _sdkb(_sdkcd param_sdkcd)
  {
    return param_sdkcd._sdka();
  }

  static _sdkhb _sdkc(_sdkcd param_sdkcd)
  {
    return param_sdkcd._sdkf;
  }

  static List _sdkd(_sdkcd param_sdkcd)
  {
    return param_sdkcd._sdki;
  }

  static void _sdke(_sdkcd param_sdkcd)
  {
    param_sdkcd._sdka();
  }

  protected _sdkad _sdka(_sdkt param_sdkt)
  {
    return new _sdkcd(param_sdkt);
  }

  public String _sdka()
  {
    return z[0];
  }

  /** @deprecated */
  // ERROR //
  public void _sdkb()
    throws _sdkl
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 85	com/skyhookwireless/_sdkcd:_sdka	()Z
    //   6: ifeq +22 -> 28
    //   9: aload_0
    //   10: getfield 67	com/skyhookwireless/_sdkcd:_sdkf	Lcom/skyhookwireless/_sdkhb;
    //   13: astore_1
    //   14: getstatic 47	com/skyhookwireless/_sdkcd:z	[Ljava/lang/String;
    //   17: iconst_4
    //   18: aaload
    //   19: astore_2
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 101	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new 103	com/skyhookwireless/_sdkxb
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 104	com/skyhookwireless/_sdkxb:<init>	(Lcom/skyhookwireless/_sdkcd;)V
    //   36: invokestatic 109	com/skyhookwireless/_sdkr:_sdka	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   39: astore_3
    //   40: getstatic 115	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   43: astore 4
    //   45: aload_3
    //   46: ldc2_w 116
    //   49: aload 4
    //   51: invokeinterface 123 4 0
    //   56: checkcast 125	android/hardware/SensorManager
    //   59: astore 5
    //   61: aload 5
    //   63: ifnonnull +48 -> 111
    //   66: getstatic 47	com/skyhookwireless/_sdkcd:z	[Ljava/lang/String;
    //   69: iconst_5
    //   70: aaload
    //   71: astore 6
    //   73: new 96	com/skyhookwireless/_sdkl
    //   76: dup
    //   77: aload 6
    //   79: invokespecial 127	com/skyhookwireless/_sdkl:<init>	(Ljava/lang/String;)V
    //   82: athrow
    //   83: astore 7
    //   85: aload_0
    //   86: monitorexit
    //   87: aload 7
    //   89: athrow
    //   90: astore 5
    //   92: getstatic 47	com/skyhookwireless/_sdkcd:z	[Ljava/lang/String;
    //   95: iconst_5
    //   96: aaload
    //   97: astore 8
    //   99: new 96	com/skyhookwireless/_sdkl
    //   102: dup
    //   103: aload 8
    //   105: aload 5
    //   107: invokespecial 130	com/skyhookwireless/_sdkl:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: athrow
    //   111: aload 5
    //   113: iconst_1
    //   114: invokevirtual 134	android/hardware/SensorManager:getSensorList	(I)Ljava/util/List;
    //   117: astore 9
    //   119: aload 9
    //   121: invokeinterface 139 1 0
    //   126: ifeq +20 -> 146
    //   129: getstatic 47	com/skyhookwireless/_sdkcd:z	[Ljava/lang/String;
    //   132: iconst_3
    //   133: aaload
    //   134: astore 10
    //   136: new 96	com/skyhookwireless/_sdkl
    //   139: dup
    //   140: aload 10
    //   142: invokespecial 127	com/skyhookwireless/_sdkl:<init>	(Ljava/lang/String;)V
    //   145: athrow
    //   146: aload_0
    //   147: getfield 57	com/skyhookwireless/_sdkcd:_sdke	Landroid/hardware/SensorEventListener;
    //   150: astore 11
    //   152: aload 9
    //   154: iconst_0
    //   155: invokeinterface 142 2 0
    //   160: checkcast 144	android/hardware/Sensor
    //   163: astore 12
    //   165: aload 5
    //   167: aload 11
    //   169: aload 12
    //   171: iconst_2
    //   172: invokevirtual 148	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   175: ifne +20 -> 195
    //   178: getstatic 47	com/skyhookwireless/_sdkcd:z	[Ljava/lang/String;
    //   181: iconst_2
    //   182: aaload
    //   183: astore 13
    //   185: new 96	com/skyhookwireless/_sdkl
    //   188: dup
    //   189: aload 13
    //   191: invokespecial 127	com/skyhookwireless/_sdkl:<init>	(Ljava/lang/String;)V
    //   194: athrow
    //   195: aload_0
    //   196: aload 5
    //   198: putfield 59	com/skyhookwireless/_sdkcd:_sdkh	Landroid/hardware/SensorManager;
    //   201: goto -176 -> 25
    //
    // Exception table:
    //   from	to	target	type
    //   2	25	83	finally
    //   28	61	83	finally
    //   66	83	83	finally
    //   92	201	83	finally
    //   28	61	90	java/lang/Throwable
  }

  /** @deprecated */
  public void _sdkc()
  {
    try
    {
      boolean bool = _sdka();
      if (!bool);
      while (true)
      {
        return;
        _sdkhb local_sdkhb = this._sdkf;
        String str = z[1];
        local_sdkhb._sdkb(str);
        SensorManager localSensorManager = this._sdkh;
        SensorEventListener localSensorEventListener = this._sdke;
        localSensorManager.unregisterListener(localSensorEventListener);
        this._sdkh = null;
        this._sdki.clear();
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  public List<_sdkwb> _sdkd()
  {
    try
    {
      List localList = this._sdki;
      ArrayList localArrayList = new ArrayList(localList);
      this._sdki.clear();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String toString()
  {
    return _sdka();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkcd
 * JD-Core Version:    0.6.2
 */