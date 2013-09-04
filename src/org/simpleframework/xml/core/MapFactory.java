package org.simpleframework.xml.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

class MapFactory extends Factory
{
  public MapFactory(Context paramContext, Type paramType)
  {
    super(paramContext, paramType);
  }

  private boolean isMap(Class paramClass)
  {
    return Map.class.isAssignableFrom(paramClass);
  }

  public Class getConversion(Class paramClass)
    throws Exception
  {
    if (paramClass.isAssignableFrom(HashMap.class));
    for (Object localObject = HashMap.class; ; localObject = TreeMap.class)
    {
      return localObject;
      if (!paramClass.isAssignableFrom(TreeMap.class))
        break;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramClass;
    Type localType = this.type;
    arrayOfObject[1] = localType;
    throw new InstantiationException("Cannot instantiate %s for %s", arrayOfObject);
  }

  public Object getInstance()
    throws Exception
  {
    Class localClass1 = getType();
    Class localClass2 = localClass1;
    if (!isInstantiable(localClass2))
      localClass2 = getConversion(localClass1);
    if (!isMap(localClass2))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass1;
      Type localType = this.type;
      arrayOfObject[1] = localType;
      throw new InstantiationException("Invalid map %s for %s", arrayOfObject);
    }
    return localClass2.newInstance();
  }

  public Instance getInstance(Value paramValue)
    throws Exception
  {
    Class localClass = paramValue.getType();
    if (!isInstantiable(localClass))
      localClass = getConversion(localClass);
    if (!isMap(localClass))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass;
      Type localType = this.type;
      arrayOfObject[1] = localType;
      throw new InstantiationException("Invalid map %s for %s", arrayOfObject);
    }
    Context localContext = this.context;
    return new ConversionInstance(localContext, paramValue, localClass);
  }

  public Instance getInstance(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = getOverride(paramInputNode);
    Class localClass = getType();
    if (localValue != null);
    for (Instance localInstance = getInstance(localValue); ; localInstance = this.context.getInstance(localClass))
    {
      return localInstance;
      if (!isInstantiable(localClass))
        localClass = getConversion(localClass);
      if (!isMap(localClass))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localClass;
        Type localType = this.type;
        arrayOfObject[1] = localType;
        throw new InstantiationException("Invalid map %s for %s", arrayOfObject);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MapFactory
 * JD-Core Version:    0.6.2
 */