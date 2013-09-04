package com.hopstop.ClientModel.directions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;

@SuppressLint({"ViewConstructor"})
public class WrappedImageView extends ImageView
{
  private int _index;

  public WrappedImageView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this._index = paramInt;
  }

  public int getIndex()
  {
    return this._index;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.WrappedImageView
 * JD-Core Version:    0.6.2
 */