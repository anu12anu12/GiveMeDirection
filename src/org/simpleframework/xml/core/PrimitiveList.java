package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class PrimitiveList
  implements Converter
{
  private final Type entry;
  private final CollectionFactory factory;
  private final String parent;
  private final Primitive root;

  public PrimitiveList(Context paramContext, Type paramType1, Type paramType2, String paramString)
  {
    CollectionFactory localCollectionFactory = new CollectionFactory(paramContext, paramType1);
    this.factory = localCollectionFactory;
    Primitive localPrimitive = new Primitive(paramContext, paramType2);
    this.root = localPrimitive;
    this.parent = paramString;
    this.entry = paramType2;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    CollectionFactory localCollectionFactory = this.factory;
    Type localType = this.entry;
    return localCollectionFactory.setOverride(localType, paramObject, paramOutputNode);
  }

  private Object populate(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return localCollection;
      Object localObject = this.root.read(localInputNode);
      boolean bool = localCollection.add(localObject);
    }
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return true;
      boolean bool = this.root.validate(localInputNode);
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Object localObject = localInstance.getInstance();
    if (!localInstance.isReference())
      localObject = populate(paramInputNode, localObject);
    return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (localInstance.isReference())
      paramObject = localInstance.getInstance();
    while (true)
    {
      return paramObject;
      Object localObject = localInstance.setInstance(paramObject);
      if (paramObject != null)
        paramObject = populate(paramInputNode, paramObject);
    }
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Class localClass;
    if (!localInstance.isReference())
    {
      Object localObject = localInstance.setInstance(null);
      localClass = localInstance.getType();
    }
    for (boolean bool = validate(paramInputNode, localClass); ; bool = true)
      return bool;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Iterator localIterator = ((Collection)paramObject).iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Object localObject = localIterator.next();
      if (localObject != null)
      {
        String str = this.parent;
        OutputNode localOutputNode = paramOutputNode.getChild(str);
        if (!isOverridden(localOutputNode, localObject))
          this.root.write(localOutputNode, localObject);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveList
 * JD-Core Version:    0.6.2
 */