package org.simpleframework.xml.stream;

public abstract interface Node
{
  public abstract String getName();

  public abstract Node getParent();

  public abstract String getValue()
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Node
 * JD-Core Version:    0.6.2
 */