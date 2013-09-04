package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class CompositeInlineList
  implements Repeater
{
  private final Type entry;
  private final CollectionFactory factory;
  private final String name;
  private final Traverser root;
  private final Type type;

  public CompositeInlineList(Context paramContext, Type paramType1, Type paramType2, String paramString)
  {
    CollectionFactory localCollectionFactory = new CollectionFactory(paramContext, paramType1);
    this.factory = localCollectionFactory;
    Traverser localTraverser = new Traverser(paramContext);
    this.root = localTraverser;
    this.entry = paramType2;
    this.type = paramType1;
    this.name = paramString;
  }

  private Object read(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    Object localObject = this.root.read(paramInputNode, paramClass);
    Class localClass = localObject.getClass();
    if (!this.entry.getType().isAssignableFrom(localClass))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localClass;
      Type localType1 = this.entry;
      arrayOfObject[1] = localType1;
      Type localType2 = this.type;
      arrayOfObject[2] = localType2;
      throw new PersistenceException("Entry %s does not match %s for %s", arrayOfObject);
    }
    return localObject;
  }

  private Object read(InputNode paramInputNode, Collection paramCollection)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      Class localClass = this.entry.getType();
      Object localObject = read(paramInputNode, localClass);
      if (localObject != null)
        boolean bool = paramCollection.add(localObject);
      paramInputNode = localInputNode.getNext(str);
    }
    return paramCollection;
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Collection localCollection = (Collection)this.factory.getInstance();
    if (localCollection != null);
    for (Object localObject = read(paramInputNode, localCollection); ; localObject = null)
      return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    if (localCollection != null);
    for (Object localObject = read(paramInputNode, localCollection); ; localObject = read(paramInputNode))
      return localObject;
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    Class localClass = this.entry.getType();
    String str = paramInputNode.getName();
    if (paramInputNode != null)
      if (this.root.validate(paramInputNode, localClass));
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      paramInputNode = localInputNode.getNext(str);
      break;
    }
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    OutputNode localOutputNode = paramOutputNode.getParent();
    if (!paramOutputNode.isCommitted())
      paramOutputNode.remove();
    write(localOutputNode, localCollection);
  }

  public void write(OutputNode paramOutputNode, Collection paramCollection)
    throws Exception
  {
    Iterator localIterator = paramCollection.iterator();
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
          arrayOfObject[1] = localClass1;
          Type localType = this.type;
          arrayOfObject[2] = localType;
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
 * Qualified Name:     org.simpleframework.xml.core.CompositeInlineList
 * JD-Core Version:    0.6.2
 */