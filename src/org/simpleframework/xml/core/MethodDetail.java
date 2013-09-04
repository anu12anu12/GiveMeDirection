package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class MethodDetail
{
  private final Annotation[] list;
  private final Method method;
  private final String name;

  public MethodDetail(Method paramMethod)
  {
    Annotation[] arrayOfAnnotation = paramMethod.getDeclaredAnnotations();
    this.list = arrayOfAnnotation;
    String str = paramMethod.getName();
    this.name = str;
    this.method = paramMethod;
  }

  public Annotation[] getAnnotations()
  {
    return this.list;
  }

  public Method getMethod()
  {
    return this.method;
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodDetail
 * JD-Core Version:    0.6.2
 */