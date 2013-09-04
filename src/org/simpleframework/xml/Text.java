package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@Text(data=false, empty="", required=true))
@Retention(RetentionPolicy.RUNTIME)
public @interface Text
{
  public abstract boolean data();

  public abstract String empty();

  public abstract boolean required();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.Text
 * JD-Core Version:    0.6.2
 */