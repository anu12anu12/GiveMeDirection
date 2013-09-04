package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class TextList
  implements Repeater
{
  private final CollectionFactory factory;
  private final Primitive primitive;
  private final Type type;

  public TextList(Context paramContext, Type paramType, Label paramLabel)
  {
    ClassType localClassType = new ClassType(String.class);
    this.type = localClassType;
    CollectionFactory localCollectionFactory = new CollectionFactory(paramContext, paramType);
    this.factory = localCollectionFactory;
    Type localType = this.type;
    Primitive localPrimitive = new Primitive(paramContext, localType);
    this.primitive = localPrimitive;
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Object localObject1 = localInstance.getInstance();
    if (localInstance.isReference());
    for (Object localObject2 = localInstance.getInstance(); ; localObject2 = read(paramInputNode, localObject1))
      return localObject2;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    Object localObject = this.primitive.read(paramInputNode);
    if (localObject != null)
      boolean bool = localCollection.add(localObject);
    return paramObject;
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    return true;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    OutputNode localOutputNode = paramOutputNode.getParent();
    Iterator localIterator = localCollection.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Object localObject = localIterator.next();
      this.primitive.write(localOutputNode, localObject);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TextList
 * JD-Core Version:    0.6.2
 */