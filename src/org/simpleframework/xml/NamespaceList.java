package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@NamespaceList({}))
@Retention(RetentionPolicy.RUNTIME)
public @interface NamespaceList
{
  public abstract Namespace[] value();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.NamespaceList
 * JD-Core Version:    0.6.2
 */