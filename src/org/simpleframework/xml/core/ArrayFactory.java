package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Position;

class ArrayFactory extends Factory
{
  public ArrayFactory(Context paramContext, Type paramType)
  {
    super(paramContext, paramType);
  }

  private Class getComponentType()
    throws Exception
  {
    Class localClass = getType();
    if (!localClass.isArray())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass;
      Type localType = this.type;
      arrayOfObject[1] = localType;
      throw new InstantiationException("The %s not an array for %s", arrayOfObject);
    }
    return localClass.getComponentType();
  }

  private Instance getInstance(Value paramValue, Class paramClass)
    throws Exception
  {
    Class localClass = getComponentType();
    if (!localClass.isAssignableFrom(paramClass))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = paramClass;
      Type localType = this.type;
      arrayOfObject[2] = localType;
      throw new InstantiationException("Array of type %s cannot hold %s for %s", arrayOfObject);
    }
    return new ArrayInstance(paramValue);
  }

  public Object getInstance()
    throws Exception
  {
    Class localClass = getComponentType();
    if (localClass != null);
    for (Object localObject = Array.newInstance(localClass, 0); ; localObject = null)
      return localObject;
  }

  public Instance getInstance(InputNode paramInputNode)
    throws Exception
  {
    Position localPosition = paramInputNode.getPosition();
    Value localValue = getOverride(paramInputNode);
    if (localValue == null)
    {
      Object[] arrayOfObject = new Object[2];
      Type localType = this.type;
      arrayOfObject[0] = localType;
      arrayOfObject[1] = localPosition;
      throw new ElementException("Array length required for %s at %s", arrayOfObject);
    }
    Class localClass = localValue.getType();
    return getInstance(localValue, localClass);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ArrayFactory
 * JD-Core Version:    0.6.2
 */