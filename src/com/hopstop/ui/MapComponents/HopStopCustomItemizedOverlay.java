package com.hopstop.ui.MapComponents;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;

public class HopStopCustomItemizedOverlay extends ItemizedOverlay<OverlayItem>
{
  private Context mContext;
  private ArrayList<OverlayItem> mOverlays;

  public HopStopCustomItemizedOverlay(Drawable paramDrawable)
  {
    super(localDrawable);
    ArrayList localArrayList = new ArrayList();
    this.mOverlays = localArrayList;
  }

  public HopStopCustomItemizedOverlay(Drawable paramDrawable, Context paramContext)
  {
    super(localDrawable);
    ArrayList localArrayList = new ArrayList();
    this.mOverlays = localArrayList;
    this.mContext = paramContext;
  }

  public void addOverlay(OverlayItem paramOverlayItem)
  {
    boolean bool = this.mOverlays.add(paramOverlayItem);
    populate();
  }

  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this.mOverlays.get(paramInt);
  }

  protected boolean onTap(int paramInt)
  {
    return false;
  }

  public int size()
  {
    return this.mOverlays.size();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.MapComponents.HopStopCustomItemizedOverlay
 * JD-Core Version:    0.6.2
 */