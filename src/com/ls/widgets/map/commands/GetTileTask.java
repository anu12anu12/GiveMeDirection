package com.ls.widgets.map.commands;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;

public class GetTileTask extends AsyncTask<Integer, Integer, Boolean>
{
  private static final Drawable c = new ColorDrawable(0);
  private InputStream a;
  private Drawable b;

  public GetTileTask(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }

  public void closeStream()
    throws IOException
  {
    this.a.close();
  }

  protected Boolean doInBackground(Integer[] paramArrayOfInteger)
  {
    try
    {
      localObject = BitmapFactory.decodeStream(this.a);
      if (localObject != null)
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable((Bitmap)localObject);
        Drawable[] arrayOfDrawable = new Drawable[2];
        Drawable localDrawable1 = c;
        arrayOfDrawable[0] = localDrawable1;
        arrayOfDrawable[1] = localBitmapDrawable;
        TransitionDrawable localTransitionDrawable = new TransitionDrawable(arrayOfDrawable);
        this.b = localTransitionDrawable;
        Drawable localDrawable2 = this.b;
        int i = localBitmapDrawable.getBitmap().getWidth();
        int j = localBitmapDrawable.getBitmap().getHeight();
        localDrawable2.setBounds(0, 0, i, j);
      }
      for (localObject = Boolean.TRUE; ; localObject = Boolean.FALSE)
        return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
        Object localObject = Boolean.FALSE;
    }
  }

  public Drawable getResult()
  {
    return this.b;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.commands.GetTileTask
 * JD-Core Version:    0.6.2
 */