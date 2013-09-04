package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;

public class TransitMaps
  implements Serializable
{
  private Map _map;

  public Map getMap()
  {
    return this._map;
  }

  public void setMap(Map paramMap)
  {
    this._map = paramMap;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.TransitMaps
 * JD-Core Version:    0.6.2
 */