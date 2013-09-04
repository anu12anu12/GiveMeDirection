package com.hopstop.ClientModel.Schedules;

import java.io.Serializable;

public class Map
  implements Serializable
{
  private boolean _has_id;
  private int _id;
  private String _name;

  public void deleteId()
  {
    this._has_id = false;
  }

  public int getId()
  {
    return this._id;
  }

  public String getName()
  {
    return this._name;
  }

  public boolean hasId()
  {
    return this._has_id;
  }

  public void setId(int paramInt)
  {
    this._id = paramInt;
    this._has_id = true;
  }

  public void setName(String paramString)
  {
    this._name = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Map
 * JD-Core Version:    0.6.2
 */