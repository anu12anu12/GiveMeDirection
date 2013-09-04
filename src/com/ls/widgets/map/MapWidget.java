package com.ls.widgets.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Scroller;
import android.widget.ZoomButtonsController;
import android.widget.ZoomButtonsController.OnZoomListener;
import com.ls.widgets.map.config.GPSConfig;
import com.ls.widgets.map.config.MapConfigParser;
import com.ls.widgets.map.config.MapGraphicsConfig;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.events.MapScrolledEvent;
import com.ls.widgets.map.events.MapTouchedEvent;
import com.ls.widgets.map.events.ObjectTouchEvent;
import com.ls.widgets.map.interfaces.Layer;
import com.ls.widgets.map.interfaces.MapEventsListener;
import com.ls.widgets.map.interfaces.MapLocationListener;
import com.ls.widgets.map.interfaces.OnGridReadyListener;
import com.ls.widgets.map.interfaces.OnLocationChangedListener;
import com.ls.widgets.map.interfaces.OnMapDoubleTapListener;
import com.ls.widgets.map.interfaces.OnMapLongClickListener;
import com.ls.widgets.map.interfaces.OnMapScrollListener;
import com.ls.widgets.map.interfaces.OnMapTilesFinishedLoadingListener;
import com.ls.widgets.map.interfaces.OnMapTouchListener;
import com.ls.widgets.map.location.PositionMarker;
import com.ls.widgets.map.model.Grid;
import com.ls.widgets.map.model.MapLayer;
import com.ls.widgets.map.providers.AssetTileProvider;
import com.ls.widgets.map.providers.ExternalStorageTileProvider;
import com.ls.widgets.map.providers.GPSLocationProvider;
import com.ls.widgets.map.providers.TileProvider;
import com.ls.widgets.map.utils.Graphics;
import com.ls.widgets.map.utils.MapCalibrationData;
import com.ls.widgets.map.utils.MathUtils;
import com.ls.widgets.map.utils.OfflineMapUtil;
import com.ls.widgets.map.utils.PivotFactory;
import com.ls.widgets.map.utils.PivotFactory.PivotPosition;
import com.ls.widgets.map.utils.TransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xml.sax.SAXException;

