package com.MASTAdView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MASTAdView extends MASTAdViewCore
{
  private Integer autoCloseInterstitialTime;
  Canvas c;
  Paint clear;
  private Button closeButton;
  Bitmap image;
  private Boolean isShowPhoneStatusBar;
  Matrix matrix;
  Paint paint;
  private Integer showCloseButtonTime;

  public MASTAdView(Context paramContext)
  {
    super(paramContext);
  }

  public MASTAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AutoDetectParameters(paramContext);
  }

  public MASTAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public MASTAdView(Context paramContext, Integer paramInteger1, Integer paramInteger2)
  {
    super(paramContext, paramInteger1, paramInteger2);
  }

  protected MASTAdView(Context paramContext, boolean paramBoolean, MASTAdViewCore paramMASTAdViewCore)
  {
    super(paramContext, paramBoolean, paramMASTAdViewCore);
  }

  private void openInterstitialForm(Context paramContext, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean, MASTAdView paramMASTAdView, Button paramButton)
  {
    if ((paramInteger1 == null) || (paramInteger1.intValue() < 0))
      paramInteger1 = Integer.valueOf(0);
    if ((paramInteger2 == null) || (paramInteger2.intValue() < 0))
      paramInteger2 = Integer.valueOf(0);
    if (paramBoolean == null)
      paramBoolean = Boolean.valueOf(true);
    final Dialog localDialog;
    final RelativeLayout localRelativeLayout;
    if (paramBoolean.booleanValue())
    {
      localDialog = new Dialog(paramContext, 16973830);
      paramMASTAdView.dialog = localDialog;
      if (paramMASTAdView.getParent() != null)
        ((ViewGroup)paramMASTAdView.getParent()).removeAllViews();
      localRelativeLayout = new RelativeLayout(paramContext);
      ViewGroup.LayoutParams localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(-1, -1);
      paramMASTAdView.setLayoutParams(localLayoutParams2);
      localRelativeLayout.addView(paramMASTAdView);
      if (paramButton == null)
      {
        paramButton = new Button(paramContext);
        paramButton.setText("Close");
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.addRule(14, -1);
        paramButton.setLayoutParams(localLayoutParams);
      }
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
        }
      };
      paramButton.setOnClickListener(local1);
      localRelativeLayout.addView(paramButton);
      if (paramInteger1.intValue() > 0)
        break label320;
      paramButton.setVisibility(0);
    }
    while (true)
    {
      if (paramInteger2.intValue() > 0)
      {
        Handler localHandler1 = this.handler;
        new CloseDialogThread(localHandler1, localDialog, paramInteger2).start();
      }
      localDialog.setContentView(localRelativeLayout);
      DialogInterface.OnDismissListener local2 = new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          localRelativeLayout.removeAllViews();
        }
      };
      localDialog.setOnDismissListener(local2);
      localDialog.show();
      return;
      localDialog = new Dialog(paramContext, 16973831);
      break;
      label320: paramButton.setVisibility(4);
      localDialog.setCancelable(false);
      Handler localHandler2 = this.handler;
      new ShowCloseButtonThread(localHandler2, localDialog, paramButton, paramInteger1).start();
    }
  }

  protected void AutoDetectParameters(Context paramContext)
  {
    super.AutoDetectParameters(paramContext);
    MASTAdView localMASTAdView = this;
    if (this.adserverRequest == null)
      return;
    AutoDetectParameters localAutoDetectParameters = AutoDetectParameters.getInstance();
    if ((this.adserverRequest.getVersion() != null) || (localAutoDetectParameters.getVersion() == null));
    while (true)
    {
      try
      {
        String str1 = "2.12";
        if ((str1 != null) && (str1.length() > 0))
        {
          AdserverRequest localAdserverRequest1 = this.adserverRequest.setVersion(str1);
          localAutoDetectParameters.setVersion(str1);
        }
        this.adLog.log(2, 3, "AutoDetectParameters.SDK_VERSION", str1);
        if (this.adserverRequest.getPremium() == null)
        {
          AdserverRequest localAdserverRequest2 = this.adserverRequest;
          Integer localInteger = Integer.valueOf(2);
          AdserverRequest localAdserverRequest3 = localAdserverRequest2.setPremium(localInteger);
        }
        if (this.adserverRequest.getUa() != null)
          return;
        if (localAutoDetectParameters.getUa() != null)
          break;
        String str2 = localMASTAdView.getSettings().getUserAgentString();
        if (str2 == null)
          return;
        if (str2.length() <= 0)
          return;
        AdserverRequest localAdserverRequest4 = this.adserverRequest.setUa(str2);
        localAutoDetectParameters.setUa(str2);
        return;
      }
      catch (Exception localException)
      {
        MASTAdLog localMASTAdLog1 = this.adLog;
        String str3 = localException.getMessage();
        localMASTAdLog1.log(1, 1, "SDK_VERSION", str3);
        continue;
      }
      AdserverRequest localAdserverRequest5 = this.adserverRequest;
      String str4 = localAutoDetectParameters.getVersion();
      AdserverRequest localAdserverRequest6 = localAdserverRequest5.setVersion(str4);
      MASTAdLog localMASTAdLog2 = this.adLog;
      String str5 = localAutoDetectParameters.getVersion();
      localMASTAdLog2.log(2, 3, "AutoDetectParameters.SDK_VERSION", str5);
    }
    AdserverRequest localAdserverRequest7 = this.adserverRequest;
    String str6 = localAutoDetectParameters.getUa();
    AdserverRequest localAdserverRequest8 = localAdserverRequest7.setUa(str6);
  }

  protected void InterstitialClose()
  {
    if (!this.isInterstitial)
      return;
    Handler localHandler = this.handler;
    Runnable local3 = new Runnable()
    {
      public void run()
      {
        if (MASTAdView.this.dialog == null)
          return;
        MASTAdView.this.dialog.dismiss();
      }
    };
    boolean bool = localHandler.post(local3);
  }

  public Integer getAutoCloseInterstitialTime()
  {
    return this.autoCloseInterstitialTime;
  }

  public Button getCloseButton()
  {
    return this.closeButton;
  }

  public Boolean getIsShowPhoneStatusBar()
  {
    return this.isShowPhoneStatusBar;
  }

  public Integer getShowCloseButtonTime()
  {
    return this.showCloseButtonTime;
  }

  public String getUA()
  {
    return this.adserverRequest.getUa();
  }

  protected void onAttachedToWindow()
  {
    this.adLog.log(2, 3, "AttachedToWindow", "");
    super.onAttachedToWindow();
  }

  protected void onDetachedFromWindow()
  {
    this.adLog.log(2, 3, "DetachedFromWindow", "");
    if (this.c != null)
      this.c = null;
    if (this.paint != null)
      this.paint = null;
    if (this.matrix != null)
      this.matrix = null;
    if (this.clear != null)
      this.clear = null;
    if (this.image != null)
    {
      this.image.recycle();
      this.image = null;
    }
    super.onDetachedFromWindow();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      if ((getBackgroundColor() == 0) && (getWidth() > 0) && (getHeight() > 0))
      {
        if (this.image != null)
        {
          int i = this.image.getWidth();
          int j = getWidth();
          if (i != j)
          {
            int k = this.image.getHeight();
            int m = getHeight();
            if (k == m)
              break label298;
          }
        }
        if (this.image != null)
          this.image.recycle();
        int n = getWidth();
        int i1 = getHeight();
        Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap1 = Bitmap.createBitmap(n, i1, localConfig);
        this.image = localBitmap1;
        MASTAdLog localMASTAdLog = this.adLog;
        StringBuilder localStringBuilder1 = new StringBuilder("create bmp ");
        String str1 = String.valueOf(getWidth());
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("x");
        String str2 = String.valueOf(getHeight());
        String str3 = str2;
        localMASTAdLog.log(3, 3, "onDraw", str3);
        Bitmap localBitmap2 = this.image;
        Canvas localCanvas1 = new Canvas(localBitmap2);
        this.c = localCanvas1;
        Paint localPaint1 = new Paint();
        this.paint = localPaint1;
        Matrix localMatrix1 = new Matrix();
        this.matrix = localMatrix1;
        Paint localPaint2 = new Paint();
        this.clear = localPaint2;
        this.clear.setColor(0);
        Paint localPaint3 = this.clear;
        PorterDuff.Mode localMode = PorterDuff.Mode.CLEAR;
        PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(localMode);
        Xfermode localXfermode = localPaint3.setXfermode(localPorterDuffXfermode);
        label298: Canvas localCanvas2 = this.c;
        Paint localPaint4 = this.clear;
        localCanvas2.drawPaint(localPaint4);
        Canvas localCanvas3 = this.c;
        super.onDraw(localCanvas3);
        Bitmap localBitmap3 = this.image;
        Matrix localMatrix2 = this.matrix;
        Paint localPaint5 = this.paint;
        paramCanvas.drawBitmap(localBitmap3, localMatrix2, localPaint5);
        return;
      }
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      this.image = null;
      super.onDraw(paramCanvas);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    try
    {
      if ((getBackgroundColor() == 0) && (this.image != null) && (paramMotionEvent != null) && (paramMotionEvent.getX() >= 0.0F))
      {
        float f1 = paramMotionEvent.getX();
        float f2 = this.image.getWidth();
        if ((f1 < f2) && (paramMotionEvent.getY() >= 0.0F))
        {
          float f3 = paramMotionEvent.getY();
          float f4 = this.image.getHeight();
          if (f3 < f4)
          {
            Bitmap localBitmap = this.image;
            int j = (int)paramMotionEvent.getX();
            int k = (int)paramMotionEvent.getY();
            if (Color.alpha(localBitmap.getPixel(j, k)) > 0)
              i = super.onTouchEvent(paramMotionEvent);
          }
        }
      }
      while (true)
      {
        return i;
        i = 0;
        continue;
        int m = super.onTouchEvent(paramMotionEvent);
        i = m;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        MASTAdLog localMASTAdLog = this.adLog;
        String str = localException.getMessage();
        localMASTAdLog.log(i, i, "onTouchEvent", str);
      }
    }
  }

  public void setAutoCloseInterstitialTime(Integer paramInteger)
  {
    this.autoCloseInterstitialTime = paramInteger;
  }

  public void setCloseButton(Button paramButton)
  {
    this.closeButton = paramButton;
  }

  public void setIsShowPhoneStatusBar(Boolean paramBoolean)
  {
    this.isShowPhoneStatusBar = paramBoolean;
  }

  public void setShowCloseButtonTime(Integer paramInteger)
  {
    this.showCloseButtonTime = paramInteger;
  }

  public void setUA(String paramString)
  {
    AdserverRequest localAdserverRequest = this.adserverRequest.setUa(paramString);
  }

  public void show()
  {
    this.isInterstitial = true;
    Context localContext = getContext();
    Integer localInteger1 = this.showCloseButtonTime;
    Integer localInteger2 = this.autoCloseInterstitialTime;
    Boolean localBoolean = this.isShowPhoneStatusBar;
    Button localButton = this.closeButton;
    MASTAdView localMASTAdView1 = this;
    MASTAdView localMASTAdView2 = this;
    localMASTAdView1.openInterstitialForm(localContext, localInteger1, localInteger2, localBoolean, localMASTAdView2, localButton);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.MASTAdView
 * JD-Core Version:    0.6.2
 */