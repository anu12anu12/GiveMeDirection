package com.flurry.android;

import android.content.Context;

final class d
  implements Runnable
{
  d(FlurryAgent paramFlurryAgent, Context paramContext, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (!FlurryAgent.a(this.c))
    {
      FlurryAgent localFlurryAgent1 = this.c;
      Context localContext1 = this.a;
      FlurryAgent.a(localFlurryAgent1, localContext1);
    }
    FlurryAgent localFlurryAgent2 = this.c;
    Context localContext2 = this.a;
    boolean bool = this.b;
    FlurryAgent.a(localFlurryAgent2, localContext2, bool);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.d
 * JD-Core Version:    0.6.2
 */