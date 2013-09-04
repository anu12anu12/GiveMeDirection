package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.Map;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

public class TreeStrategy
  implements Strategy
{
  private final String label;
  private final String length;
  private final Loader loader;

  public TreeStrategy()
  {
    this("class", "length");
  }

  public TreeStrategy(String paramString1, String paramString2)
  {
    Loader localLoader = new Loader();
    this.loader = localLoader;
    this.length = paramString2;
    this.label = paramString1;
  }

  private Value readArray(Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    String str = this.length;
    Node localNode = paramNodeMap.remove(str);
    int i = 0;
    if (localNode != null)
      i = Integer.parseInt(localNode.getValue());
    return new ArrayValue(paramClass, i);
  }

  private Class readValue(Type paramType, NodeMap paramNodeMap)
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
    return localClass;
  }

  private Class writeArray(Class paramClass, Object paramObject, NodeMap paramNodeMap)
  {
    int i = Array.getLength(paramObject);
    if (this.length != null)
    {
      String str1 = this.length;
      String str2 = String.valueOf(i);
      Node localNode = paramNodeMap.put(str1, str2);
    }
    return paramClass.getComponentType();
  }

  public Value read(Type paramType, NodeMap paramNodeMap, Map paramMap)
    throws Exception
  {
    Class localClass1 = readValue(paramType, paramNodeMap);
    Class localClass2 = paramType.getType();
    Object localObject;
    if (localClass2.isArray())
      localObject = readArray(localClass1, paramNodeMap);
    while (true)
    {
      return localObject;
      if (localClass2 != localClass1)
        localObject = new ObjectValue(localClass1);
      else
        localObject = null;
    }
  }

  public boolean write(Type paramType, Object paramObject, NodeMap paramNodeMap, Map paramMap)
  {
    Class localClass1 = paramObject.getClass();
    Class localClass2 = paramType.getType();
    Class localClass3 = localClass1;
    if (localClass1.isArray())
      localClass3 = writeArray(localClass2, paramObject, paramNodeMap);
    if (localClass1 != localClass2)
    {
      String str1 = this.label;
      String str2 = localClass3.getName();
      Node localNode = paramNodeMap.put(str1, str2);
    }
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.TreeStrategy
 * JD-Core Version:    0.6.2
 */