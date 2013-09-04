package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

abstract class ParameterContact<T extends Annotation>
  implements Contact
{
  protected final Constructor factory;
  protected final int index;
  protected final T label;
  protected final Annotation[] labels;
  protected final Class owner;

  public ParameterContact(T paramT, Constructor paramConstructor, int paramInt)
  {
    Annotation[] arrayOfAnnotation = paramConstructor.getParameterAnnotations()[paramInt];
    this.labels = arrayOfAnnotation;
    Class localClass = paramConstructor.getDeclaringClass();
    this.owner = localClass;
    this.factory = paramConstructor;
    this.index = paramInt;
    this.label = paramT;
  }

  public Object get(Object paramObject)
  {
    return null;
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    Annotation[] arrayOfAnnotation = this.labels;
    int i = arrayOfAnnotation.length;
    int j = 0;
    Annotation localAnnotation;
    if (j < i)
    {
      localAnnotation = arrayOfAnnotation[j];
      if (!localAnnotation.annotationType().equals(paramClass));
    }
    while (true)
    {
      return localAnnotation;
      j += 1;
      break;
      localAnnotation = null;
    }
  }

  public Class getDeclaringClass()
  {
    return this.owner;
  }

  public Class getDependent()
  {
    Constructor localConstructor = this.factory;
    int i = this.index;
    return Reflector.getParameterDependent(localConstructor, i);
  }

  public Class[] getDependents()
  {
    Constructor localConstructor = this.factory;
    int i = this.index;
    return Reflector.getParameterDependents(localConstructor, i);
  }

  public abstract String getName();

  public Class getType()
  {
    Class[] arrayOfClass = this.factory.getParameterTypes();
    int i = this.index;
    return arrayOfClass[i];
  }

  public boolean isReadOnly()
  {
    return false;
  }

  public void set(Object paramObject1, Object paramObject2)
  {
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    Integer localInteger = Integer.valueOf(this.index);
    arrayOfObject[0] = localInteger;
    Constructor localConstructor = this.factory;
    arrayOfObject[1] = localConstructor;
    return String.format("parameter %s of constructor %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ParameterContact
 * JD-Core Version:    0.6.2
 */