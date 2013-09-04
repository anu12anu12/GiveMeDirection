package org.simpleframework.xml.strategy;

class Reference
  implements Value
{
  private Class type;
  private Object value;

  public Reference(Object paramObject, Class paramClass)
  {
    this.value = paramObject;
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
    return true;
  }

  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Reference
 * JD-Core Version:    0.6.2
 */