package com.androidquery.callback;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.androidquery.auth.AccountHandle;
import com.androidquery.util.AQUtility;
import com.androidquery.util.BitmapCache;
import com.androidquery.util.Common;
import com.androidquery.util.RatioDrawable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.http.HttpHost;

public class BitmapAjaxCallback extends AbstractAjaxCallback<Bitmap, BitmapAjaxCallback>
{
  private static int BIG_MAX = 0;
  private static int BIG_PIXELS = 0;
  private static int BIG_TPIXELS = 0;
  private static boolean DELAY_WRITE = false;
  private static final int FADE_DUR = 300;
  private static int SMALL_MAX = 20;
  private static int SMALL_PIXELS;
  private static Map<String, Bitmap> bigCache;
  private static Bitmap dummy = Bitmap.createBitmap(1, 1, localConfig2);
  private static Bitmap empty;
  private static Map<String, Bitmap> invalidCache;
  private static HashMap<String, WeakHashMap<ImageView, BitmapAjaxCallback>> queueMap;
  private static Map<String, Bitmap> smallCache;
  private float anchor = 3.4028235E+38F;
  private int animation;
  private Bitmap bm;
  private int fallback;
  private File imageFile;
  private boolean invalid;
  private Bitmap preset;
  private float ratio;
  private int round;
  private boolean targetDim = true;
  private int targetWidth;
  private WeakReference<ImageView> v;

  static
  {
    BIG_MAX = 20;
    SMALL_PIXELS = 2500;
    BIG_PIXELS = 160000;
    BIG_TPIXELS = 1000000;
    DELAY_WRITE = false;
    queueMap = new HashMap();
    Bitmap.Config localConfig1 = Bitmap.Config.ALPHA_8;
    empty = Bitmap.createBitmap(1, 1, localConfig1);
    Bitmap.Config localConfig2 = Bitmap.Config.ALPHA_8;
  }

