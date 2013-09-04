package com.hopstop.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;

public class HopStopSpinner extends Spinner
{
  private Paint _textPaint;
  private int arrowX = 0;
  private int arrowY = 0;
  protected Drawable dr = null;
  private Canvas offscreen;

  public HopStopSpinner(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public HopStopSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public HopStopSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    AdapterView.OnItemSelectedListener local1 = new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        float f = ((TextView)paramAnonymousView).getTextSize();
        if (HopStopSpinner.this._textPaint == null)
        {
          HopStopSpinner localHopStopSpinner = HopStopSpinner.this;
          Paint localPaint = new Paint();
          localHopStopSpinner._textPaint = localPaint;
          HopStopSpinner.this._textPaint.setTextSize(f);
        }
        if (HopStopSpinner.this.getId() == 2131493001)
          return;
        int i = HopStopSpinner.this.getId();
      }

      public void onNothingSelected(AdapterView paramAnonymousAdapterView)
      {
      }
    };
    setOnItemSelectedListener(local1);
    setSelection(10);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    Canvas localCanvas1 = this.offscreen;
    if (paramCanvas == localCanvas1)
    {
      Canvas localCanvas2 = this.offscreen;
      super.onDraw(localCanvas2);
      return;
    }
    int i = getWidth();
    int j = getHeight();
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
    Canvas localCanvas3 = new Canvas(localBitmap);
    this.offscreen = localCanvas3;
    Canvas localCanvas4 = this.offscreen;
    super.draw(localCanvas4);
    int i1;
    int i4;
    if (this.dr != null)
    {
      int k = 0;
      int m = 0;
      int n = 0;
      Object localObject = getSelectedItem();
      if ((this._textPaint != null) && (localObject != null))
      {
        k = (int)Math.ceil(-this._textPaint.ascent());
        m = (int)Math.ceil(this._textPaint.descent());
        Paint localPaint1 = this._textPaint;
        String str = localObject.toString();
        n = (int)Math.ceil(localPaint1.measureText(str));
      }
      i1 = k + m;
      int i2 = getWidth() / 2;
      int i3 = n / 2;
      i4 = i2 - i3 + -1;
      if (this.dr.getBounds().width() <= 0)
        break label381;
    }
    label381: for (int i5 = this.dr.getBounds().width(); ; i5 = 13)
    {
      int i6 = i4 - i5 + -3;
      this.arrowX = i6;
      int i7 = getHeight() / 2;
      int i8 = i1 / 2;
      int i9 = i7 - i8;
      this.arrowY = i9;
      float f1 = this.arrowX;
      float f2 = this.arrowY;
      paramCanvas.translate(f1, f2);
      this.dr.setBounds(0, 0, 13, 13);
      this.dr.draw(paramCanvas);
      float f3 = -this.arrowX;
      float f4 = -this.arrowY;
      paramCanvas.translate(f3, f4);
      Paint localPaint2 = new Paint();
      PorterDuff.Mode localMode = PorterDuff.Mode.DARKEN;
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(localMode);
      Xfermode localXfermode = localPaint2.setXfermode(localPorterDuffXfermode);
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint2);
      return;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.HopStopSpinner
 * JD-Core Version:    0.6.2
 */