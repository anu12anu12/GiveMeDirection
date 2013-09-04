package com.hopstop.ClientModel.directions;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.hopstop.ClientView.anim.ViewStepSubwayVehicle;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.DrawableManager;
import com.hopstop.network.NetworkEngine;
import java.util.LinkedList;

public class LoadImageFromNetworkTask extends AsyncTask<Object, Integer, Object[]>
{
  private static LinkedList<LoadImageFromNetworkTask> queue = new LinkedList();
  private ImageView _imgView = null;
  private ViewStepSubwayVehicle _vehicle = null;

  public LoadImageFromNetworkTask()
  {
  }

  public LoadImageFromNetworkTask(ViewStepSubwayVehicle paramViewStepSubwayVehicle, ImageView paramImageView)
  {
    this._vehicle = paramViewStepSubwayVehicle;
    this._imgView = paramImageView;
  }

  public static void addToQueue(ViewStepSubwayVehicle paramViewStepSubwayVehicle, ImageView paramImageView)
  {
    synchronized (queue)
    {
      LinkedList localLinkedList2 = queue;
      LoadImageFromNetworkTask localLoadImageFromNetworkTask = new LoadImageFromNetworkTask(paramViewStepSubwayVehicle, paramImageView);
      boolean bool = localLinkedList2.add(localLoadImageFromNetworkTask);
      executeTask();
      return;
    }
  }

  /** @deprecated */
  private static void executeTask()
  {
    try
    {
      synchronized (queue)
      {
        if ((queue.size() < 5) && (queue.size() > 0))
        {
          LoadImageFromNetworkTask localLoadImageFromNetworkTask = (LoadImageFromNetworkTask)queue.get(0);
          Object[] arrayOfObject = new Object[2];
          ViewStepSubwayVehicle localViewStepSubwayVehicle = localLoadImageFromNetworkTask._vehicle;
          arrayOfObject[0] = localViewStepSubwayVehicle;
          ImageView localImageView = localLoadImageFromNetworkTask._imgView;
          arrayOfObject[1] = localImageView;
          AsyncTask localAsyncTask = localLoadImageFromNetworkTask.execute(arrayOfObject);
          boolean bool = queue.remove(localLoadImageFromNetworkTask);
        }
        return;
      }
    }
    finally
    {
    }
  }

  protected Object[] doInBackground(Object[] paramArrayOfObject)
  {
    ViewStep localViewStep = (ViewStep)paramArrayOfObject[0];
    ImageView localImageView = (ImageView)paramArrayOfObject[1];
    Object[] arrayOfObject;
    if (!localViewStep.isDownloading())
    {
      localViewStep.setDownloading(true);
      Drawable localDrawable = NetworkEngine.fetchNewDrawable(localViewStep.getURL());
      arrayOfObject = new Object[3];
      arrayOfObject[0] = localViewStep;
      arrayOfObject[1] = localDrawable;
      arrayOfObject[2] = localImageView;
    }
    while (true)
    {
      return arrayOfObject;
      arrayOfObject = null;
    }
  }

  protected void onPostExecute(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      return;
    ViewStep localViewStep = (ViewStep)paramArrayOfObject[0];
    Bitmap localBitmap = DrawableManager.resizeDrawable((Drawable)paramArrayOfObject[1]);
    ImageView localImageView = (ImageView)paramArrayOfObject[2];
    localViewStep.setBitmap(localBitmap);
    localViewStep.setDownloading(false);
    if ((localImageView != null) && (localBitmap != null))
    {
      if ((localViewStep instanceof ViewStepSubwayVehicle))
      {
        float f1 = localBitmap.getWidth();
        float f2 = ApplicationEngine.DEVICE_DENSITY;
        int i = (int)(f1 * f2) + 20;
        localImageView.setMinimumWidth(i);
        float f3 = localBitmap.getHeight();
        float f4 = ApplicationEngine.DEVICE_DENSITY;
        int j = (int)(f3 * f4);
        localImageView.setMinimumHeight(j);
      }
      localImageView.setImageBitmap(localBitmap);
      localImageView.invalidate();
    }
    if (((localViewStep instanceof ViewStepSubwayVehicle)) && (queue.size() > 0))
      executeTask();
    Object[] arrayOfObject = (Object[])null;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.LoadImageFromNetworkTask
 * JD-Core Version:    0.6.2
 */