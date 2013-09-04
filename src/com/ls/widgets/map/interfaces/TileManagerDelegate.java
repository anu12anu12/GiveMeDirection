package com.ls.widgets.map.interfaces;

import android.graphics.drawable.Drawable;

public abstract interface TileManagerDelegate
{
  public abstract void onError(Exception paramException);

  public abstract void onTileReady(int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.interfaces.TileManagerDelegate
 * JD-Core Version:    0.6.2
 */