package com.ls.widgets.map.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.interfaces.OnGridReadyListener;
import com.ls.widgets.map.providers.TileProvider;
import com.ls.widgets.map.utils.OfflineMapUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class Grid
{
  private TileProvider a;
  private OnGridReadyListener b;
  private View c;
  private ArrayList<Cell> d;
  private int e;
  private int f;
  private int g;
  private int h;
  private double i;
  private int j;
  private int k;
  private int l;
  private boolean m;
  private Rect n;
  private int o;
  private int p;
  private Point q;
  private Point r;
  private Rect s;
  private Rect t;
  private int u;
  private int v;
  private double w;
  private double x;

  public Grid(View paramView, OfflineMapConfig paramOfflineMapConfig, TileProvider paramTileProvider, int paramInt)
  {
    this.h = paramInt;
    int i1 = paramOfflineMapConfig.getImageWidth();
    this.k = i1;
    int i2 = paramOfflineMapConfig.getImageHeight();
    this.j = i2;
    int i3 = this.k;
    int i4 = this.j;
    int i5 = OfflineMapUtil.getMaxZoomLevel(i3, i4);
    this.l = i5;
    this.i = 1.0D;
    this.w = 1.0D;
    this.x = 1.0D;
    int i6 = paramOfflineMapConfig.getTileSize();
    this.g = i6;
    this.c = paramView;
    this.a = paramTileProvider;
    this.m = true;
    int i7 = getRowCount();
    this.f = i7;
    int i8 = getColCount();
    this.e = i8;
    a();
    Point localPoint1 = new Point(0, 0);
    this.q = localPoint1;
    Point localPoint2 = new Point(0, 0);
    this.r = localPoint2;
    Rect localRect1 = new Rect(0, 0, 0, 0);
    this.s = localRect1;
    Rect localRect2 = new Rect(0, 0, 0, 0);
    this.t = localRect2;
    int i9 = this.g;
    a(paramInt, i9);
  }

  private Point a(Rect paramRect, Point paramPoint)
  {
    if ((paramPoint == null) || (paramRect == null))
      throw new IllegalArgumentException();
    Point localPoint = b(paramRect, paramPoint);
    double d1 = paramRect.width();
    double d2 = this.g;
    double d3 = this.x;
    double d4 = d2 * d3;
    int i1 = (int)Math.ceil(d1 / d4) + 2;
    double d5 = paramRect.height();
    double d6 = this.g;
    double d7 = this.x;
    double d8 = d6 * d7;
    int i2 = (int)Math.ceil(d5 / d8) + 1;
    int i3 = localPoint.x;
    int i4 = i1 + i3;
    paramPoint.x = i4;
    int i5 = localPoint.y + i2;
    paramPoint.y = i5;
    int i6 = paramPoint.x;
    int i7 = this.e;
    if (i6 >= i7)
    {
      int i8 = this.e + -1;
      paramPoint.x = i8;
    }
    int i9 = paramPoint.y;
    int i10 = this.f;
    if (i9 >= i10)
    {
      int i11 = this.f + -1;
      paramPoint.y = i11;
    }
    return paramPoint;
  }

  private Rect a(Rect paramRect)
  {
    Rect localRect1 = this.t;
    int i1 = paramRect.left;
    int i2 = this.o;
    int i3 = i1 - i2;
    localRect1.left = i3;
    if (this.t.left < 0)
      this.t.left = 0;
    Rect localRect2 = this.t;
    int i4 = paramRect.right;
    int i5 = this.o;
    int i6 = i4 + i5;
    localRect2.right = i6;
    int i7 = this.t.right;
    int i8 = this.e;
    if (i7 >= i8)
    {
      Rect localRect3 = this.t;
      int i9 = this.e + -1;
      localRect3.right = i9;
    }
    Rect localRect4 = this.t;
    int i10 = paramRect.top;
    int i11 = this.p;
    int i12 = i10 - i11;
    localRect4.top = i12;
    if (this.t.top < 0)
      this.t.top = 0;
    Rect localRect5 = this.t;
    int i13 = paramRect.bottom;
    int i14 = this.p;
    int i15 = i13 + i14;
    localRect5.bottom = i15;
    int i16 = this.t.bottom;
    int i17 = this.f;
    if (i16 >= i17)
    {
      Rect localRect6 = this.t;
      int i18 = this.f + -1;
      localRect6.bottom = i18;
    }
    return this.t;
  }

  private void a()
  {
    double d1 = this.c.getWidth();
    double d2 = this.g;
    double d3 = this.x;
    double d4 = d2 * d3;
    int i1 = (int)(d1 / d4) / 2;
    this.o = i1;
    double d5 = this.c.getHeight();
    double d6 = this.g;
    double d7 = this.x;
    double d8 = d6 * d7;
    int i2 = (int)(d5 / d8) / 2;
    this.p = i2;
  }

  private void a(double paramDouble)
  {
    int i1 = this.d.size();
    a();
    int i2 = 0;
    while (true)
    {
      if (i2 >= i1)
        return;
      ((Cell)this.d.get(i2)).setScale(paramDouble);
      i2 += 1;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (Looper.myLooper() == null)
      throw new IllegalThreadStateException("Should be called from UI thread");
    int i1 = this.e;
    int i2 = this.f;
    int i3 = i1 * i2;
    ArrayList localArrayList = new ArrayList(i3);
    this.d = localArrayList;
    int i4 = 0;
    while (true)
    {
      if (i4 >= i3)
        return;
      int i5 = this.e;
      int i6 = i4 / i5;
      TileProvider localTileProvider = this.a;
      int i7 = this.e * i6;
      int i8 = i4 - i7;
      double d1 = this.x;
      Grid localGrid = this;
      int i9 = paramInt1;
      int i10 = paramInt2;
      Cell localCell = new Cell(localGrid, localTileProvider, i9, i8, i6, i10, d1);
      boolean bool = this.d.add(localCell);
      i4 += 1;
    }
  }

  private void a(boolean paramBoolean)
  {
    int i1 = this.d.size();
    ArrayList localArrayList = this.d;
    int i2 = 0;
    while (true)
    {
      if (i2 < i1);
      try
      {
        ((Cell)this.d.get(i2)).setLoadImage(paramBoolean);
        i2 += 1;
        continue;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  private Point b(Rect paramRect, Point paramPoint)
  {
    if ((paramPoint == null) || (paramRect == null))
      throw new IllegalArgumentException();
    double d1 = paramRect.left;
    double d2 = this.g;
    double d3 = this.x;
    double d4 = d2 * d3;
    int i1 = (int)Math.floor(d1 / d4) + -1;
    paramPoint.x = i1;
    double d5 = paramRect.top;
    double d6 = this.g;
    double d7 = this.x;
    double d8 = d6 * d7;
    int i2 = (int)Math.floor(d5 / d8) + -1;
    paramPoint.y = i2;
    if (paramPoint.x < 0)
      paramPoint.x = 0;
    if (paramPoint.y < 0)
      paramPoint.y = 0;
    return paramPoint;
  }

  /** @deprecated */
  private Rect b(Rect paramRect)
  {
    if (paramRect != null);
    try
    {
      if ((this.q == null) || (this.r == null))
        throw new IllegalArgumentException();
    }
    finally
    {
    }
    Point localPoint1 = this.q;
    Point localPoint2 = b(paramRect, localPoint1);
    Point localPoint3 = this.r;
    Point localPoint4 = a(paramRect, localPoint3);
    Rect localRect1 = this.s;
    int i1 = this.q.y;
    localRect1.top = i1;
    Rect localRect2 = this.s;
    int i2 = this.q.x;
    localRect2.left = i2;
    Rect localRect3 = this.s;
    int i3 = this.r.y;
    localRect3.bottom = i3;
    Rect localRect4 = this.s;
    int i4 = this.r.x;
    localRect4.right = i4;
    Rect localRect5 = this.s;
    return localRect5;
  }

  void a(Cell paramCell)
  {
    int i1 = this.v + 1;
    this.v = i1;
    int i2 = this.v;
    int i3 = this.u;
    if (i2 != i3)
      return;
    if (this.b == null)
      return;
    int i4 = Log.d("Grid", "OnReady!");
    this.b.onReady();
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, Rect paramRect)
  {
    this.n = paramRect;
    if (this.d == null)
      return;
    Rect localRect1 = b(paramRect);
    this.s = localRect1;
    Rect localRect2 = b(paramRect);
    this.t = localRect2;
    this.u = 0;
    this.v = 0;
    int i1 = this.t.top;
    while (true)
    {
      int i2 = this.t.bottom;
      if (i1 > i2)
        return;
      int i3 = this.t.left;
      int i4 = this.t.right;
      if (i3 <= i4)
      {
        ArrayList localArrayList = this.d;
        int i5 = this.e * i1 + i3;
        Cell localCell = (Cell)localArrayList.get(i5);
        if (localCell != null)
        {
          int i6 = this.s.left;
          if (i3 < i6)
            break label241;
          int i7 = this.s.right;
          if (i3 > i7)
            break label241;
          int i8 = this.s.top;
          if (i1 < i8)
            break label241;
          int i9 = this.s.bottom;
          if (i1 > i9)
            break label241;
          localCell.draw(paramCanvas, paramPaint, 0.0F, 0.0F);
          if (!localCell.isReady())
          {
            int i10 = this.u + 1;
            this.u = i10;
          }
        }
        while (true)
        {
          i3 += 1;
          break;
          label241: localCell.cacheImage(0.0F, 0.0F);
        }
      }
      i1 += 1;
    }
  }

  public void freeResources()
  {
    if (this.n == null)
      return;
    Rect localRect1 = this.n;
    Rect localRect2 = b(localRect1);
    this.s = localRect2;
    Rect localRect3 = this.s;
    Rect localRect4 = a(localRect3);
    this.t = localRect4;
    int i1 = 0;
    while (true)
    {
      int i2 = this.f;
      if (i1 >= i2)
        return;
      int i3 = 0;
      while (true)
      {
        int i4 = this.e;
        if (i3 >= i4)
          break;
        int i5 = this.t.left;
        if (i3 >= i5)
        {
          int i6 = this.t.right;
          if (i3 <= i6)
          {
            int i7 = this.t.top;
            if (i1 >= i7)
            {
              int i8 = this.t.bottom;
              if (i1 <= i8)
                break label179;
            }
          }
        }
        ArrayList localArrayList = this.d;
        int i9 = this.e * i1 + i3;
        Cell localCell = (Cell)localArrayList.get(i9);
        if (localCell != null)
          localCell.freeResources();
        label179: i3 += 1;
      }
      i1 += 1;
    }
  }

  protected int getColCount()
  {
    int i1 = this.l;
    int i2 = this.h;
    int i3 = this.k;
    float f1 = OfflineMapUtil.getScaledImageSize(i1, i2, i3);
    float f2 = this.g;
    return (int)Math.ceil(f1 / f2);
  }

  public int getHeight()
  {
    double d1 = this.j;
    double d2 = getScale();
    return (int)Math.ceil(d1 * d2);
  }

  public double getIntScale()
  {
    return this.w;
  }

  public int getMaxZoomLevel()
  {
    return this.l;
  }

  public int getMinZoomLevel()
  {
    return 0;
  }

  public int getOriginalHeight()
  {
    return this.j;
  }

  public int getOriginalWidth()
  {
    return this.k;
  }

  public View getParentView()
  {
    return this.c;
  }

  protected int getRowCount()
  {
    int i1 = this.l;
    int i2 = this.h;
    int i3 = this.j;
    float f1 = OfflineMapUtil.getScaledImageSize(i1, i2, i3);
    float f2 = this.g;
    return (int)(float)Math.ceil(f1 / f2);
  }

  public double getScale()
  {
    int i1 = this.l;
    int i2 = this.h;
    if (i1 != i2);
    double d4;
    double d5;
    for (double d1 = this.x * 1.0D; ; d1 = d4 * d5)
    {
      return d1;
      int i3 = this.l;
      int i4 = this.h;
      double d2 = i3 - i4;
      double d3 = Math.pow(2.0D, d2);
      d4 = 1.0D / d3;
      d5 = this.x;
    }
  }

  public double getSoftScale()
  {
    return this.i;
  }

  public int getWidth()
  {
    double d1 = this.k;
    double d2 = getScale();
    return (int)Math.ceil(d1 * d2);
  }

  public int getZoomLevel()
  {
    return this.h;
  }

  public boolean isLoadTiles()
  {
    return this.m;
  }

  public void setInternalScale(float paramFloat)
  {
    if (paramFloat == 0.0D)
      throw new IllegalArgumentException();
    double d1 = paramFloat;
    this.w = d1;
    double d2 = this.i;
    double d3 = this.w;
    double d4 = d2 * d3;
    this.x = d4;
    double d5 = this.x;
    a(d5);
  }

  public void setLoadTiles(boolean paramBoolean)
  {
    a(paramBoolean);
  }

  public void setOnReadyListener(OnGridReadyListener paramOnGridReadyListener)
  {
    this.b = paramOnGridReadyListener;
  }

  public void setSoftScale(float paramFloat)
  {
    if (paramFloat == 0.0D)
      throw new IllegalArgumentException();
    double d1 = paramFloat;
    this.i = d1;
    double d2 = this.i;
    double d3 = this.w;
    double d4 = d2 * d3;
    this.x = d4;
    double d5 = this.x;
    a(d5);
  }

  public void setTileProvider(TileProvider paramTileProvider)
  {
    Iterator localIterator = this.d.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((Cell)localIterator.next()).setTileProvider(paramTileProvider);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.model.Grid
 * JD-Core Version:    0.6.2
 */