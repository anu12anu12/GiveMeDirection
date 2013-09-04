package com.androidquery.auth;

import android.content.Context;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.http.HttpRequest;

public abstract class AccountHandle
{
  private LinkedHashSet<AbstractAjaxCallback<?, ?>> callbacks;

  public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpURLConnection paramHttpURLConnection)
  {
  }

  public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpRequest paramHttpRequest)
  {
  }

  protected abstract void auth();

  /** @deprecated */
  public void auth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback)
  {
    try
    {
      if (this.callbacks == null)
      {
        LinkedHashSet localLinkedHashSet = new LinkedHashSet();
        this.callbacks = localLinkedHashSet;
        boolean bool1 = this.callbacks.add(paramAbstractAjaxCallback);
        auth();
      }
      while (true)
      {
        return;
        boolean bool2 = this.callbacks.add(paramAbstractAjaxCallback);
      }
    }
    finally
    {
    }
  }

  public abstract boolean authenticated();

  public abstract boolean expired(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, AjaxStatus paramAjaxStatus);

  /** @deprecated */
  protected void failure(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      Iterator localIterator;
      if (this.callbacks != null)
        localIterator = this.callbacks.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.callbacks = null;
          return;
        }
        ((AbstractAjaxCallback)localIterator.next()).failure(paramInt, paramString);
      }
    }
    finally
    {
    }
  }

  public String getCacheUrl(String paramString)
  {
    return paramString;
  }

  public String getNetworkUrl(String paramString)
  {
    return paramString;
  }

  public abstract boolean reauth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback);

  /** @deprecated */
  protected void success(Context paramContext)
  {
    try
    {
      Iterator localIterator;
      if (this.callbacks != null)
        localIterator = this.callbacks.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.callbacks = null;
          return;
        }
        ((AbstractAjaxCallback)localIterator.next()).async(paramContext);
      }
    }
    finally
    {
    }
  }

  public void unauth()
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.auth.AccountHandle
 * JD-Core Version:    0.6.2
 */