package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class DirectionPathOverlay extends ItemizedOverlay<OverlayItem>
  implements HopStopOverlay
{
  private List<HopStopOverlayItem> _items;
  private Drawable _marker;

  public DirectionPathOverlay(Drawable paramDrawable, Hashtable<String, RouteIcons> paramHashtable, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    super(paramDrawable);
    ArrayList localArrayList = new ArrayList();
    this._items = localArrayList;
    this._marker = null;
    Drawable localDrawable1 = generateMarker(paramFrameLayout);
    this._marker = localDrawable1;
    Enumeration localEnumeration = new Hashtable(paramHashtable).keys();
    while (true)
    {
      if (!localEnumeration.hasMoreElements())
      {
        Drawable localDrawable2 = boundCenterBottom(this._marker);
        populate();
        return;
      }
      String str1 = (String)localEnumeration.nextElement();
      if ((!str1.equals("start")) && (!str1.equals("end")))
      {
        RouteIcons localRouteIcons = (RouteIcons)paramHashtable.get(str1);
        if (localRouteIcons.isOccurred() == 0)
        {
          int i = localRouteIcons.getLat();
          int j = localRouteIcons.getLon();
          GeoPoint localGeoPoint = new GeoPoint(i, j);
          String str2 = localRouteIcons.getUrl();
          FrameLayout localFrameLayout = paramFrameLayout;
          boolean bool1 = paramBoolean;
          HopStopOverlayItem localHopStopOverlayItem = new HopStopOverlayItem(localGeoPoint, "", "", localFrameLayout, str2, bool1);
          boolean bool2 = this._items.add(localHopStopOverlayItem);
        }
      }
    }
  }

  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this._items.get(paramInt);
  }

  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    super.draw(paramCanvas, paramMapView, paramBoolean);
  }

  public Drawable generateMarker(FrameLayout paramFrameLayout)
  {
    Bitmap localBitmap;
    if (paramFrameLayout != null)
    {
      paramFrameLayout.setDrawingCacheEnabled(true);
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramFrameLayout.measure(i, j);
      int k = paramFrameLayout.getMeasuredWidth();
      int m = paramFrameLayout.getMeasuredHeight();
      paramFrameLayout.layout(0, 0, k, m);
      paramFrameLayout.buildDrawingCache(true);
      if (paramFrameLayout.getDrawingCache() != null)
      {
        localBitmap = Bitmap.createBitmap(paramFrameLayout.getDrawingCache());
        if (localBitmap != null)
          paramFrameLayout.setDrawingCacheEnabled(false);
      }
    }
    for (BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap); ; localBitmapDrawable = null)
      return localBitmapDrawable;
  }

  protected boolean onTap(int paramInt)
  {
    return true;
  }

  public boolean recycle()
  {
    if (this._marker != null)
      this._marker = null;
    Iterator localIterator;
    if (this._items != null)
      localIterator = this._items.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this._items.clear();
        return true;
      }
      boolean bool = ((HopStopOverlayItem)localIterator.next()).recycle();
    }
  }

  public int size()
  {
    return this._items.size();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.DirectionPathOverlay
 * JD-Core Version:    0.6.2
 */