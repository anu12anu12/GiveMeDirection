package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.OutputNode;

abstract interface Decorator
{
  public abstract void decorate(OutputNode paramOutputNode);

  public abstract void decorate(OutputNode paramOutputNode, Decorator paramDecorator);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Decorator
 * JD-Core Version:    0.6.2
 */