package com.hopstop.ui.MapComponents;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.maps.OverlayItem;

public class BalloonOverlayView<Item extends OverlayItem> extends FrameLayout
{
  private LinearLayout layout;
  private TextView snippet;
  private TextView title;

  public BalloonOverlayView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setPadding(10, 0, 10, paramInt);
    LimitLinearLayout localLimitLinearLayout = new LimitLinearLayout(paramContext);
    this.layout = localLimitLinearLayout;
    this.layout.setVisibility(0);
    LinearLayout localLinearLayout1 = this.layout;
    setupView(paramContext, localLinearLayout1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 0;
    LinearLayout localLinearLayout2 = this.layout;
    addView(localLinearLayout2, localLayoutParams);
  }

  protected void setBalloonData(Item paramItem, ViewGroup paramViewGroup)
  {
    if (paramItem.getTitle() != null)
    {
      this.title.setVisibility(0);
      TextView localTextView1 = this.title;
      String str1 = paramItem.getTitle();
      localTextView1.setText(str1);
    }
    while (paramItem.getSnippet() != null)
    {
      this.snippet.setVisibility(0);
      TextView localTextView2 = this.snippet;
      String str2 = paramItem.getSnippet();
      localTextView2.setText(str2);
      return;
      this.title.setText("");
      this.title.setVisibility(8);
    }
    this.snippet.setText("");
    this.snippet.setVisibility(8);
  }

  public void setData(Item paramItem)
  {
    this.layout.setVisibility(0);
    LinearLayout localLinearLayout = this.layout;
    setBalloonData(paramItem, localLinearLayout);
  }

  protected void setupView(Context paramContext, ViewGroup paramViewGroup)
  {
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903042, paramViewGroup);
    TextView localTextView1 = (TextView)localView.findViewById(2131492868);
    this.title = localTextView1;
    TextView localTextView2 = (TextView)localView.findViewById(2131492869);
    this.snippet = localTextView2;
  }

  private class LimitLinearLayout extends LinearLayout
  {
    private static final int MAX_WIDTH_DP = 280;
    final float SCALE;

    public LimitLinearLayout(Context arg2)
    {
      super();
      float f = getContext().getResources().getDisplayMetrics().density;
      this.SCALE = f;
    }

    public LimitLinearLayout(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
      float f = getContext().getResources().getDisplayMetrics().density;
      this.SCALE = f;
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getSize(paramInt1);
      float f = this.SCALE;
      int k = (int)(280.0F * f + 0.5F);
      int m = View.MeasureSpec.makeMeasureSpec(Math.min(j, k), i);
      super.onMeasure(m, paramInt2);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.MapComponents.BalloonOverlayView
 * JD-Core Version:    0.6.2
 */