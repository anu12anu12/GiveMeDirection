package com.crashlytics.android;

import android.os.AsyncTask;

final class g extends AsyncTask<Void, Void, Void>
{
  g(CrashTest paramCrashTest, long paramLong)
  {
  }

  private Void a()
  {
    try
    {
      Thread.sleep(this.a);
      label7: this.b.throwRuntimeException("Background thread crash");
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label7;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.g
 * JD-Core Version:    0.6.2
 */