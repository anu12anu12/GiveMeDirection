package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

public abstract interface Strategy
{
  public abstract Value read(Type paramType, NodeMap<InputNode> paramNodeMap, Map paramMap)
    throws Exception;

  public abstract boolean write(Type paramType, Object paramObject, NodeMap<OutputNode> paramNodeMap, Map paramMap)
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Strategy
 * JD-Core Version:    0.6.2
 */