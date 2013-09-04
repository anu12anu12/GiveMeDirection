package com.hopstop.ui.MapComponents;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import java.util.Iterator;
import java.util.List;

public abstract class BalloonItemizedOverlay<Item extends OverlayItem> extends ItemizedOverlay<Item>
{
  private static final long BALLOON_INFLATION_TIME = 300L;
  private static Runnable finishBalloonInflation = new Runnable()
  {
    public void run()
    {
      BalloonItemizedOverlay.isInflating = false;
    }
  };
  private static Handler handler = new Handler();
  private static boolean isInflating = false;
  private BalloonOverlayView<Item> balloonView;
  private View clickRegion;
  private View closeRegion;
  private int currentFocusedIndex;
  private Item currentFocusedItem;
  private MapView mapView;
  final MapController mc;
  private boolean showClose = true;
  private boolean showDisclosure = false;
  private boolean snapToCenter = true;
  private int viewOffset;

  public BalloonItemizedOverlay(Drawable paramDrawable, MapView paramMapView)
  {
    super(paramDrawable);
    this.mapView = paramMapView;
    this.viewOffset = 0;
    MapController localMapController = paramMapView.getController();
    this.mc = localMapController;
    int i = (int)(paramDrawable.getIntrinsicHeight() / 2.0F);
    setBalloonBottomOffset(i);
  }

