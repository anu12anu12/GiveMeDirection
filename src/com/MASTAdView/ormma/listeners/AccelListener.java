package com.MASTAdView.ormma.listeners;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.MASTAdView.ormma.OrmmaSensorController;
import java.util.List;

public class AccelListener
  implements SensorEventListener
{
  private static final int FORCE_THRESHOLD = 1000;
  private static final int SHAKE_COUNT = 2;
  private static final int SHAKE_DURATION = 2000;
  private static final int SHAKE_TIMEOUT = 500;
  private static final int TIME_THRESHOLD = 100;
  private boolean bAccReady;
  private boolean bMagReady;
  private float[] mAccVals;
  private float[] mActualOrientation;
  Context mCtx;
  String mKey;
  private float[] mLastAccVals;
  private long mLastForce;
  private long mLastShake;
  private long mLastTime;
  private float[] mMagVals;
  OrmmaSensorController mSensorController;
  private int mSensorDelay = 3;
  private int mShakeCount;
  int registeredHeadingListeners = 0;
  int registeredShakeListeners = 0;
  int registeredTiltListeners = 0;
  private SensorManager sensorManager;

  public AccelListener(Context paramContext, OrmmaSensorController paramOrmmaSensorController)
  {
    float[] arrayOfFloat1 = { 0, 0, 0 };
    this.mAccVals = arrayOfFloat1;
    float[] arrayOfFloat2 = { 0, 0, 0 };
    this.mLastAccVals = arrayOfFloat2;
    float[] arrayOfFloat3 = { -1082130432, -1082130432, -1082130432 };
    this.mActualOrientation = arrayOfFloat3;
    this.mCtx = paramContext;
    this.mSensorController = paramOrmmaSensorController;
    SensorManager localSensorManager = (SensorManager)this.mCtx.getSystemService("sensor");
    this.sensorManager = localSensorManager;
  }

  private double[] accelerometer2tilt(float[] paramArrayOfFloat)
  {
    double d1 = -paramArrayOfFloat[0] / 9.80665F;
    double d2 = -paramArrayOfFloat[1] / 9.80665F;
    double d3 = paramArrayOfFloat[2] / 9.80665F;
    float f1 = d1 * d1;
    float f2 = d2 * d2;
    double d4 = f1 + f2;
    float f3 = d3 * d3;
    double d5 = Math.sqrt(d4 + f3);
    double d6 = Math.asin(d1 / d5);
    double d7 = Math.asin(d2 / d5);
    double d8 = Math.asin(d3 / d5);
    double[] arrayOfDouble = new double[3];
    arrayOfDouble[0] = d6;
    arrayOfDouble[1] = d7;
    arrayOfDouble[2] = d8;
    return arrayOfDouble;
  }

  private int rad2deg(float paramFloat)
  {
    if (paramFloat <= 0.0F);
    for (double d = Math.toDegrees(paramFloat) + 360.0D; ; d = Math.toDegrees(paramFloat))
      return (int)d;
  }

  private void start()
  {
    List localList = this.sensorManager.getSensorList(1);
    if (localList.size() > 0)
    {
      SensorManager localSensorManager = this.sensorManager;
      Sensor localSensor = (Sensor)localList.get(0);
      int i = this.mSensorDelay;
      boolean bool = localSensorManager.registerListener(this, localSensor, i);
      return;
    }
    this.mSensorController.injectJavaScript("Ormma.fireError(\"accelerometer\",\"Sensor is absent\")");
  }

  private void startMag()
  {
    List localList = this.sensorManager.getSensorList(2);
    if (localList.size() > 0)
    {
      SensorManager localSensorManager = this.sensorManager;
      Sensor localSensor = (Sensor)localList.get(0);
      int i = this.mSensorDelay;
      boolean bool = localSensorManager.registerListener(this, localSensor, i);
      start();
      return;
    }
    this.mSensorController.injectJavaScript("Ormma.fireError(\"heading\",\"Sensor is absent\")");
  }

  public float getHeading()
  {
    float f = this.mActualOrientation[0];
    if (f == -1.0F);
    while (true)
    {
      return f;
      f = rad2deg(f);
    }
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default:
    case 2:
    case 1:
    }
    while (true)
    {
      if ((this.mMagVals != null) && (this.mAccVals != null) && (this.bAccReady) && (this.bMagReady))
      {
        this.bAccReady = false;
        this.bMagReady = false;
        float[] arrayOfFloat1 = new float[9];
        float[] arrayOfFloat2 = new float[9];
        float[] arrayOfFloat3 = this.mAccVals;
        float[] arrayOfFloat4 = this.mMagVals;
        boolean bool = SensorManager.getRotationMatrix(arrayOfFloat1, arrayOfFloat2, arrayOfFloat3, arrayOfFloat4);
        float[] arrayOfFloat5 = new float[3];
        this.mActualOrientation = arrayOfFloat5;
        float[] arrayOfFloat6 = this.mActualOrientation;
        float[] arrayOfFloat7 = SensorManager.getOrientation(arrayOfFloat1, arrayOfFloat6);
        OrmmaSensorController localOrmmaSensorController1 = this.mSensorController;
        int i = this.mActualOrientation[0];
        int j = rad2deg(i);
        localOrmmaSensorController1.onHeadingChange(j);
      }
      if (paramSensorEvent.sensor.getType() != 1)
        return;
      long l1 = System.currentTimeMillis();
      long l2 = this.mLastForce;
      if (l1 - l2 > 500L)
        this.mShakeCount = 0;
      long l3 = this.mLastTime;
      if (l1 - l3 <= 100L)
        return;
      long l4 = this.mLastTime;
      long l5 = l1 - l4;
      int k = this.mAccVals[0];
      int m = this.mAccVals[1];
      float f1 = k + m;
      int n = this.mAccVals[2];
      float f2 = f1 + n;
      int i1 = this.mLastAccVals[0];
      float f3 = f2 - i1;
      int i2 = this.mLastAccVals[1];
      float f4 = f3 - i2;
      int i3 = this.mLastAccVals[2];
      float f5 = Math.abs(f4 - i3);
      float f6 = (float)l5;
      if (f5 / f6 * 10000.0F > 1000.0F)
      {
        int i4 = this.mShakeCount + 1;
        this.mShakeCount = i4;
        if (i4 >= 2)
        {
          long l6 = this.mLastShake;
          if (l1 - l6 > 2000L)
          {
            this.mLastShake = l1;
            this.mShakeCount = 0;
            this.mSensorController.onShake();
          }
        }
        this.mLastForce = l1;
      }
      this.mLastTime = l1;
      float[] arrayOfFloat8 = this.mAccVals;
      double[] arrayOfDouble = accelerometer2tilt(arrayOfFloat8);
      OrmmaSensorController localOrmmaSensorController2 = this.mSensorController;
      float f7 = (float)arrayOfDouble[0];
      float f8 = (float)arrayOfDouble[1];
      float f9 = (float)arrayOfDouble[2];
      localOrmmaSensorController2.onTilt(f7, f8, f9);
      return;
      float[] arrayOfFloat9 = (float[])paramSensorEvent.values.clone();
      this.mMagVals = arrayOfFloat9;
      this.bMagReady = true;
      continue;
      float[] arrayOfFloat10 = this.mAccVals;
      this.mLastAccVals = arrayOfFloat10;
      float[] arrayOfFloat11 = (float[])paramSensorEvent.values.clone();
      this.mAccVals = arrayOfFloat11;
      this.bAccReady = true;
    }
  }

  public void setSensorDelay(int paramInt)
  {
    this.mSensorDelay = paramInt;
    if ((this.registeredTiltListeners <= 0) && (this.registeredShakeListeners <= 0))
      return;
    stop();
    start();
  }

  public void startTrackingHeading()
  {
    if (this.registeredHeadingListeners == 0)
      startMag();
    int i = this.registeredHeadingListeners + 1;
    this.registeredHeadingListeners = i;
  }

  public void startTrackingShake()
  {
    if (this.registeredShakeListeners == 0)
      setSensorDelay(1);
    int i = this.registeredShakeListeners + 1;
    this.registeredShakeListeners = i;
    start();
  }

  public void startTrackingTilt()
  {
    int i = this.registeredTiltListeners + 1;
    this.registeredTiltListeners = i;
    start();
  }

  public void stop()
  {
    if (this.registeredHeadingListeners != 0)
      return;
    if (this.registeredShakeListeners != 0)
      return;
    if (this.registeredTiltListeners != 0)
      return;
    this.sensorManager.unregisterListener(this);
  }

  public void stopTrackingHeading()
  {
    if (this.registeredHeadingListeners <= 0)
      return;
    int i = this.registeredHeadingListeners + -1;
    this.registeredHeadingListeners = i;
    stop();
  }

  public void stopTrackingShake()
  {
    if (this.registeredShakeListeners <= 0)
      return;
    int i = this.registeredShakeListeners + -1;
    this.registeredShakeListeners = i;
    if (this.registeredShakeListeners == 0)
      setSensorDelay(3);
    stop();
  }

  public void stopTrackingTilt()
  {
    if (this.registeredTiltListeners <= 0)
      return;
    int i = this.registeredTiltListeners + -1;
    this.registeredTiltListeners = i;
    stop();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.listeners.AccelListener
 * JD-Core Version:    0.6.2
 */