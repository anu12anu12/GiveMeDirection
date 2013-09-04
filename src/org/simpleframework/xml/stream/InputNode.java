package org.simpleframework.xml.stream;

public abstract interface InputNode extends Node
{
  public abstract InputNode getAttribute(String paramString);

  public abstract NodeMap<InputNode> getAttributes();

  public abstract InputNode getNext()
    throws Exception;

  public abstract InputNode getNext(String paramString)
    throws Exception;

  public abstract InputNode getParent();

  public abstract Position getPosition();

  public abstract String getPrefix();

  public abstract String getReference();

  public abstract Object getSource();

  public abstract boolean isElement();

  public abstract boolean isEmpty()
    throws Exception;

  public abstract boolean isRoot();

  public abstract void skip()
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.InputNode
 * JD-Core Version:    0.6.2
 */