package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(name="phone", strict=false)
public class Phone
  implements Serializable
{

  @Element(name="description", required=false)
  private String _description;

  @Element(name="number", required=false)
  private Number _number;

  @Element(name="type", required=false)
  private String _type;

  @Commit
  private void build()
  {
    String str = getDescription();
  }

  public String getDescription()
  {
    return this._description;
  }

  public Number getNumber()
  {
    return this._number;
  }

  public String getType()
  {
    return this._type;
  }

  public void setDescription(String paramString)
  {
    this._description = paramString;
  }

  public void setNumber(Number paramNumber)
  {
    this._number = paramNumber;
  }

  public void setType(String paramString)
  {
    this._type = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.Phone
 * JD-Core Version:    0.6.2
 */