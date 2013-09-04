package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class InstanceFactory
{
  private final Cache<Constructor> cache;

  public InstanceFactory()
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
  }

  public Instance getInstance(Class paramClass)
  {
    return new ClassInstance(paramClass);
  }

  public Instance getInstance(Value paramValue)
  {
    return new ValueInstance(paramValue);
  }

  protected Object getObject(Class paramClass)
    throws Exception
  {
    Constructor localConstructor = (Constructor)this.cache.fetch(paramClass);
    if (localConstructor == null)
    {
      Class[] arrayOfClass = new Class[0];
      localConstructor = paramClass.getDeclaredConstructor(arrayOfClass);
      if (!localConstructor.isAccessible())
        localConstructor.setAccessible(true);
      this.cache.cache(paramClass, localConstructor);
    }
    Object[] arrayOfObject = new Object[0];
    return localConstructor.newInstance(arrayOfObject);
  }

  private class ClassInstance
    implements Instance
  {
    private Class type;
    private Object value;

    public ClassInstance(Class arg2)
    {
      Object localObject;
      this.type = localObject;
    }

    public Object getInstance()
      throws Exception
    {
      if (this.value == null)
      {
        InstanceFactory localInstanceFactory = InstanceFactory.this;
        Class localClass = this.type;
        Object localObject = localInstanceFactory.getObject(localClass);
        this.value = localObject;
      }
      return this.value;
    }

    public Class getType()
    {
      return this.type;
    }

    public boolean isReference()
    {
      return false;
    }

    public Object setInstance(Object paramObject)
      throws Exception
    {
      this.value = paramObject;
      return paramObject;
    }
  }

  private class ValueInstance
    implements Instance
  {
    private final Class type;
    private final Value value;

    public ValueInstance(Value arg2)
    {
      Object localObject;
      Class localClass = localObject.getType();
      this.type = localClass;
      this.value = localObject;
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
        InstanceFactory localInstanceFactory = InstanceFactory.this;
        Class localClass = this.type;
        localObject = localInstanceFactory.getObject(localClass);
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
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.InstanceFactory
 * JD-Core Version:    0.6.2
 */