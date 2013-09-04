package org.simpleframework.xml.convert;

import org.simpleframework.xml.strategy.Value;

class Reference
  implements Value
{
  private Object data;
  private Value value;

  public Reference(Value paramValue, Object paramObject)
  {
    this.value = paramValue;
    this.data = paramObject;
  }

  public int getLength()
  {
    return 0;
  }

  public Class getType()
  {
    return this.data.getClass();
  }

  public Object getValue()
  {
    return this.data;
  }

  public boolean isReference()
  {
    return true;
  }

  public void setValue(Object paramObject)
  {
    if (this.value != null)
      this.value.setValue(paramObject);
    this.data = paramObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.Reference
 * JD-Core Version:    0.6.2
 */