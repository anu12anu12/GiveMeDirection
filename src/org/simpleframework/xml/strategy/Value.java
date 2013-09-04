package org.simpleframework.xml.strategy;

public abstract interface Value
{
  public abstract int getLength();

  public abstract Class getType();

  public abstract Object getValue();

  public abstract boolean isReference();

  public abstract void setValue(Object paramObject);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Value
 * JD-Core Version:    0.6.2
 */