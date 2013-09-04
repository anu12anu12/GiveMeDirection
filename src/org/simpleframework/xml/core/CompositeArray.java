package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class CompositeArray
  implements Converter
{
  private final Type entry;
  private final ArrayFactory factory;
  private final String parent;
  private final Traverser root;
  private final Type type;

  public CompositeArray(Context paramContext, Type paramType1, Type paramType2, String paramString)
  {
    ArrayFactory localArrayFactory = new ArrayFactory(paramContext, paramType1);
    this.factory = localArrayFactory;
    Traverser localTraverser = new Traverser(paramContext);
    this.root = localTraverser;
    this.parent = paramString;
    this.entry = paramType2;
    this.type = paramType1;
  }

  private void read(InputNode paramInputNode, Object paramObject, int paramInt)
    throws Exception
  {
    Class localClass = this.entry.getType();
    Object localObject = null;
    if (!paramInputNode.isEmpty())
      localObject = this.root.read(paramInputNode, localClass);
    Array.set(paramObject, paramInt, localObject);
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return true;
      if (!localInputNode.isEmpty())
        boolean bool = this.root.validate(localInputNode, paramClass);
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Object localObject = localInstance.getInstance();
    if (!localInstance.isReference())
      localObject = read(paramInputNode, localObject);
    return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    int i = Array.getLength(paramObject);
    int j = 0;
    while (true)
    {
      Position localPosition = paramInputNode.getPosition();
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return paramObject;
      if (j >= i)
      {
        Object[] arrayOfObject = new Object[2];
        Type localType = this.type;
        arrayOfObject[0] = localType;
        arrayOfObject[1] = localPosition;
        throw new ElementException("Array length missing or incorrect for %s at %s", arrayOfObject);
      }
      read(localInputNode, paramObject, j);
      j += 1;
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
    int i = Array.getLength(paramObject);
    int j = 0;
    while (j < i)
    {
      Object localObject = Array.get(paramObject, j);
      Class localClass = this.entry.getType();
      Traverser localTraverser = this.root;
      String str = this.parent;
      localTraverser.write(paramOutputNode, localObject, localClass, str);
      j += 1;
    }
    paramOutputNode.commit();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeArray
 * JD-Core Version:    0.6.2
 */