  public BitmapAjaxCallback()
  {
    Object localObject = ((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)type(Bitmap.class)).memCache(true)).fileCache(true)).url("");
  }

  private void addQueue(String paramString, ImageView paramImageView)
  {
    WeakHashMap localWeakHashMap1 = (WeakHashMap)queueMap.get(paramString);
    if (localWeakHashMap1 == null)
    {
      if (queueMap.containsKey(paramString))
      {
        WeakHashMap localWeakHashMap2 = new WeakHashMap();
        Object localObject1 = localWeakHashMap2.put(paramImageView, this);
        Object localObject2 = queueMap.put(paramString, localWeakHashMap2);
        return;
      }
      Object localObject3 = queueMap.put(paramString, null);
      return;
    }
    Object localObject4 = localWeakHashMap1.put(paramImageView, this);
  }

  public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, Object paramObject, AccountHandle paramAccountHandle, ImageOptions paramImageOptions, HttpHost paramHttpHost, String paramString2)
  {
    boolean bool1 = paramImageOptions.memCache;
    boolean bool2 = paramImageOptions.fileCache;
    int i = paramImageOptions.targetWidth;
    int j = paramImageOptions.fallback;
    Bitmap localBitmap = paramImageOptions.preset;
    int k = paramImageOptions.animation;
    float f1 = paramImageOptions.ratio;
    float f2 = paramImageOptions.anchor;
    int m = paramImageOptions.policy;
    int n = paramImageOptions.round;
    Activity localActivity = paramActivity;
    Context localContext = paramContext;
    ImageView localImageView = paramImageView;
    String str1 = paramString1;
    Object localObject = paramObject;
    AccountHandle localAccountHandle = paramAccountHandle;
    HttpHost localHttpHost = paramHttpHost;
    String str2 = paramString2;
    async(localActivity, localContext, localImageView, str1, bool1, bool2, i, j, localBitmap, k, f1, f2, localObject, localAccountHandle, m, n, localHttpHost, str2);
  }

  public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, float paramFloat1, float paramFloat2, Object paramObject, AccountHandle paramAccountHandle, int paramInt4, int paramInt5, HttpHost paramHttpHost, String paramString2)
  {
    Bitmap localBitmap1 = null;
    if (paramBoolean1)
    {
      int i = paramInt1;
      int j = paramInt5;
      localBitmap1 = memGet(paramString1, i, j);
    }
    if (localBitmap1 != null)
    {
      paramImageView.setTag(1090453505, paramString1);
      Common.showProgress(paramObject, paramString1, false);
      ImageView localImageView = paramImageView;
      Bitmap localBitmap2 = paramBitmap;
      int k = paramInt2;
      int m = paramInt3;
      float f1 = paramFloat1;
      float f2 = paramFloat2;
      setBmAnimate(localImageView, localBitmap1, localBitmap2, k, m, f1, f2, 4);
      return;
    }
    BitmapAjaxCallback localBitmapAjaxCallback1 = new BitmapAjaxCallback();
    BitmapAjaxCallback localBitmapAjaxCallback2 = (BitmapAjaxCallback)((BitmapAjaxCallback)localBitmapAjaxCallback1.url(paramString1)).imageView(paramImageView).memCache(paramBoolean1);
    boolean bool = paramBoolean2;
    BitmapAjaxCallback localBitmapAjaxCallback3 = (BitmapAjaxCallback)localBitmapAjaxCallback2.fileCache(bool);
    int n = paramInt1;
    BitmapAjaxCallback localBitmapAjaxCallback4 = localBitmapAjaxCallback3.targetWidth(n);
    int i1 = paramInt2;
    BitmapAjaxCallback localBitmapAjaxCallback5 = localBitmapAjaxCallback4.fallback(i1);
    Bitmap localBitmap3 = paramBitmap;
    BitmapAjaxCallback localBitmapAjaxCallback6 = localBitmapAjaxCallback5.preset(localBitmap3);
    int i2 = paramInt3;
    BitmapAjaxCallback localBitmapAjaxCallback7 = localBitmapAjaxCallback6.animation(i2);
    float f3 = paramFloat1;
    BitmapAjaxCallback localBitmapAjaxCallback8 = localBitmapAjaxCallback7.ratio(f3);
    float f4 = paramFloat2;
    BitmapAjaxCallback localBitmapAjaxCallback9 = localBitmapAjaxCallback8.anchor(f4);
    Object localObject1 = paramObject;
    BitmapAjaxCallback localBitmapAjaxCallback10 = (BitmapAjaxCallback)localBitmapAjaxCallback9.progress(localObject1);
    AccountHandle localAccountHandle = paramAccountHandle;
    BitmapAjaxCallback localBitmapAjaxCallback11 = (BitmapAjaxCallback)localBitmapAjaxCallback10.auth(localAccountHandle);
    int i3 = paramInt4;
    BitmapAjaxCallback localBitmapAjaxCallback12 = (BitmapAjaxCallback)localBitmapAjaxCallback11.policy(i3);
    int i4 = paramInt5;
    BitmapAjaxCallback localBitmapAjaxCallback13 = localBitmapAjaxCallback12.round(i4);
    String str1 = paramString2;
    Object localObject2 = localBitmapAjaxCallback13.networkUrl(str1);
    if (paramHttpHost != null)
    {
      String str2 = paramHttpHost.getHostName();
      int i5 = paramHttpHost.getPort();
      Object localObject3 = localBitmapAjaxCallback1.proxy(str2, i5);
    }
    if (paramActivity != null)
    {
      localBitmapAjaxCallback1.async(paramActivity);
      return;
    }
    localBitmapAjaxCallback1.async(paramContext);
  }

  private Bitmap bmGet(String paramString, byte[] paramArrayOfByte)
  {
    int i = this.targetWidth;
    boolean bool = this.targetDim;
    int j = this.round;
    return getResizedImage(paramString, paramArrayOfByte, i, bool, j);
  }

  private void checkCb(BitmapAjaxCallback paramBitmapAjaxCallback, String paramString, ImageView paramImageView, Bitmap paramBitmap, AjaxStatus paramAjaxStatus)
  {
    if (paramImageView == null)
      return;
    if (paramBitmapAjaxCallback == null)
      return;
    Object localObject = paramImageView.getTag(1090453505);
    if (paramString.equals(localObject))
    {
      if (!(paramImageView instanceof ImageView))
        break label50;
      paramBitmapAjaxCallback.callback(paramString, paramImageView, paramBitmap, paramAjaxStatus);
    }
    while (true)
    {
      showProgress(false);
      return;
      label50: setBitmap(paramString, paramImageView, paramBitmap, false);
    }
  }

  public static void clearCache()
  {
    bigCache = null;
    smallCache = null;
    invalidCache = null;
  }

  protected static void clearTasks()
  {
    queueMap.clear();
  }

  private static Bitmap decode(String paramString, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap = null;
    if (paramString != null)
      localBitmap = decodeFile(paramString, paramOptions);
    while (true)
    {
      if ((localBitmap == null) && (paramOptions != null) && (!paramOptions.inJustDecodeBounds))
        AQUtility.debug("decode image failed", paramString);
      return localBitmap;
      if (paramArrayOfByte != null)
      {
        int i = paramArrayOfByte.length;
        localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, i, paramOptions);
      }
    }
  }

  // ERROR //
  private static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnonnull +11 -> 14
    //   6: new 275	android/graphics/BitmapFactory$Options
    //   9: dup
    //   10: invokespecial 295	android/graphics/BitmapFactory$Options:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: iconst_1
    //   16: putfield 298	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   19: aload_1
    //   20: iconst_1
    //   21: putfield 301	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   24: aconst_null
    //   25: astore_3
    //   26: new 303	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 306	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 310	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   41: aconst_null
    //   42: aload_1
    //   43: invokestatic 314	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   46: astore 5
    //   48: aload 5
    //   50: astore_2
    //   51: aload 4
    //   53: invokestatic 318	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   56: aload 4
    //   58: astore 6
    //   60: aload_2
    //   61: areturn
    //   62: astore 7
    //   64: aload 7
    //   66: invokestatic 322	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
    //   69: aload_3
    //   70: invokestatic 318	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   73: goto -13 -> 60
    //   76: astore 8
    //   78: aload_3
    //   79: invokestatic 318	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
    //   82: aload 8
    //   84: athrow
    //   85: astore 8
    //   87: aload 4
    //   89: astore 9
    //   91: goto -13 -> 78
    //   94: astore 7
    //   96: aload 4
    //   98: astore_3
    //   99: goto -35 -> 64
    //
    // Exception table:
    //   from	to	target	type
    //   26	36	62	java/io/IOException
    //   26	36	76	finally
    //   64	69	76	finally
    //   36	48	85	finally
    //   36	48	94	java/io/IOException
  }

  private static boolean fadeIn(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default:
      bool = false;
    case -1:
    case -3:
    case -2:
    }
    while (true)
    {
      return bool;
      if (paramInt2 != 3)
        if (paramInt2 != 1)
          break;
    }
  }

  private static Bitmap filter(View paramView, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap != null) && (paramBitmap.getWidth() == 1) && (paramBitmap.getHeight() == 1))
    {
      Bitmap localBitmap = empty;
      if (paramBitmap != localBitmap)
        paramBitmap = null;
    }
    if (paramBitmap != null)
      paramView.setVisibility(0);
    while (true)
    {
      return paramBitmap;
      if (paramInt == -1)
        paramView.setVisibility(8);
      else if (paramInt == -1)
        paramView.setVisibility(4);
    }
  }

  private static Map<String, Bitmap> getBCache()
  {
    if (bigCache == null)
    {
      int i = BIG_MAX;
      int j = BIG_PIXELS;
      int k = BIG_TPIXELS;
      bigCache = Collections.synchronizedMap(new BitmapCache(i, j, k));
    }
    return bigCache;
  }

  public static Bitmap getEmptyBitmap()
  {
    return empty;
  }

  private Bitmap getFallback()
  {
    Bitmap localBitmap = null;
    View localView = (View)this.v.get();
    if (localView != null)
    {
      String str = Integer.toString(this.fallback);
      localBitmap = memGet(str);
      if (localBitmap == null)
      {
        Resources localResources = localView.getResources();
        int i = this.fallback;
        localBitmap = BitmapFactory.decodeResource(localResources, i);
        if (localBitmap != null)
          memPut(str, localBitmap);
      }
    }
    return localBitmap;
  }

  private static Map<String, Bitmap> getICache()
  {
    if (invalidCache == null)
    {
      int i = BIG_PIXELS;
      invalidCache = Collections.synchronizedMap(new BitmapCache(100, i, 250000));
    }
    return invalidCache;
  }

  private static String getKey(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      String str1 = String.valueOf(paramString);
      paramString = str1 + "#" + paramInt1;
    }
    if (paramInt2 > 0)
    {
      String str2 = String.valueOf(paramString);
      paramString = str2 + "#" + paramInt2;
    }
    return paramString;
  }

  public static Bitmap getMemoryCached(Context paramContext, int paramInt)
  {
    String str = Integer.toString(paramInt);
    Bitmap localBitmap = memGet(str, 0, 0);
    if (localBitmap == null)
    {
      localBitmap = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      if (localBitmap != null)
        memPut(str, 0, 0, localBitmap, false);
    }
    return localBitmap;
  }

  public static Bitmap getMemoryCached(String paramString, int paramInt)
  {
    return memGet(paramString, paramInt, 0);
  }

  public static Bitmap getResizedImage(String paramString, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    BitmapFactory.Options localOptions1 = null;
    if (paramInt1 > 0)
    {
      BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
      localOptions2.inJustDecodeBounds = true;
      Bitmap localBitmap1 = decode(paramString, paramArrayOfByte, localOptions2);
      int i = localOptions2.outWidth;
      if (!paramBoolean)
      {
        int j = localOptions2.outHeight;
        i = Math.max(i, j);
      }
      int k = sampleSize(i, paramInt1);
      localOptions1 = new BitmapFactory.Options();
      localOptions1.inSampleSize = k;
    }
    Object localObject = null;
    try
    {
      Bitmap localBitmap2 = decode(paramString, paramArrayOfByte, localOptions1);
      localObject = localBitmap2;
      if (paramInt2 > 0)
        localObject = getRoundedCornerBitmap((Bitmap)localObject, paramInt2);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        clearCache();
        AQUtility.report(localOutOfMemoryError);
      }
    }
  }

  private static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    Rect localRect = new Rect(0, 0, k, m);
    RectF localRectF = new RectF(localRect);
    float f = paramInt;
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
    PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(localMode);
    Xfermode localXfermode = localPaint.setXfermode(localPorterDuffXfermode);
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }

  private static Map<String, Bitmap> getSCache()
  {
    if (smallCache == null)
    {
      int i = SMALL_MAX;
      int j = SMALL_PIXELS;
      smallCache = Collections.synchronizedMap(new BitmapCache(i, j, 250000));
    }
    return smallCache;
  }

  public static boolean isMemoryCached(String paramString)
  {
    if ((!getBCache().containsKey(paramString)) && (!getSCache().containsKey(paramString)) && (!getICache().containsKey(paramString)));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  private static Drawable makeDrawable(ImageView paramImageView, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    Resources localResources1;
    Bitmap localBitmap;
    ImageView localImageView;
    float f1;
    float f2;
    if (paramFloat1 > 0.0F)
    {
      localResources1 = paramImageView.getResources();
      localBitmap = paramBitmap;
      localImageView = paramImageView;
      f1 = paramFloat1;
      f2 = paramFloat2;
    }
    Resources localResources2;
    for (Object localObject = new RatioDrawable(localResources1, localBitmap, localImageView, f1, f2); ; localObject = new BitmapDrawable(localResources2, paramBitmap))
    {
      return localObject;
      localResources2 = paramImageView.getResources();
    }
  }

  private static Bitmap memGet(String paramString, int paramInt1, int paramInt2)
  {
    String str = getKey(paramString, paramInt1, paramInt2);
    Bitmap localBitmap = (Bitmap)getBCache().get(str);
    if (localBitmap == null)
      localBitmap = (Bitmap)getSCache().get(str);
    if (localBitmap == null)
    {
      localBitmap = (Bitmap)getICache().get(str);
      if ((localBitmap != null) && (getLastStatus() == 200))
      {
        invalidCache = null;
        localBitmap = null;
      }
    }
    return localBitmap;
  }

  private static void memPut(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == null)
      return;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = i * j;
    Map localMap;
    if (paramBoolean)
      localMap = getICache();
    while ((paramInt1 > 0) || (paramInt2 > 0))
    {
      String str = getKey(paramString, paramInt1, paramInt2);
      Object localObject1 = localMap.put(str, paramBitmap);
      if (localMap.containsKey(paramString))
        return;
      Object localObject2 = localMap.put(paramString, null);
      return;
      int m = SMALL_PIXELS;
      if (k <= m)
        localMap = getSCache();
      else
        localMap = getBCache();
    }
    Object localObject3 = localMap.put(paramString, paramBitmap);
  }

  private void presetBitmap(String paramString, ImageView paramImageView)
  {
    Object localObject = paramImageView.getTag(1090453505);
    if ((paramString.equals(localObject)) && (this.preset == null))
      return;
    paramImageView.setTag(1090453505, paramString);
    if (this.preset != null)
    {
      Context localContext = paramImageView.getContext();
      if (!cacheAvailable(localContext))
      {
        Bitmap localBitmap = this.preset;
        setBitmap(paramString, paramImageView, localBitmap, true);
        return;
      }
    }
    setBitmap(paramString, paramImageView, null, true);
  }

  private static int sampleSize(int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 0;
    while (true)
    {
      if (j >= 10);
      int k;
      do
      {
        return i;
        k = paramInt2 * 2;
      }
      while (paramInt1 < k);
      paramInt1 /= 2;
      i *= 2;
      j += 1;
    }
  }

  private void setBitmap(String paramString, ImageView paramImageView, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == null)
    {
      paramImageView.setImageDrawable(null);
      return;
    }
    if (paramBoolean)
    {
      float f1 = this.ratio;
      float f2 = this.anchor;
      Drawable localDrawable = makeDrawable(paramImageView, paramBitmap, f1, f2);
      paramImageView.setImageDrawable(localDrawable);
      return;
    }
    if (this.status == null)
      return;
    Bitmap localBitmap1 = this.preset;
    int i = this.fallback;
    int j = this.animation;
    float f3 = this.ratio;
    float f4 = this.anchor;
    int k = this.status.getSource();
    ImageView localImageView = paramImageView;
    Bitmap localBitmap2 = paramBitmap;
    setBmAnimate(localImageView, localBitmap2, localBitmap1, i, j, f3, f4, k);
  }

  private static void setBmAnimate(ImageView paramImageView, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    Bitmap localBitmap = filter(paramImageView, paramBitmap1, paramInt1);
    if (localBitmap == null)
    {
      paramImageView.setImageBitmap(null);
      return;
    }
    Object localObject1 = makeDrawable(paramImageView, localBitmap, paramFloat1, paramFloat2);
    Object localObject2 = null;
    if (fadeIn(paramInt2, paramInt3))
      if (paramBitmap2 == null)
      {
        localObject2 = new AlphaAnimation(0.0F, 1.0F);
        DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator();
        ((Animation)localObject2).setInterpolator(localDecelerateInterpolator);
        ((Animation)localObject2).setDuration(300L);
      }
    while (true)
    {
      paramImageView.setImageDrawable((Drawable)localObject1);
      if (localObject2 == null)
        break;
      long l = AnimationUtils.currentAnimationTimeMillis();
      ((Animation)localObject2).setStartTime(l);
      paramImageView.startAnimation((Animation)localObject2);
      return;
      Drawable localDrawable = makeDrawable(paramImageView, paramBitmap2, paramFloat1, paramFloat2);
      Drawable[] arrayOfDrawable = new Drawable[2];
      arrayOfDrawable[0] = localDrawable;
      arrayOfDrawable[1] = localObject1;
      TransitionDrawable localTransitionDrawable = new TransitionDrawable(arrayOfDrawable);
      localTransitionDrawable.setCrossFadeEnabled(true);
      localTransitionDrawable.startTransition(300);
      localObject1 = localTransitionDrawable;
      continue;
      if (paramInt2 > 0)
        localObject2 = AnimationUtils.loadAnimation(paramImageView.getContext(), paramInt2);
    }
    paramImageView.setAnimation(null);
  }

  public static void setCacheLimit(int paramInt)
  {
    BIG_MAX = paramInt;
    clearCache();
  }

  public static void setDelayWrite(boolean paramBoolean)
  {
    DELAY_WRITE = paramBoolean;
  }

  public static void setIconCacheLimit(int paramInt)
  {
    SMALL_MAX = paramInt;
    clearCache();
  }

  public static void setMaxPixelLimit(int paramInt)
  {
    BIG_TPIXELS = paramInt;
    clearCache();
  }

  public static void setPixelLimit(int paramInt)
  {
    BIG_PIXELS = paramInt;
    clearCache();
  }

  public static void setSmallPixel(int paramInt)
  {
    SMALL_PIXELS = paramInt;
    clearCache();
  }

  protected File accessFile(File paramFile, String paramString)
  {
    if ((this.imageFile != null) && (this.imageFile.exists()));
    for (File localFile = this.imageFile; ; localFile = super.accessFile(paramFile, paramString))
      return localFile;
  }

  public BitmapAjaxCallback anchor(float paramFloat)
  {
    this.anchor = paramFloat;
    return this;
  }

  public BitmapAjaxCallback animation(int paramInt)
  {
    this.animation = paramInt;
    return this;
  }

  public void async(Context paramContext)
  {
    String str = getUrl();
    ImageView localImageView = (ImageView)this.v.get();
    if (str == null)
    {
      showProgress(false);
      setBitmap(str, localImageView, null, false);
      return;
    }
    Bitmap localBitmap = memGet(str);
    if (localBitmap != null)
    {
      localImageView.setTag(1090453505, str);
      AjaxStatus localAjaxStatus1 = new AjaxStatus().source(4).done();
      this.status = localAjaxStatus1;
      AjaxStatus localAjaxStatus2 = this.status;
      callback(str, localBitmap, localAjaxStatus2);
      return;
    }
    presetBitmap(str, localImageView);
    if (!queueMap.containsKey(str))
    {
      addQueue(str, localImageView);
      Context localContext = localImageView.getContext();
      super.async(localContext);
      return;
    }
    showProgress(true);
    addQueue(str, localImageView);
  }

  public BitmapAjaxCallback bitmap(Bitmap paramBitmap)
  {
    this.bm = paramBitmap;
    return this;
  }

  public final void callback(String paramString, Bitmap paramBitmap, AjaxStatus paramAjaxStatus)
  {
    ImageView localImageView1 = (ImageView)this.v.get();
    WeakHashMap localWeakHashMap = (WeakHashMap)queueMap.remove(paramString);
    if ((localWeakHashMap == null) || (!localWeakHashMap.containsKey(localImageView1)))
    {
      BitmapAjaxCallback localBitmapAjaxCallback1 = this;
      BitmapAjaxCallback localBitmapAjaxCallback2 = this;
      String str1 = paramString;
      Bitmap localBitmap1 = paramBitmap;
      AjaxStatus localAjaxStatus1 = paramAjaxStatus;
      localBitmapAjaxCallback1.checkCb(localBitmapAjaxCallback2, str1, localImageView1, localBitmap1, localAjaxStatus1);
    }
    if (localWeakHashMap == null)
      return;
    Iterator localIterator = localWeakHashMap.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ImageView localImageView2 = (ImageView)localIterator.next();
      BitmapAjaxCallback localBitmapAjaxCallback3 = (BitmapAjaxCallback)localWeakHashMap.get(localImageView2);
      localBitmapAjaxCallback3.status = paramAjaxStatus;
      BitmapAjaxCallback localBitmapAjaxCallback4 = this;
      String str2 = paramString;
      Bitmap localBitmap2 = paramBitmap;
      AjaxStatus localAjaxStatus2 = paramAjaxStatus;
      localBitmapAjaxCallback4.checkCb(localBitmapAjaxCallback3, str2, localImageView2, localBitmap2, localAjaxStatus2);
    }
  }

  protected void callback(String paramString, ImageView paramImageView, Bitmap paramBitmap, AjaxStatus paramAjaxStatus)
  {
    setBitmap(paramString, paramImageView, paramBitmap, false);
  }

  public BitmapAjaxCallback fallback(int paramInt)
  {
    this.fallback = paramInt;
    return this;
  }

  public BitmapAjaxCallback file(File paramFile)
  {
    this.imageFile = paramFile;
    return this;
  }

  protected Bitmap fileGet(String paramString, File paramFile, AjaxStatus paramAjaxStatus)
  {
    String str = paramFile.getAbsolutePath();
    return bmGet(str, null);
  }

  public BitmapAjaxCallback imageView(ImageView paramImageView)
  {
    WeakReference localWeakReference = new WeakReference(paramImageView);
    this.v = localWeakReference;
    return this;
  }

  protected boolean isStreamingContent()
  {
    if (DELAY_WRITE);
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  protected Bitmap memGet(String paramString)
  {
    Bitmap localBitmap;
    if (this.bm != null)
      localBitmap = this.bm;
    while (true)
    {
      return localBitmap;
      if (!this.memCache)
      {
        localBitmap = null;
      }
      else
      {
        int i = this.targetWidth;
        int j = this.round;
        localBitmap = memGet(paramString, i, j);
      }
    }
  }

  protected void memPut(String paramString, Bitmap paramBitmap)
  {
    int i = this.targetWidth;
    int j = this.round;
    boolean bool = this.invalid;
    memPut(paramString, i, j, paramBitmap, bool);
  }

  public BitmapAjaxCallback preset(Bitmap paramBitmap)
  {
    this.preset = paramBitmap;
    return this;
  }

  public BitmapAjaxCallback ratio(float paramFloat)
  {
    this.ratio = paramFloat;
    return this;
  }

  public BitmapAjaxCallback round(int paramInt)
  {
    this.round = paramInt;
    return this;
  }

  protected void skip(String paramString, Bitmap paramBitmap, AjaxStatus paramAjaxStatus)
  {
    Object localObject = queueMap.remove(paramString);
  }

  public BitmapAjaxCallback targetWidth(int paramInt)
  {
    this.targetWidth = paramInt;
    return this;
  }

  public Bitmap transform(String paramString, byte[] paramArrayOfByte, AjaxStatus paramAjaxStatus)
  {
    String str = null;
    File localFile = paramAjaxStatus.getFile();
    if (localFile != null)
      str = localFile.getAbsolutePath();
    Bitmap localBitmap = bmGet(str, paramArrayOfByte);
    if (localBitmap == null)
    {
      if (this.fallback <= 0)
        break label66;
      localBitmap = getFallback();
    }
    while (true)
    {
      if (paramAjaxStatus.getCode() != 200)
        this.invalid = true;
      return localBitmap;
      label66: if ((this.fallback == -1) || (this.fallback == -1))
        localBitmap = dummy;
      else if (this.fallback == -1)
        localBitmap = this.preset;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.callback.BitmapAjaxCallback
 * JD-Core Version:    0.6.2
 */