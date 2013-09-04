package com.hopstop.ClientModel.directions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StartEndItemizedOverlay extends ItemizedOverlay<OverlayItem>
  implements HopStopOverlay
{
  private ArrayList<OverlayItem> _overlays;

  public StartEndItemizedOverlay(Drawable paramDrawable)
  {
    super(localDrawable);
    ArrayList localArrayList = new ArrayList();
    this._overlays = localArrayList;
  }

  public StartEndItemizedOverlay(Drawable paramDrawable, Context paramContext)
  {
    super(paramDrawable);
    ArrayList localArrayList = new ArrayList();
    this._overlays = localArrayList;
  }

  public void addOverlay(OverlayItem paramOverlayItem)
  {
    boolean bool = this._overlays.add(paramOverlayItem);
    populate();
  }

  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this._overlays.get(paramInt);
  }

  public boolean recycle()
  {
    Iterator localIterator;
    if (this._overlays != null)
      localIterator = this._overlays.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return true;
      OverlayItem localOverlayItem = (OverlayItem)localIterator.next();
      boolean bool = this._overlays.remove(localOverlayItem);
      localOverlayItem.setMarker(null);
    }
  }

  public int size()
  {
    return this._overlays.size();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.StartEndItemizedOverlay
 * JD-Core Version:    0.6.2
 */