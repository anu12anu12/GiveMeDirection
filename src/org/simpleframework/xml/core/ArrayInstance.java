package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Value;

class ArrayInstance
  implements Instance
{
  private final int length;
  private final Class type;
  private final Value value;

  public ArrayInstance(Value paramValue)
  {
    int i = paramValue.getLength();
    this.length = i;
    Class localClass = paramValue.getType();
    this.type = localClass;
    this.value = paramValue;
  }

  public Object getInstance()
    throws Exception
  {
    Object localObject;
    if (this.value.isReference())
      localObject = this.value.getValue();
    while (true)
    {
      return localObject;
      Class localClass = this.type;
      int i = this.length;
      localObject = Array.newInstance(localClass, i);
      if (this.value != null)
        this.value.setValue(localObject);
    }
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isReference()
  {
    return this.value.isReference();
  }

  public Object setInstance(Object paramObject)
  {
    if (this.value != null)
      this.value.setValue(paramObject);
    return paramObject;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ArrayInstance
 * JD-Core Version:    0.6.2
 */