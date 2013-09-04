package com.ls.widgets.map.commands;

public abstract interface MapCommandDelegate
{
  public abstract void onError(Exception paramException);

  public abstract void onSuccess(Object paramObject);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.commands.MapCommandDelegate
 * JD-Core Version:    0.6.2
 */