package com.hopstop.ClientModel.SmartRoute;

import com.hopstop.ClientModel.ResponseStatus;
import java.util.ArrayList;
import java.util.Iterator;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.core.Commit;

public class SmartRoute
{

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus _responseStatus;

  @ElementList(name="ExtraRoutes", required=false)
  private ArrayList<ExtraRoute> extraRoutes;

  @Element(name="ExtraRoutesIdPrefix", required=false)
  private String extraRoutesIdPrefix;

  @Element(name="ExtraRoutesResumeData", required=false)
  private String extraRoutesResumeData;

  public SmartRoute()
  {
  }

  public SmartRoute(ArrayList<ExtraRoute> paramArrayList, String paramString1, String paramString2)
  {
    this.extraRoutes = paramArrayList;
    this.extraRoutesIdPrefix = paramString1;
    this.extraRoutesResumeData = paramString2;
    if (this.extraRoutes == null)
      return;
    if (this.extraRoutesIdPrefix == null)
      return;
    resetIds();
  }

  public void addExtraRoutes(ArrayList<ExtraRoute> paramArrayList)
  {
    boolean bool = this.extraRoutes.addAll(paramArrayList);
  }

  @Commit
  public void build()
  {
    resetIds();
  }

  public boolean empty()
  {
    boolean bool = true;
    if ((this.extraRoutes != null) && (this.extraRoutes.size() > 1))
      bool = false;
    return bool;
  }

  public ArrayList<ExtraRoute> getExtraRoutes()
  {
    return this.extraRoutes;
  }

  public String getExtraRoutesIdPrefix()
  {
    return this.extraRoutesIdPrefix;
  }

  public String getExtraRoutesResumeData()
  {
    return this.extraRoutesResumeData;
  }

  public ResponseStatus getResponseStatus()
  {
    return this._responseStatus;
  }

  public void resetIds()
  {
    Iterator localIterator = this.extraRoutes.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ExtraRoute localExtraRoute = (ExtraRoute)localIterator.next();
      String str1 = String.valueOf(this.extraRoutesIdPrefix);
      StringBuilder localStringBuilder = new StringBuilder(str1);
      String str2 = localExtraRoute.getId();
      String str3 = str2;
      localExtraRoute.setId(str3);
    }
  }

  public void setExtraRoutes(ArrayList<ExtraRoute> paramArrayList)
  {
    this.extraRoutes = paramArrayList;
  }

  public void setExtraRoutesIdPrefix(String paramString)
  {
    this.extraRoutesIdPrefix = paramString;
  }

  public void setExtraRoutesResumeData(String paramString)
  {
    this.extraRoutesResumeData = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.SmartRoute
 * JD-Core Version:    0.6.2
 */