package com.flurry.android;

public class FlurryAgent$FlurryDefaultExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a;

  FlurryAgent$FlurryDefaultExceptionHandler()
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    this.a = localUncaughtExceptionHandler;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      FlurryAgent.h().a(paramThrowable);
      if (this.a == null)
        return;
      this.a.uncaughtException(paramThread, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        int i = ai.b("FlurryAgent", "", localThrowable);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.FlurryAgent.FlurryDefaultExceptionHandler
 * JD-Core Version:    0.6.2
 */