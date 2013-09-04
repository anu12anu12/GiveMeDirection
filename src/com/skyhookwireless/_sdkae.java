package com.skyhookwireless;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class _sdkae extends FutureTask<T>
{
  _sdkae(Callable paramCallable)
  {
    super(paramCallable);
  }

  public T get()
    throws ExecutionException, InterruptedException
  {
    if ((!isDone()) && (_sdkr._sdkc()))
      run();
    return super.get();
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException, InterruptedException, TimeoutException
  {
    if ((!isDone()) && (_sdkr._sdkc()))
      run();
    return super.get(paramLong, paramTimeUnit);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkae
 * JD-Core Version:    0.6.2
 */