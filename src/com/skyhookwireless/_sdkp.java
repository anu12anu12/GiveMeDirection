package com.skyhookwireless;

public abstract class _sdkp
{
  public static final boolean allowSetPrototypes = false;
  public static final String configuration;
  public static final boolean disableWifiIfConnected = true;
  public static final boolean enableInternalLogging = false;
  public static final boolean forceEnableWifi = true;
  public static final String logFilePath;
  public static final _sdkg loggerType;
  public static final String minLogLevel;
  public static final boolean noGpsProviderInjection = false;
  public static final long noSatIgnorePeriod = 2000L;
  public static final boolean useGoogleFallback;
  public static final boolean useGpsPoller;
  private static final String[] z;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[8];
    Object localObject2 = "2F+PHoQ`DYnY T\007iM;".toCharArray();
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
          i2 = 41;
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
      logFilePath = new String((char[])localObject2).intern();
      Object localObject5 = "9N-F@qQaPFsS&T\\oT;ZFsH".toCharArray();
      int i4 = localObject5.length;
      int i5;
      label176: int i8;
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
            i8 = 41;
            label240: int i9 = (char)(i8 ^ i1);
            localObject6[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label281;
            localObject6 = localObject3;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label281: i4 = i7;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i5)
          break label176;
        configuration = new String((char[])localObject5).intern();
        Object localObject7 = "Yp\rfn".toCharArray();
        int i11 = localObject7.length;
        int i12;
        label332: int i15;
        if (i11 <= 1)
        {
          i12 = 0;
          localObject3 = localObject7;
          k = i12;
          int i13 = i11;
          Object localObject8 = localObject7;
          int i14 = i13;
          while (true)
          {
            i1 = localObject8[i12];
            switch (k % 5)
            {
            default:
              i15 = 41;
              label396: int i16 = (char)(i15 ^ i1);
              localObject8[i12] = i16;
              i12 = k + 1;
              if (i14 != 0)
                break label437;
              localObject8 = localObject3;
              int i17 = i12;
              i12 = i14;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label437: i11 = i14;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i11 > i12)
            break label332;
          minLogLevel = new String((char[])localObject7).intern();
          Object localObject9 = "1\025+ZZ|W#V~tS&zO^Z!]L~A*W\024".toCharArray();
          int i18 = localObject9.length;
          int i19;
          label488: int i22;
          if (i18 <= 1)
          {
            i19 = 0;
            localObject3 = localObject9;
            k = i19;
            int i20 = i18;
            Object localObject10 = localObject9;
            int i21 = i20;
            while (true)
            {
              i1 = localObject10[i19];
              switch (k % 5)
              {
              default:
                i22 = 41;
                label552: int i23 = (char)(i22 ^ i1);
                localObject10[i19] = i23;
                i19 = k + 1;
                if (i21 != 0)
                  break label593;
                localObject10 = localObject3;
                int i24 = i19;
                i19 = i21;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label593: i18 = i21;
            localObject9 = localObject3;
          }
          while (true)
          {
            if (i18 > i19)
              break label488;
            String str1 = new String((char[])localObject9).intern();
            arrayOfString[0] = str1;
            Object localObject11 = "1\025:@LZZ TExs._ET,X\024".toCharArray();
            int i25 = localObject11.length;
            int i26;
            label648: int i29;
            if (i25 <= 1)
            {
              i26 = 0;
              localObject3 = localObject11;
              k = i26;
              int i27 = i25;
              Object localObject12 = localObject11;
              int i28 = i27;
              while (true)
              {
                i1 = localObject12[i26];
                switch (k % 5)
                {
                default:
                  i29 = 41;
                  label712: int i30 = (char)(i29 ^ i1);
                  localObject12[i26] = i30;
                  i26 = k + 1;
                  if (i28 != 0)
                    break label753;
                  localObject12 = localObject3;
                  int i31 = i26;
                  i26 = i28;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label753: i25 = i28;
              localObject11 = localObject3;
            }
            while (true)
            {
              if (i25 > i26)
                break label648;
              String str2 = new String((char[])localObject11).intern();
              arrayOfString[1] = str2;
              int i32 = 2;
              Object localObject13 = "1\025!\\nmF\037AFk\\+V[T[%VJi\\ ]\024".toCharArray();
              int i33 = localObject13.length;
              int i34;
              label811: int i37;
              int i38;
              if (i33 <= 1)
              {
                i34 = 0;
                localObject3 = localObject13;
                k = i34;
                int i35 = i33;
                Object localObject14 = localObject13;
                int i36 = i35;
                while (true)
                {
                  i37 = localObject14[i34];
                  switch (k % 5)
                  {
                  default:
                    i38 = 41;
                    label876: int i39 = (char)(i38 ^ i37);
                    localObject14[i34] = i39;
                    i34 = k + 1;
                    if (i36 != 0)
                      break label917;
                    localObject14 = localObject3;
                    int i40 = i34;
                    i34 = i36;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label917: i33 = i36;
                localObject13 = localObject3;
              }
              while (true)
              {
                if (i33 > i34)
                  break label811;
                String str3 = new String((char[])localObject13).intern();
                arrayOfString[i32] = str3;
                int i41 = 3;
                Object localObject15 = "1\025!\\z|A\006TGrG*cLo\\ W\024".toCharArray();
                int i42 = localObject15.length;
                int i43;
                label976: int i46;
                if (i42 <= 1)
                {
                  i43 = 0;
                  localObject3 = localObject15;
                  k = i43;
                  int i44 = i42;
                  Object localObject16 = localObject15;
                  int i45 = i44;
                  while (true)
                  {
                    i37 = localObject16[i43];
                    switch (k % 5)
                    {
                    default:
                      i46 = 41;
                      label1040: int i47 = (char)(i46 ^ i37);
                      localObject16[i43] = i47;
                      i43 = k + 1;
                      if (i45 != 0)
                        break label1081;
                      localObject16 = localObject3;
                      int i48 = i43;
                      i43 = i45;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1081: i42 = i45;
                  localObject15 = localObject3;
                }
                while (true)
                {
                  if (i42 > i43)
                    break label976;
                  String str4 = new String((char[])localObject15).intern();
                  arrayOfString[i41] = str4;
                  int i49 = 4;
                  Object localObject17 = "1\025)\\[~P\n]HY*d@{\\r".toCharArray();
                  int i50 = localObject17.length;
                  int i51;
                  label1140: int i54;
                  if (i50 <= 1)
                  {
                    i51 = 0;
                    localObject3 = localObject17;
                    k = i51;
                    int i52 = i50;
                    Object localObject18 = localObject17;
                    int i53 = i52;
                    while (true)
                    {
                      i37 = localObject18[i51];
                      switch (k % 5)
                      {
                      default:
                        i54 = 41;
                        label1204: int i55 = (char)(i54 ^ i37);
                        localObject18[i51] = i55;
                        i51 = k + 1;
                        if (i53 != 0)
                          break label1245;
                        localObject18 = localObject3;
                        int i56 = i51;
                        i51 = i53;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1245: i50 = i53;
                    localObject17 = localObject3;
                  }
                  while (true)
                  {
                    if (i50 > i51)
                      break label1140;
                    String str5 = new String((char[])localObject17).intern();
                    arrayOfString[i49] = str5;
                    int i57 = 5;
                    Object localObject19 = "1\025#\\N[\\#Vy|A'\016\006nQ,R[y\0328CZqZ(\035]eA".toCharArray();
                    int i58 = localObject19.length;
                    int i59;
                    label1304: int i62;
                    if (i58 <= 1)
                    {
                      i59 = 0;
                      localObject3 = localObject19;
                      k = i59;
                      int i60 = i58;
                      Object localObject20 = localObject19;
                      int i61 = i60;
                      while (true)
                      {
                        i37 = localObject20[i59];
                        switch (k % 5)
                        {
                        default:
                          i62 = 41;
                          label1368: int i63 = (char)(i62 ^ i37);
                          localObject20[i59] = i63;
                          i59 = k + 1;
                          if (i61 != 0)
                            break label1409;
                          localObject20 = localObject3;
                          int i64 = i59;
                          i59 = i61;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1409: i58 = i61;
                      localObject19 = localObject3;
                    }
                    while (true)
                    {
                      if (i58 > i59)
                        break label1304;
                      String str6 = new String((char[])localObject19).intern();
                      arrayOfString[i57] = str6;
                      int i65 = 6;
                      Object localObject21 = "1\025\"ZGQZ(LkP#\016".toCharArray();
                      int i66 = localObject21.length;
                      label1469: int i71;
                      label1536: int i68;
                      if (i66 <= 1)
                      {
                        int i67 = 0;
                        localObject3 = localObject21;
                        k = i67;
                        int i69 = i66;
                        Object localObject23 = localObject21;
                        int i70 = i69;
                        while (true)
                        {
                          i37 = localObject23[i67];
                          switch (k % 5)
                          {
                          default:
                            i71 = 41;
                            int i72 = (char)(i71 ^ i37);
                            localObject23[i67] = i72;
                            i68 = k + 1;
                            if (i70 != 0)
                              break label1577;
                            localObject23 = localObject3;
                            int i73 = i68;
                            i68 = i70;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1577: i66 = i70;
                        localObject21 = localObject3;
                      }
                      while (true)
                      {
                        if (i66 > i68)
                          break label1469;
                        String str7 = new String((char[])localObject21).intern();
                        arrayOfString[i65] = str7;
                        int i74 = 7;
                        Object localObject24 = "FW:ZEy\033,\\G{\\(F[|A&\\G \0214Q\\tY+\035Jr[)ZNhG.G@r[2\037\t|Y#\\^NP;c[rA GPmP<\016O|Y<V\005=@<VnmF\037\\EqP=\016O|Y<V\005=Y TNxG\033JYx\b".toCharArray();
                        Object localObject25 = localObject24.length;
                        label1634: Object localObject27;
                        Object localObject28;
                        label1653: int i75;
                        if (localObject25 <= 1)
                        {
                          localObject22 = localObject24;
                          localObject3 = localObject1;
                          Object localObject26 = localObject25;
                          localObject27 = localObject24;
                          localObject28 = localObject26;
                          i65 = localObject27[localObject1];
                          switch (localObject3 % 5)
                          {
                          default:
                            i75 = 41;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        while (true)
                        {
                          int i76 = (char)(i75 ^ i65);
                          localObject27[localObject1] = i76;
                          localObject1 = localObject3 + 1;
                          if (localObject28 == 0)
                          {
                            localObject27 = localObject22;
                            int i77 = localObject1;
                            localObject1 = localObject28;
                            break label1653;
                          }
                          localObject25 = localObject28;
                          localObject24 = localObject22;
                          if (localObject25 > localObject1)
                            break label1634;
                          String str8 = new String((char[])localObject24).intern();
                          arrayOfString[i74] = str8;
                          z = arrayOfString;
                          loggerType = _sdkg.BUILT_IN;
                          return;
                          i2 = 29;
                          break;
                          i2 = 53;
                          break;
                          i2 = 79;
                          break;
                          i2 = 51;
                          break;
                          i8 = 29;
                          break label240;
                          i8 = 53;
                          break label240;
                          i8 = 79;
                          break label240;
                          i8 = 51;
                          break label240;
                          i15 = 29;
                          break label396;
                          i15 = 53;
                          break label396;
                          i15 = 79;
                          break label396;
                          i15 = 51;
                          break label396;
                          i22 = 29;
                          break label552;
                          i22 = 53;
                          break label552;
                          i22 = 79;
                          break label552;
                          i22 = 51;
                          break label552;
                          i29 = 29;
                          break label712;
                          i29 = 53;
                          break label712;
                          i29 = 79;
                          break label712;
                          i29 = 51;
                          break label712;
                          i38 = 29;
                          break label876;
                          i38 = 53;
                          break label876;
                          i38 = 79;
                          break label876;
                          i38 = 51;
                          break label876;
                          i46 = 29;
                          break label1040;
                          i46 = 53;
                          break label1040;
                          i46 = 79;
                          break label1040;
                          i46 = 51;
                          break label1040;
                          i54 = 29;
                          break label1204;
                          i54 = 53;
                          break label1204;
                          i54 = 79;
                          break label1204;
                          i54 = 51;
                          break label1204;
                          i62 = 29;
                          break label1368;
                          i62 = 53;
                          break label1368;
                          i62 = 79;
                          break label1368;
                          i62 = 51;
                          break label1368;
                          i71 = 29;
                          break label1536;
                          i71 = 53;
                          break label1536;
                          i71 = 79;
                          break label1536;
                          i71 = 51;
                          break label1536;
                          i75 = 29;
                          continue;
                          i75 = 53;
                          continue;
                          i75 = 79;
                          continue;
                          i75 = 51;
                        }
                        Object localObject22 = null;
                      }
                      i59 = 0;
                    }
                    i51 = 0;
                  }
                  i43 = 0;
                }
                i34 = 0;
              }
              i26 = 0;
            }
            i19 = 0;
          }
          i12 = 0;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  public static String _sdka()
  {
    boolean bool1 = _sdkec._sdkc;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[7];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    _sdkg local_sdkg1 = loggerType;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(local_sdkg1);
    String str2 = z[6];
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str2);
    String str3 = minLogLevel;
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str3);
    _sdkg local_sdkg2 = loggerType;
    _sdkg local_sdkg3 = _sdkg.FILE;
    String str4;
    String str10;
    if (local_sdkg2 == local_sdkg3)
    {
      str4 = z[5];
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str4);
      String str5 = z[4];
      StringBuilder localStringBuilder7 = localStringBuilder6.append(str5).append(true);
      String str6 = z[0];
      StringBuilder localStringBuilder8 = localStringBuilder7.append(str6).append(true);
      String str7 = z[3];
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str7).append(2000L);
      String str8 = z[2];
      StringBuilder localStringBuilder10 = localStringBuilder9.append(str8).append(false);
      String str9 = z[1];
      str10 = str9 + false + "]";
      if (bool1)
        if (!_sdkhb._sdkd)
          break label240;
    }
    label240: for (boolean bool2 = false; ; bool2 = true)
    {
      _sdkhb._sdkd = bool2;
      return str10;
      str4 = "";
      break;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkp
 * JD-Core Version:    0.6.2
 */