package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import java.io.IOException;

class HopStopOverlayItem extends OverlayItem
  implements HopStopOverlay
{
  private int _circleOffset = 9;
  private StateListDrawable _marker = null;
  private FrameLayout _markerLayout;
  private int stateFocused = 16842908;
  private int statePressed = 16842919;
  private int stateSelected = 16842913;

  HopStopOverlayItem(GeoPoint paramGeoPoint, String paramString1, String paramString2, FrameLayout paramFrameLayout, String paramString3, boolean paramBoolean)
  {
    super(paramGeoPoint, paramString1, paramString2);
    FrameLayout localFrameLayout = paramFrameLayout;
    this._markerLayout = localFrameLayout;
    int i = this._markerLayout.findViewById(2131492980).getWidth() / 2;
    this._circleOffset = i;
    View localView = this._markerLayout.findViewById(2131492981);
    ImageView localImageView = (ImageView)this._markerLayout.findViewById(2131492982);
    if (paramBoolean);
    while (true)
    {
      try
      {
        Drawable localDrawable = NetworkEngine.fetchDrawable(paramString3);
        if (localDrawable != null)
        {
          localImageView.setImageDrawable(localDrawable);
          int j = this._markerLayout.getWidth();
          int k = this._markerLayout.getHeight();
          int m = (int)(j * 0.27D);
          int n = this._circleOffset;
          int i1 = m + n;
          int i2 = (int)(j * 0.23D);
          localView.setPadding(i1, 0, 0, i2);
          int i3 = j - i1 + -2;
          localImageView.setMaxWidth(i3);
          int i4 = k - i2 + -2;
          localImageView.setMaxHeight(i4);
          StateListDrawable localStateListDrawable = generateStateListDrawable();
          this._marker = localStateListDrawable;
          return;
        }
        NetworkEngine.fetchImageViewOnThread(paramString3, localImageView);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        NetworkEngine.fetchImageViewOnThread(paramString3, localImageView);
        localOutOfMemoryError.printStackTrace();
        continue;
      }
      catch (IOException localIOException)
      {
        NetworkEngine.fetchImageViewOnThread(paramString3, localImageView);
        localIOException.printStackTrace();
        continue;
      }
      HistoryManager localHistoryManager = ApplicationEngine.getHistoryManager(null);
      String str = paramString3;
      Bitmap localBitmap = localHistoryManager.loadDirectionIconFromDB(str);
      if (localBitmap != null)
        localImageView.setImageBitmap(localBitmap);
    }
  }

  private StateListDrawable generateStateListDrawable()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    int[] arrayOfInt1 = new int[1];
    int i = this.stateSelected;
    arrayOfInt1[0] = i;
    Drawable localDrawable1 = generateMarker(true);
    localStateListDrawable.addState(arrayOfInt1, localDrawable1);
    int[] arrayOfInt2 = new int[1];
    int j = this.statePressed;
    arrayOfInt2[0] = j;
    Drawable localDrawable2 = generateMarker(true);
    localStateListDrawable.addState(arrayOfInt2, localDrawable2);
    int[] arrayOfInt3 = new int[1];
    int k = this.stateFocused;
    arrayOfInt3[0] = k;
    Drawable localDrawable3 = generateMarker(true);
    localStateListDrawable.addState(arrayOfInt3, localDrawable3);
    int[] arrayOfInt4 = new int[0];
    Drawable localDrawable4 = generateMarker(false);
    localStateListDrawable.addState(arrayOfInt4, localDrawable4);
    return localStateListDrawable;
  }

  public static void setState(Drawable paramDrawable, int paramInt)
  {
    int[] arrayOfInt = new int[3];
    int i;
    if ((paramInt & 0x1) > 0)
    {
      i = 0 + 1;
      arrayOfInt[0] = 16842919;
    }
    while (true)
    {
      if ((paramInt & 0x2) > 0)
      {
        int j = i + 1;
        arrayOfInt[i] = 16842913;
        i = j;
      }
      if ((paramInt & 0x4) > 0)
      {
        int k = i + 1;
        arrayOfInt[i] = 16842908;
      }
      while (true)
      {
        boolean bool = paramDrawable.setState(arrayOfInt);
        return;
        int m = i;
      }
      i = 0;
    }
  }

  public Drawable generateMarker(boolean paramBoolean)
  {
    Bitmap localBitmap;
    if (this._markerLayout != null)
    {
      this._markerLayout.setDrawingCacheEnabled(true);
      FrameLayout localFrameLayout1 = this._markerLayout;
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      localFrameLayout1.measure(i, j);
      FrameLayout localFrameLayout2 = this._markerLayout;
      int k = this._markerLayout.getMeasuredWidth();
      int m = this._markerLayout.getMeasuredHeight();
      localFrameLayout2.layout(0, 0, k, m);
      this._markerLayout.buildDrawingCache(true);
      if (this._markerLayout.getDrawingCache() != null)
      {
        localBitmap = Bitmap.createBitmap(this._markerLayout.getDrawingCache());
        if (localBitmap != null)
          this._markerLayout.setDrawingCacheEnabled(false);
      }
    }
    for (BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap); ; localBitmapDrawable = null)
      return localBitmapDrawable;
  }

  public Drawable getDefaultMarker()
  {
    if (this._marker == null)
    {
      StateListDrawable localStateListDrawable = generateStateListDrawable();
      this._marker = localStateListDrawable;
    }
    return this._marker;
  }

  public StateListDrawable getMarker(int paramInt)
  {
    if (this._marker == null);
    for (StateListDrawable localStateListDrawable1 = null; ; localStateListDrawable1 = this._marker)
    {
      return localStateListDrawable1;
      setState(this._marker, paramInt);
      StateListDrawable localStateListDrawable2 = this._marker;
      int i = -this._circleOffset;
      int j = -this._marker.getIntrinsicHeight();
      int k = this._marker.getIntrinsicWidth();
      int m = this._circleOffset;
      localStateListDrawable2.setBounds(i, j, k, m);
    }
  }

  public boolean recycle()
  {
    if (this._marker != null)
      this._marker = null;
    int i;
    int j;
    if (this._markerLayout != null)
    {
      i = this._markerLayout.getChildCount();
      j = 0;
    }
    while (true)
    {
      if (j >= i)
      {
        this._markerLayout.removeAllViews();
        this._markerLayout = null;
        return true;
      }
      View localView = this._markerLayout.getChildAt(j);
      if ((localView instanceof ImageView))
        ((ImageView)localView).setImageBitmap(null);
      j += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.HopStopOverlayItem
 * JD-Core Version:    0.6.2
 */