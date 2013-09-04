package com.flurry.android;

final class af
  implements Runnable
{
  af(v paramv, String paramString)
  {
  }

  public final void run()
  {
    CallbackEvent localCallbackEvent = new CallbackEvent(101);
    String str = this.a;
    localCallbackEvent.setMessage(str);
    if (v.a(this.b) == null)
      return;
    v.a(this.b).onMarketAppLaunchError(localCallbackEvent);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.af
 * JD-Core Version:    0.6.2
 */