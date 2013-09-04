package org.simpleframework.xml.strategy;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

public abstract interface Visitor
{
  public abstract void read(Type paramType, NodeMap<InputNode> paramNodeMap)
    throws Exception;

  public abstract void write(Type paramType, NodeMap<OutputNode> paramNodeMap)
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Visitor
 * JD-Core Version:    0.6.2
 */