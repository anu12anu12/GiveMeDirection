package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.IdentityHashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

class WriteGraph extends IdentityHashMap<Object, String>
{
  private final String label;
  private final String length;
  private final String mark;
  private final String refer;

  public WriteGraph(Contract paramContract)
  {
    String str1 = paramContract.getReference();
    this.refer = str1;
    String str2 = paramContract.getIdentity();
    this.mark = str2;
    String str3 = paramContract.getLength();
    this.length = str3;
    String str4 = paramContract.getLabel();
    this.label = str4;
  }

  private Class writeArray(Class paramClass, Object paramObject, NodeMap paramNodeMap)
  {
    int i = Array.getLength(paramObject);
    if (!containsKey(paramObject))
    {
      String str1 = this.length;
      String str2 = String.valueOf(i);
      Node localNode = paramNodeMap.put(str1, str2);
    }
    return paramClass.getComponentType();
  }

  private boolean writeReference(Object paramObject, NodeMap paramNodeMap)
  {
    String str1 = (String)get(paramObject);
    int i = size();
    if (str1 != null)
    {
      String str2 = this.refer;
      Node localNode1 = paramNodeMap.put(str2, str1);
    }
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      String str3 = String.valueOf(i);
      String str4 = this.mark;
      Node localNode2 = paramNodeMap.put(str4, str3);
      Object localObject = put(paramObject, str3);
    }
  }

  public boolean write(Type paramType, Object paramObject, NodeMap paramNodeMap)
  {
    Class localClass1 = paramObject.getClass();
    Class localClass2 = paramType.getType();
    Class localClass3 = localClass1;
    if (localClass1.isArray())
      localClass3 = writeArray(localClass1, paramObject, paramNodeMap);
    if (localClass1 != localClass2)
    {
      String str1 = this.label;
      String str2 = localClass3.getName();
      Node localNode = paramNodeMap.put(str1, str2);
    }
    return writeReference(paramObject, paramNodeMap);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.WriteGraph
 * JD-Core Version:    0.6.2
 */