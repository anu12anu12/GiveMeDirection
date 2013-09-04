package com.hopstop.ClientModel;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="ResponseStatus", strict=false)
public class ResponseStatus
  implements Serializable, Cloneable
{

  @Element(name="FaultCode", required=false)
  private int faultCode;

  @Element(name="FaultString", required=false)
  private String faultString;

  @Element(name="ResultCode", required=false)
  private int resultCode;

  @Element(name="ResultString", required=false)
  private String resultString;

  public String getErrorString()
  {
    if (this.faultString != null);
    for (String str = this.faultString; ; str = this.resultString)
      return str;
  }

  public String getFaultString()
  {
    return this.faultString;
  }

  public int getResultCode()
  {
    if ((this.resultCode == 0) && (this.faultCode != 0));
    for (int i = this.faultCode; ; i = this.resultCode)
      return i;
  }

  public String getResultString()
  {
    return this.resultString;
  }

  public boolean isSuccess()
  {
    boolean bool = true;
    if ((this != null) && ((this.resultCode == 200) || (this.resultCode == 202)));
    while (true)
    {
      return bool;
      if (this.faultString != null)
        bool = false;
    }
  }

  public void setFaultString(String paramString)
  {
    this.faultString = paramString;
  }

  public void setResultCode(int paramInt)
  {
    this.resultCode = paramInt;
  }

  public void setResultString(String paramString)
  {
    this.resultString = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.ResponseStatus
 * JD-Core Version:    0.6.2
 */