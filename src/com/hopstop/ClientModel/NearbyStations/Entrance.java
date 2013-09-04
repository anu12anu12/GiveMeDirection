package com.hopstop.ClientModel.NearbyStations;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class Entrance
  implements Serializable
{

  @Element(name="Open")
  private byte _open;

  public byte getOpen()
  {
    return this._open;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.NearbyStations.Entrance
 * JD-Core Version:    0.6.2
 */