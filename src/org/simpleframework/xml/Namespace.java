package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@Namespace(prefix="", reference=""))
@Retention(RetentionPolicy.RUNTIME)
public @interface Namespace
{
  public abstract String prefix();

  public abstract String reference();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.Namespace
 * JD-Core Version:    0.6.2
 */