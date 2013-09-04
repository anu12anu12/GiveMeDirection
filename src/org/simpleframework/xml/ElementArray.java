package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@ElementArray(data=false, empty=true, entry="", name="", required=true))
@Retention(RetentionPolicy.RUNTIME)
public @interface ElementArray
{
  public abstract boolean data();

  public abstract boolean empty();

  public abstract String entry();

  public abstract String name();

  public abstract boolean required();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.ElementArray
 * JD-Core Version:    0.6.2
 */