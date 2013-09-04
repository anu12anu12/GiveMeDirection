package com.flurry.android;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class p
{
  final String a;
  int b;
  w c;
  long d;
  List e;
  private byte f;
  private AtomicInteger g;

  p(p paramp, long paramLong)
  {
    this(str, b1, paramLong);
    w localw = paramp.c;
    this.c = localw;
    long l = paramp.d;
    this.d = l;
  }

  p(String paramString, byte paramByte, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    this.e = localArrayList;
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    this.g = localAtomicInteger;
    int i = this.g.incrementAndGet();
    this.b = i;
    this.a = paramString;
    this.f = paramByte;
    List localList = this.e;
    f localf = new f((byte)1, paramLong);
    boolean bool = localList.add(localf);
  }

  final long a()
  {
    return ((f)this.e.get(0)).b;
  }

  final void a(f paramf)
  {
    boolean bool = this.e.add(paramf);
  }

  final void a(DataOutput paramDataOutput)
  {
    int i = this.b;
    paramDataOutput.writeShort(i);
    String str = this.a;
    paramDataOutput.writeUTF(str);
    int j = this.f;
    paramDataOutput.writeByte(j);
    if (this.c == null)
    {
      paramDataOutput.writeLong(0L);
      paramDataOutput.writeLong(0L);
      paramDataOutput.writeByte(0);
    }
    while (true)
    {
      int k = this.e.size();
      paramDataOutput.writeShort(k);
      Iterator localIterator = this.e.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        f localf = (f)localIterator.next();
        int m = localf.a;
        paramDataOutput.writeByte(m);
        long l1 = localf.b;
        paramDataOutput.writeLong(l1);
      }
      long l2 = this.c.a;
      paramDataOutput.writeLong(l2);
      long l3 = this.c.e;
      paramDataOutput.writeLong(l3);
      byte[] arrayOfByte = this.c.g;
      int n = arrayOfByte.length;
      paramDataOutput.writeByte(n);
      paramDataOutput.write(arrayOfByte);
    }
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder().append("{hook: ");
    String str1 = this.a;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str1).append(", ad: ");
    String str2 = this.c.d;
    String str3 = str2 + ", transitions: [";
    StringBuilder localStringBuilder4 = localStringBuilder1.append(str3);
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      StringBuilder localStringBuilder5 = localStringBuilder1.append(localf);
      StringBuilder localStringBuilder6 = localStringBuilder1.append(",");
    }
    StringBuilder localStringBuilder7 = localStringBuilder1.append("]}");
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.p
 * JD-Core Version:    0.6.2
 */