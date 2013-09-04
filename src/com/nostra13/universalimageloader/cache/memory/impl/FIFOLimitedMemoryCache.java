package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FIFOLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap>
{
  private final List<Bitmap> queue;

  public FIFOLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
    List localList = Collections.synchronizedList(new LinkedList());
    this.queue = localList;
  }

  public void clear()
  {
    this.queue.clear();
    super.clear();
  }

  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  protected int getSize(Bitmap paramBitmap)
  {
    int i = paramBitmap.getRowBytes();
    int j = paramBitmap.getHeight();
    return i * j;
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
      boolean bool1 = this.queue.add(paramBitmap);
    for (boolean bool2 = true; ; bool2 = false)
      return bool2;
  }

  public void remove(String paramString)
  {
    Bitmap localBitmap = (Bitmap)super.get(paramString);
    if (localBitmap != null)
      boolean bool = this.queue.remove(localBitmap);
    super.remove(paramString);
  }

  protected Bitmap removeNext()
  {
    return (Bitmap)this.queue.remove(0);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.FIFOLimitedMemoryCache
 * JD-Core Version:    0.6.2
 */