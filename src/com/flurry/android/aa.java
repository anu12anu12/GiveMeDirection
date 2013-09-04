package com.flurry.android;

import android.content.Context;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class aa
{
  private Context a;
  private v b;
  private a c;
  private volatile long d;
  private ag e;
  private ag f;
  private Map g;
  private Map h;
  private Map i;
  private Map j;
  private volatile boolean k;

  aa()
  {
    ag localag1 = new ag(100);
    this.e = localag1;
    ag localag2 = new ag(100);
    this.f = localag2;
    HashMap localHashMap1 = new HashMap();
    this.g = localHashMap1;
    HashMap localHashMap2 = new HashMap();
    this.h = localHashMap2;
    HashMap localHashMap3 = new HashMap();
    this.i = localHashMap3;
    HashMap localHashMap4 = new HashMap();
    this.j = localHashMap4;
  }

  /** @deprecated */
  private c a(byte paramByte)
  {
    try
    {
      Map localMap = this.i;
      Byte localByte = Byte.valueOf(paramByte);
      c localc = (c)localMap.get(localByte);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(int paramInt)
  {
    if (!this.g.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      this.k = bool;
      if (!this.k)
        return;
      this.b.a(paramInt);
      return;
    }
  }

  private void a(DataInputStream paramDataInputStream)
  {
    int m = 0;
    int n = ai.a("FlurryAgent", "Reading cache");
    if (paramDataInputStream.readUnsignedShort() != 2)
      return;
    long l1 = paramDataInputStream.readLong();
    this.d = l1;
    int i1 = paramDataInputStream.readUnsignedShort();
    ag localag1 = new ag(100);
    this.e = localag1;
    int i2 = 0;
    while (i2 < i1)
    {
      long l2 = paramDataInputStream.readLong();
      AdImage localAdImage = new AdImage();
      localAdImage.a(paramDataInputStream);
      ag localag2 = this.e;
      Long localLong1 = Long.valueOf(l2);
      localag2.a(localLong1, localAdImage);
      i2 += 1;
    }
    int i3 = paramDataInputStream.readUnsignedShort();
    ag localag3 = new ag(100);
    this.f = localag3;
    int i4 = 0;
    while (i4 < i3)
    {
      long l3 = paramDataInputStream.readLong();
      am localam = new am();
      if (paramDataInputStream.readBoolean())
      {
        String str1 = paramDataInputStream.readUTF();
        localam.a = str1;
      }
      if (paramDataInputStream.readBoolean())
      {
        String str2 = paramDataInputStream.readUTF();
        localam.b = str2;
      }
      int i5 = paramDataInputStream.readInt();
      localam.c = i5;
      ag localag4 = this.f;
      Long localLong2 = Long.valueOf(l3);
      localag4.a(localLong2, localam);
      i4 += 1;
    }
    int i6 = paramDataInputStream.readUnsignedShort();
    HashMap localHashMap1 = new HashMap(i6);
    this.h = localHashMap1;
    int i7 = 0;
    while (i7 < i6)
    {
      String str3 = paramDataInputStream.readUTF();
      e locale = new e(paramDataInputStream);
      Object localObject1 = this.h.put(str3, locale);
      i7 += 1;
    }
    int i8 = paramDataInputStream.readUnsignedShort();
    HashMap localHashMap2 = new HashMap(i8);
    this.g = localHashMap2;
    int i9 = 0;
    while (i9 < i8)
    {
      String str4 = paramDataInputStream.readUTF();
      int i10 = paramDataInputStream.readUnsignedShort();
      w[] arrayOfw = new w[i10];
      int i11 = 0;
      while (i11 < i10)
      {
        w localw = new w();
        localw.a(paramDataInputStream);
        arrayOfw[i11] = localw;
        i11 += 1;
      }
      Object localObject2 = this.g.put(str4, arrayOfw);
      i9 += 1;
    }
    int i12 = paramDataInputStream.readUnsignedShort();
    HashMap localHashMap3 = new HashMap();
    this.i = localHashMap3;
    int i13 = 0;
    while (i13 < i12)
    {
      byte b1 = paramDataInputStream.readByte();
      c localc = new c();
      localc.b(paramDataInputStream);
      Map localMap1 = this.i;
      Byte localByte = Byte.valueOf(b1);
      Object localObject3 = localMap1.put(localByte, localc);
      i13 += 1;
    }
    int i14 = paramDataInputStream.readUnsignedShort();
    HashMap localHashMap4 = new HashMap(i14);
    this.j = localHashMap4;
    while (m < i14)
    {
      short s = paramDataInputStream.readShort();
      long l4 = paramDataInputStream.readLong();
      Map localMap2 = this.j;
      Short localShort = Short.valueOf(s);
      Long localLong3 = Long.valueOf(l4);
      Object localObject4 = localMap2.put(localShort, localLong3);
      m += 1;
    }
    f();
    StringBuilder localStringBuilder = new StringBuilder().append("Cache read, num images: ");
    int i15 = this.e.a();
    String str5 = i15;
    int i16 = ai.a("FlurryAgent", str5);
  }

  private void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeShort(2);
    long l1 = this.d;
    paramDataOutputStream.writeLong(l1);
    List localList1 = this.e.b();
    int m = localList1.size();
    paramDataOutputStream.writeShort(m);
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
      long l2 = ((Long)localEntry1.getKey()).longValue();
      paramDataOutputStream.writeLong(l2);
      AdImage localAdImage = (AdImage)localEntry1.getValue();
      long l3 = localAdImage.a;
      paramDataOutputStream.writeLong(l3);
      int n = localAdImage.b;
      paramDataOutputStream.writeInt(n);
      int i1 = localAdImage.c;
      paramDataOutputStream.writeInt(i1);
      String str1 = localAdImage.d;
      paramDataOutputStream.writeUTF(str1);
      int i2 = localAdImage.e.length;
      paramDataOutputStream.writeInt(i2);
      byte[] arrayOfByte1 = localAdImage.e;
      paramDataOutputStream.write(arrayOfByte1);
    }
    List localList2 = this.f.b();
    int i3 = localList2.size();
    paramDataOutputStream.writeShort(i3);
    Iterator localIterator2 = localList2.iterator();
    label296: int i4;
    if (localIterator2.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
      long l4 = ((Long)localEntry2.getKey()).longValue();
      paramDataOutputStream.writeLong(l4);
      am localam = (am)localEntry2.getValue();
      boolean bool;
      if (localam.a != null)
      {
        bool = true;
        paramDataOutputStream.writeBoolean(bool);
        if (bool)
        {
          String str2 = localam.a;
          paramDataOutputStream.writeUTF(str2);
        }
        if (localam.b == null)
          break label387;
      }
      label387: for (i4 = 1; ; i4 = 0)
      {
        paramDataOutputStream.writeBoolean(i4);
        if (i4 != 0)
        {
          String str3 = localam.b;
          paramDataOutputStream.writeUTF(str3);
        }
        int i6 = localam.c;
        paramDataOutputStream.writeInt(i6);
        break;
        bool = false;
        break label296;
      }
    }
    int i7 = this.h.size();
    paramDataOutputStream.writeShort(i7);
    Iterator localIterator3 = this.h.entrySet().iterator();
    while (localIterator3.hasNext())
    {
      Map.Entry localEntry3 = (Map.Entry)localIterator3.next();
      String str4 = (String)localEntry3.getKey();
      paramDataOutputStream.writeUTF(str4);
      e locale = (e)localEntry3.getValue();
      String str5 = locale.a;
      paramDataOutputStream.writeUTF(str5);
      int i10 = locale.b;
      paramDataOutputStream.writeByte(i10);
      int i11 = locale.c;
      paramDataOutputStream.writeByte(i11);
    }
    int i12 = this.g.size();
    paramDataOutputStream.writeShort(i12);
    Iterator localIterator4 = this.g.entrySet().iterator();
    if (localIterator4.hasNext())
    {
      Map.Entry localEntry4 = (Map.Entry)localIterator4.next();
      String str6 = (String)localEntry4.getKey();
      paramDataOutputStream.writeUTF(str6);
      w[] arrayOfw = (w[])localEntry4.getValue();
      if (arrayOfw == null);
      int i5;
      for (i4 = 0; ; i5 = arrayOfw.length)
      {
        paramDataOutputStream.writeShort(i4);
        int i8 = 0;
        while (i8 < i4)
        {
          w localw = arrayOfw[i8];
          long l5 = localw.a;
          paramDataOutputStream.writeLong(l5);
          long l6 = localw.b;
          paramDataOutputStream.writeLong(l6);
          String str7 = localw.d;
          paramDataOutputStream.writeUTF(str7);
          String str8 = localw.c;
          paramDataOutputStream.writeUTF(str8);
          long l7 = localw.e;
          paramDataOutputStream.writeLong(l7);
          long l8 = localw.f.longValue();
          paramDataOutputStream.writeLong(l8);
          int i13 = localw.g.length;
          paramDataOutputStream.writeByte(i13);
          byte[] arrayOfByte2 = localw.g;
          paramDataOutputStream.write(arrayOfByte2);
          int i9;
          i8 += 1;
        }
        break;
      }
    }
    int i14 = this.i.size();
    paramDataOutputStream.writeShort(i14);
    Iterator localIterator5 = this.i.entrySet().iterator();
    while (localIterator5.hasNext())
    {
      Map.Entry localEntry5 = (Map.Entry)localIterator5.next();
      int i15 = ((Byte)localEntry5.getKey()).byteValue();
      paramDataOutputStream.writeByte(i15);
      ((c)localEntry5.getValue()).a(paramDataOutputStream);
    }
    int i16 = this.j.size();
    paramDataOutputStream.writeShort(i16);
    Iterator localIterator6 = this.j.entrySet().iterator();
    while (true)
    {
      if (!localIterator6.hasNext())
        return;
      Map.Entry localEntry6 = (Map.Entry)localIterator6.next();
      int i17 = ((Short)localEntry6.getKey()).shortValue();
      paramDataOutputStream.writeShort(i17);
      long l9 = ((Long)localEntry6.getValue()).longValue();
      paramDataOutputStream.writeLong(l9);
    }
  }

  private static void a(File paramFile)
  {
    if (paramFile.delete())
      return;
    int m = ai.b("FlurryAgent", "Cannot delete cached ads");
  }

  private void f()
  {
    Iterator localIterator1 = this.i.values().iterator();
    while (localIterator1.hasNext())
      Object localObject = localIterator1.next();
    Iterator localIterator2 = this.g.values().iterator();
    while (localIterator2.hasNext())
    {
      w[] arrayOfw = (w[])localIterator2.next();
      if (arrayOfw != null)
      {
        int m = arrayOfw.length;
        int n = 0;
        while (n < m)
        {
          w localw = arrayOfw[n];
          long l1 = localw.f.longValue();
          AdImage localAdImage = b(l1);
          localw.h = localAdImage;
          if (localw.h == null)
          {
            StringBuilder localStringBuilder1 = new StringBuilder().append("Ad ");
            String str1 = localw.d;
            String str2 = str1 + " has no image";
            int i1 = ai.b("FlurryAgent", str2);
          }
          long l2 = localw.a;
          if (a(l2) == null)
          {
            StringBuilder localStringBuilder2 = new StringBuilder().append("Ad ");
            String str3 = localw.d;
            String str4 = str3 + " has no pricing";
            int i2 = ai.b("FlurryAgent", str4);
          }
          n += 1;
        }
      }
    }
    Iterator localIterator3 = this.h.values().iterator();
    while (true)
    {
      if (!localIterator3.hasNext())
        return;
      e locale = (e)localIterator3.next();
      byte b1 = locale.c;
      c localc = a(b1);
      locale.d = localc;
      if (locale.d == null)
      {
        StringBuilder localStringBuilder3 = new StringBuilder().append("No ad theme found for ");
        int i3 = locale.c;
        String str5 = i3;
        int i4 = ai.d("FlurryAgent", str5);
      }
    }
  }

  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(".flurryappcircle.");
    String str = Integer.toString(this.c.a.hashCode(), 16);
    return str;
  }

  /** @deprecated */
  final AdImage a(short paramShort)
  {
    try
    {
      Map localMap = this.j;
      Short localShort = Short.valueOf((short)1);
      Long localLong = (Long)localMap.get(localShort);
      if (localLong == null);
      AdImage localAdImage;
      for (Object localObject1 = null; ; localObject1 = localAdImage)
      {
        return localObject1;
        long l = localLong.longValue();
        localAdImage = b(l);
      }
    }
    finally
    {
    }
  }

  /** @deprecated */
  final am a(long paramLong)
  {
    try
    {
      ag localag = this.f;
      Long localLong = Long.valueOf(paramLong);
      am localam = (am)localag.a(localLong);
      return localam;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  final Set a()
  {
    try
    {
      Set localSet1 = this.e.c();
      Set localSet2 = localSet1;
      return localSet2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final void a(Context paramContext, v paramv, a parama)
  {
    this.a = paramContext;
    this.b = paramv;
    this.c = parama;
  }

  /** @deprecated */
  final void a(Map paramMap1, Map paramMap2, Map paramMap3, Map paramMap4, Map paramMap5, Map paramMap6)
  {
    Object localObject2;
    try
    {
      long l = System.currentTimeMillis();
      this.d = l;
      localObject1 = paramMap4.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((Map.Entry)localObject2).getValue() != null)
        {
          ag localag1 = this.e;
          Object localObject3 = ((Map.Entry)localObject2).getKey();
          Object localObject4 = ((Map.Entry)localObject2).getValue();
          localag1.a(localObject3, localObject4);
        }
      }
    }
    finally
    {
    }
    Object localObject1 = paramMap5.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (((Map.Entry)localObject2).getValue() != null)
      {
        ag localag2 = this.f;
        Object localObject6 = ((Map.Entry)localObject2).getKey();
        Object localObject7 = ((Map.Entry)localObject2).getValue();
        localag2.a(localObject6, localObject7);
      }
    }
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
      this.h = paramMap2;
    if ((paramMap3 != null) && (!paramMap3.isEmpty()))
      this.i = paramMap3;
    if ((paramMap6 != null) && (!paramMap6.isEmpty()))
      this.j = paramMap6;
    HashMap localHashMap = new HashMap();
    this.g = localHashMap;
    Iterator localIterator = paramMap2.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      localObject1 = (e)((Map.Entry)localObject2).getValue();
      Byte localByte1 = Byte.valueOf(((e)localObject1).b);
      w[] arrayOfw = (w[])paramMap1.get(localByte1);
      if (arrayOfw != null)
      {
        Map localMap = this.g;
        Object localObject8 = ((Map.Entry)localObject2).getKey();
        Object localObject9 = localMap.put(localObject8, arrayOfw);
      }
      Byte localByte2 = Byte.valueOf(((e)localObject1).c);
      localObject2 = (c)paramMap3.get(localByte2);
      if (localObject2 != null)
        ((e)localObject1).d = ((c)localObject2);
    }
    f();
    a(202);
  }

  /** @deprecated */
  final w[] a(String paramString)
  {
    try
    {
      w[] arrayOfw = (w[])this.g.get(paramString);
      if (arrayOfw == null)
        arrayOfw = (w[])this.g.get("");
      return arrayOfw;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  final AdImage b(long paramLong)
  {
    try
    {
      ag localag = this.e;
      Long localLong = Long.valueOf(paramLong);
      AdImage localAdImage = (AdImage)localag.a(localLong);
      return localAdImage;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  /** @deprecated */
  final e b(String paramString)
  {
    try
    {
      e locale = (e)this.h.get(paramString);
      if (locale == null)
        locale = (e)this.h.get("");
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final boolean b()
  {
    return this.k;
  }

  final long c()
  {
    return this.d;
  }

  /** @deprecated */
  // ERROR //
  final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 361	com/flurry/android/aa:a	Landroid/content/Context;
    //   6: astore_1
    //   7: aload_0
    //   8: invokespecial 376	com/flurry/android/aa:g	()Ljava/lang/String;
    //   11: astore_2
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 382	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   17: astore_3
    //   18: aload_3
    //   19: invokevirtual 385	java/io/File:exists	()Z
    //   22: istore 4
    //   24: iload 4
    //   26: ifeq +113 -> 139
    //   29: aconst_null
    //   30: astore 5
    //   32: new 387	java/io/FileInputStream
    //   35: dup
    //   36: aload_3
    //   37: invokespecial 389	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: astore 6
    //   42: new 86	java/io/DataInputStream
    //   45: dup
    //   46: aload 6
    //   48: invokespecial 392	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore 7
    //   53: aload 7
    //   55: invokevirtual 90	java/io/DataInputStream:readUnsignedShort	()I
    //   58: ldc_w 393
    //   61: if_icmpne +24 -> 85
    //   64: aload_0
    //   65: aload 7
    //   67: invokespecial 395	com/flurry/android/aa:a	(Ljava/io/DataInputStream;)V
    //   70: aload_0
    //   71: sipush 201
    //   74: invokespecial 368	com/flurry/android/aa:a	(I)V
    //   77: aload 7
    //   79: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_3
    //   86: invokestatic 402	com/flurry/android/aa:a	(Ljava/io/File;)V
    //   89: goto -12 -> 77
    //   92: astore 8
    //   94: ldc 77
    //   96: ldc_w 404
    //   99: aload 8
    //   101: invokestatic 407	com/flurry/android/ai:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   104: istore 9
    //   106: aload_3
    //   107: invokestatic 402	com/flurry/android/aa:a	(Ljava/io/File;)V
    //   110: aload 7
    //   112: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   115: goto -33 -> 82
    //   118: astore 10
    //   120: aload_0
    //   121: monitorexit
    //   122: aload 10
    //   124: athrow
    //   125: astore 8
    //   127: aload 5
    //   129: astore 7
    //   131: aload 7
    //   133: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   136: aload 8
    //   138: athrow
    //   139: new 167	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 409
    //   149: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: astore 11
    //   154: aload_3
    //   155: invokevirtual 412	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: astore 12
    //   160: aload 11
    //   162: aload 12
    //   164: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 13
    //   172: ldc 77
    //   174: aload 13
    //   176: invokestatic 414	com/flurry/android/ai:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   179: istore 14
    //   181: goto -99 -> 82
    //   184: astore 8
    //   186: goto -55 -> 131
    //   189: astore 8
    //   191: aload 5
    //   193: astore 7
    //   195: goto -101 -> 94
    //
    // Exception table:
    //   from	to	target	type
    //   53	77	92	java/lang/Throwable
    //   85	89	92	java/lang/Throwable
    //   2	24	118	finally
    //   77	82	118	finally
    //   110	115	118	finally
    //   131	181	118	finally
    //   32	53	125	finally
    //   53	77	184	finally
    //   85	89	184	finally
    //   94	110	184	finally
    //   32	53	189	java/lang/Throwable
  }

  /** @deprecated */
  // ERROR //
  final void e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 361	com/flurry/android/aa:a	Landroid/content/Context;
    //   8: astore_2
    //   9: aload_0
    //   10: invokespecial 376	com/flurry/android/aa:g	()Ljava/lang/String;
    //   13: astore_3
    //   14: aload_2
    //   15: aload_3
    //   16: invokevirtual 382	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 418	java/io/File:getParentFile	()Ljava/io/File;
    //   26: astore 5
    //   28: aload 5
    //   30: invokevirtual 421	java/io/File:mkdirs	()Z
    //   33: ifne +54 -> 87
    //   36: aload 5
    //   38: invokevirtual 385	java/io/File:exists	()Z
    //   41: ifne +46 -> 87
    //   44: new 167	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 423
    //   54: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 5
    //   59: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore 6
    //   67: ldc 77
    //   69: aload 6
    //   71: invokestatic 307	com/flurry/android/ai:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: istore 7
    //   76: aconst_null
    //   77: astore 4
    //   79: aload 4
    //   81: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: new 428	java/io/FileOutputStream
    //   90: dup
    //   91: aload 4
    //   93: invokespecial 429	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   96: astore 8
    //   98: new 185	java/io/DataOutputStream
    //   101: dup
    //   102: aload 8
    //   104: invokespecial 432	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 5
    //   114: aload 4
    //   116: invokevirtual 188	java/io/DataOutputStream:writeShort	(I)V
    //   119: aload_0
    //   120: aload 5
    //   122: invokespecial 434	com/flurry/android/aa:a	(Ljava/io/DataOutputStream;)V
    //   125: aload 5
    //   127: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   130: goto -46 -> 84
    //   133: astore 9
    //   135: aload_0
    //   136: monitorexit
    //   137: aload 9
    //   139: athrow
    //   140: astore 4
    //   142: ldc 77
    //   144: ldc_w 371
    //   147: aload 4
    //   149: invokestatic 436	com/flurry/android/ai:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   152: istore 10
    //   154: aload_1
    //   155: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   158: goto -74 -> 84
    //   161: astore 4
    //   163: aload_1
    //   164: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   167: aload 4
    //   169: athrow
    //   170: astore 4
    //   172: aload 5
    //   174: astore_1
    //   175: goto -12 -> 163
    //   178: astore 4
    //   180: aload 5
    //   182: astore_1
    //   183: goto -41 -> 142
    //
    // Exception table:
    //   from	to	target	type
    //   79	84	133	finally
    //   125	130	133	finally
    //   154	170	133	finally
    //   4	76	140	java/lang/Throwable
    //   87	109	140	java/lang/Throwable
    //   4	76	161	finally
    //   87	109	161	finally
    //   142	154	161	finally
    //   112	125	170	finally
    //   112	125	178	java/lang/Throwable
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("{");
    StringBuilder localStringBuilder3 = new StringBuilder().append("adImages (");
    int m = this.e.b().size();
    String str1 = m + "),\n";
    StringBuilder localStringBuilder4 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder5 = new StringBuilder().append("adBlock (");
    int n = this.g.size();
    String str2 = n + "):";
    StringBuilder localStringBuilder6 = localStringBuilder1.append(str2).append(",\n");
    Iterator localIterator = this.g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder7 = new StringBuilder().append("\t");
      String str3 = (String)localEntry.getKey();
      StringBuilder localStringBuilder8 = localStringBuilder7.append(str3).append(": ");
      String str4 = Arrays.toString((Object[])localEntry.getValue());
      String str5 = str4;
      StringBuilder localStringBuilder9 = localStringBuilder1.append(str5);
    }
    StringBuilder localStringBuilder10 = new StringBuilder().append("adHooks (");
    int i1 = this.h.size();
    StringBuilder localStringBuilder11 = localStringBuilder10.append(i1).append("):");
    Map localMap1 = this.h;
    String str6 = localMap1;
    StringBuilder localStringBuilder12 = localStringBuilder1.append(str6).append(",\n");
    StringBuilder localStringBuilder13 = new StringBuilder().append("adThemes (");
    int i2 = this.i.size();
    StringBuilder localStringBuilder14 = localStringBuilder13.append(i2).append("):");
    Map localMap2 = this.i;
    String str7 = localMap2;
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str7).append(",\n");
    StringBuilder localStringBuilder16 = new StringBuilder().append("auxMap (");
    int i3 = this.j.size();
    StringBuilder localStringBuilder17 = localStringBuilder16.append(i3).append("):");
    Map localMap3 = this.j;
    String str8 = localMap3;
    StringBuilder localStringBuilder18 = localStringBuilder1.append(str8).append(",\n");
    StringBuilder localStringBuilder19 = localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.aa
 * JD-Core Version:    0.6.2
 */