package org.simpleframework.xml.core;

import java.lang.reflect.Modifier;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

abstract class Factory
{
  protected Context context;
  protected Class override;
  protected Support support;
  protected Type type;

  protected Factory(Context paramContext, Type paramType)
  {
    this(paramContext, paramType, null);
  }

  protected Factory(Context paramContext, Type paramType, Class paramClass)
  {
    Support localSupport = paramContext.getSupport();
    this.support = localSupport;
    this.override = paramClass;
    this.context = paramContext;
    this.type = paramType;
  }

  private Type getPrimitive(Type paramType, Class paramClass)
    throws Exception
  {
    Support localSupport = this.support;
    Class localClass = Support.getPrimitive(paramClass);
    if (localClass != paramClass)
      paramType = new OverrideType(paramType, localClass);
    return paramType;
  }

  public static boolean isCompatible(Class paramClass1, Class paramClass2)
  {
    if (paramClass1.isArray())
      paramClass1 = paramClass1.getComponentType();
    return paramClass1.isAssignableFrom(paramClass2);
  }

  public static boolean isInstantiable(Class paramClass)
  {
    boolean bool = false;
    int i = paramClass.getModifiers();
    if (Modifier.isAbstract(i));
    while (true)
    {
      return bool;
      if (!Modifier.isInterface(i))
        bool = true;
    }
  }

  public Value getConversion(InputNode paramInputNode)
    throws Exception
  {
    Context localContext = this.context;
    Type localType = this.type;
    Object localObject = localContext.getOverride(localType, paramInputNode);
    if ((localObject != null) && (this.override != null))
    {
      Class localClass1 = ((Value)localObject).getType();
      if (!isCompatible(this.override, localClass1))
      {
        Class localClass2 = this.override;
        localObject = new OverrideValue((Value)localObject, localClass2);
      }
    }
    return localObject;
  }

  public Object getInstance()
    throws Exception
  {
    Class localClass = getType();
    if (!isInstantiable(localClass))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localClass;
      throw new InstantiationException("Type %s can not be instantiated", arrayOfObject);
    }
    return localClass.newInstance();
  }

  protected Value getOverride(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = getConversion(paramInputNode);
    if (localValue != null)
    {
      Position localPosition = paramInputNode.getPosition();
      Class localClass = localValue.getType();
      if (!isCompatible(getType(), localClass))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = localClass;
        Type localType = this.type;
        arrayOfObject[1] = localType;
        arrayOfObject[2] = localPosition;
        throw new InstantiationException("Incompatible %s for %s at %s", arrayOfObject);
      }
    }
    return localValue;
  }

  public Class getType()
  {
    if (this.override != null);
    for (Class localClass = this.override; ; localClass = this.type.getType())
      return localClass;
  }

  public boolean setOverride(Type paramType, Object paramObject, OutputNode paramOutputNode)
    throws Exception
  {
    Class localClass = paramType.getType();
    if (localClass.isPrimitive())
      paramType = getPrimitive(paramType, localClass);
    return this.context.setOverride(paramType, paramObject, paramOutputNode);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Factory
 * JD-Core Version:    0.6.2
 */