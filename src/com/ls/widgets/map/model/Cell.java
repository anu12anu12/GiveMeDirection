package com.ls.widgets.map.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.TransitionDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.ls.widgets.map.interfaces.TileManagerDelegate;
import com.ls.widgets.map.providers.TileProvider;
import java.lang.ref.SoftReference;

public class Cell
  implements Drawable.Callback, TileManagerDelegate
{
  private int a;
  private float b;
  private float c;
  private int d;
  private int e;
  private Grid f;
  private View g;
  private double h;
  private float i;
  protected Drawable image;
  protected boolean invalidateRect;
  private SoftReference<Drawable> j;
  private TileProvider k;
  private Rect l;
  private float m;
  private float n;
  private boolean o;
  private boolean p;
  private boolean q;
  private String r;
  private boolean s;

  public Cell(Grid paramGrid, TileProvider paramTileProvider, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    String str = Cell.class.getSimpleName();
    this.r = str;
    this.s = false;
    float f1 = paramInt4;
    this.b = f1;
    float f2 = paramInt4;
    this.c = f2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.h = paramDouble;
    this.a = paramInt1;
    this.invalidateRect = true;
    this.f = paramGrid;
    View localView = paramGrid.getParentView();
    this.g = localView;
    this.k = paramTileProvider;
    this.p = true;
    float f3 = paramInt2;
    float f4 = this.b;
    float f5 = f3 * f4;
    this.m = f5;
    float f6 = paramInt3;
    float f7 = this.c;
    float f8 = f6 * f7;
    this.n = f8;
    Rect localRect = new Rect();
    this.l = localRect;
    float f9 = this.g.getResources().getDisplayMetrics().density;
    this.i = f9;
    this.o = false;
    this.q = false;
  }

  private void a()
  {
    this.q = true;
    this.f.a(this);
  }

  private void a(float paramFloat1, float paramFloat2, Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable == null)
      return;
    this.image = paramDrawable;
    if (!paramBoolean)
    {
      Rect localRect = this.image.getBounds();
      float f1 = Math.round(localRect.width());
      this.b = f1;
      float f2 = Math.round(localRect.height());
      this.c = f2;
    }
    while (true)
    {
      recalculateDrawableRect(paramFloat1, paramFloat2);
      if (!(this.image instanceof TransitionDrawable))
        return;
      ((TransitionDrawable)this.image).setCallback(this);
      ((TransitionDrawable)this.image).startTransition(150);
      View localView = this.g;
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          Cell.a(Cell.this);
        }
      };
      boolean bool = localView.postDelayed(local1, 150L);
      return;
      if ((this.image instanceof TransitionDrawable))
      {
        BitmapDrawable localBitmapDrawable = (BitmapDrawable)((TransitionDrawable)paramDrawable).getDrawable(1);
        float f3 = localBitmapDrawable.getBitmap().getWidth();
        this.b = f3;
        float f4 = localBitmapDrawable.getBitmap().getHeight();
        this.c = f4;
      }
    }
  }

  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.s)
      return;
    if (this.o)
      return;
    if (!this.p)
      return;
    if (this.j != null)
    {
      Drawable localDrawable = (Drawable)this.j.get();
      if (localDrawable != null)
      {
        a(0.0F, 0.0F, localDrawable, true);
        return;
      }
    }
    this.o = true;
    TileProvider localTileProvider = this.k;
    int i1 = this.a;
    int i2 = this.d;
    int i3 = this.e;
    localTileProvider.requestTile(i1, i2, i3, this);
  }

  public void cacheImage(float paramFloat1, float paramFloat2)
  {
    if (this.image != null)
      return;
    a(paramFloat1, paramFloat2, false);
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2)
  {
    try
    {
      if (this.image == null)
        a(paramFloat1, paramFloat2, true);
      if (this.image == null)
        return;
      if (this.invalidateRect)
        recalculateDrawableRect(paramFloat1, paramFloat2);
      this.image.draw(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      String str = "Exception during cell painting. E: " + localException;
      int i1 = Log.e("Cell", str);
    }
  }

  public void freeResources()
  {
    Drawable localDrawable = this.image;
    SoftReference localSoftReference = new SoftReference(localDrawable);
    this.j = localSoftReference;
    this.image = null;
    this.invalidateRect = true;
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    Rect localRect = paramDrawable.getBounds();
    View localView = this.g;
    int i1 = localRect.left;
    int i2 = localRect.top;
    int i3 = localRect.right;
    int i4 = localRect.bottom;
    localView.postInvalidate(i1, i2, i3, i4);
  }

  public boolean isReady()
  {
    return this.q;
  }

  public void onError(Exception paramException)
  {
    this.o = false;
    this.s = true;
    a();
  }

  public void onTileReady(int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable)
  {
    a(0.0F, 0.0F, paramDrawable, false);
    this.o = false;
  }

  protected void recalculateDrawableRect(float paramFloat1, float paramFloat2)
  {
    Rect localRect1 = this.l;
    double d1 = this.m;
    double d2 = this.h;
    int i1 = (int)(d1 * d2);
    localRect1.left = i1;
    Rect localRect2 = this.l;
    double d3 = this.n;
    double d4 = this.h;
    int i2 = (int)(d3 * d4);
    localRect2.top = i2;
    Rect localRect3 = this.l;
    float f1 = this.m;
    float f2 = this.b;
    double d5 = f1 + f2;
    double d6 = this.h;
    int i3 = (int)(d5 * d6);
    localRect3.right = i3;
    Rect localRect4 = this.l;
    float f3 = this.n;
    float f4 = this.c;
    double d7 = f3 + f4;
    double d8 = this.h;
    int i4 = (int)(d7 * d8);
    localRect4.bottom = i4;
    Drawable localDrawable = this.image;
    Rect localRect5 = this.l;
    localDrawable.setBounds(localRect5);
    this.invalidateRect = false;
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.g.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
  }

  public void setLoadImage(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setScale(double paramDouble)
  {
    this.h = paramDouble;
    this.invalidateRect = true;
    if (this.image == null)
      return;
    recalculateDrawableRect(0.0F, 0.0F);
  }

  public void setTileProvider(TileProvider paramTileProvider)
  {
    this.k = paramTileProvider;
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.g.unscheduleDrawable(paramDrawable, paramRunnable);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.model.Cell
 * JD-Core Version:    0.6.2
 */