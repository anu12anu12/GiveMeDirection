package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@Version(name="", required=false, revision=1.0D))
@Retention(RetentionPolicy.RUNTIME)
public @interface Version
{
  public abstract String name();

  public abstract boolean required();

  public abstract double revision();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.Version
 * JD-Core Version:    0.6.2
 */