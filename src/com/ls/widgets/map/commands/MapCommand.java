package com.ls.widgets.map.commands;

import com.ls.widgets.map.config.OfflineMapConfig;

public abstract class MapCommand
  implements Runnable
{
  private OfflineMapConfig a;
  private MapCommandDelegate b;

  public MapCommand(OfflineMapConfig paramOfflineMapConfig, MapCommandDelegate paramMapCommandDelegate)
  {
    this.a = paramOfflineMapConfig;
    this.b = paramMapCommandDelegate;
  }

  public OfflineMapConfig getConfig()
  {
    return this.a;
  }

  public void onError(Exception paramException)
  {
    paramException.printStackTrace();
    if (this.b == null)
      return;
    this.b.onError(paramException);
  }

  public void onSuccess(Object paramObject)
  {
    if (this.b == null)
      return;
    this.b.onSuccess(paramObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.commands.MapCommand
 * JD-Core Version:    0.6.2
 */