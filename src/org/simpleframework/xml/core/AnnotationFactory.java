package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;

class AnnotationFactory
{
  private final boolean required;

  public AnnotationFactory(Detail paramDetail)
  {
    boolean bool = paramDetail.isRequired();
    this.required = bool;
  }

  private ClassLoader getClassLoader()
    throws Exception
  {
    return AnnotationFactory.class.getClassLoader();
  }

  private Annotation getInstance(ClassLoader paramClassLoader, Class paramClass)
    throws Exception
  {
    boolean bool = this.required;
    AnnotationHandler localAnnotationHandler = new AnnotationHandler(paramClass, bool);
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = paramClass;
    return (Annotation)Proxy.newProxyInstance(paramClassLoader, arrayOfClass, localAnnotationHandler);
  }

  public Annotation getInstance(Class paramClass)
    throws Exception
  {
    ClassLoader localClassLoader = getClassLoader();
    Annotation localAnnotation;
    if (Map.class.isAssignableFrom(paramClass))
      localAnnotation = getInstance(localClassLoader, ElementMap.class);
    while (true)
    {
      return localAnnotation;
      if (Collection.class.isAssignableFrom(paramClass))
        localAnnotation = getInstance(localClassLoader, ElementList.class);
      else if (paramClass.isArray())
        localAnnotation = getInstance(localClassLoader, ElementArray.class);
      else
        localAnnotation = getInstance(localClassLoader, Element.class);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.AnnotationFactory
 * JD-Core Version:    0.6.2
 */