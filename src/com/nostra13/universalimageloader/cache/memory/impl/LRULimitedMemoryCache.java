package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRULimitedMemoryCache extends LimitedMemoryCache<String, Bitmap>
{
  private static final int INITIAL_CAPACITY = 10;
  private static final float LOAD_FACTOR = 1.1F;
  private final Map<String, Bitmap> lruCache;

  public LRULimitedMemoryCache(int paramInt)
  {
    super(paramInt);
    Map localMap = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
    this.lruCache = localMap;
  }

  public void clear()
  {
    this.lruCache.clear();
    super.clear();
  }

  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  public Bitmap get(String paramString)
  {
    Object localObject = this.lruCache.get(paramString);
    return (Bitmap)super.get(paramString);
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
      Object localObject = this.lruCache.put(paramString, paramBitmap);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void remove(String paramString)
  {
    Object localObject = this.lruCache.remove(paramString);
    super.remove(paramString);
  }

  protected Bitmap removeNext()
  {
    Bitmap localBitmap = null;
    synchronized (this.lruCache)
    {
      Iterator localIterator = this.lruCache.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
        localIterator.remove();
      }
      return localBitmap;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache
 * JD-Core Version:    0.6.2
 */