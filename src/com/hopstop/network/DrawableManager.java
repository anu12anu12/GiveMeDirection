package com.hopstop.network;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.hopstop.ClientView.DirectionsResultActivity;
import com.hopstop.ClientView.MoreMyTripsDirectionActivity;
import com.hopstop.core.ApplicationEngine;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class DrawableManager
{
  private static DrawableManager dManager = null;
  private final Map<String, Drawable> drawableMap;
  Handler handler;

  private DrawableManager()
  {
    HashMap localHashMap = new HashMap();
    this.drawableMap = localHashMap;
  }

  private InputStream fetch(String paramString)
    throws MalformedURLException, IOException
  {
    Object localObject = null;
    try
    {
      HttpGet localHttpGet = new HttpGet(paramString);
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      int i = NetworkSettings.NETWORK_CONNECTION_TIMEOUT;
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
      int j = NetworkSettings.NETWORK_SOCKET_TIMEOUT;
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, j);
      long l = NetworkSettings.NETWORK_CONNECTION_TIMEOUT;
      ConnManagerParams.setTimeout(localBasicHttpParams, l);
      InputStream localInputStream = new DefaultHttpClient(localBasicHttpParams).execute(localHttpGet).getEntity().getContent();
      localObject = localInputStream;
      label85: return localObject;
    }
    catch (Exception localException)
    {
      break label85;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label85;
    }
  }

  public static DrawableManager getDrawableManager()
  {
    if (dManager == null)
      dManager = new DrawableManager();
    return dManager;
  }

  private static boolean isDeviceWidthBiggerThanMapWidth(int paramInt)
  {
    if (ApplicationEngine.DEVICE_DENSITY != 1.0F)
    {
      int i = ApplicationEngine.MAX_MAP_WIDTH_AVAIALBLE;
      if ((paramInt == i) || (ApplicationEngine.DISPLAY_WIDTH <= paramInt));
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static Bitmap resizeDrawable(Drawable paramDrawable)
  {
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    if (paramDrawable != null)
    {
      localBitmap1 = ((BitmapDrawable)paramDrawable).getBitmap();
      if (isDeviceWidthBiggerThanMapWidth(localBitmap1.getWidth()))
      {
        int i = localBitmap1.getWidth();
        int j = localBitmap1.getHeight();
        Matrix localMatrix = new Matrix();
        int k = ApplicationEngine.DISPLAY_WIDTH;
        int m = ApplicationEngine.DISPLAY_WIDTH;
        float f1 = k;
        float f2 = i;
        float f3 = f1 / f2;
        float f4 = m;
        float f5 = j;
        float f6 = f4 / f5;
        boolean bool = localMatrix.postScale(f3, f6);
        int n = 0;
        localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, n, i, j, localMatrix, true);
      }
    }
    while (true)
    {
      return localBitmap2;
      localBitmap2 = localBitmap1;
      continue;
      localBitmap2 = null;
    }
  }

  public void clearHashMap()
  {
    if (this.drawableMap == null)
      return;
    try
    {
      this.drawableMap.clear();
      System.gc();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public Drawable fetchDrawable(String paramString)
    throws OutOfMemoryError, IOException
  {
    Object localObject1;
    if (paramString == null)
      localObject1 = null;
    while (true)
    {
      return localObject1;
      if (this.drawableMap.containsKey(paramString))
      {
        localObject1 = (Drawable)this.drawableMap.get(paramString);
        if ((localObject1 != null) && (!((BitmapDrawable)localObject1).getBitmap().isRecycled()));
      }
      else
      {
        Drawable localDrawable = Drawable.createFromStream(fetch(paramString), "src");
        if (localDrawable == null)
        {
          localObject1 = null;
        }
        else
        {
          Object localObject2 = this.drawableMap.put(paramString, localDrawable);
          localObject1 = localDrawable;
        }
      }
    }
  }

  public void fetchDrawableOnThread(final String paramString, ImageView paramImageView)
  {
    if ((this.drawableMap.containsKey(paramString)) && (paramImageView != null))
    {
      Drawable localDrawable = (Drawable)this.drawableMap.get(paramString);
      if ((localDrawable != null) && (!((BitmapDrawable)localDrawable).getBitmap().isRecycled()))
      {
        paramImageView.setImageDrawable(localDrawable);
        return;
      }
    }
    new Thread()
    {
      public void run()
      {
        Looper.prepare();
        DrawableManager localDrawableManager1 = DrawableManager.this;
        Handler local1 = new Handler()
        {
          public void handleMessage(Message paramAnonymous2Message)
          {
          }
        };
        localDrawableManager1.handler = local1;
        Object localObject = null;
        try
        {
          DrawableManager localDrawableManager2 = DrawableManager.this;
          String str = paramString;
          Drawable localDrawable = localDrawableManager2.fetchDrawable(str);
          localObject = localDrawable;
          Message localMessage1 = DrawableManager.this.handler.obtainMessage(1, localObject);
          Message localMessage2 = DrawableManager.this.handler.obtainMessage(2, localObject);
          boolean bool = DrawableManager.this.handler.sendMessage(localMessage2);
          Looper.loop();
          return;
        }
        catch (Exception localException)
        {
          while (true)
            localException.printStackTrace();
        }
      }
    }
    .start();
  }

  public void fetchImageViewOnThread(final String paramString, final ImageView paramImageView)
  {
    if (this.drawableMap.containsKey(paramString))
    {
      Drawable localDrawable = (Drawable)this.drawableMap.get(paramString);
      if ((localDrawable != null) && (!((BitmapDrawable)localDrawable).getBitmap().isRecycled()))
      {
        paramImageView.setImageDrawable(localDrawable);
        return;
      }
    }
    new Thread()
    {
      public void run()
      {
        Looper.prepare();
        final ImageView localImageView = paramImageView;
        final String str1 = paramString;
        Handler local1 = new Handler()
        {
          public void handleMessage(Message paramAnonymous2Message)
          {
            if (paramAnonymous2Message.obj == null)
              Looper.myLooper().quit();
            Drawable localDrawable1 = localImageView.getDrawable();
            if (localDrawable1 != null)
            {
              localDrawable1.setCallback(null);
              Map localMap = DrawableManager.this.drawableMap;
              String str = str1;
              Object localObject = localMap.put(str, localDrawable1);
            }
            Bitmap localBitmap;
            if ((localImageView.getRootView().getContext() instanceof DirectionsResultActivity))
            {
              if (paramAnonymous2Message.obj == null)
                return;
              if (!(paramAnonymous2Message.obj instanceof Bitmap))
              {
                localBitmap = ((BitmapDrawable)paramAnonymous2Message.obj).getBitmap();
                DirectionsResultActivity localDirectionsResultActivity = (DirectionsResultActivity)localImageView.getRootView().getContext();
                ImageView localImageView1 = localImageView;
                localDirectionsResultActivity.updateDirectionMap(localImageView1, localBitmap);
              }
            }
            while (true)
            {
              Looper.myLooper().quit();
              return;
              localBitmap = (Bitmap)paramAnonymous2Message.obj;
              break;
              if ((localImageView.getRootView().getContext() instanceof MoreMyTripsDirectionActivity))
              {
                ImageView localImageView2 = localImageView;
                Drawable localDrawable2 = (Drawable)paramAnonymous2Message.obj;
                localImageView2.setImageDrawable(localDrawable2);
                localImageView.invalidate();
              }
              else
              {
                ImageView localImageView3 = localImageView;
                Drawable localDrawable3 = (Drawable)paramAnonymous2Message.obj;
                localImageView3.setImageDrawable(localDrawable3);
                localImageView.invalidate();
              }
            }
          }
        };
        Object localObject = null;
        try
        {
          DrawableManager localDrawableManager = DrawableManager.this;
          String str2 = paramString;
          Drawable localDrawable = localDrawableManager.fetchDrawable(str2);
          localObject = localDrawable;
          Message localMessage1 = local1.obtainMessage(1, localObject);
          boolean bool1 = local1.sendMessage(localMessage1);
          Looper.loop();
          return;
        }
        catch (Exception localException)
        {
          while (true)
          {
            localException.printStackTrace();
            Message localMessage2 = local1.obtainMessage(2, null);
            boolean bool2 = local1.sendMessage(localMessage2);
            Looper.loop();
          }
        }
      }
    }
    .start();
  }

  public void fetchImageViewOnThread1(final String paramString, ImageView paramImageView)
  {
    if (this.drawableMap.containsKey(paramString))
    {
      Drawable localDrawable1 = (Drawable)this.drawableMap.get(paramString);
      if ((localDrawable1 != null) && (!((BitmapDrawable)localDrawable1).getBitmap().isRecycled()))
      {
        Drawable localDrawable2 = (Drawable)this.drawableMap.get(paramString);
        paramImageView.setImageDrawable(localDrawable2);
        return;
      }
    }
    new Thread()
    {
      public void run()
      {
        Object localObject = null;
        try
        {
          DrawableManager localDrawableManager = DrawableManager.this;
          String str = paramString;
          Drawable localDrawable = localDrawableManager.fetchDrawable(str);
          localObject = localDrawable;
          Message localMessage = DrawableManager.this.handler.obtainMessage(1, localObject);
          boolean bool = DrawableManager.this.handler.sendMessage(localMessage);
          return;
        }
        catch (Exception localException)
        {
          while (true)
            localException.printStackTrace();
        }
      }
    }
    .start();
  }

  public Drawable fetchNewDrawable(String paramString)
  {
    try
    {
      localDrawable = Drawable.createFromStream(fetch(paramString), "src");
      if (localDrawable != null)
        Object localObject = this.drawableMap.put(paramString, localDrawable);
      return localDrawable;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
        localDrawable = null;
    }
    catch (IOException localIOException)
    {
      while (true)
        Drawable localDrawable = null;
    }
  }

  public Drawable getMapFromURL(String paramString)
  {
    return (Drawable)this.drawableMap.get(paramString);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.network.DrawableManager
 * JD-Core Version:    0.6.2
 */