package com.flurry.android;

final class ae
  implements Runnable
{
  ae(v paramv, int paramInt)
  {
  }

  public final void run()
  {
    int i = this.a;
    CallbackEvent localCallbackEvent = new CallbackEvent(i);
    v.a(this.b).onAdsUpdated(localCallbackEvent);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.ae
 * JD-Core Version:    0.6.2
 */