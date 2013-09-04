package com.hopstop.ClientModel;

import java.io.Serializable;

public class HopStopCity
  implements Serializable
{
  private static final long serialVersionUID = -380733279563914822L;
  private String cellGateway;
  private String[] defaultCounty;
  private String id;
  private String name;
  private String state;
  private String usePlaces;

  public String getCellGateway()
  {
    return this.cellGateway;
  }

  public String[] getDefaultCounty()
  {
    return this.defaultCounty;
  }

  public String getDefaultCountyString()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    int i = 0;
    while (true)
    {
      int j = this.defaultCounty.length;
      if (i >= j)
        return localStringBuffer1.toString();
      String str = this.defaultCounty[i];
      StringBuffer localStringBuffer2 = localStringBuffer1.append(str);
      i += 1;
    }
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public String getState()
  {
    return this.state;
  }

  public String getUsePlaces()
  {
    return this.usePlaces;
  }

  public void setCellGateway(String paramString)
  {
    this.cellGateway = paramString;
  }

  public void setDefaultCounty(String[] paramArrayOfString)
  {
    this.defaultCounty = paramArrayOfString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setState(String paramString)
  {
    this.state = paramString;
  }

  public void setUsePlaces(String paramString)
  {
    this.usePlaces = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.HopStopCity
 * JD-Core Version:    0.6.2
 */