package com.skyhookwireless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.List;

class _sdkyb
  implements SensorEventListener
{
  private static final String z;
  final _sdkcd _sdka;

  static
  {
    Object localObject1 = "w+m*\001f!w~Dg,pf\0010'ue\027u ".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    Object localObject3;
    int n;
    label31: int i1;
    int i2;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      int m = i;
      localObject3 = localObject1;
      n = m;
      i1 = localObject3[j];
      switch (k % 5)
      {
      default:
        i2 = 100;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i3 = (char)(i2 ^ i1);
      localObject3[j] = i3;
      j = k + 1;
      if (n == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = n;
        break label31;
      }
      i = n;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i2 = 16;
      continue;
      i2 = 68;
      continue;
      i2 = 25;
      continue;
      i2 = 10;
    }
  }

  _sdkyb(_sdkcd param_sdkcd)
  {
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    synchronized (this._sdka)
    {
      if (!_sdkcd._sdkb(this._sdka))
      {
        _sdkhb local_sdkhb = _sdkcd._sdkc(this._sdka);
        String str = z;
        local_sdkhb._sdkb(str);
        return;
      }
      List localList = _sdkcd._sdkd(this._sdka);
      _sdkcd local_sdkcd2 = this._sdka;
      int i = paramSensorEvent.values[0];
      int j = paramSensorEvent.values[1];
      int k = paramSensorEvent.values[2];
      _sdkec local_sdkec = _sdkec._sdkd();
      _sdkwb local_sdkwb = new _sdkwb(local_sdkcd2, i, j, k, local_sdkec);
      boolean bool = localList.add(local_sdkwb);
      _sdkcd._sdke(this._sdka);
      return;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkyb
 * JD-Core Version:    0.6.2
 */