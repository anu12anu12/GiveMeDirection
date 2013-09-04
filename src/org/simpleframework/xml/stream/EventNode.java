package org.simpleframework.xml.stream;

abstract interface EventNode extends Iterable<Attribute>
{
  public abstract int getLine();

  public abstract String getName();

  public abstract String getPrefix();

  public abstract String getReference();

  public abstract Object getSource();

  public abstract String getValue();

  public abstract boolean isEnd();

  public abstract boolean isStart();

  public abstract boolean isText();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventNode
 * JD-Core Version:    0.6.2
 */