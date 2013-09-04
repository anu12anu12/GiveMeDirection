package com.flurry.android;

import android.content.Context;
import android.os.Handler;

final class b
  implements Runnable
{
  b(FlurryAgent paramFlurryAgent, boolean paramBoolean, Context paramContext)
  {
  }

  public final void run()
  {
    FlurryAgent.b(this.b);
    FlurryAgent.c(this.b);
    if (!this.c)
    {
      Handler localHandler = FlurryAgent.d(this.b);
      l locall = new l(this);
      long l = FlurryAgent.i();
      boolean bool = localHandler.postDelayed(locall, l);
    }
    if (!FlurryAgent.j())
      return;
    FlurryAgent.e(this.b).c();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.b
 * JD-Core Version:    0.6.2
 */