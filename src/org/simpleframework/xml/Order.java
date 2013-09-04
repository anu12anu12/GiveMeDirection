package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@Order(attributes={}, elements={}))
@Retention(RetentionPolicy.RUNTIME)
public @interface Order
{
  public abstract String[] attributes();

  public abstract String[] elements();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.Order
 * JD-Core Version:    0.6.2
 */