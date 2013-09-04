package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlushedInputStream extends FilterInputStream
{
  public FlushedInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public long skip(long paramLong)
    throws IOException
  {
    long l3;
    for (long l1 = 0L; ; l1 += l3)
    {
      if (l1 < paramLong)
      {
        InputStream localInputStream = this.in;
        long l2 = paramLong - l1;
        l3 = localInputStream.skip(l2);
        if (l3 != 0L)
          continue;
        if (read() >= 0);
      }
      else
      {
        return l1;
      }
      l3 = 1L;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.FlushedInputStream
 * JD-Core Version:    0.6.2
 */