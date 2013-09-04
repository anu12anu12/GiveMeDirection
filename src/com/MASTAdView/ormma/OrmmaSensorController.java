package com.MASTAdView.ormma;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import com.MASTAdView.MASTAdViewCore;
import com.MASTAdView.ormma.listeners.AccelListener;
import java.util.List;

public class OrmmaSensorController extends OrmmaController
{
  final int INTERVAL = 1000;
  private Context appContext;
  private AccelListener mAccel;
  private float mLastX = 0.0F;
  private float mLastY = 0.0F;
  private float mLastZ = 0.0F;

  public OrmmaSensorController(MASTAdViewCore paramMASTAdViewCore, Context paramContext)
  {
    super(paramMASTAdViewCore, paramContext);
    this.appContext = paramContext;
    this.mAccel = null;
  }

  public static boolean hasAccelerometer(Context paramContext)
  {
    boolean bool = false;
    if (isEmulator());
    while (true)
    {
      return bool;
      SensorManager localSensorManager = (SensorManager)paramContext.getSystemService("sensor");
      if ((localSensorManager != null) && (localSensorManager.getSensorList(1).size() > 0))
        bool = true;
    }
  }

  public static boolean hasMagneticField(Context paramContext)
  {
    boolean bool = false;
    if (isEmulator());
    while (true)
    {
      return bool;
      SensorManager localSensorManager = (SensorManager)paramContext.getSystemService("sensor");
      if ((localSensorManager != null) && (localSensorManager.getSensorList(2).size() > 0))
        bool = true;
    }
  }

  public static boolean isEmulator()
  {
    if (Build.MODEL.contains("sdk"));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public float getHeading()
  {
    if (this.mAccel == null)
    {
      Context localContext = this.appContext;
      AccelListener localAccelListener = new AccelListener(localContext, this);
      this.mAccel = localAccelListener;
    }
    return this.mAccel.getHeading();
  }

  public String getTilt()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("{ x : \"");
    float f1 = this.mLastX;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(f1).append("\", y : \"");
    float f2 = this.mLastY;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(f2).append("\", z : \"");
    float f3 = this.mLastZ;
    return f3 + "\"}";
  }

  public void injectJavaScript(String paramString)
  {
    this.mOrmmaView.injectJavaScript(paramString);
  }

  public void onHeadingChange(int paramInt)
  {
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str = "Ormma.gotHeadingChange(" + paramInt + ")";
    localMASTAdViewCore.injectJavaScript(str);
  }

  public void onShake()
  {
    this.mOrmmaView.injectJavaScript("Ormma.gotShake()");
  }

  public void onTilt(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mLastX = paramFloat1;
    this.mLastY = paramFloat2;
    this.mLastZ = paramFloat3;
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    StringBuilder localStringBuilder1 = new StringBuilder("Ormma.gotTiltChange({ x : \"");
    float f1 = this.mLastX;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(f1).append("\", y : \"");
    float f2 = this.mLastY;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(f2).append("\", z : \"");
    float f3 = this.mLastZ;
    String str = f3 + "\"})";
    localMASTAdViewCore.injectJavaScript(str);
  }

  public void startHeadingListener()
  {
    if (this.mAccel == null)
    {
      Context localContext = this.appContext;
      AccelListener localAccelListener = new AccelListener(localContext, this);
      this.mAccel = localAccelListener;
    }
    this.mAccel.startTrackingHeading();
  }

  public void startShakeListener()
  {
    if (this.mAccel == null)
    {
      Context localContext = this.appContext;
      AccelListener localAccelListener = new AccelListener(localContext, this);
      this.mAccel = localAccelListener;
    }
    this.mAccel.startTrackingShake();
  }

  public void startTiltListener()
  {
    if (this.mAccel == null)
    {
      Context localContext = this.appContext;
      AccelListener localAccelListener = new AccelListener(localContext, this);
      this.mAccel = localAccelListener;
    }
    this.mAccel.startTrackingTilt();
  }

  void stop()
  {
  }

  public void stopHeadingListener()
  {
    if (this.mAccel == null)
    {
      Context localContext = this.appContext;
      AccelListener localAccelListener = new AccelListener(localContext, this);
      this.mAccel = localAccelListener;
    }
    this.mAccel.stopTrackingHeading();
  }

  public void stopShakeListener()
  {
    if (this.mAccel == null)
    {
      Context localContext = this.appContext;
      AccelListener localAccelListener = new AccelListener(localContext, this);
      this.mAccel = localAccelListener;
    }
    this.mAccel.stopTrackingShake();
  }

  public void stopTiltListener()
  {
    if (this.mAccel == null)
    {
      Context localContext = this.appContext;
      AccelListener localAccelListener = new AccelListener(localContext, this);
      this.mAccel = localAccelListener;
    }
    this.mAccel.stopTrackingTilt();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.OrmmaSensorController
 * JD-Core Version:    0.6.2
 */