  private boolean createAndDisplayBalloonOverlay()
  {
    boolean bool;
    label109: MapView.LayoutParams localLayoutParams;
    if (this.balloonView == null)
    {
      BalloonOverlayView localBalloonOverlayView1 = createBalloonOverlayView();
      this.balloonView = localBalloonOverlayView1;
      View localView1 = this.balloonView.findViewById(2131492867);
      this.clickRegion = localView1;
      View localView2 = this.balloonView.findViewById(2131492871);
      this.closeRegion = localView2;
      if (this.closeRegion != null)
      {
        if (!this.showClose)
          this.closeRegion.setVisibility(8);
      }
      else
      {
        if ((this.showDisclosure) && (!this.showClose))
        {
          View localView3 = this.balloonView.findViewById(2131492870);
          if (localView3 != null)
            localView3.setVisibility(0);
        }
        bool = false;
        this.balloonView.setVisibility(8);
        List localList = this.mapView.getOverlays();
        if (localList.size() > 1)
          hideOtherBalloons(localList);
        if (this.currentFocusedItem != null)
        {
          BalloonOverlayView localBalloonOverlayView2 = this.balloonView;
          OverlayItem localOverlayItem = this.currentFocusedItem;
          localBalloonOverlayView2.setData(localOverlayItem);
        }
        GeoPoint localGeoPoint = this.currentFocusedItem.getPoint();
        localLayoutParams = new MapView.LayoutParams(-1, -1, localGeoPoint, 81);
        localLayoutParams.mode = 0;
        this.balloonView.setVisibility(0);
        if (!bool)
          break label259;
        this.balloonView.setLayoutParams(localLayoutParams);
      }
    }
    while (true)
    {
      return bool;
      View localView4 = this.closeRegion;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BalloonItemizedOverlay.this.hideBalloon();
        }
      };
      localView4.setOnClickListener(local3);
      break;
      bool = true;
      break label109;
      label259: MapView localMapView = this.mapView;
      BalloonOverlayView localBalloonOverlayView3 = this.balloonView;
      localMapView.addView(localBalloonOverlayView3, localLayoutParams);
    }
  }

  private View.OnTouchListener createBalloonTouchListener()
  {
    return new View.OnTouchListener()
    {
      float startX;
      float startY;

      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        Drawable localDrawable = ((View)paramAnonymousView.getParent()).findViewById(2131492866).getBackground();
        boolean bool1;
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (localDrawable != null)
          {
            int[] arrayOfInt1 = new int[1];
            arrayOfInt1[0] = 16842919;
            if (localDrawable.setState(arrayOfInt1))
              localDrawable.invalidateSelf();
          }
          float f1 = paramAnonymousMotionEvent.getX();
          this.startX = f1;
          float f2 = paramAnonymousMotionEvent.getY();
          this.startY = f2;
          bool1 = true;
        }
        while (true)
        {
          return bool1;
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            if (localDrawable != null)
            {
              int[] arrayOfInt2 = new int[0];
              if (localDrawable.setState(arrayOfInt2))
                localDrawable.invalidateSelf();
            }
            float f3 = this.startX;
            float f4 = paramAnonymousMotionEvent.getX();
            if (Math.abs(f3 - f4) < 40.0F)
            {
              float f5 = this.startY;
              float f6 = paramAnonymousMotionEvent.getY();
              if (Math.abs(f5 - f6) < 40.0F)
              {
                BalloonItemizedOverlay localBalloonItemizedOverlay = BalloonItemizedOverlay.this;
                int i = BalloonItemizedOverlay.this.currentFocusedIndex;
                OverlayItem localOverlayItem = BalloonItemizedOverlay.this.currentFocusedItem;
                boolean bool2 = localBalloonItemizedOverlay.onBalloonTap(i, localOverlayItem);
              }
            }
            bool1 = true;
          }
          else
          {
            bool1 = false;
          }
        }
      }
    };
  }

  private void hideOtherBalloons(List<Overlay> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Overlay localOverlay = (Overlay)localIterator.next();
      if (((localOverlay instanceof BalloonItemizedOverlay)) && (localOverlay != this))
        ((BalloonItemizedOverlay)localOverlay).hideBalloon();
    }
  }

  public static boolean isInflating()
  {
    return isInflating;
  }

  protected void animateTo(int paramInt, GeoPoint paramGeoPoint)
  {
    this.mc.animateTo(paramGeoPoint);
  }

  public void bringBalloonToFront()
  {
    if (this.balloonView == null)
      return;
    this.balloonView.bringToFront();
  }

  protected BalloonOverlayView<Item> createBalloonOverlayView()
  {
    Context localContext = getMapView().getContext();
    int i = getBalloonBottomOffset();
    return new BalloonOverlayView(localContext, i);
  }

  public int getBalloonBottomOffset()
  {
    return this.viewOffset;
  }

  public Item getFocus()
  {
    return this.currentFocusedItem;
  }

  protected MapView getMapView()
  {
    return this.mapView;
  }

  public void hideAllBalloons()
  {
    if (isInflating)
      return;
    List localList = this.mapView.getOverlays();
    if (localList.size() > 1)
      hideOtherBalloons(localList);
    hideBalloon();
  }

  public void hideBalloon()
  {
    if (this.balloonView != null)
      this.balloonView.setVisibility(8);
    this.currentFocusedItem = null;
  }

  protected void onBalloonOpen(int paramInt)
  {
  }

  protected boolean onBalloonTap(int paramInt, Item paramItem)
  {
    return false;
  }

  public final boolean onTap(int paramInt)
  {
    Handler localHandler1 = handler;
    Runnable localRunnable1 = finishBalloonInflation;
    localHandler1.removeCallbacks(localRunnable1);
    isInflating = true;
    Handler localHandler2 = handler;
    Runnable localRunnable2 = finishBalloonInflation;
    boolean bool1 = localHandler2.postDelayed(localRunnable2, 300L);
    this.currentFocusedIndex = paramInt;
    OverlayItem localOverlayItem = createItem(paramInt);
    this.currentFocusedItem = localOverlayItem;
    setLastFocusedIndex(paramInt);
    onBalloonOpen(paramInt);
    boolean bool2 = createAndDisplayBalloonOverlay();
    if (this.snapToCenter)
    {
      GeoPoint localGeoPoint = this.currentFocusedItem.getPoint();
      animateTo(paramInt, localGeoPoint);
    }
    return true;
  }

  public void setBalloonBottomOffset(int paramInt)
  {
    this.viewOffset = paramInt;
  }

  public void setFocus(Item paramItem)
  {
    super.setFocus(paramItem);
    int i = getLastFocusedIndex();
    this.currentFocusedIndex = i;
    this.currentFocusedItem = paramItem;
    if (this.currentFocusedItem == null)
    {
      hideBalloon();
      return;
    }
    boolean bool = createAndDisplayBalloonOverlay();
  }

  public void setShowClose(boolean paramBoolean)
  {
    this.showClose = paramBoolean;
  }

  public void setShowDisclosure(boolean paramBoolean)
  {
    this.showDisclosure = paramBoolean;
  }

  public void setSnapToCenter(boolean paramBoolean)
  {
    this.snapToCenter = paramBoolean;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.MapComponents.BalloonItemizedOverlay
 * JD-Core Version:    0.6.2
 */