package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="list", strict=false)
public class List
  implements Serializable
{

  @Element(name="description", required=false)
  private String _description;
  private boolean _has_id;

  @Element(name="id", required=false)
  private short _id;

  @Element(name="name", required=false)
  private String _name;

  @Element(name="type", required=false)
  private String _type;

  public void deleteId()
  {
    this._has_id = false;
  }

  public String getDescription()
  {
    return this._description;
  }

  public short getId()
  {
    return this._id;
  }

  public String getName()
  {
    return this._name;
  }

  public String getType()
  {
    return this._type;
  }

  public boolean hasId()
  {
    return this._has_id;
  }

  public void setDescription(String paramString)
  {
    this._description = paramString;
  }

  public void setId(short paramShort)
  {
    this._id = paramShort;
    this._has_id = true;
  }

  public void setName(String paramString)
  {
    this._name = paramString;
  }

  public void setType(String paramString)
  {
    this._type = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.List
 * JD-Core Version:    0.6.2
 */