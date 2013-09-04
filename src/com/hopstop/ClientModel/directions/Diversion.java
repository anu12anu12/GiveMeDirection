package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Diversion
  implements Serializable, Cloneable
{

  @Element(name="Description", required=false)
  private String _description;

  @Element(name="Icon", required=false)
  private Icon _icon;

  @Element(name="Id", required=false)
  private String _id;

  @Element(name="Name", required=false)
  private String _name;

  public String getDescription()
  {
    return this._description;
  }

  public Icon getIcon()
  {
    return this._icon;
  }

  public String getId()
  {
    return this._id;
  }

  public String getName()
  {
    return this._name;
  }

  public void setDescription(String paramString)
  {
    this._description = paramString;
  }

  public void setIcon(Icon paramIcon)
  {
    this._icon = paramIcon;
  }

  public void setId(String paramString)
  {
    this._id = paramString;
  }

  public void setName(String paramString)
  {
    this._name = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.Diversion
 * JD-Core Version:    0.6.2
 */