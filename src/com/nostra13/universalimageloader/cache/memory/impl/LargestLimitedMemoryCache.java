package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LargestLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap>
{
  private final Map<Bitmap, Integer> valueSizes;

  public LargestLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.valueSizes = localMap;
  }

  public void clear()
  {
    this.valueSizes.clear();
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
    {
      Map localMap = this.valueSizes;
      Integer localInteger = Integer.valueOf(getSize(paramBitmap));
      Object localObject = localMap.put(paramBitmap, localInteger);
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void remove(String paramString)
  {
    Bitmap localBitmap = (Bitmap)super.get(paramString);
    if (localBitmap != null)
      Object localObject = this.valueSizes.remove(localBitmap);
    super.remove(paramString);
  }

  protected Bitmap removeNext()
  {
    Object localObject1 = null;
    Bitmap localBitmap = null;
    Set localSet = this.valueSizes.entrySet();
    synchronized (this.valueSizes)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localBitmap == null)
        {
          localBitmap = (Bitmap)localEntry.getKey();
          localObject1 = (Integer)localEntry.getValue();
        }
        else
        {
          Integer localInteger = (Integer)localEntry.getValue();
          int i = localInteger.intValue();
          int j = ((Integer)localObject1).intValue();
          if (i > j)
          {
            localObject1 = localInteger;
            localBitmap = (Bitmap)localEntry.getKey();
          }
        }
      }
      Object localObject2 = this.valueSizes.remove(localBitmap);
      return localBitmap;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LargestLimitedMemoryCache
 * JD-Core Version:    0.6.2
 */