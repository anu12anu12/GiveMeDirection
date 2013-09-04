package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class CompositeList
  implements Converter
{
  private final Type entry;
  private final CollectionFactory factory;
  private final String name;
  private final Traverser root;
  private final Type type;

  public CompositeList(Context paramContext, Type paramType1, Type paramType2, String paramString)
  {
    CollectionFactory localCollectionFactory = new CollectionFactory(paramContext, paramType1);
    this.factory = localCollectionFactory;
    Traverser localTraverser = new Traverser(paramContext);
    this.root = localTraverser;
    this.entry = paramType2;
    this.type = paramType1;
    this.name = paramString;
  }

  private Object populate(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      Class localClass = this.entry.getType();
      if (localInputNode == null)
        return localCollection;
      Object localObject = this.root.read(localInputNode, localClass);
      boolean bool = localCollection.add(localObject);
    }
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      Class localClass = this.entry.getType();
      if (localInputNode == null)
        return true;
      boolean bool = this.root.validate(localInputNode, localClass);
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
        Class localClass1 = this.entry.getType();
        Class localClass2 = localObject.getClass();
        if (!localClass1.isAssignableFrom(localClass2))
        {
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = localClass2;
          Type localType1 = this.entry;
          arrayOfObject[1] = localType1;
          Type localType2 = this.type;
          arrayOfObject[2] = localType2;
          throw new PersistenceException("Entry %s does not match %s for %s", arrayOfObject);
        }
        Traverser localTraverser = this.root;
        String str = this.name;
        localTraverser.write(paramOutputNode, localObject, localClass1, str);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeList
 * JD-Core Version:    0.6.2
 */