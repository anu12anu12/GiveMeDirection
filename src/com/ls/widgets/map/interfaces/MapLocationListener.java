package com.ls.widgets.map.interfaces;

import android.location.Location;

public abstract interface MapLocationListener
{
  public abstract void onChangePinVisibility(boolean paramBoolean);

  public abstract void onMovePinTo(Location paramLocation);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.interfaces.MapLocationListener
 * JD-Core Version:    0.6.2
 */