package com.hopstop.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ChevronImageView extends ImageView
{
  private String reroute;
  private String[] rerouteAll;
  private String url;
  private String useAnotherStop;
  private String useAnotherTransfer;

  public ChevronImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public String getReroute()
  {
    return this.reroute;
  }

  public String[] getRerouteAll()
  {
    return this.rerouteAll;
  }

  public String getRouteURL()
  {
    return this.url;
  }

  public String getUseAnotherStop()
  {
    return this.useAnotherStop;
  }

  public String getUseAnotherTransfer()
  {
    return this.useAnotherTransfer;
  }

  public void setReroute(String paramString)
  {
    this.reroute = paramString;
  }

  public void setRerouteAll(String[] paramArrayOfString)
  {
    this.rerouteAll = paramArrayOfString;
  }

  public void setUseAnotherStop(String paramString)
  {
    this.useAnotherStop = paramString;
  }

  public void setUseAnotherTransfer(String paramString)
  {
    this.useAnotherTransfer = paramString;
  }

  public void updatedURL(String paramString)
  {
    this.url = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.ChevronImageView
 * JD-Core Version:    0.6.2
 */