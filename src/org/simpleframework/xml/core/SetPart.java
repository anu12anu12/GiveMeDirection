package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class SetPart
  implements MethodPart
{
  private final Cache<Annotation> cache;
  private final Annotation label;
  private final Annotation[] list;
  private final Method method;
  private final String name;
  private final MethodType type;

  public SetPart(MethodName paramMethodName, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
    Method localMethod = paramMethodName.getMethod();
    this.method = localMethod;
    String str = paramMethodName.getName();
    this.name = str;
    MethodType localMethodType = paramMethodName.getType();
    this.type = localMethodType;
    this.label = paramAnnotation;
    this.list = paramArrayOfAnnotation;
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    if (this.cache.isEmpty())
    {
      Annotation[] arrayOfAnnotation = this.list;
      int i = arrayOfAnnotation.length;
      int j = 0;
      while (j < i)
      {
        Annotation localAnnotation = arrayOfAnnotation[j];
        Class localClass = localAnnotation.annotationType();
        this.cache.cache(localClass, localAnnotation);
        j += 1;
      }
    }
    return (Annotation)this.cache.fetch(paramClass);
  }

  public Class getDeclaringClass()
  {
    return this.method.getDeclaringClass();
  }

  public Class getDependent()
  {
    return Reflector.getParameterDependent(this.method, 0);
  }

  public Class[] getDependents()
  {
    return Reflector.getParameterDependents(this.method, 0);
  }

  public Method getMethod()
  {
    if (!this.method.isAccessible())
      this.method.setAccessible(true);
    return this.method;
  }

  public MethodType getMethodType()
  {
    return this.type;
  }

  public String getName()
  {
    return this.name;
  }

  public Class getType()
  {
    return this.method.getParameterTypes()[0];
  }

  public String toString()
  {
    return this.method.toGenericString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SetPart
 * JD-Core Version:    0.6.2
 */