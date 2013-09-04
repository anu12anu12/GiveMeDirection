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

public class UsingFreqLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap>
{
  private final Map<Bitmap, Integer> usingCounts;

  public UsingFreqLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.usingCounts = localMap;
  }

  public void clear()
  {
    this.usingCounts.clear();
    super.clear();
  }

  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  public Bitmap get(String paramString)
  {
    Bitmap localBitmap = (Bitmap)super.get(paramString);
    if (localBitmap != null)
    {
      Integer localInteger1 = (Integer)this.usingCounts.get(localBitmap);
      if (localInteger1 != null)
      {
        Map localMap = this.usingCounts;
        Integer localInteger2 = Integer.valueOf(localInteger1.intValue() + 1);
        Object localObject = localMap.put(localBitmap, localInteger2);
      }
    }
    return localBitmap;
  }

  protected int getSize(Bitmap paramBitmap)
  {
    int i = paramBitmap.getRowBytes();
    int j = paramBitmap.getHeight();
    return i * j;
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    boolean bool = false;
    if (super.put(paramString, paramBitmap))
    {
      Map localMap = this.usingCounts;
      Integer localInteger = Integer.valueOf(0);
      Object localObject = localMap.put(paramBitmap, localInteger);
      bool = true;
    }
    return bool;
  }

  public void remove(String paramString)
  {
    Bitmap localBitmap = (Bitmap)super.get(paramString);
    if (localBitmap != null)
      Object localObject = this.usingCounts.remove(localBitmap);
    super.remove(paramString);
  }

  protected Bitmap removeNext()
  {
    Object localObject1 = null;
    Bitmap localBitmap = null;
    Set localSet = this.usingCounts.entrySet();
    synchronized (this.usingCounts)
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
          if (i < j)
          {
            localObject1 = localInteger;
            localBitmap = (Bitmap)localEntry.getKey();
          }
        }
      }
      Object localObject2 = this.usingCounts.remove(localBitmap);
      return localBitmap;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache
 * JD-Core Version:    0.6.2
 */