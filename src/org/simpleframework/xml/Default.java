package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@Default(required=true, value=DefaultType.FIELD))
@Retention(RetentionPolicy.RUNTIME)
public @interface Default
{
  public abstract boolean required();

  public abstract DefaultType value();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.Default
 * JD-Core Version:    0.6.2
 */