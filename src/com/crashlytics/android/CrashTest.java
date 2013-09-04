package com.crashlytics.android;

import android.os.AsyncTask;

public class CrashTest
{
  public void crashAsyncTask(long paramLong)
  {
    g localg = new g(this, paramLong);
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = null;
    AsyncTask localAsyncTask = localg.execute(arrayOfVoid);
  }

  public void indexOutOfBounds()
  {
    int i = new int[2][10];
    D.c("Out of bounds value: " + i);
  }

  public void stackOverflow()
  {
    stackOverflow();
  }

  public void throwFiveChainedExceptions()
  {
    try
    {
      throw new RuntimeException("1");
    }
    catch (Exception localException1)
    {
      try
      {
        throw new RuntimeException("2", localException1);
      }
      catch (Exception localException2)
      {
        try
        {
          throw new RuntimeException("3", localException2);
        }
        catch (Exception localException3)
        {
          try
          {
            throw new RuntimeException("4", localException3);
          }
          catch (Exception localException4)
          {
            throw new RuntimeException("5", localException4);
          }
        }
      }
    }
  }

  public void throwRuntimeException(String paramString)
  {
    throw new RuntimeException(paramString);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.CrashTest
 * JD-Core Version:    0.6.2
 */