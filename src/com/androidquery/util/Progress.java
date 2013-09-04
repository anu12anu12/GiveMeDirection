package com.androidquery.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;

public class Progress
  implements Runnable
{
  private Activity act;
  private int bytes;
  private int current;
  private ProgressBar pb;
  private ProgressDialog pd;
  private boolean unknown;
  private String url;
  private View view;

  public Progress(Object paramObject)
  {
    if ((paramObject instanceof ProgressBar))
    {
      ProgressBar localProgressBar = (ProgressBar)paramObject;
      this.pb = localProgressBar;
      return;
    }
    if ((paramObject instanceof ProgressDialog))
    {
      ProgressDialog localProgressDialog = (ProgressDialog)paramObject;
      this.pd = localProgressDialog;
      return;
    }
    if ((paramObject instanceof Activity))
    {
      Activity localActivity = (Activity)paramObject;
      this.act = localActivity;
      return;
    }
    if (!(paramObject instanceof View))
      return;
    View localView = (View)paramObject;
    this.view = localView;
  }

  private void dismiss(String paramString)
  {
    if (this.pd != null)
    {
      Context localContext = this.pd.getContext();
      AQuery localAQuery = new AQuery(localContext);
      ProgressDialog localProgressDialog = this.pd;
      AbstractAQuery localAbstractAQuery = localAQuery.dismiss(localProgressDialog);
    }
    if (this.act != null)
    {
      this.act.setProgressBarIndeterminateVisibility(false);
      this.act.setProgressBarVisibility(false);
    }
    if (this.pb != null)
    {
      this.pb.setTag(1090453505, paramString);
      this.pb.setVisibility(0);
    }
    Object localObject1 = this.pb;
    if (localObject1 == null)
      localObject1 = this.view;
    if (localObject1 == null)
      return;
    Object localObject2 = ((View)localObject1).getTag(1090453505);
    if ((localObject2 != null) && (!localObject2.equals(paramString)))
      return;
    ((View)localObject1).setTag(1090453505, null);
    if (this.pb == null)
      return;
    if (!this.pb.isIndeterminate())
      return;
    ((View)localObject1).setVisibility(8);
  }

  private void showProgress(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject == null)
      return;
    if ((paramObject instanceof View))
    {
      View localView = (View)paramObject;
      ProgressBar localProgressBar = null;
      if ((paramObject instanceof ProgressBar))
        localProgressBar = (ProgressBar)paramObject;
      if (paramBoolean)
      {
        localView.setTag(1090453505, paramString);
        localView.setVisibility(0);
        if (localProgressBar == null)
          return;
        localProgressBar.setProgress(0);
        localProgressBar.setMax(100);
        return;
      }
      Object localObject = localView.getTag(1090453505);
      if ((localObject != null) && (!localObject.equals(paramString)))
        return;
      localView.setTag(1090453505, null);
      if (localProgressBar == null)
        return;
      if (!localProgressBar.isIndeterminate())
        return;
      localView.setVisibility(8);
      return;
    }
    if ((paramObject instanceof Dialog))
    {
      Dialog localDialog = (Dialog)paramObject;
      Context localContext = localDialog.getContext();
      AQuery localAQuery = new AQuery(localContext);
      if (paramBoolean)
      {
        AbstractAQuery localAbstractAQuery1 = localAQuery.show(localDialog);
        return;
      }
      AbstractAQuery localAbstractAQuery2 = localAQuery.dismiss(localDialog);
      return;
    }
    if (!(paramObject instanceof Activity))
      return;
    Activity localActivity = (Activity)paramObject;
    localActivity.setProgressBarIndeterminateVisibility(paramBoolean);
    localActivity.setProgressBarVisibility(paramBoolean);
    if (!paramBoolean)
      return;
    localActivity.setProgress(0);
  }

  public void done()
  {
    if (this.pb != null)
    {
      ProgressBar localProgressBar = this.pb;
      int i = this.pb.getMax();
      localProgressBar.setProgress(i);
    }
    if (this.pd != null)
    {
      ProgressDialog localProgressDialog = this.pd;
      int j = this.pd.getMax();
      localProgressDialog.setProgress(j);
    }
    if (this.act == null)
      return;
    this.act.setProgress(9999);
  }

  public void hide(String paramString)
  {
    if (AQUtility.isUIThread())
    {
      dismiss(paramString);
      return;
    }
    this.url = paramString;
    AQUtility.post(this);
  }

  public void increment(int paramInt)
  {
    int i = 1;
    int j;
    label50: int k;
    if (this.pb != null)
    {
      ProgressBar localProgressBar = this.pb;
      if (this.unknown)
      {
        j = 1;
        localProgressBar.incrementProgressBy(j);
      }
    }
    else
    {
      if (this.pd != null)
      {
        ProgressDialog localProgressDialog = this.pd;
        if (!this.unknown)
          break label118;
        localProgressDialog.incrementProgressBy(i);
      }
      if (this.act == null)
        return;
      if (!this.unknown)
        break label123;
      k = this.current;
      int m = k + 1;
      this.current = m;
    }
    while (true)
    {
      if (k > 9999)
        k = 9999;
      this.act.setProgress(k);
      return;
      j = paramInt;
      break;
      label118: i = paramInt;
      break label50;
      label123: int n = this.current + paramInt;
      this.current = n;
      int i1 = this.current * 10000;
      int i2 = this.bytes;
      k = i1 / i2;
    }
  }

  public void reset()
  {
    if (this.pb != null)
    {
      this.pb.setProgress(0);
      this.pb.setMax(10000);
    }
    if (this.pd != null)
    {
      this.pd.setProgress(0);
      this.pd.setMax(10000);
    }
    if (this.act != null)
      this.act.setProgress(0);
    this.unknown = false;
    this.current = 0;
    this.bytes = 10000;
  }

  public void run()
  {
    String str = this.url;
    dismiss(str);
  }

  public void setBytes(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.unknown = true;
      paramInt = 10000;
    }
    this.bytes = paramInt;
    if (this.pb != null)
    {
      this.pb.setProgress(0);
      this.pb.setMax(paramInt);
    }
    if (this.pd == null)
      return;
    this.pd.setProgress(0);
    this.pd.setMax(paramInt);
  }

  public void show(String paramString)
  {
    reset();
    if (this.pd != null)
    {
      Context localContext = this.pd.getContext();
      AQuery localAQuery = new AQuery(localContext);
      ProgressDialog localProgressDialog = this.pd;
      AbstractAQuery localAbstractAQuery = localAQuery.show(localProgressDialog);
    }
    if (this.act != null)
    {
      this.act.setProgressBarIndeterminateVisibility(true);
      this.act.setProgressBarVisibility(true);
    }
    if (this.pb != null)
    {
      this.pb.setTag(1090453505, paramString);
      this.pb.setVisibility(0);
    }
    if (this.view == null)
      return;
    this.view.setTag(1090453505, paramString);
    this.view.setVisibility(0);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.Progress
 * JD-Core Version:    0.6.2
 */