public class MapWidget extends View
  implements MapLocationListener
{
  private static Bitmap K;
  static final MapScrolledEvent a = new MapScrolledEvent(0, 0);
  static final Rect b = new Rect();
  static MapTouchedEvent c = new MapTouchedEvent();
  private GestureDetector A;
  private Scroller B;
  private boolean C = false;
  private RectF D;
  private boolean E;
  private boolean F;
  private boolean G;
  private double H;
  private int I;
  private int J;
  private Rect L;
  private Runnable M;
  private Runnable N;
  private Runnable O;
  private boolean P;
  private DecelerateInterpolator Q;
  private OfflineMapConfig d;
  private ZoomButtonsController e;
  private Grid f;
  private Grid g;
  private Paint h;
  private float i;
  private double j;
  private boolean k;
  private boolean l;
  protected GPSLocationProvider locationProvider;
  private boolean m;
  private MapLayer n;
  private ArrayList<MapLayer> o;
  private Map<Long, Layer> p;
  private OnMapTouchListener q;
  private OnMapTilesFinishedLoadingListener r;
  private OnMapScrollListener s;
  private ArrayList<MapEventsListener> t;
  protected TileProvider tileProvider;
  private OnLocationChangedListener u;
  private View.OnLongClickListener v;
  private OnMapLongClickListener w;
  private OnMapDoubleTapListener x;
  private View.OnTouchListener y;
  private a z;

  public MapWidget(Context paramContext, File paramFile)
  {
    this(null, paramContext, paramFile, 10);
  }

  public MapWidget(Context paramContext, File paramFile, int paramInt)
  {
    this(null, paramContext, paramFile, paramInt);
  }

  public MapWidget(Context paramContext, String paramString)
  {
    this(null, paramContext, paramString, 10);
  }

  public MapWidget(Context paramContext, String paramString, int paramInt)
  {
    this(null, paramContext, paramString, paramInt);
  }

  public MapWidget(Bundle paramBundle, Context paramContext, File paramFile, int paramInt)
  {
    super(paramContext);
    a(paramContext);
    for (float f1 = OfflineMapUtil.getConfigFilePath(paramFile.getAbsolutePath()); ; f1 = 1.0F)
      try
      {
        String str1 = paramFile.getAbsolutePath();
        MapConfigParser localMapConfigParser = new MapConfigParser(str1);
        File localFile = new File(f1);
        OfflineMapConfig localOfflineMapConfig1 = localMapConfigParser.parse(paramContext, localFile);
        this.d = localOfflineMapConfig1;
        if (this.d == null)
          return;
        OfflineMapConfig localOfflineMapConfig2 = this.d;
        ExternalStorageTileProvider localExternalStorageTileProvider = new ExternalStorageTileProvider(localOfflineMapConfig2);
        this.tileProvider = localExternalStorageTileProvider;
        int i1 = this.d.getImageWidth();
        int i2 = this.d.getImageHeight();
        int i3 = OfflineMapUtil.getMaxZoomLevel(i1, i2);
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("com.ls.zoomLevel"))
            paramInt = paramBundle.getInt("com.ls.zoomLevel");
          if (paramBundle.containsKey("com.ls.scale"))
          {
            f1 = paramBundle.getFloat("com.ls.scale");
            if (paramInt > i3)
            {
              OfflineMapConfig localOfflineMapConfig3 = this.d;
              TileProvider localTileProvider1 = this.tileProvider;
              Grid localGrid1 = new Grid(this, localOfflineMapConfig3, localTileProvider1, i3);
              this.f = localGrid1;
              if (f1 == 1.0F)
              {
                double d1 = paramInt - i3;
                f1 = (float)Math.pow(2.0D, d1);
              }
            }
            while (true)
            {
              this.i = f1;
              this.f.setInternalScale(f1);
              a();
              a(paramBundle);
              return;
              OfflineMapConfig localOfflineMapConfig4 = this.d;
              TileProvider localTileProvider2 = this.tileProvider;
              Grid localGrid2 = new Grid(this, localOfflineMapConfig4, localTileProvider2, paramInt);
              this.f = localGrid2;
            }
          }
        }
      }
      catch (SAXException localSAXException)
      {
        String str2 = "Exception: " + localSAXException;
        int i4 = Log.e("MAP WIDGET", str2);
        localSAXException.printStackTrace();
        return;
      }
      catch (IOException localIOException)
      {
        String str3 = "Exception: " + localIOException;
        int i5 = Log.e("MAP WIDGET", str3);
        localIOException.printStackTrace();
        return;
      }
  }

  public MapWidget(Bundle paramBundle, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    a(paramContext);
    for (float f1 = OfflineMapUtil.getConfigFilePath(paramString); ; f1 = 1.0F)
      try
      {
        OfflineMapConfig localOfflineMapConfig1 = new MapConfigParser(paramString).parse(paramContext, f1);
        this.d = localOfflineMapConfig1;
        Context localContext = getContext();
        OfflineMapConfig localOfflineMapConfig2 = this.d;
        AssetTileProvider localAssetTileProvider = new AssetTileProvider(localContext, localOfflineMapConfig2);
        this.tileProvider = localAssetTileProvider;
        int i1 = this.d.getImageWidth();
        int i2 = this.d.getImageHeight();
        int i3 = OfflineMapUtil.getMaxZoomLevel(i1, i2);
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("com.ls.zoomLevel"))
            paramInt = paramBundle.getInt("com.ls.zoomLevel");
          if (paramBundle.containsKey("com.ls.scale"))
          {
            f1 = paramBundle.getFloat("com.ls.scale");
            if (paramInt > i3)
            {
              OfflineMapConfig localOfflineMapConfig3 = this.d;
              TileProvider localTileProvider1 = this.tileProvider;
              Grid localGrid1 = new Grid(this, localOfflineMapConfig3, localTileProvider1, i3);
              this.f = localGrid1;
              if (f1 == 1.0F)
              {
                double d1 = paramInt - i3;
                f1 = (float)Math.pow(2.0D, d1);
              }
            }
            while (true)
            {
              this.i = f1;
              this.f.setInternalScale(f1);
              a();
              a(paramBundle);
              return;
              OfflineMapConfig localOfflineMapConfig4 = this.d;
              TileProvider localTileProvider2 = this.tileProvider;
              Grid localGrid2 = new Grid(this, localOfflineMapConfig4, localTileProvider2, paramInt);
              this.f = localGrid2;
            }
          }
        }
      }
      catch (SAXException localSAXException)
      {
        String str1 = "Exception: " + localSAXException;
        int i4 = Log.e("MAP WIDGET", str1);
        localSAXException.printStackTrace();
        return;
      }
      catch (IOException localIOException)
      {
        String str2 = "Exception: " + localIOException;
        int i5 = Log.e("MAP WIDGET", str2);
        localIOException.printStackTrace();
        return;
      }
  }

  private Animation a(float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    float f2 = 2.0F;
    float f3 = paramFloat1;
    float f4 = paramFloat2;
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 2.0F, f1, f2, f3, f4);
    localScaleAnimation.setDuration(500L);
    DecelerateInterpolator localDecelerateInterpolator = this.Q;
    localScaleAnimation.setInterpolator(localDecelerateInterpolator);
    localScaleAnimation.setFillAfter(true);
    return localScaleAnimation;
  }

  private ArrayList<ObjectTouchEvent> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    float f1 = 5.0F;
    if (this.d != null)
      f1 = this.d.getTouchAreaSize() / 2.0F;
    Rect localRect1 = b;
    int i1 = (int)(paramInt1 - f1);
    int i2 = (int)(paramInt2 - f1);
    int i3 = (int)(paramInt1 + f1);
    float f2 = paramInt2;
    int i4 = (int)(f1 + f2);
    localRect1.set(i1, i2, i3, i4);
    int i5 = this.o.size() + -1;
    while (i5 >= 0)
    {
      MapLayer localMapLayer = (MapLayer)this.o.get(i5);
      if (localMapLayer.isVisible())
      {
        Rect localRect2 = b;
        Iterator localIterator = localMapLayer.getTouched(localRect2).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          long l1 = localMapLayer.getId();
          ObjectTouchEvent localObjectTouchEvent = new ObjectTouchEvent(localObject, l1);
          boolean bool = localArrayList.add(localObjectTouchEvent);
        }
      }
      i5 += -1;
    }
    return localArrayList;
  }

  private void a()
  {
    android.content.res.Resources localResources1 = getResources();
    byte[] arrayOfByte1 = Graphics.BLUE_ARROW;
    int i1 = Graphics.BLUE_ARROW.length;
    Bitmap localBitmap1 = BitmapFactory.decodeByteArray(arrayOfByte1, 0, i1);
    BitmapDrawable localBitmapDrawable1 = new BitmapDrawable(localResources1, localBitmap1);
    android.content.res.Resources localResources2 = getResources();
    byte[] arrayOfByte2 = Graphics.BLUE_DOT;
    int i2 = Graphics.BLUE_DOT.length;
    Bitmap localBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte2, 0, i2);
    BitmapDrawable localBitmapDrawable2 = new BitmapDrawable(localResources2, localBitmap2);
    Long localLong = Long.valueOf(1L);
    PositionMarker localPositionMarker = new PositionMarker(this, localLong, localBitmapDrawable2, localBitmapDrawable1);
    this.n.addMapObject(localPositionMarker);
  }

  private void a(float paramFloat)
  {
    int i1 = this.o.size();
    this.n.setScale(paramFloat);
    int i2 = 0;
    while (true)
    {
      if (i2 >= i1)
        return;
      ((MapLayer)this.o.get(i2)).setScale(paramFloat);
      i2 += 1;
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.f == null)
    {
      this.k = false;
      return;
    }
    int i1 = this.d.getImageWidth();
    int i2 = this.d.getImageHeight();
    int i3 = OfflineMapUtil.getMaxZoomLevel(i1, i2);
    int i4 = getZoomLevel();
    Grid localGrid1 = this.f;
    this.g = localGrid1;
    this.g.setLoadTiles(false);
    int i5 = this.f.getWidth();
    int i6 = this.f.getHeight();
    int i7 = getZoomLevel();
    double d1 = paramInt1 - i7;
    float f1 = (float)Math.pow(2.0D, d1);
    int i8 = -getScrollX();
    int i9 = -getScrollY();
    int i10 = getScrollX();
    int i11 = i5 - i10;
    int i12 = getScrollY();
    int i13 = i6 - i12;
    Rect localRect = TransformUtils.scaleRect(new Rect(i8, i9, i11, i13), f1, paramInt2, paramInt3);
    int i14;
    if (paramInt1 > i4)
    {
      i14 = 1;
      if (((i14 == 0) || (i4 >= i3)) && ((i14 != 0) || (i4 <= 0) || (this.i != 1.0F)))
        break label342;
      OfflineMapConfig localOfflineMapConfig = this.d;
      TileProvider localTileProvider = this.tileProvider;
      Grid localGrid2 = new Grid(this, localOfflineMapConfig, localTileProvider, paramInt1);
      this.f = localGrid2;
      Grid localGrid3 = this.f;
      OnGridReadyListener local7 = new OnGridReadyListener()
      {
        public void onReady()
        {
          MapWidget.c(MapWidget.this).setOnReadyListener(null);
          Grid localGrid = MapWidget.a(MapWidget.this, null);
          if (MapWidget.a(MapWidget.this) == null)
            return;
          MapWidget.a(MapWidget.this).onMapTilesFinishedLoading();
        }
      };
      localGrid3.setOnReadyListener(local7);
      this.g.setInternalScale(f1);
    }
    while (true)
    {
      f();
      float f2 = getScale();
      a(f2);
      int i15 = -i14.left;
      int i16 = -i14.top;
      scrollTo(i15, i16);
      this.k = false;
      if (i14 == 0)
        break label415;
      b(this.t);
      return;
      i14 = 0;
      break;
      label342: float f3 = this.i * f1;
      this.i = f3;
      if (this.g != null)
        this.g = null;
      this.f.setOnReadyListener(null);
      this.f.setLoadTiles(false);
      Grid localGrid4 = this.f;
      float f4 = this.i;
      localGrid4.setInternalScale(f4);
      this.f.setLoadTiles(true);
    }
    label415: d(this.t);
  }

  private void a(Context paramContext)
  {
    this.i = 1.0F;
    a locala = a.a;
    this.z = locala;
    Rect localRect = new Rect();
    this.L = localRect;
    this.l = true;
    this.P = false;
    this.G = false;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    setLayoutParams(localLayoutParams);
    setBackgroundDrawable(null);
    setClickable(true);
    setEnabled(true);
    setFocusable(true);
    e();
    b localb = new b(null);
    GestureDetector localGestureDetector = new GestureDetector(paramContext, localb);
    this.A = localGestureDetector;
    DecelerateInterpolator localDecelerateInterpolator1 = new DecelerateInterpolator(1.5F);
    this.Q = localDecelerateInterpolator1;
    DecelerateInterpolator localDecelerateInterpolator2 = this.Q;
    Scroller localScroller = new Scroller(paramContext, localDecelerateInterpolator2);
    this.B = localScroller;
    MapLayer localMapLayer = new MapLayer(1L, this);
    this.n = localMapLayer;
    this.n.setVisible(false);
    ArrayList localArrayList1 = new ArrayList();
    this.o = localArrayList1;
    HashMap localHashMap = new HashMap();
    this.p = localHashMap;
    ArrayList localArrayList2 = new ArrayList();
    this.t = localArrayList2;
    Paint localPaint1 = new Paint();
    this.h = localPaint1;
    this.h.setColor(-65536);
    Paint localPaint2 = this.h;
    Paint.Style localStyle = Paint.Style.STROKE;
    localPaint2.setStyle(localStyle);
    this.h.setStrokeWidth(1.0F);
    if (com.ls.widgets.map.utils.Resources.LOGO != null)
    {
      byte[] arrayOfByte = com.ls.widgets.map.utils.Resources.LOGO;
      int i1 = com.ls.widgets.map.utils.Resources.LOGO.length;
      K = BitmapFactory.decodeByteArray(arrayOfByte, 0, i1);
    }
    this.locationProvider = null;
    this.O = null;
  }

  private void a(Canvas paramCanvas)
  {
    this.h.setTextSize(24.0F);
    Paint localPaint1 = this.h;
    Paint.Style localStyle = Paint.Style.FILL;
    localPaint1.setStyle(localStyle);
    this.h.setAntiAlias(true);
    this.h.setSubpixelText(true);
    this.h.setColor(-16777216);
    Paint localPaint2 = this.h;
    paramCanvas.drawPaint(localPaint2);
    this.h.setColor(-1);
    Rect localRect1 = new Rect();
    Paint localPaint3 = this.h;
    int i1 = "Map data is corrupted or missing.".length();
    localPaint3.getTextBounds("Map data is corrupted or missing.", 0, i1, localRect1);
    Rect localRect2 = paramCanvas.getClipBounds();
    int i2 = localRect2.width();
    int i3 = localRect1.width();
    float f1 = (i2 - i3) / 2;
    float f2 = localRect2.height() / 2;
    Paint localPaint4 = this.h;
    paramCanvas.drawText("Map data is corrupted or missing.", f1, f2, localPaint4);
  }

  private void a(Canvas paramCanvas, Rect paramRect)
  {
    int i1 = this.o.size();
    int i2 = 0;
    while (i2 < i1)
    {
      ((MapLayer)this.o.get(i2)).draw(paramCanvas, paramRect);
      i2 += 1;
    }
    this.n.draw(paramCanvas, paramRect);
  }

  private void a(Location paramLocation)
  {
    if (this.u == null)
      return;
    try
    {
      this.u.onLocationChanged(this, paramLocation);
      return;
    }
    catch (Exception localException)
    {
      String str = "Exception while executing onLocationChanged. " + localException;
      int i1 = Log.w("MAP WIDGET", str);
    }
  }

  private void a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("com.ls.curPosOnMapX")))
    {
      final int i1 = (int)paramBundle.getFloat("com.ls.curPosOnMapX");
      final int i2 = (int)paramBundle.getFloat("com.ls.curPosOnMapY");
      String str = "Restored pos: [" + i1 + "," + i2 + "]";
      int i3 = Log.d("MapWidget", str);
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          MapWidget localMapWidget = MapWidget.this;
          int i = i1;
          int j = i2;
          Point localPoint = new Point(i, j);
          localMapWidget.jumpTo(localPoint);
        }
      };
      this.M = local1;
      return;
    }
    a(false, false);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = getScrollX();
    int i3 = i1 + i2;
    int i4 = (int)paramMotionEvent.getY();
    int i5 = getScrollY();
    int i6 = i4 + i5;
    ArrayList localArrayList = a(i3, i6);
    MapTouchedEvent localMapTouchedEvent1 = c;
    int i7 = (int)paramMotionEvent.getX();
    localMapTouchedEvent1.setScreenX(i7);
    MapTouchedEvent localMapTouchedEvent2 = c;
    int i8 = (int)paramMotionEvent.getY();
    localMapTouchedEvent2.setScreenY(i8);
    MapTouchedEvent localMapTouchedEvent3 = c;
    float f1 = paramMotionEvent.getX();
    int i9 = (int)b(f1);
    localMapTouchedEvent3.setMapX(i9);
    MapTouchedEvent localMapTouchedEvent4 = c;
    float f2 = paramMotionEvent.getY();
    int i10 = (int)c(f2);
    localMapTouchedEvent4.setMapY(i10);
    c.setTouchedObjectEvents(localArrayList);
  }

  private static final void a(ArrayList<MapEventsListener> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MapEventsListener localMapEventsListener = (MapEventsListener)localIterator.next();
      if (localMapEventsListener != null)
        try
        {
          localMapEventsListener.onPreZoomIn();
        }
        catch (Exception localException)
        {
          String str = "Exception " + localException + " on willZoomIn";
          int i1 = Log.e("MAP WIDGET", str);
        }
      else
        int i2 = Log.w("MAP WIDGET", "WillZoomIn: Map Events listener is null");
    }
  }

  private void a(boolean paramBoolean)
  {
    boolean bool = this.l;
    a(paramBoolean, bool);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() == null)
      throw new IllegalThreadStateException("Should be called from UI thread");
    if (this.f == null)
      return;
    if (this.E)
      return;
    if ((!this.d.isMapCenteringEnabled()) && (!paramBoolean1))
    {
      c();
      return;
    }
    int i1 = getWidth();
    int i2 = getHeight();
    int i3 = getMapWidth();
    int i4 = getMapHeight();
    int i6;
    float f2;
    int i8;
    if (i3 > i1)
    {
      int i5 = getScrollX();
      i6 = i3 - i5;
      if (getScrollX() < 0)
      {
        float f1 = getScrollX() * -1;
        int i7 = getScrollY();
        scrollTo(0, i7);
        f2 = f1;
        i8 = 1;
      }
    }
    while (true)
    {
      float f4;
      if (i4 > i2)
      {
        int i9 = getScrollY();
        i4 -= i9;
        if (getScrollY() < 0)
        {
          float f3 = -getScrollY();
          int i10 = getScrollX();
          scrollTo(i10, 0);
          f4 = f3;
          i8 = 1;
        }
      }
      while (true)
      {
        if ((i8 != 0) || (paramBoolean1))
        {
          if (paramBoolean2)
          {
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(f2, 0.0F, f4, 0.0F);
            Runnable local6 = new Runnable()
            {
              public void run()
              {
                MapWidget.b(MapWidget.this);
              }
            };
            this.O = local6;
            localTranslateAnimation.setDuration(500L);
            DecelerateInterpolator localDecelerateInterpolator = this.Q;
            localTranslateAnimation.setInterpolator(localDecelerateInterpolator);
            localTranslateAnimation.setFillAfter(true);
            startAnimation(localTranslateAnimation);
            return;
            if (i6 >= i1)
              break label485;
            int i11 = i1 - i6;
            float f5 = -i11;
            int i12 = getScrollX() - i11;
            int i13 = getScrollY();
            scrollTo(i12, i13);
            f2 = f5;
            i8 = 1;
            break;
            float f6 = (i1 - i3) / 2;
            f2 = -getScrollX() - f6;
            int i14 = -(int)f6;
            int i15 = getScrollY();
            scrollTo(i14, i15);
            i8 = 1;
            break;
            if (i4 >= i2)
              break label477;
            int i16 = i2 - i4;
            float f7 = -i16;
            int i17 = getScrollX();
            int i18 = getScrollY() - i16;
            scrollTo(i17, i18);
            f4 = f7;
            i8 = 1;
            continue;
            float f8 = (i2 - i4) / 2.0F;
            f4 = -getScrollY() - f8;
            int i19 = getScrollX();
            int i20 = -(int)f8;
            scrollTo(i19, i20);
            i8 = 1;
            continue;
          }
          c();
          return;
        }
        c();
        return;
        label477: f4 = 0.0F;
      }
      label485: i8 = 0;
      f2 = 0.0F;
    }
  }

  private float b(float paramFloat)
  {
    float f1 = 0.0F;
    float f2 = getScale();
    if (f2 != f1)
      f1 = (getScrollX() + paramFloat) / f2;
    return f1;
  }

  private void b()
  {
    a(false);
  }

  private static final void b(ArrayList<MapEventsListener> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MapEventsListener localMapEventsListener = (MapEventsListener)localIterator.next();
      if (localMapEventsListener != null)
        try
        {
          localMapEventsListener.onPostZoomIn();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          String str = "Exception " + localException + " on didlZoomIn";
          int i1 = Log.e("MAP WIDGET", str);
        }
      else
        int i2 = Log.w("MAP WIDGET", "DidZoomIn: Map Events listener is null");
    }
  }

  private float c(float paramFloat)
  {
    float f1 = 0.0F;
    float f2 = getScale();
    if (f2 != f1)
      f1 = (getScrollY() + paramFloat) / f2;
    return f1;
  }

  private void c()
  {
    this.f.freeResources();
    if (this.G)
      return;
    this.tileProvider.startProcessingCommands();
  }

  private static final void c(ArrayList<MapEventsListener> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MapEventsListener localMapEventsListener = (MapEventsListener)localIterator.next();
      if (localMapEventsListener != null)
        try
        {
          localMapEventsListener.onPreZoomOut();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          String str = "Exception " + localException + " on willZoomOut";
          int i1 = Log.e("MAP WIDGET", str);
        }
      else
        int i2 = Log.w("MAP WIDGET", "WillZoomOut: Map Events listener is null");
    }
  }

  private Animation d()
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    float f3 = 2.0F;
    float f4 = 1.0F;
    ScaleAnimation localScaleAnimation = new ScaleAnimation(2.0F, 1.0F, f3, f4, f1, f2);
    localScaleAnimation.setDuration(500L);
    DecelerateInterpolator localDecelerateInterpolator = this.Q;
    localScaleAnimation.setInterpolator(localDecelerateInterpolator);
    localScaleAnimation.setFillAfter(true);
    return localScaleAnimation;
  }

  private static final void d(ArrayList<MapEventsListener> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MapEventsListener localMapEventsListener = (MapEventsListener)localIterator.next();
      if (localMapEventsListener != null)
        try
        {
          localMapEventsListener.onPostZoomOut();
        }
        catch (Exception localException)
        {
          String str = "Exception " + localException + " on didZoomOut";
          int i1 = Log.e("MAP WIDGET", str);
        }
      else
        int i2 = Log.w("MAP WIDGET", "DidZoomOut: Map Events listener is null");
    }
  }

  private void e()
  {
    ZoomButtonsController localZoomButtonsController1 = new ZoomButtonsController(this);
    this.e = localZoomButtonsController1;
    ZoomButtonsController localZoomButtonsController2 = this.e;
    ZoomButtonsController.OnZoomListener local8 = new ZoomButtonsController.OnZoomListener()
    {
      public void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
      }

      public void onZoom(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
          try
          {
            MapWidget.this.zoomIn();
            return;
          }
          catch (Exception localException1)
          {
            boolean bool1 = MapWidget.c(MapWidget.this, false);
            String str1 = "Exception while zoom in. " + localException1;
            int i = Log.e("MapWidget", str1);
            return;
          }
        try
        {
          MapWidget.this.zoomOut();
          return;
        }
        catch (Exception localException2)
        {
          boolean bool2 = MapWidget.c(MapWidget.this, false);
          String str2 = "Exception while zoom out. " + localException2;
          int j = Log.e("MapWidget", str2);
        }
      }
    };
    localZoomButtonsController2.setOnZoomListener(local8);
  }

  private void f()
  {
    boolean bool = true;
    if (this.d == null)
      return;
    if (this.e == null)
      return;
    if (!this.d.isZoomBtnsVisible())
      return;
    int i1 = getZoomLevel();
    int i2 = this.d.getMinZoomLevelLimit();
    int i3 = this.f.getMinZoomLevel();
    int i4 = Math.max(i2, i3);
    int i5 = this.f.getMaxZoomLevel();
    int i6 = this.d.getMaxZoomLevelLimit();
    if ((i6 != 0) && (this.d.isSoftwareZoomEnabled()));
    for (i5 = i6; i1 != i5; i5 = Math.min(i6, i5))
    {
      label96: this.e.setZoomOutEnabled(true);
      if ((this.d.isSoftwareZoomEnabled()) && (i6 == 0))
        return;
      this.e.setZoomInEnabled(false);
      return;
      if ((i6 == 0) || (this.d.isSoftwareZoomEnabled()))
        break label96;
    }
    if (i1 != i4)
    {
      this.e.setZoomInEnabled(true);
      ZoomButtonsController localZoomButtonsController = this.e;
      if (this.i > 1.0F);
      while (true)
      {
        localZoomButtonsController.setZoomOutEnabled(bool);
        return;
        bool = false;
      }
    }
    this.e.setZoomInEnabled(true);
    this.e.setZoomOutEnabled(true);
  }

  public void addMapEventsListener(MapEventsListener paramMapEventsListener)
  {
    if (this.t == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.t = localArrayList;
    }
    boolean bool = this.t.add(paramMapEventsListener);
  }

  protected void animateZoomIn(Animation.AnimationListener paramAnimationListener, float paramFloat1, float paramFloat2)
  {
    Animation localAnimation = a(paramFloat1, paramFloat2);
    if (paramAnimationListener != null)
      localAnimation.setAnimationListener(paramAnimationListener);
    startAnimation(localAnimation);
  }

  protected void animateZoomOut(Animation.AnimationListener paramAnimationListener)
  {
    Animation localAnimation = null;
    if (localAnimation == null)
      localAnimation = d();
    while (true)
    {
      if (paramAnimationListener != null)
        localAnimation.setAnimationListener(paramAnimationListener);
      startAnimation(localAnimation);
      return;
      null.reset();
    }
  }

  public void centerMap()
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if ((i1 == 0) || (i2 == 0))
    {
      this.P = true;
      return;
    }
    boolean bool = this.l;
    a(true, bool);
    int i3 = getOriginalMapWidth() / 2;
    int i4 = getOriginalMapHeight() / 2;
    jumpTo(i3, i4);
  }

  public void centerMapHorizontally()
  {
    int i1 = this.f.getWidth();
    int i2 = getWidth();
    if (i1 <= i2)
      return;
    int i3 = getWidth();
    int i4 = this.f.getWidth();
    int i5 = -((i3 - i4) / 2);
    scrollBy(i5, 0);
  }

  public void clearLayers()
  {
    if (Looper.myLooper() == null)
      throw new IllegalThreadStateException("Should be called from UI thread");
    int i1 = this.o.size() + -1;
    while (i1 >= 0)
    {
      ((MapLayer)this.o.get(i1)).clearAll();
      i1 += -1;
    }
    this.o.clear();
  }

  public void computeScroll()
  {
    if (this.B.computeScrollOffset())
    {
      int i1 = this.B.getCurrX();
      int i2 = this.B.getCurrY();
      scrollTo(i1, i2);
      invalidate();
    }
    super.computeScroll();
  }

  public MapLayer createLayer(long paramLong)
  {
    Map localMap1 = this.p;
    Long localLong1 = Long.valueOf(paramLong);
    if (localMap1.containsKey(localLong1))
      throw new IllegalArgumentException("Attempt to create layer with duplicated ID");
    try
    {
      localMapLayer = new MapLayer(paramLong, this);
      boolean bool = this.o.add(localMapLayer);
      Map localMap2 = this.p;
      Long localLong2 = Long.valueOf(paramLong);
      Object localObject = localMap2.put(localLong2, localMapLayer);
      return localMapLayer;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str = "Exception: " + localException;
        int i1 = Log.e("MapWidget", str);
        MapLayer localMapLayer = null;
      }
    }
  }

  public OfflineMapConfig getConfig()
  {
    return this.d;
  }

  public GPSConfig getGpsConfig()
  {
    if (this.d != null);
    for (GPSConfig localGPSConfig = this.d.getGpsConfig(); ; localGPSConfig = null)
      return localGPSConfig;
  }

  public Layer getLayer(int paramInt)
  {
    return (Layer)this.o.get(paramInt);
  }

  public Layer getLayerById(long paramLong)
  {
    Map localMap = this.p;
    Long localLong = Long.valueOf(paramLong);
    return (Layer)localMap.get(localLong);
  }

  public int getLayerCount()
  {
    return this.o.size();
  }

  public MapGraphicsConfig getMapGraphicsConfig()
  {
    if (this.d != null);
    for (MapGraphicsConfig localMapGraphicsConfig = this.d.getGraphicsConfig(); ; localMapGraphicsConfig = null)
      return localMapGraphicsConfig;
  }

  public int getMapHeight()
  {
    if (this.f != null);
    for (int i1 = this.f.getHeight(); ; i1 = 0)
      return i1;
  }

  public int getMapWidth()
  {
    if (this.f != null);
    for (int i1 = this.f.getWidth(); ; i1 = 0)
      return i1;
  }

  public int getOriginalMapHeight()
  {
    if (this.f != null);
    for (int i1 = this.f.getOriginalHeight(); ; i1 = 0)
      return i1;
  }

  public int getOriginalMapWidth()
  {
    if (this.f != null);
    for (int i1 = this.f.getOriginalWidth(); ; i1 = 0)
      return i1;
  }

  public float getScale()
  {
    if (this.f != null);
    for (float f1 = (float)this.f.getScale(); ; f1 = 0.0F)
      return f1;
  }

  public int getZoomLevel()
  {
    int i1;
    if (this.f == null)
      i1 = 0;
    while (true)
    {
      return i1;
      double d1 = this.f.getScale();
      i1 = this.f.getZoomLevel();
      if (d1 > 1.0D)
      {
        int i2 = this.f.getWidth();
        int i3 = this.f.getHeight();
        i1 = OfflineMapUtil.getMaxZoomLevel(i2, i3);
      }
    }
  }

  public void jumpTo(int paramInt1, int paramInt2)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    float f1 = paramInt1;
    float f2 = getScale();
    float f3 = f1 * f2;
    float f4 = i1 / 2;
    int i3 = (int)(f3 - f4);
    float f5 = paramInt2;
    float f6 = getScale();
    float f7 = f5 * f6;
    float f8 = i2 / 2;
    int i4 = (int)(f7 - f8);
    scrollTo(i3, i4);
    a(false, false);
  }

  public void jumpTo(Point paramPoint)
  {
    int i1 = paramPoint.x;
    int i2 = paramPoint.y;
    jumpTo(i1, i2);
    a(false, false);
  }

  public void jumpTo(Location paramLocation)
  {
    if (this.d == null)
    {
      int i1 = Log.w("MAP WIDGET", "Jump to skipped. Map is not initialized properly.");
      return;
    }
    if (!this.d.getGpsConfig().isMapCalibrated())
      throw new IllegalStateException("Map is not calibrated.");
    Point localPoint1 = new Point();
    Point localPoint2 = getGpsConfig().getCalibration().translate(paramLocation, localPoint1);
    float f1 = localPoint1.x;
    float f2 = getScale();
    int i2 = (int)(f1 * f2);
    float f3 = localPoint1.y;
    float f4 = getScale();
    int i3 = (int)(f3 * f4);
    localPoint1.set(i2, i3);
    jumpTo(localPoint1);
  }

  public void jumpToCurrentLocation()
  {
    if (!this.n.isVisible())
    {
      int i1 = Log.i("MAP WIDGET", "Location marker is not visible. Jump to current location skipped");
      return;
    }
    MapLayer localMapLayer = this.n;
    Long localLong = Long.valueOf(1L);
    Point localPoint = ((PositionMarker)localMapLayer.getMapObject(localLong)).getPosition();
    jumpTo(localPoint);
  }

  protected void onAnimationEnd()
  {
    super.onAnimationEnd();
    Animation localAnimation = getAnimation();
    if (localAnimation == null)
      int i1 = Log.w("MAP WIDGET", "Unknown animation has been finished.");
    if (((localAnimation instanceof ScaleAnimation)) && (this.N != null))
    {
      this.N.run();
      this.N = null;
    }
    if (!(localAnimation instanceof TranslateAnimation))
      return;
    if (this.O == null)
      return;
    this.O.run();
    this.O = null;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.tileProvider != null)
    {
      this.tileProvider.startProcessingCommands();
      return;
    }
    int i1 = Log.e("MAP WIDGET", "Tile manager is not initialized");
  }

  public void onChangePinVisibility(boolean paramBoolean)
  {
    this.n.setVisible(paramBoolean);
  }

  protected void onDetachedFromWindow()
  {
    if (this.e != null)
      this.e.setVisible(false);
    if (this.tileProvider != null)
      this.tileProvider.stopProcessingCommands();
    if (this.locationProvider != null)
      this.locationProvider.stop();
    super.onDetachedFromWindow();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    Rect localRect1 = this.L;
    getDrawingRect(localRect1);
    if (this.d != null)
    {
      if (this.g != null)
      {
        Grid localGrid1 = this.g;
        Paint localPaint1 = this.h;
        Rect localRect2 = this.L;
        localGrid1.draw(paramCanvas, localPaint1, localRect2);
      }
      if (this.f != null)
      {
        Grid localGrid2 = this.f;
        Paint localPaint2 = this.h;
        Rect localRect3 = this.L;
        localGrid2.draw(paramCanvas, localPaint2, localRect3);
      }
      Rect localRect4 = this.L;
      a(paramCanvas, localRect4);
      if (K == null)
        return;
      Bitmap localBitmap = K;
      int i1 = getWidth();
      int i2 = getScrollX();
      int i3 = i1 + i2;
      int i4 = K.getWidth();
      float f1 = i3 - i4 + -10;
      int i5 = getHeight();
      int i6 = getScrollY();
      int i7 = i5 + i6;
      int i8 = K.getHeight();
      float f2 = i7 - i8 + -10;
      paramCanvas.drawBitmap(localBitmap, f1, f2, null);
      return;
    }
    scrollTo(0, 0);
    a(paramCanvas);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.d == null);
    while (true)
    {
      return bool;
      switch (paramKeyEvent.getKeyCode())
      {
      default:
        break;
      case 19:
        int i1 = -this.d.getTrackballScrollStepY();
        scrollBy(0, i1);
        bool = true;
        break;
      case 21:
        int i2 = -this.d.getTrackballScrollStepX();
        scrollBy(i2, 0);
        bool = true;
        break;
      case 22:
        int i3 = this.d.getTrackballScrollStepX();
        scrollBy(i3, 0);
        bool = true;
        break;
      case 20:
        int i4 = this.d.getTrackballScrollStepY();
        scrollBy(0, i4);
        bool = true;
        break;
      case 37:
        zoomIn();
        bool = true;
        break;
      case 43:
        zoomOut();
        bool = true;
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.P)
    {
      this.P = false;
      final ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (!localViewTreeObserver.isAlive())
        return;
      ViewTreeObserver.OnGlobalLayoutListener local5 = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          MapWidget.a(MapWidget.this, true, false);
          MapWidget localMapWidget = MapWidget.this;
          int i = MapWidget.this.getOriginalMapWidth() / 2;
          int j = MapWidget.this.getOriginalMapHeight() / 2;
          localMapWidget.jumpTo(i, j);
          localViewTreeObserver.removeGlobalOnLayoutListener(this);
        }
      };
      localViewTreeObserver.addOnGlobalLayoutListener(local5);
      return;
    }
    a(false, false);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }

  public void onMovePinTo(Location paramLocation)
  {
    MapLayer localMapLayer = this.n;
    Long localLong = Long.valueOf(1L);
    PositionMarker localPositionMarker = (PositionMarker)localMapLayer.getMapObject(localLong);
    if (localPositionMarker != null)
    {
      float f1 = paramLocation.getAccuracy();
      localPositionMarker.setAccuracy(f1);
      float f2 = paramLocation.getBearing();
      localPositionMarker.setBearing(f2);
      boolean bool = paramLocation.hasBearing();
      localPositionMarker.setBearingEnabled(bool);
      localPositionMarker.moveTo(paramLocation);
    }
    a(paramLocation);
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.s == null)
      return;
    MapScrolledEvent localMapScrolledEvent1 = a;
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    boolean bool = this.m;
    localMapScrolledEvent1.setData(i1, i2, bool);
    OnMapScrollListener localOnMapScrollListener = this.s;
    MapScrolledEvent localMapScrolledEvent2 = a;
    localOnMapScrollListener.onScrolledEvent(this, localMapScrolledEvent2);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 == 0) && (paramInt2 == 0))
      return;
    if (this.M == null)
      return;
    this.M.run();
    this.M = null;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = null;
    int i4 = 1;
    if (this.d == null);
    while (true)
    {
      return bool1;
      if (!this.F)
        break;
      int i5 = Log.w("MapWidget", "Map is destroying... OnTouch skipped");
    }
    if (this.y != null);
    boolean bool4 = super.onTouchEvent(paramMotionEvent);
    boolean bool5 = this.A.onTouchEvent(paramMotionEvent);
    int i6 = paramMotionEvent.getAction() & 0xFF;
    if (i6 == 0)
    {
      this.m = true;
      this.G = true;
    }
    while (true)
    {
      try
      {
        if (this.d.isZoomBtnsVisible())
          this.e.setVisible(true);
        int i1 = this.tileProvider;
        i1.pauseProcessingCommands();
        int i7 = i4;
      }
      catch (Exception localException)
      {
        String str = "Exception e: " + localException;
        int i8 = Log.w("MapWidget", str);
        continue;
      }
      if (i6 == 5)
      {
        if (this.d.isPinchZoomEnabled())
        {
          a locala2 = a.c;
          this.z = locala2;
          this.k = false;
          float f1 = paramMotionEvent.getX(0);
          float f2 = paramMotionEvent.getY(0);
          float f3 = paramMotionEvent.getX(1);
          float f4 = paramMotionEvent.getY(1);
          double d2 = MathUtils.distance(f1, f2, f3, f4);
          this.H = d2;
          PointF localPointF = MathUtils.middle(f1, f2, f3, f4);
          int i9 = (int)localPointF.x;
          this.I = i9;
          int i2 = (int)localPointF.y;
          this.J = i2;
        }
      }
      else
      {
        a locala1;
        if (i6 == 2)
        {
          if ((this.e != null) && (this.d.isZoomBtnsVisible()) && (!this.e.isVisible()))
            this.e.setVisible(true);
          a locala3 = this.z;
          a locala4 = a.c;
          if (locala3 == locala4)
          {
            float f5 = paramMotionEvent.getX(0);
            float f6 = paramMotionEvent.getY(0);
            float f7 = paramMotionEvent.getX(1);
            float f8 = paramMotionEvent.getY(1);
            double d1 = MathUtils.distance(f5, f6, f7, f8);
            if (this.H != 0.0D)
            {
              double d3 = this.H;
              double d4 = d1 / d3;
              this.j = d4;
              if (this.j >= 1.025D)
              {
                a locala5 = a.b;
                this.z = locala5;
                int i3 = this.I;
                int i10 = this.J;
                zoomIn(i3, i10);
              }
              else
              {
                boolean bool2 = this.j < 0.975D;
                if (!bool2)
                {
                  locala1 = a.b;
                  this.z = locala1;
                  zoomOut();
                }
              }
            }
          }
        }
        else if (i6 == 6)
        {
          locala1 = a.a;
          this.z = locala1;
        }
        else if (i6 == 1)
        {
          this.m = false;
          this.G = false;
          boolean bool3 = this.E;
          if (!bool3)
            b();
        }
        else
        {
          i4 = 0;
        }
      }
    }
  }

  public void removeAllLayers()
  {
    this.o.clear();
    this.p.clear();
  }

  public void removeAllMapEventsListeners()
  {
    if (this.t != null)
      this.t.clear();
    ArrayList localArrayList = new ArrayList();
    this.t = localArrayList;
  }

  public void removeLayer(long paramLong)
  {
    Map localMap = this.p;
    Long localLong = Long.valueOf(paramLong);
    Layer localLayer = (Layer)localMap.remove(localLong);
    boolean bool = this.o.remove(localLayer);
  }

  public void removeMapEventsListener(MapEventsListener paramMapEventsListener)
  {
    if (this.t == null)
      return;
    boolean bool = this.t.remove(paramMapEventsListener);
  }

  public void saveState(Bundle paramBundle)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = b(f1);
    float f3 = getHeight() / 2.0F;
    float f4 = c(f3);
    paramBundle.putFloat("com.ls.curPosOnMapX", f2);
    paramBundle.putFloat("com.ls.curPosOnMapY", f4);
    if (this.f != null)
    {
      int i1 = this.f.getZoomLevel();
      paramBundle.putInt("com.ls.zoomLevel", i1);
    }
    float f5 = this.i;
    paramBundle.putFloat("com.ls.scale", f5);
    String str = "Saved point pos: [" + f2 + ", " + f4 + " ]";
    int i2 = Log.d("MapWidget", str);
  }

  public void scrollMapTo(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (!this.l)
    {
      jumpTo(paramInt1, paramInt2);
      return;
    }
    int i2 = getWidth();
    int i3 = getHeight();
    if (isLayoutRequested())
      return;
    int i4 = getMapHeight();
    int i5 = getMapWidth();
    float f1 = getScale();
    int i6 = getScrollX();
    int i7 = getScrollY();
    int i8 = (int)(paramInt1 * f1);
    int i9 = i2 / 2;
    int i10 = i8 - i9;
    float f2 = paramInt2;
    int i11 = (int)(f1 * f2);
    int i12 = i3 / 2;
    int i13 = i11 - i12;
    if ((i3 < i4) && (i13 + i3 > i4))
    {
      int i14 = i13 + i3 - i4;
      i13 -= i14;
    }
    if ((i5 > i2) && (i10 + i2 > i5))
    {
      int i15 = i10 + i2 - i5;
      i10 -= i15;
    }
    if (i10 < 0)
      i10 = 0;
    if (i13 < 0);
    while (true)
    {
      if (i3 > i4);
      for (int i16 = i7; ; i16 = i1)
      {
        if (i2 > i5);
        for (int i17 = i6; ; i17 = i10)
        {
          this.B.abortAnimation();
          Scroller localScroller = this.B;
          int i18 = i17 - i6;
          int i19 = i16 - i7;
          localScroller.startScroll(i6, i7, i18, i19, 500);
          invalidate();
          return;
        }
      }
      i1 = i13;
    }
  }

  public void scrollMapTo(Point paramPoint)
  {
    int i1 = paramPoint.x;
    int i2 = paramPoint.y;
    scrollMapTo(i1, i2);
  }

  public void scrollMapTo(Location paramLocation)
  {
    if (this.d == null)
    {
      int i1 = Log.w("MAP WIDGET", "Jump to skipped. Map is not initialized properly.");
      return;
    }
    if (!this.d.getGpsConfig().isMapCalibrated())
      throw new IllegalStateException("Map is not calibrated.");
    Point localPoint1 = new Point();
    Point localPoint2 = getGpsConfig().getCalibration().translate(paramLocation, localPoint1);
    int i2 = localPoint1.x;
    int i3 = localPoint1.y;
    scrollMapTo(i2, i3);
  }

  public void scrollToCurrentLocation()
  {
    if (!this.n.isVisible())
    {
      int i1 = Log.i("MAP WIDGET", "Location pin is not visible. Scroll to current location skipped");
      return;
    }
    MapLayer localMapLayer = this.n;
    Long localLong = Long.valueOf(1L);
    Point localPoint = ((PositionMarker)localMapLayer.getMapObject(localLong)).getPosition();
    scrollMapTo(localPoint);
  }

  public void setAnimationEnabled(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public void setMaxZoomLevel(int paramInt)
  {
    if (this.d == null)
    {
      int i1 = Log.w("MAP WIDGET", "setMaxZoomLevel skipped. MapWidget was not initialized properly");
      return;
    }
    if (this.f == null)
      throw new IllegalStateException();
    int i2 = this.f.getMaxZoomLevel();
    int i3 = this.f.getMinZoomLevel();
    if ((!this.d.isSoftwareZoomEnabled()) && (paramInt > i2))
    {
      String str1 = "There is no " + paramInt + " zoom level. Will use " + i2 + " as max zoom level.";
      int i4 = Log.w("MAP WIDGET", str1);
      this.d.setMaxZoomLevelLimit(i2);
    }
    while (true)
    {
      f();
      return;
      if (paramInt < i3)
      {
        String str2 = "Max zoom level should be greater than min zoom level. Min zoom level: " + i3 + " Max zoom level: " + i2 + ", " + " you are setting: " + paramInt + " as max zoom level.";
        int i5 = Log.w("MAP WIDGET", str2);
        int i6 = Log.w("MAP WIDGET", "Will use min zoom level as max zoom level.");
        this.d.setMaxZoomLevelLimit(i3);
      }
      else
      {
        this.d.setMaxZoomLevelLimit(paramInt);
      }
    }
  }

  public void setMinZoomLevel(int paramInt)
  {
    if (this.d == null)
    {
      int i1 = Log.w("MAP WIDGET", "setMinZoomLevel skipped. MapWidget is not initialized properly");
      return;
    }
    int i2 = this.f.getMaxZoomLevel();
    int i3 = this.f.getMinZoomLevel();
    if (paramInt < i3)
    {
      String str1 = "There is no " + paramInt + " zoom level. Will use " + i3 + " as min zoom level.";
      int i4 = Log.w("MAP WIDGET", str1);
      this.d.setMinZoomLevelLimit(paramInt);
    }
    while (true)
    {
      f();
      return;
      if (paramInt > i2)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Min zoom level should be less than max zoom level. Min zoom level: ").append(i3).append(" Max zoom level: ").append(i2).append(", ").append(" You are setting: ");
        int i5 = this.d.getMaxZoomLevelLimit();
        String str2 = i5 + " as min zoom level.";
        int i6 = Log.w("MAP WIDGET", str2);
        int i7 = Log.w("MAP WIDGET", "Will use max zoom level as min zoom level.");
        this.d.setMinZoomLevelLimit(i2);
      }
      else
      {
        this.d.setMinZoomLevelLimit(paramInt);
      }
    }
  }

  public void setOnDoubleTapListener(OnMapDoubleTapListener paramOnMapDoubleTapListener)
  {
    this.x = paramOnMapDoubleTapListener;
  }

  public void setOnLocationChangedListener(OnLocationChangedListener paramOnLocationChangedListener)
  {
    this.u = paramOnLocationChangedListener;
  }

  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.v = paramOnLongClickListener;
  }

  public void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.w = paramOnMapLongClickListener;
  }

  public void setOnMapScrolledListener(OnMapScrollListener paramOnMapScrollListener)
  {
    this.s = paramOnMapScrollListener;
  }

  public void setOnMapTilesFinishLoadingListener(OnMapTilesFinishedLoadingListener paramOnMapTilesFinishedLoadingListener)
  {
    this.r = paramOnMapTilesFinishedLoadingListener;
    if (this.f == null)
      return;
    Grid localGrid = this.f;
    OnGridReadyListener local2 = new OnGridReadyListener()
    {
      public void onReady()
      {
        if (MapWidget.a(MapWidget.this) == null)
          return;
        MapWidget.a(MapWidget.this).onMapTilesFinishedLoading();
      }
    };
    localGrid.setOnReadyListener(local2);
  }

  public void setOnMapTouchListener(OnMapTouchListener paramOnMapTouchListener)
  {
    this.q = paramOnMapTouchListener;
  }

  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    super.setOnTouchListener(paramOnTouchListener);
  }

  public void setScale(float paramFloat)
  {
    if (Looper.myLooper() == null)
      throw new IllegalThreadStateException("Should be called from UI thread");
    if (this.f == null)
      return;
    this.f.setSoftScale(paramFloat);
    float f1 = getScale();
    a(f1);
    invalidate();
  }

  public void setShowMyPosition(boolean paramBoolean)
  {
    GPSConfig localGPSConfig = getConfig().getGpsConfig();
    if (!localGPSConfig.isMapCalibrated())
      throw new IllegalStateException("Map is not calibrated in order to use gps positioning");
    if (paramBoolean)
    {
      MapGraphicsConfig localMapGraphicsConfig = getConfig().getGraphicsConfig();
      MapLayer localMapLayer = this.n;
      Long localLong = Long.valueOf(1L);
      PositionMarker localPositionMarker = (PositionMarker)localMapLayer.getMapObject(localLong);
      if (localMapGraphicsConfig.getDotPointerDrawableId() != -1)
      {
        android.content.res.Resources localResources1 = getResources();
        int i1 = localMapGraphicsConfig.getDotPointerDrawableId();
        Drawable localDrawable1 = localResources1.getDrawable(i1);
        PivotFactory.PivotPosition localPivotPosition1 = PivotFactory.PivotPosition.PIVOT_CENTER;
        Point localPoint1 = PivotFactory.createPivotPoint(localDrawable1, localPivotPosition1);
        localPositionMarker.setDotPointer(localDrawable1, localPoint1);
      }
      if (localMapGraphicsConfig.getArrowPointerDrawableId() != -1)
      {
        android.content.res.Resources localResources2 = getResources();
        int i2 = localMapGraphicsConfig.getArrowPointerDrawableId();
        Drawable localDrawable2 = localResources2.getDrawable(i2);
        PivotFactory.PivotPosition localPivotPosition2 = PivotFactory.PivotPosition.PIVOT_CENTER;
        Point localPoint2 = PivotFactory.createPivotPoint(localDrawable2, localPivotPosition2);
        localPositionMarker.setArrowPointer(localDrawable2, localPoint2);
      }
      int i3 = localMapGraphicsConfig.getAccuracyAreaColor();
      int i4 = localMapGraphicsConfig.getAccuracyAreaBorderColor();
      localPositionMarker.setColor(i3, i4);
      if (this.locationProvider == null)
      {
        Context localContext = getContext();
        GPSLocationProvider localGPSLocationProvider1 = new GPSLocationProvider(localContext);
        this.locationProvider = localGPSLocationProvider1;
        GPSLocationProvider localGPSLocationProvider2 = this.locationProvider;
        int i5 = localGPSConfig.getMinTime();
        localGPSLocationProvider2.setMinRefreshTime(i5);
        GPSLocationProvider localGPSLocationProvider3 = this.locationProvider;
        int i6 = localGPSConfig.getMinDistance();
        localGPSLocationProvider3.setMinRefreshDistance(i6);
        this.locationProvider.setMapLocationListener(this);
      }
      GPSLocationProvider localGPSLocationProvider4 = this.locationProvider;
      boolean bool = localGPSConfig.getPassiveMode();
      localGPSLocationProvider4.start(bool);
      return;
    }
    if (this.locationProvider == null)
      return;
    this.locationProvider.stop();
  }

  protected void setTileProvider(TileProvider paramTileProvider)
  {
    if (this.f == null)
      return;
    this.f.setTileProvider(paramTileProvider);
  }

  public void setTouchAreaSize(int paramInt)
  {
    if (this.d == null)
      return;
    this.d.setTouchAreaSize(paramInt);
  }

  public void setUseSoftwareZoom(boolean paramBoolean)
  {
    if (this.d == null)
      return;
    this.d.setSoftwareZoomEnabled(paramBoolean);
  }

  public void setZoomButtonsVisible(boolean paramBoolean)
  {
    if (this.d != null)
    {
      this.d.setZoomBtnsVisible(paramBoolean);
      if (paramBoolean)
      {
        if (this.e != null)
          return;
        e();
        return;
      }
      if (this.e == null)
        return;
      this.e.setVisible(false);
      this.e.setOnZoomListener(null);
      this.e = null;
      return;
    }
    int i1 = Log.w("MAP WIDGET", "Ignored. Map is not initialized properly.");
  }

  protected void startProcessingRequests()
  {
    this.F = false;
    if (this.G)
      return;
    this.tileProvider.startProcessingCommands();
  }

  public void zoomIn()
  {
    int i1 = getWidth() / 2;
    int i2 = getHeight() / 2;
    zoomIn(i1, i2);
  }

  public void zoomIn(final int paramInt1, final int paramInt2)
  {
    if (this.k)
    {
      int i1 = Log.d("MAP WIDGET", "Zoom is in progress. Skipped...");
      return;
    }
    if (this.d == null)
    {
      int i2 = Log.w("MAP WIDGET", "Zoom in skipped. Map was not initialized properly");
      return;
    }
    if (!this.d.isSoftwareZoomEnabled())
    {
      int i3 = getZoomLevel();
      int i4 = this.f.getMaxZoomLevel();
      if (i3 != i4)
        return;
    }
    if ((this.d.isSoftwareZoomEnabled()) && (this.d.getMaxZoomLevelLimit() != 0))
    {
      int i5 = getZoomLevel();
      int i6 = this.d.getMaxZoomLevelLimit();
      if (i5 >= i6)
        return;
    }
    if (Looper.myLooper() == null)
      throw new IllegalThreadStateException("Should be called from UI thread");
    a(this.t);
    this.E = true;
    this.k = true;
    if (!this.l)
    {
      int i7 = getZoomLevel() + 1;
      a(i7, paramInt1, paramInt2);
      this.E = false;
      b();
      return;
    }
    Runnable local3 = new Runnable()
    {
      public void run()
      {
        MapWidget localMapWidget = MapWidget.this;
        int i = MapWidget.this.getZoomLevel() + 1;
        int j = paramInt1;
        int k = paramInt2;
        MapWidget.a(localMapWidget, i, j, k);
        boolean bool = MapWidget.a(MapWidget.this, false);
        MapWidget.b(MapWidget.this, true);
      }
    };
    this.N = local3;
    float f1 = paramInt1;
    float f2 = paramInt2;
    animateZoomIn(null, f1, f2);
  }

  public void zoomOut()
  {
    if (this.k)
    {
      int i1 = Log.d("MAP WIDGET", "Zoom is in progress. Skipped...");
      return;
    }
    if (this.d == null)
    {
      int i2 = Log.w("MAP WIDGET", "Zoom in skipped. Map was not initialized properly");
      return;
    }
    int i3 = getZoomLevel();
    if (i3 == 0)
      return;
    int i4 = this.d.getMinZoomLevelLimit();
    if (i3 <= i4)
      return;
    this.k = true;
    if (this.f == null)
    {
      int i5 = Log.w("MAP WIDGET", "zoomOut() grid is null");
      this.k = false;
      return;
    }
    if (Looper.myLooper() == null)
      throw new IllegalThreadStateException("Should be called from UI thread");
    int i6 = getWidth() / 2;
    int i7 = getHeight() / 2;
    c(this.t);
    int i8 = i3 + -1;
    a(i8, i6, i7);
    if (!this.l)
    {
      this.k = false;
      this.E = false;
      b();
      return;
    }
    this.E = true;
    Runnable local4 = new Runnable()
    {
      public void run()
      {
        boolean bool = MapWidget.a(MapWidget.this, false);
        MapWidget.b(MapWidget.this, true);
      }
    };
    this.N = local4;
    animateZoomOut(null);
  }

  private class b extends GestureDetector.SimpleOnGestureListener
  {
    private b()
    {
    }

    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      boolean bool = false;
      if (MapWidget.d(MapWidget.this) != null)
      {
        MapWidget.a(MapWidget.this, paramMotionEvent);
        OnMapDoubleTapListener localOnMapDoubleTapListener = MapWidget.d(MapWidget.this);
        MapWidget localMapWidget1 = MapWidget.this;
        MapTouchedEvent localMapTouchedEvent = MapWidget.c;
        bool = localOnMapDoubleTapListener.onDoubleTap(localMapWidget1, localMapTouchedEvent);
      }
      if (!bool)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        MapWidget localMapWidget2 = MapWidget.this;
        int i = (int)f1;
        int j = (int)f2;
        localMapWidget2.zoomIn(i, j);
        bool = true;
      }
      return bool;
    }

    public boolean onDown(MotionEvent paramMotionEvent)
    {
      if (!MapWidget.g(MapWidget.this).isFinished())
        MapWidget.g(MapWidget.this).forceFinished(true);
      return true;
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 0;
      if (MapWidget.e(MapWidget.this) == null)
        k = Log.w("MAP WIDGET", "Jump to skipped. Map is not initialized properly.");
      while ((!MapWidget.e(MapWidget.this).isFlingEnabled()) || (MapWidget.f(MapWidget.this)))
      {
        int k;
        return i;
      }
      int m = 800;
      float f1 = Math.abs(paramFloat1);
      float f2 = m;
      label83: label116: int i2;
      int i5;
      int i8;
      int i11;
      if (f1 > f2)
      {
        if (paramFloat1 > 0.0F)
          paramFloat1 = m;
      }
      else
      {
        float f3 = Math.abs(paramFloat2);
        float f4 = m;
        if (f3 > f4)
        {
          if (paramFloat2 <= 0.0F)
            break label348;
          paramFloat2 = m;
        }
        if (!MapWidget.e(MapWidget.this).isMapCenteringEnabled())
          break label357;
        int n = MapWidget.this.getWidth();
        int i1 = MapWidget.this.getMapWidth();
        i2 = (n - i1) / 2;
        int i3 = MapWidget.this.getHeight();
        int i4 = MapWidget.this.getMapHeight();
        i5 = (i3 - i4) / 2;
        int i6 = MapWidget.this.getMapWidth();
        int i7 = MapWidget.this.getWidth();
        i8 = i6 - i7;
        int i9 = MapWidget.this.getMapHeight();
        int i10 = MapWidget.this.getHeight();
        i11 = i9 - i10;
        if (i2 < 0)
          i2 = 0;
        if (i5 >= 0)
          break label529;
      }
      while (true)
      {
        int i12 = i2 * -1;
        int i13 = i * -1;
        int i14 = i11;
        int i15 = i13;
        while (true)
        {
          Scroller localScroller = MapWidget.g(MapWidget.this);
          int i16 = MapWidget.this.getScrollX();
          int i17 = MapWidget.this.getScrollY();
          int i18 = -(int)paramFloat1;
          int i19 = -(int)paramFloat2;
          localScroller.fling(i16, i17, i18, i19, i12, i8, i15, i14);
          MapWidget.this.invalidate();
          j = 1;
          break;
          paramFloat1 = -m;
          break label83;
          label348: paramFloat2 = -m;
          break label116;
          label357: j = -MapWidget.this.getMapWidth();
          int i20 = -MapWidget.this.getMapHeight();
          i8 = MapWidget.this.getMapWidth();
          i11 = MapWidget.this.getMapHeight();
          int i21 = -MapWidget.this.getWidth();
          if (j > i21)
            int i22 = -MapWidget.this.getWidth();
          int i23 = -MapWidget.this.getHeight();
          if (i20 > i23)
            int i24 = -MapWidget.this.getHeight();
          int i25 = MapWidget.this.getHeight();
          if (i11 < i25)
            int i26 = MapWidget.this.getHeight();
          int i27 = MapWidget.this.getWidth();
          if (i8 < i27)
          {
            i8 = MapWidget.this.getWidth();
            i14 = i11;
            i15 = i20;
            i12 = j;
          }
          else
          {
            i14 = i11;
            i15 = i20;
            i12 = j;
          }
        }
        label529: int j = i5;
      }
    }

    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (MapWidget.k(MapWidget.this) != null)
      {
        View.OnLongClickListener localOnLongClickListener = MapWidget.k(MapWidget.this);
        MapWidget localMapWidget1 = MapWidget.this;
        boolean bool1 = localOnLongClickListener.onLongClick(localMapWidget1);
      }
      if (MapWidget.l(MapWidget.this) == null)
        return;
      MapWidget.a(MapWidget.this, paramMotionEvent);
      OnMapLongClickListener localOnMapLongClickListener = MapWidget.l(MapWidget.this);
      MapWidget localMapWidget2 = MapWidget.this;
      MapTouchedEvent localMapTouchedEvent = MapWidget.c;
      boolean bool2 = localOnMapLongClickListener.onLongClick(localMapWidget2, localMapTouchedEvent);
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      MapWidget.a locala1 = MapWidget.h(MapWidget.this);
      MapWidget.a locala2 = MapWidget.a.a;
      if ((locala1 != locala2) || (MapWidget.f(MapWidget.this)));
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        MapWidget localMapWidget = MapWidget.this;
        int i = (int)paramFloat1;
        int j = (int)paramFloat2;
        localMapWidget.scrollBy(i, j);
      }
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (MapWidget.i(MapWidget.this) != null)
      {
        MapWidget.a(MapWidget.this, paramMotionEvent);
        if (MapWidget.j(MapWidget.this))
        {
          MapWidget localMapWidget1 = MapWidget.this;
          MapWidget localMapWidget2 = MapWidget.this;
          float f1 = paramMotionEvent.getX();
          float f2 = MapWidget.a(localMapWidget2, f1);
          MapWidget localMapWidget3 = MapWidget.this;
          float f3 = paramMotionEvent.getY();
          float f4 = MapWidget.b(localMapWidget3, f3);
          MapWidget localMapWidget4 = MapWidget.this;
          float f5 = paramMotionEvent.getX();
          float f6 = MapWidget.a(localMapWidget4, f5) + 10.0F;
          MapWidget localMapWidget5 = MapWidget.this;
          float f7 = paramMotionEvent.getY() + 10.0F;
          float f8 = MapWidget.b(localMapWidget5, f7);
          RectF localRectF1 = new RectF(f2, f4, f6, f8);
          RectF localRectF2 = MapWidget.a(localMapWidget1, localRectF1);
        }
        OnMapTouchListener localOnMapTouchListener = MapWidget.i(MapWidget.this);
        MapWidget localMapWidget6 = MapWidget.this;
        MapTouchedEvent localMapTouchedEvent = MapWidget.c;
        localOnMapTouchListener.onTouch(localMapWidget6, localMapTouchedEvent);
      }
      return false;
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      a locala1 = a;
      arrayOfa[0] = locala1;
      a locala2 = b;
      arrayOfa[1] = locala2;
      a locala3 = c;
      arrayOfa[2] = locala3;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.MapWidget
 * JD-Core Version:    0.6.2
 */