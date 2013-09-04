package com.hopstop.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class HopStopTimePicker extends Button
  implements TimePicker.OnTimeChangedListener
{
  private int _hour;
  private int _minute;
  private Paint _paint;
  private String datetime;
  private int x;
  private int y;

  public HopStopTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    Paint localPaint = new Paint();
    this._paint = localPaint;
    this._paint.setColor(-7829368);
    this._paint.setTextSize(25.0F);
    this._paint.setAntiAlias(true);
  }

  private void init(Context paramContext)
  {
  }

  private static String pad(int paramInt)
  {
    if (paramInt >= 10);
    StringBuilder localStringBuilder;
    String str2;
    for (String str1 = String.valueOf(paramInt); ; str1 = str2)
    {
      return str1;
      localStringBuilder = new StringBuilder("0");
      str2 = String.valueOf(paramInt);
    }
  }

  private void updateDisplay()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = pad(this._hour);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(":");
    String str2 = pad(this._minute);
    String str3 = str2;
    this.datetime = str3;
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
    String str = this.datetime;
    float f1 = k;
    float f2 = i1;
    Paint localPaint = this._paint;
    paramCanvas.drawText(str, f1, f2, localPaint);
  }

  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    this._hour = paramInt1;
    this._minute = paramInt2;
    updateDisplay();
  }

  public void setDateTime(String paramString)
  {
    String str2;
    if (Integer.parseInt(paramString.split(":")[0]) > 12)
    {
      String str1 = String.valueOf(paramString);
      str2 = str1 + " PM";
    }
    String str6;
    for (this.datetime = str2; ; this.datetime = str6)
    {
      Rect localRect = new Rect();
      Paint localPaint1 = this._paint;
      String str3 = this.datetime;
      int i = this.datetime.length();
      localPaint1.getTextBounds(str3, 0, i, localRect);
      int j = 0;
      int k = 0;
      if (this._paint != null)
      {
        j = (int)Math.ceil(-this._paint.ascent());
        k = (int)Math.ceil(this._paint.descent());
        Paint localPaint2 = this._paint;
        String str4 = this.datetime;
        int m = (int)Math.ceil(localPaint2.measureText(str4));
        this.x = m;
      }
      int n = j + k;
      this.y = n;
      return;
      String str5 = String.valueOf(paramString);
      str6 = str5 + " AM";
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.HopStopTimePicker
 * JD-Core Version:    0.6.2
 */