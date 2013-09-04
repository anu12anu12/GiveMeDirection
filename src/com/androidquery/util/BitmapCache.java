package com.androidquery.util;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class BitmapCache extends LinkedHashMap<String, Bitmap>
{
  private static final long serialVersionUID = 1L;
  private int maxCount;
  private int maxPixels;
  private int maxTotalPixels;
  private int pixels;

  public BitmapCache(int paramInt1, int paramInt2, int paramInt3)
  {
    super(8, 0.75F, true);
    this.maxCount = paramInt1;
    this.maxPixels = paramInt2;
    this.maxTotalPixels = paramInt3;
  }

  private int pixels(Bitmap paramBitmap)
  {
    if (paramBitmap == null);
    int j;
    int k;
    for (int i = 0; ; i = j * k)
    {
      return i;
      j = paramBitmap.getWidth();
      k = paramBitmap.getHeight();
    }
  }

  private void shrink()
  {
    int i = this.pixels;
    int j = this.maxTotalPixels;
    if (i <= j)
      return;
    Iterator localIterator = keySet().iterator();
    int k;
    int m;
    do
    {
      if (!localIterator.hasNext())
        return;
      Object localObject = localIterator.next();
      localIterator.remove();
      k = this.pixels;
      m = this.maxTotalPixels;
    }
    while (k > m);
  }

  public void clear()
  {
    super.clear();
    this.pixels = 0;
  }

  public Bitmap put(String paramString, Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int i = pixels(paramBitmap);
    int j = this.maxPixels;
    if (i <= j)
    {
      int k = this.pixels + i;
      this.pixels = k;
      localBitmap = (Bitmap)super.put(paramString, paramBitmap);
      if (localBitmap != null)
      {
        int m = this.pixels;
        int n = pixels(localBitmap);
        int i1 = m - n;
        this.pixels = i1;
      }
    }
    return localBitmap;
  }

  public Bitmap remove(Object paramObject)
  {
    Bitmap localBitmap = (Bitmap)super.remove(paramObject);
    if (localBitmap != null)
    {
      int i = this.pixels;
      int j = pixels(localBitmap);
      int k = i - j;
      this.pixels = k;
    }
    return localBitmap;
  }

  public boolean removeEldestEntry(Map.Entry<String, Bitmap> paramEntry)
  {
    int i = this.pixels;
    int j = this.maxTotalPixels;
    if (i <= j)
    {
      int k = size();
      int m = this.maxCount;
      if (k <= m);
    }
    else
    {
      Object localObject = paramEntry.getKey();
      Bitmap localBitmap = remove(localObject);
    }
    shrink();
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.BitmapCache
 * JD-Core Version:    0.6.2
 */