package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class ListVehicleIconsStep
  implements ViewStep
{
  private static final long serialVersionUID = 8747192013719045849L;
  private Hashtable<Integer, ViewStepDirections> _hashtable;
  private ArrayList<WrappedImageViewLayout> _list;

  public ListVehicleIconsStep()
  {
    Hashtable localHashtable = new Hashtable();
    this._hashtable = localHashtable;
    ArrayList localArrayList = new ArrayList();
    this._list = localArrayList;
  }

  public void add(int paramInt, ViewStepDirections paramViewStepDirections)
  {
    Hashtable localHashtable = this._hashtable;
    Integer localInteger = Integer.valueOf(paramInt);
    Object localObject = localHashtable.put(localInteger, paramViewStepDirections);
  }

  public void addBitmap(int paramInt, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return;
    Iterator localIterator = this._list.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      WrappedImageViewLayout localWrappedImageViewLayout = (WrappedImageViewLayout)localIterator.next();
      if ((localWrappedImageViewLayout.getChildAt(paramInt) instanceof WrappedImageView))
      {
        WrappedImageView localWrappedImageView = (WrappedImageView)localWrappedImageViewLayout.getChildAt(paramInt);
        if (localWrappedImageView.getIndex() != paramInt)
          localWrappedImageView.setImageBitmap(paramBitmap);
        localWrappedImageViewLayout.invalidate();
      }
    }
  }

  public void addWrappedView(WrappedImageViewLayout paramWrappedImageViewLayout)
  {
    boolean bool = this._list.add(paramWrappedImageViewLayout);
  }

  public ViewStep cloneItself()
  {
    ListVehicleIconsStep localListVehicleIconsStep = new ListVehicleIconsStep();
    Hashtable localHashtable = this._hashtable;
    localListVehicleIconsStep.setHashtable(localHashtable);
    ArrayList localArrayList = this._list;
    localListVehicleIconsStep.setList(localArrayList);
    return localListVehicleIconsStep;
  }

  public void downloadError(int paramInt)
  {
  }

  public void getAvailableStepIcons()
  {
  }

  public Bitmap getBitmap()
  {
    return null;
  }

  public String getURL()
  {
    return null;
  }

  public boolean isDownloading()
  {
    return false;
  }

  public void recycle(boolean paramBoolean)
  {
    Iterator localIterator = this._list.iterator();
    if (!localIterator.hasNext())
    {
      this._list.clear();
      this._hashtable.clear();
      return;
    }
    WrappedImageViewLayout localWrappedImageViewLayout = (WrappedImageViewLayout)localIterator.next();
    int i = 0;
    while (true)
    {
      int j = localWrappedImageViewLayout.getChildCount();
      if (i >= j)
        break;
      if ((localWrappedImageViewLayout.getChildAt(i) instanceof WrappedImageView))
      {
        WrappedImageView localWrappedImageView = (WrappedImageView)localWrappedImageViewLayout.getChildAt(i);
        if ((localWrappedImageViewLayout != null) && (localWrappedImageView.getDrawable() != null))
        {
          Drawable localDrawable = localWrappedImageView.getDrawable();
          if ((localDrawable instanceof BitmapDrawable))
            ((BitmapDrawable)localDrawable).getBitmap().recycle();
        }
      }
      i += 1;
    }
  }

  public void setBitmap(Bitmap paramBitmap)
  {
  }

  public void setDownloading(boolean paramBoolean)
  {
  }

  public void setHashtable(Hashtable<Integer, ViewStepDirections> paramHashtable)
  {
    Hashtable localHashtable = new Hashtable(paramHashtable);
    this._hashtable = localHashtable;
  }

  public void setList(ArrayList<WrappedImageViewLayout> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList);
    this._list = localArrayList;
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
  }

  /** @deprecated */
  public Collection<ViewStepDirections> values()
  {
    try
    {
      Collection localCollection1 = this._hashtable.values();
      Collection localCollection2 = localCollection1;
      return localCollection2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ListVehicleIconsStep
 * JD-Core Version:    0.6.2
 */