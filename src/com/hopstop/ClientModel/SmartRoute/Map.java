package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class Map
  implements Serializable
{

  @Element(name="Id")
  private int _id;

  public int getId()
  {
    return this._id;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.Map
 * JD-Core Version:    0.6.2
 */