package com.hopstop.ClientView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.MapView;
import com.hopstop.ui.MapComponents.BalloonItemizedOverlay;
import java.util.ArrayList;

public class SimpleItemizedOverlay extends BalloonItemizedOverlay<NearbyStationsOverlayItem>
{
  private Context c;
  private ArrayList<NearbyStationsOverlayItem> m_overlays;

  public SimpleItemizedOverlay(Drawable paramDrawable, MapView paramMapView)
  {
    super(localDrawable, paramMapView);
    ArrayList localArrayList = new ArrayList();
    this.m_overlays = localArrayList;
    Context localContext = paramMapView.getContext();
    this.c = localContext;
  }

  public void addOverlay(NearbyStationsOverlayItem paramNearbyStationsOverlayItem)
  {
    boolean bool = this.m_overlays.add(paramNearbyStationsOverlayItem);
    populate();
  }

  protected NearbyStationsOverlayItem createItem(int paramInt)
  {
    return (NearbyStationsOverlayItem)this.m_overlays.get(paramInt);
  }

  protected boolean onBalloonTap(int paramInt, NearbyStationsOverlayItem paramNearbyStationsOverlayItem)
  {
    return false;
  }

  public int size()
  {
    return this.m_overlays.size();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.SimpleItemizedOverlay
 * JD-Core Version:    0.6.2
 */