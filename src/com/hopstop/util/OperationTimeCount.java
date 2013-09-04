package com.hopstop.util;

import android.os.SystemClock;

public class OperationTimeCount
{
  long end;
  long interval;
  String operationName;
  long start;

  public void countExecutionTimeEnd(String paramString)
  {
    long l1 = SystemClock.elapsedRealtime();
    this.end = l1;
    long l2 = this.end;
    long l3 = this.start;
    long l4 = l2 - l3;
    this.interval = l4;
  }

  public void countExecutionTimeStart(String paramString)
  {
    long l = SystemClock.elapsedRealtime();
    this.start = l;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.util.OperationTimeCount
 * JD-Core Version:    0.6.2
 */