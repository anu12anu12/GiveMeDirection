package org.simpleframework.xml.strategy;

class ObjectValue
  implements Value
{
  private Class type;
  private Object value;

  public ObjectValue(Class paramClass)
  {
    this.type = paramClass;
  }

  public int getLength()
  {
    return 0;
  }

  public Class getType()
  {
    return this.type;
  }

  public Object getValue()
  {
    return this.value;
  }

  public boolean isReference()
  {
    return false;
  }

  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.ObjectValue
 * JD-Core Version:    0.6.2
 */