package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class MultiAddresses
  implements Serializable, Cloneable
{

  @Element(name="Id", required=false)
  private String _id;

  public String getId()
  {
    return this._id;
  }

  public void setId(String paramString)
  {
    this._id = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.MultiAddresses
 * JD-Core Version:    0.6.2
 */