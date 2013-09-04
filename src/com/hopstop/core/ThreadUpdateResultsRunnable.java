package com.hopstop.core;

import com.hopstop.ClientModel.DirectionResponse;

public abstract interface ThreadUpdateResultsRunnable extends Runnable
{
  public abstract void getImageView(DirectionResponse paramDirectionResponse);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.core.ThreadUpdateResultsRunnable
 * JD-Core Version:    0.6.2
 */