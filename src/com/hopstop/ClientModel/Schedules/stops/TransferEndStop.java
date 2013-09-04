package com.hopstop.ClientModel.Schedules.stops;

import org.simpleframework.xml.Root;

@Root(strict=false)
public class TransferEndStop extends Stop
{
  public TransferEndStop(Stop paramStop)
  {
    super(paramStop);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.stops.TransferEndStop
 * JD-Core Version:    0.6.2
 */