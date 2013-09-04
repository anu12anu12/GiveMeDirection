package com.flurry.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

final class z extends RelativeLayout
{
  private v a;
  private p b;
  private int c;

  public z(Context paramContext, v paramv, p paramp, e parame, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.a = paramv;
    this.b = paramp;
    w localw = paramp.c;
    this.c = paramInt;
    switch (this.c)
    {
    default:
    case 2:
    case 1:
    }
    while (true)
    {
      setFocusable(true);
      return;
      if (paramBoolean)
        a(paramContext, parame, localw, false);
      while (true)
      {
        if (!paramBoolean)
          break label104;
        a(paramContext, parame, localw, false);
        break;
        a(paramContext, parame, localw, true);
      }
      label104: a(paramContext, parame, localw, true);
    }
  }

  private void a(Context paramContext, e parame, w paramw, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    setLayoutParams(localLayoutParams1);
    c localc = parame.d;
    ImageView localImageView1 = new ImageView(paramContext);
    localImageView1.setId(1);
    Object localObject1 = paramw.h;
    Bitmap localBitmap2;
    Bitmap localBitmap4;
    if (localObject1 != null)
    {
      localObject1 = ((AdImage)localObject1).e;
      int i = localObject1.length;
      Bitmap localBitmap1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, i);
      if (localBitmap1 == null)
      {
        StringBuilder localStringBuilder1 = new StringBuilder().append("Ad with bad image: ");
        String str1 = paramw.d;
        String str2 = str1 + ", data: " + localObject1;
        int j = ai.a("FlurryAgent", str2);
      }
      if (localBitmap1 != null)
      {
        int k = localBitmap1.getWidth();
        int m = localBitmap1.getHeight();
        Bitmap.Config localConfig1 = Bitmap.Config.ARGB_8888;
        localBitmap2 = Bitmap.createBitmap(k, m, localConfig1);
        Canvas localCanvas1 = new Canvas(localBitmap2);
        Paint localPaint1 = new Paint();
        int n = localBitmap1.getWidth();
        int i1 = localBitmap1.getHeight();
        Rect localRect1 = new Rect(0, 0, n, i1);
        RectF localRectF = new RectF(localRect1);
        float f1 = r.a(paramContext, 8);
        localPaint1.setAntiAlias(true);
        localCanvas1.drawARGB(0, 0, 0, 0);
        localPaint1.setColor(-16777216);
        localCanvas1.drawRoundRect(localRectF, f1, f1, localPaint1);
        PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
        PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(localMode);
        Xfermode localXfermode = localPaint1.setXfermode(localPorterDuffXfermode);
        localCanvas1.drawBitmap(localBitmap1, localRect1, localRect1, localPaint1);
        if (Integer.parseInt(Build.VERSION.SDK) <= 4)
          break label1211;
        BlurMaskFilter.Blur localBlur = BlurMaskFilter.Blur.OUTER;
        BlurMaskFilter localBlurMaskFilter = new BlurMaskFilter(3.0F, localBlur);
        Paint localPaint2 = new Paint();
        MaskFilter localMaskFilter = localPaint2.setMaskFilter(localBlurMaskFilter);
        int[] arrayOfInt = new int[2];
        Bitmap localBitmap3 = localBitmap2.extractAlpha(localPaint2, arrayOfInt);
        Bitmap.Config localConfig2 = Bitmap.Config.ARGB_8888;
        localBitmap4 = localBitmap3.copy(localConfig2, true);
        Canvas localCanvas2 = new Canvas(localBitmap4);
        float f2 = -arrayOfInt[0];
        float f3 = -arrayOfInt[1];
        localCanvas2.drawBitmap(localBitmap2, f2, f3, null);
      }
    }
    while (true)
    {
      localImageView1.setImageBitmap(localBitmap4);
      int i2 = localc.m;
      int i3 = r.a(paramContext, i2);
      int i4 = localc.n;
      int i5 = r.a(paramContext, i4);
      r.a(paramContext, localImageView1, i3, i5);
      ImageView.ScaleType localScaleType = ImageView.ScaleType.FIT_XY;
      localImageView1.setScaleType(localScaleType);
      v localv = this.a;
      long l = localc.c;
      Object localObject2 = localv.a(l);
      Bitmap localBitmap5;
      TextView localTextView1;
      TextView localTextView2;
      if (localObject2 != null)
      {
        byte[] arrayOfByte1 = ((AdImage)localObject2).e;
        int i6 = arrayOfByte1.length;
        localBitmap5 = BitmapFactory.decodeByteArray(arrayOfByte1, 0, i6);
        if (NinePatch.isNinePatchChunk(localBitmap5.getNinePatchChunk()))
        {
          byte[] arrayOfByte2 = localBitmap5.getNinePatchChunk();
          Rect localRect2 = new Rect(0, 0, 0, 0);
          localObject2 = new NinePatchDrawable(localBitmap5, arrayOfByte2, localRect2, null);
          setBackgroundDrawable((Drawable)localObject2);
        }
      }
      else
      {
        localTextView1 = new TextView(paramContext);
        localTextView1.setId(5);
        localTextView1.setPadding(0, 0, 0, 0);
        localTextView2 = new TextView(paramContext);
        localTextView2.setId(3);
        localTextView2.setPadding(0, 0, 0, 0);
        if (!paramBoolean)
          break label1076;
        int i7 = localc.f;
        localTextView1.setTextColor(i7);
        float f4 = localc.e;
        localTextView1.setTextSize(f4);
        StringBuilder localStringBuilder2 = new StringBuilder().append("• ");
        String str3 = localc.b;
        String str4 = str3;
        String str5 = new String(str4);
        localTextView1.setText(str5);
        Typeface localTypeface1 = Typeface.create(localc.d, 0);
        localTextView1.setTypeface(localTypeface1);
        int i8 = localc.i;
        localTextView2.setTextColor(i8);
        float f5 = localc.h;
        localTextView2.setTextSize(f5);
        Typeface localTypeface2 = Typeface.create(localc.g, 0);
        localTextView2.setTypeface(localTypeface2);
        String str6 = paramw.d;
        localTextView2.setText(str6);
      }
      while (true)
      {
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        setLayoutParams(localLayoutParams);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        ImageView localImageView2 = new ImageView(paramContext);
        addView(localImageView2, localLayoutParams2);
        int i9 = localc.q;
        int i10 = localc.o << 1;
        int i11 = i9 - i10;
        int i12 = localc.m;
        int i13 = i11 - i12;
        RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams3.addRule(9);
        int i14 = localc.o;
        int i15 = localc.p;
        localLayoutParams3.setMargins(i14, i15, i13, 0);
        addView(localImageView1, localLayoutParams3);
        RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        int i16 = localImageView1.getId();
        localLayoutParams4.addRule(6, i16);
        int i17 = localImageView1.getId();
        localLayoutParams4.addRule(1, i17);
        localLayoutParams4.setMargins(0, 0, 0, 0);
        addView(localTextView1, localLayoutParams4);
        RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        int i18 = localImageView1.getId();
        localLayoutParams5.addRule(1, i18);
        int i19 = localTextView1.getId();
        localLayoutParams5.addRule(3, i19);
        localLayoutParams5.setMargins(0, -1, 0, 0);
        addView(localTextView2, localLayoutParams5);
        return;
        localObject2 = new BitmapDrawable(localBitmap5);
        break;
        label1076: localTextView1.setId(3);
        String str7 = paramw.d;
        localTextView1.setText(str7);
        int i20 = localc.i;
        localTextView1.setTextColor(i20);
        float f6 = localc.h;
        localTextView1.setTextSize(f6);
        Typeface localTypeface3 = Typeface.create(localc.g, 0);
        localTextView1.setTypeface(localTypeface3);
        localTextView2.setId(4);
        String str8 = paramw.c;
        localTextView2.setText(str8);
        int i21 = localc.l;
        localTextView2.setTextColor(i21);
        float f7 = localc.k;
        localTextView2.setTextSize(f7);
        Typeface localTypeface4 = Typeface.create(localc.j, 0);
        localTextView2.setTypeface(localTypeface4);
      }
      label1211: localBitmap4 = localBitmap2;
    }
  }

  final p a()
  {
    return this.b;
  }

  final void a(p paramp)
  {
    this.b = paramp;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.z
 * JD-Core Version:    0.6.2
 */