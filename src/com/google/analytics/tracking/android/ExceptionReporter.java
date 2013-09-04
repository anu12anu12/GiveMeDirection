package com.google.analytics.tracking.android;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private ExceptionParser exceptionParser;
  private final Thread.UncaughtExceptionHandler originalHandler;
  private final ServiceManager serviceManager;
  private final Tracker tracker;

  public ExceptionReporter(Tracker paramTracker, ServiceManager paramServiceManager, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    if (paramTracker == null)
      throw new NullPointerException("tracker cannot be null");
    if (paramServiceManager == null)
      throw new NullPointerException("serviceManager cannot be null");
    this.originalHandler = paramUncaughtExceptionHandler;
    this.tracker = paramTracker;
    this.serviceManager = paramServiceManager;
    StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null);
    for (String str = "null"; ; str = paramUncaughtExceptionHandler.getClass().getName())
    {
      int i = Log.iDebug(str);
      return;
    }
  }

  public ExceptionParser getExceptionParser()
  {
    return this.exceptionParser;
  }

  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.exceptionParser = paramExceptionParser;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str1;
    if (this.exceptionParser == null)
    {
      str1 = paramThrowable.getMessage();
      int i = Log.iDebug("Tracking Exception: " + str1);
      this.tracker.trackException(str1, true);
      this.serviceManager.dispatch();
      if (this.originalHandler == null)
        return;
      int j = Log.iDebug("Passing exception to original handler.");
      this.originalHandler.uncaughtException(paramThread, paramThrowable);
      return;
    }
    if (paramThread != null);
    for (String str2 = paramThread.getName(); ; str2 = null)
    {
      str1 = this.exceptionParser.getDescription(str2, paramThrowable);
      break;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.ExceptionReporter
 * JD-Core Version:    0.6.2
 */