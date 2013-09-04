package com.crashlytics.android;

import java.util.concurrent.CountDownLatch;

final class z
{
  private boolean a = false;
  private final CountDownLatch b;

  private z()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.b = localCountDownLatch;
  }

  final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.b.countDown();
  }

  final boolean a()
  {
    return this.a;
  }

  final void b()
  {
    try
    {
      this.b.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.z
 * JD-Core Version:    0.6.2
 */