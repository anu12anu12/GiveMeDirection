package org.simpleframework.xml.stream;

abstract interface Attribute
{
  public abstract String getName();

  public abstract String getPrefix();

  public abstract String getReference();

  public abstract Object getSource();

  public abstract String getValue();

  public abstract boolean isReserved();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Attribute
 * JD-Core Version:    0.6.2
 */