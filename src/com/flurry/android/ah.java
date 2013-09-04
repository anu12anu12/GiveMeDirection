package com.flurry.android;

import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ah
{
  private List a;
  private Handler b;
  private Handler c;
  private int d;
  private Runnable e;

  ah(Handler paramHandler, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    this.b = paramHandler;
    Handler localHandler = new Handler();
    this.c = localHandler;
    this.d = paramInt;
    k localk = new k(this);
    this.e = localk;
    b();
  }

  /** @deprecated */
  private void a()
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)((WeakReference)localIterator.next()).get();
        if (localo != null)
          boolean bool1 = localArrayList.add(localo);
      }
    }
    finally
    {
    }
    Handler localHandler = this.c;
    j localj = new j(localArrayList);
    boolean bool2 = localHandler.post(localj);
    b();
  }

  /** @deprecated */
  private void b()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        if (((WeakReference)localIterator.next()).get() == null)
          localIterator.remove();
    }
    finally
    {
    }
    Handler localHandler1 = this.b;
    Runnable localRunnable1 = this.e;
    localHandler1.removeCallbacks(localRunnable1);
    Handler localHandler2 = this.b;
    Runnable localRunnable2 = this.e;
    long l = this.d;
    boolean bool = localHandler2.postDelayed(localRunnable2, l);
  }

  /** @deprecated */
  final void a(o paramo)
  {
    try
    {
      paramo.a();
      List localList = this.a;
      WeakReference localWeakReference = new WeakReference(paramo);
      boolean bool = localList.add(localWeakReference);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.ah
 * JD-Core Version:    0.6.2
 */