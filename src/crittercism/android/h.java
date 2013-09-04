package crittercism.android;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public final class h
{
  private static final byte[] a;
  private static final byte[] b = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] c;

  static
  {
    try
    {
      byte[] arrayOfByte1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes("UTF-8");
      arrayOfByte2 = arrayOfByte1;
      a = arrayOfByte2;
      c = new byte[] { 247, 247, 247, 247, 247, 247, 247, 247, 247, 251, 251, 247, 247, 251, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 251, 247, 247, 247, 247, 247, 247, 247, 247, 247, 247, 62, 247, 247, 247, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 247, 247, 247, 255, 247, 247, 247, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 247, 247, 247, 247, 247, 247, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 247, 247, 247, 247 };
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        byte[] arrayOfByte2 = b;
    }
  }

  private static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int i = 1;
    if (paramArrayOfByte1[2] == 61)
    {
      byte[] arrayOfByte1 = c;
      int j = paramArrayOfByte1[0];
      int k = (arrayOfByte1[j] & 0xFF) << 18;
      byte[] arrayOfByte2 = c;
      int m = paramArrayOfByte1[1];
      int n = (arrayOfByte2[m] & 0xFF) << 12;
      int i1 = (byte)((k | n) >>> 16);
      paramArrayOfByte2[paramInt] = i1;
    }
    while (true)
    {
      return i;
      if (paramArrayOfByte1[3] == 61)
      {
        byte[] arrayOfByte3 = c;
        int i2 = paramArrayOfByte1[0];
        int i3 = (arrayOfByte3[i2] & 0xFF) << 18;
        byte[] arrayOfByte4 = c;
        int i4 = paramArrayOfByte1[1];
        int i5 = (arrayOfByte4[i4] & 0xFF) << 12 | i3;
        byte[] arrayOfByte5 = c;
        int i6 = paramArrayOfByte1[2];
        int i7 = (arrayOfByte5[i6] & 0xFF) << 6;
        int i8 = i5 | i7;
        int i9 = (byte)(i8 >>> 16);
        paramArrayOfByte2[paramInt] = i9;
        int i10 = paramInt + 1;
        int i11 = (byte)(i8 >>> 8);
        paramArrayOfByte2[i10] = i11;
        i = 2;
      }
      else
      {
        try
        {
          byte[] arrayOfByte6 = c;
          int i12 = paramArrayOfByte1[0];
          int i13 = (arrayOfByte6[i12] & 0xFF) << 18;
          byte[] arrayOfByte7 = c;
          int i14 = paramArrayOfByte1[1];
          int i15 = (arrayOfByte7[i14] & 0xFF) << 12;
          int i16 = i13 | i15;
          byte[] arrayOfByte8 = c;
          int i17 = paramArrayOfByte1[2];
          int i18 = (arrayOfByte8[i17] & 0xFF) << 6;
          int i19 = i16 | i18;
          byte[] arrayOfByte9 = c;
          int i20 = paramArrayOfByte1[3];
          int i21 = arrayOfByte9[i20] & 0xFF;
          int i22 = i19 | i21;
          int i23 = (byte)(i22 >> 16);
          paramArrayOfByte2[paramInt] = i23;
          int i24 = paramInt + 1;
          int i25 = (byte)(i22 >> 8);
          paramArrayOfByte2[i24] = i25;
          int i26 = paramInt + 2;
          int i27 = (byte)i22;
          paramArrayOfByte2[i26] = i27;
          i = 3;
        }
        catch (Exception localException)
        {
          PrintStream localPrintStream1 = System.out;
          StringBuilder localStringBuilder1 = new StringBuilder();
          int i28 = paramArrayOfByte1[0];
          StringBuilder localStringBuilder2 = localStringBuilder1.append(i28).append(": ");
          byte[] arrayOfByte10 = c;
          int i29 = paramArrayOfByte1[0];
          int i30 = arrayOfByte10[i29];
          String str1 = i30;
          localPrintStream1.println(str1);
          PrintStream localPrintStream2 = System.out;
          StringBuilder localStringBuilder3 = new StringBuilder();
          int i31 = paramArrayOfByte1[1];
          StringBuilder localStringBuilder4 = localStringBuilder3.append(i31).append(": ");
          byte[] arrayOfByte11 = c;
          int i32 = paramArrayOfByte1[1];
          int i33 = arrayOfByte11[i32];
          String str2 = i33;
          localPrintStream2.println(str2);
          PrintStream localPrintStream3 = System.out;
          StringBuilder localStringBuilder5 = new StringBuilder();
          int i34 = paramArrayOfByte1[2];
          StringBuilder localStringBuilder6 = localStringBuilder5.append(i34).append(": ");
          byte[] arrayOfByte12 = c;
          int i35 = paramArrayOfByte1[2];
          int i36 = arrayOfByte12[i35];
          String str3 = i36;
          localPrintStream3.println(str3);
          PrintStream localPrintStream4 = System.out;
          StringBuilder localStringBuilder7 = new StringBuilder();
          int i37 = paramArrayOfByte1[3];
          StringBuilder localStringBuilder8 = localStringBuilder7.append(i37).append(": ");
          byte[] arrayOfByte13 = c;
          int i38 = paramArrayOfByte1[3];
          int i39 = arrayOfByte13[i38];
          String str4 = i39;
          localPrintStream4.println(str4);
          i = -1;
        }
      }
    }
  }

  public static String a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return a(paramArrayOfByte, i);
  }

  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt * 4 / 3;
    if (paramInt % 3 > 0);
    byte[] arrayOfByte1;
    int i2;
    int i3;
    for (int j = 4; ; j = 0)
    {
      int k = j + i;
      int m = i / 76;
      arrayOfByte1 = new byte[k + m];
      int n = paramInt + -2;
      Object localObject = null;
      i2 = 0;
      i3 = 0;
      while (i3 < n)
      {
        int i4 = i3 + 0;
        byte[] arrayOfByte2 = a(paramArrayOfByte, i4, 3, arrayOfByte1, i2);
        int i1 = localObject + 4;
        if (i1 == 76)
        {
          int i5 = i2 + 4;
          arrayOfByte1[i5] = 10;
          i2 += 1;
          int i6 = 0;
        }
        i3 += 3;
        i2 += 4;
      }
    }
    if (i3 < paramInt)
    {
      int i7 = i3 + 0;
      int i8 = paramInt - i3;
      byte[] arrayOfByte3 = a(paramArrayOfByte, i7, i8, arrayOfByte1, i2);
      i2 += 4;
    }
    try
    {
      str = new String(arrayOfByte1, 0, i2, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        String str = new String(arrayOfByte1, 0, i2);
    }
  }

  // ERROR //
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: ldc 18
    //   7: invokevirtual 24	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   10: astore_3
    //   11: aload_3
    //   12: astore 4
    //   14: aload 4
    //   16: arraylength
    //   17: istore 5
    //   19: iload 5
    //   21: iconst_3
    //   22: imul
    //   23: iconst_4
    //   24: idiv
    //   25: newarray byte
    //   27: astore 6
    //   29: iconst_4
    //   30: newarray byte
    //   32: astore 7
    //   34: iconst_0
    //   35: istore 8
    //   37: iconst_0
    //   38: istore 9
    //   40: aconst_null
    //   41: astore 10
    //   43: iload 5
    //   45: iconst_0
    //   46: iadd
    //   47: istore 11
    //   49: iload 8
    //   51: iload 11
    //   53: if_icmpge +487 -> 540
    //   56: aload 4
    //   58: iload 8
    //   60: baload
    //   61: bipush 127
    //   63: iand
    //   64: i2b
    //   65: istore 12
    //   67: getstatic 28	crittercism/android/h:c	[B
    //   70: iload 12
    //   72: baload
    //   73: istore 13
    //   75: iload 13
    //   77: bipush 255
    //   79: if_icmplt +218 -> 297
    //   82: iload 13
    //   84: bipush 255
    //   86: if_icmplt +443 -> 529
    //   89: iload 9
    //   91: iconst_1
    //   92: iadd
    //   93: istore 14
    //   95: aload 7
    //   97: iload 9
    //   99: iload 12
    //   101: bastore
    //   102: iload 14
    //   104: iconst_3
    //   105: if_icmple +417 -> 522
    //   108: aload 7
    //   110: aload 6
    //   112: aload 10
    //   114: invokestatic 78	crittercism/android/h:a	([B[BI)I
    //   117: aload 10
    //   119: iadd
    //   120: astore 15
    //   122: bipush 61
    //   124: istore 9
    //   126: iload 12
    //   128: iload 9
    //   130: if_icmpeq +230 -> 360
    //   133: aload 15
    //   135: newarray byte
    //   137: astore 16
    //   139: aload 6
    //   141: iconst_0
    //   142: aload 16
    //   144: iconst_0
    //   145: aload 15
    //   147: invokestatic 82	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   150: aload 16
    //   152: ifnull +131 -> 283
    //   155: aload 16
    //   157: arraylength
    //   158: iconst_4
    //   159: if_icmplt +124 -> 283
    //   162: aload 16
    //   164: iconst_0
    //   165: baload
    //   166: sipush 255
    //   169: iand
    //   170: istore 17
    //   172: aload 16
    //   174: iconst_1
    //   175: baload
    //   176: bipush 8
    //   178: ishl
    //   179: ldc 83
    //   181: iand
    //   182: istore 18
    //   184: iload 17
    //   186: iload 18
    //   188: ior
    //   189: istore 19
    //   191: ldc 84
    //   193: iload 19
    //   195: if_icmpeq +88 -> 283
    //   198: sipush 2048
    //   201: newarray byte
    //   203: astore 10
    //   205: new 86	java/io/ByteArrayOutputStream
    //   208: dup
    //   209: invokespecial 87	java/io/ByteArrayOutputStream:<init>	()V
    //   212: astore 15
    //   214: new 89	java/io/ByteArrayInputStream
    //   217: dup
    //   218: aload 16
    //   220: invokespecial 92	java/io/ByteArrayInputStream:<init>	([B)V
    //   223: istore 9
    //   225: new 94	java/util/zip/GZIPInputStream
    //   228: dup
    //   229: iload 9
    //   231: invokespecial 97	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   234: istore_2
    //   235: iload_2
    //   236: aload 10
    //   238: invokevirtual 101	java/util/zip/GZIPInputStream:read	([B)I
    //   241: istore 20
    //   243: iload 20
    //   245: iflt +139 -> 384
    //   248: aload 15
    //   250: aload 10
    //   252: iconst_0
    //   253: iload 20
    //   255: invokevirtual 104	java/io/ByteArrayOutputStream:write	([BII)V
    //   258: goto -23 -> 235
    //   261: astore 21
    //   263: iload_2
    //   264: istore 20
    //   266: iload 9
    //   268: istore_2
    //   269: aload 15
    //   271: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   274: iload 20
    //   276: invokevirtual 108	java/util/zip/GZIPInputStream:close	()V
    //   279: iload_2
    //   280: invokevirtual 109	java/io/ByteArrayInputStream:close	()V
    //   283: aload 16
    //   285: areturn
    //   286: astore 22
    //   288: aload_0
    //   289: invokevirtual 112	java/lang/String:getBytes	()[B
    //   292: astore 4
    //   294: goto -280 -> 14
    //   297: getstatic 115	java/lang/System:err	Ljava/io/PrintStream;
    //   300: astore 23
    //   302: new 39	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 117
    //   308: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: iload 8
    //   313: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: ldc 48
    //   318: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: astore 24
    //   323: aload 4
    //   325: iload 8
    //   327: baload
    //   328: istore 25
    //   330: aload 24
    //   332: iload 25
    //   334: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: ldc 121
    //   339: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: astore 26
    //   347: aload 23
    //   349: aload 26
    //   351: invokevirtual 61	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   354: aconst_null
    //   355: astore 16
    //   357: goto -207 -> 150
    //   360: aload 15
    //   362: astore 27
    //   364: iconst_0
    //   365: istore 14
    //   367: iload 8
    //   369: iconst_1
    //   370: iadd
    //   371: istore 8
    //   373: aload 27
    //   375: astore 10
    //   377: iload 14
    //   379: istore 28
    //   381: goto -338 -> 43
    //   384: aload 15
    //   386: invokevirtual 124	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   389: astore 29
    //   391: aload 29
    //   393: astore 16
    //   395: aload 15
    //   397: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   400: iload_2
    //   401: invokevirtual 108	java/util/zip/GZIPInputStream:close	()V
    //   404: iload 9
    //   406: invokevirtual 109	java/io/ByteArrayInputStream:close	()V
    //   409: goto -126 -> 283
    //   412: astore 30
    //   414: goto -131 -> 283
    //   417: astore 31
    //   419: aconst_null
    //   420: astore 15
    //   422: iconst_0
    //   423: istore 9
    //   425: aload 15
    //   427: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   430: iload_1
    //   431: invokevirtual 108	java/util/zip/GZIPInputStream:close	()V
    //   434: iload 9
    //   436: invokevirtual 109	java/io/ByteArrayInputStream:close	()V
    //   439: aload 31
    //   441: athrow
    //   442: astore 32
    //   444: goto -170 -> 274
    //   447: astore 33
    //   449: goto -170 -> 279
    //   452: astore 34
    //   454: goto -24 -> 430
    //   457: astore 35
    //   459: goto -25 -> 434
    //   462: astore 36
    //   464: goto -25 -> 439
    //   467: astore 37
    //   469: goto -69 -> 400
    //   472: astore 38
    //   474: goto -70 -> 404
    //   477: astore 31
    //   479: iconst_0
    //   480: istore 9
    //   482: goto -57 -> 425
    //   485: astore 31
    //   487: goto -62 -> 425
    //   490: astore 31
    //   492: iload_2
    //   493: istore_1
    //   494: goto -69 -> 425
    //   497: astore 39
    //   499: aconst_null
    //   500: astore 15
    //   502: iconst_0
    //   503: istore_2
    //   504: goto -235 -> 269
    //   507: astore 40
    //   509: iconst_0
    //   510: istore_2
    //   511: goto -242 -> 269
    //   514: astore 41
    //   516: iload 9
    //   518: istore_2
    //   519: goto -250 -> 269
    //   522: aload 10
    //   524: astore 27
    //   526: goto -159 -> 367
    //   529: iload 9
    //   531: istore 14
    //   533: aload 10
    //   535: astore 27
    //   537: goto -170 -> 367
    //   540: aload 10
    //   542: astore 15
    //   544: goto -411 -> 133
    //
    // Exception table:
    //   from	to	target	type
    //   235	258	261	java/io/IOException
    //   384	391	261	java/io/IOException
    //   4	11	286	java/io/UnsupportedEncodingException
    //   279	283	412	java/lang/Exception
    //   404	409	412	java/lang/Exception
    //   205	214	417	finally
    //   269	274	442	java/lang/Exception
    //   274	279	447	java/lang/Exception
    //   425	430	452	java/lang/Exception
    //   430	434	457	java/lang/Exception
    //   434	439	462	java/lang/Exception
    //   395	400	467	java/lang/Exception
    //   400	404	472	java/lang/Exception
    //   214	225	477	finally
    //   225	235	485	finally
    //   235	258	490	finally
    //   384	391	490	finally
    //   205	214	497	java/io/IOException
    //   214	225	507	java/io/IOException
    //   225	235	514	java/io/IOException
  }

  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = 0;
    int j;
    int m;
    label40: int i2;
    if (paramInt2 > 0)
    {
      j = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      if (paramInt2 <= 1)
        break label112;
      int k = paramInt1 + 1;
      m = paramArrayOfByte1[k] << 24 >>> 16;
      int n = m | j;
      if (paramInt2 > 2)
      {
        int i1 = paramInt1 + 2;
        i = paramArrayOfByte1[i1] << 24 >>> 24;
      }
      i2 = i | n;
      switch (paramInt2)
      {
      default:
      case 3:
      case 2:
      case 1:
      }
    }
    while (true)
    {
      return paramArrayOfByte2;
      j = 0;
      break;
      label112: m = 0;
      break label40;
      byte[] arrayOfByte1 = a;
      int i3 = i2 >>> 18;
      int i4 = arrayOfByte1[i3];
      paramArrayOfByte2[paramInt3] = i4;
      int i5 = paramInt3 + 1;
      byte[] arrayOfByte2 = a;
      int i6 = i2 >>> 12 & 0x3F;
      int i7 = arrayOfByte2[i6];
      paramArrayOfByte2[i5] = i7;
      int i8 = paramInt3 + 2;
      byte[] arrayOfByte3 = a;
      int i9 = i2 >>> 6 & 0x3F;
      int i10 = arrayOfByte3[i9];
      paramArrayOfByte2[i8] = i10;
      int i11 = paramInt3 + 3;
      byte[] arrayOfByte4 = a;
      int i12 = i2 & 0x3F;
      int i13 = arrayOfByte4[i12];
      paramArrayOfByte2[i11] = i13;
      continue;
      byte[] arrayOfByte5 = a;
      int i14 = i2 >>> 18;
      int i15 = arrayOfByte5[i14];
      paramArrayOfByte2[paramInt3] = i15;
      int i16 = paramInt3 + 1;
      byte[] arrayOfByte6 = a;
      int i17 = i2 >>> 12 & 0x3F;
      int i18 = arrayOfByte6[i17];
      paramArrayOfByte2[i16] = i18;
      int i19 = paramInt3 + 2;
      byte[] arrayOfByte7 = a;
      int i20 = i2 >>> 6 & 0x3F;
      int i21 = arrayOfByte7[i20];
      paramArrayOfByte2[i19] = i21;
      int i22 = paramInt3 + 3;
      paramArrayOfByte2[i22] = 61;
      continue;
      byte[] arrayOfByte8 = a;
      int i23 = i2 >>> 18;
      int i24 = arrayOfByte8[i23];
      paramArrayOfByte2[paramInt3] = i24;
      int i25 = paramInt3 + 1;
      byte[] arrayOfByte9 = a;
      int i26 = i2 >>> 12 & 0x3F;
      int i27 = arrayOfByte9[i26];
      paramArrayOfByte2[i25] = i27;
      int i28 = paramInt3 + 2;
      paramArrayOfByte2[i28] = 61;
      int i29 = paramInt3 + 3;
      paramArrayOfByte2[i29] = 61;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     crittercism.android.h
 * JD-Core Version:    0.6.2
 */