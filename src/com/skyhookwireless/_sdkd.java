package com.skyhookwireless;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.List;

class _sdkd extends PhoneStateListener
{
  private static final String[] z;
  final _sdku _sdka;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[11];
    Object localObject2 = "%S1\031{<T\001\031Z>\\\026\031J\"\\\f\033l.\025".toCharArray();
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
          i2 = 9;
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
      Object localObject5 = "/E\001\031y>T\r\022)#SB\023g\031X\020\n`)X1\bh>X!\024h$Z\007\030!c".toCharArray();
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
            i8 = 9;
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
        Object localObject7 = "+N\027\\f?IB\023oj_\r\tg.NN\\j&\\\017\f`$ZB\bfjP\013\022`'H\017".toCharArray();
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
              i17 = 9;
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
          Object localObject9 = "/E\001\031y>T\r\022)#SB\023g\031T\005\022h&n\026\016l$Z\026\024J\"\\\f\033l.".toCharArray();
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
                i25 = 9;
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
            Object localObject11 = "%S1\025n$\\\016/}8X\f\033}\"~\n\035g-X\006T".toCharArray();
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
                  i33 = 9;
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
              Object localObject13 = "$X\025\\d+T\f\\j/Q\016F)".toCharArray();
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
                    i41 = 9;
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
                Object localObject15 = ")X\016\020)$R\026\\N\031p".toCharArray();
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
                      i49 = 9;
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
                  Object localObject17 = "-R\026\\l<X\f\b)=U\013\020lj^\016\023z/Y".toCharArray();
                  int i53 = localObject17.length;
                  int i54;
                  label1169: int i57;
                  if (i53 <= 1)
                  {
                    i54 = 0;
                    localObject3 = localObject17;
                    k = i54;
                    int i55 = i53;
                    Object localObject18 = localObject17;
                    int i56 = i55;
                    while (true)
                    {
                      i16 = localObject18[i54];
                      switch (k % 5)
                      {
                      default:
                        i57 = 9;
                        label1236: int i58 = (char)(i57 ^ i16);
                        localObject18[i54] = i58;
                        i54 = k + 1;
                        if (i56 != 0)
                          break label1277;
                        localObject18 = localObject3;
                        int i59 = i54;
                        i54 = i56;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i53 = i56;
                    localObject17 = localObject3;
                  }
                  while (true)
                  {
                    if (i53 > i54)
                      break label1169;
                    String str8 = new String((char[])localObject17).intern();
                    arrayOfString[i52] = str8;
                    int i60 = 8;
                    Object localObject19 = "/E\001\031y>T\r\022)#SB\023g\tX\016\020E%^\003\b`%S!\024h$Z\007\030".toCharArray();
                    int i61 = localObject19.length;
                    int i62;
                    label1337: int i65;
                    if (i61 <= 1)
                    {
                      i62 = 0;
                      localObject3 = localObject19;
                      k = i62;
                      int i63 = i61;
                      Object localObject20 = localObject19;
                      int i64 = i63;
                      while (true)
                      {
                        i16 = localObject20[i62];
                        switch (k % 5)
                        {
                        default:
                          i65 = 9;
                          label1404: int i66 = (char)(i65 ^ i16);
                          localObject20[i62] = i66;
                          i62 = k + 1;
                          if (i64 != 0)
                            break label1445;
                          localObject20 = localObject3;
                          int i67 = i62;
                          i62 = i64;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1445: i61 = i64;
                      localObject19 = localObject3;
                    }
                    while (true)
                    {
                      if (i61 > i62)
                        break label1337;
                      String str9 = new String((char[])localObject19).intern();
                      arrayOfString[i60] = str9;
                      Object localObject21 = "%S!\031e&q\r\037h>T\r\022J\"\\\f\033l.\025".toCharArray();
                      int i68 = localObject21.length;
                      label1501: int i73;
                      label1568: int i70;
                      if (i68 <= 1)
                      {
                        int i69 = 0;
                        localObject3 = localObject21;
                        k = i69;
                        int i71 = i68;
                        Object localObject23 = localObject21;
                        int i72 = i71;
                        while (true)
                        {
                          i60 = localObject23[i69];
                          switch (k % 5)
                          {
                          default:
                            i73 = 9;
                            int i74 = (char)(i73 ^ i60);
                            localObject23[i69] = i74;
                            i70 = k + 1;
                            if (i72 != 0)
                              break label1609;
                            localObject23 = localObject3;
                            int i75 = i70;
                            i70 = i72;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1609: i68 = i72;
                        localObject21 = localObject3;
                      }
                      while (true)
                      {
                        if (i68 > i70)
                          break label1501;
                        String str10 = new String((char[])localObject21).intern();
                        arrayOfString[9] = str10;
                        int i76 = 10;
                        Object localObject24 = "-R\026\\|$V\f\023~$\035!\031e&q\r\037h>T\r\022)9H��\037e+N\021".toCharArray();
                        Object localObject25 = localObject24.length;
                        label1666: Object localObject27;
                        Object localObject28;
                        label1685: int i77;
                        if (localObject25 <= 1)
                        {
                          localObject22 = localObject24;
                          localObject3 = localObject1;
                          Object localObject26 = localObject25;
                          localObject27 = localObject24;
                          localObject28 = localObject26;
                          i60 = localObject27[localObject1];
                          switch (localObject3 % 5)
                          {
                          default:
                            i77 = 9;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        while (true)
                        {
                          int i78 = (char)(i77 ^ i60);
                          localObject27[localObject1] = i78;
                          localObject1 = localObject3 + 1;
                          if (localObject28 == 0)
                          {
                            localObject27 = localObject22;
                            int i79 = localObject1;
                            localObject1 = localObject28;
                            break label1685;
                          }
                          localObject25 = localObject28;
                          localObject24 = localObject22;
                          if (localObject25 > localObject1)
                            break label1666;
                          String str11 = new String((char[])localObject24).intern();
                          arrayOfString[i76] = str11;
                          z = arrayOfString;
                          return;
                          i2 = 74;
                          break;
                          i2 = 61;
                          break;
                          i2 = 98;
                          break;
                          i2 = 124;
                          break;
                          i8 = 74;
                          break label244;
                          i8 = 61;
                          break label244;
                          i8 = 98;
                          break label244;
                          i8 = 124;
                          break label244;
                          i17 = 74;
                          break label408;
                          i17 = 61;
                          break label408;
                          i17 = 98;
                          break label408;
                          i17 = 124;
                          break label408;
                          i25 = 74;
                          break label572;
                          i25 = 61;
                          break label572;
                          i25 = 98;
                          break label572;
                          i25 = 124;
                          break label572;
                          i33 = 74;
                          break label736;
                          i33 = 61;
                          break label736;
                          i33 = 98;
                          break label736;
                          i33 = 124;
                          break label736;
                          i41 = 74;
                          break label900;
                          i41 = 61;
                          break label900;
                          i41 = 98;
                          break label900;
                          i41 = 124;
                          break label900;
                          i49 = 74;
                          break label1068;
                          i49 = 61;
                          break label1068;
                          i49 = 98;
                          break label1068;
                          i49 = 124;
                          break label1068;
                          i57 = 74;
                          break label1236;
                          i57 = 61;
                          break label1236;
                          i57 = 98;
                          break label1236;
                          i57 = 124;
                          break label1236;
                          i65 = 74;
                          break label1404;
                          i65 = 61;
                          break label1404;
                          i65 = 98;
                          break label1404;
                          i65 = 124;
                          break label1404;
                          i73 = 74;
                          break label1568;
                          i73 = 61;
                          break label1568;
                          i73 = 98;
                          break label1568;
                          i73 = 124;
                          break label1568;
                          i77 = 74;
                          continue;
                          i77 = 61;
                          continue;
                          i77 = 98;
                          continue;
                          i77 = 124;
                        }
                        Object localObject22 = null;
                      }
                      i62 = 0;
                    }
                    i54 = 0;
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

  _sdkd(_sdku param_sdku)
  {
  }

  // ERROR //
  public void onCellLocationChanged(CellLocation paramCellLocation)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   4: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   7: invokestatic 69	com/skyhookwireless/_sdksc:_sdka	(Lcom/skyhookwireless/_sdksc;)Lcom/skyhookwireless/_sdkhb;
    //   10: invokevirtual 75	com/skyhookwireless/_sdkhb:_sdkb	()Z
    //   13: ifeq +56 -> 69
    //   16: aload_0
    //   17: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   20: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   23: invokestatic 69	com/skyhookwireless/_sdksc:_sdka	(Lcom/skyhookwireless/_sdksc;)Lcom/skyhookwireless/_sdkhb;
    //   26: astore_2
    //   27: new 77	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   34: astore_3
    //   35: getstatic 48	com/skyhookwireless/_sdkd:z	[Ljava/lang/String;
    //   38: bipush 9
    //   40: aaload
    //   41: astore 4
    //   43: aload_3
    //   44: aload 4
    //   46: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: ldc 87
    //   55: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 5
    //   63: aload_2
    //   64: aload 5
    //   66: invokevirtual 93	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   69: aload_1
    //   70: checkcast 95	android/telephony/gsm/GsmCellLocation
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   78: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   81: astore 6
    //   83: aload 6
    //   85: monitorenter
    //   86: aload_0
    //   87: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   90: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   93: invokestatic 98	com/skyhookwireless/_sdksc:_sdkb	(Lcom/skyhookwireless/_sdksc;)Landroid/telephony/TelephonyManager;
    //   96: ifnonnull +98 -> 194
    //   99: aload_0
    //   100: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   103: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   106: invokestatic 69	com/skyhookwireless/_sdksc:_sdka	(Lcom/skyhookwireless/_sdksc;)Lcom/skyhookwireless/_sdkhb;
    //   109: astore 7
    //   111: getstatic 48	com/skyhookwireless/_sdkd:z	[Ljava/lang/String;
    //   114: bipush 7
    //   116: aaload
    //   117: astore 8
    //   119: aload 7
    //   121: aload 8
    //   123: invokevirtual 93	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   126: aload 6
    //   128: monitorexit
    //   129: return
    //   130: astore 9
    //   132: aload_0
    //   133: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   136: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   139: invokestatic 69	com/skyhookwireless/_sdksc:_sdka	(Lcom/skyhookwireless/_sdksc;)Lcom/skyhookwireless/_sdkhb;
    //   142: astore 10
    //   144: getstatic 48	com/skyhookwireless/_sdkd:z	[Ljava/lang/String;
    //   147: bipush 10
    //   149: aaload
    //   150: astore 11
    //   152: aload 10
    //   154: aload 11
    //   156: aload 9
    //   158: invokevirtual 102	com/skyhookwireless/_sdkhb:_sdkc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: return
    //   162: astore 12
    //   164: aload_0
    //   165: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   168: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   171: invokestatic 69	com/skyhookwireless/_sdksc:_sdka	(Lcom/skyhookwireless/_sdksc;)Lcom/skyhookwireless/_sdkhb;
    //   174: astore 13
    //   176: getstatic 48	com/skyhookwireless/_sdkd:z	[Ljava/lang/String;
    //   179: bipush 8
    //   181: aaload
    //   182: astore 14
    //   184: aload 13
    //   186: aload 14
    //   188: aload 12
    //   190: invokevirtual 105	com/skyhookwireless/_sdkhb:_sdke	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: return
    //   194: aload_1
    //   195: ifnull +35 -> 230
    //   198: aload_1
    //   199: invokevirtual 109	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   202: bipush 255
    //   204: if_icmpeq +26 -> 230
    //   207: aload_1
    //   208: invokevirtual 112	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   211: bipush 255
    //   213: if_icmpeq +17 -> 230
    //   216: aload_1
    //   217: invokevirtual 109	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   220: ifne +20 -> 240
    //   223: aload_1
    //   224: invokevirtual 112	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   227: ifne +13 -> 240
    //   230: aload_0
    //   231: getfield 51	com/skyhookwireless/_sdkd:_sdka	Lcom/skyhookwireless/_sdku;
    //   234: getfield 64	com/skyhookwireless/_sdku:_sdka	Lcom/skyhookwireless/_sdksc;
    //   237: invokestatic 116	com/skyhookwireless/_sdksc:_sdkg	(Lcom/skyhookwireless/_sdksc;)V
    //   240: aload 6
    //   242: monitorexit
    //   243: return
    //   244: astore 9
    //   246: aload 6
    //   248: monitorexit
    //   249: aload 9
    //   251: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   69	74	130	java/lang/ClassCastException
    //   0	69	162	java/lang/Throwable
    //   69	74	162	java/lang/Throwable
    //   74	86	162	java/lang/Throwable
    //   132	161	162	java/lang/Throwable
    //   249	252	162	java/lang/Throwable
    //   86	129	244	finally
    //   198	244	244	finally
  }

  public void onServiceStateChanged(ServiceState paramServiceState)
  {
    try
    {
      if (_sdksc._sdka(this._sdka._sdka)._sdkb())
      {
        _sdkhb local_sdkhb1 = _sdksc._sdka(this._sdka._sdka);
        StringBuilder localStringBuilder = new StringBuilder();
        String str1 = z[0];
        String str2 = str1 + paramServiceState + ")";
        local_sdkhb1._sdkb(str2);
      }
      switch (paramServiceState.getState())
      {
      case 2:
      default:
        return;
      case 1:
      case 3:
      }
      _sdksc._sdkg(this._sdka._sdka);
      return;
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb2 = _sdksc._sdka(this._sdka._sdka);
      String str3 = z[1];
      local_sdkhb2._sdke(str3, localThrowable);
    }
  }

  public void onSignalStrengthChanged(int paramInt)
  {
    int i = _sdkab._sdkf;
    try
    {
      if (_sdksc._sdka(this._sdka._sdka)._sdkb())
      {
        _sdkhb local_sdkhb1 = _sdksc._sdka(this._sdka._sdka);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[4];
        String str2 = str1 + paramInt + ")";
        local_sdkhb1._sdkb(str2);
      }
      synchronized (this._sdka._sdka)
      {
        if (_sdksc._sdkb(this._sdka._sdka) == null)
        {
          _sdkhb local_sdkhb2 = _sdksc._sdka(this._sdka._sdka);
          String str3 = z[7];
          local_sdkhb2._sdkb(str3);
          return;
        }
        CellLocation localCellLocation = _sdksc._sdkb(this._sdka._sdka).getCellLocation();
        if (!(localCellLocation instanceof GsmCellLocation))
        {
          _sdkhb local_sdkhb3 = _sdksc._sdka(this._sdka._sdka);
          String str4 = z[6];
          local_sdkhb3._sdkb(str4);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      _sdkhb local_sdkhb4 = _sdksc._sdka(this._sdka._sdka);
      String str5 = z[3];
      local_sdkhb4._sdke(str5, localThrowable);
      return;
    }
    GsmCellLocation localGsmCellLocation = (GsmCellLocation)localObject;
    if ((_sdksc._sdkc(this._sdka._sdka) != null) && (_sdksc._sdkd(this._sdka._sdka) != null) && (_sdksc._sdke(this._sdka._sdka) != null))
    {
      if (localGsmCellLocation != null)
      {
        int j = _sdksc._sdkc(this._sdka._sdka)._sdkc();
        int k = localGsmCellLocation.getLac();
        if (j != k)
        {
          int m = _sdksc._sdkc(this._sdka._sdka)._sdkb();
          int n = localGsmCellLocation.getCid();
          if (m == n)
            break label342;
        }
      }
      _sdksc._sdkf(this._sdka._sdka);
    }
    label342: if ((localGsmCellLocation == null) || (localGsmCellLocation.getCid() == -1) || (localGsmCellLocation.getLac() == -1) || ((localGsmCellLocation.getCid() == 0) && (localGsmCellLocation.getLac() == 0)))
    {
      _sdksc._sdkg(this._sdka._sdka);
      if (i == 0);
    }
    else
    {
      if (_sdksc._sdkc(this._sdka._sdka) != null)
      {
        int i1 = _sdksc._sdkc(this._sdka._sdka)._sdkc();
        int i2 = localGsmCellLocation.getLac();
        if (i1 != i2)
        {
          int i3 = _sdksc._sdkc(this._sdka._sdka)._sdkb();
          int i4 = localGsmCellLocation.getCid();
          if (i3 == i4)
            break label629;
        }
      }
      _sdksc local_sdksc2 = this._sdka._sdka;
      _sdkv local_sdkv1 = _sdksc._sdka(this._sdka._sdka, localGsmCellLocation);
      _sdkv local_sdkv2 = _sdksc._sdka(local_sdksc2, local_sdkv1);
      _sdkhb local_sdkhb5 = _sdksc._sdka(this._sdka._sdka);
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str6 = z[5];
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str6);
      _sdkv local_sdkv3 = _sdksc._sdkc(this._sdka._sdka);
      String str7 = local_sdkv3;
      local_sdkhb5._sdkb(str7);
      if (_sdksc._sdkc(this._sdka._sdka) != null)
      {
        _sdksc local_sdksc3 = this._sdka._sdka;
        _sdksc local_sdksc4 = this._sdka._sdka;
        _sdkv local_sdkv4 = _sdksc._sdkc(this._sdka._sdka);
        List localList1 = _sdksc._sdkb(local_sdksc4, local_sdkv4);
        List localList2 = _sdksc._sdka(local_sdksc3, localList1);
      }
      label629: if (!_sdkab._sdka(paramInt))
      {
        _sdksc local_sdksc5 = this._sdka._sdka;
        Integer localInteger1 = Integer.valueOf(_sdkab._sdkb(paramInt));
        Integer localInteger2 = _sdksc._sdka(local_sdksc5, localInteger1);
        if (i == 0);
      }
      else
      {
        _sdkhb local_sdkhb6 = _sdksc._sdka(this._sdka._sdka);
        String str8 = z[2];
        local_sdkhb6._sdkd(str8);
        _sdksc local_sdksc6 = this._sdka._sdka;
        Integer localInteger3 = Integer.valueOf(65423);
        Integer localInteger4 = _sdksc._sdka(local_sdksc6, localInteger3);
      }
      _sdksc local_sdksc7 = this._sdka._sdka;
      _sdkec local_sdkec1 = _sdkec._sdkd();
      _sdkec local_sdkec2 = _sdksc._sdka(local_sdksc7, local_sdkec1);
      _sdksc._sdkh(this._sdka._sdka);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkd
 * JD-Core Version:    0.6.2
 */