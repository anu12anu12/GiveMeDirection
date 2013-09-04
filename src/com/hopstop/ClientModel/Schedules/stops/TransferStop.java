package com.hopstop.ClientModel.Schedules.stops;

public class TransferStop extends Stop
{
  private String _actionsText;

  public TransferStop(String paramString)
  {
    this._actionsText = paramString;
  }

  public String getActionsText()
  {
    return this._actionsText;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.stops.TransferStop
 * JD-Core Version:    0.6.2
 */