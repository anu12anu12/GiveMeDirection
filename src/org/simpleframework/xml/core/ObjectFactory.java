package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

class ObjectFactory extends PrimitiveFactory
{
  public ObjectFactory(Context paramContext, Type paramType, Class paramClass)
  {
    super(paramContext, paramType, paramClass);
  }

  public Instance getInstance(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = getOverride(paramInputNode);
    Class localClass = getType();
    if (localValue == null)
      if (!isInstantiable(localClass))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localClass;
        Type localType = this.type;
        arrayOfObject[1] = localType;
        throw new InstantiationException("Cannot instantiate %s for %s", arrayOfObject);
      }
    Context localContext;
    for (Object localObject = this.context.getInstance(localClass); ; localObject = new ObjectInstance(localContext, localValue))
    {
      return localObject;
      localContext = this.context;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ObjectFactory
 * JD-Core Version:    0.6.2
 */