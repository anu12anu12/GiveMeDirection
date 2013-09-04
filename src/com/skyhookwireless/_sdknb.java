package com.skyhookwireless;

import java.io.File;

final class _sdknb
{
  private static final String[] _sdka;
  private static final char[] _sdkb;
  private static int _sdkc;
  private static File _sdkd;
  private static long _sdke;
  private static _sdkh _sdkf;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[3];
    Object localObject1 = "Mh5b_M-eJ\007a{zQ\001m Q\f#,fMM?oV\rc?ZQ\005\"7yP\004".toCharArray();
    int j = localObject1.length;
    int k;
    Object localObject2;
    int m;
    int i2;
    int i3;
    if (j <= i)
    {
      k = 0;
      localObject2 = localObject1;
      m = k;
      int n = j;
      Object localObject3 = localObject1;
      int i1 = n;
      while (true)
      {
        i2 = localObject3[k];
        switch (m % 5)
        {
        default:
          i3 = 62;
          int i4 = (char)(i3 ^ i2);
          localObject3[k] = i4;
          k = m + 1;
          if (i1 != 0)
            break label129;
          localObject3 = localObject2;
          m = k;
          k = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: j = i1;
      localObject1 = localObject2;
    }
    while (j <= k)
    {
      String str1 = new String((char[])localObject1).intern();
      arrayOfString[0] = str1;
      Object localObject4 = "L#'}G\nc;}r\rkzuQ\fj".toCharArray();
      int i5 = localObject4.length;
      int i6;
      label180: int i9;
      if (i5 <= 1)
      {
        i6 = 0;
        localObject2 = localObject4;
        m = i6;
        int i7 = i5;
        Object localObject5 = localObject4;
        int i8 = i7;
        while (true)
        {
          i2 = localObject5[i6];
          switch (m % 5)
          {
          default:
            i9 = 62;
            label244: int i10 = (char)(i9 ^ i2);
            localObject5[i6] = i10;
            i6 = m + 1;
            if (i8 != 0)
              break label285;
            localObject5 = localObject2;
            int i11 = i6;
            i6 = i8;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i5 = i8;
        localObject4 = localObject2;
      }
      while (true)
      {
        if (i5 > i6)
          break label180;
        String str2 = new String((char[])localObject4).intern();
        arrayOfString[1] = str2;
        int i12 = 2;
        Object localObject6 = "M0u_\020h{eU\033d;yU.c38]\rb2".toCharArray();
        int i13 = localObject6.length;
        int i14;
        label343: int i17;
        if (i13 <= 1)
        {
          i14 = 0;
          localObject2 = localObject6;
          m = i14;
          int i15 = i13;
          Object localObject7 = localObject6;
          int i16 = i15;
          while (true)
          {
            i = localObject7[i14];
            switch (m % 5)
            {
            default:
              i17 = 62;
              label408: int i18 = (char)(i17 ^ i);
              localObject7[i14] = i18;
              i14 = m + 1;
              if (i16 != 0)
                break label448;
              localObject7 = localObject2;
              int i19 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label448: i13 = i16;
          localObject6 = localObject2;
        }
        while (true)
        {
          if (i13 > i14)
            break label343;
          String str3 = new String((char[])localObject6).intern();
          arrayOfString[i12] = str3;
          _sdka = arrayOfString;
          _sdkb = new char[32];
          _sdkc = 0;
          _sdkd = null;
          _sdke = 0L;
          _sdkf = null;
          return;
          i3 = 98;
          break;
          i3 = 12;
          break;
          i3 = 84;
          break;
          i3 = 22;
          break;
          i9 = 98;
          break label244;
          i9 = 12;
          break label244;
          i9 = 84;
          break label244;
          i9 = 22;
          break label244;
          i17 = 98;
          break label408;
          i17 = 12;
          break label408;
          i17 = 84;
          break label408;
          i17 = 22;
          break label408;
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  /** @deprecated */
  // ERROR //
  private static final boolean _sdka(_sdkh param_sdkh)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 44	com/skyhookwireless/_sdknb:_sdkc	I
    //   10: istore_3
    //   11: iload_3
    //   12: iconst_1
    //   13: iadd
    //   14: putstatic 44	com/skyhookwireless/_sdknb:_sdkc	I
    //   17: iload_3
    //   18: sipush 1023
    //   21: iand
    //   22: ifne +89 -> 111
    //   25: getstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   28: ifnonnull +54 -> 82
    //   31: getstatic 40	com/skyhookwireless/_sdknb:_sdka	[Ljava/lang/String;
    //   34: astore 4
    //   36: aload 4
    //   38: arraylength
    //   39: istore 5
    //   41: iconst_0
    //   42: istore 6
    //   44: iload 6
    //   46: iload 5
    //   48: if_icmpge +34 -> 82
    //   51: aload 4
    //   53: iload 6
    //   55: aaload
    //   56: astore 7
    //   58: new 57	java/io/File
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 8
    //   69: aload 8
    //   71: invokevirtual 64	java/io/File:exists	()Z
    //   74: ifeq +64 -> 138
    //   77: aload 8
    //   79: putstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   82: getstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   85: ifnull +26 -> 111
    //   88: getstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   91: invokevirtual 64	java/io/File:exists	()Z
    //   94: ifne +53 -> 147
    //   97: aconst_null
    //   98: putstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   101: ldc2_w 47
    //   104: putstatic 50	com/skyhookwireless/_sdknb:_sdke	J
    //   107: aconst_null
    //   108: putstatic 52	com/skyhookwireless/_sdknb:_sdkf	Lcom/skyhookwireless/_sdkh;
    //   111: getstatic 52	com/skyhookwireless/_sdknb:_sdkf	Lcom/skyhookwireless/_sdkh;
    //   114: ifnull +19 -> 133
    //   117: getstatic 52	com/skyhookwireless/_sdknb:_sdkf	Lcom/skyhookwireless/_sdkh;
    //   120: aload_0
    //   121: invokevirtual 70	com/skyhookwireless/_sdkh:compareTo	(Ljava/lang/Enum;)I
    //   124: istore 9
    //   126: iload 9
    //   128: ifgt +5 -> 133
    //   131: iconst_1
    //   132: istore_2
    //   133: ldc 2
    //   135: monitorexit
    //   136: aload_2
    //   137: ireturn
    //   138: iload 6
    //   140: iconst_1
    //   141: iadd
    //   142: istore 6
    //   144: goto -100 -> 44
    //   147: getstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   150: invokevirtual 74	java/io/File:lastModified	()J
    //   153: lstore 10
    //   155: getstatic 50	com/skyhookwireless/_sdknb:_sdke	J
    //   158: lstore 12
    //   160: lload 10
    //   162: lload 12
    //   164: lcmp
    //   165: ifle -54 -> 111
    //   168: getstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   171: invokevirtual 74	java/io/File:lastModified	()J
    //   174: putstatic 50	com/skyhookwireless/_sdknb:_sdke	J
    //   177: getstatic 46	com/skyhookwireless/_sdknb:_sdkd	Ljava/io/File;
    //   180: astore 14
    //   182: new 76	java/io/FileReader
    //   185: dup
    //   186: aload 14
    //   188: invokespecial 79	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   191: astore 6
    //   193: getstatic 42	com/skyhookwireless/_sdknb:_sdkb	[C
    //   196: astore 15
    //   198: aload 6
    //   200: aload 15
    //   202: invokevirtual 83	java/io/FileReader:read	([C)I
    //   205: istore_1
    //   206: iload_1
    //   207: ifle +25 -> 232
    //   210: getstatic 42	com/skyhookwireless/_sdknb:_sdkb	[C
    //   213: astore 16
    //   215: new 20	java/lang/String
    //   218: dup
    //   219: aload 16
    //   221: iconst_0
    //   222: iload_1
    //   223: invokespecial 86	java/lang/String:<init>	([CII)V
    //   226: invokestatic 90	com/skyhookwireless/_sdkh:valueOf	(Ljava/lang/String;)Lcom/skyhookwireless/_sdkh;
    //   229: putstatic 52	com/skyhookwireless/_sdknb:_sdkf	Lcom/skyhookwireless/_sdkh;
    //   232: aload 6
    //   234: ifnull -123 -> 111
    //   237: aload 6
    //   239: invokevirtual 93	java/io/FileReader:close	()V
    //   242: goto -131 -> 111
    //   245: astore 17
    //   247: goto -136 -> 111
    //   250: astore 18
    //   252: aconst_null
    //   253: astore 6
    //   255: aload 6
    //   257: ifnull -146 -> 111
    //   260: aload 6
    //   262: invokevirtual 93	java/io/FileReader:close	()V
    //   265: goto -154 -> 111
    //   268: astore 19
    //   270: goto -159 -> 111
    //   273: astore_2
    //   274: aconst_null
    //   275: astore 6
    //   277: aload 6
    //   279: ifnull +8 -> 287
    //   282: aload 6
    //   284: invokevirtual 93	java/io/FileReader:close	()V
    //   287: aload_2
    //   288: athrow
    //   289: astore 20
    //   291: ldc 2
    //   293: monitorexit
    //   294: aload 20
    //   296: athrow
    //   297: astore 21
    //   299: goto -12 -> 287
    //   302: astore_2
    //   303: goto -26 -> 277
    //   306: astore 22
    //   308: goto -53 -> 255
    //
    // Exception table:
    //   from	to	target	type
    //   237	242	245	java/lang/Throwable
    //   177	193	250	java/lang/Throwable
    //   260	265	268	java/lang/Throwable
    //   177	193	273	finally
    //   7	126	289	finally
    //   147	177	289	finally
    //   237	242	289	finally
    //   260	265	289	finally
    //   282	287	289	finally
    //   287	289	289	finally
    //   282	287	297	java/lang/Throwable
    //   193	232	302	finally
    //   193	232	306	java/lang/Throwable
  }

  static boolean _sdkb(_sdkh param_sdkh)
  {
    return _sdka(param_sdkh);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdknb
 * JD-Core Version:    0.6.2
 */