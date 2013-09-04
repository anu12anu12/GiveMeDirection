package com.hopstop.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class HopStopDatePicker extends Spinner
{
  private Paint _paint;
  private String datetime;
  private int x;
  private int y;

  public HopStopDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    Paint localPaint = new Paint();
    this._paint = localPaint;
    this._paint.setColor(-7829368);
    this._paint.setTextSize(21.0F);
    this._paint.setAntiAlias(true);
  }

  private void init(Context paramContext)
  {
    AdapterView.OnItemSelectedListener local1 = new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        HopStopDatePicker.this.setDateTime("");
      }

      public void onNothingSelected(AdapterView paramAnonymousAdapterView)
      {
      }
    };
    setOnItemSelectedListener(local1);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.datetime == null)
      return;
    int i = getWidth() / 2;
    int j = this.x / 2;
    int k = i - j;
    int m = getHeight() / 2;
    int n = this.y / 2;
    int i1 = m + n;
    this._paint.setColor(-7829368);
    String str = this.datetime;
    float f1 = k;
    float f2 = i1;
    Paint localPaint1 = this._paint;
    paramCanvas.drawText(str, f1, f2, localPaint1);
    this._paint.setColor(-16777216);
    float f3 = i1;
    Paint localPaint2 = this._paint;
    paramCanvas.drawText("Day", 10.0F, f3, localPaint2);
  }

  public void setDateTime(String paramString)
  {
    this.datetime = paramString;
    Rect localRect = new Rect();
    Paint localPaint1 = this._paint;
    String str1 = this.datetime;
    int i = this.datetime.length();
    localPaint1.getTextBounds(str1, 0, i, localRect);
    int j = 0;
    int k = 0;
    if (this._paint != null)
    {
      j = (int)Math.ceil(-this._paint.ascent());
      k = (int)Math.ceil(this._paint.descent());
      Paint localPaint2 = this._paint;
      String str2 = this.datetime;
      int m = (int)Math.ceil(localPaint2.measureText(str2));
      this.x = m;
    }
    int n = j + k;
    this.y = n;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.HopStopDatePicker
 * JD-Core Version:    0.6.2
 */