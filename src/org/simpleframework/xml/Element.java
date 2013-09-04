package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@Element(data=false, name="", required=true, type=void.class))
@Retention(RetentionPolicy.RUNTIME)
public @interface Element
{
  public abstract boolean data();

  public abstract String name();

  public abstract boolean required();

  public abstract Class type();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.Element
 * JD-Core Version:    0.6.2
 */