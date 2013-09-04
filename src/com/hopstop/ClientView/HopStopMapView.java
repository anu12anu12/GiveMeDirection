package com.hopstop.ClientView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.hopstop.ClientModel.directions.HopStopOverlay;
import java.util.List;
import java.util.ListIterator;

public class HopStopMapView extends MapView
{
  private long lastTouchTime = 65535L;

  public HopStopMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    long l1;
    if (paramMotionEvent.getAction() == 0)
    {
      l1 = System.currentTimeMillis();
      long l2 = this.lastTouchTime;
      if (l1 - l2 >= 250L)
        break label72;
      MapController localMapController = getController();
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      boolean bool = localMapController.zoomInFixing(i, j);
    }
    label72: for (this.lastTouchTime = 65535L; ; this.lastTouchTime = l1)
      return super.onInterceptTouchEvent(paramMotionEvent);
  }

  /** @deprecated */
  public boolean recycle()
  {
    while (true)
    {
      Overlay localOverlay;
      try
      {
        List localList = getOverlays();
        ListIterator localListIterator = localList.listIterator();
        if (!localListIterator.hasNext())
        {
          localList.clear();
          return true;
        }
        localOverlay = (Overlay)localListIterator.next();
        if ((localOverlay instanceof HopStopOverlay))
        {
          boolean bool1 = ((HopStopOverlay)localOverlay).recycle();
          continue;
        }
      }
      finally
      {
      }
      boolean bool2 = localOverlay instanceof MyLocationOverlay;
      if (!bool2);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.HopStopMapView
 * JD-Core Version:    0.6.2
 */