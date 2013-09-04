package org.simpleframework.xml.strategy;

import java.util.HashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

class ReadGraph extends HashMap
{
  private final String label;
  private final String length;
  private final Loader loader;
  private final String mark;
  private final String refer;

  public ReadGraph(Contract paramContract, Loader paramLoader)
  {
    String str1 = paramContract.getReference();
    this.refer = str1;
    String str2 = paramContract.getIdentity();
    this.mark = str2;
    String str3 = paramContract.getLength();
    this.length = str3;
    String str4 = paramContract.getLabel();
    this.label = str4;
    this.loader = paramLoader;
  }

  private Value readArray(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    String str = this.length;
    Node localNode = paramNodeMap.remove(str);
    int i = 0;
    if (localNode != null)
      i = Integer.parseInt(localNode.getValue());
    return new ArrayValue(paramClass, i);
  }

  private Value readInstance(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    String str1 = this.mark;
    Node localNode = paramNodeMap.remove(str1);
    if (localNode == null);
    String str2;
    for (Value localValue = readReference(paramType, paramClass, paramNodeMap); ; localValue = readValue(paramType, paramClass, paramNodeMap, str2))
    {
      return localValue;
      str2 = localNode.getValue();
      if (containsKey(str2))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = str2;
        throw new CycleException("Element '%s' already exists", arrayOfObject);
      }
    }
  }

  private Value readReference(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    String str1 = this.refer;
    Node localNode = paramNodeMap.remove(str1);
    if (localNode == null);
    Object localObject2;
    for (Object localObject1 = readValue(paramType, paramClass, paramNodeMap); ; localObject1 = new Reference(localObject2, paramClass))
    {
      return localObject1;
      String str2 = localNode.getValue();
      localObject2 = get(str2);
      if (!containsKey(str2))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = str2;
        throw new CycleException("Invalid reference '%s' found", arrayOfObject);
      }
    }
  }

  private Value readValue(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    if (paramType.getType().isArray());
    for (Object localObject = readArray(paramType, paramClass, paramNodeMap); ; localObject = new ObjectValue(paramClass))
      return localObject;
  }

  private Value readValue(Type paramType, Class paramClass, NodeMap paramNodeMap, String paramString)
    throws Exception
  {
    Object localObject = readValue(paramType, paramClass, paramNodeMap);
    if (paramString != null)
      localObject = new Allocate((Value)localObject, this, paramString);
    return localObject;
  }

  public Value read(Type paramType, NodeMap paramNodeMap)
    throws Exception
  {
    String str1 = this.label;
    Node localNode = paramNodeMap.remove(str1);
    Class localClass = paramType.getType();
    if (localClass.isArray())
      localClass = localClass.getComponentType();
    if (localNode != null)
    {
      String str2 = localNode.getValue();
      localClass = this.loader.load(str2);
    }
    return readInstance(paramType, localClass, paramNodeMap);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.ReadGraph
 * JD-Core Version:    0.6.2
 */