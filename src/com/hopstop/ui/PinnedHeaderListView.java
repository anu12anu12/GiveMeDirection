package com.hopstop.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PinnedHeaderListView extends ListView
{
  private static final int MAX_ALPHA = 255;
  private PinnedHeaderAdapter mAdapter;
  private View mHeaderView;
  private int mHeaderViewHeight;
  private boolean mHeaderViewVisible;
  private int mHeaderViewWidth;

  public PinnedHeaderListView(Context paramContext)
  {
    super(paramContext);
  }

  public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void configureHeaderView(int paramInt)
  {
    if (this.mHeaderView == null)
      return;
    switch (this.mAdapter.getPinnedHeaderState(paramInt))
    {
    default:
      return;
    case 0:
      this.mHeaderViewVisible = false;
      return;
    case 1:
      PinnedHeaderAdapter localPinnedHeaderAdapter1 = this.mAdapter;
      View localView1 = this.mHeaderView;
      localPinnedHeaderAdapter1.configurePinnedHeader(localView1, paramInt, 255);
      if (this.mHeaderView.getTop() != 0)
      {
        View localView2 = this.mHeaderView;
        int i = this.mHeaderViewWidth;
        int j = this.mHeaderViewHeight;
        localView2.layout(0, 0, i, j);
      }
      this.mHeaderViewVisible = true;
      return;
    case 2:
    }
    View localView3 = getChildAt(0);
    if (localView3 == null)
      return;
    int k = localView3.getBottom();
    int m = localView3.getHeight();
    int n = this.mHeaderView.getHeight();
    int i1;
    if (k < n)
      i1 = k - n;
    for (int i2 = (n + i1) * 255 / n; ; i2 = 255)
    {
      PinnedHeaderAdapter localPinnedHeaderAdapter2 = this.mAdapter;
      View localView4 = this.mHeaderView;
      localPinnedHeaderAdapter2.configurePinnedHeader(localView4, paramInt, i2);
      if (this.mHeaderView.getTop() != i1)
      {
        View localView5 = this.mHeaderView;
        int i3 = this.mHeaderViewWidth;
        int i4 = this.mHeaderViewHeight + i1;
        localView5.layout(0, i1, i3, i4);
      }
      this.mHeaderViewVisible = true;
      return;
      i1 = 0;
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (!this.mHeaderViewVisible)
      return;
    View localView = this.mHeaderView;
    long l = getDrawingTime();
    boolean bool = drawChild(paramCanvas, localView, l);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mHeaderView == null)
      return;
    View localView = this.mHeaderView;
    int i = this.mHeaderViewWidth;
    int j = this.mHeaderViewHeight;
    localView.layout(0, 0, i, j);
    int k = getFirstVisiblePosition();
    configureHeaderView(k);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mHeaderView == null)
      return;
    View localView = this.mHeaderView;
    measureChild(localView, paramInt1, paramInt2);
    int i = this.mHeaderView.getMeasuredWidth();
    this.mHeaderViewWidth = i;
    int j = this.mHeaderView.getMeasuredHeight();
    this.mHeaderViewHeight = j;
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    PinnedHeaderAdapter localPinnedHeaderAdapter = (PinnedHeaderAdapter)paramListAdapter;
    this.mAdapter = localPinnedHeaderAdapter;
  }

  public void setPinnedHeaderView(View paramView)
  {
    this.mHeaderView = paramView;
    if (this.mHeaderView != null)
      setFadingEdgeLength(0);
    requestLayout();
  }

  public static abstract interface PinnedHeaderAdapter
  {
    public static final int PINNED_HEADER_GONE = 0;
    public static final int PINNED_HEADER_PUSHED_UP = 2;
    public static final int PINNED_HEADER_VISIBLE = 1;

    public abstract void configurePinnedHeader(View paramView, int paramInt1, int paramInt2);

    public abstract int getPinnedHeaderState(int paramInt);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.PinnedHeaderListView
 * JD-Core Version:    0.6.2
 */