package com.flurry.android;

import java.util.Map;

final class i
{
  private int a;
  private String b;
  private Map c;
  private long d;
  private boolean e;
  private long f;

  public i(String paramString, Map paramMap, long paramLong, boolean paramBoolean)
  {
    int i = FlurryAgent.f();
    this.a = i;
    this.b = paramString;
    this.c = paramMap;
    this.d = paramLong;
    this.e = paramBoolean;
  }

  public final void a(long paramLong)
  {
    long l1 = this.d;
    long l2 = paramLong - l1;
    this.f = l2;
    StringBuilder localStringBuilder1 = new StringBuilder().append("Ended event '");
    String str1 = this.b;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("' (");
    long l3 = this.d;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(l3).append(") after ");
    long l4 = this.f;
    String str2 = l4 + "ms";
    int i = ai.a("FlurryAgent", str2);
  }

  public final boolean a(String paramString)
  {
    if ((this.e) && (this.f == 0L) && (this.b.equals(paramString)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  // ERROR //
  public final byte[] a()
  {
    // Byte code:
    //   0: new 82	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 83	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 85	java/io/DataOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 88	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 28	com/flurry/android/i:a	I
    //   21: istore_3
    //   22: aload_2
    //   23: iload_3
    //   24: invokevirtual 92	java/io/DataOutputStream:writeShort	(I)V
    //   27: aload_0
    //   28: getfield 30	com/flurry/android/i:b	Ljava/lang/String;
    //   31: astore 4
    //   33: aload_2
    //   34: aload 4
    //   36: invokevirtual 96	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 32	com/flurry/android/i:c	Ljava/util/Map;
    //   43: ifnonnull +53 -> 96
    //   46: aload_2
    //   47: iconst_0
    //   48: invokevirtual 92	java/io/DataOutputStream:writeShort	(I)V
    //   51: aload_0
    //   52: getfield 34	com/flurry/android/i:d	J
    //   55: lstore 5
    //   57: aload_2
    //   58: lload 5
    //   60: invokevirtual 99	java/io/DataOutputStream:writeLong	(J)V
    //   63: aload_0
    //   64: getfield 39	com/flurry/android/i:f	J
    //   67: lstore 7
    //   69: aload_2
    //   70: lload 7
    //   72: invokevirtual 99	java/io/DataOutputStream:writeLong	(J)V
    //   75: aload_2
    //   76: invokevirtual 102	java/io/DataOutputStream:flush	()V
    //   79: aload_1
    //   80: invokevirtual 105	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: astore 9
    //   85: aload 9
    //   87: astore 10
    //   89: aload_2
    //   90: invokestatic 110	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   93: aload 10
    //   95: areturn
    //   96: aload_0
    //   97: getfield 32	com/flurry/android/i:c	Ljava/util/Map;
    //   100: invokeinterface 115 1 0
    //   105: istore 11
    //   107: aload_2
    //   108: iload 11
    //   110: invokevirtual 92	java/io/DataOutputStream:writeShort	(I)V
    //   113: aload_0
    //   114: getfield 32	com/flurry/android/i:c	Ljava/util/Map;
    //   117: invokeinterface 119 1 0
    //   122: invokeinterface 125 1 0
    //   127: astore 12
    //   129: aload 12
    //   131: invokeinterface 131 1 0
    //   136: ifeq -85 -> 51
    //   139: aload 12
    //   141: invokeinterface 135 1 0
    //   146: checkcast 137	java/util/Map$Entry
    //   149: astore 13
    //   151: aload 13
    //   153: invokeinterface 140 1 0
    //   158: checkcast 73	java/lang/String
    //   161: sipush 255
    //   164: invokestatic 143	com/flurry/android/r:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   167: astore 14
    //   169: aload_2
    //   170: aload 14
    //   172: invokevirtual 96	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   175: aload 13
    //   177: invokeinterface 146 1 0
    //   182: checkcast 73	java/lang/String
    //   185: sipush 255
    //   188: invokestatic 143	com/flurry/android/r:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   191: astore 15
    //   193: aload_2
    //   194: aload 15
    //   196: invokevirtual 96	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   199: goto -70 -> 129
    //   202: astore 16
    //   204: aload_2
    //   205: astore 17
    //   207: iconst_0
    //   208: istore 18
    //   210: iload 18
    //   212: newarray byte
    //   214: astore 10
    //   216: aload 17
    //   218: invokestatic 110	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   221: goto -128 -> 93
    //   224: astore 19
    //   226: aconst_null
    //   227: astore_2
    //   228: aload 19
    //   230: astore 20
    //   232: aload_2
    //   233: invokestatic 110	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   236: aload 20
    //   238: athrow
    //   239: astore 20
    //   241: goto -9 -> 232
    //   244: astore 20
    //   246: aload 17
    //   248: astore_2
    //   249: goto -17 -> 232
    //   252: astore 21
    //   254: aconst_null
    //   255: astore 17
    //   257: goto -50 -> 207
    //
    // Exception table:
    //   from	to	target	type
    //   17	85	202	java/io/IOException
    //   96	199	202	java/io/IOException
    //   0	17	224	finally
    //   17	85	239	finally
    //   96	199	239	finally
    //   210	216	244	finally
    //   0	17	252	java/io/IOException
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.i
 * JD-Core Version:    0.6.2
 */