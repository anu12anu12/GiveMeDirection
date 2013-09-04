package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class PrimitiveArray
  implements Converter
{
  private final Type entry;
  private final ArrayFactory factory;
  private final String parent;
  private final Primitive root;
  private final Type type;

  public PrimitiveArray(Context paramContext, Type paramType1, Type paramType2, String paramString)
  {
    ArrayFactory localArrayFactory = new ArrayFactory(paramContext, paramType1);
    this.factory = localArrayFactory;
    Primitive localPrimitive = new Primitive(paramContext, paramType2);
    this.root = localPrimitive;
    this.parent = paramString;
    this.entry = paramType2;
    this.type = paramType1;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    ArrayFactory localArrayFactory = this.factory;
    Type localType = this.entry;
    return localArrayFactory.setOverride(localType, paramObject, paramOutputNode);
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

  private void write(OutputNode paramOutputNode, Object paramObject, int paramInt)
    throws Exception
  {
    Object localObject = Array.get(paramObject, paramInt);
    if (localObject == null)
      return;
    if (isOverridden(paramOutputNode, localObject))
      return;
    this.root.write(paramOutputNode, localObject);
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
      Object localObject = this.root.read(localInputNode);
      Array.set(paramObject, j, localObject);
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
    while (true)
    {
      if (j >= i)
        return;
      String str = this.parent;
      OutputNode localOutputNode = paramOutputNode.getChild(str);
      if (localOutputNode == null)
        return;
      write(localOutputNode, paramObject, j);
      j += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveArray
 * JD-Core Version:    0.6.2
 */