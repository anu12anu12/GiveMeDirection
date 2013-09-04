package com.hopstop.ui.MapComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class TapControlledMapView extends MapView
  implements GestureDetector.OnGestureListener
{
  private GestureDetector gd;
  private OnSingleTapListener singleTapListener;

  public TapControlledMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setupGestures();
  }

  public TapControlledMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setupGestures();
  }

  public TapControlledMapView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    setupGestures();
  }

  private void setupGestures()
  {
    GestureDetector localGestureDetector1 = new GestureDetector(this);
    this.gd = localGestureDetector1;
    GestureDetector localGestureDetector2 = this.gd;
    GestureDetector.OnDoubleTapListener local1 = new GestureDetector.OnDoubleTapListener()
    {
      public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        MapController localMapController = TapControlledMapView.this.getController();
        int i = (int)paramAnonymousMotionEvent.getX();
        int j = (int)paramAnonymousMotionEvent.getY();
        boolean bool = localMapController.zoomInFixing(i, j);
        return false;
      }

      public boolean onDoubleTapEvent(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }

      public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        if (TapControlledMapView.this.singleTapListener != null);
        for (boolean bool = TapControlledMapView.this.singleTapListener.onSingleTap(paramAnonymousMotionEvent); ; bool = false)
          return bool;
      }
    };
    localGestureDetector2.setOnDoubleTapListener(local1);
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.gd.onTouchEvent(paramMotionEvent));
    for (boolean bool = true; ; bool = super.onTouchEvent(paramMotionEvent))
      return bool;
  }

  public void setOnSingleTapListener(OnSingleTapListener paramOnSingleTapListener)
  {
    this.singleTapListener = paramOnSingleTapListener;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.MapComponents.TapControlledMapView
 * JD-Core Version:    0.6.2
 */