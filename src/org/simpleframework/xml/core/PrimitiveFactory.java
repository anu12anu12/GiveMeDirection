package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

class PrimitiveFactory extends Factory
{
  public PrimitiveFactory(Context paramContext, Type paramType)
  {
    super(paramContext, paramType);
  }

  public PrimitiveFactory(Context paramContext, Type paramType, Class paramClass)
  {
    super(paramContext, paramType, paramClass);
  }

  public Object getInstance(String paramString, Class paramClass)
    throws Exception
  {
    return this.support.read(paramString, paramClass);
  }

  public Instance getInstance(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = getOverride(paramInputNode);
    Class localClass = getType();
    if (localValue == null);
    Context localContext;
    for (Object localObject = this.context.getInstance(localClass); ; localObject = new ObjectInstance(localContext, localValue))
    {
      return localObject;
      localContext = this.context;
    }
  }

  public String getText(Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    if (localClass.isEnum());
    for (String str = this.support.write(paramObject, localClass); ; str = this.support.write(paramObject, localClass))
      return str;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveFactory
 * JD-Core Version:    0.6.2
 */