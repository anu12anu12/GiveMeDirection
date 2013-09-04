package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;

class PrimitiveInlineList
  implements Repeater
{
  private final Type entry;
  private final CollectionFactory factory;
  private final String parent;
  private final Primitive root;

  public PrimitiveInlineList(Context paramContext, Type paramType1, Type paramType2, String paramString)
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

  private Object read(InputNode paramInputNode, Collection paramCollection)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      Object localObject = this.root.read(paramInputNode);
      if (localObject != null)
        boolean bool = paramCollection.add(localObject);
      paramInputNode = localInputNode.getNext(str);
    }
    return paramCollection;
  }

  private void write(OutputNode paramOutputNode, Object paramObject, Mode paramMode)
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
        {
          localOutputNode.setMode(paramMode);
          this.root.write(localOutputNode, localObject);
        }
      }
    }
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
    String str = paramInputNode.getName();
    if (paramInputNode != null)
      if (this.root.validate(paramInputNode));
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
    OutputNode localOutputNode = paramOutputNode.getParent();
    Mode localMode = paramOutputNode.getMode();
    if (!paramOutputNode.isCommitted())
      paramOutputNode.remove();
    write(localOutputNode, paramObject, localMode);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveInlineList
 * JD-Core Version:    0.6.2
 */