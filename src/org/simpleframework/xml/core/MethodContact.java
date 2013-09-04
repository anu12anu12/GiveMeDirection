package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class MethodContact
  implements Contact
{
  private MethodPart get;
  private Class item;
  private Class[] items;
  private Annotation label;
  private String name;
  private Class owner;
  private MethodPart set;
  private Class type;

  public MethodContact(MethodPart paramMethodPart)
  {
    this(paramMethodPart, null);
  }

  public MethodContact(MethodPart paramMethodPart1, MethodPart paramMethodPart2)
  {
    Class localClass1 = paramMethodPart1.getDeclaringClass();
    this.owner = localClass1;
    Annotation localAnnotation = paramMethodPart1.getAnnotation();
    this.label = localAnnotation;
    Class[] arrayOfClass = paramMethodPart1.getDependents();
    this.items = arrayOfClass;
    Class localClass2 = paramMethodPart1.getDependent();
    this.item = localClass2;
    Class localClass3 = paramMethodPart1.getType();
    this.type = localClass3;
    String str = paramMethodPart1.getName();
    this.name = str;
    this.set = paramMethodPart2;
    this.get = paramMethodPart1;
  }

  public Object get(Object paramObject)
    throws Exception
  {
    Method localMethod = this.get.getMethod();
    Object[] arrayOfObject = new Object[0];
    return localMethod.invoke(paramObject, arrayOfObject);
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Annotation localAnnotation = this.get.getAnnotation(paramClass);
    Class localClass = this.label.annotationType();
    if (paramClass == localClass);
    for (localAnnotation = this.label; ; localAnnotation = this.set.getAnnotation(paramClass))
      do
        return localAnnotation;
      while ((localAnnotation != null) || (this.set == null));
  }

  public Class getDeclaringClass()
  {
    return this.owner;
  }

  public Class getDependent()
  {
    return this.item;
  }

  public Class[] getDependents()
  {
    return this.items;
  }

  public String getName()
  {
    return this.name;
  }

  public MethodPart getRead()
  {
    return this.get;
  }

  public Class getType()
  {
    return this.type;
  }

  public MethodPart getWrite()
  {
    return this.set;
  }

  public boolean isReadOnly()
  {
    if (this.set == null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void set(Object paramObject1, Object paramObject2)
    throws Exception
  {
    Class localClass = this.get.getMethod().getDeclaringClass();
    if (this.set == null)
    {
      Object[] arrayOfObject1 = new Object[2];
      String str = this.name;
      arrayOfObject1[0] = str;
      arrayOfObject1[1] = localClass;
      throw new MethodException("Property '%s' is read only in %s", arrayOfObject1);
    }
    Method localMethod = this.set.getMethod();
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = paramObject2;
    Object localObject = localMethod.invoke(paramObject1, arrayOfObject2);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    String str = this.name;
    arrayOfObject[0] = str;
    return String.format("method '%s'", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodContact
 * JD-Core Version:    0.6.2
 */