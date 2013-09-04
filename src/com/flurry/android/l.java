package com.flurry.android;

import android.content.Context;

final class l
  implements Runnable
{
  l(b paramb)
  {
  }

  public final void run()
  {
    FlurryAgent localFlurryAgent = this.a.b;
    Context localContext = this.a.a;
    FlurryAgent.b(localFlurryAgent, localContext);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.l
 * JD-Core Version:    0.6.2
 */