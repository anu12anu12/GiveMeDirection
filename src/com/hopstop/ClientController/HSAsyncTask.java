package com.hopstop.ClientController;

import android.os.AsyncTask;

public abstract class HSAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result>
{
  private Exception e;
  private String error_string;
  private boolean hasError = false;

  protected void Error(Exception paramException, String paramString)
  {
    this.e = paramException;
    this.error_string = paramString;
    this.hasError = true;
    paramException.printStackTrace();
  }

  protected String getErrorString()
  {
    return this.error_string;
  }

  protected Exception getException()
  {
    return this.e;
  }

  protected boolean hasError()
  {
    return this.hasError;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientController.HSAsyncTask
 * JD-Core Version:    0.6.2
 */