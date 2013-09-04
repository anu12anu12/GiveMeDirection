package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@Root(name="", strict=true))
@Retention(RetentionPolicy.RUNTIME)
public @interface Root
{
  public abstract String name();

  public abstract boolean strict();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.Root
 * JD-Core Version:    0.6.2
 */