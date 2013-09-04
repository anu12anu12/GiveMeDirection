package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.List;

class NoopDispatcher
  implements Dispatcher
{
  public int dispatchHits(List<Hit> paramList)
  {
    if (paramList == null)
    {
      i = 0;
      return i;
    }
    int j = Log.iDebug("Hits not actually being sent as dispatch is false...");
    int i = Math.min(paramList.size(), 40);
    int k = 0;
    label29: String str1;
    label65: String str2;
    if (k < i)
      if (Log.debugEnabled())
      {
        if (!TextUtils.isEmpty(((Hit)paramList.get(k)).getHitParams()))
          break label111;
        str1 = "";
        if (!TextUtils.isEmpty(str1))
          break label141;
        str2 = "Hit couldn't be read, wouldn't be sent:";
      }
    while (true)
    {
      int m = Log.iDebug(str2 + str1);
      k += 1;
      break label29;
      break;
      label111: Hit localHit = (Hit)paramList.get(k);
      long l = System.currentTimeMillis();
      str1 = HitBuilder.postProcessHit(localHit, l);
      break label65;
      label141: if (str1.length() <= 2036)
        str2 = "GET would be sent:";
      else if (str1.length() > 8192)
        str2 = "Would be too big:";
      else
        str2 = "POST would be sent:";
    }
  }

  public boolean okToDispatch()
  {
    return true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.NoopDispatcher
 * JD-Core Version:    0.6.2
 */