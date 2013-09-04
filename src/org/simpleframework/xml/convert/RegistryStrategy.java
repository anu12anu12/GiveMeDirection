package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

public class RegistryStrategy
  implements Strategy
{
  private final Registry registry;
  private final Strategy strategy;

  public RegistryStrategy(Registry paramRegistry)
  {
    this(paramRegistry, localTreeStrategy);
  }

  public RegistryStrategy(Registry paramRegistry, Strategy paramStrategy)
  {
    this.registry = paramRegistry;
    this.strategy = paramStrategy;
  }

  private boolean isReference(Value paramValue)
  {
    if ((paramValue != null) && (paramValue.isReference()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private Converter lookup(Type paramType, Object paramObject)
    throws Exception
  {
    Class localClass = paramType.getType();
    if (paramObject != null)
      localClass = paramObject.getClass();
    return this.registry.lookup(localClass);
  }

  private Converter lookup(Type paramType, Value paramValue)
    throws Exception
  {
    Class localClass = paramType.getType();
    if (paramValue != null)
      localClass = paramValue.getType();
    return this.registry.lookup(localClass);
  }

  private Value read(Type paramType, NodeMap<InputNode> paramNodeMap, Value paramValue)
    throws Exception
  {
    Converter localConverter = lookup(paramType, paramValue);
    InputNode localInputNode = (InputNode)paramNodeMap.getNode();
    if (localConverter != null)
    {
      Object localObject = localConverter.read(localInputNode);
      if (paramValue != null)
        paramValue.setValue(localObject);
      paramValue = new Reference(paramValue, localObject);
    }
    return paramValue;
  }

  private boolean write(Type paramType, Object paramObject, NodeMap<OutputNode> paramNodeMap)
    throws Exception
  {
    Converter localConverter = lookup(paramType, paramObject);
    OutputNode localOutputNode = (OutputNode)paramNodeMap.getNode();
    if (localConverter != null)
      localConverter.write(localOutputNode, paramObject);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Value read(Type paramType, NodeMap<InputNode> paramNodeMap, Map paramMap)
    throws Exception
  {
    Value localValue = this.strategy.read(paramType, paramNodeMap, paramMap);
    if (isReference(localValue));
    while (true)
    {
      return localValue;
      localValue = read(paramType, paramNodeMap, localValue);
    }
  }

  public boolean write(Type paramType, Object paramObject, NodeMap<OutputNode> paramNodeMap, Map paramMap)
    throws Exception
  {
    boolean bool = this.strategy.write(paramType, paramObject, paramNodeMap, paramMap);
    if (!bool)
      bool = write(paramType, paramObject, paramNodeMap);
    return bool;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.RegistryStrategy
 * JD-Core Version:    0.6.2
 */