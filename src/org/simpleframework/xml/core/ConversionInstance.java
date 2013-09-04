package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

class ConversionInstance
  implements Instance
{
  private final Context context;
  private final Class convert;
  private final Value value;

  public ConversionInstance(Context paramContext, Value paramValue, Class paramClass)
    throws Exception
  {
    this.context = paramContext;
    this.convert = paramClass;
    this.value = paramValue;
  }

  public Object getInstance()
    throws Exception
  {
    Object localObject1;
    if (this.value.isReference())
      localObject1 = this.value.getValue();
    while (true)
    {
      return localObject1;
      Class localClass = this.convert;
      localObject1 = getInstance(localClass);
      if (localObject1 != null)
        Object localObject2 = setInstance(localObject1);
    }
  }

  public Object getInstance(Class paramClass)
    throws Exception
  {
    return this.context.getInstance(paramClass).getInstance();
  }

  public Class getType()
  {
    return this.convert;
  }

  public boolean isReference()
  {
    return this.value.isReference();
  }

  public Object setInstance(Object paramObject)
    throws Exception
  {
    if (this.value != null)
      this.value.setValue(paramObject);
    return paramObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ConversionInstance
 * JD-Core Version:    0.6.2
 */