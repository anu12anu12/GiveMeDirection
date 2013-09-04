package com.flurry.android;

import java.util.Iterator;
import java.util.List;

final class j
  implements Runnable
{
  j(List paramList)
  {
  }

  public final void run()
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((o)localIterator.next()).a();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.j
 * JD-Core Version:    0.6.2
 */