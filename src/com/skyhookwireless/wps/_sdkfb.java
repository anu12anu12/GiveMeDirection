package com.skyhookwireless.wps;

import com.skyhookwireless._sdkic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class _sdkfb extends _sdkeb
{
  private static final String[] z;
  private final com.skyhookwireless._sdkhb _sdkb;
  private final String _sdkc;
  private ByteBuffer _sdkd;
  private ArrayList<_sdkgb> _sdke;
  private final RandomAccessFile _sdkf;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[4];
    Object localObject2 = ".k&x3##'44!k qw+m?q".toCharArray();
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
      Object localObject5 = "\032T��&".toCharArray();
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
        Object localObject7 = "\fTsx8\"o&dw+e:x2)$5{%m".toCharArray();
        int i12 = localObject7.length;
        label343: int i18;
        label408: int i14;
        if (i12 <= 1)
        {
          int i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i15 = i12;
          Object localObject9 = localObject7;
          int i16 = i15;
          while (true)
          {
            int i17 = localObject9[i13];
            switch (k % 5)
            {
            default:
              i18 = 87;
              int i19 = (char)(i18 ^ i17);
              localObject9[i13] = i19;
              i14 = k + 1;
              if (i16 != 0)
                break label449;
              localObject9 = localObject3;
              int i20 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i12 = i16;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i14)
            break label343;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i21 = 3;
          Object localObject10 = "mm=4$!e14".toCharArray();
          Object localObject11 = localObject10.length;
          label505: Object localObject13;
          Object localObject14;
          label524: int i22;
          if (localObject11 <= 1)
          {
            localObject8 = localObject10;
            localObject3 = localObject1;
            Object localObject12 = localObject11;
            localObject13 = localObject10;
            localObject14 = localObject12;
            i11 = localObject13[localObject1];
            switch (localObject3 % 5)
            {
            default:
              i22 = 87;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          while (true)
          {
            int i23 = (char)(i22 ^ i11);
            localObject13[localObject1] = i23;
            localObject1 = localObject3 + 1;
            if (localObject14 == 0)
            {
              localObject13 = localObject8;
              int i24 = localObject1;
              localObject1 = localObject14;
              break label524;
            }
            localObject11 = localObject14;
            localObject10 = localObject8;
            if (localObject11 > localObject1)
              break label505;
            String str4 = new String((char[])localObject10).intern();
            arrayOfString[i21] = str4;
            z = arrayOfString;
            return;
            i2 = 77;
            break;
            i2 = 4;
            break;
            i2 = 83;
            break;
            i2 = 20;
            break;
            i8 = 77;
            break label244;
            i8 = 4;
            break label244;
            i8 = 83;
            break label244;
            i8 = 20;
            break label244;
            i18 = 77;
            break label408;
            i18 = 4;
            break label408;
            i18 = 83;
            break label408;
            i18 = 20;
            break label408;
            i22 = 77;
            continue;
            i22 = 4;
            continue;
            i22 = 83;
            continue;
            i22 = 20;
          }
          Object localObject8 = null;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  public _sdkfb(String paramString1, String paramString2)
    throws IOException
  {
    com.skyhookwireless._sdkhb local_sdkhb = com.skyhookwireless._sdkhb._sdkb(_sdkfb.class);
    this._sdkb = local_sdkhb;
    String str1 = paramString1;
    this._sdkc = str1;
    String str2 = paramString2;
    File localFile = new File(str2);
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "r");
    this._sdkf = localRandomAccessFile;
    FileChannel localFileChannel = this._sdkf.getChannel();
    FileChannel.MapMode localMapMode = FileChannel.MapMode.READ_ONLY;
    long l1 = (int)localFileChannel.size();
    MappedByteBuffer localMappedByteBuffer = localFileChannel.map(localMapMode, 0L, l1);
    this._sdkd = localMappedByteBuffer;
    _sdka();
    Buffer localBuffer = this._sdkd.rewind();
    int j = this._sdkd.capacity() + -16;
    if (j < 2)
      throw new _sdkc();
    int k = j + -2;
    int m = _sdka(k, 2)._sdkb(16);
    int n = m * 4;
    int i1 = j + -2 - n;
    _sdka local_sdka = _sdka(i1, n);
    ArrayList localArrayList1 = new ArrayList();
    this._sdke = localArrayList1;
    long l2 = z[1].length();
    int i2 = 0;
    do
    {
      if (i2 >= m)
        return;
      long l3 = local_sdka._sdkc(32);
      ArrayList localArrayList2 = this._sdke;
      ByteBuffer localByteBuffer = this._sdkd;
      int i3 = (int)l2;
      int i4 = (int)l3;
      _sdkb local_sdkb = new _sdkb(localByteBuffer, i3, i4);
      String str3 = this._sdkc;
      _sdkgb local_sdkgb = new _sdkgb(local_sdkb, str3, i2);
      boolean bool = localArrayList2.add(local_sdkgb);
      l2 += l3;
      i2 += 1;
    }
    while (i == 0);
  }

  private _sdka _sdka(int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = this._sdkd;
    _sdkb local_sdkb = new _sdkb(localByteBuffer, paramInt1, paramInt2);
    return new _sdka(local_sdkb);
  }

  private void _sdka()
    throws _sdkc
  {
    int i = this._sdkd.capacity();
    int j = z[1].length() + 16;
    if (i < j)
      throw new _sdkc(this);
    byte[] arrayOfByte1 = new byte[4];
    ByteBuffer localByteBuffer1 = this._sdkd.get(arrayOfByte1);
    if ((arrayOfByte1[0] != 87) || (arrayOfByte1[1] != 80) || (arrayOfByte1[2] != 83) || (arrayOfByte1[3] != 50))
      throw new _sdkc(this);
    _sdkbb local_sdkbb = new _sdkbb();
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = z[1];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = this._sdkc;
    byte[] arrayOfByte2 = str2.getBytes();
    local_sdkbb._sdka(arrayOfByte2);
    byte[] arrayOfByte3 = local_sdkbb._sdka();
    byte[] arrayOfByte4 = new byte[16];
    ByteBuffer localByteBuffer2 = this._sdkd;
    int k = this._sdkd.capacity() + -16;
    Buffer localBuffer = localByteBuffer2.position(k);
    ByteBuffer localByteBuffer3 = this._sdkd.get(arrayOfByte4);
    if (Arrays.equals(arrayOfByte4, arrayOfByte3))
      return;
    throw new _sdkc(this);
  }

  protected _sdkeb _sdka(String paramString1, String paramString2)
    throws IOException
  {
    return new _sdkfb(paramString1, paramString2);
  }

  public _sdkhb _sdka(_sdkic param_sdkic)
    throws _sdkc
  {
    int i = _sdkc._sdkb;
    Iterator localIterator = this._sdke.iterator();
    _sdkgb local_sdkgb;
    if (localIterator.hasNext())
      local_sdkgb = (_sdkgb)localIterator.next();
    while (true)
    {
      try
      {
        _sdkhb local_sdkhb1 = local_sdkgb._sdka(param_sdkic);
        local_sdkhb2 = local_sdkhb1;
        if (local_sdkhb2 != null)
          return local_sdkhb2;
      }
      catch (Exception localException)
      {
        com.skyhookwireless._sdkhb local_sdkhb = this._sdkb;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[2];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(param_sdkic);
        String str2 = z[3];
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
        int j = local_sdkgb._sdka();
        String str3 = j;
        local_sdkhb._sdke(str3, localException);
        throw new _sdkc(this);
      }
      if (i == 0)
        break;
      _sdkhb local_sdkhb2 = null;
    }
  }

  public void close()
  {
    try
    {
      this._sdkf.close();
      this._sdkd = null;
      this._sdke = null;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        com.skyhookwireless._sdkhb local_sdkhb = this._sdkb;
        String str = z[0];
        local_sdkhb._sdke(str, localIOException);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkfb
 * JD-Core Version:    0.6.2
 */